package SCPCraft.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCP914FineRecipes
{
	private static final SCP914FineRecipes smeltingBase = new SCP914FineRecipes();

	/** The list of smelting results. */
	private Map<Integer, ItemStack> smeltingList;

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final SCP914FineRecipes smelting()
	{
		return smeltingBase;
	}

	private SCP914FineRecipes()
	{
		smeltingList = new HashMap<Integer, ItemStack>();
		addSmelting(Block.sand.blockID, new ItemStack(Block.sandStone));
		addSmelting(Block.sandStone.blockID, new ItemStack(Block.sandStone, 1, 2));
		addSmelting(Item.flint.itemID, new ItemStack(Item.flintAndSteel));
		addSmelting(mod_SCP.SCP500G.itemID, new ItemStack(mod_SCP.SCP427));
		addSmelting(mod_SCP.L2Keycard.itemID, new ItemStack(mod_SCP.L3Keycard));
		addSmelting(mod_SCP.Locker.blockID, new ItemStack(Item.ingotIron, 10));
		addSmelting(mod_SCP.Wrench.itemID, new ItemStack(mod_SCP.GodlyWrench));
		addSmelting(Item.pocketSundial.itemID, new ItemStack(Item.ingotGold, 12));
		addSmelting(Item.compass.itemID, new ItemStack(Item.pocketSundial));
		addSmelting(Block.glowStone.blockID, new ItemStack(Block.redstoneLampIdle));
		addSmelting(mod_SCP.Pearl914.itemID, new ItemStack(mod_SCP.Pearl261));
		addSmelting(Block.netherrack.blockID, new ItemStack(Block.netherBrick, 2));
		addSmelting(Block.fence.blockID, new ItemStack(Block.netherFence, 2));
		addSmelting(Item.seeds.itemID, new ItemStack(Item.netherStalkSeeds));
		addSmelting(Item.slimeBall.itemID, new ItemStack(Item.magmaCream));
		addSmelting(mod_SCP.BloodBlock.blockID, new ItemStack(Block.netherrack));
		addSmelting(Item.blazeRod.itemID, new ItemStack(Item.blazePowder, 5));
		addSmelting(Item.bone.itemID, new ItemStack(Item.dyePowder, 5, 15));
		addSmelting(Item.netherStar.itemID, new ItemStack(Block.beacon));
		addSmelting(Block.bedrock.blockID, new ItemStack(Item.diamond, 2));
		addSmelting(Item.arrow.itemID, new ItemStack(Item.flint, 2));
		addSmelting(Block.bed.blockID, new ItemStack(Block.cloth, 2, 14));
		addSmelting(Item.bed.itemID, new ItemStack(Block.cloth, 2, 14));
		addSmelting(Item.bow.itemID, new ItemStack(Item.silk, 5));
		addSmelting(Item.brick.itemID, new ItemStack(Item.flowerPot));
		addSmelting(Item.glassBottle.itemID, new ItemStack(Item.potion, 1, 0));
		addSmelting(Item.doorWood.itemID, new ItemStack(Item.doorSteel));
		addSmelting(Block.plantRed.blockID, new ItemStack(Item.dyePowder, 4, 1));
		addSmelting(Block.plantYellow.blockID, new ItemStack(Item.dyePowder, 4, 11));
		addSmelting(Item.egg.itemID, new ItemStack(Item.monsterPlacer));
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
