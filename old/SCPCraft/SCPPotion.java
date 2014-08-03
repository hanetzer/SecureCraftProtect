package SCPCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StringUtils;

public class SCPPotion extends Potion
{
    /** The array of SCPPotion types. */
    public static final SCPPotion[] SCPPotionTypes = new SCPPotion[32];
	public static final SCPPotion electricity = (new SCPPotion(21, true, 14994699)).setPotionName("potion.electric").setIconIndex(1, 0).setEffectiveness(0.25D);
	public static final SCPPotion shake = (new SCPPotion(22, true, 6513507)).setPotionName("potion.shake").setIconIndex(2, 0).setEffectiveness(0.25D);
	public static final SCPPotion control = (new SCPPotion(23, true, 986895)).setPotionName("potion.control").setIconIndex(0, 0).setEffectiveness(0.25D);
	public static final SCPPotion verminGod = (new SCPPotion(24, true, 8350208)).setPotionName("potion.vermin").setIconIndex(4, 0).setEffectiveness(0.25D);
	public static final SCPPotion bloodStone = (new SCPPotion(25, true, 1615855616)).setPotionName("potion.bloodstone").setIconIndex(3, 0).setEffectiveness(0.25D);
	public static final SCPPotion crystal = (new SCPPotion(26, true, 14804975)).setPotionName("potion.crystal").setIconIndex(0, 0).setEffectiveness(0.25D);
	public static final SCPPotion sticky = (new SCPPotion(27, false, 3211033)).setPotionName("potion.sticky").setIconIndex(5, 0).setEffectiveness(0.25D);
	public static final SCPPotion skeleton = (new SCPPotion(28, false, 9896114)).setPotionName("potion.skeleton").setIconIndex(6, 0).setEffectiveness(0.25D);
	public static final SCPPotion eaten = (new SCPPotion(29, false, 9896114)).setPotionName("potion.eat").setIconIndex(6, 0).setEffectiveness(0.25D);

    /** The Id of a SCPPotion object. */
    public final int id;

    /** The name of the SCPPotion. */
    private String name = "";

    /** The index for the icon displayed when the SCPPotion effect is active. */
    private int statusIconIndex = -1;

    /**
     * This field indicated if the effect is 'bad' - negative - for the entity.
     */
    private final boolean isBadEffect;
    private double effectiveness;
    private boolean usable;

    /** Is the color of the liquid for this SCPPotion. */
    private final int liquidColor;

    protected SCPPotion(int par1, boolean par2, int par3)
    {
    	super(par1, par2, par3);
        this.id = par1;
        SCPPotionTypes[par1] = this;
        this.isBadEffect = par2;

        if (par2)
        {
            this.effectiveness = 0.5D;
        }
        else
        {
            this.effectiveness = 1.0D;
        }

        this.liquidColor = par3;
    }

    /**
     * Sets the index for the icon displayed in the player's inventory when the status is active.
     */
    protected SCPPotion setIconIndex(int par1, int par2)
    {
        this.statusIconIndex = par1 + par2 * 8;
        return this;
    }

    /**
     * returns the ID of the SCPPotion
     */
    public int getId()
    {
        return this.id;
    }

    public void performEffect(EntityLiving par1EntityLiving, int par2)
    {
        if (this.id == regeneration.id)
        {
            if (par1EntityLiving.getHealth() < par1EntityLiving.getMaxHealth())
            {
                par1EntityLiving.heal(1);
            }
        }
        else if (this.id == poison.id)
        {
            if (par1EntityLiving.getHealth() > 1)
            {
                par1EntityLiving.attackEntityFrom(DamageSource.magic, 1);
            }
        }
        else if (this.id == wither.id)
        {
            par1EntityLiving.attackEntityFrom(DamageSource.wither, 1);
        }
        else if (this.id == hunger.id && par1EntityLiving instanceof EntityPlayer)
        {
            ((EntityPlayer)par1EntityLiving).addExhaustion(0.025F * (float)(par2 + 1));
        }
        else if ((this.id != heal.id || par1EntityLiving.isEntityUndead()) && (this.id != harm.id || !par1EntityLiving.isEntityUndead()))
        {
            if (this.id == harm.id && !par1EntityLiving.isEntityUndead() || this.id == heal.id && par1EntityLiving.isEntityUndead())
            {
                par1EntityLiving.attackEntityFrom(DamageSource.magic, 6 << par2);
            }
        }
        else
        {
            par1EntityLiving.heal(6 << par2);
        }
    }

