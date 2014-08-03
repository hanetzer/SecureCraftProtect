package SCPCraft.blocks;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPPosters extends SCPBlockPoster
{
	private int ID;
	public SCPPosters(int par1, int texture, int id)
	{
		super(par1);
		ID = id;
		//blockIndexInTexture = texture;
		disableStats();
	}
	
    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        if(ID==0) ret.add(new ItemStack(mod_SCP.Pearl106));
        if(ID==1) ret.add(new ItemStack(mod_SCP.Pearl173));
        if(ID==2) ret.add(new ItemStack(mod_SCP.Pearl079));
        if(ID==3) ret.add(new ItemStack(mod_SCP.Pearl914));
        if(ID==4) ret.add(new ItemStack(mod_SCP.Pearl372));
    	ret.add(new ItemStack(mod_SCP.ItemSCPPoster));
        return ret;
    }
}
