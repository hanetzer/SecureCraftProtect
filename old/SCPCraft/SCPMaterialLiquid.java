package SCPCraft;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class SCPMaterialLiquid extends SCPMaterial
{
    public SCPMaterialLiquid(MapColor par1MapColor)
    {
        super(par1MapColor);
        this.setReplaceable();
        this.setNoPushMobility();
    }

    /**
     * Returns if blocks of these materials are liquids.
     */
    public boolean isLiquid()
    {
        return true;
    }

    /**
     * Returns if this material is considered solid or not
     */
    public boolean blocksMovement()
    {
        return false;
    }

    public boolean isSolid()
    {
        return false;
    }
}
