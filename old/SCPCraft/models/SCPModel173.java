package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel173 extends ModelBase
{
	//fields
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer RightArm;
	ModelRenderer LeftArm;
	ModelRenderer RightLeg;
	ModelRenderer LeftLeg;

	public SCPModel173()
	{
		textureWidth = 128;
		textureHeight = 32;

		Head = new ModelRenderer(this, 0, 6);
		Head.addBox(-4F, -8F, -4F, 8, 8, 8);
		Head.setRotationPoint(0F, -10F, 0F);
		Head.setTextureSize(128, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 32, 0);
		Body.addBox(-4F, 0F, -2F, 8, 22, 4);
		Body.setRotationPoint(0F, -10F, 0F);
		Body.setTextureSize(128, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		RightArm = new ModelRenderer(this, 70, 0);
		RightArm.addBox(-1F, -2F, -1F, 2, 13, 2);
		RightArm.setRotationPoint(-5F, -4F, 0F);
		RightArm.setTextureSize(128, 32);
		RightArm.mirror = true;
		setRotation(RightArm, -1.623156F, 0F, 0F);
		LeftArm = new ModelRenderer(this, 70, 0);
		LeftArm.addBox(-1F, -2F, -1F, 2, 13, 2);
		LeftArm.setRotationPoint(5F, -4F, 0F);
		LeftArm.setTextureSize(128, 32);
		LeftArm.mirror = true;
		setRotation(LeftArm, -1.570796F, 0F, 0F);
		RightLeg = new ModelRenderer(this, 57, 0);
		RightLeg.addBox(-1F, 0F, -1F, 2, 12, 2);
		RightLeg.setRotationPoint(-2F, 12F, 0F);
		RightLeg.setTextureSize(128, 32);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0F);
		LeftLeg = new ModelRenderer(this, 57, 0);
		LeftLeg.addBox(-1F, 0F, -1F, 2, 12, 2);
		LeftLeg.setRotationPoint(2F, 12F, 0F);
		LeftLeg.setTextureSize(128, 32);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		Body.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
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