package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SCPEntity131 extends EntityTameable
{
	public SCPEntity131(World par1World)
	{
		super(par1World);
		setSize(0.9F, 1.3F);
		texture = "/SCPCraft/textures/mobs/131A.png";
		getNavigator().setAvoidsWater(true);
		tasks.addTask(2, aiSit);
		moveSpeed = 0.4F;
		tasks.addTask(5, new EntityAIFollowOwner(this, moveSpeed, 10F, 2.0F));
		tasks.addTask(6, new EntityAIMate(this, 0.23F));
		tasks.addTask(7, new EntityAISCP0173Attack(this, SCPEntity173.class, moveSpeed, false));
		tasks.addTask(8, new EntityAIWander(this, 0.23F));
		tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 10F));
		tasks.addTask(10, new EntityAIWatchClosest(this, SCPEntityClassDGuy.class, 10F));
		tasks.addTask(11, new EntityAIWatchClosest(this, SCPEntity173.class, 10F));
		targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(0, new EntityAITempt(this, 0.25F, Item.ingotGold.itemID, false));
		targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, SCPEntity173.class, 16F, 0, true));

	}

	public SCPEnumCreatureAttribute getSCPAttribute()
	{
		return SCPEnumCreatureAttribute.SCP;
	}

	protected void entityInit()
	{
		super.entityInit();
	}

	public void onUpdate()
	{
		super.onUpdate();

		System.out.println(tamedNum + " | " + foodNum);
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	protected void fall(float f)
	{
	}

	public int getMaxHealth()
	{
		return 20;
	}

	public String getTexture()
	{
		if(!isTamed())
		{

			return "/SCPCraft/textures/mobs/131A.png";
		}
		else
		{
			return "/SCPCraft/textures/mobs/131B.png";
		}
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

	public double getMountedYOffset()
	{
		return (double)this.height - 0.82D;
	}

	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		tamedNum = nbt.getInteger("tamednum");
		foodNum = nbt.getInteger("foodnum");
	}

	public boolean interact(EntityPlayer par1EntityPlayer)
	{	
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if(tamedNum == 0)
		{
			tamedNum = rand.nextInt(3) + 1;
		}

		if (!isTamed())
		{
			//Taming
			if (itemstack != null && itemstack.itemID == Item.ingotGold.itemID && par1EntityPlayer.getDistanceSqToEntity(this) < 9D)
			{
				itemstack.stackSize--;
				foodNum++;
				if (itemstack.stackSize <= 0)
				{
					par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
				}

				if (!worldObj.isRemote && foodNum >= tamedNum)
				{
					setTamed(true);
					setOwner(par1EntityPlayer.username);
					aiSit.setSitting(true);
					worldObj.setEntityState(this, (byte)7);
					worldObj.getClosestPlayerToEntity(par1EntityPlayer, 16.0D).addChatMessage("You have an EyePod now!");
				}
			}

			return true;
		}

		return super.interact(par1EntityPlayer);  
	}

	public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
	{
		return new SCPEntity131(worldObj);
	}

	public boolean isWheat(ItemStack par1ItemStack)
	{
		return par1ItemStack.itemID == Item.ingotGold.itemID;
	}

	public EntityAgeable createChild(EntityAgeable var1) 
	{
		return new SCPEntity131(worldObj);
	}
}