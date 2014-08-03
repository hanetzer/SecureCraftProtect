package SCPCraft.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class SCP080FX extends EntityFX
{
    float smokeParticleScale;

    public SCP080FX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        this(par1World, par2, par4, par6, par8, par10, par12, 1.0F);
    }

    public SCP080FX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        motionX *= 0D;
        motionY *= 0D;
        motionZ *= 0D;
        motionY = 0;
        particleRed = particleGreen = particleBlue = (float)(Math.random() * 0.10000001192092896D);
        particleScale *= 0.75F;
        particleScale *= par14;
        smokeParticleScale = particleScale;
        particleMaxAge = (int)(8D / (Math.random() * 0.90000000000000004D + 0.40000000000000001D));
        particleMaxAge *= par14;
        noClip = false;
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        float f = (((float)particleAge + par2) / (float)particleMaxAge) * 32F;

        if (f < 0.0F)
        {
            f = 0.0F;
        }

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        particleScale = smokeParticleScale * f;
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;

        if (particleAge++ >= particleMaxAge)
        {
            setDead();
        }

        setParticleTextureIndex(7 - (particleAge * 8) / particleMaxAge);
        motionY += 0.0040000000000000001D;
        moveEntity(motionX, motionY, motionZ);

    }
}
