package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem002 extends SCPItemDocument
{	
	public SCPItem002(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-002");
		list.add("\u00a77The Living Room");
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
			
			sphere(par3World, par4, par5 - 1, par6, 7, mod_SCP.Locker.blockID);
			sphere(par3World, par4, par5, par6, 6, mod_SCP.Flesh.blockID);
			
			for(int width = -1; width <= 7; width++)
			{
				for(int length = 0; length <= 6; length++)
				{
					par3World.setBlock(par4 + width - 2, par5 + 5, par6 + length - 2, mod_SCP.Bone.blockID); //
				}
			}
			for(int w = 1; w <= 21; w++)
			{
				if(par3World.getBlockId(par4 + 1, par5 - w + 7, par6 - 5 - w) == 0)par3World.setBlock(par4 + 1, par5 - w + 7, par6 - 5 - w, Block.stairsStoneBrick.blockID, 2, 2);
			}
			par3World.setBlock(par4 + 1, par5 + 5, par6 - 6, Block.stoneBrick.blockID);
			ItemDoor.placeDoorBlock(par3World, par4 + 1, par5 + 6, par6 - 5, 1, Block.doorSteel);
			
			par3World.setBlock(par4 + 1, par5 + 6, par6 - 6, 0); //
			par3World.setBlock(par4 + 1, par5 + 7, par6 - 6, 0); //
			par3World.setBlock(par4 + 2, par5 + 6, par6 - 6, 0); //
			par3World.setBlock(par4 + 2, par5 + 7, par6 - 6, 0); //
			par3World.setBlock(par4, par5 + 6, par6 - 6, 0); //
			par3World.setBlock(par4, par5 + 7, par6 - 6, 0); //
			par3World.setBlock(par4 + 1, par5 + 6, par6 - 4, 0); //
			par3World.setBlock(par4 + 1, par5 + 7, par6 - 4, 0); //
			par3World.setBlock(par4, par5 + 7, par6 - 6, mod_SCP.KeycardSlotLv2.blockID, 0, 2);
			par3World.setBlock(par4 + 2, par5 + 7, par6 - 4, mod_SCP.KeycardSlotLv2.blockID, 0, 2);
			par3World.setBlock(par4 + 2, par5 + 7, par6 - 5, mod_SCP.Locker.blockID); //
			par3World.setBlock(par4 + 2, par5 + 6, par6 - 5, mod_SCP.Locker.blockID); //
			par3World.setBlock(par4, par5 + 7, par6 - 5, mod_SCP.Locker.blockID); //	
			par3World.setBlock(par4, par5 + 6, par6 - 5, mod_SCP.Locker.blockID); //
			
			par3World.setBlock(par4 + 5, par5 + 6, par6, mod_SCP.woodDesk.blockID); //
			par3World.setBlock(par4 + 5, par5 + 6, par6 + 1, mod_SCP.woodDesk.blockID); //
			par3World.setBlock(par4 + 5, par5 + 6, par6 + 2, mod_SCP.woodDesk.blockID); //
			par3World.setBlock(par4 + 5, par5 + 7, par6 + 2, Block.torchRedstoneActive.blockID); //
			par3World.setBlock(par4 + 5, par5 + 7, par6, Block.flowerPot.blockID);
			par3World.setBlock(par4 + 4, par5 + 6, par6 + 1, mod_SCP.woodenChair.blockID); //
			par3World.setBlock(par4 + 2, par5 + 6, par6 + 5, Block.chest.blockID); //
			par3World.setBlock(par4 + 1, par5 + 6, par6 + 5, Block.chest.blockID); //
			par3World.setBlock(par4, par5 + 6, par6 + 5, Block.enderChest.blockID, 2, 2);
			
			par2EntityPlayer.addChatMessage("SCP-002 Spawned." + " | [Type: \u00a7eEuclid\u00a7f]");

			return true;
		}
	}
	
	public void sphere(World par1World, int par3, int par4, int par5, int var7, int b)
	{
		int m;
		int n = var7;
	    int midX = (int)Math.floor(Math.IEEEremainder(1, 10));
	    int midZ = (int)Math.floor(Math.IEEEremainder(1, 10));
		for(m = 1; m <= var7; m++)	circle(par1World, par3 + midX, par4 + m, par5 + midZ, m, b);
		for(m = var7 + 1; m <= var7*2; m++){circle(par1World, par3 + midX, par4 + m, par5 + midZ, n, b);n--;}
	}
	
	public void circle(World par1World, int par3, int par4, int par5, int var7, int block)
    {
            int var8;
            int var9;
            int var10;
            int var11;

            for (var8 = par4; var8 < par4 + 1 && var8 < 128; ++var8)
            {
                for (var9 = par3 - var7; var9 <= par3 + var7; ++var9)
                {
                    for (var10 = par5 - var7; var10 <= par5 + var7; ++var10)
                    {
                        var11 = var9 - par3;
                        int var12 = var10 - par5;

                        if (var11 * var11 + var12 * var12 <= var7 * var7 + 1)
                        {
                            par1World.setBlock(var9, var8, var10, block); //
                        }
                    }
                }
            }
            
            for (var8 = par4; var8 < par4 + 1 && var8 < 128; ++var8)
            {
                for (var9 = par3 - var7 - 1; var9 <= par3 + var7 - 1; ++var9)
                {
                    for (var10 = par5 - var7 - 1; var10 <= par5 + var7 - 1; ++var10)
                    {
                        var11 = var9 - par3;
                        int var12 = var10 - par5;

                        if (var11 * var11 + var12 * var12 <= var7 * var7 - 2*var7)
                        {
                            par1World.setBlock(var9, var8, var10, 0); //
                        }
                    }
                }
            }
    }

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		return false;
	}
}