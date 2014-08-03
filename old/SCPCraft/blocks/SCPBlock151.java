package SCPCraft.blocks;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntity151;

public class SCPBlock151 extends BlockContainer
{
	public SCPBlock151(int par1)
	{
		super(par1, Material.wood);
	//	blockIndexInTexture = 8;
        this.setCreativeTab(mod_SCP.tabBlockSCP);
        disableStats();
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }
    
	public TileEntity createNewTileEntity(World var1) {
		try
		{
			return (TileEntity)SCPTileEntity151.class.newInstance();
		}
		catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
				par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
				par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
				par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH);
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return mod_SCP.ItemSCPPoster.itemID;
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

	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);           
		if(par1World.getBlockId(par2, par3, par4 + 1) == 0 && l == 0)return false;
		else if(par1World.getBlockId(par2, par3, par4 - 1) == 0 && l == 1)return false;
		else if(par1World.getBlockId(par2 + 1, par3, par4) == 0 && l == 2)return false;
		else if(par1World.getBlockId(par2 - 1, par3, par4) == 0 && l == 3)return false;
		return true;
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{    	
		int l = determineOrientation(world, i, j, k, (EntityPlayer)entityliving);
		if(l == 5) world.setBlockMetadataWithNotify(i, j, k, 0, 0);
		if(l == 4) world.setBlockMetadataWithNotify(i, j, k, 1, 0);
		if(l == 3) world.setBlockMetadataWithNotify(i, j, k, 2, 0); //FIXME
		if(l == 2) world.setBlockMetadataWithNotify(i, j, k, 3, 0); //Flags?
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0F, 0F, -1F, 0.2F, 2F, 1F);
		if(l == 1) setBlockBounds(0.8F, 0F, 0F, 1F, 2F, 2F);
		if(l == 2) setBlockBounds(0F, 0F, 0F, 2F, 2F, 0.2F);
		if(l == 3) setBlockBounds(-1F, 0F, 0.8F, 1F, 2F, 1F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0F, 0F, -1F, 0.2F, 2F, 1F);
		if(l == 1) setBlockBounds(0.8F, 0F, 1F, 1F, 2F, 2F);
		if(l == 2) setBlockBounds(0F, 0F, 0F, 2F, 2F, 0.2F);
		if(l == 3) setBlockBounds(-1F, 0F, 0.8F, 1F, 2F, 1F);
	} 

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	{
		return null;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int idDropped(int i, Random random, int j)
	{
		return mod_SCP.SCP151.blockID;
	}

	public int quanityDropped(Random random)
	{
		return 1;
	}

	public int getRenderType()
	{
		return mod_Others.PosterID;
	}
}
