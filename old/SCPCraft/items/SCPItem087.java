package SCPCraft.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity087;

public class SCPItem087 extends SCPItemDocument
{
	public SCPItem087(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);

	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-087");
		list.add("\u00a77The Stairwell");
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
			par2EntityPlayer.addStat(mod_SCP.challengeaccepted, 1);
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
				generateChamber(par3World, par4, par5 - 50, par6, par2EntityPlayer);
				generateStairs(par3World, par4, par5 - 8, par6);
				generateStairs(par3World, par4, par5 - 20, par6);
				generateStairs(par3World, par4, par5 - 32, par6);
				generateStairs(par3World, par4, par5 - 44, par6);

				par3World.setBlock(par4 + 3, par5 - 13, par6 + 2, Block.stairsStoneBrick.blockID, 0, 2);
				par3World.setBlock(par4 + 3, par5 - 25, par6 + 2, Block.stairsStoneBrick.blockID, 0, 2);
				par3World.setBlock(par4 + 3, par5 - 37, par6 + 2, Block.stairsStoneBrick.blockID, 0, 2);
				par3World.setBlock(par4 + 3, par5 - 49, par6 + 2, Block.stairsStoneBrick.blockID, 0, 2);

				for(int m = -1; m <= 8; m++)
					for(int n = -1; n <= 8; n++)
						for(int b = -1; b <= 6; b++)
							par3World.setBlock(par4 + m, par5 + b, par6 + n, Block.stoneBrick.blockID, 0, 2);

				for(int m = 0; m <= 7; m++)
					for(int n = 0; n <= 7; n++)
						for(int b = 0; b <= 5; b++)
							par3World.setBlock(par4 + m, par5 + b, par6 + n, 0, 0, 2);

				par3World.setBlock(par4 + 2, par5 - 1, par6 + 3, 0, 0, 2);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 4, 0, 0, 2);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 5, 0, 0, 2);

				par3World.setBlock(par4 + 1, par5 - 47, par6 + 2, 0, 0, 2);
				par3World.setBlock(par4 + 1, par5 - 48, par6 + 2, 0, 0, 2);
				par3World.setBlock(par4 + 1, par5 - 49, par6 + 2, 0, 0, 2);
				par3World.setBlock(par4 + 1, par5 - 47, par6 + 3, 0, 0, 2);
				par3World.setBlock(par4 + 1, par5 - 48, par6 + 3, 0, 0, 2);
				par3World.setBlock(par4 + 1, par5 - 49, par6 + 3, 0, 0, 2);

				ItemDoor.placeDoorBlock(par3World, par4 + 3, par5, par6 - 1, 1, Block.doorSteel);
				par3World.setBlock(par4 + 2, par5 + 1, par6 - 2, mod_SCP.KeycardSlotLv2.blockID, 2, 2);
				par3World.setBlock(par4 + 4, par5 + 1, par6, mod_SCP.KeycardSlotLv2.blockID, 0, 2);

				TileEntityChest chest = new TileEntityChest();
				par3World.setBlock(par4 + 2, par5, par6, Block.chest.blockID, 0, 2);

				par3World.setBlockTileEntity(par4 + 2, par5, par6, chest);

				Random randI = new Random();
				for(int slot = 0; slot < chest.getSizeInventory(); slot++)
				{
					chest.setInventorySlotContents(slot, new ItemStack(mod_SCP.CupGlowstone));
				}

			}
		}

		par1ItemStack.damageItem(2, par2EntityPlayer);
		return true;
	}

	public void generateStairs(World world, int i, int j, int k)
	{		
		for(int m = 1; m <= 7; m++)
			for(int n = 1; n <= 7; n++)
				for(int b = -6; b <= 7; b++)
					world.setBlock(i + m, j + b, k + n, Block.stoneBrick.blockID, 0, 2);

		for(int m = 2; m <= 6; m++)
			for(int n = 2; n <= 6; n++)
				for(int b = -5; b <= 6; b++)
					world.setBlock(i + m, j + b, k + n, 0, 0, 2);

		for(int m = 2; m <= 6; m++)
			for(int n = 2; n <= 6; n++)
				world.setBlock(i + m, j + 7, k + n, 0, 0, 2);

		world.setBlock(i + 2, j + 6, k + 2, Block.stoneBrick.blockID, 0, 2);		
		world.setBlock(i + 2, j + 6, k + 3, Block.stairsStoneBrick.blockID, 3, 2);
		world.setBlock(i + 2, j + 5, k + 4, Block.stairsStoneBrick.blockID, 3, 2);
		world.setBlock(i + 2, j + 6, k + 5, Block.torchRedstoneActive.blockID, 0, 2);
		world.setBlock(i + 2, j + 4, k + 5, Block.stairsStoneBrick.blockID, 3, 2);

		world.setBlock(i + 2, j + 3, k + 6, Block.stoneBrick.blockID, 0, 2);		
		world.setBlock(i + 3, j + 3, k + 6, Block.stairsStoneBrick.blockID, 1, 2);
		world.setBlock(i + 4, j + 2, k + 6, Block.stairsStoneBrick.blockID, 1, 2);
		world.setBlock(i + 5, j + 3, k + 6, Block.torchRedstoneActive.blockID, 0, 2);
		world.setBlock(i + 5, j + 1, k + 6, Block.stairsStoneBrick.blockID, 1, 2);

		world.setBlock(i + 6, j, k + 6, Block.stoneBrick.blockID, 0, 2);		
		world.setBlock(i + 6, j, k + 5, Block.stairsStoneBrick.blockID, 2, 2);
		world.setBlock(i + 6, j - 1, k + 4, Block.stairsStoneBrick.blockID, 2, 2);
		world.setBlock(i + 6, j, k + 3, Block.torchRedstoneActive.blockID, 0, 2);
		world.setBlock(i + 6, j - 2, k + 3, Block.stairsStoneBrick.blockID, 2, 2);

		world.setBlock(i + 6, j - 3, k + 2, Block.stoneBrick.blockID, 0, 2);		
		world.setBlock(i + 5, j - 3, k + 2, Block.stairsStoneBrick.blockID, 0, 2);
		world.setBlock(i + 4, j - 4, k + 2, Block.stairsStoneBrick.blockID, 0, 2);
		world.setBlock(i + 3, j - 3, k + 2, Block.torchRedstoneActive.blockID, 0, 2);
		world.setBlock(i + 3, j - 5, k + 2, Block.stairsStoneBrick.blockID, 0, 2);
		world.setBlock(i + 2, j - 6, k + 2, Block.stoneBrick.blockID, 0, 2);	

	}

	public void generateChamber(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		for(int m = -3; m <= 11; m++)
			for(int n = -3; n <= 11; n++)
				for(int b = 0; b <= 7; b++)
					world.setBlock(i + m, j + b, k + n, Block.stoneBrick.blockID, 0, 2);

		for(int m = -2; m <= 10; m++)
			for(int n = -2; n <= 10; n++)
				for(int b = 1; b <= 6; b++)
					world.setBlock(i + m, j + b, k + n, 0, 0, 2);

		//(i, j + 1, k + 3);

		entityplayer.addChatMessage("SCP-087 Spawned." +    

				" | [Type: \u00a7eEuclid\u00a7f]");
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity087 var8 = new SCPEntity087(par0World);
		var8.setLocationAndAngles(par2 + 3, par4 - 9, par6 + 2, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}