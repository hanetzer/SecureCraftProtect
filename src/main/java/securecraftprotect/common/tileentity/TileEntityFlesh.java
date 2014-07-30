package securecraftprotect.common.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class TileEntityFlesh extends TileEntity
{
	public Random rand = new Random();
	public boolean hasStepped;
	public int time;
	private double x = (double)xCoord;
	private double y = (double)yCoord;
	private double z = (double)zCoord;
	private Minecraft mc = Minecraft.getMinecraft();

	public TileEntityFlesh()
	{
	}

	public boolean setStep(boolean par)
	{
		return hasStepped = par;
	}

	public void updateEntity()
	{
		EntityPlayer player = worldObj.getClosestPlayer(x + 0.5D, y + 0.5D, z + 0.5D, 4D);
		if (hasStepped && player != null) time++;
		if (player != null && time == 500) {
			//player.addPotionEffect(new PotionEffect(SCPPotion.eaten.id,
			//		12 * 20, 1));
		}
		/*if (player != null && player.isPotionActive(SCPPotion.eaten) && time
				>= 500 && time % 50 == 0) {
			worldObj.playSoundEffect(((float) this.xCoord + 0.5F),
					((float) this.yCoord + 0.5F), ((float)
							this.zCoord + 0.5F), "sounds.Munch", 1F, 1F);
		}*/
		super.updateEntity();
	}

	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		time = compound.getShort("Time");
		hasStepped = compound.getBoolean("Step");
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setShort("Time", (short) time);
		compound.setBoolean("Step", hasStepped);
	}
}
