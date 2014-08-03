package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModelRat extends ModelBase
{
	//fields
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer Tail;
	public boolean Armed;

	public SCPModelRat()
	{
		Armed = false;
		textureWidth = 64;
		textureHeight = 32;
		
      //  this.field_40331_g = 2.0F;
       // this.field_40332_n = 1.0F;
        this.Body = new ModelRenderer(this, 0, 5);
        this.Body.addBox(-1.5F, -1.5F, -2.0F, 3, 3, 4);
        this.Body.setRotationPoint(0.0F, 22.5F, 0.0F);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-1.5F, -1.0F, -2.0F, 3, 2, 2);
        this.Head.setRotationPoint(0.0F, 23.0F, -2.0F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 10, 0);
        this.Tail.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
        this.Tail.setRotationPoint(0.0F, 23.0F, 2.0F);
        this.Tail.setTextureSize(64, 32);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		Body.render(f5);
		Tail.render(f5);
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