package securecraftprotect.common.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import securecraftprotect.init.SCPItems;

import java.util.Random;

public class TileEntitySCP0015 extends TileEntity {
    public Random rand = new Random();
    private Minecraft mc = Minecraft.getMinecraft();
    private double x = (double)xCoord;
    private double y = (double)yCoord;
    private double z = (double)zCoord;

    public TileEntitySCP0015() {}

    public boolean anyPlayerInRange() {
        return worldObj.getClosestPlayer(x + 0.5D, y + 0.5D, z + 0.5D, 4D) != null;
    }

    public void updateEntity() {
        int potions[] = {
                Potion.blindness.id, Potion.hunger.id, Potion.confusion.id,
                Potion.digSlowdown.id, Potion.moveSlowdown.id, Potion.weakness.id,
                Potion.poison.id//, SCPPotion.shake.id
                };
        Item tools[] = {
                Items.iron_pickaxe, Items.wooden_pickaxe, Items.golden_pickaxe,
                Items.diamond_pickaxe, Items.stone_pickaxe, Items.iron_sword,
                Items.wooden_sword, Items.golden_sword, Items.diamond_sword,
                Items.stone_sword,
                SCPItems.scp0143_pickaxe, SCPItems.scp0143_sword, SCPItems.wrench
        };

        if (!anyPlayerInRange()) {
            return;
        } else {
            for (int i = 0; i <= tools.length; ++i) {
                if (rand.nextInt(1000) == 0)
                    if (mc.playerController.isNotCreative())
                        if (worldObj.getClosestPlayer(x + 0.5D,
                                y + 0.5D,
                                z + 0.5D, 4D).inventory.hasItem(tools[i])) {
                            for (int j = 0; j < 150; ++j) {
                                worldObj.spawnParticle("splash",
                                        worldObj.getClosestPlayer(
                                                x + 0.5D,
                                                y + 0.5D,
                                                z + 0.5D, 4D).posX,
                                        worldObj.getClosestPlayer(
                                                x + 0.5D,
                                                y + 0.5D,
                                                z + 0.5D, 4D).posY,
                                        worldObj.getClosestPlayer(
                                                x + 0.5D,
                                                y + 0.5D,
                                                z + 0.5D, 4D).posZ,
                                        0D, -0.1D, 0D);
                            }
                            worldObj.getClosestPlayer(
                                    x + 0.5D,
                                    y + 0.5D,
                                    z + 0.5D, 4D).addPotionEffect(
                                    new PotionEffect(
                                            potions[rand.nextInt(potions.length)], 200, 1));
                        }

            }
        }
        super.updateEntity();
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }

    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
    }
}

