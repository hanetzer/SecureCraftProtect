package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import securecraftprotect.SCP;

public class TileDocument extends Block {
    private IIcon icon_top;
    private IIcon icon_front;
    private IIcon icon_side;
    private IIcon icon_bottom;

    public TileDocument() {
        super(Material.iron);
        this.setCreativeTab(SCP.scpTile);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icon_side = iconRegister.registerIcon("scp:document_side");
        this.icon_top = iconRegister.registerIcon("scp:document_top");
        this.icon_front = iconRegister.registerIcon("scp:document_front");
        this.icon_bottom = iconRegister.registerIcon("minecraft:iron_block");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch (side) {
            case 0:
                return icon_bottom;
            case 1:
                return icon_top;
            default:
                if (side != meta) {
                    return icon_side;
                } else {
                    return icon_front;
                }
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z,
                                    EntityPlayer player, int var6,
                                    float var7, float var8, float var9) {
        Block block = world.getBlock(x, y, z);
        if (block == this) {
            player.openGui(SCP.instance(), 0, world, x, y, z);
            return true;
        } else {
            return false;
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z,
                                EntityLivingBase entity, ItemStack stack) {
        byte b0 = 0;
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        switch (l) {
            case 0:
                b0 = 2;
                break;
            case 1:
                b0 = 5;
                break;
            case 2:
                b0 = 3;
                break;
            case 3:
                b0 = 4;
                break;
        }
        world.setBlockMetadataWithNotify(x, y, z, b0, 2);
    }
}
