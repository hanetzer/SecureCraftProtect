package SCPCraft.entities;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;
import SCPCraft.mod_SCP;

public class SCPEntity594 extends EntityAnimal
{
	/**
	 * Used to control movement as well as wool regrowth. Set to 40 on handleHealthUpdate and counts down with each
	 * tick.
	 */
	private int sheepTimer;
	public boolean field_70885_d = false;
	public float field_70886_e = 0.0F;
	public float destPos = 0.0F;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;

	
	public SCPEntity594(World par1World)
	{
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/594Unsheered.png";
		this.setSize(1.0F, 1.3F);
		float var2 = 0.23F;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
		this.tasks.addTask(2, new EntityAIMate(this, var2));
		this.tasks.addTask(3, new EntityAITempt(this, 0.25F, Item.wheat.itemID, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
		this.tasks.addTask(6, new EntityAIWander(this, var2));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
    public boolean isAIEnabled()
    {
    	if(!isAggro)return true;
    	else return false;
    }

	protected void updateAITasks()
	{
		super.updateAITasks();
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		this.field_70888_h = this.field_70886_e;
		this.field_70884_g = this.destPos;
		this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
		for (int var3 = 0; var3 < 2 * 8; ++var3)
		{
			float var1 = (float)this.boundingBox.minY;
			float var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
			float var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
		}
		if (this.destPos < 0.0F)
		{
			this.destPos = 0.0F;
		}

		if (this.destPos > 1.0F)
		{
			this.destPos = 1.0F;
		}


		if (!this.onGround && this.field_70889_i < 1.0F)
		{
			this.field_70889_i = 1.0F;
		}

		this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}

		this.field_70886_e += this.field_70889_i * 2.0F;
	}


	public int getMaxHealth()
	{
		return 16;
	}

	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
		byte var2 = 0;
		if (this.worldObj.difficultySetting == 1) var2 = 3;
		else if (this.worldObj.difficultySetting == 2) var2 = 7;
		else if (this.worldObj.difficultySetting == 3) var2 = 15;
		else if (this.worldObj.difficultySetting == 0) var2 = 0; 

		if (var2 > 0)
		{
			((EntityLiving)par1EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.electricity.id, 10*var2, 1));
		}
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	public void handleHealthUpdate(byte par1)
	{
		if (par1 == 10)
		{
			this.sheepTimer = 40;
		}
		else
		{
			super.handleHealthUpdate(par1);
		}
	}

	public float func_70894_j(float par1)
	{
		return this.sheepTimer <= 0 ? 0.0F : (this.sheepTimer >= 4 && this.sheepTimer <= 36 ? 1.0F : (this.sheepTimer < 4 ? ((float)this.sheepTimer - par1) / 4.0F : -((float)(this.sheepTimer - 40) - par1) / 4.0F));
	}

	public float func_70890_k(float par1)
	{
		if (this.sheepTimer > 4 && this.sheepTimer <= 36)
		{
			float var2 = ((float)(this.sheepTimer - 4) - par1) / 32.0F;
			return ((float)Math.PI / 5F) + ((float)Math.PI * 7F / 100F) * MathHelper.sin(var2 * 28.7F);
		}
		else
		{
			return this.sheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch / (180F / (float)Math.PI);
		}
	}

	protected void fall(float par1) {}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	 public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if (var2 != null && var2.itemID == Item.shears.itemID && !this.getSheared() && !this.isChild())
		{
			if (!this.worldObj.isRemote)
			{
				this.setDead();
				int var3 = 1 + this.rand.nextInt(3);

				for (int var4 = 0; var4 < var3; ++var4)
				{
					EntityItem var5 = this.entityDropItem(new ItemStack(mod_SCP.ElectricWool.blockID, 1, this.getFleeceColor()), 1.0F);
					var5.motionY += (double)(this.rand.nextFloat() * 0.05F);
					var5.motionX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
					var5.motionZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
				}

				if (!this.worldObj.isRemote)
				{
					ItemStack itemstack = par1EntityPlayer.inventory.armorInventory[2];
					if(itemstack != null && itemstack.itemID == mod_SCP.ClassDShirt.itemID)
					{
						SCPEntity594Naked var10 = new SCPEntity594Naked(this.worldObj);
						var10.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
						var10.setEntityHealth(this.getHealth());
						var10.renderYawOffset = this.renderYawOffset;
						this.worldObj.spawnEntityInWorld(var10);
					}
					else
					{
						SCPEntity594Naked var10 = new SCPEntity594Naked(this.worldObj);
						var10.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
						var10.setEntityHealth(this.getHealth());
						var10.renderYawOffset = this.renderYawOffset;
						this.worldObj.spawnEntityInWorld(var10);
						((EntityLiving)par1EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.electricity.id, 35, 0));
					}
				}
			}

			var2.damageItem(1, par1EntityPlayer);
		}

