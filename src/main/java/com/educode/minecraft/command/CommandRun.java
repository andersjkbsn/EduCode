package com.educode.minecraft.command;

import com.educode.errorhandling.ErrorMessage;
import com.educode.events.achievements.AchievementEvent;
import com.educode.minecraft.CompilerMod;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.parsing.ParserHelper;
import com.educode.runtime.ProgramBase;
import com.educode.runtime.ProgramImpl;
import com.educode.runtime.threads.ProgramRunner;
import com.educode.visitors.semantic.SemanticVisitor;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class CommandRun implements ICommand
{
    private final List<String> _aliases;
    
    public CommandRun()
    {
        _aliases = java.util.Arrays.asList("run", "runprogram");;
    }
    
    @Override
    public int compareTo(ICommand arg0)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName()
    {
        return "run";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/run <name> [count]";
    }

    @Override
    public List<String> getAliases()
    {
        return _aliases;
    }

    private void printMessagesToChat(ICommandSender sender, List<ErrorMessage> errorMessages)
    {
        for (ErrorMessage message : errorMessages)
        {
            if (message.getType() == ErrorMessage.MessageType.ERROR)
                sender.sendMessage(new TextComponentString(TextFormatting.RED + "[Error]" + TextFormatting.RESET + " " + message.toString()));
            else if (message.getType() == ErrorMessage.MessageType.WARNING)
                sender.sendMessage(new TextComponentString(TextFormatting.YELLOW + "[Warning]" + TextFormatting.RESET + " " + message.toString()));
        }
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length < 1) return;
        final String programName = args[0];

        try
        {
            // Parse source program
            StartNode startNode =  ParserHelper.parse( programName + ".educ");
            
            // Perform semantic checks
            SemanticVisitor semanticVisitor = new SemanticVisitor();
            semanticVisitor.getSymbolTableHandler().setInputSource(startNode);
            startNode.setInputSource(programName + ".educ");
            startNode.setIsMain(true);
            startNode.accept(semanticVisitor);
            printMessagesToChat(sender, semanticVisitor.getSymbolTableHandler().getMessages());
            if (semanticVisitor.getSymbolTableHandler().hasErrors())
                throw new Exception("Could not compile source program due to contextual constraint errors.");

            /* Optimise code
            startNode.accept(new OptimisationVisitor());

            // Generate Java code
            JavaCodeGenerationVisitor javaVisitor = new JavaCodeGenerationVisitor();
            startNode.accept(javaVisitor);

            // Compile and main Java
            Class<?> compiledClass = new CustomJavaCompiler().compile(programName);*/

            int instances = 1;
            if (args.length > 1)
                instances = Integer.parseInt(args[1]);

            // Run designated amount of instances
            for (int i = 0; i < instances; i++)
            {
                //ProgramBase program = (ProgramBase) compiledClass.newInstance();
                ProgramBase program = new ProgramImpl();
                ProgramRunner programThread = new ProgramRunner(program, startNode);
                program.init(programName, programThread, server.getEntityWorld(), (EntityPlayer) sender, semanticVisitor.getEventDefinitions());

                // Run program in separate thread
                programThread.start();

                // Add to running programs
                synchronized (CompilerMod.RUNNING_PROGRAMS)
                {
                    CompilerMod.RUNNING_PROGRAMS.add(program);
                }
            }

            //Give first run achievement
            MinecraftForge.EVENT_BUS.post(new AchievementEvent.ProgramRunEvent((EntityPlayer) sender));
        }
        catch (Exception e)
        {
            // Give compiler error achievement
            MinecraftForge.EVENT_BUS.post(new AchievementEvent.CompilerErrorEvent((EntityPlayer) sender));

            sender.sendMessage(new TextComponentString(TextFormatting.RED + "[Error]" + TextFormatting.RESET + " " + e.getMessage()));

            e.printStackTrace();
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
    {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index)
    {
        return false;
    }

}
