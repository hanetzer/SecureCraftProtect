package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import securecraftprotect.SCP;
import securecraftprotect.common.item.*;
import securecraftprotect.common.tile.ITileFurnature;

import static securecraftprotect.init.SCPItems.*;

public class SCPItem {
    public static void init() {
        initMaterials();
        registerItems();
        registerCraft();
    }

    private static void initMaterials() {
        tool1023 = EnumHelper.addToolMaterial("1023", 0, -1, 0.0F, 9996.0F, 0);
        armorClassD = EnumHelper.addArmorMaterial("CLASSD", 29, new int[] {1, 3, 2, 1}, 0);
        armorSwat = EnumHelper.addArmorMaterial("SWAT", 33, new int[] {2, 6, 5, 2}, 9);
    }

    private static void registerItems() {
        scp1023ARC  = registerItem(new ItemSCPKnife(tool1023, 0).setUnlocalizedName("scp.1023arc").setCreativeTab(SCP.scpTab));
        gas_mask = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 0).setUnlocalizedName("scp.gas_mask"));
        classd_shirt = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 1).setUnlocalizedName("scp.classd_shirt"));
        classd_pants = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 2).setUnlocalizedName("scp.classd_pants"));
        classd_boots = registerItem(new ItemArmorClassD(armorClassD, SCP.proxy.addArmor("CLASSD"), 3).setUnlocalizedName("scp.classd_boots"));
        swat_helmet = registerItem(new ItemArmorSwat(armorSwat, SCP.proxy.addArmor("SWAT"), 0).setUnlocalizedName("scp.swat_helmet"));
        swat_shirt = registerItem(new ItemArmorSwat(armorSwat, SCP.proxy.addArmor("SWAT"), 1).setUnlocalizedName("scp.swat_shirt"));
        swat_pants = registerItem(new ItemArmorSwat(armorSwat, SCP.proxy.addArmor("SWAT"), 2).setUnlocalizedName("scp.swat_pants"));
        swat_shoes = registerItem(new ItemArmorSwat(armorSwat, SCP.proxy.addArmor("SWAT"), 3).setUnlocalizedName("scp.swat_shoes"));
        document    = registerItem(new ItemSCPDocument().setUnlocalizedName("scp.document"));
        pearl       = registerItem(new ItemSCPPearl().setUnlocalizedName("scp.pearl"));
        circuit     = registerItem(new Item().setUnlocalizedName("scp.circuit").setTextureName("scp:circuit"));
        bucket     = registerItem(new ItemBucket().setUnlocalizedName("scp.bucketAcid").setTextureName("scp:bucketAcid"));
		wrench = registerItem(new ItemSCPWrench(0).setUnlocalizedName("scp.wrench"));
		wrench_godly = registerItem(new ItemSCPWrench(1).setUnlocalizedName("scp.wrenchupgraded"));
    }

    private static void registerCraft() {
        GameRegistry.addShapedRecipe(new ItemStack(classd_shirt, 1),
                "A A", "AAA", "AAA", 'A', new ItemStack(Blocks.wool, 1, 1));
    }

    public static Item registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.scp.", ""), "scp");
        return item;
    }
}
