package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import securecraftprotect.SCP;
import securecraftprotect.common.tileentity.TileEntitySCP0015;
import securecraftprotect.init.SCPTiles;
import securecraftprotect.util.Globals;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

public class TileSCP0015 extends BlockContainer {
	public Random rand = new Random();

	public TileSCP0015() {
		super(Material.iron);
		this.setCreativeTab(SCP.scpTile);
	}

	public final boolean canPaneConnectToBlock(Block block) {
		return block == this || block == SCPTiles.machinery || block == SCPTiles.toilet;
	}

	public boolean canPaneConnectTo(IBlockAccess world,
									int x, int y, int z, ForgeDirection dir) {
		return canPaneConnectToBlock(world.getBlock(x, y, z)) ||
				world.isSideSolid(x, y, z, dir.getOpposite(), false);
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int i) {
		world.func_147453_f(x, y, z, block);
		super.breakBlock(world, x, y, z, block, i);
	}

	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntitySCP0015();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
									EntityPlayer player, int j,
									float u, float v, float w) {
		int pot[] = {
			Potion.blindness.id, Potion.hunger.id, Potion.confusion.id,
			Potion.digSlowdown.id, Potion.moveSlowdown.id, Potion.weakness.id,
			Potion.poison.id//, SCPPotion.shake.id
		};

		if(world.isRemote) {
			return true;
		} else {
			for(int i = 0; i < 50; ++i) {
				world.spawnParticle("splash",
						player.posX, player.posY, player.posZ, 0D, -0.1D, 0D);
				world.spawnParticle("splash",
						player.posX, player.posY, player.posZ, 0D, -0.1D, 0D);
				world.spawnParticle("splash",
						player.posX, player.posY, player.posZ, 0D, -0.1D, 0D);
			}
			player.addPotionEffect(new PotionEffect(pot[rand.nextInt(pot.length)], 200, 1));
			return true;
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderBlockPass() {
		return 0;
	}
/*
	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int x, int y, int z) {
        boolean flag = this.canPaneConnectToBlock(world.getBlock(x, y, z - 1));
        boolean flag1 = this.canPaneConnectToBlock(world.getBlock(x - 1, y, z));
        boolean flag2 = this.canPaneConnectToBlock(world.getBlock(x + 1, y, z));
        boolean flag3 = this.canPaneConnectToBlock(world.getBlock(x, y, z + 1));
        boolean flag4 = this.canPaneConnectToBlock(world.getBlock(x, y + 1, z));
        boolean flag5 = this.canPaneConnectToBlock(world.getBlock(x, y - 1, z));
        setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
        if (flag1) setBlockBounds(0.0F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
        if (flag) setBlockBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.66F);
        if (flag3) setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 1F);
        if (flag2) setBlockBounds(0.33F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
        if (flag4) setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 1F, 0.66F);
        if (flag5) setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.66F, 0.66F);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }*/

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		boolean north = canPaneConnectTo(world, x, y, z - 1, NORTH);
		boolean south = canPaneConnectTo(world, x, y, z + 1, SOUTH);
		boolean west = canPaneConnectTo(world, x - 1, y, z, WEST);
		boolean east = canPaneConnectTo(world, x + 1, y, z, EAST);
		boolean down = canPaneConnectTo(world, x, y - 1, z, DOWN);
		boolean up = canPaneConnectTo(world, x, y + 1, z, UP);
		setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		if(north) setBlockBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.66F);
		if(south) setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 1F);
		if(west) setBlockBounds(0.0F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		if(east) setBlockBounds(0.33F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
		if(down) setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.66F, 0.66F);
		if(up) setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 1F, 0.66F);
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z,
										AxisAlignedBB axis, List list, Entity entity) {
		boolean flag = this.canPaneConnectToBlock(world.getBlock(x, y, z - 1));
		boolean flag1 = this.canPaneConnectToBlock(world.getBlock(x - 1, y, z));
		boolean flag2 = this.canPaneConnectToBlock(world.getBlock(x + 1, y, z));
		boolean flag3 = this.canPaneConnectToBlock(world.getBlock(x, y, z + 1));
		boolean flag4 = this.canPaneConnectToBlock(world.getBlock(x, y + 1, z));
		boolean flag5 = this.canPaneConnectToBlock(world.getBlock(x, y - 1, z));

		setBlockBounds(0.33F, 0.33F, 0.33F, 0.66F, 0.66F, 0.66F);
		super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);

		if(flag1) {
			setBlockBounds(0.0F, 0.33F, 0.33F, 0.33F, 0.66F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
		if(flag) {
			setBlockBounds(0.33F, 0.33F, 0.0F, 0.66F, 0.66F, 0.33F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
		if(flag3) {
			setBlockBounds(0.33F, 0.33F, 0.66F, 0.66F, 0.66F, 1F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
		if(flag2) {
			setBlockBounds(0.66F, 0.33F, 0.33F, 1F, 0.66F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
		if(flag4) {
			setBlockBounds(0.33F, 0.66F, 0.33F, 0.66F, 1F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
		if(flag5) {
			setBlockBounds(0.33F, 0.0F, 0.33F, 0.66F, 0.33F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
		}
	}

	public boolean canRenderInPass(int pass) {
		return true;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return Globals.RENDER_PIPE;
	}

	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("scp:0015");
	}

	public IIcon getIcon() {
		return this.blockIcon;
	}
}
