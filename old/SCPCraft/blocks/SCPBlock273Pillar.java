package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity273;

public class SCPBlock273Pillar extends Block
{
	public int nr = 0;
    public SCPBlock273Pillar(int par1, int j)
    {
        super(par1, Material.iron);
        this.setTickRandomly(true);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public void registerIcons(IconRegister par1)
	{
    	blockIcon = par1.registerIcon(Block.stone.getUnlocalizedName2());
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		setBlockBounds(0F, 0F, 0F, 1F, 2F, 1F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{         
		setBlockBounds(0F, 0F, 0F, 1F, 2F, 1F);
	} 
	
	 public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	 {
		setBlockBounds(0F, 0F, 0F, 1F, 0.2F, 1F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		setBlockBounds(0.25F, 0.2F, 0.25F, 0.75F, 1.8F, 0.75F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);			
		setBlockBounds(0F, 1.8F, 0F, 1F, 2F, 1F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
	 }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean canRenderInPass(int pass)
    {
        return true;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	return true;
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	nr++;
    	if(nr == 3)
    	{
    		SCPEntity273 var8 = new SCPEntity273(par1World);
    		var8.setLocationAndAngles(par2, par3, par4, par1World.rand.nextFloat() * 360.0F, 0.0F);
    		par1World.spawnEntityInWorld(var8);
    		this.nr = 0;
    		par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0); //setBlockWithNotify(par2, par3, par4, 0);
    	}
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return mod_Others.SCP273ID;
    }
    
    public int tickRate()
    {
        return 0;
    }
}
