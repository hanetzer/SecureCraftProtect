package SCPCraft.blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;
import SCPCraft.mod_SCP;

public class SCPBlockElectricWool extends Block
{
	/** Whether the redstone torch is currently active or not. */
	private boolean torchActive = true;

	/** Map of ArrayLists of SCPRedstoneUpdateInfo. Key of map is World. */
	private static Map SCPRedstoneUpdateInfoCache = new HashMap();

	private boolean checkForBurnout(World par1World, int par2, int par3, int par4, boolean par5)
	{
		if (!SCPRedstoneUpdateInfoCache.containsKey(par1World))
		{
			SCPRedstoneUpdateInfoCache.put(par1World, new ArrayList());
		}

		if (par5)
		{
			((List)SCPRedstoneUpdateInfoCache.get(par1World)).add(new SCPRedstoneUpdateInfo(par2, par3, par4, par1World.getWorldTime()));
		}

		int var6 = 0;
		Iterator var7 = ((List)SCPRedstoneUpdateInfoCache.get(par1World)).iterator();

		while (var7.hasNext())
		{
			SCPRedstoneUpdateInfo var8 = (SCPRedstoneUpdateInfo)var7.next();

			if (var8.getX() == par2 && var8.getY() == par3 && var8.getZ() == par4)
			{
				++var6;

				if (var6 >= 8)
				{
					return true;
				}
			}
		}

		return false;
	}

	public SCPBlockElectricWool(int par1, int par2, boolean par3)
	{
		super(par1, Material.circuits);
		this.torchActive = par3;
		this.setTickRandomly(true);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}
	
	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(Block.cloth.getUnlocalizedName2());
    }

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return true;
	}

	public int getMobilityFlag()
	{
		return 0;
	}

	public boolean isBlockSolid(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}

	public boolean renderAsNormalBlock()
	{
		return true;
	}

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate()
	{
		return 2;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			super.onBlockAdded(par1World, par2, par3, par4);
		}

		if (this.torchActive)
		{
			par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
		}
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if (this.torchActive)
		{
			par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
			par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
		}
	}

	/**
	 * Is this block powering the block on the specified side
	 */
	public boolean isPoweringTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if (!this.torchActive)
		{
			return false;
		}
		else
		{
			int var6 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
			return var6 == 5 && par5 == 1 ? false : (var6 == 3 && par5 == 3 ? false : (var6 == 4 && par5 == 2 ? false : (var6 == 1 && par5 == 5 ? false : var6 != 2 || par5 != 4)));
		}
	}

	/**
	 * Returns true or false based on whether the block the torch is attached to is providing indirect power.
	 */
	private boolean isIndirectlyPowered(World par1World, int par2, int par3, int par4)
	{
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		return var5 == 5 && par1World.getIndirectPowerOutput(par2, par3 - 1, par4, 0) ? true : (var5 == 3 && par1World.getIndirectPowerOutput(par2, par3, par4 - 1, 2) ? true : (var5 == 4 && par1World.getIndirectPowerOutput(par2, par3, par4 + 1, 3) ? true : (var5 == 1 && par1World.getIndirectPowerOutput(par2 - 1, par3, par4, 4) ? true : var5 == 2 && par1World.getIndirectPowerOutput(par2 + 1, par3, par4, 5))));
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		boolean var6 = this.isIndirectlyPowered(par1World, par2, par3, par4);
		List var7 = (List)SCPRedstoneUpdateInfoCache.get(par1World);

		while (var7 != null && !var7.isEmpty() && par1World.getWorldTime() - ((SCPRedstoneUpdateInfo)var7.get(0)).getUpdateTime() > 60L)
		{
			var7.remove(0);
		}

		if (this.torchActive)
		{
			if (var6)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, mod_SCP.ElectricWool.blockID, par1World.getBlockMetadata(par2, par3, par4));

				if (this.checkForBurnout(par1World, par2, par3, par4, true))
				{
					par1World.playSoundEffect((double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

					for (int var8 = 0; var8 < 5; ++var8)
					{
						double var9 = (double)par2 + par5Random.nextDouble() * 0.6D + 0.2D;
						double var11 = (double)par3 + par5Random.nextDouble() * 0.6D + 0.2D;
						double var13 = (double)par4 + par5Random.nextDouble() * 0.6D + 0.2D;

					}
				}
			}
		}
		else if (!var6 && !this.checkForBurnout(par1World, par2, par3, par4, false))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, mod_SCP.ElectricWool.blockID, par1World.getBlockMetadata(par2, par3, par4));
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
	}

	/**
	 * Is this block indirectly powering the block on the specified side
	 */
	public boolean isIndirectlyPoweringTo(World par1World, int par2, int par3, int par4, int par5)
	{
		return par5 == 0 ? this.isPoweringTo(par1World, par2, par3, par4, par5) : false;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.ElectricWool.blockID;
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this change based on its state.
	 */
	public boolean canProvidePower()
	{
		return true;
	}

	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) 
	{
		ItemStack var2 = par5EntityPlayer.inventory.getCurrentItem();
		if(var2 != null)
		{
			if(var2.itemID != mod_SCP.TothBrush.itemID) ((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.electricity.id, 10, 0));
		}
		else
		{
			((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.electricity.id, 10, 1));
		}
	}

	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return mod_SCP.ElectricWool.blockID;
	}

	/**
	 * Called when the time changes.
	 */
	public void onTimeChanged(World par1World, long par2, long par4)
	{
		List var6 = (List)SCPRedstoneUpdateInfoCache.get(par1World);
		SCPRedstoneUpdateInfo var8;

		if (var6 != null)
		{
			for (Iterator var7 = var6.iterator(); var7.hasNext(); var8.setUpdateTime(var8.getUpdateTime() + par2))
			{
				var8 = (SCPRedstoneUpdateInfo)var7.next();
			}
		}
	}

	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
		EntityPlayer entityplayer= ModLoader.getMinecraftInstance().thePlayer;
		ItemStack itemstack = entityplayer.inventory.armorInventory[3];

		if (itemstack != null && itemstack.itemID == Item.helmetSteel.itemID)
		{  
			if(entity instanceof EntityPlayer)
			{
				((EntityLiving)entity).addPotionEffect(new PotionEffect(SCPPotion.electricity.id, 100, 1));
			}
		}
		else
		{
		}
	}
}
