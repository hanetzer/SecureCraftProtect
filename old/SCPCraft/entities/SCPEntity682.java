package SCPCraft.entities;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class SCPEntity682 extends EntityAnimal
{
	private final EntityAIControlledByPlayer field_82184_d;

	public SCPEntity682(World world)
	{
		super(world);
		texture = "/SCPCraft/textures/mobs/Bosses/682/682.png";
		moveSpeed = 0.6F;
		setSize(0.9F, 0.9F);
		stepHeight = 1.0F;
		getNavigator().setAvoidsWater(true);
		float f = 0.25F;
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIWander(this, f));
		this.tasks.addTask(2, this.field_82184_d = new EntityAIControlledByPlayer(this, 0.7F));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
		tasks.addTask(4, new EntityAIWatchClosest(this, EntityLiving.class, 18F));
		tasks.addTask(5, new EntityAIWatchClosest(this, SCPEntityClassDGuy.class, 18F));
		tasks.addTask(6, new EntityAILookIdle(this));
		tasks.addTask(7, new EntityAIPanic(this, 0.38F));
		this.tasks.addTask(8, new EntityAITempt(this, 0.3F, Item.ingotIron.itemID, false));
        this.tasks.addTask(8, new EntityAITempt(this, 0.3F, Item.ingotIron.itemID, false));
	}
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

	public boolean isAIEnabled()
	{
		if(!isAggro)return true;
		else return false;
	}

	protected boolean canDespawn()
	{
		return false;
	}
	
	Random rand = new Random();

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2, EntityPlayer entityplayer)
	{
		if(riddenByEntity != null || riddenByEntity == entityplayer)
		{
			return false;
		}

		else
		{
			return super.attackEntityFrom(par1DamageSource, par2);	
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();

		if (!worldObj.isRemote)
		{
			func_40148_a(isCollidedHorizontally);
		}
	}

	public int getMaxHealth()
	{
		return 9001;
	}
	
	protected void updateAITasks()
    {
        super.updateAITasks();
    }

    public boolean canBeSteered()
    {
        ItemStack var1 = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return var1 == null || var1 != null;
    }

	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset()
	{
		return (double)height * 1.6499999999999999D - 0.5D;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return true;
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (super.interact(par1EntityPlayer))
        {
            return true;
        }
        else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
        {
            par1EntityPlayer.mountEntity(this);
            return true;
        }
        else
        {
            return false;
        }
    }


	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);
	}

	public void func_48150_h(boolean flag)
	{
		isJumping = flag;
	}
	
	public EntityAIControlledByPlayer func_82183_n()
    {
        return this.field_82184_d;
    }

	public boolean func_40149_l_()
	{
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void func_40148_a(boolean flag)
	{
		byte byte0 = dataWatcher.getWatchableObjectByte(16);

		if (flag)
		{
			byte0 |= 1;
		}
		else
		{
			byte0 &= 0xfe;
		}

		dataWatcher.updateObject(16, Byte.valueOf(byte0));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return new SCPEntity682(worldObj);
	}
}
