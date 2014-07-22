package securecraftprotect.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import securecraftprotect.common.entity.passive.ExtendedAnimalSCP;
import securecraftprotect.common.entity.player.ExtendedPlayerSCP;

public class SCPEntityConstructingHandler {
    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if(event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            if(ExtendedPlayerSCP.get(player) == null) {
                ExtendedPlayerSCP.register(player);
            }
        } else if(event.entity instanceof EntityAnimal) {
            EntityAnimal animal = (EntityAnimal) event.entity;
            if(ExtendedAnimalSCP.get(animal) == null) {
                ExtendedAnimalSCP.register(animal);
            }
        }
    }
}
