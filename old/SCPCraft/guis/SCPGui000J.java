package SCPCraft.guis;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import SCPCraft.SCPInventory000J;
import SCPCraft.containerslots.SCPCraftingInventoryRecipeBookCB;

public class SCPGui000J extends GuiContainer
{
    private SCPInventory000J recipes;
    private EntityPlayer player;
    public static final int BORDER = 4;
    public static final int ROWS = 4;
    public static final int COLUMNS = 3;
    public static final int ENTRIES = ROWS * COLUMNS;
    public static final int GRIDX = 5;
    public static final int GRIDY = 6;
    public static final int CRAFTX = 99;
    public static final int CRAFTY = 24;
    public static final int IMGWIDTH = 176;
    public static final int IMGHEIGHT = 166;
    public static final int IMGMIDX = 29;
    public static final int IMGMIDY = 15;
    public static final int MIDWIDTH = 117;
    public static final int MIDHEIGHT = 55;
    private final SCPInventory000J inv;

    public SCPGui000J(SCPInventory000J var1, EntityPlayer pl)
    {
        super(new SCPCraftingInventoryRecipeBookCB(var1));
        player = pl;
        this.inv = var1;
        this.xSize = 117 * COLUMNS + 8;
        this.ySize = 55 * ROWS + 8;
        this.recipes = this.inv;
    }
    public void initGui()
    {
        int h = (height - 166)/2;
        int w = (width - 176)/2;
        buttonList.clear();
		buttonList.add(new GuiButton(1, w + 210, h - 35, 30, 20, "Quit"));
		buttonList.add(new GuiButton(2, w + 265, h + 75, 30, 20, "--->"));
		buttonList.add(new GuiButton(3, w - 120, h + 75, 30, 20, "<---"));
        super.initGui();
    }

    protected void drawGuiContainerForegroundLayer()
    {
        String var1 = this.inv.getInvName();
        this.fontRenderer.drawString(var1, this.xSize - this.fontRenderer.getStringWidth(var1) - 3, 6, 4210752);
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        if (par3 == 0)
        {
            for (int var4 = 0; var4 < this.buttonList.size(); ++var4)
            {
                GuiButton var5 = (GuiButton)this.buttonList.get(var4);

                if (var5.mousePressed(this.mc, par1, par2))
                {
                    this.mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
                    this.actionPerformed(var5);
                }
            }
        }
    }
    
	public void actionPerformed(GuiButton button)
	{
		if(button.id == 1)
		{
			this.player.closeScreen();
		}
		if(button.id == 2)
		{
			if((int)(this.recipes.getIndex()/12 + 1) != this.recipes.totalPages)this.recipes.incIndex();
		}
		if(button.id == 3)
		{
			if((int)(this.recipes.getIndex()/12 + 1) != 1)this.recipes.decIndex();
		}
	}

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        int var4 = this.mc.renderEngine.getTexture("/SCPCraft/textures/gui/SCP000J.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //this.mc.renderEngine.bindTexture(var4);
        this.mc.renderEngine.bindTexture("/SCPCraft/textures/gui/SCP000J.png");
        int var5 = this.width - this.xSize >> 1;
        int var6 = this.height - this.ySize >> 1;
        int var7 = Mouse.getDWheel();
        int h = (height - 166)/2;
        int w = (width - 176)/2;        
        
        if(var7 < 0)if((int)(this.recipes.getIndex()/12 + 1) != 1)this.recipes.decIndex();
        if(var7 > 0)if((int)(this.recipes.getIndex()/12 + 1) != this.recipes.totalPages)this.recipes.incIndex();

        int var8 = (this.xSize - 8) / COLUMNS;
        int var9;

        for (var9 = 0; var9 < COLUMNS; ++var9)
        {
            this.drawTexturedModalRect(var5 + 4 + var9 * var8, var6, 4, 0, var8, 4);
            this.drawTexturedModalRect(var5 + 4 + var9 * var8, var6 + this.ySize - 4, 4, 162, var8, 4);
        }

        var9 = (this.ySize - 8) / ROWS;
        int var10;

        for (var10 = 0; var10 < ROWS; ++var10)
        {
            this.drawTexturedModalRect(var5, var6 + 4 + var10 * var9, 0, 4, 4, var9);
            this.drawTexturedModalRect(var5 + this.xSize - 4, var6 + 4 + var10 * var9, 172, 4, 4, var9);
        }

        this.drawTexturedModalRect(var5, var6, 0, 0, 4, 4);
        this.drawTexturedModalRect(var5 + 4 + 117 * COLUMNS, var6, 172, 0, 4, 4);
        this.drawTexturedModalRect(var5, var6 + this.ySize - 4, 0, 162, 4, 4);
        this.drawTexturedModalRect(var5 + this.xSize - 4, var6 + this.ySize - 4, 172, 162, 4, 4);

        for (var10 = 0; var10 < COLUMNS; ++var10)
        {
            for (int var11 = 0; var11 < ROWS; ++var11)
            {
                this.drawTexturedModalRect(var5 + 4 + var10 * 117, var6 + 4 + var11 * 55, 29, 15, 117, 55);
            }
        }
		drawCenteredString(fontRenderer, "SCP-000J", width / 2 + 20, h - 25, 0xffffff);
		drawCenteredString(fontRenderer, Integer.toString(recipes.getIndex()/12 + 1) + "/" + Integer.toString(recipes.totalPages), width / 2 + 20, h + 185, 0xffffff);
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return true;
    }
}
