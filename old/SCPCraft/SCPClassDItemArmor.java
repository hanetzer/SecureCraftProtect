package SCPCraft;
 
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class SCPClassDItemArmor extends ItemArmor
{
	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
 
    private static final int maxDamageArray[] = {
        11, 16, 15, 13
    };
    public final int armorType;
    public final int damageReduceAmount;
    public final int renderIndex;
    private final SCPArmorMaterial material;
 
    public SCPClassDItemArmor(int i, SCPArmorMaterial enumarmormaterial, int j, int k, CreativeTabs tab)
    {
        super(i, EnumArmorMaterial.DIAMOND, j, k);
        material = enumarmormaterial;
        armorType = k;
        renderIndex = j;
        damageReduceAmount = enumarmormaterial.getDamageReductionAmount(k);
        setMaxDamage(enumarmormaterial.getDurability(k));
        maxStackSize = 1;
		this.setCreativeTab(tab);
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