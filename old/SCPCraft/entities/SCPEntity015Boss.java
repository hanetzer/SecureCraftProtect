package SCPCraft.entities;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity015Boss extends SCPEntity
{
	/** Random offset used in floating behaviour */
	private float heightOffset = 0.5F;
	protected int maxHealth = 60;

	public static boolean isHalfWay;

	private static String Phase1 = "/SCPCraft/textures/mobs/Bosses/015/015BossPhase1.png";
	private static String Phase2 = "/SCPCraft/textures/mobs/Bosses/015/015BossPhaseDead.png";

	/** ticks until heightOffset is randomized */
	private int heightOffsetUpdateTime;
	private int field_70846_g;
	public int deathTicks = 0;

	public SCPEntity015Boss(World par1World)
	{
		super(par1World);
		this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		this.texture = "/SCPCraft/textures/mobs/Bosses/015/015BossPhase1.png";
		this.isImmuneToFire = true;
		this.maxHealth = 1200;
		this.setEntityHealth(this.maxHealth);
		this.attackStrength = 6;
		this.experienceValue = 15;
		this.yOffset *= 6.0F;
		this.setSize(this.width * 1.0F, this.height * 1.6F);
	}

	public int getMaxHealth()
	{
		return this.maxHealth;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(0));
		this.dataWatcher.addObject(17, new Integer(this.maxHealth));
	}

	public String getTexture()
	{		

		//120
		if(this.health >= 600) return Phase1;
		if(isHalfWay)
		{
			return Phase2;
		}
		if(this.health < 8)
		{
			return Phase2;
		}
		else
		{
			return Phase1;
		}

	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.blaze.breathe";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.blaze.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.blaze.death";
	}

	public int getBrightnessForRender(float par1)
	{
		return 15728880;
	}

	/**
	 * Gets how bright this entity is.
	 */
	public float getBrightness(float par1)
	{
		return 0.4F;
	}
    
    public void targetLivings()
    {
    }
	
	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		if(this.health <= 600 && this.health > 300) isHalfWay = true;

		if(isHalfWay)
		{
			for(int var10 = 0; var10 <= 7; var10++)
			{
				this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		}

		if (!this.worldObj.isRemote)
		{
			this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
		}
		float var1;
		float var3;
		float var26;

		if (this.health <= 0)
		{

			for(int times = 0; times <= 3; times++)
			{
				this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.blaze.breathe", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
				this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "random.click", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
			}
			var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			var26 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("largeexplode", this.posX + (double)var1, this.posY + 2.0D + (double)var26, this.posZ + (double)var3, 0.0D, 0.0D, 0.0D);
		}

		this.isJumping = false;
		if (!this.worldObj.isRemote)
		{

			--this.heightOffsetUpdateTime;

			if (this.heightOffsetUpdateTime <= 0)
			{
				this.heightOffsetUpdateTime = 100;
				this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
			}

			if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
			{
				this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
			}
		}

		if (this.rand.nextInt(24) == 0 && this.health > 0)
		{
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "random.break", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
		}

		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}

		if(this.health < 1200)
		{
			for(int var10 = 0; var10 <= 7; var10++)
			{
				this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 1, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		}

		for (int var2 = 0; var2 < 2; ++var2)
		{
			Random rand = new Random();
			int particle = rand.nextInt(5);

			if(particle == 0)
			{
				this.worldObj.spawnParticle("townaura", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
			if(particle == 1)
			{
				this.worldObj.spawnParticle("splash", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
			if(particle == 2)
			{
				this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
			if(particle == 3)
			{
				this.worldObj.spawnParticle("suspended", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
			if(particle == 4)
			{ 
				this.worldObj.spawnParticle("depthsuspend", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
				this.worldObj.spawnParticle("depthsuspend", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
				this.worldObj.spawnParticle("depthsuspend", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		}

		super.onLivingUpdate();
	}

	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	protected void onDeathUpdate()
	{
		++this.deathTicks;

		if (this.deathTicks >= 180 && this.deathTicks <= 200)
		{
			float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;

			this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)var1, this.posY + 2.0D + (double)var2, this.posZ + (double)var3, 0.0D, 0.0D, 0.0D);
		}

		int var4;
		int var5;

		if (!this.worldObj.isRemote)
		{
			if(this.deathTicks > 150 && this.deathTicks % 5 == 0)
			{
				var4 = 500;

				while (var4 > 0)
				{
					var5 = EntityXPOrb.getXPSplit(var4);
					var4 -= var5;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
				}
			}

            if (this.deathTicks == 1)
            {
                this.worldObj.func_82739_e(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote)
		{
			var4 = 500;

			while (var4 > 0)
			{
				var5 = EntityXPOrb.getXPSplit(var4);
				var4 -= var5;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
			}
			this.setDead();
		}
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	protected void attackEntity(Entity par1Entity, float par2)
	{
		if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(par1Entity);
		}
		else if (par2 < 30.0F)
		{
			double var3 = par1Entity.posX - this.posX;
			double var5 = par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
			double var7 = par1Entity.posZ - this.posZ;

			if (this.attackTime == 0)
			{
				++this.field_70846_g;

				if (this.field_70846_g == 1)
				{
					this.attackTime = 60;
				}
				else if (this.field_70846_g <= 4)
				{
					this.attackTime = 6;
				}
				else
				{
					this.attackTime = 100;
					this.field_70846_g = 0;
				}

				if (this.field_70846_g > 1)
				{
					float var9 = MathHelper.sqrt_float(par2) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

					for (int var10 = 0; var10 < 1; ++var10)
					{
						SCPEntity015Projectile var11 = new SCPEntity015Projectile(this.worldObj, this, var3 + this.rand.nextGaussian() * (double)var9, var5, var7 + this.rand.nextGaussian() * (double)var9);
						var11.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
						this.worldObj.spawnEntityInWorld(var11);
					}
				}
			}

			this.rotationYaw = (float)(Math.atan2(var7, var3) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float par1) {}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return mod_SCP.SCP015.blockID;
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(2 + par2);

		for (int var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(mod_SCP.SCP015.blockID, 1);
		}
							
		int j = rand.nextInt(2);
		if(j == 0) this.dropItem(mod_SCP.Record106.itemID, 1);
		if(j == 1) this.dropItem(mod_SCP.Record173.itemID, 1);
	}

	public boolean func_70845_n()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	protected boolean isValidLightLevel()
	{
		return true;
	}

	/**
	 * Returns the health points of the dragon.
	 */
	public int getSCP015BossHealth()
	{
		return this.dataWatcher.getWatchableObjectInt(16);
	}
}
