package SCPCraft;

import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SCPCraft_EventSounds
{

	@ForgeSubscribe
	public void onSoundsLoaded(SoundLoadEvent event)
	{
		try
		{
			SoundManager manager = event.manager;
			String[] soundFiles =
				{
					"/SCPCraft/sounds/096Cry.wav", 
					"/SCPCraft/sounds/096Scream.wav", 
					"/SCPCraft/sounds/096Seen.wav", 
					"/SCPCraft/sounds/294use.wav",
					"/SCPCraft/sounds/914use.wav", 
					"/SCPCraft/sounds/AlarmClassic.wav", 
					"/SCPCraft/sounds/AlarmRetro.wav",
					"/SCPCraft/sounds/AlarmScary.wav",
					"/SCPCraft/sounds/AlarmSpeaker.wav",
					"/SCPCraft/sounds/doorClose.wav",
					"/SCPCraft/sounds/doorOpen.wav",
					"/SCPCraft/sounds/drop.wav",
					"/SCPCraft/sounds/heartbeat.wav",
					"/SCPCraft/sounds/MrBrass.wav",
					"/SCPCraft/sounds/Munch.wav",
					"/SCPCraft/sounds/oldman.wav",
					"/SCPCraft/sounds/Roar1.wav",
					"/SCPCraft/sounds/Roar2.wav",
					"/SCPCraft/sounds/rustle1.wav",
					"/SCPCraft/sounds/rustle2.wav",
					"/SCPCraft/sounds/rustle3.wav",
					"/SCPCraft/sounds/SCP789J.wav",
					"/SCPCraft/sounds/sculpture.wav",
					"/SCPCraft/sounds/stairs.wav",
					"/SCPCraft/sounds/Whispers.wav",
					"/SCPCraft/sounds/StepSounds/StepPD1.wav",
					"/SCPCraft/sounds/StepSounds/StepPD2.wav",
					"/SCPCraft/sounds/StepSounds/StepPD3.wav",
					"/SCPCraft/sounds/gameshow/Correct.wav",
					"/SCPCraft/sounds/gameshow/Die.wav",
					"/SCPCraft/sounds/gameshow/Ok.wav",
					"/SCPCraft/sounds/gameshow/Present.wav",
					"/SCPCraft/sounds/gameshow/Time.wav",
					"/SCPCraft/sounds/gameshow/Welcome.wav",
					"/SCPCraft/sounds/gameshow/Win.wav",
					"/SCPCraft/sounds/gameshow/Wrong.wav",
					"/SCPCraft/sounds/StoneDoorOpen.wav",
					"/SCPCraft/sounds/StoneDoorSlam.wav",
					"/SCPCraft/sounds/cowbell.wav",
					"/SCPCraft/sounds/173sound1.wav",
					"/SCPCraft/sounds/173sound2.wav",
					"/SCPCraft/sounds/173sound3.wav"
				};

			for (int i = 0; i < soundFiles.length; i++)
			{
				// remove '/sounds/' portion for the name
				String soundName = soundFiles[i].substring(10);
				manager.soundPoolSounds.addSound(soundName, this.getClass().getResource(soundFiles[i]));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("[SCPCraft] Failed to register one or more sounds.");
		}
		finally
		{
			System.out.println("[SCPCraft] Succesfully installed the sounds!");
		}
	}
}
