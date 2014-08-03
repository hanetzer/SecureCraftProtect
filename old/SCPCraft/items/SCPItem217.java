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

public class SCPItem217 extends SCPItemDocument
{
	private int color;
	@SideOnly(Side.CLIENT)
	public Icon empty, filled;

	public SCPItem217(int par1, int col)
	{
		super(par1);
		maxStackSize = 1;
		color = col;
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public Icon getIconFromDamageForRenderPass(int par1, int par2)
	{
		if(color != -1){
			if(par2 == 0)return empty;
			else return filled;
		}
		else return empty;
	}

	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
		empty = par1IconRegister.registerIcon(mod_SCP.modid + ":" + "SCP217_Shell");
		filled = par1IconRegister.registerIcon(mod_SCP.modid + ":" + "SCP217_Overlay");        
	}

	public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
	{
		if(par2 == 0)return 0xffffff;
		else return color;
	}

	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	public int getRenderPasses(int metadata)
	{
		return 2;
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

			return true;
		}
	}

}
