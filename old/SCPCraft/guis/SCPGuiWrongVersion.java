package SCPCraft.guis;

import java.io.IOException;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import SCPCraft.SCPThread;

public class SCPGuiWrongVersion extends GuiScreen
{
	public static boolean isRightVersion;

	Random rand = new Random();

	public SCPGuiWrongVersion(World world, Minecraft minecraft, EntityPlayer player, String par1Str)
	{
	}

	public void initGui()
	{
		Minecraft mc = ModLoader.getMinecraftInstance();
		buttonList.clear();
		buttonList.add(new GuiButton(1, width - 110, height / 30, 80, 20, "Continue"));
		Keyboard.enableRepeatEvents(true);
		buttonList.add(new GuiButton(2, width / 2 - 22, height / 2 + 40, 50, 20, "Link"));
	}

	public int esc = Keyboard.KEY_ESCAPE;
	public void actionPerformed(GuiButton button)
	{
		if(button.id == 1)
		{
			EntityPlayer player = ModLoader.getMinecraftInstance().thePlayer;
			World par1World = ModLoader.getMinecraftInstance().theWorld;
			this.mc.displayGuiScreen(new GuiMainMenu());
		}
		if(button.id == 2)
		{
			try
			{
				SCPThread.main(null);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if(Keyboard.isKeyDown(esc))
		{
			if(this.isRightVersion)
			{
				this.mc.thePlayer.closeScreen();
			}
			else if(!this.isRightVersion)
			{
				EntityPlayer player = ModLoader.getMinecraftInstance().thePlayer;
				World par1World = ModLoader.getMinecraftInstance().theWorld;
				this.mc.displayGuiScreen(new GuiMainMenu());
			}
		}
	}

	protected int xSize = 700;
	protected int ySize = 460;

	public void drawScreen(int i, int j, float f)
	{
		this.drawDefaultBackground();
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);     

		if(!this.isRightVersion)
		{
			drawCenteredString(fontRenderer, "You are using the wrong Forge version for SCPCraft.", width / 2, 60, 0xffffff);
			drawCenteredString(fontRenderer, "Go to the forum to see which version is needed.", width / 2, 100, 0xffffff);
		}
		super.drawScreen(i, j, f);
	}
}