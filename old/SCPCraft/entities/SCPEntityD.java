package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public abstract class SCPEntityD extends EntityCreature implements IMob
{
    /** How much damage this mob's attacks deal */
    protected int attackStrength = 0;

    public SCPEntityD(World par1World)
    {
        super(par1World);
        this.experienceValue = 0;
		this.getNavigator().setAvoidsWater(true);
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.CLASSD;
    }

	public int getMaxHealth()
	{
		return 30;
	}
    
	protected boolean canDespawn()
	{
		return false;
	}
	
    public void setAttackTarget(EntityLiving par1EntityLiving)
    {
        super.setAttackTarget(par1EntityLiving);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
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
