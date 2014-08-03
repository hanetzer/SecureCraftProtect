package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel457 extends ModelBase
{
	//fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;

	public SCPModel457()
	{
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 5);
		head.setRotationPoint(0F, 2F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-3F, 0F, -2F, 6, 12, 3);
		body.setRotationPoint(0F, 2F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 3, 12, 3);
		rightarm.setRotationPoint(-3F, 4F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 3, 12, 3);
		leftarm.setRotationPoint(4F, 4F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 3, 10, 3);
		rightleg.setRotationPoint(-1F, 14F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-1F, 0F, -2F, 3, 10, 3);
		leftleg.setRotationPoint(1F, 14F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
	{
		head.rotateAngleY = par4 / (180F / (float)Math.PI);
		head.rotateAngleX = par5 / (180F / (float)Math.PI);
		rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		rightleg.rotateAngleY = 0.0F;
		leftleg.rotateAngleY = 0.0F;

		if (isRiding)
		{
			rightleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			leftleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
			rightleg.rotateAngleY = ((float)Math.PI / 10F);
			leftleg.rotateAngleY = -((float)Math.PI / 10F);
		}

		if (onGround > -9990F)
		{
			float f = onGround;
			body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f) * (float)Math.PI * 2.0F) * 0.2F;
			f = 1.0F - onGround;
			f *= f;
			f *= f;
			f = 1.0F - f;
			float f2 = MathHelper.sin(f * (float)Math.PI);
			float f4 = MathHelper.sin(onGround * (float)Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;
		}
	}
}