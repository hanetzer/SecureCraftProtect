package SCPCraft.renders;
 
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

import SCPCraft.entities.SCPEntityReal682;
import SCPCraft.models.SCPModelReal682;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SCPRender682 extends RenderLiving
{
    private int field_77068_a;
    public static float scale;
    public static SCPEntityReal682 entity682;

    public SCPRender682(SCPModelReal682 scpModelReal682, float f)
    {
        super(new SCPModelReal682(), 0.5F);
        this.field_77068_a = ((SCPModelReal682)this.mainModel).func_78104_a();
        this.scale = f;
    }
    
    /**
     * Applies the scale to the transform matrix
     */
    protected void preRenderScale(SCPEntityReal682 par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    public void renderSCP682(SCPEntityReal682 entity, double par2, double par4, double par6, float par8, float par9)
    {
    	entity682 = entity;
        int var10 = ((SCPModelReal682)this.mainModel).func_78104_a();

        if (var10 != this.field_77068_a)
        {
            this.field_77068_a = var10;
            this.mainModel = new SCPModelReal682();
        }
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
    
    protected void renderDragonModel(SCPEntityReal682 par1SCPEntityReal682, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        if (par1SCPEntityReal682.deathTicks > 0)
        {
            float var8 = (float)par1SCPEntityReal682.deathTicks / 200.0F;
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glAlphaFunc(GL11.GL_GREATER, var8);
            this.loadDownloadableImageTexture(par1SCPEntityReal682.skinUrl, "/SCPCraft/textures/mobs/Bosses/682/682Shuffle.png");
            this.mainModel.render(par1SCPEntityReal682, par2, par3, par4, par5, par6, par7);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
            GL11.glDepthFunc(GL11.GL_EQUAL);
        }
        this.loadDownloadableImageTexture(par1SCPEntityReal682.skinUrl, par1SCPEntityReal682.getTexture());
        this.mainModel.render(par1SCPEntityReal682, par2, par3, par4, par5, par6, par7);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
    }
    
    protected void renderModel(EntityLiving par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.renderDragonModel((SCPEntityReal682)par1EntityLiving, par2, par3, par4, par5, par6, par7);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSCP682((SCPEntityReal682)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSCP682((SCPEntityReal682)par1Entity, par2, par4, par6, par8, par9);
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderScale((SCPEntityReal682)par1EntityLiving, par2);
    }
}
