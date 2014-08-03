package SCPCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCPItemWrench extends Item
{
	public int type;
	public SCPItemWrench(int i, int Type)
	{
		super(i);
		setMaxStackSize(1);
		this.setCreativeTab(mod_SCP.tabItemSCP);
		type = Type;
		if(Type == 0) setMaxDamage(100);
		else setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	public void updateIcons(IconRegister par1)
    {
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
    	if(type == 0) iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
    	else iconIndex = par1.registerIcon(mod_SCP.modid + ":Upgraded" + name);
    }

	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(type == 1) return true;
		else return false;
	}

	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		if(type == 1)
		{
			return par1ItemStack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
		}

		else
		{
			return par1ItemStack.getItemDamage() == 0 ? EnumRarity.uncommon : EnumRarity.common;
		}
	}

	public boolean isFull3D()
	{
		return true;
	}
}
