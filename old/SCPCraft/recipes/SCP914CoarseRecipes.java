package SCPCraft.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCP914CoarseRecipes
{
	private static final SCP914CoarseRecipes smeltingBase = new SCP914CoarseRecipes();

	/** The list of smelting results. */
	private Map<Integer, ItemStack> smeltingList;

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final SCP914CoarseRecipes smelting()
	{
		return smeltingBase;
	}

	private SCP914CoarseRecipes()
	{
		smeltingList = new HashMap<Integer, ItemStack>();
		addSmelting(Block.sandStone.blockID, new ItemStack(Block.sand));
		addSmelting(Block.cobblestone.blockID, new ItemStack(Block.gravel));
		addSmelting(Block.gravel.blockID, new ItemStack(Item.flint));
		addSmelting(Block.blockSteel.blockID, new ItemStack(Item.ingotIron));
		addSmelting(Item.ingotGold.itemID, new ItemStack(Block.oreGold));
		addSmelting(Item.book.itemID, new ItemStack(Item.paper));
		addSmelting(Item.paper.itemID, new ItemStack(Item.reed));
		addSmelting(Block.blockGold.blockID, new ItemStack(Item.ingotGold));
		addSmelting(Block.blockSnow.blockID, new ItemStack(Item.snowball));
		addSmelting(Item.ingotIron.itemID, new ItemStack(Block.oreIron));
		addSmelting(Item.diamond.itemID, new ItemStack(Block.oreDiamond));
		addSmelting(Block.blockDiamond.blockID, new ItemStack(Item.diamond));
		addSmelting(Block.bookShelf.blockID, new ItemStack(Item.book));
		addSmelting(Block.grass.blockID, new ItemStack(Item.seeds));
		addSmelting(Item.axeSteel.itemID, new ItemStack(Item.ingotIron, 3));
		addSmelting(Item.swordSteel.itemID, new ItemStack(Item.ingotIron, 2));
		addSmelting(Item.pickaxeSteel.itemID, new ItemStack(Item.ingotIron, 3));
		addSmelting(Item.shovelSteel.itemID, new ItemStack(Item.ingotIron, 1));
		addSmelting(Item.hoeSteel.itemID, new ItemStack(Item.ingotIron, 2));
		addSmelting(mod_SCP.SCP427.itemID, new ItemStack(mod_SCP.SCP500G));
		addSmelting(Item.axeStone.itemID, new ItemStack(Block.cobblestone, 3));
		addSmelting(Item.swordStone.itemID, new ItemStack(Block.cobblestone, 2));
		addSmelting(Item.pickaxeStone.itemID, new ItemStack(Block.cobblestone, 3));
		addSmelting(Item.shovelStone.itemID, new ItemStack(Block.cobblestone, 1));
		addSmelting(Item.hoeStone.itemID, new ItemStack(Block.cobblestone, 2));
		addSmelting(Item.axeGold.itemID, new ItemStack(Item.ingotGold, 3));
		addSmelting(Item.swordGold.itemID, new ItemStack(Item.ingotGold, 2));
		addSmelting(Item.pickaxeGold.itemID, new ItemStack(Item.ingotGold, 3));
		addSmelting(Item.shovelGold.itemID, new ItemStack(Item.ingotGold, 1));
		addSmelting(Item.hoeGold.itemID, new ItemStack(Item.ingotGold, 2));
		addSmelting(Item.axeDiamond.itemID, new ItemStack(Item.diamond, 3));
		addSmelting(Item.swordDiamond.itemID, new ItemStack(Item.diamond, 2));
		addSmelting(Item.pickaxeDiamond.itemID, new ItemStack(Item.diamond, 3));
		addSmelting(Item.shovelDiamond.itemID, new ItemStack(Item.diamond, 1));
		addSmelting(Item.hoeDiamond.itemID, new ItemStack(Item.diamond, 2));
		addSmelting(Item.redstoneRepeater.itemID, new ItemStack(Block.torchRedstoneActive));
		addSmelting(mod_SCP.SCP217.itemID, new ItemStack(Item.ingotIron, 2));
		addSmelting(mod_SCP.Wrench.itemID, new ItemStack(Item.ingotIron, 3));
		addSmelting(mod_SCP.Locker.blockID, new ItemStack(Block.blockSteel));
		addSmelting(Item.map.itemID, new ItemStack(Item.paper, 3));
		addSmelting(mod_SCP.SCP143Planks.blockID, new ItemStack(Block.wood));
		addSmelting(mod_SCP.SCP420J.itemID, new ItemStack(Item.wheat, 2));
		addSmelting(Item.axeWood.itemID, new ItemStack(Block.planks, 3));
		addSmelting(Item.swordWood.itemID, new ItemStack(Block.planks, 2));
		addSmelting(Item.pickaxeWood.itemID, new ItemStack(Block.planks, 3));
		addSmelting(Item.shovelWood.itemID, new ItemStack(Block.planks, 1));
		addSmelting(Item.hoeWood.itemID, new ItemStack(Block.planks, 2));
		addSmelting(Block.grass.blockID, new ItemStack(Block.tallGrass));
		addSmelting(Block.mycelium.blockID, new ItemStack(Block.mushroomBrown));
		addSmelting(Block.netherrack.blockID, new ItemStack(Block.obsidian));
		addSmelting(Block.netherBrick.blockID, new ItemStack(Block.netherrack, 4));
		addSmelting(Block.vine.blockID, new ItemStack(Block.leaves, 2));
		addSmelting(Item.lightStoneDust.itemID, new ItemStack(Item.sugar));
		addSmelting(Block.bed.blockID, new ItemStack(Block.planks, 2));
		addSmelting(Block.bedrock.blockID, new ItemStack(Block.stone, 6));
		addSmelting(Item.bow.itemID, new ItemStack(Item.silk, 2));
		addSmelting(Item.arrow.itemID, new ItemStack(Item.flint, 2));
		addSmelting(Item.bed.itemID, new ItemStack(Block.planks, 2));
		addSmelting(mod_SCP.CupEmpty.itemID, new ItemStack(Item.paper, 3));
		addSmelting(Item.eyeOfEnder.itemID, new ItemStack(Item.enderPearl, 1));
		addSmelting(Block.sand.blockID, new ItemStack(Block.slowSand, 1));
		addSmelting(Block.stoneBrick.blockID, new ItemStack(Block.cobblestone));
		addSmelting(mod_SCP.SCP079.blockID, new ItemStack(mod_SCP.Circuit, 5));
	}

	/**
	 * Adds a smelting recipe.
	 */
	 public void addSmelting(int par1, ItemStack par2ItemStack)
	{
		smeltingList.put(Integer.valueOf(par1), par2ItemStack);
	}

	/**
	 * Returns the smelting result of an item.
	 */
	 public ItemStack getSmeltingResult(int par1)
	{
		return (ItemStack)smeltingList.get(Integer.valueOf(par1));
	}

	 public Map<Integer, ItemStack> getSmeltingList()
	 {
		 return smeltingList;
	 }
}
