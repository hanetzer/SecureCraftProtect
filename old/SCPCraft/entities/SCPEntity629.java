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
import SCPCraft.guis.SCPGuiName;
import SCPCraft.items.SCPItemWrench;

public class SCPEntity629 extends EntityTameable
{
	public boolean Armed;
	public String Name;
	public SCPEntity629(World par1World)
	{
		super(par1World);
		setSize(0.9F, 1.3F);
		texture = "/SCPCraft/textures/mobs/629.png";
		getNavigator().setAvoidsWater(true);
		tasks.addTask(2, aiSit);
		moveSpeed = 0.24F;
		Name = "SCP-629";
		Armed = false;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAISCP0173Attack(this, this.moveSpeed, true));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, this.moveSpeed, 10.0F, 2.0F));
		this.tasks.addTask(5, new EntityAIMate(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
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
		super.onLivingUpdate();
	}

	protected void entityInit()
	{
		super.entityInit();
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

	public String getTexture()
	{
		if(Armed || isTamed())
		{
			return "/SCPCraft/textures/mobs/629Armed.png";
		}
		if(!Armed || !isTamed())
		{
			return "/SCPCraft/textures/mobs/629UnArmed.png";
		}
		else
		{
			return "/SCPCraft/textures/mobs/629UnArmed.png";
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
	private boolean Head;

	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setInteger("foodnum", foodNum);
		nbt.setInteger("tamednum", tamedNum);
		nbt.setBoolean("Armed", Armed);

		if (this.getOwnerName() == null)
		{
			nbt.setString("Owner", "");
		}
		else
		{
			nbt.setString("Owner", this.getOwnerName());
		}

		if(this.Name != null)
		{
			nbt.setString("Name", this.Name);
		}

		if(this.isSitting())
		{
			nbt.setBoolean("Sitting", this.isSitting());
		}
	}

	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		tamedNum = nbt.getInteger("tamednum");
		foodNum = nbt.getInteger("foodnum");
		Armed = nbt.getBoolean("Armed");
		String var2 = nbt.getString("Owner");
		this.Name = nbt.getString("Name");

		if (var2.length() > 0)
		{
			this.setOwner(var2);
			this.setTamed(true);
		}

		if(this.isSitting())
		{
			this.aiSit.setSitting(nbt.getBoolean("Sitting"));
		}
	}

	public int getTalkInterval()
	{
		return 1000;
	}

	public String getLivingSound()
	{
		if(!worldObj.isRemote)
		{
			return "sounds.MrBrass";
		}
		else
		{
			return "mob.villager.default";
		}
	}

	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if (this.isTamed())
		{
			if(var2 == null)
			{
				if(!this.isSitting())
				{
					this.aiSit.setSitting(!this.isSitting());
					this.isJumping = false;
					this.setPathToEntity((PathEntity)null);
				}
				if(this.isSitting())
				{

				}
			}
			if (var2 != null && Item.itemsList[var2.itemID] instanceof SCPItemWrench)
			{
				SCPItemWrench var3 = (SCPItemWrench)Item.itemsList[var2.itemID];
				if (!par1EntityPlayer.capabilities.isCreativeMode)
				{
					--var2.stackSize;
				}

				this.heal((10));

				if (var2.stackSize <= 0)
				{
					par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
				}

				var2.damageItem(5, par1EntityPlayer);
				ModLoader.openGUI(par1EntityPlayer, new SCPGuiName(this));
				return true;
			}

			if (par1EntityPlayer.username.equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote)
			{
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
				ModLoader.openGUI(par1EntityPlayer, new SCPGuiName(this));
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
					this.setEntityHealth(30);
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
					if(this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) != null)this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D).addChatMessage("Thank you so much sir!");
					worldObj.playSoundAtEntity(this, "random.click", getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
					((par1EntityPlayer)).triggerAchievement(mod_SCP.SCP629);
					for (int l = 0; l < 8; l++)
					{
						worldObj.spawnParticle("largesmoke", (double)i + Math.random(), (double)j + 0.75D, (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
					}
					ModLoader.openGUI(par1EntityPlayer, new SCPGuiName(this));
					var2.damageItem(5, par1EntityPlayer);
				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
					var2.damageItem(5, par1EntityPlayer);
					ModLoader.openGUI(par1EntityPlayer, new SCPGuiName(this));
				}
			}

			return true;
		}

		else if (var2 == null)
		{
			if(!this.isTamed())
			{
				return super.interact(par1EntityPlayer);
			}
			else if(this.isTamed())
			{
				this.heal(30);
				this.setEntityHealth(30);
				return super.interact(par1EntityPlayer);
			}
		}

		return super.interact(par1EntityPlayer);
	}


	public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
	{
		return new SCPEntity629(worldObj);
	}

	public int func_48148_ad()
	{
		return dataWatcher.getWatchableObjectByte(18);
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.irongolem.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.irongolem.hit";
	}

	public EntityAgeable func_90011_a(EntityAgeable var1)
	{
		return var1;
	}

	public EntityAgeable createChild(EntityAgeable entityageable) 
	{
		return new SCPEntity629(worldObj);
	}

}