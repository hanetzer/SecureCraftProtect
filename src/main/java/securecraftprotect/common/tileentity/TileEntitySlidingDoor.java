package securecraftprotect.common.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySlidingDoor extends TileEntity
{
    private Random rand = new Random();
    public boolean open;
    public float doorMovement;
    
    public TileEntitySlidingDoor()
    {
        this.open = false;
        this.doorMovement = 0f;
    }
    
    public void updateEntity()
    {
        super.updateEntity();
        if(open && doorMovement <= 1.1f) doorMovement += 0.1f;
        else if(!open && doorMovement >= 0f ) doorMovement -= 0.1f;
        if(doorMovement < 0f) doorMovement = 0f;
        if(doorMovement > 1.1f) doorMovement = 1.1f;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        open = nbt.getBoolean("State");
        doorMovement = nbt.getFloat("DoorMovement");
    }
    
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setBoolean("State", open);
        nbt.setFloat("DoorMovement", doorMovement);
    }
    
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbt);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.getNbtCompound());
        worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
    }
}
