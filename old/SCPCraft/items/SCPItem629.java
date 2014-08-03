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
import SCPCraft.entities.SCPEntity629;

public class SCPItem629 extends SCPItemDocument
{
	public SCPItem629(int i)
	{
		super(i, 0);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a72SCP-629");
		list.add("\u00a77Mr. Brass");
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
				spawnRoom(par3World, par4, par5, par6 + 4);

				par2EntityPlayer.addChatMessage("SCP-629 Spawned." +    

						" | [Type: \u00a72Safe\u00a7f]");
			}

			par2EntityPlayer.addChatMessage("\u00a7lSCP-629: \u00a7rI want arms! Give me my arms please, sir!");
			return true;
		}
	}

	public static void spawnRoom(World par3World, int par4, int par5, int par6)
	{
		for(int m = -3; m <= 4; m++)
			for(int n = -3; n <= 4; n++)
				par3World.setBlock(par4 + m, par5 - 1, par6 + n, Block.stone.blockID, 0, 2);

		for(int m = -3; m <= 4; m++)
			for(int n = -3; n <= 4; n++)
				for(int b = 0; b <= 3; b++)
					par3World.setBlock(par4 + m, par5 + b, par6 + n, mod_SCP.Locker.blockID, 0, 2);

		for(int m = 1; m <= 3; m++)
			for(int b = 1; b <= 2; b++)
				par3World.setBlock(par4 + m, par5 + b, par6 - 3, Block.thinGlass.blockID, 0, 2);

		for(int m = -1; m <= 2; m++)
			par3World.setBlock(par4 + m, par5 + 2, par6 + 4, Block.thinGlass.blockID, 0, 2);

		for(int m = -2; m <= 3; m++)
			for(int n = -2; n <= 3; n++)
				for(int b = 0; b <= 2; b++)
					par3World.setBlock(par4 + m, par5 + b, par6 + n, 0, 0, 2);

		par3World.setBlock(par4 - 2, par5 + 1, par6 - 4, mod_SCP.KeycardSlot.blockID, 2, 2);
		par3World.setBlock(par4, par5 + 1, par6 - 2, mod_SCP.KeycardSlot.blockID, 0, 2);

		par3World.setBlock(par4 - 1, par5 + 3, par6 + 2, Block.redstoneLampActive.blockID, 0, 2);
		par3World.setBlock(par4 + 2, par5 + 3, par6 + 2, Block.redstoneLampActive.blockID, 0, 2);

		par3World.setBlock(par4 - 1, par5 + 3, par6 - 1, Block.redstoneLampActive.blockID, 0, 2);
		par3World.setBlock(par4 + 2, par5 + 3, par6 - 1, Block.redstoneLampActive.blockID, 0, 2);

		par3World.setBlock(par4 + 1, par5 + 4, par6, Block.torchRedstoneActive.blockID, 0, 2);
		par3World.setBlock(par4 + 1, par5 + 4, par6 - 1, Block.redstoneWire.blockID, 0, 2);
		par3World.setBlock(par4, par5 + 4, par6 - 1, Block.redstoneWire.blockID, 0, 2);

		par3World.setBlock(par4 + 1, par5 + 4, par6 + 1, Block.redstoneWire.blockID, 0, 2);
		par3World.setBlock(par4 + 1, par5 + 4, par6 + 2, Block.redstoneWire.blockID, 0, 2);
		par3World.setBlock(par4, par5 + 4, par6 + 2, Block.redstoneWire.blockID, 0, 2);		
		ItemDoor.placeDoorBlock(par3World, par4 - 1, par5, par6 - 3, 1, Block.doorSteel);
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity629 var8 = new SCPEntity629(par0World);
		var8.setLocationAndAngles(par2 + 2, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}

}