package securecraftprotect.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import securecraftprotect.common.entity.monster.EntitySCP0023;

@SideOnly(Side.CLIENT)
public class RenderSCP0023 extends RenderLiving
{
	public RenderSCP0023(ModelBase model, float par2)
	{
		super(model, par2);
	}

	protected ResourceLocation getTexture(EntitySCP0023 entity)
	{
		return new ResourceLocation("scp:textures/entity/0023.png");
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTexture((EntitySCP0023) entity);
	}
}
