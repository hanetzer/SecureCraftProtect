package SCPCraft.guis;

import java.awt.image.BufferedImage;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import SCPCraft.containerslots.SCPContainerButler;
import SCPCraft.entities.SCPEntity106;
import SCPCraft.entities.SCPEntityButler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SCPGuiButler extends GuiContainer
{
    /** Instance of IMerchant interface. */
    private GuiTextField textfield;
    
    public Item aitem[] = {
    		Item.ingotIron, Item.arrow, Item.flint, Item.cake, Item.appleGold,
    		Item.appleRed, Item.cauldron, Item.axeDiamond, Item.shears, Item.wheat,
    		Item.pumpkinPie, Item.swordWood, Item.shovelDiamond, Item.spiderEye, Item.speckledMelon,
    		Item.snowball, Item.bone, Item.silk, Item.flintAndSteel, Item.swordDiamond
    	};
    	
    	private BufferedImage img;
    	private int imgID = 1000;

    	public String order;
    	public SCPEntityButler mob;
    	private World world;

    public SCPGuiButler(InventoryPlayer par1InventoryPlayer, SCPEntityButler par2IMerchant, World par3World)
    {
        super(new SCPContainerButler(par1InventoryPlayer, par2IMerchant, par3World));
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture("/gui/trading.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //this.mc.renderEngine.bindTexture(var4);
        this.mc.renderEngine.bindTexture("/gui/trading.png");
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }

    public void initGui()
	{
		try
		{
			img = ModLoader.loadImage(mc.renderEngine, "/blox/Naming.png");
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
		super.initGui();

	}
    
    public SCPEntityButler butler;
    
	protected void actionPerformed(GuiButton guibutton)
	{
		Item aitem1[] = aitem;
		int i = aitem1.length;
		
		EntityPlayer player = this.world.getClosestPlayerToEntity(butler, 16.0D);
		
		if(guibutton.id == 1)
		{
			this.order = textfield.getText();
			for(int j = 0; j < i; j++)
			{
				Item item = aitem1[j];
				String name = aitem[j].getUnlocalizedName();
				if(this.order.contains(name.substring(5)))
				{
					player.inventory.addItemStackToInventory(new ItemStack(item));
				}
			}	
			if(this.order.contains("iron"))
			{
				player.inventory.addItemStackToInventory(new ItemStack(Item.ingotIron));
			}
			if(this.order.contains("TNT"))
			{
				world.spawnEntityInWorld(new EntityTNTPrimed(world, mob.posX, mob.posY + 4, mob.posZ, player));
			}
			if(this.order.contains("SCP-106"))
			{	
				SCPEntity106 SCP106 = new SCPEntity106(world);
				spawnCreature(world, SCP106, mob.posX, mob.posY + 4, mob.posZ);
			}

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
		super.onGuiClosed();
	}
	
	public void drawScreen(int i, int j, float f)
	{
		drawDefaultBackground();
		int k = width / 2 - 100;
		int l = height  / 2 - 40;
		try
		{
			int tempvar = mc.renderEngine.getTexture("/blox/Naming.png");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.renderEngine.bindTexture("/blox/Naming.png");
			drawTexturedModalRect(k, l, 0, 0, 176, 166);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		textfield.drawTextBox();
		drawCenteredString(fontRenderer, "\u00a7lMr. Deeds: \u00a7rWhat would you like?", width / 2 - 10, height / 2 - 35, 0xffffff);
		
	}
	
	public static boolean spawnCreature(World par0World, Entity entity, double par2, double par4, double par6)
	{
		entity.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
		entity.setPositionAndRotation(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
		entity.onUpdate();
		par0World.spawnEntityInWorld(entity);
		((EntityLiving)entity).playLivingSound();

		return entity != null;
	}
}
