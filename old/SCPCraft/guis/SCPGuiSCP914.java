package SCPCraft.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import SCPCraft.containerslots.SCPContainer914;
import SCPCraft.tileentities.SCPTileEntity914;

public class SCPGuiSCP914 extends GuiContainer
{
    private SCPTileEntity914 SCP914Inventory;

    public SCPGuiSCP914(InventoryPlayer par1InventoryPlayer, SCPTileEntity914 par2TileEntity914)
    {
        super(new SCPContainer914(par1InventoryPlayer, par2TileEntity914));
        this.SCP914Inventory = par2TileEntity914;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
    	this.fontRenderer.drawString(StatCollector.translateToLocal(""), 60, 6, 0x404040);
    	this.fontRenderer.drawString(StatCollector.translateToLocal(""), 8, (ySize - 96) + 2, 0x404040);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int i = mc.renderEngine.getTexture("/SCPCraft/textures/gui/914GUI.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/SCPCraft/textures/gui/914GUI.png");
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        this.drawTexturedModalRect(j, k, 0, 0, xSize, ySize);

        int i1 = this.SCP914Inventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(j + 76, k + 40, 176, 14, i1 + 1, 16);
    }
}
