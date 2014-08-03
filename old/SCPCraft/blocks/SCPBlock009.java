package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPBlock009 extends Block
{
	public SCPBlock009(int par1, int par2)
	{
		super(par1, Material.ice);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
		setTickRandomly(true);
		this.slipperiness = 1F;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.SCP009.blockID;
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":SCP009");
    }

	public int tickRate()
	{
		return 4;
	}

	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) 
	{
		ItemStack var2 = par5EntityPlayer.inventory.getCurrentItem(); 

		Minecraft minecraft = ModLoader.getMinecraftInstance();

		ItemStack boots = minecraft.thePlayer.inventory.armorInventory[0]; 
		ItemStack legs = minecraft.thePlayer.inventory.armorInventory[1]; 
		ItemStack chest = minecraft.thePlayer.inventory.armorInventory[2]; 
		ItemStack helm = minecraft.thePlayer.inventory.armorInventory[3]; 
	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		EntityPlayer par5EntityPlayer = ModLoader.getMinecraftInstance().thePlayer;
		ItemStack var2 = par5EntityPlayer.inventory.getCurrentItem(); 
		Minecraft minecraft = ModLoader.getMinecraftInstance();

		ItemStack boots = minecraft.thePlayer.inventory.armorInventory[0]; 
		ItemStack legs = minecraft.thePlayer.inventory.armorInventory[1]; 
		ItemStack chest = minecraft.thePlayer.inventory.armorInventory[2]; 
		ItemStack helm = minecraft.thePlayer.inventory.armorInventory[3]; 
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack var2 = par5EntityPlayer.inventory.getCurrentItem(); 
		Minecraft minecraft = ModLoader.getMinecraftInstance();

		ItemStack boots = minecraft.thePlayer.inventory.armorInventory[0]; 
		ItemStack legs = minecraft.thePlayer.inventory.armorInventory[1]; 
		ItemStack chest = minecraft.thePlayer.inventory.armorInventory[2]; 
		ItemStack helm = minecraft.thePlayer.inventory.armorInventory[3]; 
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			for (int var6 = 0; var6 < 100; ++var6)
			{
				int var7 = par2 + par5Random.nextInt(3) - 1;
				int var8 = par3 + par5Random.nextInt(5) - 3;
				int var9 = par4 + par5Random.nextInt(3) - 1;
				int var10 = par1World.getBlockId(var7, var8 + 1, var9);

				if (par1World.getBlockId(var7, var8, var9) == 0)
				{
					par1World.setBlock(var7, var8, var9, mod_SCP.SCP009.blockID);
				}
			}
		}
	}
}
