package securecraftprotect.common.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import securecraftprotect.SCP;

public class TileMachine extends Block {
	private IIcon[] icons;

	public TileMachine() {
		super(Material.rock);
		this.setCreativeTab(SCP.scpTile);
	}

	@Override
	public void registerIcons(IIconRegister register) {
		icons = new IIcon[2];

		for(int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon("scp:machine" + i);
		}
	}

	public IIcon getIcon(int side, int meta) {
		switch(meta) {
			case 0: {
				switch(side) {
					case 0:
						return icons[1];
					case 1:
						return icons[1];
					case 4:
						return icons[1];
					default:
						return icons[0];
				}
			}
			default:
				return icons[1];
		}
	}

	public void onBlockPlacedBy(World world, int x, int y, int z,
								EntityLivingBase entity, ItemStack stack) {
		byte meta;
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		switch(l) {
			case 0:
				meta = 2;
				break;
			case 1:
				meta = 5;
				break;
			case 2:
				meta = 3;
				break;
			case 3:
				meta = 4;
				break;
			default:
				meta = 0;
				break;
		}
		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}
}
