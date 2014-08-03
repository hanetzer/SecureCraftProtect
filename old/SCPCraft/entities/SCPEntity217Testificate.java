package SCPCraft.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCPEntity217Testificate extends EntityAgeable implements INpc, IMerchant
{
    private int randomTickDivider;
    private boolean isMating;
    private boolean isPlaying;
    Village villageObj;

    /** This villager's current customer. */
    private EntityPlayer buyingPlayer;

    /** Initialises the MerchantRecipeList.java */
    private MerchantRecipeList buyingList;
    private int timeUntilReset;

    /** addDefaultEquipmentAndRecipies is called if this is true */
    private boolean needsInitilization;
    private int wealth;
    private String field_82189_bL;
    private boolean field_82190_bM;
    private float field_82191_bN;

    /**
     * a villagers recipe list is intialized off this list ; the 2 params are min/max amount they will trade for 1
     * emerald
     */
    public static final Map villagerStockList = new HashMap();

    /**
     * Selling list of Blacksmith items. negative numbers mean 1 emerald for n items, positive numbers are n emeralds
     * for 1 item
     */
    public static final Map blacksmithSellingList = new HashMap();

    public SCPEntity217Testificate(World par1World)
    {
        this(par1World, 0);
    }
	
    public SCPEnumCreatureAttribute getSCPAttribute()
    {
        return SCPEnumCreatureAttribute.SCP;
    }

    public SCPEntity217Testificate(World par1World, int par2)
    {
        super(par1World);
        this.randomTickDivider = 0;
        this.isMating = false;
        this.isPlaying = false;
        this.villageObj = null;
        this.texture = "/SCPCraft/textures/mobs/SCP217/SCPTestificate.png";
        this.moveSpeed = 0.4F;
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, SCPEntity217Zombie.class, 8.0F, 0.3F, 0.35F));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.3F, 0.35F));
        this.tasks.addTask(1, new SCPEntityAITradePlayer(this));
        this.tasks.addTask(1, new SCPEntityAILookAtTradePlayer(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, SCPEntity217Testificate.class, 5.0F, 0.02F));
        this.tasks.addTask(6, new EntityAIWander(this, 0.3F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        if (--this.randomTickDivider <= 0)
        {
            this.worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

            if (this.villageObj == null)
            {
                this.detachHome();
            }
            else
            {
                ChunkCoordinates var1 = this.villageObj.getCenter();
                this.setHomeArea(var1.posX, var1.posY, var1.posZ, (int)((float)this.villageObj.getVillageRadius() * 0.6F));

                if (this.field_82190_bM)
                {
                    this.field_82190_bM = false;
                    this.villageObj.func_82683_b(5);
                }
            }
        }

        if (!this.isTrading() && this.timeUntilReset > 0)
        {
            --this.timeUntilReset;

            if (this.timeUntilReset <= 0)
            {
                if (this.needsInitilization)
                {
                    if (this.buyingList.size() > 1)
                    {
                        Iterator<?> var3 = this.buyingList.iterator();

                        while (var3.hasNext())
                        {
                            MerchantRecipe var2 = (MerchantRecipe)var3.next();

                            if (var2.func_82784_g())
                            {
                                var2.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                            }
                        }
                    }

                    this.addDefaultEquipmentAndRecipies(1);
                    this.needsInitilization = false;

                    if (this.villageObj != null && this.field_82189_bL != null)
                    {
                        this.worldObj.setEntityState(this, (byte)14);
                        this.villageObj.setReputationForPlayer(this.field_82189_bL, 1);
                    }
                }

                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }

        super.updateAITick();
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (this.isEntityAlive() && !this.isTrading() && !this.isChild())
        {
            if (!this.worldObj.isRemote)
            {
                this.setCustomer(par1EntityPlayer);
                par1EntityPlayer.displayGUIMerchant(this, this.func_94057_bL());
            }

            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
    }

    public int getMaxHealth()
    {
        return 20;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Riches", this.wealth);

        if (this.buyingList != null)
        {
            par1NBTTagCompound.setCompoundTag("Offers", this.buyingList.getRecipiesAsTags());
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.wealth = par1NBTTagCompound.getInteger("Riches");

        if (par1NBTTagCompound.hasKey("Offers"))
        {
            NBTTagCompound var2 = par1NBTTagCompound.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(var2);
        }
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }

    public boolean isMating()
    {
        return this.isMating;
    }

    public void setMating(boolean par1)
    {
        this.isMating = par1;
    }

    public void setPlaying(boolean par1)
    {
        this.isPlaying = par1;
    }

    public boolean isPlaying()
    {
        return this.isPlaying;
    }

    public void setRevengeTarget(EntityLiving par1EntityLiving)
    {
        super.setRevengeTarget(par1EntityLiving);

        if (this.villageObj != null && par1EntityLiving != null)
        {
            this.villageObj.addOrRenewAgressor(par1EntityLiving);

            if (par1EntityLiving instanceof EntityPlayer)
            {
                byte var2 = -1;

                if (this.isChild())
                {
                    var2 = -3;
                }

                this.villageObj.setReputationForPlayer(((EntityPlayer)par1EntityLiving).getCommandSenderName(), var2);

                if (this.isEntityAlive())
                {
                    this.worldObj.setEntityState(this, (byte)13);
                }
            }
        }
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        if (this.villageObj != null)
        {
            Entity var2 = par1DamageSource.getEntity();

            if (var2 != null)
            {
                if (var2 instanceof EntityPlayer)
                {
                    this.villageObj.setReputationForPlayer(((EntityPlayer)var2).getCommandSenderName(), -2);
                }
                else if (var2 instanceof IMob)
                {
                    this.villageObj.endMatingSeason();
                }
            }
            else if (var2 == null)
            {
                EntityPlayer var3 = this.worldObj.getClosestPlayerToEntity(this, 16.0D);

                if (var3 != null)
                {
                    this.villageObj.endMatingSeason();
                }
            }
        }

        super.onDeath(par1DamageSource);
    }

    public void setCustomer(EntityPlayer par1EntityPlayer)
    {
        this.buyingPlayer = par1EntityPlayer;
    }

    public EntityPlayer getCustomer()
    {
        return this.buyingPlayer;
    }

    public boolean isTrading()
    {
        return this.buyingPlayer != null;
    }

    public void useRecipe(MerchantRecipe par1MerchantRecipe)
    {
        par1MerchantRecipe.incrementToolUses();

        if (par1MerchantRecipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1)))
        {
            this.timeUntilReset = 40;
            this.needsInitilization = true;

            if (this.buyingPlayer != null)
            {
                this.field_82189_bL = this.buyingPlayer.getCommandSenderName();
            }
            else
            {
                this.field_82189_bL = null;
            }
        }

        if (par1MerchantRecipe.getItemToBuy().itemID == Item.emerald.itemID)
        {
            this.wealth += par1MerchantRecipe.getItemToBuy().stackSize;
        }
    }

    public MerchantRecipeList getRecipes(EntityPlayer par1EntityPlayer)
    {
        if (this.buyingList == null)
        {
            this.addDefaultEquipmentAndRecipies(1);
        }

        return this.buyingList;
    }

    private float func_82188_j(float par1)
    {
        float var2 = par1 + this.field_82191_bN;
        return var2 > 0.9F ? 0.9F - (var2 - 0.9F) : var2;
    }

    /**
     * based on the villagers profession add items, equipment, and recipies adds par1 random items to the list of things
     * that the villager wants to buy. (at most 1 of each wanted type is added)
     */
    private void addDefaultEquipmentAndRecipies(int par1)
    {
        if (this.buyingList != null)
        {
            this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
        }
        else
        {
            this.field_82191_bN = 0.0F;
        }

        MerchantRecipeList merchantrecipelist;
        merchantrecipelist = new MerchantRecipeList();
        merchantrecipelist = new MerchantRecipeList();
        //TODO
        //Villager buying
        //Simple: random number of items selling for an emerald - the ending float is the probability of that trade to appear, the higher value, the more common it will be
        addMerchantItem(merchantrecipelist, mod_SCP.Circuit.itemID, this.rand, this.func_82188_j(0.5F));  
        addMerchantItem(merchantrecipelist, mod_SCP.ElectricWool.blockID, this.rand, this.func_82188_j(0.3F));   
        
        //Advanced: random number of items for a random number of emeralds
        merchantrecipelist.add(new MerchantRecipe(new ItemStack(mod_SCP.Circuit, 1 + rand.nextInt(3)), null, new ItemStack(Item.emerald.itemID, 1 + this.rand.nextInt(3), 0)));
        merchantrecipelist.add(new MerchantRecipe(new ItemStack(Item.paper, 3 + rand.nextInt(4)), null, new ItemStack(Item.emerald.itemID, 1 + this.rand.nextInt(2), 0)));
        
        
        //Villager selling
        //Simple: random amount of items buying with an emerald - the ending float is the probability of that trade to appear, the higher value, the more common it will be
        addBlacksmithItem(merchantrecipelist, Item.melon.itemID, this.rand, this.func_82188_j(0.45F));        
        addBlacksmithItem(merchantrecipelist, Item.enderPearl.itemID, this.rand, this.func_82188_j(0.3F));        
        addBlacksmithItem(merchantrecipelist, mod_SCP.Pearl006.itemID, this.rand, this.func_82188_j(0.3F));     
        addBlacksmithItem(merchantrecipelist, mod_SCP.Pearl015.itemID, this.rand, this.func_82188_j(0.35F));     
        addBlacksmithItem(merchantrecipelist, mod_SCP.Pearl019.itemID, this.rand, this.func_82188_j(0.4005F)); 
        
        //Advanced: random amount of items bought with random amounts of emeralds
        merchantrecipelist.add(new MerchantRecipe(new ItemStack(Item.emerald, 2 + rand.nextInt(5)), null, new ItemStack(mod_SCP.L2Keycard.itemID, 1, 0)));
        merchantrecipelist.add(new MerchantRecipe(new ItemStack(Item.diamond, 4 + rand.nextInt(6)), null, new ItemStack(mod_SCP.OmniKeycard.itemID, 1, 0)));
        
        
        //Trade with 2 items
        //Villager changing 10 gravel into a random number of flint
        merchantrecipelist.add(new MerchantRecipe(new ItemStack(Block.blockSteel, rand.nextInt(2)), new ItemStack(Item.diamond), new ItemStack(mod_SCP.DocumentTable)));
        merchantrecipelist.add(new MerchantRecipe(new ItemStack(Item.paper, 1 + rand.nextInt(3)), new ItemStack(Item.enderPearl), new ItemStack(Item.ingotIron.itemID, 1 + this.rand.nextInt(2), 0)));
        //TODO
        int[] var3 = new int[] {mod_SCP.SCP143Axe.itemID, mod_SCP.SCP143Pickaxe.itemID, mod_SCP.SCP143Spade.itemID, mod_SCP.SCP143Sword.itemID};
        int[] var4 = var3;
        int var5 = var3.length;
        int var6 = 0;

        while (true)
        {
            if (var6 >= var5)
            {
                break;
            }

            int var7 = var4[var6];

            if (this.rand.nextFloat() < this.func_82188_j(0.05F))
            {
                merchantrecipelist.add(new MerchantRecipe(new ItemStack(var7, 1, 0), new ItemStack(Item.emerald, 2 + this.rand.nextInt(3), 0), EnchantmentHelper.addRandomEnchantment(this.rand, new ItemStack(var7, 1, 0), 5 + this.rand.nextInt(15))));
            }

            ++var6;
        }

        if (merchantrecipelist.isEmpty())
        {
            addMerchantItem(merchantrecipelist, Item.ingotGold.itemID, this.rand, 1.0F);
        }

        Collections.shuffle(merchantrecipelist);

        if (this.buyingList == null)
        {
            this.buyingList = new MerchantRecipeList();
        }

        for (int j1 = 0; j1 < par1 && j1 < merchantrecipelist.size(); ++j1)
        {
            this.buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(j1));
        }
    }

    @SideOnly(Side.CLIENT)
    public void setRecipes(MerchantRecipeList par1MerchantRecipeList) {}

    /**
     * each recipie takes a random stack from villagerStockList and offers it for 1 emerald
     */
    public static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(par1, par2Random), Item.emerald));
        }
    }

    private static ItemStack getRandomSizedStack(int par0, Random par1Random)
    {
        return new ItemStack(par0, getRandomCountForItem(par0, par1Random), 0);
    }

    /**
     * default to 1, and villagerStockList contains a min/max amount for each index
     */
    private static int getRandomCountForItem(int par0, Random par1Random)
    {
        Tuple var2 = (Tuple)villagerStockList.get(Integer.valueOf(par0));
        return var2 == null ? 1 : (((Integer)var2.getFirst()).intValue() >= ((Integer)var2.getSecond()).intValue() ? ((Integer)var2.getFirst()).intValue() : ((Integer)var2.getFirst()).intValue() + par1Random.nextInt(((Integer)var2.getSecond()).intValue() - ((Integer)var2.getFirst()).intValue()));
    }

    public static void addBlacksmithItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            int var4 = getRandomCountForBlacksmithItem(par1, par2Random);
            ItemStack var5;
            ItemStack var6;

            if (var4 < 0)
            {
                var5 = new ItemStack(Item.emerald.itemID, 1, 0);
                var6 = new ItemStack(par1, -var4, 0);
            }
            else
            {
                var5 = new ItemStack(Item.emerald.itemID, var4, 0);
                var6 = new ItemStack(par1, 1, 0);
            }

            par0MerchantRecipeList.add(new MerchantRecipe(var5, var6));
        }
    }

    private static int getRandomCountForBlacksmithItem(int par0, Random par1Random)
    {
        Tuple var2 = (Tuple)blacksmithSellingList.get(Integer.valueOf(par0));
        return var2 == null ? 1 : (((Integer)var2.getFirst()).intValue() >= ((Integer)var2.getSecond()).intValue() ? ((Integer)var2.getFirst()).intValue() : ((Integer)var2.getFirst()).intValue() + par1Random.nextInt(((Integer)var2.getSecond()).intValue() - ((Integer)var2.getFirst()).intValue()));
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 12)
        {
            this.generateRandomParticles("heart");
        }
        else if (par1 == 13)
        {
            this.generateRandomParticles("angryVillager");
        }
        else if (par1 == 14)
        {
            this.generateRandomParticles("happyVillager");
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * par1 is the particleName
     */
    private void generateRandomParticles(String par1Str)
    {
        for (int var2 = 0; var2 < 5; ++var2)
        {
            double var3 = this.rand.nextGaussian() * 0.02D;
            double var5 = this.rand.nextGaussian() * 0.02D;
            double var7 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(par1Str, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var3, var5, var7);
        }
    }

    public void initCreature()
    {
        SCPVillagerRegistry.applyRandomTrade(this, worldObj.rand);
    }

    public void func_82187_q()
    {
        this.field_82190_bM = true;
    }

    public EntityVillager func_90012_b(EntityAgeable par1EntityAgeable)
    {
        EntityVillager entityvillager = new EntityVillager(this.worldObj);
        entityvillager.initCreature();
        return entityvillager;
    }

    //TODO
    //Here it is decided between what values can the simple version recipes can have their item stack sizes
    static
    {
//        villagerStockList.put(Integer.valueOf(mod_SCP.Circuit.itemID), new Tuple(Integer.valueOf(2), Integer.valueOf(8)));
//        villagerStockList.put(Integer.valueOf(mod_SCP.ElectricWool.blockID), new Tuple(Integer.valueOf(1), Integer.valueOf(12)));
//        blacksmithSellingList.put(Integer.valueOf(Item.melon.itemID), new Tuple(Integer.valueOf(4), Integer.valueOf(8)));
//        blacksmithSellingList.put(Integer.valueOf(Item.enderPearl.itemID), new Tuple(Integer.valueOf(2), Integer.valueOf(5)));
//        blacksmithSellingList.put(Integer.valueOf(mod_SCP.Pearl015.itemID), new Tuple(Integer.valueOf(2), Integer.valueOf(10)));
//        blacksmithSellingList.put(Integer.valueOf(mod_SCP.Pearl019.itemID), new Tuple(Integer.valueOf(1), Integer.valueOf(6)));
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1) 
	{
        return this.func_90012_b(var1);
	}
}
