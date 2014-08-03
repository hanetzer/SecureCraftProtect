package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntityRemoteDoorComp;

public class SCPBlockRemoteDoorComputer extends BlockContainer
{	
	private Class SCPEntityRemoteDoorClass;
	
	public SCPBlockRemoteDoorComputer(int i, int j)
	{
		super(i, Material.iron);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	/**
	 * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
	 * block.
	 */
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
		if(!par1World.isRemote)
		{
			int var10 = par1World.getBlockMetadata(par2, par3, par4);
            int var12 = 8 - (var10 & 8);
            
			if(mod_Others.remoteDoorActivate)
			{
				mod_Others.remoteDoorActivate = false;
				par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, var12 > 0 ? 0.6F : 0.5F);
				par5EntityPlayer.addChatMessage("Remote doors have been deactivated!");
			}
			else
			{
				mod_Others.remoteDoorActivate = true;
				par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, var12 > 0 ? 0.6F : 0.5F);
				par5EntityPlayer.addChatMessage("Remote doors have been reactivated!");				
			}
		}
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.RemoteDoorComputer.blockID;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k); 
		//f:2
		if(l == 0) setBlockBounds(0F, 0.0F, 0.1F, 1F, 2.2F, 1F);
		//f:3
		if(l == 1) setBlockBounds(0F, 0.0F, 0F, 1F, 2.2F, 1F);
		
		if(l == 2) setBlockBounds(0F, 0.0F, 0.1F, 1F, 2.2F, 1F);
		if(l == 3) setBlockBounds(0F, 0.0F, 0F, 1F, 2.2F, 1F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0F, 0.0F, 0.1F, 1F, 2.2F, 1F);
		if(l == 1) setBlockBounds(0F, 0.0F, 0F, 1F, 2.2F, 1F);
		if(l == 2) setBlockBounds(0F, 0.0F, 0.1F, 1F, 2.2F, 1F);
		if(l == 3) setBlockBounds(0F, 0.0F, 0F, 1F, 2.2F, 1F);
	} 

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		int i = par1World.getBlockMetadata(par2, par3, par4);
		if(i == 0) setBlockBounds(0F, 0.0F, 0.1F, 1F, 2.2F, 1F);
		if(i == 1) setBlockBounds(0F, 0.0F, 0F, 1F, 2.2F, 1F);
		if(i == 2) setBlockBounds(0F, 0.0F, 0.1F, 1F, 2.2F, 1F);
		if(i == 3) setBlockBounds(0F, 0.0F, 0F, 1F, 2.2F, 1F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);	
	}

	public int quanityDropped(Random random)
	{
		return 1;
	}

	public int getRenderType()
	{
		return mod_Others.RemoteDoorCompID;
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
		//setDefaultDirection(par1World, par2, par3, par4);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var6, 0x02); //
	}

	/*private void setDefaultDirection(World par1World, int par2, int par3, int par4)
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

		par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
	}*/

	/**
	 * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
	 * block.
	 */
	public void breakBlock(World var1, int var2, int var3, int var4, int var5, int var6)
	{
		ModLoader.genericContainerRemoval(var1, var2, var3, var4);
		super.breakBlock(var1, var2, var3, var4, var5, var6);
	}

	public TileEntity createNewTileEntity(World var1)
	{
		return new SCPTileEntityRemoteDoorComp();
	}

}
