package securecraftprotect.core;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import securecraftprotect.SCP;
import securecraftprotect.common.entity.boss.EntitySCP0015;
import securecraftprotect.common.entity.monster.EntitySCP0023;
import securecraftprotect.common.entity.monster.EntitySCP0173;
import securecraftprotect.common.entity.passive.EntityClassDMale;
import securecraftprotect.common.entity.passive.EntitySCP0131;
import securecraftprotect.common.entity.projectile.EntitySCP0015Projectile;
import securecraftprotect.common.registry.DocumentRegistry;

public class SCPEntity {
    public static void init() {
        registerSCP(EntitySCP0015.class, "scp:0015",
                EntityRegistry.findGlobalUniqueEntityId(),
                0x000000, 0x000000, 1);
        registerSCP(EntitySCP0015Projectile.class, "scp:0015-p",
                EntityRegistry.findGlobalUniqueEntityId(),
                -1, -1, -1);
        registerSCP(EntitySCP0023.class, "scp:0023",
                EntityRegistry.findGlobalUniqueEntityId(),
                0x000000, 0x000000, 1);
        registerSCP(EntitySCP0131.class, "scp:0131",
                EntityRegistry.findGlobalUniqueEntityId(),
                0xFF0000, 0xFFFF00, 0);
        registerSCP(EntitySCP0173.class, "scp:0173",
                EntityRegistry.findGlobalUniqueEntityId(),
                0xFEF2BF, 0x2BC600, 1);
        registerSCP(EntityClassDMale.class, "scp:classd_male",
                EntityRegistry.findGlobalUniqueEntityId(),
                0xFF6600, 0x000000, -1);
    }

    public static void registerSCP(Class<? extends Entity> scp, String name,
                                   int entityID, int back, int fore,
                                    int level) {
        if (back != -1 && fore != -1) {
            EntityRegistry.registerGlobalEntityID(scp, name, entityID, back, fore);
        } else {
            EntityRegistry.registerGlobalEntityID(scp, name, entityID);
        }
        if (level >= 0) {
            DocumentRegistry.registerDocument(name, level);
        }
        EntityRegistry.registerModEntity(scp, name, entityID+300, SCP.instance(), 80, 3, true);
    }
}
