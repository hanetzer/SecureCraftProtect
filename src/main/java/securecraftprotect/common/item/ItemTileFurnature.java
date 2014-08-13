package securecraftprotect.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import securecraftprotect.common.tile.TileChair;
import securecraftprotect.common.tile.TileDesk;
import securecraftprotect.common.tileentity.TileEntityChair;

public class ItemTileFurnature extends ItemBlock
{
	public final Block block;
	public static String[][] types = {
			{"oak", "spruce", "birch", "acacia", "big_oak"},
			{"stone", "scp:granite", "scp:marble"}
	};

	public ItemTileFurnature(Block block)
	{
		super(block);
		this.block = block;
		setHasSubtypes(true);
		setMaxDurability(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		String s = block.getUnlocalizedName();
		int type;
		if(block instanceof TileChair) {
			TileChair tile = (TileChair) block;
			type = tile.getType();
		}
		else {
			TileDesk tile = (TileDesk) block;
			type = tile.getType();
		}
		String s1 = types[type][stack.getCurrentDurability()].replace("scp:", "");
		return s + "." + s1;
	}

	public int getMetadata(int meta)
	{
		return meta;
	}

	public IIcon getIconFromDamage(int damage)
	{
		return this.block.getIcon(2, damage);
	}
}
