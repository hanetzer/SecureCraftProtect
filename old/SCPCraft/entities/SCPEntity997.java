package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class SCPEntity997 extends SCPEntity
{
    public SCPEntity997(World par1World)
    {	
        super(par1World);
        setSize(0.3F, 0.7F);
        texture = "/SCPCraft/textures/mobs/997.png";
		moveSpeed = 0.0F;
		attackStrength = 0;
		getNavigator().setAvoidsWater(true);
		isImmuneToFire = true;
    }

    public int getMaxHealth()
    {
        return 9001;
    } 
    
    public void targetLivings()
    {
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCPObject;
    }   

	public boolean isAIEnabled()
	{
		return false;
	}

    protected Entity findPlayerToAttack()
    {
    	return null;
    }
    
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
    }
	
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        return false;
    }
    
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return false;
	}
    
    public void playLivingSound()
    {
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
    	this.motionX = 0D;
    	this.motionZ = 0D;
        super.onLivingUpdate();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	this.rotationPitch = 0F;
    	this.rotationYaw = 0F;
        super.onUpdate();
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
    
	protected boolean canDespawn()
	{
		return false;
	}
}
