package SCPCraft.items;

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.SCPInventory000J;
import SCPCraft.mod_SCP;
import SCPCraft.guis.SCPGui000J;

public class SCPItem000J extends Item
{
	public static String Illness;
	public static int Disease;	
	Random rand = new Random();

	public SCPItem000J(int i)
	{
		super(i);
		setMaxStackSize(1);
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		EntityPlayer ep = ModLoader.getMinecraftInstance().thePlayer;
		ModLoader.openGUI(var3, new SCPGui000J(new SCPInventory000J(var1), var3));
		return var1;
	}
}
