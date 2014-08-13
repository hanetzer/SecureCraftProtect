package securecraftprotect.common.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLightBulb extends TileEntity
{
    int test = 0;
    
    public TileEntityLightBulb()
    {
    }
    
    public void updateEntity()
    {
        if (test % 7 == 0) this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 4, 2);
        if (test % 18 == 0) this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 8, 2);
        test += new Random().nextInt(19);
    }
    
    public void readFromNBT(NBTTagCompound tag)
    {
    }
    
    public void writeToNBT(NBTTagCompound tag)
    {
    }
    
}
