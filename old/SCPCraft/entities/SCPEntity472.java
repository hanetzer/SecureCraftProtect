package SCPCraft.entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.SCPDamageSource;
import SCPCraft.SCPPotion;

public class SCPEntity472 extends SCPEntity
{
    private static final IEntitySelector field_82219_bJ = new SCP472FilterAttack();
	int time;
	public SCPEntity472(World par1World)
	{	
		super(par1World);
		setSize(0.3F, 0.3F);
		texture = "/SCPCraft/textures/mobs/472.png";
		moveSpeed = 0.0F;
		attackStrength = 0;
		isImmuneToFire = true;
		time = 0;
	}
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCPObject;
    }

	protected String getLivingSound()
	{
		return "mob.villager.default";
	}
    
    public void targetLivings()
    {
    }
	
	public int getTalkInterval()
	{
		return 0;
	}

    protected Entity findPlayerToAttack()
    {
    	return null;
    }
    
    public void onCollideWithPlayer(EntityPlayer par1Entityvar4)
    {
    }
    
	protected float getSoundVolume()
	{
		return 1F;
	}

	public int getMaxHealth()
	{
		return 9001;
	} 

	public boolean isAIEnabled()
	{
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return false;
	}
    
	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(16, new Byte((byte)0));
	}

	public void onLivingUpdate()
	{
		this.rotationPitch = 0F;
		this.rotationYaw = 0F;
		if(time%50 == 0)this.worldObj.playSoundAtEntity(this, "sounds.heartbeat", 1F, 1F);
		time++;
    	List var5 = this.worldObj.selectEntitiesWithinAABB(EntityLiving.class, this.boundingBox.expand((double)9F, 4.0D, (double)9F), field_82219_bJ);		
		EntityPlayer player = worldObj.getClosestPlayerToEntity(this, 256D);
        Iterator var2 = var5.iterator();
        while (var2.hasNext())
        {
            Entity var3 = (Entity)var2.next();
            EntityLiving var4 = (EntityLiving)var3;
            if (var4 != null)
            {
            	if(this.livingSoundTime == 0)var4.increaseExposure(1);
            	if(var4.getExposure() >= 0 && var4.getExposure() <= 15)var4.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 0));
            	if(var4.getExposure() >= 16 && var4.getExposure() <= 30){
            		var4.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 300, 0));
            		var4.addPotionEffect(new PotionEffect(SCPPotion.shake.id, 300, 0));
            		var4.addPotionEffect(new PotionEffect(SCPPotion.bloodStone.id, 300, 0)); 
            		worldObj.updateEntity(var4);
            	}
            	if(var4.getExposure() >= 31 && var4.getExposure() <= 50){
            		var4.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3600, 0));
            		var4.addPotionEffect(new PotionEffect(Potion.confusion.id, 3600, 0));
            		var4.addPotionEffect(new PotionEffect(SCPPotion.bloodStone.id, 3600, 1));
            		worldObj.updateEntity(var4);
            	}
            	if(var4.getExposure() >= 51 && var4.getExposure() <= 68){
            		var4.removePotionEffect(Potion.moveSlowdown.id);
            		var4.addPotionEffect(new PotionEffect(Potion.confusion.id, 10800, 0));
            		var4.addPotionEffect(new PotionEffect(Potion.blindness.id, 10800, 1));
            		var4.addPotionEffect(new PotionEffect(SCPPotion.bloodStone.id, 10800, 2));
            		worldObj.updateEntity(var4);
            	}
            	if(var4.getExposure() >= 69 && var4.getExposure() <= 79){
            		var4.removePotionEffect(Potion.blindness.id);
            		var4.addPotionEffect(new PotionEffect(Potion.confusion.id, 86400, 1));
            		var4.addPotionEffect(new PotionEffect(Potion.blindness.id, 86400, 0));
            		var4.addPotionEffect(new PotionEffect(SCPPotion.bloodStone.id, 86400, 2)); 
            		if(rand.nextInt(20) == 0)worldObj.playSoundEffect((double)((float)var4.posX + 0.5F), (double)((float)var4.posY + 0.5F), (double)((float)var4.posZ + 0.5F), "sounds.whispers", 0.5F, 1F);
            		worldObj.updateEntity(var4);
            	}
            	if(var4.getExposure() >= 80){
            		var4.removePotionEffect(Potion.blindness.id);
            		var4.addPotionEffect(new PotionEffect(Potion.confusion.id, 86400, 1));
            		var4.addPotionEffect(new PotionEffect(Potion.blindness.id, 86400, 0));
            		var4.addPotionEffect(new PotionEffect(SCPPotion.bloodStone.id, 86400, 2)); 
            		if(rand.nextInt(20) == 0)worldObj.playSoundEffect((double)((float)var4.posX + 0.5F), (double)((float)var4.posY + 0.5F), (double)((float)var4.posZ + 0.5F), "sounds.whispers", 0.5F, 1F);
            		var4.attackEntityFrom(SCPDamageSource.bloodstone, 1);
            		worldObj.updateEntity(var4);
            	}	
            }
            if(var4.isDead)var4.setExposure(0);
        }
        if(player != null && this.getDistanceSqToEntity(player)>81D)if(player.getExposure()>0 && rand.nextInt(20)==0)player.increaseExposure(-1);
        this.motionX = 0D;
		this.motionZ = 0D;
		super.onLivingUpdate();
	}

	public void onUpdate()
	{
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
