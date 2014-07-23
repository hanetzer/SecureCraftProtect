package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import securecraftprotect.common.tile.TileBlood;
import securecraftprotect.common.tile.TileLocker;

import static securecraftprotect.init.SCPTiles.*;

public class SCPTile {
    public static void init() {
        regBlocks();
    }

    private static void regBlocks() {
        blood = registerBlock(new TileBlood().setBlockName("scp:blood"));
        locker = registerBlock(new TileLocker().setBlockName("scp:locker"));
    }
    public static Block registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().replace("tile.cpc:", ""));

        return block;
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass) {
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.cpc:", ""));

        return block;
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass, Object... constructorArgs) {
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.cpc:", ""), constructorArgs);

        return block;
    }

}
