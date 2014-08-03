package SCPCraft.containerslots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.recipes.SCPDocumentManager;

public class SCPContainerDocument extends Container
{
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public SCPContainerDocument(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
    {
        craftMatrix = new InventoryCrafting(this, 2, 2);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        posX = i;
        posY = j;
        posZ = k;
        addSlotToContainer(new SlotCrafting(inventoryplayer.player, craftMatrix, craftResult, 0, 99, 36));
        addSlotToContainer(new Slot(craftMatrix, 1, 63, 18));
        addSlotToContainer(new Slot(craftMatrix, 2, 63, 54));

        for (int l = 0; l < 3; l++)
        {
            for (int j1 = 0; j1 < 9; j1++)
            {
                addSlotToContainer(new Slot(inventoryplayer, j1 + l * 9 + 9, 8 + j1 * 18, 84 + l * 18));
            }
        }

        for (int i1 = 0; i1 < 9; i1++)
        {
            addSlotToContainer(new Slot(inventoryplayer, i1, 8 + i1 * 18, 142));
        }

        onCraftMatrixChanged(craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory iinventory)
    {
        craftResult.setInventorySlotContents(0, SCPDocumentManager.getInstance().func_82787_a(this.craftMatrix, this.worldObj));
    }
    
    /**
     * Callback for when the crafting gui is closed.
     */
    public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);
            for (int var2 = 0; var2 < 3; ++var2)
            {
                ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

                if (var3 != null)
                {
                    par1EntityPlayer.dropPlayerItem(var3);
                }
            }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != mod_SCP.DocumentTable.blockID ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 0 || par2 == 1 || par2 == 2)
            {
                if (!this.mergeItemStack(var5, 6, inventorySlots.size(), false))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
	        else if (par2 != 1 && par2 != 2)
	        { 
	        	if (!this.mergeItemStack(var5, 1, 2, false) && !this.mergeItemStack(var5, 2, 3, false))
	            {
	                return null;
	            }
	        }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack)null);
            }
            else
            {
                var4.onSlotChanged();
            }

            if (var5.stackSize == var3.stackSize)
            {
                return null;
            }

            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }

        return var3;
    }
}
