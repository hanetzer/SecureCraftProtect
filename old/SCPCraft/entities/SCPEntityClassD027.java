package SCPCraft.entities;

import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;

public class SCPEntityClassD027 extends SCPEntityD
{
	public boolean isVerminGod;
	public static boolean isDead;

	public SCPEntityClassD027(World par1World)
	{
		super(par1World);
		setSize(0.9F, 1.3F);
		texture = "/SCPCraft/textures/mobs/ClassDGuy.png";
		getNavigator().setAvoidsWater(true);
		moveSpeed = 0.4F;
		tasks.addTask(0, new EntityAIAvoidEntity(this, SCPEntityRat.class, 6.0F, 0.25F, 0.3F));
		tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 10F));
		tasks.addTask(1, new EntityAIWatchClosest(this, SCPEntityClassD027.class, 10F));
		tasks.addTask(2, new EntityAIWatchClosest(this, SCPEntity173.class, 10F));
		tasks.addTask(3, new EntityAIWatchClosest(this, SCPEntity111.class, 10F));
	}
	protected void updateAITasks()
	{
		super.updateAITasks();
	}

	public void onLivingUpdate()
	{
		this.addPotionEffect(new PotionEffect(SCPPotion.verminGod.id, 100 * 100, 1));
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

	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
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