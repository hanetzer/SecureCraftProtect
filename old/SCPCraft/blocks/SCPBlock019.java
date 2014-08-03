package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPBlock019 extends BlockContainer
{
	private Class SCPEntity019Class;

	public SCPBlock019(int i,Class tClass)
	{
		super(i,Material.rock);
		//	blockIndexInTexture = 21;
		setBlockBounds(-0.06F, 0.0F, 0.26F, 1.05F, 1.62F, 0.75F);
		SCPEntity019Class = tClass;
	}

	public void registerIcons(IconRegister par1)
	{
		blockIcon = par1.registerIcon(Block.blockClay.getUnlocalizedName2());
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0 || l == 2) setBlockBounds(-0.06F, 0.0F, 0.26F, 1.05F, 1.62F, 0.75F);
		if(l == 1 || l == 3) setBlockBounds(0.26F, 0.0F, -0.06F, 0.75F, 1.62F, 1.05F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0 || l == 2) setBlockBounds(-0.06F, 0.0F, 0.26F, 1.05F, 1.62F, 0.75F);
		if(l == 1 || l == 3) setBlockBounds(0.26F, 0.0F, -0.06F, 0.75F, 1.62F, 1.05F);
	} 

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		int i = par1World.getBlockMetadata(par2, par3, par4);
		if(i == 0 || i == 2) setBlockBounds(-0.06F, 0.0F, 0.26F, 1.05F, 1.62F, 0.75F);
		if(i == 1 || i == 3) setBlockBounds(0.26F, 0.0F, -0.06F, 0.75F, 1.62F, 1.05F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);	
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		setDefaultDirection(par1World, par2, par3, par4);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		//par1World.setBlockMetadataWithNotify(par2, par3, par4, var6);
	}

	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (par1World.isRemote)
		{
			return;
		}

		int i = par1World.getBlockId(par2, par3, par4 - 1);
		int j = par1World.getBlockId(par2, par3, par4 + 1);
		int k = par1World.getBlockId(par2 - 1, par3, par4);
		int l = par1World.getBlockId(par2 + 1, par3, par4);
		byte byte0 = 3;

		if (Block.opaqueCubeLookup[i] && !Block.opaqueCubeLookup[j])
		{
			byte0 = 3;
		}

		if (Block.opaqueCubeLookup[j] && !Block.opaqueCubeLookup[i])
		{
			byte0 = 2;
		}

		if (Block.opaqueCubeLookup[k] && !Block.opaqueCubeLookup[l])
		{
			byte0 = 5;
		}

		if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[k])
		{
			byte0 = 4;
		}

		//par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
	}

	public int idDropped(int i, Random random, int j)
	{
		return mod_SCP.Item019.itemID;
	}

	public int quanityDropped(Random random)
	{
		return 1;
	}

	public int getRenderType()
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return mod_SCP.Item019.itemID;
	}

	public TileEntity createNewTileEntity(World var1) {
		try
		{
			return (TileEntity)SCPEntity019Class.newInstance();
		}
		catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

}