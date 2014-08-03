package SCPCraft.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import SCPCraft.containerslots.SCPContainer294;
import SCPCraft.tileentities.SCPTileEntity294;

public class SCPGuiSCP294 extends GuiContainer
{
    private SCPTileEntity294 furnaceInventory;

    public SCPGuiSCP294(InventoryPlayer par1InventoryPlayer, SCPTileEntity294 par2TileEntity294)
    {
        super(new SCPContainer294(par1InventoryPlayer, par2TileEntity294));
        furnaceInventory = par2TileEntity294;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(StatCollector.translateToLocal(""), 60, 6, 0x404040);
        fontRenderer.drawString(StatCollector.translateToLocal(""), 8, (ySize - 96) + 2, 0x404040);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int i = mc.renderEngine.getTexture("/SCPCraft/textures/gui/294GUI.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture("/SCPCraft/textures/gui/294GUI.png");
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);

        if (furnaceInventory.isBurning())
        {
            int l = furnaceInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(j + 56, (k + 36 + 12) - l, 176, 12 - l, 14, l + 2);
        }

        int i1 = furnaceInventory.getCookProgressScaled(24);
        drawTexturedModalRect(j + 79, k + 34, 176, 14, i1 + 1, 16);
    }
}
