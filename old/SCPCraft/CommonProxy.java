package SCPCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public void registerRenderInformation()
	{
		//unused server side. -- see ClientProxy for implementation
	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	public World getClientWorld()
	{
		return null;
	}
}
