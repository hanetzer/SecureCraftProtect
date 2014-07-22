package securecraftprotect.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import securecraftprotect.client.model.ModelSCP0173;
import securecraftprotect.client.renderer.entity.RenderSCP0173;
import securecraftprotect.common.CommonProxy;
import securecraftprotect.common.entity.monster.EntitySCP0173;

public class ClientProxy extends CommonProxy {
    public void init() {
    }

    private void render() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP0173.class,
                new RenderSCP0173(new ModelSCP0173(), 0.5F));
    }

    public int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
