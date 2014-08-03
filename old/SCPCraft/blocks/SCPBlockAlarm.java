package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntityAlarm;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCPBlockAlarm extends BlockContainer
{
    public SCPBlockAlarm(int par1)
    {
        super(par1, Material.iron); //211
		this.setCreativeTab(mod_SCP.tabBlockSCP);
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem(); 
        SCPTileEntityAlarm var7 = (SCPTileEntityAlarm)par1World.getBlockTileEntity(par2, par3, par4);
		if(itemstack != null && (itemstack.itemID == mod_SCP.Wrench.itemID || itemstack.itemID == mod_SCP.GodlyWrench.itemID)) 
		{
			itemstack.damageItem(1, par5EntityPlayer);			
			if(var7.alarmType != 3)var7.alarmType++;
			else var7.alarmType = 0;
			if(!par1World.isRemote)par5EntityPlayer.addChatMessage("AlarmType: " + var7.alarmType);
		}
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, tickRate(par1World));
		return true;
	}

    public int func_85104_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var10 = par9 & 3;
        byte var11 = 0;

        switch (par5)
        {
            case 0:
                var11 = 1;
                break;
            case 1:
                var11 = 0;
                break;
            case 2:
                var11 = 5;
                break;
            case 3:
                var11 = 3;
                break;
            case 4:
                var11 = 4;
                break;
            case 5:
                var11 = 2;
        }

        return var10 | var11;
    }

	public AxisAlignedBB getSelectedBoundingBoxFromPool_do(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.35F, 1.0F);
		if(l == 1) setBlockBounds(0.0F, 0.65F, 0.0F, 1.0F, 1.0F, 1.0F);
		if(l == 2) setBlockBounds(0.0F, 0.0F, 0.0F, 0.35F, 1F, 1.0F);
		if(l == 3) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.35F);
		if(l == 4) setBlockBounds(0.65F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
		if(l == 5) setBlockBounds(0.0F, 0.0F, 0.65F, 1.0F, 1F, 1.0F);
		return super.getSelectedBoundingBoxFromPool((World)world, i, j, k);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);
		if(l == 0) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.35F, 1.0F);
		if(l == 1) setBlockBounds(0.0F, 0.65F, 0.0F, 1.0F, 1.0F, 1.0F);
		if(l == 2) setBlockBounds(0.0F, 0.0F, 0.0F, 0.35F, 1F, 1.0F);
		if(l == 3) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.35F);
		if(l == 4) setBlockBounds(0.65F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
		if(l == 5) setBlockBounds(0.0F, 0.0F, 0.65F, 1.0F, 1F, 1.0F);
	} 

	/**
	 * Adds to the supplied array any colliding bounding boxes with the passed in bounding box. Args: world, x, y, z,
	 * axisAlignedBB, arrayList
	 */
	 public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	 {
		int i = par1World.getBlockMetadata(par2, par3, par4);
		if(i == 0) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.35F, 1.0F);
		if(i == 1) setBlockBounds(0.0F, 0.65F, 0.0F, 1.0F, 1.0F, 1.0F);
		if(i == 2) setBlockBounds(0.0F, 0.0F, 0.0F, 0.35F, 1F, 1.0F);
		if(i == 3) setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 0.35F);
		if(i == 4) setBlockBounds(0.65F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
		if(i == 5) setBlockBounds(0.0F, 0.0F, 0.65F, 1.0F, 1F, 1.0F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
	 }

	 //FIXME
	//public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	//{
	//	if(par2 == 0 && par1 == 1) blockIndexInTexture = 73;    		
	//	else if(par2 == 1 && par1 == 0) blockIndexInTexture = 73;
	//	else if(par2 == 2 && par1 == 5) blockIndexInTexture = 73;
	//	else if(par2 == 3 && par1 == 3) blockIndexInTexture = 73;
	//	else if(par2 == 4 && par1 == 4) blockIndexInTexture = 73;
	//	else if(par2 == 5 && par1 == 2) blockIndexInTexture = 73;
	//	else blockIndexInTexture = 72;
	//	return blockIndexInTexture;
	//}

	public int getRenderType()
	{
		return mod_Others.AlarmID;
	}
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (par5 > 0)
        {
            boolean var6 = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
            SCPTileEntityAlarm var7 = (SCPTileEntityAlarm)par1World.getBlockTileEntity(par2, par3, par4);
            if(var6)
            {
                var7.triggerNote(par1World, par2, par3, par4);
            }
        }
    }

    public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	} 
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }

    @Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new SCPTileEntityAlarm();
	}

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return mod_SCP.Alarm.blockID;
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return mod_SCP.Alarm.blockID;
    }
}
