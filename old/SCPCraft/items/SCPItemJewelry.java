package SCPCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCPItemJewelry extends Item
{
	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
	
    public final int jewelryType;
    public boolean hasEffect;
    public EnumRarity rare;
    /** 
     * @param i The id of the item
     * @param type The type of jewelry (0 is for earings, 1 is for necklace, 2 is for bracelets and 3 is for rings)
     * @param dmg The max damage this item can have
     * @param effect Determines wheter the item has an effect or not
     * @param rarity How rare is this item
     */
	public SCPItemJewelry(int i, int type, int dmg, boolean effect, EnumRarity rarity)
	{
		super(i);
        this.jewelryType = type;
        hasEffect = effect;
        rare = rarity;
        this.setMaxDamage(dmg);
        this.setMaxStackSize(1);
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public boolean isFull3D()
	{
		return true;
	}

	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return rare;
	}

	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return hasEffect;
	}    
}
