package SCPCraft.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCPItemRecord extends ItemRecord
{
	/** The name of the record. */
	public final String recordName;
	public final String author;
	private static final Map field_90044_b = new HashMap();

	public SCPItemRecord(int par1, String par2Str, String aut)
	{
		super(par1, par2Str);
		this.recordName = par2Str;
		this.maxStackSize = 1;
		this.author = aut;
		this.setCreativeTab(mod_SCP.tabItemSCP);
		field_90044_b.put(par2Str, this);
	}

	public void updateIcons(IconRegister par1)
	{
		if(recordName.equals("106")) iconIndex = par1.registerIcon(mod_SCP.modid + ":Rotten Disk");
		else if(recordName.equals("173") || recordName.equals("173E")) iconIndex = par1.registerIcon(mod_SCP.modid + ":SCP-173 Disk");
		else if(recordName.equals("789J")) iconIndex = par1.registerIcon(mod_SCP.modid + ":SCP-789-J Disk");
		else if(recordName.equals("914")) iconIndex = par1.registerIcon(mod_SCP.modid + ":SCP-914 Disk");
		else if(recordName.equals("079")) iconIndex = par1.registerIcon(mod_SCP.modid + ":SCP-079 Disk");
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par3World.getBlockId(par4, par5, par6) == Block.jukebox.blockID && par3World.getBlockMetadata(par4, par5, par6) == 0)
		{
			if (par3World.isRemote)
			{
				return true;
			}
			else
			{
				((BlockJukeBox)Block.jukebox).insertRecord(par3World, par4, par5, par6, par1ItemStack);
				par3World.playAuxSFXAtEntity((EntityPlayer)null, 1005, par4, par5, par6, this.itemID);
				--par1ItemStack.stackSize;
				return true;
			}
		}
		else
		{
			return false;
		}
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(this.author + " - " + this.recordName);
	}

	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return EnumRarity.rare;
	}

	@SideOnly(Side.CLIENT)
	public static SCPItemRecord func_90042_d(String par0Str)
	{
		return (SCPItemRecord)field_90044_b.get(par0Str);
	}
}