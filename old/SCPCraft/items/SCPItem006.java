package SCPCraft.items;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.worldgen.SCPWorldGen006;

public class SCPItem006 extends SCPItemDocument
{
	public SCPWorldGen006 worldgenlakes = new SCPWorldGen006(mod_SCP.SCP006Still.blockID);
	public Random rand = new Random();

	public SCPItem006(int i)
	{
		super(i, 0);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a72SCP-006");
		list.add("\u00a77Fountain of Youth");
	}

	public boolean isFull3D()
	{
		return true;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{		
		worldgenlakes.generate(par3World, rand, par4, par5, par6);

		par2EntityPlayer.addChatMessage("SCP-006 Spawned." + " | [Type: \u00a72Safe\u00a7f]");
		par1ItemStack.damageItem(2, par2EntityPlayer);
		return true;
	}
}