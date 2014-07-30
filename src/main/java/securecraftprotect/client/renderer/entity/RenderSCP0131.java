package securecraftprotect.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import securecraftprotect.common.entity.passive.EntitySCP0131;

@SideOnly(Side.CLIENT)
public class RenderSCP0131 extends RenderLiving
{
	public RenderSCP0131(ModelBase model, float par2)
	{
		super(model, par2);
	}

	protected ResourceLocation getTexture(EntitySCP0131 entity)
	{
		if (entity.isTamed()) {
			return new ResourceLocation("scp:textures/entity/0131/tame.png");
		} else {
			return new ResourceLocation("scp:textures/entity/0131/wild.png");
		}
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTexture((EntitySCP0131) entity);
	}
}
