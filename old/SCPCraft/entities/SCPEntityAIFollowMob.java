package SCPCraft.entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class SCPEntityAIFollowMob extends EntityAIBase
{
    private EntityLiving theEntity;
    private EntityLiving theMob;
    private EntityLiving choosenMob;
    private int field_48402_c;
    private boolean field_48400_d;

    public SCPEntityAIFollowMob(EntityLiving entityliving, EntityLiving entitymob)
    {
        field_48400_d = false;
        theEntity = entityliving;
        choosenMob = entitymob;
        setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!theEntity.worldObj.isDaytime())
        {
            return false;
        }

        List list = theEntity.worldObj.getEntitiesWithinAABB(EntityLiving.class, theEntity.boundingBox.expand(6D, 2D, 6D));

        if (list.size() == 0)
        {
            return false;
        }

        Iterator iterator = list.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            theMob = choosenMob;
            break;
        }
        while (true);

        return theMob != null;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return theMob.getHealth() > 0;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        field_48402_c = theEntity.getRNG().nextInt(320);
        field_48400_d = false;
        theMob.getNavigator().clearPathEntity();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        theMob = null;
        theEntity.getNavigator().clearPathEntity();
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        theEntity.getLookHelper().setLookPositionWithEntity(theMob, 30F, 30F);

        if (theMob.getHealth() == field_48402_c)
        {
            theEntity.getNavigator().tryMoveToEntityLiving(theMob, 0.15F);
            field_48400_d = true;
        }

        if (field_48400_d && theEntity.getDistanceSqToEntity(theMob) < 4D)
        {
            theEntity.getNavigator().clearPathEntity();
        }
    }
}
