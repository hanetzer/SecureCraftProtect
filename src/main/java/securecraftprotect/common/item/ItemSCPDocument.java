package securecraftprotect.common.item;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.util.SCPCell;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static securecraftprotect.common.registry.DocumentRegistry.scpList;

@SuppressWarnings(
{ "unchecked", "unused" })
public class ItemSCPDocument extends Item
{
    private IIcon[] icons = new IIcon[3];
    private String[] levels = new String[3];
    
    public ItemSCPDocument()
    {
        setMaxStackSize(1);
        setMaxDamage(0);
        setHasSubtypes(true);
        this.setCreativeTab(SCP.scpTab);
    }
    
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }
    
    public IIcon getIconFromDamage(int damage)
    {
        int level = scpList.get(damage).level;
        return icons[level];
    }
    
    private String getJson(ItemStack stack)
    {
        return scpList.get(stack.getItemDamage()).json;
    }
    
    private String getColor(ItemStack stack)
    {
        return levels[scpList.get(stack.getItemDamage()).level];
    }
    
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
    {
        String scp = scpList.get(stack.getItemDamage()).name;
        String level = getColor(stack);
        list.add("\u00a7e" + I18n.format("scp." + scp + ".name"));
        list.add("\u00a7" + level + I18n.format("scp." + scp + ".desc"));
    }
    
    private void generateCell(SCPCell cell, World world, int x, int y, int z)
    {
        try
        {
            for (int h = 0; h < cell.content.length; ++h)
            {
                for (int w = 0; w < cell.content[h].length; ++w)
                {
                    for (int d = 0; d < cell.content[h][w].length; ++d)
                    {
                        String uuid = (String) cell.blocks.get(cell.content[h][w][d]);
                        String[] parts = uuid.split(":");
                        Block block = GameRegistry.findBlock(parts[0], parts[1]);
                        world.setBlock(x + h, y + w, z + d, block);
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Found exception: " + e.getLocalizedMessage());
        }
    }
    
    public void registerIcons(IIconRegister register)
    {
        icons[0] = register.registerIcon("scp:document_safe");
        levels[0] = "2";
        icons[1] = register.registerIcon("scp:document_euclid");
        levels[1] = "e";
        icons[2] = register.registerIcon("scp:document_keter");
        levels[2] = "4";
    }
    
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int dir, float par8, float par9, float par10)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            String json = getJson(stack);
            try
            {
                Reader reader = null;
                try
                {
                    reader = new InputStreamReader(this.getClass().getResourceAsStream(json), "UTF-8");
                }
                catch (Exception e)
                {
                    
                }
                if (reader != null)
                {
                    Gson gson = new GsonBuilder().create();
                    SCPCell cell = gson.fromJson(reader, SCPCell.class);
                    Block block = world.getBlock(x, y, z);
                    x += Facing.offsetsXForSide[dir];
                    y += Facing.offsetsYForSide[dir];
                    z += Facing.offsetsZForSide[dir];
                    double d0 = 0.0D;
                    if (dir == 1 && block.getRenderType() == 11)
                    {
                        d0 = 0.5D;
                    }
                    generateCell(cell, world, x, y, z);
                    return true;
                }
            }
            catch (Exception e)
            {
                System.out.println("File Not Found: " + json);
                return false;
            }
        }
        return false;
    }
    
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < scpList.size(); i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
