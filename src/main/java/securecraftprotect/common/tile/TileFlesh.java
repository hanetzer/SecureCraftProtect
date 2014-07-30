package securecraftprotect.common.tile;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntityFlesh;

public class TileFlesh extends BlockContainer
{
	public TileFlesh()
	{
		super(Material.clay);
		this.setCreativeTab(SCP.scpTile);
	}
	
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
    	TileEntityFlesh tile = (TileEntityFlesh)world.getTileEntity(x, y, z);
    	tile.setStep(true);
	}

	public void registerBlockIcons(IIconRegister register)
    {
    	blockIcon = register.registerIcon("scp:flesh");
    }
	
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityFlesh();
	}
}
