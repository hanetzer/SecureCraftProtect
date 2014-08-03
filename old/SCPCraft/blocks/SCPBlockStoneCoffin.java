package SCPCraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntityMountableBlock;

public class SCPBlockStoneCoffin extends Block
{
	public SCPBlockStoneCoffin(int par1, int par2)
	{
		super(par1, Material.rock);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

/*	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.StoneCoffin.blockID;
	} */

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
	{
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, 0.15F, 0.5F, 0, 0, 0, 0);
	}

	//Use this method for a custom mounting ysize.
	public static boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, float y)
	{
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, y, 0.5F, 0, 0, 0, 0);
	}

	//This is the main onBlockActivated method. Use it for fully custom mounting positions.
	public static boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, float x, float y, float z, int north, int south, int east, int west)
	{
		if (!world.isRemote)
		{
			//Looks for EMBs up to 1 block away from the activated block. Hopefully you didn't set the mounting position further away than this.
			List<SCPEntityMountableBlock> listEMB = world.getEntitiesWithinAABB(SCPEntityMountableBlock.class, AxisAlignedBB.getBoundingBox(i, j, k, i + 1.0D, j + 1.0D, k + 1.0D).expand(1D, 1D, 1D));
			for (SCPEntityMountableBlock entitytocheck : listEMB)
			{
				//Looks for an EMB created by this block.
				if (entitytocheck.getOrgBlockPosX() == i && entitytocheck.getOrgBlockPosY() == j && entitytocheck.getOrgBlockPosZ() == k)
				{
					entitytocheck.interact(entityplayer);
					return true;
				}
			}
			//Sets coordinates for mounting a north oriented block.
			float mountingX = i + x;
			float mountingY = j + y;
			float mountingZ = k + z;
			//Changes coordinates for mounting to compensate for none-north block orientation.
			if(north != south) 
			{
				int md = world.getBlockMetadata(i, j, k);
				if (md == east) 
				{
					mountingX = i + 1 - z; 
					mountingZ = k + x; 
				}
				else if (md == south) 
				{
					mountingX = i + 1 - x; 
					mountingZ = k + 1 - z; 
				}
				else if (md == west) 
				{
					mountingX = i + z; 
					mountingZ = k + 1 - x; 
				}
			}
			//Creates a new EMB if none had been created already or if the old one was bugged.
			SCPEntityMountableBlock nemb = new SCPEntityMountableBlock(world, entityplayer, i, j, k, mountingX, mountingY, mountingZ); 
			world.spawnEntityInWorld(nemb);
			nemb.interact(entityplayer);
			return true;
		}
		return true;
	}
    
	public int getRenderType()
	{
		return mod_Others.StoneCoffinID;
	}
    
    public final boolean canThisPaneConnectToThisBlockID(int i)
    {
        return blocksList[i] instanceof SCPBlockStoneCoffin;
    }

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
	{
		setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}
    
    public boolean canRenderInPass(int pass)
    {
        return true;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1World, int i, int j, int k)
	{
		boolean flag = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(i, j, k - 1));
		boolean flag1 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(i - 1, j, k));
		boolean flag2 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(i + 1, j, k));
		boolean flag3 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(i, j, k + 1));
			//BOTTOM
		setBlockBounds(0F, 0F, 0F, 1F, 0.15F, 1F);			
			//SIDES
		if(!flag1){
			if(!flag && !flag3)setBlockBounds(0F, 0.15F, 0.15F, 0.15F, 1F, 0.85F);
			else if(flag)setBlockBounds(0F, 0.15F, 0F, 0.15F, 1F, 0.85F);	
			else if(flag3)setBlockBounds(0F, 0.15F, 0.15F, 0.15F, 1F, 1F);	
		}
		if(!flag2){
			if(!flag && !flag3)setBlockBounds(0.85F, 0.15F, 0.15F, 1F, 1F, 0.85F);	
			else if(flag)setBlockBounds(0.85F, 0.15F, 0F, 1F, 1F, 0.85F);
			else if(flag3)setBlockBounds(0.85F, 0.15F, 0.15F, 1F, 1F, 1F);
		}			
		if(!flag)setBlockBounds(0F, 0.15F, 0F, 1F, 1F, 0.15F);
		if(!flag3)setBlockBounds(0F, 0.15F, 0.85F, 1F, 1F, 1F);	
	} 
	
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	{
		boolean flag = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2, par3, par4 - 1));
		boolean flag1 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2 - 1, par3, par4));
		boolean flag2 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2 + 1, par3, par4));
		boolean flag3 = this.canThisPaneConnectToThisBlockID(par1World.getBlockId(par2, par3, par4 + 1));
			//BOTTOM
			setBlockBounds(0F, 0F, 0F, 1F, 0.15F, 1F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);			
			
			//SIDES
			if(!flag1){
				if(!flag && !flag3){
					setBlockBounds(0F, 0.15F, 0.15F, 0.15F, 1F, 0.85F);
					super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);					
				}
				else if(flag){
					setBlockBounds(0F, 0.15F, 0F, 0.15F, 1F, 0.85F);
					super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);										
				}
				else if(flag3){
					setBlockBounds(0F, 0.15F, 0.15F, 0.15F, 1F, 1F);
					super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);										
				}
			}
			if(!flag2){
				if(!flag && !flag3){
					setBlockBounds(0.85F, 0.15F, 0.15F, 1F, 1F, 0.85F);
					super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);					
				}
				else if(flag){					
					setBlockBounds(0.85F, 0.15F, 0F, 1F, 1F, 0.85F);
					super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);										
				}
				else if(flag3){
					setBlockBounds(0.85F, 0.15F, 0.15F, 1F, 1F, 1F);
					super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);										
				}
			}			
			if(!flag){
				setBlockBounds(0F, 0.15F, 0F, 1F, 1F, 0.15F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);				
			}
			if(!flag3){
				setBlockBounds(0F, 0.15F, 0.85F, 1F, 1F, 1F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);				
			}
	}
}