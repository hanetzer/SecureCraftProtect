package securecraftprotect.common.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import securecraftprotect.common.entity.passive.EntitySCP0131;
import securecraftprotect.common.entity.player.ExtendedPlayerSCP;

import java.util.Iterator;
import java.util.List;

public class EntitySCP0173 extends EntityMob implements IMob {
    public Minecraft mc = Minecraft.getMinecraft();
    private int slowPeriod;
    private int timeTillNextTeleport;
    private boolean timeLocked;
    private int transparentBlocks[] =
            {
                    8, 9, 10, 11, 18, 27, 28, 30, 31,
                    32, 37, 38, 39, 40, 44, 50, 51, 52, 59,
                    64, 65, 66, 67, 69, 70, 72, 75, 76,
                    77, 78, 83, 85, 90, 92, 106, 71,
                    107, 108, 109, 111, 113, 114, 114, 117
            };

    public EntitySCP0173(World world) {
        super(world);
        stepHeight = 4.0F;
        setSize(0.6F, 1.6F);
        isImmuneToFire = true;
        getNavigator().setEnterDoors(true);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(9001.0D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);

    }

    protected void func_145780_a(int par1, int par2, int par3, Block block) {
        this.playSound("scp:mob.0173.step", 0.15F, 1.0F);
    }

//    public float getSpeedModifier() {
//        return super.getSpeedModifier() * 3F;
//    }

    public boolean canBePushed() {
        return false;
    }

    public boolean isAIEnabled() {
        return false;
    }

    public void func_48150_h(boolean flag) {
        isJumping = flag;
    }

    protected boolean canDespawn() {
        return false;
    }

    public int getTalkInterval() {
        return 220;
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack() {
        EntityPlayer player = worldObj.getClosestPlayerToEntity(this, 16D);
        if (player != null && canSCPBeSeen(player)) {
            return player;
        } else {
            return null;
        }
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity entity, float f) {
        if (entityToAttack != null && (entityToAttack instanceof EntityPlayer) && !canSCPBeSeen((EntityPlayer) entityToAttack)) {
            if (rand.nextInt(20) != 0) {
                super.attackEntity(entity, f);
            }
        }
    }


    protected void updateEntityActionState() {
        if (entityToAttack != null) {
            if (!canSCPBeSeen((EntityPlayer) entityToAttack)) {
                super.updateEntityActionState();
            }
        } else {
            super.updateEntityActionState();
        }
    }

    public void onCollideWithPlayer(EntityPlayer player) {
    }

    public boolean attackEntityFrom(DamageSource source, int par2) {
        return false;
    }

    public void onLivingUpdate() {
        getNavigator().setSpeed(80.0D);
        isJumping = false;
        super.onLivingUpdate();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        isJumping = false;

        if (worldObj.isDaytime()) {
            float f = getBrightness(1.0F);

            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F) {
            } else {
            }
        }

        if (entityToAttack != null && (entityToAttack instanceof EntityPlayer)) {
            if (!canSCPBeSeen((EntityPlayer) entityToAttack)) {
                if (getDistancetoEntityToAttack() > 15D && timeTillNextTeleport-- < 0) {
                    timeTillNextTeleport = rand.nextInt(60) + 20;
                }
            }

            if (slowPeriod > 0) {
                slowPeriod--;
                entityToAttack.motionX *= 0.01D;
                entityToAttack.motionZ *= 0.01D;
            }

            if ((entityToAttack instanceof EntityPlayer) && (canSCPBeSeen((EntityPlayer) entityToAttack) || timeLocked)) {
                SCPDirectLook((EntityPlayer) entityToAttack);
                moveStrafing = moveForward = 0.0F;
                getNavigator().setSpeed(0.0D);
            } else {
                faceEntity(entityToAttack, 100F, 100F);
            }
        }

        super.onUpdate();
    }

    public boolean canSCPBeSeen(EntityPlayer player) {
        //List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntitySCP0131.class, this.boundingBox.expand((double) 4F, 2.0D, (double) 4F));
        //Iterator<?> iterator = var5.iterator();
        ExtendedPlayerSCP props = (ExtendedPlayerSCP) player.getExtendedProperties(ExtendedPlayerSCP.EXT_PROP_NAME);
        //while (iterator.hasNext()) return true;

        if (worldObj.getFullBlockLightValue(
                MathHelper.floor_double(posX),
                MathHelper.floor_double(posY),
                MathHelper.floor_double(posZ)) < 1) {
            return false;
        }
        if (props.getBlink() >= 0 && props.getBlink() <= 10) {
            return false;
        }
        if (player.canEntityBeSeen(this) || lineOfSightCheck(player)) {
            return isInFieldOfVision(this, player, 100F, 100F);  //70 65
        } else {
            return false;
        }
    }

