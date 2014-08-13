package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import securecraftprotect.SCP;

import java.util.List;

public class ItemSCPKeyCard extends Item
{
	private String[] types = {"1", "2", "3", "omni"};
	private IIcon[] icons;
	public ItemSCPKeyCard()
	{
		super();
		setMaxStackSize(1);
		setMaxDurability(0);
		setHasSubtypes(true);
        this.setCreativeTab(SCP.scpItem);
	}

	public void registerIcons(IIconRegister register) {
		icons = new IIcon[types.length];
		for (int i = 0; i < icons.length; ++ i) {
			icons[1] = register.registerIcon("scp:keycard_" + types[i]);
		}
	}

	public IIcon getIconFromDamage(int damage) {
		return icons[damage];
	}

	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < types.length; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
}
