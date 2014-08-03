package SCPCraft.containerslots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import SCPCraft.guis.SCPGui000J;

public class SCPCraftingInventoryRecipeBookCB extends Container
{
    private IInventory inv;

    public SCPCraftingInventoryRecipeBookCB(IInventory var1)
    {
        this.inv = var1;
        int var2 = 0;

        for (int var3 = 0; var3 < SCPGui000J.ROWS; ++var3)
        {
            for (int var4 = 0; var4 < SCPGui000J.COLUMNS; ++var4)
            {
                this.addSlotToContainer(new Slot(var1, var2++, 99 + var4 * 117, 24 + var3 * 55));

                for (int var5 = 0; var5 < 3; ++var5)
                {
                    for (int var6 = 0; var6 < 3; ++var6)
                    {
                        this.addSlotToContainer(new Slot(var1, var2++, 5 + var6 * 18 + var4 * 117, 6 + var5 * 18 + var3 * 55));
                    }
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return this.inv.isUseableByPlayer(var1);
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        return null;
    }
}
