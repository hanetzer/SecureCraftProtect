package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel058 extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer RearEnd;
    ModelRenderer Tentacle2;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Tentacle1;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Claw2;
    ModelRenderer Claw1;
    ModelRenderer tent1;
    ModelRenderer tent2;
    ModelRenderer RearerEnd;
    ModelRenderer Sting;
    ModelRenderer Stingend;
    ModelRenderer Stingendthing;
  
  public SCPModel058()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-3F, -3F, -3F, 6, 6, 6);
      Body.setRotationPoint(0F, 20F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      RearEnd = new ModelRenderer(this, 0, 12);
      RearEnd.addBox(-4F, -6F, 0F, 8, 8, 6);
      RearEnd.setRotationPoint(0F, 20F, 0F);
      RearEnd.setTextureSize(64, 32);
      RearEnd.mirror = true;
      setRotation(RearEnd, 0F, 0F, 0F);
      Tentacle2 = new ModelRenderer(this, 43, 0);
      Tentacle2.addBox(-1F, -1F, -1F, 9, 2, 1);
      Tentacle2.setRotationPoint(4F, 20F, -3F);
      Tentacle2.setTextureSize(64, 32);
      Tentacle2.mirror = true;
      setRotation(Tentacle2, 0F, 0.5759587F, 0.1396263F);
      Leg6 = new ModelRenderer(this, 19, 0);
      Leg6.addBox(-1F, -1F, -1F, 10, 1, 1);
      Leg6.setRotationPoint(4F, 20F, 1F);
      Leg6.setTextureSize(64, 32);
      Leg6.mirror = true;
      setRotation(Leg6, 0F, 0.2792527F, 0.2617994F);
      Leg4 = new ModelRenderer(this, 19, 0);
      Leg4.addBox(-1F, -1F, -1F, 8, 1, 1);
      Leg4.setRotationPoint(4F, 20F, 4F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, -0.2792527F, 0.2617994F);
      Tentacle1 = new ModelRenderer(this, 43, 0);
      Tentacle1.addBox(-8F, -1F, -1F, 9, 2, 1);
      Tentacle1.setRotationPoint(-4F, 20F, -3F);
      Tentacle1.setTextureSize(64, 32);
      Tentacle1.mirror = true;
      setRotation(Tentacle1, 0F, -0.5759587F, -0.1396263F);
      Leg5 = new ModelRenderer(this, 19, 0);
      Leg5.addBox(-10F, -1F, -1F, 10, 1, 1);
      Leg5.setRotationPoint(-3F, 20F, 2F);
      Leg5.setTextureSize(64, 32);
      Leg5.mirror = true;
      setRotation(Leg5, 0F, -0.2792527F, -0.2617994F);
      Leg3 = new ModelRenderer(this, 19, 0);
      Leg3.addBox(-8F, -1F, 0F, 8, 1, 1);
      Leg3.setRotationPoint(-4F, 20F, 4F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0.2792527F, -0.2617994F);
      Claw2 = new ModelRenderer(this, 51, 4);
      Claw2.addBox(1F, 0F, 7F, 5, 2, 1);
      Claw2.setRotationPoint(4F, 20F, -3F);
      Claw2.setTextureSize(64, 32);
      Claw2.mirror = true;
      setRotation(Claw2, 0F, 2.094395F, 0.0349066F);
      Claw1 = new ModelRenderer(this, 51, 4);
      Claw1.addBox(-6F, 0F, 7F, 5, 2, 1);
      Claw1.setRotationPoint(-4F, 20F, -3F);
      Claw1.setTextureSize(64, 32);
      Claw1.mirror = true;
      setRotation(Claw1, 0F, -2.094395F, -0.0349066F);
      tent1 = new ModelRenderer(this, 25, 7);
      tent1.addBox(-2F, -1F, -6F, 1, 1, 3);
      tent1.setRotationPoint(0F, 20F, 0F);
      tent1.setTextureSize(64, 32);
      tent1.mirror = true;
      setRotation(tent1, 0.0872665F, 0.1047198F, 0F);
      tent2 = new ModelRenderer(this, 25, 7);
      tent2.addBox(1F, -1F, -6F, 1, 1, 3);
      tent2.setRotationPoint(0F, 20F, 0F);
      tent2.setTextureSize(64, 32);
      tent2.mirror = true;
      setRotation(tent2, 0.0872665F, -0.1047198F, 0F);
      RearerEnd = new ModelRenderer(this, 29, 18);
      RearerEnd.addBox(-4F, -5F, 6F, 8, 7, 1);
      RearerEnd.setRotationPoint(0F, 20F, 0F);
      RearerEnd.setTextureSize(64, 32);
      RearerEnd.mirror = true;
      setRotation(RearerEnd, 0F, 0F, 0F);
      Sting = new ModelRenderer(this, 57, 21);
      Sting.addBox(-1F, -14F, 4F, 2, 9, 1);
      Sting.setRotationPoint(0F, 20F, 0F);
      Sting.setTextureSize(64, 32);
      Sting.mirror = true;
      setRotation(Sting, -0.2443461F, 0F, 0F);
      Stingend = new ModelRenderer(this, 51, 15);
      Stingend.addBox(-2F, -15F, 2F, 4, 3, 2);
      Stingend.setRotationPoint(0F, 20F, 0F);
      Stingend.setTextureSize(64, 32);
      Stingend.mirror = true;
      setRotation(Stingend, -0.2443461F, 0F, 0F);
      Stingendthing = new ModelRenderer(this, 55, 11);
      Stingendthing.addBox(-1F, -14F, 0F, 2, 1, 2);
      Stingendthing.setRotationPoint(0F, 20F, 0F);
      Stingendthing.setTextureSize(64, 32);
      Stingendthing.mirror = true;
      setRotation(Stingendthing, -0.2443461F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Body.render(f5);
    RearEnd.render(f5);
    Tentacle2.render(f5);
    Leg6.render(f5);
    Leg4.render(f5);
    Tentacle1.render(f5);
    Leg5.render(f5);
    Leg3.render(f5);
    Claw2.render(f5);
    Claw1.render(f5);
    tent1.render(f5);
    tent2.render(f5);
    RearerEnd.render(f5);
    Sting.render(f5);
    Stingend.render(f5);
    Stingendthing.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
  {
	  float var7 = ((float)Math.PI / 4F);
      this.Leg3.rotateAngleZ = -var7 * 0.74F;
      this.Leg4.rotateAngleZ = var7 * 0.74F;
      this.Leg5.rotateAngleZ = -var7 * 0.74F;
      this.Leg6.rotateAngleZ = var7 * 0.74F;
      float var8 = -0.0F;
      float var9 = 0.3926991F;
      this.Leg3.rotateAngleY = var9 * 1.0F + var8;
      this.Leg4.rotateAngleY = -var9 * 1.0F - var8;
      this.Leg5.rotateAngleY = -var9 * 1.0F + var8;
      this.Leg6.rotateAngleY = var9 * 1.0F - var8;
      float var10 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * par2;
      float var11 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * par2;
      float var12 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * par2;
      float var13 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * par2;
      float var14 = Math.abs(MathHelper.sin(par1 * 0.6662F + 0.0F) * 0.4F) * par2;
      float var15 = Math.abs(MathHelper.sin(par1 * 0.6662F + (float)Math.PI) * 0.4F) * par2;
      float var16 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * par2;
      float var17 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * par2;
      this.Leg3.rotateAngleY += var11;
      this.Leg4.rotateAngleY += -var11;
      this.Leg5.rotateAngleY += var12;
      this.Leg6.rotateAngleY += -var12;
      this.Leg3.rotateAngleZ += var15;
      this.Leg4.rotateAngleZ += -var15;
      this.Leg5.rotateAngleZ += var16;
      this.Leg6.rotateAngleZ += -var16;
  }

}
