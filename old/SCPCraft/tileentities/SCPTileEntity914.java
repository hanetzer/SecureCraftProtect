package SCPCraft.tileentities;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import paulscode.sound.SoundSystem;
import SCPCraft.recipes.SCP9141_1Recipes;
import SCPCraft.recipes.SCP914CoarseRecipes;
import SCPCraft.recipes.SCP914FineRecipes;
import SCPCraft.recipes.SCP914RoughRecipes;
import SCPCraft.recipes.SCP914VeryFineRecipes;

public class SCPTileEntity914 extends TileEntity implements IInventory
{
    private ItemStack SCP914ItemStacks[] = new ItemStack[7];
    public int SCP914BurnTime = 0;
    public int currentItemBurnTime = 0;
    public int SCP914CookTime = 0;
    public static SoundSystem sndSystem;
    
    public int getSizeInventory()
    {
        return this.SCP914ItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return SCP914ItemStacks[par1];
    }
    
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.SCP914ItemStacks[var1] != null)
        {
            ItemStack var3;

            if (this.SCP914ItemStacks[var1].stackSize <= var2)
            {
                var3 = this.SCP914ItemStacks[var1];
                this.SCP914ItemStacks[var1] = null;
                this.onInventoryChanged();
                return var3;
            }
            else
            {
                var3 = this.SCP914ItemStacks[var1].splitStack(var2);

                if (this.SCP914ItemStacks[var1].stackSize == 0)
                {
                    this.SCP914ItemStacks[var1] = null;
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
        if (this.SCP914ItemStacks[var1] != null)
        {
            ItemStack var2 = this.SCP914ItemStacks[var1];
            this.SCP914ItemStacks[var1] = null;
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
        this.SCP914ItemStacks[var1] = var2;

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
        return "container.SCP914";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        SCP914ItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");

            if (byte0 >= 0 && byte0 < SCP914ItemStacks.length)
            {
                SCP914ItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        SCP914CookTime = par1NBTTagCompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(SCP914ItemStacks[6]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)SCP914BurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)SCP914CookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < SCP914ItemStacks.length; i++)
        {
            if (SCP914ItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                SCP914ItemStacks[i].writeToNBT(nbttagcompound);
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
        return 32;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return (SCP914CookTime * par1) / 250;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (currentItemBurnTime == 0)
        {
            currentItemBurnTime = 250;
        }

        return (SCP914BurnTime * par1) / currentItemBurnTime;
    }

    /**
     * Returns true if the SCP914 is currently burning
     */
    public boolean isBurning()
    {
        return SCP914BurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var1 = this.SCP914BurnTime > 0;
        boolean var2 = false;

        if (this.SCP914BurnTime > 0)
        {
            --this.SCP914BurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.SCP914BurnTime == 0 && (this.canSmeltRough() || this.canSmeltCoarse() || this.canSmelt1_1() || this.canSmeltFine() || this.canSmeltVeryFine()))
            {
                this.currentItemBurnTime = this.SCP914BurnTime = getItemBurnTime(this.SCP914ItemStacks[6]);

                if (this.SCP914BurnTime > 0)
                {
                    var2 = true;

                    if (this.SCP914ItemStacks[6] != null)
                    {
                        --this.SCP914ItemStacks[6].stackSize;

                        if (this.SCP914ItemStacks[6].stackSize == 0)
                        {
                            Item var3 = this.SCP914ItemStacks[6].getItem().getContainerItem();
                            this.SCP914ItemStacks[6] = var3 == null ? null : new ItemStack(var3);
                        }
                    }
                }
            }

            if (this.isBurning() && (this.canSmeltRough() || this.canSmeltCoarse() || this.canSmelt1_1() || this.canSmeltFine() || this.canSmeltVeryFine()))
            {
                if(SCP914CookTime == 0)
                worldObj.playSoundEffect((double)((float)this.xCoord + 0.5F), (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F), "sounds.914use", 0.5F, 1F);            	
                ++this.SCP914CookTime;
                if (this.SCP914CookTime == 250)
                {
                    this.SCP914CookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.SCP914CookTime = 0;
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    /**
     * Returns true if the SCP914 can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmeltRough()
    {
        if (this.SCP914ItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = SCP914RoughRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[0].getItem().itemID);
            return var1 == null ? false : (this.SCP914ItemStacks[5] == null ? true : (!this.SCP914ItemStacks[5].isItemEqual(var1) ? false : (this.SCP914ItemStacks[5].stackSize < this.getInventoryStackLimit() && this.SCP914ItemStacks[5].stackSize < this.SCP914ItemStacks[5].getMaxStackSize() ? true : this.SCP914ItemStacks[5].stackSize < var1.getMaxStackSize())));
        }
    }
    
    private boolean canSmeltCoarse()
    {
        if (this.SCP914ItemStacks[1] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = SCP914CoarseRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[1].getItem().itemID);
            return var1 == null ? false : (this.SCP914ItemStacks[5] == null ? true : (!this.SCP914ItemStacks[5].isItemEqual(var1) ? false : (this.SCP914ItemStacks[5].stackSize < this.getInventoryStackLimit() && this.SCP914ItemStacks[5].stackSize < this.SCP914ItemStacks[5].getMaxStackSize() ? true : this.SCP914ItemStacks[5].stackSize < var1.getMaxStackSize())));
        }
    }
    
    private boolean canSmelt1_1()
    {
        if (this.SCP914ItemStacks[2] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = SCP9141_1Recipes.smelting().getSmeltingResult(this.SCP914ItemStacks[2].getItem().itemID);
            return var1 == null ? false : (this.SCP914ItemStacks[5] == null ? true : (!this.SCP914ItemStacks[5].isItemEqual(var1) ? false : (this.SCP914ItemStacks[5].stackSize < this.getInventoryStackLimit() && this.SCP914ItemStacks[5].stackSize < this.SCP914ItemStacks[5].getMaxStackSize() ? true : this.SCP914ItemStacks[5].stackSize < var1.getMaxStackSize())));
        }
    }
    
    private boolean canSmeltFine()
    {
        if (this.SCP914ItemStacks[3] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = SCP914FineRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[3].getItem().itemID);
            return var1 == null ? false : (this.SCP914ItemStacks[5] == null ? true : (!this.SCP914ItemStacks[5].isItemEqual(var1) ? false : (this.SCP914ItemStacks[5].stackSize < this.getInventoryStackLimit() && this.SCP914ItemStacks[5].stackSize < this.SCP914ItemStacks[5].getMaxStackSize() ? true : this.SCP914ItemStacks[5].stackSize < var1.getMaxStackSize())));
        }
    }
    
    private boolean canSmeltVeryFine()
    {
        if (this.SCP914ItemStacks[4] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = SCP914VeryFineRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[4].getItem().itemID);
            return var1 == null ? false : (this.SCP914ItemStacks[5] == null ? true : (!this.SCP914ItemStacks[5].isItemEqual(var1) ? false : (this.SCP914ItemStacks[5].stackSize < this.getInventoryStackLimit() && this.SCP914ItemStacks[5].stackSize < this.SCP914ItemStacks[5].getMaxStackSize() ? true : this.SCP914ItemStacks[5].stackSize < var1.getMaxStackSize())));
        }
    }

    /**
     * Turn one item from the SCP914 source stack into the appropriate smelted item in the SCP914 result stack
     */
    public Random rand = new Random();
    public void smeltItem()
    {
        if (this.canSmeltRough())
        {
            ItemStack var1 = SCP914RoughRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[0].getItem().itemID);

            if (this.SCP914ItemStacks[5] == null)
            {
                this.SCP914ItemStacks[5] = var1.copy();
                this.SCP914ItemStacks[5].stackSize = this.SCP914ItemStacks[0].stackSize*var1.stackSize; 
            }
            else if (this.SCP914ItemStacks[5].itemID == var1.itemID)
            {
               this.SCP914ItemStacks[5].stackSize += this.SCP914ItemStacks[0].stackSize*var1.stackSize;
            }
            this.SCP914ItemStacks[0].stackSize = 0;

            if (this.SCP914ItemStacks[0].stackSize <= 0)
            {
                this.SCP914ItemStacks[0] = null;
            }
        }
        if (this.canSmeltCoarse())
        {
            ItemStack var1 = SCP914CoarseRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[1].getItem().itemID);

            if (this.SCP914ItemStacks[5] == null)
            {
                this.SCP914ItemStacks[5] = var1.copy();
                this.SCP914ItemStacks[5].stackSize = this.SCP914ItemStacks[1].stackSize*var1.stackSize; 
            }
            else if (this.SCP914ItemStacks[5].itemID == var1.itemID)
            {
                this.SCP914ItemStacks[5].stackSize+=(this.SCP914ItemStacks[1].stackSize*var1.stackSize);
            }

            this.SCP914ItemStacks[1].stackSize = 0;

            if (this.SCP914ItemStacks[1].stackSize <= 0)
            {
                this.SCP914ItemStacks[1] = null;
            }
        }
        if (this.canSmelt1_1())
        {
            ItemStack var1 = SCP9141_1Recipes.smelting().getSmeltingResult(this.SCP914ItemStacks[2].getItem().itemID);
            if(SCP914ItemStacks[2].getItem() == Item.potion)var1 = new ItemStack(Item.potion, 1, rand.nextInt(16472));
            if(SCP914ItemStacks[2].getItem() == Item.dyePowder)var1 = new ItemStack(Item.dyePowder, 1, rand.nextInt(16));
            int maxMobs = 50 + rand.nextInt(49);
            if(SCP914ItemStacks[2].getItem() == Item.monsterPlacer)
               	if(EntityList.entityEggs.containsKey(maxMobs))var1 = new ItemStack(Item.monsterPlacer, 1, maxMobs);
               		else var1 = new ItemStack(Item.monsterPlacer, 1, 120);
            if (this.SCP914ItemStacks[5] == null)
            {
                this.SCP914ItemStacks[5] = var1.copy();
                this.SCP914ItemStacks[5].stackSize = this.SCP914ItemStacks[2].stackSize*var1.stackSize; 
            }
            else if (this.SCP914ItemStacks[5].itemID == var1.itemID)
            {
                this.SCP914ItemStacks[5].stackSize+=(this.SCP914ItemStacks[2].stackSize*var1.stackSize);
            }

            this.SCP914ItemStacks[2].stackSize = 0;

            if (this.SCP914ItemStacks[2].stackSize <= 0)
            {
                this.SCP914ItemStacks[2] = null;
            }
        }
        if (this.canSmeltFine())
        {
            ItemStack var1 = SCP914FineRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[3].getItem().itemID);
            if(SCP914ItemStacks[3].getItem() == Item.egg)
            {
                int maxMobs1 = 50 + rand.nextInt(49);
               	if(EntityList.entityEggs.containsKey(maxMobs1))var1 = new ItemStack(Item.monsterPlacer, 1, maxMobs1);
               		else var1 = new ItemStack(Item.monsterPlacer, 1, 120);
            }
            if (this.SCP914ItemStacks[5] == null)
            {
                this.SCP914ItemStacks[5] = var1.copy();
                this.SCP914ItemStacks[5].stackSize = this.SCP914ItemStacks[3].stackSize*var1.stackSize; 
            }
            else if (this.SCP914ItemStacks[5].itemID == var1.itemID)
            {
                this.SCP914ItemStacks[5].stackSize+=(this.SCP914ItemStacks[3].stackSize*var1.stackSize);
            }

            this.SCP914ItemStacks[3].stackSize = 0;

            if (this.SCP914ItemStacks[3].stackSize <= 0)
            {
                this.SCP914ItemStacks[3] = null;
            }
        }
        if (this.canSmeltVeryFine())
        {
            ItemStack var1 = SCP914VeryFineRecipes.smelting().getSmeltingResult(this.SCP914ItemStacks[4].getItem().itemID);

            if (this.SCP914ItemStacks[5] == null)
            {
                this.SCP914ItemStacks[5] = var1.copy();
                this.SCP914ItemStacks[5].stackSize = this.SCP914ItemStacks[4].stackSize*var1.stackSize; 
            }
            else if (this.SCP914ItemStacks[5].itemID == var1.itemID)
            {
                this.SCP914ItemStacks[5].stackSize+=(this.SCP914ItemStacks[4].stackSize*var1.stackSize);
            }

            this.SCP914ItemStacks[4].stackSize = 0;

            if (this.SCP914ItemStacks[4].stackSize <= 0)
            {
                this.SCP914ItemStacks[4] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the SCP914 burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack par1ItemStack)
    {
        if (par1ItemStack == null)
        {
            return 1;
        }

        int i = par1ItemStack.getItem().itemID;
        
        {
            return ModLoader.addAllFuel(par1ItemStack.itemID, par1ItemStack.getItemDamage());
        }
    }

    public static boolean isItemFuel(ItemStack par0ItemStack)
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
