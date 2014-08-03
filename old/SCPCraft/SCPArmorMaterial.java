package SCPCraft;

import SCPCraft.items.SCPItemArmor;
import net.minecraft.item.ItemArmor;

public enum SCPArmorMaterial
{
	ClassD("ClassD", 25, 29, new int[] {2, 7, 5, 3}, 9), 
	SCP912("SCP912", 26, 500, new int[] {40, 90, 70, 50}, 100);
	private int maxDamageFactor;
	private int damageReductionAmountArray[];
	private int enchantability;


	private SCPArmorMaterial(String s, int i, int j, int ai[], int k)
	{
		maxDamageFactor = j;
		damageReductionAmountArray = ai;
		enchantability = k;
	}

	public ItemArmor ar;

	public int getDurability(int i)
	{
		return SCPItemArmor.getMaxDamageArrays()[i] * maxDamageFactor;
	}
	public int getDamageReductionAmount(int i)
	{
		return damageReductionAmountArray[i];
	}

	public int getEnchantability()
	{
		return enchantability;
	}
}