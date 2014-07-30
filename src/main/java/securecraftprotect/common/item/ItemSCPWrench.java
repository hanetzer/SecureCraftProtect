package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import securecraftprotect.SCP;

public class ItemSCPWrench extends Item
{
	public int type;
	public ItemSCPWrench(int type)
	{
		super();
		setMaxStackSize(1);
		this.setCreativeTab(SCP.scpItem);
		this.type = type;
		if(type == 0) {
			setMaxDamage(100);
		}
		else {
			setMaxDamage(0);
		}
		setHasSubtypes(true);
	}
	public void registerIcons(IIconRegister register) {
		switch (type) {
			case 1:
				itemIcon = register.registerIcon("scp:upgradedwrench");
				break;
			default:
				itemIcon = register.registerIcon("scp:wrench");
				break;
		}
	}

	public boolean isItemEnchanted()
	{
		return (type == 1);
	}

	public EnumRarity getRarity(ItemStack stack)
	{
		switch (type) {
			case 1:
				return stack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
			default:
				return stack.getItemDamage() == 0 ? EnumRarity.uncommon : EnumRarity.common;
		}
	}

	public boolean isFull3D()
	{
		return true;
	}
}
