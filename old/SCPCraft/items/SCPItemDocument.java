package SCPCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItemDocument extends Item
{
	int classification;
	public SCPItemDocument(int i, int clas)
	{
		super(i);
		this.classification = clas;
		maxStackSize = 1;
		setMaxDamage(1);
        this.setCreativeTab(mod_SCP.tabSCP);
	}
	
	public SCPItemDocument(int i)
	{
		super(i);
		maxStackSize = 1;
		setMaxDamage(1);
        this.setCreativeTab(mod_SCP.tabSCP);
	}	
	
	public void updateIcons(IconRegister par1)
	{
		switch(classification)
		{
		default:
		case 0:
			iconIndex = par1.registerIcon(mod_SCP.modid + ":Document_Safe");
			break;
		case 1:
			iconIndex = par1.registerIcon(mod_SCP.modid + ":Document_Euclid");
			break;
		case 2:
			iconIndex = par1.registerIcon(mod_SCP.modid + ":Document_Keter");
			break;
		}
	}

    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
        int var11 = par3World.getBlockId(par4, par5, par6);
		if (var11 == Block.snow.blockID)
        {
            par7 = 1;
        }
        else if (var11 != Block.vine.blockID && var11 != Block.tallGrass.blockID && var11 != Block.deadBush.blockID
                && (Block.blocksList[var11] == null || !Block.blocksList[var11].isBlockReplaceable(par3World, par4, par5, par6))) par5 +=1;
    	return true;
	}
}