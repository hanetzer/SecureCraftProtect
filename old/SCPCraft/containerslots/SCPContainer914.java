package SCPCraft.containerslots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import SCPCraft.tileentities.SCPTileEntity914;

public class SCPContainer914 extends Container
{
	private SCPTileEntity914 SCP914;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

	public SCPContainer914(InventoryPlayer par1InventoryPlayer, SCPTileEntity914 par2SCPTileEntity914)
	{
		lastCookTime = 0;
		lastBurnTime = 0;
		lastItemBurnTime = 0;
		SCP914 = par2SCPTileEntity914;
		addSlotToContainer(new Slot(par2SCPTileEntity914, 0, 8, 22));
		addSlotToContainer(new Slot(par2SCPTileEntity914, 1, 44, 22));
		addSlotToContainer(new Slot(par2SCPTileEntity914, 2, 80, 22));
		addSlotToContainer(new Slot(par2SCPTileEntity914, 3, 117, 22));
		addSlotToContainer(new Slot(par2SCPTileEntity914, 4, 153, 22));
		addSlotToContainer(new SCPSlot914(par1InventoryPlayer.player, par2SCPTileEntity914, 5, 80, 59));
		int var3;

		for (var3 = 0; var3 < 3; ++var3)
		{
			for (int var4 = 0; var4 < 9; ++var4)
			{
				this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3)
		{
			this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.SCP914.SCP914CookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.SCP914.SCP914CookTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.SCP914.SCP914CookTime);
		par1ICrafting.sendProgressBarUpdate(this, 3, this.SCP914.SCP914CookTime);
		par1ICrafting.sendProgressBarUpdate(this, 4, this.SCP914.SCP914CookTime);
		par1ICrafting.sendProgressBarUpdate(this, 5, this.SCP914.currentItemBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, 6, this.SCP914.SCP914BurnTime);
	}

	/**
	 * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
	 */
	 public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting)crafters.get(i);

			if (lastCookTime != SCP914.SCP914CookTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, SCP914.SCP914CookTime);
				icrafting.sendProgressBarUpdate(this, 1, SCP914.SCP914CookTime);
				icrafting.sendProgressBarUpdate(this, 2, SCP914.SCP914CookTime);
				icrafting.sendProgressBarUpdate(this, 3, SCP914.SCP914CookTime);
				icrafting.sendProgressBarUpdate(this, 4, SCP914.SCP914CookTime);
			}

			if (lastBurnTime != SCP914.SCP914BurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 6, SCP914.SCP914BurnTime);
			}

			if (lastItemBurnTime != SCP914.currentItemBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 5, SCP914.currentItemBurnTime);
			}
		}

		lastCookTime = SCP914.SCP914CookTime;
		lastBurnTime = SCP914.SCP914BurnTime;
		lastItemBurnTime = SCP914.currentItemBurnTime;
	}

	 public void updateProgressBar(int par1, int par2)
	 {
		 if (par1 == 0 || par1 == 1 || par1 == 2 || par1 == 3 || par1 == 4)
		 {
			 SCP914.SCP914CookTime = par2;
		 }

		 if (par1 == 6)
		 {
			 SCP914.SCP914BurnTime = par2;
		 }

		 if (par1 == 5)
		 {
			 SCP914.currentItemBurnTime = par2;
		 }
	 }

	 public boolean canInteractWith(EntityPlayer var1)
	 {
		 return this.SCP914.isUseableByPlayer(var1);
	 }

	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slot_index)
	 {
		 ItemStack stack = null;
		 Slot slot_object = (Slot) inventorySlots.get(slot_index);

		 if(slot_object != null && slot_object.getHasStack())
		 {
			 ItemStack stack_in_slot = slot_object.getStack();
			 stack = stack_in_slot.copy();

			 if(slot_index == 0 || slot_index == 1 || slot_index == 2 || slot_index == 3 || slot_index == 4 || slot_index == 5)
			 {
				 if(!mergeItemStack(stack_in_slot, 6, inventorySlots.size(), false))
				 {
					 return null;
				 }
			 } 
			 else return null;

			 if(stack_in_slot.stackSize == 0)
			 {
				 slot_object.putStack(null);
			 } 
			 else
			 {
				 slot_object.onSlotChanged();
			 }
		 }
		 return stack;
	 }

}
