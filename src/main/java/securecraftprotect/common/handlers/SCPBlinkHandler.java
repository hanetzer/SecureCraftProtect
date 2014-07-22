package securecraftprotect.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import securecraftprotect.common.entity.player.ExtendedPlayerSCP;

public class SCPBlinkHandler {

    @SubscribeEvent
    public void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
        if (event.player != null) {
            EntityPlayer player = event.player;
            ExtendedPlayerSCP props = ExtendedPlayerSCP.get(player);
            if (player.isEntityAlive()) {
                props.decreaseBlink(props.getBlinkSpeed());
                if (props.getBlink() <= 0) {
                    props.setBlink(300);
                }
            }
        }
    }
}

