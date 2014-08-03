package SCPCraft.tileentities;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;

public class SCPTileEntity079 extends TileEntity
{
	public Random rand = new Random();
	private Minecraft minecraft = ModLoader.getMinecraftInstance();
    public SCPTileEntity079()
    {
    }

    public boolean anyPlayerInRange()
    {
        return worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 9D) != null;
    }

    public void updateEntity()
    {    	
        super.updateEntity();
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

