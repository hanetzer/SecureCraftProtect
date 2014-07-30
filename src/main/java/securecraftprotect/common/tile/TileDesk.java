package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import securecraftprotect.SCP;
import securecraftprotect.util.Globals;

import java.util.List;

import static net.minecraftforge.common.util.ForgeDirection.UP;
import static securecraftprotect.util.Globals.*;

public class TileDesk extends Block
{
	public String[][] types = {
			{"oak", "spruce", "birch", "acacia", "big_oak"},
			{"stone", "scp:granite", "scp:marble"}
	};
	public  int type;
	private IIcon[] icons;

	public TileDesk(Material material, int type)
	{
		super(material);
		this.type = type;
		this.setCreativeTab(SCP.scpTile);
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

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.icons[meta];
	}

	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int meta = 0; meta < icons.length; ++meta) {
			list.add(new ItemStack(item, 1, meta));
		}
	}

	public final boolean canPaneConnectToBlock(Block block)
	{
		return block instanceof TileDesk;
	}

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
	{
		return true;
	}

	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y,
										int z, int side)
	{
		return true;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderBlockPass()
	{
		return 0;
	}

	public boolean isBlockSolidOnSide(World world, int x, int y, int z,
									  ForgeDirection side)
	{
		return ((side == UP) || isOpaqueCube());
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return RENDER_DESK;
	}
}
