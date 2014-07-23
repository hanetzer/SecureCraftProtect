package securecraftprotect.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import securecraftprotect.client.gui.SCPGuiBlink;
import securecraftprotect.client.handlers.SCPBlinkRenderHandler;
import securecraftprotect.client.model.ModelSCP0173;
import securecraftprotect.client.renderer.entity.RenderSCP0173;
import securecraftprotect.common.CommonProxy;
import securecraftprotect.common.entity.monster.EntitySCP0173;
import securecraftprotect.common.handlers.SCPBlinkHandler;
import securecraftprotect.common.handlers.SCPInputHandler;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();
        render();
        MinecraftForge.EVENT_BUS.register(new SCPGuiBlink());
        FMLCommonHandler.instance().bus().register(new SCPInputHandler());
    }


    private void render() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP0173.class,
                new RenderSCP0173(new ModelSCP0173(), 0.5F));
    }

    public int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
