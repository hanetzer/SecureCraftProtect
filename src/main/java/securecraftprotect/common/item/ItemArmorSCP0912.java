package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import securecraftprotect.SCP;

public class ItemArmorSCP0912 extends ItemArmor {
    public int armorSlot, meta;
    private int SLOTS = 4, TYPES = 2;
    private IIcon[][] armorIcon = new IIcon[TYPES][SLOTS];

    public ItemArmorSCP0912(ArmorMaterial material, int renderIndex, int armorType, int meta) {
        super(material, renderIndex, armorType);
        armorSlot = armorType;
        this.meta = meta;
        setCreativeTab(SCP.scpItem);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        String textureLoc = "";
        switch (meta) {
            case 0:
                textureLoc = "scp:textures/models/armor/classd_";
                break;
            case 1:
                textureLoc = "scp:textures/models/armor/912_";
                break;
        }
        switch (armorSlot) {
            case 2:
                return textureLoc + "2.png";
            default:
                return textureLoc + "1.png";
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        armorIcon[0][0] = iconRegister.registerIcon("scp:gas_mask");
        armorIcon[0][1] = iconRegister.registerIcon("scp:classd_shirt");
        armorIcon[0][2] = iconRegister.registerIcon("scp:classd_pants");
        armorIcon[0][3] = iconRegister.registerIcon("scp:classd_boots");
        armorIcon[1][0] = iconRegister.registerIcon("scp:gas_mask");
        armorIcon[1][1] = iconRegister.registerIcon("scp:classd_shirt");
        armorIcon[1][2] = iconRegister.registerIcon("scp:classd_pants");
        armorIcon[1][3] = iconRegister.registerIcon("scp:classd_boots");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass) {
        return armorIcon[this.meta][this.armorSlot];
    }
}
