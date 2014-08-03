package SCPCraft.items;

import SCPCraft.mod_SCP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class SCPItem extends Item
{
	public SCPItem(int i)
	{
		super(i);
	}
	
	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
}
