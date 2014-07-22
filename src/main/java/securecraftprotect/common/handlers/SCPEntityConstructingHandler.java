package securecraftprotect.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import securecraftprotect.common.entity.player.ExtendedPlayerSCP;

public class SCPEntityConstructingHandler {
    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            if(ExtendedPlayerSCP.get(player) == null) {
                ExtendedPlayerSCP.register(player);
            }
        }
    }
}
