package securecraftprotect.common.tileentity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class TileEntityEventBlock extends TileEntity
{
    private Random rand = new Random();
    private String direction;
    private int entityID;
    public ItemStack block;
    public boolean isDirty;
    public int timer;
    
    public TileEntityEventBlock()
    {
        this.direction = "North";
        this.isDirty = false;
        this.timer = -1;
        this.entityID = 0;
    }
    
    public void updateEntity()
    {
        if(isDirty)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            isDirty = false;
        }
        if(timer <= 0) worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        if (direction.equals("North")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord, zCoord - 1), 1, worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1));
        else if (direction.equals("South")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord, zCoord + 1), 1, worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1));
        else if (direction.equals("East")) block = new ItemStack(worldObj.getBlock(xCoord + 1, yCoord, zCoord), 1, worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord));
        else if (direction.equals("West")) block = new ItemStack(worldObj.getBlock(xCoord - 1, yCoord, zCoord), 1, worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord));
        else if (direction.equals("Up")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord + 1, zCoord), 1, worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord));
        else if (direction.equals("Down")) block = new ItemStack(worldObj.getBlock(xCoord, yCoord - 1, zCoord), 1, worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord));
//        if(EntityList.getStringFromID(entityID) != "" && EntityList.getClassFromID(entityID) != null)
//        {
//            Entity entity = EntityList.createEntityByID(entityID, worldObj);
//
//            if (entity != null)
//            {
//                entity.setLocationAndAngles((double)xCoord, (double)yCoord + 0.5f, (double)zCoord, MathHelper.wrapAngleTo180_float(rand.nextFloat() * 360.0F), 0.0F);
//                worldObj.spawnEntityInWorld(entity);
//                worldObj.updateEntities();
//            }
//        }
        timer++;
        if(timer >= 100) timer = 10;
        super.updateEntity();
    }
    
    public void setDirection(String side)
    {
        this.direction = side;
    }
    
    public String getDirection()
    {
        return this.direction;
    }
    
    public void setEntityID(int id)
    {
        this.entityID = id;
    }
    
    public int getEntityID()
    {
        return this.entityID;
    }
    
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.setDirection(nbt.getString("Txtr"));
        this.setEntityID(nbt.getInteger("Entity"));
    }
    
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setString("Txtr", direction);
        nbt.setInteger("Entity", entityID);
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
