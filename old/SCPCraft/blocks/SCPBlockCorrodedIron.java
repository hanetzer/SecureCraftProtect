package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import SCPCraft.mod_SCP;

public class SCPBlockCorrodedIron extends Block
{
    public SCPBlockCorrodedIron(int par1, int par2)
    {
        super(par1, Material.iron);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.CorrodedIron.blockID;
	}
    
    public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }
}