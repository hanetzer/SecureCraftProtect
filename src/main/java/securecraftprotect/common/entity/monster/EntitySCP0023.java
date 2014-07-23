package securecraftprotect.common.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import securecraftprotect.util.SCPDamageSource;

public class EntitySCP0023 extends SCPEntity {
    public boolean isAttacking;
    private int field_35185_e;

    public EntitySCP0023(World world) {
        super(world);
        //this.texture = "/SCPCraft/textures/mobs/023.png";
        this.setSize(1.0F, 1.0F);
        //this.moveSpeed = 0.4F;
        this.stepHeight = 1.0F;
        //this.attackStrength = 2;
        this.getNavigator().setAvoidsWater(true);
        float var2 = 0.25F;
        isImmuneToFire = true;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, var2));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLiving.class, 1.0D, true));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled() {
        return true;
    }

//    public int getMaxHealth() {
//        return 100;
//    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (byte) 0);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
    }

    protected boolean canDespawn() {
        return false;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {
    }

    protected Entity findPlayerToAttack() {
        EntityPlayer player = worldObj.getClosestVulnerablePlayerToEntity(this, 64D);

        if (player != null) {
            if (shouldAttackPlayer(player)) {
                if (field_35185_e++ == 5) {
                    field_35185_e = 0;
                    return player;
                }
            } else {
                field_35185_e = 0;
            }
        }

        return null;
    }

    private boolean shouldAttackPlayer(EntityPlayer player) {
        if (player != null) {
            Vec3 vec3a = player.getLook(1.0F).normalize();
            Vec3 vec3b = Vec3.createVectorHelper(
                    posX - player.posX,
                    (boundingBox.minY + (double) (height / 2.0F)) - (player.posY + (double) player.getEyeHeight()),
                    posZ - player.posZ);
            double d = vec3b.lengthVector();
            vec3b = vec3b.normalize();
            double d1 = vec3a.dotProduct(vec3b);

            if (d1 > 1.0D - 0.025D / d) {
                return player.canEntityBeSeen(this);
            } else {
                return false;
            }
        }
        return false;
    }

    public void onLivingUpdate() {
        EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        motionX = 0;
        motionZ = 0;
        isAttacking = entityToAttack != null;
        //moveSpeed = entityToAttack == null ? 0.3F : 6.5F;

        if (shouldAttackPlayer(player) == true) {
            if (!worldObj.isRemote) {
                //ModLoader.getMinecraftInstance();
                if (player != null && !player.capabilities.isCreativeMode) {
                    player.attackEntityFrom(SCPDamageSource.SCP0023, 6);
                }
            }
        }

        if (worldObj.isDaytime() && !worldObj.isRemote) {
            float f = getBrightness(1.0F);

            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F) {
                entityToAttack = null;
            }
        }

        isJumping = false;

        if (entityToAttack != null) {
            faceEntity(entityToAttack, 100F, 100F);
        }

        if (!worldObj.isRemote && isEntityAlive()) {
            if (entityToAttack != null) {
                if ((entityToAttack instanceof EntityPlayer) && shouldAttackPlayer((EntityPlayer) entityToAttack)) {
                    moveStrafing = moveForward = 0.0F;
                    //moveSpeed = 0.0F;

                }
            }
        }
        super.onLivingUpdate();
    }
}
