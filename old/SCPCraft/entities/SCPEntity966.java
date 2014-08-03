package SCPCraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPEntity966 extends SCPEntity
{
	/**
	 * Used to control movement as well as wool regrowth. Set to 40 on handleHealthUpdate and counts down with each
	 * tick.
	 */
	private int freezeTimer;
	public boolean field_70885_d = false;
	public float field_70886_e = 0.0F;
	public float destPos = 0.0F;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;

	public int timeUntilFreeze;
	public SCPEntity966(World par1World)
	{
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/966Infrared.png";
		this.setSize(1.0F, 2.0F);
		float var2 = 0.23F;
		this.moveSpeed = 0.3F;
		this.timeUntilFreeze = this.rand.nextInt(800);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIWander(this, var2));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(1, new EntityAISCP0173Attack(this, EntityPlayer.class, this.moveSpeed, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{       
		return false;
	}

	public String getTexture()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, 48.0D);
		if(entityplayer != null)
		{
			ItemStack var2 = entityplayer.inventory.armorInventory[3];

			if(var2 != null && var2.itemID == mod_SCP.InfraRedGlasses.itemID)
			{
				return "/SCPCraft/textures/mobs/966Infrared.png";
			}
			else
			{
				return "/SCPCraft/textures/mobs/966Invis.png";
			}
		}
		return "/SCPCraft/textures/mobs/966Invis.png";
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return true;
	}

	protected void updateAITasks()
	{
		super.updateAITasks();
	}

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

		if (!this.isChild() && --this.timeUntilFreeze <= 0)
		{

			if (!this.worldObj.isRemote)
			{
				this.moveSpeed = 0.0F;
				this.entityToAttack = null;
				this.worldObj.playSoundAtEntity(this, "mob.blaze.breath", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}
			this.timeUntilFreeze = this.rand.nextInt(1200);
		}
	}


	public int getMaxHealth()
	{
		return 9001;
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return super.attackEntityAsMob(par1Entity);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	protected boolean canDespawn()
	{
		return false;
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
}
