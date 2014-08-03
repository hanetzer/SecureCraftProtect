package SCPCraft.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCP294Recipes
{
	private static final SCP294Recipes smeltingBase = new SCP294Recipes();

	/** The list of smelting results. */
	private Map<Integer, ItemStack> smeltingList;

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final SCP294Recipes smelting()
	{
		return smeltingBase;
	}

	private SCP294Recipes()
	{
		smeltingList = new HashMap<Integer, ItemStack>();
		addSmelting(mod_SCP.BloodBlock.blockID, new ItemStack(mod_SCP.CupBlood));
		addSmelting(Block.mycelium.blockID, new ItemStack(mod_SCP.CupMycelium));
		addSmelting(Block.netherrack.blockID, new ItemStack(mod_SCP.CupNetherrack));
		addSmelting(Item.coal.itemID, new ItemStack(mod_SCP.CupCoal));
		addSmelting(Block.cactus.blockID, new ItemStack(mod_SCP.CupCactus));
		addSmelting(Item.feather.itemID, new ItemStack(mod_SCP.CupFeather));
		addSmelting(Block.blockGold.blockID, new ItemStack(mod_SCP.CupGold));
		addSmelting(Item.appleGold.itemID, new ItemStack(mod_SCP.CupAppleGold));
		addSmelting(Item.appleRed.itemID, new ItemStack(mod_SCP.CupApple));
		addSmelting(Block.obsidian.blockID, new ItemStack(mod_SCP.CupObsidian));
		addSmelting(Block.slowSand.blockID, new ItemStack(mod_SCP.CupSlowSand));
		addSmelting(Block.glowStone.blockID, new ItemStack(mod_SCP.CupGlowstone));
		addSmelting(Item.lightStoneDust.itemID, new ItemStack(mod_SCP.CupGlowstone));
		addSmelting(Block.glass.blockID, new ItemStack(mod_SCP.CupGlass));
		addSmelting(Block.thinGlass.blockID, new ItemStack(mod_SCP.CupGlass));
		addSmelting(Block.pumpkin.blockID, new ItemStack(mod_SCP.CupPumpkin));
		addSmelting(Block.pumpkinLantern.blockID, new ItemStack(mod_SCP.CupPumpkin));
		addSmelting(Item.spiderEye.itemID, new ItemStack(mod_SCP.CupSpiderEye));
		addSmelting(Item.sugar.itemID, new ItemStack(mod_SCP.CupSugar));
		addSmelting(Block.stone.blockID, new ItemStack(mod_SCP.CupStone));
		addSmelting(Item.clay.itemID, new ItemStack(mod_SCP.CupClay));
		addSmelting(Block.reed.blockID, new ItemStack(mod_SCP.CupSugar));
		addSmelting(Block.blockClay.blockID, new ItemStack(mod_SCP.CupClay));
		addSmelting(Block.brick.blockID, new ItemStack(mod_SCP.CupClay));
		addSmelting(Item.brick.itemID, new ItemStack(mod_SCP.CupClay));
		addSmelting(Block.stoneBrick.blockID, new ItemStack(mod_SCP.CupStone));
		addSmelting(Item.rottenFlesh.itemID, new ItemStack(mod_SCP.CupRottenFlesh));
		addSmelting(Block.oreDiamond.blockID, new ItemStack(mod_SCP.CupDiamond));
		addSmelting(Item.diamond.itemID, new ItemStack(mod_SCP.CupDiamond));
		addSmelting(Block.oreIron.blockID, new ItemStack(mod_SCP.CupIron));
		addSmelting(Item.ingotIron.itemID, new ItemStack(mod_SCP.CupIron));
		addSmelting(mod_SCP.Locker.blockID, new ItemStack(mod_SCP.CupIron));
		addSmelting(Item.redstone.itemID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(Item.redstoneRepeater.itemID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(Block.torchRedstoneActive.blockID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(Block.torchRedstoneIdle.blockID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(Block.redstoneRepeaterActive.blockID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(Block.redstoneRepeaterIdle.blockID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(Block.oreRedstone.blockID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(mod_SCP.ElectricWool.blockID, new ItemStack(mod_SCP.CupRedstone));
		addSmelting(mod_SCP.GrateBlock.blockID, new ItemStack(mod_SCP.CupIron));
		addSmelting(mod_SCP.Machinery.blockID, new ItemStack(mod_SCP.CupCoal));
		addSmelting(mod_SCP.Granite.blockID, new ItemStack(mod_SCP.CupObsidian));
		addSmelting(Item.silk.itemID, new ItemStack(mod_SCP.CupCobweb));
		addSmelting(Block.web.blockID, new ItemStack(mod_SCP.CupCobweb));
		addSmelting(mod_SCP.DocumentTable.blockID, new ItemStack(mod_SCP.CupIron));
		addSmelting(Item.bone.itemID, new ItemStack(mod_SCP.CupBone));
		addSmelting(Item.slimeBall.itemID, new ItemStack(mod_SCP.CupSlimeBall));
		addSmelting(mod_SCP.Bone.blockID, new ItemStack(mod_SCP.CupBone));
		addSmelting(mod_SCP.Flesh.blockID, new ItemStack(mod_SCP.CupRottenFlesh));
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
