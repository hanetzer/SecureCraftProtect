package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel966 extends ModelBase
{
	//fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer neck;
	ModelRenderer rightarmthing;
	ModelRenderer righthand;
	ModelRenderer rightfinger1;
	ModelRenderer rightfinger2;
	ModelRenderer rightfinger3;
	ModelRenderer rightfinger4;
	ModelRenderer rightfinger5;
	ModelRenderer leftarmthing;
	ModelRenderer lefthand;
	ModelRenderer leftfinger1;
	ModelRenderer leftfinger2;
	ModelRenderer jaw;
	ModelRenderer leftfinger3;
	ModelRenderer leftfinger4;
	ModelRenderer leftfinger5;

	public SCPModel966()
	{
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -11F, -5F, 8, 7, 6);
		head.setRotationPoint(0F, -6F, 0F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0.2094395F, 0F, 0F);
		body = new ModelRenderer(this, 16, 24);
		body.addBox(-4F, 0F, -2F, 8, 14, 3);
		body.setRotationPoint(0F, -3F, 0F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0.2443461F, 0F, 0F);
		rightarm = new ModelRenderer(this, 45, 16);
		rightarm.addBox(-3F, -2F, -2F, 3, 11, 3);
		rightarm.setRotationPoint(-4F, 0F, 0F);
		rightarm.setTextureSize(64, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 45, 16);
		leftarm.addBox(-1F, -2F, -2F, 3, 11, 3);
		leftarm.setRotationPoint(5F, 0F, 0F);
		leftarm.setTextureSize(64, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 3, 13, 3);
		rightleg.setRotationPoint(-2F, 11F, 3F);
		rightleg.setTextureSize(64, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-1F, 0F, -2F, 3, 13, 3);
		leftleg.setRotationPoint(2F, 11F, 3F);
		leftleg.setTextureSize(64, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 16, 16);
		neck.addBox(-2F, -3F, -2F, 4, 4, 3);
		neck.setRotationPoint(0F, -3F, 0F);
		neck.setTextureSize(64, 64);
		neck.mirror = true;
		setRotation(neck, 0F, 0F, 0F);
		rightarmthing = new ModelRenderer(this, 40, 31);
		rightarmthing.addBox(-3F, 6.1F, -7F, 3, 3, 7);
		rightarmthing.setRotationPoint(-4F, 0F, 0F);
		rightarmthing.setTextureSize(64, 64);
		rightarmthing.mirror = true;
		setRotation(rightarmthing, -0.1919862F, 0F, 0F);
		righthand = new ModelRenderer(this, 40, 42);
		righthand.addBox(-3F, 7.1F, -10F, 3, 3, 3);
		righthand.setRotationPoint(-4F, 0F, 0F);
		righthand.setTextureSize(64, 64);
		righthand.mirror = true;
		setRotation(righthand, -0.1919862F, 0F, 0F);
		rightfinger1 = new ModelRenderer(this, 40, 16);
		rightfinger1.addBox(-3F, 12.1F, -6F, 1, 3, 1);
		rightfinger1.setRotationPoint(-4F, 0F, 0F);
		rightfinger1.setTextureSize(64, 64);
		rightfinger1.mirror = true;
		setRotation(rightfinger1, -0.5585054F, 0F, 0F);
		rightfinger2 = new ModelRenderer(this, 40, 16);
		rightfinger2.addBox(-1F, 12.1F, -6F, 1, 4, 1);
		rightfinger2.setRotationPoint(-4F, 0F, 0F);
		rightfinger2.setTextureSize(64, 64);
		rightfinger2.mirror = true;
		setRotation(rightfinger2, -0.5585054F, 0F, 0F);
		rightfinger3 = new ModelRenderer(this, 40, 16);
		rightfinger3.addBox(-10F, 6.1F, 3.6F, 1, 4, 1);
		rightfinger3.setRotationPoint(-4F, 0F, 0F);
		rightfinger3.setTextureSize(64, 64);
		rightfinger3.mirror = true;
		setRotation(rightfinger3, -0.5585054F, -1.570796F, 0F);
		rightfinger4 = new ModelRenderer(this, 40, 16);
		rightfinger4.addBox(-10F, 7.1F, -2.4F, 1, 3, 1);
		rightfinger4.setRotationPoint(-4F, 0F, 0F);
		rightfinger4.setTextureSize(64, 64);
		rightfinger4.mirror = true;
		setRotation(rightfinger4, 0.5585054F, -1.570796F, 0F);
		rightfinger5 = new ModelRenderer(this, 40, 16);
		rightfinger5.addBox(-10F, 9.1F, 0.6F, 1, 4, 1);
		rightfinger5.setRotationPoint(-4F, 0F, 0F);
		rightfinger5.setTextureSize(64, 64);
		rightfinger5.mirror = true;
		setRotation(rightfinger5, 0.5585054F, -1.919862F, 0F);
		leftarmthing = new ModelRenderer(this, 40, 31);
		leftarmthing.addBox(-1F, 6F, -7F, 3, 3, 7);
		leftarmthing.setRotationPoint(5F, 0F, 0F);
		leftarmthing.setTextureSize(64, 64);
		leftarmthing.mirror = true;
		setRotation(leftarmthing, -0.0349066F, 0F, 0F);
		lefthand = new ModelRenderer(this, 40, 42);
		lefthand.addBox(-1F, 7F, -10F, 3, 3, 3);
		lefthand.setRotationPoint(5F, 0F, 0F);
		lefthand.setTextureSize(64, 64);
		lefthand.mirror = true;
		setRotation(lefthand, -0.0349066F, 0F, 0F);
		leftfinger1 = new ModelRenderer(this, 40, 16);
		leftfinger1.addBox(-1F, 12F, -6.4F, 1, 4, 1);
		leftfinger1.setRotationPoint(5F, 0F, 0F);
		leftfinger1.setTextureSize(64, 64);
		leftfinger1.mirror = true;
		setRotation(leftfinger1, -0.3839724F, 0F, 0F);
		leftfinger2 = new ModelRenderer(this, 40, 16);
		leftfinger2.addBox(1F, 12F, -6.4F, 1, 3, 1);
		leftfinger2.setRotationPoint(5F, 0F, 0F);
		leftfinger2.setTextureSize(64, 64);
		leftfinger2.mirror = true;
		setRotation(leftfinger2, -0.3839724F, 0F, 0F);
		jaw = new ModelRenderer(this, 29, 0);
		jaw.addBox(-3F, -4F, -5F, 6, 4, 6);
		jaw.setRotationPoint(0F, -6F, 0F);
		jaw.setTextureSize(64, 64);
		jaw.mirror = true;
		setRotation(jaw, 0.2094395F, 0F, 0F);
		leftfinger3 = new ModelRenderer(this, 40, 16);
		leftfinger3.addBox(8F, 8F, 2F, 1, 5, 1);
		leftfinger3.setRotationPoint(5F, 0F, 0F);
		leftfinger3.setTextureSize(64, 64);
		leftfinger3.mirror = true;
		setRotation(leftfinger3, -0.3839724F, 1.570796F, 0F);
		leftfinger4 = new ModelRenderer(this, 40, 16);
		leftfinger4.addBox(8F, 8F, -2F, 1, 4, 1);
		leftfinger4.setRotationPoint(5F, 0F, 0F);
		leftfinger4.setTextureSize(64, 64);
		leftfinger4.mirror = true;
		setRotation(leftfinger4, 0.3839724F, 1.570796F, 0F);
		leftfinger5 = new ModelRenderer(this, 40, 16);
		leftfinger5.addBox(9F, 9F, -2F, 1, 3, 1);
		leftfinger5.setRotationPoint(5F, 0F, 0F);
		leftfinger5.setTextureSize(64, 64);
		leftfinger5.mirror = true;
		setRotation(leftfinger5, 0.3839724F, 1.64061F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		neck.render(f5);
		rightarmthing.render(f5);
		righthand.render(f5);
		rightfinger1.render(f5);
		rightfinger2.render(f5);
		rightfinger3.render(f5);
		rightfinger4.render(f5);
		rightfinger5.render(f5);
		leftarmthing.render(f5);
		lefthand.render(f5);
		leftfinger1.render(f5);
		leftfinger2.render(f5);
		jaw.render(f5);
		leftfinger3.render(f5);
		leftfinger4.render(f5);
		leftfinger5.render(f5);
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
		head.rotateAngleY = f3 / (180F / (float)Math.PI);
		head.rotateAngleX = f4 / (180F / (float)Math.PI);
		jaw.rotateAngleY = f3 / (180F / (float)Math.PI);
		jaw.rotateAngleX = f4 / (180F / (float)Math.PI);
		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		rightleg.rotateAngleY = 0.0F;
		leftleg.rotateAngleY = 0.0F;  
	}
}
