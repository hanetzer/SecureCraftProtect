package securecraftprotect.common.handlers;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class SCPInputHandler {
    private Minecraft mc = Minecraft.getMinecraft();
    public static final int KEY_ACTIVATE = 0;
    public static final int KEY_BLINK    = 1;
    public static final int KEY_REMOTE   = 2;
    public static final String[] desc = {"key.activate.desc", "key.blink.desc", "key.doors.desc"};
    public static final int[] keyValues = {Keyboard.KEY_N, Keyboard.KEY_B, Keyboard.KEY_V};
    private final KeyBinding[] keys;

    public SCPInputHandler() {
        keys = new KeyBinding[desc.length];
        for (int i=0; i < desc.length; i++) {
            keys[i] = new KeyBinding(desc[i], keyValues[i], "key.scp.category");
            ClientRegistry.registerKeyBinding(keys[i]);
        }
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (keys[KEY_BLINK].isPressed()) {
            mc.thePlayer.getDataWatcher().updateObject(20, 5);
        }
    }
}
