package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem261 extends SCPItemDocument
{
	int spawnID = mod_SCP.SCP261.blockID;
	public SCPItem261(int i)
	{
		super(i, 0);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a72SCP-261");
		list.add("\u00a77Pan Dimensional Vending");
	}

	public boolean isFull3D()
	{
		return true;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int var11 = par3World.getBlockId(par4, par5, par6);

		if (var11 == Block.snow.blockID)
		{
			par7 = 1;
		}
		else if (var11 != Block.vine.blockID && var11 != Block.tallGrass.blockID && var11 != Block.deadBush.blockID)
		{
			if (par7 == 0)
			{
				--par5;
			}
			if (par7 == 1)
			{
				++par5;
			}
			if (par7 == 2)
			{
				--par6;
			}
			if (par7 == 3)
			{
				++par6;
			}
			if (par7 == 4)
			{
				--par4;
			}
			if (par7 == 5)
			{
				++par4;
			}
		}

		if (par1ItemStack.stackSize == 0)
		{
			return false;
		}
		else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else
		{
			if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity)null, par1ItemStack))
			{
				Block var12 = Block.blocksList[this.spawnID];
				int var13 = this.getMetadata(par1ItemStack.getItemDamage());
				int var14 = Block.blocksList[this.spawnID].onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, var13);

				if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10, var14))
				{
					par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					--par1ItemStack.stackSize;					
					par2EntityPlayer.addChatMessage("SCP-261 Spawned." + " | [Type: \u00a72Safe\u00a7f]");
				}
			}

			return true;
		}
	}

	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	{
		if (!world.setBlock(x, y, z, this.spawnID, metadata, 2))
		{
			return false;
		}

		if (world.getBlockId(x, y, z) == this.spawnID)
		{
			Block.blocksList[this.spawnID].onBlockPlacedBy(world, x, y, z, player, stack);
			Block.blocksList[this.spawnID].onPostBlockPlaced(world, x, y, z, metadata);
		}

		return true;
	}
}