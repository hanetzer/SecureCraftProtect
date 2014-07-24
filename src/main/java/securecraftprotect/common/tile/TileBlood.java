package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import securecraftprotect.SCP;

public class TileBlood extends Block {
    public TileBlood() {
        super(Material.rock);
        setCreativeTab(SCP.scpTile);
    }

    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon("scp:blood_block");
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        byte b0 = 0;
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox(
                (double) x + minX,
                (double) y + minY,
                (double) z + minZ,
                (double) x + maxX,
                (double) ((float) y + ((float) b0 * f)),
                (double) z + maxZ);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public void setBlockBoundsForItemRender() {
        func_150089_b(0);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int x, int y, int z) {
        func_150089_b(p_149719_1_.getBlockMetadata(x, y, z));
    }

    protected void func_150089_b(int p_150089_1_) {
        byte b0 = 0;
        float f = (float) ((1 + b0)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }
}
