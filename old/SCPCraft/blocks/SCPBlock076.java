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
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;

public class SCPBlock076 extends BlockContainer
{
	private Class SCPEntity076Class;

	public SCPBlock076(int i,int j, Class tClass)
	{
		super(i,Material.rock);
		//blockIndexInTexture = 43;
		SCPEntity076Class = tClass;
		this.setCreativeTab(mod_SCP.tabBlockSCP);
		this.setBlockBounds(0F, 0F, 0F, 2F, 2F, 2F);
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderBlockPass()
	{
		return 0;
	}

	public boolean canRenderInPass(int pass)
	{
		return true;
	}

	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		this.setBlockBounds(0F, 0F, 0F, 2F, 2F, 2F);
	} 

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		this.setBlockBounds(0F, 0F, 0F, 2F, 2F, 2F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
	}
	
	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		setDefaultDirection(par1World, par2, par3, par4);
	}
	
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
      //  par1World.setBlockMetadataWithNotify(par2, par3, par4, var6);
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
		return mod_SCP.SCP076.blockID;
	}

	public int quanityDropped(Random random)
	{
		return 1;
	}

	public int getRenderType()
	{
		return mod_Others.SCP076ID;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public TileEntity createNewTileEntity(World var1) 
	{
		try
		{
			return (TileEntity)SCPEntity076Class.newInstance();
		}
		catch(Exception exception)
		{
			throw new RuntimeException(exception);
		}
	}

}