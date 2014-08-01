package securecraftprotect.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMountable extends Entity
{

	//These variables keep track of the block that created the entity.
	public int orgBlockPosX;
	public int orgBlockPosY;
	public int orgBlockPosZ;

	public EntityMountable(World world)
	{
		super(world);
		noClip = true;
		preventEntitySpawning = true;
		width = 0F;
		height = 0F;
	}

	public EntityMountable(World world, double x, double y, double z)
	{
		super(world);
		noClip = true;
		preventEntitySpawning = true;
		width = 0F;
		height = 0F;
		setPosition(x, y, z);
	}

	//This constructor is called by the mountable block.
	public EntityMountable(World world, EntityPlayer player, int x, int y,
						   int z,
						   float mountX, float mountY, float mountZ)
	{
		super(world);
		noClip = true;
		preventEntitySpawning = true;
		width = 0.0F;
		height = 0.0F;

		orgBlockPosX = x;
		orgBlockPosY = y;
		orgBlockPosZ = z;

		setPosition(mountX, mountY, mountZ);
	}

	//@Override
	public boolean interact(EntityPlayer player)
	{
		if (!worldObj.isRemote && (riddenByEntity == null || riddenByEntity == player))
		{
			player.mountEntity(this);
			return true;
		}
		else
		{
			return false;
		}
	}

	//This method is mostly a simplified version of the one in Entity but it
	// also deletes unused EMBs.
	@Override
	public void onEntityUpdate()
	{
		worldObj.theProfiler.startSection("entityBaseTick");
		if (riddenByEntity == null || riddenByEntity.isDead)
		{
			setDead();
		}
		ticksExisted++;
		worldObj.theProfiler.endSection();
	}

	@Override
	public void entityInit() {}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {}
}
