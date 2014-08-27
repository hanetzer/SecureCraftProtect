package securecraftprotect.client.gui.inventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import securecraftprotect.SCP;
import securecraftprotect.common.handlers.packet.EventBlockPacket;
import securecraftprotect.common.tileentity.TileEntityEventBlock;

public class GuiEventBlock extends GuiScreen
{
    private GuiButton texture;
    private TileEntityEventBlock block;
    private String direction;
    private int entityID;
    
    public GuiEventBlock(EntityPlayer player, World world, int x, int y, int z)
    {
        super();
        block = ((TileEntityEventBlock) world.getTileEntity(x, y, z));
        direction = block.getDirection();
        entityID = block.getEntityID();
    }
    
    public void initGui()
    {
        buttonList.clear();
        buttonList.add(new GuiButton(1, width - 70, 10, 50, 20, "Quit"));
        buttonList.add(new GuiButton(2, 125, 25, 110, 20, "Switch Block Texture"));
        buttonList.add(new GuiButton(3, width - 150, 10, 75, 20, "Save Settings"));
        buttonList.add(new GuiButton(4, 125, 45, 110, 20, "Change Entity"));
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
                if(direction.equals("North")) direction = "South";
                else if(direction.equals("South")) direction = "East";
                else if(direction.equals("East")) direction = "West";
                else if(direction.equals("West")) direction = "Up";
                else if(direction.equals("Up")) direction = "Down";
                else if(direction.equals("Down")) direction = "North";
                break;
            case 3: 
                SCP.netWrapper.sendToServer(new EventBlockPacket(block, direction, entityID));
                this.mc.thePlayer.closeScreen();
                break;
            case 4: 
                if((entityID + 1) < EntityList.IDtoClassMapping.size())
                {
                    if(EntityList.getClassFromID(entityID + 1) != null) entityID++;
                    else while(EntityList.getClassFromID(entityID + 1) == null) entityID++;
                }
                else entityID = 0;
                break;
            default:;
        }
    }
    
    public void drawScreen(int x, int y, float z)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Event Block", this.width / 2, 5, 16777215);
        this.drawString(this.fontRendererObj, "Block Texture: ", 20, 30, 16777215);
        this.drawString(this.fontRendererObj, "Entity: ", 20, 50, 16777215);
        this.drawString(this.fontRendererObj, direction, 95, 30, 0xffff00);
        this.drawString(this.fontRendererObj, EntityList.getStringFromID(entityID), 55, 50, 0xffff00);
        super.drawScreen(x, y, z);
    }
}
