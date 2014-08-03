package securecraftprotect.common.tile;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntityLightBulb;

public class TileLightBulb extends BlockContainer
{
    public TileLightBulb()
    {
        super(Material.glass);
        this.setCreativeTab(SCP.scpTile);
        this.setBlockBounds(0.12F, 0.37F, 0.12F, 0.88F, 1F, 0.88F);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int dir, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            int meta = world.getBlockMetadata(x, y, z);
            meta += 1;
            if (meta > 15)
            {
                meta = 0;
            }
            world.setBlockMetadataWithNotify(x, y, z, meta, 0b11);
            return true;
        }
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        world.setBlockMetadataWithNotify(x, y, z, 0, 0b11);
    }
    
     public TileEntity createNewTileEntity(World world, int par2)
     {
     return new TileEntityLightBulb();
     }
    
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return -1;
    }
}
