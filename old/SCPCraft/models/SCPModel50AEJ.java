package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel50AEJ extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer pointthing;
    ModelRenderer pointthing2;
    ModelRenderer bodeh;
    ModelRenderer wing1;
    ModelRenderer underbody;
    ModelRenderer wing2;
    ModelRenderer leg1;
    ModelRenderer feet1;
    ModelRenderer finger1;
    ModelRenderer finger2;
    ModelRenderer finger3;
    ModelRenderer leg2;
    ModelRenderer feet2;
    ModelRenderer finger4;
    ModelRenderer finger5;
    ModelRenderer finger6;
  
  public SCPModel50AEJ()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 34, 19);
      head.addBox(-2F, -4F, -2F, 4, 4, 4);
      head.setRotationPoint(0F, 0F, -4F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      pointthing = new ModelRenderer(this, 51, 19);
      pointthing.addBox(-1F, -2F, -5F, 2, 1, 3);
      pointthing.setRotationPoint(0F, 0F, -4F);
      pointthing.setTextureSize(64, 64);
      pointthing.mirror = true;
      setRotation(pointthing, -0.1745329F, 0F, 0F);
      pointthing2 = new ModelRenderer(this, 51, 24);
      pointthing2.addBox(-1F, -2F, -4F, 2, 1, 3);
      pointthing2.setRotationPoint(0F, 0F, -4F);
      pointthing2.setTextureSize(64, 64);
      pointthing2.mirror = true;
      setRotation(pointthing2, 0.1745329F, 0F, 0F);
      bodeh = new ModelRenderer(this, 9, 17);
      bodeh.addBox(-3F, -3F, 0F, 6, 6, 6);
      bodeh.setRotationPoint(0F, -2F, -2F);
      bodeh.setTextureSize(64, 64);
      bodeh.mirror = true;
      setRotation(bodeh, 0F, 0F, 0F);
      wing1 = new ModelRenderer(this, 27, 7);
      wing1.addBox(-6F, -2F, 1F, 4, 1, 8);
      wing1.setRotationPoint(0F, -2F, -2F);
      wing1.setTextureSize(64, 64);
      wing1.mirror = true;
      setRotation(wing1, -0.0872665F, -0.1745329F, -0.296706F);
      underbody = new ModelRenderer(this, 1, 30);
      underbody.addBox(-2F, -2F, 6F, 4, 4, 1);
      underbody.setRotationPoint(0F, -2F, -2F);
      underbody.setTextureSize(64, 64);
      underbody.mirror = true;
      setRotation(underbody, 0F, 0F, 0F);
      wing2 = new ModelRenderer(this, 0, 7);
      wing2.addBox(2F, -2F, 1F, 4, 1, 8);
      wing2.setRotationPoint(0F, -2F, -2F);
      wing2.setTextureSize(64, 64);
      wing2.mirror = true;
      setRotation(wing2, -0.0872665F, 0.1745329F, 0.296706F);
      leg1 = new ModelRenderer(this, 1, 48);
      leg1.addBox(1F, -1F, 7F, 1, 1, 5);
      leg1.setRotationPoint(0F, -2F, -2F);
      leg1.setTextureSize(64, 64);
      leg1.mirror = true;
      setRotation(leg1, -0.0698132F, 0.0349066F, 0F);
      feet1 = new ModelRenderer(this, 7, 0);
      feet1.addBox(0F, -1F, 12F, 2, 2, 1);
      feet1.setRotationPoint(0F, -2F, -2F);
      feet1.setTextureSize(64, 64);
      feet1.mirror = true;
      setRotation(feet1, -0.0698132F, 0.0349066F, 0F);
      finger1 = new ModelRenderer(this, 0, 0);
      finger1.addBox(2F, 0F, 12F, 1, 1, 2);
      finger1.setRotationPoint(0F, -2F, -2F);
      finger1.setTextureSize(64, 64);
      finger1.mirror = true;
      setRotation(finger1, -0.0698132F, 0.0349066F, 0F);
      finger2 = new ModelRenderer(this, 0, 0);
      finger2.addBox(1F, -2F, 12F, 1, 1, 2);
      finger2.setRotationPoint(0F, -2F, -2F);
      finger2.setTextureSize(64, 64);
      finger2.mirror = true;
      setRotation(finger2, -0.0698132F, 0.0349066F, 0F);
      finger3 = new ModelRenderer(this, 14, 0);
      finger3.addBox(0F, 0F, 13F, 1, 1, 1);
      finger3.setRotationPoint(0F, -2F, -2F);
      finger3.setTextureSize(64, 64);
      finger3.mirror = true;
      setRotation(finger3, -0.0698132F, 0.0349066F, 0F);
      leg2 = new ModelRenderer(this, 1, 48);
      leg2.addBox(-1F, -1F, 7F, 1, 1, 5);
      leg2.setRotationPoint(0F, -2F, -2F);
      leg2.setTextureSize(64, 64);
      leg2.mirror = true;
      setRotation(leg2, -0.0698132F, -0.1047198F, 0F);
      feet2 = new ModelRenderer(this, 7, 0);
      feet2.addBox(-1F, -1F, 12F, 2, 2, 1);
      feet2.setRotationPoint(0F, -2F, -2F);
      feet2.setTextureSize(64, 64);
      feet2.mirror = true;
      setRotation(feet2, -0.0698132F, -0.1047198F, 0F);
      finger4 = new ModelRenderer(this, 0, 0);
      finger4.addBox(-1F, -2F, 12F, 1, 1, 2);
      finger4.setRotationPoint(0F, -2F, -2F);
      finger4.setTextureSize(64, 64);
      finger4.mirror = true;
      setRotation(finger4, -0.0698132F, -0.1047198F, 0F);
      finger5 = new ModelRenderer(this, 14, 0);
      finger5.addBox(0F, 0F, 13F, 1, 1, 1);
      finger5.setRotationPoint(0F, -2F, -2F);
      finger5.setTextureSize(64, 64);
      finger5.mirror = true;
      setRotation(finger5, -0.0698132F, -0.1047198F, 0F);
      finger6 = new ModelRenderer(this, 0, 0);
      finger6.addBox(-2F, 0F, 12F, 1, 1, 2);
      finger6.setRotationPoint(0F, -2F, -2F);
      finger6.setTextureSize(64, 64);
      finger6.mirror = true;
      setRotation(finger6, -0.0698132F, -0.1047198F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    pointthing.render(f5);
    pointthing2.render(f5);
    bodeh.render(f5);
    wing1.render(f5);
    underbody.render(f5);
    wing2.render(f5);
    leg1.render(f5);
    feet1.render(f5);
    finger1.render(f5);
    finger2.render(f5);
    finger3.render(f5);
    leg2.render(f5);
    feet2.render(f5);
    finger4.render(f5);
    finger5.render(f5);
    finger6.render(f5);
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
