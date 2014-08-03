package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel049 extends ModelBase
{
  //fields
    ModelRenderer Thing;
    ModelRenderer MaskTop;
    ModelRenderer MaskSide;
    ModelRenderer MaskBottom;
    ModelRenderer MaskSideleft;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Nose;
    ModelRenderer NoseTop;
  
  public SCPModel049()
  {
    textureWidth = 64;
    textureHeight = 64;
    
 
      Thing = new ModelRenderer(this, 18, 19);
      Thing.addBox(-4F, 4.5F, 0F, 8, 4, 4);
      Thing.setRotationPoint(0F, 0F, 0F);
      Thing.setTextureSize(64, 32);
      Thing.mirror = true;
      setRotation(Thing, -0.7679449F, 0F, 0F);
      Thing.mirror = false;
      MaskTop = new ModelRenderer(this, 2, 7);
      MaskTop.addBox(-4F, -10F, -5F, 8, 1, 1);
      MaskTop.setRotationPoint(0F, 0F, 0F);
      MaskTop.setTextureSize(64, 32);
      MaskTop.mirror = true;
      setRotation(MaskTop, 0F, 0F, 0F);
      MaskSide = new ModelRenderer(this, 1, 10);
      MaskSide.addBox(-4F, -9F, -5F, 1, 9, 1);
      MaskSide.setRotationPoint(0F, 0F, 0F);
      MaskSide.setTextureSize(64, 32);
      MaskSide.mirror = true;
      setRotation(MaskSide, 0F, 0F, 0F);
      MaskBottom = new ModelRenderer(this, 3, 4);
      MaskBottom.addBox(-3F, -1F, -5F, 7, 1, 1);
      MaskBottom.setRotationPoint(0F, 0F, 0F);
      MaskBottom.setTextureSize(64, 32);
      MaskBottom.mirror = true;
      setRotation(MaskBottom, 0F, 0F, 0F);
      MaskSideleft = new ModelRenderer(this, 6, 11);
      MaskSideleft.addBox(3F, -9F, -5F, 1, 8, 1);
      MaskSideleft.setRotationPoint(0F, 0F, 0F);
      MaskSideleft.setTextureSize(64, 32);
      MaskSideleft.mirror = true;
      setRotation(MaskSideleft, 0F, 0F, 0F);
      head = new ModelRenderer(this, 31, 0);
      head.addBox(-4F, -10F, -4F, 8, 10, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 28);
      body.addBox(-4F, 0F, -3F, 8, 19, 6);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 0, 21);
      rightarm.addBox(-3F, -1F, -1F, 4, 8, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -0.8203047F, 0F, 0F);
      leftarm = new ModelRenderer(this, 46, 25);
      leftarm.addBox(-1F, -1F, -1F, 4, 8, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, -0.8203047F, 0F, 0F);
      rightleg = new ModelRenderer(this, 13, 54);
      rightleg.addBox(-2F, 0F, -2F, 4, 5, 4);
      rightleg.setRotationPoint(-2F, 19F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 30, 54);
      leftleg.addBox(-2F, 0F, -2F, 4, 5, 4);
      leftleg.setRotationPoint(2F, 19F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Nose = new ModelRenderer(this, 1, 40);
      Nose.addBox(-1F, -5F, -6F, 2, 5, 1);
      Nose.setRotationPoint(0F, 0F, 0F);
      Nose.setTextureSize(64, 32);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
      NoseTop = new ModelRenderer(this, 1, 47);
      NoseTop.addBox(-1F, 0F, -6F, 2, 2, 1);
      NoseTop.setRotationPoint(0F, 0F, 0F);
      NoseTop.setTextureSize(64, 32);
      NoseTop.mirror = true;
      setRotation(NoseTop, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Thing.render(f5);
    MaskTop.render(f5);
    MaskSide.render(f5);
    MaskBottom.render(f5);
    MaskSideleft.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Nose.render(f5);
    NoseTop.render(f5);
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
    MaskTop.rotateAngleY = par4 / (180F / (float)Math.PI);
    MaskTop.rotateAngleX = par5 / (180F / (float)Math.PI);
    MaskSide.rotateAngleY = par4 / (180F / (float)Math.PI);
    MaskSide.rotateAngleX = par5 / (180F / (float)Math.PI);
    MaskBottom.rotateAngleY = par4 / (180F / (float)Math.PI);
    MaskBottom.rotateAngleX = par5 / (180F / (float)Math.PI);
    MaskSideleft.rotateAngleY = par4 / (180F / (float)Math.PI);
    MaskSideleft.rotateAngleX = par5 / (180F / (float)Math.PI);
    Nose.rotateAngleY = par4 / (180F / (float)Math.PI);
    Nose.rotateAngleX = par5 / (180F / (float)Math.PI);
    NoseTop.rotateAngleY = par4 / (180F / (float)Math.PI);
    NoseTop.rotateAngleX = par5 / (180F / (float)Math.PI);
    rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2 * 0.5F;
    leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2 * 0.5F;
    rightleg.rotateAngleY = 0.0F;
    leftleg.rotateAngleY = 0.0F;
  }

}
