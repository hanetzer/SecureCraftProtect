package SCPCraft.items;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem500 extends Item
{
	private int healAmount, id;
	private boolean alwaysEdible;

	public SCPItem500(int par1, int i, int heal)
	{
		super(par1);
		healAmount = heal;
		id = i;
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public int getHealAmount()
	{
		return healAmount;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.block;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		Minecraft mc = ModLoader.getMinecraftInstance();
		if(mc.playerController.isNotCreative())
		{
			par1ItemStack.stackSize--;
			if(id == 0)par3EntityPlayer.heal(healAmount);
			if(id == 1)par3EntityPlayer.setEntityHealth(0);
			par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
		}
		return par1ItemStack;
	}

	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(id == 0)return false;
		else return true;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 0;
	}
}