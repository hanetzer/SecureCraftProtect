package SCPCraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SCPEntity594Naked extends EntityAnimal
{
    /**
     * Holds the RGB table of the sheep colors - in OpenGL glColor3f values - used to render the sheep colored fleece.
     */
    public static final float[][] fleeceColorTable = new float[][] {{1.0F, 1.0F, 1.0F}, {0.95F, 0.7F, 0.2F}, {0.9F, 0.5F, 0.85F}, {0.6F, 0.7F, 0.95F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.7F, 0.8F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.6F, 0.7F}, {0.7F, 0.4F, 0.9F}, {0.2F, 0.4F, 0.8F}, {0.5F, 0.4F, 0.3F}, {0.4F, 0.5F, 0.2F}, {0.8F, 0.3F, 0.3F}, {0.1F, 0.1F, 0.1F}};

    /**
     * Used to control movement as well as wool regrowth. Set to 40 on handleHealthUpdate and counts down with each
     * tick.
     */
    private int sheepTimer;
    public boolean field_70885_d = false;
    public float field_70886_e = 0.0F;
    public float destPos = 0.0F;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;

    /** The time until the next egg is spawned. */
    public int timeUntilNextWool;

    /** The eat grass AI task for this mob. */
    private EntityAIEatGrass aiEatGrass = new EntityAIEatGrass(this);

    public SCPEntity594Naked(World par1World)
    {
        super(par1World);
        this.texture = "/SCPCraft/textures/mobs/594Naked.png";
        this.setSize(0.8F, 1.3F);
        float var2 = 0.23F;
        this.timeUntilNextWool = this.rand.nextInt(1000);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, new EntityAIMate(this, var2));
        this.tasks.addTask(3, new EntityAITempt(this, 0.25F, Item.wheat.itemID, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
        this.tasks.addTask(5, this.aiEatGrass);
        this.tasks.addTask(6, new EntityAIWander(this, var2));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
    	if(!isAggro)return true;
    	else return false;
    }

    protected void updateAITasks()
    {
        this.sheepTimer = this.aiEatGrass.getEatGrassTick();
        super.updateAITasks();
    }

    protected void fall(float par1) {}
    
    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
    	 super.onLivingUpdate();
         this.field_70888_h = this.field_70886_e;
         this.field_70884_g = this.destPos;
         this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);

         if (this.destPos < 0.0F)
         {
             this.destPos = 0.0F;
         }

         if (this.destPos > 1.0F)
         {
             this.destPos = 1.0F;
         }
         

         if (!this.onGround && this.field_70889_i < 1.0F)
         {
             this.field_70889_i = 1.0F;
         }

         this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

         if (!this.onGround && this.motionY < 0.0D)
         {
             this.motionY *= 0.6D;
         }

         this.field_70886_e += this.field_70889_i * 2.0F;

         if (!this.isChild() && --this.timeUntilNextWool <= 0)
         {
     
             if (!this.worldObj.isRemote)
             {
            	 this.setDead();
                 SCPEntity594 var10 = new SCPEntity594(this.worldObj);
                 var10.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
                 var10.setEntityHealth(this.getHealth());
                 var10.renderYawOffset = this.renderYawOffset;
                 this.worldObj.spawnEntityInWorld(var10);
                 this.worldObj.playSoundAtEntity(this, "mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
             }
             this.timeUntilNextWool = this.rand.nextInt(1000);
         }
    }

    public int getMaxHealth()
    {
        return 16;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 10)
        {
            this.sheepTimer = 40;
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public float func_70894_j(float par1)
    {
        return this.sheepTimer <= 0 ? 0.0F : (this.sheepTimer >= 4 && this.sheepTimer <= 36 ? 1.0F : (this.sheepTimer < 4 ? ((float)this.sheepTimer - par1) / 4.0F : -((float)(this.sheepTimer - 40) - par1) / 4.0F));
    }

    public float func_70890_k(float par1)
    {
        if (this.sheepTimer > 4 && this.sheepTimer <= 36)
        {
            float var2 = ((float)(this.sheepTimer - 4) - par1) / 32.0F;
            return ((float)Math.PI / 5F) + ((float)Math.PI * 7F / 100F) * MathHelper.sin(var2 * 28.7F);
        }
        else
        {
            return this.sheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch / (180F / (float)Math.PI);
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

        return super.interact(par1EntityPlayer);
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
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.sheep";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.sheep";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.sheep";
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return new SCPEntity594(worldObj);
	}
}
