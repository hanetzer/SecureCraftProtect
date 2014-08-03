package SCPCraft.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import SCPCraft.SCPDamageSource;
import SCPCraft.SCPPotion;
import SCPCraft.mod_SCP;

public class SCPEntity015Projectile extends EntityFireball
{
	/** The x coordinate of the tile entity. */
	public int xCoord;

	public EntityLiving shootingEntity;
	public double accelerationX;
	public double accelerationY;
	public double accelerationZ;
	/** The y coordinate of the tile entity. */
	public int yCoord;

	/** The z coordinate of the tile entity. */
	public int zCoord;

	public SCPEntity015Projectile(World par1World)
	{
		super(par1World);
		this.setSize(0.2125F, 0.2125F);
	}

	public SCPEntity015Projectile(World par1World, EntityLiving par2EntityLiving, double par3, double par5, double par7)
	{
		super(par1World, par2EntityLiving, par3, par5, par7);
		this.setSize(0.2125F, 0.2125F);
	}

	public SCPEntity015Projectile(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
	{
		super(par1World, par2, par4, par6, par8, par10, par12);
		this.setSize(0.2125F, 0.2125F);
	}
    
    public void targetLivings()
    {
    }

	/**
	 * Called when this EntityFireball hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		int Potions[] = 
			{ 
				Potion.blindness.id, Potion.hunger.id, Potion.confusion.id, Potion.digSlowdown.id, Potion.moveSlowdown.id, Potion.weakness.id, 
				Potion.poison.id, SCPPotion.shake.id, Potion.harm.id
			};
		int Tools[] = 
			{
				Item.pickaxeSteel.itemID, Item.pickaxeWood.itemID, Item.pickaxeGold.itemID, Item.pickaxeDiamond.itemID, Item.pickaxeStone.itemID,
				Item.swordSteel.itemID, Item.swordGold.itemID, Item.swordDiamond.itemID, Item.swordStone.itemID,
				mod_SCP.SCP143Pickaxe.itemID, mod_SCP.SCP143Sword.itemID, mod_SCP.Wrench.itemID, Item.bow.itemID, Item.swordWood.itemID
			};

		if (!this.worldObj.isRemote && par1MovingObjectPosition.entityHit != null)
		{
			Minecraft minecraft = ModLoader.getMinecraftInstance();
			EntityPlayer ep = ((EntityPlayer)par1MovingObjectPosition.entityHit);

			if (ep != null)
			{
				ItemStack boots = ep.inventory.armorInventory[0]; 
				ItemStack legs = ep.inventory.armorInventory[1]; 
				ItemStack chest = ep.inventory.armorInventory[2]; 
				ItemStack helm = ep.inventory.armorInventory[3]; 
				if(chest != null && legs != null && boots != null && helm != null)
				{
					if(chest.itemID == mod_SCP.SCP912Shirt.itemID || legs.itemID == mod_SCP.SCP912Pants.itemID || boots.itemID == mod_SCP.SCP912Shoes.itemID || helm.itemID == mod_SCP.SCP912Head.itemID)
					{
						par1MovingObjectPosition.entityHit.attackEntityFrom(SCPDamageSource.pipe, 2*this.worldObj.difficultySetting);
						this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 2.0F, true, true);
					}
					else if(chest.itemID == mod_SCP.ClassDShirt.itemID || legs.itemID == mod_SCP.ClassDPants.itemID || boots.itemID == mod_SCP.ClassDShoes.itemID || helm.itemID == mod_SCP.GasMask.itemID)
					{
						par1MovingObjectPosition.entityHit.attackEntityFrom(SCPDamageSource.pipe, 2*this.worldObj.difficultySetting + 2);
					}
					else
					{
						par1MovingObjectPosition.entityHit.attackEntityFrom(SCPDamageSource.pipe, 2*this.worldObj.difficultySetting);
					}
				}
				else if(chest != null && legs != null && boots != null && helm != null)
				{
					if(chest.itemID == mod_SCP.ClassDShirt.itemID || legs.itemID == mod_SCP.ClassDPants.itemID || boots.itemID == mod_SCP.ClassDShoes.itemID || helm.itemID == mod_SCP.GasMask.itemID)
					{
						par1MovingObjectPosition.entityHit.attackEntityFrom(SCPDamageSource.pipe, 2*this.worldObj.difficultySetting + 2);
					}
				}
				else
				{
					par1MovingObjectPosition.entityHit.attackEntityFrom(SCPDamageSource.pipe, 2*this.worldObj.difficultySetting + 2);
				}
			}

			for(int var3 = 0; var3 < 50; ++var3)
			{
				worldObj.spawnParticle("smoke", (double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D, (double)xCoord + 0.5D, (double)yCoord + 0.5D);                	
				worldObj.spawnParticle("splash", (double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D, (double)xCoord + 0.5D, (double)yCoord + 0.5D);       
				worldObj.spawnParticle("smoke", (double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D, 4D, (double)xCoord + 0.5D, (double)yCoord + 0.5D);       
			}
			for(int tools = 0; tools <= Tools.length - 1; tools++)
			{
				if(ep.inventory.hasItem(Tools[tools]) && minecraft.playerController.isNotCreative())
				{
					ep.addPotionEffect(new PotionEffect(Potions[rand.nextInt(Potions.length)], 200, 1));
				}
			}
		}

		this.setDead();
	}
	
	public void onUpdate()
    {
	   this.setFire(-1);
       super.onUpdate();
       this.setFire(-1);
    }

	/**
	 * Returns true if other Entities should be prevented from moving through this Entity.
	 */
	public boolean canBeCollidedWith()
	{
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	public float getShadowSize()
	{
		return 0.0F;
	}

	public float getBrightness(float par1)
	{
		return 1.0F;
	}

	public int getBrightnessForRender(float par1)
	{
		return 14496512;
	}
}
