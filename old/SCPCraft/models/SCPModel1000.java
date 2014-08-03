package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel1000 extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer jawup;
    ModelRenderer jawdown;
    ModelRenderer leftfoot;
    ModelRenderer rightfoot;
   public boolean isAttacking;
  
  public SCPModel1000()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 1, 1);
      head.addBox(-4F, -8F, -4F, 8, 8, 7);
      head.setRotationPoint(0F, -2F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 1, 32);
      body.addBox(-5F, 0F, -2F, 10, 15, 4);
      body.setRotationPoint(0F, -2F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 16, 4);
      rightarm.setRotationPoint(-6F, 0F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 16, 4);
      leftarm.setRotationPoint(6F, 0F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 40, 39);
      rightleg.addBox(-2F, 0F, -2F, 4, 6, 4);
      rightleg.setRotationPoint(-2F, 13F, 0F);
      rightleg.setTextureSize(64, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 40, 39);
      leftleg.addBox(-2F, 0F, -2F, 4, 6, 4);
      leftleg.setRotationPoint(2F, 13F, 0F);
      leftleg.setTextureSize(64, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      jawup = new ModelRenderer(this, 1, 17);
      jawup.addBox(-5F, -4F, -5F, 10, 2, 4);
      jawup.setRotationPoint(0F, -2F, 0F);
      jawup.setTextureSize(64, 64);
      jawup.mirror = true;
      setRotation(jawup, 0F, 0F, 0F);
      jawdown = new ModelRenderer(this, 1, 24);
      jawdown.addBox(-5F, -2F, -5F, 10, 2, 4);
      jawdown.setRotationPoint(0F, -2F, 0F);
      jawdown.setTextureSize(64, 64);
      jawdown.mirror = true;
      setRotation(jawdown, 0F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 38, 3);
      leftfoot.addBox(-2F, 6F, -3F, 5, 5, 5);
      leftfoot.setRotationPoint(2F, 13F, 0F);
      leftfoot.setTextureSize(64, 64);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, 0F, 0F);
      rightfoot = new ModelRenderer(this, 38, 3);
      rightfoot.addBox(-3F, 6F, -3F, 5, 5, 5);
      rightfoot.setRotationPoint(-2F, 13F, 0F);
      rightfoot.setTextureSize(64, 64);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    jawup.render(f5);
    jawdown.render(f5);
    leftfoot.render(f5);
    rightfoot.render(f5);
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
    rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	rightleg.rotateAngleY = 0.0F;
	leftleg.rotateAngleY = 0.0F;
	jawup.rotateAngleY = f3 / (180F / (float)Math.PI);
    jawup.rotateAngleX = f4 / (180F / (float)Math.PI);
    jawdown.rotateAngleY = f3 / (180F / (float)Math.PI);
    jawdown.rotateAngleX = f4 / (180F / (float)Math.PI);
    rightfoot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   	leftfoot.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
   	rightfoot.rotateAngleY = 0.0F;
   	leftfoot.rotateAngleY = 0.0F;
    rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    rightarm.rotateAngleZ = 0.0F;
    leftarm.rotateAngleZ = 0.0F;
  }
}
