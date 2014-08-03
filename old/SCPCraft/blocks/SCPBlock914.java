package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntity914;

public class SCPBlock914 extends BlockContainer
{
	private Icon[] icons;

	public SCPBlock914(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public void registerIcons(IconRegister par1)
	{
		icons = new Icon[2];

		for(int i = 0; i < icons.length; i++)
		{
			if(i == 0) icons[i] = par1.registerIcon(mod_SCP.modid + ":SCP-914");
			else icons[i] = par1.registerIcon(mod_SCP.modid + ":Machine Block0");
		}
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par2)
		{
		default:
		case 0:
		{
			switch(par1)
			{
			case 0: return icons[1];
			case 1: return icons[1];
			case 4: return icons[0];
			default: return icons[0];
			}
		}
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return 0;
	}
	private Random furnaceRand = new Random();	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		SCPTileEntity914 var7 = (SCPTileEntity914)par1World.getBlockTileEntity(par2, par3, par4);
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

		if (tileEntity == null || var5.isSneaking()) 
		{
			return false;
		}

		var5.openGui(mod_SCP.instance, 0, var1, var2, var3, var4);
		return true;
	}

	/**
	 * Returns the TileEntity used by this block.
	 */
	 public TileEntity createNewTileEntity(World var1)
	 {
		 return new SCPTileEntity914();
	 }
}
