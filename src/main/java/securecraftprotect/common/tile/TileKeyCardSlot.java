package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import securecraftprotect.SCP;
import securecraftprotect.common.item.ItemSCPWrench;
import securecraftprotect.init.SCPItems;
import securecraftprotect.util.Globals;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

public abstract class TileKeyCardSlot extends Block
{
	/**
	 * 0: Front, 1: Top, 2: Sides, 3: top_down, 4: top_up, 5: top_left,
	 * 6: top_right
	 */
	protected IIcon[] icons;

	public TileKeyCardSlot()
	{
		super(Material.circuits);
		setTickRandomly(true);
		this.setCreativeTab(SCP.scpTile);
	}

	public void registerIcons(IIconRegister register)
	{
		icons = new IIcon[7];
		for (int i = 0; i < icons.length; i++)
		{
			switch (i)
			{
				case 0:
					icons[i] = register.registerIcon("scp:keycard_front");
					break;
				case 1:
					icons[i] = register.registerIcon("scp:keycard_top");
					break;
				case 2:
					icons[i] = register.registerIcon("scp:keycard_sides");
					break;
				case 3:
					icons[i] = register.registerIcon("scp:keycard_top_down");
					break;
				case 4:
					icons[i] = register.registerIcon("scp:keycard_top_up");
					break;
				case 5:
					icons[i] = register.registerIcon("scp:keycard_top_left");
					break;
				case 6:
					icons[i] = register.registerIcon("scp:keycard_top_right");
					break;
			}
		}
	}

	//	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	//	{
	//		switch(par2)
	//		{
	//		default:
	//		case 0:
	//		{
	//			switch(par1)
	//			{
	//			case 0: return icons[1];
	//			case 1: return icons[1];
	//			default: return icons[0];
	//			}
	//		}
	//		}
	//	}

	public int getRenderType()
	{
		return Globals.RENDER_KEYCARD;
	}

	public int tickRate()
	{
		return 55;
	}

	public void onBlockClicked(World world, int x, int y, int z,
							   EntityPlayer player)
	{
		this.onBlockActivated(world, x, y, z, player,
				0, 0F, 0F, 0F);
	}

/*	public void updateBlockMetadata(World world, int x, int y, int z,
									int par5, float par6, float par7,
									float par8)
	{
		int var9 = world.getBlockMetadata(x, y, z);
		int var10 = var9 & 8;
		var9 &= 7;
		var9 = -1;

		if (par5 == 0 && world.isBlockNormalCube(x, y + 1, z)) {
			var9 = world.rand.nextBoolean() ? 0 : 7;
		}

		if (par5 == 1 && world.doesBlockHaveSolidTopSurface(x, y - 1, z)) {
			var9 = 5 + world.rand.nextInt(2);
		}

		if (par5 == 2 && world.isBlockNormalCube(x, y, z + 1)) {
			var9 = 4;
		}

		if (par5 == 3 && world.isBlockNormalCube(x, y, z - 1)) {
			var9 = 3;
		}

		if (par5 == 4 && world.isBlockNormalCube(x + 1, y, z)) {
			var9 = 2;
		}

		if (par5 == 5 && world.isBlockNormalCube(x - 1, y, z)) {
			var9 = 1;
		}

		if (var9 == -1) {
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y,
					z), 0);
			world.setBlockMetadataWithNotify(x, y, z, 0, 0x02); //
		} else {
			world.setBlockMetadataWithNotify(x, y, z, var9 + var10, 0x02); //
		}
	}*/

