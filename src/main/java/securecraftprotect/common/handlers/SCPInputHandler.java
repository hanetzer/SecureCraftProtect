package securecraftprotect.common.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import securecraftprotect.util.Globals;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCPInputHandler
{
    public static final String[] desc =
    { "key.blinking.desc", "key.blink.desc", "key.doors.desc" };
    public static final int[] keyValues =
    { Keyboard.KEY_N, Keyboard.KEY_B, Keyboard.KEY_V };
    private final KeyBinding[] keys;
    
    public SCPInputHandler()
    {
        keys = new KeyBinding[desc.length];
        for (int i = 0; i < desc.length; i++)
        {
            keys[i] = new KeyBinding(desc[i], keyValues[i], "key.scp.category");
            ClientRegistry.registerKeyBinding(keys[i]);
        }
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onKeyPressed(InputEvent.KeyInputEvent event)
    {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (player != null && keys[Globals.KEY_BLINK].isPressed())
        {
            player.getDataWatcher().updateObject(Globals.BLINK, 5);
        }
        if (keys[Globals.KEY_BLINKING].isPressed())
        {
            if (player.getDataWatcher().getWatchableObjectInt(Globals.BLINKING) == 1)
            {
                player.getDataWatcher().updateObject(Globals.BLINKING, 0);
            }
            else
            {
                player.getDataWatcher().updateObject(Globals.BLINKING, 1);
                player.getDataWatcher().updateObject(Globals.BLINK, Globals.MAX_BLINK);
            }
        }
    }
}
