package SCPCraft.entities;

import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.SCPDamageSource;
import SCPCraft.mod_SCP;
import SCPCraft.worldgen.SCPWorldGenPocketDimension;

public class SCPEntity106 extends SCPEntity
{

	EntityPlayer entityplayer = worldObj.getClosestVulnerablePlayerToEntity(this, 16D);

	public boolean isAttacking;
	public static int PDDuration;
	public static boolean didPlayerWin;

	public static double OverworldX;
	public static double OverworldY;
	public static double OverworldZ;


	public static boolean PocketDimension = false;

	public SCPEntity106(World par1World)
	{
		super(par1World);
		texture = "/SCPCraft/textures/mobs/106.png";
		moveSpeed = 0.3F;
		attackStrength = 6;
		isAttacking = true;
		SCPEntity106.PDDuration = 0;
		this.setSize(0.8F, 1.8F);
		isImmuneToFire = true;
		stepHeight = 2F;
		SCPEntity106.didPlayerWin = false;
		getNavigator().setAvoidsWater(true);
		getNavigator().clearPathEntity();
		getNavigator().getPathToEntityLiving((EntityLiving)entityToAttack);
		getNavigator().tryMoveToEntityLiving((EntityLiving)entityToAttack, 1F);
		getNavigator().setEnterDoors(true);
	}

	protected boolean isAIEnabled()
	{
		return false;
	}

	protected String getLivingSound()
	{
		return "sounds.oldman";
	}

	public void moveEntity(double par1, double par3, double par5)
	{
		this.worldObj.theProfiler.startSection("move");
		boundingBox.offset(par1, 0, par5);
		ySize *= 0.4F;
		double d2 = par1;
		double d3 = par3;
		double d4 = par5;
		AxisAlignedBB axisalignedbb = boundingBox.copy();

		List<?> list = worldObj.getCollidingBoundingBoxes(this, boundingBox.addCoord(par1, par3, par5));

		for (int i = 0; i < list.size(); i++)
		{
			par3 = ((AxisAlignedBB)list.get(i)).calculateYOffset(boundingBox, par3);
		}

		boundingBox.offset(0.0D, par3, 0.0D);

		if (!field_70135_K && d3 != par3)
		{
			par1 = par3 = par5 = 0.0D;
		}

		boolean flag1 = onGround || d3 != par3 && d3 < 0.0D;

		for (int j = 0; j < list.size(); j++)
		{
			par1 = ((AxisAlignedBB)list.get(j)).calculateXOffset(boundingBox, par1);
		}

		boundingBox.offset(par1, 0.0D, 0.0D);

		if (!field_70135_K && d2 != par1)
		{
			par1 = par3 = par5 = 0.0D;
		}

		for (int k = 0; k < list.size(); k++)
		{
			par5 = ((AxisAlignedBB)list.get(k)).calculateZOffset(boundingBox, par5);
		}

		boundingBox.offset(0.0D, 0.0D, par5);

		if (!field_70135_K && d4 != par5)
		{
			par1 = par3 = par5 = 0.0D;
		}

		if (stepHeight > 0.0F && flag1 && ySize < 0.05F && (d2 != par1 || d4 != par5))
		{
			double d6 = par1;
			double d8 = par3;
			double d10 = par5;
			par1 = d2;
			par3 = stepHeight;
			par5 = d4;
			AxisAlignedBB axisalignedbb1 = boundingBox.copy();
			boundingBox.setBB(axisalignedbb);
			List<?> list1 = worldObj.getCollidingBoundingBoxes(this, boundingBox.addCoord(par1, par3, par5));

			for (int j2 = 0; j2 < list1.size(); j2++)
			{
				par3 = ((AxisAlignedBB)list1.get(j2)).calculateYOffset(boundingBox, par3);
			}

			boundingBox.offset(0.0D, par3, 0.0D);

			if (!field_70135_K && d3 != par3)
			{
				par1 = par3 = par5 = 0.0D;
			}

			for (int k2 = 0; k2 < list1.size(); k2++)
			{
				par1 = ((AxisAlignedBB)list1.get(k2)).calculateXOffset(boundingBox, par1);
			}

			boundingBox.offset(par1, 0.0D, 0.0D);

			if (!field_70135_K && d2 != par1)
			{
				par1 = par3 = par5 = 0.0D;
			}

			for (int l2 = 0; l2 < list1.size(); l2++)
			{
				par5 = ((AxisAlignedBB)list1.get(l2)).calculateZOffset(boundingBox, par5);
			}

			boundingBox.offset(0.0D, 0.0D, par5);

			if (!field_70135_K && d4 != par5)
			{
				par1 = par3 = par5 = 0.0D;
			}

			if (!field_70135_K && d3 != par3)
			{
				par1 = par3 = par5 = 0.0D;
			}
			else
			{
				par3 = -stepHeight;

				for (int i3 = 0; i3 < list1.size(); i3++)
				{
					par3 = ((AxisAlignedBB)list1.get(i3)).calculateYOffset(boundingBox, par3);
				}

				boundingBox.offset(0.0D, par3, 0.0D);
			}

			if (d6 * d6 + d10 * d10 >= par1 * par1 + par5 * par5)
			{
				par1 = d6;
				par3 = d8;
				par5 = d10;
				boundingBox.setBB(axisalignedbb1);
			}
			else
			{
				double d11 = boundingBox.minY - (double)(int)boundingBox.minY;

				if (d11 > 0.0D)
				{
					ySize += d11 + 0.01D;
				}
			}
		}	        	     
		posX = (boundingBox.minX + boundingBox.maxX) / 2D;
		posY = (boundingBox.minY + (double)yOffset) - (double)ySize;
		posZ = (boundingBox.minZ + boundingBox.maxZ) / 2D;
		onGround = d3 != par3 && d3 < 0.0D;
		updateFallState(par3, onGround);	        
		this.worldObj.theProfiler.endSection();
	}

