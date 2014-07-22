package securecraftprotect.common.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLiving;
//import net.minecraft.entity.passive.EntityBat;
//import net.minecraft.entity.passive.EntitySquid;
//import securecraftprotect.common.entity.monster.SCPEntity;

public final class SCPFilterAttack implements IEntitySelector {
    public boolean isEntityApplicable(Entity entity) {
        //if (entity instanceof EntityLiving) {
            //if (!(entity instanceof EntityBat)) {
                //if (!(entity instanceof EntitySquid)) {
                    //if (((EntityLiving) entity).getSCPAttribute() != SCPEntity.SCPEnumCreatureAttribute.SCP) {
                        //if (((EntityLiving) entity).getSCPAttribute() != SCPEntity.SCPEnumCreatureAttribute.SCPObject) {
                            //return true;
                        //}
                    //}
                //}
            //}
        //}
        return false;
    }
}
