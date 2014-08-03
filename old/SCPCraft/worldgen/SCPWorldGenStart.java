package SCPCraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import SCPCraft.mod_SCP;

public class SCPWorldGenStart extends WorldGenerator
{
    public SCPWorldGenStart()
    {
    }
    
    public void create(World par1World, int par3, int par4, int par5)
    {
    	par1World.setBlockMetadataWithNotify(par3 - 1, par4, par5, Block.skull.blockID, 0);
    	par1World.setBlockMetadataWithNotify(par3 + 1, par4, par5, Block.skull.blockID, 0);
    	
    	par1World.setBlockMetadataWithNotify(par3 + 1, par4 + 1, par5, Block.skull.blockID, 1);
    	par1World.setBlockMetadataWithNotify(par3 - 1, par4 + 1, par5, Block.skull.blockID, 1);
    			
    	for(int m = -1; m <= 1; m++)
    		for(int n = 0; n <=1; n++)
    	    	par1World.setBlockMetadataWithNotify(par3 + m, par4 + n, par5 + 1, Block.planks.blockID, 2);
    	
        par1World.setBlockMetadataWithNotify(par3 - 1, par4, par5 - 1, Block.signWall.blockID, 2);
		TileEntitySign te1 = (TileEntitySign) par1World.getBlockTileEntity(par3 - 1, par4, par5 - 1);
		te1.signText[1]="Phuck_Yu_Too";
		te1.signText[2]="[coder]";
    			
        par1World.setBlockMetadataWithNotify(par3 + 1, par4, par5 - 1, Block.signWall.blockID, 2);
		TileEntitySign te2 = (TileEntitySign) par1World.getBlockTileEntity(par3 + 1, par4, par5 - 1);
		te2.signText[1]="TheDarkKnight";
		te2.signText[2]="[coder]";
    			
        par1World.setBlockMetadataWithNotify(par3, par4 + 1, par5, Block.signWall.blockID, 2);
		TileEntitySign te3 = (TileEntitySign) par1World.getBlockTileEntity(par3, par4 + 1, par5);
		te3.signText[0]="Thank you for installing";
		te3.signText[1]="\u00a7l" + mod_SCP.SCPCraftVersion;
		te3.signText[2]="Hope you'll enjoy the mod";
		te3.signText[3]=":)";
		
    	TileEntity var12 = par1World.getBlockTileEntity(par3 + 1, par4 + 1, par5);
        ((TileEntitySkull)var12).setSkullType(3, "sor1n");
    	TileEntity var13 = par1World.getBlockTileEntity(par3 - 1, par4 + 1, par5);
        ((TileEntitySkull)var13).setSkullType(3, "_xXMasterBaitXx_");    	
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
    	return true;
    }
}
