package securecraftprotect.core;

import static net.minecraft.block.material.Material.rock;
import static net.minecraft.block.material.Material.wood;
import static net.minecraft.init.Blocks.crafting_table;
import static net.minecraft.init.Blocks.iron_block;
import static net.minecraft.init.Blocks.planks;
import static net.minecraft.init.Items.iron_ingot;
import static securecraftprotect.init.SCPTiles.acid;
import static securecraftprotect.init.SCPTiles.acidFluid;
import static securecraftprotect.init.SCPTiles.blood;
import static securecraftprotect.init.SCPTiles.bone;
import static securecraftprotect.init.SCPTiles.chair_stone;
import static securecraftprotect.init.SCPTiles.chair_wood;
import static securecraftprotect.init.SCPTiles.desk_stone;
import static securecraftprotect.init.SCPTiles.desk_wood;
import static securecraftprotect.init.SCPTiles.document_crafter;
import static securecraftprotect.init.SCPTiles.event_block;
import static securecraftprotect.init.SCPTiles.flesh;
import static securecraftprotect.init.SCPTiles.light_bulb;
import static securecraftprotect.init.SCPTiles.machinery;
import static securecraftprotect.init.SCPTiles.reinforced_steel;
import static securecraftprotect.init.SCPTiles.scp_0015;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import securecraftprotect.common.item.ItemTileFurnature;
import securecraftprotect.common.tile.TileAcid;
import securecraftprotect.common.tile.TileBlood;
import securecraftprotect.common.tile.TileBone;
import securecraftprotect.common.tile.TileChair;
import securecraftprotect.common.tile.TileDesk;
import securecraftprotect.common.tile.TileDocCrafter;
import securecraftprotect.common.tile.TileEventBlock;
import securecraftprotect.common.tile.TileFlesh;
import securecraftprotect.common.tile.TileLightBulb;
import securecraftprotect.common.tile.TileMachine;
import securecraftprotect.common.tile.TileSCP0015;
import securecraftprotect.common.tile.TileSteel;
import securecraftprotect.common.tileentity.TileEntityChair;
import securecraftprotect.common.tileentity.TileEntityEventBlock;
import securecraftprotect.common.tileentity.TileEntityFlesh;
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
        blood = registerTile(new TileBlood().setUnlocalizedName("scp.blood"), "blood");
        reinforced_steel = registerTile(new TileSteel().setUnlocalizedName("scp.reinforced_steel"), "steel");
        document_crafter = registerTile(new TileDocCrafter().setUnlocalizedName("scp.doc_crafter"), "doc_crafter");
        scp_0015 = registerTile(new TileSCP0015().setUnlocalizedName("scp.0015"), "0015");
        machinery = registerTile(new TileMachine().setUnlocalizedName("scp.machine"), "machine");
        
        acidFluid = new Fluid("acid").setLuminosity(15).setDensity(3000).setTemperature(2000).setViscosity(6000);
        if (!FluidRegistry.registerFluid(acidFluid))
        {
            acidFluid = FluidRegistry.getFluid("acid");
        }
        acid = registerTile(new TileAcid(acidFluid).setUnlocalizedName("scp.acid"), "acid");
        bone = registerTile(new TileBone().setUnlocalizedName("scp.bone"), "bone");
        flesh = registerTile(new TileFlesh().setUnlocalizedName("scp.flesh"), "flesh");
        desk_wood = registerTile(new TileDesk(wood, 0).setUnlocalizedName("scp.desk_wood"), ItemTileFurnature.class, "desk_wood");
        desk_stone = registerTile(new TileDesk(rock, 1).setUnlocalizedName("scp.desk_stone"), ItemTileFurnature.class, "desk_stone");
        chair_wood = registerTile(new TileChair(wood, 0).setUnlocalizedName("scp.chair_wood"), ItemTileFurnature.class, "chair_wood");
        chair_stone = registerTile(new TileChair(rock, 1).setUnlocalizedName("scp.chair_stone"), ItemTileFurnature.class, "chair_stone");
        light_bulb = registerTile(new TileLightBulb().setUnlocalizedName("scp.light_bulb"), "lighBulb");
        event_block = registerTile(new TileEventBlock().setBlockUnbreakable().setUnlocalizedName("scp.event_Block"), "eventBlock");
    }
    
    private static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntitySCP0015.class, "scp.0015");
        GameRegistry.registerTileEntity(TileEntityFlesh.class, "scp.flesh");
        GameRegistry.registerTileEntity(TileEntityChair.class, "scp.chair");
        GameRegistry.registerTileEntity(TileEntityEventBlock.class, "scp.eventBlock");
    }
    
    private static void registerCraft()
    {
        GameRegistry.addShapedRecipe(new ItemStack(reinforced_steel, 1), " A ", "ABA", " A ", 'A', new ItemStack(iron_ingot), 'B', new ItemStack(iron_block));
        GameRegistry.addShapedRecipe(new ItemStack(document_crafter, 1), " A ", "ABA", " A ", 'A', new ItemStack(reinforced_steel), 'B', new ItemStack(crafting_table));
        for (int j = 0; j < ItemTileFurnature.types[0].length; ++j)
        {
            GameRegistry.addShapedRecipe(new ItemStack(chair_wood, 1, j), "A  ", "AAA", "A A", 'A', new ItemStack(planks, 1, j));
            GameRegistry.addShapedRecipe(new ItemStack(chair_wood, 1, j), "  A", "AAA", "A A", 'A', new ItemStack(planks, 1, j));
            GameRegistry.addShapedRecipe(new ItemStack(desk_wood, 1, j), "AAA", "A A", 'A', new ItemStack(planks, 1, j));
        }
        
    }
    
    public static Block registerTile(Block tile, String name)
    {
        GameRegistry.registerBlock(tile, name);
        return tile;
    }
    
    public static Block registerTile(Block tile, Class<? extends ItemBlock> item, String name)
    {
        GameRegistry.registerBlock(tile, item, name);
        return tile;
    }
    
    public static Block registerTile(Block tile, Class<? extends ItemBlock> item, Object... args)
    {
        String name = tile.getUnlocalizedName().replace("tile.scp.", "");
        GameRegistry.registerBlock(tile, item, name, args);
        return tile;
    }
}
