package SCPCraft.entities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.items.SCPItem1023ARC;

public class SCPEntity1440 extends EntityAnimal
{
	public SCPEntity1440(World par1World)
	{
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/1440.png";
		this.moveSpeed = 0.35F;
		isImmuneToFire = true;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
		this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	public int getMaxHealth()
	{
		return 9001;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{      
		if(par1DamageSource == DamageSource.fall)
		{
			Random rand = new Random();
			int Teleport = rand.nextInt(10);
            boolean var2 = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3F, var2);
			if(Teleport == 0 || Teleport == 5)
			{
				this.setPosition(posX - 4, posY + 4, posZ);
			}
			if(Teleport == 1 || Teleport == 6)
			{
				this.setPosition(posX + 4, posY + 4, posZ);
			}
			if(Teleport == 2 || Teleport == 7)
			{
				this.setPosition(posX, posY + 4, posZ + 4);
			}
			if(Teleport == 3 || Teleport == 8)
			{
				this.setPosition(posX, posY + 4, posZ - 4);
			}
			if(Teleport == 4)
			{
				this.setPosition(posX, posY + 2, posZ);
			}
			if(Teleport == 9)
			{
				this.setPosition(posX, posY + 4, posZ - 4);
			}
			return true;
		}
		if (par1DamageSource.getEntity() instanceof SCPEntity50AEJ)
		{
			this.setDead();
			worldObj.playSoundAtEntity(this, "random.hurt", getSoundVolume(), ((rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
			this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + (double)(this.height / 2.0F), this.posZ, 0.0D, 0.0D, 0.0D);
			EntityPlayer ep = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
			Random rand = new Random();
			if(ep != null)
			{	
				int Chat = rand.nextInt(4);
				if(Chat == 0)
				{
					ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rDIE YOU RUSSIAN");
				}
				if(Chat == 1)
				{
					ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rPINKO PHUCKS");
				}
				if(Chat == 2)
				{
					ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rUP YOUR LEBENSRAUM YOU UBERMENSCH F*CK");
				}
				if(Chat == 3)
				{
					ep.addChatMessage("\u00a7lSCP-50-AE-1: \u00a7rCAN YOU HEAR ME NOW HUGO CHAVEZ");
				}
			}
			return true;
		}
		else
		{
			return false;
		}
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

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		int i = MathHelper.floor_double(posX);
		int k = MathHelper.floor_double(posY);
		int i1 = MathHelper.floor_double(posZ);

		Block ablock[] =
			{
				Block.brick, Block.sand, Block.stone, Block.cobblestone, Block.cobblestoneMossy, Block.sandStone, Block.dirt, Block.gravel, Block.grass, Block.obsidian, Block.wood, Block.planks, 
				Block.glass, Block.thinGlass, Block.fenceIron, Block.fence, Block.fenceGate, Block.doorSteel, Block.doorWood, Block.cloth, Block.blockClay, Block.blockSnow, Block.ice, 
				Block.blockGold, Block.blockLapis, Block.chest, Block.cobblestone, Block.cobblestoneMossy, Block.dispenser, Block.trapdoor, Block.doorSteel, Block.doorWood, mod_SCP.Locker, mod_SCP.KeycardSlot,
				Block.bed, Block.stoneBrick, Block.enchantmentTable, Block.furnaceIdle, Block.furnaceBurning, mod_SCP.KeycardSlotLv2, mod_SCP.KeycardSlotLv3, mod_SCP.KeycardSlotOmni
			};

		for(int m = 1; m <= 2; m++)
		{		
			for(int length = 0; length <= 41; length++) 
			{
				if(worldObj.getBlockId(i + 1, k + m, i1) == ablock[length].blockID)
					worldObj.setBlock(i + 1, k + m, i1, 0);		
				if(worldObj.getBlockId(i - 1, k + m, i1) == ablock[length].blockID)
					worldObj.setBlock(i - 1, k + m, i1, 0);		
				if(worldObj.getBlockId(i, k + m, i1 - 1) == ablock[length].blockID)
					worldObj.setBlock(i, k + m, i1 - 1, 0);		
				if(worldObj.getBlockId(i, k + m, i1 + 1) == ablock[length].blockID)
					worldObj.setBlock(i, k + m, i1 + 1, 0);	
			}
		}


		super.onLivingUpdate();
	}

	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
        boolean var2 = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
		if(par1EntityPlayer != null)
		{
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2F, var2);
			this.setPosition(this.posX + 4, this.posY + 4, this.posZ + 4);
		}
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.villager.default";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.villager.default";
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return 0;
	}

	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if(itemstack != null && Item.itemsList[itemstack.itemID] instanceof SCPItem1023ARC)
		{
			this.setDead();
			this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + (double)(this.height / 2.0F), this.posZ, 0.0D, 0.0D, 0.0D);
			return true;
		}
		else
		{
			return false;
		}
	}

	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return new SCPEntity1440(worldObj);
	}
}
