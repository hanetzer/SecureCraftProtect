package SCPCraft.entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
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
import SCPCraft.mod_SCP;
import SCPCraft.CoroAI.PFQueue;

public class SCPEntity096Mad extends SCPEntity
{
	public boolean isAttacking;
    private static final IEntitySelector field_82219_bJ = new SCPFilterAttack();	
	int time;

	public SCPEntity096Mad(World par1World)
	{
		super(par1World);
		this.texture = "/SCPCraft/textures/mobs/096Mad.png";
		this.moveSpeed = 0.7F;
		this.attackStrength = 200;
		this.time = 0;
		this.getNavigator().setAvoidsWater(true);
		this.isAttacking = false;
		this.isImmuneToFire = true;
		this.setSize(0.8F, 1.8F);
		this.worldObj.getClosestVulnerablePlayerToEntity(this, 256D);
		PFQueue.getPath(this, entityToAttack, 256F);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(2, new EntityAISCP0173Attack(this, EntityLiving.class, this.moveSpeed, true));
		this.tasks.addTask(3, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 48.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 48.0F, 0, false, false, field_82219_bJ));
	}

	public int getMaxHealth()
	{
		return 9001;
	}
    
    public void targetLivings()
    {
    	List<?> var5 = this.worldObj.selectEntitiesWithinAABB(EntityLiving.class, this.boundingBox.expand((double)64F, 40.0D, (double)64F), field_82219_bJ);
        Iterator<?> var2 = var5.iterator();

        while (var2.hasNext())
        {
            Entity var3 = (Entity)var2.next();
            EntityLiving var4 = (EntityLiving)var3;

            if (var4 != null)
            {
                entityToAttack = var4;
            }
        }
    }

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return true;
	}

	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 256D);

		if (entityplayer != null)
		{
			isAttacking = true;
		}

		return entityplayer;
	}

	public void onLivingUpdate()
	{
		int i = MathHelper.floor_double(posX);
		int k = MathHelper.floor_double(posY);
		int i1 = MathHelper.floor_double(posZ);
		isAttacking = entityToAttack != null;
		int min;			
		PFQueue.getPath(this, entityToAttack, 256F);

		if(entityToAttack != null && entityToAttack instanceof EntityPlayer && ((EntityPlayer)entityToAttack).is096Target == true && !entityToAttack.isEntityAlive())
		{
			if(!worldObj.isRemote)
			{	
				this.setDead();
				spawnCreature(worldObj, this.posX, this.posY, this.posZ);
			}
		}
		if(time % 90 == 0)this.worldObj.playSoundAtEntity(this, "sounds.096Scream", 0.2F, 1F);
		time++;

		Block ablock[] =
			{
				Block.bedrock, mod_SCP.Locker
			};
		if(entityToAttack != null && this.posY == entityToAttack.posY)min = 0;
		else min = 1;

		for(int m = min; m <= 3; m++)
		{		
			for(int length = 0; length <= ablock.length - 1; length++) {
		        int met1 = this.worldObj.getBlockMetadata(i + 1, k + m, i1);
                int id1 = this.worldObj.getBlockId(i + 1, k + m, i1);
		        int met2 = this.worldObj.getBlockMetadata(i - 1, k + m, i1);
                int id2 = this.worldObj.getBlockId(i - 1, k + m, i1);
		        int met3 = this.worldObj.getBlockMetadata(i, k + m, i1 - 1);
                int id3 = this.worldObj.getBlockId(i, k + m, i1 - 1);
		        int met4 = this.worldObj.getBlockMetadata(i, k + m, i1 + 1);
                int id4 = this.worldObj.getBlockId(i, k + m, i1 + 1);
				if(worldObj.getBlockId(i + 1, k + m, i1) != ablock[length].blockID){
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			        this.worldObj.playAuxSFX(2001, i + 1, k + m, i1, id1 + (met1 << 12));
					worldObj.setBlock(i + 1, k + m, i1, 0);}
				if(worldObj.getBlockId(i - 1, k + m, i1) != ablock[length].blockID){
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			        this.worldObj.playAuxSFX(2001, i - 1, k + m, i1, id2 + (met2 << 12));
					worldObj.setBlock(i - 1, k + m, i1, 0);}
				if(worldObj.getBlockId(i, k + m, i1 - 1) != ablock[length].blockID){
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			        this.worldObj.playAuxSFX(2001, i, k + m, i1 - 1, id3 + (met3 << 12));
					worldObj.setBlock(i, k + m, i1 - 1, 0);}
				if(worldObj.getBlockId(i, k + m, i1 + 1) != ablock[length].blockID){
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			        this.worldObj.playAuxSFX(2001, i, k + m, i1 + 1, id4 + (met4 << 12));
					worldObj.setBlock(i, k + m, i1 + 1, 0);}
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

		isJumping = false;
		
		super.onLivingUpdate();
	}
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.villager.default";
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
		return "mob.villager.default";
	}

	protected boolean canDespawn()
	{
		return false;
	}
	
	public static boolean spawnCreature(World par0World, double par2, double par4, double par6)
	{
		SCPEntity096Docile var8 = new SCPEntity096Docile(par0World);
		var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}
