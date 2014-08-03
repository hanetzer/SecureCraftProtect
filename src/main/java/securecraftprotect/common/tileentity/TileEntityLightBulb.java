package securecraftprotect.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.EnumSkyBlock;

public class TileEntityLightBulb extends TileEntity
{

    public TileEntityLightBulb()
    {
    }
    
    public void updateEntity()
    {
        this.worldObj.setLightValue(EnumSkyBlock.Block, this.xCoord, this.yCoord, this.zCoord, 12);
        this.updateContainingBlockInfo();
//        this.worldObj.updateLightByType(EnumSkyBlock.Block, this.xCoord, this.yCoord, this.zCoord);
        //this.worldObj.markTileEntityChunkModified(this.xCoord, this.yCoord, this.zCoord, this);
    }

    public void readFromNBT(NBTTagCompound tag)
    {
    }

    public void writeToNBT(NBTTagCompound tag)
    {
    }
    
}
