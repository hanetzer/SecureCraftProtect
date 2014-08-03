package SCPCraft;

import net.minecraft.block.StepSound;

public final class SCPStepSoundPocketDimension extends StepSound
{
	SCPStepSoundPocketDimension(String par1Str, float par2, float par3)
    {
        super(par1Str, par2, par3);
    }

    /**
     * Used when a block breaks, EXA: Player break, Shep eating grass, etc..
     */
    public String getBreakSound()
    {
        return "dig.stone";
    }
    
    /**
     * Used when a block is stepped on
     */
    public String getStepSound()
    {
        return "sounds.StepSounds.StepPD";
    }

    /**
     * Used when a block is placed
     */
    public String func_82593_b()
    {
        return this.getBreakSound();
    }
}
