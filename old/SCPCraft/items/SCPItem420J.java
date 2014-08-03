package SCPCraft.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem420J extends Item
{
	public SCPItem420J(int par1)
	{
		super(par1);
		setMaxStackSize(1);
		this.setCreativeTab(mod_SCP.tabSCP);
	}

    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        --par1ItemStack.stackSize;
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 30 * 20, 1));
        return par1ItemStack;
    }

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.bow;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		Minecraft mc = ModLoader.getMinecraftInstance();
		par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    public String getTextureFile()
	{
		return "/SCPCraft/textures/SCPItems.png";
	}
}