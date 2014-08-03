package SCPCraft.entities;

import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.guis.SCPGuiButler;

public class SCPEntityButler extends SCPEntityD
{
	public SCPGuiButler gui;
	
	public SCPEntityButler(World par1World)
	{
		super(par1World);
		setSize(1.0F, 2.0F);
		texture = "/SCPCraft/textures/mobs/MrDeeds.png";
		getNavigator().setAvoidsWater(true);
		moveSpeed = 0.35F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 10F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, SCPEntity173.class, 10F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, SCPEntity111.class, 10F));
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
		return 50;
	}

	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
		if (var2 == null)
		{
			ModLoader.openGUI(par1EntityPlayer, new SCPGuiButler(par1EntityPlayer.inventory, this, this.worldObj));
			return super.interact(par1EntityPlayer);
		}
		else
		{
			return super.interact(par1EntityPlayer);
		}
	}
}