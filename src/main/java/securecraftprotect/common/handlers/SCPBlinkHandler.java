package securecraftprotect.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import securecraftprotect.common.entity.player.ExtendedPlayerSCP;

public class SCPBlinkHandler {
    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            ExtendedPlayerSCP props = ExtendedPlayerSCP.get(player);
            if (player.isEntityAlive()) {
                props.decreaseBlink(props.getBlinkSpeed());
                if (props.getBlink() <= 0) {
                    System.out.println("Blink");
                    props.setBlink(300);
                }
            }
        }
    }
}
