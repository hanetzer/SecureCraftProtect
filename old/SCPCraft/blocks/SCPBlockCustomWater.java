package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import SCPCraft.SCPMaterial;
import SCPCraft.SCPPotion;
import SCPCraft.mod_SCP;

public class SCPBlockCustomWater 
{
	public static class SCP354Flowing extends SCPBlockCustomWaterFlowing 
	{
		public SCP354Flowing(int i) 
		{
			super(i, SCPMaterial.SCP354); 
			this.setCreativeTab(mod_SCP.tabBlockSCP);
			bubbleColor(136D, 0D, 0D);
			disableStats();
		}

		public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4)
		{
			return 0x820e03;
		}

		public int tickRate()
		{
			return 30;
		}

		private boolean isFlammable(World world, int i, int j, int k) 
		{
			return false;
		}
	}

	public static class SCP354Still extends SCPBlockCustomWaterStill 
	{
		public SCP354Still(int i) 
		{
			super(i, SCPMaterial.SCP354);      
			setTickRandomly(true);
			this.setCreativeTab(mod_SCP.tabBlockSCP);
			bubbleColor(136D, 0D, 0D);
			disableStats();
		}
		public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) 
		{
			return 0x820e03;
		}

		public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
		{
			if(entity instanceof EntityPlayer)
			{
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 1));
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.hunger.id, 200, 0));
				((EntityLiving)entity).addPotionEffect(new PotionEffect(SCPPotion.shake.id, 100, 1));
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 3));
			}
		}

		public int tickRate()
		{
			return 30;
		}

		public void updateTick(World world, int i, int j, int k, Random random)
		{
			BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(i, k);
			super.updateTick(world, i, j, k, random);
			if(!world.isRemote)
			{
				if(random.nextInt(600) == 0)
				{
					EntityEnderman pigz = new EntityEnderman(world);
					pigz.setLocationAndAngles(i, j, k, 0, 0);
					world.spawnEntityInWorld(pigz);     			 
				}       
				if(random.nextInt(600) == 0)
				{
					EntitySkeleton pigz = new EntitySkeleton(world);
					pigz.setLocationAndAngles(i, j, k, 0, 0);
					world.spawnEntityInWorld(pigz);     			 
				} 
				if(random.nextInt(600) == 0)
				{
					EntityPigZombie pigz = new EntityPigZombie(world);
					pigz.setLocationAndAngles(i, j, k, 0, 0);
					world.spawnEntityInWorld(pigz);     			 
				}
				if(random.nextInt(600) == 0)
				{
					EntityZombie pigz = new EntityZombie(world);
					pigz.setLocationAndAngles(i, j, k, 0, 0);
					world.spawnEntityInWorld(pigz); 
				}
			}

		}

		private boolean isFlammable(World world, int i, int j, int k) 
		{
			return false;
		}
	}

	public static class SCP006Flowing extends SCPBlockCustomWaterFlowing 
	{
		public SCP006Flowing(int i) 
		{
			super(i, Material.water); 
			this.setCreativeTab(mod_SCP.tabBlockSCP);
			bubbleColor(63D, 205D, 255D);
			disableStats();
		}

		public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4)
		{
			return 0x007FFF;
		}
	}

	public static class SCP006Still extends SCPBlockCustomWaterStill 
	{
		public SCP006Still(int i) 
		{
			super(i, Material.water);      
			this.setCreativeTab(mod_SCP.tabBlockSCP);
			bubbleColor(63D, 205D, 255D);
			disableStats();
		}
		public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) 
		{
			return 0x007FFF;
		}
		public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
		{
			if(entity instanceof EntityLiving)
			{
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 40, 1));
			}
		}
	}
}
