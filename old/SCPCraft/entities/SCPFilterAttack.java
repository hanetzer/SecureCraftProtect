package SCPCraft.entities;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;

final class SCPFilterAttack implements IEntitySelector
{
    public boolean isEntityApplicable(Entity par1Entity)
    {
        return par1Entity instanceof EntityLiving && !(par1Entity instanceof EntityBat) && !(par1Entity instanceof EntitySquid) && ((EntityLiving)par1Entity).getSCPAttribute() != SCPEnumCreatureAttribute.SCP && ((EntityLiving)par1Entity).getSCPAttribute() != SCPEnumCreatureAttribute.SCPObject;
    }
}
