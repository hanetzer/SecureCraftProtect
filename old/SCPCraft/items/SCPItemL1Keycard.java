package SCPCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import SCPCraft.mod_SCP;

public class SCPItemL1Keycard extends Item
{
	public SCPItemL1Keycard(int i)
	{
		super(i);
		setMaxStackSize(1);
        this.setCreativeTab(mod_SCP.tabItemSCP);
	}
	
	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		name = name.substring(8);
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
}
