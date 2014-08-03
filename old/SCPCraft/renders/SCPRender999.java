package SCPCraft.renders;
 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

import SCPCraft.SCPPotion;
import SCPCraft.entities.SCPEntity999;

public class SCPRender999 extends RenderLiving
{
    private ModelBase scaleAmount;

    public SCPRender999(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.scaleAmount = par2ModelBase;
    }

    protected int func_77090_a(SCPEntity999 par1EntitySlime, int par2, float par3)
    {
    	//TODO
        if (par1EntitySlime.isPotionActive(SCPPotion.crystal))
        {
            GL11.glDepthMask(true);
            if (par2 == 0)
            {
                this.loadTexture("/SCPCraft/textures/SCP409Overlay.png");
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                this.setRenderPassModel(this.mainModel);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                return 1;
            }

            if (par2 == 2)
            {
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }
        }
        if (par2 == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(0.8F, 0.2F, 0F, 1F);
            return 1;
        }
        else
        {
            if (par2 == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1F, 1F, 1F, 1.0F);
            }

            return -1;
        }
    }

    /**
     * sets the scale for the slime based on getSlimeSize in EntitySlime
     */
    protected void scaleSlime(SCPEntity999 par1EntitySlime, float par2)
    {
        float var3 = (float)par1EntitySlime.getSlimeSize();
        float var4 = (par1EntitySlime.field_70812_c + (par1EntitySlime.field_70811_b - par1EntitySlime.field_70812_c) * par2) / (var3 * 0.5F + 1.0F);
        float var5 = 1.0F / (var4 + 1.0F);
        GL11.glScalef(var5 * var3, 1.0F / var5 * var3, var5 * var3);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.scaleSlime((SCPEntity999)par1EntityLiving, par2);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.func_77090_a((SCPEntity999)par1EntityLiving, par2, par3);
    }
}
