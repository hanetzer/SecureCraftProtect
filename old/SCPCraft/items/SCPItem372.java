package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity372;

public class SCPItem372 extends SCPItemDocument
{
	public SCPItem372(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-372");
		list.add("\u00a77Peripheral Jumper");
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

			for(int width = -1; width <= 8; width++)
			{
				for(int length = -1; length <= 8; length++)
				{
					for(int height = -1; height <= 4; height++)
					{
						par3World.setBlock(par4 + width, par5 + height, par6 + length, Block.glass.blockID);
						par3World.setBlock(par4 + width, par5 + 5, par6 + length, Block.blockSteel.blockID);
						par3World.setBlock(par4 + width, par5 + 2, par6 + length, Block.blockSteel.blockID);
						par3World.setBlock(par4 - 1, par5 + height, par6 - 1, Block.blockSteel.blockID);
						par3World.setBlock(par4 - 1, par5 + height, par6 + 8, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 8, par5 + height, par6 + 8, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 8, par5 + height, par6 - 1, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 3, par5 + height, par6 - 1, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 4, par5 + height, par6 - 1, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 3, par5 + height, par6 + 8, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 4, par5 + height, par6 + 8, Block.blockSteel.blockID);
						par3World.setBlock(par4 - 1, par5 + height, par6 + 3, Block.blockSteel.blockID);
						par3World.setBlock(par4 - 1, par5 + height, par6 + 4, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 8, par5 + height, par6 + 3, Block.blockSteel.blockID);
						par3World.setBlock(par4 + 8, par5 + height, par6 + 4, Block.blockSteel.blockID);
					}
				}
			}
			for(int width = 0; width <= 7; width++)
			{
				for(int length = 0; length <= 7; length++)
				{
					for(int height = 0; height <= 4; height++)
					{
						par3World.setBlock(par4 + width, par5 + height, par6 + length, 0);
					}
				}
			}

			par3World.setBlock(par4 + 4, par5 + 1, par6 - 2, mod_SCP.KeycardSlotLv2.blockID, 2, 2);
			par3World.setBlock(par4 + 4, par5 + 1, par6, mod_SCP.KeycardSlotLv2.blockID, 0, 2);

			for(int width = -1; width <= 8; width++)
			{
				for(int length = -1; length <= 8; length++)
				{
					par3World.setBlock(par4 + width, par5 - 1, par6 + length, Block.stone.blockID);
				}
			}

			ItemDoor.placeDoorBlock(par3World, par4 + 3, par5, par6 - 1, 1, Block.doorSteel);

			par2EntityPlayer.addChatMessage("SCP-372 Spawned." +    

					" | [Type: \u00a7eEuclid\u00a7f]");

			return true;
		}
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity372 var8 = new SCPEntity372(par0World);
		var8.setLocationAndAngles(par2 + 2, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}