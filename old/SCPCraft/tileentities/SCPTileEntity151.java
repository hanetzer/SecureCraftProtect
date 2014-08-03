package SCPCraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;

public class SCPTileEntity151 extends TileEntity
{
    public SCPTileEntity151()
    {
    }

    public boolean anyPlayerInRange()
    {
        return worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 16D) != null;
    }

    public void updateEntity()
    {    	
		EntityPlayer entityplayer = worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 16D);
        if (!anyPlayerInRange())
        {
            return;
        }
        else
        {
            if(entityplayer != null && !entityplayer.capabilities.isCreativeMode && shouldAttackPlayer(entityplayer))
            {
            	entityplayer.attackEntityFrom(DamageSource.drown, 2);
            }
        }
        super.updateEntity();
    }
    
	private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer)
	{
		if(par1EntityPlayer != null)
		{
			Vec3 vec3d = par1EntityPlayer.getLook(1.0F).normalize();
			Vec3 vec3d1 = Vec3.createVectorHelper(xCoord - par1EntityPlayer.posX, yCoord + 1D - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight()), zCoord - par1EntityPlayer.posZ);
			double d = vec3d1.lengthVector();
			vec3d1 = vec3d1.normalize();
			double d1 = vec3d.dotProduct(vec3d1);

			if (d1 > 0.5D - 0.025000000000000001D / d)
			{
				return canTileEntityBeSeen(this);
			}
			else
			{
				return false;
			}
		}
		return false;
	}
    
	public boolean canTileEntityBeSeen(TileEntity par1Entity)
	{
		EntityPlayer entityplayer = worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 16D);
		return this.worldObj.rayTraceBlocks(this.worldObj.getWorldVec3Pool().getVecFromPool(entityplayer.posX, entityplayer.posY + (double)entityplayer.getEyeHeight(), entityplayer.posZ), this.worldObj.getWorldVec3Pool().getVecFromPool(par1Entity.xCoord, par1Entity.yCoord + (double)entityplayer.getEyeHeight(), par1Entity.zCoord)) == null;
	}

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
    }
}

