package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity217Zombie extends SCPEntity
{
	private final EntityAIControlledByPlayer field_82184_d;
	
    public SCPEntity217Zombie(World par1World)
    {
        super(par1World);
        texture = "/SCPCraft/textures/mobs/SCP217/SCPZombie.png";
        moveSpeed = 0.25F;
        attackStrength = 3;
        getNavigator().setBreakDoors(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, this.field_82184_d = new EntityAIControlledByPlayer(this, 0.7F));
        tasks.addTask(3, new EntityAISCP0173Attack(this, SCPEntity217Testificate.class, this.moveSpeed, true));
        tasks.addTask(3, new EntityAISCP0173Attack(this, EntityVillager.class, this.moveSpeed, true));
        tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, moveSpeed));
        tasks.addTask(5, new EntityAIMoveThroughVillage(this, moveSpeed, false));
        tasks.addTask(6, new EntityAIWander(this, moveSpeed));
        tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
        tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, SCPEntity217Testificate.class, 16.0F, 0, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }
    
    public boolean canBeSteered()
    {
        ItemStack var1 = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return var1 == null || var1 != null;
    }
	
	public EntityAIControlledByPlayer func_82183_n()
    {
        return this.field_82184_d;
    }

	protected void updateAITasks()
    {
        super.updateAITasks();
    }
    
    public void onKillEntity(EntityLiving par1EntityLiving)
    {
        super.onKillEntity(par1EntityLiving);

        if (this.worldObj.difficultySetting >= 1)
        {
            if (par1EntityLiving instanceof SCPEntity217Testificate && this.rand.nextBoolean())
            {
            	SCPEntity217Zombie var2 = new SCPEntity217Zombie(this.worldObj);
            	var2.func_82149_j(par1EntityLiving);
            	this.worldObj.removeEntity(par1EntityLiving);
            	var2.initCreature();
            	this.worldObj.spawnEntityInWorld(var2);
            	this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
            if (par1EntityLiving instanceof EntityVillager && this.rand.nextBoolean())
            {
            	SCPEntity217Zombie var2 = new SCPEntity217Zombie(this.worldObj);
                var2.func_82149_j(par1EntityLiving);
                this.worldObj.removeEntity(par1EntityLiving);
                var2.initCreature();

                this.worldObj.spawnEntityInWorld(var2);
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }
    }

    public int getMaxHealth()
    {
        return 40;
    }

    protected Entity findPlayerToAttack()
    {
    	return null;
    }
    
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
    }
    
	public boolean attackEntityAsMob(Entity par1Entity)
	{
        int var2 = this.attackStrength;
		if(!(par1Entity instanceof EntityPlayer))return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
		else return false;
	}

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        return 3;
    }
    
    public double getMountedYOffset()
	{
		return (double)height * 1.3199999999999999D - 0.5D;
	}

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
    	return true;
    }
    
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (super.interact(par1EntityPlayer))
        {
            return true;
        }
        else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
        {
            par1EntityPlayer.mountEntity(this);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.zombie";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombiehurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombiedeath";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.ingotIron.itemID;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void dropRareDrop(int par1)
    {
        switch (rand.nextInt(2))
        {
            case 0:
                dropItem(mod_SCP.Wrench.itemID, 1);
                break;

            case 1:
                dropItem(Item.ingotIron.itemID, 1);
                break;
        }
    }
}
