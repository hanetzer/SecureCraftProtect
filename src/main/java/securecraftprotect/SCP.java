package securecraftprotect;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import securecraftprotect.common.CommonProxy;
import securecraftprotect.common.command.CommandJson;
import securecraftprotect.common.creativetab.SCPItemTab;
import securecraftprotect.common.creativetab.SCPTab;
import securecraftprotect.common.creativetab.SCPTileTab;
import securecraftprotect.common.handlers.BucketHandler;
import securecraftprotect.common.handlers.SCPEventHandler;
import securecraftprotect.common.handlers.packet.PacketPipeline;
import securecraftprotect.core.SCPEntity;
import securecraftprotect.core.SCPItem;
import securecraftprotect.core.SCPTile;
import securecraftprotect.init.SCPItems;
import securecraftprotect.init.SCPTiles;
import securecraftprotect.util.SCPConfig;

import java.io.File;

@SuppressWarnings("unused")
@Mod(
		modid = "scp", name = "SecureCraftProtect", version = "@VERSION@",
		guiFactory = "securecraftprotect.client.gui.SCPGuiFactory")
public class SCP
{
	public static SCPConfig config;
	@SidedProxy(
			clientSide = "securecraftprotect.client.ClientProxy",
			serverSide = "securecraftprotect.common.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs scpTab, scpTile, scpItem;
	public static String configPath;
	public static final PacketPipeline pipe = new PacketPipeline();
	@Mod.Instance("scp")
	private static SCP instance;

	public static SCP instance()
	{
		return instance;
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		configPath = event.getModConfigurationDirectory() + "/securecraftprotect/";
		config = new SCPConfig(new File(configPath + "blink.cfg"));
		SCPConfig.syncConfig(config);
		//config = new Configuration(event.getSuggestedConfigurationFile());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		scpTab = new SCPTab(CreativeTabs.getNextID(), "scpTab");
		scpTile = new SCPTileTab(CreativeTabs.getNextID(), "scpTile");
		scpItem = new SCPItemTab(CreativeTabs.getNextID(), "scpItem");
		SCPEventHandler.init();
		SCPItem.init();
		SCPTile.init();
		SCPEntity.init();
		MinecraftForge.EVENT_BUS.register(BucketHandler.get());
		BucketHandler.get().buckets.put(SCPTiles.acid, SCPItems.bucket);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(instance);
		proxy.init();
		pipe.initialise();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		pipe.postInitialise();
	}

	@Mod.EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandJson());
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equals("scp"))
		{
			SCPConfig.syncConfig(config);
		}
	}
}
