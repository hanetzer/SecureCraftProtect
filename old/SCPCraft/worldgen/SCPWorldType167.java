package SCPCraft.worldgen;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class SCPWorldType167 extends WorldType
{
	public SCPWorldType167(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	//this will set the name of the world type. if you set it 
	//as Frozen Mountain it will look like Frozen Mountain
	public String getTranslateName()
	{
		return "SCP-167";
	}


	//this is the worldcunck manager class. this sets up what is in the world. 
	//as you can see we are using the hell manager as a base for our world type. 
	//this is because the nether/hell only has one biome type. 
	//you can replace Icemountains with your own biome or an ingame biome. 
	//if you are not sure what the biome is called just delete iceMountains and the . before it
	//then re enter the . eclipse will then give you a list of biomes it has found. 
	public WorldChunkManager getChunkManager(World var1)
	{
		return new WorldChunkManagerHell(BiomeGenBase.iceMountains, 0.5F, 0.5F);
	}

}