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
import net.minecraft.world.World;

public class SCPEntity111 extends EntityAnimal
{
    private final EntityAIControlledByPlayer field_82184_d;

    public SCPEntity111(World par1World)
    {
        super(par1World);
        this.texture = "/SCPCraft/textures/mobs/111.png";
        this.setSize(0.75F, 0.75F);
        this.getNavigator().setAvoidsWater(true);
        float var2 = 0.25F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, this.field_82184_d = new EntityAIControlledByPlayer(this, 0.7F));
        this.tasks.addTask(3, new EntityAIMate(this, var2));
        this.tasks.addTask(4, new EntityAITempt(this, 0.3F, Item.appleRed.itemID, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 0.28F));
        this.tasks.addTask(6, new EntityAIWander(this, var2));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
    	return true;
    }
    
    /**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset()
	{
		return (double)height * 0.7499999999999999D - 0.5D;
	}

    public int getMaxHealth()
    {
        return 40;
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

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
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
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getHurtSound()
    {
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.default";
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
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return 0;
    }

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public SCPEntity111 spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new SCPEntity111(this.worldObj);
    }

    /**
     * Checks if the parameter is an wheat item.
     */
    public boolean isWheat(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.itemID == Item.appleRed.itemID;
    }

    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.field_82184_d;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return this.spawnBabyAnimal(var1);
	}
}
