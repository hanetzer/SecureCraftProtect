package SCPCraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import SCPCraft.mod_SCP;

public class SCPWorldGen006 extends WorldGenerator
{
    private int blockIndex;

    public SCPWorldGen006(int par1)
    {
        this.blockIndex = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
    	if(par1World.isBlockNormalCube(par3, par4 - 1, par5) && (par1World.getBlockMaterial(par3, par4 - 1, par5) != Material.leaves || par1World.getBlockMaterial(par3, par4 - 1, par5) != Material.plants)){
    	par1World.setBlock(par3, par4, par5, mod_SCP.SCP006Flowing.blockID);
    	par1World.setBlock(par3, par4, par5 + 1, 0);
    	par1World.setBlock(par3 - 1, par4, par5 + 1, 0);
    	par1World.setBlock(par3, par4, par5 + 2, 0);
    	par1World.setBlock(par3 + 1, par4, par5 + 2, 0);
    	par1World.setBlock(par3 + 2, par4, par5 + 2, 0);
    	par1World.setBlock(par3 + 3, par4, par5 + 2, 0);
    	par1World.setBlock(par3 + 2, par4, par5 + 3, 0);

    	for(int m = -5; m <= 5; m++)
    		for(int n = -5; n <= 5; n++)
    		{
    			if(par1World.getBlockId(par3 + m, par4, par5 + n) != 0 && par1World.getBlockId(par3 + m, par4 + 1, par5 + n) == 0 && par2Random.nextInt(3) == 0)
    		    	par1World.setBlockMetadataWithNotify(par3 + m, par4 + 1, par5 + n, Block.tallGrass.blockID, 1);
    		}
    	
    	return true;  
    	}else return false;
    }
}
