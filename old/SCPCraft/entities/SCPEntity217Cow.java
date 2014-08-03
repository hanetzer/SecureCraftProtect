package SCPCraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
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

public class SCPEntity217Cow extends EntityAnimal
{
	private final EntityAIControlledByPlayer field_82184_d;
	
    public SCPEntity217Cow(World par1World)
    {
        super(par1World);
        texture = "/SCPCraft/textures/mobs/SCP217/SCPCow.png";
        setSize(0.9F, 1.3F);
        getNavigator().setAvoidsWater(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, this.field_82184_d = new EntityAIControlledByPlayer(this, 0.7F));
        tasks.addTask(2, new EntityAIMate(this, 0.2F));
        tasks.addTask(3, new EntityAITempt(this, 0.25F, Item.ingotIron.itemID, false));
        tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
        tasks.addTask(5, new EntityAIWander(this, 0.2F));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
        tasks.addTask(7, new EntityAILookIdle(this));
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }
    
    public boolean canBeSteered()
    {
        ItemStack var1 = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return var1 == null || var1 != null;
    }

	protected void updateAITasks()
    {
        super.updateAITasks();
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
    	if(!isAggro)return true;
    	else return false;
    }
    
    public int getMaxHealth()
    {
        return 20;
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
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.cow";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cowhurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cowhurt";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.ingotIron.itemID;
    }
    
    /**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset()
	{
		return (double)height * 1.3499999999999999D - 0.5D;
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

    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.field_82184_d;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1) 
	{
        return new SCPEntity217Cow(worldObj);
	}
}
