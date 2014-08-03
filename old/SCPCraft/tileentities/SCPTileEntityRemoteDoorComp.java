package SCPCraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class SCPTileEntityRemoteDoorComp extends TileEntity implements IInventory
{
	public int getSizeInventory()
	{
		return 0;
	}

	public ItemStack getStackInSlot(int var1)
	{
		return null;
	}

	public ItemStack decrStackSize(int var1, int var2)
	{
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int var1) 
	{
		return null;
	}

	public void setInventorySlotContents(int var1, ItemStack var2)
	{

	}

	public String getInvName()
	{
		return null;
	}

	public int getInventoryStackLimit()
	{
		return 0;
	}

	public boolean isUseableByPlayer(EntityPlayer var1)
	{
		return false;
	}

	public void openChest()
	{

	}

	public void closeChest() 
	{

	}
	
	public boolean isInvNameLocalized()
	{
		return true;
	}

	public boolean isStackValidForSlot(int i, ItemStack itemstack) 
	{
		return false;
	}
}
