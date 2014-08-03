package SCPCraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntityMountableBlock;

public class SCPBlockToilet extends Block
{
	public SCPBlockToilet(int par1, int j)
	{
		super(par1, Material.circuits);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
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
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
	{
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, 0.5F, 0.5F, 0, 0, 0, 0);
	}

	//Use this method for a custom mounting ysize.
	public static boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, float y)
	{
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, y, 0.5F, 0, 0, 0, 0);
	}

	//This is the main onBlockActivated method. Use it for fully custom mounting positions.
	public static boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, float x, float y, float z, int north, int south, int east, int west)
	{
		if (!world.isRemote)
		{
			//Looks for EMBs up to 1 block away from the activated block. Hopefully you didn't set the mounting position further away than this.
			List<SCPEntityMountableBlock> listEMB = world.getEntitiesWithinAABB(SCPEntityMountableBlock.class, AxisAlignedBB.getBoundingBox(i, j, k, i + 1.0D, j + 1.0D, k + 1.0D).expand(1D, 1D, 1D));
			for (SCPEntityMountableBlock entitytocheck : listEMB)
			{
				//Looks for an EMB created by this block.
				if (entitytocheck.getOrgBlockPosX() == i && entitytocheck.getOrgBlockPosY() == j && entitytocheck.getOrgBlockPosZ() == k)
				{
					entitytocheck.interact(entityplayer);
					return true;
				}
			}
			//Sets coordinates for mounting a north oriented block.
			float mountingX = i + x;
			float mountingY = j + y;
			float mountingZ = k + z;
			//Changes coordinates for mounting to compensate for none-north block orientation.
			if(north != south) 
			{
				int md = world.getBlockMetadata(i, j, k);
				if (md == east) 
				{
					mountingX = i + 1 - z; 
					mountingZ = k + x; 
				}
				else if (md == south) 
				{
					mountingX = i + 1 - x; 
					mountingZ = k + 1 - z; 
				}
				else if (md == west) 
				{
					mountingX = i + z; 
					mountingZ = k + 1 - x; 
				}
			}
			//Creates a new EMB if none had been created already or if the old one was bugged.
			SCPEntityMountableBlock nemb = new SCPEntityMountableBlock(world, entityplayer, i, j, k, mountingX, mountingY, mountingZ); 
			world.spawnEntityInWorld(nemb);
			nemb.interact(entityplayer);
			return true;
		}
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

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{    	
		int l = determineOrientation(world, i, j, k, (EntityPlayer)entityliving);
		if(l == 3) world.setBlockMetadataWithNotify(i, j, k, 0, 0x02); //
		if(l == 2) world.setBlockMetadataWithNotify(i, j, k, 1, 0x02); //
		if(l == 5) world.setBlockMetadataWithNotify(i, j, k, 2, 0x02); //
		if(l == 4) world.setBlockMetadataWithNotify(i, j, k, 3, 0x02); //
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0.20F, 0F, 0.0F, 0.80F, 1.3F, 0.85F);
		if(l == 1) setBlockBounds(0.20F, 0F, 0.15F, 0.80F, 1.3F, 1F);
		if(l == 2) setBlockBounds(0.0F, 0F, 0.20F, 0.85F, 1.3F, 0.80F);
		if(l == 3) setBlockBounds(0.15F, 0F, 0.20F, 1F, 1.3F, 0.80F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0.20F, 0F, 0.0F, 0.80F, 1.3F, 0.85F);
		if(l == 1) setBlockBounds(0.20F, 0F, 0.15F, 0.80F, 1.3F, 1F);
		if(l == 2) setBlockBounds(0.0F, 0F, 0.20F, 0.85F, 1.3F, 0.80F);
		if(l == 3) setBlockBounds(0.15F, 0F, 0.20F, 1F, 1.3F, 0.80F);
	} 

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		int i = par1World.getBlockMetadata(par2, par3, par4);
		if(i == 0) 
		{
			setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);	
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		

			setBlockBounds(0.20F, 0.4F, 0.185F, 0.80F, 0.6F, 0.85F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.20F, 0.4F, 0F, 0.80F, 1.3F, 0.25F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.20F, 0.6F, 0.30F, 0.80F, 1.3F, 0.37F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}
		if(i == 1) 
		{
			setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		

			setBlockBounds(0.20F, 0.4F, 0.15F, 0.80F, 0.6F, 0.85F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.20F, 0.4F, 0.75F, 0.80F, 1.3F, 1F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.20F, 0.6F, 0.63F, 0.80F, 1.3F, 0.70F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}
		if(i == 2) 
		{
			setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);	
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		

			setBlockBounds(0.15F, 0.4F, 0.20F, 0.85F, 0.6F, 0.80F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.0F, 0.4F, 0.20F, 0.25F, 1.3F, 0.8F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.30F, 0.6F, 0.20F, 0.37F, 1.3F, 0.80F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}
		if(i == 3) 
		{
			setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);	
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		

			setBlockBounds(0.15F, 0.4F, 0.20F, 0.85F, 0.6F, 0.80F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.75F, 0.4F, 0.20F, 1F, 1.3F, 0.8F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

			setBlockBounds(0.63F, 0.6F, 0.20F, 0.7F, 1.3F, 0.80F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	private boolean canPlaceCandleOn(World par1World, int par2, int par3, int par4)
	{
		if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
		{
			return true;
		}
		else
		{
			int var5 = par1World.getBlockId(par2, par3, par4);
			return var5 == Block.glass.blockID || var5 == Block.pressurePlatePlanks.blockID || var5 == Block.pressurePlateStone.blockID || var5 == this.blockID;
		}
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true) ? true : (par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true) ? true : (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true) ? true : (par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true) ? true : this.canPlaceCandleOn(par1World, par2, par3 - 1, par4))));
	}

	public int getRenderType()
	{
		return mod_Others.ToiletID;
	}
}
