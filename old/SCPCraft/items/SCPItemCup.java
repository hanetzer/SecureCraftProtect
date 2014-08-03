package SCPCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItemCup extends Item
{
    public SCPItemCup(int par1)
    {
        super(par1);
		this.setCreativeTab(mod_SCP.tabCupsSCP);
		//this.setIconIndex(11);
    }
    
    public void updateIcons(IconRegister par1)
	{
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + "Cup_Empty");
	}

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

        if (movingobjectposition == null)
        {
            return par1ItemStack;
        }

        return par1ItemStack;
    }
}