		return super.interact(par1EntityPlayer);
	}

	 protected boolean canDespawn()
	 {
		 return false;
	 }

	 /**
	  * (abstract) Protected helper method to write subclass entity data to NBT.
	  */
	 public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	 {
		 super.writeEntityToNBT(par1NBTTagCompound);
		 par1NBTTagCompound.setBoolean("Sheared", this.getSheared());
		 par1NBTTagCompound.setByte("Color", (byte)this.getFleeceColor());
	 }

	 /**
	  * (abstract) Protected helper method to read subclass entity data from NBT.
	  */
	 public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	 {
		 super.readEntityFromNBT(par1NBTTagCompound);
		 this.setSheared(par1NBTTagCompound.getBoolean("Sheared"));
		 this.setFleeceColor(par1NBTTagCompound.getByte("Color"));
	 }

	 /**
	  * Returns the sound this mob makes while it's alive.
	  */
	 protected String getLivingSound()
	 {
		 return "mob.sheep";
	 }

	 /**
	  * Returns the sound this mob makes when it is hurt.
	  */
	 protected String getHurtSound()
	 {
		 return "mob.sheep";
	 }

	 /**
	  * Returns the sound this mob makes on death.
	  */
	 protected String getDeathSound()
	 {
		 return "mob.sheep";
	 }

	 public int getFleeceColor()
	 {
		 return this.dataWatcher.getWatchableObjectByte(16) & 15;
	 }

	 public void setFleeceColor(int par1)
	 {
		 byte var2 = this.dataWatcher.getWatchableObjectByte(16);
		 this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & 240 | par1 & 15)));
	 }

	 /**
	  * returns true if a sheeps wool has been sheared
	  */
	 public boolean getSheared()
	 {
		 return (this.dataWatcher.getWatchableObjectByte(16) & 16) != 0;
	 }

	 /**
	  * make a sheep sheared if set to true
	  */
	 public void setSheared(boolean par1)
	 {
		 byte var2 = this.dataWatcher.getWatchableObjectByte(16);

		 if (par1)
		 {
			 this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 16)));
		 }
		 else
		 {
			 this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -17)));
		 }
	 }

	 /**
	  * This method is called when a sheep spawns in the world to select the color of sheep fleece.
	  */
	 public static int getRandomFleeceColor(Random par0Random)
	 {
		 int var1 = par0Random.nextInt(100);
		 return var1 < 5 ? 15 : (var1 < 10 ? 7 : (var1 < 15 ? 8 : (var1 < 18 ? 12 : (par0Random.nextInt(500) == 0 ? 6 : 0))));
	 }

	 /**
	  * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
	  */
	 public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
	 {
		 SCPEntity594 var2 = (SCPEntity594)par1EntityAnimal;
		 SCPEntity594 var3 = new SCPEntity594(this.worldObj);

		 if (this.rand.nextBoolean())
		 {
			 var3.setFleeceColor(this.getFleeceColor());
		 }
		 else
		 {
			 var3.setFleeceColor(var2.getFleeceColor());
		 }

		 return var3;
	 }

	 /**
	  * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
	  * function is used in the AIEatGrass)
	  */
	 public void eatGrassBonus()
	 {
		 this.setSheared(false);

		 if (this.isChild())
		 {
			 int var1 = this.getGrowingAge() + 1200;

			 if (var1 > 0)
			 {
				 var1 = 0;
			 }

			 this.setGrowingAge(var1);
		 }
	 }

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return new SCPEntity594(worldObj);
	}
}
