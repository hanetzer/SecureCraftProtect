package securecraftprotect.common.handlers.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import securecraftprotect.common.entity.player.ExtendedPlayerSCP;

public class SyncPlayerPropertiesPacket extends AbstractPacket
{
	private NBTTagCompound data;

	public SyncPlayerPropertiesPacket() {}

	public SyncPlayerPropertiesPacket(EntityPlayer player) {
		data = new NBTTagCompound();
		ExtendedPlayerSCP.get(player).saveNBTData(data);
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		ByteBufUtils.writeTag(buffer, data);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		data = ByteBufUtils.readTag(buffer);
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		ExtendedPlayerSCP.get(player).loadNBTData(data);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {}
}
