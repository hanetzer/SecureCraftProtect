package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import securecraftprotect.SCP;
import securecraftprotect.common.item.*;

import static securecraftprotect.init.SCPItems.*;

public class SCPItem {
    public static void init() {
        initMaterials();
        registerItems();
        registerCraft();
    }

    private static void initMaterials() {
        tool1023 = EnumHelper.addToolMaterial("1023", 0, -1, 0.0F, 9996.0F, 0);
        armorClassD = EnumHelper.addArmorMaterial("CLASSD", 29, new int[] {2, 7, 5, 3}, 9);
        armor0912 = EnumHelper.addArmorMaterial("0912", 500, new int[] {40, 90, 70, 50}, 100);
    }

    private static void registerItems() {
        scp1023ARC  = registerItem(new ItemSCPKnife(tool1023, 0).setUnlocalizedName("scp:1023arc").setCreativeTab(SCP.scpTab));
        gas_mask = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 0).setUnlocalizedName("scp:gas_mask"));
        classd_shirt = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 1).setUnlocalizedName("scp:classd_shirt"));
        classd_pants = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 2).setUnlocalizedName("scp:classd_pants"));
        classd_boots = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 3).setUnlocalizedName("scp:classd_boots"));
        scp0912_helmet = registerItem(new ItemArmorSCP0912(armor0912, SCP.proxy.addArmor("0912"), 0).setUnlocalizedName("scp:0912_helmet"));
        scp0912_shirt = registerItem(new ItemArmorSCP0912(armor0912, SCP.proxy.addArmor("0912"), 1).setUnlocalizedName("scp:0912_shirt"));
        scp0912_pants = registerItem(new ItemArmorSCP0912(armor0912, SCP.proxy.addArmor("0912"), 2).setUnlocalizedName("scp:0912_pants"));
        scp0912_shoes = registerItem(new ItemArmorSCP0912(armor0912, SCP.proxy.addArmor("0912"), 3).setUnlocalizedName("scp:0912_shoes"));
        document    = registerItem(new ItemSCPDocument().setUnlocalizedName("scp:document"));
        pearl       = registerItem(new ItemSCPPearl().setUnlocalizedName("scp:pearl"));
        circuit     = registerItem(new Item().setUnlocalizedName("scp:circuit").setTextureName("scp:circuit"));
    }

    private static void registerCraft() {

    }
    public static Item registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.scp:", ""), "scp");
        return item;
    }
}