	public int getMaxHealth()
	{
		return 9001;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setDouble("playerX", SCPEntity106.OverworldX);
		nbt.setDouble("playerY", SCPEntity106.OverworldY);
		nbt.setDouble("playerZ", SCPEntity106.OverworldZ);
		nbt.setBoolean("pocketDimensionWin", SCPEntity106.didPlayerWin);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		SCPEntity106.OverworldX = nbt.getDouble("playerX");
		SCPEntity106.OverworldY = nbt.getDouble("playerY");
		SCPEntity106.OverworldZ = nbt.getDouble("playerZ");

		SCPEntity106.didPlayerWin = nbt.getBoolean("pocketDimensionWin");
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	public void onLivingUpdate()
	{		
		super.onLivingUpdate();
		
		EntityPlayer player = worldObj.getClosestVulnerablePlayerToEntity(this, 256D);

		if(player != null)
		{
			if(SCPEntity106.PDDuration > 0)
			{
				SCPEntity106.PDDuration--;
			}

			if(SCPEntity106.PDDuration == 1 && player.isEntityAlive())
			{
				player.setPositionAndUpdate(OverworldX, OverworldY + 2F, OverworldZ);
				player.addStat(mod_SCP.pocketD, 1);
				player.triggerAchievement(mod_SCP.pocketD);
				Random rand = new Random();
				int chance = rand.nextInt(4);

				switch(chance)
				{
				case 0:
					player.inventory.addItemStackToInventory(new ItemStack(mod_SCP.Record079));
					break;
				case 1:
					player.inventory.addItemStackToInventory(new ItemStack(mod_SCP.Record789J));
					break;
				case 2:
					player.inventory.addItemStackToInventory(new ItemStack(mod_SCP.Record914));
					break;
				case 3:
					player.inventory.addItemStackToInventory(new ItemStack(mod_SCP.Record173E));
					break;
				}

				player.clearActivePotions();

				SCPEntity106.didPlayerWin = true;
				this.kill();
			}

			if(player.isDead && !player.isEntityAlive())
			{
				SCPEntity106.PDDuration = 0;
				this.setPositionAndUpdate(OverworldX + 2F, OverworldY + 2F, OverworldZ + 2F);
			}
		}

	}

	public void onCollideWithPlayer(EntityPlayer player)
	{    
		if(this.posY != 5)
		{
			SCPEntity106.OverworldX = player.posX;
			SCPEntity106.OverworldY = player.posY;
			SCPEntity106.OverworldZ = player.posZ;

			Minecraft mc = Minecraft.getMinecraft();

			if(mc.playerController.isNotCreative())
			{
				player.inventory.consumeInventoryItem(Item.bucketMilk.itemID);
				player.inventory.consumeInventoryItem(mod_SCP.SCP500G.itemID);
				player.setPositionAndUpdate(player.posX, 5, player.posZ - 1);
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600 * 20, 2));
				SCPWorldGenPocketDimension.generate(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
				mc.gameSettings.setOptionValue(EnumOptions.RENDER_DISTANCE, 3);

				this.setPositionAndUpdate(this.posX + 10, 5, this.posZ - 2);

				SCPEntity106.PDDuration = rand.nextInt(4000);
			}
		}
		else player.attackEntityFrom(SCPDamageSource.SCP106, 6);
	}
}
