package SCPCraft.entities;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

final class SCP472FilterAttack implements IEntitySelector
{
    public boolean isEntityApplicable(Entity par1Entity)
    {
        return par1Entity instanceof EntityLiving && ((EntityLiving)par1Entity).getSCPAttribute() != SCPEnumCreatureAttribute.SCPObject;
    }
}
