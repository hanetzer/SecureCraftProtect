package securecraftprotect.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import securecraftprotect.init.SCPItems;
import securecraftprotect.init.SCPTiles;

public class SCPTab extends CreativeTabs {
    public SCPTab(int position, String name) {
        super(position, name);
    }
    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(SCPItems.pearl, 1, 2);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }
}
