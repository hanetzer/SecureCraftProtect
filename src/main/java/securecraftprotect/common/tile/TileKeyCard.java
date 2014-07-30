package securecraftprotect.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.init.SCPItems;

import static securecraftprotect.init.SCPItems.wrench;
import static securecraftprotect.init.SCPItems.wrench_godly;

public class TileKeyCard extends TileKeyCardSlot
{
	public int type;
	public TileKeyCard(int type)
	{
		super();
		this.type = type;
		setTickRandomly(true);
		this.setCreativeTab(SCP.scpTile);
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
									EntityPlayer player, int dir,
									float par7, float par8, float par9)
	{
		ItemStack stack = player.inventory.getCurrentItem();
		int i = world.getBlockMetadata(x, y, z);
		int j = i & 7;
		if (world.isRemote)
		{
			return true;
		}else{
			if(stack != null && (stack.getItem() == SCPItems.keycard))
			{
				int k = 8 - (i & 8);
	            world.setBlockMetadataWithNotify(x, y, z, j + k, 0x03); //
	            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.click", 0.3F, 0.6F);
	            this.func_82536_d(world, x, y, z, j);
	            world.scheduleBlockUpdate(x, y, z, this, this.tickRate());
			}
			else
			{
				if(stack != null && (stack.getItem() == wrench_godly || stack.getItem() == wrench)) {
					world.setBlockMetadataWithNotify(x, y, z, j, 0x03);
					stack.damageItem(1, player);
					if(world.isRemote)
					{
						//player.addChatMessage("Keycard Level: 3");
					}

					if(!world.isRemote)
					{
						//player.addChatMessage("Keycard Level: 3");
					}
				}
				else
				{
					if(world.isRemote)
					{
						//player.addChatMessage("You need a Level 2 or" +
						//		" higher Keycard to activate.");
					}
					if(!world.isRemote)
					{
						//player.addChatMessage("You need a Level 2 or" +
						//		" higher Keycard to activate.");
					}
				}
			}		
			world.scheduleBlockUpdate(x, y, z, this, tickRate());
		}
		return true;
	}
}
