package SCPCraft.recipes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SCP261Recipes
{
	Random rand = new Random();
	ItemStack itemStack;
	private static final SCP261Recipes smeltingBase = new SCP261Recipes();

	/** The list of smelting results. */
	private Map smeltingList;

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final SCP261Recipes smelting()
	{
		return smeltingBase;
	}

	private SCP261Recipes()
	{
		smeltingList = new HashMap();
		addSmelting(Item.ingotIron.itemID, new ItemStack(Item.pickaxeSteel));

	}

	/**
	 * Adds a smelting recipe.
	 */
	public void addSmelting(int par1, ItemStack par2ItemStack)
	{
		par1 = Item.ingotIron.itemID;
		smeltingList.put(Integer.valueOf(par1), par2ItemStack);
	}

	/**
	 * Returns the smelting result of an item.
	 */
	public ItemStack getSmeltingResult(int par1)
	{
		return (ItemStack)smeltingList.get(Integer.valueOf(par1));
	}

	public Map getSmeltingList()
	{
		return smeltingList;
	}
}
