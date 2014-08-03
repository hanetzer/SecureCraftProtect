package SCPCraft.renders;

import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

import SCPCraft.entities.SCPEntity015Boss;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SCPRender015Boss extends RenderLiving
{
    private int field_77068_a;
    private float scale;
    public static SCPEntity015Boss entityPipe;

    public SCPRender015Boss(ModelBlaze modelBlaze, float f)
    {
        super(new ModelBlaze(), 0.5F);
        this.field_77068_a = ((ModelBlaze)this.mainModel).func_78104_a();
        this.scale = f;
    }
    
    /**
     * Applies the scale to the transform matrix
     */
    protected void preRenderScale(SCPEntity015Boss par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    public void renderBlaze(SCPEntity015Boss entity, double par2, double par4, double par6, float par8, float par9)
    {
    	entityPipe = entity;
        int var10 = ((ModelBlaze)this.mainModel).func_78104_a();

        if (var10 != this.field_77068_a)
        {
            this.field_77068_a = var10;
            this.mainModel = new ModelBlaze();
        }
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
    
    protected void renderDragonModel(SCPEntity015Boss par1SCPEntity015Boss, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        if (par1SCPEntity015Boss.deathTicks > 0)
        {
            float var8 = (float)par1SCPEntity015Boss.deathTicks / 200.0F;
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glAlphaFunc(GL11.GL_GREATER, var8);
            this.loadDownloadableImageTexture(par1SCPEntity015Boss.skinUrl, "/SCPCraft/textures/mobs/Bosses/015/015BossShuffle.png");
            this.mainModel.render(par1SCPEntity015Boss, par2, par3, par4, par5, par6, par7);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
            GL11.glDepthFunc(GL11.GL_EQUAL);
        }
        this.loadDownloadableImageTexture(par1SCPEntity015Boss.skinUrl, par1SCPEntity015Boss.getTexture());
        this.mainModel.render(par1SCPEntity015Boss, par2, par3, par4, par5, par6, par7);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
    }
    
    protected void renderModel(EntityLiving par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.renderDragonModel((SCPEntity015Boss)par1EntityLiving, par2, par3, par4, par5, par6, par7);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBlaze((SCPEntity015Boss)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBlaze((SCPEntity015Boss)par1Entity, par2, par4, par6, par8, par9);
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderScale((SCPEntity015Boss)par1EntityLiving, par2);
    }
}
