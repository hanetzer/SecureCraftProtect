package SCPCraft.containerslots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.entities.SCPEntityButler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCPContainerButler extends Container
{
    /** Instance of Merchant. */
    private SCPEntityButler theMerchant;
    private InventoryMerchant merchantInventory;

    /** Instance of World. */
    private final World theWorld;

    public SCPContainerButler(InventoryPlayer par1InventoryPlayer, SCPEntityButler par2iMerchant, World par3World)
    {
        this.theMerchant = par2iMerchant;
        this.theWorld = par3World;
  //      this.addSlotToContainer(new Slot(this.merchantInventory, 0, 36, 53));
  //      this.addSlotToContainer(new Slot(this.merchantInventory, 1, 62, 53));
  //      int var4;

   //     for (var4 = 0; var4 < 3; ++var4)
  //      {
  //          for (int var5 = 0; var5 < 9; ++var5)
   //         {
  //              this.addSlotToContainer(new Slot(par1InventoryPlayer, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
  //          }
  //      }

   //     for (var4 = 0; var4 < 9; ++var4)
   //     {
   //         this.addSlotToContainer(new Slot(par1InventoryPlayer, var4, 8 + var4 * 18, 142));
   //     }
    }

    public InventoryMerchant getMerchantInventory()
    {
        return this.merchantInventory;
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.merchantInventory.resetRecipeAndSlots();
        super.onCraftMatrixChanged(par1IInventory);
    }

    public void setCurrentRecipeIndex(int par1)
    {
        this.merchantInventory.setCurrentRecipeIndex(par1);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2) {}

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return par1EntityPlayer != null;
    }

    public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(var5, 3, 39, true))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            else if (par2 != 0 && par2 != 1)
            {
                if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(var5, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 3, 39, false))
            {
                return null;
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
