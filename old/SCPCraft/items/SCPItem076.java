package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem076 extends SCPItemDocument
{
	public SCPItem076(int i)
	{
		super(i, 2);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a74SCP-076");
		list.add("\u00a77Able");
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
			if (spawnCreature(par3World, par1ItemStack.getItemDamage(), (double)par4 + 0.5D, (double)par5 + var12, (double)par6 + 2.5D) && !par2EntityPlayer.capabilities.isCreativeMode)
			{
				--par1ItemStack.stackSize;
			}
		
				for(int Width = -1; Width <= 6; Width++)
				{
					for(int Length = -1; Length <= 7; Length++)
					{
						for(int Heigth = -1; Heigth <= 4; Heigth++)
						{
							par3World.setBlock(par4 + Width, par5 + Heigth, par6 + Length, Block.bedrock.blockID);
						}
					}
				}
				for(int Width = 0; Width <= 5; Width++)
				{
					for(int Length = 0; Length <= 4; Length++)
					{
						for(int Heigth = 0; Heigth <= 3; Heigth++)
						{
							par3World.setBlock(par4 + Width, par5 + Heigth, par6 + Length, 0);
						}
					}
				}
				--par1ItemStack.stackSize;
				par3World.setBlock(par4 + 2, par5 + 1, par6 - 2, mod_SCP.KeycardSlotLv3.blockID, 2, 2);
				par3World.setBlock(par4 + 4, par5 + 1, par6, mod_SCP.KeycardSlotLv3.blockID, 0, 2);
			    ItemDoor.placeDoorBlock(par3World, par4 + 3, par5, par6 - 1, 1, Block.doorSteel);
				
			    par3World.setBlock(par4 + 2, par5, par6 + 3, mod_SCP.SCP076.blockID);

			par2EntityPlayer.addChatMessage("SCP-076 Spawned." +  " | [Type: \u00a74Keter\u00a7f]");


			par2EntityPlayer.addStat(mod_SCP.AbleWin, 1);
			
			return true;
		}
	}
	
	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		return false;
	}
}


