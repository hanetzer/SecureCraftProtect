package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SCPEntity019n2 extends SCPEntity
{
    public SCPEntity019n2(World par1World)
    {
        super(par1World);
        texture = "/SCPCraft/textures/mobs/019-2.png";
        moveSpeed = 0.3F;
        attackStrength = 4;
        this.setSize(0.2F, 0.2F);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAISCP0173Attack(this, net.minecraft.entity.player.EntityPlayer.class, moveSpeed, false));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
        tasks.addTask(2, new EntityAIWander(this, moveSpeed));
        tasks.addTask(3, new EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 8F));
        tasks.addTask(4, new EntityAILookIdle(this));
        tasks.addTask(5, new EntityAILeapAtTarget(this, 0.4F));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.entity.player.EntityPlayer.class, 16F, 0, true));
    }

    public int getMaxHealth()
    {
        return 20;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    protected void attackEntity(Entity par1Entity, float par2)
    {

        if (par2 > 2.0F && par2 < 6F && rand.nextInt(10) == 0)
        {
            if (onGround)
            {
                double d = par1Entity.posX - posX;
                double d1 = par1Entity.posZ - posZ;
                float f1 = MathHelper.sqrt_double(d * d + d1 * d1);
                motionX = (d / (double)f1) * 0.5D * 0.80000001192092896D + motionX * 0.20000000298023224D;
                motionZ = (d1 / (double)f1) * 0.5D * 0.80000001192092896D + motionZ * 0.20000000298023224D;
                motionY = 0.40000000596046448D;
            }
        }
        else
        {
            super.attackEntity(par1Entity, par2);
        }
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.silverfish.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.silverfish.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.silverfish.kill";
    }
}
