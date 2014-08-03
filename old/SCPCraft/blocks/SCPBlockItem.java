package SCPCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPBlockItem extends Item
{
	/** The ID of the block the reed will spawn when used from inventory bar. */
	private int spawnID;

	public SCPBlockItem(int par1, Block par2Block)
	{
		super(par1);
		this.spawnID = par2Block.blockID;
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
        else if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, par2EntityPlayer, par1ItemStack))
        {
            Block var12 = Block.blocksList[this.spawnID];
            int var13 = this.getMetadata(par1ItemStack.getItemDamage());
            int var14 = Block.blocksList[this.spawnID].onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, var13);

            if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10, var14))
            {
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var12.stepSound.getPlaceSound(), (var12.stepSound.getVolume() + 1.0F) / 2.0F, var12.stepSound.getPitch() * 0.8F);
                --par1ItemStack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
	}

    /**
     * Called to actually place the block, after the location is determined
     * and all permission checks have been made.
     *
     * @param stack The item stack that was used to place the block. This can be changed inside the method.
     * @param player The player who is placing the block. Can be null if the block is not being placed by a player.
     * @param side The side the player (or machine) right-clicked on.
     */
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
       if(!world.setBlock(x, y, z, this.spawnID, metadata, 2))
       {
          return false;
       }
       if (world.getBlockId(x, y, z) == this.spawnID)
       {
           Block.blocksList[spawnID].onBlockPlacedBy(world, x, y, z, player, stack);
           Block.blocksList[spawnID].onPostBlockPlaced(world, x, y, z, metadata);
       }
       return true;
    }
}
