package SCPCraft.entities;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity076 extends SCPEntity
{
	public int Swordtick;
	public static boolean Death;
	public static boolean CainWin;
	
	Random rand = new Random();
	public SCPEntity076(World par1World)
	{
		//Able
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/076.png";
		this.moveSpeed = 0.35F;
		SCPEntity076.CainWin = false;
		this.health = 150;
		this.Swordtick = rand.nextInt(200);
		this.attackStrength = 6;
		SCPEntity076.Death = false;
		this.isImmuneToFire = true;
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAISCP0173Attack(this, SCPEntity073.class, this.moveSpeed, true));
		this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityPlayer.class, this.moveSpeed, true));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		this.tasks.addTask(3, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.3F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, SCPEntity073.class, 16.0F, 0, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, false));
	}
	
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		EntityPlayer ep = ModLoader.getMinecraftInstance().thePlayer;
		
		if(par1DamageSource.getEntity() instanceof SCPEntity073)
		{
			this.health--;
			if(this.health <= 1 && par1DamageSource.getEntity() instanceof SCPEntity073)
			{
				SCPEntity076.CainWin = true;
				ep.addStat(mod_SCP.CainWin, 1);
				return super.attackEntityFrom(par1DamageSource, par2);
			}
			return super.attackEntityFrom(par1DamageSource, par2);
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	public int getMaxHealth()
	{
		return this.health;
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return true;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		
		if(this.Swordtick > 0)
		{
			--this.Swordtick;
		}
		if(this.Swordtick == 0)
		{
			this.Swordtick = rand.nextInt(200);
		}	
		
		if(this.Swordtick < 25)
		{
			this.setCurrentItemOrArmor(0, new ItemStack(mod_SCP.SCP143Sword, 1));
		}
	}
	public void onUpdate()
	{
		EntityPlayer ep = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);		
		super.onUpdate();
		if(this.isDead)
		{
			SCPEntity076.Death = true;
		}
		if(this.isDead && SCPEntity076.CainWin)
		{
			ep.addStat(mod_SCP.CainWin, 1);
		}
	}
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.blaze.breath";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "sounds.StoneDoorSlam";
	}
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return 0;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	public ItemStack getHeldItem()
	{
		if(this.Swordtick <= 80)
		{
			return defaultHeldItem;
		}
		else
		{
			return null;
		}
	}

	static
	{
		defaultHeldItem = new ItemStack(mod_SCP.SCP143Sword, 1);
	}

	private static final ItemStack defaultHeldItem;
	{
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
}
