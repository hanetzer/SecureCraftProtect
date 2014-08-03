package SCPCraft.items;

import net.minecraft.creativetab.CreativeTabs;
import SCPCraft.mod_SCP;

public final class SCPItemsTab extends CreativeTabs
{
    public SCPItemsTab(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    public int getTabIconItemIndex()
    {
        return mod_SCP.Circuit.itemID;
    }
    
    public String getTabLabel()
    {
        return "SCPItems";
    }
}
