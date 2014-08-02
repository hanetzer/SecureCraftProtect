package securecraftprotect.util;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class SCPConfig extends Configuration
{
	public static int BLINK_DW = 31;
	public static boolean BLINK_ENABLED = false;
	public SCPConfig(File file)
	{
		super(file, null);
	}

	public static void syncConfig(Configuration config)
	{
		BLINK_DW = config.getInt("BlinkWatcher", "scp.blink", BLINK_DW, 19, 31, "");
		BLINK_ENABLED = config.getBoolean("BlinkEnable", "scp.blink", BLINK_ENABLED, "");
		if (config.hasChanged())
		{
			config.save();
		}
	}
}
