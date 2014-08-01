package securecraftprotect.common.handlers;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class SCPEventHandler {
    public static void init() {
        registerEntityEventHandler();
    }

    private static void registerEntityEventHandler() {
        //MinecraftForge.EVENT_BUS.register(new SCPEntityConstructingHandler());
        //MinecraftForge.EVENT_BUS.register(new SCPBlinkHandler());
        //FMLCommonHandler.instance().bus().register(new SCPBlinkHandler());
    }
}
