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
import SCPCraft.entities.SCPEntity538;

public class SCPItem538 extends SCPItemDocument
{
	public SCPItem538(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-538");
		list.add("\u00a77Shadow Spiders");
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

			for(int height = -1; height <= 3; height++)
				for(int length = -1; length <= 15; length++)
					for(int width = -1; width <= 15; width++)
					{					
						par3World.setBlock(par4 + length, par5 + height, par6 + width, Block.cloth.blockID, 0, 2);					
					}
			par3World.setBlock(par4, par5 + 3, par6, Block.glowStone.blockID, 0, 2);
			par3World.setBlock(par4 + 14, par5 + 3, par6, Block.glowStone.blockID, 0, 2);	
			par3World.setBlock(par4, par5 + 3, par6 + 14, Block.glowStone.blockID, 0, 2);	
			par3World.setBlock(par4 + 14, par5 + 3, par6 + 14, Block.glowStone.blockID, 0, 2);	
			par3World.setBlock(par4 + 7, par5 + 3, par6 + 7, Block.glowStone.blockID, 0, 2);	
			par3World.setBlock(par4 + 7, par5 + 3, par6 + 3, Block.glowStone.blockID, 0, 2);
			par3World.setBlock(par4 + 7, par5 + 3, par6 + 11, Block.glowStone.blockID, 0, 2);
			par3World.setBlock(par4 + 3, par5 + 3, par6 + 7, Block.glowStone.blockID, 0, 2);
			par3World.setBlock(par4 + 11, par5 + 3, par6 + 7, Block.glowStone.blockID, 0, 2);
			par3World.setBlock(par4 + 7, par5 + 3, par6, Block.glowStone.blockID, 0, 2);	
			par3World.setBlock(par4, par5 + 3, par6 + 7, Block.glowStone.blockID, 0, 2);	
			par3World.setBlock(par4 + 14, par5 + 3, par6 + 7, Block.glowStone.blockID, 0, 2);	
			par3World.setBlock(par4 + 7, par5 + 3, par6 + 14, Block.glowStone.blockID, 0, 2);	

			for(int height = 1; height <= 2; height++)
				for(int length = 6; length <= 11; length++)
				{
					par3World.setBlock(par4 + length, par5 + height, par6 - 1, Block.thinGlass.blockID, 0, 2);
				}

			for(int height = 0; height <= 2; height++)
				for(int length = 0; length <= 14; length++)
					for(int width = 0; width <= 14; width++)
					{
						par3World.setBlock(par4 + length, par5 + height, par6 + width, 0, 0, 2);				
					}

			par3World.setBlock(par4 + 2, par5 + 1, par6 - 2, mod_SCP.KeycardSlotLv2.blockID, 2, 2);
			par3World.setBlock(par4 + 4, par5 + 1, par6, mod_SCP.KeycardSlotLv2.blockID, 0, 2);
			ItemDoor.placeDoorBlock(par3World, par4 + 3, par5, par6 - 1, 1, Block.doorSteel);

			SCPEntity538 SCPEntity538 = new SCPEntity538(par3World);
			SCPEntity538 SCPEntity5381 = new SCPEntity538(par3World);
			SCPEntity538 SCPEntity5382 = new SCPEntity538(par3World);
			SCPEntity538 SCPEntity5383 = new SCPEntity538(par3World);
			SCPEntity538 SCPEntity5384 = new SCPEntity538(par3World);
			SCPEntity538 SCPEntity5385 = new SCPEntity538(par3World);
			SCPEntity538 SCPEntity5386 = new SCPEntity538(par3World);
			SCPEntity538 SCPEntity5387 = new SCPEntity538(par3World);

			SCPEntity538.setPosition(par4 + 7, par5 + 1, par6 + 7);			
			par3World.joinEntityInSurroundings(SCPEntity538);

			SCPEntity5381.setPosition(par4 + 7, par5 + 1, par6 + 6);
			par3World.joinEntityInSurroundings(SCPEntity5381);

			SCPEntity5382.setPosition(par4 + 7, par5 + 1, par6 + 5);
			par3World.joinEntityInSurroundings(SCPEntity5382);

			SCPEntity5383.setPosition(par4 + 7, par5 + 1, par6 + 4);	
			par3World.joinEntityInSurroundings(SCPEntity5383);

			SCPEntity5384.setPosition(par4 + 6, par5 + 1, par6 + 7);
			par3World.joinEntityInSurroundings(SCPEntity5384);

			SCPEntity5385.setPosition(par4 + 5, par5 + 1, par6 + 7);
			par3World.joinEntityInSurroundings(SCPEntity5385);

			SCPEntity5386.setPosition(par4 + 4, par5 + 1, par6 + 7);
			par3World.joinEntityInSurroundings(SCPEntity5386);

			SCPEntity5387.setPosition(par4 + 3, par5 + 1, par6 + 7);
			par3World.joinEntityInSurroundings(SCPEntity5387);

			par2EntityPlayer.addChatMessage("SCP-538 Spawned." +    

					" | [Type: \u00a7eEuclid\u00a7f]");

			return true;
		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntity538 SCPEntity538 = new SCPEntity538(par0World);
		SCPEntity538 SCPEntity5381 = new SCPEntity538(par0World);
		SCPEntity538 SCPEntity5382 = new SCPEntity538(par0World);
		SCPEntity538 SCPEntity5383 = new SCPEntity538(par0World);
		SCPEntity538 SCPEntity5384 = new SCPEntity538(par0World);
		SCPEntity538 SCPEntity5385 = new SCPEntity538(par0World);
		SCPEntity538 SCPEntity5386 = new SCPEntity538(par0World);
		SCPEntity538 SCPEntity5387 = new SCPEntity538(par0World);

		SCPEntity538.setPosition(par2 + 7, par4 + 1, par6 + 7);			
		par0World.joinEntityInSurroundings(SCPEntity538);

		SCPEntity5381.setPosition(par2 + 7, par4 + 1, par6 + 6);
		par0World.joinEntityInSurroundings(SCPEntity5381);

		SCPEntity5382.setPosition(par2 + 7, par4 + 1, par6 + 5);
		par0World.joinEntityInSurroundings(SCPEntity5382);

		SCPEntity5383.setPosition(par2 + 7, par4 + 1, par6 + 4);	
		par0World.joinEntityInSurroundings(SCPEntity5383);

		SCPEntity5384.setPosition(par2 + 6, par4 + 1, par6 + 7);
		par0World.joinEntityInSurroundings(SCPEntity5384);

		SCPEntity5385.setPosition(par2 + 5, par4 + 1, par6 + 7);
		par0World.joinEntityInSurroundings(SCPEntity5385);

		SCPEntity5386.setPosition(par2 + 4, par4 + 1, par6 + 7);
		par0World.joinEntityInSurroundings(SCPEntity5386);

		SCPEntity5387.setPosition(par2 + 3, par4 + 1, par6 + 7);
		par0World.joinEntityInSurroundings(SCPEntity5387);

		par0World.spawnEntityInWorld(SCPEntity538);
		((EntityLiving)SCPEntity538).playLivingSound();

		par0World.spawnEntityInWorld(SCPEntity5381);
		((EntityLiving)SCPEntity5381).playLivingSound();

		par0World.spawnEntityInWorld(SCPEntity5382);
		((EntityLiving)SCPEntity5382).playLivingSound();

		par0World.spawnEntityInWorld(SCPEntity5383);
		((EntityLiving)SCPEntity5383).playLivingSound();

		par0World.spawnEntityInWorld(SCPEntity5384);
		((EntityLiving)SCPEntity5384).playLivingSound();

		par0World.spawnEntityInWorld(SCPEntity5385);
		((EntityLiving)SCPEntity5385).playLivingSound();

		par0World.spawnEntityInWorld(SCPEntity5386);
		((EntityLiving)SCPEntity5386).playLivingSound();

		return SCPEntity538 != null;
	}
}