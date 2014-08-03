package SCPCraft.items;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntityButler;

public class SCPItem662 extends Item
{
	public SCPItem662(int i)
	{
		super(i);
		setMaxStackSize(1);
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(!world.isRemote)
		{
			spawnCreature(world, entityplayer.posX, entityplayer.posY, entityplayer.posZ);

			if(!entityplayer.capabilities.isCreativeMode)
			{
				itemstack.stackSize--;
			}
		}

		return itemstack;
	}

	public static boolean spawnCreature(World par0World, double par2, double par4, double par6)
	{

		SCPEntityButler var8 = new SCPEntityButler(par0World);
		var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();

		return var8 != null;
	}
}
