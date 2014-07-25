package securecraftprotect.common.entity.boss;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import securecraftprotect.common.entity.projectile.EntitySCP0015Projectile;
import securecraftprotect.init.SCPTiles;

import java.util.Random;

public class EntitySCP0015 extends EntityMob implements IBossDisplayData, IRangedAttackMob {
    public static boolean isHalfWay;
    public int deathTicks = 0;
    /**
     * Random offset used in floating behaviour
     */
    private float heightOffset = 0.5F;
    /**
     * ticks until heightOffset is randomized
     */
    private int heightOffsetUpdateTime;
    private int field_70846_g;

    public EntitySCP0015(World world) {
        super(world);
        setSize(width * 1.0F, height * 1.6F);
        isImmuneToFire = true;
        experienceValue = 15;
        yOffset *= 6.0F;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
        getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
    }

    protected void entityInit() {
        super.entityInit();
        dataWatcher.addObject(17, 0);
        dataWatcher.addObject(18, 0);
        dataWatcher.addObject(19, 0);
        dataWatcher.addObject(20, 0);
    }

    protected String getLivingSound() {
        return "mob.blaze.breathe";
    }

    protected String getHurtSound() {
        return "mob.blaze.hit";
    }

    protected String getDeathSound() {
        return "mob.blaze.death";
    }

    public int getBrightnessForRender(float par1) {
        return 15728880;
    }

    public float getBrightness(float par1) {
        return 0.4F;
    }

    public void targetLivings() {
    }

    public void onLivingUpdate() {
        if (getHealth() <= 600 && getHealth() > 300) isHalfWay = true;

        if (isHalfWay) {
            for (int i = 0; i <= 7; i++) {
                worldObj.spawnParticle("smoke",
                        posX + (rand.nextDouble() - 0.5D) * (double) width,
                        posY + rand.nextDouble() * (double) height,
                        posZ + (rand.nextDouble() - 0.5D) * (double) width,
                        0.0D, 0.0D, 0.0D);
            }
        }

        float var1;
        float var3;
        float var26;

        if (getHealth() <= 0) {

            for (int i = 0; i <= 3; i++) {
                this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.blaze.breathe", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
                this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "random.click", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
            }
            var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            var26 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.worldObj.spawnParticle("largeexplode", this.posX + (double) var1, this.posY + 2.0D + (double) var26, this.posZ + (double) var3, 0.0D, 0.0D, 0.0D);
        }

        this.isJumping = false;
        if (!this.worldObj.isRemote) {

            --this.heightOffsetUpdateTime;

            if (this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5F + (float) this.rand.nextGaussian() * 3.0F;
            }

            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double) this.getEntityToAttack().getEyeHeight() > this.posY + (double) this.getEyeHeight() + (double) this.heightOffset) {
                this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            }
        }

        if (this.rand.nextInt(24) == 0 && this.getHealth() > 0) {
            this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "random.break", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
        }

        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }

        if (this.getHealth() < 1200) {
            for (int var10 = 0; var10 <= 7; var10++) {
                this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height + 1, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
        }

        for (int var2 = 0; var2 < 2; ++var2) {
            Random rand = new Random();
            int particle = rand.nextInt(5);

            if (particle == 0) {
                this.worldObj.spawnParticle("townaura", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
            if (particle == 1) {
                this.worldObj.spawnParticle("splash", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
            if (particle == 2) {
                this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
            if (particle == 3) {
                this.worldObj.spawnParticle("suspended", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
            if (particle == 4) {
                this.worldObj.spawnParticle("depthsuspend", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("depthsuspend", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("depthsuspend", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
        }

        super.onLivingUpdate();
    }

    /**
     * handles entity death timer, experience orb and particle creation
     */
    protected void onDeathUpdate() {
        ++this.deathTicks;

        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;

            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double) var1, this.posY + 2.0D + (double) var2, this.posZ + (double) var3, 0.0D, 0.0D, 0.0D);
        }

        int var4;
        int var5;

        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                var4 = 500;

                while (var4 > 0) {
                    var5 = EntityXPOrb.getXPSplit(var4);
                    var4 -= var5;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
                }
            }

            if (this.deathTicks == 1) {
                this.worldObj.playBroadcastSound(1018, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
            }
        }

        this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
        this.renderYawOffset = this.rotationYaw += 20.0F;

        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            var4 = 500;

            while (var4 > 0) {
                var5 = EntityXPOrb.getXPSplit(var4);
                var4 -= var5;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
            }
            this.setDead();
        }
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float par2) {
        if (this.attackTime <= 0 && par2 < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        } else if (par2 < 30.0F) {
            double var3 = entity.posX - this.posX;
            double var5 = entity.boundingBox.minY + (double) (entity.height / 2.0F) - (this.posY + (double) (this.height / 2.0F));
            double var7 = entity.posZ - this.posZ;

            if (this.attackTime == 0) {
                ++this.field_70846_g;

                if (this.field_70846_g == 1) {
                    this.attackTime = 60;
                } else if (this.field_70846_g <= 4) {
                    this.attackTime = 6;
                } else {
                    this.attackTime = 100;
                    this.field_70846_g = 0;
                }

                if (this.field_70846_g > 1) {
                    float var9 = MathHelper.sqrt_float(par2) * 0.5F;
                    this.worldObj.playAuxSFXAtEntity(null, 1009, (int) posX, (int) posY, (int) posZ, 0);

                    for (int i = 0; i < 1; ++i) {
                        EntitySCP0015Projectile projectile = new EntitySCP0015Projectile(worldObj, this, var3 + rand.nextGaussian() * (double) var9, var5, var7 + rand.nextGaussian() * (double) var9);
                        projectile.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
                        this.worldObj.spawnEntityInWorld(projectile);
                    }
                }
            }

            this.rotationYaw = (float) (Math.atan2(var7, var3) * 180.0D / Math.PI) - 90.0F;
            this.hasAttacked = true;
        }
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {}

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem() {
        return Item.getItemFromBlock(SCPTiles.scp_0015);
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean killedByPlayer, int fortune) {
        int max = this.rand.nextInt(2 + fortune);

        for (int i = 0; i < max; ++i) {
            this.dropItem(Item.getItemFromBlock(SCPTiles.scp_0015), 1);
        }

        //int j = rand.nextInt(2);
        //if (j == 0) this.dropItem(mod_SCP.Record106.itemID, 1);
        //if (j == 1) this.dropItem(mod_SCP.Record173.itemID, 1);
    }

    public boolean func_70845_n() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel() {
        return true;
    }
}
