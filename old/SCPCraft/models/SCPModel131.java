package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel131 extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer Tail;
    ModelRenderer tail2;
    ModelRenderer rim1;
    ModelRenderer rim2;
    ModelRenderer rim3;
    ModelRenderer rim4;
    ModelRenderer eye;
  
  public SCPModel131()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 12, 1);
      body.addBox(-3F, 0F, -3F, 7, 6, 8);
      body.setRotationPoint(0F, 19F, 2F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, -1.570796F, 0F, 0F);
      Tail = new ModelRenderer(this, 49, 7);
      Tail.addBox(-1F, -3F, -4F, 3, 3, 4);
      Tail.setRotationPoint(0F, 19F, 2F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, -0.7853982F, 0F, 0F);
      tail2 = new ModelRenderer(this, 53, 1);
      tail2.addBox(0F, -6F, -3F, 1, 3, 2);
      tail2.setRotationPoint(0F, 19F, 2F);
      tail2.setTextureSize(64, 32);
      tail2.mirror = true;
      setRotation(tail2, -0.7853982F, 0F, 0F);
      rim1 = new ModelRenderer(this, 18, 16);
      rim1.addBox(-3F, 6F, -3F, 7, 1, 2);
      rim1.setRotationPoint(0F, 19F, 2F);
      rim1.setTextureSize(64, 32);
      rim1.mirror = true;
      setRotation(rim1, -1.570796F, 0F, 0F);
      rim2 = new ModelRenderer(this, 1, 16);
      rim2.addBox(-3F, 6F, -2F, 1, 1, 7);
      rim2.setRotationPoint(0F, 19F, 2F);
      rim2.setTextureSize(64, 32);
      rim2.mirror = true;
      setRotation(rim2, -1.570796F, 0F, 0F);
      rim3 = new ModelRenderer(this, 19, 21);
      rim3.addBox(-2F, 6F, 3F, 6, 1, 2);
      rim3.setRotationPoint(0F, 19F, 2F);
      rim3.setTextureSize(64, 32);
      rim3.mirror = true;
      setRotation(rim3, -1.570796F, 0F, 0F);
      rim4 = new ModelRenderer(this, 37, 17);
      rim4.addBox(3F, 6F, -2F, 1, 1, 6);
      rim4.setRotationPoint(0F, 19F, 2F);
      rim4.setTextureSize(64, 32);
      rim4.mirror = true;
      setRotation(rim4, -1.570796F, 0F, 0F);
      eye = new ModelRenderer(this, 22, 27);
      eye.addBox(-1F, 6F, 0F, 3, 1, 2);
      eye.setRotationPoint(0F, 19F, 2F);
      eye.setTextureSize(64, 32);
      eye.mirror = true;
      setRotation(eye, -1.570796F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    Tail.render(f5);
    tail2.render(f5);
    rim1.render(f5);
    rim2.render(f5);
    rim3.render(f5);
    rim4.render(f5);
    eye.render(f5);
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
