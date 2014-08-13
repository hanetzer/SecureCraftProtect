package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import securecraftprotect.SCP;

import java.util.List;

import static securecraftprotect.common.registry.DocumentRegistry.scpList;

@SuppressWarnings("unchecked")
public class ItemSCPPearl extends Item {
    private IIcon[] icons;

    public ItemSCPPearl() {
        super();
        setMaxStackSize(1);
        setMaxDurability(0);
        setHasSubtypes(true);
        setCreativeTab(SCP.scpTab);
    }

    public IIcon getIconFromDamage(int damage) {
        return icons[damage];
    }

    public void registerIcons(IIconRegister register) {
        icons = new IIcon[scpList.size()];
        for (int i = 0; i < scpList.size(); ++i) {
            icons[i] = register.registerIcon("scp:"+scpList.get(i).name);
        }
    }

    public String getItemStackDisplayName(ItemStack stack) {
        String s = "scp."+ scpList.get(stack.getCurrentDurability()).name + ".name";
        String s1 = getUnlocalizedName() + ".name";
        return I18n.format(s) + " " + I18n.format(s1);
    }

    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int i = 0; i < scpList.size(); ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
