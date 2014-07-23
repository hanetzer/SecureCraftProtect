package securecraftprotect;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import securecraftprotect.common.CommonProxy;
import securecraftprotect.common.creativetab.SCPTileTab;
import securecraftprotect.common.handlers.SCPEventHandler;
import securecraftprotect.core.SCPEntity;
import securecraftprotect.core.SCPItem;
import securecraftprotect.core.SCPTile;

//import cpw.mods.fml.common.network.NetworkRegistry;
@SuppressWarnings("unused")
@Mod(modid = "scp", name = "SecureCraftProtect", version = "@VERSION@")
public class SCP {
    @Mod.Instance("scp")
    private static SCP instance;
    public static SCP instance() {
        return instance;
    }
    @SidedProxy(
            clientSide = "securecraftprotect.client.ClientProxy",
            serverSide = "securecraftprotect.common.CommonProxy")
    public static CommonProxy proxy;
    public static CreativeTabs scpTile;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
        scpTile = new SCPTileTab(CreativeTabs.getNextID(), "scpTile");
        SCPEventHandler.init();
        SCPItem.init();
        SCPTile.init();
        SCPEntity.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }
}
