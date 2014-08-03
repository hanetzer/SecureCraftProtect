package securecraftprotect.common;


import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import securecraftprotect.client.gui.inventory.GuiDocument;
import securecraftprotect.common.inventory.ContainerDocument;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<>();
    public void init() {
        //FMLCommonHandler.instance().bus().register(new SCPBlinkHandler());
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player,
                                      World world, int x, int y, int z) {
        switch (ID) {
            case 0:
                return new ContainerDocument(player.inventory, world, x, y, z);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player,
                                      World world, int x, int y, int z) {
        switch (ID) {
            case 0:
                return new GuiDocument(player.inventory, world, x, y, z);
            default:
                return null;
        }
    }

	public static void storeEntityData(String name, NBTTagCompound compound)
	{
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name)
	{
		return extendedEntityData.remove(name);
	}
    public int addArmor(String armor) {
        return 0;
    }
}
