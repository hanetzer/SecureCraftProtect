package SCPCraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import SCPCraft.recipes.SCP294Recipes;

public class SCPTileEntity294 extends TileEntity implements IInventory
{
    private ItemStack SCP294ItemStacks[] = new ItemStack[3];
    public int SCP294BurnTime = 0;
    public int currentItemBurnTime = 0;
    public int SCP294CookTime = 0;
    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.SCP294ItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int var1)
    {
        return this.SCP294ItemStacks[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.SCP294ItemStacks[var1] != null)
        {
            ItemStack var3;

            if (this.SCP294ItemStacks[var1].stackSize <= var2)
            {
                var3 = this.SCP294ItemStacks[var1];
                this.SCP294ItemStacks[var1] = null;
                this.onInventoryChanged();
                return var3;
            }
            else
            {
                var3 = this.SCP294ItemStacks[var1].splitStack(var2);

                if (this.SCP294ItemStacks[var1].stackSize == 0)
                {
                    this.SCP294ItemStacks[var1] = null;
                }

                this.onInventoryChanged();
                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int var1)
    {
        if (this.SCP294ItemStacks[var1] != null)
        {
            ItemStack var2 = this.SCP294ItemStacks[var1];
            this.SCP294ItemStacks[var1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        this.SCP294ItemStacks[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
        {
            var2.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.SCP294";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        SCP294ItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");

            if (byte0 >= 0 && byte0 < SCP294ItemStacks.length)
            {
                SCP294ItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        SCP294BurnTime = par1NBTTagCompound.getShort("BurnTime");
        SCP294CookTime = par1NBTTagCompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(SCP294ItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)SCP294BurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)SCP294CookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < SCP294ItemStacks.length; i++)
        {
            if (SCP294ItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                SCP294ItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 8;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return (SCP294CookTime * par1) / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (currentItemBurnTime == 0)
        {
            currentItemBurnTime = 200;
        }

        return (SCP294BurnTime * par1) / currentItemBurnTime;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return SCP294BurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean flag = SCP294BurnTime > 0;
        boolean flag1 = false;

        if (SCP294BurnTime > 0)
        {
            SCP294BurnTime--;
        }

        if (!worldObj.isRemote)
        {
            if (SCP294BurnTime == 0 && canSmelt())
            {
                currentItemBurnTime = SCP294BurnTime = getItemBurnTime(SCP294ItemStacks[1]);

                if (SCP294BurnTime > 0)
                {
                    flag1 = true;

                    if (SCP294ItemStacks[1] != null)
                    {
                        if (SCP294ItemStacks[1].getItem().hasContainerItem())
                        {
                            SCP294ItemStacks[1] = new ItemStack(SCP294ItemStacks[1].getItem().setFull3D());
                        }
                        else
                        {
                            SCP294ItemStacks[1].stackSize--;
                        }

                        if (SCP294ItemStacks[1].stackSize == 0)
                        {
                            SCP294ItemStacks[1] = null;
                        }
                    }
                }
            }

            if (isBurning() && canSmelt())
            {
            	if(SCP294CookTime == 0)
                worldObj.playSoundEffect((double)((float)this.xCoord + 0.5F), (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F), "sounds.294use", 0.5F, 1F);
            
                SCP294CookTime++;

                if (SCP294CookTime == 200)
                {
                    SCP294CookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                SCP294CookTime = 0;
            }

            if (flag != (SCP294BurnTime > 0))
            {
                flag1 = true;
                
            }
        }

        if (flag1)
        {
            onInventoryChanged();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (SCP294ItemStacks[0] == null)
        {
            return false;
        }

        ItemStack itemstack = SCP294Recipes.smelting().getSmeltingResult(SCP294ItemStacks[0].getItem().itemID);

        if (itemstack == null)
        {
            return false;
        }

        if (SCP294ItemStacks[2] == null)
        {
            return true;
        }

        if (!SCP294ItemStacks[2].isItemEqual(itemstack))
        {
            return false;
        }

        if (SCP294ItemStacks[2].stackSize < getInventoryStackLimit() && SCP294ItemStacks[2].stackSize < SCP294ItemStacks[2].getMaxStackSize())
        {
            return true;
        }

        return SCP294ItemStacks[2].stackSize < itemstack.getMaxStackSize();
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (!canSmelt())
        {
            return;
        }

        ItemStack itemstack = SCP294Recipes.smelting().getSmeltingResult(SCP294ItemStacks[0].getItem().itemID);

        if (SCP294ItemStacks[2] == null)
        {
            SCP294ItemStacks[2] = itemstack.copy();
        }
        else if (SCP294ItemStacks[2].itemID == itemstack.itemID)
        {
            SCP294ItemStacks[2].stackSize += itemstack.stackSize;
        }

        if (SCP294ItemStacks[0].getItem().hasContainerItem())
        {
            SCP294ItemStacks[0] = new ItemStack(SCP294ItemStacks[0].getItem().setFull3D());
        }
        else
        {
            SCP294ItemStacks[0].stackSize--;
        }

        if (SCP294ItemStacks[0].stackSize <= 0)
        {
            SCP294ItemStacks[0] = null;
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack par1ItemStack)
    {
        if (par1ItemStack == null)
        {
            return 1;
        }
        return 0;
    }

    public static boolean func_52005_b(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
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
