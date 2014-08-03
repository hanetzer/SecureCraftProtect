package SCPCraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntityFlesh;

public class SCPBlockFlesh extends BlockContainer
{
	public SCPBlockFlesh(int par1, int par2)
	{
		super(par1, Material.clay);
		this.setCreativeTab(mod_SCP.tabBlockSCP);
	}
	
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) 
    {
    	SCPTileEntityFlesh tileEntity = (SCPTileEntityFlesh)par1World.getBlockTileEntity(par2, par3, par4);
    	tileEntity.setStep(true);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_SCP.Flesh.blockID;
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }
	
	public TileEntity createNewTileEntity(World var1) 
	{
		return new SCPTileEntityFlesh();
	}
}
