package SCPCraft;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class SCPClientTickHandler implements ITickHandler
{
	Minecraft mc = FMLClientHandler.instance().getClient();
	EntityPlayer player;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) 
	{
		if (type.equals(EnumSet.of(TickType.RENDER)))
		{
			float ticks = ((Float)tickData[0]).floatValue();
			onRenderTickStart(ticks);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		{
			this.player = (EntityPlayer)tickData[0];
		}
		else if (type.equals(EnumSet.of(TickType.RENDER)))
		{
			float ticks = ((Float)tickData[0]).floatValue();
			onRenderTickEnd(ticks);
			GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
			if (guiscreen != null && ModLoader.getMinecraftInstance().thePlayer != null)
			{
				onTickInGUI(guiscreen);
			} 
		}
		else if (type.equals(EnumSet.of(TickType.CLIENT)))
		{
			if(ModLoader.getMinecraftInstance().thePlayer != null){onTickInGame();}
		}
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.RENDER, TickType.CLIENT, TickType.PLAYER, TickType.WORLD);
		// In my testing only RENDER, CLIENT, & PLAYER did anything on the client side.
		// Read 'cpw.mods.fml.common.TickType.java' for a full list and description of available types
	}

	@Override
	public String getLabel() { return null; }

	private boolean keyStates[];

	/**Key checking function**/
	public boolean checkKey(int i)
	{
		keyStates = new boolean[256];
		if(ModLoader.getMinecraftInstance().currentScreen != null)
		{
			return false;
		}
		if(Keyboard.isKeyDown(i) != keyStates[i])
		{
			return keyStates[i] = !keyStates[i];
		} else
		{
			return false;
		}
	}

	public void onRenderTickStart(float ticks)
	{

	}

	public void onRenderTickEnd(float ticks)
	{
		ScaledResolution var5 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		int var6 = var5.getScaledWidth();
		int var7 = var5.getScaledHeight();

		if(mc.currentScreen == null)
		{
			ItemStack var9 = this.mc.thePlayer.inventory.armorItemInSlot(3);
			
			if (this.mc.gameSettings.thirdPersonView == 0 && var9 != null && var9.itemID == mod_SCP.GasMask.itemID)
	        {
	            renderGasMaskBlur(var6, var7);
	        }
			
	        if(this.mc.thePlayer.getBlink() >= 0 && this.mc.thePlayer.getBlink() <= 10 && mod_SCP.isActive)
	        {
	        	renderBlink(var6, var7);
	        }
		}
	}

	public void onTickInGUI(GuiScreen gui)
	{
		
	}

	public void onTickInGame()
	{
		
	}
	
	private void renderBlink(int par1, int par2)
    {
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("%blur%/SCPCraft/textures/Blink.png"));
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, par2, -90D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(par1, par2, -90D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(par1, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
	
	private void renderGasMaskBlur(int par1, int par2)
    {
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("%blur%/SCPCraft/textures/GasmaskOverlay.png"));
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, par2, -90D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(par1, par2, -90D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(par1, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
	
	public static void drawRect(int par0, int par1, int par2, int par3, int par4)
    {
        int var5;

        if (par0 < par2)
        {
            var5 = par0;
            par0 = par2;
            par2 = var5;
        }

        if (par1 < par3)
        {
            var5 = par1;
            par1 = par3;
            par3 = var5;
        }

        float var10 = (float)(par4 >> 24 & 255) / 255.0F;
        float var6 = (float)(par4 >> 16 & 255) / 255.0F;
        float var7 = (float)(par4 >> 8 & 255) / 255.0F;
        float var8 = (float)(par4 & 255) / 255.0F;
        Tessellator var9 = Tessellator.instance;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(var6, var7, var8, var10);
        var9.startDrawingQuads();
        var9.addVertex((double)par0, (double)par3, 0.0D);
        var9.addVertex((double)par2, (double)par3, 0.0D);
        var9.addVertex((double)par2, (double)par1, 0.0D);
        var9.addVertex((double)par0, (double)par1, 0.0D);
        var9.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }
}