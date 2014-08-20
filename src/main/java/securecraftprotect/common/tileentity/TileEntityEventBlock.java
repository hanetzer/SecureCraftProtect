package securecraftprotect.common.tileentity;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEventBlock extends TileEntity
{
    private Random rand = new Random();
    private String texture;
    public ItemStack block;
    public boolean isDirty;
    public int timer;
    
    public TileEntityEventBlock()
    {
        this.texture = "North";
        this.isDirty = false;
        this.timer = -1;
    }
    
    public void updateEntity()
    {
        if(isDirty)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            isDirty = false;
        }
        if(timer <= 0) worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        if (texture.equals("North")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord, zCoord - 1), 1, worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1));
        else if (texture.equals("South")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord, zCoord + 1), 1, worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1));
        else if (texture.equals("East")) block = new ItemStack(worldObj.getBlock(xCoord + 1, yCoord, zCoord), 1, worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord));
        else if (texture.equals("West")) block = new ItemStack(worldObj.getBlock(xCoord - 1, yCoord, zCoord), 1, worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord));
        else if (texture.equals("Up")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord + 1, zCoord), 1, worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord));
        else if (texture.equals("Down")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord - 1, zCoord), 1, worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord));
        timer++;
        if(timer >= 100) timer = 10;
        super.updateEntity();
    }
    
    public void setTexture(String side)
    {
        this.texture = side;
    }
    
    public String getTextureName()
    {
        return this.texture;
    }
    
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.setTexture(nbt.getString("Txtr"));
    }
    
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setString("Txtr", texture);
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
//        worldObj.updateAllLightTypes(xCoord, yCoord, zCoord);
    }
}
