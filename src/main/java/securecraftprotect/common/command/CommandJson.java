package securecraftprotect.common.command;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.world.World;
import org.apache.commons.io.IOUtils;
import securecraftprotect.util.SCPCell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static cpw.mods.fml.common.registry.GameRegistry.findUniqueIdentifierFor;

public class CommandJson implements ICommand
{
	private List<String> aliases;
	public CommandJson() {
		this.aliases = new ArrayList<>();
		this.aliases.add("json");
		this.aliases.add("js");
	}
	@Override
	public String getCommandName() {
		return "json";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "json <x> <y> <z> <width> <height> <depth> <name>";
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] argv) {
		if(argv.length == 7) {
			toJson(sender, argv);
		} else if (argv.length == 1) {
			toStructure(sender, argv[0]);
		} else {
			throw new CommandException(getCommandUsage(sender));
		}
	}

	private void toStructure(ICommandSender sender, String json) {
		BufferedReader reader;
		File file = new File(json);
		Gson gson = new Gson();
		World w = sender.getEntityWorld();
		int x = sender.getPlayerCoordinates().posX;
		int y = sender.getPlayerCoordinates().posY;
		int z = sender.getPlayerCoordinates().posZ;
		try {
			reader =Files.newReader(file, Charsets.UTF_8);
			SCPCell tmp = gson.fromJson(reader, SCPCell.class);
			int xCoord = 0, yCoord = 0, zCoord = 0;
			/*for (Array xarray : tmp.content) {
				xCoord++;
				for (Array yarray : xarray ) {
					yCoord++;
					for (int id : yarray) {
						zCoord++;
					}
				}
			}*/
			for(int xstart = 0; xstart < tmp.content.length; ++xstart) {
				for(int ystart = 0; ystart < tmp.content[xstart].length; ++ystart) {
					for(int zstart = 0; zstart < tmp.content[xstart][ystart].length; ++zstart) {
						String uuid = (String)tmp.blocks.get(tmp.content[xstart][ystart][zstart]);
						String[] parts = uuid.split(":");
						String domain = parts[0];
						String name = parts[1];
						int meta = Integer.valueOf(parts[2]);
						Block block = GameRegistry.findBlock(domain, name);
						w.setBlock(x + xstart, y + ystart, z + zstart, block);
						w.setBlockMetadataWithNotify(x + xstart, y + ystart, z+zstart, meta, 0x03);
					}
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void toJson(ICommandSender sender, String[] argv) {
		int[] start = new int[3];
		start[0] = Integer.valueOf(argv[0]);
		start[1] = Integer.valueOf(argv[1]);
		start[2] = Integer.valueOf(argv[2]);
		int xsize = Integer.valueOf(argv[3]);
		int ysize = Integer.valueOf(argv[4]);
		int zsize = Integer.valueOf(argv[5]);
		int[][][] content = new int[xsize][ysize][zsize];
		System.out.printf("Array Size %sx%sx%s\n", xsize, ysize, zsize);
		List blocks = new ArrayList<String>();
		for(int z = start[2]; z < start[2] +zsize; ++z) {
			for(int y = start[1]; y < start[1]+ysize; ++y) {
				for(int x = start[0]; x < start[0]+xsize; ++x) {
					String uuid = getBlockUUID(sender.getEntityWorld(), x, y, z);

					int index = blocks.indexOf(uuid);
					if (index < 0) {
						blocks.add(uuid);
					}
					content[x - start[0]][y - start[1]][z - start[2]] = blocks.indexOf(uuid);
				}
			}
		}
		//write results to file
		SCPCell tmp = new SCPCell();
		tmp.setStart(start[0], start[1], start[2]);
		tmp.setBlocks(blocks);
		tmp.setContent(content);
		Gson gson = new GsonBuilder().create();
		String s = gson.toJson(tmp);
		File file = new File(argv[6] + ".json");
		BufferedWriter writer = null;
		try {
			writer = Files.newWriter(file, Charsets.UTF_8);
			writer.write(s);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(writer);
		}
	}

	private String getBlockUUID(World world, int x, int y, int z) {
		String name = findUniqueIdentifierFor(world.getBlock(x, y, z)).toString();
		int meta = world.getBlockMetadata(x,y,z);
		return name + ":" + meta;
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] argv) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] argv, int i) {
		return false;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
