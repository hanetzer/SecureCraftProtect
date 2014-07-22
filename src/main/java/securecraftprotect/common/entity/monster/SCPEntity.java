package securecraftprotect.common.entity.monster;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import securecraftprotect.common.entity.SCPEnumCreatureAttribute;
import securecraftprotect.init.SCPItems;
import securecraftprotect.common.entity.ai.SCPFilterAttack;

import java.util.Iterator;
import java.util.List;

public abstract class SCPEntity extends EntityCreature {
    private static final IEntitySelector field_82219_bJ = new SCPFilterAttack();
    /**
     * How much damage this mob's attacks deal
     */
    protected int attackStrength = 0;

    public SCPEntity(World world) {
        super(world);
        this.experienceValue = 5;
        this.renderDistanceWeight = 10.0D;
        attackStrength = 6;
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, false, field_82219_bJ));
    }

    public void targetLivings() {
        List<?> var5 = this.worldObj.selectEntitiesWithinAABB(EntityLiving.class, this.boundingBox.expand((double) 16F, 4.0D, (double) 16F), field_82219_bJ);
        Iterator<?> var2 = var5.iterator();

        while (var2.hasNext()) {
            Entity var3 = (Entity) var2.next();
            EntityLiving var4 = (EntityLiving) var3;

            if (var4 != null) {
                entityToAttack = var4;
            }
        }
    }

    protected boolean canDespawn() {
        return false;
    }

    public void setAttackTarget(EntityLiving entity) {
        super.setAttackTarget(entity);
    }

    public SCPEnumCreatureAttribute getSCPAttribute() {
        return SCPEnumCreatureAttribute.SCP;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate() {
        super.onLivingUpdate();
        targetLivings();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        super.onUpdate();
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack() {
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return var1 != null && this.canEntityBeSeen(var1) ? var1 : null;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, int par2) {
        if (super.attackEntityFrom(source, par2)) {
            Entity entity = source.getEntity();

            if (this.riddenByEntity != entity && this.ridingEntity != entity) {
                if (entity != this) {
                    this.entityToAttack = entity;
                }

                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void onCollideWithPlayer(EntityPlayer player) {
        if (this.getSCPAttribute() != SCPEnumCreatureAttribute.SCPObject)
            player.attackEntityFrom(DamageSource.causeMobDamage(this), attackStrength);
    }

    public boolean attackEntityAsMob(Entity entity) {
        int var2 = this.attackStrength;
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity entity, float par2) {
        if (this.attackTime <= 0 && par2 < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float getBlockPathWeight(int x, int y, int z) {
        return 0.5F - this.worldObj.getLightBrightness(x, y, z);
    }

    public boolean interact(EntityPlayer player) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (stack != null && stack.getItem() == SCPItems.scp1023ARC) {
            this.setDead();
            this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + (double) (this.height / 2.0F), this.posZ, 0.0D, 0.0D, 0.0D);
            return true;
        } else {
            return super.interact(player);
        }
    }
}
