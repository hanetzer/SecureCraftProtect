package SCPCraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SCPModel019n2 extends ModelBase
{
	//fields
	ModelRenderer Head;
	ModelRenderer Neck;
	ModelRenderer Breasts;
	ModelRenderer Belleh;
	ModelRenderer Leg1;
	ModelRenderer foot1;
	ModelRenderer Leg2;
	ModelRenderer foot2;
	ModelRenderer Backleg1;
	ModelRenderer backfoot1;
	ModelRenderer Backleg2;
	ModelRenderer backfoot2;

	public SCPModel019n2()
	{
		textureWidth = 32;
		textureHeight = 32;

		Head = new ModelRenderer(this, 9, 4);
		Head.addBox(-2F, -1F, -3F, 4, 3, 3);
		Head.setRotationPoint(0F, 20F, -4F);
		Head.setTextureSize(32, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Neck = new ModelRenderer(this, 13, 11);
		Neck.addBox(-1F, 0F, 0F, 2, 1, 1);
		Neck.setRotationPoint(0F, 20F, -4F);
		Neck.setTextureSize(32, 32);
		Neck.mirror = true;
		setRotation(Neck, 0F, 0F, 0F);
		Breasts = new ModelRenderer(this, 10, 14);
		Breasts.addBox(-2F, 0F, -1F, 4, 1, 2);
		Breasts.setRotationPoint(0F, 20F, -2F);
		Breasts.setTextureSize(32, 32);
		Breasts.mirror = true;
		setRotation(Breasts, -0.2617994F, 0F, 0F);
		Belleh = new ModelRenderer(this, 12, 18);
		Belleh.addBox(-1F, 0F, 1F, 2, 1, 2);
		Belleh.setRotationPoint(0F, 20F, -2F);
		Belleh.setTextureSize(32, 32);
		Belleh.mirror = true;
		setRotation(Belleh, -0.2617994F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 5, 13);
		Leg1.addBox(0F, -1F, -1F, 1, 3, 1);
		Leg1.setRotationPoint(2F, 21F, -2F);
		Leg1.setTextureSize(32, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, -0.6981317F);
		foot1 = new ModelRenderer(this, 1, 18);
		foot1.addBox(1F, 1F, -1F, 1, 2, 1);
		foot1.setRotationPoint(2F, 21F, -2F);
		foot1.setTextureSize(32, 32);
		foot1.mirror = true;
		setRotation(foot1, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 23, 13);
		Leg2.addBox(-1F, -1F, -1F, 1, 3, 1);
		Leg2.setRotationPoint(-2F, 21F, -2F);
		Leg2.setTextureSize(32, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0.6981317F);
		foot2 = new ModelRenderer(this, 27, 18);
		foot2.addBox(-2F, 1F, -1F, 1, 2, 1);
		foot2.setRotationPoint(-2F, 21F, -2F);
		foot2.setTextureSize(32, 32);
		foot2.mirror = true;
		setRotation(foot2, 0F, 0F, 0F);
		Backleg1 = new ModelRenderer(this, 8, 22);
		Backleg1.addBox(0F, -0.5F, 0F, 1, 1, 3);
		Backleg1.setRotationPoint(1F, 21F, 0F);
		Backleg1.setTextureSize(32, 32);
		Backleg1.mirror = true;
		setRotation(Backleg1, -0.2094395F, 0F, 0F);
		backfoot1 = new ModelRenderer(this, 8, 27);
		backfoot1.addBox(0F, 0F, 2F, 1, 2, 1);
		backfoot1.setRotationPoint(1F, 21F, 0F);
		backfoot1.setTextureSize(32, 32);
		backfoot1.mirror = true;
		setRotation(backfoot1, -0.3665191F, 0F, 0F);
		Backleg2 = new ModelRenderer(this, 17, 22);
		Backleg2.addBox(-1F, -0.5F, 0F, 1, 1, 3);
		Backleg2.setRotationPoint(-1F, 21F, 0F);
		Backleg2.setTextureSize(32, 32);
		Backleg2.mirror = true;
		setRotation(Backleg2, -0.2094395F, 0F, 0F);
		backfoot2 = new ModelRenderer(this, 21, 27);
		backfoot2.addBox(-1F, 0F, 2F, 1, 2, 1);
		backfoot2.setRotationPoint(-1F, 21F, 0F);
		backfoot2.setTextureSize(32, 32);
		backfoot2.mirror = true;
		setRotation(backfoot2, -0.3665191F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Head.render(f5);
		Neck.render(f5);
		Breasts.render(f5);
		Belleh.render(f5);
		Leg1.render(f5);
		foot1.render(f5);
		Leg2.render(f5);
		foot2.render(f5);
		Backleg1.render(f5);
		backfoot1.render(f5);
		Backleg2.render(f5);
		backfoot2.render(f5);
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
		Leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		Leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		Leg1.rotateAngleY = 0.0F;
		Leg2.rotateAngleY = 0.0F;
		foot1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		foot2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		foot1.rotateAngleY = 0.0F;
		foot2.rotateAngleY = 0.0F;
		Backleg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		Backleg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		Backleg1.rotateAngleY = -0.2F;
		Backleg2.rotateAngleY = -0.2F;
		backfoot1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		backfoot2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		backfoot1.rotateAngleY = -0.2F;
		backfoot2.rotateAngleY = -0.2F;
	}

}
