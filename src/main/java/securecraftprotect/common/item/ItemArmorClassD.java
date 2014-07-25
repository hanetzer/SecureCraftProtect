package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import securecraftprotect.SCP;

public class ItemArmorClassD extends ItemArmor {
    public ItemArmorClassD(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        setCreativeTab(SCP.scpItem);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        String textureLoc = "scp:textures/models/armor/classd_";
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
                itemIcon = iconRegister.registerIcon("scp:gas_mask");
                break;
            case 1:
                itemIcon = iconRegister.registerIcon("scp:classd_shirt");
                break;
            case 2:
                itemIcon = iconRegister.registerIcon("scp:classd_pants");
                break;
            case 3:
                itemIcon = iconRegister.registerIcon("scp:classd_boots");
                break;
        }
    }
}
