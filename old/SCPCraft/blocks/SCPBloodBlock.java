package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import SCPCraft.mod_SCP;

public class SCPBloodBlock extends Block
{
    public SCPBloodBlock(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return mod_SCP.BloodBlock.blockID;
    }
    
    public void addCreativeItems(java.util.ArrayList list) { list.add(new ItemStack(this));	}
}
