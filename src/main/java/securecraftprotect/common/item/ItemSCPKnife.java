package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSCPKnife extends ItemSword {
    public int textureID;

    public ItemSCPKnife(ToolMaterial material, int textureID) {
        super(material);
        this.textureID = textureID;
    }

    public boolean getIsRepairable(ItemStack itemToRepair,
                                   ItemStack itemToRepairWith) {
        return false;
    }

    public void registerIcons(IIconRegister iconRegister) {
        switch (textureID) {
            case 0:
                itemIcon = iconRegister.registerIcon("scp:1023");
                break;
            default:
                itemIcon = iconRegister.registerIcon("minecraft:slimeball");
                break;
        }
    }

    public boolean isFull3D() {
        return true;
    }

    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.epic;
    }
}
