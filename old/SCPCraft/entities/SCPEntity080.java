package SCPCraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class SCPEntity080 extends SCPEntity
{
	private int teleportDelay;
	
    public SCPEntity080(World par1World)
    {	
        super(par1World);
        setSize(0.3F, 0.7F);
        texture = "/SCPCraft/textures/mobs/080.png";
		moveSpeed = 0.3F;
		teleportDelay = 10;
		attackStrength = 10;
		getNavigator().setAvoidsWater(true);
		isImmuneToFire = true;
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAISCP0173Attack(this, EntityPlayer.class, moveSpeed, false));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		tasks.addTask(2, new EntityAIWander(this, 0.2F));
		tasks.addTask(3, new EntityAIRestrictSun(this));
        tasks.addTask(4, new EntityAIFleeSun(this, moveSpeed));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 4F));
		tasks.addTask(6, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16F, 0, true));
    }

    public int getMaxHealth()
    {
        return 9001;
    }    

	public boolean isAIEnabled()
	{
		return true;
	}
	
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        return false;
    }
    
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		int dmg = 1;			
		if(worldObj.difficultySetting == 1){
			dmg = 2;
		}
		else if(worldObj.difficultySetting == 2){
			dmg = 3;
		}
		else if (worldObj.difficultySetting == 3){
			dmg = 4;
		}			
		par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), dmg);

		return true;
	}
    
    public void playLivingSound()
    {
        String s = getLivingSound();

        if (s != null)
        {
            worldObj.playSoundAtEntity(this, s, 0.5F, 2.0F);
        }
    }
    
    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)0));
    }

    public int getBrightnessForRender(float par1)
    {
        return 0xf000f0;
    }
    
    public float getBrightness(float par1)
    {
        return 10.0F;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posY);
        int i1 = MathHelper.floor_double(posZ);
        
        if (worldObj.isDaytime() && !worldObj.isRemote)
        {
            float f = getBrightness(1.0F);

            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F || worldObj.getSavedLightValue(EnumSkyBlock.Block, i, j, i1) > 7)
            {
                setDead();
            }
        }
        
        for (int k = 0; k < 1; k++)
		{
			worldObj.spawnParticle("SCP080", posX, posY + 0.2D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 0.2D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 0.2D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 0.2D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 0.2D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			
			worldObj.spawnParticle("SCP080", posX, posY + 0.6D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 0.6D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 0.6D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 0.6D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 0.6D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));

			worldObj.spawnParticle("SCP080", posX, posY + 0.8D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 0.8D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 0.8D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 0.8D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 0.8D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 0.8D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 0.8D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 0.8D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 0.8D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			
			worldObj.spawnParticle("SCP080", posX, posY + 1D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			
			worldObj.spawnParticle("SCP080", posX, posY + 1.2D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1.2D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1.2D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1.2D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1.2D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1.2D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1.2D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1.2D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1.2D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			
			worldObj.spawnParticle("SCP080", posX, posY + 1.5D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1.5D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1.5D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1.5D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1.5D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			
			worldObj.spawnParticle("SCP080", posX, posY + 1.8D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1.8D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1.8D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1.8D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1.8D, posZ, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX, posY + 1.8D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1.8D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX - 0.2D, posY + 1.8D, posZ + 0.2D, (0.0D), 0.0D, (0.0D));
			worldObj.spawnParticle("SCP080", posX + 0.2D, posY + 1.8D, posZ - 0.2D, (0.0D), 0.0D, (0.0D));
		}
        
        if(entityToAttack != null && this.getDistanceToEntity(entityToAttack) >= 0F && this.getDistanceToEntity(entityToAttack) <= 5F)
        {
        	if(entityToAttack instanceof EntityPlayer)
        	{
        		if(!((EntityPlayer) entityToAttack).capabilities.isCreativeMode)
        		{
        			((EntityLiving)entityToAttack).addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 0));
        		}
        	}
        	else
        	{
        		((EntityLiving)entityToAttack).addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 0));	
        	}
        }
        if (worldObj.isDaytime() && !worldObj.isRemote)
        {
            float f = getBrightness(1.0F);

            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                entityToAttack = null;
            }
        }
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        
        if(teleportDelay <= 1 && entityToAttack != null)
        {
			teleportToEntity(entityplayer);
        }

        super.onLivingUpdate();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        double d = 16D;
        return worldObj.getClosestVulnerablePlayerToEntity(this, d);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "sounds.stairs";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.blaze.breath";
    }
  
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }
    
	protected boolean canDespawn()
	{
		return false;
	}
	
	/**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        return true;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        if (super.getCanSpawnHere())
        {
            EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 5D);
            return entityplayer == null;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Teleport the enderman to a random nearby position
     */
    protected boolean teleportRandomly()
    {
        double d = posX + (rand.nextDouble() - 0.5D) * 64D;
        double d1 = posY + (double)(rand.nextInt(64) - 32);
        double d2 = posZ + (rand.nextDouble() - 0.5D) * 64D;
        return teleportTo(d, d1, d2);
    }

    /**
     * Teleport the enderman to another entity
     */
    protected boolean teleportToEntity(Entity par1Entity)
    {
        Vec3 vec3d = Vec3.createVectorHelper(posX - par1Entity.posX, ((boundingBox.minY + (double)(height / 2.0F)) - par1Entity.posY) + (double)par1Entity.getEyeHeight(), posZ - par1Entity.posZ);
        vec3d = vec3d.normalize();
        double d = 16D;
        double d1 = (posX + (rand.nextDouble() - 0.5D) * 8D) - vec3d.xCoord * d;
        double d2 = (posY + (double)(rand.nextInt(16) - 8)) - vec3d.yCoord * d;
        double d3 = (posZ + (rand.nextDouble() - 0.5D) * 8D) - vec3d.zCoord * d;
        return teleportTo(d1, d2, d3);
    }

    /**
     * Teleport the enderman
     */
    protected boolean teleportTo(double par1, double par3, double par5)
    {
        double d = posX;
        double d1 = posY;
        double d2 = posZ;
        posX = par1;
        posY = par3;
        posZ = par5;
        boolean flag = false;
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posY);
        int k = MathHelper.floor_double(posZ);

        if (worldObj.blockExists(i, j, k))
        {
            boolean flag1;

            for (flag1 = false; !flag1 && j > 0;)
            {
                int i1 = worldObj.getBlockId(i, j - 1, k);

                if (i1 == 0 || !Block.blocksList[i1].blockMaterial.blocksMovement())
                {
                    posY--;
                    j--;
                }
                else
                {
                    flag1 = true;
                }
            }

            if (flag1)
            {
                setPosition(posX, posY, posZ);

                if (worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.isAnyLiquid(boundingBox))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            setPosition(d, d1, d2);
            return false;
        }

        int l = 128;

        for (int j1 = 0; j1 < l; j1++)
        {
            double d3 = (double)j1 / ((double)l - 1.0D);
            float f = (rand.nextFloat() - 0.5F) * 0.2F;
            float f1 = (rand.nextFloat() - 0.5F) * 0.2F;
            float f2 = (rand.nextFloat() - 0.5F) * 0.2F;
            double d4 = d + (posX - d) * d3 + (rand.nextDouble() - 0.5D) * (double)width * 2D;
            double d5 = d1 + (posY - d1) * d3 + rand.nextDouble() * (double)height;
            double d6 = d2 + (posZ - d2) * d3 + (rand.nextDouble() - 0.5D) * (double)width * 2D;
        }
        return true;
    }
}
