package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import securecraftprotect.SCP;

public class ItemArmorSCP0912 extends ItemArmor {

    public ItemArmorSCP0912(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        setCreativeTab(SCP.scpItem);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        String textureLoc = "scp:textures/models/armor/912_";
        switch (armorType) {
            case 2:
                return textureLoc + "2.png";
            default:
                return textureLoc + "1.png";
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        switch (armorType) {
            case 0:
                itemIcon = iconRegister.registerIcon("scp:0912_helmet");
                break;
            case 1:
                itemIcon = iconRegister.registerIcon("scp:0912_shirt");
                break;
            case 2:
                itemIcon = iconRegister.registerIcon("scp:0912_pants");
                break;
            case 3:
                itemIcon = iconRegister.registerIcon("scp:0912_shoes");

        }
    }
}
