package SCPCraft.tileentities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class SCPTileEntityShelf extends TileEntity
{
	public ItemStack item;
	public float rot;
	
	public SCPTileEntityShelf(){}
	
    public ItemStack getItem()
    {
        return this.item;
    }

    public ItemStack setItem(ItemStack it)
    {
        return this.item = it;
    }

    public float setRotation(float rotation)
    {
        return this.rot = rotation;
    }
    
    public float getRotation()
    {
        return this.rot;
    }
    
    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
        this.readFromNBT(pkt.customParam1);
    }
   
    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound var1 = new NBTTagCompound();
        this.writeToNBT(var1);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 0, var1);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        if(par1NBTTagCompound.hasKey("item")) item = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("item"));
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagCompound compound = new NBTTagCompound();     
        par1NBTTagCompound.setCompoundTag("item", compound);   
        if(item != null) item.writeToNBT(compound);
    }
}
