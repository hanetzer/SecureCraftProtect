package SCPCraft;

import net.minecraft.creativetab.CreativeTabs;

public final class SCPCreativeTab extends CreativeTabs
{
    SCPCreativeTab(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    public int getTabIconItemIndex()
    {
        return mod_SCP.SCP173S.itemID;
    }
    
    public String getTabLabel()
    {
        return "SCPs";
    }
}
