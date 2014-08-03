package SCPCraft;

import net.minecraft.creativetab.CreativeTabs;

public final class SCPCupsTab extends CreativeTabs
{
    SCPCupsTab(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    public int getTabIconItemIndex()
    {
        return mod_SCP.CupEmpty.itemID;
    }
    
    public String getTabLabel()
    {
        return "SCPCups";
    }
}
