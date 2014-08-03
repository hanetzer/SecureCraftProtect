package SCPCraft;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class SCPProperties extends Properties
{
	public SCPProperties()
	{
	}

	public synchronized Enumeration keys()
	{
		Enumeration enumeration = super.keys();
		Vector vector = new Vector();
		for(; enumeration.hasMoreElements(); vector.add(enumeration.nextElement())) { }
		Collections.sort(vector);
		return vector.elements();
	}
}
