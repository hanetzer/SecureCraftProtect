package securecraftprotect.client.gui.inventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import securecraftprotect.common.tileentity.TileEntityEventBlock;

public class GuiEventBlock extends GuiScreen
{
    private GuiButton texture;
    private TileEntityEventBlock block;
    private String textureName;
    
    public GuiEventBlock(EntityPlayer player, World world, int x, int y, int z)
    {
        super();
        block = ((TileEntityEventBlock) world.getTileEntity(x, y, z));
        textureName = block.getTextureName();
    }
    
    public void initGui()
    {
        buttonList.clear();
        buttonList.add(new GuiButton(1, width - 70, 10, 50, 20, "Quit"));
        buttonList.add(new GuiButton(2, 125, 25, 110, 20, "Switch Block Texture"));
        buttonList.add(new GuiButton(3, width - 150, 10, 75, 20, "Save Settings"));
    }
    
    protected void keyTyped(char c, int i)
    {
        
    }
    
    protected void mouseClicked(int i, int j, int k)
    {
        super.mouseClicked(i, j, k);
    }
    
    public int esc = Keyboard.KEY_ESCAPE;
    
    public void actionPerformed(GuiButton button)
    {
        super.actionPerformed(button);
        switch(button.id)
        {
            case 1: this.mc.thePlayer.closeScreen(); break;
            case 2: 
                if(textureName.equals("North")) textureName = "South";
                else if(textureName.equals("South")) textureName = "East";
                else if(textureName.equals("East")) textureName = "West";
                else if(textureName.equals("West")) textureName = "Up";
                else if(textureName.equals("Up")) textureName = "Down";
                else if(textureName.equals("Down")) textureName = "North";
                block.isDirty = true;
                block.markDirty();
                break;
            case 3: 
                block.setSideName(textureName); 
                block.isDirty = true;
                block.markDirty();
                this.mc.thePlayer.closeScreen();
                break;
            default:;
        }
    }
    
    public void drawScreen(int x, int y, float z)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Event Block", this.width / 2, 5, 16777215);
        this.drawString(this.fontRendererObj, "Block Texture: ", 20, 30, 16777215);
        this.drawString(this.fontRendererObj, textureName, 95, 30, 0xffff00);
        super.drawScreen(x, y, z);
    }
}
