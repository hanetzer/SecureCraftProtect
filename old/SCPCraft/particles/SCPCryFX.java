package SCPCraft.particles;

import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SCPCryFX extends EntityRainFX
{
    public SCPCryFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        super(par1World, par2, par4, par6);
        this.particleGravity = 0.2F;
        this.nextTextureIndexX();
    }
}
