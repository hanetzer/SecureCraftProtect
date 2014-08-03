package SCPCraft.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCP914RoughRecipes
{
	private static final SCP914RoughRecipes smeltingBase = new SCP914RoughRecipes();

	/** The list of smelting results. */
	private Map<Integer, ItemStack> smeltingList;

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final SCP914RoughRecipes smelting()
	{
		return smeltingBase;
	}

	private SCP914RoughRecipes()
	{
		smeltingList = new HashMap<Integer, ItemStack>();
		addSmelting(Item.ingotIron.itemID, new ItemStack(Item.goldNugget, 2));
		addSmelting(Block.cobblestone.blockID, new ItemStack(Item.flint));
		addSmelting(Item.book.itemID, new ItemStack(Item.seeds));
		addSmelting(mod_SCP.Locker.blockID, new ItemStack(mod_SCP.BloodBlock));
		addSmelting(Block.bookShelf.blockID, new ItemStack(Block.reed));
		addSmelting(Block.blockSteel.blockID, new ItemStack(Item.ingotIron));
		addSmelting(mod_SCP.SCP217.itemID, new ItemStack(Block.oreIron, 2));
		addSmelting(mod_SCP.Wrench.itemID, new ItemStack(Block.oreIron, 3));
		addSmelting(Block.blockSteel.blockID, new ItemStack(Block.oreIron));
		addSmelting(Block.reed.blockID, new ItemStack(Item.sugar, 2));
		addSmelting(Item.paper.itemID, new ItemStack(Item.gunpowder, 2));
		addSmelting(Item.map.itemID, new ItemStack(Item.wheat, 3));
		addSmelting(mod_SCP.SCP143Planks.blockID, new ItemStack(Block.planks, 2));
		addSmelting(mod_SCP.SCP420J.itemID, new ItemStack(Item.gunpowder, 3));
		addSmelting(Item.axeWood.itemID, new ItemStack(Item.seeds, 3));
		addSmelting(Item.swordWood.itemID, new ItemStack(Item.seeds, 2));
		addSmelting(Item.pickaxeWood.itemID, new ItemStack(Item.seeds, 3));
		addSmelting(Item.shovelWood.itemID, new ItemStack(Item.seeds, 1));
		addSmelting(Item.hoeWood.itemID, new ItemStack(Item.seeds, 2));
		addSmelting(Item.axeStone.itemID, new ItemStack(Block.cobblestone));
		addSmelting(Item.swordStone.itemID, new ItemStack(Block.cobblestone));
		addSmelting(Item.pickaxeStone.itemID, new ItemStack(Block.cobblestone));
		addSmelting(Item.shovelStone.itemID, new ItemStack(Block.cobblestone));
		addSmelting(Item.hoeStone.itemID, new ItemStack(Block.cobblestone));
		addSmelting(Item.axeGold.itemID, new ItemStack(Item.ingotIron));
		addSmelting(Item.swordGold.itemID, new ItemStack(Item.ingotIron));
		addSmelting(Item.pickaxeGold.itemID, new ItemStack(Item.ingotIron));
		addSmelting(Item.shovelGold.itemID, new ItemStack(Item.ingotIron));
		addSmelting(Item.hoeGold.itemID, new ItemStack(Item.ingotIron));
		addSmelting(Item.axeDiamond.itemID, new ItemStack(Item.coal, 2));
		addSmelting(Item.swordDiamond.itemID, new ItemStack(Item.coal, 2));
		addSmelting(Item.pickaxeDiamond.itemID, new ItemStack(Item.coal, 2));
		addSmelting(Item.shovelDiamond.itemID, new ItemStack(Item.coal, 2));
		addSmelting(Item.hoeDiamond.itemID, new ItemStack(Item.coal, 2));
		addSmelting(Item.axeSteel.itemID, new ItemStack(Block.stone, 3));
		addSmelting(Item.swordSteel.itemID, new ItemStack(Block.stone, 2));
		addSmelting(Item.pickaxeSteel.itemID, new ItemStack(Block.stone, 3));
		addSmelting(Item.shovelSteel.itemID, new ItemStack(Block.stone, 1));
		addSmelting(Item.hoeSteel.itemID, new ItemStack(Block.stone, 2));
		addSmelting(Item.diamond.itemID, new ItemStack(Item.coal));
		addSmelting(Block.obsidian.blockID, new ItemStack(Block.cobblestone, 2));
		addSmelting(Block.mycelium.blockID, new ItemStack(Block.dirt, 2));
		addSmelting(Block.netherrack.blockID, new ItemStack(Block.sandStone, 2));
		addSmelting(Block.netherBrick.blockID, new ItemStack(Block.stoneBrick, 2));
		addSmelting(Block.redstoneLampActive.blockID, new ItemStack(Item.lightStoneDust));
		addSmelting(Block.redstoneLampIdle.blockID, new ItemStack(Item.lightStoneDust));
		addSmelting(Block.vine.blockID, new ItemStack(Item.seeds));
		addSmelting(Item.lightStoneDust.itemID, new ItemStack(Item.gunpowder, 2));
		addSmelting(Block.bedrock.blockID, new ItemStack(Block.dirt, 8));
		addSmelting(Item.bow.itemID, new ItemStack(Item.stick));
		addSmelting(Block.bed.blockID, new ItemStack(Block.cloth));
		addSmelting(Item.arrow.itemID, new ItemStack(Item.flint));
		addSmelting(Block.stoneBrick.blockID, new ItemStack(Block.stone));
		addSmelting(Item.bed.itemID, new ItemStack(Block.cloth));
		addSmelting(Block.glowStone.blockID, new ItemStack(Item.lightStoneDust, 2));
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
