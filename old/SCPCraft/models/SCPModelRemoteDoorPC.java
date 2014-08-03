package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import SCPCraft.mod_Others;

public class SCPModelRemoteDoorPC extends ModelBase
{
	//fields
	ModelRenderer Shape3;
	ModelRenderer Shape1;
	ModelRenderer Shape2;

	public SCPModelRemoteDoorPC()
	{
		textureWidth = 64;
		textureHeight = 64;

		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(0F, 0F, 0F, 14, 18, 12);
		Shape3.setRotationPoint(-7F, 6F, -6F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 1, 32);
		Shape1.addBox(0F, 0F, 0F, 14, 16, 6);
		Shape1.setRotationPoint(-7F, -10F, 0F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 1, 1);
		Shape2.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		
		if(mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(3F, 4F, -4F);
		}
		else if(!mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(5F, 4F, -4F);
		}
		setRotation(Shape2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape3.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
		
		if(mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(3F, 4F, -4F);
		}
		else if(!mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(5F, 4F, -4F);
		}
	}

	public void renderModel(float f1)
	{
		Shape3.render(f1);
		Shape1.render(f1);
		Shape2.render(f1);
		
		if(mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(3F, 4F, -4F);
		}
		else if(!mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(5F, 4F, -4F);
		}
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
		
		if(mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(3F, 4F, -4F);
		}
		else if(!mod_Others.remoteDoorActivate)
		{
			Shape2.setRotationPoint(5F, 4F, -4F);
		}
	}

}
