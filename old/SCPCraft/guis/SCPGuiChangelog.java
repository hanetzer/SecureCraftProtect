package SCPCraft.guis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import SCPCraft.mod_SCP;

public class SCPGuiChangelog extends GuiScreen
{
	public static boolean isClosed = false;
	private static final Random rand = new Random();
	private float updateCounter = 0.0F;
	private String Change = "Where is Changelog.txt?";

	public SCPGuiChangelog()
	{
		BufferedReader var1 = null;

		try
		{
			ArrayList var2 = new ArrayList();
			var1 = new BufferedReader(new InputStreamReader(SCPGuiChangelog.class.getResourceAsStream("/SCPCraft/changelog.txt"), Charset.forName("UTF-8")));
			String var3;

			while ((var3 = var1.readLine()) != null)
			{
				var3 = var3.trim();

				if (var3.length() > 0)
				{
					var2.add(var3);
				}
			}

			do
			{
				this.Change = (String)var2.get(rand.nextInt(var2.size()));
			}
			while (this.Change.hashCode() == 125780783);
		}
		catch (IOException var12)
		{
			;
		}
		finally
		{
			if (var1 != null)
			{
				try
				{
					var1.close();
				}
				catch (IOException var11)
				{
					;
				}
			}
		}

		this.updateCounter = rand.nextFloat();
	}

	public void initGui()
	{
		buttonList.clear();
		if(!isClosed)
		{
			buttonList.add(new GuiButton(1, width / 2 - 37, height / 2 + 48, 70, 20, "Continue"));
		}
	}

	public int esc = Keyboard.KEY_ESCAPE;
	public void actionPerformed(GuiButton button)
	{
		if(button.id == 1)
		{
			EntityPlayer player = ModLoader.getMinecraftInstance().thePlayer;
			World par1World = ModLoader.getMinecraftInstance().theWorld;
			this.mc.displayGuiScreen(new GuiMainMenu());
			this.isClosed = true;
		}
		if(Keyboard.isKeyDown(esc))
		{
			EntityPlayer player = ModLoader.getMinecraftInstance().thePlayer;
			World par1World = ModLoader.getMinecraftInstance().theWorld;
			this.mc.displayGuiScreen(new GuiMainMenu());
			this.isClosed = true;
		}
	}

	public void drawScreen(int i, int j, float f)
	{
		if(!isClosed)
		{
			int k = width / 2 - 130;
			int l = height  / 2 - 100;
			this.drawDefaultBackground();
			int tempvar = mc.renderEngine.getTexture("/SCPCraft/textures/gui/Changelog.png");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.renderEngine.bindTexture("/SCPCraft/textures/gui/Changelog.png");
			drawTexturedModalRect(k, l, 0, 0, 256, 166);
			this.drawString(fontRenderer, Change, width / 2 - 110, height / 2 - 20, 0xffffff);
			drawCenteredString(fontRenderer, mod_SCP.SCPCraftVersion + " Changelog", width / 2 - 1, height / 2 - 88, 0xffffff);
		}
		super.drawScreen(i, j, f);
	}
}