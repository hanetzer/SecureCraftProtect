package SCPCraft.entities;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SCPEntity50AEJ extends SCPEntity
{
	public SCPEntity50AEJ(World par1World)
	{
		super(par1World);
		texture = "/SCPCraft/textures/mobs/50AEJ.png";
		moveSpeed = 0.4F;
		attackStrength = 9002;
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAISCP0173Attack(this, SCPEntity1440.class, moveSpeed, false));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		tasks.addTask(2, new EntityAIWander(this, moveSpeed));
		tasks.addTask(3, new EntityAIWatchClosest(this, SCPEntity1440.class, 8F));
		tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, SCPEntity1440.class, 16F, 0, true));
	}

	public int getMaxHealth()
	{
		return 9001;
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

		Random rand = new Random();
		int Delay = rand.nextInt(250);

		if(Delay <= 2)
		{
			this.setDead();
		}
	}
	
	 public void onKillEntity(EntityLiving par1EntityLiving) 
	 {
		EntityPlayer ep = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if(ep != null)
		{
			int Chat = rand.nextInt(4);
			if(Chat == 0)
			{
				ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rDIE YOU RUSSIAN");
			}
			if(Chat == 1)
			{
				ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rPINKO PHUCKS");
			}
			if(Chat == 2)
			{
				ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rUP YOUR LEBENSRAUM YOU UBERMENSCH F*CK");
			}
			if(Chat == 3)
			{
				ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rCAN YOU HEAR ME NOW HUGO CHAVEZ");
			}
		}
	 }

	public float getShadowSize()
	{
		return 0.0F;
	}

/*	public boolean isEntityAlive()
	{
		EntityPlayer ep = ModLoader.getMinecraftInstance().thePlayer;
		int Chat = rand.nextInt(250);

		if(Chat <= 2)
		{
			if(!worldObj.isRemote)
			{
				int randomChat = rand.nextInt(4);
				if(randomChat == 0)
				{
					ep.addChatMessage("CAN YOU HEAR ME NOW HUGO CHAVEZ");
				}
				if(randomChat == 1)
				{
					ep.addChatMessage("PINKO F*CKS");
				}
				if(randomChat == 2)
				{
					ep.addChatMessage("UP YOUR LEBENSRAUM YOU UBERMENSCH F*CK");
				}
				if(randomChat == 3)
				{
					ep.addChatMessage("DIE YOU RUSSIAN");
				}
			}

			if(worldObj.isRemote)
			{
				int randomChat = rand.nextInt(4);
				if(randomChat == 0)
				{
					ep.addChatMessage("CAN YOU HEAR ME NOW HUGO CHAVEZ");
				}
				if(randomChat == 1)
				{
					ep.addChatMessage("PINKO F*CKS");
				}
				if(randomChat == 2)
				{
					ep.addChatMessage("UP YOUR LEBENSRAUM YOU UBERMENSCH F*CK");
				}
				if(randomChat == 3)
				{
					ep.addChatMessage("DIE YOU RUSSIAN");
				}
			}
		}

		return !this.isDead;
	} */

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
