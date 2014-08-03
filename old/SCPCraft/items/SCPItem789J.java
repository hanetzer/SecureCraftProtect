package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem789J extends SCPItemDocument
{
	public SCPItem789J(int i)
	{
		super(i, 0);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a72SCP-789-J");
		list.add("\u00a77The Butt Ghost");
	}

	public boolean isFull3D()
	{
		return true;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par3World.isRemote)
		{
			return true;
		}

		else
		{
			int var11 = par3World.getBlockId(par4, par5, par6);
			par4 += Facing.offsetsXForSide[par7];
			par5 += Facing.offsetsYForSide[par7];
			par6 += Facing.offsetsZForSide[par7];
			double var12 = 0.0D;

			if (par7 == 1 && var11 == Block.fence.blockID || var11 == Block.netherFence.blockID)
			{
				var12 = 0.5D;
			}
			par1ItemStack.stackSize--;

			for(int height = -1; height <= 3; height++)
				for(int length = 0; length <= 6; length++)
					for(int width = 0; width <= 6; width++)
					{					
						par3World.setBlock(par4 + length, par5 + height, par6 + width, Block.stone.blockID, 0, 2);					
					}
			
			for(int height = 0; height <= 2; height++)
				for(int length = 1; length <= 5; length++)
					for(int width = 1; width <= 5; width++)
					{
						par3World.setBlock(par4 + length, par5 + height, par6 + width, 0, 0, 2);				
					}
			
			for(int length = 2; length <= 3; length++)
			{					
				par3World.setBlock(par4 + length, par5 + 2, par6 + 6, Block.thinGlass.blockID, 0, 2);					
			}
			
			par3World.setBlock(par4 + 5, par5, par6 + 1, mod_SCP.Toilet.blockID, 3, 2);	
			par3World.setBlock(par4 + 5, par5, par6 + 3, mod_SCP.SCP789J.blockID, 3, 2);	
			par3World.setBlock(par4 + 5, par5, par6 + 5, mod_SCP.Toilet.blockID, 3, 2);	
			ItemDoor.placeDoorBlock(par3World, par4 + 1, par5, par6, 1, Block.doorWood);
			
			ItemDoor.placeDoorBlock(par3World, par4 + 4, par5, par6 + 1, 0, Block.doorWood);
			ItemDoor.placeDoorBlock(par3World, par4 + 4, par5, par6 + 3, 0, Block.doorWood);
			ItemDoor.placeDoorBlock(par3World, par4 + 4, par5, par6 + 5, 0, Block.doorWood);
			
			for(int height = 0; height <= 2; height++)
			{					
				par3World.setBlock(par4 + 5, par5 + height, par6 + 2, Block.stone.blockID, 0, 2);
				par3World.setBlock(par4 + 5, par5 + height, par6 + 4, Block.stone.blockID, 0, 2);	
				par3World.setBlock(par4 + 4, par5 + height, par6 + 2, Block.stone.blockID, 0, 2);
				par3World.setBlock(par4 + 4, par5 + height, par6 + 4, Block.stone.blockID, 0, 2);		
			}
			
			par2EntityPlayer.addChatMessage("SCP-789-J Spawned." +  " | [Type: \u00a72Safe\u00a7f]");

			return true;
		}
	}
	
}


