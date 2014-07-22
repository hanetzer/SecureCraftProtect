package securecraftprotect.client.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import securecraftprotect.common.entity.player.ExtendedPlayerSCP;

import static org.lwjgl.opengl.GL11.*;

public class SCPBlinkRenderHandler {
    private Minecraft mc = Minecraft.getMinecraft();
    protected static final ResourceLocation blink = new ResourceLocation("%blur%scp:textures/misc/blink.png");
    protected static final ResourceLocation gasMask = new ResourceLocation("%blur%scp:textures/misc/gasmask.png");

    @SubscribeEvent
    public void onRenderTick(TickEvent.ClientTickEvent event) {
            if(event.phase == TickEvent.Phase.END) {
                ScaledResolution resolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                double width  = (double)resolution.getScaledWidth();
                double height = (double)resolution.getScaledHeight();

                if(mc.currentScreen == null) {
                    ItemStack stack = mc.thePlayer.inventory.armorItemInSlot(3);
                    ExtendedPlayerSCP props = (ExtendedPlayerSCP) mc.thePlayer.getExtendedProperties(ExtendedPlayerSCP.EXT_PROP_NAME);

                    if(mc.gameSettings.thirdPersonView == 0 && stack != null) {
                        if(stack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
                            renderGasMaskBlur(width, height);
                        }
                    }

                    if(props.getBlink() >= 0 && props.getBlink() <= 0) {
                        renderBlink(width, height);
                    }
                }
        }
    }

    private void renderGasMaskBlur(double width, double height) {
        glDisable(GL_DEPTH_TEST);
        glDepthMask(false);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        glDisable(GL_ALPHA_TEST);
        mc.getTextureManager().bindTexture(gasMask);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D,  height, -90D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(width, height, -90D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(width, 0.0D,   -90D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D,  0.0D,   -90D, 0.0D, 0.0D);
        tessellator.draw();
        glDepthMask(true);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_ALPHA_TEST);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void renderBlink(double width, double height) {
        System.out.println("Rendering blink");
        //glPushMatrix();
        glDisable(GL_DEPTH_TEST);
        glDepthMask(false);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        glDisable(GL_ALPHA_TEST);
        mc.getTextureManager().bindTexture(blink);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D,  height, -90D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(width, height, -90D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(width, 0.0D,   -90D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D,  0.0D,   -90D, 0.0D, 0.0D);
        tessellator.draw();
        glDepthMask(true);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_ALPHA_TEST);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //glPopMatrix();
    }
}
