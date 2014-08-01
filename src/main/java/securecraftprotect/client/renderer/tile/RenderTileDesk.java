package securecraftprotect.client.renderer.tile;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import securecraftprotect.common.tile.TileDesk;
import securecraftprotect.util.Globals;

import static org.lwjgl.opengl.GL11.glTranslatef;

public class RenderTileDesk implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int meta, int ID,
									 RenderBlocks render)
	{
		if (block instanceof TileDesk)
		{
			TileDesk desk = (TileDesk) block;
			IIcon icon = desk.getIcon(2, meta);
			desk.setBlockBoundsForItemRender();
			Tessellator tess = Tessellator.instance;

			render.setRenderBounds(0.0D, 0.8D, 0.0D, 1.0D, 1.0D, 1.0D);

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

			render.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);

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

			render.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);

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

			render.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);

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

			render.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);

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
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
									Block block, int ID, RenderBlocks renderer)
	{
		if (block instanceof TileDesk) {
			TileDesk desk = (TileDesk) block;
			boolean N = desk.canPaneConnectToBlock(world.getBlock(x, y,
					z - 1));
			boolean S = desk.canPaneConnectToBlock(world.getBlock(x, y,
					z + 1));
			boolean W = desk.canPaneConnectToBlock(world.getBlock(x - 1, y,
					z));
			boolean E = desk.canPaneConnectToBlock(world.getBlock(x + 1, y,
					z));
			renderer.setRenderBounds(0.0D, 0.8D, 0.0D, 1.0D, 1.0D, 1.0D); //top
			renderer.renderStandardBlock(desk, x, y, z);
			if (!N && !S && !W && !E) {
				renderer.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
				renderer.renderStandardBlock(block, x, y, z);
			} else {
				if (N) {
					if (!S && !W && !E) {
						renderer.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (W) {
						renderer.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (E) {
						renderer.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
				if (W) {
					if (!E && !S && !N) {
						renderer.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (N) {
						renderer.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (S) {
						renderer.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
				if (E) {
					if (!W && !S && !N) {
						renderer.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (N) {
						renderer.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (S) {
						renderer.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
				if (S) {
					if (!N && !W && !E) {
						renderer.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (E) {
						renderer.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
					} else if (W) {
						renderer.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
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
		return Globals.RENDER_DESK;
	}
}
