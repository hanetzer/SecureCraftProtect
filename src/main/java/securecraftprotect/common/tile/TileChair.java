package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.entity.EntityMountableBlock;
import securecraftprotect.common.tileentity.TileEntityChair;
import securecraftprotect.util.Globals;

import java.util.List;

public class TileChair extends BlockContainer
{
	public String[][] types = {
			{"oak", "spruce", "birch", "acacia", "big_oak"},
			{"stone", "scp:granite", "scp:marble"}
	};
	public int dir;
	private IIcon[] icons;
	private int type;

	public TileChair(Material mat, int type)
	{
		super(mat);
		this.type = type;
		this.setCreativeTab(SCP.scpTile);
	}

	//Use this method for a custom mounting ysize.
	public static boolean onBlockActivated(World world, int x, int y, int z,
										   EntityPlayer player, float f)
	{
		return onBlockActivated(world, x, y, z, player, 0.5F, f, 0.5F, 0, 0,
				0, 0);
	}

	//This is the main onBlockActivated method. Use it for fully custom
	// mounting positions.
	public static boolean onBlockActivated(World w, int i, int j, int k,
										   EntityPlayer player, float x,
										   float y, float z, int north,
										   int south, int east, int west)
	{
		if (!w.isRemote) {
			//Looks for EMBs up to 1 block away from the activated block.
			// Hopefully you didn't set the mounting position further away
			// than this.
			List<EntityMountableBlock> listEMB = w.getEntitiesWithinAABB
					(EntityMountableBlock.class, AxisAlignedBB.getBoundingBox
							(i, j, k, i + 1.0D, j + 1.0D, k + 1.0D).expand(1D,
							1D, 1D));
			for (EntityMountableBlock entitytocheck : listEMB) {
				//Looks for an EMB created by this block.
				if (entitytocheck.getOrgBlockPosX() == i && entitytocheck
						.getOrgBlockPosY() == j && entitytocheck
						.getOrgBlockPosZ() == k) {
					entitytocheck.interact(player);
					return true;
				}
			}
			//Sets coordinates for mounting a north oriented block.
			float mountingX = i + x;
			float mountingY = j + y;
			float mountingZ = k + z;
			//Changes coordinates for mounting to compensate for none-north
			// block orientation.
			if (north != south) {
				int md = w.getBlockMetadata(i, j, k);
				if (md == east) {
					mountingX = i + 1 - z;
					mountingZ = k + x;
				} else if (md == south) {
					mountingX = i + 1 - x;
					mountingZ = k + 1 - z;
				} else if (md == west) {
					mountingX = i + z;
					mountingZ = k + 1 - x;
				}
			}
			//Creates a new EMB if none had been created already or if the old
			// one was bugged.
			EntityMountableBlock nemb = new EntityMountableBlock(w, player, i,
					j, k, mountingX, mountingY, mountingZ);
			w.spawnEntityInWorld(nemb);
			nemb.interact(player);
			return true;
		}
		return true;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		switch (type) {
			case 0:
				this.icons = new IIcon[types[0].length];
				for (int i = 0; i < icons.length; ++i) {
					icons[i] = register.registerIcon("planks_" + types[0][i]);
				}
				break;
			case 1:
				this.icons = new IIcon[types[1].length];
				for (int i = 0; i < icons.length; ++i) {
					icons[i] = register.registerIcon(types[1][i]);
				}
				break;
		}
	}

	public final boolean canPaneConnectBlock(Block block)
	{
		return block instanceof TileChair;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z)
	{
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.5F, 0.9F);
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z,
								EntityLivingBase entity, ItemStack stack)
	{
		int i = MathHelper.floor_double((double) ((entity.rotationYaw * 4F) /
				360F) + 0.5D) & 3;
		TileEntityChair chair = (TileEntityChair) w.getTileEntity(x, y, z);

		chair.setDir(i);
	}

	@Override
	public void addCollisionBoxesToList(World w, int x, int y, int z,
										AxisAlignedBB axis, List list,
										Entity entity)
	{
		TileEntityChair chair = (TileEntityChair) w.getTileEntity(x, y, z);
		int dir = chair.getDir();

		setBlockBounds(0.1F, 0.5F, 0.1F, 0.9F, 0.6F, 0.9F);
		super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
		switch (dir) {
			case 0: //S
				setBlockBounds(0.1F, 0.6F, 0.7F, 0.9F, 1.5F, 0.9F);
				super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
				break;
			case 1: //W
				setBlockBounds(0.1F, 0.6F, 0.1F, 0.2F, 1.5F, 0.9F);
				super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
				break;
			case 2: //N
				setBlockBounds(0.1F, 0.6F, 0.1F, 0.9F, 1.5F, 0.2F);
				super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
				break;
			case 3: //E
				setBlockBounds(0.7F, 0.6F, 0.1F, 0.9F, 1.5F, 0.9F);
				super.addCollisionBoxesToList(w, x, y, z, axis, list, entity);
				break;
		}
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z,
									EntityPlayer player, int dir,
									float par7, float par8, float par9)
	{
		return onBlockActivated(w, x, y, z, player, 0.5F, 0.5F, 0.5F, 0, 0, 0, 0);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[meta];
	}

	public boolean shouldSideBeRendered(IBlockAccess w, int x, int y, int z,
										int side)
	{
		return true;
	}

	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		for (int meta = 0; meta < icons.length; ++meta) {
			list.add(new ItemStack(item, 1, meta));
		}
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderBlockPass()
	{
		return 0;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return Globals.RENDER_CHAIR;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityChair();
	}
}
