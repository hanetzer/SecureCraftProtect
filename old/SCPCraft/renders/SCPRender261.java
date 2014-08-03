package SCPCraft.renders;
 
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import SCPCraft.models.SCPModel261;
import SCPCraft.tileentities.SCPTileEntity261;
 
public class SCPRender261 extends TileEntitySpecialRenderer
{
 
    public SCPRender261()
    {
        aModel = new SCPModel261();
    }
       
    public void renderAModelAt(SCPTileEntity261 tileentity1, double d, double d1, double d2, float f)
    {  
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        int var11 = tileentity1.getBlockMetadata();
        if(var11 == 2)GL11.glRotatef(180, 0, 0, 90);
        if(var11 == 0)GL11.glRotatef(180, 360, 0, 0);
        if(var11 == 1)GL11.glRotatef(180, 90, 0, 90);
        if(var11 == 3)GL11.glRotatef(180, -90, 0, 90);
        bindTextureByName("/SCPCraft/textures/mobs/261.png");
        GL11.glPushMatrix();
        aModel.renderModel(0.0625F);
        GL11.glPopMatrix();    
        GL11.glPopMatrix();                    
    }
 
    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2,
            float f)
    {
        renderAModelAt((SCPTileEntity261)tileentity, d, d1, d2, f);
    }
 
    private SCPModel261 aModel;
}