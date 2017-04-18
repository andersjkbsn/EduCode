package com.educode.minecraft.gui;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.networking.MessageSaveFile;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.xml.soap.Text;
import java.io.IOException;

import static org.lwjgl.input.Keyboard.*;


@SideOnly(Side.CLIENT)
public class GuiProgramEditor extends GuiScreen
{
    private static final ResourceLocation BOOK_GUI_TEXTURES = new ResourceLocation("textures/gui/book.png");

    private static String _text = "";
    private static String _formattedText = "";
    private static String _fileName;
    private static int _position = 0;
    private static int _lineNumber = 0;
    private static final char _cursorSymbol = '|';

    public GuiProgramEditor()
    {
        super();
    }

    public static void setFileName(String name)
    {
        _fileName = name;
    }

    public static void setText(String text)
    {
        _text = text.replace("\r", "");
        String newFormattedText = new StringBuffer(_text).insert(_position, _cursorSymbol).toString();

        // Perform syntax highlighting using regex
        newFormattedText = newFormattedText.replaceAll("(begin|end|program|if|then|else|while|repeat|method|return(s)?)", TextFormatting.BLUE + "$1" + TextFormatting.WHITE);
        newFormattedText = newFormattedText.replaceAll("(not|equals|less than|greater than|or|and)", TextFormatting.YELLOW + "$1" + TextFormatting.WHITE);
        newFormattedText = newFormattedText.replaceAll("(number|Coordinates|string|bool|Collection<(.*?)>)", TextFormatting.LIGHT_PURPLE + "$1" + TextFormatting.WHITE);
        newFormattedText = newFormattedText.replaceAll("\"(.*?)\"", TextFormatting.RED + "\"$1\"" + TextFormatting.WHITE); // Strings
        newFormattedText = newFormattedText.replaceAll("(true|false)", TextFormatting.RED + "$1" + TextFormatting.WHITE); // Other literals
        newFormattedText = newFormattedText.replaceAll("(//.*)", TextFormatting.GREEN + "$1" + TextFormatting.WHITE); // Comments

        _formattedText = TextFormatting.WHITE + newFormattedText;
    }

    private static void insert(String content)
    {
        int oldPosition = _position;
        _position += content.length();
        setText(new StringBuffer(_text).insert(oldPosition, content).toString());
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();

        // Draw position string
        this.fontRendererObj.drawString(TextFormatting.WHITE + "Position: " + _position, this.width - 100, 10, 0);

        // Draw line number
        this.fontRendererObj.drawString(TextFormatting.WHITE + "Line Num: " + _lineNumber, this.width - 100, 25, 0);

        // Draw code
        this.fontRendererObj.drawSplitString( _formattedText, 10, 10, 400, 0);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {
        updateScreen();
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    private void setPositionSafe(int newPosition)
    {
        if (newPosition < 0)
            newPosition = 0;
        else if (newPosition > _text.length() - 1)
            newPosition = _text.length() - 1;

        _position = newPosition;
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (keyCode == KEY_ESCAPE) // Close the GUI
            this.mc.displayGuiScreen(null); // Displaying null hides the GUI screen
        else if (keyCode == KEY_RETURN) // Newline
            insert("\n");
        else if (keyCode == KEY_TAB) // Tab (creates two spaces)
            insert("  ");
        else if (keyCode == KEY_LEFT && _position > 0) // Change position to left
        {
            _position--;
            setText(_text);
        }
        else if (keyCode == KEY_RIGHT && _position < _text.length() - 1)
        {
            _position++;
            setText(_text);
        }
        else if (keyCode == KEY_DELETE && !_text.isEmpty() && _position < _text.length() - 1)
            setText(new StringBuffer(_text).deleteCharAt(_position + 1).toString());
        else if (keyCode == KEY_BACK && !_text.isEmpty() && _position > 0)
        {
            _position--;
            setText(new StringBuffer(_text).deleteCharAt(_position).toString());
        }
        else if (keyCode ==  KEY_DOWN)
        {
            String textAfter = _text.substring(_position);
            int newLinePosition = textAfter.indexOf("\n");
            if (newLinePosition != -1)
            {
                setPositionSafe(_position + newLinePosition + 1);
                setText(_text);
            }
        }
        else if (keyCode == KEY_UP)
        {
            String textBefore = _text.substring(0, _position);
            setPositionSafe(textBefore.lastIndexOf("\n") - 1);
            setText(_text);
        }
        else if (isKeyDown(KEY_LCONTROL))
        {
            if (keyCode == KEY_S) // Save file
                CompilerMod.NETWORK_INSTANCE.sendToServer(new MessageSaveFile(_fileName, _text));
        }
        else if (ChatAllowedCharacters.isAllowedCharacter(typedChar))
            insert(String.valueOf(typedChar));
        else
            System.out.println("Key code:" + keyCode);
    }

    public static void resetPosition()
    {
        _position = 0;
    }
}