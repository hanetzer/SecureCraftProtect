package securecraftprotect.common.entity.projectile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import securecraftprotect.common.item.ItemArmorClassD;
import securecraftprotect.common.item.ItemArmorSwat;
import securecraftprotect.init.SCPItems;
import securecraftprotect.util.SCPDamageSource;

public class EntitySCP0015Projectile extends EntityFireball
{
    /**
     * The x coordinate of the tile entity.
     */
    public int xCoord;
    public EntityLiving shootingEntity;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    /**
     * The y coordinate of the tile entity.
     */
    public int yCoord;
    /**
     * The z coordinate of the tile entity.
     */
    public int zCoord;
    private Minecraft mc = Minecraft.getMinecraft();

    public EntitySCP0015Projectile(World world) {
        super(world);
        setSize(0.2125F, 0.2125F);
    }

    public EntitySCP0015Projectile(World world, EntityLiving living,
								   double x, double y, double z)
	{
        super(world, living, x, y, z);
        setSize(0.2125F, 0.2125F);
    }

    public EntitySCP0015Projectile(World world, double x, double y, double z,
								   double par8, double par10, double par12)
	{
        super(world, x, y, z, par8, par10, par12);
        setSize(0.2125F, 0.2125F);
    }

    public void targetLivings() {}

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition pos)
	{
        int potions[] = {
                Potion.blindness.id, Potion.hunger.id, Potion.confusion.id,
                Potion.digSlowdown.id, Potion.moveSlowdown.id, Potion.weakness.id,
                Potion.poison.id, /*SCPPotion.shake.id,*/ Potion.harm.id
        };
        Item tools[] = {
                Items.iron_pickaxe, Items.wooden_pickaxe, Items.golden_pickaxe,
                Items.diamond_pickaxe, Items.stone_pickaxe, Items.iron_sword,
                Items.wooden_sword, Items.golden_sword, Items.diamond_sword,
                Items.stone_sword,
                SCPItems.scp0143_pickaxe, SCPItems.scp0143_sword, SCPItems.wrench
        };

        if (!worldObj.isRemote && pos.entityHit != null) {
            if (pos.entityHit instanceof EntityPlayer) {

                EntityPlayer player = ((EntityPlayer) pos.entityHit);

                Item boots = player.inventory.armorInventory[0].getItem();
                Item legs = player.inventory.armorInventory[1].getItem();
                Item chest = player.inventory.armorInventory[2].getItem();
                Item helm = player.inventory.armorInventory[3].getItem();
                if (chest != null && legs != null && boots != null && helm != null)
				{
                    if (chest instanceof ItemArmorSwat
                            || legs instanceof ItemArmorSwat
                            || boots instanceof ItemArmorSwat
                            || helm instanceof ItemArmorSwat)
					{
                        pos.entityHit.attackEntityFrom(SCPDamageSource.SCP0015,
                                2 * worldObj.difficultySetting.getDifficultyId());
                        worldObj.newExplosion(null, posX, posY, posZ,
                                2.0F, true, true);
                    }
					else if (chest instanceof ItemArmorClassD
                            || legs instanceof ItemArmorClassD
                            || boots instanceof ItemArmorClassD
                            || helm instanceof ItemArmorClassD)
					{
                        pos.entityHit.attackEntityFrom(SCPDamageSource.SCP0015,
                                2 * worldObj.difficultySetting.getDifficultyId() + 2);
                    }
					else
					{
                        pos.entityHit.attackEntityFrom(SCPDamageSource.SCP0015,
                                2 * worldObj.difficultySetting.getDifficultyId());
                    }
                }
				else
				{
                    pos.entityHit.attackEntityFrom(SCPDamageSource.SCP0015,
                            2 * worldObj.difficultySetting.getDifficultyId() + 2);
                }
			}

            for (int i = 0; i < 50; ++i) {
                worldObj.spawnParticle("smoke",
						(double) xCoord + 0.5D,
						(double) yCoord + 0.5D,
						(double) zCoord + 0.5D, 4D,
						(double) xCoord + 0.5D,
						(double) yCoord + 0.5D);
                worldObj.spawnParticle("splash",
						(double) xCoord + 0.5D,
						(double) yCoord + 0.5D,
						(double) zCoord + 0.5D, 4D,
						(double) xCoord + 0.5D,
						(double) yCoord + 0.5D);
                worldObj.spawnParticle("smoke",
						(double) xCoord + 0.5D,
						(double) yCoord + 0.5D,
						(double) zCoord + 0.5D, 4D,
						(double) xCoord + 0.5D,
						(double) yCoord + 0.5D);
            }
            for (int i = 0; i <= tools.length - 1; i++)
			{
                if (mc.thePlayer.inventory.hasItem(tools[i]) && mc.playerController.isNotCreative())
				{
                    mc.thePlayer.addPotionEffect(new PotionEffect(potions[rand.nextInt(potions.length)], 200, 1));
                }
            }
        }
        this.setDead();
    }

    public void onUpdate() {
        this.setFire(-1);
        super.onUpdate();
        this.setFire(-1);
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
	{
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, int par2)
	{
        return false;
    }

    public float getShadowSize()
	{
        return 0.0F;
    }

    public float getBrightness(float par1)
	{
        return 1.0F;
    }

    public int getBrightnessForRender(float par1)
	{
        return 14496512;
    }
}
