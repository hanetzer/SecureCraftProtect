package securecraftprotect.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelClassDMale extends ModelBase
{
	//fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer righteye;
	ModelRenderer lefteye;
	ModelRenderer Gasmask;
	ModelRenderer BreathPipe;
	ModelRenderer GasThing;

	public ModelClassDMale()
	{
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		righteye = new ModelRenderer(this, 40, 1);
		righteye.addBox(1F, -7F, -5F, 2, 2, 1);
		righteye.setRotationPoint(0F, 0F, 0F);
		righteye.setTextureSize(64, 32);
		righteye.mirror = true;
		setRotation(righteye, 0F, 0F, 0F);
		lefteye = new ModelRenderer(this, 33, 1);
		lefteye.addBox(-3F, -7F, -5F, 2, 2, 1);
		lefteye.setRotationPoint(0F, 0F, 0F);
		lefteye.setTextureSize(64, 32);
		lefteye.mirror = true;
		setRotation(lefteye, 0F, 0F, 0F);
		Gasmask = new ModelRenderer(this, 33, 5);
		Gasmask.addBox(-2F, -3F, -6F, 3, 3, 2);
		Gasmask.setRotationPoint(0F, 0F, 0F);
		Gasmask.setTextureSize(64, 32);
		Gasmask.mirror = true;
		setRotation(Gasmask, 0F, 0F, 0F);
		BreathPipe = new ModelRenderer(this, 44, 8);
		BreathPipe.addBox(1F, -2F, -6F, 2, 1, 1);
		BreathPipe.setRotationPoint(0F, 0F, 0F);
		BreathPipe.setTextureSize(64, 32);
		BreathPipe.mirror = true;
		setRotation(BreathPipe, 0F, 0F, 0F);
		GasThing = new ModelRenderer(this, 51, 5);
		GasThing.addBox(3F, -3F, -7F, 2, 3, 3);
		GasThing.setRotationPoint(0F, 0F, 0F);
		GasThing.setTextureSize(64, 32);
		GasThing.mirror = true;
		setRotation(GasThing, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
					   float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		righteye.render(f5);
		lefteye.render(f5);
		Gasmask.render(f5);
		BreathPipe.render(f5);
		GasThing.render(f5);
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
		head.rotateAngleY = f3 / (180F / (float) Math.PI);
		head.rotateAngleX = f4 / (180F / (float) Math.PI);
		Gasmask.rotateAngleY = f3 / (180F / (float) Math.PI);
		Gasmask.rotateAngleX = f4 / (180F / (float) Math.PI);
		BreathPipe.rotateAngleY = f3 / (180F / (float) Math.PI);
		BreathPipe.rotateAngleX = f4 / (180F / (float) Math.PI);
		GasThing.rotateAngleY = f3 / (180F / (float) Math.PI);
		GasThing.rotateAngleX = f4 / (180F / (float) Math.PI);
		righteye.rotateAngleY = f3 / (180F / (float) Math.PI);
		righteye.rotateAngleX = f4 / (180F / (float) Math.PI);
		lefteye.rotateAngleY = f3 / (180F / (float) Math.PI);
		lefteye.rotateAngleX = f4 / (180F / (float) Math.PI);
		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) *
				1.4F * f1;
		rightleg.rotateAngleY = 0.0F;
		leftleg.rotateAngleY = 0.0F;
		rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* 2.0F * f1 * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;
	}
}
