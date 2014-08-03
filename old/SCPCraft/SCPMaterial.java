package SCPCraft;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.material.MaterialLogic;
import net.minecraft.block.material.MaterialPortal;
import net.minecraft.block.material.MaterialTransparent;

public class SCPMaterial extends Material
{
	//Materials
	public static final SCPMaterial SCP354 = (new SCPMaterialLiquid(MapColor.tntColor)).setNoPushMobility();

    /** Bool defining if the block can burn or not. */
    private boolean canBurn;

    /**
     * Determines whether blocks with this material can be "overwritten" by other blocks when placed - eg snow, vines
     * and tall grass.
     */
    private boolean replaceable;

    /** Indicates if the material is translucent */
    private boolean isTranslucent;

    /** The color index used to draw the blocks of this material on maps. */
    public final MapColor materialMapColor;

    /**
     * Determines if the material can be harvested without a tool (or with the wrong tool)
     */
    private boolean requiresNoTool = true;

    /**
     * Mobility information flag. 0 indicates that this block is normal, 1 indicates that it can't push other blocks, 2
     * indicates that it can't be pushed.
     */
    private int mobilityFlag;
    private boolean field_85159_M;

    public SCPMaterial(MapColor par1MapColor)
    {
    	super(par1MapColor);
        this.materialMapColor = par1MapColor;
    }

    /**
     * Returns if blocks of these materials are liquids.
     */
    public boolean isLiquid()
    {
        return false;
    }

    public boolean isSolid()
    {
        return true;
    }

    /**
     * Will prevent grass from growing on dirt underneath and kill any grass below it if it returns true
     */
    public boolean getCanBlockGrass()
    {
        return true;
    }

    /**
     * Returns if this material is considered solid or not
     */
    public boolean blocksMovement()
    {
        return true;
    }

    /**
     * Marks the material as translucent
     */
    private SCPMaterial setTranslucent()
    {
        this.isTranslucent = true;
        return this;
    }

    /**
     * Makes blocks with this material require the correct tool to be harvested.
     */
    protected SCPMaterial setRequiresTool()
    {
        this.requiresNoTool = false;
        return this;
    }

    /**
     * Set the canBurn bool to True and return the current object.
     */
    protected SCPMaterial setBurning()
    {
        this.canBurn = true;
        return this;
    }

    /**
     * Returns if the block can burn or not.
     */
    public boolean getCanBurn()
    {
        return this.canBurn;
    }

    /**
     * Sets {@link #replaceable} to true.
     */
    public SCPMaterial setReplaceable()
    {
        this.replaceable = true;
        return this;
    }

    /**
     * Returns whether the material can be replaced by other blocks when placed - eg snow, vines and tall grass.
     */
    public boolean isReplaceable()
    {
        return this.replaceable;
    }

    /**
     * Indicate if the material is opaque
     */
    public boolean isOpaque()
    {
        return this.isTranslucent ? false : this.blocksMovement();
    }

    /**
     * Returns true if the material can be harvested without a tool (or with the wrong tool)
     */
    public boolean isToolNotRequired()
    {
        return this.requiresNoTool;
    }

    /**
     * Returns the mobility information of the material, 0 = free, 1 = can't push but can move over, 2 = total
     * immobility and stop pistons.
     */
    public int getMaterialMobility()
    {
        return this.mobilityFlag;
    }

    /**
     * This type of material can't be pushed, but pistons can move over it.
     */
    protected SCPMaterial setNoPushMobility()
    {
        this.mobilityFlag = 1;
        return this;
    }

    /**
     * This type of material can't be pushed, and pistons are blocked to move.
     */
    protected SCPMaterial setImmovableMobility()
    {
        this.mobilityFlag = 2;
        return this;
    }

    protected SCPMaterial func_85158_p()
    {
        this.field_85159_M = true;
        return this;
    }

    public boolean func_85157_q()
    {
        return this.field_85159_M;
    }
}
