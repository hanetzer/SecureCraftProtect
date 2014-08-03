package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import SCPCraft.mod_SCP;

public class SCPBlockGrate extends Block
{
	public SCPBlockGrate(int par1, int par2)
	{
		super(par1, Material.iron);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.GrateBlock.blockID;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return true;
    }
    
  /*  public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
    	EntityPlayer ep = ModLoader.getMinecraftInstance().thePlayer;
    	((EntityLiving)ep).addPotionEffect(new PotionEffect(mod_SCP.verminGod.id, 10 * 10, 1));
    	return true;
    } */

    public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }
}