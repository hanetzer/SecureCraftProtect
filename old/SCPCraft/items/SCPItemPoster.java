package SCPCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItemPoster extends Item
{
    public SCPItemPoster(int par1)
    {
        super(par1);
        this.setCreativeTab(mod_SCP.tabItemSCP);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	int l = determineOrientation(par3World, par4, par5, par6, (EntityPlayer)par2EntityPlayer);
        if (par3World.getBlockId(par4, par5, par6) != Block.snow.blockID)
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

            if (!par3World.isAirBlock(par4, par5, par6))
            {
                return false;
            }
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            if (mod_SCP.Poster.canPlaceBlockAt(par3World, par4, par5, par6) && l == 5)
            {
                --par1ItemStack.stackSize;
                par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.Poster.blockID, 0);
            }
            else if (mod_SCP.Poster.canPlaceBlockAt(par3World, par4, par5, par6) && l == 4)
            {
                --par1ItemStack.stackSize;
                par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.Poster.blockID, 1);
            }
            else if (mod_SCP.Poster.canPlaceBlockAt(par3World, par4, par5, par6) && l == 3)
            {
                --par1ItemStack.stackSize;
                par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.Poster.blockID, 2);
            }
            else if (mod_SCP.Poster.canPlaceBlockAt(par3World, par4, par5, par6) && l == 2)
            {
                --par1ItemStack.stackSize;
                par3World.setBlockMetadataWithNotify(par4, par5, par6, mod_SCP.Poster.blockID, 3);
            }
            return true;
        }
    }
    
 	private static int determineOrientation(World par0World, int par1, int par2, int par3, EntityPlayer par4EntityPlayer)
 	{
 		if (MathHelper.abs((float)par4EntityPlayer.posX - (float)par1) < 2.0F && MathHelper.abs((float)par4EntityPlayer.posZ - (float)par3) < 2.0F)
 		{
 			double d = (par4EntityPlayer.posY + 1.8200000000000001D) - (double)par4EntityPlayer.yOffset;

 			if (d - (double)par2 > 2D)
 			{
 				return 1;
 			}

 			if ((double)par2 - d > 0.0D)
 			{
 				return 0;
 			}
 		}

 		int i = MathHelper.floor_double((double)((par4EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;

 		if (i == 0)
 		{
 			return 2;
 		}

 		if (i == 1)
 		{
 			return 5;
 		}

 		if (i == 2)
 		{
 			return 3;
 		}

 		return i != 3 ? 0 : 4;
 	}
    
 	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
}
