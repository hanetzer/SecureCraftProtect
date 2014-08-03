package SCPCraft.blocks;

import static net.minecraftforge.common.ForgeDirection.UP;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;

public class SCPBlockDesk extends Block
{
    public SCPBlockDesk(int par1, int par2, Material mat)
    {
        super(par1, mat);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public void registerIcons(IconRegister par1)
    {
    	if(blockID == 242) blockIcon = par1.registerIcon(Block.stone.getUnlocalizedName2());
    	else if(blockID == 243) blockIcon = par1.registerIcon(Block.planks.getUnlocalizedName2());
    	else if(blockID == 244) blockIcon = par1.registerIcon(mod_SCP.modid + ":Granite");
    	else if(blockID == 245) blockIcon = par1.registerIcon(mod_SCP.modid + ":Marble");
    }
    
    public final boolean canThisPaneConnectToThisBlockID(int i)
    {
        return blocksList[i] instanceof SCPBlockDesk;
    }
    
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
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
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) 
    {
        return ((side == UP) || isOpaqueCube());
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
        
    public int getRenderType()
    {
        return mod_Others.DeskID;
    }
}
