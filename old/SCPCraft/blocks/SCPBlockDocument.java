package SCPCraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.containerslots.SCPContainerDocument;
import net.minecraft.util.*;

public class SCPBlockDocument extends Block
{	
	private Icon[] icons;

	public SCPBlockDocument(int par1, boolean par2)
	{
		super(par1, Material.iron);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public void registerIcons(IconRegister par1)
	{
		icons = new Icon[3];

		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1.registerIcon(mod_SCP.modid + ":" + (this.getUnlocalizedName2()) + i);
		}
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par2)
		{
		default:
		case 0:
		{
			switch(par1)
			{
			case 0: return icons[0];
			case 1: return icons[2];
			default: return icons[1];
			}
		}
		}
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
	{
		if (var5 instanceof EntityPlayerMP)
		{
			if (var1.isRemote)
			{
				return true;
			}
			else
			{
				SCPContainerDocument var11 = new SCPContainerDocument(var5.inventory, var1, var2, var3, var4);
				ModLoader.serverOpenWindow((EntityPlayerMP)var5, var11, 6079, var2, var3, var4);
				return true;
			}
		}
		else
		{
			return true;
		}
	}
}
