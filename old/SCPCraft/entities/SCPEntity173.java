package SCPCraft.entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class SCPEntity173 extends SCPEntity
{
	public Minecraft mc = Minecraft.getMinecraft();
	private int slowPeriod;
	private int timeTillNextTeleport;
	private boolean timeLocked;
	private int transparentBlocks[] =
		{
			8, 9, 10, 11, 18, 27, 28, 30, 31,
			32, 37, 38, 39, 40, 44, 50, 51, 52, 59,
			64, 65, 66, 67, 69, 70, 72, 75, 76,
			77, 78, 83, 85, 90, 92, 106, 71,
			107, 108, 109, 111, 113, 114, 114, 117
		};

	public SCPEntity173(World world)
	{
		super(world);
		texture = "/SCPCraft/textures/mobs/173.png";
		attackStrength = 200;
		stepHeight = 4.0F;
		setSize(0.6F, 1.6F);
		this.health = 9001;
		isImmuneToFire = true;
		getNavigator().setEnterDoors(true);
	}
	
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("sounds.173sound", 0.15F, 1.0F);
    }

    
    public void targetLivings()
    {
    }

	public int getMaxHealth()
	{
		return 9001;
	}
	
    public float getSpeedModifier()
    {
        return super.getSpeedModifier() * 3F;
    }
	
	public boolean canBePushed()
    {
        return false;
    }

	public boolean isAIEnabled()
	{
		return false;
	}
	
	public void func_48150_h(boolean flag)
	{
		isJumping = flag;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	public int getTalkInterval()
	{
		return 220;
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
	 * (Animals, Spiders at day, peaceful PigZombies).
	 */
	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 16D);

		if (entityplayer != null && canSCPBeSeen(entityplayer))
		{
			return entityplayer;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	protected void attackEntity(Entity entity, float f)
	{		
		if (entityToAttack != null && (entityToAttack instanceof EntityPlayer) && !canSCPBeSeen((EntityPlayer)entityToAttack))
		{
			if (rand.nextInt(20) != 0)
			{
				super.attackEntity(entity, f);
			}
		}
	}


	protected void updateEntityActionState()
	{
		if (entityToAttack != null)
		{
			if (!canSCPBeSeen((EntityPlayer)entityToAttack))
			{
				super.updateEntityActionState();
			}
		}
		else
		{
			super.updateEntityActionState();
		}
	}
    
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
    }

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{       
		return false;
	}

	public void onLivingUpdate()
	{			
		moveSpeed = 80F;
        getNavigator().setSpeed(moveSpeed);
		isJumping = false;
		super.onLivingUpdate();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{	
		isJumping = false;

		if (worldObj.isDaytime())
		{
			float f = getBrightness(1.0F);

			if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
			{
			}
			else
			{
			}
		}

		if (entityToAttack != null && (entityToAttack instanceof EntityPlayer))
		{
			if (!canSCPBeSeen((EntityPlayer)entityToAttack))
			{
				if (getDistancetoEntityToAttack() > 15D && timeTillNextTeleport-- < 0)
				{
					timeTillNextTeleport = rand.nextInt(60) + 20;
				}

				if ((entityToAttack instanceof EntityPlayer) && getDistancetoEntityToAttack() <= 5D)
				{
					texture = "/SCPCraft/textures/mobs/173.png";

				}
				else
				{
					texture = "/SCPCraft/textures/mobs/173.png";

				}
			}

			if (slowPeriod > 0)
			{
				slowPeriod--;
				entityToAttack.motionX *= 0.01D;
				entityToAttack.motionZ *= 0.01D;
			}

			if ((entityToAttack instanceof EntityPlayer) && (canSCPBeSeen((EntityPlayer)entityToAttack) || timeLocked))
			{
				SCPDirectLook((EntityPlayer)entityToAttack);
				moveStrafing = moveForward = 0.0F;
				moveSpeed = 0.0F;

			}
			else
			{
				faceEntity(entityToAttack, 100F, 100F);
			}
		}

		super.onUpdate();
	}

	public boolean canSCPBeSeen(EntityPlayer entityplayer)
	{
    	List<?> var5 = this.worldObj.getEntitiesWithinAABB(SCPEntity131.class, this.boundingBox.expand((double)4F, 2.0D, (double)4F));
        Iterator<?> var2 = var5.iterator();
        while(var2.hasNext())return true;
        
		if (worldObj.getFullBlockLightValue(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) < 1)
		{
			return false;
		}
		if (mc.thePlayer != null && mc.thePlayer.getBlink() >= 0 && mc.thePlayer.getBlink() <= 10) return false;
		if (entityplayer.canEntityBeSeen(this) || LineOfSightCheck(entityplayer))
		{
			return isInFieldOfVision(this, entityplayer, 100F, 100F);  //70 65
		}
		else
		{
			return false;
		}
	}

	private boolean LineOfSightCheck(EntityLiving entityliving)
	{
		return rayTraceBlocks(Vec3.createVectorHelper(posX, posY + (double)getEyeHeight(), posZ), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX, posY + (double)height, posZ), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX, posY + (double)height * 0.10000000000000001D, posZ), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX + 0.69999999999999996D, posY + (double)getEyeHeight(), posZ), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX - 0.69999999999999996D, posY + (double)getEyeHeight(), posZ), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX, posY + (double)getEyeHeight(), posZ + 0.69999999999999996D), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX, posY + (double)getEyeHeight(), posZ - 0.69999999999999996D), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX, posY + (double)height * 1.2D, posZ - 0.69999999999999996D), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null || rayTraceBlocks(Vec3.createVectorHelper(posX, posY + (double)height * 1.2D + 1.0D, posZ), Vec3.createVectorHelper(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ)) == null;
	}

	private MovingObjectPosition rayTraceBlocks(Vec3 Vec3, Vec3 Vec31)
	{
		boolean flag = false;
		boolean flag1 = false;

		if (Double.isNaN(Vec3.xCoord) || Double.isNaN(Vec3.yCoord) || Double.isNaN(Vec3.zCoord))
		{
			return null;
		}

		if (Double.isNaN(Vec31.xCoord) || Double.isNaN(Vec31.yCoord) || Double.isNaN(Vec31.zCoord))
		{
			return null;
		}

		int i = MathHelper.floor_double(Vec31.xCoord);
		int j = MathHelper.floor_double(Vec31.yCoord);
		int k = MathHelper.floor_double(Vec31.zCoord);
		int l = MathHelper.floor_double(Vec3.xCoord);
		int i1 = MathHelper.floor_double(Vec3.yCoord);
		int j1 = MathHelper.floor_double(Vec3.zCoord);
		int k1 = worldObj.getBlockId(l, i1, j1);
		int l1 = worldObj.getBlockMetadata(l, i1, j1);
		Block block = Block.blocksList[k1];

		if ((!flag1 || block == null || block.getCollisionBoundingBoxFromPool(worldObj, l, i1, j1) != null) && k1 > 0 && block.canCollideCheck(l1, flag))
		{
			MovingObjectPosition movingobjectposition = block.collisionRayTrace(worldObj, l, i1, j1, Vec3, Vec31);

			if (movingobjectposition != null)
			{
				return movingobjectposition;
			}
		}

		for (int i2 = 200; i2-- >= 0;)
		{
			if (Double.isNaN(Vec3.xCoord) || Double.isNaN(Vec3.yCoord) || Double.isNaN(Vec3.zCoord))
			{
				return null;
			}

			if (l == i && i1 == j && j1 == k)
			{
				return null;
			}

			boolean flag2 = true;
			boolean flag3 = true;
			boolean flag4 = true;
			double d = 999D;
			double d1 = 999D;
			double d2 = 999D;

			if (i > l)
			{
				d = (double)l + 1.0D;
			}
			else if (i < l)
			{
				d = (double)l + 0.0D;
			}
			else
			{
				flag2 = false;
			}

			if (j > i1)
			{
				d1 = (double)i1 + 1.0D;
			}
			else if (j < i1)
			{
				d1 = (double)i1 + 0.0D;
			}
			else
			{
				flag3 = false;
			}

			if (k > j1)
			{
				d2 = (double)j1 + 1.0D;
			}
			else if (k < j1)
			{
				d2 = (double)j1 + 0.0D;
			}
			else
			{
				flag4 = false;
			}

			double d3 = 999D;
			double d4 = 999D;
			double d5 = 999D;
			double d6 = Vec31.xCoord - Vec3.xCoord;
			double d7 = Vec31.yCoord - Vec3.yCoord;
			double d8 = Vec31.zCoord - Vec3.zCoord;

			if (flag2)
			{
				d3 = (d - Vec3.xCoord) / d6;
			}

			if (flag3)
			{
				d4 = (d1 - Vec3.yCoord) / d7;
			}

			if (flag4)
			{
				d5 = (d2 - Vec3.zCoord) / d8;
			}

			byte byte0 = 0;

			if (d3 < d4 && d3 < d5)
			{
				if (i > l)
				{
					byte0 = 4;
				}
				else
				{
					byte0 = 5;
				}

				Vec3.xCoord = d;
				Vec3.yCoord += d7 * d3;
				Vec3.zCoord += d8 * d3;
			}
			else if (d4 < d5)
			{
				if (j > i1)
				{
					byte0 = 0;
				}
				else
				{
					byte0 = 1;
				}

				Vec3.xCoord += d6 * d4;
				Vec3.yCoord = d1;
				Vec3.zCoord += d8 * d4;
			}
			else
			{
				if (k > j1)
				{
					byte0 = 2;
				}
				else
				{
					byte0 = 3;
				}

				Vec3.xCoord += d6 * d5;
				Vec3.yCoord += d7 * d5;
				Vec3.zCoord = d2;
			}

			Vec3 Vec32 = net.minecraft.util.Vec3.createVectorHelper(Vec3.xCoord, Vec3.yCoord, Vec3.zCoord);
			l = (int)(Vec32.xCoord = MathHelper.floor_double(Vec3.xCoord));

			if (byte0 == 5)
			{
				l--;
				Vec32.xCoord++;
			}

			i1 = (int)(Vec32.yCoord = MathHelper.floor_double(Vec3.yCoord));

			if (byte0 == 1)
			{
				i1--;
				Vec32.yCoord++;
			}

			j1 = (int)(Vec32.zCoord = MathHelper.floor_double(Vec3.zCoord));

			if (byte0 == 3)
			{
				j1--;
				Vec32.zCoord++;
			}

			int j2 = worldObj.getBlockId(l, i1, j1);
			int k2 = worldObj.getBlockMetadata(l, i1, j1);
			Block block1 = Block.blocksList[j2];

			if ((!flag1 || block1 == null || block1.getCollisionBoundingBoxFromPool(worldObj, l, i1, j1) != null) && j2 > 0 && block1.canCollideCheck(k2, flag) && !isBlockTransparent(j2))
			{
				MovingObjectPosition movingobjectposition1 = block1.collisionRayTrace(worldObj, l, i1, j1, Vec3, Vec31);

				if (movingobjectposition1 != null)
				{
					return movingobjectposition1;
				}
			}
		}

		return null;
	}

	private boolean isBlockTransparent(int i)
	{
		for (int j = 0; j < transparentBlocks.length; j++)
		{
			if (i == transparentBlocks[j])
			{
				return true;
			}
		}

		return true;
	}

	private boolean SCPDirectLook(EntityPlayer entityplayer)
	{
		if (worldObj.getFullBlockLightValue(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) < 1)
		{
			return false;
		}

		Vec3 Vec3 = entityplayer.getLook(1.0F).normalize();
		Vec3 Vec31 = net.minecraft.util.Vec3.createVectorHelper(posX - entityplayer.posX, ((boundingBox.minY + (double)height) - entityplayer.posY) + (double)entityplayer.getEyeHeight(), posZ - entityplayer.posZ);
		double d = Vec31.lengthVector();
		Vec31 = Vec31.normalize();
		double d1 = Vec3.dotProduct(Vec31);

		if (d1 > 1.0D - 0.025000000000000001D / d)
		{


			return entityplayer.canEntityBeSeen(this);
		}
		else
		{
			return false;
		}
	}

	public boolean SCPSeeSCP(SCPEntity173 entityscp)
	{
		if (worldObj.getFullBlockLightValue(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) < 1)
		{
			return false;
		}


		else
		{
			return isInFieldOfVision(entityscp, this, 40F, 65F);
		}
	}

	public double getDistance(int i, int j, int k, int l, int i1, int j1)
	{
		int k1 = l - i;
		int l1 = i1 - j;
		int i2 = j1 - k;
		return Math.sqrt(k1 * k1 + l1 * l1 + i2 * i2);
	}

	public double getDistancetoEntityToAttack()
	{
		if (entityToAttack instanceof EntityPlayer)
		{
			double d = entityToAttack.posX - posX;
			double d2 = entityToAttack.posY - posY;
			double d4 = entityToAttack.posZ - posZ;
			return (double)MathHelper.sqrt_double(d * d + d2 * d2 + d4 * d4);
		}

		EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 64D);

		if (entityplayer != null)
		{
			double d1 = entityplayer.posX - posX;
			double d3 = entityplayer.posY - posY;
			double d5 = entityplayer.posZ - posZ;
			return (double)MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
		}
		else
		{
			return 40000D;
		}
	}

	private boolean isInFieldOfVision(SCPEntity173 entityscp, EntityLiving entityliving, float f, float f1)
	{
		float f2 = entityliving.rotationYaw;
		float f3 = entityliving.rotationPitch;
		entityliving.faceEntity(entityscp, 360F, 360F);
		float f4 = entityliving.rotationYaw;
		float f5 = entityliving.rotationPitch;
		entityliving.rotationYaw = f2;
		entityliving.rotationPitch = f3;
		f2 = f4;
		f3 = f5;
		float f6 = f;
		float f7 = f1;
		float f8 = entityliving.rotationYaw - f6;
		float f9 = entityliving.rotationYaw + f6;
		float f10 = entityliving.rotationPitch - f7;
		float f11 = entityliving.rotationPitch + f7;
		boolean flag = GetFlag(f8, f9, f2, 0.0F, 360F);
		boolean flag1 = GetFlag(f10, f11, f3, -180F, 180F);
		return flag && flag1 && (entityliving.canEntityBeSeen(entityscp) || LineOfSightCheck(entityliving));
	}

	public boolean GetFlag(float f, float f1, float f2, float f3, float f4)
	{
		if (f < f3)
		{
			if (f2 >= f + f4)
			{
				return true;
			}

			if (f2 <= f1)
			{
				return true;
			}
		}

		if (f1 >= f4)
		{
			if (f2 <= f1 - f4)
			{
				return true;
			}

			if (f2 >= f)
			{
				return true;
			}
		}

		if (f1 < f4 && f >= f3)
		{
			return f2 <= f1 && f2 > f;
		}
		else
		{
			return false;
		}
	}
	
	public void setYaw(float f)
	{
		rotationYaw = f;
	}

	protected String getLivingSound()
	{
		return "sounds.sculpture";
	}
	
    public boolean canBeCollidedWith()
    {
        return true;
    }
    
	public int getMaxSpawnedInChunk()
	{
		return 0;
	}
}
