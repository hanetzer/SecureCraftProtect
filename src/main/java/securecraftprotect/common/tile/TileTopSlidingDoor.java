package securecraftprotect.common.tile;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntitySlidingDoor;

public class TileTopSlidingDoor extends Block
{
    public boolean isActivated = false;
    
    public TileTopSlidingDoor()
    {
        super(Material.iron);
        setHardness(3.0F);
        setStepSound(Block.soundTypeMetal);
        setResistance(20.0F);
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

    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean canRenderInPass(int pass)
    {
        return true;
    }

    public Item getItemDropped(int quantity, Random random, int metadata)
    {
        return null;
    }

    public void registerIcons(IIconRegister iconRegister) 
    {
        blockIcon = iconRegister.registerIcon("scp:invisible");
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        boolean isGettingPowered = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z) || world.isBlockIndirectlyGettingPowered(x, y - 1, z);
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) world.getTileEntity(x, y - 1, z);
        if (door != null && isGettingPowered)
        {
            if (!door.open)
            {
                world.playSoundEffect(x, (double) y + 0.5D, z, "scp:block.slidingDoor.open", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                door.open = true;
            }
            else
            {
                world.playSoundEffect(x, (double) y + 0.5D, z, "scp:block.slidingDoor.close", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                door.open = false;
            }
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        super.breakBlock(world, x, y, z, block, metadata);
        world.breakBlock(x, y - 1, z, true);
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World w, int x, int y, int z)
    {
        int metadata = w.getBlockMetadata(x, y, z);
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) w.getTileEntity(x, y - 1, z);
        if (door != null)
        {
            if (!door.open)
            {
                if (metadata == 0) setBlockBounds(0f, -1f, 0.35f, 1f, 1f, 0.65f);
                if (metadata == 1) setBlockBounds(0.35f, -1f, 0f, 0.65f, 1f, 1f);
            }
            else setBlockBounds(0f, 0f, 0f, 0f, 0f, 0f);
        }
        return super.getSelectedBoundingBoxFromPool(w, x, y, z);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z)
    {
        int metadata = w.getBlockMetadata(x, y, z);
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) w.getTileEntity(x, y - 1, z);
        if (door != null)
        {
            if (!door.open)
            {
                if (metadata == 0) setBlockBounds(0f, -1f, 0.35f, 1f, 1f, 0.65f);
                if (metadata == 1) setBlockBounds(0.35f, -1f, 0f, 0.65f, 1f, 1f);
            }
            else setBlockBounds(0f, 0f, 0f, 0f, 0f, 0f);
        }
    }
    
    public void addCollisionBoxesToList(World w, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
        int metadata = w.getBlockMetadata(x, y, z);
        TileEntitySlidingDoor door = (TileEntitySlidingDoor) w.getTileEntity(x, y - 1, z);
        if (door != null)
        {
            if (!door.open)
            {
                if (metadata == 0)
                {
                    setBlockBounds(0f, -1f, 0.35f, 1f, 1f, 0.65f);
                    super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
                }
                if (metadata == 1)
                {
                    setBlockBounds(0.35f, -1f, 0f, 0.65f, 1f, 1f);
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
    
    public int getMobilityFlag()
    {
        return 1;
    }
}
