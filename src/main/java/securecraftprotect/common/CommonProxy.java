package securecraftprotect.common;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import securecraftprotect.client.gui.inventory.GuiDocument;
import securecraftprotect.common.handlers.SCPBlinkHandler;
import securecraftprotect.common.inventory.ContainerDocument;

public class CommonProxy implements IGuiHandler{
    public void init() {
        FMLCommonHandler.instance().bus().register(new SCPBlinkHandler());
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

    public int addArmor(String armor) {
        return 0;
    }
}
