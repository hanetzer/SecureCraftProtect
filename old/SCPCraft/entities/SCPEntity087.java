package SCPCraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class SCPEntity087 extends SCPEntity
{
    /** Random offset used in floating behaviour */
    private float heightOffset;

    /** ticks until heightOffset is randomized */
    private int heightOffsetUpdateTime;
    private int field_40152_d;
    private int breakLight;
    private int breakNextLight;
    private boolean canSeeSkyAndDay;
    private boolean destroyPerGo;

    public SCPEntity087(World par1World)
    {
        super(par1World);
        this.heightOffset = 0.5F;
        this.texture = "/SCPCraft/textures/mobs/087.png";
        this.isImmuneToFire = true;
        this.attackStrength = 200;
        this.stepHeight = 0.0F;
        this.moveSpeed = 0.25F;
        this.setSize(1.0F, 2.0F);
        this.experienceValue = 0;
    }

    public int getMaxHealth()
    {
        return 20;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)0));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "sounds.stairs";
    }
    
    protected boolean canDespawn()
    {
        return false;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        return false;
    }

    public int getBrightnessForRender(float par1)
    {
        return 0xf000f0;
    }
    
    public double getDistance(int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = l - i;
        int l1 = i1 - j;
        int i2 = j1 - k;
        return Math.sqrt(k1 * k1 + l1 * l1 + i2 * i2);
    }


    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        return 1.0F;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (!worldObj.isRemote)
        {

            heightOffsetUpdateTime--;

            if (heightOffsetUpdateTime <= 0)
            {
                heightOffsetUpdateTime = 100;
                heightOffset = 0.5F + (float)rand.nextGaussian() * 3F;
            }

        }

        super.onLivingUpdate();
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float f)
    {
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return 0;
    }
   

    public boolean func_40151_ac()
    {
        return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_40150_a(boolean par1)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            byte0 |= 1;
        }
        else
        {
            byte0 &= 0xfe;
        }

        dataWatcher.updateObject(16, Byte.valueOf(byte0));
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        return true;
    }
   

    public void onUpdate()
    {
    	
        destroyPerGo = false;
        moveSpeed = entityToAttack != null ? 7F : 0.3F;
        isJumping = false;
        int i = MathHelper.floor_double(posX);
        int k = MathHelper.floor_double(posY);
        int i1 = MathHelper.floor_double(posZ);

        if (worldObj.isDaytime())
        {
            float f = getBrightness(1.0F);

            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                canSeeSkyAndDay = true;
            }
            else
            {
                canSeeSkyAndDay = false;
            }
        }
        
        for(int m = -2; m <= 2; m++)
        	for(int z = -2; z <= 3; z++)
        		for(int n = -2; n <= 2; n++)
        		{
    		        int met1 = this.worldObj.getBlockMetadata(i + m, k + z, i1 + n);
                    int var11 = this.worldObj.getBlockId(i + m, k + z, i1 + n);
        			if(var11 > 0 && worldObj.getSavedLightValue(EnumSkyBlock.Block, i + m, k + z, i1 + n) >= 1){
                        int var12 = this.worldObj.getBlockMetadata(i + m, k + z, i1 + n);
    			        this.worldObj.playAuxSFX(2001, i + m, k + z, i1 + n, var11 + (met1 << 12));
                        Block.blocksList[var11].dropBlockAsItem(this.worldObj, i + m, k + z, i1 + n, var12, 0);
        				worldObj.setBlockMetadataWithNotify(i + m, k + z, i1 + n, 0, 0);
        			}
        		}


        if (entityToAttack != null && (entityToAttack instanceof EntityPlayer))
        {            
            faceEntity(entityToAttack, 100F, 100F);
        }

        super.onUpdate();
    }
    
}
