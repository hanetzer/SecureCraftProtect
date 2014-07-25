package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import securecraftprotect.common.tile.TileBlood;
import securecraftprotect.common.tile.TileDocumentCrafter;
import securecraftprotect.common.tile.TileReinforcedSteel;
import securecraftprotect.common.tile.TileSCP0015;
import securecraftprotect.common.tileentity.TileEntitySCP0015;

import static securecraftprotect.init.SCPTiles.*;

public class SCPTile {
    public static void init() {
        registerTiles();
        registerTileEntities();
    }

    private static void registerTiles() {
        blood = registerTile(new TileBlood().setBlockName("scp:blood"));
        reinforced_steel = registerTile(new TileReinforcedSteel().setBlockName("scp:reinforced_steel"));
        document_crafter = registerTile(new TileDocumentCrafter().setBlockName("scp:document_crafter"));
        scp_0015 = registerTile(new TileSCP0015().setBlockName("scp:0015"));
    }

    private static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntitySCP0015.class, "scp:0015");
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
