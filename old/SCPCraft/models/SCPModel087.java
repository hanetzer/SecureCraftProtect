package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel087 extends ModelBase
{
  //fields
    ModelRenderer fingerright4;
    ModelRenderer fingerright5;
    ModelRenderer fingerleft1;
    ModelRenderer fingerleft2;
    ModelRenderer fingerleft3;
    ModelRenderer fingerleft4;
    ModelRenderer fingerleft5;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer Shoulder1;
    ModelRenderer Shoulder2;
    ModelRenderer underbody;
    ModelRenderer rightarmunder;
    ModelRenderer leftarmunder;
    ModelRenderer fingerright1;
    ModelRenderer fingerright2;
    ModelRenderer fingerright3;
  
  public SCPModel087()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      fingerright4 = new ModelRenderer(this, 2, 50);
      fingerright4.addBox(0F, 19F, 0F, 1, 5, 1);
      fingerright4.setRotationPoint(-4F, -9F, 0F);
      fingerright4.setTextureSize(64, 64);
      fingerright4.mirror = true;
      setRotation(fingerright4, 0F, 0F, 0.3665191F);
      fingerright5 = new ModelRenderer(this, 2, 59);
      fingerright5.addBox(-6F, 18F, 0F, 1, 3, 1);
      fingerright5.setRotationPoint(-4F, -9F, 0F);
      fingerright5.setTextureSize(64, 64);
      fingerright5.mirror = true;
      setRotation(fingerright5, 0F, 0F, -0.1396263F);
      fingerleft1 = new ModelRenderer(this, 57, 50);
      fingerleft1.addBox(3F, 20F, -2F, 1, 9, 1);
      fingerleft1.setRotationPoint(4F, -9F, 0F);
      fingerleft1.setTextureSize(64, 64);
      fingerleft1.mirror = true;
      setRotation(fingerleft1, 0F, 0F, -0.1396263F);
      fingerleft2 = new ModelRenderer(this, 47, 50);
      fingerleft2.addBox(1F, 20F, -2F, 1, 9, 1);
      fingerleft2.setRotationPoint(4F, -9F, 0F);
      fingerleft2.setTextureSize(64, 64);
      fingerleft2.mirror = true;
      setRotation(fingerleft2, 0F, 0F, -0.0872665F);
      fingerleft3 = new ModelRenderer(this, 52, 50);
      fingerleft3.addBox(1F, 20F, 0F, 1, 10, 1);
      fingerleft3.setRotationPoint(4F, -9F, 0F);
      fingerleft3.setTextureSize(64, 64);
      fingerleft3.mirror = true;
      setRotation(fingerleft3, 0F, 0F, -0.1396263F);
      fingerleft4 = new ModelRenderer(this, 42, 55);
      fingerleft4.addBox(-1F, 19F, 0F, 1, 5, 1);
      fingerleft4.setRotationPoint(4F, -9F, 0F);
      fingerleft4.setTextureSize(64, 64);
      fingerleft4.mirror = true;
      setRotation(fingerleft4, 0F, 0F, -0.3665191F);
      fingerleft5 = new ModelRenderer(this, 42, 50);
      fingerleft5.addBox(5F, 18F, 0F, 1, 3, 1);
      fingerleft5.setRotationPoint(4F, -9F, 0F);
      fingerleft5.setTextureSize(64, 64);
      fingerleft5.mirror = true;
      setRotation(fingerleft5, 0F, 0F, 0.1396263F);
      head = new ModelRenderer(this, 20, 0);
      head.addBox(-3F, -5F, -3F, 6, 5, 6);
      head.setRotationPoint(0F, -11F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 19, 12);
      body.addBox(-4F, 0F, -2F, 8, 10, 4);
      body.setRotationPoint(0F, -11F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 2, 19);
      rightarm.addBox(-6F, -1F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-4F, -9F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 44, 19);
      leftarm.addBox(2F, -1F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(4F, -9F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      Shoulder1 = new ModelRenderer(this, 4, 11);
      Shoulder1.addBox(-3F, -2F, -2F, 3, 3, 4);
      Shoulder1.setRotationPoint(-4F, -9F, 0F);
      Shoulder1.setTextureSize(64, 64);
      Shoulder1.mirror = true;
      setRotation(Shoulder1, 0F, 0F, 0F);
      Shoulder2 = new ModelRenderer(this, 44, 11);
      Shoulder2.addBox(0F, -2F, -2F, 3, 3, 4);
      Shoulder2.setRotationPoint(4F, -9F, 0F);
      Shoulder2.setTextureSize(64, 64);
      Shoulder2.mirror = true;
      setRotation(Shoulder2, 0F, 0F, 0F);
      underbody = new ModelRenderer(this, 20, 27);
      underbody.addBox(-3F, 10F, -3F, 6, 10, 4);
      underbody.setRotationPoint(0F, -11F, 0F);
      underbody.setTextureSize(64, 64);
      underbody.mirror = true;
      setRotation(underbody, 0.1396263F, 0F, 0F);
      rightarmunder = new ModelRenderer(this, 2, 36);
      rightarmunder.addBox(-4F, 11F, -2F, 4, 9, 4);
      rightarmunder.setRotationPoint(-4F, -9F, 0F);
      rightarmunder.setTextureSize(64, 64);
      rightarmunder.mirror = true;
      setRotation(rightarmunder, 0F, 0F, 0.1396263F);
      leftarmunder = new ModelRenderer(this, 42, 36);
      leftarmunder.addBox(0F, 11F, -2F, 4, 9, 4);
      leftarmunder.setRotationPoint(4F, -9F, 0F);
      leftarmunder.setTextureSize(64, 64);
      leftarmunder.mirror = true;
      setRotation(leftarmunder, 0F, 0F, -0.1396263F);
      fingerright1 = new ModelRenderer(this, 7, 50);
      fingerright1.addBox(-4F, 20F, -2F, 1, 9, 1);
      fingerright1.setRotationPoint(-4F, -9F, 0F);
      fingerright1.setTextureSize(64, 64);
      fingerright1.mirror = true;
      setRotation(fingerright1, 0F, 0F, 0.1396263F);
      fingerright2 = new ModelRenderer(this, 17, 50);
      fingerright2.addBox(-2F, 20F, -2F, 1, 9, 1);
      fingerright2.setRotationPoint(-4F, -9F, 0F);
      fingerright2.setTextureSize(64, 64);
      fingerright2.mirror = true;
      setRotation(fingerright2, 0F, 0F, 0.0872665F);
      fingerright3 = new ModelRenderer(this, 12, 50);
      fingerright3.addBox(-2F, 20F, 0F, 1, 10, 1);
      fingerright3.setRotationPoint(-4F, -9F, 0F);
      fingerright3.setTextureSize(64, 64);
      fingerright3.mirror = true;
      setRotation(fingerright3, 0F, 0F, 0.1396263F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    fingerright4.render(f5);
    fingerright5.render(f5);
    fingerleft1.render(f5);
    fingerleft2.render(f5);
    fingerleft3.render(f5);
    fingerleft4.render(f5);
    fingerleft5.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    Shoulder1.render(f5);
    Shoulder2.render(f5);
    underbody.render(f5);
    rightarmunder.render(f5);
    leftarmunder.render(f5);
    fingerright1.render(f5);
    fingerright2.render(f5);
    fingerright3.render(f5);
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
