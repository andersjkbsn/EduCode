package com.educode.runtime;

import com.educode.minecraft.Command;
import com.educode.minecraft.entity.EntityRobot;

import com.educode.nodes.ungrouped.EventDefinitionNode;
import com.educode.events.Broadcaster;
import com.educode.runtime.types.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.Path;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ScriptBase implements IRobot
{
    // Queue of commands to be executed
    private final Queue<Command> _commandQueue = new ConcurrentLinkedQueue<>();

    // General
    private final Random _rand = new Random();
    private List<EventDefinitionNode> _eventDefinitions;

    // Minecraft related
    private World _world;
    private EntityRobot _robot;
    private EntityPlayer _player;

    // Used by implemented scripts
    protected final ScriptBase robot = this;

    // Threading
    private Thread _mainThread;

    public void init(Thread mainThread, World world, EntityPlayer player, List<EventDefinitionNode> eventDefinitions)
    {
        this._world = world;
        this._player = player;
        this._eventDefinitions = eventDefinitions;
        this._mainThread = mainThread;

        _robot = new EntityRobot(this, _world, player);
        BlockPos spawnPosition = this._player.getPosition();
        do
        {
        	this._robot.setPosition(spawnPosition.getX() + world.rand.nextInt(3), spawnPosition.getY(), spawnPosition.getZ() + world.rand.nextInt(3));
        	
            switch (_world.rand.nextInt() % 4)
            {
                case 0:
                    spawnPosition = spawnPosition.west();
                    break;
                case 1:
                    spawnPosition = spawnPosition.east();
                    break;
                case 2:
                    spawnPosition = spawnPosition.north();
                    break;
                case 3:
                    spawnPosition = spawnPosition.south();
                    break;
            }
        } while (!this._robot.getCanSpawnHere() && _robot.getPosition().equals(_player.getPosition()));
        this._world.spawnEntity(_robot);
    }

    public Thread getMainThread()
    {
        return this._mainThread;
    }

    public Command pollCommand()
    {
        return _commandQueue.poll();
    }

    public List<EventDefinitionNode> getEventDefinitions()
    {
        return this._eventDefinitions;
    }

    public ExtendedCollection<Float> range(float min, float max)
    {
        ExtendedCollection<Float> ret = new ExtendedCollection<Float>();

        for (float c = min; c <= max; c++)
            ret.addItem(c);

        return ret;
    }

    public float abs(float value)
    {
        return Math.abs(value);
    }

    public float random(float min, float max)
    {
        return (max - min) * _rand.nextFloat() + min;
    }

    @Override
    public boolean isRobot()
    {
        return true;
    }

    @Override
    public boolean isPlayer()
    {
        return false;
    }

    public void wait(float time) throws InterruptedException
    {
        Thread.sleep((long) time);
    }

    @Override
    public void setWorldTime(float time)
    {
        executeOnTick(() -> _world.setWorldTime((long) time % 24000));
    }

    public void say(String message)
    {
        executeOnTick(() ->
        {
            MinecraftServer server = _world.getMinecraftServer();
            if (server == null)
                return; // Should never happen since this method is never executed client-side

            // Using an iterator should not be necessary in this iteration because it is executed on tick
            for (EntityPlayer player : server.getPlayerList().getPlayers())
                _robot.sendMessageTo(player, message);
        });
    }

    public void explode(float strength)
    {
        boolean mobGriefingEnabled = this._world.getGameRules().getBoolean("mobGriefing");
        executeOnTick(() -> _world.createExplosion(this._robot, getX(), getY(), getZ(), strength, mobGriefingEnabled));
    }

    public void removeEntity()
    {
        executeOnTick(() -> _world.removeEntity(_robot));
    }

    public void dropItems()
    {
        executeOnTick(() -> _robot.dropItems());
    }

    @Override
    public float getX()
    {
        return (float) _robot.posX;
    }

    @Override
    public float getY()
    {
        return (float) _robot.posY;
    }

    @Override
    public float getZ()
    {
        return (float) _robot.posZ;
    }

    @Override
    public Coordinates getCoordinates()
    {
        return new Coordinates(_robot.getPosition());
    }

    //TODO: should maybe be in interface as well?, Andreas
    @Override
    public boolean placeBlock(Coordinates coordinates) throws InterruptedException
    {
        if (this._robot.getPosition().getDistance((int)coordinates.getX(), (int)coordinates.getY(), (int)coordinates.getZ()) > 3.0)
            return false;

        boolean result = (boolean) executeOnTick(() ->
        {
            ItemStack heldStack = getHeldItem().getWrappedItem();
            if (heldStack.getItem() instanceof ItemBlock)
            {
                ItemBlock itemBlock = (ItemBlock) heldStack.getItem();
                Block block = Block.getBlockFromItem(heldStack.getItem());

                itemBlock.placeBlockAt(heldStack, _player, _world, coordinates.toBlockPos(), EnumFacing.DOWN, 0F, 0F, 0F, block.getDefaultState());
            }
            else
                return false;

            return false;
        });

        if (result)
            wait(500.0F);

        return result;
    }

    @Override
    public void broadcast(float channel, String message)
    {
        Broadcaster.broadcastMessage(this._robot, channel, message);
    }

    @Override
    public void broadcast(float channel, MinecraftEntity entity)
    {
        Broadcaster.broadcastMessage(this._robot, channel, entity);
    }

    @Override
    public void stop()
    {
        executeOnTick(() -> getRobot().setDead());
    }

    @Override
    public boolean attack(MinecraftEntity entity) throws InterruptedException
    {
        if (this._robot.isDead || this.getDistanceTo(entity) > 3.0F)
            return false;

        executeOnTick(() -> _robot.attackEntity(entity.getWrappedEntity()));
        wait(500F);

        return true;
    }

    private Object executeOnTick(IExecutableReturns executable)
    {
        Command command = new Command(executable);
        _commandQueue.add(command);

        return command.getResult();
    }

    private void executeOnTick(IExecutable executable)
    {
        executeOnTick(() ->
        {
            executable.execute();
            return null;
        });
    }

    @Override
    public float dropItem(String name, final float quantity)
    {
        return (float) executeOnTick(() -> _robot.dropInventoryItem(name, quantity));
    }

    @Override
    public ExtendedCollection<MinecraftItem> getInventory()
    {
        ExtendedCollection<MinecraftItem> collection = new ExtendedCollection<>();

        // Add non-air blocks
        for (int i = 0; i < this._robot.getInventory().getSizeInventory(); i++)
        {
            ItemStack current = this._robot.getInventory().getStackInSlot(i);
            if (current.isEmpty())
                continue;
            collection.add(new MinecraftItem(current));
        }

        return collection;
    }

    @Override
    public MinecraftItem getHeldItem()
    {
        return new MinecraftItem(this._robot.getHeldItem(EnumHand.MAIN_HAND));
    }

    @Override
    public void setHeldItem(MinecraftItem item)
    {
        executeOnTick(() -> this._robot.setHeldItem(EnumHand.MAIN_HAND, item.getWrappedItem()));
    }

    @Override
    public MinecraftItem getItemFromSlot(float index)
    {
        int intIndex = (int) index;
        if (intIndex >= this._robot.getInventory().getSizeInventory())
            return new MinecraftItem();
        return new MinecraftItem(this._robot.getInventory().getStackInSlot(intIndex));
    }

    @Override
    public float getDistanceTo(MinecraftEntity entity)
    {
    	return _robot.getDistanceToEntity(entity.getWrappedEntity());
    }

    @Override
    public boolean walkTo(Coordinates coords) throws InterruptedException
    {
        return navigateToBlock(coords.toBlockPos());
    }

    private boolean navigateToBlock(BlockPos pos) throws InterruptedException
    {
        boolean result = (boolean) executeOnTick(() ->
        {
            _robot.getNavigator().clearPathEntity();
            Path path = _robot.getNavigator().getPathToPos(pos);
            if (path == null)
                return false;
            return _robot.getNavigator().setPath(_robot.getNavigator().getPathToPos(pos), 0.5D);
        });

        wait(500F);
        return result;
    }


    @Override
    public ExtendedCollection<MinecraftEntity> getNearbyEntities()
    {
        return (ExtendedCollection<MinecraftEntity>) executeOnTick(() ->
        {
            ExtendedCollection<MinecraftEntity> returnList = new ExtendedCollection<>();
            for (Entity entity : this._world.getEntitiesWithinAABB(EntityLivingBase.class, this._robot.getEntityBoundingBox().expand(30, 5, 30)))
            {
                if (entity.equals(this._robot) || entity.equals(this._player))
                    continue;

                returnList.addItem(new MinecraftEntity(entity));
            }

            return returnList;
        });
    }

    @Override
    public MinecraftEntity getOwner()
    {
        return new MinecraftEntity(this._player);
    }

    @Override
    public void move(String direction) throws InterruptedException
    {
        BlockPos targetPosition = _robot.getPosition();
        switch (direction.toLowerCase())
        {
            case "north":
                targetPosition = targetPosition.north();
                break;
            case "south":
                targetPosition = targetPosition.south();
                break;
            case "east":
                targetPosition = targetPosition.east();
                break;
            case "west":
                targetPosition = targetPosition.west();
                break;
            default:
                say(String.format("Unknown direction '%s'!", direction));
                return;
        }
        
        navigateToBlock(targetPosition);
    }

    @Override
    public String toString()
    {
        return this._robot.getName();
    }

    @Override
    public float getHealth()
    {
        return this._robot.getHealth();
    }

    @Override
    public void mine(String direction) throws InterruptedException
    {
    	mine(direction, 0);
    }
    
    private void mine(String direction, int yModifier) throws InterruptedException
    {
        BlockPos targetBlockPosition = _robot.getPosition();
        if (yModifier != 0)
        	targetBlockPosition = targetBlockPosition.add(0, yModifier, 0);
        
        switch (direction)
        {
            case "down":
                targetBlockPosition = targetBlockPosition.down();
                break;
            case "up":
                targetBlockPosition = targetBlockPosition.up(2);
                break;
            case "north":
                faceAndMine((targetBlockPosition = targetBlockPosition.north()));
                break;
            case "south":
                faceAndMine((targetBlockPosition = targetBlockPosition.south()));
                break;
            case "east":
                faceAndMine((targetBlockPosition = targetBlockPosition.east()));
                break;
            case "west":
                faceAndMine((targetBlockPosition = targetBlockPosition.west()));
                break;
            default:
                say(String.format("Unknown direction '%s'!", direction));
                return;
        }
        
        if (!direction.equals("up") && !direction.equals("down"))
            targetBlockPosition = targetBlockPosition.up();
        
        faceAndMine(targetBlockPosition);
    }
    
    private void faceAndMine(BlockPos position) throws InterruptedException
    {
        if (_world.isAirBlock(position))
            return;
        
        // face(position);
        mineBlock(position);
    }

    private void mineBlock(BlockPos position) throws InterruptedException
    {
        boolean blockDestroyed = (boolean) executeOnTick(() ->
        {
            if (_world.getBlockState(position).getBlock() == Blocks.BEDROCK)
                return false;

            return _world.destroyBlock(position, true);
        });

        if (blockDestroyed)
            wait(500F);
    }

    public void mineBlock(Coordinates position) throws InterruptedException
    {
        if(this.getCoordinates().toBlockPos().getDistance((int)position.getX(), (int)position.getY(), (int)position.getZ()) > 3.0F)
        {
            mineBlock(position.toBlockPos());
        }
    }
    
    public abstract void main() throws InterruptedException;

    public EntityRobot getRobot()
    {
        return this._robot;
    }
}
