package SCPCraft.renders;

import java.util.Random;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import SCPCraft.mod_Others;
import SCPCraft.blocks.SCPBlock015;
import SCPCraft.blocks.SCPBlockCorrodedDoor;
import SCPCraft.blocks.SCPBlockDesk;
import SCPCraft.blocks.SCPBlockSlideDoor;
import SCPCraft.blocks.SCPBlockStoneCoffin;

public class SCPBlockRenders implements ISimpleBlockRenderingHandler
{

	public SCPBlockRenders() 
	{
	}

	public boolean RenderKeycardSlot(Block block, int i, int j, int k, RenderBlocks renderblocks) 
	{
		int l = renderblocks.blockAccess.getBlockMetadata(i, j, k);		
		int m = l & 7;

		if (m == 0 || m == 4) 
		{
			renderblocks.setRenderBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.185F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.33F, 0.2F, 0.185F, 0.66F, 0.4F, 0.25F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.25F);
		}
		if (m == 1 || m == 5) 
		{
			renderblocks.setRenderBounds(0.815F, 0.2F, 0.33F, 1.0F, 0.8F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.75F, 0.2F, 0.33F, 0.815F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.75F, 0.2F, 0.33F, 1.0F, 0.8F, 0.66F);
		}
		if (m == 2 || m == 6) 
		{
			renderblocks.setRenderBounds(0.33F, 0.2F, 0.815F, 0.66F, 0.8F, 1.0F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.4F, 0.815F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.8F, 1.0F);
		}
		if (m == 3 || m == 7) 
		{
			renderblocks.setRenderBounds(0.0F, 0.2F, 0.33F, 0.185F, 0.8F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.185F, 0.2F, 0.33F, 0.25F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.0F, 0.2F, 0.3F, 0.25F, 0.8F, 0.6F);
		}
		return true;
	}	

	public void colorFix(Block par1Block, RenderBlocks renderblocks, int par2, int par3, int par4)
	{
		Tessellator var6 = Tessellator.instance;
		var6.setBrightness(par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2, par3, par4));
		float var7 = 1.0F;
		int var8 = par1Block.colorMultiplier(renderblocks.blockAccess, par2, par3, par4);
		float var9 = (float)(var8 >> 16 & 255) / 255.0F;
		float var10 = (float)(var8 >> 8 & 255) / 255.0F;
		float var11 = (float)(var8 & 255) / 255.0F;

		if (EntityRenderer.anaglyphEnable)
		{
			float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
			float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
			float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
			var9 = var12;
			var10 = var13;
			var11 = var14;
		}

		var6.setColorOpaque_F(var7 * var9, var7 * var10, var7 * var11);		
	}

	public boolean renderSmokeBlock(Block par1Block, int par2, int par3, int par4, RenderBlocks renderblocks)
	{
		int i = renderblocks.blockAccess.getBlockMetadata(par2, par3, par4);
		colorFix(par1Block, renderblocks, par2, par3, par4);

		if(i == 0) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 1) 
		{
			renderblocks.setRenderBounds(0.0F, 0.1875F, 0.0F, 1.0F, 1.0F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 2) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 0.8125F, 1F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 3) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.8125F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 4) 
		{
			renderblocks.setRenderBounds(0.1875F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 5) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.1875F, 1.0F, 1F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		return true;
	}

	public boolean renderSCP310(Block par1Block, int par2, int par3, int par4, RenderBlocks renderblocks)
	{
		Icon icon;
		renderblocks.setRenderBounds(0.4F, 0.2F, 0.4F, 0.6F, 0.5F, 0.6F);  
		renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
		renderblocks.renderTopFace(par1Block, (double)par2, (double)par3, (double)par4, renderblocks.getBlockIconFromSide(par1Block, 2));
		renderblocks.renderNorthFace(par1Block, (double)par2, (double)par3, (double)par4, renderblocks.getBlockIconFromSide(par1Block, 2));
		renderblocks.renderSouthFace(par1Block, (double)par2, (double)par3, (double)par4, renderblocks.getBlockIconFromSide(par1Block, 2));
		renderblocks.renderEastFace(par1Block, (double)par2, (double)par3, (double)par4, renderblocks.getBlockIconFromSide(par1Block, 2));
		renderblocks.renderWestFace(par1Block, (double)par2, (double)par3, (double)par4, renderblocks.getBlockIconFromSide(par1Block, 2));

		renderblocks.setRenderBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.2F, 0.7F);
		par1Block.setUnlocalizedName("2");
		renderblocks.renderStandardBlock(par1Block, par2, par3, par4);

		return true;
	}

	public boolean CorrodedDoor(Block par1Block, int par2, int par3, int par4, RenderBlocks renderblocks) 
	{
		Tessellator tessellator = Tessellator.instance;
        int l = renderblocks.blockAccess.getBlockMetadata(par2, par3, par4);

        if ((l & 8) != 0)
        {
            if (renderblocks.blockAccess.getBlockId(par2, par3 - 1, par4) != par1Block.blockID)
            {
                return false;
            }
        }
        else if (renderblocks.blockAccess.getBlockId(par2, par3 + 1, par4) != par1Block.blockID)
        {
            return false;
        }

        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        int i1 = par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2, par3, par4);
        tessellator.setBrightness(renderblocks.renderMinY > 0.0D ? i1 : par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2, par3 - 1, par4));
        tessellator.setColorOpaque_F(f, f, f);
        renderblocks.renderBottomFace(par1Block, (double)par2, (double)par3, (double)par4, renderblocks.getBlockIcon(par1Block, renderblocks.blockAccess, par2, par3, par4, 0));
        flag = true;
        tessellator.setBrightness(renderblocks.renderMaxY < 1.0D ? i1 : par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2, par3 + 1, par4));
        tessellator.setColorOpaque_F(f1, f1, f1);
        renderblocks.renderTopFace(par1Block, (double)par2, (double)par3, (double)par4, renderblocks.getBlockIcon(par1Block, renderblocks.blockAccess, par2, par3, par4, 1));
        flag = true;
        tessellator.setBrightness(renderblocks.renderMinZ > 0.0D ? i1 : par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2, par3, par4 - 1));
        tessellator.setColorOpaque_F(f2, f2, f2);
        Icon icon = renderblocks.getBlockIcon(par1Block, renderblocks.blockAccess, par2, par3, par4, 2);
        renderblocks.renderEastFace(par1Block, (double)par2, (double)par3, (double)par4, icon);
        flag = true;
        renderblocks.flipTexture = false;
        tessellator.setBrightness(renderblocks.renderMaxZ < 1.0D ? i1 : par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2, par3, par4 + 1));
        tessellator.setColorOpaque_F(f2, f2, f2);
        icon = renderblocks.getBlockIcon(par1Block, renderblocks.blockAccess, par2, par3, par4, 3);
        renderblocks.renderWestFace(par1Block, (double)par2, (double)par3, (double)par4, icon);
        flag = true;
        renderblocks.flipTexture = false;
        tessellator.setBrightness(renderblocks.renderMinX > 0.0D ? i1 : par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2 - 1, par3, par4));
        tessellator.setColorOpaque_F(f3, f3, f3);
        icon = renderblocks.getBlockIcon(par1Block, renderblocks.blockAccess, par2, par3, par4, 4);
        renderblocks.renderNorthFace(par1Block, (double)par2, (double)par3, (double)par4, icon);
        flag = true;
        renderblocks.flipTexture = false;
        tessellator.setBrightness(renderblocks.renderMaxX < 1.0D ? i1 : par1Block.getMixedBrightnessForBlock(renderblocks.blockAccess, par2 + 1, par3, par4));
        tessellator.setColorOpaque_F(f3, f3, f3);
        icon = renderblocks.getBlockIcon(par1Block, renderblocks.blockAccess, par2, par3, par4, 5);
        renderblocks.renderSouthFace(par1Block, (double)par2, (double)par3, (double)par4, icon);
        flag = true;
        renderblocks.flipTexture = false;
        return flag;
	}

	public boolean renderToilet(Block block, int i, int j, int k, RenderBlocks renderblocks) 
	{
		int l = renderblocks.blockAccess.getBlockMetadata(i, j, k);		
		if (l == 0) {
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.20F, 0.4F, 0.25F, 0.80F, 0.6F, 0.85F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.20F, 0.4F, 0F, 0.80F, 1.3F, 0.25F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.20F, 0.6F, 0.30F, 0.80F, 1.3F, 0.37F);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		if (l == 1) {
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.20F, 0.4F, 0.25F, 0.80F, 0.6F, 0.75F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.20F, 0.4F, 0.75F, 0.80F, 1.3F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.20F, 0.6F, 0.63F, 0.80F, 1.3F, 0.70F);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		if (l == 2) {
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.25F, 0.4F, 0.20F, 0.85F, 0.6F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.0F, 0.4F, 0.20F, 0.25F, 1.3F, 0.8F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.30F, 0.6F, 0.20F, 0.37F, 1.3F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		if (l == 3) {
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.15F, 0.4F, 0.20F, 0.75F, 0.6F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.75F, 0.4F, 0.20F, 1F, 1.3F, 0.8F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.setRenderBounds(0.63F, 0.6F, 0.20F, 0.7F, 1.3F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		return true;
	}

	public boolean renderSCP789J(Block block, int i, int j, int k, RenderBlocks renderblocks) 
	{
		int l = renderblocks.blockAccess.getBlockMetadata(i, j, k);		

		if (l == 0) 
		{
			//Support
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			//Bottom
			renderblocks.setRenderBounds(0.20F, 0.4F, 0.25F, 0.80F, 0.6F, 0.85F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			//Recipient
			renderblocks.setRenderBounds(0.20F, 0.4F, 0F, 0.80F, 1.3F, 0.25F);
			renderblocks.renderStandardBlock(block, i, j, k);

			//Seat
			renderblocks.setRenderBounds(0.20F, 0.6F, 0.30F, 0.80F, 1.3F, 0.37F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

		}
		if (l == 1) 
		{
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.20F, 0.4F, 0.25F, 0.80F, 0.6F, 0.75F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0.20F, 0.4F, 0.75F, 0.80F, 1.3F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.20F, 0.6F, 0.63F, 0.80F, 1.3F, 0.70F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if (l == 2) 
		{
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.25F, 0.4F, 0.20F, 0.85F, 0.6F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0.0F, 0.4F, 0.20F, 0.25F, 1.3F, 0.8F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.30F, 0.6F, 0.20F, 0.37F, 1.3F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if (l == 3) 
		{
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.4F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.15F, 0.4F, 0.20F, 0.75F, 0.6F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0.75F, 0.4F, 0.20F, 1F, 1.3F, 0.8F);
			renderblocks.renderStandardBlock(block, i, j, k);

			renderblocks.setRenderBounds(0.63F, 0.6F, 0.20F, 0.7F, 1.3F, 0.80F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		return true;
	}

	public boolean renderSCP015(SCPBlock015 block, int i, int j, int k, RenderBlocks renderblocks)
	{
		boolean flag = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i, j, k - 1));
		boolean flag1 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i - 1, j, k));
		boolean flag2 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i + 1, j, k));
		boolean flag3 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i, j, k + 1));
		boolean flag4 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i, j + 1, k));
		boolean flag5 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i, j - 1, k));

		renderblocks.setRenderBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		renderblocks.renderStandardBlock(block, i, j, k);
		colorFix(block, renderblocks, i, j, k);

		if(flag1) 
		{
			renderblocks.setRenderBounds(0.0F, 0.33F, 0.33F, 0.33F, 0.66F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
		}    	
		if(flag) 
		{
			renderblocks.setRenderBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.33F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
		}    	
		if(flag3) 
		{
			renderblocks.setRenderBounds(0.33F, 0.33F, 0.66F, 0.66F, 0.66F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
		}    	
		if(flag2) 
		{
			renderblocks.setRenderBounds(0.66F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
		}	
		if(flag4) 
		{
			renderblocks.setRenderBounds(0.33F, 0.66F, 0.33F, 0.66F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
		}    	
		if(flag5) 
		{
			renderblocks.setRenderBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.33F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
		}
		return true;
	}

	public boolean renderSlideDoor(SCPBlockSlideDoor block, int i, int j, int k, RenderBlocks renderblocks)
	{
		int l = renderblocks.blockAccess.getBlockMetadata(i, j, k);	
		colorFix(block, renderblocks, i, j, k);
		//BOTTOM
		if(l == 0)
		{
			renderblocks.setRenderBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));					
		}
		if(l == 1)
		{
			renderblocks.setRenderBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));	
		}
		//TOP
		if(l == 2)
		{
			renderblocks.setRenderBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if(l == 3)
		{
			renderblocks.setRenderBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		//BOTTOM Moving
		if(l == 4)
		{
			renderblocks.setRenderBounds(1.1F, 0F, 0.33F, 1.9F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if(l == 5)
		{
			renderblocks.setRenderBounds(0.33F, 0F, 1.1F, 0.66F, 1F, 1.9F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		//TOP Moving
		if(l == 6)
		{
			renderblocks.setRenderBounds(1.1F, 0F, 0.33F, 1.9F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));	
		}
		if(l == 7)
		{
			renderblocks.setRenderBounds(0.33F, 0F, 1.1F, 0.66F, 1F, 1.9F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));	
		}

		//BOTTOM
		if(l == 8)
		{
			renderblocks.setRenderBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));					
		}
		if(l == 9)
		{
			renderblocks.setRenderBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));	
		}
		//TOP
		if(l == 10)
		{
			renderblocks.setRenderBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if(l == 11)
		{
			renderblocks.setRenderBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		//BOTTOM Moving
		if(l == 12)
		{
			renderblocks.setRenderBounds(-0.9F, 0F, 0.33F, -0.1F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if(l == 13)
		{
			renderblocks.setRenderBounds(0.33F, 0F, -0.9F, 0.66F, 1F, -0.1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		//TOP Moving
		if(l == 14)
		{
			renderblocks.setRenderBounds(-0.9F, 0F, 0.33F, -0.1F, 1F, 0.66F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));	
		}
		if(l == 15)
		{
			renderblocks.setRenderBounds(0.33F, 0F, -0.9F, 0.66F, 1F, -0.1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));	
		}
		return true;
	}

	public Random rand = new Random();
	public boolean renderSCP079(Block block, int i, int j, int k, RenderBlocks renderblocks) 
	{		
		int screen = rand.nextInt(2); 
		Tessellator var4 = Tessellator.instance;
		//Screen
		renderblocks.setRenderBounds(0.0F, 0F, 0.13F, 1F, 1.2F, 1F);
		renderblocks.renderStandardBlock(block, i, j, k);

		//Keyboard
		renderblocks.setRenderBounds(0F, 0.0F, -0.65F, 1F, 0.3F, 0.07F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.flipTexture = false;
		renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

		//HDD
		renderblocks.setRenderBounds(-0.7F, 0F, -0.2F, -0.2F, 0.2F, 0.6F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

		//some other crazy shit
		renderblocks.setRenderBounds(1.2F, 0F, 0.1F, 1.8F, 0.3F, 1F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1.67F, 0.1F, -0.05F, 1.77F, 0.25F, 0.1F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1.52F, 0.1F, -0.05F, 1.62F, 0.25F, 0.1F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1.37F, 0.1F, -0.05F, 1.47F, 0.25F, 0.1F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1.22F, 0.1F, -0.05F, 1.32F, 0.25F, 0.1F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

		//cables
		renderblocks.setRenderBounds(0.46F, 0.0F, 0.07F, 0.52F, 0.15F, 0.2F);
		renderblocks.renderStandardBlock(block, i, j, k);		
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(-0.2F, 0.0F, 0.25F, 0F, 0.15F, 0.4F);
		renderblocks.renderStandardBlock(block, i, j, k);	
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1F, 0.0F, 0.35F, 1.2F, 0.05F, 0.4F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1F, 0.0F, 0.45F, 1.2F, 0.05F, 0.5F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1F, 0.0F, 0.55F, 1.2F, 0.05F, 0.6F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1F, 0.0F, 0.65F, 1.2F, 0.05F, 0.7F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.setRenderBounds(1F, 0.1F, 0.4F, 1.2F, 0.15F, 0.45F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

		return true;
	}

	public boolean renderSCP076(Block block, int i, int j, int k, RenderBlocks renderblocks) 
	{
		renderblocks.setRenderBounds(0F, 0F, 0F, 2F, 2F, 2F);
		renderblocks.renderStandardBlock(block, i, j, k);
		return true;
	}

	public boolean renderShelf(Block block, int i, int j, int k, RenderBlocks renderblocks) 
	{
		renderblocks.setRenderBounds(0F, 0F, 0F, 1F, 0.25F, 1F);
		renderblocks.renderStandardBlock(block, i, j, k);
		return true;
	}

	public boolean renderPillar(Block block, int i, int j, int k, RenderBlocks renderblocks) 
	{
		renderblocks.setRenderBounds(0F, 0F, 0F, 1F, 0.2F, 1F);
		renderblocks.renderStandardBlock(block, i, j, k);

		renderblocks.setRenderBounds(0.25F, 0.2F, 0.25F, 0.75F, 1.8F, 0.75F);
		renderblocks.renderStandardBlock(block, i, j, k);

		renderblocks.setRenderBounds(0F, 1.8F, 0F, 1F, 2F, 1F);
		renderblocks.renderStandardBlock(block, i, j, k);
		return true;
	}

	public boolean renderStoneCoffin(SCPBlockStoneCoffin block, int i, int j, int k, RenderBlocks renderblocks)
	{
		boolean flag = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i, j, k - 1));
		boolean flag1 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i - 1, j, k));
		boolean flag2 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i + 1, j, k));
		boolean flag3 = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(i, j, k + 1));
		//BOTTOM
		renderblocks.setRenderBounds(0F, 0F, 0F, 1F, 0.15F, 1F);
		renderblocks.renderStandardBlock(block, i, j, k);

		//SIDES
		if(!flag1){
			if(!flag && !flag3){
				renderblocks.setRenderBounds(0F, 0.15F, 0.15F, 0.15F, 1F, 0.85F);
				renderblocks.renderStandardBlock(block, i, j, k);
			}
			else if(flag && !flag3){
				renderblocks.setRenderBounds(0F, 0.15F, 0F, 0.15F, 1F, 0.85F);
				renderblocks.renderStandardBlock(block, i, j, k);					
			}
			else if(flag3 && !flag){
				renderblocks.setRenderBounds(0F, 0.15F, 0.15F, 0.15F, 1F, 1F);
				renderblocks.renderStandardBlock(block, i, j, k);					
			}
			else if(flag && flag3)
			{
				renderblocks.setRenderBounds(0F, 0.15F, 0F, 0.15F, 1F, 1F);
				renderblocks.renderStandardBlock(block, i, j, k);					
			}
		}
		if(!flag2){
			if(!flag && !flag3){
				renderblocks.setRenderBounds(0.85F, 0.15F, 0.15F, 1F, 1F, 0.85F);
				renderblocks.renderStandardBlock(block, i, j, k);
			}
			else if(flag && !flag3){					
				renderblocks.setRenderBounds(0.85F, 0.15F, 0F, 1F, 1F, 0.85F);
				renderblocks.renderStandardBlock(block, i, j, k);					
			}
			else if(flag3 && !flag){
				renderblocks.setRenderBounds(0.85F, 0.15F, 0.15F, 1F, 1F, 1F);
				renderblocks.renderStandardBlock(block, i, j, k);					
			}
			else if(flag && flag3)
			{
				renderblocks.setRenderBounds(0.85F, 0.15F, 0F, 1F, 1F, 1F);
				renderblocks.renderStandardBlock(block, i, j, k);					
			}
		}			
		if(!flag){
			renderblocks.setRenderBounds(0F, 0.15F, 0F, 1F, 1F, 0.15F);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		if(!flag3){
			renderblocks.setRenderBounds(0F, 0.15F, 0.85F, 1F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		return true;
	}

	public boolean renderPaintings(Block block, int i, int j, int k, RenderBlocks renderblocks)
	{
		int l = renderblocks.blockAccess.getBlockMetadata(i, j, k);	
		Tessellator var5 = Tessellator.instance;
		if (l == 0) 
		{
			renderblocks.setRenderBounds(0F, 0F, 0F, 0.2F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0F, 1F, 0F, 0.2F, 2F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0F, 0F, -1F, 0.2F, 1F, 0F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0F, 1F, -1F, 0.2F, 2F, 0F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if (l == 1) 
		{
			renderblocks.setRenderBounds(0.8F, 0F, 0F, 1F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0.8F, 1F, 0F, 1F, 2F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0.8F, 0F, 1F, 1F, 1F, 2F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0.8F, 1F, 1F, 1F, 2F, 2F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if (l == 2) 
		{
			renderblocks.setRenderBounds(0F, 0F, 0F, 1F, 1F, 0.2F);
			renderblocks.renderStandardBlock(block, i, j, k); 
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0F, 1F, 0F, 1F, 2F, 0.2F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(1F, 0F, 0F, 2F, 1F, 0.2F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(1F, 1F, 0F, 2F, 2F, 0.2F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		if (l == 3) 
		{
			renderblocks.setRenderBounds(0F, 0F, 0.8F, 1F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(0F, 1F, 0.8F, 1F, 2F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(-1F, 0F, 0.8F, 0F, 1F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));

			renderblocks.setRenderBounds(-1F, 1F, 0.8F, 0F, 2F, 1F);
			renderblocks.renderStandardBlock(block, i, j, k);
			colorFix(block, renderblocks, i, j, k);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		}
		return true;
	}

	public boolean renderSCP822(Block block, int i, int j, int k, RenderBlocks renderblocks)
	{	
		Tessellator var8 = Tessellator.instance;
		boolean var9 = false;
		float var10 = 0.5F;
		float var11 = 1.0F;
		float var12 = 0.8F;
		float var13 = 0.6F;
		float var14 = var10 * i;
		float var15 = var11 * i;
		float var16 = var12 * i;
		float var17 = var13 * i;
		float var18 = var10 * j;
		float var19 = var11 * j;
		float var20 = var12 * j;
		float var21 = var13 * j;
		float var22 = var10 * k;
		float var23 = var11 * k;
		float var24 = var12 * k;
		float var25 = var13 * k;
		float var26 = 0.0625F;
		int var28 = block.getMixedBrightnessForBlock(renderblocks.blockAccess, i, j, k);

		int l = renderblocks.blockAccess.getBlockMetadata(i, j, k);	

		if (block.shouldSideBeRendered(renderblocks.blockAccess, i, j - 1, k, 0))
		{
			renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, block.getBlockTexture(renderblocks.blockAccess, i, j, k, 0));
			var9 = true;
		}

		if (block.shouldSideBeRendered(renderblocks.blockAccess, i, j + 1, k, 1))
		{
			renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, block.getBlockTexture((renderblocks.blockAccess), i, j, k, 1));
			var9 = true;
		}

		if (block.shouldSideBeRendered(renderblocks.blockAccess, i, j, k - 1, 2))
		{
			var8.addTranslation(0.0F, 0.0F, var26);
			renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, block.getBlockTexture((renderblocks.blockAccess), i, j, k, 2));
			var8.addTranslation(0.0F, 0.0F, -var26);
			var9 = true;
		}

		if (block.shouldSideBeRendered(renderblocks.blockAccess, i, j, k + 1, 3))
		{
			var8.addTranslation(0.0F, 0.0F, -var26);
			renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, block.getBlockTexture((renderblocks.blockAccess), i, j, k, 3));
			var8.addTranslation(0.0F, 0.0F, var26);
			var9 = true;
		}

		if (block.shouldSideBeRendered(renderblocks.blockAccess, i - 1, j, k, 4))
		{
			var8.addTranslation(var26, 0.0F, 0.0F);
			renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, block.getBlockTexture((renderblocks.blockAccess), i, j, k, 4));
			var8.addTranslation(-var26, 0.0F, 0.0F);
			var9 = true;
		}

		if (block.shouldSideBeRendered((renderblocks.blockAccess), i + 1, j, k, 5))
		{
			var8.addTranslation(-var26, 0.0F, 0.0F);
			renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, block.getBlockTexture((renderblocks.blockAccess), i, j, k, 5));
			var8.addTranslation(var26, 0.0F, 0.0F);
			var9 = true;
		}

		renderblocks.setRenderBounds(0.3F, 1F, 0.3F, 0.7F, 1.2F, 0.7F);
		renderblocks.renderStandardBlock(block, i, j, k);
		renderblocks.renderEastFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderWestFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderSouthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderNorthFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderTopFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		renderblocks.renderBottomFace(block, (double)i, (double)j, (double)k, renderblocks.getBlockIconFromSide(block, 2));
		return true;
	}

	public boolean renderDesk(SCPBlockDesk block, int x, int y, int z, RenderBlocks renderblocks)
	{
		boolean N = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(x, y, z - 1));
		boolean S = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(x, y, z + 1));
		boolean W = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(x - 1, y, z));
		boolean E = block.canThisPaneConnectToThisBlockID(renderblocks.blockAccess.getBlockId(x + 1, y, z));

		renderblocks.setRenderBounds(0F, 0.8F, 0F, 1F, 1F, 1F);
		renderblocks.renderStandardBlock(block, x, y, z);

		if(!N && !W && !E && !S)
		{
			renderblocks.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
			renderblocks.renderStandardBlock(block, x, y, z);
			renderblocks.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
			renderblocks.renderStandardBlock(block, x, y, z);
			renderblocks.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
			renderblocks.renderStandardBlock(block, x, y, z);
			renderblocks.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
			renderblocks.renderStandardBlock(block, x, y, z);
		}
		else if(N && W && E && S){}
		else{
			if(N)
			{
				if(!S && !W && !E)
				{
					renderblocks.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
					renderblocks.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}
				else if(W)
				{
					renderblocks.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}
				else if(E)
				{	
					renderblocks.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}
			}
			if(W)
			{
				if(!E && !S && !N)
				{
					renderblocks.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
					renderblocks.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}	
				else if(N)
				{
					renderblocks.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}
				else if(S)
				{
					renderblocks.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}				
			}
			if(E)
			{
				if(!W && !S && !N)
				{
					renderblocks.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
					renderblocks.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}		
				else if(N)
				{
					renderblocks.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}
				else if(S)
				{
					renderblocks.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}					
			}
			if(S)
			{
				if(!N && !W && !E)
				{
					renderblocks.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
					renderblocks.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}	
				else if(E)
				{
					renderblocks.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}	
				else if(W)
				{		
					renderblocks.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
					renderblocks.renderStandardBlock(block, x, y, z);
				}	
			}
		}
		return true;
	}

	public boolean renderAlarmBlock(Block par1Block, int par2, int par3, int par4, RenderBlocks renderblocks)
	{
		int i = renderblocks.blockAccess.getBlockMetadata(par2, par3, par4);
		colorFix(par1Block, renderblocks, par2, par3, par4);

		if(i == 0) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.35F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 1) 
		{
			renderblocks.setRenderBounds(0.0F, 0.65F, 0.0F, 1.0F, 1.0F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 2) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 0.35F, 1F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 3) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.35F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 4) 
		{
			renderblocks.setRenderBounds(0.65F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		if(i == 5) 
		{
			renderblocks.setRenderBounds(0.0F, 0.0F, 0.65F, 1.0F, 1F, 1.0F);
			renderblocks.renderStandardBlock(par1Block, par2, par3, par4);
			colorFix(par1Block, renderblocks, par2, par3, par4);
		}
		return true;
	}

	public boolean renderBlockChairInWorld(RenderBlocks render, IBlockAccess world, int x, int y, int z, Block block)
	{
		int side = world.getBlockMetadata(x, y, z) & 0x3;
		setBlockBoundsWithRotation(render, block, 0.1F, 0.0F, 0.1F, 0.2F, 0.5F, 0.2F, side);
		render.renderStandardBlock(block, x, y, z);
		setBlockBoundsWithRotation(render, block, 0.1F, 0.0F, 0.8F, 0.2F, 0.5F, 0.9F, side);
		render.renderStandardBlock(block, x, y, z);
		setBlockBoundsWithRotation(render, block, 0.8F, 0.0F, 0.8F, 0.9F, 0.5F, 0.9F, side);
		render.renderStandardBlock(block, x, y, z);
		setBlockBoundsWithRotation(render, block, 0.8F, 0.0F, 0.1F, 0.9F, 0.5F, 0.2F, side);
		render.renderStandardBlock(block, x, y, z);
		setBlockBoundsWithRotation(render, block, 0.1F, 0.5F, 0.1F, 0.9F, 0.6F, 0.9F, side);
		render.renderStandardBlock(block, x, y, z);
		setBlockBoundsWithRotation(render, block, 0.1F, 0.6F, 0.1F, 0.2F, 1.5F, 0.9F, side);
		render.renderStandardBlock(block, x, y, z);
		return true;
	}

	public static void setBlockBoundsWithRotation(RenderBlocks renderblocks, Block block, float minx, float miny, float minz, float maxx, float maxy, float maxz, int rotationType)
	{
		if(rotationType == 1) //Swap X and Z, sign-swap Z, Z++, self-swap Z (fix render derp)
		{
			float tempminx = minx;
			float tempmaxx = maxx;
			minx = minz;
			minz = -tempminx + 1;
			maxx = maxz;
			maxz = -tempmaxx + 1;

			float tempminz = minz;
			minz = maxz;
			maxz = tempminz;
		}
		else if(rotationType == 2) //Sign-swap X and Z, X++, Z++
		{
			minx = -minx + 1;
			minz = -minz + 1;
			maxx = -maxx + 1;
			maxz = -maxz + 1;
		}
		else if(rotationType == 3) //Swap X and Z, sign-swap X, X++, self-swap X (fix render derp)
		{
			float tempminx = minx;
			float tempmaxx = maxx;
			minx = -minz + 1;
			minz = tempminx;
			maxx = -maxz + 1;
			maxz = tempmaxx;

			tempminx = minx;
			minx = maxx;
			maxx = tempminx;
		}
		renderblocks.setRenderBounds(minx, miny, minz, maxx, maxy, maxz);
	}

	public static void setBlockBoundsWithRotation(Block block, float minx, float miny, float minz, float maxx, float maxy, float maxz, int rotationType)
	{
		if(rotationType == 1) //Swap X and Z, sign-swap Z, Z++, self-swap Z (fix render derp)
		{
			float tempminx = minx;
			float tempmaxx = maxx;
			minx = minz;
			minz = -tempminx + 1;
			maxx = maxz;
			maxz = -tempmaxx + 1;

			float tempminz = minz;
			minz = maxz;
			maxz = tempminz;
		}
		else if(rotationType == 2) //Sign-swap X and Z, X++, Z++
		{
			minx = -minx + 1;
			minz = -minz + 1;
			maxx = -maxx + 1;
			maxz = -maxz + 1;
		}
		else if(rotationType == 3) //Swap X and Z, sign-swap X, X++, self-swap X (fix render derp)
		{
			float tempminx = minx;
			float tempmaxx = maxx;
			minx = -minz + 1;
			minz = tempminx;
			maxx = -maxz + 1;
			maxz = tempmaxx;

			tempminx = minx;
			minx = maxx;
			maxx = tempminx;
		}
		block.setBlockBounds(minx, miny, minz, maxx, maxy, maxz);
	}
	
	public boolean renderSCP513(Block par1Block, int i, int j, int k, RenderBlocks renderblocks) 
	{
		renderblocks.setRenderBounds(0.25F, 0.0F, 0.65F, 0.75F, 0.5F, 0.66F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);		
		
		renderblocks.setRenderBounds(0.25F, 0.0F, 0.35F, 0.75F, 0.5F, 0.36F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);	
		
		renderblocks.setRenderBounds(0.25F, 0.0F, 0.35F, 0.26F, 0.5F, 0.65F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);		
		
		renderblocks.setRenderBounds(0.74F, 0.0F, 0.35F, 0.75F, 0.5F, 0.65F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);		
		
		renderblocks.setRenderBounds(0.25F, 0.5F, 0.35F, 0.75F, 0.51F, 0.66F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);	
		
		//Handle
		renderblocks.setRenderBounds(0.42F, 0.51F, 0.49F, 0.58F, 0.6F, 0.52F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);		
		
		//Bell
		renderblocks.setRenderBounds(0.49F, 0.2F, 0.49F, 0.52F, 0.5F, 0.52F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);	
		
		renderblocks.setRenderBounds(0.47F, 0.1F, 0.47F, 0.54F, 0.2F, 0.54F);
		renderblocks.renderStandardBlock(par1Block, i, j, k);	
		return true;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) 
	{
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) 
	{
//		if (modelId == mod_Others.KeycardSlotID) return RenderKeycardSlot(block, i, j, k, renderer);
//		if (modelId == mod_Others.SmokeBlockID) return renderSmokeBlock(block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP310ID) return renderSCP310(block, i, j, k, renderer);
//		if (modelId == mod_Others.CorrodedDoorID) return CorrodedDoor(block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP789JID) return renderSCP789J(block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP015ID) return renderSCP015((SCPBlock015)block, i, j, k, renderer);
//		if (modelId == mod_Others.SlidingDoorID) return renderSlideDoor((SCPBlockSlideDoor)block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP079ID) return renderSCP079(block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP076ID) return renderSCP076(block, i, j, k, renderer);
//		if (modelId == mod_Others.ShelfID) return renderShelf(block, i, j, k, renderer);
//		if (modelId == mod_Others.StoneCoffinID) return renderStoneCoffin((SCPBlockStoneCoffin)block, i, j, k, renderer);
//		if (modelId == mod_Others.PosterID) return renderPaintings(block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP273ID) return renderPillar(block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP822ID) return renderSCP822(block, i, j, k, renderer);
//		if (modelId == mod_Others.ToiletID) return renderToilet(block, i, j, k, renderer);
//		if (modelId == mod_Others.DeskID) return renderDesk((SCPBlockDesk)block, i, j, k, renderer);
//		if (modelId == mod_Others.ChairID) return renderBlockChairInWorld(renderer, world, i, j, k, block);
//		if (modelId == mod_Others.AlarmID) return renderAlarmBlock(block, i, j, k, renderer);
//		if (modelId == mod_Others.SCP513ID) return renderSCP513(block, i, j, k, renderer);
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() 
	{
		return true;
	}

	@Override
	public int getRenderId() 
	{
		return mod_Others.ChairID;
	}
}
