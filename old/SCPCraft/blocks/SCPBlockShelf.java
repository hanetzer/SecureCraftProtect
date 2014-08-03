package SCPCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntityShelf;

public class SCPBlockShelf extends BlockContainer {

	public SCPBlockShelf(int par1, int par2, Material mat)
	{
		super(par1, mat);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
		setBlockBounds(0F, 0F, 0F, 1F, 0.25F, 1F);
	}

	public void registerIcons(IconRegister par1)
	{
		if(blockID == 225) blockIcon = par1.registerIcon(mod_SCP.modid + ":FancyIron");
		else if(blockID == 252) blockIcon = par1.registerIcon(BlockWood.woodTextureTypes[1]);
		else if(blockID == 253) blockIcon = par1.registerIcon(BlockWood.woodTextureTypes[2]);
		else if(blockID == 254) blockIcon = par1.registerIcon(BlockWood.woodTextureTypes[3]);
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean onBlockActivated(World world, int var2, int var3, int var4, EntityPlayer entityplayer, int var6, float var7, float var8, float var9) 	
	{
		SCPTileEntityShelf te = (SCPTileEntityShelf)world.getBlockTileEntity(var2, var3, var4);
		ItemStack stack = entityplayer.inventory.getCurrentItem();
		if(entityplayer.isSneaking()) return false;
		if(te != null)
		{
			if(te.getItem() != null)
			{
				if(!world.isRemote){
					EntityItem entityitem = new EntityItem(world, var2 + 0.5, var3 + 0.5, var4 + 0.5, te.item);
					world.spawnEntityInWorld(entityitem);				
				}
				te.setItem(null);
			}
			if(stack != null && stack.stackSize > 0)
			{
				te.setItem(stack.copy());
				te.getItem().stackSize = stack.stackSize;
				stack.stackSize = 0;
				world.setBlockMetadataWithNotify(var2, var3, var4, MathHelper.floor_double((double)((entityplayer.rotationYaw * 4F) / 360F) + 2.5D) & 3, 0x02); //

			}
			world.setBlockTileEntity(var2, var3, var4, te);
			world.updateAllLightTypes(var2, var3, var4);	
			world.updateTileEntityChunkAndDoNothing(var2, var3, var4, te);
		}
		return true;
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		SCPTileEntityShelf te = (SCPTileEntityShelf)par1World.getBlockTileEntity(par2, par3, par4);
		if (!par1World.isRemote)
		{
			par1World.updateTileEntityChunkAndDoNothing(par2, par3, par4, te);
			super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		}
	}

	public float getBlockBrightness(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) 
	{
		SCPTileEntityShelf te = (SCPTileEntityShelf)par1iBlockAccess.getBlockTileEntity(par2, par3, par4);
		if(te != null && te.getItem() != null)
		{
			if(te.getItem().itemID < 4096 && te.getItem().itemID > 0)
			{
				return Block.blocksList[te.getItem().itemID].getBlockBrightness(par1iBlockAccess, par2, par3, par4);
			}
		}
		return 0;
	}

	/**
	 * Called whenever the block is removed.
	 */
	public void breakBlock(World var1, int var2, int var3, int var4, int var5, int var6)
	{
		SCPTileEntityShelf te = (SCPTileEntityShelf)var1.getBlockTileEntity(var2, var3, var4);
		if(te != null)
		{
			if(te.getItem() != null)
			{
				EntityItem entityitem = new EntityItem(var1, var2 + 0.5, var3 + 0.5, var4 + 0.5, te.getItem());
				var1.spawnEntityInWorld(entityitem);
				te.setItem(null);
			}
		}
		super.breakBlock(var1, var2, var3, var4, var5, var6);
	}

	public int getRenderType()
	{
		return mod_Others.ShelfID;
	}

	public TileEntity createNewTileEntity(World var1) 
	{
		return new SCPTileEntityShelf();
	}
}
