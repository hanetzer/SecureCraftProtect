package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import securecraftprotect.SCP;

public class TileReinforcedSteel extends Block {
    public TileReinforcedSteel() {
        super(Material.iron);
        setCreativeTab(SCP.scpTile);
    }

    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon("scp:reinforced_steel");
    }
}
