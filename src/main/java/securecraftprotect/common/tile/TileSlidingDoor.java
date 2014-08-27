package securecraftprotect.common.tile;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntitySlidingDoor;

public class TileSlidingDoor extends BlockContainer
{
    public boolean isActivated = false;
    
    public TileSlidingDoor()
    {
        super(Material.iron);
        this.setCreativeTab(SCP.scpTile);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getRenderType()
    {
        return -1;
    }
    
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntitySlidingDoor();
    }
    
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
    {
        return side == 1 || world.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean canRenderInPass(int pass)
    {
        return true;
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World w, int x, int y, int z)
    {
        int metadata = w.getBlockMetadata(x, y, z);
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) w.getTileEntity(x, y, z);
        if (door != null)
        {
            if (!door.open)
            {
                if (metadata == 0) setBlockBounds(0f, 0f, 0.35f, 1f, 2f, 0.65f);
                if (metadata == 1) setBlockBounds(0.35f, 0f, 0f, 0.65f, 2f, 1f);
            }
            else setBlockBounds(0f, 0f, 0f, 0f, 0f, 0f);
        }
        return super.getSelectedBoundingBoxFromPool(w, x, y, z);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z)
    {
        int metadata = w.getBlockMetadata(x, y, z);
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) w.getTileEntity(x, y, z);
        if (door != null)
        {
            if (!door.open)
            {
                if (metadata == 0) setBlockBounds(0f, 0f, 0.35f, 1f, 2f, 0.65f);
                if (metadata == 1) setBlockBounds(0.35f, 0f, 0f, 0.65f, 2f, 1f);
            }
            else setBlockBounds(0f, 0f, 0f, 0f, 0f, 0f);
        }
    }
    
    public void addCollisionBoxesToList(World w, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
        int metadata = w.getBlockMetadata(x, y, z);
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) w.getTileEntity(x, y, z);
        if (door != null)
        {
            if (!door.open)
            {
                if (metadata == 0)
                {
                    setBlockBounds(0f, 0f, 0.35f, 1f, 2f, 0.65f);
                    super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
                }
                if (metadata == 1)
                {
                    setBlockBounds(0.35f, 0f, 0f, 0.65f, 2f, 1f);
                    super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
                }
            }
            else
            {
                setBlockBounds(0f, 0f, 0f, 0f, 0f, 0f);
                super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
            }
        }
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        boolean isGettingPowered = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z) || world.isBlockIndirectlyGettingPowered(x, y - 1, z);
        if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z))
        {
            world.setBlockToAir(x, y, z);
            this.dropBlockAsItem(world, x, y, z, 0, 0);
        }
        
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) world.getTileEntity(x, y, z);
        if (door != null && isGettingPowered)
        {
            if (!door.open)
            {
                world.playSoundEffect(x, (double) y + 0.5D, z, "scp:mob.0173.step", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                door.open = true;
            }
            else
            {
                world.playSoundEffect(x, (double) y + 0.5D, z, "scp:random.rustle1", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                door.open = false;
            }
        }
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        int l = determineOrientation(world, x, y, z, entity);
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }
    
    public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player)
    {
        if (MathHelper.abs((float) player.posX - (float) x) < 2.0F && MathHelper.abs((float) player.posZ - (float) z) < 2.0F)
        {
            double d0 = player.posY + 1.82D - (double) player.yOffset;
            
            if (d0 - (double) y > 2.0D) { return 1; }
            
            if ((double) y - d0 > 0.0D) { return 0; }
        }
        
        int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 0 : (l == 1 ? 1 : (l == 2 ? 0 : (l == 3 ? 1 : 0)));
    }
    
    public int getMobilityFlag()
    {
        return 1;
    }
}
