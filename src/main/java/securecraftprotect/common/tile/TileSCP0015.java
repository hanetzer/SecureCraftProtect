package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntitySCP0015;
import securecraftprotect.util.Globals;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static securecraftprotect.init.SCPTiles.machinery;
import static securecraftprotect.init.SCPTiles.toilet;

public class TileSCP0015 extends BlockContainer
{
    public Random rand = new Random();
    
    public TileSCP0015()
    {
        super(Material.iron);
        this.setCreativeTab(SCP.scpTile);
    }
    
    public final boolean canPaneConnectToBlock(Block block)
    {
        return block == this || block == machinery || block == toilet;
    }
    
    public boolean canPaneConnectTo(IBlockAccess w, int x, int y, int z, ForgeDirection dir)
    {
        return canPaneConnectToBlock(w.getBlock(x, y, z));
    }
    
    public void breakBlock(World world, int x, int y, int z, Block block, int i)
    {
        world.func_147453_f(x, y, z, block);
        super.breakBlock(world, x, y, z, block, i);
    }
    
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntitySCP0015();
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int j, float u, float v, float w)
    {
        int p[] =
        { Potion.blindness.id, Potion.hunger.id, Potion.confusion.id, Potion.digSlowdown.id, Potion.moveSlowdown.id, Potion.weakness.id, Potion.poison.id // ,
                                                                                                                                                          // SCPPotion.shake.id
        };
        
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            for (int i = 0; i < 50; ++i)
            {
                world.spawnParticle("splash", player.posX, player.posY, player.posZ, 0D, -0.1D, 0D);
                world.spawnParticle("splash", player.posX, player.posY, player.posZ, 0D, -0.1D, 0D);
                world.spawnParticle("splash", player.posX, player.posY, player.posZ, 0D, -0.1D, 0D);
            }
            player.addPotionEffect(new PotionEffect(p[rand.nextInt(p.length)], 200, 1));
            return true;
        }
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World w, int x, int y, int z)
    {
        boolean D = canPaneConnectTo(w, x, y - 1, z, DOWN);
        boolean U = canPaneConnectTo(w, x, y + 1, z, UP);
        boolean N = canPaneConnectTo(w, x, y, z - 1, NORTH);
        boolean S = canPaneConnectTo(w, x, y, z + 1, SOUTH);
        boolean W = canPaneConnectTo(w, x - 1, y, z, WEST);
        boolean E = canPaneConnectTo(w, x + 1, y, z, EAST);
        
        float minX = 0.33f, minY = 0.33f, minZ = 0.33f, maxX = 0.66f, maxY = 0.66f, maxZ = 0.66f;
        
        if (D) minY = 0F;
        if (U) maxY = 1F;
        if (N) minZ = 0F;
        if (S) maxZ = 1F;
        if (W) minX = 0F;
        if (E) maxX = 1F;
        
        setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        return super.getSelectedBoundingBoxFromPool(w, x, y, z);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z)
    {
        boolean D = canPaneConnectTo(w, x, y - 1, z, DOWN);
        boolean U = canPaneConnectTo(w, x, y + 1, z, UP);
        boolean N = canPaneConnectTo(w, x, y, z - 1, NORTH);
        boolean S = canPaneConnectTo(w, x, y, z + 1, SOUTH);
        boolean W = canPaneConnectTo(w, x - 1, y, z, WEST);
        boolean E = canPaneConnectTo(w, x + 1, y, z, EAST);
        
        float minX = 0.33f, minY = 0.33f, minZ = 0.33f, maxX = 0.66f, maxY = 0.66f, maxZ = 0.66f;
        
        if (D) minY = 0F;
        if (U) maxY = 1F;
        if (N) minZ = 0F;
        if (S) maxZ = 1F;
        if (W) minX = 0F;
        if (E) maxX = 1F;
        
        setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }
    
    public void addCollisionBoxesToList(World w, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
        boolean D = canPaneConnectTo(w, x, y - 1, z, DOWN);
        boolean U = canPaneConnectTo(w, x, y + 1, z, UP);
        boolean N = canPaneConnectTo(w, x, y, z - 1, NORTH);
        boolean S = canPaneConnectTo(w, x, y, z + 1, SOUTH);
        boolean W = canPaneConnectTo(w, x - 1, y, z, EAST);
        boolean E = canPaneConnectTo(w, x + 1, y, z, WEST);
        
        setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
        super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
        
        if (W)
        {
            setBlockBounds(0.0F, 0.33F, 0.33F, 0.33F, 0.66F, 0.66F);
            super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
        }
        if (N)
        {
            setBlockBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.33F);
            super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
        }
        if (S)
        {
            setBlockBounds(0.33F, 0.33F, 0.66F, 0.66F, 0.66F, 1F);
            super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
        }
        if (E)
        {
            setBlockBounds(0.66F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
            super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
        }
        if (U)
        {
            setBlockBounds(0.33F, 0.66F, 0.33F, 0.66F, 1F, 0.66F);
            super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
        }
        if (D)
        {
            setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.33F, 0.66F);
            super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
        }
    }
    
    public boolean canRenderInPass(int pass)
    {
        return true;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getRenderType()
    {
        return Globals.RENDER_PIPE;
    }
    
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("scp:0015");
    }
    
    public IIcon getIcon()
    {
        return this.blockIcon;
    }
}
