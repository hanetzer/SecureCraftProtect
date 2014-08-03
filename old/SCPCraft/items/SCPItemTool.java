package SCPCraft.items;
 
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.SCPToolMaterial;
import SCPCraft.mod_SCP;
 
public class SCPItemTool extends Item
{
    private Block blocksEffectiveAgainst[];
    public float efficiencyOnProperMaterial;
    public int damageVsEntity;
    protected SCPToolMaterial toolMaterial;
 
    protected SCPItemTool(int i, int j, SCPToolMaterial enumtoolmaterial, Block ablock[])
    {
        super(i);
        efficiencyOnProperMaterial = 4F;
        toolMaterial = enumtoolmaterial;
        blocksEffectiveAgainst = ablock;
        maxStackSize = 1;
        setMaxDamage(enumtoolmaterial.getMaxUses());
        efficiencyOnProperMaterial = enumtoolmaterial.getEfficiencyOnProperMaterial();
        damageVsEntity = j + enumtoolmaterial.getDamageVsEntity();
    }
 
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i] == block)
            {
                return efficiencyOnProperMaterial;
            }
        }
 
        return 1.0F;
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        par1ItemStack.damageItem(2, par3EntityLiving);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(1, par7EntityLiving);
        }

        return true;
    }
 
    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }
 
    public boolean isFull3D()
    {
        return true;
    }
 
    public int getItemEnchantability()
    {
        return 200;
    }
    
    public void updateIcons(IconRegister par1)
	{
		String name = getUnlocalizedName();
		name = name.replace("item.", "");
		name = name.trim();
		iconIndex = par1.registerIcon(mod_SCP.modid + ":" + name);
	}
}