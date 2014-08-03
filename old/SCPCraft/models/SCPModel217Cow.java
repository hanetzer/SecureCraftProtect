package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel217Cow extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer udders;
    ModelRenderer pegleg;
    ModelRenderer thing1;
    ModelRenderer thing2;
    ModelRenderer thing3;
    ModelRenderer thing6;
    ModelRenderer udders1;
    ModelRenderer udders2;
    ModelRenderer udders3;
    ModelRenderer udders4;
    ModelRenderer udders5;
    ModelRenderer udders6;
    ModelRenderer thing4;
    ModelRenderer thing5;
  
  public SCPModel217Cow()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 4F, -8F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 18, 4);
      body.addBox(-6F, -10F, -7F, 12, 18, 10);
      body.setRotationPoint(0F, 5F, 2F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
      leg1.setRotationPoint(-3F, 12F, 7F);
      leg1.setTextureSize(64, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
      leg2.setRotationPoint(3F, 12F, 7F);
      leg2.setTextureSize(64, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-3F, 0F, -3F, 4, 2, 4);
      leg3.setRotationPoint(-3F, 12F, -5F);
      leg3.setTextureSize(64, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-1F, 0F, -3F, 4, 12, 4);
      leg4.setRotationPoint(3F, 12F, -5F);
      leg4.setTextureSize(64, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      horn1 = new ModelRenderer(this, 22, 0);
      horn1.addBox(-4F, -5F, -4F, 1, 3, 1);
      horn1.setRotationPoint(0F, 3F, -7F);
      horn1.setTextureSize(64, 64);
      horn1.mirror = true;
      setRotation(horn1, 0F, 0F, 0F);
      horn2 = new ModelRenderer(this, 22, 0);
      horn2.addBox(3F, -5F, -4F, 1, 3, 1);
      horn2.setRotationPoint(0F, 3F, -7F);
      horn2.setTextureSize(64, 64);
      horn2.mirror = true;
      setRotation(horn2, 0F, 0F, 0F);
      udders = new ModelRenderer(this, 52, 0);
      udders.addBox(-2F, -3F, 0F, 4, 6, 2);
      udders.setRotationPoint(0F, 14F, 6F);
      udders.setTextureSize(64, 64);
      udders.mirror = true;
      setRotation(udders, 1.570796F, 0F, 0F);
      pegleg = new ModelRenderer(this, 1, 34);
      pegleg.addBox(-2F, 2F, -2F, 2, 10, 2);
      pegleg.setRotationPoint(-3F, 12F, -5F);
      pegleg.setTextureSize(64, 64);
      pegleg.mirror = true;
      setRotation(pegleg, 0F, 0F, 0F);
      thing1 = new ModelRenderer(this, 22, 0);
      thing1.addBox(-3F, -4F, -4F, 1, 1, 1);
      thing1.setRotationPoint(0F, 3F, -7F);
      thing1.setTextureSize(64, 64);
      thing1.mirror = true;
      setRotation(thing1, 0F, 0F, 0F);
      thing2 = new ModelRenderer(this, 22, 0);
      thing2.addBox(2F, -4F, -4F, 1, 1, 1);
      thing2.setRotationPoint(0F, 3F, -7F);
      thing2.setTextureSize(64, 64);
      thing2.mirror = true;
      setRotation(thing2, 0F, 0F, 0F);
      thing3 = new ModelRenderer(this, 22, 0);
      thing3.addBox(-5F, -4F, -4F, 1, 3, 1);
      thing3.setRotationPoint(0F, 3F, -7F);
      thing3.setTextureSize(64, 64);
      thing3.mirror = true;
      setRotation(thing3, 0F, 0F, 0F);
      thing6 = new ModelRenderer(this, 22, 0);
      thing6.addBox(-6F, -3F, -4F, 1, 1, 1);
      thing6.setRotationPoint(0F, 3F, -7F);
      thing6.setTextureSize(64, 64);
      thing6.mirror = true;
      setRotation(thing6, 0F, 0F, 0F);
      udders1 = new ModelRenderer(this, 52, 0);
      udders1.addBox(-3F, -3F, 0F, 1, 1, 2);
      udders1.setRotationPoint(0F, 14F, 6F);
      udders1.setTextureSize(64, 64);
      udders1.mirror = true;
      setRotation(udders1, 1.570796F, 0F, 0F);
      udders2 = new ModelRenderer(this, 52, 0);
      udders2.addBox(-1F, -4F, 0F, 1, 1, 2);
      udders2.setRotationPoint(0F, 14F, 6F);
      udders2.setTextureSize(64, 64);
      udders2.mirror = true;
      setRotation(udders2, 1.570796F, 0F, 0F);
      udders3 = new ModelRenderer(this, 52, 0);
      udders3.addBox(1F, -4F, 0F, 1, 1, 2);
      udders3.setRotationPoint(0F, 14F, 6F);
      udders3.setTextureSize(64, 64);
      udders3.mirror = true;
      setRotation(udders3, 1.570796F, 0F, 0F);
      udders4 = new ModelRenderer(this, 52, 0);
      udders4.addBox(2F, -2F, 0F, 1, 1, 2);
      udders4.setRotationPoint(0F, 14F, 6F);
      udders4.setTextureSize(64, 64);
      udders4.mirror = true;
      setRotation(udders4, 1.570796F, 0F, 0F);
      udders5 = new ModelRenderer(this, 52, 0);
      udders5.addBox(-2F, 3F, 0F, 1, 1, 2);
      udders5.setRotationPoint(0F, 14F, 6F);
      udders5.setTextureSize(64, 64);
      udders5.mirror = true;
      setRotation(udders5, 1.570796F, 0F, 0F);
      udders6 = new ModelRenderer(this, 52, 0);
      udders6.addBox(0F, 3F, 0F, 1, 1, 2);
      udders6.setRotationPoint(0F, 14F, 6F);
      udders6.setTextureSize(64, 64);
      udders6.mirror = true;
      setRotation(udders6, 1.570796F, 0F, 0F);
      thing4 = new ModelRenderer(this, 22, 0);
      thing4.addBox(4F, -4F, -4F, 1, 3, 1);
      thing4.setRotationPoint(0F, 3F, -7F);
      thing4.setTextureSize(64, 64);
      thing4.mirror = true;
      setRotation(thing4, 0F, 0F, 0F);
      thing5 = new ModelRenderer(this, 22, 0);
      thing5.addBox(5F, -3F, -4F, 1, 1, 1);
      thing5.setRotationPoint(0F, 3F, -7F);
      thing5.setTextureSize(64, 64);
      thing5.mirror = true;
      setRotation(thing5, 0F, 0F, 0F);
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
    udders.render(f5);
    pegleg.render(f5);
    thing1.render(f5);
    thing2.render(f5);
    thing3.render(f5);
    thing6.render(f5);
    udders1.render(f5);
    udders2.render(f5);
    udders3.render(f5);
    udders4.render(f5);
    udders5.render(f5);
    udders6.render(f5);
    thing4.render(f5);
    thing5.render(f5);
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
    head.rotateAngleX = f4 / (180F / (float)Math.PI);
    head.rotateAngleY = f3 / (180F / (float)Math.PI);
    horn1.rotateAngleX = f4 / (180F / (float)Math.PI);
    horn1.rotateAngleY = f3 / (180F / (float)Math.PI);
    horn2.rotateAngleX = f4 / (180F / (float)Math.PI);
    horn2.rotateAngleY = f3 / (180F / (float)Math.PI);
    thing1.rotateAngleX = f4 / (180F / (float)Math.PI);
    thing1.rotateAngleY = f3 / (180F / (float)Math.PI);
    thing2.rotateAngleX = f4 / (180F / (float)Math.PI);
    thing2.rotateAngleY = f3 / (180F / (float)Math.PI);
    thing3.rotateAngleX = f4 / (180F / (float)Math.PI);
    thing3.rotateAngleY = f3 / (180F / (float)Math.PI);
    thing4.rotateAngleX = f4 / (180F / (float)Math.PI);
    thing4.rotateAngleY = f3 / (180F / (float)Math.PI);
    thing5.rotateAngleX = f4 / (180F / (float)Math.PI);
    thing5.rotateAngleY = f3 / (180F / (float)Math.PI);
    thing6.rotateAngleX = f4 / (180F / (float)Math.PI);
    thing6.rotateAngleY = f3 / (180F / (float)Math.PI);
    leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;  
    pegleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
