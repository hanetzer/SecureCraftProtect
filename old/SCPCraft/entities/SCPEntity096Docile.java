package SCPCraft.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class SCPEntity096Docile extends SCPEntity
{
	private int field_35185_e;
	public boolean isAttacking;
	int time;	
	public SCPEntity096Docile(World par1World)
	{
		super(par1World);
		texture = "/SCPCraft/textures/mobs/096Mad.png";
		moveSpeed = 0.0F;
		attackStrength = 0;
		this.time = 0;
		isAttacking = false;
	}
    
    public void targetLivings()
    {
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
		EntityPlayer entityplayer = worldObj.getClosestVulnerablePlayerToEntity(this, 64D);

		if (entityplayer != null)
		{
			if (shouldAttackPlayer(entityplayer))
			{
				if (field_35185_e++ == 5)
				{
					field_35185_e = 0;
					return entityplayer;
				}
			}
			else
			{
				field_35185_e = 0;
			}
		}

		return null;
	}
    
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
    }

	private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer)
	{
		EntityPlayer player = ModLoader.getMinecraftInstance().thePlayer;
		if(par1EntityPlayer != null && player != null && !(player.getBlink() >= 0 && player.getBlink() <= 10))
		{
            Vec3 var3 = par1EntityPlayer.getLook(1.0F).normalize();
            Vec3 var4 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX - par1EntityPlayer.posX +1D, this.boundingBox.minY + (double)(this.height / 2.0F) - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight()), this.posZ - par1EntityPlayer.posZ +1D);
            double var5 = var4.lengthVector();
            var4 = var4.normalize();
            double var7 = var3.dotProduct(var4);
            return var7 > 0.6D - 0.025D / var5 ? par1EntityPlayer.canEntityBeSeen(this) : false;

			/*if ((d1 > 0.6D - 0.025000000000000001D / d) && this.canEntityBeSeen(par1EntityPlayer) && (par1EntityPlayer.rotationYawHead <= 240 && par1EntityPlayer.rotationYawHead >= 120) || (par1EntityPlayer.rotationYawHead >= -240 && par1EntityPlayer.rotationYawHead <= -120))
			{
				return par1EntityPlayer.canEntityBeSeen(this);
			}*/
		}
		return false;
	}

	public void onLivingUpdate()
	{
		EntityPlayer entityplayer = worldObj.getClosestVulnerablePlayerToEntity(this, 64D);
		motionX = 0;
		motionZ = 0;
		this.rotationYaw = 0F;
		renderYawOffset = 0;
        this.moveStrafing = 0.0F;
        this.moveForward = 0.0F;
        this.randomYawVelocity = 0.0F;
		isAttacking = entityToAttack != null;
		if(time%340 == 0)this.worldObj.playSoundAtEntity(this, "sounds.096Cry", 0.2F, 1F);
		time++;
		Minecraft mc = ModLoader.getMinecraftInstance();
		
		if(shouldAttackPlayer(entityplayer) == true && entityplayer.isEntityAlive())
		{
			entityplayer.set096TargetState(true);
			if(!worldObj.isRemote)
			{
				this.setDead();
				SCPEntity096Cry silver = new SCPEntity096Cry(worldObj);
				silver.setLocationAndAngles(posX, posY, posZ, 0, 0);
				worldObj.spawnEntityInWorld(silver); 
				((EntityLiving)silver).playLivingSound();
			}
		}

        if (Math.abs(this.motionY) < 0.005D)
        {
            this.motionY = 0.0D;
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
