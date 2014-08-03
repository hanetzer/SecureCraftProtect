package SCPCraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import SCPCraft.mod_SCP;

public class SCPItemDescription extends Item
{
	public static final String[] scpNames = new String[] {"SCP-500", "SCP-063", "SCP-1025", "SCP-109", "SCP-50-AE-J", "SCP-420-J", "SCP-458", "SCP-217", "SCP-912"};
	public SCPItemDescription(int i)
	{
		super(i);
        this.setHasSubtypes(true);
		this.setCreativeTab(mod_SCP.tabItemSCP);
	}    
	
	public void updateIcons(IconRegister par1)
	{
		iconIndex = par1.registerIcon(mod_SCP.modid + ":DocumentItem");
	}

    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int var2 = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, scpNames.length - 1);
        return super.getUnlocalizedName() + "." + scpNames[var2];
    }
	
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < scpNames.length; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

	public String getTextureFile()
	{
		return "/SCPCraft/textures/SCPItems.png";
	}
}
