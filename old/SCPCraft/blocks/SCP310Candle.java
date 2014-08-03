package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;

public class SCP310Candle extends Block
{
	private Icon[] icons;
	public SCP310Candle(int par1, int j)
	{
		super(par1, Material.circuits);
		this.setTickRandomly(true);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}
	
//	public void registerIcons(IconRegister par1)
//	{
//		icons = new Icon[7];
//		for(int i = 0; i < icons.length; i++)
//		{
//			switch(i)
//			{
//			case 0:
//				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_Front");
//				break;
//			case 1:
//				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top");
//				break;
//			case 2:
//				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_Sides");
//				break;
//			case 3:
//				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_down");
//				break;
//			case 4:
//				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_up");
//				break;
//			case 5:
//				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_left");
//				break;
//			case 6:
//				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_right");
//				break;
//			}
//		}
//	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		setBlockBounds(0.4F, 0.2F, 0.4F, 0.6F, 0.5F, 0.6F);  
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.2F, 0.7F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int var6 = 0;
		int var7;
		int var8;

		for (var7 = 0; var7 < 7; ++var7)
		{
			par2 += par5Random.nextInt(3) - 1;
			++par3;
			par4 += par5Random.nextInt(3) - 1;
			var8 = par1World.getBlockId(par2, par3, par4);

			if (var8 == 0)
			{
				if (this.isFlammable(par1World, par2 - 1, par3, par4) || this.isFlammable(par1World, par2 + 1, par3, par4) || this.isFlammable(par1World, par2, par3, par4 - 1) || this.isFlammable(par1World, par2, par3, par4 + 1) || this.isFlammable(par1World, par2, par3 - 1, par4) || this.isFlammable(par1World, par2, par3 + 1, par4))
				{
					par1World.setBlock(par2, par3, par4, mod_SCP.SCP310Fire.blockID);
					return;
				}
			}
			else if (Block.blocksList[var8].blockMaterial.blocksMovement())
			{
				return;
			}
		}

		if (var6 == 0)
		{
			var7 = par2;
			var8 = par4;

			for (int var9 = 0; var9 < 3; ++var9)
			{
				par2 = var7 + par5Random.nextInt(3) - 1;
				par4 = var8 + par5Random.nextInt(3) - 1;

				if (par1World.isAirBlock(par2, par3 + 1, par4) && this.isFlammable(par1World, par2, par3, par4))
				{
					par1World.setBlock(par2, par3 + 1, par4, mod_SCP.SCP310Fire.blockID);
				}
			}
		}
	}

	private boolean isFlammable(World par1World, int par2, int par3, int par4)
	{
		return par1World.getBlockMaterial(par2, par3, par4).getCanBurn();
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
		return mod_Others.SCP310ID;
	}

	public int tickRate()
	{
		return 1;
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		double var7 = (double)((float)par2 + 0.5F);
		double var9 = (double)((float)par3 + 0.65F);
		double var11 = (double)((float)par4 + 0.5F);
		par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
	{
		var1.setBlock(var2 + 1, var3 - 1, var4, mod_SCP.SCP310Fire.blockID);
		var1.setBlock(var2 - 1, var3 - 1, var4, mod_SCP.SCP310Fire.blockID);
		var1.setBlock(var2, var3 - 1, var4 + 1, mod_SCP.SCP310Fire.blockID);
		var1.setBlock(var2, var3 - 1, var4 - 1, mod_SCP.SCP310Fire.blockID);
		return true;
	}
}
