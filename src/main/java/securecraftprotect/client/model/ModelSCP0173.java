package securecraftprotect.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSCP0173 extends ModelBase
{
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightArm;
	ModelRenderer leftArm;
	ModelRenderer rightLeg;
	ModelRenderer leftLeg;

	public ModelSCP0173()
	{
		textureWidth = 128;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 6);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, -10F, 0F);
		head.setTextureSize(128, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 32, 0);
		body.addBox(-4F, 0F, -2F, 8, 22, 4);
		body.setRotationPoint(0F, -10F, 0F);
		body.setTextureSize(128, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightArm = new ModelRenderer(this, 70, 0);
		rightArm.addBox(-1F, -2F, -1F, 2, 13, 2);
		rightArm.setRotationPoint(-5F, -4F, 0F);
		rightArm.setTextureSize(128, 32);
		rightArm.mirror = true;
		setRotation(rightArm, -1.623156F, 0F, 0F);
		leftArm = new ModelRenderer(this, 70, 0);
		leftArm.addBox(-1F, -2F, -1F, 2, 13, 2);
		leftArm.setRotationPoint(5F, -4F, 0F);
		leftArm.setTextureSize(128, 32);
		leftArm.mirror = true;
		setRotation(leftArm, -1.570796F, 0F, 0F);
		rightLeg = new ModelRenderer(this, 57, 0);
		rightLeg.addBox(-1F, 0F, -1F, 2, 12, 2);
		rightLeg.setRotationPoint(-2F, 12F, 0F);
		rightLeg.setTextureSize(128, 32);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0F, 0F, 0F);
		leftLeg = new ModelRenderer(this, 57, 0);
		leftLeg.addBox(-1F, 0F, -1F, 2, 12, 2);
		leftLeg.setRotationPoint(2F, 12F, 0F);
		leftLeg.setTextureSize(128, 32);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
					   float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightArm.render(f5);
		leftArm.render(f5);
		rightLeg.render(f5);
		leftLeg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
								  float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
