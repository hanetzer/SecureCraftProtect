package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.renders.SCPRender058;

public class SCPEntity058 extends SCPEntity
{
	private boolean hasSaid;
	private boolean isSaying;
	private boolean Said;
	public boolean isAttacking;
	
	public static int beat; 

	public SCPEntity058(World par1World)
	{
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/058.png";
		this.setSize(0.8F, 0.9F);
		this.moveSpeed = 1.0F;
		this.beat = 25;
		hasSaid = false;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	public SCPRender058 render;

	public void onLivingUpdate()
	{	
		if(this.beat > 0)
		{
			this.beat--;
			
			if(this.beat <= 10 && this.beat > 9)
			{
				this.worldObj.playSoundAtEntity(this, "sounds.heartbeat", 1.0F, 1.0F);
			}
		}
		
		if(this.beat <= 0)
		{
			this.beat = 55;
		}
		
		int i = MathHelper.floor_double(posX);
		int k = MathHelper.floor_double(posY);
		int i1 = MathHelper.floor_double(posZ);
		isAttacking = entityToAttack != null;

		if (!worldObj.isRemote)
		{
		}

		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

		if(entityplayer != null && entityplayer.isDead == true && Said == false)
		{
			if(!worldObj.isRemote)
			{
				hasSaid = true;
			}
			if(hasSaid == true && isSaying == false && Said == false)
			{
				this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D).addChatMessage("\u00a7lSCP-058: \u00a7rThe sensual violence of lust is all the assurance you will ever need to know the worth of life.");
				hasSaid = false;
				isSaying = true;
				Said = true;
			}
		}



		super.onLivingUpdate();
	}

	public void onKillEntity(EntityLiving par1EntityLiving) {}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();

		if (!this.worldObj.isRemote)
		{
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}

	public int getMaxHealth()
	{
		return 100;
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset()
	{
		return (double)this.height * 0.75D - 0.5D;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return false;
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
	 * (Animals, Spiders at day, peaceful PigZombies).
	 */
	protected Entity findPlayerToAttack()
	{
		float var1 = this.getBrightness(1.0F);

		if (var1 < 0.5F)
		{
			double var2 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
		}
		else
		{
			double var2 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
		}
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.spider";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.spider";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.spiderdeath";
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	protected void attackEntity(Entity par1Entity, float par2)
	{
		float var3 = this.getBrightness(1.0F);

		if (var3 > 0.5F && this.rand.nextInt(100) == 0)
		{
			this.entityToAttack = null;
		}
		else
		{
			if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0)
			{
				if (this.onGround)
				{
					double var4 = par1Entity.posX - this.posX;
					double var6 = par1Entity.posZ - this.posZ;
					float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
					this.motionX = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
					this.motionZ = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
					this.motionY = 0.4000000059604645D;
				}
			}
			else
			{
				super.attackEntity(par1Entity, par2);
			}
		}
	}

	/**
	 * returns true if this entity is by a ladder, false otherwise
	 */
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}

	/**
	 * Sets the Entity inside a web block.
	 */
	public void setInWeb() {}

	/**
	 * How large the spider should be scaled.
	 */
	public float spiderScaleAmount()
	{
		return 0.9F;
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	/**
	 * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
	 * setBesideClimableBlock.
	 */
	public boolean isBesideClimbableBlock()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean par1)
	{
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1)
		{
			var2 = (byte)(var2 | 1);
		}
		else
		{
			var2 &= -2;
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(var2));
	}
}
