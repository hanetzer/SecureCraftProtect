package securecraftprotect.common.config;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import securecraftprotect.SCP;

import static cpw.mods.fml.client.event.ConfigChangedEvent.*;

public class SCPConfigHandler
{
	@SubscribeEvent
	public void onConfigChanged(OnConfigChangedEvent event)
	{
		if (event.modID.equals("scp"))
		{
			if (event.configID.equals("blink"))
			{
				SCP.syncConfig(SCPConfigBlink.getConfig());
			}
		}
	}
}
