package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntityLightBulb;
import securecraftprotect.common.tileentity.TileEntitySCP0015;

public class TileLightBulb extends BlockContainer
{
    public TileLightBulb()
    {
        super(Material.glass);
        this.setCreativeTab(SCP.scpTile);
    }
    
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntityLightBulb();
    }
}
