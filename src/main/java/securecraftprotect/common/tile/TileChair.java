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
import securecraftprotect.common.entity.EntityMountable;
import securecraftprotect.common.tileentity.TileEntityChair;
import securecraftprotect.util.Globals;

import java.util.List;

import static net.minecraft.util.AxisAlignedBB.getBoundingBox;

public class TileChair extends BlockContainer implements ITileFurnature
{
	public int dir;
	private IIcon[] icons;
	private int type;

	public TileChair(Material mat, int type)
	{
		super(mat);
		this.type = type;
		this.setCreativeTab(SCP.scpTile);
	}

	//Use this method for a custom mounting height.
	public static boolean onBlockActivated(World world, int i, int j, int k,
										   EntityPlayer entityplayer, float y)
	{
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, y, 0.5F);
	}

	//This is the main onBlockActivated method. Use it for fully custom
	// mounting positions.
	public static boolean onBlockActivated(World w, int x, int y, int z,
										   EntityPlayer player, float x2,
										   float y2, float z2)
	{
		if (!w.isRemote)
		{
			//Looks for EMBs up to 1 block away from the activated block.
			// Hopefully you didn't set the mounting position further away
			// than this.
			List<EntityMountable> list = w.getEntitiesWithinAABB
					(EntityMountable.class, getBoundingBox
							(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D,
							1D, 1D));
			for (EntityMountable entity : list)
			{
				//Looks for an EMB created by this block.
				if (entity.orgBlockPosX == x
						&& entity.orgBlockPosY == y
						&& entity.orgBlockPosZ == z)
				{
					entity.interact(player);
					return true;
				}
			}
			//Sets coordinates for mounting a north oriented block.
			//Changes coordinates for mounting to compensate for none-north
			float mountingX = 0.0F;
			float mountingY = y + y2;
			float mountingZ = 0.0F;
			// block orientation.
			TileEntityChair chair = (TileEntityChair) w.getTileEntity(x, y, z);
			//int md = world.getBlockMetadata(i, j, k);
			int md = chair.getDir();//SWNE
			if (md == 2)
			{
				mountingX = x + x2;
				mountingZ = z + z2;
			}
			else if (md == 3)
			{
				mountingX = x + 1 - z2;
				mountingZ = z + x2;
			}
			else if (md == 0)
			{
				mountingX = x + 1 - x2;
				mountingZ = z + 1 - z2;
			}
			else if (md == 1)
			{
				mountingX = x + z2;
				mountingZ = z + 1 - x2;
			}
			//Creates a new EMB if none had been created already or if the old
			// one was bugged.
			EntityMountable nemb = new EntityMountable(w,
					player, x, y, z, mountingX, mountingY, mountingZ);
			w.spawnEntityInWorld(nemb);
			nemb.interact(player);
			return true;
		}
		return true;
	}

	public int getType()
	{
		return type;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		switch (type)
		{
			case 0:
				this.icons = new IIcon[types[0].length];
				for (int i = 0; i < icons.length; ++i)
				{
					icons[i] = register.registerIcon("planks_" + types[0][i]);
				}
				break;
			case 1:
				this.icons = new IIcon[types[1].length];
				for (int i = 0; i < icons.length; ++i)
				{
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
		switch (dir)
		{
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
		return onBlockActivated(w, x, y, z, player, 0.5F, 0.5F, 0.5F);
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
		for (int meta = 0; meta < icons.length; ++meta)
		{
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

	public String getUnlocalizedName(ItemStack stack)
	{
		String s = super.getUnlocalizedName();
		String s1 = getTextureName();
		switch (type)
		{
			case 0:
				s1 = types[0][stack.getItemDamage()];
				break;
			case 1:
				s1 = types[1][stack.getItemDamage()];
				break;
		}
		return s + "." + s1;
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

	@Override
	public void breakBlock(World w, int x, int y, int z, Block block, int i)
	{
		super.breakBlock(w, x, y, z, block, i);
		w.removeTileEntity(x, y, z);
	}
}
