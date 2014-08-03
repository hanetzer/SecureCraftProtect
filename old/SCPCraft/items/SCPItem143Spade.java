package SCPCraft.items;

import net.minecraft.block.Block;
import SCPCraft.SCPToolMaterial;
import SCPCraft.mod_SCP;
 
public class SCPItem143Spade extends SCPItemTool
{
 
    private static Block blocksEffectiveAgainst[];
 
    public SCPItem143Spade(int i, SCPToolMaterial enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst);
        this.setCreativeTab(mod_SCP.tabItemSCP);
        setMaxDamage(1000);
    }
 
    public boolean canHarvestBlock(Block block)
    {
        if(block == Block.snow)
        {
            return true;
        }
        return block == Block.blockSnow;
    }
 
    static
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium
        });
    }
    
    public String getTextureFile()
	{
		return "/SCPCraft/textures/SCPItems.png";
	}
}