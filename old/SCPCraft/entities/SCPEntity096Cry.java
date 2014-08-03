package SCPCraft.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class SCPEntity096Cry extends SCPEntity
{
	private int field_35185_e;
	public boolean isAttacking;
	int time;
	public SCPEntity096Cry(World par1World)
	{
		super(par1World);
		texture = "/SCPCraft/textures/mobs/096Mad.png";
		moveSpeed = 0.0F;
		attackStrength = 0;
		this.time = 0;
		isAttacking = false;
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

	protected Entity findPlayerToAttack()
	{
		return null;
	}
    
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
    }

	public void onLivingUpdate()
	{
		EntityPlayer entityplayer = worldObj.getClosestVulnerablePlayerToEntity(this, 64D);
		motionX = 0;
		motionZ = 0;
		isAttacking = entityToAttack != null;
		if(time == 0)this.worldObj.playSoundAtEntity(this, "sounds.096Seen", 0.2F, 1F);
		time++;
		Minecraft mc = ModLoader.getMinecraftInstance();
		if(!worldObj.isRemote && time == 620)
		{
			this.setDead();
			SCPEntity096Mad silver = new SCPEntity096Mad(worldObj);
			silver.setLocationAndAngles(posX, posY, posZ, 0, 0);
			worldObj.spawnEntityInWorld(silver); 
			((EntityLiving)silver).playLivingSound();
		}
		for (int k = 0; k < 2; k++)
		{
			worldObj.spawnParticle("cry", posX + 0.1, posY + 2D, posZ + 0.25D, (rand.nextDouble() - 0.5D), -1.5D, (rand.nextDouble() - 0.5D));
			worldObj.spawnParticle("cry", posX - 0.1, posY + 2D, posZ + 0.25D, (rand.nextDouble() - 0.5D), -1.5D, (rand.nextDouble() - 0.5D));
		}
		isJumping = false;
	}
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.villager.default";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.ghast.scream";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.villager.default";
	}

	protected boolean canDespawn()
	{
		return false;
	}
}
