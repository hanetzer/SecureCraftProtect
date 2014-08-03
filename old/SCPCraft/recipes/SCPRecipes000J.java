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

public class SCPRecipes000J {

    private static final SCPRecipes000J instance = new SCPRecipes000J();
    private List<IRecipe> recipes;

    public static final SCPRecipes000J getInstance()
    {
        return instance;
    }

    private SCPRecipes000J()
    {
        recipes = new ArrayList<IRecipe>();
        //SCP Items
        addRecipe(new ItemStack (mod_SCP.SCP000J, 1), (new Object[]{" B ", "BAB", " B ", Character.valueOf('A'), Item.book, Character.valueOf('B'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.GasMask, 1), (new Object[]{"AAA", "A A", Character.valueOf('A'), mod_SCP.Locker}));
		addRecipe(new ItemStack (mod_SCP.ClassDShirt, 1), (new Object[]{"A A", "AAA", "AAA", Character.valueOf('A'), mod_SCP.Locker}));
		addRecipe(new ItemStack (mod_SCP.ClassDPants, 1), (new Object[]{"AAA", "A A", "A A", Character.valueOf('A'), mod_SCP.Locker}));
		addRecipe(new ItemStack (mod_SCP.ClassDShoes, 1), (new Object[]{"A A", "A A", Character.valueOf('A'), mod_SCP.Locker}));
		addRecipe(new ItemStack (mod_SCP.L1Keycard, 1), (new Object[]{"AAA", "BBB", Character.valueOf('A'), Item.paper, Character.valueOf('B'), Item.ingotIron}));		
		addRecipe(new ItemStack (mod_SCP.Wrench, 1), (new Object[]{"B B", "AAA", " A ", Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.ingotGold}));
		addRecipe(new ItemStack (mod_SCP.SCP143Sword, 1), (new Object[]{"A", "A", "X", Character.valueOf('X'), Item.stick, Character.valueOf('A'), mod_SCP.SCP143Planks}));
		addRecipe(new ItemStack (mod_SCP.SCP143Axe, 1), (new Object[]{"AA", "AX", " X", Character.valueOf('X'), Item.stick, Character.valueOf('A'), mod_SCP.SCP143Planks}));
		addRecipe(new ItemStack (mod_SCP.SCP143Pickaxe, 1), (new Object[]{"AAA", " X ", " X ", Character.valueOf('X'), Item.stick, Character.valueOf('A'), mod_SCP.SCP143Planks}));
		addRecipe(new ItemStack (mod_SCP.SCP143Spade, 1), (new Object[]{"A", "X", "X", Character.valueOf('X'), Item.stick, Character.valueOf('A'), mod_SCP.SCP143Planks}));
		addRecipe(new ItemStack (Item.stick, 4), (new Object[]{"A", "A", Character.valueOf('A'), mod_SCP.SCP143Planks}));		
		addRecipe(new ItemStack (mod_SCP.CorrodedDoorItem, 1), (new Object[]{"XX ", "XX ", "XX ", Character.valueOf('X'), mod_SCP.CorrodedIron}));		
		addRecipe(new ItemStack (mod_SCP.InfraRedGlasses, 1), (new Object[]{"B B", "AAA", " Z ", Character.valueOf('B'), Block.torchRedstoneIdle, Character.valueOf('A'), Item.ingotIron, Character.valueOf('Z'), Item.redstoneRepeater}));
		addRecipe(new ItemStack (mod_SCP.InfraRedGlasses, 1), (new Object[]{"B B", "AAA", " Z ", Character.valueOf('B'), Block.torchRedstoneActive, Character.valueOf('A'), Item.ingotIron, Character.valueOf('Z'), Item.redstoneRepeater}));
		addRecipe(new ItemStack (mod_SCP.SlideDoorItem, 4), (new Object[]{" O ", "APA", "XXX", Character.valueOf('X'), Block.rail, Character.valueOf('P'), Item.doorSteel, Character.valueOf('A'), Item.redstoneRepeater, Character.valueOf('O'), Item.coal}));
		addRecipe(new ItemStack (mod_SCP.Circuit, 2), (new Object[]{"AAA", "BIB", "AAA", Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.redstone, Character.valueOf('I'), Block.torchRedstoneActive}));		
		addRecipe(new ItemStack (mod_SCP.ItemSCPPoster, 3), (new Object[]{"AAA", "BBB", "AAA", Character.valueOf('A'), Block.planks, Character.valueOf('B'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.ItemSCPPoster, 6), (new Object[]{"AAA", "BBB", "AAA", Character.valueOf('A'), mod_SCP.SCP143Planks, Character.valueOf('B'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCP143Bucket, 1), (new Object[]{"B B", " B ", Character.valueOf('B'), mod_SCP.SCP143Planks}));
		
		//SCP Pearls
		addRecipe(new ItemStack (mod_SCP.Pearl914, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.ingotGold, Character.valueOf('B'), Item.diamond}));
		addRecipe(new ItemStack (mod_SCP.Pearl019, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.blockClay, Character.valueOf('B'), Item.coal}));
		addRecipe(new ItemStack (mod_SCP.Pearl457, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.flintAndSteel, Character.valueOf('B'), Block.netherrack}));
		addRecipe(new ItemStack (mod_SCP.Pearl294, 1), (new Object[]{"XBX", "BAB", "XBX", Character.valueOf('A'), Item.enderPearl, Character.valueOf('B'), Item.bucketWater, Character.valueOf('X'), Block.obsidian}));
		addRecipe(new ItemStack (mod_SCP.Pearl513, 1), (new Object[]{" X ", "XXX", "XBX", Character.valueOf('B'), Item.enderPearl, Character.valueOf('X'), Item.ingotIron}));
		addRecipe(new ItemStack (mod_SCP.Pearl049, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.appleRed, Character.valueOf('B'), Item.spiderEye}));
		addRecipe(new ItemStack (mod_SCP.Pearl087, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.stairsCobblestone, Character.valueOf('B'), Item.eyeOfEnder}));
		addRecipe(new ItemStack (mod_SCP.Pearl1000, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.dirt, Character.valueOf('B'), Block.tallGrass}));
		addRecipe(new ItemStack (mod_SCP.Pearl131, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.eyeOfEnder, Character.valueOf('B'), Item.redstone}));
		addRecipe(new ItemStack (mod_SCP.Pearl999, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.slimeBall, Character.valueOf('B'), Item.blazePowder}));
		addRecipe(new ItemStack (mod_SCP.Pearl261, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.obsidian, Character.valueOf('B'), Item.diamond}));
		addRecipe(new ItemStack (mod_SCP.Pearl629, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.ingotGold}));
		addRecipe(new ItemStack (mod_SCP.Pearl106, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.obsidian, Character.valueOf('B'), Block.cobblestoneMossy}));
		addRecipe(new ItemStack (mod_SCP.Pearl538, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.spiderEye, Character.valueOf('B'), Item.silk}));		
		addRecipe(new ItemStack (mod_SCP.Pearl280, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.whiteStone, Character.valueOf('B'), Block.obsidian}));
		addRecipe(new ItemStack (mod_SCP.Pearl080, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.torchWood, Character.valueOf('B'), Item.coal}));
		addRecipe(new ItemStack (mod_SCP.Pearl409, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.diamond, Character.valueOf('B'), mod_SCP.Granite}));
		addRecipe(new ItemStack (mod_SCP.Pearl310, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.flintAndSteel, Character.valueOf('B'), Item.silk}));
		addRecipe(new ItemStack (mod_SCP.Pearl594, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.cloth, Character.valueOf('B'), Item.redstone}));
		addRecipe(new ItemStack (mod_SCP.Pearl058, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), mod_SCP.BloodBlock, Character.valueOf('B'), Item.spiderEye}));
		addRecipe(new ItemStack (mod_SCP.Pearl143, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.wood, Character.valueOf('B'), Block.sapling}));
		addRecipe(new ItemStack (mod_SCP.Pearl173, 1), (new Object[]{"YAY", "AXA", "YAY", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.rottenFlesh, Character.valueOf('Y'), Block.stone}));
		addRecipe(new ItemStack (mod_SCP.Pearl111, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.dirt, Character.valueOf('B'), Item.appleRed}));
		addRecipe(new ItemStack (mod_SCP.Pearl966, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.bed, Character.valueOf('B'), Item.redstone}));
		addRecipe(new ItemStack (mod_SCP.Pearl015, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.blockSteel, Character.valueOf('B'), mod_SCP.Machinery}));
		addRecipe(new ItemStack (mod_SCP.Pearl053, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.plantRed, Character.valueOf('B'), Block.plantYellow}));
		addRecipe(new ItemStack (mod_SCP.Pearl076, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.netherBrick, Character.valueOf('B'), Block.stone}));
		addRecipe(new ItemStack (mod_SCP.Pearl073, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.obsidian, Character.valueOf('B'), Item.bone}));
		addRecipe(new ItemStack (mod_SCP.Pearl997, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.ingotGold, Character.valueOf('B'), Item.brewingStand}));
		addRecipe(new ItemStack (mod_SCP.Pearl027, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), mod_SCP.GrateBlock, Character.valueOf('B'), Item.coal}));
		addRecipe(new ItemStack (mod_SCP.Pearl079, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.redstoneRepeater, Character.valueOf('B'), mod_SCP.Circuit}));
		addRecipe(new ItemStack (mod_SCP.Pearl872, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.wheat, Character.valueOf('B'), Item.stick}));
		addRecipe(new ItemStack (mod_SCP.Pearl789J, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.bucketWater, Character.valueOf('B'), Block.slowSand}));
		addRecipe(new ItemStack (mod_SCP.Pearl151, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('B'), Item.bucketWater}));
		addRecipe(new ItemStack (mod_SCP.Pearl472, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.redstone, Character.valueOf('B'), mod_SCP.BloodBlock}));
		addRecipe(new ItemStack (mod_SCP.Pearl372, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.vine, Character.valueOf('B'), Block.leaves}));
		addRecipe(new ItemStack (mod_SCP.Pearl023, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.obsidian, Character.valueOf('B'), Item.porkRaw}));
		addRecipe(new ItemStack (mod_SCP.Pearl822, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.cactus, Character.valueOf('B'), Block.tnt}));
		addRecipe(new ItemStack (mod_SCP.Pearl006, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.bucketWater, Character.valueOf('B'), Block.grass}));		
		addRecipe(new ItemStack (mod_SCP.Pearl354, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.snowball, Character.valueOf('B'), Item.bucketLava}));
		addRecipe(new ItemStack (mod_SCP.Pearl096, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.ghastTear, Character.valueOf('B'), Item.gunpowder}));
		//addRecipe(new ItemStack (mod_SCP.Pearl1440, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.leather, Character.valueOf('B'), Block.tnt}));
		addRecipe(new ItemStack (mod_SCP.Pearl002, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.blockSteel, Character.valueOf('B'), Item.rottenFlesh}));
		addRecipe(new ItemStack (mod_SCP.Pearl009, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Block.ice, 'B', new ItemStack(Item.dyePowder, 1, 1)}));
		addRecipe(new ItemStack (mod_SCP.Pearl273, 1), (new Object[]{"BAB", "AXA", "BAB", Character.valueOf('X'), Item.enderPearl, Character.valueOf('A'), Item.gunpowder, Character.valueOf('B'), Item.blazePowder}));
		
		//SCP Item Descriptions
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 0), (new Object[]{"XBX", "BAB", "XBX", Character.valueOf('A'), Item.paper, Character.valueOf('B'), Item.appleGold, Character.valueOf('X'), Item.redstone}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 1), (new Object[]{"BXB", "XAX", "BXB", Character.valueOf('X'), Block.obsidian, Character.valueOf('B'), Item.emerald, Character.valueOf('A'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 2), (new Object[]{"ABA", "BCB", "ABA", Character.valueOf('A'), Item.book, Character.valueOf('B'), Item.rottenFlesh, Character.valueOf('C'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 3), (new Object[]{"XAX", "ABA", "XAX", Character.valueOf('X'), Item.bucketWater, Character.valueOf('A'), Item.leather, Character.valueOf('B'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 4), (new Object[]{"XBX", "BPB", "XBX", Character.valueOf('X'), mod_SCP.CorrodedIron, Character.valueOf('B'), Block.lever, Character.valueOf('P'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 5), (new Object[]{"XAX", "ABA", "XAX", Character.valueOf('X'), Item.flintAndSteel, Character.valueOf('A'), Item.wheat, Character.valueOf('B'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 6), (new Object[]{"XAX", "ABA", "XAX", Character.valueOf('X'), Item.appleGold, Character.valueOf('A'), Item.diamond, Character.valueOf('B'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 7), (new Object[]{"BAB", "AZA", "BAB", Character.valueOf('B'), Item.ingotIron, Character.valueOf('A'), Block.thinGlass, Character.valueOf('Z'), Item.paper}));
		addRecipe(new ItemStack (mod_SCP.SCPItems, 1, 8), (new Object[]{"AXB", "XYX", "DXC", Character.valueOf('X'), mod_SCP.Locker, Character.valueOf('A'), Item.helmetSteel, Character.valueOf('B'), Item.plateSteel, Character.valueOf('C'), Item.legsSteel, Character.valueOf('D'), Item.bootsSteel, Character.valueOf('Y'), Item.paper}));
		
		//SCP-217
		addShapelessRecipe(new ItemStack(mod_SCP.VirusPig, 1), new Object [] {mod_SCP.SCP217, Item.porkRaw});
		addShapelessRecipe(new ItemStack(mod_SCP.VirusCreeper, 1), new Object [] {mod_SCP.SCP217, Item.gunpowder});
		addShapelessRecipe(new ItemStack(mod_SCP.VirusPig, 1), new Object [] {mod_SCP.SCP217, Item.porkCooked});
		addShapelessRecipe(new ItemStack(mod_SCP.VirusCow, 1), new Object [] {mod_SCP.SCP217, Item.beefRaw});
		addShapelessRecipe(new ItemStack(mod_SCP.VirusCow, 1), new Object [] {mod_SCP.SCP217, Item.beefCooked});
		addShapelessRecipe(new ItemStack(mod_SCP.VirusSpider, 1), new Object [] {mod_SCP.SCP217, Item.silk});
		addShapelessRecipe(new ItemStack(mod_SCP.VirusSpider, 1), new Object [] {mod_SCP.SCP217, Item.spiderEye});
		addShapelessRecipe(new ItemStack(mod_SCP.VirusZombie, 1), new Object [] {mod_SCP.SCP217, Item.rottenFlesh});	
		addShapelessRecipe(new ItemStack(mod_SCP.VirusTestificate, 1), new Object [] {mod_SCP.SCP217, Item.emerald});
		
		//SCP Blocks
		addRecipe(new ItemStack (mod_SCP.Locker, 1), (new Object[]{" B ", "BAB", " B ", Character.valueOf('B'), Item.ingotIron, Character.valueOf('A'), Block.blockSteel}));
		addRecipe(new ItemStack (mod_SCP.DocumentTable, 1), new Object[]{" W ", "WCW", " W ", Character.valueOf('C'), Block.workbench, Character.valueOf('W'), mod_SCP.Locker});
		addRecipe(new ItemStack (mod_SCP.SmokeBlock, 2), (new Object[]{"B B", "BXB", "BBB", Character.valueOf('X'), Item.flintAndSteel, Character.valueOf('B'), Block.cobblestone}));
		addRecipe(new ItemStack (mod_SCP.KeycardSlot, 4), (new Object[]{"CCC", "ABA", "AAA", Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.redstone, Character.valueOf('C'), Block.stoneButton}));
		addRecipe(new ItemStack (mod_SCP.Alarm, 2), (new Object[]{"CCC", "ABA", "CCC", Character.valueOf('A'), Item.redstone, Character.valueOf('B'), Block.music, Character.valueOf('C'), Item.ingotIron}));
		addRecipe(new ItemStack (mod_SCP.Granite, 4), (new Object[]{" A ", "AXA", " A ", Character.valueOf('X'), Block.obsidian, Character.valueOf('A'), Block.stone}));
		addShapelessRecipe(new ItemStack(mod_SCP.SCP143Planks, 4), new Object [] {mod_SCP.SCP143Log});
		addRecipe(new ItemStack (Block.workbench, 1), (new Object[]{"XX", "XX", Character.valueOf('X'), mod_SCP.SCP143Planks}));
		addRecipe(new ItemStack (mod_SCP.GrateBlock, 6), (new Object[]{"AAA", "AAA", "AAA", Character.valueOf('A'), Block.fenceIron}));
		addRecipe(new ItemStack (mod_SCP.RemoteDoorComputer, 1), (new Object[]{"BXB", " Z ", "BXB", Character.valueOf('B'), Item.ingotIron, Character.valueOf('X'), mod_SCP.Circuit, Character.valueOf('Z'), mod_SCP.SlideDoorItem}));
		addRecipe(new ItemStack (mod_SCP.Shelf, 3), (new Object[]{"AAA", Character.valueOf('A'), Item.ingotIron}));		
		addRecipe(new ItemStack (mod_SCP.OakShelf, 3), (new Object[]{"AAA", Character.valueOf('A'), new ItemStack(Block.woodSingleSlab, 1, 0)}));
		addRecipe(new ItemStack (mod_SCP.SpruceShelf, 3), (new Object[]{"AAA", Character.valueOf('A'), new ItemStack(Block.woodSingleSlab, 1, 1)}));
		addRecipe(new ItemStack (mod_SCP.BirchShelf, 3), (new Object[]{"AAA", Character.valueOf('A'), new ItemStack(Block.woodSingleSlab, 1, 2)}));
		addRecipe(new ItemStack (mod_SCP.JungleShelf, 3), (new Object[]{"AAA", Character.valueOf('A'), new ItemStack(Block.woodSingleSlab, 1, 3)}));
		addRecipe(new ItemStack (mod_SCP.Toilet, 1), (new Object[]{"  B", "BBB", " B ", Character.valueOf('B'), mod_SCP.Marble}));
		addRecipe(new ItemStack (mod_SCP.marbleDesk, 1), (new Object[]{"BBB", "B B", Character.valueOf('B'), mod_SCP.Marble}));
		addRecipe(new ItemStack (mod_SCP.woodDesk, 1), (new Object[]{"BBB", "B B", Character.valueOf('B'), Block.planks}));
		addRecipe(new ItemStack (mod_SCP.stoneDesk, 1), (new Object[]{"BBB", "B B", Character.valueOf('B'), Block.stone}));
		addRecipe(new ItemStack (mod_SCP.graniteDesk, 1), (new Object[]{"BBB", "B B", Character.valueOf('B'), mod_SCP.Granite}));
		addRecipe(new ItemStack (mod_SCP.marbleChair, 1), (new Object[]{"  B", "BBB", "B B", Character.valueOf('B'), mod_SCP.Marble}));
		addRecipe(new ItemStack (mod_SCP.woodenChair, 1), (new Object[]{"  B", "BBB", "B B", Character.valueOf('B'), Block.planks}));
		addRecipe(new ItemStack (mod_SCP.stoneChair, 1), (new Object[]{"  B", "BBB", "B B", Character.valueOf('B'), Block.stone}));
		addRecipe(new ItemStack (mod_SCP.Flesh, 4), (new Object[]{"BBB", "BBB", "BBB", Character.valueOf('B'), Item.rottenFlesh}));
		addRecipe(new ItemStack (mod_SCP.Flesh, 4), (new Object[]{"BBB", "BBB", "BBB", Character.valueOf('B'), Item.porkRaw}));
		addRecipe(new ItemStack (mod_SCP.Flesh, 4), (new Object[]{"BBB", "BBB", "BBB", Character.valueOf('B'), Item.beefRaw}));
		addRecipe(new ItemStack (mod_SCP.Bone, 4), (new Object[]{"BBB", "BBB", "BBB", Character.valueOf('B'), Item.bone}));
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
