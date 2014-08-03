package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntity294;

public class SCPBlock294 extends BlockContainer
{
	private Class SCPEntity294Class;

	public SCPBlock294(int par1)
	{
		super(par1, Material.rock);
	}

	public void registerIcons(IconRegister par1)
	{
		blockIcon = par1.registerIcon(Block.obsidian.getUnlocalizedName2());
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.Item294.itemID;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return mod_SCP.Item294.itemID;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.6F, 0.85F);
		if(l == 1) setBlockBounds(0.1F, 0.0F, 0.1F, 0.85F, 1.6F, 0.9F);
		if(l == 2) setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.6F, 0.85F);
		if(l == 3) setBlockBounds(0.1F, 0.0F, 0.1F, 0.85F, 1.6F, 0.9F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.6F, 0.85F);
		if(l == 1) setBlockBounds(0.1F, 0.0F, 0.1F, 0.85F, 1.6F, 0.9F);
		if(l == 2) setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.6F, 0.85F);
		if(l == 3) setBlockBounds(0.1F, 0.0F, 0.1F, 0.85F, 1.6F, 0.9F);
	} 

	public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		int i = par1World.getBlockMetadata(par2, par3, par4);
		if(i == 0) setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.6F, 0.85F);
		if(i == 1) setBlockBounds(0.1F, 0.0F, 0.1F, 0.85F, 1.6F, 0.9F);
		if(i == 2) setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.6F, 0.85F);
		if(i == 3) setBlockBounds(0.1F, 0.0F, 0.1F, 0.85F, 1.6F, 0.9F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);	
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

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
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

	/**
	 * set a blocks direction
	 */
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

		par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0, 0);
	}

	/**
	 * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
	 * block.
	 */
	private Random furnaceRand = new Random();	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		SCPTileEntity294 var7 = (SCPTileEntity294)par1World.getBlockTileEntity(par2, par3, par4);
		if (var7 != null)
		{
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
			{
				ItemStack var9 = var7.getStackInSlot(var8);

				if (var9 != null)
				{
					float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
					float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
					float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

					while (var9.stackSize > 0)
					{
						int var13 = this.furnaceRand.nextInt(21) + 10;

						if (var13 > var9.stackSize)
						{
							var13 = var9.stackSize;
						}

						var9.stackSize -= var13;
						EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

						if (var9.hasTagCompound())
						{
							var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
						}

						float var15 = 0.05F;
						var14.motionX = (double)((float)this.furnaceRand.nextGaussian() * var15);
						var14.motionY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
						var14.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
						par1World.spawnEntityInWorld(var14);
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
	 * block.
	 */
	 public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
	{
		TileEntity tileEntity = var1.getBlockTileEntity(var2, var3, var4);

		if (tileEntity == null || var5.isSneaking()) {
			return false;
		}

		var5.openGui(mod_SCP.instance, 2, var1, var2, var3, var4);
		return true;
	}

	public TileEntity createNewTileEntity(World var1)
	{
		return new SCPTileEntity294();
	}

}
