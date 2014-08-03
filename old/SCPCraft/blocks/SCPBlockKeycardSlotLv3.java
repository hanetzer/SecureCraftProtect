package SCPCraft.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPBlockKeycardSlotLv3 extends SCPBlockKeycardSlot
{	
	public SCPBlockKeycardSlotLv3(int i, int j)
	{
		super(i, j);
		setTickRandomly(true);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem(); 
		int i = par1World.getBlockMetadata(par2, par3, par4);
		int j = i & 7;
		if (par1World.isRemote)
		{
			return true;
		}else{
			if(itemstack != null && (itemstack.itemID == mod_SCP.L3Keycard.itemID || itemstack.itemID == mod_SCP.OmniKeycard.itemID)) 
			{
				int k = 8 - (i & 8);
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, j + k, 0x02); //
	            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, 0.6F);
	            this.func_82536_d(par1World, par2, par3, par4, j);
	            par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());

			}else
			{
				if(itemstack != null && (itemstack.itemID == mod_SCP.Wrench.itemID || itemstack.itemID == mod_SCP.GodlyWrench.itemID)) {
					par1World.setBlockMetadataWithNotify(par2, par3, par4, mod_SCP.KeycardSlotOmni.blockID, j);
					itemstack.damageItem(1, par5EntityPlayer);
					if(par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("Keycard Level: Omni");
					}
					if(!par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("Keycard Level: Omni");
					}
				}
				else 
				{
					if(par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("You need a Level 3 or higher Keycard to activate.");
					}
					
					if(!par1World.isRemote)
					{
						par5EntityPlayer.addChatMessage("You need a Level 3 or higher Keycard to activate.");
					}
				}
			}		
			par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, tickRate());
		}
		return true;
	}

}