	public void onNeighborBlockChange(World world, int x, int y, int z,
									  Block block)
	{
		if (this.func_150044_m(world, x, y, z)) {
			int meta = world.getBlockMetadata(x, y, z);
			boolean flag = false;

			if (!world.isSideSolid(x - 1, y, z, EAST) && meta == 3) {
				flag = true;
			}

			if (!world.isSideSolid(x + 1, y, z, WEST) && meta == 1) {
				flag = true;
			}

			if (!world.isSideSolid(x, y, z - 1, SOUTH) && meta == 0) {
				flag = true;
			}

			if (!world.isSideSolid(x, y, z + 1, NORTH) && meta == 2) {
				flag = true;
			}

			if (flag) {
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x,
						y, z), 0);
				world.setBlockMetadataWithNotify(x, y, z, 0, 0x02); //
			}
		}
	}

	private boolean func_150044_m(World world, int x, int y, int z)
	{
		if (!this.canPlaceBlockAt(world, x, y, z))
		{
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return (world.isSideSolid(x - 1, y, z, EAST)) ||
				(world.isSideSolid(x + 1, y, z, WEST)) ||
				(world.isSideSolid(x, y, z - 1, SOUTH)) ||
				(world.isSideSolid(x, y, z + 1, NORTH));
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity)
	{
		int l = MathHelper.floor_double((double) ((entity.rotationYaw *
				4F) / 360F) + 0.5D) & 3;
		// +z
		switch (l)
		{
			case 0:
				world.setBlockMetadataWithNotify(x, y, z, 3, 0x02);
				break;
			case 1:
				world.setBlockMetadataWithNotify(x, y, z, 3, 0x02);
				break;
			case 2:
				world.setBlockMetadataWithNotify(x, y, z, 0, 0x02);
				break;
			case 3:
				world.setBlockMetadataWithNotify(x, y, z, 1, 0x02);
				break;
		}
	}

	public boolean onBlockActivated(World world, int x, int y,
									int z, EntityPlayer player,
									int par6, float par7, float par8,
									float par9)
	{
		ItemStack stack = player.inventory.getCurrentItem();
		int i = world.getBlockMetadata(x, y, z);
		int j = i & 7;
		if (world.isRemote) {
			return true;
		} else {
			if (stack != null && (stack.getItem() == SCPItems.keycard)) {
				int k = 8 - (i & 8);
				world.setBlockMetadataWithNotify(x, y, z, j + k,
						0x02); //
				world.playSoundEffect((double) x + 0.5D,
						(double) y + 0.5D, (double) z + 0.5D,
						"random.click", 0.3F, 0.6F);
				this.func_82536_d(world, x, y, z, j);
				world.scheduleBlockUpdate(x, y, z, this,
						this.tickRate());

			} else {
				if (stack != null && (stack.getItem() instanceof ItemSCPWrench))
				{
					world.setBlockMetadataWithNotify(x, y, z, j, 3);
					//world.setBlock
					stack.damageItem(1, player);
					if (world.isRemote) {
						//player.addChatMessage("Keycard Level: 2");
					}

					if (!world.isRemote) {
						//player.addChatMessage("Keycard Level: 2");
					}
				} else {
					if (world.isRemote) {
						//player.addChatMessage("You need a Level 1 " +
						//		"or" +
						//		" higher Keycard to activate.");
					}
					if (!world.isRemote) {
						//player.addChatMessage("You need a Level 1 " +
						//		"or" +
						//		" higher Keycard to activate.");
					}
				}
			}
			world.scheduleBlockUpdate(x, y, z, this, tickRate());
		}
		return true;
	}

	/**
	 * Is this block indirectly powering the block on the specified side
	 */
	public int isProvidingStrongPower(IBlockAccess world, int x,
									  int y, int z, int side)
	{
		int i1 = world.getBlockMetadata(x, y, z);

		if ((i1 & 8) == 0) {
			return 0;
		} else {
			int j1 = i1 & 7;
			return j1 == 5 && side == 1 ? 15 : (j1 == 4 && side == 2 ? 15 :
					(j1 == 3 && side == 3 ? 15 : (j1 == 2 && side == 4 ? 15 :
							(j1 == 1 && side == 5 ? 15 : 0))));
		}
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this
	 * change based on its state.
	 */
	public boolean canProvidePower()
	{
		return true;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int x,
														   int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		int m = l & 7;
		if (m == 0 || m == 4) {
			setBlockBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.25F);
		}
		if (m == 1 || m == 5) {
			setBlockBounds(0.75F, 0.2F, 0.3F, 1.0F, 0.8F, 0.6F);
		}
		if (m == 2 || m == 6) {
			setBlockBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.8F, 1.0F);
		}
		if (m == 3 || m == 7) {
			setBlockBounds(0.0F, 0.2F, 0.33F, 0.25F, 0.8F, 0.66F);
		}
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		int m = l & 7;
		if (m == 0 || m == 4) {
			setBlockBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.25F);
		}
		if (m == 1 || m == 5) {
			setBlockBounds(0.75F, 0.2F, 0.33F, 1.0F, 0.8F, 0.66F);
		}
		if (m == 2 || m == 6) {
			setBlockBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.8F, 1.0F);
		}
		if (m == 3 || m == 7) {
			setBlockBounds(0.0F, 0.2F, 0.33F, 0.25F, 0.8F, 0.66F);
		}
	}

	public IIcon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		int par3 = par2 & 7;
		if (par3 == 0 || par3 == 4) {
			// 1 = top; 0 = bottom; 2 = back; 3 = front; 4 = right; 5 = left
			if (par1 == 3) return icons[0];
			else if (par1 == 1) return icons[4]; //SlotTop1
			else return icons[2];
		}
		if (par3 == 1 || par3 == 5) {
			if (par1 == 4) return icons[0];
			else if (par1 == 1) return icons[6]; //SlotTop3
			else return icons[2];
		}
		if (par3 == 2 || par3 == 6) {
			if (par1 == 2) return icons[0];
			else if (par1 == 1) return icons[3]; //SlotTop
			else return icons[2];
		}
		if (par3 == 3 || par3 == 7) {
			if (par1 == 5) return icons[0];
			else if (par1 == 1) return icons[5]; //SlotTop2
			else return icons[2];
		}
		return icons[0];
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z,
										AxisAlignedBB axis, List list,
										Entity entity)
	{
		int l = world.getBlockMetadata(x, y, z);
		int m = l & 7;
		if (m == 0 || m == 4) {
			setBlockBounds(0.33F, 0.2F, 0.0F, 0.66F, 0.8F, 0.18F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);

			setBlockBounds(0.33F, 0.2F, 0.18F, 0.66F, 0.4F, 0.25F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);
		}
		if (m == 1 || m == 5) {
			setBlockBounds(0.82F, 0.2F, 0.33F, 1.0F, 0.8F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);

			setBlockBounds(0.75F, 0.2F, 0.33F, 0.82F, 0.4F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);
		}
		if (m == 2 || m == 6) {
			setBlockBounds(0.33F, 0.2F, 0.82F, 0.66F, 0.8F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);

			setBlockBounds(0.33F, 0.2F, 0.75F, 0.66F, 0.4F, 0.82F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);
		}
		if (m == 3 || m == 7) {
			setBlockBounds(0.0F, 0.2F, 0.33F, 0.18F, 0.8F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);

			setBlockBounds(0.18F, 0.2F, 0.33F, 0.25F, 0.4F, 0.66F);
			super.addCollisionBoxesToList(world, x, y, z,
					axis, list, entity);
		}
	}

	public int quantityDropped(Random random)
	{
		return 1;
	}

	public int damageDropped(int i)
	{
		return i;
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World world, int x, int y, int z, Block block,
						   int meta)
	{
		if ((meta & 8) > 0) {
			int var7 = meta & 7;
			this.func_82536_d(world, x, y, z, var7);
		}

		super.breakBlock(world, x, y, z, block, meta);
	}

	/**
	 * Is this block powering the block on the specified side
	 */
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2,
									int par3, int par4, int par5)
	{
		return (par1IBlockAccess.getBlockMetadata(par2, par3,
				par4) & 8) > 0 ? 15 : 0;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4,
						   Random par5Random)
	{
		if (!par1World.isRemote) {
			int var6 = par1World.getBlockMetadata(par2, par3, par4);
			par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 & 7,
					0); //
			int var7 = var6 & 7;
			this.func_82536_d(par1World, par2, par3, par4, var7);
		}
	}

	protected void func_82536_d(World world, int x, int y, int z, int par5)
	{
		world.notifyBlocksOfNeighborChange(x, y, z, this);

		switch (par5)
		{
			case 0:
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				break;
			case 1:
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				break;
			case 2:
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
				break;
			case 3:
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				break;
			case 4:
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				break;
			case 5:
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				break;
			case 6:
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
				break;
			case 7:
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				break;
			default:
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);

		}
	}
}
