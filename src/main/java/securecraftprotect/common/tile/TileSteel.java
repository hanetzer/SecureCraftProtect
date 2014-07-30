package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import securecraftprotect.SCP;

public class TileSteel extends Block {
    public TileSteel() {
        super(Material.iron);
		setHardness(3.0F);
		setStepSound(Block.soundTypeMetal);
		setResistance(20.0F);
        setCreativeTab(SCP.scpTile);
    }

    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon("scp:reinforced_steel");
    }
}
