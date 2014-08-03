package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import SCPCraft.mod_SCP;
import SCPCraft.worldgen.SCPWorldGen143;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, World, WorldGenTaiga2, WorldGenForest, 
//            WorldGenTrees, WorldGenBigTree, WorldGenerator

public class SCPBlock143Sapling extends BlockFlower
{
	public SCPBlock143Sapling(int i, int j)
	{
		super(i, Material.ground);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public void registerIcons(IconRegister par1)
	{
		blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
	}

	protected boolean canThisPlantGrowOnThisBlockID(int i)
	{
		return i == Block.grass.blockID;
	}

	public void updateTick(World world, int i, int j, int k, Random random)
	{
		if(world.isRemote)
		{
			return;
		}
		super.updateTick(world, i, j, k, random);

		if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
		{
			int l = world.getBlockMetadata(i, j, k);
			if((l & 8) == 0)
			{
				world.setBlockMetadataWithNotify(i, j, k, l | 8, 0x02);
			} else
			{
				growTree(world, i, j, k, random);
			}
		}
	}

	/*	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		j &= 3;
		if(j == 1)
		{
			return blockIndexInTexture;  //63
		}
		if(j == 2)
		{
			return blockIndexInTexture; //79
		} else
		{
			//return super.getBlockTextureFromSideAndMetadata(i, j);
			return blockIndexInTexture;
		}
	}*/

	public void growTree(World world, int i, int j, int k, Random random)
	{
		int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, 0);
		Object obj = null;
		obj = new SCPWorldGen143();
		/*if(l == 1)
        {
            obj = new WorldGenTaiga2(true);
        } else
        if(l == 2)
        {
            obj = new WorldGenForest(true);
        } else
        {
            obj = new WorldGenTrees(true);
            if(random.nextInt(10) == 0)
            {
                obj = new WorldGenBigTree(true);
            }
        }*/
		if(!((WorldGenerator) (obj)).generate(world, random, i, j, k))
		{
			world.setBlockMetadataWithNotify(i, j, k, blockID, l);
		}
	}

	public int damageDropped(int i)
	{
		return i & 3;
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
		else
		{
			if(itemstack != null && (itemstack.itemID == Item.dyePowder.itemID))
			{

				if (itemstack.getItemDamage() == 15)
				{
					((SCPBlock143Sapling)mod_SCP.SCP143Sapling).growTree(par1World, par2, par3, par4, par1World.rand);
				}
			}
		}
		return true;
	}
}
