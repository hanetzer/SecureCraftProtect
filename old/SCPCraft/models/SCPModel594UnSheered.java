package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel594UnSheered extends ModelBase
{
	
	private float field_78152_i;
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer horn3;
    ModelRenderer horn4;
    ModelRenderer horn5;
    ModelRenderer horn6;
  
  public SCPModel594UnSheered()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 18, 13);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 4F, -9F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 2, 28);
      body.addBox(-6F, -10F, -7F, 14, 19, 16);
      body.setRotationPoint(-1F, 10F, 1F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 1, 16);
      leg1.addBox(-2F, 0F, -2F, 3, 7, 3);
      leg1.setRotationPoint(-4F, 17F, 7F);
      leg1.setTextureSize(64, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 1, 16);
      leg2.addBox(-1F, 0F, -2F, 3, 7, 3);
      leg2.setRotationPoint(4F, 17F, 7F);
      leg2.setTextureSize(64, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 1, 16);
      leg3.addBox(-2F, 0F, -2F, 3, 7, 3);
      leg3.setRotationPoint(-4F, 17F, -5F);
      leg3.setTextureSize(64, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 1, 16);
      leg4.addBox(-1F, 0F, -2F, 3, 7, 3);
      leg4.setRotationPoint(4F, 17F, -5F);
      leg4.setTextureSize(64, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      horn1 = new ModelRenderer(this, 1, 1);
      horn1.addBox(-8F, -4F, -3F, 4, 2, 2);
      horn1.setRotationPoint(0F, 4F, -9F);
      horn1.setTextureSize(64, 64);
      horn1.mirror = true;
      setRotation(horn1, 0F, 0F, 0F);
      horn2 = new ModelRenderer(this, 50, 1);
      horn2.addBox(4F, -4F, -3F, 4, 2, 2);
      horn2.setRotationPoint(0F, 4F, -9F);
      horn2.setTextureSize(64, 64);
      horn2.mirror = true;
      setRotation(horn2, 0F, 0F, 0F);
      horn3 = new ModelRenderer(this, 1, 6);
      horn3.addBox(-8F, -2F, -3F, 2, 4, 2);
      horn3.setRotationPoint(0F, 4F, -9F);
      horn3.setTextureSize(64, 64);
      horn3.mirror = true;
      setRotation(horn3, 0F, 0F, 0F);
      horn4 = new ModelRenderer(this, 54, 6);
      horn4.addBox(6F, -2F, -3F, 2, 4, 2);
      horn4.setRotationPoint(0F, 4F, -9F);
      horn4.setTextureSize(64, 64);
      horn4.mirror = true;
      setRotation(horn4, 0F, 0F, 0F);
      horn5 = new ModelRenderer(this, 10, 9);
      horn5.addBox(-8F, 0F, -4F, 2, 2, 1);
      horn5.setRotationPoint(0F, 4F, -9F);
      horn5.setTextureSize(64, 64);
      horn5.mirror = true;
      setRotation(horn5, 0F, 0F, 0F);
      horn6 = new ModelRenderer(this, 47, 9);
      horn6.addBox(6F, 0F, -4F, 2, 2, 1);
      horn6.setRotationPoint(0F, 4F, -9F);
      horn6.setTextureSize(64, 64);
      horn6.mirror = true;
      setRotation(horn6, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    horn1.render(f5);
    horn2.render(f5);
    horn3.render(f5);
    horn4.render(f5);
    horn5.render(f5);
    horn6.render(f5);
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
      this.head.rotateAngleX = this.field_78152_i;
      head.rotateAngleX = par5 / (180F / (float)Math.PI);
      head.rotateAngleY = par4 / (180F / (float)Math.PI);
      horn1.rotateAngleX = par5 / (180F / (float)Math.PI);
      horn1.rotateAngleY = par4 / (180F / (float)Math.PI);
      horn2.rotateAngleX = par5 / (180F / (float)Math.PI);
      horn2.rotateAngleY = par4 / (180F / (float)Math.PI);
      horn3.rotateAngleX = par5 / (180F / (float)Math.PI);
      horn3.rotateAngleY = par4 / (180F / (float)Math.PI);
      horn4.rotateAngleX = par5 / (180F / (float)Math.PI);
      horn4.rotateAngleY = par4 / (180F / (float)Math.PI);
      horn5.rotateAngleX = par5 / (180F / (float)Math.PI);
      horn5.rotateAngleY = par4 / (180F / (float)Math.PI);
      horn6.rotateAngleX = par5 / (180F / (float)Math.PI);
      horn6.rotateAngleY = par4 / (180F / (float)Math.PI);  
      body.rotateAngleX = ((float)Math.PI / 2F);
      leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
  }

}
