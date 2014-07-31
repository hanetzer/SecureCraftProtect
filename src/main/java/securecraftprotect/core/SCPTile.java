package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import securecraftprotect.common.item.ItemTileFurnature;
import securecraftprotect.common.tile.*;
import securecraftprotect.common.tileentity.TileEntityChair;
import securecraftprotect.common.tileentity.TileEntityFlesh;
import securecraftprotect.common.tileentity.TileEntitySCP0015;

import static net.minecraft.block.material.Material.rock;
import static net.minecraft.block.material.Material.wood;
import static net.minecraft.init.Blocks.crafting_table;
import static net.minecraft.init.Blocks.iron_block;
import static net.minecraft.init.Blocks.planks;
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
        blood = registerTile(
				new TileBlood().setBlockName("scp.blood"), "blood");
        reinforced_steel = registerTile(
				new TileSteel().setBlockName("scp.reinforced_steel"), "steel");
        document_crafter = registerTile(
				new TileDocCrafter().setBlockName("scp.doc_crafter"), "doc_crafter");
        scp_0015 = registerTile(
				new TileSCP0015().setBlockName("scp.0015"), "0015");
        machinery = registerTile(
				new TileMachine().setBlockName("scp.machine"), "machine");
        
        acidFluid = new Fluid("acid").setLuminosity(15).setDensity(3000).setTemperature(2000).setViscosity(6000);
        if (!FluidRegistry.registerFluid(acidFluid)) {
			acidFluid = FluidRegistry.getFluid("acid");
		}
        acid = registerTile(
				new TileAcid(acidFluid).setBlockName("scp.acid"), "acid");
		bone = registerTile(new TileBone().setBlockName("scp.bone"), "bone");
		flesh = registerTile(new TileFlesh().setBlockName("scp.flesh"), "flesh");
		desk_wood = registerTile(
				new TileDesk(wood, 0).setBlockName("scp.desk_wood"),
				ItemTileFurnature.class, "desk_wood");
		desk_stone = registerTile(new TileDesk(rock, 1).setBlockName("scp.desk_stone"),
				ItemTileFurnature.class, "desk_stone");
		chair_wood = registerTile(new TileChair(wood, 0).setBlockName("scp.chair_wood"),
				ItemTileFurnature.class, "chair_wood");
		chair_stone = registerTile(new TileChair(rock, 1).setBlockName("scp.chair_stone"),
				ItemTileFurnature.class, "chair_stone");
    }
    
    private static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntitySCP0015.class, "scp.0015");
		GameRegistry.registerTileEntity(TileEntityFlesh.class, "scp.flesh");
		GameRegistry.registerTileEntity(TileEntityChair.class, "scp.chair");
    }
    
    private static void registerCraft()
    {
        GameRegistry.addShapedRecipe(new ItemStack(reinforced_steel, 1),
				" A ", "ABA", " A ",
				'A', new ItemStack(iron_ingot), 'B', new ItemStack(iron_block));
        GameRegistry.addShapedRecipe(new ItemStack(document_crafter, 1),
				" A ", "ABA", " A ",
				'A', new ItemStack(reinforced_steel), 'B', new ItemStack(crafting_table));
		for (int j=0; j < ItemTileFurnature.types[0].length; ++j) {
			GameRegistry.addShapedRecipe(new ItemStack(chair_wood, 1, j),
					"A  ", "AAA", "A A",
					'A', new ItemStack(planks, 1, j));
			GameRegistry.addShapedRecipe(new ItemStack(chair_wood, 1, j),
					"  A", "AAA", "A A",
					'A', new ItemStack(planks, 1, j));
			GameRegistry.addShapedRecipe(new ItemStack(desk_wood, 1, j),
					"AAA", "A A",
					'A', new ItemStack(planks, 1, j));
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
