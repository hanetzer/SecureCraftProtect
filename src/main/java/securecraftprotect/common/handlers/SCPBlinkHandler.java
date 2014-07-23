package securecraftprotect.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;

public class SCPBlinkHandler {

    @SubscribeEvent
    public void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
        if (event.player != null) {
            EntityPlayer player = event.player;
            if (player.isEntityAlive()) {
                int blink = player.getDataWatcher().getWatchableObjectInt(20);
                player.getDataWatcher().updateObject(20, blink - 2);
                if (player.getDataWatcher().getWatchableObjectInt(20) <= 0) {
                    player.getDataWatcher().updateObject(20, 300);
                }
            }
        }
    }
}
