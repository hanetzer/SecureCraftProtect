package SCPCraft.tileentities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import SCPCraft.mod_SCP;
import SCPCraft.recipes.SCP261Recipes;

public class SCPTileEntity261 extends TileEntity implements IInventory
{
    private ItemStack SCP261ItemStacks[];

    /** The number of ticks that the furnace will keep burning */
    public int SCP261BurnTime;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int currentItemBurnTime;

    /** The number of ticks that the current item has been cooking for */
    public int SCP261CookTime;

    public SCPTileEntity261()
    {
        SCP261ItemStacks = new ItemStack[3];
        SCP261BurnTime = 0;
        currentItemBurnTime = 0;
        SCP261CookTime = 0;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return SCP261ItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return SCP261ItemStacks[par1];
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (SCP261ItemStacks[par1] != null)
        {
            if (SCP261ItemStacks[par1].stackSize <= par2)
            {
                ItemStack itemstack = SCP261ItemStacks[par1];
                SCP261ItemStacks[par1] = null;
                return itemstack;
            }

            ItemStack itemstack1 = SCP261ItemStacks[par1].splitStack(par2);

            if (SCP261ItemStacks[par1].stackSize == 0)
            {
                SCP261ItemStacks[par1] = null;
            }

            return itemstack1;
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
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (SCP261ItemStacks[par1] != null)
        {
            ItemStack itemstack = SCP261ItemStacks[par1];
            SCP261ItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        SCP261ItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
        {
            par2ItemStack.stackSize = getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.SCP261";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        SCP261ItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound.getByte("Slot");

            if (byte0 >= 0 && byte0 < SCP261ItemStacks.length)
            {
                SCP261ItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        SCP261BurnTime = par1NBTTagCompound.getShort("BurnTime");
        SCP261CookTime = par1NBTTagCompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(SCP261ItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)SCP261BurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)SCP261CookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < SCP261ItemStacks.length; i++)
        {
            if (SCP261ItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                SCP261ItemStacks[i].writeToNBT(nbttagcompound);
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
        return 16;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return (SCP261CookTime * par1) / 50;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (currentItemBurnTime == 0)
        {
            currentItemBurnTime = 50;
        }

        return (SCP261BurnTime * par1) / currentItemBurnTime;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return SCP261BurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean flag = SCP261BurnTime > 0;
        boolean flag1 = false;

        if (SCP261BurnTime > 0)
        {
            SCP261BurnTime--;
        }

        if (!worldObj.isRemote)
        {
            if (SCP261BurnTime == 0 && canSmelt())
            {
                currentItemBurnTime = SCP261BurnTime = getItemBurnTime(SCP261ItemStacks[1]);

                if (SCP261BurnTime > 0)
                {
                    flag1 = true;

                    if (SCP261ItemStacks[1] != null)
                    {
                        if (SCP261ItemStacks[1].getItem().hasContainerItem())
                        {
                            SCP261ItemStacks[1] = new ItemStack(SCP261ItemStacks[1].getItem().setFull3D());
                        }
                        else
                        {
                            SCP261ItemStacks[1].stackSize--;
                        }

                        if (SCP261ItemStacks[1].stackSize == 0)
                        {
                            SCP261ItemStacks[1] = null;
                        }
                    }
                }
            }

            if (isBurning() && canSmelt())
            {
                SCP261CookTime++;

                if (SCP261CookTime == 50)
                {
                	worldObj.playSoundEffect((double)((float)this.xCoord + 0.5F), (double)((float)this.yCoord + 0.5F), (double)((float)this.zCoord + 0.5F), "sounds.drop", 0.5F, 1F);
                    SCP261CookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                SCP261CookTime = 0;
            }

            if (flag != (SCP261BurnTime > 0))
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
        if (SCP261ItemStacks[0] == null)
        {
            return false;
        }

        ItemStack itemstack = SCP261Recipes.smelting().getSmeltingResult(SCP261ItemStacks[0].getItem().itemID);

        if (itemstack == null)
        {
            return false;
        }

        if (SCP261ItemStacks[2] == null)
        {
            return true;
        }

        if (!SCP261ItemStacks[2].isItemEqual(itemstack))
        {
            return false;
        }

        if (SCP261ItemStacks[2].stackSize < getInventoryStackLimit() && SCP261ItemStacks[2].stackSize < SCP261ItemStacks[2].getMaxStackSize())
        {
            return true;
        }

        return SCP261ItemStacks[2].stackSize < itemstack.getMaxStackSize();
    }
    public Random rand = new Random();

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (!canSmelt())
        {
            return;
        }

        ItemStack itemstack = SCP261Recipes.smelting().getSmeltingResult(SCP261ItemStacks[0].getItem().itemID);
        
    	Block ablock[] =
	        {
				Block.brick, Block.sand, Block.blockSnow, Block.netherBrick, Block.glowStone, Block.glass, Block.gravel, Block.oreIron, Block.web, Block.cloth, 
				Block.cobblestone, Block.mushroomBrown, Block.mushroomRed, Block.mycelium, Block.blockEmerald, Block.plantRed, Block.railDetector,
				Block.leaves, Block.sponge, Block.dispenser, Block.blockGold, Block.blockLapis, Block.blockClay, Block.blockDiamond, mod_SCP.BloodBlock,
				Block.blockSteel, Block.bookShelf, Block.brewingStand, Block.dirt, Block.oreCoal, Block.oreGold, Block.oreLapis, Block.planks, Block.railPowered,
				Block.stoneButton, Block.cactus, Block.cauldron, Block.chest, Block.sandStone, Block.sapling, Block.pistonBase, Block.pistonStickyBase, Block.stone,
				Block.wood, Block.deadBush, Block.grass, Block.plantYellow, Block.stoneSingleSlab, Block.woodSingleSlab, Block.workbench, Block.vine, Block.waterlily, 
				Block.whiteStone, Block.trapdoor, Block.torchRedstoneIdle, Block.torchWood, Block.thinGlass, Block.tilledField, Block.tnt, Block.furnaceIdle, 
				Block.stairsWoodSpruce, Block.stoneBrick, Block.stairsWoodJungle, Block.stairsWoodBirch, Block.stairsStoneBrick, Block.stairsSandStone, 
				Block.stairsNetherBrick, Block.stairsBrick, Block.stairsWoodOak, Block.stairsCobblestone, Block.snow, Block.silverfish, Block.slowSand, 
				Block.redstoneLampIdle, Block.rail, Block.pumpkinLantern, Block.pumpkin, Block.pressurePlateStone, Block.pressurePlatePlanks, Block.oreRedstone, 
				Block.oreDiamond, Block.obsidian, Block.netherrack, Block.netherFence, Block.mushroomCapRed, Block.mushroomCapBrown, Block.mobSpawner, 
				Block.melon, Block.lever, Block.ladder, Block.jukebox, Block.ice, Block.anvil, Block.beacon, Block.cobblestoneWall, 
				Block.woodenButton, Block.fenceIron, Block.fenceGate, Block.fence, Block.endPortalFrame, Block.cobblestoneMossy, Block.enderChest, Block.dragonEgg, 
				Block.enchantmentTable, Block.tallGrass, mod_SCP.CorrodedIron, mod_SCP.DocumentTable, mod_SCP.ElectricWool, mod_SCP.Granite, mod_SCP.GrateBlock, 
				mod_SCP.KeycardSlot, mod_SCP.Locker, mod_SCP.Machinery, mod_SCP.RemoteDoorComputer, mod_SCP.SCP143Leaves, mod_SCP.SCP143Log, mod_SCP.SCP143Planks, 
				mod_SCP.SCP143Sapling, mod_SCP.Shelf, mod_SCP.SmokeBlock, mod_SCP.Alarm, mod_SCP.Toilet, mod_SCP.SCP151, mod_SCP.Flesh, mod_SCP.Bone, mod_SCP.Marble,
				mod_SCP.stoneChair, mod_SCP.stoneDesk, mod_SCP.woodDesk, mod_SCP.woodenChair, mod_SCP.graniteDesk, mod_SCP.marbleChair, mod_SCP.marbleDesk, 
				mod_SCP.SCP513
	        };
    	
    	Item items[] =
    		{
    			Item.appleGold, Item.appleRed, Item.arrow, Item.axeDiamond, Item.axeGold, Item.axeSteel, Item.axeStone, Item.axeWood, 
    			Item.bed, Item.beefCooked, Item.beefRaw, Item.blazePowder, Item.blazeRod, Item.boat, Item.bone, Item.book, Item.bootsChain, Item.bootsDiamond, 
    			Item.bootsLeather, Item.bootsSteel, Item.bootsGold, Item.bow, Item.bowlEmpty, Item.bowlSoup, Item.bread,Item.brewingStand, Item.brick, 
    			Item.bucketEmpty, Item.bucketWater, Item.bucketLava, Item.bucketMilk, Item.coal, Item.clay, Item.cake, Item.compass, Item.shovelSteel,
    			Item.pickaxeSteel, Item.cauldron, Item.chickenCooked, Item.flintAndSteel, Item.diamond, Item.ingotIron, Item.ingotGold, Item.chickenRaw, 
    			Item.cookie, Item.doorSteel, Item.doorWood, Item.swordSteel, Item.swordWood, Item.shovelWood, Item.dyePowder, Item.egg, Item.emerald, 
    			Item.enderPearl, Item.expBottle, Item.pickaxeWood, Item.eyeOfEnder, Item.feather, Item.axeWood, Item.swordStone, Item.shovelStone, Item.pickaxeStone, 
    			Item.fermentedSpiderEye, Item.fireballCharge, Item.swordDiamond, Item.shovelDiamond, Item.fishCooked, Item.fishingRod, Item.fishRaw, 
    			Item.flint, Item.pickaxeDiamond, Item.stick, Item.swordGold, Item.ghastTear, Item.glassBottle, Item.goldNugget, Item.gunpowder,
    			Item.shovelGold, Item.pickaxeGold, Item.silk, Item.hoeWood, Item.hoeStone, Item.hoeGold, Item.hoeSteel, Item.hoeDiamond, Item.helmetChain, 
    			Item.helmetDiamond, Item.helmetGold, Item.helmetLeather, Item.helmetSteel, Item.seeds, Item.wheat, Item.leather, Item.legsChain, 
    			Item.legsDiamond, Item.legsLeather, Item.legsSteel, Item.legsGold, Item.lightStoneDust, Item.magmaCream, Item.melon, Item.melonSeeds, 
    			Item.minecartCrate, Item.minecartEmpty, Item.minecartPowered, Item.plateLeather, Item.monsterPlacer, Item.map, Item.plateChain, Item.plateSteel,
    			Item.plateGold, Item.plateDiamond, Item.porkRaw, Item.netherStalkSeeds, Item.painting, Item.porkCooked, Item.sign, Item.saddle, Item.redstone,
    			Item.snowball, Item.reed, Item.pocketSundial, Item.pumpkinSeeds, Item.potion, Item.slimeBall, Item.sugar, Item.shears, Item.rottenFlesh, Item.spiderEye,
    			Item.record11, Item.record13, Item.recordBlocks, Item.speckledMelon, Item.writableBook, Item.writtenBook, Item.recordChirp, Item.recordCat, Item.recordFar,
    			Item.recordMall, Item.recordMellohi, Item.recordStal, Item.recordStrad, Item.recordWard, Item.redstoneRepeater, Item.paper, Item.emptyMap, 
    			Item.itemFrame, Item.flowerPot, Item.carrot, Item.potato, Item.bakedPotato, Item.poisonousPotato, Item.goldenCarrot, Item.skull, Item.netherStar, 
    			Item.carrotOnAStick, Item.pumpkinPie, mod_SCP.Circuit, mod_SCP.ClassDPants, mod_SCP.ClassDShirt, mod_SCP.ClassDShoes, mod_SCP.CorrodedDoorItem, 
    			mod_SCP.GasMask, mod_SCP.InfraRedGlasses, mod_SCP.ItemSCPPoster, mod_SCP.L1Keycard, mod_SCP.SCP912Head, mod_SCP.SCP912Pants, mod_SCP.SCP912Shirt, 
    			mod_SCP.SCP912Shoes, mod_SCP.SlideDoorItem, mod_SCP.Wrench, mod_SCP.SCP000J, mod_SCP.SCP143Bucket, mod_SCP.Bucket006, mod_SCP.Bucket354, mod_SCP.BucketWater,
    			Item.enchantedBook, Item.fireworkCharge, Item.firework
    		};
    	
		int q = rand.nextInt(2);
		int maxBlocks = rand.nextInt(ablock.length);
		int maxItems = rand.nextInt(items.length);
		if(q == 1)itemstack = new ItemStack(ablock[maxBlocks], 1, rand.nextInt(17));
		if(q == 2)
		{
			if(items[maxItems] == Item.enchantedBook)itemstack = Item.enchantedBook.func_92109_a(rand);
			else itemstack = new ItemStack(items[maxItems], 1, rand.nextInt(items[maxItems].getMaxDamage() + 1));		
		}
		
        if (SCP261ItemStacks[2] == null)
        {
            SCP261ItemStacks[2] = itemstack.copy();
        }
        else if (SCP261ItemStacks[2].itemID == itemstack.itemID)
        {
            SCP261ItemStacks[2].stackSize += itemstack.stackSize;
        }

        if (SCP261ItemStacks[0].getItem().hasContainerItem())
        {
            SCP261ItemStacks[0] = new ItemStack(SCP261ItemStacks[0].getItem().setFull3D());
        }
        else
        {
            SCP261ItemStacks[0].stackSize--;
        }

        if (SCP261ItemStacks[0].stackSize <= 0)
        {
            SCP261ItemStacks[0] = null;
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

        int i = par1ItemStack.getItem().itemID;
        
        {
            return ModLoader.addAllFuel(par1ItemStack.itemID, par1ItemStack.getItemDamage());
        }
    }

    public static boolean func_52005_b(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }

        return par1EntityPlayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
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
