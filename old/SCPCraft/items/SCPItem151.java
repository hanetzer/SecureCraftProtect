package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem151 extends SCPItemDocument
{
	public SCPItem151(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-151");
		list.add("\u00a77The Painting");
	}

	public boolean isFull3D()
	{
		return true;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int v = determineOrientation(par3World, par4, par5, par6, par2EntityPlayer);
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
			--par1ItemStack.stackSize;

			//Layer 1
			par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);

			for(int width = -1; width <= 6; width++)
			{
				for(int length = -1; length <= 5; length++)
				{
					for(int height = -1; height <= 4; height++)
					{
						par3World.setBlock(par4 + width, par5 + height, par6 + length, Block.cloth.blockID);
					}
				}
			}
			for(int width = 0; width <= 5; width++)
			{
				for(int length = 0; length <= 4; length++)
				{
					for(int height = 0; height <= 3; height++)
					{
						par3World.setBlock(par4 + width, par5 + height, par6 + length, 0);
					}
				}
			}
			par3World.setBlock(par4 + 1, par5 + 1, par6 - 2, mod_SCP.KeycardSlotLv2.blockID, 2, 2);
			par3World.setBlock(par4 + 3, par5 + 1, par6, mod_SCP.KeycardSlotLv2.blockID, 0, 2);

			ItemDoor.placeDoorBlock(par3World, par4 + 2, par5, par6 - 1, 1, Block.doorSteel);

			par3World.setBlock(par4 + 3, par5, par6 + 4, mod_SCP.SCP151.blockID, 3, 2);
			
			par2EntityPlayer.addChatMessage("SCP-151 Spawned." +    

					" | [Type: \u00a7eEuclid\u00a7f]");

			return true;
		}
	}
	
    public static int determineOrientation(World par0World, int par1, int par2, int par3, EntityPlayer par4EntityPlayer)
    {
        if (MathHelper.abs((float)par4EntityPlayer.posX - (float)par1) < 2.0F && MathHelper.abs((float)par4EntityPlayer.posZ - (float)par3) < 2.0F)
        {
            double var5 = par4EntityPlayer.posY + 1.82D - (double)par4EntityPlayer.yOffset;

            if (var5 - (double)par2 > 2.0D)
            {
                return 1;
            }

            if ((double)par2 - var5 > 0.0D)
            {
                return 0;
            }
        }

        int var7 = MathHelper.floor_double((double)(par4EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return var7 == 0 ? 2 : (var7 == 1 ? 5 : (var7 == 2 ? 3 : (var7 == 3 ? 4 : 0)));
    }

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		return false;
	}
}