    /**
     * Hits the provided entity with this SCPPotion's instant effect.
     */
    public void affectEntity(EntityLiving par1EntityLiving, EntityLiving par2EntityLiving, int par3, double par4)
    {
        int j;

        if ((this.id != heal.id || par2EntityLiving.isEntityUndead()) && (this.id != harm.id || !par2EntityLiving.isEntityUndead()))
        {
            if (this.id == harm.id && !par2EntityLiving.isEntityUndead() || this.id == heal.id && par2EntityLiving.isEntityUndead())
            {
                j = (int)(par4 * (double)(6 << par3) + 0.5D);

                if (par1EntityLiving == null)
                {
                    par2EntityLiving.attackEntityFrom(DamageSource.magic, j);
                }
                else
                {
                    par2EntityLiving.attackEntityFrom(DamageSource.causeIndirectMagicDamage(par2EntityLiving, par1EntityLiving), j);
                }
            }
        }
        else
        {
            j = (int)(par4 * (double)(6 << par3) + 0.5D);
            par2EntityLiving.heal(j);
        }
    }

    /**
     * Returns true if the SCPPotion has an instant effect instead of a continuous one (eg Harming)
     */
    public boolean isInstant()
    {
        return false;
    }

    /**
     * checks if SCPPotion effect is ready to be applied this tick.
     */
    public boolean isReady(int par1, int par2)
    {
        int k;

        if (this.id != regeneration.id && this.id != poison.id)
        {
            if (this.id == wither.id)
            {
                k = 40 >> par2;
                return k > 0 ? par1 % k == 0 : true;
            }
            else
            {
                return this.id == hunger.id;
            }
        }
        else
        {
            k = 25 >> par2;
            return k > 0 ? par1 % k == 0 : true;
        }
    }

    /**
     * Set the SCPPotion name.
     */
    public SCPPotion setPotionName(String par1Str)
    {
        this.name = par1Str;
        return this;
    }

    /**
     * returns the name of the SCPPotion
     */
    public String getName()
    {
        return this.name;
    }

    protected SCPPotion setEffectiveness(double par1)
    {
        this.effectiveness = par1;
        return this;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the SCPPotion has a associated status icon to display in then inventory when active.
     */
    public boolean hasStatusIcon()
    {
        return this.statusIconIndex >= 0;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the index for the icon to display when the SCPPotion is active.
     */
    public int getStatusIconIndex()
    {
        return this.statusIconIndex;
    }

    @SideOnly(Side.CLIENT)

    /**
     * This method returns true if the SCPPotion effect is bad - negative - for the entity.
     */
    public boolean isBadEffect()
    {
        return this.isBadEffect;
    }

    @SideOnly(Side.CLIENT)
    public static String getDurationString(PotionEffect par0PotionEffect)
    {
        if (par0PotionEffect.func_100011_g())
        {
            return "**:**";
        }
        else
        {
            int i = par0PotionEffect.getDuration();
            return StringUtils.ticksToElapsedTime(i);
        }
    }

    public double getEffectiveness()
    {
        return this.effectiveness;
    }

    public boolean isUsable()
    {
        return this.usable;
    }

    /**
     * Returns the color of the SCPPotion liquid.
     */
    public int getLiquidColor()
    {
        return this.liquidColor;
    }
}
