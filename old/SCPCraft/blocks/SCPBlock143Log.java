package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;

public class SCPBlock143Log extends Block
{
	private Icon[] icons;
    public SCPBlock143Log(int i)
    {
        super(i, Material.wood);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public void registerIcons(IconRegister par1)
	{
		icons = new Icon[2];
		for(int i = 0; i < icons.length; i++)
		{
			switch(i)
			{
			case 0:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SCP143Log_Sides");
				break;
			default:
				icons[i] = par1.registerIcon(mod_SCP.modid + ":SCP143Log_Top");
				break;
			}
		}
	}
    
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		switch(par2)
		{
		default:
		case 0:
		{
			switch(par1)
			{
			case 0: return icons[1];
			case 1: return icons[1];
			default: return icons[0];
			}
		}
		}
	}

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return mod_SCP.SCP143Log.blockID;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        byte byte0 = 4;
        int l = byte0 + 1;
        if(world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l))
        {
            for(int i1 = -byte0; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0; j1 <= byte0; j1++)
                {
                    for(int k1 = -byte0; k1 <= byte0; k1++)
                    {
                        int l1 = world.getBlockId(i + i1, j + j1, k + k1);
                        if(l1 != mod_SCP.SCP143Leaves.blockID)  ///Leaf//////////////
                        {
                            continue;
                        }
                        int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
                        if((i2 & 8) == 0)
                        {
                      //      world.setBlockMetadata(i + i1, j + j1, k + k1, i2 | 8);
                        }
                    }

                }

            }

        }
    }

 /*   public int getBlockTextureFromSideAndMetadata(int i, int j)  ////////////////
    {
    	if(i == 0)
			return 0;
		if(i == 1)
			return 0;
		if(i == 2)
			return 3;
		if(i == 3)
			return 3;
		if(i == 4)
			return 3;
		if(i == 5)
			return 3;
		
        if(j == 1)
        {
            return 116;
        }
        return j != 2 ? 20 : 117;
    }*/

    public int damageDropped(int i)
    {
        return i;
    }
}

