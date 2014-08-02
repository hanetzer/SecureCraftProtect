package securecraftprotect.client.renderer.tile;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import securecraftprotect.common.tile.TileChair;
import securecraftprotect.common.tileentity.TileEntityChair;
import securecraftprotect.util.Globals;

import static org.lwjgl.opengl.GL11.*;

public class RenderTileChair implements ISimpleBlockRenderingHandler
{


	@Override
	public void renderInventoryBlock(Block block, int meta, int ID, RenderBlocks render)
	{
		TileChair chair =(TileChair)block;
		IIcon icon = chair.getIcon(2, meta);
		Tessellator tess = Tessellator.instance;

		/**start section one */
		render.setRenderBounds(0.1F, 0.0F, 0.1F, 0.2F, 0.45F, 0.2F);// leg

		glTranslatef(-0.5F, -0.5F, -0.5F);

		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1F, 0.0F);
		render.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		/**
		 * Top face not rendered due to always being hidden by the chair seat
		 */
		//tess.startDrawingQuads();
		//tess.setNormal(0.0F, 1.0F, 0.0F);
		//render.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
		//tess.draw();

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

		/**start section two */
		render.setRenderBounds(0.1F, 0.0F, 0.8F, 0.2F, 0.45F, 0.9F);

		glTranslatef(-0.5F, -0.5F, -0.5F);

		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1F, 0.0F);
		render.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		/**
		 * Top face not rendered due to always being hidden by the chair seat
		 */
		//tess.startDrawingQuads();
		//tess.setNormal(0.0F, 1.0F, 0.0F);
		//render.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
		//tess.draw();

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

		/**start section three */
		render.setRenderBounds(0.8F, 0.0F, 0.8F, 0.9F, 0.45F, 0.9F);

		glTranslatef(-0.5F, -0.5F, -0.5F);

		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1F, 0.0F);
		render.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		/**
		 * Top face not rendered due to always being hidden by the chair seat
		 */
		//tess.startDrawingQuads();
		//tess.setNormal(0.0F, 1.0F, 0.0F);
		//render.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
		//tess.draw();

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

		/**start section four */
		render.setRenderBounds(0.8F, 0.0F, 0.1F, 0.9F, 0.45F, 0.2F);

		glTranslatef(-0.5F, -0.5F, -0.5F);

		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1F, 0.0F);
		render.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		/**
		 * Top face not rendered due to always being hidden by the chair seat
		 */
		//tess.startDrawingQuads();
		//tess.setNormal(0.0F, 1.0F, 0.0F);
		//render.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
		//tess.draw();

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

		/**start section five */
		render.setRenderBounds(0.1F, 0.45F, 0.1F, 0.9F, 0.55F, 0.9F); //seat

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

		/**start section six */
		render.setRenderBounds(0.1F, 0.55F, 0.1F, 0.9F, 1F, 0.2F);//Back

		glTranslatef(-0.5F, -0.5F, -0.5F);

		/**
		 * Bottom face not rendered due to always being hidden by the chair seat
		 */
		//tess.startDrawingQuads();
		//tess.setNormal(0.0F, -1F, 0.0F);
		//render.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
		//tess.draw();

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

	@Override
	public boolean renderWorldBlock(IBlockAccess w, int x, int y, int z,
									Block block, int ID, RenderBlocks render)
	{
		if (block instanceof TileChair) {
			TileEntityChair chair = (TileEntityChair)w.getTileEntity(x, y, z);
			int side = chair.getDir();
			//int side = world.getBlockMetadata(x, y, z) & 0x03;
			setBlockBoundsWithRotation(render, side,
					0.1F, 0.0F, 0.1F, 0.2F, 0.5F, 0.2F);
			render.renderStandardBlock(block, x, y, z);
			setBlockBoundsWithRotation(render, side,
					0.1F, 0.0F, 0.8F, 0.2F, 0.5F, 0.9F);
			render.renderStandardBlock(block, x, y, z);
			setBlockBoundsWithRotation(render, side,
					0.8F, 0.0F, 0.8F, 0.9F, 0.5F, 0.9F);
			render.renderStandardBlock(block, x, y, z);
			setBlockBoundsWithRotation(render, side,
					0.8F, 0.0F, 0.1F, 0.9F, 0.5F, 0.2F);
			render.renderStandardBlock(block, x, y, z);
			setBlockBoundsWithRotation(render, side,
					0.1F, 0.5F, 0.1F, 0.9F, 0.6F, 0.9F);
			render.renderStandardBlock(block, x, y, z);
			setBlockBoundsWithRotation(render, side,
					0.1F, 0.6F, 0.1F, 0.2F, 1.5F, 0.9F);
			render.renderStandardBlock(block, x, y, z);
		}

		return true;
	}

	public static void setBlockBoundsWithRotation(RenderBlocks render, int side,
												  float xNeg, float yNeg, float zNeg,
												  float xPos, float yPos, float zPos)
	{
		float tempXNeg = xNeg;
		float tempXPos = xPos;
		switch (side) {
			case 0: //S
				xNeg = zNeg;
				zNeg = -tempXNeg +1;
				xPos = zPos;
				zPos = -tempXPos +1;

				tempXNeg = xNeg;
				xNeg = xPos;
				xPos = tempXNeg;

				break;
			case 1: //W Do nothing
				break;
			case 2: //N
				xNeg = -zNeg + 1;
				zNeg = tempXNeg;
				xPos = -zPos + 1;
				zPos = tempXPos;

				tempXNeg = xNeg;
				xNeg = xPos;
				xPos = tempXNeg;
				break;
			case 3: //E
				xNeg = -xNeg + 1;
				zNeg = -zNeg + 1;
				xPos = -xPos + 1;
				zPos = -zPos + 1;
				break;
		}
		render.setRenderBounds(xNeg, yNeg, zNeg, xPos, yPos, zPos);
	}

	@Override
	public boolean shouldRender3DInInventory(int ID)
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return Globals.RENDER_DESK;
	}
}
