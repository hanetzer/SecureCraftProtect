package SCPCraft.items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItem458 extends ItemFood
{
	private static boolean alwaysEdible;
	private final float saturationModifier;
	private final int healAmount;

	public SCPItem458(int par1, int par2, float par3, boolean par4)
	{
		super(par1, par2, par3, par4);
		healAmount = 2;
		saturationModifier = 3;
		this.setCreativeTab(mod_SCP.tabSCP);
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 50;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if (entityplayer.canEat(alwaysEdible))
		{
			entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
		}
		return itemstack;
	}

	public int getHealAmount()
	{
		return 1;
	}

	public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		par3EntityPlayer.getFoodStats().addStats(healAmount, saturationModifier);
		super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
	}

	/**
	 * gets the saturationModifier of the ItemFood
	 */
	public float getSaturationModifier()
	{
		return 1;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.eat;
	}

	public SCPItem458 setAlwaysEdible()
	{
		alwaysEdible = true;
		return this;
	}

}