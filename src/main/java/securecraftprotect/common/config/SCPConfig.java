package securecraftprotect.common.config;

import java.io.File;

public class SCPConfig
{
	public static File blinkConfig;
	public static void init(String configPath)
	{
		blinkConfig = new File(configPath + "blink.cfg");
		SCPConfigBlink.init(blinkConfig);
	}
}
