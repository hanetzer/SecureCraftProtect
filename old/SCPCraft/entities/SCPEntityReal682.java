package SCPCraft.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;
import SCPCraft.models.SCPModelReal682;
import SCPCraft.renders.SCPRender682;

public class SCPEntityReal682 extends SCPEntity
{
	public SCPModelReal682 model;
	public SCPRender682 render;
    public float animTime = 0.0F;
	public boolean isGrowling;
	public int deathTicks = 0;
	protected int maxHealth = 60;
	
	public SCPEntityReal682(World world)
	{
		super(world);
		texture = "/SCPCraft/textures/mobs/Bosses/682/682.png";
		moveSpeed = 0.6F;
		this.maxHealth = 1200;
		this.health = maxHealth;
		stepHeight = 1.0F;
		render.scale = 1.7F;
		getNavigator().setAvoidsWater(true);
		float f = 0.25F;
        this.isImmuneToFire = true;
		this.isGrowling = false;
		model.isGrowling = false;
		this.yOffset *= 6.0F;
		this.setSize(4F, 2F);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIWander(this, f));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
		tasks.addTask(4, new EntityAIWatchClosest(this, EntityLiving.class, 18F));
		tasks.addTask(5, new EntityAIWatchClosest(this, SCPEntityClassDGuy.class, 18F));
		tasks.addTask(6, new EntityAILookIdle(this));
	}
	
	protected void updateAITasks()
    {
        super.updateAITasks();
        if (this.ticksExisted % 20 == 0)
        {
            this.heal(10);
        }
    }

	public int getMaxHealth()
	{
		return this.maxHealth;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(0));
		this.dataWatcher.addObject(17, new Integer(this.maxHealth));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{	
		super.onLivingUpdate();
		EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 9D);
        float var1 = MathHelper.cos(this.animTime * (float)Math.PI * 2.0F);
        if(var1 >= 0.5F && var1 <= 0.6F)isGrowling = true;
        else isGrowling = false;
        if(isGrowling)
        {
        	if(player != null && !player.capabilities.isCreativeMode)player.addPotionEffect(new PotionEffect(SCPPotion.shake.id, 20, 1));
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "sounds.Roar", 5F, 1F);
        }
        if (this.health > 0)
        {
            this.animTime += 0.002F;
        }
        
        if (!this.worldObj.isRemote)
		{
			this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
		}
		float par1;
		float var3;
		float var26;

		if (this.health <= 0)
		{
			for(int times = 0; times <= 3; times++)
			{
				this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "sounds.Roar", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
			}
			par1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			var26 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("largeexplode", this.posX + (double)par1, this.posY + 2.0D + (double)var26, this.posZ + (double)var3, 0.0D, 0.0D, 0.0D);
		}

		this.isJumping = false;
		
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2, EntityPlayer entityplayer)
	{
		return super.attackEntityFrom(par1DamageSource, par2);	
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset()
	{
		return (double)height * 1.6499999999999999D - 0.5D;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return true;
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		return super.interact(par1EntityPlayer);
	}


	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);
	}

	public void func_48150_h(boolean flag)
	{
		isJumping = flag;
	}

//	protected String getLivingSound()
//	{
//		return "scp.Roar";
//	}

	public boolean func_40149_l_()
	{
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void func_40148_a(boolean flag)
	{
		byte byte0 = dataWatcher.getWatchableObjectByte(16);

		if (flag)
		{
			byte0 |= 1;
		}
		else
		{
			byte0 &= 0xfe;
		}

		dataWatcher.updateObject(16, Byte.valueOf(byte0));
	}
	
	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	protected void onDeathUpdate()
	{
		render.scale -= 0.004;
		++this.deathTicks;
		EntityPlayer ep = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

		if (this.deathTicks >= 180 && this.deathTicks <= 200)
		{
			float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;

			this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)var1, this.posY + 2.0D + (double)var2, this.posZ + (double)var3, 0.0D, 0.0D, 0.0D);
		}

		int var4;
		int var5;

		if (!this.worldObj.isRemote && this.deathTicks > 150 && this.deathTicks % 5 == 0)
		{
			var4 = 500;

			while (var4 > 0)
			{
				var5 = EntityXPOrb.getXPSplit(var4);
				var4 -= var5;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote)
		{
			var4 = 500;

			while (var4 > 0)
			{
				var5 = EntityXPOrb.getXPSplit(var4);
				var4 -= var5;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
			}
			this.setDead();
		}
	}
	
	public boolean func_70845_n()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}
	
	/**
	 * Returns the health points of the dragon.
	 */
	public int getSCP682Health()
	{
		return this.dataWatcher.getWatchableObjectInt(16);
	}
}
