package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.items.SCPItemWrench;

public class SCPEntity222Clone extends EntityTameable
{
	public SCPEntity222Clone(World par1World)
	{
		super(par1World);
		EntityPlayer entityplayer = ModLoader.getMinecraftInstance().thePlayer;
		setSize(0.8F, 1.8F);
		getNavigator().setAvoidsWater(true);
		tasks.addTask(2, aiSit);
		moveSpeed = 0.35F;
		this.texture = entityplayer.skinUrl;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAISCP0173Attack(this, this.moveSpeed, true));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 0.35F, 10.0F, 2.0F));
		this.tasks.addTask(5, new EntityAIMate(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWander(this, 0.35F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

	}
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

	public void onLivingUpdate()
	{
		if (!this.worldObj.isRemote && !this.hasPath() && this.onGround)
		{
			this.worldObj.setEntityState(this, (byte)8);
		}
		
		EntityPlayer par1EntityPlayer = ModLoader.getMinecraftInstance().thePlayer;
		
		if(par1EntityPlayer != null)
		{
			this.texture = par1EntityPlayer.skinUrl;
		}
		
		super.onLivingUpdate();
	}

	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(18, Byte.valueOf((byte)0));
	}



	public void onUpdate()
	{
		super.onUpdate();
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	protected void updateAITick()
	{
		this.dataWatcher.updateObject(18, Integer.valueOf(this.getHealth()));
	}


	public String getTexture()
	{	
		EntityPlayer ep = ModLoader.getMinecraftInstance().thePlayer;
		String playerSkin = ep.skinUrl;
		World par1World = ModLoader.getMinecraftInstance().theWorld;
		
		if(!par1World.isRemote)
		{
			return this.texture = playerSkin;
		}
		else
		{
			return this.texture = playerSkin;
		}
	}

	protected void fall(float f)
	{
	}

	public int getMaxHealth()
	{
		return 30;
	}

	public Entity ridingEntity;
	public int foodNum;
	public int tamedNum;
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setInteger("foodnum", foodNum);
		nbt.setInteger("tamednum", tamedNum);
	}

	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		tamedNum = nbt.getInteger("tamednum");
		foodNum = nbt.getInteger("foodnum");
	}

	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if (this.isTamed())
		{
			if (var2 != null && Item.itemsList[var2.itemID] instanceof SCPItemWrench)
			{
				if (this.dataWatcher.getWatchableObjectInt(18) < 20)
				{
					if (!par1EntityPlayer.capabilities.isCreativeMode)
					{
						--var2.stackSize;
					}

					this.heal((10));

					if (var2.stackSize <= 0)
					{
						par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
					}

					return true;
				}
			}

			if (par1EntityPlayer.username.equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote && !this.isWheat(var2))
			{
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
			}
		}
		else if (var2 != null && var2.itemID == mod_SCP.Wrench.itemID)
		{
			if (!par1EntityPlayer.capabilities.isCreativeMode)
			{
				--var2.stackSize;
			}

			if (var2.stackSize <= 0)
			{
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
			}

			if (!this.worldObj.isRemote)
			{
				if (this.rand.nextInt(3) == 0)
				{
					this.setTamed(true);
					this.setPathToEntity((PathEntity)null);
					this.setAttackTarget((EntityLiving)null);
					this.setEntityHealth(20);
					this.setOwner(par1EntityPlayer.username);
					this.playTameEffect(true);
					((par1EntityPlayer)).triggerAchievement(mod_SCP.SCP629);

					int i = MathHelper.floor_double(posX);
					int j = MathHelper.floor_double(posY);
					int k = MathHelper.floor_double(posZ);

					int k1 = EntityXPOrb.getXPSplit(i);
					i -= k1;
					worldObj.spawnEntityInWorld(new EntityXPOrb(worldObj, posX, posY, posZ, 100));
					this.worldObj.setEntityState(this, (byte)7);
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Thank you so much sir!");
					worldObj.playSoundAtEntity(this, "random.click", getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
					((par1EntityPlayer)).triggerAchievement(mod_SCP.SCP629);
					for (int l = 0; l < 8; l++)
					{
						worldObj.spawnParticle("largesmoke", (double)i + Math.random(), (double)j + 0.75D, (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
					}

				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
				}
			}

			return true;
		}

		if(var2 == null)
		{
			return false;
		}

		return super.interact(par1EntityPlayer);
	}


	public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
	{
		return new SCPEntity222Clone(worldObj);
	}

	public int func_48148_ad()
	{
		return dataWatcher.getWatchableObjectByte(18);
	}

	public boolean isWheat(ItemStack par1ItemStack)
	{
		return par1ItemStack.itemID == Item.ingotIron.itemID;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return new SCPEntity222Clone(null);
	}
}