package securecraftprotect.common.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import securecraftprotect.common.entity.SCPEnumCreatureAttribute;
import securecraftprotect.common.entity.monster.EntitySCP0173;

public class EntitySCP0131 extends EntityTameable {
    public Entity ridingEntity;
    public int foodNum;
    public int tamedNum;

    public EntitySCP0131(World world) {
        super(world);
        setSize(0.9F, 1.3F);
        getNavigator().setAvoidsWater(true);
        tasks.addTask(0, new EntityAITempt(this, 0.25F, Items.gold_ingot, false));
        tasks.addTask(2, aiSit);
        tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10F, 2.0F));
        tasks.addTask(6, new EntityAIMate(this, 1.0D));
        tasks.addTask(7, new EntityAIAttackOnCollide(this, EntitySCP0173.class, 1.0D, false));
        tasks.addTask(8, new EntityAIWander(this, 1.0D));
        tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 10F));
        tasks.addTask(10, new EntityAIWatchClosest(this, EntityClassDMale.class, 10F));
        tasks.addTask(11, new EntityAIWatchClosest(this, EntitySCP0173.class, 10F));
        targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySCP0173.class, 0, true));
        setTamed(false);
    }

    public SCPEnumCreatureAttribute getSCPAttribute() {
        return SCPEnumCreatureAttribute.SCP;
    }

    protected void entityInit() {
        super.entityInit();
    }

    public void onUpdate() {
        super.onUpdate();

        //System.out.println(tamedNum + " | " + foodNum);
    }

//    public int getMaxHealth()
//    {
//        return 20;
//    }

    public boolean isAIEnabled() {
        return true;
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void fall(float f) {
    }

    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("foodnum", foodNum);
        nbt.setInteger("tamednum", tamedNum);
    }

    public double getMountedYOffset() {
        return (double) this.height - 0.82D;
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        tamedNum = compound.getInteger("tamednum");
        foodNum = compound.getInteger("foodnum");
    }

    public boolean interact(EntityPlayer player) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (tamedNum == 0) {
            tamedNum = rand.nextInt(3) + 1;
        }

        if (!isTamed()) {
            //Taming
            if (stack != null && stack.getItem() == Items.gold_ingot && player.getDistanceSqToEntity(this) < 9D) {
                stack.stackSize--;
                foodNum++;
                if (stack.stackSize <= 0) {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }

                if (!worldObj.isRemote && foodNum >= tamedNum) {
                    setTamed(true);
                    this.func_152115_b(player.getUniqueID().toString());
                    aiSit.setSitting(true);
                    worldObj.setEntityState(this, (byte) 7);
                    worldObj.getClosestPlayerToEntity(player, 16.0D).addChatMessage(new ChatComponentText("You have an EyePod now!"));
                }
            }
            return true;
        }
        return super.interact(player);
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal animal) {
        return new EntitySCP0131(worldObj);
    }

    public boolean isWheat(ItemStack stack) {
        return stack.getItem() == Items.gold_ingot;
    }

    public EntityAgeable createChild(EntityAgeable var1) {
        return new EntitySCP0131(worldObj);
    }
}