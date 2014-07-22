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

    @SubscribeEvent
    public void onRenderTick(TickEvent.ClientTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
            System.out.println("ClientTick");
            ScaledResolution resolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
            double width = (double) resolution.getScaledWidth();
            double height = (double) resolution.getScaledHeight();

            if (mc.currentScreen == null) {
                ItemStack stack = mc.thePlayer.inventory.armorItemInSlot(3);
                ExtendedPlayerSCP props = (ExtendedPlayerSCP) mc.thePlayer.getExtendedProperties(ExtendedPlayerSCP.EXT_PROP_NAME);

                if (mc.gameSettings.thirdPersonView == 0 && stack != null) {
                    if (stack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
                        //renderGasMaskBlur(width, height);
                    }
                }

                if (props.getBlink() >= 0 && props.getBlink() <= 0) {
                    //renderBlink(width, height);
                }
            }
        }
    }


}
