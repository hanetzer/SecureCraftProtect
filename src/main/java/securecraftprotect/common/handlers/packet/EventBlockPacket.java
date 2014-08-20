package securecraftprotect.common.handlers.packet;

import securecraftprotect.common.tileentity.TileEntityEventBlock;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class EventBlockPacket implements IMessage, IMessageHandler<EventBlockPacket, IMessage>
{
    String direction;
    int dimID, x, y, z;
    
    public EventBlockPacket()
    {
    }
    
    public EventBlockPacket(String direction, TileEntity tile)
    {
        this.direction = direction;
        dimID = tile.getWorld().provider.dimensionId;
        x = tile.xCoord;
        y = tile.yCoord;
        z = tile.zCoord;
    }
    
    @Override
    public void fromBytes(ByteBuf buf)
    {
        direction = ByteBufUtils.readUTF8String(buf);
        dimID = buf.readInt();
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
    }
    
    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, direction);
        buf.writeInt(dimID);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }
    
    @Override
    public IMessage onMessage(EventBlockPacket message, MessageContext ctx)
    {
        TileEntityEventBlock tile = (TileEntityEventBlock) MinecraftServer.getServer().worldServers[message.dimID].getTileEntity(message.x, message.y, message.z);
        
        tile.setTexture(message.direction);
        
        tile.isDirty = true;
        tile.markDirty();
        
        return null;
    }
}
