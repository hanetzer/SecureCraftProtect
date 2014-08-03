package SCPCraft.containerslots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

public class SCPSlot294 extends Slot
{
    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;
    private int field_48437_f;

    public SCPSlot294(EntityPlayer par1EntityPlayer, IInventory par2IInventory, int par3, int par4, int par5)
    {
        super(par2IInventory, par3, par4, par5);
        thePlayer = par1EntityPlayer;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1)
    {
        if (getHasStack())
        {
            field_48437_f += Math.min(par1, getStack().stackSize);
        }

        return super.decrStackSize(par1);
    }

    /**
     * Called when the player picks up an item from an inventory slot
     */
    public void onCrafting(ItemStack par1ItemStack)
    {
        func_48434_c(par1ItemStack);
        super.onCrafting(par1ItemStack);
    }

    protected void func_48435_a(ItemStack par1ItemStack, int par2)
    {
        field_48437_f += par2;
        func_48434_c(par1ItemStack);
    }

    protected void func_48434_c(ItemStack par1ItemStack)
    {
        par1ItemStack.onCrafting(thePlayer.worldObj, thePlayer, field_48437_f);
        field_48437_f = 0;
        ModLoader.takenFromFurnace(thePlayer, par1ItemStack);
    }
}
