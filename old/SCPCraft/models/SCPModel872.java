package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel872 extends ModelBase
{
  //fields
    ModelRenderer foot;
    ModelRenderer waist;
    ModelRenderer body;
    ModelRenderer shoulderleft;
    ModelRenderer shoulderright;
    ModelRenderer armleft;
    ModelRenderer armleft1;
    ModelRenderer armleft2;
    ModelRenderer armright;
    ModelRenderer armright1;
    ModelRenderer armright2;
    ModelRenderer head;
    ModelRenderer hat;
    ModelRenderer hatrim;
  
  public SCPModel872()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      foot = new ModelRenderer(this, 38, 51);
      foot.addBox(0F, 0F, 0F, 2, 10, 2);
      foot.setRotationPoint(-1F, 14F, -1F);
      foot.setTextureSize(128, 64);
      foot.mirror = true;
      setRotation(foot, 0F, 0F, 0F);
      waist = new ModelRenderer(this, 50, 49);
      waist.addBox(0F, 0F, 0F, 8, 6, 8);
      waist.setRotationPoint(-4F, 8F, -4F);
      waist.setTextureSize(128, 64);
      waist.mirror = true;
      setRotation(waist, 0F, 0F, 0F);
      body = new ModelRenderer(this, 43, 30);
      body.addBox(0F, 0F, 0F, 14, 10, 8);
      body.setRotationPoint(-7F, -2F, -4F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      shoulderleft = new ModelRenderer(this, 28, 41);
      shoulderleft.addBox(0F, 0F, 0F, 2, 3, 4);
      shoulderleft.setRotationPoint(-9F, -2F, -2F);
      shoulderleft.setTextureSize(128, 64);
      shoulderleft.mirror = true;
      setRotation(shoulderleft, 0F, 0F, 0F);
      shoulderright = new ModelRenderer(this, 90, 40);
      shoulderright.addBox(0F, 0F, 0F, 2, 3, 4);
      shoulderright.setRotationPoint(7F, -2F, -2F);
      shoulderright.setTextureSize(128, 64);
      shoulderright.mirror = true;
      setRotation(shoulderright, 0F, 0F, 0F);
      armleft = new ModelRenderer(this, 0, 0);
      armleft.addBox(0F, 0F, 0F, 17, 1, 2);
      armleft.setRotationPoint(-25F, 5F, -1F);
      armleft.setTextureSize(128, 64);
      armleft.mirror = true;
      setRotation(armleft, 0F, 0F, -0.3665191F);
      armleft1 = new ModelRenderer(this, 0, 5);
      armleft1.addBox(0F, 0F, 0F, 7, 1, 2);
      armleft1.setRotationPoint(-23F, 7F, -1F);
      armleft1.setTextureSize(128, 64);
      armleft1.mirror = true;
      setRotation(armleft1, 0F, 0F, -0.715585F);
      armleft2 = new ModelRenderer(this, 0, 5);
      armleft2.addBox(0F, 0F, 0F, 7, 1, 2);
      armleft2.setRotationPoint(-24F, 2F, -1F);
      armleft2.setTextureSize(128, 64);
      armleft2.mirror = true;
      setRotation(armleft2, 0F, 0F, 0F);
      armright = new ModelRenderer(this, 0, 0);
      armright.addBox(0F, 0F, 0F, 19, 1, 2);
      armright.setRotationPoint(8F, -1F, -1F);
      armright.setTextureSize(128, 64);
      armright.mirror = true;
      setRotation(armright, 0F, 0F, 0.2617994F);
      armright1 = new ModelRenderer(this, 0, 9);
      armright1.addBox(0F, 0F, 0F, 9, 1, 2);
      armright1.setRotationPoint(19F, 2F, -1F);
      armright1.setTextureSize(128, 64);
      armright1.mirror = true;
      setRotation(armright1, 0F, 0F, 0.6632251F);
      armright2 = new ModelRenderer(this, 0, 13);
      armright2.addBox(0F, 0F, 0F, 8, 1, 2);
      armright2.setRotationPoint(19F, 2F, -1F);
      armright2.setTextureSize(128, 64);
      armright2.mirror = true;
      setRotation(armright2, 0F, 0F, -0.1047198F);
      head = new ModelRenderer(this, 1, 21);
      head.addBox(0F, 0F, -1F, 8, 8, 8);
      head.setRotationPoint(-4F, -8F, -6F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0.3839724F, 0F, 0F);
      hat = new ModelRenderer(this, 3, 49);
      hat.addBox(0F, 0F, -1F, 8, 6, 8);
      hat.setRotationPoint(-4F, -12F, -7F);
      hat.setTextureSize(128, 64);
      hat.mirror = true;
      setRotation(hat, 0.3839724F, 0F, 0F);
      hatrim = new ModelRenderer(this, 49, 1);
      hatrim.addBox(0F, 0F, -1F, 18, 1, 18);
      hatrim.setRotationPoint(-9F, -6F, -10F);
      hatrim.setTextureSize(128, 64);
      hatrim.mirror = true;
      setRotation(hatrim, 0.3839724F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    foot.render(f5);
    waist.render(f5);
    body.render(f5);
    shoulderleft.render(f5);
    shoulderright.render(f5);
    armleft.render(f5);
    armleft1.render(f5);
    armleft2.render(f5);
    armright.render(f5);
    armright1.render(f5);
    armright2.render(f5);
    head.render(f5);
    hat.render(f5);
    hatrim.render(f5);
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
