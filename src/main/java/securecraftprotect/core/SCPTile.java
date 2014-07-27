package securecraftprotect.core;

import static net.minecraft.init.Blocks.crafting_table;
import static net.minecraft.init.Blocks.iron_block;
import static net.minecraft.init.Items.iron_ingot;
import static securecraftprotect.init.SCPTiles.acid;
import static securecraftprotect.init.SCPTiles.acidFluid;
import static securecraftprotect.init.SCPTiles.blood;
import static securecraftprotect.init.SCPTiles.document_crafter;
import static securecraftprotect.init.SCPTiles.machinery;
import static securecraftprotect.init.SCPTiles.reinforced_steel;
import static securecraftprotect.init.SCPTiles.scp_0015;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import securecraftprotect.common.tile.BlockAcid;
import securecraftprotect.common.tile.TileBlood;
import securecraftprotect.common.tile.TileDocumentCrafter;
import securecraftprotect.common.tile.TileMachine;
import securecraftprotect.common.tile.TileReinforcedSteel;
import securecraftprotect.common.tile.TileSCP0015;
import securecraftprotect.common.tileentity.TileEntitySCP0015;
import cpw.mods.fml.common.registry.GameRegistry;

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
        if (!FluidRegistry.registerFluid(acidFluid)) acidFluid = FluidRegistry.getFluid("acid");
        acid = new BlockAcid(acidFluid, Material.water);
        GameRegistry.registerBlock(acid, "acidLiquid");
    }
    
    private static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntitySCP0015.class, "scp:0015");
    }
    
    private static void registerCraft()
    {
        GameRegistry.addShapedRecipe(new ItemStack(reinforced_steel, 1), " A ", "ABA", " A ", 'A', new ItemStack(iron_ingot), 'B', new ItemStack(iron_block));
        GameRegistry.addShapedRecipe(new ItemStack(document_crafter, 1), " A ", "ABA", " A ", 'A', new ItemStack(reinforced_steel), 'B', new ItemStack(crafting_table));
    }
    
    public static Block registerTile(Block tile)
    {
        GameRegistry.registerBlock(tile, tile.getUnlocalizedName().replace("tile.scp:", ""));
        return tile;
    }
    
    public static Block registerTile(Block tile, Class<? extends ItemBlock> itemTileClass)
    {
        GameRegistry.registerBlock(tile, itemTileClass, tile.getUnlocalizedName().replace("tile.scp:", ""));
        return tile;
    }
    
    public static Block registerTile(Block tile, Class<? extends ItemBlock> itemTileClass, Object... args)
    {
        GameRegistry.registerBlock(tile, itemTileClass, tile.getUnlocalizedName().replace("tile.scp:", ""), args);
        return tile;
    }
}
