package securecraftprotect.client.renderer.tile;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import securecraftprotect.common.tile.TileSCP0015;
import securecraftprotect.util.Globals;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class RenderTileSCP0015 implements ISimpleBlockRenderingHandler
{
    
    @Override
    public void renderInventoryBlock(Block block, int meta, int ID, RenderBlocks render)
    {
        TileSCP0015 pipe = (TileSCP0015) block;
        IIcon icon = pipe.getIcon();
        pipe.setBlockBoundsForItemRender();
        Tessellator tess = Tessellator.instance;
        if (ID == Globals.RENDER_PIPE)
        {
            render.setRenderBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
            glTranslatef(-0.5F, -0.5F, -0.5F);
            
            tess.startDrawingQuads();
            tess.setNormal(0.0F, -1F, 0.0F);
            render.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
            tess.draw();
            
            tess.startDrawingQuads();
            tess.setNormal(0.0F, 1.0F, 0.0F);
            render.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
            tess.draw();
            
            tess.startDrawingQuads();
            tess.setNormal(0.0F, 0.0F, -1F);
            render.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
            tess.draw();
            
            tess.startDrawingQuads();
            tess.setNormal(0.0F, 0.0F, 1.0F);
            render.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
            tess.draw();
            
            tess.startDrawingQuads();
            tess.setNormal(-1F, 0.0F, 0.0F);
            render.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
            tess.draw();
            
            tess.startDrawingQuads();
            tess.setNormal(1.0F, 0.0F, 0.0F);
            render.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
            tess.draw();
            
            glTranslatef(0.5F, 0.5F, 0.5F);
        }
    }
    
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int ID, RenderBlocks render)
    {
        if (block instanceof TileSCP0015)
        {
            TileSCP0015 pipe = (TileSCP0015) block;
            boolean D = pipe.canPaneConnectTo(world, x, y - 1, z, DOWN);
            boolean U = pipe.canPaneConnectTo(world, x, y + 1, z, UP);
            boolean N = pipe.canPaneConnectTo(world, x, y, z - 1, NORTH);
            boolean S = pipe.canPaneConnectTo(world, x, y, z + 1, SOUTH);
            boolean W = pipe.canPaneConnectTo(world, x - 1, y, z, WEST);
            boolean E = pipe.canPaneConnectTo(world, x + 1, y, z, EAST);
            
            render.setRenderBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
            render.renderStandardBlock(pipe, x, y, z);
            
            if (D)
            {
                render.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.33F, 0.66F);
                render.renderStandardBlock(pipe, x, y, z);
            }
            if (U)
            {
                render.setRenderBounds(0.33F, 0.66F, 0.33F, 0.66F, 1F, 0.66F);
                render.renderStandardBlock(pipe, x, y, z);
            }
            if (N)
            {
                render.setRenderBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.33F);
                render.renderStandardBlock(pipe, x, y, z);
            }
            if (S)
            {
                render.setRenderBounds(0.33F, 0.33F, 0.66F, 0.66F, 0.66F, 1F);
                render.renderStandardBlock(pipe, x, y, z);
            }
            if (W)
            {
                render.setRenderBounds(0.0F, 0.33F, 0.33F, 0.33F, 0.66F, 0.66F);
                render.renderStandardBlock(pipe, x, y, z);
            }
            if (E)
            {
                render.setRenderBounds(0.66F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
                render.renderStandardBlock(pipe, x, y, z);
            }
        }
        return true;
    }
    
    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }
    
    @Override
    public int getRenderId()
    {
        return Globals.RENDER_PIPE;
    }
}
