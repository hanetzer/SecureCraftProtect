package SCPCraft.entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;
import SCPCraft.mod_SCP;

public class SCPEntityRat extends SCPEntity
{
	private int angerLevel = 0;
	Minecraft minecraft = ModLoader.getMinecraftInstance();
    private static final IEntitySelector field_82219_bJ = new SCPFilterRatAttack();
	
	public SCPEntityRat(World par1World)
	{
		super(par1World);
		texture = "/SCPCraft/textures/mobs/Rat.png";
		moveSpeed = 0.35F;
		attackStrength = 2;
        this.renderDistanceWeight = 10.0D;
		this.setSize(0.1F, 0.1F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new SCPEntityAggressiveAI(this, SCPEntityClassD027.class, this.moveSpeed, true));
		this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, SCPEntityClassD027.class, 16.0F, 0, false));
	}

    public boolean attackEntityAsMob(Entity par1Entity)
    {
    	return false;
    }

	public int getMaxHealth()
	{
		return 10;
	}
    
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
        if(!par1EntityPlayer.isVermin)par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), attackStrength);
        else;
    }
    
    public void targetLivings()
    {
    	List var5 = this.worldObj.selectEntitiesWithinAABB(EntityLiving.class, this.boundingBox.expand((double)16F, 4.0D, (double)16F), field_82219_bJ);
        Iterator var2 = var5.iterator();

        while (var2.hasNext())
        {
            Entity var3 = (Entity)var2.next();
            EntityLiving var4 = (EntityLiving)var3;

            if (var4 != null && var4.isPotionActive(SCPPotion.verminGod))
            {
                entityToAttack = var4;
            }
        }
    }

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return false;
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("isVermin", isVermin);
		par1NBTTagCompound.setShort("Anger", (short)this.angerLevel);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.isVermin = par1NBTTagCompound.getBoolean("isVermin");
		this.angerLevel = par1NBTTagCompound.getShort("Anger");
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
	 * (Animals, Spiders at day, peaceful PigZombies).
	 */
	protected Entity findPlayerToAttack()
	{
		EntityPlayer ep = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if(ep != null)
		{
			if(ep.getActivePotionEffect(SCPPotion.verminGod) != null)
			{
				this.angerLevel = 0;
				this.isVermin = true;
				return super.findPlayerToAttack();
			}
		}

		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	private Entity closestLivingEntity;
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		List var1 = this.worldObj.getEntitiesWithinAABB(SCPEntity997.class, this.boundingBox.expand(16D, 5.0D, 16D));
		if (var1.isEmpty())
        {
            return;
        }
        this.closestLivingEntity = (Entity)var1.get(0);
		if(closestLivingEntity != null)this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20, 1));
		isJumping = false;
	}

	protected void attackEntity(Entity par1Entity, float par2)
	{
		if (par2 > 2.0F && par2 < 6F && rand.nextInt(10) == 0)
		{
			if (onGround)
			{
				double d = par1Entity.posX - posX;
				double d1 = par1Entity.posZ - posZ;
				float f1 = MathHelper.sqrt_double(d * d + d1 * d1);
				motionX = (d / (double)f1) * 0.5D * 0.80000001192092896D + motionX * 0.20000000298023224D;
				motionZ = (d1 / (double)f1) * 0.5D * 0.80000001192092896D + motionZ * 0.20000000298023224D;
				motionY = 0.40000000596046448D;
			}
		}
		else
		{
			super.attackEntity(par1Entity, par2);
		}
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.silverfish.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.silverfish.hit";
	}

	protected boolean canTriggerWalking()
	{
		return false;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.silverfish.kill";
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		Entity var3 = par1DamageSource.getEntity();

		if (var3 instanceof EntityPlayer)
		{
			List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
			Iterator var5 = var4.iterator();

			while (var5.hasNext())
			{
				Entity var6 = (Entity)var5.next();

				if (var6 instanceof SCPEntityRat)
				{
					SCPEntityRat var7 = (SCPEntityRat)var6;
					var7.becomeAngryAt(var3);
				}
			}

			this.becomeAngryAt(var3);
		}

		return super.attackEntityFrom(par1DamageSource, par2);
	}

	private void becomeAngryAt(Entity par1Entity)
	{
		this.entityToAttack = par1Entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
	}
}
