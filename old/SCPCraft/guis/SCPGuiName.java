package SCPCraft.guis;

import java.awt.image.BufferedImage;
import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.src.ModLoader;

import org.lwjgl.opengl.GL11;

import SCPCraft.entities.SCPEntity629;

public class SCPGuiName extends GuiScreen
{
	private BufferedImage img;
	private int imgID = 1000;
	public SCPGuiName(SCPEntity629 entity)
	{
		mob = entity;
	}

	private GuiTextField textfield;
	public SCPEntity629 mob;

	public void initGui()
	{
		try
		{
			img = ModLoader.loadImage(mc.renderEngine, "/SCPCraft/textures/gui/Naming.png");
			mc.renderEngine.setupTexture(img, imgID);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		buttonList.clear();
		buttonList.add(new GuiButton(1, width / 2 - 49, height / 2 + 20, 70, 20, "Enter"));
		textfield = new GuiTextField(fontRenderer, width / 2 - 87, height / 2 - 10, 150, 20);
		textfield.setFocused(false);
		textfield.setMaxStringLength(16);

	}
	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			mob.Name = textfield.getText();
			mc.displayGuiScreen(null);
		}
	}
	protected void keyTyped(char c, int i)
	{
		super.keyTyped(c, i);
		textfield.textboxKeyTyped(c, i);
	}
	protected void mouseClicked(int i, int j, int k)
	{
		super.mouseClicked(i, j, k);
		textfield.mouseClicked(i, j, k);
	}
	public boolean doesGuiPauseGame()
	{
		return true;
	}
	public void onGuiClosed()
	{
	}
	public void drawScreen(int i, int j, float f)
	{
		drawDefaultBackground();
		int k = width / 2 - 100;
		int l = height  / 2 - 40;
		try
		{
			int tempvar = mc.renderEngine.getTexture("/SCPCraft/textures/gui/Naming.png");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.renderEngine.bindTexture("/SCPCraft/textures/gui/Naming.png");
			drawTexturedModalRect(k, l, 0, 0, 176, 166);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		textfield.drawTextBox();
		drawCenteredString(fontRenderer, "Enter the Name of your Mob", width / 2 - 10, height / 2 - 35, 0xffffff);
		super.drawScreen(i, j, f);
	}
}