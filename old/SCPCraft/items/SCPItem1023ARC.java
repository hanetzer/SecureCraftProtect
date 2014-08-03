package SCPCraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem1023ARC extends Item
{
	public SCPItem1023ARC(int i)
	{
		super(i);
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
	{
		World world = ModLoader.getMinecraftInstance().theWorld;
		EntityPlayer entityplayer = ModLoader.getMinecraftInstance().thePlayer;
		
		onItemRightClick(itemstack, world, entityplayer);
		return true;
	}
	
	public boolean isFull3D()
	{
		return true;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}
	
	public int getDamageVsEntity(Entity par1Entity)
    {
        return 9999999;
    }
}
