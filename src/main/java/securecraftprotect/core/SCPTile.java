package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import securecraftprotect.common.tile.*;
import securecraftprotect.common.tileentity.TileEntitySCP0015;

import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static securecraftprotect.init.SCPTiles.*;

public class SCPTile {
    public static void init() {
        registerTiles();
        registerTileEntities();
        registerCraft();
    }

    private static void registerTiles() {
        blood = registerTile(new TileBlood().setBlockName("scp:blood"));
        reinforced_steel = registerTile(new TileReinforcedSteel().setBlockName("scp:reinforced_steel"));
        document_crafter = registerTile(new TileDocumentCrafter().setBlockName("scp:document_crafter"));
        scp_0015 = registerTile(new TileSCP0015().setBlockName("scp:0015"));
		machinery = registerTile(new TileMachine().setBlockName("scp:machine"));
    }

    private static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntitySCP0015.class, "scp:0015");
    }

    private static void registerCraft() {
        GameRegistry.addShapedRecipe(new ItemStack(reinforced_steel, 1),
                " A ", "ABA", " A ",
                'A', new ItemStack(iron_ingot), 'B', new ItemStack(iron_block));
        GameRegistry.addShapedRecipe(new ItemStack(document_crafter, 1),
                " A ", "ABA", " A ",
                'A', new ItemStack(reinforced_steel), 'B', new ItemStack(crafting_table));
    }

    public static Block registerTile(Block tile) {
        GameRegistry.registerBlock(tile, tile.getUnlocalizedName().replace("tile.scp:", ""));
        return tile;
    }

    public static Block registerTile(Block tile, Class<? extends ItemBlock> itemTileClass) {
        GameRegistry.registerBlock(tile, itemTileClass, tile.getUnlocalizedName().replace("tile.scp:", ""));
        return tile;
    }

    public static Block registerTile(Block tile, Class<? extends ItemBlock> itemTileClass, Object... args) {
        GameRegistry.registerBlock(tile, itemTileClass, tile.getUnlocalizedName().replace("tile.scp:", ""), args);
        return tile;
    }
}
