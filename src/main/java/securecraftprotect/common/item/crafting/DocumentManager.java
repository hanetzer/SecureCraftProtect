package securecraftprotect.common.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import securecraftprotect.common.registry.DocumentRegistry;
import static securecraftprotect.init.SCPItems.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DocumentManager {
    private static final DocumentManager instance = new DocumentManager();
    private List<IRecipe> recipes = new ArrayList<IRecipe>();


    private DocumentManager() {
        for(int i = 0; i < DocumentRegistry.documentList.size(); i++){
            this.addShapelessRecipe(new ItemStack(document, 1, i), new Object[]{new ItemStack(pearl, 1, i), Items.paper});
        }

        //addShapelessRecipe(new ItemStack(mod_SCP.SCP1440S, 1), new Object[] { mod_SCP.Pearl1440, Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP846S, 1), new Object[] { mod_SCP.Pearl846, Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP500S, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 0), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP063S, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 1), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP1025S, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 2), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP109S, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 3), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP50AEJS, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 5), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP420JS, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 6), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP458S, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 7), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP217S, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 8), Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP912S, 1), new Object[]{new ItemStack(mod_SCP.SCPItems, 1, 10), Item.paper});
        System.out.println((new StringBuilder()).append(recipes.size()).append(" documents").toString());
    }

    public static DocumentManager getInstance() {
        return instance;
    }

    void addShapelessRecipe(ItemStack itemstack, Object objects[]) {
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();

        for (Object obj : objects) {
            if (obj instanceof ItemStack) {
                list.add(((ItemStack) obj).copy());
                continue;
            }

            if (obj instanceof Item) {
                list.add(new ItemStack((Item) obj));
                continue;
            }

            if (obj instanceof Block) {
                list.add(new ItemStack((Block) obj));
            } else {
                throw new RuntimeException("Invalid shapeless recipe!");
            }
        }

        recipes.add(new ShapelessRecipes(itemstack, list));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting p_82787_1_, World p_82787_2_)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < p_82787_1_.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = p_82787_1_.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(p_82787_1_, p_82787_2_))
                {
                    return irecipe.getCraftingResult(p_82787_1_);
                }
            }

            return null;
        }
    }

    public List<IRecipe> getRecipeList() {
        return recipes;
    }
}
