package securecraftprotect.client.renderer.tile;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import securecraftprotect.client.model.ModelTileLightBulb;
import securecraftprotect.common.tileentity.TileEntityLightBulb;

public class RenderTileLightBulb extends TileEntitySpecialRenderer
{
    ModelTileLightBulb lightBulb = new ModelTileLightBulb();
    
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 2.1F, (float) z + 0.5F);
        TileEntityLightBulb st = (TileEntityLightBulb) te;
        int block = te.getBlockMetadata();
        
        ResourceLocation blockTexture = new ResourceLocation("scp", "textures/tileentities/light_" + block + ".png");
        Minecraft.getMinecraft().renderEngine.bindTexture(blockTexture);
        
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        GL11.glTranslatef(0.0F, -0.35F, 0.0F);
        lightBulb.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
}
