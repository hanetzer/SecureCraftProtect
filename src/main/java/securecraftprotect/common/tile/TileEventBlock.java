package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntityEventBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEventBlock extends BlockContainer
{
    public TileEntityEventBlock tile;
    
    
    public TileEventBlock()
    {
        super(Material.iron);
        this.setCreativeTab(SCP.scpTile);
    }
    
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntityEventBlock();
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return Blocks.iron_block.getIcon(side, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
    {
        TileEntityEventBlock tile = (TileEntityEventBlock) world.getTileEntity(x, y, z);
        if (tile != null && tile.block != null)
        {
            Block bl = Block.getBlockFromItem(tile.block.getItem());
            if (bl != Blocks.air)
            {
                ItemStack itemStack = tile.block;
                if (itemStack != null) return bl instanceof TileEventBlock ? Blocks.iron_block.colorMultiplier(world, x, y, z) : bl.colorMultiplier(world, x, y, z);
            }
        }
        return 16777215;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        TileEntityEventBlock tile = (TileEntityEventBlock) world.getTileEntity(x, y, z);
        if (tile != null && tile.block != null)
        {
            Block bl = Block.getBlockFromItem(tile.block.getItem());
            if (bl != Blocks.air)
            {
                ItemStack itemStack = tile.block;
                if (itemStack != null) return bl instanceof TileEventBlock ? Blocks.iron_block.getIcon(0, 0) : bl.getIcon(side, itemStack.getMetadata());
            }
        }
        return Blocks.iron_block.getBlockTextureFromSide(side);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
        
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9)
    {
//        boolean isPlayerOp = false;
        Block block = world.getBlock(x, y, z);
//        String[] OpPlayers = MinecraftServer.getServer().getConfigurationManager().func_152603_m().func_152685_a();
//        for(int i = 0; i < OpPlayers.length; i++) if(OpPlayers[i].equalsIgnoreCase(player.getDisplayName())) isPlayerOp = true;
        if (block == this && player.capabilities.isCreativeMode)
        {
            player.openGui(SCP.instance(), 1, world, x, y, z);
            return true;
        }
        else return false;
    }
}
