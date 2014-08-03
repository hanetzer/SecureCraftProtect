package securecraftprotect.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTileLightBulb extends ModelBase
{
    // fields
    ModelRenderer Bulb;
    ModelRenderer Wire;
    ModelRenderer LampStrip1;
    ModelRenderer LampStrip5;
    ModelRenderer LampStrip4;
    ModelRenderer LampStrip7;
    ModelRenderer LampStrip2;
    ModelRenderer LampStrip8;
    ModelRenderer LampStrip9;
    ModelRenderer LampStrip11;
    ModelRenderer LampStrip3;
    ModelRenderer LampStrip6;
    ModelRenderer LampStrip10;
    ModelRenderer LampStrip12;
    
    public ModelTileLightBulb()
    {
        textureWidth = 32;
        textureHeight = 32;
        
        Bulb = new ModelRenderer(this, 24, 10);
        Bulb.addBox(0F, 0F, 0F, 2, 2, 2);
        Bulb.setRotationPoint(-1F, 22F, -1F);
        Bulb.setTextureSize(32, 32);
        Bulb.mirror = true;
        setRotation(Bulb, 0F, 0F, 0F);
        Wire = new ModelRenderer(this, 28, 3);
        Wire.addBox(0.5F, 0F, 0.5F, 1, 5, 1);
        Wire.setRotationPoint(-1F, 17F, -1F);
        Wire.setTextureSize(32, 32);
        Wire.mirror = true;
        setRotation(Wire, 0F, 0F, 0F);
        LampStrip1 = new ModelRenderer(this, 0, 0);
        LampStrip1.addBox(0F, 0F, 0F, 1, 1, 4);
        LampStrip1.setRotationPoint(1F, 21F, -2F);
        LampStrip1.setTextureSize(32, 32);
        LampStrip1.mirror = true;
        setRotation(LampStrip1, 0F, 0F, 0F);
        LampStrip5 = new ModelRenderer(this, 0, 0);
        LampStrip5.addBox(0F, 0F, 0F, 1, 1, 4);
        LampStrip5.setRotationPoint(-2F, 21F, -2F);
        LampStrip5.setTextureSize(32, 32);
        LampStrip5.mirror = true;
        setRotation(LampStrip5, 0F, 0F, 0F);
        LampStrip4 = new ModelRenderer(this, 0, 6);
        LampStrip4.addBox(0F, 0F, 0F, 2, 1, 1);
        LampStrip4.setRotationPoint(-1F, 21F, -2F);
        LampStrip4.setTextureSize(32, 32);
        LampStrip4.mirror = true;
        setRotation(LampStrip4, 0F, 0F, 0F);
        LampStrip7 = new ModelRenderer(this, 0, 6);
        LampStrip7.addBox(0F, 0F, 0F, 2, 1, 1);
        LampStrip7.setRotationPoint(-1F, 21F, 1F);
        LampStrip7.setTextureSize(32, 32);
        LampStrip7.mirror = true;
        setRotation(LampStrip7, 0F, 0F, 0F);
        LampStrip2 = new ModelRenderer(this, 11, 0);
        LampStrip2.addBox(0F, 0F, 0F, 1, 1, 6);
        LampStrip2.setRotationPoint(2F, 22F, -3F);
        LampStrip2.setTextureSize(32, 32);
        LampStrip2.mirror = true;
        setRotation(LampStrip2, 0F, 0F, 0F);
        LampStrip8 = new ModelRenderer(this, 11, 8);
        LampStrip8.addBox(0F, 0F, 0F, 4, 1, 1);
        LampStrip8.setRotationPoint(-2F, 22F, 2F);
        LampStrip8.setTextureSize(32, 32);
        LampStrip8.mirror = true;
        setRotation(LampStrip8, 0F, 0F, 0F);
        LampStrip9 = new ModelRenderer(this, 11, 0);
        LampStrip9.addBox(0F, 0F, 0F, 1, 1, 6);
        LampStrip9.setRotationPoint(-3F, 22F, -3F);
        LampStrip9.setTextureSize(32, 32);
        LampStrip9.mirror = true;
        setRotation(LampStrip9, 0F, 0F, 0F);
        LampStrip11 = new ModelRenderer(this, 11, 8);
        LampStrip11.addBox(0F, 0F, 0F, 4, 1, 1);
        LampStrip11.setRotationPoint(-2F, 22F, -3F);
        LampStrip11.setTextureSize(32, 32);
        LampStrip11.mirror = true;
        setRotation(LampStrip11, 0F, 0F, 0F);
        LampStrip3 = new ModelRenderer(this, 0, 21);
        LampStrip3.addBox(0F, 0F, 0F, 6, 1, 1);
        LampStrip3.setRotationPoint(-3F, 23F, 3F);
        LampStrip3.setTextureSize(32, 32);
        LampStrip3.mirror = true;
        setRotation(LampStrip3, 0F, 0F, 0F);
        LampStrip6 = new ModelRenderer(this, 0, 11);
        LampStrip6.addBox(0F, 0F, 0F, 1, 1, 8);
        LampStrip6.setRotationPoint(3F, 23F, -4F);
        LampStrip6.setTextureSize(32, 32);
        LampStrip6.mirror = true;
        setRotation(LampStrip6, 0F, 0F, 0F);
        LampStrip10 = new ModelRenderer(this, 0, 11);
        LampStrip10.addBox(0F, 0F, 0F, 1, 1, 8);
        LampStrip10.setRotationPoint(-4F, 23F, -4F);
        LampStrip10.setTextureSize(32, 32);
        LampStrip10.mirror = true;
        setRotation(LampStrip10, 0F, 0F, 0F);
        LampStrip12 = new ModelRenderer(this, 0, 21);
        LampStrip12.addBox(0F, 0F, 0F, 6, 1, 1);
        LampStrip12.setRotationPoint(-3F, 23F, -4F);
        LampStrip12.setTextureSize(32, 32);
        LampStrip12.mirror = true;
        setRotation(LampStrip12, 0F, 0F, 0F);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        Bulb.render(f5);
        Wire.render(f5);
        LampStrip1.render(f5);
        LampStrip5.render(f5);
        LampStrip4.render(f5);
        LampStrip7.render(f5);
        LampStrip2.render(f5);
        LampStrip8.render(f5);
        LampStrip9.render(f5);
        LampStrip11.render(f5);
        LampStrip3.render(f5);
        LampStrip6.render(f5);
        LampStrip10.render(f5);
        LampStrip12.render(f5);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }
    
}
