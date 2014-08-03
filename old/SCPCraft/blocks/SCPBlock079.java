package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.guis.SCPGui079;
import SCPCraft.tileentities.SCPTileEntity079;

public class SCPBlock079 extends BlockContainer
{
	public SCPBlock079(int par1, int j)
	{
		super(par1, Material.iron);
		this.setTickRandomly(true);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
		disableStats();
	}

	public int tickRate()
	{
		return 0;
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		setBlockBounds(-0.7F, 0F, -0.65F, 1.8F, 1.2F, 1F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{         
		setBlockBounds(-0.7F, 0F, -0.65F, 1.8F, 1.2F, 1F);
	} 

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if(!mod_Others.wantsToTalk)return false;
		ModLoader.openGUI(par5EntityPlayer, new SCPGui079(par1World, null, par5EntityPlayer, ""));
		((par5EntityPlayer)).addStat(mod_SCP.hacker, 1);
		return true;
	}

/*	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
		int i = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		int j = par1World.getBlockMetadata(par2, par3, par4) & 12;

		if (i == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | j);
		}
		else if (i == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | j);
		}
		else if (i == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | j);
		}
		else if (i == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | j);
		}
	} */

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		setBlockBounds(0.0F, 0F, 0.13F, 1F, 1.2F, 1F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0F, 0.0F, -0.65F, 1F, 0.3F, 0.07F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(-0.7F, 0F, -0.2F, -0.2F, 0.2F, 0.6F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(1.2F, 0F, 0.1F, 1.8F, 0.3F, 1F);		
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);	
		setBlockBounds(1.67F, 0.1F, -0.05F, 1.77F, 0.25F, 0.1F);	
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		
		setBlockBounds(1.52F, 0.1F, -0.05F, 1.62F, 0.25F, 0.1F);	
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		
		setBlockBounds(1.37F, 0.1F, -0.05F, 1.47F, 0.25F, 0.1F);	
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		
		setBlockBounds(1.22F, 0.1F, -0.05F, 1.32F, 0.25F, 0.1F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.46F, 0.0F, 0.07F, 0.52F, 0.15F, 0.2F);		
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);			
		setBlockBounds(-0.2F, 0.0F, 0.25F, 0F, 0.15F, 0.4F);	
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);			
		setBlockBounds(1F, 0.0F, 0.35F, 1.2F, 0.05F, 0.4F);		
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);	
		setBlockBounds(1F, 0.0F, 0.45F, 1.2F, 0.05F, 0.5F);		
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);	
		setBlockBounds(1F, 0.0F, 0.55F, 1.2F, 0.05F, 0.6F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(1F, 0.0F, 0.65F, 1.2F, 0.05F, 0.7F);	
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		
		setBlockBounds(1F, 0.1F, 0.4F, 1.2F, 0.15F, 0.45F);			
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
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

	public Random rand = new Random();
	
/*	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		if(par1 == 2 && mod_Others.wantsToTalk && rand.nextInt(10) == 0) blockIndexInTexture = 52;
		else if(par1 == 2 && mod_Others.wantsToTalk)blockIndexInTexture = 50;
		if(par1 == 2 && !mod_Others.wantsToTalk)blockIndexInTexture = 51;  
		if(par1 != 2)blockIndexInTexture = 54;
		return blockIndexInTexture;
	}*/

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return mod_Others.SCP079ID;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new SCPTileEntity079();
	}
}
