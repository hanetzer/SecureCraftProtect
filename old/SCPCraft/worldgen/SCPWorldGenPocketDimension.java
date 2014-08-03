package SCPCraft.worldgen;

import java.util.Random;

import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPWorldGenPocketDimension
{
	public static String mob;
	public static TileEntitySign tempSign;
	public SCPWorldGenPocketDimension()
	{
	}

	public static boolean generate(World world, int i, int j, int k)
	{
		Random rom = new Random();
		/*
		int j1 = world.getBlockId(i + 4, j - 2, k - 12);

		for(int width = 0; width <= 9; width++)
			for(int length = -12; length <= 9; length++)
				for(int ysize = -11; ysize <= -4; ysize++)
				{
					world.updateAllLightTypes(i + width, j + ysize, k + length);
					int block = world.getBlockId(i + width, j + ysize, k + length);
					if(block == mod_SCP.SCPSpawner.blockID || block == Block.stairsStoneBrickSmooth.blockID) return false;
				}

		int room = rom.nextInt(5);
		*/

		genCorridor(world, i, 5, k, "lenght");
		genCorridor(world, i + 9, 5, k, "lenght");
		genCorridor(world, i - 9, 5, k, "lenght");
		genCorridor(world, i - 18, 5, k, "lenght");
		genCorridor(world, i + 18, 5, k, "lenght");
		genCorridor(world, i - 27, 5, k, "lenght");
		genCorridor(world, i + 27, 5, k, "corner1");
		return true;
	}

	private static void genCorridor(World world, int i, int j, int k, String type)
	{
		if(type == "lenght")
		{
			for(int length = -4; length <= 0; length++)
				for(int width = 0; width <= 9; width++)
					for(int height = 0; height <= 1; height++)
					{
						world.setBlockMetadataWithNotify(i + width, j + height, k + length, 0, 0);
					}
			for(int length = -4; length <= 0; length++)
				for(int width = 0; width <= 9; width++)
					for(int height = 0; height <= 1; height++)
					{
						world.setBlockMetadataWithNotify(i + width, j + height, k, mod_SCP.SCPspawner.blockID, 0);
						world.setBlockMetadataWithNotify(i + width, j + height, k - 4, mod_SCP.SCPspawner.blockID, 0);                              
						world.setBlockMetadataWithNotify(i + width, j - 1, k + length, mod_SCP.SCPspawner.blockID, 0);
						world.setBlockMetadataWithNotify(i + width, j + 2, k + length, mod_SCP.SCPspawner.blockID, 0);
					}
		}
		if(type == "corner1")
		{
			for(int length = -4; length <= 0; length++)
				for(int width = 0; width <= 2; width++)
					for(int height = 0; height <= 1; height++)
					{
						world.setBlockMetadataWithNotify(i + width, j + height, k + length, 0, 0);
					}
			for(int length = -4; length <= 0; length++)
				for(int width = 0; width <= 2; width++)
					for(int height = 0; height <= 1; height++)
					{
						world.setBlockMetadataWithNotify(i + width, j + height, k, mod_SCP.SCPspawner.blockID, 0);
						world.setBlockMetadataWithNotify(i + width, j + height, k - 4, mod_SCP.SCPspawner.blockID, 0);                              
						world.setBlockMetadataWithNotify(i + width, j - 1, k + length, mod_SCP.SCPspawner.blockID, 0);
						world.setBlockMetadataWithNotify(i + width, j + 2, k + length, mod_SCP.SCPspawner.blockID, 0);
					}
			for(int length = 0; length <= 4; length++)
				for(int width = 0; width <= 3; width++)
					for(int height = 0; height <= 1; height++)
					{
						world.setBlockMetadataWithNotify(i + width, j + height, k, mod_SCP.SCPspawner.blockID, 0);
						world.setBlockMetadataWithNotify(i - 1, j + height, k + length, mod_SCP.SCPspawner.blockID, 0);                            
						world.setBlockMetadataWithNotify(i + width, j - 1, k + length, mod_SCP.SCPspawner.blockID, 0);
						world.setBlockMetadataWithNotify(i + width, j + 2, k + length, mod_SCP.SCPspawner.blockID, 0);
					}
			for(int length = -3; length <= 4; length++)
				for(int width = 0; width <= 3; width++)
					for(int height = 0; height <= 1; height++)
					{    
						world.setBlockMetadataWithNotify(i + 3, j + height, k + length, mod_SCP.SCPspawner.blockID, 0);  
					}
			
			for(int length = -1; length <= 4; length++)
				for(int width = 0; width <= 2; width++)
					for(int height = 0; height <= 1; height++)
					{
						world.setBlockMetadataWithNotify(i + width, j + height, k + length, 0, 0);
					}
		}
	}
}