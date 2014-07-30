package securecraftprotect.client.renderer.tile;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import securecraftprotect.common.tile.TileDesk;
import securecraftprotect.util.Globals;

public class RenderTileDesk implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int meta, int ID,
									 RenderBlocks render)
	{
		TileDesk desk = (TileDesk) block;
		IIcon icon = desk.getIcon(2, meta);
		desk.setBlockBoundsForItemRender();
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		render.setRenderBounds(0.0D, 0.8D, 0.0D, 1.0D, 1.0D, 1.0D);
		render.renderFaceXNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceXPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZPos(desk, 0.0F, 0.0F, 0.0F, icon);

		render.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
		render.renderFaceXNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceXPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZPos(desk, 0.0F, 0.0F, 0.0F, icon);

		render.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
		render.renderFaceXNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceXPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZPos(desk, 0.0F, 0.0F, 0.0F, icon);

		render.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
		render.renderFaceXNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceXPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZPos(desk, 0.0F, 0.0F, 0.0F, icon);

		render.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
		render.renderFaceXNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceXPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceYPos(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZNeg(desk, 0.0F, 0.0F, 0.0F, icon);
		render.renderFaceZPos(desk, 0.0F, 0.0F, 0.0F, icon);

		tessellator.draw();
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
			renderer.setRenderBounds(0.0D, 0.8D, 0.0D, 1.0D, 1.0D, 1.0D);
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
			} else if (N && W && E && S) {
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
