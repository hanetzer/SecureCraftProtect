package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel019 extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer head;
    ModelRenderer armleft;
    ModelRenderer armright;
    ModelRenderer rimback;
    ModelRenderer rimleft;
    ModelRenderer rimfront;
    ModelRenderer rimright;
    ModelRenderer thingyleft;
    ModelRenderer thingyright;
  
  public SCPModel019()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      base = new ModelRenderer(this, 9, 39);
      base.addBox(0F, 0F, 0F, 14, 16, 8);
      base.setRotationPoint(-7F, 8F, -4F);
      base.setTextureSize(64, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      head = new ModelRenderer(this, 13, 25);
      head.addBox(0F, 0F, 0F, 12, 7, 6);
      head.setRotationPoint(-6F, 1F, -3F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      armleft = new ModelRenderer(this, 38, 14);
      armleft.addBox(0F, 0F, 0F, 1, 9, 1);
      armleft.setRotationPoint(-8F, 0F, 0F);
      armleft.setTextureSize(64, 64);
      armleft.mirror = true;
      setRotation(armleft, 0F, 0F, 0F);
      armright = new ModelRenderer(this, 43, 14);
      armright.addBox(0F, 0F, 0F, 1, 9, 1);
      armright.setRotationPoint(7F, 0F, 0F);
      armright.setTextureSize(64, 64);
      armright.mirror = true;
      setRotation(armright, 0F, 0F, 0F);
      rimback = new ModelRenderer(this, 1, 7);
      rimback.addBox(0F, 0F, 0F, 14, 2, 1);
      rimback.setRotationPoint(-7F, -1F, 3F);
      rimback.setTextureSize(64, 64);
      rimback.mirror = true;
      setRotation(rimback, 0F, 0F, 0F);
      rimleft = new ModelRenderer(this, 1, 11);
      rimleft.addBox(0F, 0F, 0F, 1, 2, 7);
      rimleft.setRotationPoint(-7F, -1F, -4F);
      rimleft.setTextureSize(64, 64);
      rimleft.mirror = true;
      setRotation(rimleft, 0F, 0F, 0F);
      rimfront = new ModelRenderer(this, 1, 21);
      rimfront.addBox(0F, 0F, 0F, 13, 2, 1);
      rimfront.setRotationPoint(-6F, -1F, -4F);
      rimfront.setTextureSize(64, 64);
      rimfront.mirror = true;
      setRotation(rimfront, 0F, 0F, 0F);
      rimright = new ModelRenderer(this, 18, 12);
      rimright.addBox(0F, 0F, 0F, 1, 2, 6);
      rimright.setRotationPoint(6F, -1F, -3F);
      rimright.setTextureSize(64, 64);
      rimright.mirror = true;
      setRotation(rimright, 0F, 0F, 0F);
      thingyleft = new ModelRenderer(this, 36, 10);
      thingyleft.addBox(0F, 0F, 0F, 2, 2, 1);
      thingyleft.setRotationPoint(-9F, -2F, 0F);
      thingyleft.setTextureSize(64, 64);
      thingyleft.mirror = true;
      setRotation(thingyleft, 0F, 0F, 0F);
      thingyright = new ModelRenderer(this, 43, 10);
      thingyright.addBox(0F, 0F, 0F, 2, 2, 1);
      thingyright.setRotationPoint(7F, -2F, 0F);
      thingyright.setTextureSize(64, 64);
      thingyright.mirror = true;
      setRotation(thingyright, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    head.render(f5);
    armleft.render(f5);
    armright.render(f5);
    rimback.render(f5);
    rimleft.render(f5);
    rimfront.render(f5);
    rimright.render(f5);
    thingyleft.render(f5);
    thingyright.render(f5);
  }
  
  public void renderModel(float f1)
  {
	  base.render(f1);
	    head.render(f1);
	    armleft.render(f1);
	    armright.render(f1);
	    rimback.render(f1);
	    rimfront.render(f1);
	    rimleft.render(f1);
	    rimright.render(f1);
	    thingyleft.render(f1);
	    thingyright.render(f1);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity par7Entity)
  {
    super.setRotationAngles(f1, f2, f3, f4, f5, f6, par7Entity);
  }

}
