package SCPCraft.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class SCPEntity053 extends SCPEntity
{
	private int field_35185_e;
	public boolean isAttacking;
	private boolean isAngry;

	public SCPEntity053(World par1World)
	{
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/053.png";
		this.setSize(1.0F, 2.0F);
		this.moveSpeed = 0.4F;
		this.stepHeight = 1.0F;
		this.attackStrength = 0;
		this.getNavigator().setAvoidsWater(true);
		float var2 = 0.25F;
		isAngry = false;
		isImmuneToFire = true;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, var2));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAISCP0173Attack(this, EntityPlayer.class, this.moveSpeed, false));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{	
		return true;
	}
    
    public void targetLivings()
    {
    }

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{       
		EntityPlayer ep = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if(ep != null)((EntityLiving)ep).addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 20, 2));
		return false;
	}

	public int getMaxHealth()
	{
		return 9001; //ITS OVER 9000!!!!!!!!!!!!!!!!!!
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

	protected boolean canDespawn()
	{
		return false;
	}

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float par1)
	{
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

	private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer)
	{
		if(par1EntityPlayer != null)
		{
			Vec3 vec3d = par1EntityPlayer.getLook(1.0F).normalize();
			Vec3 vec3d1 = Vec3.createVectorHelper(posX - par1EntityPlayer.posX, (boundingBox.minY + (double)(height / 2.0F)) - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight()), posZ - par1EntityPlayer.posZ);
			double d = vec3d1.lengthVector();
			vec3d1 = vec3d1.normalize();
			double d1 = vec3d.dotProduct(vec3d1);

			if (d1 > 1.0D - 0.025000000000000001D / d)
			{
				return par1EntityPlayer.canEntityBeSeen(this);
			}
			else
			{
				return false;
			}
		}
		return false;
	}

	public void onLivingUpdate()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		motionX = 0;
		motionZ = 0;
		isAttacking = entityToAttack != null;
		moveSpeed = entityToAttack == null ? 0.3F : 6.5F;

		if(shouldAttackPlayer(entityplayer) == true)
		{
			if(!worldObj.isRemote)
			{
				Minecraft mc = ModLoader.getMinecraftInstance();
				if(entityplayer != null && mc.playerController.isNotCreative())
				{
					((EntityLiving)entityplayer).addPotionEffect(new PotionEffect(Potion.confusion.id, 12 * 12, 2));
				}
			}
		}

		if (worldObj.isDaytime() && !worldObj.isRemote)
		{
			float f = getBrightness(1.0F);

			if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
			{
				entityToAttack = null;
			}
		}

		isJumping = false;

		if (entityToAttack != null)
		{
			faceEntity(entityToAttack, 100F, 100F);
		}

		if (!worldObj.isRemote && isEntityAlive())
		{
			if (entityToAttack != null)
			{
				if ((entityToAttack instanceof EntityPlayer) && shouldAttackPlayer((EntityPlayer)entityToAttack))
				{
					moveStrafing = moveForward = 0.0F;
					moveSpeed = 0.0F;

				}
			}
		}
		super.onLivingUpdate();
	}
}
