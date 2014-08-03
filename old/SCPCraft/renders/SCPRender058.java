package SCPCraft.renders;
 
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

import SCPCraft.entities.SCPEntity058;
import SCPCraft.models.SCPModel058;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SCPRender058 extends RenderLiving
{
    private int field_77068_a;
    public static float scale = 0.6F;
    
    public static SCPEntity058 entity682;

    public SCPRender058(SCPModel058 scpModel058, float f)
    {
        super(new SCPModel058(), 0.5F);
    }
    
    /**
     * Applies the scale to the transform matrix
     */
    protected void preRenderScale(SCPEntity058 par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    public SCPEntity058 entity;
    
    public void renderSCP058(SCPEntity058 entity, double par2, double par4, double par6, float par8, float par9)
    {	
    	if(entity.beat > 0)
    	{
    		this.scale += 0.002F;
    	}
    	
    	if(entity.beat <= 20)
    	{
    		this.scale = 0.6F;
    	}
    	
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSCP058((SCPEntity058)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSCP058((SCPEntity058)par1Entity, par2, par4, par6, par8, par9);
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderScale((SCPEntity058)par1EntityLiving, par2);
    }
}
