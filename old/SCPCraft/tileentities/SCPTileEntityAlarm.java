package SCPCraft.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SCPTileEntityAlarm extends TileEntity
{
	public int alarmType;
    public SCPTileEntityAlarm()
    {
    	alarmType = 0;
    }
    public void triggerNote(World par1World, int par2, int par3, int par4)
    {
    	if(alarmType == 0)par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "sounds.AlarmClassic", 30F, 1F);
    	else if(alarmType == 1)par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "sounds.AlarmSpeaker", 30F, 1F);
    	else if(alarmType == 2)par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "sounds.AlarmRetro", 30F, 1F);
    	else if(alarmType == 3)par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "sounds.AlarmScary", 30F, 1F);
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
        alarmType = par1NBTTagCompound.getShort("Alarm");
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("Alarm", (short)alarmType);
    }
}

