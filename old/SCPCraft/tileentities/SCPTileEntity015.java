package SCPCraft.tileentities;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import SCPCraft.SCPPotion;
import SCPCraft.mod_SCP;

public class SCPTileEntity015 extends TileEntity
{
	public Random rand = new Random();
	private Minecraft minecraft = ModLoader.getMinecraftInstance();
    public SCPTileEntity015()
    {
    }

    public boolean anyPlayerInRange()
    {
        return worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D) != null;
    }

    public void updateEntity()
    {
    	int Potions[] = 
    		{ 
    			Potion.blindness.id, Potion.hunger.id, Potion.confusion.id, Potion.digSlowdown.id, Potion.moveSlowdown.id, Potion.weakness.id, 
    			Potion.poison.id, SCPPotion.shake.id
    		};
    	int Tools[] = 
    		{
    			Item.pickaxeSteel.itemID, Item.pickaxeWood.itemID, Item.pickaxeGold.itemID, Item.pickaxeDiamond.itemID, Item.pickaxeStone.itemID,
    			Item.swordSteel.itemID, Item.swordGold.itemID, Item.swordDiamond.itemID, Item.swordStone.itemID,
    			mod_SCP.SCP143Pickaxe.itemID, mod_SCP.SCP143Sword.itemID, mod_SCP.Wrench.itemID
    		};
    	
        if (!anyPlayerInRange())
        {
            return;
        }
        else
        {
        	for(int tools = 0; tools <= 11; tools++)
        	{
            	if(rand.nextInt(1000) == 0 && minecraft.playerController.isNotCreative() && worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).inventory.hasItem(Tools[tools]))
            	{
                    double d = (float)xCoord;
                    double d1 = (float)yCoord;
                    double d2 = (float)zCoord;
                    for(int var3 = 0; var3 < 50; ++var3){
                    	worldObj.spawnParticle("splash", worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posX, worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posY, worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posZ, 0D, -0.1D, 0D);                	
                    	worldObj.spawnParticle("splash", worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posX, worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posY, worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posZ, 0D, -0.1D, 0D);
                    	worldObj.spawnParticle("splash", worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posX, worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posY, worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).posZ, 0D, -0.1D, 0D);
                    }
                    worldObj.getClosestPlayer((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D).addPotionEffect(new PotionEffect(Potions[rand.nextInt(8)], 200, 1));
            	}
        		
        	}
        }
        super.updateEntity();
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
    }
}

