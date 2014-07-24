package securecraftprotect.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import securecraftprotect.common.item.crafting.DocumentManager;
import securecraftprotect.init.SCPTiles;

public class ContainerDocument extends Container {
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerDocument(InventoryPlayer inventory,
                             World world, int x, int y, int z) {
        craftMatrix = new InventoryCrafting(this, 2, 2);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        posX = x;
        posY = y;
        posZ = z;
        addSlotToContainer(new SlotCrafting(inventory.player, craftMatrix, craftResult, 0, 99, 36));
        addSlotToContainer(new Slot(craftMatrix, 1, 63, 18));
        addSlotToContainer(new Slot(craftMatrix, 2, 63, 54));

        for (int l = 0; l < 3; l++) {
            for (int j1 = 0; j1 < 9; j1++) {
                addSlotToContainer(new Slot(inventory, j1 + l * 9 + 9, 8 + j1 * 18, 84 + l * 18));
            }
        }

        for (int i1 = 0; i1 < 9; i1++) {
            addSlotToContainer(new Slot(inventory, i1, 8 + i1 * 18, 142));
        }

        onCraftMatrixChanged(craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory iinventory) {
        craftResult.setInventorySlotContents(0, DocumentManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }

    /**
     * Callback for when the crafting gui is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        if(!worldObj.isRemote) {
            for (int i = 0; i < 3; ++i) {
                ItemStack stack = craftMatrix.getStackInSlotOnClosing(i);

                if (stack != null) {
                    player.dropPlayerItemWithRandomChoice(stack, false);
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        if (worldObj.getBlock(posX, posY, posZ) != SCPTiles.document_crafter) {
            return false;
        }
        else {
            return player.getDistanceSq(
                    (double) posX + 0.5D,
                    (double) posY + 0.5D,
                    (double) posZ + 0.5D) <= 64.0D;
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stack1 = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack2 = slot.getStack();
            stack1 = stack2.copy();

            if (index == 0 || index == 1 || index == 2) {
                if (!this.mergeItemStack(stack2, 6, inventorySlots.size(), false)) {
                    return null;
                }

                slot.onSlotChange(stack2, stack1);
            } else if (index != 1 && index != 2) {
                if (!this.mergeItemStack(stack2, 1, 2, false) && !this.mergeItemStack(stack2, 2, 3, false)) {
                    return null;
                }
            }

            if (stack2.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (stack2.stackSize == stack1.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, stack2);
        }
        return stack1;
    }
}
