package SCPCraft.guis;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import SCPCraft.SCPPotion;
import SCPCraft.items.SCPItem1025;

public class SCPGui1025 extends GuiScreen
{
	Random rand = new Random();
	EntityPlayer player;
	int Disease = rand.nextInt(8);
	public SCPGui1025(World world, Minecraft minecraft, EntityPlayer player){}
	public SCPGui1025(SCPItem1025 scpItem1025, EntityPlayer pl)
	{
		player = pl;
	}
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(new GuiButton(1, width - 110, height / 30, 50, 20, "Close"));
		Keyboard.enableRepeatEvents(false);
	}

	public void actionPerformed(GuiButton button)
	{
		if(button.id == 1)
		{
			getDisease();
			this.player.closeScreen();
		}
	}
	protected void keyTyped(char par1, int par2)
	{
		if (par2 == 1)
		{
			getDisease();
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
	}
	protected int xSize = 176;
	protected int ySize = 166;

	public void drawScreen(int i, int j, float f)
	{
		//this.drawDefaultBackground();
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
		drawCenteredString(fontRenderer, "SCP-1025", width / 2, 15, 0xffffff);
		if(Disease == 0)drawCenteredString(fontRenderer, "Blindness", width / 2, 50, 0xffffff);
		if(Disease == 1)drawCenteredString(fontRenderer, "Nausea", width / 2, 50, 0xffffff);
		if(Disease == 2)drawCenteredString(fontRenderer, "Food Poisoning", width / 2, 50, 0xffffff);
		if(Disease == 3)drawCenteredString(fontRenderer, "Headache", width / 2, 50, 0xffffff);
		if(Disease == 4)drawCenteredString(fontRenderer, "Gonorrhea", width / 2, 50, 0xffffff);
		if(Disease == 5)drawCenteredString(fontRenderer, "Anorexia Nervosa", width / 2, 50, 0xffffff);
		if(Disease == 6)drawCenteredString(fontRenderer, "Common Cold", width / 2, 50, 0xffffff);
		if(Disease == 7)drawCenteredString(fontRenderer, "Stomach Pain", width / 2, 50, 0xffffff);
		super.drawScreen(i, j, f);
	}

	public void getDisease()
	{
		if(player != null){
			if(Disease == 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20 * 10, 2));
			}
			if(Disease == 1)
			{
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20 * 10, 2));
			}
			if(Disease == 2)
			{
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20 * 10, 2));
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 10, 2));
			}
			if(Disease == 3)
			{
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 20 * 10, 2));
			}
			if(Disease == 4)
			{
				player.setFire(10);
			}
			if(Disease == 5)
			{
				player.addExhaustion(20F);
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20 * 10, 2));
			}
			if(Disease == 6)
			{
				player.addPotionEffect(new PotionEffect(SCPPotion.shake.id, 20 * 5, 1));
			}
			if(Disease == 7)
			{
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20 * 5, 1));
				player.addPotionEffect(new PotionEffect(Potion.harm.id, 20 * 3, 1));
			}
			player.updatePotionEffects();
		}
	}
}