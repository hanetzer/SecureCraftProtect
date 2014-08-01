package securecraftprotect.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/*ITOS:
 *This class acts as a bridge between the mountable block and the player.
 *This entity is what the player actually mounts instead of the block.
 *An entity of this class is created by the mountable block upon activation
 *and is killed when it's no longer used.
*/

public class EntityMountable extends Entity
{
	
	//These variables keep track of the block that created the entity.
	public int orgBlockPosX;
	public int orgBlockPosY;
	public int orgBlockPosZ;
	protected int orgBlockID;
	
	public EntityMountable(World world)
	{
		super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0F;
        height = 0F;
	}
	
	public EntityMountable(World world, double d, double d1, double d2)
	{
        super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0F;
        height = 0F;
        setPosition(d, d1, d2);
	}

	//This constructor is called by the mountable block.
	public EntityMountable(World world, EntityPlayer entityplayer, int i,
						   int j, int k, float mountingX,
						   float mountingY, float mountingZ)
	{
		super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0.0F;
        height = 0.0F;
        
    	setOrgBlockPosX(i);
    	setOrgBlockPosY(j);
    	setOrgBlockPosZ(k);

        setPosition(mountingX, mountingY, mountingZ);
	}
	
	//This method handles mounting and dismounting.
	//@Override
    public boolean interact(Entity entity)
    {
        if (
				this.riddenByEntity != null
				&& this.riddenByEntity instanceof EntityPlayer
				&& this.riddenByEntity != entity)
        {
        	return true;
        }
        else
        {
        	if (!this.worldObj.isRemote)
        	{
        		entity.mountEntity(this);
        	}
        	return true;
        }
    }
    
	//This method is mostly a simplified version of the one in Entity but it also deletes unused EMBs.
    @Override
    public void onEntityUpdate()
    {
    	this.worldObj.theProfiler.startSection("entityBaseTick");
        if(riddenByEntity == null || riddenByEntity.isDead)
        {
			this.setDead();
        }
        else
		{
        	this.interact(riddenByEntity);
		}
        ticksExisted++;
        this.worldObj.theProfiler.endSection();
    }
    
    //The following methods are required by the Entity class but I don't know what they are for.
    @Override
    public void entityInit() {}
    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {}
    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {}

	public int getPosX() {
		return orgBlockPosX;
	}

	public void setOrgBlockPosX(int orgBlockPosX) {
		this.orgBlockPosX = orgBlockPosX;
	}

	public int getPosY() {
		return orgBlockPosY;
	}

	public void setOrgBlockPosY(int orgBlockPosY) {
		this.orgBlockPosY = orgBlockPosY;
	}

	public int getPosZ() {
		return orgBlockPosZ;
	}

	public void setOrgBlockPosZ(int orgBlockPosZ) {
		this.orgBlockPosZ = orgBlockPosZ;
	}
	
}
