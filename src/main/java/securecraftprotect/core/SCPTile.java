package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import securecraftprotect.common.tile.TileBlood;
import securecraftprotect.common.tile.TileDocumentCrafter;
import securecraftprotect.common.tile.TileReinforcedSteel;

import static securecraftprotect.init.SCPTiles.*;

public class SCPTile {
    public static void init() {
        regBlocks();
    }

    private static void regBlocks() {
        blood = registerBlock(new TileBlood().setBlockName("scp:blood"));
        reinforced_steel = registerBlock(new TileReinforcedSteel().setBlockName("scp:reinforced_steel"));
        document_crafter = registerBlock(new TileDocumentCrafter().setBlockName("scp:document_crafter"));
    }
    public static Block registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().replace("tile.scp:", ""));

        return block;
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass) {
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.scp:", ""));

        return block;
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass, Object... constructorArgs) {
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.scp:", ""), constructorArgs);

        return block;
    }
}
