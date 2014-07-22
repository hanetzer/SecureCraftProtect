package securecraftprotect.core;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import securecraftprotect.SCP;
import securecraftprotect.common.entity.monster.EntitySCP0173;

public class SCPEntity {
    public static void init() {
        registerSCP(EntitySCP0173.class, "scp:0173",
                EntityRegistry.findGlobalUniqueEntityId(), 0xFEF2BF, 0x2BC600);
    }

    public static void registerSCP(Class<? extends Entity> klazz, String name,
                                   int ID, int back, int fore) {
        if (back != -1 && fore != -1) {
            EntityRegistry.registerGlobalEntityID(klazz, name, ID, back, fore);
        } else {
            EntityRegistry.registerGlobalEntityID(klazz, name, ID);
        }
        EntityRegistry.registerModEntity(klazz, name, ID+300, SCP.instance(), 80, 3, true);
    }
}
