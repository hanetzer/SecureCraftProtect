package securecraftprotect.common.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import securecraftprotect.util.SCPDamageSource;

public class TileAcid extends BlockFluidClassic
{
    
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    
    public TileAcid(Fluid fluid)
    {
        super(fluid, Material.water);
        this.setQuantaPerBlock(8);
        this.setTickRate(5);
    }
    
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        stillIcon = register.registerIcon("scp:acidStill");
        flowingIcon = register.registerIcon("scp:acidFlow");
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
    {
        if(entity != null) entity.attackEntityFrom(SCPDamageSource.acid, 5f);
    }
    
}
