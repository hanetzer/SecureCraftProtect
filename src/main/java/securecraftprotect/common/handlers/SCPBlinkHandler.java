package securecraftprotect.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;

import static securecraftprotect.util.Globals.*;

@SuppressWarnings("unused")
public class SCPBlinkHandler
{

	@SubscribeEvent
	public void onPlayerUpdate(TickEvent.PlayerTickEvent event)
	{
		if (event.player != null)
		{
			EntityPlayer player = event.player;
			DataWatcher data = player.getDataWatcher();
			if (data.getWatchableObjectInt(BLINKING) == TRUE)
			{
				if (player.isEntityAlive()) {
					int blink = data.getWatchableObjectInt(BLINK);
					data.updateObject(BLINK, blink - 2);
					if (data.getWatchableObjectInt(BLINK) <= 0)
					{
						data.updateObject(BLINK, MAX_BLINK);
					}
				}
			}
			else
			{
				//TEST
			}
		}
	}
}
