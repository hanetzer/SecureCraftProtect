package SCPCraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCPBlockSlideDoor extends Block
{
	public boolean isActivated = false;
	public SCPBlockSlideDoor(int par1, Material par2Material)
	{
		super(par1, par2Material);
//		blockIndexInTexture = 20;
        this.setTickRandomly(true);
	}

	public void registerIcons(IconRegister par1)
    {
    	blockIcon = par1.registerIcon(mod_SCP.modid + ":" + this.getUnlocalizedName2());
    }

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderBlockPass()
	{
		return 0;
	}

	public boolean canRenderInPass(int pass)
	{
		return true;
	}

	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return mod_Others.SlidingDoorID;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);   
		float var1 = 0.33F, var2 = 0.33F, var3 = 0.66F, var4 = 0.66F, var5 = 1F;
		if(l == 0 || l == 8){var1 = 0F; var3 = 1F;}
		if(l == 1 || l == 9) {var2 = 0F; var4 = 1F;}
		if(l == 2 || l == 10) {var1= 0F; var3 = 1F;}
		if(l == 3 || l == 11) {var2 = 0F; var4 = 1F;}
		if(l == 4 || l == 5 || l == 6 || l == 7 || l == 12 || l == 13 || l == 14 || l == 15) {var1 = 0F; var2 = 0F; var3 = 0F; var4 = 0F; var5 = 0F;}
		return AxisAlignedBB.getAABBPool().getAABB((double)((float)i + var1), (double)j, (double)((float)k + var2), (double)((float)(i + var3)), (double)((float)j + var5), (double)((float)(k + var4)));
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);           
		if(l == 0 || l == 8) setBlockBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);
		if(l == 1 || l == 9) setBlockBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);
		if(l == 2 || l == 10) setBlockBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);
		if(l == 3 || l == 11) setBlockBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);
		if(l == 4 || l == 5 || l == 6 || l == 7 || l == 12 || l == 13 || l == 14 || l == 15) setBlockBounds(0F, 0F, 0F, 0F, 0F, 0F);
	} 
	
	 public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6ArrayList, Entity par7Entity)
	 {
		 int i = par1World.getBlockMetadata(par2, par3, par4);
		 if(i == 0 || i == 8) {
			 setBlockBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);	
			 super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		 }
		 if(i == 1 || i == 9) {
			 setBlockBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);	
			 super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		 }
		 if(i == 2 || i == 10) {
			 setBlockBounds(0F, 0F, 0.33F, 1F, 1F, 0.66F);	
			 super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		 }
		 if(i == 3 || i == 11) {
			 setBlockBounds(0.33F, 0F, 0F, 0.66F, 1F, 1F);	
			 super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList, par7Entity);
		 }
		 if(i == 4 || i == 5 || i == 6 || i == 7 || i == 12 || i == 13 || i == 14 || i == 15) return;
	 }

	 /**
	  * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	  * their own) Args: x, y, z, neighbor blockID
	  */
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	 {
		 int var6 = par1World.getBlockMetadata(par2, par3, par4);
		 boolean var8 = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 + 1, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 - 1, par4);

		 if(!canPlaceBlockAt(par1World, par2, par3, par4))
		 {
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         //    par1World.setBlockWithNotify(par2, par3, par4, 0);
		 }
		 //BOTTOM ACTIVATION 1
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 0 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 6);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 4);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 4 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 2);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 0);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 
		 //BOTTOM ACTIVATION 2
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 1 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 7);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 5);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 5 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 3);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 1);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 
		//TOP ACTIVATION 1
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 2 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 4);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 6);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 6 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 2);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 
		 //TOP ACTIVATION 2
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 3 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 5);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 7);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 7 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 1);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 3);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 

		 //BOTTOM ACTIVATION 1
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 8 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 14);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 12);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 12 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 10);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 8);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 
		 //BOTTOM ACTIVATION 2
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 9 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 15);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 13);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 13 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 11);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 9);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 + 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 
		//TOP ACTIVATION 1
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 10 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 12);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 14);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 14 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 8);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 10);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 
		 //TOP ACTIVATION 2
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 11 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 13);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 15);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 if(par5 > 0 && Block.blocksList[par5].canProvidePower() && var6 == 15 && var8)
		 {
			 par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, this.blockID, 9);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 11);
             par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
             par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		 }
		 
		 //BLOCK DESTROY LOGIC
		 if(var6 == 0 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 2 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 1 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 3 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }		 
		 if(var6 == 4 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 5 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 6 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 7 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);	 		 
		 } 
		 
		 if(var6 == 8 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 10 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 9 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 11 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }		 
		 if(var6 == 12 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 13 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 + 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 14 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);
		 }
		 if(var6 == 15 && par1World.getBlockId(par2, par3, par4) == this.blockID && par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
			 this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			 par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 0);	 		 
		 }
	 
	 }
	 
	 Random rand = new Random();
	 public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	 {
		 int var6 = par1World.getBlockMetadata(par2, par3, par4);
	     if(mod_Others.remoteDoorActivate = true)
	     {
			 if(var6 == 0)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 6);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 4);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }
			 if(var6 == 4)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 2);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 0);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }
			 if(var6 == 1)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 7);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 5);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }
			 if(var6 == 5)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 3);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 1);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }		 
			 if(var6 == 8)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 14);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 12);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }
			 if(var6 == 12)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 10);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 8);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }
			 if(var6 == 9)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 15);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 13);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorOpen", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }
			 if(var6 == 13)
			 {
				 par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, this.blockID, 11);
				 par1World.setBlockMetadataWithNotify(par2, par3, par4, this.blockID, 9);
				 par1World.playSoundEffect(par2, (double)par3 + 0.5D, par4, "sounds.doorClose", 0.5F, par1World.rand.nextFloat() * 0.1F + 0.9F);
			 }
	     }
	 }

	 /**
	  * Returns the ID of the items to drop on destruction.
	  */
	 public int idDropped(int par1, Random par2Random, int par3)
	 {
		 if(par1 == 2 || par1 == 3 || par1 == 6 || par1 == 7 || par1 == 14 || par1 == 15 || par1 == 10 || par1 == 11)return 0;
		 return mod_SCP.SlideDoorItem.itemID;
	 }
	    
	 public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	 {
		 if(par1World.getBlockId(par2, par3 - 1, par4) == 0) return false;
		 return true;
	 }
	 
	 public int tickRate()
	 {
	     return 0;
	 }

	 /**
	  * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
	  * and stop pistons
	  */
	 public int getMobilityFlag()
	 {
		 return 2;
	 }

	 @SideOnly(Side.CLIENT)

	 /**
	  * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	  */
	 public int idPicked(World par1World, int par2, int par3, int par4)
	 {
		 return mod_SCP.SlideDoorItem.itemID;
	 }
}
