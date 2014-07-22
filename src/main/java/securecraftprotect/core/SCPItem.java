package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import securecraftprotect.common.item.ItemSCPKnife;

import static securecraftprotect.init.SCPItems.scp1023ARC;
import static securecraftprotect.init.SCPItems.toolMaterial1023;

public class SCPItem {
    public static void init() {
        initMaterials();
        regItems();
    }

    private static void initMaterials() {
        toolMaterial1023 = EnumHelper.addToolMaterial("1023", 0, -1, 0.0F, 9998.0F, 0);
    }

    private static void regItems() {
        scp1023ARC = registerItem(new ItemSCPKnife(toolMaterial1023, 0).setUnlocalizedName("scp:1023arc"));
    }

    public static Item registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.scp:", ""));
        return item;
    }
}
