package securecraftprotect.common.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import static securecraftprotect.common.registry.DocumentRegistry.*;

import java.util.List;

public class ItemSCPDocument extends Item {
    private IIcon[] itemIcon = new IIcon[3];

    public ItemSCPDocument() {
        setMaxStackSize(1);
        setMaxDamage(0);
        setHasSubtypes(true);
        this.setCreativeTab(SCP.scpTab);
    }

    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    public IIcon getIconFromDamage(int damage) {
        DocumentInfo documentInfo;
        documentInfo = documentList.get(damage);
        return itemIcon[documentInfo.level];
    }

    public void registerIcons(IIconRegister iconRegister) {
        itemIcon[0] = iconRegister.registerIcon("scp:document_safe");
        itemIcon[1] = iconRegister.registerIcon("scp:document_euclid");
        itemIcon[2] = iconRegister.registerIcon("scp:document_keter");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player,
                             World world, int x, int y, int z,
                             int par7, float par8, float par9, float par10) {
        Block block = world.getBlock(x, y, z);
        if (block == Blocks.snow_layer) {
            par7 = 1;
        } else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush
                && (block == null /*|| !Block.blocksList[block].isBlockReplaceable(world, x, y, z)*/))
            y += 1;
        return true;
    }

    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int i = 0; i < documentList.size(); i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
