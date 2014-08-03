package SCPCraft.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCP914VeryFineRecipes
{
	private static final SCP914VeryFineRecipes smeltingBase = new SCP914VeryFineRecipes();

	/** The list of smelting results. */
	private Map<Integer, ItemStack> smeltingList;

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final SCP914VeryFineRecipes smelting()
	{
		return smeltingBase;
	}

	private SCP914VeryFineRecipes()
	{
		smeltingList = new HashMap<Integer, ItemStack>();
		addSmelting(Item.goldNugget.itemID, new ItemStack(Item.ingotGold));
		addSmelting(Block.blockSteel.blockID, new ItemStack(mod_SCP.Locker));
		addSmelting(mod_SCP.SCP500G.itemID, new ItemStack(mod_SCP.SCP500B));
		addSmelting(mod_SCP.L2Keycard.itemID, new ItemStack(Item.ingotGold));
		addSmelting(Block.oreIron.blockID, new ItemStack(Block.blockSteel));
		addSmelting(Block.glowStone.blockID, new ItemStack(Item.lightStoneDust, 6));
		addSmelting(mod_SCP.Item019.itemID, new ItemStack(Block.blockDiamond));
		addSmelting(Item.ingotGold.itemID, new ItemStack(Block.blockGold));
		addSmelting(Block.sand.blockID, new ItemStack(Block.glass, 3));
		addSmelting(Block.stone.blockID, new ItemStack(mod_SCP.Granite));
		addSmelting(Item.helmetLeather.itemID, new ItemStack(mod_SCP.GasMask));
		addSmelting(Item.plateSteel.itemID, new ItemStack(mod_SCP.SCP912Shirt));
		addSmelting(Item.pickaxeWood.itemID, new ItemStack(Item.pickaxeSteel));
		addSmelting(Item.wheat.itemID, new ItemStack(mod_SCP.SCP420J));
		addSmelting(Item.feather.itemID, new ItemStack(Item.egg));
		addSmelting(Item.bread.itemID, new ItemStack(Block.cake));
		addSmelting(Item.bucketWater.itemID, new ItemStack(Item.bucketLava));
		addSmelting(mod_SCP.Locker.blockID, new ItemStack(Block.anvil));
		addSmelting(Item.paper.itemID, new ItemStack(Item.map));
		addSmelting(Item.potion.itemID, new ItemStack(Item.expBottle));
		addSmelting(Item.silk.itemID, new ItemStack(Block.cloth));
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
