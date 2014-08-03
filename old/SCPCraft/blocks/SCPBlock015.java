package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntity015;

public class SCPBlock015 extends BlockContainer
{
	public Random rand = new Random();
	public SCPBlock015(int par1, int par2)
	{
		super(par1, Material.iron);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public final boolean canThisPaneConnectToThisBlockID(int i)
	{
		return blocksList[i] instanceof SCPBlock015 || i == mod_SCP.Machinery.blockID || i == mod_SCP.Toilet.blockID;
	}

	public TileEntity createNewTileEntity(World var1) {
		try
		{
			return (TileEntity)SCPTileEntity015.class.newInstance();
		}
		catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) 
	{
		int Potions[] = 
			{ 
				Potion.blindness.id, Potion.hunger.id, Potion.confusion.id, Potion.digSlowdown.id, Potion.moveSlowdown.id, Potion.weakness.id, 
				Potion.poison.id, SCPPotion.shake.id
			};

		double d = (float)par2;
		double d1 = (float)par3;
		double d2 = (float)par4;

		if(par5EntityPlayer != null)
		{
			for(int var3 = 0; var3 < 50; ++var3){
				par1World.spawnParticle("splash", par5EntityPlayer.posX, par5EntityPlayer.posY, par5EntityPlayer.posZ, 0D, -0.1D, 0D);                	
				par1World.spawnParticle("splash", par5EntityPlayer.posX, par5EntityPlayer.posY, par5EntityPlayer.posZ, 0D, -0.1D, 0D);
				par1World.spawnParticle("splash", par5EntityPlayer.posX, par5EntityPlayer.posY, par5EntityPlayer.posZ, 0D, -0.1D, 0D);
			}
			par5EntityPlayer.addPotionEffect(new PotionEffect(Potions[rand.nextInt(8)], 200, 1));        	
		}	
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderBlockPass()
	{
		return 0;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		boolean flag = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j, k - 1));
		boolean flag1 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i - 1, j, k));
		boolean flag2 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i + 1, j, k));
		boolean flag3 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j, k + 1));
		boolean flag4 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j + 1, k));
		boolean flag5 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j - 1, k));
		setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		if(flag1)setBlockBounds(0.0F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		if(flag)setBlockBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.66F);
		if(flag3)setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 1F);
		if(flag2)setBlockBounds(0.33F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
		if(flag4)setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 1F, 0.66F);
		if(flag5)setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.66F, 0.66F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		boolean flag = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j, k - 1));
		boolean flag1 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i - 1, j, k));
		boolean flag2 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i + 1, j, k));
		boolean flag3 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j, k + 1));
		boolean flag4 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j + 1, k));
		boolean flag5 = this.canThisPaneConnectToThisBlockID(world.getBlockId(i, j - 1, k));
		setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		if(flag1)setBlockBounds(0.0F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		if(flag)setBlockBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.66F);
		if(flag3)setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 1F);
		if(flag2)setBlockBounds(0.33F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
		if(flag4)setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 1F, 0.66F);
		if(flag5)setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.66F, 0.66F);
	} 

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		boolean flag = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2, par3, par4 - 1));
		boolean flag1 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2 - 1, par3, par4));
		boolean flag2 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2 + 1, par3, par4));
		boolean flag3 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2, par3, par4 + 1));
		boolean flag4 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2, par3 + 1, par4));
		boolean flag5 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2, par3 - 1, par4));

		setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);

		if(flag1) 
		{
			setBlockBounds(0.0F, 0.33F, 0.33F, 0.33F, 0.66F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}    	
		if(flag) 
		{    		
			setBlockBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.33F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}    	
		if(flag3) 
		{
			setBlockBounds(0.33F, 0.33F, 0.66F, 0.66F, 0.66F, 1F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}    	
		if(flag2) 
		{
			setBlockBounds(0.66F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}	
		if(flag4) 
		{
			setBlockBounds(0.33F, 0.66F, 0.33F, 0.66F, 1F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}    	
		if(flag5) 
		{
			setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.33F, 0.66F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		}
	}

	public boolean canRenderInPass(int pass)
	{
		return true;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return mod_Others.SCP015ID;
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":ShinyFancyIron");
    }
}
