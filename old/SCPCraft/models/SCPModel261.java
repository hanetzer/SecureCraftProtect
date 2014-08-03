package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel261 extends ModelBase
{
	//fields
	ModelRenderer BoxHead;

	public SCPModel261()
	{
		textureWidth = 64;
		textureHeight = 64;

		BoxHead = new ModelRenderer(this, 0, 0);
		BoxHead.addBox(0F, 0F, 0F, 12, 24, 10);
		BoxHead.setRotationPoint(-6F, 0F, -5F);
		BoxHead.setTextureSize(64, 64);
		BoxHead.mirror = true;
		setRotation(BoxHead, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BoxHead.render(f5);
	}

	public void renderModel(float f1)
	{
		BoxHead.render(f1);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
