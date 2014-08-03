package SCPCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import SCPCraft.blocks.*;
import SCPCraft.entities.*;
import SCPCraft.guis.*;
import SCPCraft.items.*;
import SCPCraft.recipes.*;
import SCPCraft.renders.SCPBlockRenders;
import SCPCraft.renders.SCPRender019;
import SCPCraft.renders.SCPRender261;
import SCPCraft.renders.SCPRender294;
import SCPCraft.renders.SCPRenderRemoteDoorComp;
import SCPCraft.renders.SCPRenderShelf;
import SCPCraft.tileentities.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = mod_SCP.modid, name = "SCPCraft", version = "1.4")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,
clientPacketHandlerSpec =
@SidedPacketHandler(channels = {"SCPCraft" }, packetHandler = SCPClientPacketHandler.class),
serverPacketHandlerSpec =
@SidedPacketHandler(channels = {"SCPCraft" }, packetHandler = SCPServerPacketHandler.class))
/*
 *  SCPCraft made by Phuck_Yu_Too (www.youtube.com/superbowserfreak11)
 */

public class mod_SCP
{
	public static final String modid = "SCPCraft";
	public static String SCPCraftVersion = "SCPCraft v1.3 [1.5.2]";

	// Textures
	public static int Safe = 253;
	public static int Euclid = 254;
	public static int Keter = 255;
	
	//Misc
	public static boolean isActive = true;
	public World worldObj;
	private SCPGuiHandler guiHandler = new SCPGuiHandler();		
	public static final CreativeTabs tabBlockSCP = new SCPBlockTab(12, "scp");
	public static final CreativeTabs tabItemSCP = new SCPItemsTab(13, "scp");
	public static final CreativeTabs tabSCP = new SCPCreativeTab(14, "scp");
	public static final CreativeTabs tabCupsSCP = new SCPCupsTab(15, "scp");
	
	//StepSounds
    public static final SCPStepSoundPocketDimension soundPDFootstep = new SCPStepSoundPocketDimension("pocketDimension", 1.0F, 1F);

    //WorldTypes
   // public static final WorldType SCP167 = new SCPWorldType167(4, "SCP-167");
    
