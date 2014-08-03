package SCPCraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntityClassD027;
import SCPCraft.entities.SCPEntityRat;

public class SCPItem027 extends SCPItemDocument
{
	public SCPItem027(int i)
	{
		super(i, 1);
		maxStackSize = 1;
		setMaxDamage(1);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("\u00a7eSCP-027");
		list.add("\u00a77The Vermin God");
	}

	public boolean isFull3D()
	{
		return true;
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
			
			for(int length = -1; length <= 5; length++)
			{
				for(int width = -1; width <= 5; width++)
				{
					for(int heigth = -1; heigth <= 5; heigth++)
					{
						par3World.setBlock(par4 + width, par5 + heigth, par6 + length, Block.stone.blockID);
					}
				}
			}
			
			for(int length = 0; length <= 4; length++)
			{
				for(int width = 0; width <= 4; width++)
				{
					for(int heigth = 0; heigth <= 4; heigth++)
					{
						par3World.setBlock(par4 + width, par5 + heigth, par6 + length, 0);
					}
				}
			}
			
			for(int floorWidth = 0; floorWidth <= 4; floorWidth++)
			{
				for(int floorLength = 0; floorLength <= 5; floorLength++)
				{
					par3World.setBlock(par4 + floorWidth, par5 - 1, par6 + floorLength, mod_SCP.GrateBlock.blockID);
				}
			}
			for(int width = 0; width <= 4; width++)
			{
				for(int length = 0; length <= 4; length++)
				{
					for(int heigth = 1; heigth <= 2; heigth++)
					{
						par3World.setBlock(par4 + width, par5 - heigth - 1, par6 + length, 0);
					}
				}
			}
			
			ItemDoor.placeDoorBlock(par3World, par4 + 2, par5, par6 - 1, 1, Block.doorSteel);
			par3World.setBlockMetadataWithNotify(par4 + 1, par5 + 1, par6 - 2, mod_SCP.KeycardSlotLv2.blockID, 2);
			par3World.setBlockMetadataWithNotify(par4 + 3, par5 + 1, par6, mod_SCP.KeycardSlotLv2.blockID, 0);
			
			par3World.setBlockMetadataWithNotify(par4 + 5, par5, par6 + 2, Block.stoneSingleSlab.blockID, 8);
			par3World.setBlockMetadataWithNotify(par4 + 5, par5, par6 + 3, Block.stoneSingleSlab.blockID, 8);
			par3World.setBlockMetadataWithNotify(par4 + 5, par5, par6 + 1, Block.stoneSingleSlab.blockID, 8);
			par3World.setBlockMetadataWithNotify(par4 - 1, par5, par6 + 2, Block.stoneSingleSlab.blockID, 8);
			par3World.setBlockMetadataWithNotify(par4 - 1, par5, par6 + 3, Block.stoneSingleSlab.blockID, 8);
			par3World.setBlockMetadataWithNotify(par4 - 1, par5, par6 + 1, Block.stoneSingleSlab.blockID, 8);
			
			par2EntityPlayer.addChatMessage("SCP-027 Spawned." +    
					  
					" | [Type: \u00a7eEuclid\u00a7f]");

			
			//(par4 + 2, par5, par6 + 3);

		return true;
		}
	}
	
	public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
	{
		SCPEntityRat var8 = new SCPEntityRat(par0World);
		var8.setLocationAndAngles(par2 + 2, par4 - 2, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var8);
		((EntityLiving)var8).playLivingSound();
		
		SCPEntityRat var9 = new SCPEntityRat(par0World);
		var9.setLocationAndAngles(par2 + 3, par4 - 2, par6 + 2, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var9);
		((EntityLiving)var9).playLivingSound();
		
		SCPEntityRat var10 = new SCPEntityRat(par0World);
		var10.setLocationAndAngles(par2 + 1, par4 - 2, par6 + 1, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var10);
		((EntityLiving)var10).playLivingSound();
		
		SCPEntityRat var11 = new SCPEntityRat(par0World);
		var11.setLocationAndAngles(par2 + 1, par4 - 2, par6 + 1, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(var11);
		((EntityLiving)var11).playLivingSound();
		
		SCPEntityClassD027 classd = new SCPEntityClassD027(par0World);
		classd.setLocationAndAngles(par2 + 2, par4, par6 + 2, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(classd);
		((EntityLiving)classd).playLivingSound();
		
		SCPEntityRat top1 = new SCPEntityRat(par0World);
		top1.setLocationAndAngles(par2 + 2, par4, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(top1);
		((EntityLiving)top1).playLivingSound();
		
		SCPEntityRat top2 = new SCPEntityRat(par0World);
		top2.setLocationAndAngles(par2 + 3, par4, par6 + 2, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(top2);
		((EntityLiving)top2).playLivingSound();
		
		SCPEntityRat top3 = new SCPEntityRat(par0World);
		top3.setLocationAndAngles(par2 + 1, par4, par6 + 1, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(top3);
		((EntityLiving)top3).playLivingSound();
		
		SCPEntityRat top4 = new SCPEntityRat(par0World);
		top4.setLocationAndAngles(par2 + 1, par4, par6 + 1, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(top4);
		((EntityLiving)top4).playLivingSound();
		
		SCPEntityRat bottom1 = new SCPEntityRat(par0World);
		bottom1.setLocationAndAngles(par2 + 2, par4 - 2, par6 + 3, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(bottom1);
		((EntityLiving)bottom1).playLivingSound();
		
		SCPEntityRat bottom2 = new SCPEntityRat(par0World);
		bottom2.setLocationAndAngles(par2 + 3, par4 - 2, par6 + 2, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(bottom2);
		((EntityLiving)bottom2).playLivingSound();
		
		SCPEntityRat bottom3 = new SCPEntityRat(par0World);
		bottom3.setLocationAndAngles(par2 + 1, par4 - 2, par6 + 1, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(bottom3);
		((EntityLiving)bottom3).playLivingSound();
		
		SCPEntityRat bottom4 = new SCPEntityRat(par0World);
		bottom4.setLocationAndAngles(par2 + 1, par4 - 2, par6 + 1, par0World.rand.nextFloat() * 360.0F, 0.0F);
		par0World.spawnEntityInWorld(bottom4);
		((EntityLiving)bottom4).playLivingSound();

		return var8 != null;
	}
}



