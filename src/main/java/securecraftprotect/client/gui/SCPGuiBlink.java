package securecraftprotect.client.gui;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import securecraftprotect.util.Globals;

import static org.lwjgl.opengl.GL11.*;

@SuppressWarnings("unused")
public class SCPGuiBlink extends Gui {
    private static final ResourceLocation icons = new ResourceLocation("scp:textures/gui/icons.png");
    private static Minecraft mc = Minecraft.getMinecraft();
    protected static final ResourceLocation blink = new ResourceLocation("scp:textures/misc/blink.png");
    protected static final ResourceLocation gasMask = new ResourceLocation("scp:textures/misc/gasmask.png");


    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderExperienceBar(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            return;
        }
        int width = event.resolution.getScaledWidth();
        int height = event.resolution.getScaledHeight();

        int k2 = height - 20;
        int blink = mc.thePlayer.getDataWatcher().getWatchableObjectInt(Globals.BLINK);
        int i4 = width /2 +91;
        int var26 = MathHelper.ceiling_double_int((double)(blink + 2) * 10.0D / Globals.MAX_BLINK);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        glDisable(GL_LIGHTING);
        mc.getTextureManager().bindTexture(icons);
        drawTexturedModalRect(i4 - 281, k2 - 1, 0, 18, 83, 11);
        drawTexturedModalRect(i4 - 301, k2 -1, 83, 18, 17, 11);
        for (int i = 0; i < 10; ++i) {
            if (i < var26) {
                drawTexturedModalRect(i4 + i * 8 - 280, k2, 100, 18, 9, 9);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderPumpkin(RenderGameOverlayEvent event) {
        double width = event.resolution.getScaledWidth();
        double height = event.resolution.getScaledHeight();
        int blink = mc.thePlayer.getDataWatcher().getWatchableObjectInt(Globals.BLINK);
        if (blink >= 0 && blink <= 10) {
            renderBlink(width, height);
        }
    }

    @SideOnly(Side.CLIENT)
    private static void renderGasMaskBlur(double width, double height) {
        glDisable(GL_DEPTH_TEST);
        glDepthMask(false);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        glDisable(GL_ALPHA_TEST);
        mc.getTextureManager().bindTexture(gasMask);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, height, -90D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(width, height, -90D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(width, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.draw();
        glDepthMask(true);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_ALPHA_TEST);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    private static void renderBlink(double width, double height) {
        glDisable(GL_DEPTH_TEST);
        glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        glDisable(GL_ALPHA_TEST);
        mc.getTextureManager().bindTexture(blink);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, height, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(width, height, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(width, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        glDepthMask(true);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_ALPHA_TEST);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
