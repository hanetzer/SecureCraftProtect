package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem009 extends SCPItemDocument
{	
	public SCPItem009(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-009");
		list.add("\u00a77Red Ice");
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
			
			for(int width = -1; width <= 5; width++)
			{
				for(int length = -1; length <= 3; length++)
				{
					for(int height = -1; height <= 3; height++)
					{
						par3World.setBlock(par4 + width, par5 + height, par6 + length, mod_SCP.Locker.blockID);
					}
				}
			}
			for(int width = 0; width <= 4; width++)
			{
				for(int length = 0; length <= 2; length++)
				{
					for(int height = 0; height <= 2; height++)
					{
						par3World.setBlock(par4 + width, par5 + height, par6 + length, mod_SCP.SCP009.blockID);
					}
				}
			}
			
			par2EntityPlayer.addChatMessage("SCP-009 Spawned." + " | [Type: \u00a7eEuclid\u00a7f]");

			return true;
		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		return false;
	}
}