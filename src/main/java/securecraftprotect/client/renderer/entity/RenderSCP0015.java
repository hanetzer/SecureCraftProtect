package securecraftprotect.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import securecraftprotect.common.entity.boss.EntitySCP0015;

import static org.lwjgl.opengl.GL11.*;

@SideOnly(Side.CLIENT)
public class RenderSCP0015 extends RenderLiving
{
	private static final ResourceLocation start = new ResourceLocation
			("scp:textures/entity/0015/start.png");
	private static final ResourceLocation half = new ResourceLocation
			("scp:textures/entity/0015/half.png");
	private static final ResourceLocation dead = new ResourceLocation
			("scp:textures/entity/0015/dead.png");
	public static EntitySCP0015 entityPipe;
	private int field_77068_a;
	private float scale;

	public RenderSCP0015(ModelBlaze model, float f)
	{
		super(new ModelBlaze(), 0.5F);
		this.field_77068_a = ((ModelBlaze) this.mainModel).func_78104_a();
		this.scale = f;
	}


	protected void preRenderScale(EntitySCP0015 entity, float par2)
	{
		glScalef(this.scale, this.scale, this.scale);
	}

	public void renderSCP0015(EntitySCP0015 entity, double par2, double par4,
							  double par6, float par8, float par9)
	{
		entityPipe = entity;
		int var10 = ((ModelBlaze) this.mainModel).func_78104_a();

		if (var10 != this.field_77068_a) {
			this.field_77068_a = var10;
			this.mainModel = new ModelBlaze();
		}
		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	protected void renderDragonModel(EntitySCP0015 entity, float par2,
									 float par3, float par4, float par5,
									 float par6, float par7)
	{
		if (entity.deathTicks > 0) {
			float var8 = (float) entity.deathTicks / 200.0F;
			glDepthFunc(GL_LEQUAL);
			glEnable(GL_ALPHA_TEST);
			glAlphaFunc(GL_GREATER, var8);
			this.mainModel.render(entity, par2, par3, par4, par5, par6, par7);
			glAlphaFunc(GL_GREATER, 0.1F);
			glDepthFunc(GL_EQUAL);
		}
		this.mainModel.render(entity, par2, par3, par4, par5, par6, par7);
		glDepthFunc(GL_LEQUAL);
	}

	protected void renderModel(EntityLiving par1EntityLiving, float par2,
							   float par3, float par4, float par5, float par6,
							   float par7)
	{
		this.renderDragonModel((EntitySCP0015) par1EntityLiving, par2, par3,
				par4, par5, par6, par7);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
							   double par4, double par6, float par8,
							   float par9)
	{
		this.renderSCP0015((EntitySCP0015) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}

	public void doRender(Entity entity, double par2, double par4, double par6,
						 float par8, float par9)
	{
		this.renderSCP0015((EntitySCP0015) entity, par2, par4, par6, par8,
				par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getSCP0015Texture((EntitySCP0015) entity);
	}

	private ResourceLocation getSCP0015Texture(EntitySCP0015 entity)
	{
		if (entity.getHealth() > 600) {
			return start;
		} else if (entity.getHealth() <= 600
				&& entity.getHealth() > 8) {
			return half;
		} else {
			return dead;
		}
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args:
	 * entityLiving, partialTickTime
	 */
	protected void preRenderCallback(EntityLiving entity, float par2)
	{
		this.preRenderScale((EntitySCP0015) entity, par2);
	}
}
