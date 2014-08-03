package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import SCPCraft.mod_SCP;

public class SCPBlockMachine extends Block
{
	private Icon[] icons;
	
    public SCPBlockMachine(int par1, int par2)
    {
        super(par1, Material.rock);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public void registerIcons(IconRegister par1)
	{
		icons = new Icon[2];

		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1.registerIcon(mod_SCP.modid + ":" + (this.getUnlocalizedName2()) + i);
		}
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par2)
		{
		default:
		case 0:
		{
			switch(par1)
			{
			case 0: return icons[1];
			case 1: return icons[1];
			case 4: return icons[1];
			default: return icons[0];
			}
		}
		}
	}
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return mod_SCP.Machinery.blockID;
    }
    
    public void addCreativeItems(java.util.ArrayList list) { list.add(new ItemStack(this));	}
}
