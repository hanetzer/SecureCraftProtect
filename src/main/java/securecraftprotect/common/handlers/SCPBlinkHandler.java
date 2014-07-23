package securecraftprotect.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import securecraftprotect.util.Globals;

public class SCPBlinkHandler {

    @SubscribeEvent
    public void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
        if (event.player != null) {
            EntityPlayer player = event.player;
            if (player.isEntityAlive()) {
                int blink = player.getDataWatcher().getWatchableObjectInt(Globals.BLINK);
                player.getDataWatcher().updateObject(Globals.BLINK, blink - 2);
                if (player.getDataWatcher().getWatchableObjectInt(Globals.BLINK) <= 0) {
                    player.getDataWatcher().updateObject(Globals.BLINK, Globals.MAX_BLINK);
                }
            }
        }
    }
}
