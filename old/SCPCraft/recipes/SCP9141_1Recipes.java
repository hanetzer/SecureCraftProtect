package SCPCraft.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCP9141_1Recipes
{
	private static final SCP9141_1Recipes smeltingBase = new SCP9141_1Recipes();

	/** The list of smelting results. */
	private Map<Integer, ItemStack> smeltingList;

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final SCP9141_1Recipes smelting()
	{
		return smeltingBase;
	}

	private SCP9141_1Recipes()
	{
		smeltingList = new HashMap<Integer, ItemStack>();
		addSmelting(Block.cobblestone.blockID, new ItemStack(Block.stone));
		addSmelting(Block.dirt.blockID, new ItemStack(Block.grass));
		addSmelting(mod_SCP.L1Keycard.itemID, new ItemStack(mod_SCP.L2Keycard));
		addSmelting(Block.oreIron.blockID, new ItemStack(Item.ingotIron));
		addSmelting(Block.torchRedstoneActive.blockID, new ItemStack(Block.torchWood));
		addSmelting(Item.coal.itemID, new ItemStack(Item.coal, 1, 1));
		addSmelting(Item.potion.itemID, new ItemStack(Item.potion));
		addSmelting(Item.bucketWater.itemID, new ItemStack(Block.ice, 3));
		addSmelting(Item.dyePowder.itemID, new ItemStack(Item.dyePowder));
		addSmelting(Item.monsterPlacer.itemID, new ItemStack(Item.monsterPlacer));
	
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
