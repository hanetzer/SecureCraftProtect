package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntityClassDGuy;

public class SCPItem914 extends SCPItemDocument
{
	public SCPItem914(int i)
	{
		super(i, 0);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a72SCP-914");
		list.add("\u00a77The Clockworks");
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
				for(int width = -5; width <=5; width++)
					for(int length = 0; length <= 7; length++)
						for(int height = 0; height <= 5; height++)
							par3World.setBlock(par4 + width, par5 + height, par6 + length, 0);
				par3World.setBlock(par4 - 4, par5, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5, par6 + 2, Block.torchWood.blockID);
				par3World.setBlock(par4 - 4, par5 + 1, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5 - 1, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5 - 1, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5 - 1, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5 + 2, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5 + 2, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5 + 2, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5 + 1, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 4, par5, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 5, par5, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 5, par5 + 1, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 5, par5, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 5, par5 + 1, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 5, par5, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 5, par5 + 1, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5, par6 + 2, Block.torchWood.blockID);
				par3World.setBlock(par4 + 4, par5 + 1, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5 - 1, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5 - 1, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5 - 1, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5 + 2, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5 + 2, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5 + 2, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5 + 1, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 4, par5, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 5, par5, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 5, par5 + 1, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 5, par5, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 5, par5 + 1, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 5, par5, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 5, par5 + 1, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 6, Block.stone.blockID);

				// Floor
				par3World.setBlock(par4, par5 - 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 - 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6 + 1, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 1, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6 + 1, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6 + 1, Block.stoneBrick.blockID);
				par3World.setBlock(par4, par5 - 1, par6 + 2, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6 + 2, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 2, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6 + 2, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6 + 2, Block.stoneBrick.blockID);
				par3World.setBlock(par4, par5 - 1, par6 + 3, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6 + 3, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 3, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6 + 3, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6 + 3, Block.stoneBrick.blockID);
				par3World.setBlock(par4, par5 - 1, par6 + 4, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6 + 4, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 4, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6 + 4, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6 + 4, Block.stoneBrick.blockID);
				par3World.setBlock(par4, par5 - 1, par6 + 5, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6 + 5, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 5, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6 + 5, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6 + 5, Block.stoneBrick.blockID);
				par3World.setBlock(par4, par5 - 1, par6 + 6, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 1, par5 - 1, par6 + 6, Block.stoneBrick.blockID);
				par3World.setBlock(par4 + 2, par5 - 1, par6 + 6, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 1, par5 - 1, par6 + 6, Block.stoneBrick.blockID);
				par3World.setBlock(par4 - 2, par5 - 1, par6 + 6, Block.stoneBrick.blockID);
				par3World.setBlock(par4, par5, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 1, par5, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 1, par5, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5, par6 + 7, Block.stone.blockID);
				//Layer 2

				par3World.setBlock(par4, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 1, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 1, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 2, Block.thinGlass.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 3, Block.thinGlass.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 4, Block.thinGlass.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 2, Block.thinGlass.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 3, Block.thinGlass.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 4, Block.thinGlass.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 1, par6 + 6, Block.stone.blockID);
				// Layer 3

				par3World.setBlock(par4, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 1, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 1, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 + 2, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 2, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 + 2, par6, Block.stone.blockID);
				//Layer 4

				par3World.setBlock(par4, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 1, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 1, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4, par5 + 3, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 1, par5 + 3, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 1, par5 + 3, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 2, par5 + 3, par6, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 - 3, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 7, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 1, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 2, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 3, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 4, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 5, Block.stone.blockID);
				par3World.setBlock(par4 + 3, par5 + 3, par6 + 6, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 + 3, par6, Block.stone.blockID);
				// Top

				par3World.setBlock(par4, par5 + 4, par6, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 6, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6 + 6, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 3, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 1, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 2, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 3, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 4, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 5, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 6, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 6, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 6, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 6, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 6, Block.blockSteel.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 + 3, par5 + 4, par6 + 7, Block.blockSteel.blockID);
				par3World.setBlock(par4 - 2, par5 + 4, par6 + 7, Block.blockSteel.blockID);	
				par3World.setBlock(par4 - 2, par5, par6, Block.stone.blockID);
				par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID);
				par3World.setBlock(par4, par5 + 1, par6 + 6, mod_SCP.SCP914.blockID);
				par3World.setBlock(par4, par5 + 2, par6 + 6, Block.torchWood.blockID);
				par3World.setBlock(par4 - 1, par5 + 1, par6 + 6, mod_SCP.Machinery.blockID);
				par3World.setBlock(par4 - 2, par5 + 1, par6 + 6, mod_SCP.Machinery.blockID);
				par3World.setBlock(par4 + 1, par5 + 1, par6 + 6, mod_SCP.Machinery.blockID);
				par3World.setBlock(par4 + 2, par5 + 1, par6 + 6, mod_SCP.Machinery.blockID);
				par3World.setBlock(par4, par5, par6 + 6, mod_SCP.Machinery.blockID);
				par3World.setBlock(par4 + 2, par5, par6 + 6, mod_SCP.Machinery.blockID);
				par3World.setBlock(par4 - 2, par5, par6 + 6, mod_SCP.Machinery.blockID);
				par3World.setBlock(par4 - 1, par5, par6 + 6, Block.netherFence.blockID);
				par3World.setBlock(par4 + 1, par5, par6 + 6, Block.netherFence.blockID);

				//(par4 + 3.8, par5, par6 + 3);
				//(par4 - 3.5, par5, par6 + 3);

				par2EntityPlayer.addChatMessage("SCP-914 Spawned." +    

						" | [Type: \u00a72Safe\u00a7f]");

			}

			return true;
		}

	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntityClassDGuy var8 = new SCPEntityClassDGuy(par0World);
		var8.setLocationAndAngles(par2 + 3.8, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		SCPEntityClassDGuy var9 = new SCPEntityClassDGuy(par0World);
		var9.setLocationAndAngles(par2 - 3.8, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var9);
		((EntityLiving)var9).playLivingSound();

		return var8 != null;
	}
}