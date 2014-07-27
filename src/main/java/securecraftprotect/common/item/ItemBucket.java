package securecraftprotect.common.item;

import java.io.IOException;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import securecraftprotect.SCP;
import securecraftprotect.init.SCPItems;
import securecraftprotect.init.SCPTiles;
import cpw.mods.fml.common.eventhandler.Event;

public class ItemBucket extends Item
{    
    public ItemBucket()
    {
        this.maxStackSize = 1;
        this.setCreativeTab(SCP.scpTile);
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World par2World, EntityPlayer par3EntityPlayer)
    {
        boolean flag = SCPTiles.acid == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);
        
        if (movingobjectposition == null)
        {
            return stack;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, stack, par2World, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event)) { return stack; }
            
            if (event.getResult() == Event.Result.ALLOW)
            {
                if (par3EntityPlayer.capabilities.isCreativeMode) { return stack; }
                
                if (--stack.stackSize <= 0) { return event.result; }
                
                if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
                {
                    par3EntityPlayer.dropPlayerItemWithRandomChoice(event.result, false);
                }
                
                return stack;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;
                
                if (!par2World.canMineBlock(par3EntityPlayer, i, j, k)) { return stack; }
                
                if (flag)
                {
                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)) { return stack; }
                    
                    Material material = par2World.getBlock(i, j, k).getMaterial();
                    int l = par2World.getBlockMetadata(i, j, k);
                    par2World.setBlockToAir(i, j, k);
                    return this.func_150910_a(stack, par3EntityPlayer, SCPItems.bucket);
                }
                else
                {
                    if (SCPTiles.acid == Blocks.air) { return new ItemStack(Items.bucket); }
                    
                    if (movingobjectposition.sideHit == 0)
                    {
                        --j;
                    }
                    
                    if (movingobjectposition.sideHit == 1)
                    {
                        ++j;
                    }
                    
                    if (movingobjectposition.sideHit == 2)
                    {
                        --k;
                    }
                    
                    if (movingobjectposition.sideHit == 3)
                    {
                        ++k;
                    }
                    
                    if (movingobjectposition.sideHit == 4)
                    {
                        --i;
                    }
                    
                    if (movingobjectposition.sideHit == 5)
                    {
                        ++i;
                    }
                    
                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)) { return stack; }
                    
                    try
                    {
                        if (this.tryPlaceContainedLiquid(par2World, i, j, k, stack) && !par3EntityPlayer.capabilities.isCreativeMode) { return new ItemStack(Items.bucket); }
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            
            return stack;
        }
    }
    
    private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_)
    {
        if (p_150910_2_.capabilities.isCreativeMode)
        {
            return p_150910_1_;
        }
        else if (--p_150910_1_.stackSize <= 0)
        {
            return new ItemStack(p_150910_3_);
        }
        else
        {
            if (!p_150910_2_.inventory.addItemStackToInventory(new ItemStack(p_150910_3_)))
            {
                p_150910_2_.dropPlayerItemWithRandomChoice(new ItemStack(p_150910_3_, 1, 0), false);
            }
            
            return p_150910_1_;
        }
    }
    
    /**
     * Attempts to place the liquid contained inside the bucket.
     * 
     * @throws IOException
     */
    public boolean tryPlaceContainedLiquid(World world, int x, int y, int z, ItemStack stack) throws IOException
    {
        if (SCPTiles.acid == Blocks.air)
        {
            return false;
        }
        else
        {
            Material material = world.getBlock(x, y, z).getMaterial();
            boolean flag = !material.isSolid();
            
            if (!world.isAirBlock(x, y, z) && !flag) return false;
            else
            {
                if (!world.isRemote && flag && !material.isLiquid()) world.func_147480_a(x, y, z, true);
                world.setBlock(x, y, z, SCPTiles.acid, 0, 3);
                return true;
            }
        }
    }
}
