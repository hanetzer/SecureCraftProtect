package SCPCraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import SCPCraft.SCPToolMaterial;
import SCPCraft.mod_SCP;

public class SCPItem143Axe extends SCPItemTool
{
	private static Block blocksEffectiveAgainst[];

	public SCPItem143Axe(int i, SCPToolMaterial enumtoolmaterial)
	{
		super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
		this.setCreativeTab(mod_SCP.tabItemSCP);
		setMaxDamage(1000);
	}

	public float getStrVsBlock(ItemStack itemstack, Block block)
	{
		if(block != null && block.blockMaterial == Material.iron)
		{
			return efficiencyOnProperMaterial;
		} 
		else
		{
			return super.getStrVsBlock(itemstack, block);
		}
	}

	static
	{
		blocksEffectiveAgainst = (new Block[] {
				Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stairsWoodBirch, Block.stairsWoodJungle, Block.stairsWoodSpruce, Block.stairsWoodOak, Block.pumpkin, Block.pumpkinLantern, mod_SCP.SCP143Log
		});
	}
	
	public String getTextureFile()
	{
		return "/SCPCraft/textures/SCPItems.png";
	}
}