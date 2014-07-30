package securecraftprotect.common.handlers;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;

import static securecraftprotect.util.Globals.*;

public class SCPInputHandler
{
	public static final String[] desc =
			{"key.blinking.desc", "key.blink.desc", "key.doors.desc"};
	public static final int[] keyValues =
			{Keyboard.KEY_N, Keyboard.KEY_B, Keyboard.KEY_V};
	private final KeyBinding[] keys;

	public SCPInputHandler()
	{
		keys = new KeyBinding[desc.length];
		for (int i = 0; i < desc.length; i++) {
			keys[i] = new KeyBinding(desc[i], keyValues[i],
					"key.scp.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyPressed(InputEvent.KeyInputEvent event)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null)
		{
			DataWatcher data = player.getDataWatcher();
			if (keys[KEY_BLINK].isPressed())
			{
				data.updateObject(BLINK, 5);
			}
			if (keys[KEY_BLINKING].isPressed())
			{
				if (data.getWatchableObjectInt(BLINKING) == FALSE)
				{
					data.updateObject(BLINKING, TRUE);
					player.addChatMessage(new ChatComponentText("Blinking enabled"));
				}
				else
				{
					data.updateObject(BLINKING, FALSE);
					data.updateObject(BLINK, MAX_BLINK);
					player.addChatMessage(new ChatComponentText("Blinking disabled"));
				}
			}
		}
	}
}
