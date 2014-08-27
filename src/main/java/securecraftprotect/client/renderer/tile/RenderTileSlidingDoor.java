package securecraftprotect.client.renderer.tile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import securecraftprotect.client.model.ModelTileSlidingDoor;
import securecraftprotect.common.tileentity.TileEntitySlidingDoor;

public class RenderTileSlidingDoor extends TileEntitySpecialRenderer
{
    ModelTileSlidingDoor door = new ModelTileSlidingDoor();
    
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

        TileEntitySlidingDoor tileDoor = (TileEntitySlidingDoor)te;
        ResourceLocation blockTexture = new ResourceLocation("scp", "textures/tileentities/slidingDoor.png");
        Minecraft.getMinecraft().renderEngine.bindTexture(blockTexture);
        
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        if(tileDoor.open) GL11.glScalef(0.9F, 0.999F, 1F);
        if(tileDoor.getBlockMetadata() == 1) GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
        door.render((Entity) null, tileDoor.doorMovement, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
}
