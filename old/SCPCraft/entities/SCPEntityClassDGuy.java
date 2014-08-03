package SCPCraft.entities;

import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SCPEntityClassDGuy extends SCPEntityD
{
	public boolean isVerminGod;

	public SCPEntityClassDGuy(World par1World)
	{
		super(par1World);
		setSize(0.9F, 1.3F);
		texture = "/SCPCraft/textures/mobs/ClassDGuy.png";
		getNavigator().setAvoidsWater(true);
		moveSpeed = 0.4F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 10F));
		tasks.addTask(1, new EntityAIWatchClosest(this, SCPEntityClassDGuy.class, 10F));
		tasks.addTask(2, new EntityAIWatchClosest(this, SCPEntity173.class, 10F));
		tasks.addTask(3, new EntityAIWatchClosest(this, SCPEntity111.class, 10F));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, SCPEntity.class, 9.0F, 0.4F, 0.3F));
	}
	
	protected void updateAITasks()
	{
		super.updateAITasks();
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	public void onUpdate()
	{
		super.onUpdate();
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected boolean canDespawn()
	{
		return false;
	}

	public int getMaxHealth()
	{
		return 30;
	}
}