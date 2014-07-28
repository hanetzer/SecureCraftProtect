package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import securecraftprotect.common.tile.*;
import securecraftprotect.common.tileentity.TileEntitySCP0015;

import static net.minecraft.init.Blocks.crafting_table;
import static net.minecraft.init.Blocks.iron_block;
import static net.minecraft.init.Items.iron_ingot;
import static securecraftprotect.init.SCPTiles.*;

public class SCPTile
{
    public static void init()
    {
        registerTiles();
        registerTileEntities();
        registerCraft();
    }
    
    private static void registerTiles()
    {
        blood = registerTile(new TileBlood().setBlockName("scp:blood"));
        reinforced_steel = registerTile(new TileReinforcedSteel().setBlockName("scp:reinforced_steel"));
        document_crafter = registerTile(new TileDocumentCrafter().setBlockName("scp:document_crafter"));
        scp_0015 = registerTile(new TileSCP0015().setBlockName("scp:0015"));
        machinery = registerTile(new TileMachine().setBlockName("scp:machine"));
        
        acidFluid = new Fluid("acid").setLuminosity(15).setDensity(3000).setTemperature(2000).setViscosity(6000);
        if (!FluidRegistry.registerFluid(acidFluid)) {
			acidFluid = FluidRegistry.getFluid("acid");
		}
        acid = registerTile(new TileAcid(acidFluid).setBlockName("scp:acid"));
    }
    
    private static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntitySCP0015.class, "scp:0015");
    }
    
    private static void registerCraft()
    {
        GameRegistry.addShapedRecipe(new ItemStack(reinforced_steel, 1),
				" A ", "ABA", " A ",
				'A', new ItemStack(iron_ingot), 'B', new ItemStack(iron_block));
        GameRegistry.addShapedRecipe(new ItemStack(document_crafter, 1),
				" A ", "ABA", " A ",
				'A', new ItemStack(reinforced_steel), 'B', new ItemStack(crafting_table));
    }
    
    public static Block registerTile(Block tile)
    {
		String name = tile.getUnlocalizedName().replace("tile.scp:", "");
        GameRegistry.registerBlock(tile, name);
        return tile;
    }
    
    public static Block registerTile(Block tile, Class<? extends ItemBlock> item)
    {
		String name = tile.getUnlocalizedName().replace("tile.scp:", "");
        GameRegistry.registerBlock(tile, item, name);
        return tile;
    }
    
    public static Block registerTile(Block tile, Class<? extends ItemBlock> item, Object... args)
    {
		String name = tile.getUnlocalizedName().replace("tile.scp:", "");
        GameRegistry.registerBlock(tile, item, name, args);
        return tile;
    }
}
