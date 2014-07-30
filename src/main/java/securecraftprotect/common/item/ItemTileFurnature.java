package securecraftprotect.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemTileFurnature extends ItemBlock
{
	public final Block block;
	private String[] types;

	public ItemTileFurnature(Block block)
	{
		super(block);
		this.block = block;
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	public ItemTileFurnature func_150943_a(String[] types)
	{
		this.types = types;
		return this;
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		if (this.types == null)
		{
			return super.getUnlocalizedName(stack);
		}
		else
		{
			int i = stack.getItemDamage();
			if (i >= 0 && i < this.types.length)
				return super.getUnlocalizedName(stack) + "." + this.types[i];
			else return super.getUnlocalizedName(stack);
		}
	}

	public int getMetadata(int meta) {
		return meta;
	}

	public IIcon getIconFromDamage(int damage) {
		return this.block.getIcon(2, damage);
	}
}
