package securecraftprotect.common;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import securecraftprotect.common.handlers.SCPBlinkHandler;

public class CommonProxy implements IGuiHandler{
    public void init() {
        FMLCommonHandler.instance().bus().register(new SCPBlinkHandler());
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    public int addArmor(String armor) {
        return 0;
    }
}
