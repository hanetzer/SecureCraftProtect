package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.entities.SCPEntity111;

public class SCPItem111 extends SCPItemDocument
{
	public SCPItem111(int i)
	{
		super(i, 0);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a72SCP-111");
		list.add("\u00a77Dragon Snail");
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
					for(int b = 0; b <= 3; b++)
						par3World.setBlock(par4 + m, par5 + b, par6 + n, 0, 0, 2);		

			par3World.setBlock(par4 - 2, par5 + 2, par6, Block.blockSteel.blockID, 0, 2);		
			par3World.setBlock(par4 - 2, par5 + 2, par6 + 1, Block.torchWood.blockID, 0, 2);		

			for(int i = -3; i <= 3; i++)
				for(int j = 0; j <= 7; j++)
					par3World.setBlock(par4 + i, par5 - 1, par6 + j, Block.grass.blockID, 0, 2);		

			ItemDoor.placeDoorBlock(par3World, par4 - 2, par5, par6, 1, Block.doorWood);

			par2EntityPlayer.addChatMessage("SCP-111 Spawned." +    

					" | [Type: \u00a72Safe\u00a7f]");


			//(par4 + 2, par5, par6 + 3);

			return true;

		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity111 var8 = new SCPEntity111(par0World);
		var8.setLocationAndAngles(par2 + 2, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}