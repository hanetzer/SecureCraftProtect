package SCPCraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.Explosion;

public class SCPDamageSource extends DamageSource
{
	//Damages
	public static SCPDamageSource crystalDamage = new SCPDamageSource("crystal").setDamageBypassesArmor();
	public static SCPDamageSource electricDamage = new SCPDamageSource("electricity").setDamageBypassesArmor();
	public static SCPDamageSource ghostButt = new SCPDamageSource("ghost");
	public static SCPDamageSource bloodstone = new SCPDamageSource("bloodstone").setDamageBypassesArmor();
	public static SCPDamageSource pipe = new SCPDamageSource("pipeBoss");
	public static SCPDamageSource SCP143 = new SCPDamageSource("143");
	public static SCPDamageSource SCP106 = new SCPDamageSource("106").setDamageBypassesArmor();
	public static SCPDamageSource SCP023 = new SCPDamageSource("023").setDamageBypassesArmor();
	public static SCPDamageSource SCP682 = new SCPDamageSource("682").setDamageBypassesArmor();;
	public static SCPDamageSource SCP073 = new SCPDamageSource("073");
	public static SCPDamageSource SCP002 = new SCPDamageSource("002").setDamageBypassesArmor();;

    /** This kind of damage can be blocked or not. */
    private boolean isUnblockable = false;
    private boolean isDamageAllowedInCreativeMode = false;
    private float hungerDamage = 0.3F;

    /** This kind of damage is based on fire or not. */
    private boolean fireDamage;

    /** This kind of damage is based on a projectile or not. */
    private boolean projectile;

    /**
     * Whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    private boolean difficultyScaled;
    private boolean magicDamage = false;
    private boolean explosion = false;
    public String damageType;

    /**
     * Returns true if the damage is projectile based.
     */
    public boolean isProjectile()
    {
        return this.projectile;
    }

    /**
     * Define the damage type as projectile based.
     */
    public SCPDamageSource setProjectile()
    {
        this.projectile = true;
        return this;
    }

    public boolean isExplosion()
    {
        return this.explosion;
    }

    public SCPDamageSource setExplosion()
    {
        this.explosion = true;
        return this;
    }

    public boolean isUnblockable()
    {
        return this.isUnblockable;
    }

    /**
     * How much satiate(food) is consumed by this SCPDamageSource
     */
    public float getHungerDamage()
    {
        return this.hungerDamage;
    }

    public boolean canHarmInCreative()
    {
        return this.isDamageAllowedInCreativeMode;
    }

    protected SCPDamageSource(String par1Str)
    {
    	super(par1Str);
        this.damageType = par1Str;
    }

    public Entity getSourceOfDamage()
    {
        return this.getEntity();
    }

    public Entity getEntity()
    {
        return null;
    }

    protected SCPDamageSource setDamageBypassesArmor()
    {
        this.isUnblockable = true;
        this.hungerDamage = 0.0F;
        return this;
    }

    protected SCPDamageSource setDamageAllowedInCreativeMode()
    {
        this.isDamageAllowedInCreativeMode = true;
        return this;
    }

    /**
     * Define the damage type as fire based.
     */
    protected SCPDamageSource setFireDamage()
    {
        this.fireDamage = true;
        return this;
    }

    /**
     * Returns the message to be displayed on player death.
     */
    public String getDeathMessage(EntityLiving par1EntityLiving)
    {
        EntityLiving entityliving1 = par1EntityLiving.func_94060_bK();
        String s = "death.attack." + this.damageType;
        String s1 = s + ".player";
        return entityliving1 != null && StatCollector.func_94522_b(s1) ? StatCollector.translateToLocalFormatted(s1, new Object[] {par1EntityLiving.func_96090_ax(), entityliving1.func_96090_ax()}): StatCollector.translateToLocalFormatted(s, new Object[] {par1EntityLiving.func_96090_ax()});
    }

    /**
     * Returns true if the damage is fire based.
     */
    public boolean isFireDamage()
    {
        return this.fireDamage;
    }

    /**
     * Return the name of damage type.
     */
    public String getDamageType()
    {
        return this.damageType;
    }

    /**
     * Set whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    public SCPDamageSource setDifficultyScaled()
    {
        this.difficultyScaled = true;
        return this;
    }

    /**
     * Return whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    public boolean isDifficultyScaled()
    {
        return this.difficultyScaled;
    }

    /**
     * Returns true if the damage is magic based.
     */
    public boolean isMagicDamage()
    {
        return this.magicDamage;
    }

    /**
     * Define the damage type as magic based.
     */
    public SCPDamageSource setMagicDamage()
    {
        this.magicDamage = true;
        return this;
    }
}
