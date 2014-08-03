package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel997 extends ModelBase
{
  //fields
    ModelRenderer plate;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer foot3;
    ModelRenderer foot4;
    ModelRenderer underthing;
    ModelRenderer thing;
    ModelRenderer pipe;
    ModelRenderer ring;
    ModelRenderer neck;
    ModelRenderer top;
    ModelRenderer toprim;
    ModelRenderer spalk1;
    ModelRenderer spalk2;
    ModelRenderer rim1;
    ModelRenderer rim2;
    ModelRenderer rim3;
    ModelRenderer rim4;
    ModelRenderer rim5;
    ModelRenderer rim6;
  
  public SCPModel997()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      plate = new ModelRenderer(this, 4, 48);
      plate.addBox(0F, 0F, 0F, 14, 1, 14);
      plate.setRotationPoint(-7F, 21F, -7F);
      plate.setTextureSize(64, 64);
      plate.mirror = true;
      setRotation(plate, 0F, 0F, 0F);
      foot1 = new ModelRenderer(this, 0, 0);
      foot1.addBox(0F, 0F, 0F, 2, 2, 2);
      foot1.setRotationPoint(-7F, 22F, -7F);
      foot1.setTextureSize(64, 64);
      foot1.mirror = true;
      setRotation(foot1, 0F, 0F, 0F);
      foot2 = new ModelRenderer(this, 0, 0);
      foot2.addBox(0F, 0F, 0F, 2, 2, 2);
      foot2.setRotationPoint(5F, 22F, -7F);
      foot2.setTextureSize(64, 64);
      foot2.mirror = true;
      setRotation(foot2, 0F, 0F, 0F);
      foot3 = new ModelRenderer(this, 0, 0);
      foot3.addBox(0F, 0F, 0F, 2, 2, 2);
      foot3.setRotationPoint(-7F, 22F, 5F);
      foot3.setTextureSize(64, 64);
      foot3.mirror = true;
      setRotation(foot3, 0F, 0F, 0F);
      foot4 = new ModelRenderer(this, 0, 0);
      foot4.addBox(0F, 0F, 0F, 2, 2, 2);
      foot4.setRotationPoint(5F, 22F, 5F);
      foot4.setTextureSize(64, 64);
      foot4.mirror = true;
      setRotation(foot4, 0F, 0F, 0F);
      underthing = new ModelRenderer(this, 24, 41);
      underthing.addBox(0F, 0F, 0F, 4, 2, 4);
      underthing.setRotationPoint(-2F, 19F, -2F);
      underthing.setTextureSize(64, 64);
      underthing.mirror = true;
      setRotation(underthing, 0F, 0F, 0F);
      thing = new ModelRenderer(this, 20, 30);
      thing.addBox(0F, 0F, 0F, 6, 4, 6);
      thing.setRotationPoint(-3F, 15F, -3F);
      thing.setTextureSize(64, 64);
      thing.mirror = true;
      setRotation(thing, 0F, 0F, 0F);
      pipe = new ModelRenderer(this, 28, 20);
      pipe.addBox(0F, 0F, 0F, 2, 7, 2);
      pipe.setRotationPoint(-1F, 8F, -1F);
      pipe.setTextureSize(64, 64);
      pipe.mirror = true;
      setRotation(pipe, 0F, 0F, 0F);
      ring = new ModelRenderer(this, 24, 12);
      ring.addBox(0F, 0F, 0F, 4, 3, 4);
      ring.setRotationPoint(-2F, 5F, -2F);
      ring.setTextureSize(64, 64);
      ring.mirror = true;
      setRotation(ring, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 28, 5);
      neck.addBox(0F, 0F, 0F, 2, 4, 2);
      neck.setRotationPoint(-1F, 1F, -1F);
      neck.setTextureSize(64, 64);
      neck.mirror = true;
      setRotation(neck, 0F, 0F, 0F);
      top = new ModelRenderer(this, 9, 5);
      top.addBox(0F, 0F, 0F, 4, 1, 4);
      top.setRotationPoint(-2F, 0F, -2F);
      top.setTextureSize(64, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      toprim = new ModelRenderer(this, 27, 2);
      toprim.addBox(0F, 0F, 0F, 4, 1, 1);
      toprim.setRotationPoint(-2F, -4F, 0F);
      toprim.setTextureSize(64, 64);
      toprim.mirror = true;
      setRotation(toprim, 0F, 0F, 0F);
      spalk1 = new ModelRenderer(this, 0, 13);
      spalk1.addBox(0F, 0F, 0F, 1, 5, 1);
      spalk1.setRotationPoint(-3F, -4F, 0F);
      spalk1.setTextureSize(64, 64);
      spalk1.mirror = true;
      setRotation(spalk1, 0F, 0F, 0F);
      spalk2 = new ModelRenderer(this, 0, 13);
      spalk2.addBox(0F, 0F, 0F, 1, 5, 1);
      spalk2.setRotationPoint(2F, -4F, 0F);
      spalk2.setTextureSize(64, 64);
      spalk2.mirror = true;
      setRotation(spalk2, 0F, 0F, 0F);
      rim1 = new ModelRenderer(this, 8, 11);
      rim1.addBox(0F, 0F, 0F, 6, 1, 1);
      rim1.setRotationPoint(-9F, -4F, 0F);
      rim1.setTextureSize(64, 64);
      rim1.mirror = true;
      setRotation(rim1, 0F, 0F, 0F);
      rim2 = new ModelRenderer(this, 8, 11);
      rim2.addBox(0F, 0F, 0F, 6, 1, 1);
      rim2.setRotationPoint(3F, -4F, 0F);
      rim2.setTextureSize(64, 64);
      rim2.mirror = true;
      setRotation(rim2, 0F, 0F, 0F);
      rim3 = new ModelRenderer(this, 1, 20);
      rim3.addBox(0F, 0F, 0F, 1, 11, 1);
      rim3.setRotationPoint(-9F, -3F, 0F);
      rim3.setTextureSize(64, 64);
      rim3.mirror = true;
      setRotation(rim3, 0F, 0F, 0F);
      rim4 = new ModelRenderer(this, 1, 20);
      rim4.addBox(0F, 0F, 0F, 1, 11, 1);
      rim4.setRotationPoint(8F, -3F, 0F);
      rim4.setTextureSize(64, 64);
      rim4.mirror = true;
      setRotation(rim4, 0F, 0F, 0F);
      rim5 = new ModelRenderer(this, 39, 1);
      rim5.addBox(0F, 0F, 0F, 10, 1, 1);
      rim5.setRotationPoint(-9F, 8F, 0F);
      rim5.setTextureSize(64, 64);
      rim5.mirror = true;
      setRotation(rim5, 0F, 0F, -0.9075712F);
      rim6 = new ModelRenderer(this, 39, 1);
      rim6.addBox(0F, 0F, 0F, 9, 1, 1);
      rim6.setRotationPoint(3F, 0F, 0F);
      rim6.setTextureSize(64, 64);
      rim6.mirror = true;
      setRotation(rim6, 0F, 0F, 0.9075712F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    plate.render(f5);
    foot1.render(f5);
    foot2.render(f5);
    foot3.render(f5);
    foot4.render(f5);
    underthing.render(f5);
    thing.render(f5);
    pipe.render(f5);
    ring.render(f5);
    neck.render(f5);
    top.render(f5);
    toprim.render(f5);
    spalk1.render(f5);
    spalk2.render(f5);
    rim1.render(f5);
    rim2.render(f5);
    rim3.render(f5);
    rim4.render(f5);
    rim5.render(f5);
    rim6.render(f5);
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
  }

}
