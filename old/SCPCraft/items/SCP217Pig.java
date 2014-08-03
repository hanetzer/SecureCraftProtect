package SCPCraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity217Cow;
import SCPCraft.entities.SCPEntity217Creeper;
import SCPCraft.entities.SCPEntity217Pig;
import SCPCraft.entities.SCPEntity217Spider;
import SCPCraft.entities.SCPEntity217Testificate;
import SCPCraft.entities.SCPEntity217Zombie;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCP217Pig extends SCPItem217
{
	private int color;

	public SCP217Pig(int par1, int col)
	{
		super(par1, col);
		maxStackSize = 1;
		color = col;
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par3World.isRemote)
		{
			return true;
		}
		else
		{
			int var11 = par3World.getBlockId(par4, par5, par6);
			par4 += Facing.offsetsXForSide[par7];
			par5 += Facing.offsetsYForSide[par7];
			par6 += Facing.offsetsZForSide[par7];
			double var12 = 0.0D;

			if (par7 == 1 && var11 == Block.fence.blockID || var11 == Block.netherFence.blockID)
			{
				var12 = 0.5D;
			}

			if (spawnCreature(par3World, par1ItemStack.getItemDamage(), (double)par4 + 0.5D, (double)par5 + var12, (double)par6 + 0.5D) && !par2EntityPlayer.capabilities.isCreativeMode)
			{
				--par1ItemStack.stackSize;
			}

			return true;
		}
	}

	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{		
		SCPEntity217Pig ent= new SCPEntity217Pig(par0World);
		ent.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(ent);
		((EntityLiving)ent).playLivingSound();

		return true;
	}

}
