package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.entities.SCPEntity019n2;

public class SCPBlockSpawner extends Block
{
    public static final String[] field_72155_a = new String[] {"moss stone"};

    public SCPBlockSpawner(int par1, int par2)
    {
        super(par1, Material.rock); //1
        this.setHardness(3.0F);
        this.setCreativeTab(mod_SCP.tabBlockSCP);
    }

    public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(Block.cobblestoneMossy.getUnlocalizedName2());
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            SCPEntity019n2 var6 = new SCPEntity019n2(par1World);
            var6.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(var6);
            var6.spawnExplosionParticle();
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Gets the blockID of the block this block is pretending to be according to this block's metadata.
     */
    public static boolean getPosingIdByMetadata(int par0)
    {
        return par0 == Block.cobblestoneMossy.blockID || par0 == Block.cobblestoneMossy.blockID || par0 == Block.cobblestoneMossy.blockID;
    }

    /**
     * Returns the metadata to use when a Silverfish hides in the block. Sets the block to BlockSilverfish with this
     * metadata. It changes the displayed texture client side to look like a normal block.
     */
    public static int getMetadataForBlockType(int par0)
    {
        return par0 == Block.cobblestoneMossy.blockID ? 1 : (par0 == Block.cobblestoneMossy.blockID ? 2 : 0);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        Block var2 = Block.cobblestoneMossy;

        if (par1 == 1)
        {
            var2 = Block.cobblestoneMossy;
        }

        if (par1 == 2)
        {
            var2 = Block.cobblestoneMossy;
        }

        return new ItemStack(var2);
    }
}
