package SCPCraft.renders;
 
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import SCPCraft.mod_SCP;
import SCPCraft.tileentities.SCPTileEntityShelf;

import net.minecraft.block.Block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class SCPRenderShelf extends TileEntitySpecialRenderer {

	public RenderBlocks renderBlocksInstance = new RenderBlocks();
	private Minecraft minecraft = ModLoader.getMinecraftInstance();
	//143
	public Item items[] = {Item.appleGold, Item.appleRed, Item.arrow, Item.axeDiamond, Item.axeGold, Item.axeSteel, Item.axeStone, Item.axeWood, 
			Item.bed, Item.beefCooked, Item.beefRaw, Item.blazePowder, Item.blazeRod, Item.boat, Item.bone, Item.book, Item.bootsChain, Item.bootsDiamond, 
			Item.bootsLeather, Item.bootsSteel, Item.bootsGold, Item.bow, Item.bowlEmpty, Item.bowlSoup, Item.bread,Item.brewingStand, Item.brick, 
			Item.bucketEmpty, Item.bucketWater, Item.bucketLava, Item.bucketMilk, Item.coal, Item.clay, Item.cake, Item.compass, Item.shovelSteel,
			Item.pickaxeSteel, Item.cauldron, Item.chickenCooked, Item.flintAndSteel, Item.diamond, Item.ingotIron, Item.ingotGold, Item.chickenRaw, 
			Item.cookie, Item.doorSteel, Item.doorWood, Item.swordSteel, Item.swordWood, Item.shovelWood, Item.dyePowder, Item.egg, Item.emerald, 
			Item.enderPearl, Item.expBottle, Item.pickaxeWood, Item.eyeOfEnder, Item.feather, Item.axeWood, Item.swordStone, Item.shovelStone, Item.pickaxeStone, 
			Item.fermentedSpiderEye, Item.fireballCharge, Item.swordDiamond, Item.shovelDiamond, Item.fishCooked, Item.fishingRod, Item.fishRaw, 
			Item.flint, Item.pickaxeDiamond, Item.stick, Item.swordGold, Item.ghastTear, Item.glassBottle, Item.goldNugget, Item.gunpowder,
			Item.shovelGold, Item.pickaxeGold, Item.silk, Item.hoeWood, Item.hoeStone, Item.hoeGold, Item.hoeSteel, Item.hoeDiamond, Item.helmetChain, 
			Item.helmetDiamond, Item.helmetGold, Item.helmetLeather, Item.helmetSteel, Item.seeds, Item.wheat, Item.leather, Item.legsChain, 
			Item.legsDiamond, Item.legsLeather, Item.legsSteel, Item.legsGold, Item.lightStoneDust, Item.magmaCream, Item.melon, Item.melonSeeds, 
			Item.minecartCrate, Item.minecartEmpty, Item.minecartPowered, Item.plateLeather, Item.monsterPlacer, Item.map, Item.plateChain, Item.plateSteel,
			Item.plateGold, Item.plateDiamond, Item.porkRaw, Item.netherStalkSeeds, Item.painting, Item.porkCooked, Item.sign, Item.saddle, Item.redstone,
			Item.snowball, Item.reed, Item.pocketSundial, Item.pumpkinSeeds, Item.potion, Item.slimeBall, Item.sugar, Item.shears, Item.rottenFlesh, Item.spiderEye,
			Item.record11, Item.record13, Item.recordBlocks, Item.speckledMelon, Item.writableBook, Item.writtenBook, Item.recordChirp, Item.recordCat, Item.recordFar,
			Item.recordMall, Item.recordMellohi, Item.recordStal, Item.recordStrad, Item.recordWard, Item.redstoneRepeater, Item.paper, Item.emptyMap, 
			Item.itemFrame, Item.flowerPot, Item.firework, Item.fireworkCharge, Item.enchantedBook, Item.carrot, Item.potato, Item.bakedPotato, Item.poisonousPotato, 
			Item.goldenCarrot, Item.skull, Item.netherStar, Item.carrotOnAStick, Item.pumpkinPie};
	
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
	{
		renderShelfAt((SCPTileEntityShelf)tileentity, d, d1, d2, f);		
	}
	
	public boolean isItem(SCPTileEntityShelf tileentity)
	{
		int id = tileentity.item.itemID;
		if (id == new ItemStack(items[0]).itemID || id == new ItemStack(items[1]).itemID || id == new ItemStack(items[2]).itemID || id == new ItemStack(items[3]).itemID ||	id == new ItemStack(items[4]).itemID || id == new ItemStack(items[5]).itemID || id == new ItemStack(items[6]).itemID || id == new ItemStack(items[7]).itemID ||	id == new ItemStack(items[8]).itemID || id == new ItemStack(items[9]).itemID || id == new ItemStack(items[10]).itemID || id == new ItemStack(items[11]).itemID || id == new ItemStack(items[12]).itemID || id == new ItemStack(items[13]).itemID || id == new ItemStack(items[14]).itemID || id == new ItemStack(items[15]).itemID ||	id == new ItemStack(items[16]).itemID || id == new ItemStack(items[17]).itemID || id == new ItemStack(items[18]).itemID || id == new ItemStack(items[19]).itemID ||	id == new ItemStack(items[20]).itemID || id == new ItemStack(items[21]).itemID || id == new ItemStack(items[22]).itemID || id == new ItemStack(items[23]).itemID ||	id == new ItemStack(items[24]).itemID || id == new ItemStack(items[25]).itemID || id == new ItemStack(items[26]).itemID || id == new ItemStack(items[27]).itemID ||	id == new ItemStack(items[28]).itemID || id == new ItemStack(items[29]).itemID || id == new ItemStack(items[30]).itemID || id == new ItemStack(items[31]).itemID ||	id == new ItemStack(items[32]).itemID || id == new ItemStack(items[33]).itemID || id == new ItemStack(items[34]).itemID || id == new ItemStack(items[35]).itemID ||	id == new ItemStack(items[36]).itemID || id == new ItemStack(items[37]).itemID || id == new ItemStack(items[38]).itemID || id == new ItemStack(items[39]).itemID ||	id == new ItemStack(items[40]).itemID || id == new ItemStack(items[41]).itemID || id == new ItemStack(items[42]).itemID || id == new ItemStack(items[43]).itemID ||	id == new ItemStack(items[44]).itemID || id == new ItemStack(items[45]).itemID || id == new ItemStack(items[46]).itemID || id == new ItemStack(items[47]).itemID ||	id == new ItemStack(items[48]).itemID || id == new ItemStack(items[49]).itemID || id == new ItemStack(items[50]).itemID || id == new ItemStack(items[51]).itemID ||	id == new ItemStack(items[52]).itemID || id == new ItemStack(items[53]).itemID || id == new ItemStack(items[54]).itemID || id == new ItemStack(items[55]).itemID ||	id == new ItemStack(items[56]).itemID || id == new ItemStack(items[57]).itemID || id == new ItemStack(items[58]).itemID || id == new ItemStack(items[59]).itemID ||	id == new ItemStack(items[60]).itemID || id == new ItemStack(items[61]).itemID || id == new ItemStack(items[62]).itemID || id == new ItemStack(items[63]).itemID ||	id == new ItemStack(items[64]).itemID || id == new ItemStack(items[65]).itemID || id == new ItemStack(items[66]).itemID || id == new ItemStack(items[67]).itemID ||	id == new ItemStack(items[68]).itemID || id == new ItemStack(items[69]).itemID || id == new ItemStack(items[70]).itemID || id == new ItemStack(items[71]).itemID ||	id == new ItemStack(items[72]).itemID || id == new ItemStack(items[73]).itemID || id == new ItemStack(items[74]).itemID || id == new ItemStack(items[75]).itemID ||	id == new ItemStack(items[76]).itemID || id == new ItemStack(items[77]).itemID || id == new ItemStack(items[78]).itemID || id == new ItemStack(items[79]).itemID ||	id == new ItemStack(items[80]).itemID || id == new ItemStack(items[81]).itemID || id == new ItemStack(items[82]).itemID || id == new ItemStack(items[83]).itemID ||	id == new ItemStack(items[84]).itemID || id == new ItemStack(items[85]).itemID || id == new ItemStack(items[86]).itemID || id == new ItemStack(items[87]).itemID ||	id == new ItemStack(items[88]).itemID || id == new ItemStack(items[89]).itemID || id == new ItemStack(items[90]).itemID || id == new ItemStack(items[91]).itemID ||	id == new ItemStack(items[92]).itemID || id == new ItemStack(items[93]).itemID || id == new ItemStack(items[94]).itemID	|| id == new ItemStack(items[95]).itemID ||	id == new ItemStack(items[96]).itemID || id == new ItemStack(items[97]).itemID || id == new ItemStack(items[98]).itemID || id == new ItemStack(items[99]).itemID ||	id == new ItemStack(items[100]).itemID || id == new ItemStack(items[101]).itemID || id == new ItemStack(items[102]).itemID || id == new ItemStack(items[103]).itemID ||	id == new ItemStack(items[104]).itemID || id == new ItemStack(items[105]).itemID || id == new ItemStack(items[106]).itemID || id == new ItemStack(items[107]).itemID ||	id == new ItemStack(items[108]).itemID || id == new ItemStack(items[109]).itemID || id == new ItemStack(items[110]).itemID || id == new ItemStack(items[111]).itemID ||	id == new ItemStack(items[112]).itemID || id == new ItemStack(items[113]).itemID || id == new ItemStack(items[114]).itemID || id == new ItemStack(items[115]).itemID ||	id == new ItemStack(items[116]).itemID || id == new ItemStack(items[117]).itemID || id == new ItemStack(items[118]).itemID || id == new ItemStack(items[119]).itemID ||	id == new ItemStack(items[120]).itemID || id == new ItemStack(items[121]).itemID || id == new ItemStack(items[122]).itemID || id == new ItemStack(items[123]).itemID ||	id == new ItemStack(items[124]).itemID || id == new ItemStack(items[125]).itemID || id == new ItemStack(items[126]).itemID || id == new ItemStack(items[127]).itemID ||	id == new ItemStack(items[128]).itemID || id == new ItemStack(items[129]).itemID || id == new ItemStack(items[130]).itemID || id == new ItemStack(items[131]).itemID ||	id == new ItemStack(items[132]).itemID || id == new ItemStack(items[133]).itemID || id == new ItemStack(items[134]).itemID || id == new ItemStack(items[135]).itemID ||	id == new ItemStack(items[136]).itemID || id == new ItemStack(items[137]).itemID || id == new ItemStack(items[138]).itemID || id == new ItemStack(items[139]).itemID ||	id == new ItemStack(items[140]).itemID || id == new ItemStack(items[141]).itemID || id == new ItemStack(items[142]).itemID || id == new ItemStack(items[143]).itemID || id == new ItemStack(items[144]).itemID || id == new ItemStack(items[145]).itemID || id == new ItemStack(items[146]).itemID || id == new ItemStack(items[147]).itemID || id == new ItemStack(items[148]).itemID || id == new ItemStack(items[149]).itemID || id == new ItemStack(items[150]).itemID || id == new ItemStack(items[151]).itemID || id == new ItemStack(items[152]).itemID || id == new ItemStack(items[153]).itemID || id == new ItemStack(items[154]).itemID || id == new ItemStack(items[155]).itemID || id == new ItemStack(items[156]).itemID) return true;
		else return false;
	}

	private void renderShelfAt(SCPTileEntityShelf tileentity, double d, double d1, double d2, float f) 
	{
		if(tileentity.item == null) return;
		GL11.glPushMatrix();
		int facing1 = (tileEntityRenderer.worldObj.getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) & 3);
		float pos = 0F;
		if(facing1 == 0)pos = 180F;
		else if (facing1 == 1)pos = 90F;
		else if (facing1 == 2)pos = 0F;
		else if (facing1 == 3)pos = 270F;
		if(tileentity.item.getMaxDamage() > 1){
			renderLivingLabel(tileentity.item.getDisplayName(), d + 0.5D, d1 + 0.95D, d2 + 0.5D, pos);
			renderLivingLabel(tileentity.item.getMaxDamage() - tileentity.item.getItemDamage() + "/" + tileentity.item.getMaxDamage(), d + 0.5D, d1 + 0.85D, d2 + 0.5D, pos);
		}
		else if(tileentity.item.isStackable())renderLivingLabel(tileentity.item.getDisplayName() + " (" + tileentity.item.stackSize + ")", d + 0.5D, d1 + 0.85D, d2 + 0.5D, pos);
		else renderLivingLabel(tileentity.item.getDisplayName(), d + 0.5D, d1 + 0.85D, d2 + 0.5D, pos);	
		if (tileentity.item.itemID < 4096 && !isItem(tileentity) && RenderBlocks.renderItemIn3d(Block.blocksList[tileentity.item.itemID].getRenderType()))
		{
			float blockScale = 0.35F;
			float offset = 0.5F;
			int s = 0;
			int facing = (tileEntityRenderer.worldObj.getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) & 3);
			if(facing == 0) facing = 2;
			else if (facing == 2) facing = 0;
			facing = (facing + 2) % 4;
			if(facing == 1 || facing == 3)s = 1;
			
			if(tileentity.item.itemID != mod_SCP.SCP151.blockID)GL11.glTranslatef((float)d + offset, (float)d1 + offset, (float)d2 + offset);
			else if(s == 1) GL11.glTranslatef((float)d + 0.66F, (float)d1 + 0.6F, (float)d2 + 0.33F);
			else GL11.glTranslatef((float)d + 0.33F, (float)d1 + 0.6F, (float)d2 + 0.33F);
			
			if(tileentity.item.itemID != mod_SCP.SCP151.blockID)GL11.glRotatef(90F * facing, 0.0F, 1.0F, 0F);
			else if(s == 1)GL11.glRotatef(90F, 0.0F, 1.0F, 0F);
			else GL11.glRotatef(180F, 0.0F, 1.0F, 0F);
			
			GL11.glScalef(blockScale,blockScale,blockScale);						
			if (tileentity.item.itemID < 190)
			{
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, tileEntityRenderer.renderEngine.getTexture("/terrain.png"));
			}
			else if(tileentity.item.itemID >= 190 && tileentity.item.itemID < 4096)
			{
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, tileEntityRenderer.renderEngine.getTexture(tileentity.item.getItem().getUnlocalizedName()));
			}

			this.renderBlocksInstance.renderBlockAsItem(Block.blocksList[tileentity.item.itemID], tileentity.item.getItemDamage(), 1F);
		}
		else
		{
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, tileEntityRenderer.renderEngine.getTexture(tileentity.item.getItem().getUnlocalizedName()));
			
			Tessellator tessellator = Tessellator.instance;
			Icon i = tileentity.item.getIconIndex();
			float f0 = i.getMinU();
			float f1 = i.getMaxU();
			float f2 = i.getMinV();
			float f3 = i.getMaxV();

			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float)d, (float)d1, (float)d2);
			GL11.glTranslatef(0.5F, 0.25F, 0.5F);
			int var15;
			
			int facing = (tileEntityRenderer.worldObj.getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) & 3);
			if(facing == 0) facing = 2;
			else if (facing == 2) facing = 0;
			GL11.glRotatef(90F * facing, 0.0F, 1.0F, 0F);
			
			GL11.glTranslatef(-0.2F, 0F, 0F);
			GL11.glScalef(0.4F, 0.4F, 1.0F);
			
			this.renderItem(tessellator, f1, f2, f0, f3);
			
			if (tileentity.item.getItem().requiresMultipleRenderPasses())
            {
                for (var15 = 0; var15 < tileentity.item.getItem().getRenderPasses(tileentity.item.getItemDamage()); ++var15)
                {
                    Icon var16 = tileentity.item.getItem().getIconFromDamageForRenderPass(tileentity.item.itemID, var15);
        			f0 = var16.getMinU();
        			f1 = var16.getMaxU();
        			f2 = var16.getMinV();
        			f3 = var16.getMaxV();
                    float var17 = 1.0F;
                    int var18 = Item.itemsList[tileentity.item.itemID].getColorFromItemStack(tileentity.item, var15);
                    float var19 = (float)(var18 >> 16 & 255) / 255.0F;
                    float var20 = (float)(var18 >> 8 & 255) / 255.0F;
                    float var21 = (float)(var18 & 255) / 255.0F;
                    GL11.glColor4f(var19 * var17, var20 * var17, var21 * var17, 1.0F);
        			this.renderItem(tessellator, f1, f2, f0, f3);
                }
            }
			
			if(tileentity.item.hasEffect())
			{
				GL11.glDepthFunc(GL11.GL_EQUAL);
				GL11.glDisable(GL11.GL_LIGHTING);
				tileEntityRenderer.renderEngine.bindTexture("%blur%/misc/glint.png");
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glColor4f(0.5F, 0.25F, 0.8F, 0.175F);
				GL11.glMatrixMode(GL11.GL_TEXTURE);
				GL11.glPushMatrix();
				float f8 = 0.325F;
				GL11.glScalef(f8, f8, f8);
				float f9 = ((float)(System.currentTimeMillis() % 3000L) / 3000F) * 4F;
				GL11.glTranslatef(f9, 0.0F, 0.0F);
				GL11.glRotatef(-50F, 0.0F, 0.0F, 1.0F);
				this.renderItem(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				GL11.glScalef(f8, f8, f8);
				f9 = ((float)(System.currentTimeMillis() % 4873L) / 4873F) * 4F;
				GL11.glTranslatef(-f9, 0.0F, 0.0F);
				GL11.glRotatef(10F, 0.0F, 0.0F, 1.0F);
				this.renderItem(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
				GL11.glPopMatrix();
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glDepthFunc(GL11.GL_LEQUAL);
			}

		}
        GL11.glPopMatrix();
	}
    protected void renderLivingLabel(String par2Str, double par3, double par5, double par7, float position)
    {
            FontRenderer var12 = this.minecraft.fontRenderer;
            float var13 = 0.75F;
            float var14 = 0.012666668F * var13;
            float var17 = 0F;
            if(var12.getStringWidth(par2Str) > 70)var17 = 0.9F/var12.getStringWidth(par2Str);
            else var17 = var14;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)par3, (float)par5, (float)par7);
            GL11.glNormal3f(0.0F, 0.0F, 0.0F);
            GL11.glRotatef(position, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-var17, -var14, var17);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDepthMask(false);
            byte var16 = 0;
            var12.drawString(par2Str, -var12.getStringWidth(par2Str) / 2, var16, 553648127);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
    }
	
	public void renderItem(Tessellator par1Tessellator, float par2, float par3, float par4, float par5)
    {
        float f = 1.0F;
        float f1 = 0.0625F;
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0F, 0.0F, 1.0F);
        par1Tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, par2, par5);
        par1Tessellator.addVertexWithUV(f, 0.0D, 0.0D, par4, par5);
        par1Tessellator.addVertexWithUV(f, 1.0D, 0.0D, par4, par3);
        par1Tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, par2, par3);
        par1Tessellator.draw();
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0F, 0.0F, -1F);
        par1Tessellator.addVertexWithUV(0.0D, 1.0D, 0.0F - f1, par2, par3);
        par1Tessellator.addVertexWithUV(f, 1.0D, 0.0F - f1, par4, par3);
        par1Tessellator.addVertexWithUV(f, 0.0D, 0.0F - f1, par4, par5);
        par1Tessellator.addVertexWithUV(0.0D, 0.0D, 0.0F - f1, par2, par5);
        par1Tessellator.draw();
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(-1F, 0.0F, 0.0F);

        for (int i = 0; i < 16; i++)
        {
            float f2 = (float)i / 16F;
            float f6 = (par2 + (par4 - par2) * f2) - 0.001953125F;
            float f10 = f * f2;
            par1Tessellator.addVertexWithUV(f10, 0.0D, 0.0F - f1, f6, par5);
            par1Tessellator.addVertexWithUV(f10, 0.0D, 0.0D, f6, par5);
            par1Tessellator.addVertexWithUV(f10, 1.0D, 0.0D, f6, par3);
            par1Tessellator.addVertexWithUV(f10, 1.0D, 0.0F - f1, f6, par3);
        }

        par1Tessellator.draw();
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(1.0F, 0.0F, 0.0F);

        for (int j = 0; j < 16; j++)
        {
            float f3 = (float)j / 16F;
            float f7 = (par2 + (par4 - par2) * f3) - 0.001953125F;
            float f11 = f * f3 + 0.0625F;
            par1Tessellator.addVertexWithUV(f11, 1.0D, 0.0F - f1, f7, par3);
            par1Tessellator.addVertexWithUV(f11, 1.0D, 0.0D, f7, par3);
            par1Tessellator.addVertexWithUV(f11, 0.0D, 0.0D, f7, par5);
            par1Tessellator.addVertexWithUV(f11, 0.0D, 0.0F - f1, f7, par5);
        }

        par1Tessellator.draw();
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0F, 1.0F, 0.0F);

        for (int k = 0; k < 16; k++)
        {
            float f4 = (float)k / 16F;
            float f8 = (par5 + (par3 - par5) * f4) - 0.001953125F;
            float f12 = f * f4 + 0.0625F;
            par1Tessellator.addVertexWithUV(0.0D, f12, 0.0D, par2, f8);
            par1Tessellator.addVertexWithUV(f, f12, 0.0D, par4, f8);
            par1Tessellator.addVertexWithUV(f, f12, 0.0F - f1, par4, f8);
            par1Tessellator.addVertexWithUV(0.0D, f12, 0.0F - f1, par2, f8);
        }

        par1Tessellator.draw();
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0F, -1F, 0.0F);

        for (int l = 0; l < 16; l++)
        {
            float f5 = (float)l / 16F;
            float f9 = (par5 + (par3 - par5) * f5) - 0.001953125F;
            float f13 = f * f5;
            par1Tessellator.addVertexWithUV(f, f13, 0.0D, par4, f9);
            par1Tessellator.addVertexWithUV(0.0D, f13, 0.0D, par2, f9);
            par1Tessellator.addVertexWithUV(0.0D, f13, 0.0F - f1, par2, f9);
            par1Tessellator.addVertexWithUV(f, f13, 0.0F - f1, par4, f9);
        }

        par1Tessellator.draw();
    }

}
