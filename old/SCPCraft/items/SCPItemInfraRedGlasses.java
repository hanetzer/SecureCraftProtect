package SCPCraft.items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import SCPCraft.SCPArmorMaterial;
import SCPCraft.mod_SCP;

public class SCPItemInfraRedGlasses extends ItemArmor
{
    private static final int maxDamageArray[] = {
        11, 16, 15, 13
    };
    public final int armorType;
    public final int damageReduceAmount;
    public final int renderIndex;
    private final SCPArmorMaterial material;
 
    public SCPItemInfraRedGlasses(int i, SCPArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, EnumArmorMaterial.IRON, j, k);
        material = enumarmormaterial;
        armorType = k;
        renderIndex = j;
        damageReduceAmount = enumarmormaterial.getDamageReductionAmount(k);
        setMaxDamage(enumarmormaterial.getDurability(k));
        maxStackSize = 1;
		this.setCreativeTab(mod_SCP.tabItemSCP);
    }
 
    public int getItemEnchantability()
    {
        return material.getEnchantability();
    }
 
    public static int[] getMaxDamageArray()
    {
        return maxDamageArray;
    }
 
}