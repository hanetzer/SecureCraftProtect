package SCPCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import SCPCraft.mod_SCP;

public class SCPItemPearl extends Item
{
	public static String SCP;
	public SCPItemPearl(int i, String SCPID)
	{
		super(i);
		getSCPName();
		this.SCP = SCPID;
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}

	public static String getSCPName()
	{
		return SCP;
	}
}