    private boolean lineOfSightCheck(EntityPlayer player) {
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX,
                        posY + (double) getEyeHeight(),
                        posZ),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX,
                        posY + (double) height,
                        posZ),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX,
                        posY + (double) height * 0.1D,
                        posZ),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX + 0.7D,
                        posY + (double) getEyeHeight(),
                        posZ),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX - 0.7D,
                        posY + (double) getEyeHeight(),
                        posZ),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX,
                        posY + (double) getEyeHeight(),
                        posZ + 0.7D),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX,
                        posY + (double) getEyeHeight(),
                        posZ - 0.7D),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX,
                        posY + (double) height * 1.2D,
                        posZ - 0.7D),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        if (worldObj.rayTraceBlocks(
                Vec3.createVectorHelper(
                        posX,
                        posY + (double) height * 1.2D + 1.0D,
                        posZ),
                Vec3.createVectorHelper(
                        player.posX,
                        player.posY + (double) player.getEyeHeight(),
                        player.posZ)) == null) {
            return true;
        }
        return false;
    }

    private boolean isBlockTransparent(int i) {
        for (int transparentBlock : transparentBlocks) {
            if (i == transparentBlock) {
                return true;
            }
        }

        return true;
    }

    private boolean SCPDirectLook(EntityPlayer player) {
        if (worldObj.getFullBlockLightValue(
                MathHelper.floor_double(posX),
                MathHelper.floor_double(posY),
                MathHelper.floor_double(posZ)) < 1) {
            return false;
        }

        Vec3 vec3a = player.getLook(1.0F).normalize();
        Vec3 vec3b = Vec3.createVectorHelper(
                posX - player.posX,
                ((boundingBox.minY + (double) height) - player.posY) + (double) player.getEyeHeight(),
                posZ - player.posZ);
        double d = vec3b.lengthVector();
        vec3b = vec3b.normalize();
        double d1 = vec3a.dotProduct(vec3b);

        return d1 > 1.0D - 0.025D / d && player.canEntityBeSeen(this);
    }

//    public boolean SCPSeeSCP(EntitySCP0173 scp0173) {
//        if (worldObj.getFullBlockLightValue(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) < 1) {
//            return false;
//        } else {
//            return isInFieldOfVision(scp0173, this, 40F, 65F);
//        }
//    }

    public double getDistance(int i, int j, int k, int l, int i1, int j1) {
        int k1 = l - i;
        int l1 = i1 - j;
        int i2 = j1 - k;
        return Math.sqrt(k1 * k1 + l1 * l1 + i2 * i2);
    }

    public double getDistancetoEntityToAttack() {
        if (entityToAttack instanceof EntityPlayer) {
            double d = entityToAttack.posX - posX;
            double d2 = entityToAttack.posY - posY;
            double d4 = entityToAttack.posZ - posZ;
            return (double) MathHelper.sqrt_double(d * d + d2 * d2 + d4 * d4);
        }

        EntityPlayer player = worldObj.getClosestVulnerablePlayerToEntity(this, 64D);

        if (player != null) {
            double d1 = player.posX - posX;
            double d3 = player.posY - posY;
            double d5 = player.posZ - posZ;
            return (double) MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
        } else {
            return 40000D;
        }
    }

    private boolean isInFieldOfVision(EntitySCP0173 scp173, EntityPlayer player, float f, float f1) {
        float f2 = player.rotationYaw;
        float f3 = player.rotationPitch;
        //player.faceEntity(this, 360F, 360F);
        float f4 = player.rotationYaw;
        float f5 = player.rotationPitch;
        player.rotationYaw = f2;
        player.rotationPitch = f3;
        f2 = f4;
        f3 = f5;
        float f8 = player.rotationYaw - f;
        float f9 = player.rotationYaw + f;
        float f10 = player.rotationPitch - f1;
        float f11 = player.rotationPitch + f1;
        boolean flag = getFlag(f8, f9, f2, 0.0F, 360F);
        boolean flag1 = getFlag(f10, f11, f3, -180F, 180F);
        return flag && flag1 && (player.canEntityBeSeen(scp173) || lineOfSightCheck(player));
    }

    public boolean getFlag(float f, float f1, float f2, float f3, float f4) {
        if (f < f3) {
            if (f2 >= f + f4) {
                return true;
            }

            if (f2 <= f1) {
                return true;
            }
        }

        if (f1 >= f4) {
            if (f2 <= f1 - f4) {
                return true;
            }

            if (f2 >= f) {
                return true;
            }
        }

        if (f1 < f4 && f >= f3) {
            return f2 <= f1 && f2 > f;
        } else {
            return false;
        }
    }

    public void setYaw(float f) {
        rotationYaw = f;
    }

    protected String getLivingSound() {
        return "scp:mob.0173.say";
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public int getMaxSpawnedInChunk() {
        return 0;
    }
}