	//Blocks
	public static final Block BloodBlock = new SCPBloodBlock(190).setHardness(1.0F).setUnlocalizedName("Blood Block").setStepSound(Block.soundStoneFootstep).setResistance(2.0F);
	public static final Block Locker = new SCPLockerBlock(191, 23).setHardness(3.0F).setUnlocalizedName("Reinforced Iron").setStepSound(Block.soundMetalFootstep).setResistance(20.0F);
	public static final Block SCP914 = new SCPBlock914(192).setBlockUnbreakable().setHardness(20.0F).setUnlocalizedName("SCP-914").setStepSound(Block.soundMetalFootstep).setResistance(20.0F);
	public static final Block DocumentTable = new SCPBlockDocument(193, false).setHardness(2.5F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SCP Document Crafter");
	public static final Block Machinery = new SCPBlockMachine(194, 21).setHardness(10.0F).setUnlocalizedName("Machine Block").setStepSound(Block.soundMetalFootstep).setResistance(18.0F);
	public static final Block SCP019 = (new SCPBlock019(195, SCPCraft.tileentities.SCPTileEntity019.class)).setHardness(100F).setStepSound(Block.soundMetalFootstep).setResistance(100F).setUnlocalizedName("SCP-019");
	public static final Block SCP294 = new SCPBlock294(196).setHardness(2F).setStepSound(Block.soundMetalFootstep).setResistance(100F).setUnlocalizedName("SCP-294");
	public static final Block SCP261 = new SCPBlock261(197).setHardness(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SCP-261").setResistance(20.0F);
	public static final Block SCP354Still = new SCPBlockCustomWater.SCP354Still(198).setHardness(100F).setLightOpacity(255).setUnlocalizedName("SCP-354 Still");
	public static final Block SCP354Flowing = new SCPBlockCustomWater.SCP354Flowing(199).setHardness(0F).setLightOpacity(255).setUnlocalizedName("SCP-354 Flowing");
	public static final Block KeycardSlot = new SCPBlockKeycardSlot(200, 34).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Keycard Slot");
	public static final Block KeycardSlotLv2 = new SCPBlockKeycardSlotLv2(201, 34).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Keycard Slot Lv2");
	public static final Block KeycardSlotLv3 = new SCPBlockKeycardSlotLv3(202, 34).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Keycard Slot Lv3");
	public static final Block KeycardSlotOmni = new SCPBlockKeycardSlotOmni(203, 34).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Omni Keycard Slot");
	public static final Block SmokeBlock = new SCPSmokeBlock(204, 31).setLightOpacity(255).setLightValue(0F).setHardness(2F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Smoke Block");
	public static final Block CorrodedIron = (new SCPBlockCorrodedIron(205, 22)).setHardness(10.0F).setStepSound(Block.soundMetalFootstep).setResistance(100.0F).setUnlocalizedName("Corroded Iron Block");
	public static final Block SCPspawner = (new SCPBlockSpawner(206, 48)).setHardness(5.0F).setStepSound(soundPDFootstep).setBlockUnbreakable().setResistance(5000.0F).setUnlocalizedName("Pocket Dimension Rock");
	public static final Block Granite = (new SCPBlock(207, 13, Material.rock).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Granite"));
	public static final Block SCP409 = (new SCPBlock409(208, 5).setHardness(6.0F).setResistance(20.0F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("SCP-409"));
	public static final Block SCP310 = (new SCP310Candle(209, 37).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("SCP-310"));
	public static final Block SCP310Fire = (new SCP310Fire(210).setHardness(0.0F).setLightValue(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("SCP-310 Fire"));
	public static final Block ElectricWool = (new SCPBlockElectricWool(211, 64, true).setHardness(3.0F).setStepSound(Block.soundClothFootstep).setResistance(1.0F).setUnlocalizedName("Electric Wool"));
	public static final Block SCP143Leaves = new SCPBlock143Leaves(212).setHardness(0.2F).setStepSound(Block.soundGrassFootstep).setLightOpacity(1).setUnlocalizedName("SCP-143 leaves");
	public static final Block SCP143Log = new SCPBlock143Log(213).setHardness(36.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("SCP-143 Log");
	public static final Block SCP143Sapling = (new SCPBlock143Sapling(214, 4)).setHardness(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("SCP-143 Sapling");
	public static final Block SCP143Planks = (new SCPBlock143Planks(215, 2).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setResistance(1F).setUnlocalizedName("SCP-143 Plank"));
	public static final Block CorrodedDoor = (new SCPBlockCorrodedDoor(216, Material.iron).setHardness(10.0F).setResistance(100.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Corroded Iron Door"));
	public static final Block SCP006Still = new SCPBlockCustomWater.SCP006Still(217).setHardness(100F).setLightOpacity(1).setUnlocalizedName("SCP-006 Still");
	public static final Block SCP006Flowing = new SCPBlockCustomWater.SCP006Flowing(218).setHardness(100F).setLightOpacity(1).setUnlocalizedName("SCP-006 Flowing");
	public static final Block SCP789J = (new SCPBlock789J(219, 38).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setResistance(0.5F).setUnlocalizedName("SCP-789-J"));
	public static final Block SCP015 = (new SCPBlock015(220, 41).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SCP-015"));
	public static final Block SlidingDoor = (new SCPBlockSlideDoor(221, Material.iron).setHardness(5.0F).setResistance(100.0F).setUnlocalizedName("Sliding Door"));
	public static final Block GrateBlock = new SCPBlockGrate(222, 42).setHardness(5.0F).setResistance(8F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Grate Block");
	public static final Block SCP079 = new SCPBlock079(223, 54).setHardness(5.0F).setResistance(8F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SCP-\u00a7k079");
	public static final Block SCP076 = (new SCPBlock076(224, 43, SCPCraft.tileentities.SCPTileEntity076.class).setHardness(10.0F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("SCP-076 Spawner"));
	public static final Block Shelf = (new SCPBlockShelf(225, 60, Material.iron).setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Iron Shelf"));
	//	public static final Block StoneCoffin = (new SCPBlockStoneCoffin(mod_Others.StoneCoffinId, 54).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Stone Coffin"));
	public static final Block Poster = (new SCPBlockPoster(226).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Poster"));
	public static final Block Poster106 = (new SCPPosters(227, 2, 0).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Poster106"));
	public static final Block Poster173 = (new SCPPosters(228, 0, 1).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Poster173"));
	public static final Block Poster079 = (new SCPPosters(229, 4, 2).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Poster079"));
	public static final Block Poster914 = (new SCPPosters(230, 6, 3).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Poster914"));
	public static final Block SCP151 = (new SCPBlock151(231).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("SCP-151"));
	public static final Block Poster372 = (new SCPPosters(232, 10, 4).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Poster372"));
	public static final Block RemoteDoorComputer = (new SCPBlockRemoteDoorComputer(233, 1).setHardness(2.0F).setResistance(3.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Remote Door Computer"));
	public static final Block SCP273 = (new SCPBlock273Pillar(234, 156).setHardness(1F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("SCP-273 Pillar"));
	public static final Block Flesh = (new SCPBlockFlesh(235, 62).setHardness(1F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Flesh"));
	public static final Block Bone = (new SCPBlockBone(236, 63).setHardness(3F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Bone"));
	public static final Block SCP822 = (new SCPBlock822Immature(237, 67).setHardness(1F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("SCP-822"));
	public static final Block SCP822Grown = (new SCPBlock822Mature(238, 67).setHardness(1F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("SCP-822"));
	public static final Block SCP009 = (new SCPBlock009(239, 71).setHardness(1.5F).setResistance(0.2F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("SCP-009"));
	public static final Block Toilet = (new SCPBlockToilet(240, 38).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setResistance(0.5F).setUnlocalizedName("Toilet"));
	public static final Block Alarm = (new SCPBlockAlarm(241).setHardness(5.0F).setResistance(20.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Alarm Block"));
	public static final Block stoneDesk = (new SCPBlockDesk(242, 1, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Stone Table"));
	public static final Block woodDesk = (new SCPBlockDesk(243, 4, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Wooden Table"));
	public static final Block graniteDesk = (new SCPBlockDesk(244, 13, Material.rock).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Granite Table"));
	public static final Block marbleDesk = (new SCPBlockDesk(245, 38, Material.rock).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Marble Table"));
	public static final Block Marble = (new SCPBlock(246, 38, Material.rock).setHardness(1.5F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Marble"));
	public static final Block marbleChair = (new SCPBlockChair(247, 38, Material.rock).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Marble Chair"));
	public static final Block woodenChair = (new SCPBlockChair(248, 4, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Wooden Chair"));
	public static final Block stoneChair = (new SCPBlockChair(249, 1, Material.rock).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Stone Chair"));
	public static final Block SCP513 = new SCPBlock513(250, 15).setHardness(2.0F).setResistance(2.0F).setStepSound(Block.soundAnvilFootstep).setUnlocalizedName("SCP-513");
	public static final Block OakShelf = (new SCPBlockShelf(251, 4, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Oak Wood Shelf"));
	public static final Block SpruceShelf = (new SCPBlockShelf(252, 198, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Spruce Wood Shelf"));
	public static final Block BirchShelf = (new SCPBlockShelf(253, 214, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Birch Wood Shelf"));
	public static final Block JungleShelf = (new SCPBlockShelf(254, 199, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Jungle Wood Shelf"));
	
	//Items
	public static final Item GasMask = (new SCPClassDItemArmor(8000,SCPArmorMaterial.ClassD, ModLoader.addArmor("classd"), 0, tabItemSCP)).setUnlocalizedName("Gas Mask");
	public static final Item ClassDShirt = (new SCPClassDItemArmor(8001,SCPArmorMaterial.ClassD, ModLoader.addArmor("classd"), 1, tabItemSCP)).setUnlocalizedName("Class-D Shirt");
	public static final Item ClassDPants = (new SCPClassDItemArmor(8002,SCPArmorMaterial.ClassD, ModLoader.addArmor("classd"), 2, tabItemSCP)).setUnlocalizedName("Class-D Panties");
	public static final Item ClassDShoes = (new SCPClassDItemArmor(8003,SCPArmorMaterial.ClassD, ModLoader.addArmor("classd"), 3, tabItemSCP)).setUnlocalizedName("Class-D Boots");
	public static final Item Item019 = (new SCPBlockItem(8004, SCP019)).setUnlocalizedName("Monster Pot");
	public static final Item Item294 = (new SCPBlockItem(8005, SCP294)).setUnlocalizedName("SCP-294 Item");
	public static final Item SCP458 = (new SCPItem458(8006, 0, 0, false).setAlwaysEdible().setUnlocalizedName("SCP-458"));
	public static final Item SCP912Head = (new SCPClassDItemArmor(8007,SCPArmorMaterial.SCP912, ModLoader.addArmor("912"), 0, tabSCP)).setUnlocalizedName("SCP-912 Helmet");
	public static final Item SCP912Shirt = (new SCPClassDItemArmor(8008,SCPArmorMaterial.SCP912, ModLoader.addArmor("912"), 1, tabSCP)).setUnlocalizedName("SCP-912 Shirt");
	public static final Item SCP912Pants = (new SCPClassDItemArmor(8009,SCPArmorMaterial.SCP912, ModLoader.addArmor("912"), 2, tabSCP)).setUnlocalizedName("SCP-912 Pants");
	public static final Item SCP912Shoes = (new SCPClassDItemArmor(8010,SCPArmorMaterial.SCP912, ModLoader.addArmor("912"), 3, tabSCP)).setUnlocalizedName("SCP-912 Shoes");
	public static final Item SCP217 = (new SCPItem217(8011, -1).setUnlocalizedName("SCP-217"));
	public static final Item VirusPig = (new SCP217Pig(8012, 0xff7f7f).setUnlocalizedName("Pig DNA With Clockwork Virus"));
	public static final Item VirusSpider = (new SCP217Spider(8013, 0x3e0000).setUnlocalizedName("Spider DNA With Clockwork Virus"));
	public static final Item VirusZombie = (new SCP217Zombie(8014, 0x0c5900).setUnlocalizedName("Zombie DNA With Clockwork Virus"));
	public static final Item Item261 = (new SCPBlockItem(8015, SCP261)).setUnlocalizedName("SCP-261 Item");
	public static final Item Wrench = (new SCPItemWrench(8016, 0).setUnlocalizedName("Wrench"));
	public static final Item VirusCow = (new SCP217Cow(8017, 0x7f3300).setUnlocalizedName("Cow DNA With Clockwork Virus"));
	public static final Item L1Keycard = (new SCPItemL1Keycard(8018).setUnlocalizedName("\u00a7eKeycard Lv1"));
	public static final Item L2Keycard = (new SCPItemL1Keycard(8019).setUnlocalizedName("\u00a76Keycard Lv2"));
	public static final Item L3Keycard = (new SCPItemL1Keycard(8020).setUnlocalizedName("\u00a74Keycard Lv3"));
	public static final Item OmniKeycard = (new SCPItemL1Keycard(8021).setUnlocalizedName("\u00a79Omni Keycard"));		
	public static final Item SCP500G = (new SCPItem500(8022, 0, 20).setUnlocalizedName("SCP-500").setMaxStackSize(16));
	public static final Item SCP500B = (new SCPItem500(8023, 1, 0).setUnlocalizedName("SCP-500").setMaxStackSize(1));
	public static final Item GodlyWrench = (new SCPItemWrench(8024, 1).setUnlocalizedName("Wrench"));
	public static final Item SCP420J = (new SCPItem420J(8025).setUnlocalizedName("SCP-420-J"));
	public static final Item TothBrush = (new SCPItemTothBrush(8026, EnumToolMaterial.EMERALD).setUnlocalizedName("SCP-063"));
	public static final SCPItemJewelry SCP427 = (SCPItemJewelry) (new SCPItemJewelry(8027, 1, 500, true, EnumRarity.rare).setUnlocalizedName("SCP-427"));
	public static final Item SCP143Pickaxe = (new SCPItem143PickAxe(8028, SCPToolMaterial.SCP143)).setUnlocalizedName("SCP-143 Pickaxe");
	public static final Item SCP143Spade = (new SCPItem143Spade(8029, SCPToolMaterial.SCP143)).setUnlocalizedName("SCP-143 Spade");
	public static final Item SCP143Sword = (new SCPItem143Sword(8030, SCPToolMaterial.SCP143)).setUnlocalizedName("SCP-143 Sword");
	public static final Item SCP143Axe = (new SCPItem143Axe(8031, SCPToolMaterial.SCP143)).setUnlocalizedName("SCP-143 Axe");
	public static final Item SCP1023ARC = (new SCPItem1023ARC(8032).setUnlocalizedName("SCP-1023-ARC"));
	public static final Item CorrodedDoorItem = (new SCPItemCorrodedDoor(8033, Material.iron).setUnlocalizedName("Corroded Iron Door"));
	public static final Item InfraRedGlasses = (new SCPItemInfraRedGlasses(8034,SCPArmorMaterial.ClassD, ModLoader.addArmor("infrared"), 0)).setUnlocalizedName("Infrared Glasses");
	public static final Item SCP50AEJ = (new SCPItem50AEJ(8035).setUnlocalizedName("SCP-50-AE-J"));
	public static final Item VirusCreeper = (new SCP217Creeper(8036, 0x00b60e).setUnlocalizedName("Creeper DNA With Clockwork Virus"));
	public static final Item SCP1025 = (new SCPItem1025(8037).setUnlocalizedName("SCP-1025"));
	public static final Item SlideDoorItem = (new SCPItemSlideDoor(8038, Material.iron).setUnlocalizedName("Sliding Door"));
	public static final Item SCP109 = (new SCPItem109(8039).setUnlocalizedName("SCP-109"));
	public static final Item ItemSCPPoster = (new SCPItemPoster(8040).setUnlocalizedName("SCP Poster"));
	public static final Item Circuit = new SCPItemObject(8041).setUnlocalizedName("Circuit");
	public static final Item VirusTestificate = new SCP217Testificate(8042, 0xc18f66).setUnlocalizedName("Testificate DNA With Clockwork Virus");
	//public static final Item AtomicGrenade = new SCPItemAtomicGrenade(8043).10).setUnlocalizedName("Throwing");
	public static final Item Record106 = (new SCPItemRecord(8044, "106", "GlennLeroi").setUnlocalizedName("SCP Record"));
	public static final Item Record173 = (new SCPItemRecord(8045, "173", "GlennLeroi").setUnlocalizedName("SCP Record"));
	public static final Item SCP000J = (new SCPItem000J(8046).setUnlocalizedName("SCP-000-J"));
	public static final SCP143Bucket SCP143Bucket = (SCP143Bucket)(new SCP143Bucket(8047, 0, 6576458, false).setUnlocalizedName("SCP-143 Bucket")).setMaxStackSize(20);
	public static final Item Bucket006 = (new SCP143Bucket(8048, SCP006Flowing.blockID, 9983, true).setUnlocalizedName("SCP-143 SCP-006 Bucket"));
	public static final Item Bucket354 = (new SCP143Bucket(8049, SCP354Flowing.blockID, 7602181, true).setUnlocalizedName("SCP-143 SCP-354 Bucket"));
	public static final Item BucketWater = (new SCP143Bucket(8050, Block.waterMoving.blockID, 5017087, true).setUnlocalizedName("SCP-143 Water Bucket"));
	public static final Item Record914 = (new SCPItemRecord(8051, "914", "GlennLeroi").setUnlocalizedName("SCP Record"));
	public static final Item Record173E = (new SCPItemRecord(8052, "173E", "GlennLeroi").setUnlocalizedName("SCP Record"));
	public static final Item Record789J = (new SCPItemRecord(8053, "789J", "GlennLeroi").setUnlocalizedName("SCP Record"));
	public static final Item Record079 = (new SCPItemRecord(8054, "079", "GlennLeroi").setUnlocalizedName("SCP Record"));
	//public static final Item SCP662 = (new SCPItem662(8055).44).setUnlocalizedName("SCP-662"));
	
	//Spawner Documents
	public static final Item SCP173S = (new SCPItem173(5000).setUnlocalizedName("SCP173S"));
	public static final Item SCP111S = (new SCPItem111(5001).setUnlocalizedName("SCP111S"));
	public static final Item SCP914S = (new SCPItem914(5002).setUnlocalizedName("SCP914S"));
	public static final Item SCP019S = (new SCPItem019(5003).setUnlocalizedName("SCP019S"));
	public static final Item SCP457S = (new SCPItem457(5004).setUnlocalizedName("SCP457S"));
	public static final Item SCP294S = (new SCPItem294(5005).setUnlocalizedName("SCP294S"));
	public static final Item SCP513S = (new SCPItem513(5006).setUnlocalizedName("SCP513S"));
	public static final Item SCP049S = (new SCPItem049(5007).setUnlocalizedName("SCP049S"));
	public static final Item SCP087S = (new SCPItem087(5008).setUnlocalizedName("SCP087S"));
	public static final Item SCP1000S = (new SCPItem1000(5009).setUnlocalizedName("SCP1000S"));
	public static final Item SCP131S = (new SCPItem131(5010).setUnlocalizedName("SCP131S"));
	public static final Item SCP999S = (new SCPItem999(5011).setUnlocalizedName("SCP999S"));
	public static final Item SCP261S = (new SCPItem261(5012).setUnlocalizedName("SCP261S"));
	public static final Item SCP629S = (new SCPItem629(5013).setUnlocalizedName("SCP629S"));
	public static final Item SCP354S = (new SCPItem354(5014).setUnlocalizedName("SCP354S"));
	public static final Item SCP096S = (new SCPItem096(5015).setUnlocalizedName("SCP096S"));
	public static final Item SCP538S = (new SCPItem538(5016).setUnlocalizedName("SCP538S"));
	public static final Item SCP106S = (new SCPItem106(5017).setUnlocalizedName("SCP106S"));
	public static final Item SCP080S = (new SCPItem080(5018).setUnlocalizedName("SCP080S"));
	public static final Item SCP280S = (new SCPItem280(5019).setUnlocalizedName("SCP280S"));
	public static final Item SCP409S = (new SCPItem409(5020).setUnlocalizedName("SCP409S"));
	public static final Item SCP310S = (new SCPItem310(5021).setUnlocalizedName("SCP310S"));
	public static final Item SCP594S = (new SCPItem594(5022).setUnlocalizedName("SCP594S"));
	public static final Item SCP143S = (new SCPItem143(5023).setUnlocalizedName("SCP143S"));
	public static final Item SCP058S = (new SCPItem058(5024).setUnlocalizedName("SCP058S"));
	public static final Item SCP966S = (new SCPItem966(5025).setUnlocalizedName("SCP966S"));
	public static final Item SCP872S = (new SCPItem872(5026).setUnlocalizedName("SCP872S"));
	public static final Item SCP006S = (new SCPItem006(5027).setUnlocalizedName("SCP006S"));
//	public static final Item SCP1440S = (new SCPItem1440(5028).setUnlocalizedName("SCP1440S"));
	public static final Item SCP789JS = (new SCPItem789J(5029).setUnlocalizedName("SCP789JS"));
	public static final Item SCP015S = (new SCPItem015(5030).setUnlocalizedName("SCP015S"));
	public static final Item SCP053S = (new SCPItem053(5031).setUnlocalizedName("SCP053S"));
	public static final Item SCP073S = (new SCPItem073(5032).setUnlocalizedName("SCP073S"));
	public static final Item SCP027S = (new SCPItem027(5033).setUnlocalizedName("SCP027S"));
	public static final Item SCP076S = (new SCPItem076(5034).setUnlocalizedName("SCP076S"));
	public static final Item SCP997S = (new SCPItem997(5035).setUnlocalizedName("SCP997S"));
	public static final Item SCP079S = (new SCPItem079(5036).setUnlocalizedName("SCP079S"));
	public static final Item SCP372S = (new SCPItem372(5037).setUnlocalizedName("SCP372S"));
	public static final Item SCP151S = (new SCPItem151(5038).setUnlocalizedName("SCP151S"));
	public static final Item SCP472S = (new SCPItem472(5039).setUnlocalizedName("SCP472S"));
	//	public static final Item SCP846S = (new SCPItem846(5040).setUnlocalizedName("SCP846S"));
	public static final Item SCP273S = (new SCPItem273(5041).setUnlocalizedName("SCP273S"));
	public static final Item SCP002S = (new SCPItem002(5042).setUnlocalizedName("SCP002S"));
	public static final Item SCP822S = (new SCPItem822(5043).setUnlocalizedName("SCP822S"));
	public static final Item SCP023S = (new SCPItem023(5044).setUnlocalizedName("SCP023S"));
	public static final Item SCP009S = (new SCPItem009(5045).setUnlocalizedName("SCP009S"));
	public static final Item SCP682S = (new SCPItem682(5046).setUnlocalizedName("SCP682S"));
	public static final Item SCP500S = (new SCPDocumentItems(5047, "SCP-500", "Panacea", "\u00a72", 1, SCP500G, 16).setUnlocalizedName("SCP500S"));
	public static final Item SCP063S = (new SCPDocumentItems(5048, "SCP-063", "The World's Best TothBrush", "\u00a72", 1, TothBrush, 1).setUnlocalizedName("SCP063S"));
	public static final Item SCP1025S = (new SCPDocumentItems(5049, "SCP-1025", "Encyclopedia of Diseases", "\u00a72", 1, SCP1025, 1).setUnlocalizedName("SCP1025S"));
	public static final Item SCP109S = (new SCPDocumentItems(5050, "SCP-109", "Infinite Canteen", "\u00a7e", 2, SCP109, 1).setUnlocalizedName("SCP109S"));
	public static final Item SCP50AEJS = (new SCPDocumentItems(5051, "SCP-50-AE-J", "The Deagle", "\u00a7e", 2, SCP50AEJ, 1).setUnlocalizedName("SCP50AEJS"));
	public static final Item SCP420JS = (new SCPDocumentItems(5052, "SCP-420-J", "The Best \u00a7kShit \u00a77in the World", "\u00a72", 1, SCP420J, 2).setUnlocalizedName("SCP420JS"));
	public static final Item SCP458S = (new SCPDocumentItems(5053, "SCP-458", "The Never-Ending Pizza Box", "\u00a72", 1, SCP458, 1).setUnlocalizedName("SCP458S"));
	public static final Item SCP217S = (new SCPDocumentItems(5054, "SCP-217", "The Clockwork Virus", "\u00a74", 3, SCP217, 1).setUnlocalizedName("SCP217S"));
	public static final Item SCP912S = (new SCPItemArmorSpawns(5055, "SCP-912", "Autonomous SWAT Armor", "\u00a72", 1, SCP912Head, SCP912Shirt, SCP912Pants, SCP912Shoes, 1).setUnlocalizedName("SCP912HS"));
	
	//Pearls
	public static final Item Pearl354 = (new SCPItemPearl(6000, "SCP-354").setUnlocalizedName("SCP-354"));
	public static final Item Pearl096 = (new SCPItemPearl(6001, "SCP-096").setUnlocalizedName("SCP-096"));
	public static final Item Pearl261 = (new SCPItemPearl(6002, "SCP-261").setUnlocalizedName("SCP-261"));
	public static final Item Pearl629 = (new SCPItemPearl(6003, "SCP-629").setUnlocalizedName("SCP-629"));
	public static final Item Pearl1000 = (new SCPItemPearl(6004, "SCP-1000").setUnlocalizedName("SCP-1000"));
	public static final Item Pearl131 = (new SCPItemPearl(6005, "SCP-131").setUnlocalizedName("SCP-131"));
	public static final Item Pearl999 = (new SCPItemPearl(6006, "SCP-999").setUnlocalizedName("SCP-999"));
	public static final Item Pearl049 = (new SCPItemPearl(6007, "SCP-049").setUnlocalizedName("SCP-049"));
	public static final Item Pearl087 = (new SCPItemPearl(6008, "SCP-087").setUnlocalizedName("SCP-087"));
	public static final Item Pearl173 = (new SCPItemPearl(6009, "SCP-173").setUnlocalizedName("SCP-173"));
	public static final Item Pearl111 = (new SCPItemPearl(6010, "SCP-111").setUnlocalizedName("SCP-111"));
	public static final Item Pearl294 = (new SCPItemPearl(6011, "SCP-294").setUnlocalizedName("SCP-294"));
	public static final Item Pearl019 = (new SCPItemPearl(6012, "SCP-019").setUnlocalizedName("SCP-019"));
	public static final Item Pearl457 = (new SCPItemPearl(6013, "SCP-457").setUnlocalizedName("SCP-457"));
	public static final Item Pearl513 = (new SCPItemPearl(6014, "SCP-513").setUnlocalizedName("Cowbell"));
	public static final Item Pearl914 = (new SCPItemPearl(6015, "SCP-914").setUnlocalizedName("SCP-914"));
	public static final Item Pearl106 = (new SCPItemPearl(6016, "SCP-106").setUnlocalizedName("SCP-106"));
	public static final Item Pearl538 = (new SCPItemPearl(6017, "SCP-538").setUnlocalizedName("SCP-538"));
	public static final Item Pearl280 = (new SCPItemPearl(6018, "SCP-280").setUnlocalizedName("SCP-280"));
	public static final Item Pearl080 = (new SCPItemPearl(6019, "SCP-080").setUnlocalizedName("SCP-080"));
	public static final Item Pearl409 = (new SCPItemPearl(6020, "SCP-409").setUnlocalizedName("SCP-409"));
	public static final Item Pearl310 = (new SCPItemPearl(6021, "SCP-310").setUnlocalizedName("SCP-310"));
	public static final Item Pearl594 = (new SCPItemPearl(6022, "SCP-594").setUnlocalizedName("SCP-594"));
	public static final Item Pearl143 = (new SCPItemPearl(6023, "SCP-143").setUnlocalizedName("SCP-143"));
	public static final Item Pearl058 = (new SCPItemPearl(6024, "SCP-058").setUnlocalizedName("SCP-058"));
//	public static final Item Pearl1440 = (new SCPItemPearl(6025, "SCP-1440").26).setUnlocalizedName("SCP-1440"));
	public static final Item Pearl006 = (new SCPItemPearl(6026, "SCP-006").setUnlocalizedName("SCP-006"));
	public static final Item Pearl966 = (new SCPItemPearl(6027, "SCP-966").setUnlocalizedName("SCP-966"));
	public static final Item Pearl872 = (new SCPItemPearl(6028, "SCP-872").setUnlocalizedName("SCP-872"));
	public static final Item Pearl789J = (new SCPItemPearl(6029, "SCP-789-J").setUnlocalizedName("SCP-789-J"));
	public static final Item Pearl015 = (new SCPItemPearl(6030, "SCP-015").setUnlocalizedName("SCP-015"));
	public static final Item Pearl053 = (new SCPItemPearl(6031, "SCP-053").setUnlocalizedName("SCP-053"));
	public static final Item Pearl073 = (new SCPItemPearl(6032, "SCP-073").setUnlocalizedName("SCP-073"));
	public static final Item Pearl027 = (new SCPItemPearl(6033, "SCP-027").setUnlocalizedName("SCP-027"));
	public static final Item Pearl076 = (new SCPItemPearl(6034, "SCP-076").setUnlocalizedName("SCP-076"));
	public static final Item Pearl997 = (new SCPItemPearl(6035, "SCP-997").setUnlocalizedName("SCP-997"));
	public static final Item Pearl079 = (new SCPItemPearl(6036, "SCP-079").setUnlocalizedName("SCP-079"));
	public static final Item Pearl372 = (new SCPItemPearl(6037, "SCP-372").setUnlocalizedName("SCP-372"));
	public static final Item Pearl151 = (new SCPItemPearl(6038, "SCP-151").setUnlocalizedName("SCP-151"));
	public static final Item Pearl472 = (new SCPItemPearl(6039, "SCP-472").setUnlocalizedName("SCP-472"));
	//	public static final Item Pearl846 = (new SCPItemPearl(6040, "SCP-846").42).setUnlocalizedName("SCP846"));
	public static final Item Pearl273 = (new SCPItemPearl(6041, "SCP-273").setUnlocalizedName("SCP-273"));
	public static final Item Pearl822 = (new SCPItemPearl(6042, "SCP-822").setUnlocalizedName("SCP-822"));
	public static final Item Pearl023 = (new SCPItemPearl(6043, "SCP-023").setUnlocalizedName("SCP-023"));
	public static final Item Pearl009 = (new SCPItemPearl(6044, "SCP-009").setUnlocalizedName("SCP-009"));
	public static final Item Pearl002 = (new SCPItemPearl(6045, "SCP-002").setUnlocalizedName("SCP-002"));
	public static final Item SCPItems = (new SCPItemDescription(6046).setUnlocalizedName("SCPItems"));
	
	//Drinks
	public static final Item CupEmpty = (new SCPItemCup(7000).setUnlocalizedName("Empty Cup"));
	public static final SCPItemCupFilled CupMycelium = (SCPItemCupFilled)(new SCPItemCupFilled(7001, 10124161, false, 0).setPotionEffect(Potion.confusion.id, 30, 2, 1F).setUnlocalizedName("Cup with Mycelium"));
	public static final SCPItemCupFilled CupNetherrack = (SCPItemCupFilled)(new SCPItemCupFilled(7002, 5975598, true, 6817800).setPotionEffect(Potion.fireResistance.id, 30, 2, 1F).setUnlocalizedName("Cup with Netherrack"));
	public static final SCPItemCupFilled CupCoal = (SCPItemCupFilled)(new SCPItemCupFilled(7003, 1776411, false, 0).setPotionEffect(Potion.weakness.id, 30, 2, 1F).setUnlocalizedName("Cup with Coal"));
	public static final SCPItemCupFilled CupGlowstone = (SCPItemCupFilled)(new SCPItemCupFilled(7004, 16759902, true, 7499593).setPotionEffect(Potion.blindness.id, 30, 2, 1F).setUnlocalizedName("Cup with Glowstone"));
	public static final SCPItemCupFilled CupGold = (SCPItemCupFilled)(new SCPItemCupFilled(7005, 14605824, false, 0).setPotionEffect(Potion.moveSpeed.id, 10, 1, 1F).setUnlocalizedName("Cup with Gold"));
	public static final SCPItemCupFilled CupAppleGold = (SCPItemCupFilled)(new SCPItemCupFilled(7006, 15396439, false, 0).setPotionEffect(Potion.heal.id, 30, 2, 1F).setUnlocalizedName("Cup with Golden Apple"));
	public static final SCPItemCupFilled CupCactus = (SCPItemCupFilled)(new SCPItemCupFilled(7007, 1346852, false, 0).setPotionEffect(Potion.harm.id, 30, 2, 1F).setUnlocalizedName("Cup with Cactus"));
	public static final SCPItemCupFilled CupSlowSand = (SCPItemCupFilled)(new SCPItemCupFilled(7008, 4206115, true, 4206115).setPotionEffect(Potion.moveSlowdown.id, 30, 2, 1F).setUnlocalizedName("Cup with Soul Sand"));
	public static final SCPItemCupFilled CupObsidian = (SCPItemCupFilled)(new SCPItemCupFilled(7009, 1052697, true, 3812948).setPotionEffect(Potion.resistance.id, 30, 5, 1F).setUnlocalizedName("Cup with Obsidian"));
	public static final SCPItemCupFilled CupFeather = (SCPItemCupFilled)(new SCPItemCupFilled(7010, 16777215, false, 0).setPotionEffect(Potion.jump.id, 30, 2, 1F).setUnlocalizedName("Cup with Feathers"));
	public static final SCPItemCupFilled CupSpiderEye = (SCPItemCupFilled)(new SCPItemCupFilled(7011, 6620715, false, 0).setPotionEffect(Potion.poison.id, 30, 2, 1F).setUnlocalizedName("Cup with Spider Eyes"));
	public static final SCPItemCupFilled CupGlass = (SCPItemCupFilled)(new SCPItemCupFilled(7012, 11785947, false, 0).setPotionEffect(Potion.waterBreathing.id, 30, 2, 1F).setUnlocalizedName("Cup with Glass"));
	public static final SCPItemCupFilled CupPumpkin = (SCPItemCupFilled)(new SCPItemCupFilled(7013, 14913565, false, 0).setPotionEffect(SCPPotion.shake.id, 5, 1, 1F).setUnlocalizedName("Cup with Moldy Pumpkin"));
	public static final SCPItemCupFilled CupApple = (SCPItemCupFilled)(new SCPItemCupFilled(7014, 16718891, false, 0).setPotionEffect(Potion.regeneration.id, 30, 2, 1F).setUnlocalizedName("Apple Juice"));
	public static final SCPItemCupFilled CupStone = (SCPItemCupFilled)(new SCPItemCupFilled(7015, 4473924, false, 0).setPotionEffect(SCPPotion.crystal.id, 3, 0, 1F).setUnlocalizedName("Cup with Stone"));
	public static final SCPItemCupFilled CupClay = (SCPItemCupFilled)(new SCPItemCupFilled(7016, 10791096, false, 0).setPotionEffect(Potion.poison.id, 17, 1, 1F).setUnlocalizedName("Cup with Clay"));
	public static final SCPItemCupFilled CupSugar = (SCPItemCupFilled)(new SCPItemCupFilled(7017, 16777215, true, 16777215).setPotionEffect(Potion.moveSpeed.id, 30, 3, 1F).setUnlocalizedName("Cup with Redbull"));
	public static final SCPItemCupFilled CupRottenFlesh = (SCPItemCupFilled)(new SCPItemCupFilled(7018, 7298075, true, 9130787).setPotionEffect(Potion.hunger.id, 50, 2, 1F).setUnlocalizedName("Cup with Rotten Stuff (yuck)"));
	public static final SCPItemCupFilled CupIron = (SCPItemCupFilled)(new SCPItemCupFilled(7019, 14211288, false, 0).setPotionEffect(Potion.damageBoost.id, 30, 2, 1F).setUnlocalizedName("Cup with Iron"));
	public static final SCPItemCupFilled CupDiamond = (SCPItemCupFilled)(new SCPItemCupFilled(7020, 4910545, false, 0).setPotionEffect(Potion.digSpeed.id, 50, 5, 1F).setUnlocalizedName("Cup with Diamond"));
	public static final SCPItemCupFilled CupRedstone = (SCPItemCupFilled)(new SCPItemCupFilled(7021, 7471104, true, 16711680).setPotionEffect(SCPPotion.electricity.id, 5, 1, 1F).setUnlocalizedName("Cup with Redstone"));
	public static final SCPItemCupFilled CupCobweb = (SCPItemCupFilled)(new SCPItemCupFilled(7022, 11382197, false, 0).setPotionEffect(Potion.moveSlowdown.id, 8, 1, 1F).setUnlocalizedName("Cup with Web"));
	public static final SCPItemCupFilled CupBone = (SCPItemCupFilled)(new SCPItemCupFilled(7023, 16777215, false, 0).setPotionEffect(SCPPotion.skeleton.id, 30, 0, 1F).setUnlocalizedName("Cup with Bone Fragments"));
	public static final SCPItemCupFilled CupSlimeBall = (SCPItemCupFilled)(new SCPItemCupFilled(7024, 3211033, false, 0).setPotionEffect(SCPPotion.sticky.id, 30, 0, 1F).setUnlocalizedName("Cup with Slime"));
	public static final SCPItemCupFilled CupBlood = (SCPItemCupFilled)(new SCPItemCupFilled(7025, 8323072, false, 0).setPotionEffect(SCPPotion.bloodStone.id, 600, 0, 1F).setUnlocalizedName("Cup with Blood"));

	//Achievements
	//TODO
	public static final Achievement reinforcedIron = (new Achievement(1000, "reinforcedIron", 0, 0, Locker, null)).setIndependent().registerAchievement();
	public static final Achievement craftCrafter = (new Achievement(1001, "craftCrafter", 0, -1, DocumentTable, reinforcedIron)).registerAchievement();
	public static final Achievement breakSCP019 = (new Achievement(1002, "breakSCP019", 1, 1, Item019, craftCrafter)).registerAchievement();
	public static final Achievement classD = (new Achievement(1003, "classD", 1, 2, GasMask, craftCrafter)).registerAchievement();
	public static final Achievement pizzaBreak = (new Achievement(1004, "pizzaBreak", -1, 1, SCP458, craftCrafter)).registerAchievement();
	public static final Achievement classDshirt = (new Achievement(1005, "classd_shirt", -1, 2, ClassDShirt, reinforcedIron)).registerAchievement();
	public static final Achievement classDpants = (new Achievement(1006, "classd_pants", -2, 2, ClassDPants, classDshirt)).registerAchievement();
	public static final Achievement classDboots = (new Achievement(1007, "classd_boots", -3, 2, ClassDShoes, classDpants)).registerAchievement();
	public static final Achievement SCP629 = (new Achievement(1008, "ArmJob", -1, -1, Pearl629, craftCrafter)).registerAchievement();
	public static final Achievement SCP457 = (new Achievement(1009, "Hothead", -1, -2, Pearl457, craftCrafter)).registerAchievement();
	public static final Achievement Healer = (new Achievement(1010, "Healer", -1, -3, Pearl049, craftCrafter)).registerAchievement();
	public static final Achievement hacker = (new Achievement(1011, "hacker", 1, -1, Pearl079, craftCrafter)).registerAchievement();
	public static final Achievement brushYourToths = (new Achievement(1012, "BrushYourToths", -1, 3, TothBrush, craftCrafter)).registerAchievement();
	public static final Achievement noSmoking = (new Achievement(1013, "noSmoking", 1, 3, SmokeBlock, craftCrafter)).registerAchievement();
	public static final Achievement painKiller = (new Achievement(1014, "painKiller", -1, 4, SCP500G, craftCrafter)).registerAchievement();
	public static final Achievement bestShit = (new Achievement(1015, "bestShit", 1, 4, SCP420J, craftCrafter)).registerAchievement();
	public static final Achievement challengeaccepted = (new Achievement(1016, "challengeaccepted", 1, -2, Pearl087, craftCrafter)).registerAchievement();
	public static final Achievement ClassDNoob = (new Achievement(1017, "ClassDNoob", 1, 5, L1Keycard, craftCrafter)).registerAchievement();
	public static final Achievement CainWin = (new Achievement(1018, "cainwin", 1, -3, Pearl073, craftCrafter)).registerAchievement();
	public static final Achievement AbleWin = (new Achievement(1019, "ablewin", 1, -4, Pearl076, craftCrafter)).registerAchievement();
	public static final Achievement summonSCP015Boss = (new Achievement(1020, "KillSCP015Boss", -1, -4, Pearl015, craftCrafter)).registerAchievement();
	public static final Achievement pocketD = (new Achievement(1021, "pocketD", -2, -4, Pearl106, craftCrafter)).registerAchievement();
	

	public static AchievementPage scpAchievement = new AchievementPage("SCP Craft", reinforcedIron, craftCrafter, breakSCP019, classD, pizzaBreak, classDpants, classDshirt, classDboots,
			SCP629, SCP457, Healer, hacker, brushYourToths, noSmoking, painKiller, bestShit, challengeaccepted, ClassDNoob,
			AbleWin, CainWin, summonSCP015Boss, pocketD);

	@Instance
	public static mod_SCP instance = new mod_SCP();
	public static CommonProxy proxy;

	private static float zLevel;

	//ModLoader Functions
	@Init
	public void load(FMLInitializationEvent event)
	{
		zLevel = -90F;

		MinecraftForge.EVENT_BUS.register(new SCPCraft_EventSounds());
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		//RegisterEntityID		
		registerSCP(SCPEntity111.class, "SCP-111", EntityRegistry.findGlobalUniqueEntityId(), 0x00CC00, 0x77FF49);
		registerSCP(SCPEntityClassDGuy.class, "Class-D Guy", EntityRegistry.findGlobalUniqueEntityId(), 0xFF6600, 0x000000);
		registerSCP(SCPEntity019n2.class, "SCP-019-2", EntityRegistry.findGlobalUniqueEntityId(), 0xFFDA91, 0xFFFCFC);
		registerSCP(SCPEntity457.class, "SCP-457", EntityRegistry.findGlobalUniqueEntityId(), 0xFF0000, 0xFF6600);
		registerSCP(SCPEntity513.class, "SCP-513", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFF0905);
		registerSCP(SCPEntity087.class, "SCP-087", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0xE0E0E0);
		registerSCP(SCPEntity049.class, "SCP-049", EntityRegistry.findGlobalUniqueEntityId(), 0x550000, 0xffffff);
		registerSCP(SCPEntity217Zombie.class, "Zomborg", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x00CC00);
		registerSCP(SCPEntity217Creeper.class, "CreeperDrone", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x00CC00);
		registerSCP(SCPEntity131.class, "SCP-131", EntityRegistry.findGlobalUniqueEntityId(), 0xFF0000, 0xFFFF00);
		registerSCP(SCPEntity999.class, "SCP-999", EntityRegistry.findGlobalUniqueEntityId(), 0xFF6600, 0xFF780A);
		registerSCP(SCPEntity629.class, "SCP-629", EntityRegistry.findGlobalUniqueEntityId(), 0x8B5A00, 0x8B7500);
		registerSCP(SCPEntity096Docile.class, "SCP-096 Docile", EntityRegistry.findGlobalUniqueEntityId(), 0xFFC4CC, 0x99D9FF);
		registerSCP(SCPEntity096Cry.class, "SCP-096 Crying", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		registerSCP(SCPEntity096Mad.class, "SCP-096", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		registerSCP(SCPEntity217Cow.class, "Cowborg", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x999999);
		registerSCP(SCPEntity538.class, "SCP-538", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x494C48);
		registerSCP(SCPEntity106.class, "SCP-106", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x442F1F);
		registerSCP(SCPEntity080.class, "SCP-080", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x555656);
		registerSCP(SCPEntity280.class, "SCP-280", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x8E8D8B);
		registerSCP(SCPEntity594.class, "SCP-594", EntityRegistry.findGlobalUniqueEntityId(), 0x3F0E0B, 0xFFEFE2);
		registerSCP(SCPEntity594Naked.class, "SCP-594Naked", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		registerSCP(SCPEntity058.class, "SCP-058", EntityRegistry.findGlobalUniqueEntityId(), 0x990000, 0x330000);
		registerSCP(SCPEntity966.class, "SCP-966", EntityRegistry.findGlobalUniqueEntityId(), 0xFFDA91, 0xFFFCFC);
		registerSCP(SCPEntity872.class, "SCP-872", EntityRegistry.findGlobalUniqueEntityId(), 0x555656, 0x5E594D);
		//registerSCP(SCPEntity1440.class, "SCP-1440", EntityRegistry.findGlobalUniqueEntityId(), 0xFFD3A8, 0x555656);
		registerSCP(SCPEntity50AEJ.class, "SCP-50-AE-J", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		registerSCP(SCPEntity1000.class, "SCP-1000", EntityRegistry.findGlobalUniqueEntityId(), 0x550000, 0xFFDA91);
		registerSCP(SCPEntity053.class, "SCP-053", EntityRegistry.findGlobalUniqueEntityId(), 0xFFEB16, 0xA90AFF);
		registerSCP(SCPEntityClassD027.class, "Class-D Guy 027", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		registerSCP(SCPEntity997.class, "SCP-997", EntityRegistry.findGlobalUniqueEntityId(), 0x8B5A00, 0x8B7500);
		//	registerSCP(SCPEntity222Clone.class, "SCP-222 Clone", 70, 0x000000, 0x000000);
		registerSCP(SCPEntity217Testificate.class, "Testifinator", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x999999);
		registerSCP(SCPEntity372.class, "SCP-372", EntityRegistry.findGlobalUniqueEntityId(), 0x00CC00, 0x00CC00);
		//	registerSCP(SCPEntity846.class, "SCP-846", 73, 0x999999, 0x000000);
		registerSCP(SCPEntity472.class, "SCP-472", EntityRegistry.findGlobalUniqueEntityId(), 0xFF0000, 0x820e03);
		registerSCP(SCPEntity273.class, "SCP-273", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xffffff);
		registerSCP(SCPEntity015Boss.class, "The Pipe Boss", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x000000);
		registerSCP(SCPEntity015Projectile.class, "SCP-015projectile", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		registerSCP(SCPEntity217Pig.class, "Pigbot", EntityRegistry.findGlobalUniqueEntityId(), 0xFF9999, 0x999999);
		registerSCP(SCPEntity217Spider.class, "Spitron", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x999999);
		registerSCP(SCPEntity073.class, "SCP-073", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xffffff);
		registerSCP(SCPEntity076.class, "SCP-076", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xffffff);
		registerSCP(SCPEntityRat.class, "Rat", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFDA91);
		registerSCP(SCPEntity173.class, "SCP-173", EntityRegistry.findGlobalUniqueEntityId(), 0xFEF2BF, 0x2BC600);
		registerSCP(SCPEntity023.class, "SCP-023", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x000000);
		registerSCP(SCPEntity682.class, "SCP-682", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0x000000);
		registerSCP(SCPEntityReal682.class, "SCP-682Real", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		//registerSCP(SCPEntityButler.class, "Butler", EntityRegistry.findGlobalUniqueEntityId(), -1, -1);
		
		//Register mod entities
		EntityRegistry.registerModEntity(SCPEntityMountableBlock.class, "SCPEntityMountableBlock", EntityRegistry.findGlobalUniqueEntityId(), this, 250, 5, false);
		
		RegisterItemDocumentNames(new String[]{
				"SCP-500", "SCP-063", "SCP-1025", "SCP-109", "SCP-50-AE-J", "SCP-420-J", "SCP-458", "SCP-217", "SCP-912"
		});

		RegisterPearl(new Item[]{
				Pearl273, Pearl372, Pearl151, Pearl472, Pearl079, Pearl997, Pearl076, Pearl027, Pearl073, Pearl053, Pearl015, Pearl789J, Pearl872, Pearl966, Pearl058, 
				Pearl310, Pearl409, Pearl594, Pearl143, Pearl280, Pearl080, Pearl106, Pearl538, Pearl079, Pearl629, Pearl087, Pearl173, Pearl111, Pearl914, Pearl294,
				Pearl261, Pearl131, Pearl457, Pearl019, /*Pearl1440, */ Pearl1000, Pearl006, Pearl096, Pearl354, Pearl999, Pearl049, Pearl023, Pearl822, Pearl002, Pearl009
		});

		RegisterItemNames(new Item[]{
				BucketWater, Bucket354, Bucket006, SCP143Bucket, CupSlimeBall, CupBone, SCP000J, Record173, Record106, VirusTestificate, GasMask,
				ClassDShirt, ClassDPants, ClassDShoes, Item019, Item294, Item261, SCP458, SCP912Head, SCP912Pants, SCP912Shoes, SCP912Shirt, SCP217,
				VirusPig, VirusZombie, VirusSpider, VirusCreeper,	Wrench, VirusCow, L1Keycard, L2Keycard, L3Keycard, OmniKeycard,
				SCP500G, SCP500B, SCP427, GodlyWrench, SCP420J, TothBrush, SCP143Pickaxe, SCP143Spade, SCP143Sword, SCP143Axe, CorrodedDoorItem, InfraRedGlasses,
				SCP50AEJ, SCP1025, SCP109, SlideDoorItem, ItemSCPPoster, Circuit, CupEmpty, CupMycelium, CupNetherrack, CupGlowstone, CupCoal, CupAppleGold,
				CupGold, CupSlowSand, CupCactus, CupObsidian, CupSpiderEye, CupFeather,	CupGlass, CupPumpkin, CupApple, CupStone, CupClay, CupSugar, CupRottenFlesh,
				CupIron, CupDiamond, CupRedstone, CupCobweb, CupBone, CupBlood,	SCP1023ARC, Pearl513, Record789J, Record173E, Record914, Record079, /*SCP662 */
		});

		RegisterDocumentNames(new Item[]{
				SCP822S, SCP002S, SCP273S, SCP151S, SCP076S, SCP079S, SCP372S, SCP472S,	SCP997S, SCP027S, SCP015S, SCP073S,	SCP053S, SCP789JS, /*SCP1440S, */SCP1000S,
				SCP006S, SCP058S, SCP966S, SCP143S,	SCP106S, SCP280S, SCP080S, SCP173S,	SCP914S, SCP872S, SCP409S, SCP310S,	SCP087S, SCP049S, SCP019S, SCP294S,
				SCP261S, SCP111S, SCP457S, SCP131S,	SCP513S, SCP999S, SCP096S, SCP629S,	SCP538S, SCP594S, SCP354S, SCP023S, SCP009S, SCP682S, SCP500S, SCP109S,
				SCP063S, SCP458S, SCP50AEJS, SCP420JS, SCP217S, SCP1025S, SCP912S
		});

		RegisterBlocks(new Block[]{
				BloodBlock, Locker, SCP914, DocumentTable, Machinery, SCP019, SCP294, SCP261, SCP354Still, SCP354Flowing, KeycardSlot, KeycardSlotLv2, KeycardSlotLv3, 
				KeycardSlotOmni, SmokeBlock, CorrodedIron, SCPspawner, Granite, SCP409, SCP310, SCP310Fire, ElectricWool, SCP143Leaves, SCP143Log, SCP143Sapling, 
				SCP143Planks, CorrodedDoor, SCP006Still, SCP006Flowing, SCP789J, SCP015, SlidingDoor, GrateBlock, SCP079, SCP076, Shelf, Poster, SCP151, RemoteDoorComputer, 
				SCP273, Flesh, Bone, SCP822, SCP822Grown, SCP009, Toilet, Alarm, stoneDesk, woodDesk, graniteDesk, marbleDesk, Marble, marbleChair, woodenChair, stoneChair, 
				SCP513, OakShelf, SpruceShelf, BirchShelf, JungleShelf
		});

		RegisterPosters(new Block[]{
				Poster173, Poster106, Poster914, Poster372, Poster079
		});

		//addLocalization - potions, deaths, keys, itemgroups, gui
		ModLoader.addLocalization("potion.crystal", "SCP-409");
		ModLoader.addLocalization("potion.electric", "Electricity");
		ModLoader.addLocalization("potion.shake", "Scare");
		ModLoader.addLocalization("potion.bloodstone", "Bloodstone");
		ModLoader.addLocalization("potion.control", "SCP-872");
		ModLoader.addLocalization("potion.vermin", "Vermin God");
		ModLoader.addLocalization("potion.sticky", "Sticky");
		ModLoader.addLocalization("potion.skeleton", "Skeleton King");
		ModLoader.addLocalization("potion.eat", "SCP-002");
		ModLoader.addLocalization("death.crystal", "%1$s got crystalized by SCP-409");
		ModLoader.addLocalization("death.bloodstone", "%1$s has gone mad");
		ModLoader.addLocalization("death.pipeBoss", "%1$ss got piped");
		ModLoader.addLocalization("death.ghost", "%1$ss butt got eaten");
		ModLoader.addLocalization("death.electricity", "%1$s got electrocuted");
		ModLoader.addLocalization("death.143", "%1$s got cut in SCP-143");
		ModLoader.addLocalization("death.106", "%1$s rotted away from SCP-106");
		ModLoader.addLocalization("death.023", "%1$s got stared to death by SCP-023");
		ModLoader.addLocalization("death.682", "%1$s got squashed by SCP-682");
		ModLoader.addLocalization("death.073", "%1$s got countered by SCP-073");
		ModLoader.addLocalization("death.002", "%1$s got eaten by SCP-002");
		ModLoader.addLocalization("key.blink", "Blink");
		ModLoader.addLocalization("key.Activate", "Blink Activation");
		ModLoader.addLocalization("key.doors", "Remote Doors");
		ModLoader.addLocalization("itemGroup.SCPBlocks", "SCP Blocks");
		ModLoader.addLocalization("itemGroup.SCPs", "SCPs");
		ModLoader.addLocalization("itemGroup.SCPCups", "SCP Cups");
		ModLoader.addLocalization("itemGroup.SCPItems", "SCP Items");
		ModLoader.addLocalization("gui.scpachievements", "SCPCraft");

		//Achievements
		//TODO
		ModLoader.addAchievementDesc(reinforcedIron, "It's Iron...But Better!", "Craft Reinforced Iron");
		ModLoader.addAchievementDesc(craftCrafter, "Let The Adventure Begin...", "Craft the Document Table.");
		ModLoader.addAchievementDesc(breakSCP019, "Break The Unbreakable.", "Acquire SCP-019");
		ModLoader.addAchievementDesc(classD, "I CAN'T SEE!!!", "Craft A Gas Mask.");
		ModLoader.addAchievementDesc(pizzaBreak, "Pizza Break", "Prepare Your Lunch");
		ModLoader.addAchievementDesc(SCP629, "ArmJob", "Give SCP-629 his arms");
		ModLoader.addAchievementDesc(SCP457, "Fight Fire With Water", "Use The Burning Man's Document");
		ModLoader.addAchievementDesc(Healer, "Heal The Healer", "Give the special item to Mr. Plague Doctor");
		ModLoader.addAchievementDesc(hacker, "Hacker", "Communicate With SCP-079");
		ModLoader.addAchievementDesc(classDpants, "Then Pants...", "Craft The Class-D Panties");
		ModLoader.addAchievementDesc(classDshirt, "First The Shirt...", "Craft The Class-D Shirt");
		ModLoader.addAchievementDesc(classDboots, "...Then Booties", "Craft The Class-D Shoes");
		ModLoader.addAchievementDesc(brushYourToths, "Brush Your Toths", "Craft The World's Best Tothbrush");
		ModLoader.addAchievementDesc(noSmoking, "NO SMOKING", "Craft A Smoke Block");
		ModLoader.addAchievementDesc(painKiller, "Painkiller", "Craft An SCP-500 Pill");
		ModLoader.addAchievementDesc(bestShit, "Best [REDACTED] In The World", "Craft The Best Shit In The World");
		ModLoader.addAchievementDesc(challengeaccepted, "Challenge Accepted", "Spawn SCP-087's Chamber");
		ModLoader.addAchievementDesc(ClassDNoob, "Class-D Noob", "Craft A Level 1 Keycard");
		ModLoader.addAchievementDesc(AbleWin, "Are You Able To Do This?", "Spawn Able's Document");
		ModLoader.addAchievementDesc(CainWin, "Candy Cain", "Use Cain's Document");
		ModLoader.addAchievementDesc(summonSCP015Boss, "The Pied Piper", "Summon The Pipe Monster");
		ModLoader.addAchievementDesc(pocketD, "Check Your Pockets", "Succesfully Escape the Pocket Dimension.");
		
		AchievementPage.registerAchievementPage(scpAchievement);

		//Misc
		ModLoader.registerTileEntity(SCPTileEntity914.class, "SCP-914");
		ModLoader.registerTileEntity(SCPTileEntity294.class, "SCP-294", new SCPRender294());
		ModLoader.registerTileEntity(SCPTileEntity019.class, "SCP-019", new SCPRender019());
		ModLoader.registerTileEntity(SCPTileEntity261.class, "SCP-261", new SCPRender261());	
		ModLoader.registerTileEntity(SCPTileEntity076.class, "SCP-076-1");
		ModLoader.registerTileEntity(SCPTileEntityShelf.class, "Shelf", new SCPRenderShelf());
		ModLoader.registerTileEntity(SCPTileEntity151.class, "SCP-151");
		ModLoader.registerTileEntity(SCPTileEntity015.class, "SCP-015");
		ModLoader.registerTileEntity(SCPTileEntityRemoteDoorComp.class, "RemoteDoorComp", new SCPRenderRemoteDoorComp());
		ModLoader.registerTileEntity(SCPTileEntity079.class, "SCP-079");
		ModLoader.registerTileEntity(SCPTileEntityAlarm.class, "Alarm");
		ModLoader.registerTileEntity(SCPTileEntityFlesh.class, "Flesh");

		SCPRecipes000J.getInstance();
		SCPDocumentManager.getInstance();
		SCPRecipes.recipes();
	}

	//Version
	public String getVersion()
	{
		return SCPCraftVersion;
	}

	@PreInit
	public void PreInit(FMLPreInitializationEvent event)
	{		
		MinecraftForge.EVENT_BUS.register(new SCPCraft_EventSounds());
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		TickRegistry.registerTickHandler(new SCPClientTickHandler(), Side.CLIENT);
	}


	@PostInit
	public void PostInit(FMLPostInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
	}

	private void registerSCP(Class<? extends Entity> cl, String name, int id, int background, int foreground) 
	{
		if(background != -1 && foreground != -1)EntityRegistry.registerGlobalEntityID(cl, name, id, background, foreground);
		else EntityRegistry.registerGlobalEntityID(cl, name, id);
		EntityRegistry.registerModEntity(cl, name, id, this, 80, 3, true);
		ModLoader.addLocalization("entity." + name + ".name", name);
	}

	private void RegisterBlocks(Block ablock []) 
	{
		Block ablock1[] = ablock;
		int i = ablock1.length;
		for(int j = 0; j < i; j++)
		{
			Block block = ablock1[j];
			GameRegistry.registerBlock(block);
			Block item = ablock1[j];
			String name = ablock[j].getUnlocalizedName();
			LanguageRegistry.addName(item, name.substring(5));
		}	
	}

	private void RegisterItemDocumentNames(String[] name) 
	{
		int i = name.length;
		for(int j = 0; j < i; j++)
		{
			LanguageRegistry.addName(new ItemStack(SCPItems, 1, j), name[j] + " Item Description");
		}	
	}

	private void RegisterItemNames(Item aitem[]) 
	{
		Item aitem1[] = aitem;
		int i = aitem1.length;
		for(int j = 0; j < i; j++)
		{
			Item item = aitem1[j];
			String name = aitem[j].getUnlocalizedName();
			LanguageRegistry.addName(item, name.substring(5));
		}	
	}

	private void RegisterPosters(Block ablock[])
	{
		Block ablock1[] = ablock;
		int i = ablock1.length;
		for(int j = 0; j < i; j++)
		{
			Block block = ablock1[j];
			LanguageRegistry.addName(block, "SCP Poster");
			GameRegistry.registerBlock(block);
		}	
	}

	private void RegisterPearl(Item aitem[])
	{
		Item aitem1[] = aitem;
		int i = aitem1.length;
		for(int j = 0; j < i; j++)
		{
			String name = aitem[j].getUnlocalizedName();
			Item item = aitem1[j];
			LanguageRegistry.addName(item, name.substring(5) + " Pearl");
		}	
	}

	private void RegisterDocumentNames(Item aitem []) 
	{
		Item aitem1[] = aitem;
		int i = aitem1.length;
		for(int j = 0; j < i; j++)
		{
			Item item = aitem1[j];
			LanguageRegistry.addName(item, "SCP Document");
		}	
	}
	
	public void baseFilesEdited()
	{
		/*
		 * v = updated; x = made our own file; all are in net.minecraft.*
		 * BlockCrops - *.block - v
		 * BlockPane - *.block - v
		 * ContainerPlayer - *.inventory - v
		 * EntityAnimal - *.entity.passive - v ##
		 * EntityAINearestAttackableTarget - *.entity.ai - v
		 * EntityCow - *.entity.passive - v ##
		 * EntityChicken - *.entity.passive - v
		 * EntityLiving - *.entity - v
		 * EntityPig - *.entity.passive - v
		 * EntityPlayer - *.entity.player - v
		 * EntityPlayerMP - *.entity.player - v
		 * EntityRenderer - *.client.renderer - v
		 * EntitySheep - *.entity.passive - v
		 * EntityOcelot - *.entity.passive - v
		 * EntityWolf - *.entity.passive - v
		 * GuiContainerCreative - *.client.gui.inventory - v
		 * GuiInventory - *.client.gui.inventory - v
		 * InventoryEffectRenderer - *.client.renderer - v
		 * InventoryPlayer - *.entity.player - v
		 * Render - *.client.renderer.entity - v
		 * RenderBiped - *.client.renderer.entity - v
		 * RenderCreeper - *.client.renderer.entity - v
		 * RenderEnderman - *.client.renderer.entity - v
		 * RenderLiving - *.client.renderer.entity - v
		 * RenderPig - *.client.renderer.entity - v
		 * RenderPlayer - *.client.renderer.entity - v
		 * RenderSilverfish - *.client.renderer.entity - v
		 * RenderSlime - *.client.renderer.entity - v
		 * RenderSpider - *.client.renderer.entity - v
		 * RenderVillager - *.client.renderer.entity - v
		 * World - *.world - v
		 */
	}
}
