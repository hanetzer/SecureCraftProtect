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

public class SCPItemSlideDoor extends Item
{
	private Material doorMaterial;

	public SCPItemSlideDoor(int par1, Material par2Material)
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

			var11 = mod_SCP.SlidingDoor;

			if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
			{
				if (!var11.canPlaceBlockAt(par3World, par4, par5, par6))
				{
					return false;
				}
				else
				{
					int var12 = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
					if(var12 == 3)
					{
						par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 0);
						par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 2);						
					}
					if(var12 == 0)
					{
						par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 1);
						par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 3);						
					}
					if(var12 == 1)
					{
						par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 8);
						par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 10);						
					}
					if(var12 == 2)
					{
						par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 9);
						par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 11);						
					}
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
	
	public static void placeDoorBlock(World par3World, int par4, int par5, int par6, int par7)
    {
		if(par7 == 3)
		{
			par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 0);
			par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 2);						
		}
		if(par7 == 0)
		{
			par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 1);
			par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 3);						
		}
		if(par7 == 1)
		{
			par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 8);
			par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 10);						
		}
		if(par7 == 2)
		{
			par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.SlidingDoor.blockID, 9);
			par3World.setBlockMetadataWithNotify(par4, par5 + 1, par6, mod_SCP.SlidingDoor.blockID, 11);						
		}
    }
}
