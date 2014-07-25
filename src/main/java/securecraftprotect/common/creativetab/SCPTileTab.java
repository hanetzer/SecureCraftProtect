package securecraftprotect.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import securecraftprotect.init.SCPTiles;

public class SCPTileTab extends CreativeTabs {
    public SCPTileTab(int position, String name) {
        super(position, name);
    }
    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(SCPTiles.reinforced_steel);
    }
}
