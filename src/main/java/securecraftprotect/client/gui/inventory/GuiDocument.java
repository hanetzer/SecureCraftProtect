package securecraftprotect.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import securecraftprotect.common.inventory.ContainerDocument;

import static org.lwjgl.opengl.GL11.glColor4f;

public class GuiDocument extends GuiContainer
{
	private ResourceLocation texture;

	public GuiDocument(InventoryPlayer inventory, World world, int x, int y,
					   int z)
	{
		super(new ContainerDocument(inventory, world, x, y, z));
		this.texture = new ResourceLocation("scp:textures/gui/document.png");
	}

	protected void drawGuiContainerForegroundLayer()
	{
		fontRendererObj.drawString("", 62, 6, 0x404040);
		fontRendererObj.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
	{
		glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		y = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(y, k, 0, 0, xSize, ySize);
	}
}
