package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SCPModel111 extends ModelBase
{
  //fields
    ModelRenderer Tail;
    ModelRenderer End;
    ModelRenderer Neck;
    ModelRenderer NeckPiece;
    ModelRenderer Head;
    ModelRenderer Snout;
    ModelRenderer Spikeythingleft;
    ModelRenderer Spikeythingright;
    ModelRenderer Swirlleft;
    ModelRenderer Swirlright;
    ModelRenderer SwirlEndleft;
    ModelRenderer SwirlEndright;
  
  public SCPModel111()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Tail = new ModelRenderer(this, 19, 43);
      Tail.addBox(-3F, -2F, -13F, 6, 4, 16);
      Tail.setRotationPoint(0F, 22F, 5F);
      Tail.setTextureSize(64, 64);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      End = new ModelRenderer(this, 0, 33);
      End.addBox(-3F, -1F, 0F, 6, 3, 6);
      End.setRotationPoint(0F, 22F, 8F);
      End.setTextureSize(64, 64);
      End.mirror = true;
      setRotation(End, 0F, 0F, 0F);
      Neck = new ModelRenderer(this, 46, 24);
      Neck.addBox(-2F, -8F, -2F, 4, 8, 4);
      Neck.setRotationPoint(0F, 20F, -7F);
      Neck.setTextureSize(64, 64);
      Neck.mirror = true;
      setRotation(Neck, 0F, 0F, 0F);
      NeckPiece = new ModelRenderer(this, 52, 37);
      NeckPiece.addBox(-2F, 0F, -2F, 4, 2, 1);
      NeckPiece.setRotationPoint(0F, 20F, -7F);
      NeckPiece.setTextureSize(64, 64);
      NeckPiece.mirror = true;
      setRotation(NeckPiece, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 28, 5);
      Head.addBox(-2F, -4F, -3F, 4, 4, 6);
      Head.setRotationPoint(0F, 12F, -7F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Snout = new ModelRenderer(this, 49, 9);
      Snout.addBox(-2F, -3F, -6F, 4, 3, 3);
      Snout.setRotationPoint(0F, 12F, -7F);
      Snout.setTextureSize(64, 64);
      Snout.mirror = true;
      setRotation(Snout, 0F, 0F, 0F);
      Spikeythingleft = new ModelRenderer(this, 1, 20);
      Spikeythingleft.addBox(-3F, -4F, 1F, 1, 1, 5);
      Spikeythingleft.setRotationPoint(0F, 12F, -7F);
      Spikeythingleft.setTextureSize(64, 64);
      Spikeythingleft.mirror = true;
      setRotation(Spikeythingleft, 0F, 0F, 0F);
      Spikeythingright = new ModelRenderer(this, 1, 1);
      Spikeythingright.addBox(2F, -4F, 1F, 1, 1, 5);
      Spikeythingright.setRotationPoint(0F, 12F, -7F);
      Spikeythingright.setTextureSize(64, 64);
      Spikeythingright.mirror = true;
      setRotation(Spikeythingright, 0F, 0F, 0F);
      Swirlleft = new ModelRenderer(this, 1, 27);
      Swirlleft.addBox(-3F, -3F, 5F, 1, 4, 1);
      Swirlleft.setRotationPoint(0F, 12F, -7F);
      Swirlleft.setTextureSize(64, 64);
      Swirlleft.mirror = true;
      setRotation(Swirlleft, 0F, 0F, 0F);
      Swirlright = new ModelRenderer(this, 1, 8);
      Swirlright.addBox(2F, -3F, 5F, 1, 4, 1);
      Swirlright.setRotationPoint(0F, 12F, -7F);
      Swirlright.setTextureSize(64, 64);
      Swirlright.mirror = true;
      setRotation(Swirlright, 0F, 0F, 0F);
      SwirlEndleft = new ModelRenderer(this, 6, 30);
      SwirlEndleft.addBox(-3F, 0F, 4F, 1, 1, 1);
      SwirlEndleft.setRotationPoint(0F, 12F, -7F);
      SwirlEndleft.setTextureSize(64, 64);
      SwirlEndleft.mirror = true;
      setRotation(SwirlEndleft, 0F, 0F, 0F);
      SwirlEndright = new ModelRenderer(this, 6, 11);
      SwirlEndright.addBox(2F, 0F, 4F, 1, 1, 1);
      SwirlEndright.setRotationPoint(0F, 12F, -7F);
      SwirlEndright.setTextureSize(64, 64);
      SwirlEndright.mirror = true;
      setRotation(SwirlEndright, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Tail.render(f5);
    End.render(f5);
    Neck.render(f5);
    NeckPiece.render(f5);
    Head.render(f5);
    Snout.render(f5);
    Spikeythingleft.render(f5);
    Spikeythingright.render(f5);
    Swirlleft.render(f5);
    Swirlright.render(f5);
    SwirlEndleft.render(f5);
    SwirlEndright.render(f5);
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
    Head.rotateAngleY = f3 / (180F / (float)Math.PI);
    Head.rotateAngleX = f4 / (180F / (float)Math.PI);
    Snout.rotateAngleY = f3 / (180F / (float)Math.PI);
    Snout.rotateAngleX = f4 / (180F / (float)Math.PI);
    Spikeythingleft.rotateAngleY = f3 / (180F / (float)Math.PI);
    Spikeythingleft.rotateAngleX = f4 / (180F / (float)Math.PI);
    Spikeythingright.rotateAngleY = f3 / (180F / (float)Math.PI);
    Spikeythingright.rotateAngleX = f4 / (180F / (float)Math.PI);
    Swirlleft.rotateAngleY = f3 / (180F / (float)Math.PI);
    Swirlleft.rotateAngleX = f4 / (180F / (float)Math.PI);
    Swirlright.rotateAngleY = f3 / (180F / (float)Math.PI);
    Swirlright.rotateAngleX = f4 / (180F / (float)Math.PI);
    SwirlEndleft.rotateAngleY = f3 / (180F / (float)Math.PI);
    SwirlEndleft.rotateAngleX = f4 / (180F / (float)Math.PI);
    SwirlEndright.rotateAngleY = f3 / (180F / (float)Math.PI);
    SwirlEndright.rotateAngleX = f4 / (180F / (float)Math.PI);
    
  }

}
