package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel372 extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer neck;
    ModelRenderer body;
    ModelRenderer Leg8;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Leg7;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    ModelRenderer eye1;
    ModelRenderer tail;
    ModelRenderer eye2;
  
  public SCPModel372()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Head = new ModelRenderer(this, 16, 9);
      Head.addBox(-2F, -1F, -8F, 4, 2, 5);
      Head.setRotationPoint(0F, 21F, -12F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 1, 9);
      neck.addBox(-2F, -3F, -3F, 4, 4, 3);
      neck.setRotationPoint(0F, 21F, -12F);
      neck.setTextureSize(64, 64);
      neck.mirror = true;
      setRotation(neck, 0F, 0F, 0F);
      body = new ModelRenderer(this, 1, 24);
      body.addBox(0F, 0F, 0F, 2, 2, 18);
      body.setRotationPoint(-1F, 20F, -12F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      Leg8 = new ModelRenderer(this, 18, 0);
      Leg8.addBox(-1F, -1F, -1F, 16, 1, 1);
      Leg8.setRotationPoint(2F, 21F, -7F);
      Leg8.setTextureSize(64, 64);
      Leg8.mirror = true;
      setRotation(Leg8, 0F, 0.5759587F, 0.1919862F);
      Leg6 = new ModelRenderer(this, 18, 0);
      Leg6.addBox(-1F, -1F, -1F, 16, 1, 1);
      Leg6.setRotationPoint(2F, 21F, -3F);
      Leg6.setTextureSize(64, 64);
      Leg6.mirror = true;
      setRotation(Leg6, 0F, 0.2792527F, 0.1919862F);
      Leg4 = new ModelRenderer(this, 18, 0);
      Leg4.addBox(-1F, -1F, -1F, 16, 1, 1);
      Leg4.setRotationPoint(1.5F, 21F, -1F);
      Leg4.setTextureSize(64, 64);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, -0.2792527F, 0.1919862F);
      Leg2 = new ModelRenderer(this, 18, 0);
      Leg2.addBox(-1F, -1F, -1F, 16, 1, 1);
      Leg2.setRotationPoint(1F, 21F, 2F);
      Leg2.setTextureSize(64, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, -0.5759587F, 0.1919862F);
      Leg7 = new ModelRenderer(this, 18, 0);
      Leg7.addBox(-15F, -1F, -1F, 16, 1, 1);
      Leg7.setRotationPoint(-2F, 21F, -7F);
      Leg7.setTextureSize(64, 64);
      Leg7.mirror = true;
      setRotation(Leg7, 0F, -0.5759587F, -0.1919862F);
      Leg5 = new ModelRenderer(this, 18, 0);
      Leg5.addBox(-15F, -1F, -1F, 16, 1, 1);
      Leg5.setRotationPoint(-2F, 21F, -3F);
      Leg5.setTextureSize(64, 64);
      Leg5.mirror = true;
      setRotation(Leg5, 0F, -0.2792527F, -0.1919862F);
      Leg3 = new ModelRenderer(this, 18, 0);
      Leg3.addBox(-15F, -1F, -1F, 16, 1, 1);
      Leg3.setRotationPoint(-1.5F, 21F, -1F);
      Leg3.setTextureSize(64, 64);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0.2792527F, -0.1919862F);
      Leg1 = new ModelRenderer(this, 18, 0);
      Leg1.addBox(-15F, -1F, -1F, 16, 1, 1);
      Leg1.setRotationPoint(-1F, 21F, 2F);
      Leg1.setTextureSize(64, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0.5759587F, -0.1919862F);
      eye1 = new ModelRenderer(this, 1, 17);
      eye1.addBox(-3.5F, -4F, -4F, 3, 3, 3);
      eye1.setRotationPoint(0F, 21F, -12F);
      eye1.setTextureSize(64, 64);
      eye1.mirror = true;
      setRotation(eye1, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 1, 45);
      tail.addBox(0F, 0F, 0F, 2, 2, 16);
      tail.setRotationPoint(-1F, 20F, 5F);
      tail.setTextureSize(64, 64);
      tail.mirror = true;
      setRotation(tail, 0.3839724F, 0F, 0F);
      eye2 = new ModelRenderer(this, 14, 17);
      eye2.addBox(0.5F, -4F, -4F, 3, 3, 3);
      eye2.setRotationPoint(0F, 21F, -12F);
      eye2.setTextureSize(64, 64);
      eye2.mirror = true;
      setRotation(eye2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Head.render(f5);
    neck.render(f5);
    body.render(f5);
    Leg8.render(f5);
    Leg6.render(f5);
    Leg4.render(f5);
    Leg2.render(f5);
    Leg7.render(f5);
    Leg5.render(f5);
    Leg3.render(f5);
    Leg1.render(f5);
    eye1.render(f5);
    tail.render(f5);
    eye2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
  {
      Head.rotateAngleY = par4 / (180F / (float)Math.PI);
      Head.rotateAngleX = par5 / (180F / (float)Math.PI);
      eye2.rotateAngleY = par4 / (180F / (float)Math.PI);
      eye2.rotateAngleX = par5 / (180F / (float)Math.PI);
      eye1.rotateAngleY = par4 / (180F / (float)Math.PI);
      eye1.rotateAngleX = par5 / (180F / (float)Math.PI);
      neck.rotateAngleY = par4 / (180F / (float)Math.PI);
      neck.rotateAngleX = par5 / (180F / (float)Math.PI);
      float f = ((float)Math.PI / 4F);
      Leg1.rotateAngleZ = -f;
      Leg2.rotateAngleZ = f;
      Leg3.rotateAngleZ = -f * 0.74F;
      Leg4.rotateAngleZ = f * 0.74F;
      Leg5.rotateAngleZ = -f * 0.74F;
      Leg6.rotateAngleZ = f * 0.74F;
      Leg7.rotateAngleZ = -f;
      Leg8.rotateAngleZ = f;
      float f1 = -0F;
      float f2 = 0.3926991F;
      Leg1.rotateAngleY = f2 * 2.0F + f1;
      Leg2.rotateAngleY = -f2 * 2.0F - f1;
      Leg3.rotateAngleY = f2 * 1.0F + f1;
      Leg4.rotateAngleY = -f2 * 1.0F - f1;
      Leg5.rotateAngleY = -f2 * 1.0F + f1;
      Leg6.rotateAngleY = f2 * 1.0F - f1;
      Leg7.rotateAngleY = -f2 * 2.0F + f1;
      Leg8.rotateAngleY = f2 * 2.0F - f1;
      float f3 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * par2;
      float f4 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * par2;
      float f5 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * par2;
      float f6 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * par2;
      float f7 = Math.abs(MathHelper.sin(par1 * 0.6662F + 0.0F) * 0.4F) * par2;
      float f8 = Math.abs(MathHelper.sin(par1 * 0.6662F + (float)Math.PI) * 0.4F) * par2;
      float f9 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * par2;
      float f10 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * par2;
      Leg1.rotateAngleY += f3;
      Leg2.rotateAngleY += -f3;
      Leg3.rotateAngleY += f4;
      Leg4.rotateAngleY += -f4;
      Leg5.rotateAngleY += f5;
      Leg6.rotateAngleY += -f5;
      Leg7.rotateAngleY += f6;
      Leg8.rotateAngleY += -f6;
      Leg1.rotateAngleZ += f7;
      Leg2.rotateAngleZ += -f7;
      Leg3.rotateAngleZ += f8;
      Leg4.rotateAngleZ += -f8;
      Leg5.rotateAngleZ += f9;
      Leg6.rotateAngleZ += -f9;
      Leg7.rotateAngleZ += f10;
      Leg8.rotateAngleZ += -f10;
  }

}
