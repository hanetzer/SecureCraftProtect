package SCPCraft.entities;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.potion.PotionEffect;

public class SCPEntity872AI extends EntityAIBase
{
    /** The entity we are attached to */
    private EntityCreature theEntity;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private double distance;
    private int potionID;
    private int potionDuration;
    private int potionAmplifier;

    /** The class of the entity we should avoid */
    private Class targetEntityClass;

    public SCPEntity872AI(EntityCreature par1EntityCreature, Class par2Class, float par3, double dist, int id, int duration, int amplifier)
    {
        this.theEntity = par1EntityCreature;
        this.targetEntityClass = par2Class;
        this.distanceFromEntity = par3;
        this.distance = dist;
        this.potionID = id;
        this.potionDuration = duration;
        this.potionAmplifier = amplifier;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(this.distanceFromEntity < 16D)
    	{
    		return false;
        }
        else
        {
            List var1 = this.theEntity.worldObj.getEntitiesWithinAABB(this.targetEntityClass, this.theEntity.boundingBox.expand((double)this.distanceFromEntity, 5.0D, (double)this.distanceFromEntity));

            if (var1.isEmpty())
            {
                return false;
            }

            this.closestLivingEntity = (Entity)var1.get(0);
        }
        return true;
    }
    
    public void startExecuting()
    {
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.closestLivingEntity = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < distance)
        {
            this.theEntity.addPotionEffect(new PotionEffect(potionID, potionDuration, potionAmplifier));
        }
    }
}
