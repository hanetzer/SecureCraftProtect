package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import securecraftprotect.SCP;

public class TileBone extends Block
{
	public TileBone()
	{
		super(Material.rock);
		this.setCreativeTab(SCP.scpTile);
	}
	
	public void registerIcons(IIconRegister register)
    {
    	blockIcon = register.registerIcon("scp:bone");
    }
}
