package SCPCraft.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import SCPCraft.containerslots.SCPContainer261;
import SCPCraft.containerslots.SCPContainer294;
import SCPCraft.containerslots.SCPContainer914;
import SCPCraft.tileentities.SCPTileEntity261;
import SCPCraft.tileentities.SCPTileEntity294;
import SCPCraft.tileentities.SCPTileEntity914;
import cpw.mods.fml.common.network.IGuiHandler;

public class SCPGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if (tileEntity instanceof SCPTileEntity914 && ID == 0) 
		{
			return new SCPContainer914(player.inventory, (SCPTileEntity914) tileEntity);
		}
		else if(tileEntity instanceof SCPTileEntity261 && ID == 1) 
		{
			return new SCPContainer261(player.inventory, (SCPTileEntity261) tileEntity);
		}
		else if(tileEntity instanceof SCPTileEntity294 && ID == 2) 
		{
			return new SCPContainer294(player.inventory, (SCPTileEntity294) tileEntity);
		}
		else if(ID == 3)
		{
			return new SCPGuiSCP294(player.inventory, (SCPTileEntity294)tileEntity);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if (tileEntity instanceof SCPTileEntity914 && ID == 0) {
			return new SCPGuiSCP914(player.inventory, (SCPTileEntity914) tileEntity);
		}
		else if(tileEntity instanceof SCPTileEntity261 && ID == 1) {
			return new SCPGuiSCP261(player.inventory, (SCPTileEntity261) tileEntity);
		}
		else if(tileEntity instanceof SCPTileEntity294 && ID == 2) {
			return new SCPGuiSCP294(player.inventory, (SCPTileEntity294) tileEntity);
		}
		else if(ID == 3)
		{
			return new SCPGuiSCP294(player.inventory, (SCPTileEntity294)tileEntity);
		}
		
		return null;
	}

}
