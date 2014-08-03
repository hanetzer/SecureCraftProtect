package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import SCPCraft.SCPPotion;
import SCPCraft.mod_SCP;

public class SCPBlock409 extends Block
{
	public SCPBlock409(int par1, int par2)
	{
		super(par1, Material.glass);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
		setTickRandomly(true);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.SCP409.blockID;
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }

	public int tickRate()
	{
		return 2;
	}

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.125F;
        return AxisAlignedBB.getAABBPool().getAABB((double)(par2 + var5), (double)(par3 + var5), (double)(par4 + var5), (double)((par2 + 1) - var5), (double)((float)(par3 + 1) - var5), (double)((par4 + 1) - var5));
    }

	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) 
	{
		ItemStack var2 = par5EntityPlayer.inventory.getCurrentItem(); 

		Minecraft minecraft = ModLoader.getMinecraftInstance();

		ItemStack boots = minecraft.thePlayer.inventory.armorInventory[0]; 
		ItemStack legs = minecraft.thePlayer.inventory.armorInventory[1]; 
		ItemStack chest = minecraft.thePlayer.inventory.armorInventory[2]; 
		ItemStack helm = minecraft.thePlayer.inventory.armorInventory[3]; 

		if(var2 != null)
		{
			if(chest != null && legs != null && boots != null && helm != null)
			{
				if(chest.itemID == mod_SCP.SCP912Shirt.itemID || legs.itemID == mod_SCP.SCP912Pants.itemID || boots.itemID == mod_SCP.SCP912Shoes.itemID || helm.itemID == mod_SCP.SCP912Head.itemID)
				{
					super.onEntityWalking(par1World, par2, par3, par4, par5EntityPlayer);
					return;
				}
				
				else
				{
					((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
				}
			}
			else
			{
				((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
			}
		}
		else
		{
			((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
		}
	}
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	if(par5Entity instanceof EntityLiving)((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
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

		if(var2 != null)
		{
			if(chest != null && legs != null && boots != null && helm != null)
			{
				if(chest.itemID == mod_SCP.SCP912Shirt.itemID || legs.itemID == mod_SCP.SCP912Pants.itemID || boots.itemID == mod_SCP.SCP912Shoes.itemID || helm.itemID == mod_SCP.SCP912Head.itemID)
				{
					super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
					return;
				}
				
				else
				{
					((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
				}
			}
			else
			{
				((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
			}
		}
		else
		{
			((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
		}
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

		if(var2 != null)
		{
			if(chest != null && legs != null && boots != null && helm != null)
			{
				if(chest.itemID == mod_SCP.SCP912Shirt.itemID || legs.itemID == mod_SCP.SCP912Pants.itemID || boots.itemID == mod_SCP.SCP912Shoes.itemID || helm.itemID == mod_SCP.SCP912Head.itemID)
				{
					super.onEntityWalking(par1World, par2, par3, par4, par5EntityPlayer);
					return false;
				}
				
				else
				{
					((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
				}
			}
			else
			{
				((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
			}
		}
		else
		{
			((EntityLiving)par5EntityPlayer).addPotionEffect(new PotionEffect(SCPPotion.crystal.id, 160, 0));
		}
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

				if (par1World.getBlockId(var7, var8, var9) != 0 && par1World.getBlockId(var7, var8, var9) != mod_SCP.Granite.blockID && par1World.getBlockId(var7, var8, var9) != Block.bedrock.blockID && par1World.getBlockId(var7, var8, var9) != Block.chest.blockID)
				{
					par1World.setBlock(var7, var8, var9, mod_SCP.SCP409.blockID);
				}
			}
		}
	}
}
