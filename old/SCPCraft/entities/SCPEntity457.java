package SCPCraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity457 extends SCPEntity
{
	/** ticks until heightOffset is randomized */
	private int heightOffsetUpdateTime;
	private int field_40152_d;
	private boolean Dead;

	public SCPEntity457(World par1World)
	{	
		super(par1World);
		texture = "/SCPCraft/textures/mobs/457.png";
		isImmuneToFire = true;
		attackStrength = 5;
		experienceValue = 0;
		moveSpeed = 0.3F;
		getNavigator().setAvoidsWater(true);
		tasks.addTask(0, new EntityAISCP0173Attack(this, EntityPlayer.class, moveSpeed, false));
        tasks.addTask(1, new EntityAIWander(this, moveSpeed));
        tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16F, 0, true));
		targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	protected boolean isAIEnabled()
	{
		return true;
	}

	public int getMaxHealth()
	{
		return 20;
	}
	
	protected boolean canDespawn()
    {
        return false;
    }

	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(16, new Byte((byte)0));
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "fire.fire";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "fire.ignite";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.blaze.death";
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{

		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if (isWet())
		{
			setDead();
			Dead = true;
		}
		if(Dead == true)
		{
			entityplayer.addStat(mod_SCP.SCP457, 1);
		}
		else
		{
			Dead = false;
		}

	return false;
	}
	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource par1DamageSource, EntityPlayer entityplayer)
	{
		super.onDeath(par1DamageSource);
		worldObj.setBlock(chunkCoordX, chunkCoordY, chunkCoordZ, Block.fire.blockID);
		entityplayer.addStat(mod_SCP.SCP457, 1);
	}

	public int getBrightnessForRender(float par1)
	{
		return 0xf000f0;
	}

	/**
	 * Gets how bright this entity is.
	 */
	public float getBrightness(float par1)
	{
		return 1.0F;
	}


	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		if (!worldObj.isRemote)
		{
			if (isWet())
			{
				setDead();
				Dead = true;
			}
			
			else
			{
				Dead = false;
			}
		}

		for (int j = 0; j < 4; j++)
		{
			int l = MathHelper.floor_double(posX + (double)((float)((j % 2) * 2 - 1) * 0.25F));
			int i1 = MathHelper.floor_double(posY);
			int j1 = MathHelper.floor_double(posZ + (double)((float)(((j / 2) % 2) * 2 - 1) * 0.25F));

			if (worldObj.getBlockId(l, i1, j1) == 0)
			{
				worldObj.setBlock(l, i1, j1, Block.fire.blockID);
			}
		}

		if (health <= 0)
		{
			float f = (rand.nextFloat() - 0.5F) * 8F;
			float f2 = (rand.nextFloat() - 0.5F) * 4F;
			float f4 = (rand.nextFloat() - 0.5F) * 8F;
			worldObj.spawnParticle("flame", posX + (double)f, posY + 2D + (double)f2, posZ + (double)f4, 0.0D, 0.0D, 0.0D);
			return;
		}

		if (rand.nextInt(24) == 0)
		{
			worldObj.playSoundEffect(posX + 0.5D, posY + 0.5D, posZ + 0.5D, "fire.fire", 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F);
		}

		for (int i = 0; i < 2; i++)
		{
			worldObj.spawnParticle("flame", posX + (rand.nextDouble() - 0.5D) * (double)width, posY + rand.nextDouble() * (double)height, posZ + (rand.nextDouble() - 0.5D) * (double)width, 0.0D, 0.0D, 0.0D);
			worldObj.spawnParticle("largesmoke", posX + (rand.nextDouble() - 0.5D) * (double)width, posY + rand.nextDouble() * (double)height, posZ + (rand.nextDouble() - 0.5D) * (double)width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	protected void attackEntity(Entity par1Entity, EntityPlayer entityplayer, float par2)
    {

            super.attackEntity(par1Entity, par2);
            entityplayer.setFire(8);
    }
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float f)
	{
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
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return Block.fire.blockID;
	}

	/**
	 * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
	 */
	public boolean isBurning()
	{
		return true;
	}

	public boolean func_40151_ac()
	{
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void func_40150_a(boolean par1)
	{
		byte byte0 = dataWatcher.getWatchableObjectByte(16);

		if (par1)
		{
			byte0 |= 1;
		}
		else
		{
			byte0 &= 0xfe;
		}

		dataWatcher.updateObject(16, Byte.valueOf(byte0));
	}

	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	protected boolean isValidLightLevel()
	{
		return true;
	}
}
