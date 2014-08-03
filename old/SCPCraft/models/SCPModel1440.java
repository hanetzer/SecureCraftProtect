package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel1440 extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer epicbeard;
    ModelRenderer hat;
    ModelRenderer sideburn1;
    ModelRenderer sideburn2;
  
  public SCPModel1440()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 48);
      head.addBox(-4F, -7F, -5F, 8, 7, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 37, 46);
      body.addBox(-4F, 0F, -3F, 8, 12, 5);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 23);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 23);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 30);
      rightleg.addBox(-2F, 0F, -4F, 4, 12, 5);
      rightleg.setRotationPoint(-2F, 12F, 1F);
      rightleg.setTextureSize(64, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 30);
      leftleg.addBox(-2F, 0F, -3F, 4, 12, 5);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      epicbeard = new ModelRenderer(this, 1, 23);
      epicbeard.addBox(-5F, -1F, -5F, 10, 4, 2);
      epicbeard.setRotationPoint(0F, 0F, 0F);
      epicbeard.setTextureSize(64, 64);
      epicbeard.mirror = true;
      setRotation(epicbeard, 0F, 0F, 0F);
      hat = new ModelRenderer(this, 12, 0);
      hat.addBox(-5F, -14F, -6F, 10, 7, 10);
      hat.setRotationPoint(0F, 0F, 0F);
      hat.setTextureSize(64, 64);
      hat.mirror = true;
      setRotation(hat, 0F, 0F, 0F);
      sideburn1 = new ModelRenderer(this, 0, 0);
      sideburn1.addBox(-5F, -7F, -5F, 1, 6, 2);
      sideburn1.setRotationPoint(0F, 0F, 0F);
      sideburn1.setTextureSize(64, 64);
      sideburn1.mirror = true;
      setRotation(sideburn1, 0F, 0F, 0F);
      sideburn2 = new ModelRenderer(this, 0, 0);
      sideburn2.addBox(4F, -7F, -5F, 1, 6, 2);
      sideburn2.setRotationPoint(0F, 0F, 0F);
      sideburn2.setTextureSize(64, 64);
      sideburn2.mirror = true;
      setRotation(sideburn2, 0F, 0F, 0F);
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
    epicbeard.render(f5);
    hat.render(f5);
    sideburn1.render(f5);
    sideburn2.render(f5);
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
	sideburn1.rotateAngleY = f3 / (180F / (float)Math.PI);
	sideburn1.rotateAngleX = f4 / (180F / (float)Math.PI);
	sideburn2.rotateAngleY = f3 / (180F / (float)Math.PI);
	sideburn2.rotateAngleX = f4 / (180F / (float)Math.PI);
	epicbeard.rotateAngleY = f3 / (180F / (float)Math.PI);
	epicbeard.rotateAngleX = f4 / (180F / (float)Math.PI);
	hat.rotateAngleY = f3 / (180F / (float)Math.PI);
	hat.rotateAngleX = f4 / (180F / (float)Math.PI);
	rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	rightleg.rotateAngleY = 0.0F;
	leftleg.rotateAngleY = 0.0F;  
	rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
	leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
	rightarm.rotateAngleZ = 0.0F;
	leftarm.rotateAngleZ = 0.0F;
  }

}
