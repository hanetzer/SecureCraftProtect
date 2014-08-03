package SCPCraft.entities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISCP0173Attack;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SCPCraft.SCPDamageSource;

public class SCPEntity073 extends SCPEntity
{
	Random rand = new Random();
	public SCPEntity073(World par1World)
	{
		//Able
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/073.png";
		this.moveSpeed = 0.35F;
		this.health = 150;
		this.attackStrength = 6;
		this.isImmuneToFire = true;
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAISCP0173Attack(this, SCPEntity076.class, this.moveSpeed, true));
		this.tasks.addTask(3, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.3F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, SCPEntity076.class, 16.0F, 0, false));
	}
    
    public void targetLivings()
    {
    }

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		EntityPlayer ep = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		EntityLiving entity = (EntityLiving)par1DamageSource.getEntity();
		if(entity != null){
			entity.attackEntityFrom(SCPDamageSource.SCP073, par2);
			this.heal(par2);
		}
		if(ep != null && !this.worldObj.isRemote)ep.addChatMessage("\u00a7lSCP-073: \u00a7rPlease don't do that again. It hurts :c");
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	public int getMaxHealth()
	{
		return this.health;
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

		int var1 = MathHelper.floor_double(this.posX);
		int var2 = MathHelper.floor_double(this.posZ);
		for (var1 = 0; var1 < 4; ++var1)
		{
			var2 = MathHelper.floor_double(this.posX + (double)((float)(var1 % 2 * 2 - 1) * 0.25F));
			int var3 = MathHelper.floor_double(this.posY);
			int var4 = MathHelper.floor_double(this.posZ + (double)((float)(var1 / 2 % 2 * 2 - 1) * 0.25F));

			if (this.worldObj.getBlockId(var2, var3 - 1, var4) == Block.grass.blockID)
			{
				this.worldObj.setBlock(var2, var3 - 1, var4, Block.dirt.blockID);
			}

			if (this.worldObj.getBlockId(var2, var3, var4) == Block.tallGrass.blockID)
			{
				this.worldObj.setBlock(var2, var3, var4, 0);
			}

			if (this.worldObj.getBlockId(var2, var3, var4) == Block.plantRed.blockID || this.worldObj.getBlockId(var2, var3, var4) == Block.plantYellow.blockID)
			{
				this.worldObj.setBlock(var2, var3, var4, 0);
			}
		}
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
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
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return 0;
	}

	protected boolean canDespawn()
	{
		return false;
	}

}