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
        this.setCreativeTab(SCP.scpItem);
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        boolean flag = SCPTiles.acid == Blocks.air;
        MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(world, player, flag);
        
        if (pos == null)
        {
            return stack;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(player, stack, world, pos);
            if (MinecraftForge.EVENT_BUS.post(event))
			{
				return stack;
			}
            
            if (event.getResult() == Event.Result.ALLOW)
            {
                if (player.capabilities.isCreativeMode) { return stack; }
                
                if (--stack.stackSize <= 0) { return event.result; }
                
                if (!player.inventory.addItemStackToInventory(event.result))
                {
                    player.dropPlayerItemWithRandomChoice(event.result, false);
                }
                
                return stack;
            }
            if (pos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int x = pos.blockX;
                int y = pos.blockY;
                int z = pos.blockZ;
                
                if (!world.canMineBlock(player, x, y, z)) { return stack; }
                
                if (flag)
                {
                    if (!player.canPlayerEdit(x, y, z, pos.sideHit, stack)) { return stack; }
                    
                    Material material = world.getBlock(x, y, z).getMaterial();
                    int l = world.getBlockMetadata(x, y, z);
                    world.setBlockToAir(x, y, z);
                    return this.func_150910_a(stack, player, SCPItems.bucket);
                }
                else
                {
                    if (SCPTiles.acid == Blocks.air) {
						return new ItemStack(Items.bucket);
					}
                    switch (pos.sideHit) {
						case 0:
							--y;
							break;
						case 1:
							++y;
							break;
						case 2:
							--z;
							break;
						case 3:
							++z;
							break;
						case 4:
							--x;
							break;
						case 5:
							++x;
							break;
					}

                    if (!player.canPlayerEdit(x, y, z, pos.sideHit, stack)) {
						return stack;
					}
                    try
                    {
						if (this.tryPlaceContainedLiquid(world, x, y, z, stack)) {
							if (!player.capabilities.isCreativeMode) {
								return new ItemStack(Items.bucket);
							}
						}
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
    
    private ItemStack func_150910_a(ItemStack stack, EntityPlayer player, Item item)
    {
        if (player.capabilities.isCreativeMode)
        {
            return stack;
        }
        else if (--stack.stackSize <= 0)
        {
            return new ItemStack(item);
        }
        else
        {
            if (!player.inventory.addItemStackToInventory(new ItemStack(item)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(item, 1, 0), false);
            }
            
            return stack;
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
