package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel294 extends ModelBase
{
	//fields
	ModelRenderer Main;
	ModelRenderer Keyboard;
	ModelRenderer Plate;

	public SCPModel294()
	{
		textureWidth = 64;
		textureHeight = 64;

		Main = new ModelRenderer(this, 0, 0);
		Main.addBox(0F, 0F, 0F, 12, 25, 8);
		Main.setRotationPoint(-6F, -1F, -3F);
		Main.setTextureSize(64, 64);
		Main.mirror = true;
		setRotation(Main, 0F, 0F, 0F);
		Keyboard = new ModelRenderer(this, 2, 35);
		Keyboard.addBox(0F, 0F, 0F, 8, 5, 3);
		Keyboard.setRotationPoint(-4F, 8F, -3F);
		Keyboard.setTextureSize(64, 64);
		Keyboard.mirror = true;
		setRotation(Keyboard, -0.418879F, 0F, 0F);
		Plate = new ModelRenderer(this, 2, 44);
		Plate.addBox(0F, 0F, 0F, 8, 11, 2);
		Plate.setRotationPoint(-4F, 13F, -5F);
		Plate.setTextureSize(64, 64);
		Plate.mirror = true;
		setRotation(Plate, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Main.render(f5);
		Keyboard.render(f5);
		Plate.render(f5);
	}

	public void renderModel(float f1)
	{
		Main.render(f1);
		Keyboard.render(f1);
		Plate.render(f1);
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
