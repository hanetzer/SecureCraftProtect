package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.CoroAI.PFQueue;

public class SCPEntity049 extends SCPEntity
{
	public boolean isAggro = false;

	public SCPEntity049(World par1World)
	{
		super(par1World);
		PFQueue.canUseLadder = true;
		this.texture = "/SCPCraft/textures/mobs/049.png";
	}

	public int getMaxHealth()
	{
		return 30;
	}

	protected void attackEntity(Entity par1Entity, float par2)
	{
		return;
	}
    
    public void targetLivings()
    {
    }

	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{    
		if (isAggro)
		{
			if (par1EntityPlayer instanceof EntityLiving)
			{
				byte var2 = 0;
				if (this.worldObj.difficultySetting == 1) var2 = 3;
				else if (this.worldObj.difficultySetting == 2) var2 = 7;
				else if (this.worldObj.difficultySetting == 3) var2 = 15;

				if (var2 > 0)
				{
					((EntityLiving)par1EntityPlayer).addPotionEffect(new PotionEffect(Potion.wither.id, var2 * 20, 0));
				}
				par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), 1);
			}
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{        
		return false;
	}

	protected boolean canDamagePlayer()
	{
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		Entity var3 = par1DamageSource.getEntity();
		if (var3 instanceof EntityPlayer)
		{
			isAggro = true;
			entityToAttack = var3;
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	protected Entity findPlayerToAttack()
	{
		return entityToAttack;
	}

	public boolean interact(EntityPlayer entityplayer)
	{
		ItemStack var2 = entityplayer.inventory.getCurrentItem();        

		if (var2 != null && var2.itemID == mod_SCP.SCP427.itemID)
		{
			((entityplayer)).triggerAchievement(mod_SCP.Healer);
			if(!worldObj.isRemote)
			{
				this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D).addChatMessage("\u00a7lVillager: \u00a7rDamn You.");
			}
			this.setDead();
			this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + (double)(this.height / 2.0F), this.posZ, 0.0D, 0.0D, 0.0D);
			if (--var2.stackSize <= 0)
			{
				entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
			}
			if (!this.worldObj.isRemote)
			{
				EntityVillager var3 = new EntityVillager(this.worldObj);
				var3.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
				var3.setEntityHealth(this.getHealth());
				var3.renderYawOffset = this.renderYawOffset;
				this.worldObj.spawnEntityInWorld(var3);
			}

			return true;
		}
		else
		{
			return super.interact(entityplayer);
		}
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		int q = rand.nextInt(8);
		for (int j = 0; j < 0.000000000000000000000000001; j++)
		{			
			if(entityplayer != null && rand.nextInt(400) == 0 && this.getDistanceToEntity(entityplayer) < 3F)
			{
				if(q == 1)entityplayer.addChatMessage("\u00a7lSCP-049: \u00a7rWhat is this place?");
				if(q == 2)entityplayer.addChatMessage("\u00a7lSCP-049: \u00a7rHello you marvelous sir!");
				if(q == 3)entityplayer.addChatMessage("\u00a7lSCP-049: \u00a7rMy cure is the most effective, doctor!");
				if(q == 4)entityplayer.addChatMessage("\u00a7lSCP-049: \u00a7rThe Pestilence is here, and I can sense it.");
				if(q == 5)entityplayer.addChatMessage("\u00a7lSCP-049: \u00a7rIt is my duty in life to rid the world of the Great Pestilence.");
				if(q == 6)entityplayer.addChatMessage("\u00a7lSCP-049: \u00a7rI assume you are also a doctor?");
				if(q == 7)entityplayer.addChatMessage("\u00a7lSCP-049: \u00a7rIs this a laboratory? It is quite marvelous.");					
			}
		}
		super.onLivingUpdate();
	}
	
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Anger", isAggro);
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.isAggro = par1NBTTagCompound.getBoolean("Anger");
	}
}
