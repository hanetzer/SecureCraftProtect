package SCPCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import SCPCraft.mod_SCP;

public class SCPItemTothBrush extends ItemTool
{
	/** an array of the blocks this pickaxe is effective against */
	private static Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron,
		Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.obsidian,
		Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered,
		Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium, Block.planks, Block.bookShelf, Block.wood,
		Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern,
		mod_SCP.BloodBlock, mod_SCP.SCP409, mod_SCP.CorrodedIron, mod_SCP.Granite, Block.bedrock, mod_SCP.SCPspawner, mod_SCP.KeycardSlot, mod_SCP.KeycardSlotLv2, mod_SCP.KeycardSlotLv3,
		mod_SCP.KeycardSlotOmni, mod_SCP.SmokeBlock, Block.endPortalFrame, Block.mobSpawner, mod_SCP.SCP019};

	public SCPItemTothBrush(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(mod_SCP.tabSCP);
		setMaxDamage(-99);
	}
	
    public int getItemEnchantability()
    {
        return 20;
    }

	public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
	{
		return true;
	}

	public boolean canHarvestBlock(Block par1Block)
	{
		return true;
	}

	public int getDamageVsEntity(Entity par1Entity)
	{
		return 4;
	}

	/**
	 * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
	 * sword
	 */
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return 100F;
	}
	
	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
}
