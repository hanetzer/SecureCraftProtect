package SCPCraft;

import java.util.Collections;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.src.ModLoader;
import SCPCraft.guis.SCPGui000J;
import SCPCraft.recipes.SCPRecipes000J;

public class SCPInventory000J implements IInventory
{
    private static List<?> recipes = null;
    private final ItemStack book;
    private int index = -1;
    public int totalPages;
    public ItemStack[][] items;

    public SCPInventory000J(ItemStack var1)
    {
        this.items = new ItemStack[SCPGui000J.ENTRIES][];
        recipes = Collections.unmodifiableList(SCPRecipes000J.getInstance().getRecipeList());
        this.book = var1;
        int var2 = 0;

        if (this.book != null)
        {
            var2 = this.book.getItemDamage();
        }

        this.update();
        this.index = this.setIndex(var2);
    }

    private void update()
    {
        try
        {
        	this.index = this.setIndex(0);
            this.totalPages = (SCPInventory000J.recipes.size() - 1) / SCPGui000J.ENTRIES + 1;
        }
        catch (Throwable var5)
        {
            ModLoader.getLogger().throwing("RecipeInventory", "update", var5);
            ModLoader.throwException("Exception in RecipeInventory", var5);
        }
    }

    public void decIndex()
    {
        this.index = this.setIndex(this.index - SCPGui000J.ENTRIES);
    }

    public void incIndex()
    {
        this.index = this.setIndex(this.index + SCPGui000J.ENTRIES);
    }
    
    public int getIndex()
    {
    	return this.index;
    }

    public int setIndex(int var1)
    {
        try
        {
            if (this.totalPages == 1)
            {
                var1 = 0;
            }
            else if (var1 < 0)
            {
                var1 = SCPInventory000J.recipes.size() - SCPInventory000J.recipes.size() % SCPGui000J.ENTRIES;
            }
            else if (var1 >= SCPInventory000J.recipes.size())
            {
                var1 = 0;
            }

            this.items = new ItemStack[SCPGui000J.ENTRIES][];

            for (int var2 = 0; var2 < SCPGui000J.ENTRIES; ++var2)
            {
                int var3 = var1 + var2;

                if (var3 < SCPInventory000J.recipes.size())
                {
                    IRecipe var4 = (IRecipe)SCPInventory000J.recipes.get(var3);
                    ItemStack[] var5 = this.getRecipeArray(var4);

                    if (var5 == null)
                    {
                        ++var1;
                        --var2;
                    }
                    else
                    {
                        this.items[var2] = var5;
                    }
                }
            }

            if (this.book != null)
            {
                this.book.setItemDamage(var1);
            }

            return var1;
        }
        catch (Throwable var6)
        {
            ModLoader.getLogger().throwing("RecipeInventory", "setIndex", var6);
            ModLoader.throwException("Exception in RecipeInventory", var6);
            return 0;
        }
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return 10 * SCPGui000J.ENTRIES;
    }

    private ItemStack[] getRecipeArray(IRecipe var1) throws IllegalArgumentException, SecurityException, NoSuchFieldException
    {
        if (var1.getRecipeSize() > 9)
        {
            return null;
        }
        else
        {
            ItemStack[] var2 = new ItemStack[10];
            var2[0] = var1.getRecipeOutput();
            int var4;

            if (var1 instanceof ShapedRecipes)
            {
                int var3 = ((Integer)ModLoader.getPrivateValue(ShapedRecipes.class, (ShapedRecipes)var1, 0)).intValue();
                var4 = ((Integer)ModLoader.getPrivateValue(ShapedRecipes.class, (ShapedRecipes)var1, 1)).intValue();
                ItemStack[] var5 = (ItemStack[])((ItemStack[])ModLoader.getPrivateValue(ShapedRecipes.class, (ShapedRecipes)var1, 2));

                for (int var6 = 0; var6 < var5.length; ++var6)
                {
                    int var7 = var6 % var3;
                    int var8 = var6 / var3;
                    var2[var7 + var8 * 3 + 1] = var5[var6];
                }
            }
            else
            {
                if (!(var1 instanceof ShapelessRecipes))
                {
                    return null;
                }

                List<?> var9 = (List<?>)ModLoader.getPrivateValue(ShapelessRecipes.class, (ShapelessRecipes)var1, 1);

                for (var4 = 0; var4 < var9.size(); ++var4)
                {
                    var2[var4 + 1] = (ItemStack)var9.get(var4);
                }
            }

            return var2;
        }
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.book != null)
        {
        	this.book.stackTagCompound = null;
        }
        this.update();
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int var1, ItemStack var2) {}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return true;
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        StringBuilder var1 = new StringBuilder();
        var1.append(this.index / SCPGui000J.ENTRIES + 1);
        var1.append('/');
        var1.append(this.totalPages);
        return var1.toString();
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int var1)
    {
    	ItemStack[] var2 = this.items[var1 / 10];
        if (var2 == null)
        {
            var2 = this.items[var1 / 10] = new ItemStack[10];
        }
        return var2[var1 % 10];
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Called when an the contents of an Inventory change, usually
     */
    public void onInventoryChanged() {}

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int var1)
    {
        return null;
    }

    public void closeChest() {}

    public void openChest() {}

	public boolean isInvNameLocalized()
	{
		return true;
	}

	public boolean isStackValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}
}
