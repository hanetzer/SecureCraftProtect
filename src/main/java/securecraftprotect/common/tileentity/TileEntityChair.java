package securecraftprotect.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityChair extends TileEntity
{
	public int dir;
	public TileEntityChair() {}

	public void setDir(int i) {
		this.dir = i;
	}

	public int getDir() {
		return this.dir;
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("Direction", this.dir);
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.setDir(compound.getInteger("Direction"));
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pack)
	{
		readFromNBT(pack.func_148857_g());
	}
}
