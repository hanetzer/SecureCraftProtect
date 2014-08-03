package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;

public class SCPEntity538 extends SCPEntity
{
    public SCPEntity538(World par1World)
    {
        super(par1World);
        setSize(0.6F, 0.4F);
        texture = "/SCPCraft/textures/mobs/SCP538.png";
		moveSpeed = 0.8F;
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAISCP0173Attack(this, 0.25F, false));
		tasks.addTask(2, new EntityAIWander(this, 0.2F));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 4F));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		tasks.addTask(4, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16F, 0, true));
    }

    public int getMaxHealth()
    {
        return 16;
    }    

	public boolean isAIEnabled()
	{
		return true;
	}

    public float spiderScaleAmount()
    {
        return 0.4F;
    }
    
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		int dmg = 1;			
		if(worldObj.difficultySetting == 1){
			dmg = 2;
		}
		else if(worldObj.difficultySetting == 2){
			dmg = 4;
		}
		else if (worldObj.difficultySetting == 3){
			dmg = 6;
		}			
		par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), dmg);

		return true;
	}
    
    public void playLivingSound()
    {
        String s = getLivingSound();

        if (s != null)
        {
            worldObj.playSoundAtEntity(this, s, 0.5F, 2.0F);
        }
    }
    
    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)0));
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

        if (!worldObj.isRemote)
        {
            func_40148_a(isCollidedHorizontally);
        }
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getMountedYOffset()
    {
        return (double)height * 0.75D - 0.5D;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        double d = 16D;
        return worldObj.getClosestVulnerablePlayerToEntity(this, d);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.spider";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.spider";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.spiderdeath";
    }
  
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    public boolean isOnLadder()
    {
        return func_40149_l_();
    }

    /**
     * Sets the Entity inside a web block.
     */
    public void setInWeb()
    {
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean isPotionApplicable(PotionEffect par1PotionEffect)
    {
        if (par1PotionEffect.getPotionID() == Potion.poison.id)
        {
            return false;
        }
        if (par1PotionEffect.getPotionID() == SCPPotion.crystal.id)
        {
            return false;
        }
        else
        {
            return super.isPotionApplicable(par1PotionEffect);
        }
    }
    
	protected boolean canDespawn()
	{
		return false;
	}

    public boolean func_40149_l_()
    {
        return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_40148_a(boolean par1)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            byte0 |= 1;
        }
        else
        {
            byte0 &= 0xfe;
        }

        dataWatcher.updateObject(16, Byte.valueOf(byte0));
    }
}
