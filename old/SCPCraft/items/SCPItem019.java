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
import SCPCraft.entities.SCPEntity019n2;

public class SCPItem019 extends SCPItemDocument
{
	public SCPItem019(int i)
	{
		super(i, 2);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a74SCP-019");
		list.add("\u00a77The Monster Pot");
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

			//Layer 1
			par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			spawnRoom(par3World, par4, par5, par6 + 4);
			par3World.setBlock(par4, par5, par6 + 4, mod_SCP.SCP019.blockID, 0, 0);

			par2EntityPlayer.addChatMessage("SCP-019 Spawned." +    

					" | [Type: \u00a74Keter\u00a7f]");

			return true;
		}
	}

	public static void spawnRoom(World par3World, int par4, int par5, int par6)
	{
		for(int m = -3; m <= 3; m++)
			for(int n = -3; n <= 3; n++)
				par3World.setBlock(par4 + m, par5 - 1, par6 + n, Block.stone.blockID, 0, 2);

		for(int m = -3; m <= 3; m++)
			for(int n = -3; n <= 3; n++)
				for(int b = 0; b <= 3; b++)
					par3World.setBlock(par4 + m, par5 + b, par6 + n, Block.stone.blockID, 0, 2);

		for(int m = -2; m <= 2; m++)
			for(int n = -2; n <= 2; n++)
				for(int b = 0; b <= 2; b++)
					par3World.setBlock(par4 + m, par5 + b, par6 + n, 0, 0, 2);

		par3World.setBlock(par4 - 2, par5 + 1, par6 - 4, mod_SCP.KeycardSlotLv3.blockID, 2, 2);
		par3World.setBlock(par4, par5 + 1, par6 - 2, mod_SCP.KeycardSlotLv3.blockID, 0, 2);
		ItemDoor.placeDoorBlock(par3World, par4 - 1, par5, par6 - 3, 1, Block.doorSteel);
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity019n2 var8 = new SCPEntity019n2(par0World);
		var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}