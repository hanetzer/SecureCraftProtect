package SCPCraft.entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public abstract class SCPEntity extends EntityCreature
{
    /** How much damage this mob's attacks deal */
    protected int attackStrength = 0;
    private static final IEntitySelector field_82219_bJ = new SCPFilterAttack();

    public SCPEntity(World par1World)
    {
        super(par1World);
        this.experienceValue = 5;
        this.renderDistanceWeight = 10.0D;
		attackStrength = 6;
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 16.0F, 0, false, false, field_82219_bJ));
    }
    
    public void targetLivings()
    {
    	List<?> var5 = this.worldObj.selectEntitiesWithinAABB(EntityLiving.class, this.boundingBox.expand((double)16F, 4.0D, (double)16F), field_82219_bJ);
        Iterator<?> var2 = var5.iterator();

        while (var2.hasNext())
        {
            Entity var3 = (Entity)var2.next();
            EntityLiving var4 = (EntityLiving)var3;

            if (var4 != null)
            {
                entityToAttack = var4;
            }
        }
    }
    
	protected boolean canDespawn()
	{
		return false;
	}
	
    public void setAttackTarget(EntityLiving par1EntityLiving)
    {
        super.setAttackTarget(par1EntityLiving);
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        targetLivings();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return var1 != null && this.canEntityBeSeen(var1) ? var1 : null;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        if (super.attackEntityFrom(par1DamageSource, par2))
        {
            Entity var3 = par1DamageSource.getEntity();

            if (this.riddenByEntity != var3 && this.ridingEntity != var3)
            {
                if (var3 != this)
                {
                    this.entityToAttack = var3;
                }

                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
    
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
        if(this.getSCPAttribute() != SCPEnumCreatureAttribute.SCPObject)par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), attackStrength);
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        int var2 = this.attackStrength;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float getBlockPathWeight(int par1, int par2, int par3)
    {
        return 0.5F - this.worldObj.getLightBrightness(par1, par2, par3);
    }
    
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

        if (var2 != null && var2.itemID == mod_SCP.SCP1023ARC.itemID)
        {
            this.setDead();
            this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + (double)(this.height / 2.0F), this.posZ, 0.0D, 0.0D, 0.0D);
            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }
}
