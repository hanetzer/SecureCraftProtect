package securecraftprotect.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import securecraftprotect.init.SCPItems;

public class SCPItemTab extends CreativeTabs {
    public SCPItemTab(int position, String name) {
        super(position, name);
    }
    @Override
    public Item getTabIconItem() {
        return SCPItems.circuit;
    }
}
