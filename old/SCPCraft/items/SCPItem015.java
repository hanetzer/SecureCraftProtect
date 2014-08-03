package SCPCraft.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity015Boss;

public class SCPItem015 extends SCPItemDocument
{
	public Random rand = new Random();
	public int pipes[]= {1, 0, 1, 1, 1, 0, 1, 1, 2, 0, 1, 0, 0, 2, 1,
			             1, 2, 1, 0, 0, 0, 0, 2, 1, 1, 1, 0, 0, 1, 1,
			             1, 1, 0, 1, 2, 0, 0, 1, 1, 0, 1, 0, 2, 1, 2,
			             0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 
			             1, 0, 1, 2, 0, 1, 2, 0, 1, 1, 0, 0, 0, 1, 0,
			             1, 0, 1, 1, 1, 0, 0, 0, 1, 2, 0, 1, 1, 2, 1,
			             2, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1,
			             0, 0, 1, 1, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2,
			             1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 2, 1, 1,
			             0, 0, 1, 2, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1,
			             0, 1, 2, 1, 1, 0, 1, 2, 0, 0, 1, 0, 1, 1, 1,
			             0, 0, 0, 0, 2, 1, 1, 1, 0, 1, 1, 0, 0, 0, 2,
			             1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,
			             0, 0, 1, 0, 1, 1, 0, 2, 0, 0, 0, 1, 2, 1, 0,
			             1, 2, 0, 0, 2, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0,
			             1, 0, 2, 1, 1, 0, 0, 1, 1, 0, 1, 2, 1, 0, 0};
	
	public int pipes1[]= {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1,
            			  1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1,
            			  1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1,
            			  0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 
            			  1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0,
            			  1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1,
            			  0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1,
            			  0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1,
            			  1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1,
            			  0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1,
            			  1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1,
            			  0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1,
            			  1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0,
            			  0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1,
            			  1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0,
            			  1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1};

	public int pipes2[]= {1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1,
            			  1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1,
            			  1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1,
            			  0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 
            			  1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0,
            			  1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1,
            			  0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1,
            			  0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,
            			  1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0,
            			  0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1,
            			  0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1,
            			  0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0,
            			  1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,
            			  0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0,
            			  0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0,
            			  1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0};
	
	public SCPItem015(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add("\u00a7eSCP-015");
		list.add("\u00a77Pipe Nightmare");
	}

