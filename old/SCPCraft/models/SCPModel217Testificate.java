package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel217Testificate extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Thing;
    ModelRenderer head;
    ModelRenderer nose;
    ModelRenderer CW1;
    ModelRenderer CW11;
    ModelRenderer CW12;
    ModelRenderer CW13;
    ModelRenderer CW14;
    ModelRenderer CW15;
    ModelRenderer CW16;
    ModelRenderer CW17;
    ModelRenderer CW18;
  
  public SCPModel217Testificate()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      body = new ModelRenderer(this, 16, 38);
      body.addBox(-4F, 0F, -3F, 8, 19, 6);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -1F, -1F, 4, 8, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, -0.8203047F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -1F, -1F, 4, 8, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, -0.8203047F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 24);
      rightleg.addBox(-2F, 0F, -2F, 4, 5, 4);
      rightleg.setRotationPoint(-2F, 19F, 0F);
      rightleg.setTextureSize(64, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 34);
      leftleg.addBox(-1F, 0F, -1F, 2, 5, 2);
      leftleg.setRotationPoint(2F, 19F, 0F);
      leftleg.setTextureSize(64, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Thing = new ModelRenderer(this, 39, 29);
      Thing.addBox(-4F, 4.5F, 0F, 8, 4, 4);
      Thing.setRotationPoint(0F, 0F, 0F);
      Thing.setTextureSize(64, 64);
      Thing.mirror = true;
      setRotation(Thing, -0.7679449F, 0F, 0F);
      head = new ModelRenderer(this, 1, 1);
      head.addBox(-4F, -10F, -4F, 8, 10, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      nose = new ModelRenderer(this, 19, 20);
      nose.addBox(-1F, -3F, -6F, 2, 4, 2);
      nose.setRotationPoint(0F, 0F, 0F);
      nose.setTextureSize(64, 64);
      nose.mirror = true;
      setRotation(nose, 0F, 0F, 0F);
      CW1 = new ModelRenderer(this, 26, 1);
      CW1.addBox(-5F, -11F, -1F, 3, 3, 2);
      CW1.setRotationPoint(0F, 0F, 0F);
      CW1.setTextureSize(64, 64);
      CW1.mirror = true;
      setRotation(CW1, 0F, 0F, 0F);
      CW11 = new ModelRenderer(this, 37, 1);
      CW11.addBox(-6F, -9F, -1F, 1, 1, 1);
      CW11.setRotationPoint(0F, 0F, 0F);
      CW11.setTextureSize(64, 64);
      CW11.mirror = true;
      setRotation(CW11, 0F, 0F, 0F);
      CW12 = new ModelRenderer(this, 37, 1);
      CW12.addBox(-6F, -10F, 0F, 1, 1, 1);
      CW12.setRotationPoint(0F, 0F, 0F);
      CW12.setTextureSize(64, 64);
      CW12.mirror = true;
      setRotation(CW12, 0F, 0F, 0F);
      CW13 = new ModelRenderer(this, 37, 1);
      CW13.addBox(-6F, -11F, -1F, 1, 1, 1);
      CW13.setRotationPoint(0F, 0F, 0F);
      CW13.setTextureSize(64, 64);
      CW13.mirror = true;
      setRotation(CW13, 0F, 0F, 0F);
      CW14 = new ModelRenderer(this, 37, 1);
      CW14.addBox(-5F, -12F, 0F, 1, 1, 1);
      CW14.setRotationPoint(0F, 0F, 0F);
      CW14.setTextureSize(64, 64);
      CW14.mirror = true;
      setRotation(CW14, 0F, 0F, 0F);
      CW15 = new ModelRenderer(this, 37, 1);
      CW15.addBox(-4F, -12F, -1F, 1, 1, 1);
      CW15.setRotationPoint(0F, 0F, 0F);
      CW15.setTextureSize(64, 64);
      CW15.mirror = true;
      setRotation(CW15, 0F, 0F, 0F);
      CW16 = new ModelRenderer(this, 37, 1);
      CW16.addBox(-3F, -12F, 0F, 1, 1, 1);
      CW16.setRotationPoint(0F, 0F, 0F);
      CW16.setTextureSize(64, 64);
      CW16.mirror = true;
      setRotation(CW16, 0F, 0F, 0F);
      CW17 = new ModelRenderer(this, 37, 1);
      CW17.addBox(-5F, -8F, 0F, 1, 1, 1);
      CW17.setRotationPoint(0F, 0F, 0F);
      CW17.setTextureSize(64, 64);
      CW17.mirror = true;
      setRotation(CW17, 0F, 0F, 0F);
      CW18 = new ModelRenderer(this, 37, 1);
      CW18.addBox(-2F, -11F, -1F, 1, 1, 1);
      CW18.setRotationPoint(0F, 0F, 0F);
      CW18.setTextureSize(64, 64);
      CW18.mirror = true;
      setRotation(CW18, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Thing.render(f5);
    head.render(f5);
    nose.render(f5);
    CW1.render(f5);
    CW11.render(f5);
    CW12.render(f5);
    CW13.render(f5);
    CW14.render(f5);
    CW15.render(f5);
    CW16.render(f5);
    CW17.render(f5);
    CW18.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
    head.rotateAngleY = par4 / (180F / (float)Math.PI);
    head.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW1.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW1.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW11.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW11.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW12.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW12.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW13.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW13.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW14.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW14.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW15.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW15.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW16.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW16.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW17.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW17.rotateAngleX = par5 / (180F / (float)Math.PI);
    CW18.rotateAngleY = par4 / (180F / (float)Math.PI);
    CW18.rotateAngleX = par5 / (180F / (float)Math.PI);
    nose.rotateAngleY = par4 / (180F / (float)Math.PI);
    nose.rotateAngleX = par5 / (180F / (float)Math.PI);
    rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2 * 0.5F;
    leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2 * 0.5F;
    rightleg.rotateAngleY = 0.0F;
    leftleg.rotateAngleY = 0.0F;
  }

}
