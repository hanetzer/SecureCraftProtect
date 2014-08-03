package SCPCraft.tileentities;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCPTileEntity076 extends TileEntity
{
    /** The stored delay before a new spawn. */
    public int delay = -1;

    /**
     * The string ID of the mobs being spawned from this spawner. Defaults to pig, apparently.
     */
    private String mobID = "SCP-076";

    /** The extra NBT data to add to spawned entities */
    private NBTTagCompound spawnerTags = null;
    public double yaw;
    public double yaw2 = 0.0D;
    @SideOnly(Side.CLIENT)
    private Entity spawnedMob;

    public SCPTileEntity076()
    {
    }

    @SideOnly(Side.CLIENT)
    public String getMobID()
    {
        return this.mobID;
    }

    public void setMobID(String par1Str)
    {
        this.mobID = par1Str;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
            if (this.worldObj.isRemote)
            {
                double var1 = (double)((float)this.xCoord + this.worldObj.rand.nextFloat());
                double var3 = (double)((float)this.yCoord + this.worldObj.rand.nextFloat());
                double var5 = (double)((float)this.zCoord + this.worldObj.rand.nextFloat());
                this.worldObj.spawnParticle("smoke", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("flame", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("smoke", var1 + 1, var3, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("flame", var1 + 1, var3, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("smoke", var1, var3, var5 + 1, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("flame", var1, var3, var5 + 1, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("smoke", var1, var3 + 1, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("flame", var1, var3 + 1, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("smoke", var1 + 1, var3 + 1, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("flame", var1 + 1, var3 + 1, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("smoke", var1, var3 + 1, var5 + 1, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("flame", var1, var3 + 1, var5 + 1, 0.0D, 0.0D, 0.0D);
                this.yaw2 = this.yaw % 360.0D;
                this.yaw += 4.545454502105713D;
            }
            else
            {
                if (this.delay == -1)
                {
                    this.updateDelay();
                }
                //10 ticks = 1 second
                if(this.delay == 90)worldObj.playSoundEffect((double)((float)this.xCoord + 0.5F), (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F), "sounds.StoneDoorOpen", 0.5F, 1F);                
                for (int var11 = 0; var11 < 1; ++var11)
                {
                    Entity var2 = EntityList.createEntityByName(this.mobID, this.worldObj);

                    if (var2 == null)
                    {
                        return;
                    }
                    int var12 = this.worldObj.getEntitiesWithinAABB(var2.getClass(), AxisAlignedBB.getAABBPool().getAABB((double)this.xCoord, (double)this.yCoord, (double)this.zCoord, (double)(this.xCoord + 256), (double)(this.yCoord + 256), (double)(this.zCoord + 256)).expand(256.0D, 40.0D, 256.0D)).size();

                    if (var12 >= 1)
                    {
                        this.updateDelay();
                        return;
                    }

                    if (var2 != null)
                    {                    	
                        if (this.delay > 0)
                        {
                            --this.delay;
                            System.out.println(delay);
                            return;
                        }
                        double var4 = (double)this.xCoord + 0.5D;
                        double var6 = (double)this.yCoord + 1D;
                        double var8 = (double)this.zCoord + 0.5D;
                        var2.setLocationAndAngles(var4, var6, var8, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
                        this.writeNBTTagsTo(var2);
                        this.worldObj.spawnEntityInWorld(var2);
                    }
                }
            }

            super.updateEntity();
    }

    public void writeNBTTagsTo(Entity par1Entity)
    {
        if (this.spawnerTags != null)
        {
            NBTTagCompound var2 = new NBTTagCompound();
            par1Entity.addEntityID(var2);
            Iterator var3 = this.spawnerTags.getTags().iterator();

            while (var3.hasNext())
            {
                NBTBase var4 = (NBTBase)var3.next();
                var2.setTag(var4.getName(), var4.copy());
            }

            par1Entity.readFromNBT(var2);
        }
    }

    /**
     * Sets the delay before a new spawn (base delay of 200 + random number up to 600).
     */
    private void updateDelay()
    {
        this.delay = 200 + this.worldObj.rand.nextInt(5000);
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.mobID = par1NBTTagCompound.getString("EntityId");
        this.delay = par1NBTTagCompound.getShort("Delay");

        if (par1NBTTagCompound.hasKey("SpawnData"))
        {
            this.spawnerTags = par1NBTTagCompound.getCompoundTag("SpawnData");
        }
        else
        {
            this.spawnerTags = null;
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setString("EntityId", this.mobID);
        par1NBTTagCompound.setShort("Delay", (short)this.delay);

        if (this.spawnerTags != null)
        {
            par1NBTTagCompound.setCompoundTag("SpawnData", this.spawnerTags);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * will create the entity from the internalID the first time it is accessed
     */
    public Entity getMobEntity()
    {
        if (this.spawnedMob == null)
        {
            Entity var1 = EntityList.createEntityByName(this.getMobID(), (World)null);
            this.writeNBTTagsTo(var1);
            this.spawnedMob = var1;
        }

        return this.spawnedMob;
    }

    /**
     * Overriden in a sign to provide the text.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound var1 = new NBTTagCompound();
        this.writeToNBT(var1);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, var1);
    }
}
