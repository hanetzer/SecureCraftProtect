package SCPCraft.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.entities.SCPEntity872;

public class SCPItem872 extends SCPItemDocument
{
	public SCPItem872(int i)
	{
		super(i, 0);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a72SCP-872");
		list.add("\u00a77The Tattered Farmer");
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
			
			for(int length = 0; length <= 30; length++)
			{
				for(int width = 0; width <= 30; width++)
				{
					par3World.setBlock(par4 + width, par5, par6 + length, Block.fence.blockID);
				}
			}
			
			for(int length = 1; length <= 29; length++)
			{
				for(int width = 1; width <= 29; width++)
				{
					for(int height = 0; height <= 3; height++)
						par3World.setBlock(par4 + width, par5 + height, par6 + length, 0);
					
					Random rand = new Random();
					if(rand.nextInt(3) == 0)
					{
						par3World.setBlock(par4 + width, par5, par6 + length, Block.tallGrass.blockID, 3, 2);
					}
				}
			}
			
			for(int length = 0; length <= 30; length++)
			{
				for(int width = 0; width <= 30; width++)
				{
					par3World.setBlock(par4 + width, par5 - 1, par6 + length, Block.grass.blockID);
				}
			}
			
			par3World.setBlock(par4 + 3, par5, par6, Block.fenceGate.blockID, 0, 2);
	
			par2EntityPlayer.addChatMessage("SCP-872 Spawned." +    

					" | [Type: \u00a72Safe\u00a7f]");
			
		return true;
		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity872 var8 = new SCPEntity872(par0World);
		var8.setLocationAndAngles(par2 + 15, par4, par6 + 15, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}