	public boolean isFull3D()
	{
		return true;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player,
							 World world, int x, int y, int z, int dir,
							 float par8, float par9, float par10)
	{
		--stack.stackSize;
		if (world.isRemote)
		{
			--stack.stackSize;
			return true;
		}

		else
		{
			int var11 = world.getBlockId(x, y, z);
			x += Facing.offsetsXForSide[dir];
			y += Facing.offsetsYForSide[dir];
			z += Facing.offsetsZForSide[dir];
			double var12 = 0.0D;

			if (dir == 1 && var11 == Block.fence.blockID || var11 == Block.netherFence.blockID)
			{
				var12 = 0.5D;
			}
			
			if (spawnCreature(world, stack.getItemDamage(), (double)x + 0.5D, (double)y + var12, (double)z + 0.5D) && !player.capabilities.isCreativeMode)
			{
				stack.stackSize = 0;
			}
			int i = world.getBlockId(x, y, z);

			for(int height = -1; height <= 5; height++)
				for(int length = -1; length <= 15; length++)
					for(int width = -1; width <= 15; width++)
					{					
						world.setBlock(x + length, y + height, z + width, Block.stone.blockID, 0, 2);
					}

			for(int height = 0; height <= 4; height++)
				for(int length = 0; length <= 14; length++)
					for(int width = 0; width <= 14; width++)
					{
						world.setBlock(x + length, y + height, z + width, 0, 0, 2);
					}
				
			//FLOOR
			for(int width = 0; width <= 224; width++)
			{
				if(pipes[width] == 1){
				if(width <= 14) world.setBlock(x + width, y, z + 14, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 15 && width <= 29) world.setBlock(x + width - 14 - 1, y, z + 13, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 30 && width <= 44) world.setBlock(x + width - 14*2 - 2, y, z + 12, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 45 && width <= 59) world.setBlock(x + width - 14*3 - 3, y, z + 11, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 60 && width <= 74) world.setBlock(x + width - 14*4 - 4, y, z + 10, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 75 && width <= 89) world.setBlock(x + width - 14*5 - 5, y, z + 9, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 90 && width <= 104) world.setBlock(x + width - 14*6 - 6, y, z + 8, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 105 && width <= 119) world.setBlock(x + width - 14*7 - 7, y, z + 7, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 120 && width <= 134) world.setBlock(x + width - 14*8 - 8, y, z + 6, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 135 && width <= 149) world.setBlock(x + width - 14*9 - 9, y, z + 5, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 150 && width <= 164) world.setBlock(x + width - 14*10 - 10, y, z + 4, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 165 && width <= 179) world.setBlock(x + width - 14*11 - 11, y, z + 3, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 180 && width <= 194) world.setBlock(x + width - 14*12 - 12, y, z + 2, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 195 && width <= 209) world.setBlock(x + width - 14*13 - 13, y, z + 1, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 210 && width <= 224) world.setBlock(x + width - 14*14 - 14, y, z, mod_SCP.SCP015.blockID, 0, 2);
				}
				if(pipes[width] == 2)
				{
					if(width <= 14) world.setBlock(x + width, y, z + 14, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 15 && width <= 29) world.setBlock(x + width - 14 - 1, y, z + 13, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 30 && width <= 44) world.setBlock(x + width - 14*2 - 2, y, z + 12, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 45 && width <= 59) world.setBlock(x + width - 14*3 - 3, y, z + 11, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 60 && width <= 74) world.setBlock(x + width - 14*4 - 4, y, z + 10, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 75 && width <= 89) world.setBlock(x + width - 14*5 - 5, y, z + 9, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 90 && width <= 104) world.setBlock(x + width - 14*6 - 6, y, z + 8, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 105 && width <= 119) world.setBlock(x + width - 14*7 - 7, y, z + 7, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 120 && width <= 134) world.setBlock(x + width - 14*8 - 8, y, z + 6, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 135 && width <= 149) world.setBlock(x + width - 14*9 - 9, y, z + 5, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 150 && width <= 164) world.setBlock(x + width - 14*10 - 10, y, z + 4, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 165 && width <= 179) world.setBlock(x + width - 14*11 - 11, y, z + 3, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 180 && width <= 194) world.setBlock(x + width - 14*12 - 12, y, z + 2, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 195 && width <= 209) world.setBlock(x + width - 14*13 - 13, y, z + 1, mod_SCP.Machinery.blockID, 0, 2);
					else if(width >= 210 && width <= 224) world.setBlock(x + width - 14*14 - 14, y, z, mod_SCP.Machinery.blockID, 0, 2);
				}
			}
			
			//LEVEL 2
			for(int width = 0; width <= 224; width++)
			{
				if(pipes2[width] == 1){
				if(width <= 14) world.setBlock(x + width, y, z + 14, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 15 && width <= 29) world.setBlock(x + width - 14 - 1, y + 1, z + 13, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 30 && width <= 44) world.setBlock(x + width - 14*2 - 2, y + 1, z + 12, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 45 && width <= 59) world.setBlock(x + width - 14*3 - 3, y + 1, z + 11, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 60 && width <= 74) world.setBlock(x + width - 14*4 - 4, y + 1, z + 10, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 75 && width <= 89) world.setBlock(x + width - 14*5 - 5, y + 1, z + 9, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 90 && width <= 104) world.setBlock(x + width - 14*6 - 6, y + 1, z + 8, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 105 && width <= 119) world.setBlock(x + width - 14*7 - 7, y + 1, z + 7, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 120 && width <= 134) world.setBlock(x + width - 14*8 - 8, y + 1, z + 6, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 135 && width <= 149) world.setBlock(x + width - 14*9 - 9, y + 1, z + 5, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 150 && width <= 164) world.setBlock(x + width - 14*10 - 10, y + 1, z + 4, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 165 && width <= 179) world.setBlock(x + width - 14*11 - 11, y + 1, z + 3, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 180 && width <= 194) world.setBlock(x + width - 14*12 - 12, y + 1, z + 2, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 195 && width <= 209) world.setBlock(x + width - 14*13 - 13, y + 1, z + 1, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 210 && width <= 224) world.setBlock(x + width - 14*14 - 14, y + 1, z, mod_SCP.SCP015.blockID, 0, 2);
				}
			}
			
			//LEVEL 3
			for(int width = 0; width <= 224; width++)
			{
				if(pipes1[width] == 1){
				if(width <= 14) world.setBlock(x + width, y + 2, z + 14, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 15 && width <= 29) world.setBlock(x + width - 14 - 1, y + 2, z + 13, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 30 && width <= 44) world.setBlock(x + width - 14*2 - 2, y + 2, z + 12, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 45 && width <= 59) world.setBlock(x + width - 14*3 - 3, y + 2, z + 11, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 60 && width <= 74) world.setBlock(x + width - 14*4 - 4, y + 2, z + 10, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 75 && width <= 89) world.setBlock(x + width - 14*5 - 5, y + 2, z + 9, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 90 && width <= 104) world.setBlock(x + width - 14*6 - 6, y + 2, z + 8, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 105 && width <= 119) world.setBlock(x + width - 14*7 - 7, y + 2, z + 7, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 120 && width <= 134) world.setBlock(x + width - 14*8 - 8, y + 2, z + 6, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 135 && width <= 149) world.setBlock(x + width - 14*9 - 9, y + 2, z + 5, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 150 && width <= 164) world.setBlock(x + width - 14*10 - 10, y + 2, z + 4, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 165 && width <= 179) world.setBlock(x + width - 14*11 - 11, y + 2, z + 3, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 180 && width <= 194) world.setBlock(x + width - 14*12 - 12, y + 2, z + 2, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 195 && width <= 209) world.setBlock(x + width - 14*13 - 13, y + 2, z + 1, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 210 && width <= 224) world.setBlock(x + width - 14*14 - 14, y + 2, z, mod_SCP.SCP015.blockID, 0, 2);
				}
			}

			//LEVEL 4
			for(int width = 0; width <= 224; width++)
			{
				if(pipes[width] == 1){
				if(width <= 14) world.setBlock(x + width, y, z + 14, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 15 && width <= 29) world.setBlock(x + width - 14 - 1, y + 3, z + 13, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 30 && width <= 44) world.setBlock(x + width - 14*2 - 2, y + 3, z + 12, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 45 && width <= 59) world.setBlock(x + width - 14*3 - 3, y + 3, z + 11, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 60 && width <= 74) world.setBlock(x + width - 14*4 - 4, y + 3, z + 10, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 75 && width <= 89) world.setBlock(x + width - 14*5 - 5, y + 3, z + 9, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 90 && width <= 104) world.setBlock(x + width - 14*6 - 6, y + 3, z + 8, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 105 && width <= 119) world.setBlock(x + width - 14*7 - 7, y + 3, z + 7, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 120 && width <= 134) world.setBlock(x + width - 14*8 - 8, y + 3, z + 6, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 135 && width <= 149) world.setBlock(x + width - 14*9 - 9, y + 3, z + 5, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 150 && width <= 164) world.setBlock(x + width - 14*10 - 10, y + 3, z + 4, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 165 && width <= 179) world.setBlock(x + width - 14*11 - 11, y + 3, z + 3, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 180 && width <= 194) world.setBlock(x + width - 14*12 - 12, y + 3, z + 2, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 195 && width <= 209) world.setBlock(x + width - 14*13 - 13, y + 3, z + 1, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 210 && width <= 224) world.setBlock(x + width - 14*14 - 14, y + 3, z, mod_SCP.SCP015.blockID, 0, 2);
				}
			}
			
			//ROOF
			for(int width = 0; width <= 224; width++)
			{
				if(pipes2[width] == 1){
				if(width <= 14) world.setBlock(x + width, y, z + 14, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 15 && width <= 29) world.setBlock(x + width - 14 - 1, y + 4, z + 13, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 30 && width <= 44) world.setBlock(x + width - 14*2 - 2, y + 4, z + 12, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 45 && width <= 59) world.setBlock(x + width - 14*3 - 3, y + 4, z + 11, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 60 && width <= 74) world.setBlock(x + width - 14*4 - 4, y + 4, z + 10, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 75 && width <= 89) world.setBlock(x + width - 14*5 - 5, y + 4, z + 9, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 90 && width <= 104) world.setBlock(x + width - 14*6 - 6, y + 4, z + 8, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 105 && width <= 119) world.setBlock(x + width - 14*7 - 7, y + 4, z + 7, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 120 && width <= 134) world.setBlock(x + width - 14*8 - 8, y + 4, z + 6, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 135 && width <= 149) world.setBlock(x + width - 14*9 - 9, y + 4, z + 5, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 150 && width <= 164) world.setBlock(x + width - 14*10 - 10, y + 4, z + 4, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 165 && width <= 179) world.setBlock(x + width - 14*11 - 11, y + 4, z + 3, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 180 && width <= 194) world.setBlock(x + width - 14*12 - 12, y + 4, z + 2, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 195 && width <= 209) world.setBlock(x + width - 14*13 - 13, y + 4, z + 1, mod_SCP.SCP015.blockID, 0, 2);
				else if(width >= 210 && width <= 224) world.setBlock(x + width - 14*14 - 14, y + 4, z, mod_SCP.SCP015.blockID, 0, 2);
				}
			}
			for(int width = 0; width <= 3; width++)
			{
				for(int length = 0; length <= 3; length++)
				{
					for(int height = 0; height <= 2; height++)
					{
						world.setBlock(x + width + 5, y + height, z + length + 5, 0);
						--stack.stackSize;
					}
				}
			}

			world.setBlock(x + 2, y + 1, z - 2, mod_SCP.KeycardSlotLv2.blockID, 2, 2);
			world.setBlock(x + 4, y + 1, z, mod_SCP.KeycardSlotLv2.blockID, 0, 2);
			ItemDoor.placeDoorBlock(world, x + 3, y, z - 1, 1, Block.doorSteel);
			player.addChatMessage("SCP-015 Spawned." + " | [Type: \u00a7eEuclid\u00a7f]");
			player.addStat(mod_SCP.summonSCP015Boss, 1);
			
			stack.stackSize = 0;
			return true;
		}
	}
	
	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity015Boss var8 = new SCPEntity015Boss(par0World);
		var8.setLocationAndAngles(par2 + 7, par4, par6 + 7, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}


