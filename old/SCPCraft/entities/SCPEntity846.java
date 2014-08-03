package SCPCraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SCPEntity846 extends EntityTameable
{
	public SCPEntity846(World par1World)
	{
		super(par1World);
		setSize(1.0F, 1.8F);
		texture = "/SCPCraft/textures/mobs/846.png";
		getNavigator().setAvoidsWater(true);
		moveSpeed = 0.3F;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAISCP0173Attack(this, this.moveSpeed, true));
	//	this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(18, Byte.valueOf((byte)0));
	}

	public void onUpdate()
	{
		super.onUpdate();
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	protected void updateAITick()
	{
		this.dataWatcher.updateObject(18, Integer.valueOf(this.getHealth()));
	}

	protected void fall(float f)
	{
	}

	public int getMaxHealth()
	{
		return 40;
	}
	
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
	}

	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
	}

	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		return super.interact(par1EntityPlayer);
	}

	public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
	{
		return new SCPEntity846(worldObj);
	}

	public int func_48148_ad()
	{
		return dataWatcher.getWatchableObjectByte(18);
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.irongolem.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.irongolem.hit";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return new SCPEntity846(worldObj);
	}
}