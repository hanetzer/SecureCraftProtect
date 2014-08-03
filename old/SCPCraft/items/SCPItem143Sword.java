package SCPCraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import SCPCraft.SCPToolMaterial;
import SCPCraft.mod_SCP;

public class SCPItem143Sword extends SCPItemTool
{

	private static Block blocksEffectiveAgainst[];

	public SCPItem143Sword(int i, SCPToolMaterial enumtoolmaterial)
	{
		super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
		this.setCreativeTab(mod_SCP.tabItemSCP);
		setMaxDamage(1000);
	}
	
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }
	
	public float getStrVsBlock(ItemStack itemstack, Block block)
	{
		if(block != null && block.blockMaterial == Material.wood)
		{
			return efficiencyOnProperMaterial;
		} else
		{
			return super.getStrVsBlock(itemstack, block);
		}
	}

	static
	{
		blocksEffectiveAgainst = (new Block[] 
				{
				Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stairsWoodBirch,
				Block.pumpkin, Block.pumpkinLantern, Block.stairsWoodSpruce,
				Block.stairsWoodJungle, Block.stairsWoodBirch
				});
	}
	
	public String getTextureFile()
	{
		return "/SCPCraft/textures/SCPItems.png";
	}
}