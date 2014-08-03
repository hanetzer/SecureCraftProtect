package SCPCraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntityMountableBlock;

public class SCPBlockChair extends Block
{
    public SCPBlockChair(int par1, int par2, Material mat)
    {
        super(par1, mat);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public void registerIcons(IconRegister par1)
    {
    	if(blockID == 249) blockIcon = par1.registerIcon(Block.stone.getUnlocalizedName2());
    	else if(blockID == 248) blockIcon = par1.registerIcon(Block.planks.getUnlocalizedName2());
    	else if(blockID == 247) blockIcon = par1.registerIcon(mod_SCP.modid + ":Marble");
    }
    
    public final boolean canThisPaneConnectToThisBlockID(int i)
    {
        return blocksList[i] instanceof SCPBlockChair;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.5F, 0.9F);
    }
    
    @Override
    public void onBlockPlacedBy(World w, int x, int y, int z,
								EntityLiving entity, ItemStack stack)
    {
        int i = MathHelper.floor_double((double)((entity.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        int j = w.getBlockMetadata(x, y, z) & 0b1100;

        if (i == 0)
        {
            w.setBlockMetadataWithNotify(x, y, z, 0b0001 | j, 0x0002);//
        }
        else if (i == 1)
        {
            w.setBlockMetadataWithNotify(x, y, z, 0b0000 | j, 0x0002);//
        }
        else if (i == 2)
        {
            w.setBlockMetadataWithNotify(x, y, z, 0b0011 | j, 0x0002);//
        }
        else if (i == 3)
        {
            w.setBlockMetadataWithNotify(x, y, z, 0b0010 | j, 0x0002); //
        }
    }
    
    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
    {
    	int j = par1World.getBlockMetadata(par2, par3, par4) & 3;
    	
    	setBlockBounds(0.1F, 0.5F, 0.1F, 0.9F, 0.6F, 0.9F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);	
        if(j == 0){
        	setBlockBounds(0.1F, 0.6F, 0.1F, 0.2F, 1.5F, 0.9F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
        }	
        if(j == 1){
        	setBlockBounds(0.1F, 0.6F, 0.7F, 0.9F, 1.5F, 0.9F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
        }	
        if(j == 3){
        	setBlockBounds(0.1F, 0.6F, 0.1F, 0.9F, 1.5F, 0.2F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
        }	
        if(j == 2){
        	setBlockBounds(0.7F, 0.6F, 0.1F, 0.9F, 1.5F, 0.9F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
        }
    }

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
	{
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, 0.5F, 0.5F, 0, 0, 0, 0);
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
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
        
    public int getRenderType()
    {
        return mod_Others.ChairID;
    }
}
