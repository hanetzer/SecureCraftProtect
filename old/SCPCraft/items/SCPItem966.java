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
import SCPCraft.entities.SCPEntity966;

public class SCPItem966 extends SCPItemDocument
{
	public SCPItem966(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-966");
		list.add("\u00a77Sleep Killer");
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

			for(int length = 0; length <= 9; length++)
			{
				for(int width = 0; width <= 9; width++)
				{
					for(int heigth = -1; heigth <= 6; heigth++)
					{
						par3World.setBlock(par4 + width, par5 + heigth, par6 + length, mod_SCP.Locker.blockID);
					}
				}
			}
			for(int length = 1; length <= 8; length++)
			{
				for(int width = 1; width <= 8; width++)
				{
					for(int heigth = 0; heigth <= 5; heigth++)
					{
						par3World.setBlock(par4 + width, par5 + heigth, par6 + length, 0);
					}
				}
			}
			ItemDoor.placeDoorBlock(par3World, par4 + 4, par5, par6, 1, Block.doorSteel);
			par3World.setBlock(par4 + 3, par5 + 1, par6 - 1, mod_SCP.KeycardSlotLv2.blockID, 2, 2);
			par3World.setBlock(par4 + 5, par5 + 1, par6 + 1, mod_SCP.KeycardSlotLv2.blockID, 0, 2);

			par2EntityPlayer.addChatMessage("SCP-966 Spawned." + " | [Type: \u00a7eEuclid\u00a7f]");


			return true;
		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity966 var8 = new SCPEntity966(par0World);
		var8.setLocationAndAngles(par2 + 3, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();
		
		SCPEntity966 var9 = new SCPEntity966(par0World);
		var9.setLocationAndAngles(par2 + 4, par4, par6 + 4, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var9);
		((EntityLiving)var9).playLivingSound();
		
		SCPEntity966 var10 = new SCPEntity966(par0World);
		var10.setLocationAndAngles(par2 + 5, par4, par6 + 5, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var10);
		((EntityLiving)var10).playLivingSound();
		
		SCPEntity966 var11 = new SCPEntity966(par0World);
		var11.setLocationAndAngles(par2 + 6, par4, par6 + 6, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var11);
		((EntityLiving)var11).playLivingSound();

		return var8 != null;
	}
}


