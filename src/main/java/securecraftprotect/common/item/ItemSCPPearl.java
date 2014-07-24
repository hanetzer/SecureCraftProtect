package securecraftprotect.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import securecraftprotect.SCP;

import java.util.List;

import static securecraftprotect.common.registry.DocumentRegistry.documentList;

public class ItemSCPPearl extends Item {
    private IIcon[] icons;

    public ItemSCPPearl() {
        super();
        setMaxStackSize(1);
        setMaxDamage(0);
        setHasSubtypes(true);
        setCreativeTab(SCP.scpTab);
    }

    public IIcon getIconFromDamage(int damage) {
        return icons[damage];
    }

    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[documentList.size()];
        for (int i = 0; i < documentList.size(); ++i) {
            icons[i]= iconRegister.registerIcon(documentList.get(i).name);
        }
    }

    public String getUnlocalizedName(ItemStack stack) {
        String scp = documentList.get(stack.getItemDamage()).name.replace("scp:", "");
        return super.getUnlocalizedName() + "." + scp;
    }

    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int i = 0; i < documentList.size(); ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
