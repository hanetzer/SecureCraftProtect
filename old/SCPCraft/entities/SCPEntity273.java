package SCPCraft.entities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity273 extends SCPEntity
{
	public static int starvingTime;
	public boolean isAggro = false;	
	protected static Random Rand = new Random();

	public SCPEntity273(World par1World)
	{	
		super(par1World);
		texture = "/SCPCraft/textures/mobs/273.png";
		isImmuneToFire = true;
		experienceValue = 0;
		starvingTime = 7000;
		moveSpeed = 0.7F;
	}
	
	protected boolean isAIEnabled()
	{
		return false;
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
				byte var2 = 0;
				if (this.worldObj.difficultySetting == 1) var2 = 2;
				else if (this.worldObj.difficultySetting == 2) var2 = 4;
				else if (this.worldObj.difficultySetting == 3) var2 = 6;
				par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
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
	
	public int getMaxHealth()
	{
		return 30;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	protected String getLivingSound()
	{
		return "mob.villager.default";
	}

	protected String getHurtSound()
	{
		return "mob.villager.default";
	}

	protected String getDeathSound()
	{
		return "fire.ignite";
	}
	
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);
		float f = (rand.nextFloat() - 0.5F) * 8F;
		float f2 = (rand.nextFloat() - 0.5F) * 4F;
		float f4 = (rand.nextFloat() - 0.5F) * 8F;

		for(int times = 0; times <= 800; times++)
		{
			worldObj.spawnParticle("flame", posX + (double)f, posY + 2D + (double)f2, posZ + (double)f4, 0.0D, 0.0D, 0.0D);
		}
		if(worldObj.getBlockId((int)this.posX, (int)this.posY, (int)this.posZ) == 0)worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, mod_SCP.SCP273.blockID);
		worldObj.setBlock((int)this.posX, (int)this.posY + 1, (int)this.posZ, 0);
		
		for(int i = -2; i <= 2; i++)
			for(int j = -2; j <= 2; j++)
				if(rand.nextInt(5) == 0 && worldObj.getBlockId((int)this.posX + i, (int)this.posY, (int)this.posZ + j) == 0)
					if(worldObj.getBlockId((int)this.posX + i, (int)this.posY, (int)this.posZ + j) == 0)worldObj.setBlock((int)this.posX + i, (int)this.posY, (int)this.posZ + j, Block.fire.blockID);
		
		worldObj.playSoundEffect((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D, "fire.ignite", 1.0F, Rand.nextFloat() * 0.4F + 0.8F);
    }
    
	 public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
		if (var2 != null)
		{
				if(var2.itemID == Item.bowlSoup.itemID || var2.itemID == Item.appleRed.itemID || var2.itemID == Item.bread.itemID
						|| var2.itemID == Item.carrot.itemID || var2.itemID == Item.potato.itemID
						|| var2.itemID == Item.bakedPotato.itemID){
					par1EntityPlayer.addChatMessage("\u00a7lSCP-273: \u00a7rThank you kind sir");
					par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 30*20, 0));
					decreaseHunger(-7000);
					var2.stackSize--;

		            if (var2.stackSize <= 0)
		            {
		                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
		            }
				}
				if(var2.itemID == Item.appleGold.itemID || var2.itemID == Item.cake.itemID || var2.itemID == Item.goldenCarrot.itemID
						|| var2.itemID == Item.pumpkinPie.itemID){
					par1EntityPlayer.addChatMessage("\u00a7lSCP-273: \u00a7rThat was amazing *o*! Thank you so much :3");
					par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 60*20, 2));
					decreaseHunger(-15000);
					var2.stackSize--;

		            if (var2.stackSize <= 0)
		            {
		                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
		            }
				}
				if(var2.itemID == Item.porkCooked.itemID || var2.itemID == Item.beefCooked.itemID || var2.itemID == Item.chickenCooked.itemID
						|| var2.itemID == Item.fishCooked.itemID){
					par1EntityPlayer.addChatMessage("\u00a7lSCP-273: \u00a7rThat was delicious :D");
					par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 30*20, 1));
					decreaseHunger(-7000);
					var2.stackSize--;

		            if (var2.stackSize <= 0)
		            {
		                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
		            }
				}
				if(var2.itemID == Item.porkRaw.itemID || var2.itemID == Item.beefRaw.itemID || var2.itemID == Item.chickenRaw.itemID
						|| var2.itemID == Item.fishRaw.itemID){
					par1EntityPlayer.addChatMessage("\u00a7lSCP-273: \u00a7rYuck! Cheap bastard! >:(");
					par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10*20, 0));
					decreaseHunger(-2000);
					var2.stackSize--;

		            if (var2.stackSize <= 0)
		            {
		                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
		            }
				}
				if(var2.itemID == Item.rottenFlesh.itemID || var2.itemID == Item.spiderEye.itemID || var2.itemID == Item.poisonousPotato.itemID){
					par1EntityPlayer.addChatMessage("\u00a7lSCP-273: \u00a7rBlugh!");
					par1EntityPlayer.setFire(20);
					decreaseHunger(2000);
					var2.stackSize--;

		            if (var2.stackSize <= 0)
		            {
		                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
		            }
				}
				if(var2.itemID == Item.cookie.itemID || var2.itemID == Item.melon.itemID){
					par1EntityPlayer.addChatMessage("\u00a7lSCP-273: \u00a7rOmnomnomnomnom");
					par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20*20, 0));
					decreaseHunger(-2000);
					var2.stackSize--;

		            if (var2.stackSize <= 0)
		            {
		                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
		            }
				}
				if(var2.itemID == mod_SCP.SCP458.itemID){
					par1EntityPlayer.addChatMessage("\u00a7lSCP-273: \u00a7rI hope I won't get fat :)");
					par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 120*20, 1));
					decreaseHunger(-45000);
					var2.stackSize--;

		            if (var2.stackSize <= 0)
		            {
		                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
		            }
				}
		}
		return true;
	}

	public void onLivingUpdate()
	{
		moveSpeed = 0.7F;
		EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		if(player != null && player.isDead)isAggro = false;
		if(getHunger() != 0)decreaseHunger(1);
		if(player != null && getHunger() == 600)player.addChatMessage("\u00a7lSCP-273: \u00a7rI am hungry");
		if(getHunger() < 300)isAggro = true;
		if(getHunger() <= 0)this.attackEntityFrom(DamageSource.starve, 1);
		super.onLivingUpdate();
	}
	
	protected int decreaseHunger(int par1)
	{
		return starvingTime = starvingTime - par1;
	}
	
    public int getHunger()
    {
        return starvingTime;
    }

    public void setHunger(int par1)
    {
       starvingTime = par1;
    }
	 
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("Hunger", (short)getHunger());
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		setHunger(par1NBTTagCompound.getShort("Hunger"));
	}
}
