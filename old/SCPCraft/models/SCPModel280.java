package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel280 extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leftarm;
    ModelRenderer underbody;
    ModelRenderer underbody1;
    ModelRenderer rightfinger1;
    ModelRenderer rightpalm;
    ModelRenderer rightarm;
    ModelRenderer rightfinger2;
    ModelRenderer rightfinger3;
    ModelRenderer leftpalm;
    ModelRenderer leftfinger1;
    ModelRenderer leftfinger2;
    ModelRenderer leftfinger3;
  
  public SCPModel280()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 13, 4);
      head.addBox(-3F, -5F, -3F, 6, 5, 5);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-2F, 0F, -2F, 4, 10, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 21);
      leftarm.addBox(0F, -2F, -1F, 2, 10, 2);
      leftarm.setRotationPoint(2F, 2F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, -1.500983F, 0F, 0F);
      underbody = new ModelRenderer(this, 16, 31);
      underbody.addBox(-2F, 9F, -4F, 4, 3, 4);
      underbody.setRotationPoint(0F, 0F, 0F);
      underbody.setTextureSize(64, 64);
      underbody.mirror = true;
      setRotation(underbody, 0.2268928F, 0F, 0F);
      underbody1 = new ModelRenderer(this, 16, 39);
      underbody1.addBox(-2F, 11F, -5.8F, 4, 2, 4);
      underbody1.setRotationPoint(0F, 0F, 0F);
      underbody1.setTextureSize(64, 64);
      underbody1.mirror = true;
      setRotation(underbody1, 0.3839724F, 0F, 0F);
      rightfinger1 = new ModelRenderer(this, 40, 16);
      rightfinger1.addBox(0F, 8F, -1F, 1, 3, 1);
      rightfinger1.setRotationPoint(-2F, 2F, 0F);
      rightfinger1.setTextureSize(64, 64);
      rightfinger1.mirror = true;
      setRotation(rightfinger1, -1.500983F, 0F, 0F);
      rightpalm = new ModelRenderer(this, 40, 34);
      rightpalm.addBox(-3F, 8F, -2F, 3, 1, 3);
      rightpalm.setRotationPoint(-2F, 2F, 0F);
      rightpalm.setTextureSize(64, 64);
      rightpalm.mirror = true;
      setRotation(rightpalm, -1.500983F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 21);
      rightarm.addBox(-2F, -2F, -1F, 2, 10, 2);
      rightarm.setRotationPoint(-2F, 2F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, -1.500983F, 0F, 0F);
      rightfinger2 = new ModelRenderer(this, 40, 16);
      rightfinger2.addBox(-1F, 8F, -3F, 1, 3, 1);
      rightfinger2.setRotationPoint(-2F, 2F, 0F);
      rightfinger2.setTextureSize(64, 64);
      rightfinger2.mirror = true;
      setRotation(rightfinger2, -1.500983F, 0F, 0F);
      rightfinger3 = new ModelRenderer(this, 40, 16);
      rightfinger3.addBox(-3F, 8F, -3F, 1, 3, 1);
      rightfinger3.setRotationPoint(-2F, 2F, 0F);
      rightfinger3.setTextureSize(64, 64);
      rightfinger3.mirror = true;
      setRotation(rightfinger3, -1.500983F, 0F, 0F);
      leftpalm = new ModelRenderer(this, 40, 34);
      leftpalm.addBox(0F, 8F, -2F, 3, 1, 3);
      leftpalm.setRotationPoint(2F, 2F, 0F);
      leftpalm.setTextureSize(64, 64);
      leftpalm.mirror = true;
      setRotation(leftpalm, -1.500983F, 0F, 0F);
      leftfinger1 = new ModelRenderer(this, 40, 16);
      leftfinger1.addBox(-1F, 8F, -1F, 1, 3, 1);
      leftfinger1.setRotationPoint(2F, 2F, 0F);
      leftfinger1.setTextureSize(64, 64);
      leftfinger1.mirror = true;
      setRotation(leftfinger1, -1.500983F, 0F, 0F);
      leftfinger2 = new ModelRenderer(this, 40, 16);
      leftfinger2.addBox(0F, 8F, -3F, 1, 3, 1);
      leftfinger2.setRotationPoint(2F, 2F, 0F);
      leftfinger2.setTextureSize(64, 64);
      leftfinger2.mirror = true;
      setRotation(leftfinger2, -1.500983F, 0F, 0F);
      leftfinger3 = new ModelRenderer(this, 40, 16);
      leftfinger3.addBox(2F, 8F, -3F, 1, 3, 1);
      leftfinger3.setRotationPoint(2F, 2F, 0F);
      leftfinger3.setTextureSize(64, 64);
      leftfinger3.mirror = true;
      setRotation(leftfinger3, -1.500983F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    leftarm.render(f5);
    underbody.render(f5);
    underbody.render(f5);
    rightfinger1.render(f5);
    rightpalm.render(f5);
    rightarm.render(f5);
    rightfinger2.render(f5);
    rightfinger3.render(f5);
    leftpalm.render(f5);
    leftfinger1.render(f5);
    leftfinger2.render(f5);
    leftfinger3.render(f5);
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
  }

}
