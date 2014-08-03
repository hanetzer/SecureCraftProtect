package SCPCraft.items;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity50AEJ;

public class SCPItem50AEJ extends SCPItem
{
	public SCPItem50AEJ(int i)
	{
		super(i);
		setMaxStackSize(1);
		this.setCreativeTab(mod_SCP.tabSCP);
		setMaxDamage(300);
	}

	public boolean isFull3D()
	{
		return true;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World var2, EntityPlayer var3)
	{
		if(!var2.isRemote){
		SCPEntity50AEJ var8 = new SCPEntity50AEJ(var2);
		var8.setLocationAndAngles(var3.posX, var3.posY, var3.posZ, var2.rand.nextFloat() * 360.0F, 0.0F);
		var2.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();
		}
		return par1ItemStack;
	}
}

