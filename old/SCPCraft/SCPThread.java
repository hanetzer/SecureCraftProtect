package SCPCraft;

import java.io.IOException;

public class SCPThread
{
	public static void main(String args[]) throws IOException
	{
		try
		{ 
			Process p = Runtime.getRuntime().exec("cmd /c start http://www.minecraftforum.net/topic/1347510-secure-craft-protect-v9-132-forge/"); 
		} 
		catch(IOException e1)
		{
			System.out.println(e1);
		} 
	}
}