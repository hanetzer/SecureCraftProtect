package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel053 extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer waist;
  
  public SCPModel053()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 5F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 17, 17);
      body.addBox(-3F, 0F, -2F, 6, 10, 4);
      body.setRotationPoint(0F, 5F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 3, 9, 3);
      rightarm.setRotationPoint(-3F, 7F, 1F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -1F, 3, 9, 3);
      leftarm.setRotationPoint(4F, 7F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-1F, 0F, -2F, 3, 4, 4);
      rightleg.setRotationPoint(-2F, 20F, 0F);
      rightleg.setTextureSize(64, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 3, 4, 4);
      leftleg.setRotationPoint(2F, 20F, 0F);
      leftleg.setTextureSize(64, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      waist = new ModelRenderer(this, 13, 35);
      waist.addBox(-4F, 13F, -3F, 8, 5, 6);
      waist.setRotationPoint(0F, 2F, 0F);
      waist.setTextureSize(64, 64);
      waist.mirror = true;
      setRotation(waist, 0F, 0F, 0F);
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
    waist.render(f5);
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
    rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	rightleg.rotateAngleY = 0.0F;
	leftleg.rotateAngleY = 0.0F;
    rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    rightarm.rotateAngleZ = 0.0F;
    leftarm.rotateAngleZ = 0.0F;
  }
}
