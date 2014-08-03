package SCPCraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItemCorrodedDoor extends Item
{
	private Material doorMaterial;

	public SCPItemCorrodedDoor(int par1, Material par2Material)
	{
		super(par1);
		this.doorMaterial = Material.iron;
		this.maxStackSize = 1;
		this.setCreativeTab(mod_SCP.tabItemSCP);
	}
	
	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par7 != 1)
		{
			return false;
		}
		else
		{
			++par5;
			Block var11;

			var11 = mod_SCP.CorrodedDoor;

			if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
			{
				if (!var11.canPlaceBlockAt(par3World, par4, par5, par6))
				{
					return false;
				}
				else
				{
					int var12 = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
					placeDoorBlock(par3World, par4, par5, par6, var12, var11);
					--par1ItemStack.stackSize;
					return true;
				}
			}
			else
			{
				return false;
			}
		}
	}

	public static void placeDoorBlock(World par0World, int par1, int par2, int par3, int par4, Block par5Block)
	{
		byte var6 = 0;
		byte var7 = 0;

		if (par4 == 0)
		{
			var7 = 1;
		}

		if (par4 == 1)
		{
			var6 = -1;
		}

		if (par4 == 2)
		{
			var7 = -1;
		}

		if (par4 == 3)
		{
			var6 = 1;
		}

		int var8 = (par0World.isBlockNormalCube(par1 - var6, par2, par3 - var7) ? 1 : 0) + (par0World.isBlockNormalCube(par1 - var6, par2 + 1, par3 - var7) ? 1 : 0);
		int var9 = (par0World.isBlockNormalCube(par1 + var6, par2, par3 + var7) ? 1 : 0) + (par0World.isBlockNormalCube(par1 + var6, par2 + 1, par3 + var7) ? 1 : 0);
		boolean var10 = par0World.getBlockId(par1 - var6, par2, par3 - var7) == par5Block.blockID || par0World.getBlockId(par1 - var6, par2 + 1, par3 - var7) == par5Block.blockID;
		boolean var11 = par0World.getBlockId(par1 + var6, par2, par3 + var7) == par5Block.blockID || par0World.getBlockId(par1 + var6, par2 + 1, par3 + var7) == par5Block.blockID;
		boolean var12 = false;

		if (var10 && !var11)
		{
			var12 = true;
		}
		else if (var9 > var8)
		{
			var12 = true;
		}
		
//		par0World.editingBlocks = true;
		par0World.setBlock(par1, par2, par3, par5Block.blockID, par4, 2);
		par0World.setBlock(par1, par2 + 1, par3, par5Block.blockID, 8 | (var12 ? 1 : 0), 2);
//		par0World.editingBlocks = false;
		par0World.notifyBlocksOfNeighborChange(par1, par2, par3, par5Block.blockID);
		par0World.notifyBlocksOfNeighborChange(par1, par2 + 1, par3, par5Block.blockID);
	}
}
