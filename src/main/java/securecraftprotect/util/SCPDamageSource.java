package securecraftprotect.util;

import net.minecraft.util.DamageSource;

public class SCPDamageSource {
	public static DamageSource acid = new DamageSource("acid");
	public static DamageSource crystalDamage = new DamageSource("crystal").setDamageBypassesArmor();
	public static DamageSource electricDamage = new DamageSource("electricity").setDamageBypassesArmor();
	public static DamageSource ghostButt = new DamageSource("ghost");
	public static DamageSource bloodstone = new DamageSource("bloodstone").setDamageBypassesArmor();
	public static DamageSource pipe = new DamageSource("pipeBoss");
    public static DamageSource SCP0002 = new DamageSource("0002").setDamageBypassesArmor();
	public static DamageSource SCP0023 = new DamageSource("0023").setDamageBypassesArmor();
	public static DamageSource SCP0073 = new DamageSource("0073");
    public static DamageSource SCP0143 = new DamageSource("0143");
    public static DamageSource SCP0106 = new DamageSource("0106").setDamageBypassesArmor();
    public static DamageSource SCP0682 = new DamageSource("0682").setDamageBypassesArmor();

}
