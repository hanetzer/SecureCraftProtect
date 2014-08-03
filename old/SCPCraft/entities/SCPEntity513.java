package SCPCraft.entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity513 extends SCPEntity
{ 
    private static final IEntitySelector field_82219_bJ = new SCPFilterAttack();
    public SCPEntity513(World par1World)
    {
        super(par1World); 
        setSize(0.6F, 2.0F);
        isImmuneToFire = true;
        attackStrength = 0;
    }

    public int getMaxHealth()
    {
        return 9001;
    }
        
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {        
    }
    
    public void targetLivings()
    {
    	List<?> var5 = this.worldObj.selectEntitiesWithinAABB(EntityLiving.class, this.boundingBox.expand((double)16F, 4.0D, (double)16F), field_82219_bJ);
        Iterator<?> var2 = var5.iterator();

        while (var2.hasNext())
        {
            Entity var3 = (Entity)var2.next();
            EntityPlayer var4 = (EntityPlayer)var3;

            if (var4 != null && var4.hasEntityHeard513() == true)
            {
                entityToAttack = var4;
            }
        }
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
    
    public boolean attackEntityAsMob(Entity par1Entity)
    {        
        return false;
    }
    
    protected float getSoundVolume()
    {
        return 0F;
    }
    
    protected boolean canDespawn()
	{
		return false;
	}
    
    protected boolean canDamagePlayer()
    {
        return false;
    }

    protected void playStepSound(int par1, int par2, int par3, int par4)
    {        
    }
 
    public void onLivingUpdate()
    {    	
        ChunkCoordinates var2 = worldObj.getSpawnPoint();
    	if(rand.nextInt(200) == 0 ) texture = "/SCPCraft/textures/mobs/513.png";
    	else texture = "/SCPCraft/textures/mobs/513B.png";
        if (entityToAttack != null)
        {
            this.faceEntity(entityToAttack, 10.0F, 20.0F);
        }
        if(entityToAttack != null && this.getDistanceToEntity(entityToAttack) > 15D)
        {
        	this.setPosition(entityToAttack.posX, entityToAttack.posY, entityToAttack.posZ);
       	}
        if(entityToAttack != null && ((EntityPlayer)entityToAttack).getBlink() >= 0 && ((EntityPlayer)entityToAttack).getBlink() <= 5)
        {
        	this.setPosition(entityToAttack.posX, entityToAttack.posY, entityToAttack.posZ);
       	}
        if(entityToAttack != null)
        {
        	if(entityToAttack.isDead && entityToAttack instanceof EntityPlayer)this.setPosition(var2.posX, var2.posY, var2.posZ);
        }this.despawnEntity();
    	super.onLivingUpdate();
    }
    
    protected void attackEntity(Entity par1Entity, float par2)
    {
        return;
    }
    
    public boolean canBeCollidedWith()
    {
        return false;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}
}
