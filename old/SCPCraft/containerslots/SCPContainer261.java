package SCPCraft.containerslots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import SCPCraft.tileentities.SCPTileEntity261;

public class SCPContainer261 extends Container
{
    private SCPTileEntity261 SCP261;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public SCPContainer261(InventoryPlayer par1InventoryPlayer, SCPTileEntity261 par2SCPTileEntity261)
    {
        lastCookTime = 0;
        lastBurnTime = 0;
        lastItemBurnTime = 0;
        SCP261 = par2SCPTileEntity261;
        addSlotToContainer(new Slot(par2SCPTileEntity261, 0, 56, 34));
        addSlotToContainer(new SCPSlot261(par1InventoryPlayer.player, par2SCPTileEntity261, 2, 116, 35));

        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
                addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; j++)
        {
            addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
        }
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

            if (lastCookTime != SCP261.SCP261CookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, SCP261.SCP261CookTime);
            }

            if (lastBurnTime != SCP261.SCP261BurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, SCP261.SCP261BurnTime);
            }

            if (lastItemBurnTime != SCP261.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, SCP261.currentItemBurnTime);
            }
        }

        lastCookTime = SCP261.SCP261CookTime;
        lastBurnTime = SCP261.SCP261BurnTime;
        lastItemBurnTime = SCP261.currentItemBurnTime;
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            SCP261.SCP261CookTime = par2;
        }

        if (par1 == 1)
        {
            SCP261.SCP261BurnTime = par2;
        }

        if (par1 == 2)
        {
            SCP261.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return SCP261.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
	 
	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slot_index)
	 {
		 ItemStack stack = null;
		 Slot slot_object = (Slot) inventorySlots.get(slot_index);

		 if(slot_object != null && slot_object.getHasStack())
		 {
			 ItemStack stack_in_slot = slot_object.getStack();
			 stack = stack_in_slot.copy();

			 if(slot_index == 0 || slot_index == 1)
			 {
				 if(!mergeItemStack(stack_in_slot, 2, inventorySlots.size(), false))
				 {
					 return null;
				 }
			 } 
			 else 
			 {
	             if (((Slot)this.inventorySlots.get(0)).getHasStack() || !((Slot)this.inventorySlots.get(0)).isItemValid(stack_in_slot))
	             {
	                 return null;
	             }
	             
	             if (stack_in_slot.stackSize >= 16)
	             {
	                 ((Slot)this.inventorySlots.get(0)).putStack(new ItemStack(stack_in_slot.itemID, 16, stack_in_slot.getItemDamage()));
	                 stack_in_slot.stackSize -= 16;
	             }
	             else
	             {
	            	 ((Slot)this.inventorySlots.get(0)).putStack(new ItemStack(stack_in_slot.itemID, stack_in_slot.stackSize, stack_in_slot.getItemDamage()));
	                 stack_in_slot.stackSize -= stack_in_slot.stackSize;
	             }
			 }

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
