package SCPCraft.items;

import SCPCraft.mod_SCP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class SCPItemArmor extends ItemArmor
{
	public SCPItemArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	public static int[] getMaxDamageArrays()
	{
		return getMaxDamageArray();
	}
	
	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
}
