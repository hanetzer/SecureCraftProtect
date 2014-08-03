package SCPCraft.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.guis.SCPGui1025;

public class SCPItem1025 extends Item
{
	public static String Illness;
	public static int Disease;	
	Random rand = new Random();
	
	public SCPItem1025(int i)
	{
		super(i);
		setMaxStackSize(1);
		this.setCreativeTab(mod_SCP.tabSCP);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World var2, EntityPlayer var3)
	{
		ModLoader.openGUI(var3, new SCPGui1025(this, var3));
		return par1ItemStack;
	}
}
