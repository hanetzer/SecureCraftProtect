package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem143 extends SCPItemDocument
{
	public SCPItem143(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-143");
		list.add("\u00a77The Bladewood Grove");
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

			//Layer 1
			par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);

			for(int i = -3; i <= 3; i++)
				for(int j = 0; j <= 7; j++)
					for(int k = 0; k <= 4; k++)
			par3World.setBlock(par4 + i, par5 + k, par6 + j, Block.glass.blockID, 0, 2);				
			
			for(int m = -2; m <= 2; m++)
				for(int n = 1; n <= 6; n++)
					for(int b = 0; b <= 4; b++)
						par3World.setBlock(par4 + m, par5 + b, par6 + n, 0, 0, 2);	
			
			par3World.setBlock(par4 - 2, par5 + 2, par6, Block.blockSteel.blockID, 0, 2);
			par3World.setBlock(par4 - 2, par5 + 2, par6 + 1, Block.torchWood.blockID, 0, 2);
			
			for(int i = -3; i <= 3; i++)
				for(int j = 0; j <= 7; j++)
					par3World.setBlock(par4 + i, par5 - 1, par6 + j, Block.grass.blockID, 0, 2);
			par3World.setBlock(par4, par5, par6 + 4, mod_SCP.SCP143Sapling.blockID, 0, 2);
			
			par2EntityPlayer.addChatMessage("SCP-143 Spawned." +    

					" | [Type: \u00a7eEuclid\u00a7f]");


			//(par4 + 2, par5, par6 + 3);

			--par1ItemStack.stackSize;
			return true;

		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		return false;
	}
}