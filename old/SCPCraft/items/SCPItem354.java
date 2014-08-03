package SCPCraft.items;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.worldgen.SCPWorldGenSCP354;

public class SCPItem354 extends SCPItemDocument
{
	public SCPWorldGenSCP354 worldgenlakes = new SCPWorldGenSCP354(mod_SCP.SCP354Still.blockID);
	public Random rand = new Random();

	public SCPItem354(int i)
	{
		super(i, 2);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a74SCP-354");
		list.add("\u00a77The Red Pool");
	}

	public boolean isFull3D()
	{
		return true;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{		
		worldgenlakes.generate(par3World, rand, par4, par5, par6);
		worldgenlakes.generate(par3World, rand, par4 - 8, par5, par6);
		worldgenlakes.generate(par3World, rand, par4, par5, par6 + 8);
		worldgenlakes.generate(par3World, rand, par4 + 8, par5, par6);
		worldgenlakes.generate(par3World, rand, par4, par5, par6 - 8);
		worldgenlakes.generate(par3World, rand, par4 - 8, par5, par6 - 8);
		worldgenlakes.generate(par3World, rand, par4 + 8, par5, par6 + 8);
		worldgenlakes.generate(par3World, rand, par4 + 8, par5, par6 -8);
		worldgenlakes.generate(par3World, rand, par4 - 8, par5, par6 + 8);
		worldgenlakes.generate(par3World, rand, par4 - 16, par5, par6);
		worldgenlakes.generate(par3World, rand, par4, par5, par6 + 16);
		worldgenlakes.generate(par3World, rand, par4 + 16, par5, par6);
		worldgenlakes.generate(par3World, rand, par4, par5, par6 - 16);

		par2EntityPlayer.addChatMessage("SCP-354 Spawned." + " | [Type: \u00a74Keter\u00a7f]");
		par1ItemStack.damageItem(2, par2EntityPlayer);
		return true;
	}
}