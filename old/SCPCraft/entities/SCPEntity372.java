package SCPCraft.entities;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity372 extends EntityAnimal
{
	public Minecraft mc = ModLoader.getMinecraftInstance().getMinecraft();
	public int directionX = 0, directionZ = 0, seen;
	private int transparentBlocks[] =
		{
			8, 9, 10, 11, 18, 27, 28, 30, 31,
			32, 37, 38, 39, 40, 44, 50, 51, 52, 59,
			64, 65, 66, 67, 69, 70, 72, 75, 76,
			77, 78, 83, 85, 90, 92, 106, 71,
			107, 108, 109, 111, 113, 114, 114, 117
		};

	public SCPEntity372(World world)
	{
		super(world);
		texture = "/SCPCraft/textures/mobs/372.png";
		setSize(1.4F, 0.9F);
		moveSpeed = 1.25F;
		stepHeight = 1.0F;
		float f = 0.25F;
		seen = 0;
		getNavigator().setAvoidsWater(true);
	}
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }
	
	public float getShadowSize()
    {
        return 0F;
    }

	public boolean isAIEnabled()
	{
		return false;
	}

	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	protected boolean canDespawn()
	{
		return false;
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		if(rand.nextInt(200) == 0) for(int m = 0; m <= 1000; m++)texture = "/SCPCraft/textures/mobs/372.png";
		else texture = "/SCPCraft/textures/mobs/513B.png";
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{       
		return false;
	}

	public void onUpdate()
	{
		super.onUpdate();
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if(entityplayer != null && canSCPBeSeen(entityplayer) && !worldObj.isRemote )
		{
			seen++;
			if(entityplayer.isDead)seen = 0;
			getNavigator().tryMoveToXYZ(entityplayer.posX + directionX, entityplayer.posY, entityplayer.posZ + directionZ, moveSpeed);
		}
		if(seen >= 1500)this.isAggro = true;
		if (!worldObj.isRemote)
		{
			func_40148_a(isCollidedHorizontally);
		}
	}

	public boolean canSCPBeSeen(EntityPlayer entityplayer)
	{
		if (worldObj.getFullBlockLightValue(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) < 1)
		{
			return false;
		}
		if (this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) != null && this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D).getBlink() >= 0 && this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D).getBlink() <= 10) return false;

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
    
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

        if (var2 != null && var2.itemID == mod_SCP.SCP1023ARC.itemID)
        {
            this.setDead();
            this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + (double)(this.height / 2.0F), this.posZ, 0.0D, 0.0D, 0.0D);
            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
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

			Vec3 Vec32 = Vec3.createVectorHelper(Vec3.xCoord, Vec3.yCoord, Vec3.zCoord);
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
		Vec3 Vec31 = Vec3.createVectorHelper(posX - entityplayer.posX, ((boundingBox.minY + (double)height) - entityplayer.posY) + (double)entityplayer.getEyeHeight(), posZ - entityplayer.posZ);
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

	public double getDistance(int i, int j, int k, int l, int i1, int j1)
	{
		int k1 = l - i;
		int l1 = i1 - j;
		int i2 = j1 - k;
		return Math.sqrt(k1 * k1 + l1 * l1 + i2 * i2);
	}

	private boolean isInFieldOfVision(SCPEntity372 entityscp, EntityLiving entityliving, float f, float f1)
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
		boolean flag2 = GetFlag(f9, f8, f2, 0.0F, 360F);
		boolean flag3 = GetFlag(f11, f10, f3, -180F, 180F);
		if(flag)directionZ = 2;
		if(flag1)directionX = -2;
		if(flag2)directionZ = -2;
		if(flag3)directionX = 2;
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

	public int getMaxHealth()
	{
		return 40;
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset()
	{
		return (double)height * 0.90D - 0.5D;
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
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Seen", seen);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);
		seen = nbttagcompound.getInteger("Seen");
	}

	public boolean func_40149_l_()
	{
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void func_40148_a(boolean flag)
	{
		byte byte0 = dataWatcher.getWatchableObjectByte(16);

		if (flag)
		{
			byte0 |= 1;
		}
		else
		{
			byte0 &= 0xfe;
		}

		dataWatcher.updateObject(16, Byte.valueOf(byte0));
	}

	protected String getLivingSound()
	{
		return "scp.rustle";
	}
	
	protected String getDeathSound()
	{
		return "mob.spiderdeath";
	}

	/**
	 * returns true if this entity is by a ladder, false otherwise
	 */
	public boolean isOnLadder()
	{
		return func_40149_l_();
	}

	/**
	 * Sets the Entity inside a web block.
	 */
	public void setInWeb()
	{

	}
	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return new SCPEntity372(worldObj);
	}
}
