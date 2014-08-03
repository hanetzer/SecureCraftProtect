package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import SCPCraft.SCPDamageSource;
import SCPCraft.mod_SCP;

public class SCPBlock143Leaves extends BlockLeavesBase
{
	private int fancyg = 1;
	private int fastg = 47;
	private int hurrdurr;
	int adjacentTreeBlocks[];

	public SCPBlock143Leaves(int i)
	{
		super(i, Material.leaves, false);
		setTickRandomly(true);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		float var5 = 0.125F;
		return AxisAlignedBB.getAABBPool().getAABB((double)(par2 + var5), (double)(par3 + var5), (double)(par4 + var5), (double)((par2 + 1) - var5), (double)((float)(par3 + 1) - var5), (double)((par4 + 1) - var5));
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.attackEntityFrom(SCPDamageSource.SCP143, 4);
	}

	public int getBlockColor()
	{
		double d = 0.5D;
		double d1 = 1.0D;
		return 0;
	}

	public void onBlockRemoval(World world, int i, int j, int k)
	{
		int l = 1;
		int i1 = l + 1;
		if(world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
		{
			for(int j1 = -l; j1 <= l; j1++)
			{
				for(int k1 = -l; k1 <= l; k1++)
				{
					for(int l1 = -l; l1 <= l; l1++)
					{
						int i2 = world.getBlockId(i + j1, j + k1, k + l1);
						if(i2 == mod_SCP.SCP143Leaves.blockID)              ///////Leaf/////////////
						{
							int j2 = world.getBlockMetadata(i + j1, j + k1, k + l1);
							world.setBlock(i + j1, j + k1, k + l1, j2 | 8); //setBlockMetadata
						}
					}

				}

			}

		}
	}

	public void updateTick(World world, int i, int j, int k, Random random)
	{
		if(world.isRemote)
		{
			return;
		}
		int l = world.getBlockMetadata(i, j, k);
		if((l & 8) != 0 && (l & 4) == 0)
		{
			byte byte0 = 4;
			int i1 = byte0 + 1;
			byte byte1 = 32;
			int j1 = byte1 * byte1;
			int k1 = byte1 / 2;
			if(adjacentTreeBlocks == null)
			{
				adjacentTreeBlocks = new int[byte1 * byte1 * byte1];
			}
			if(world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
			{
				for(int l1 = -byte0; l1 <= byte0; l1++)
				{
					for(int k2 = -byte0; k2 <= byte0; k2++)
					{
						for(int i3 = -byte0; i3 <= byte0; i3++)
						{
							int k3 = world.getBlockId(i + l1, j + k2, k + i3);
							if(k3 == mod_SCP.SCP143Log.blockID)            ///////Log//////////////
							{
								adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = 0;
								continue;
							}
							if(k3 == mod_SCP.SCP143Leaves.blockID)               ///////Leaf///////////
							{
								adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -2;
							} else
							{
								adjacentTreeBlocks[(l1 + k1) * j1 + (k2 + k1) * byte1 + (i3 + k1)] = -1;
							}
						}

					}

				}

				for(int i2 = 1; i2 <= 4; i2++)
				{
					for(int l2 = -byte0; l2 <= byte0; l2++)
					{
						for(int j3 = -byte0; j3 <= byte0; j3++)
						{
							for(int l3 = -byte0; l3 <= byte0; l3++)
							{
								if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] != i2 - 1)
								{
									continue;
								}
								if(adjacentTreeBlocks[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
								{
									adjacentTreeBlocks[((l2 + k1) - 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
								}
								if(adjacentTreeBlocks[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] == -2)
								{
									adjacentTreeBlocks[(l2 + k1 + 1) * j1 + (j3 + k1) * byte1 + (l3 + k1)] = i2;
								}
								if(adjacentTreeBlocks[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] == -2)
								{
									adjacentTreeBlocks[(l2 + k1) * j1 + ((j3 + k1) - 1) * byte1 + (l3 + k1)] = i2;
								}
								if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] == -2)
								{
									adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1 + 1) * byte1 + (l3 + k1)] = i2;
								}
								if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] == -2)
								{
									adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + ((l3 + k1) - 1)] = i2;
								}
								if(adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] == -2)
								{
									adjacentTreeBlocks[(l2 + k1) * j1 + (j3 + k1) * byte1 + (l3 + k1 + 1)] = i2;
								}
							}

						}

					}

				}

			}
			int j2 = adjacentTreeBlocks[k1 * j1 + k1 * byte1 + k1];
			if(j2 >= 0)
			{
				world.setBlock(i, j, k, l & -9);
			} else
			{
				removeLeaves(world, i, j, k);
			}
		}
	}

	private void removeLeaves(World world, int i, int j, int k)
	{
		dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
		world.setBlockMetadataWithNotify(i, j, k, 0, 0);
	}

	public int quantityDropped(Random random)
	{
		return random.nextInt(20) != 0 ? 0 : 1;
	}

	public int idDropped(int i, Random random, int j)
	{
		return mod_SCP.SCP143Sapling.blockID;
	}

	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
	{
		if (!world.isRemote && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.shears.itemID)
		{
			entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
			dropBlockAsItem_do(world, i, j, k, new ItemStack(Block.leaves.blockID, 1, l & 3));
		}
		else
		{
			super.harvestBlock(world, entityplayer, i, j, k, l);
		}
	}

	public int damageDropped(int i)
	{
		return i & 3;
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 0;
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
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public Icon getBlockTextureFromSideAndMetadata(int i, int j)
	{
	/*	Minecraft mc = ModLoader.getMinecraftInstance();
		if(mc.gameSettings.fancyGraphics || Minecraft.isFancyGraphicsEnabled())
		{
			return fancyg;
		}
		else
		{
			return fastg;
		} */
		return super.getBlockTextureFromSideAndMetadata(i, j);
	}

	public void setGraphicsLevel(boolean flag)
	{
		graphicsLevel = flag;
		//this.blockIcon = this.hurrdurr + (flag ? 0 : 1);
	}

	public void registerIcons(IconRegister par1)
	{
		blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
	}

	public void onEntityWalking(World world, int i, int j, int k, Entity entity)
	{
		super.onEntityWalking(world, i, j, k, entity);
	}
}
