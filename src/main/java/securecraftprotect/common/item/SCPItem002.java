package securecraftprotect.common.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.init.Blocks.*;
import static securecraftprotect.init.SCPTiles.*;

public class SCPItem002 extends Item
{	
	public SCPItem002()
	{
		super();
		setMaxStackSize(1);
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-002");
		list.add("\u00a77The Living Room");
	}

	public boolean isFull3D()
	{
		return true;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player,
							 World world, int x, int y, int z, int dir,
							 float par8, float par9, float par10)
	{
		if (world.isRemote)
		{
			return true;
		}

		else
		{
			Block block = world.getBlock(x, y, z);
			x += Facing.offsetsXForSide[dir];
			y += Facing.offsetsYForSide[dir];
			z += Facing.offsetsZForSide[dir];
			double var12 = 0.0D;

			if (dir == 1 && block.getRenderType() == 11)
			{
				var12 = 0.5D;
			}

			if (spawnCreature(world, stack.getItemDamage(), (double)x + 0.5D, (double)y + var12, (double)z + 0.5D) && !player.capabilities.isCreativeMode)
			{
				--stack.stackSize;
			}
			
			sphere(world, x, y - 1, z, 7, reinforced_steel);
			sphere(world, x, y, z, 6, flesh);
			
			for(int width = -1; width <= 7; width++)
			{
				for(int length = 0; length <= 6; length++)
				{
					world.setBlock(x + width - 2, y + 5, z + length - 2, bone); //
				}
			}
			for(int w = 1; w <= 21; w++)
			{
				if(world.getBlock(x + 1, y - w + 7, z - 5 - w) == air) {
					world.setBlock(x + 1, y - w + 7, z - 5 - w,
							stone_brick_stairs, 2, 2);
				}
			}
			world.setBlock(x + 1, y + 5, z - 6, stonebrick);
			ItemDoor.placeDoorBlock(world, x + 1, y + 6, z - 5,
					1, iron_door);
			
			world.setBlock(x + 1, y + 6, z - 6, air); //
			world.setBlock(x + 1, y + 7, z - 6, air); //
			world.setBlock(x + 2, y + 6, z - 6, air); //
			world.setBlock(x + 2, y + 7, z - 6, air); //
			world.setBlock(x, y + 6, z - 6, air); //
			world.setBlock(x, y + 7, z - 6, air); //
			world.setBlock(x + 1, y + 6, z - 4, air); //
			world.setBlock(x + 1, y + 7, z - 4, air); //
			world.setBlock(x, y + 7, z - 6, key_slot_2, 0, 2);
			world.setBlock(x + 2, y + 7, z - 4, key_slot_2, 0, 2);
			world.setBlock(x + 2, y + 7, z - 5, reinforced_steel); //
			world.setBlock(x + 2, y + 6, z - 5, reinforced_steel); //
			world.setBlock(x, y + 7, z - 5, reinforced_steel); //
			world.setBlock(x, y + 6, z - 5, reinforced_steel); //
			
			world.setBlock(x + 5, y + 6, z, desk_wood); //
			world.setBlock(x + 5, y + 6, z + 1, desk_wood); //
			world.setBlock(x + 5, y + 6, z + 2, desk_wood); //
			world.setBlock(x + 5, y + 7, z + 2, redstone_torch); //
			world.setBlock(x + 5, y + 7, z, flower_pot);
			//world.setBlock(x + 4, y + 6, z + 1, mod_SCP.woodenChair.blockID); //
			world.setBlock(x + 2, y + 6, z + 5, chest); //
			world.setBlock(x + 1, y + 6, z + 5, chest); //
			world.setBlock(x, y + 6, z + 5, ender_chest, 2, 2);
			
			//player.addChatMessage("SCP-002 Spawned." + " | [Type: " +
			//		"\u00a7eEuclid\u00a7f]");

			return true;
		}
	}
	
	public void sphere(World world, int x, int y, int z, int var7, Block block)
	{
		int m;
		int n = var7;
	    int midX = (int)Math.floor(Math.IEEEremainder(1, 10));
	    int midZ = (int)Math.floor(Math.IEEEremainder(1, 10));
		for(m = 1; m <= var7; m++)
		{
			circle(world, x + midX, y + m, z + midZ, m, block);
		}
		for(m = var7 + 1; m <= var7*2; m++)
		{
			circle(world, x + midX, y + m, z + midZ, n, block);
			n--;
		}
	}
	
	public void circle(World world, int x, int y, int z, int var7, Block block)
    {
            int yCoord;
            int xCoord;
            int zCoord;
            int var11;

            for (yCoord = y; yCoord < y + 1 && yCoord < 128; ++yCoord)
            {
                for (xCoord = x - var7; xCoord <= x + var7; ++xCoord)
                {
                    for (zCoord = z - var7; zCoord <= z + var7; ++zCoord)
                    {
                        var11 = xCoord - x;
                        int var12 = zCoord - z;

                        if (var11 * var11 + var12 * var12 <= var7 * var7 + 1)
                        {
                            world.setBlock(xCoord, yCoord, zCoord, block); //
                        }
                    }
                }
            }
            
            for (yCoord = y; yCoord < y + 1 && yCoord < 128; ++yCoord)
            {
                for (xCoord = x - var7 - 1; xCoord <= x + var7 - 1; ++xCoord)
                {
                    for (zCoord = z - var7 - 1; zCoord <= z + var7 - 1; ++zCoord)
                    {
                        var11 = xCoord - x;
                        int var12 = zCoord - z;

                        if (var11 * var11 + var12 * var12 <= var7 * var7 - 2*var7)
                        {
                            world.setBlock(xCoord, yCoord, zCoord, air); //
                        }
                    }
                }
            }
    }

	public static boolean spawnCreature(World world, int par1, double par2, double par4, double par6)
	{
		return false;
	}
}