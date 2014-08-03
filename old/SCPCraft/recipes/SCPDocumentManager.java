package SCPCraft.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import SCPCraft.mod_SCP;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class SCPDocumentManager
{
    private static final SCPDocumentManager instance = new SCPDocumentManager();
    private List<IRecipe> recipes;

    public static final SCPDocumentManager getInstance()
    {
        return instance;
    }

    private SCPDocumentManager()
    {
        recipes = new ArrayList<IRecipe>();

        addShapelessRecipe(new ItemStack(mod_SCP.SCP173S, 1), new Object[] { mod_SCP.Pearl173, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP111S, 1), new Object[] { mod_SCP.Pearl111, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP914S, 1), new Object[] { mod_SCP.Pearl914, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP019S, 1), new Object[] { mod_SCP.Pearl019, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP457S, 1), new Object[] { mod_SCP.Pearl457, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP294S, 1), new Object[] { mod_SCP.Pearl294, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP513S, 1), new Object[] { mod_SCP.Pearl513, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP049S, 1), new Object[] { mod_SCP.Pearl049, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP087S, 1), new Object[] { mod_SCP.Pearl087, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP1000S, 1), new Object[] { mod_SCP.Pearl1000, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP131S, 1), new Object[] { mod_SCP.Pearl131, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP999S, 1), new Object[] { mod_SCP.Pearl999, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP629S, 1), new Object[] { mod_SCP.Pearl629, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP354S, 1), new Object[] { mod_SCP.Pearl354, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP096S, 1), new Object[] { mod_SCP.Pearl096, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP261S, 1), new Object[] { mod_SCP.Pearl261, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP106S, 1), new Object[] { mod_SCP.Pearl106, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP538S, 1), new Object[] { mod_SCP.Pearl538, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP280S, 1), new Object[] { mod_SCP.Pearl280, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP080S, 1), new Object[] { mod_SCP.Pearl080, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP143S, 1), new Object[] { mod_SCP.Pearl143, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP409S, 1), new Object[] { mod_SCP.Pearl409, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP310S, 1), new Object[] { mod_SCP.Pearl310, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP594S, 1), new Object[] { mod_SCP.Pearl594, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP058S, 1), new Object[] { mod_SCP.Pearl058, Item.paper});
      //  addShapelessRecipe(new ItemStack(mod_SCP.SCP1440S, 1), new Object[] { mod_SCP.Pearl1440, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP006S, 1), new Object[] { mod_SCP.Pearl006, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP966S, 1), new Object[] { mod_SCP.Pearl966, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP872S, 1), new Object[] { mod_SCP.Pearl872, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP079S, 1), new Object[] { mod_SCP.Pearl079, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP073S, 1), new Object[] { mod_SCP.Pearl073, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP076S, 1), new Object[] { mod_SCP.Pearl076, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP015S, 1), new Object[] { mod_SCP.Pearl015, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP053S, 1), new Object[] { mod_SCP.Pearl053, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP997S, 1), new Object[] { mod_SCP.Pearl997, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP027S, 1), new Object[] { mod_SCP.Pearl027, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP789JS, 1), new Object[] { mod_SCP.Pearl789J, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP079S, 1), new Object[] { mod_SCP.Pearl079, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP151S, 1), new Object[] { mod_SCP.Pearl151, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP372S, 1), new Object[] { mod_SCP.Pearl372, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP472S, 1), new Object[] { mod_SCP.Pearl472, Item.paper});
        //addShapelessRecipe(new ItemStack(mod_SCP.SCP846S, 1), new Object[] { mod_SCP.Pearl846, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP273S, 1), new Object[] { mod_SCP.Pearl273, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP822S, 1), new Object[] { mod_SCP.Pearl822, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP023S, 1), new Object[] { mod_SCP.Pearl023, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP002S, 1), new Object[] { mod_SCP.Pearl002, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP009S, 1), new Object[] { mod_SCP.Pearl009, Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP500S, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 0), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP063S, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 1), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP1025S, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 2), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP109S, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 3), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP50AEJS, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 5), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP420JS, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 6), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP458S, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 7), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP217S, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 8), Item.paper});
        addShapelessRecipe(new ItemStack(mod_SCP.SCP912S, 1), new Object[] { new ItemStack(mod_SCP.SCPItems, 1, 10), Item.paper});
        System.out.println((new StringBuilder()).append(recipes.size()).append(" documents").toString());
    }

    void addRecipe(ItemStack itemstack, Object aobj[])
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (aobj[i] instanceof String[])
        {
            String as[] = (String[])aobj[i++];

            for (int l = 0; l < as.length; l++)
            {
                String s2 = as[l];
                k++;
                j = s2.length();
                s = (new StringBuilder()).append(s).append(s2).toString();
            }
        }
        else
        {
            while (aobj[i] instanceof String)
            {
                String s1 = (String)aobj[i++];
                k++;
                j = s1.length();
                s = (new StringBuilder()).append(s).append(s1).toString();
            }
        }

        HashMap<Character, ItemStack> hashmap = new HashMap<Character, ItemStack>();

        for (; i < aobj.length; i += 2)
        {
            Character character = (Character)aobj[i];
            ItemStack itemstack1 = null;

            if (aobj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)aobj[i + 1]);
            }
            else if (aobj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)aobj[i + 1], 1, -1);
            }
            else if (aobj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)aobj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack aitemstack[] = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; i1++)
        {
            char c = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        recipes.add(new ShapedRecipes(j, k, aitemstack, itemstack));
    }

    void addShapelessRecipe(ItemStack itemstack, Object aobj[])
    {
        ArrayList<ItemStack> arraylist = new ArrayList<ItemStack>();
        Object aobj1[] = aobj;
        int i = aobj1.length;

        for (int j = 0; j < i; j++)
        {
            Object obj = aobj1[j];

            if (obj instanceof ItemStack)
            {
                arraylist.add(((ItemStack)obj).copy());
                continue;
            }

            if (obj instanceof Item)
            {
                arraylist.add(new ItemStack((Item)obj));
                continue;
            }

            if (obj instanceof Block)
            {
                arraylist.add(new ItemStack((Block)obj));
            }
            else
            {
                throw new RuntimeException("Invalid shapeless recipy!");
            }
        }

        recipes.add(new ShapelessRecipes(itemstack, arraylist));
    }

    public ItemStack func_82787_a(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;

        for (int var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
        {
            ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

            if (var7 != null)
            {
                if (var3 == 0)
                {
                    var4 = var7;
                }

                if (var3 == 1)
                {
                    var5 = var7;
                }

                ++var3;
            }
        }

        if (var3 == 2 && var4.itemID == var5.itemID && var4.stackSize == 1 && var5.stackSize == 1 && Item.itemsList[var4.itemID].isRepairable())
        {
            Item var13 = Item.itemsList[var4.itemID];
            int var14 = var13.getMaxDamage() - var4.getItemDamageForDisplay();
            int var8 = var13.getMaxDamage() - var5.getItemDamageForDisplay();
            int var9 = var14 + var8 + var13.getMaxDamage() * 5 / 100;
            int var10 = var13.getMaxDamage() - var9;

            if (var10 < 0)
            {
                var10 = 0;
            }

            return new ItemStack(var4.itemID, 1, var10);
        }
        else
        {
            Iterator<IRecipe> var11 = this.recipes.iterator();
            IRecipe var12;

            do
            {
                if (!var11.hasNext())
                {
                    return null;
                }

                var12 = (IRecipe)var11.next();
            }
            while (!var12.matches(par1InventoryCrafting, par2World));

            return var12.getCraftingResult(par1InventoryCrafting);
        }
    }

    public List<IRecipe> getRecipeList()
    {
        return recipes;
    }
}
