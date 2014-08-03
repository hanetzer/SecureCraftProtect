package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;

public class SCPBlockKeycardSlot extends Block
{	
	/**
	 * 0: Front, 1: Top, 2: Sides, 3: top_down, 4: top_up, 5: top_left, 6: top_right
	 */
	protected Icon[] icons;

	public SCPBlockKeycardSlot(int i, int j)
	{
		super(i, Material.circuits);
		setTickRandomly(true);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public void registerIcons(IconRegister par1)
	{
		icons = new Icon[7];
		for(int i = 0; i < icons.length; i++)
		{
			switch(i)
			{
			case 0:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_Front");
				break;
			case 1:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top");
				break;
			case 2:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_Sides");
				break;
			case 3:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_down");
				break;
			case 4:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_up");
				break;
			case 5:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_left");
				break;
			case 6:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":Keycard_top_right");
				break;
			}
		}
	}

	//	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	//	{
	//		switch(par2)
	//		{
	//		default:
	//		case 0:
	//		{
	//			switch(par1)
	//			{
	//			case 0: return icons[1];
	//			case 1: return icons[1];
	//			default: return icons[0];
	//			}
	//		}
	//		}
	//	}

	public int getRenderType()
	{
		return mod_Others.KeycardSlotID;
	}

	public int tickRate()
	{
		return 55;
	}

	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
		this.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, 0, 0F, 0F, 0F);
	}

	public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
	{
		int var9 = par1World.getBlockMetadata(par2, par3, par4);
		int var10 = var9 & 8;
		var9 &= 7;
		var9 = -1;

		if (par5 == 0 && par1World.isBlockNormalCube(par2, par3 + 1, par4))
		{
			var9 = par1World.rand.nextBoolean() ? 0 : 7;
		}

		if (par5 == 1 && par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4))
		{
			var9 = 5 + par1World.rand.nextInt(2);
		}

		if (par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1))
		{
			var9 = 4;
		}

		if (par5 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1))
		{
			var9 = 3;
		}

		if (par5 == 4 && par1World.isBlockNormalCube(par2 + 1, par3, par4))
		{
			var9 = 2;
		}

		if (par5 == 5 && par1World.isBlockNormalCube(par2 - 1, par3, par4))
		{
			var9 = 1;
		}

		if (var9 == -1)
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0x02); //
		}
		else
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 + var10, 0x02); //
		}
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		if (this.redundantCanPlaceBlockAt(par1World, par2, par3, par4))
		{
			int var6 = par1World.getBlockMetadata(par2, par3, par4);
			boolean var7 = false;

			if (!par1World.isBlockNormalCube(par2, par3, par4 - 1) && var6 == 0)
			{
				var7 = true;
			}

			if (!par1World.isBlockNormalCube(par2 + 1, par3, par4) && var6 == 1)
			{
				var7 = true;
			}

			if (!par1World.isBlockNormalCube(par2, par3, par4 + 1) && var6 == 2)
			{
				var7 = true;
			}

			if (!par1World.isBlockNormalCube(par2 - 1, par3, par4) && var6 == 3)
			{
				var7 = true;
			}

			if (var7)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0x02); //
			}
		}
	}

	private boolean redundantCanPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0x02); //
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return par1World.isBlockNormalCube(par2, par3, par4 - 1) ? true : (par1World.isBlockNormalCube(par2 + 1, par3, par4) ? true : (par1World.isBlockNormalCube(par2, par3, par4 + 1) ? true : (par1World.isBlockNormalCube(par2 - 1, par3, par4))));
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{    	
		int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		// +z
		if(l == 2)
		{
			world.setBlockMetadataWithNotify(i, j, k, 0, 0x02); //
		}  
		// -x
		if(l == 3)
		{
			world.setBlockMetadataWithNotify(i, j, k, 1, 0x02); //
		}
		// -z
		if(l == 0)
		{
			world.setBlockMetadataWithNotify(i, j, k, 2, 0x02); //
		}
		// +x
		if(l == 1)
		{
			world.setBlockMetadataWithNotify(i, j, k, 3, 0x02); //
		}
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem(); 
		int i = par1World.getBlockMetadata(par2, par3, par4);
		int j = i & 7;
		if (par1World.isRemote)
		{
			return true;
		}
		else{
			if(itemstack != null && (itemstack.itemID == mod_SCP.L1Keycard.itemID || itemstack.itemID == mod_SCP.L2Keycard.itemID || itemstack.itemID == mod_SCP.L3Keycard.itemID || itemstack.itemID == mod_SCP.OmniKeycard.itemID)) 
			{
				int k = 8 - (i & 8);
				par1World.setBlockMetadataWithNotify(par2, par3, par4, j + k, 0x02); //
				par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, 0.6F);
				this.func_82536_d(par1World, par2, par3, par4, j);
				par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());

			}else
			{
				if(itemstack != null && (itemstack.itemID == mod_SCP.Wrench.itemID || itemstack.itemID == mod_SCP.GodlyWrench.itemID)) {
					par1World.setBlockMetadataWithNotify(par2, par3, par4, mod_SCP.KeycardSlotLv2.blockID, j);
					itemstack.damageItem(1, par5EntityPlayer);
					if(par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("Keycard Level: 2");
					}

					if(!par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("Keycard Level: 2");
					}
				}
				else
				{
					if(par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("You need a Level 1 or higher Keycard to activate.");
					}
					if(!par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("You need a Level 1 or higher Keycard to activate.");
					}
				}
			}		
			par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, tickRate());
		}
		return true;
	}

	/**
	 * Is this block indirectly powering the block on the specified side
	 */
	public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		int i1 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

		if ((i1 & 8) == 0)
		{
			return 0;
		}
		else
		{
			int j1 = i1 & 7;
			return j1 == 5 && par5 == 1 ? 15 : (j1 == 4 && par5 == 2 ? 15 : (j1 == 3 && par5 == 3 ? 15 : (j1 == 2 && par5 == 4 ? 15 : (j1 == 1 && par5 == 5 ? 15 : 0))));
		}
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this change based on its state.
	 */
	public boolean canProvidePower()
	{
		return true;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	} 

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);      
		int m = l & 7;        
		if(m == 0 || m == 4)
		{
			setBlockBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.25F);
		}       
		if(m == 1 || m == 5)
		{
			setBlockBounds(0.75F, 0.2F, 0.3F, 1.0F, 0.8F, 0.6F);
		}       
		if(m == 2 || m == 6)
		{
			setBlockBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.8F, 1.0F);
		}       
		if(m == 3 || m == 7)
		{
			setBlockBounds(0.0F, 0.2F, 0.33F, 0.25F, 0.8F, 0.66F);
		}        
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);         
		int m = l & 7;     
		if(m == 0 || m == 4)
		{
			setBlockBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.25F);
		}         
		if(m == 1 || m == 5)
		{
			setBlockBounds(0.75F, 0.2F, 0.33F, 1.0F, 0.8F, 0.66F);
		}      
		if(m == 2 || m == 6)
		{
			setBlockBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.8F, 1.0F);
		}      
		if(m == 3 || m == 7)
		{
			setBlockBounds(0.0F, 0.2F, 0.33F, 0.25F, 0.8F, 0.66F);
		} 
	}    

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		int par3 = par2 & 7;
		if(par3 == 0 || par3 == 4)
		{
			// 1 = top; 0 = bottom; 2 = back; 3 = front; 4 = right; 5 = left
			if(par1 == 3) return icons[0];
			else if(par1 == 1) return icons[4]; //SlotTop1 		
			else return icons[2];
		}
		if(par3 == 1 || par3 == 5)
		{
			if(par1 == 4) return icons[0];
			else if(par1 == 1) return icons[6]; //SlotTop3
			else return icons[2];
		}
		if(par3 == 2 || par3 == 6)
		{
			if(par1 == 2) return icons[0];
			else if(par1 == 1) return icons[3]; //SlotTop 
			else return icons[2];
		}
		if(par3 == 3 || par3 == 7)
		{
			if(par1 == 5) return icons[0];
			else if(par1 == 1) return icons[5]; //SlotTop2
			else return icons[2];
		}
		return icons[0];
	}

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List arraylist, Entity par7Entity)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);      
		int m = l & 7;
		if(m == 0 || m == 4)
		{
			setBlockBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.18F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);

			setBlockBounds(0.33F, 0.2F, 0.18F, 0.66F, 0.4F, 0.25F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);
		}     
		if(m == 1 || m == 5)
		{
			setBlockBounds(0.82F, 0.2F, 0.33F, 1.0F, 0.8F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);

			setBlockBounds(0.75F, 0.2F, 0.33F, 0.82F, 0.4F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);
		}     
		if(m == 2 || m == 6)
		{
			setBlockBounds(0.33F, 0.2F, 0.82F, 0.66F, 0.8F, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);

			setBlockBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.4F, 0.82F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);
		}     
		if(m == 3 || m == 7)
		{
			setBlockBounds(0.0F, 0.2F, 0.33F, 0.18F, 0.8F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);

			setBlockBounds(0.18F, 0.2F, 0.33F, 0.25F, 0.4F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, arraylist, par7Entity);
		}  
	}

	public int quantityDropped(Random random)
	{
		return 1;
	}

	public int damageDropped(int i) 
	{
		return i;
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if ((par6 & 8) > 0)
		{
			int var7 = par6 & 7;
			this.func_82536_d(par1World, par2, par3, par4, var7);
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * Is this block powering the block on the specified side
	 */
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) > 0 ? 15 : 0;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			int var6 = par1World.getBlockMetadata(par2, par3, par4);
			par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 & 7, 0); //
			int var7 = var6 & 7;
			this.func_82536_d(par1World, par2, par3, par4, var7);
		}
	}

	protected void func_82536_d(World par1World, int par2, int par3, int par4, int par5)
	{
		par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);

		if (par5 == 0 || par5 == 4)
		{
			par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
		}
		else if (par5 == 1 || par5 == 5)
		{
			par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
		}
		else if (par5 == 2 || par5 == 6)
		{
			par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
		}
		else if (par5 == 3 || par5 == 7)
		{
			par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
		}
		else
		{
			par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
		}
	}
}
