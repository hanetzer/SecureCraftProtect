package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity513;

public class SCPBlock513 extends Block
{
	public SCPBlock513(int par1, int par2)
	{
		super(par1, Material.anvil);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.SCP513.blockID;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		setBlockBounds(0.25F, 0F, 0.35F, 0.75F, 0.6F, 0.66F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		setBlockBounds(0.25F, 0F, 0.35F, 0.75F, 0.6F, 0.66F);
	} 

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		setBlockBounds(0.25F, 0.0F, 0.65F, 0.75F, 0.5F, 0.66F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.25F, 0.0F, 0.35F, 0.75F, 0.5F, 0.36F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.25F, 0.0F, 0.35F, 0.26F, 0.5F, 0.65F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.74F, 0.0F, 0.35F, 0.75F, 0.5F, 0.65F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);		
		setBlockBounds(0.25F, 0.5F, 0.35F, 0.75F, 0.51F, 0.66F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.42F, 0.51F, 0.49F, 0.58F, 0.6F, 0.52F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.49F, 0.2F, 0.49F, 0.52F, 0.5F, 0.52F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.47F, 0.1F, 0.47F, 0.54F, 0.2F, 0.54F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }

	public int getRenderType()
	{
		return mod_Others.SCP513ID;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack var1 = par5EntityPlayer.inventory.getCurrentItem();

		if(par5EntityPlayer != null && var1 == null)
		{
			par1World.playSoundAtEntity(par5EntityPlayer, "sounds.cowbell", 1.0F, 1.0F);
			
			if(par5EntityPlayer instanceof EntityPlayerMP)
			{
				SCPEntity513 dude = new SCPEntity513(par1World);
				dude.setLocationAndAngles(par2, par3, par4, 1.0F, 1.0F);
				par1World.spawnEntityInWorld(dude);
			}
			
			return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
		}

		if(par5EntityPlayer != null && var1 != null)
		{
			return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
		}
		return true;
	}
}
