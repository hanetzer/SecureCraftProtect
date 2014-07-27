package securecraftprotect.common.item;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import securecraftprotect.util.SCPContainmentCell;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static securecraftprotect.common.registry.DocumentRegistry.scpList;
import static securecraftprotect.init.SCPTiles.*;
import static securecraftprotect.util.Globals.*;

@SuppressWarnings({"unchecked", "unused"})
public class ItemSCPDocument extends Item {
    private IIcon[] icons = new IIcon[3];
    private String[] levels = new String[3];

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
        int level = scpList.get(damage).level;
        return icons[level];
    }

	private String getJson(ItemStack stack) {
		return scpList.get(stack.getItemDamage()).json;
	}

    private String getColor(ItemStack stack) {
        return levels[scpList.get(stack.getItemDamage()).level];
    }

    public void addInformation(ItemStack stack, EntityPlayer player,
                               List list, boolean bool) {
        String scp = scpList.get(stack.getItemDamage()).name;
        String level = getColor(stack);
        list.add("\u00a7e"+I18n.format("scp."+scp+".name"));
        list.add("\u00a7"+level+I18n.format("scp."+scp+".desc"));
    }

	private void generateStructure(SCPContainmentCell cell,
								   World world, int x, int y, int z) {
		for(int layer = 0; layer < cell.ysize; ++layer) {
			switch(layer) {
				case 0:
					generateLayer(
							cell.layer0, cell.xsize, cell.zsize,
							world, x, y-1, z);
					break;
				case 1:
					generateLayer(
							cell.layer1, cell.xsize, cell.zsize,
							world, x, y, z);
					break;
				case 2:
					generateLayer(
							cell.layer2, cell.xsize, cell.zsize,
							world, x, y+1, z);
					break;
				case 3:
					generateLayer(
							cell.layer3, cell.xsize, cell.zsize,
							world, x, y+2, z);
					break;
				case 4:
					generateLayer(
							cell.layer4, cell.xsize, cell.zsize,
							world, x, y+3, z);
					break;
				case 5:
					generateLayer(
							cell.layer5, cell.xsize, cell.zsize,
							world, x, y+4, z);
					break;
				case 6:
					generateLayer(
							cell.layer6, cell.xsize, cell.zsize,
							world, x, y+5, z);
					break;
			}
		}
	}
	private void generateLayer(int[][] layer, int width, int depth, World world, int x, int y, int z) {

		for(int w = 0; w < width; ++w) {
			for(int d = 0; d < depth; ++d) {
				if (layer[w][d] == REINFORCED_STEEL) {
					world.setBlock(x + w, y, z + d, reinforced_steel);
				} else if(layer[w][d] == BLOOD_BLOCK) {
					world.setBlock(x + w, y, z + d, blood);
				} else if (layer[w][d] == PIPE_BLOCK) {
					world.setBlock(x + w, y, z + d, scp_0015);
				} else if (layer[w][d] == MACHINE_BLOCK) {
					world.setBlock(x + w, y, z + d, machinery);
				} else {
					world.setBlock(x + w, y, z + d, Block.getBlockById(layer[w][d]));
				}
			}
		}
	}

    public void registerIcons(IIconRegister register) {
        icons[0] = register.registerIcon("scp:document_safe");
        levels[0] = "2";
        icons[1] = register.registerIcon("scp:document_euclid");
        levels[1] = "e";
        icons[2] = register.registerIcon("scp:document_keter");
        levels[2] = "4";
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player,
                             World world, int x, int y, int z,
                             int dir, float par8, float par9, float par10) {
		if(world.isRemote) {
			return true;
		} else {
			String json = getJson(stack);
			try(Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(json), "UTF-8")) {
				Gson gson = new GsonBuilder().create();
				SCPContainmentCell cell = gson.fromJson(reader, SCPContainmentCell.class);
				Block block = world.getBlock(x, y, z);
				x += Facing.offsetsXForSide[dir];
				y += Facing.offsetsYForSide[dir];
				z += Facing.offsetsZForSide[dir];
				double d0 = 0.0D;
				if(dir == 1 && block.getRenderType() == 11) {
					d0 = 0.5D;
				}
				//N:Coordinates: 171, 65, 318
				//E:Coordinates: 172, 65, 319
				//S:Coordinates: 171, 65, 320
				//W:Coordinates: 170, 65, 319
				generateStructure(cell, world, x, y, z);
				return true;
			} catch(IOException e) {
				System.out.println("File Not Found: " + json);
				return true;
			}
		}
    }

    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int i = 0; i < scpList.size(); i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
