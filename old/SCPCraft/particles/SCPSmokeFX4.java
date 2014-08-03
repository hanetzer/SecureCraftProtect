package SCPCraft.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPSmokeFX4 extends EntityFX
{
    float smokeParticleScale;
    public int getMetadata;

    public SCPSmokeFX4(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        this(par1World, par2, par4, par6, par8, par10, par12, 1.0F);
    }

    public SCPSmokeFX4(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        motionX *= 0.10000000149011612D;
        motionY *= 0.10000000149011612D;
        motionZ *= 0.10000000149011612D;
        motionX += par8;
        motionY += par10;
        motionZ += par12;
        particleRed = particleGreen = particleBlue = 0F;
        particleScale *= 0.75F;
        particleScale *= par14;
        smokeParticleScale = particleScale;
        particleMaxAge = 32;
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
    	EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
    	if(player != null){
    		ItemStack var9 = player.inventory.armorItemInSlot(3);
    		if(var9 != null){
    			if(var9.itemID != mod_SCP.GasMask.itemID && this.getDistanceToEntity(player)<1D)
    				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 7*20, 1));
    		}
    		else if(this.getDistanceToEntity(player)<1D)player.addPotionEffect(new PotionEffect(Potion.blindness.id, 7*20, 1));
    	}
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;

        if (particleAge++ >= particleMaxAge)
        {
            setDead();
        }

        setParticleTextureIndex(7 - (particleAge * 8) / particleMaxAge);
        motionZ += 0.0040000000000000001D;
        moveEntity(motionX, motionY, motionZ);

        if (posY == prevPosY)
        {
            motionX *= 1.1000000000000001D;
            motionZ *= 1.1000000000000001D;
        }

        motionX *= 0.95999997854232788D;
        motionY *= 0.95999997854232788D;
        motionZ *= 0.95999997854232788D;
    }
}
