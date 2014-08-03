package SCPCraft.tileentities;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import SCPCraft.SCPPotion;

public class SCPTileEntityFlesh extends TileEntity
{
	public Random rand = new Random();
	public boolean hasStepped;
	public int time;
	private Minecraft minecraft = ModLoader.getMinecraftInstance();
    public SCPTileEntityFlesh()
    {
    }
    
    public boolean setStep(boolean par)
    {
    	return hasStepped = par;
    }

    public void updateEntity()
    {
    	EntityPlayer player = worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D);
    	if(hasStepped == true && player != null)time++;
    	if(player != null && time == 500)player.addPotionEffect(new PotionEffect(SCPPotion.eaten.id, 12*20, 1));
    	if(player != null && player.isPotionActive(SCPPotion.eaten) && time >= 500 && time%50 == 0)worldObj.playSoundEffect((double)((float)this.xCoord + 0.5F), (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F), "sounds.Munch", 1F, 1F);
        super.updateEntity();
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        time = par1NBTTagCompound.getShort("Time");
        hasStepped = par1NBTTagCompound.getBoolean("Step");
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("Time", (short)time);
        par1NBTTagCompound.setBoolean("Step", hasStepped);
    }
}

