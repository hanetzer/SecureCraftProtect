package securecraftprotect.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import securecraftprotect.common.entity.passive.EntityClassD;

@SideOnly(Side.CLIENT)
public class RenderClassDMale extends RenderLiving {
    public RenderClassDMale(ModelBase model, float par2) {
        super(model, par2);
    }

    protected ResourceLocation getTexture(EntityClassD entity) {
        return new ResourceLocation("scp:textures/entity/classd_male.png");
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getTexture((EntityClassD) entity);
    }
}
