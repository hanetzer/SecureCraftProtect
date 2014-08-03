package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel096Docile extends ModelBase
{
	//fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer neck;
	ModelRenderer mouth;

	public SCPModel096Docile()
	{
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 21, 1);
		head.addBox(-3F, -8F, -4F, 6, 6, 6);
		head.setRotationPoint(0F, 10F, -1F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.296706F, 0F, 0F);
		body = new ModelRenderer(this, 36, 17);
		body.addBox(-3F, 0F, -1F, 6, 12, 2);
		body.setRotationPoint(0F, 10F, -1F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0.1919862F, 0F, 0F);
		rightarm = new ModelRenderer(this, 54, 1);
		rightarm.addBox(-2F, -2F, -1F, 2, 15, 2);
		rightarm.setRotationPoint(-3F, 12F, -1F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, -0.4537856F, 0F, 0.1047198F);
		leftarm = new ModelRenderer(this, 54, 1);
		leftarm.addBox(0F, -2F, -1F, 2, 15, 2);
		leftarm.setRotationPoint(3F, 12F, -1F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, -0.296706F, -0.1396263F, 0F);
		rightleg = new ModelRenderer(this, 1, 4);
		rightleg.addBox(-1F, 0F, -1F, 2, 15, 2);
		rightleg.setRotationPoint(-2F, 22F, 2F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, -1.43117F, 0F, 0F);
		leftleg = new ModelRenderer(this, 1, 4);
		leftleg.addBox(-1F, 0F, -1F, 2, 15, 2);
		leftleg.setRotationPoint(2F, 22F, 2F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, -1.466077F, 0F, 0F);
		neck = new ModelRenderer(this, 10, 1);
		neck.addBox(-2F, -2F, 0F, 4, 2, 1);
		neck.setRotationPoint(0F, 10F, -1F);
		neck.setTextureSize(64, 32);
		neck.mirror = true;
		setRotation(neck, 0.1919862F, 0F, 0F);
		mouth = new ModelRenderer(this, 15, 14);
		mouth.addBox(-3F, -2F, -4F, 6, 3, 2);
		mouth.setRotationPoint(0F, 10F, -1F);
		mouth.setTextureSize(64, 32);
		mouth.mirror = true;
		setRotation(mouth, 0.296706F, 0F, 0F);
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
		mouth.render(f5);
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
