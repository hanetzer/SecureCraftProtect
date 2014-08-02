package securecraftprotect.common.config;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.logging.log4j.Level;

import java.io.File;
import java.util.Properties;

public class SCPConfigBlink extends Configuration
{
	public static Configuration config;
	public static int BLINK_DW = 31;
	public static boolean BLINK_ENABLED = false;

	public static void init(File configFile)
	{
		config = new Configuration(configFile);
		try
		{
			config.load();
			BLINK_DW = config.getInt("Watcher", "blink", BLINK_DW, 19, 31, "");
			BLINK_ENABLED = config.getBoolean("Enable", "blink", BLINK_ENABLED, "");
		}
		catch (Exception e)
		{
			FMLLog.log(Level.ERROR, "SecureCraftProtect has had a problem loading its config");
			FMLLog.log(Level.ERROR, "Error: ",e);
		}
	}

	public static Configuration getConfig()
	{
		return config;
	}

}
