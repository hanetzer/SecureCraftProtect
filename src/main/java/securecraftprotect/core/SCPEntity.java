package securecraftprotect.core;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import securecraftprotect.SCP;
import securecraftprotect.common.entity.monster.EntitySCP0173;
import securecraftprotect.common.entity.passive.EntitySCP0131;

public class SCPEntity {
    public static void init() {
        registerSCP(EntitySCP0173.class, "scp:0173",
                EntityRegistry.findGlobalUniqueEntityId(), 0xFEF2BF, 0x2BC600);
        registerSCP(EntitySCP0131.class, "scp:0131",
                EntityRegistry.findGlobalUniqueEntityId(), 0xFF0000, 0xFFFF00);
        registerSCP(securecraftprotect.common.entity.passive.EntityClassDMale.class, "scp:classd_male",
                EntityRegistry.findGlobalUniqueEntityId(), 0xFF6600, 0x000000);
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
