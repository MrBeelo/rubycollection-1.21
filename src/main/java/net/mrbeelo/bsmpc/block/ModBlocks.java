package net.mrbeelo.bsmpc.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.block.custom.*;
import net.mrbeelo.bsmpc.effect.ModEffects;
import net.mrbeelo.bsmpc.item.ModItems;
import net.mrbeelo.bsmpc.sound.ModSounds;
import net.mrbeelo.bsmpc.world.tree.ModSaplingGenerators;

public class ModBlocks {

    //REGISTERING

    public static final Block RUBY_BLOCK = registerWithItem("ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK).sounds(ModSounds.RUBY_BLOCK_SOUNDS)), new Item.Settings().maxCount(65));
    public static final Block RUBY_ORE = registerWithItem("ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE)), new Item.Settings());
    public static final Block DEEPSLATE_RUBY_ORE = registerWithItem("deepslate_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_EMERALD_ORE)), new Item.Settings());
    public static final Block NETHER_RUBY_ORE = registerWithItem("nether_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE)), new Item.Settings());
    public static final Block END_RUBY_ORE = registerWithItem("end_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE)), new Item.Settings());

    public static final SMRUBlock SMOOTH_QUARTZ_RUBY_UPGRADER = registerWithItem("smooth_quartz_ruby_upgrader", new SMRUBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ)), new Item.Settings());
    public static final SMRDBlock SMOOTH_QUARTZ_RUBY_DOWNGRADER = registerWithItem("smooth_quartz_ruby_downgrader", new SMRDBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ)), new Item.Settings());

    public static final StairsBlock RUBY_STAIRS = registerWithItem("ruby_stairs", new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(ModBlocks.RUBY_BLOCK)), new Item.Settings());
    public static final SlabBlock RUBY_SLAB = registerWithItem("ruby_slab", new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.RUBY_BLOCK)), new Item.Settings());

    public static final ButtonBlock RUBY_BUTTON = registerWithItem("ruby_button", new ButtonBlock(BlockSetType.IRON ,40, AbstractBlock.Settings.copy(Blocks.STONE_BUTTON)), new Item.Settings());
    public static final PressurePlateBlock RUBY_PRESSURE_PLATE = registerWithItem("ruby_pressure_plate", new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)), new Item.Settings());

    public static final FenceBlock RUBY_FENCE = registerWithItem("ruby_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE)), new Item.Settings());
    public static final FenceGateBlock RUBY_FENCE_GATE = registerWithItem("ruby_fence_gate", new FenceGateBlock(WoodType.OAK ,AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE)), new Item.Settings());
    public static final WallBlock RUBY_WALL = registerWithItem("ruby_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE)), new Item.Settings());

    public static final DoorBlock RUBY_DOOR = registerWithItem("ruby_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().requiresTool().nonOpaque()), new Item.Settings());
    public static final TrapdoorBlock RUBY_TRAPDOOR = registerWithItem("ruby_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().requiresTool().nonOpaque()), new Item.Settings());

    public static final Block KOKAINA_CROP = Registry.register(Registries.BLOCK, BsmpC.id("kokaina_crop"), new KokainaCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block PACKED_IRON_BLOCK = registerWithItem("packed_iron_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), new Item.Settings());
    public static final RGBBlock RGB_BLOCK = registerWithItem("rgb_block", new RGBBlock(AbstractBlock.Settings.copy(Blocks.STONE)), new Item.Settings());
    public static final FlowerBlock ROSE = registerWithItem("rose", new FlowerBlock(ModEffects.HIGH, 20, AbstractBlock.Settings.copy(Blocks.POPPY).nonOpaque()), new Item.Settings());
    public static final FlowerPotBlock POTTED_ROSE = register("potted_rose", new FlowerPotBlock(ROSE, AbstractBlock.Settings.copy(Blocks.POTTED_POPPY).nonOpaque()));
    public static final PedestalBlock PEDESTAL = registerWithItem("pedestal", new PedestalBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().nonOpaque()), new Item.Settings());

    public static final PillarBlock CS_LOG = registerWithItem("cs_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)), new Item.Settings());
    public static final PillarBlock CS_WOOD = registerWithItem("cs_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)), new Item.Settings());
    public static final PillarBlock STRIPPED_CS_LOG = registerWithItem("stripped_cs_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)), new Item.Settings());
    public static final PillarBlock STRIPPED_CS_WOOD = registerWithItem("stripped_cs_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)), new Item.Settings());

    public static final Block CS_PLANKS = registerWithItem("cs_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)), new Item.Settings());
    public static final LeavesBlock CS_LEAVES = registerWithItem("cs_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque()), new Item.Settings());
    public static final ModSaplingBlock CS_SAPLING = registerWithItem("cs_sapling", new ModSaplingBlock(ModSaplingGenerators.CUPRESSUS_SEMPERVIRENS, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING), Blocks.GRASS_BLOCK), new Item.Settings());

    public static final StairsBlock CS_STAIRS = registerWithItem("cs_stairs", new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)), new Item.Settings());
    public static final SlabBlock CS_SLAB = registerWithItem("cs_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)), new Item.Settings());

    public static final ButtonBlock CS_BUTTON = registerWithItem("cs_button", new ButtonBlock(BlockSetType.IRON ,10, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)), new Item.Settings());
    public static final PressurePlateBlock CS_PRESSURE_PLATE = registerWithItem("cs_pressure_plate", new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)), new Item.Settings());

    public static final FenceBlock CS_FENCE = registerWithItem("cs_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)), new Item.Settings());
    public static final FenceGateBlock CS_FENCE_GATE = registerWithItem("cs_fence_gate", new FenceGateBlock(WoodType.OAK ,AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)), new Item.Settings());

    public static final DoorBlock CS_DOOR = registerWithItem("cs_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)), new Item.Settings());
    public static final TrapdoorBlock CS_TRAPDOOR = registerWithItem("cs_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)), new Item.Settings());

    //METHODS

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, BsmpC.id(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public static void registerModBlocks() {
    }
}
