package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem409 extends SCPItemDocument
{
	public SCPItem409(int i)
	{
		super(i, 2);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a74SCP-409");
		list.add("\u00a77Contagious Crystal");
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

			if (spawnCreature(par3World, par1ItemStack.getItemDamage(), (double)par4 + 0.5D, (double)par5 + var12, (double)par6 + 0.5D) && !par2EntityPlayer.capabilities.isCreativeMode)
			{
				--par1ItemStack.stackSize;
			}

			for(int height = -2; height <= 4; height++)
				for(int length = -2; length <= 7; length++)
					for(int width = -2; width <= 7; width++)
					{					
						par3World.setBlock(par4 + length, par5 + height, par6 + width, mod_SCP.Granite.blockID, 0, 2);					
					}
			for(int height = 0; height <= 2; height++)
				for(int length = 0; length <= 5; length++)
					for(int width = 0; width <= 5; width++)
					{
						par3World.setBlock(par4 + length, par5 + height, par6 + width, 0, 0, 2);				
					}
			par3World.setBlock(par4 + 3, par5 + 1, par6 + 3, mod_SCP.SCP409.blockID, 0, 2);
			par3World.setBlock(par4 + 3, par5, par6 + 3, mod_SCP.Granite.blockID, 0, 2);	
			ItemDoor.placeDoorBlock(par3World, par4 + 3, par5, par6 - 2, 1, Block.doorSteel);
			par3World.setBlock(par4 + 3, par5 + 1, par6 - 1, 0, 0, 2);	
			par3World.setBlock(par4 + 3, par5, par6 - 1, 0, 0, 2);	
			par3World.setBlock(par4 + 2, par5 + 1, par6 - 3, mod_SCP.KeycardSlotLv3.blockID, 2, 2);
			par3World.setBlock(par4 + 3, par5 + 1, par6 - 1, mod_SCP.KeycardSlotLv3.blockID, 1, 2);

			int i = par3World.getBlockId(par4, par5, par6);
			--par1ItemStack.stackSize;
			par2EntityPlayer.addChatMessage("SCP-409 Spawned." +    

					" | [Type: \u00a74Keter\u00a7f]");

			return true;
		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		return false;
	}
	
}