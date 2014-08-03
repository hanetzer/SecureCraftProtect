package SCPCraft.renders;
 
import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;

public class SCPRenderInventory 
{

	public SCPRenderInventory() 
	{
	}
	
	public void renderInvKeySlot(RenderBlocks renderblocks, Block block, int i)  
	{		
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.185F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 

		renderblocks.setRenderBounds(0.33F, 0.2F, 0.185F, 0.66F, 0.4F, 0.25F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvSCP015(RenderBlocks renderblocks, Block block, int i)  
	{		
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvSCP789J(RenderBlocks renderblocks, Block block, int i)  
	{		
		Tessellator tessellator = Tessellator.instance;
		//Support
		renderblocks.setRenderBounds(0.33F, -0.3F, 0.33F, 0.66F, 0.1F, 0.66F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 

		//Bottom
		renderblocks.setRenderBounds(0.20F, 0.1F, 0.25F, 0.80F, 0.3F, 0.85F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 

		//Recipient
		renderblocks.setRenderBounds(0.20F, 0.1F, 0F, 0.80F, 1F, 0.25F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 

		//Seat
		renderblocks.setRenderBounds(0.20F, 0.3F, 0.30F, 0.80F, 1F, 0.37F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvSmokeBlock(RenderBlocks renderblocks, Block block, int i)  
	{		
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvSCP310(RenderBlocks renderblocks, Block block, int i)  
	{		
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0.4F, 0.2F, 0.4F, 0.6F, 0.5F, 0.6F);  
		block.setUnlocalizedName("37");
		renderStandardInvBlock(renderblocks, tessellator, block, i); 

		renderblocks.setRenderBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.2F, 0.7F);
		block.setUnlocalizedName("2");
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvShelf(RenderBlocks renderblocks, Block block, int i) 
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0F, 0F, 0F, 1F, 0.25F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvBlock(RenderBlocks renderblocks, Block block, int i) 
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0F, 0F, 0F, 1F, 1F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvStoneCoffin(RenderBlocks renderblocks, Block block, int i) 
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0F, 0F, 0F, 1F, 0.15F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
		renderblocks.setRenderBounds(0F, 0.15F, 0.15F, 0.15F, 1F, 0.85F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
		renderblocks.setRenderBounds(0.85F, 0.15F, 0.15F, 1F, 1F, 0.85F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
		renderblocks.setRenderBounds(0F, 0.15F, 0F, 1F, 1F, 0.15F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
		renderblocks.setRenderBounds(0F, 0.15F, 0.85F, 1F, 1F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInvPoster(RenderBlocks renderblocks, Block block, int i) 
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(-0.5F, -0.4F, 0F, 0.5F, 0.6F, 0.2F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public void renderInv079(RenderBlocks renderblocks, Block block, int i) 
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0.1F, 0F, 0.13F, 1.1F, 1.0F, 1F);
		GL11.glRotatef(180F, 0F, 1F, 0F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}
	
	public static void renderStandardInvBlock(RenderBlocks render, Tessellator tess, Block block, int i) {
		glTranslatef(-0.5F, -0.5F, -0.5F);

		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1F, 0.0F);
		render.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(0.0F, 1.0F, 0.0F);
		render.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, -1F);
		render.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, 1.0F);
		render.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(-1F, 0.0F, 0.0F);
		render.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(1.0F, 0.0F, 0.0F);
		render.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
		tess.draw();

		glTranslatef(0.5F, 0.5F, 0.5F);
	}

	public static void renderInvRemoteDoorComp(RenderBlocks renderblocks, Block block, int i)
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0.13F, 0F, 0.13F, 1F, 1.0F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}

	public static void renderInvDesk(RenderBlocks renderblocks, Block block, int i)
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0F, 0.8F, 0F, 1F, 1F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0F, 0F, 0F, 0.1F, 0.8F, 0.1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0F, 0F, 0.9F, 0.1F, 0.8F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0.9F, 0F, 0F, 1F, 0.8F, 0.1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0.9F, 0F, 0.9F, 1F, 0.8F, 1F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}

	public static void renderInvChair(RenderBlocks renderblocks, Block block, int i)
	{
		Tessellator tessellator = Tessellator.instance;
		renderblocks.setRenderBounds(0.1F, 0.0F, 0.1F, 0.2F, 0.2F, 0.2F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0.1F, 0.0F, 0.8F, 0.2F, 0.2F, 0.9F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0.8F, 0.0F, 0.8F, 0.9F, 0.2F, 0.9F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0.8F, 0.0F, 0.1F, 0.9F, 0.2F, 0.2F);
		renderStandardInvBlock(renderblocks, tessellator, block, i);
		renderblocks.setRenderBounds(0.1F, 0.2F, 0.1F, 0.9F, 0.3F, 0.9F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
		renderblocks.setRenderBounds(0.1F, 0.3F, 0.1F, 0.9F, 1F, 0.2F);
		renderStandardInvBlock(renderblocks, tessellator, block, i); 
	}

	public void renderInvPillar(RenderBlocks renderer, Block block, int metadata) 
	{
		Tessellator tessellator = Tessellator.instance;
		
		renderer.setRenderBounds(0.25F, 0F, 0.25F, 0.75F, 0.15F, 0.75F);
		renderStandardInvBlock(renderer, tessellator, block, metadata); 
		
		renderer.setRenderBounds(0.35F, 0.15F, 0.35F, 0.65F, 0.85F, 0.65F);
		renderStandardInvBlock(renderer, tessellator, block, metadata); 
		
		renderer.setRenderBounds(0.25F, 0.85F, 0.25F, 0.75F, 1F, 0.75F);
		renderStandardInvBlock(renderer, tessellator, block, metadata); 		
	}
	
	public void renderInvSCP822(RenderBlocks renderblocks, Block block, int metadata)
	{	
		Tessellator tess = Tessellator.instance;
		
		renderblocks.setRenderBounds(0.1F, 0.1F, 0F, 0.9F, 1F, 0.9F);
		renderStandardInvBlock(renderblocks, tess, block, metadata);
		block.setUnlocalizedName("70");
		
		renderblocks.setRenderBounds(0.3F, 1F, 0.3F, 0.7F, 1.2F, 0.7F);
		renderStandardInvBlock(renderblocks, tess, block, metadata);
		block.setUnlocalizedName("67");
	}

	public void renderInvAlarm(RenderBlocks renderer, Block block, int metadata) 
	{		
		Tessellator tessellator = Tessellator.instance;
		renderer.setRenderBounds(0F, 0F, 0F, 1F, 0.35F, 1F);
		renderStandardInvBlock(renderer, tessellator, block, metadata); 	
	}
	
	public void renderSCP513(RenderBlocks renderblocks, Block block, int i)  
	{	
		Tessellator var8 = Tessellator.instance;
		renderblocks.setRenderBounds(0.25F, 0.0F, 0.65F, 0.75F, 0.5F, 0.66F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		
		renderblocks.setRenderBounds(0.25F, 0.0F, 0.35F, 0.75F, 0.5F, 0.36F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		
		renderblocks.setRenderBounds(0.25F, 0.0F, 0.35F, 0.26F, 0.5F, 0.65F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		
		renderblocks.setRenderBounds(0.74F, 0.0F, 0.35F, 0.75F, 0.5F, 0.65F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		
		renderblocks.setRenderBounds(0.25F, 0.5F, 0.35F, 0.75F, 0.51F, 0.66F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		
		//Handle
		renderblocks.setRenderBounds(0.42F, 0.51F, 0.49F, 0.58F, 0.6F, 0.52F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		
		//Bell
		renderblocks.setRenderBounds(0.49F, 0.2F, 0.49F, 0.52F, 0.5F, 0.52F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		
		renderblocks.setRenderBounds(0.47F, 0.1F, 0.47F, 0.54F, 0.2F, 0.54F);
		renderStandardInvBlock(renderblocks, var8, block, i);		
		block.setUnlocalizedName("15");
	}
}
