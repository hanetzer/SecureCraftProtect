package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;

public class SCPSmokeBlock extends Block
{
	/**
	 * 0: down, 1: top, 2: sidedown, 3: sideup, 4: sideleft, 5: sideright, // 6: sideleftinverted, 7: siderightinverted
	 */
	private Icon[] icons;

	public SCPSmokeBlock(int par1, int j)
	{
		super(par1, Material.iron);
		setTickRandomly(true);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public void registerIcons(IconRegister par1)
	{
		icons = new Icon[6];
		for(int i = 0; i < icons.length; i++)
		{
			switch(i)
			{
			case 0:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_Bottom");
				break;
			case 1:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_Top");
				break;
			case 2:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_SideDown");
				break;
			case 3:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_SideUp");
				break;
			case 4:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_SideLeft");
				break;
			case 5:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_SideRight");
				break;
			case 6:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_LeftInverted");
				break;
			default:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SmokeBlock_RightInverted");
				break;
			}
		}
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getBlockTextureFromSideAndMetadata(int i, int j)
	{
		if(j == 0) 
		{
			if (i == 0)	return icons[0]; //25
			if (i == 1)	return icons[1]; //30
			if (i == 2)	return icons[3]; //26
			if (i == 3)	return icons[3];
			if (i == 4)	return icons[3];
			if (i == 5)	return icons[3];
		}    	
		if(j == 2)
		{
			if (i == 5)	return icons[1];
			if (i == 4)	return icons[0];
			if (i == 0)	return icons[5]; //28
			if (i == 1)	return icons[5];
			if (i == 2)	return icons[6]; //44
			if (i == 3)	return icons[5];
		}
		if(j == 1)
		{
			if (i == 0)	return icons[1];
			if (i == 1)	return icons[0];
			if (i == 2)	return icons[2]; //27
			if (i == 3)	return icons[2];
			if (i == 4)	return icons[2];
			if (i == 5)	return icons[2];
		}
		if(j == 4)
		{
			if (i == 4)	return icons[1];
			if (i == 5)	return icons[0];
			if (i == 2)	return icons[7]; //45
			if (i == 3)	return icons[4]; //29
			if (i == 0)	return icons[4];
			if (i == 1)	return icons[4];
		}
		if(j == 3)
		{
			if (i == 3)	return icons[1];
			if (i == 2)	return icons[0];
			if (i == 1)	return icons[2];
			if (i == 0)	return icons[2];
			if (i == 4)	return icons[5];
			if (i == 5)	return icons[6];
		}
		if(j == 5)
		{
			if (i == 2)	return icons[1];
			if (i == 3)	return icons[0];
			if (i == 4)	return icons[4];
			if (i == 5)	return icons[7];
			if (i == 1)	return icons[3];
			if (i == 0)	return icons[3];
		}

		return icons[0];
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return mod_Others.SmokeBlockID;
	}

	public int func_85104_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	{
		int var10 = par9 & 3;
		byte var11 = 0;

		switch (par5)
		{
		case 0:
			var11 = 1;
			break;
		case 1:
			var11 = 0;
			break;
		case 2:
			var11 = 5;
			break;
		case 3:
			var11 = 3;
			break;
		case 4:
			var11 = 4;
			break;
		case 5:
			var11 = 2;
		}

		return var10 | var11;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
		if(l == 1) setBlockBounds(0.0F, 0.1875F, 0.0F, 1.0F, 1.0F, 1.0F);
		if(l == 2) setBlockBounds(0.0F, 0.0F, 0.0F, 0.8125F, 1F, 1.0F);
		if(l == 3) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.8125F);
		if(l == 4) setBlockBounds(0.1875F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
		if(l == 5) setBlockBounds(0.0F, 0.0F, 0.1875F, 1.0F, 1F, 1.0F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);
		if(l == 0) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
		if(l == 1) setBlockBounds(0.0F, 0.1875F, 0.0F, 1.0F, 1.0F, 1.0F);
		if(l == 2) setBlockBounds(0.0F, 0.0F, 0.0F, 0.8125F, 1F, 1.0F);
		if(l == 3) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.8125F);
		if(l == 4) setBlockBounds(0.1875F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
		if(l == 5) setBlockBounds(0.0F, 0.0F, 0.1875F, 1.0F, 1F, 1.0F);
	} 

	/**
	 * Adds to the supplied array any colliding bounding boxes with the passed in bounding box. Args: world, x, y, z,
	 * axisAlignedBB, arrayList
	 */
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		int i = par1World.getBlockMetadata(par2, par3, par4);
		if(i == 0) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
		if(i == 1) setBlockBounds(0.0F, 0.1875F, 0.0F, 1.0F, 1.0F, 1.0F);
		if(i == 2) setBlockBounds(0.0F, 0.0F, 0.0F, 0.8125F, 1F, 1.0F);
		if(i == 3) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.8125F);
		if(i == 4) setBlockBounds(0.1875F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
		if(i == 5) setBlockBounds(0.0F, 0.0F, 0.1875F, 1.0F, 1F, 1.0F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
	}

	public int tickRate()
	{
		return 0;
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int i = par1World.getBlockMetadata(par2, par3, par4);
		double d = (float)par2 + 0.5F;
		double d1 = (float)par3 + 0.7F;
		double d2 = (float)par4 + 0.5F;
		double d3 = 0.004D;
		double d4 = 0.004D;
		double d5 = 0.8125D;
		if(i == 0 && par1World.getBlockId(par2, par3 + 1, par4) == 0) {
			par1World.spawnParticle("SCPsmoke", d - d4, d1 + d5, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke", d + d4, d1 + d5, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke", d + d4, d1 + d5, d2 - d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke", d - d4, d1 + d5, d2 - d3, 0.0D, 0.0D, 0.0D);   
		}
		if(i == 1 && par1World.getBlockId(par2, par3 - 1, par4) == 0) {
			par1World.spawnParticle("SCPsmoke2", d - d4, d1 - d5, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke2", d + d4, d1 - d5, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke2", d + d4, d1 - d5, d2 - d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke2", d - d4, d1 - d5, d2 - d3, 0.0D, 0.0D, 0.0D);     
		}  
		if(i == 2 && par1World.getBlockId(par2 + 1, par3, par4) == 0) {
			par1World.spawnParticle("SCPsmoke3", d + d5, d1 - d3, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke3", d + d5, d1 + d3, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke3", d + d5, d1 + d3, d2 - d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke3", d + d5, d1 - d3, d2 - d3, 0.0D, 0.0D, 0.0D);   
		}
		if(i == 3 && par1World.getBlockId(par2, par3, par4 + 1) == 0) {
			par1World.spawnParticle("SCPsmoke4", d - d4, d1 + d3, d2 + d5, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke4", d + d4, d1 + d3, d2 + d5, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke4", d + d4, d1 - d3, d2 + d5, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke4", d - d4, d1 - d3, d2 + d5, 0.0D, 0.0D, 0.0D); 
		}  
		if(i == 4 && par1World.getBlockId(par2 - 1, par3, par4) == 0) {
			par1World.spawnParticle("SCPsmoke5", d - d5, d1 - d3, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke5", d - d5, d1 + d3, d2 + d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke5", d - d5, d1 + d3, d2 - d3, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke5", d - d5, d1 - d3, d2 - d3, 0.0D, 0.0D, 0.0D); 
		}
		if(i == 5 && par1World.getBlockId(par2, par3, par4 - 1) == 0) {
			par1World.spawnParticle("SCPsmoke6", d - d4, d1 + d3, d2 - d5, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke6", d + d4, d1 + d3, d2 - d5, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke6", d + d4, d1 - d3, d2 - d5, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("SCPsmoke6", d - d4, d1 - d3, d2 - d5, 0.0D, 0.0D, 0.0D);   
		} 
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			onBlockAdded(par1World, par2, par3, par4);
		}
	}
}
