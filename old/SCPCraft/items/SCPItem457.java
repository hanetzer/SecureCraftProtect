package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity457;

public class SCPItem457 extends SCPItemDocument
{
	public SCPItem457(int i)
	{
		super(i, 2);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a74SCP-457");
		list.add("\u00a77The Burning Man");
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

			int i = par3World.getBlockId(par4, par5, par6);

			if (i == 0)
			{
				//Layer 1
				par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				for(int m = -4; m <= 4; m++)
					for(int n = 0; n <= 8; n++)
						for(int b = -1; b <= 3; b++)
							par3World.setBlock(par4 + m, par5 + b, par6 + n, Block.stone.blockID, 0, 2);
				for(int m = -3; m <= 3; m++)
					for(int n = 1; n <= 7; n++)
						for(int b = 0; b <= 2; b++)
							par3World.setBlock(par4 + m, par5 + b, par6 + n, 0, 0, 2);
				for(int m = 1; m <= 3; m++)
					for(int b = 1; b <= 2; b++)
						par3World.setBlock(par4 + m, par5 + b, par6, Block.thinGlass.blockID, 0, 2);

				for(int m = 1; m<= 3; m++)
					for(int n = -3; n <= 0; n++)
						for(int k = 0; k <= 2; k++)
							par3World.setBlock(par4 + n, par5 + k, par6 + m, Block.stone.blockID, 0, 2);

				for(int m = 1; m<3; m++)
					for(int n = -2; n < -1; n++)
						for(int k = 0; k <= 1; k++)
							par3World.setBlock(par4 + n, par5 + k, par6 + m, 0, 0, 2);

				ItemDoor.placeDoorBlock(par3World, par4 - 2, par5, par6, 1, Block.doorSteel);
				ItemDoor.placeDoorBlock(par3World, par4 - 2, par5, par6 + 3, 3, Block.doorSteel);
				par3World.setBlock(par4 - 1, par5 + 1, par6 + 2, mod_SCP.KeycardSlotLv3.blockID, 2, 2);
				par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID, 0, 2);

				par3World.setBlock(par4 - 3, par5 + 1, par6 - 1, mod_SCP.KeycardSlotLv3.blockID, 2, 2);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 1, mod_SCP.KeycardSlotLv3.blockID, 0, 2);
				par3World.setBlock(par4 - 1, par5 + 1, par6 + 4, mod_SCP.KeycardSlotLv3.blockID, 0, 2);

				par2EntityPlayer.addChatMessage("SCP-457 Spawned." + " | [Type: \u00a74Keter\u00a7f]");

			}
			par2EntityPlayer.addStat(mod_SCP.SCP457, 1);
			return true;
		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity457 var8 = new SCPEntity457(par0World);
		var8.setLocationAndAngles(par2 + 2, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}

}