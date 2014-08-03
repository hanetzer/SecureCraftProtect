package SCPCraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPItemCupFilled extends Item
{
	private int potionId;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;
	private int color;
	private int color2;
	private boolean hasSprinkles;
    @SideOnly(Side.CLIENT)
    private Icon liquid;
    @SideOnly(Side.CLIENT)
    private Icon empty;
    @SideOnly(Side.CLIENT)
    private Icon sparklez;

	/** 
	 * @param par1 The id of the cup
	 * @param col Color of the cup content
	 * @param sprinkles Determines whether the cup has or not sprinkles
	 * @param col2 Color of the sprinkles
	 * @see<b>Colors are expressed in decimals!</b>
	 * @see <i>Example:</i> 0xffffff (white in hex) = 16777215 (white in decimals)
	 */
	public SCPItemCupFilled(int par1, int col, boolean sprinkles, int col2)
	{
		super(par1);
		color = col;
		color2 = col2;
		hasSprinkles = sprinkles;
		setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setCreativeTab(mod_SCP.tabCupsSCP);
	}

	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	public void updateIcons(IconRegister par1)
	{
        this.empty = par1.registerIcon(mod_SCP.modid + ":" + "Cup_Empty");
        this.liquid = par1.registerIcon(mod_SCP.modid + ":" + "Cup_Liquid");
        this.sparklez = par1.registerIcon(mod_SCP.modid + ":" + "Cup_Sparklez");
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}

	//FIXME
	public Icon getIconFromDamageForRenderPass(int par1, int par2)
	{
		super.getIconFromDamageForRenderPass(par1, par2);
		if(par2 == 0)return empty;
		else if(par2 == 1) return liquid;
		else if(hasSprinkles)return sparklez;
		else return liquid;
	}
	
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
		if(par2 == 0)return 16777215;
		else if(par2 == 1)return color;
		else if(hasSprinkles)return color2;
		else return color;
    }
    
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	public int getRenderPasses(int metadata)
	{
		return 3;
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par1ItemStack.stackSize--;

		if (!par2World.isRemote && potionId > 0 && par2World.rand.nextFloat() < potionEffectProbability)
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(potionId, potionDuration * 20, potionAmplifier));

		}

		return new ItemStack(mod_SCP.CupEmpty);
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 40;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public SCPItemCupFilled setPotionEffect(int par1, int par2, int par3, float par4)
	{
		potionId = par1;
		potionDuration = par2;
		potionAmplifier = par3;
		potionEffectProbability = par4;
		return this;
	}
}

