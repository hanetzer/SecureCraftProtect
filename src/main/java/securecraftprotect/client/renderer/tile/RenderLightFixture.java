package securecraftprotect.client.renderer.tile;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderLightFixture implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int meta, int ID, RenderBlocks render)
	{

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
									Block block, int ID, RenderBlocks render)
	{
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return 0;
	}
}
