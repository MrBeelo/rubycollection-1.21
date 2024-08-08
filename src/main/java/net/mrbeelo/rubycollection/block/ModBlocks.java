package net.mrbeelo.rubycollection.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.block.custom.*;
import net.mrbeelo.rubycollection.item.ModItems;
import net.mrbeelo.rubycollection.sound.ModSounds;

public class ModBlocks {

    //REGISTERING

    public static final Block RUBY_BLOCK = registerWithRubyBlockItem("ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK).sounds(ModSounds.RUBY_BLOCK_SOUNDS)));
    public static final Block RUBY_ORE = registerWithItem("ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE)));
    public static final Block DEEPSLATE_RUBY_ORE = registerWithItem("deepslate_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_EMERALD_ORE)));
    public static final Block NETHER_RUBY_ORE = registerWithItem("nether_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE)));
    public static final Block END_RUBY_ORE = registerWithItem("end_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE)));
    public static final Block KOKAINA_CROP = Registry.register(Registries.BLOCK, Rubycollection.id("kokaina_crop"), new KokainaCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block PACKED_IRON_BLOCK = registerWithItem("packed_iron_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final SMRUBlock SMOOTH_QUARTZ_RUBY_UPGRADER = registerWithItem("smooth_quartz_ruby_upgrader", new SMRUBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ)));
    public static final SMRDBlock SMOOTH_QUARTZ_RUBY_DOWNGRADER = registerWithItem("smooth_quartz_ruby_downgrader", new SMRDBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ)));
    public static final PedestalBlock PEDESTAL = registerWithItem("pedestal", new PedestalBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().nonOpaque()));
    public static final StairsBlock RUBY_STAIRS = registerWithItem("ruby_stairs", new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(ModBlocks.RUBY_BLOCK)));
    public static final SlabBlock RUBY_SLAB = registerWithItem("ruby_slab", new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.RUBY_BLOCK)));
    public static final ButtonBlock RUBY_BUTTON = registerWithItem("ruby_button", new ButtonBlock(BlockSetType.IRON ,30, AbstractBlock.Settings.copy(Blocks.STONE_BUTTON)));
    public static final PressurePlateBlock RUBY_PRESSURE_PLATE = registerWithItem("ruby_pressure_plate", new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)));
    public static final FenceBlock RUBY_FENCE = registerWithItem("ruby_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE)));
    public static final FenceGateBlock RUBY_FENCE_GATE = registerWithItem("ruby_fence_gate", new FenceGateBlock(WoodType.OAK ,AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE)));
    public static final WallBlock RUBY_WALL = registerWithItem("ruby_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE)));
    public static final DoorBlock RUBY_DOOR = registerWithItem("ruby_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().requiresTool().nonOpaque()));
    public static final TrapdoorBlock RUBY_TRAPDOOR = registerWithItem("ruby_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().requiresTool().nonOpaque()));
    public static final RGBBlock RGB_BLOCK = registerWithItem("rgb_block", new RGBBlock(AbstractBlock.Settings.copy(Blocks.STONE)));


    //METHODS

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Rubycollection.id(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public static <T extends Block> T registerWithRubyBlockItem(String name, T block) {
        T registered = register(name, block);
        Item.Settings updatedSettings = new Item.Settings().maxCount(65);
        ModItems.register(name, new BlockItem(registered, updatedSettings));
        return registered;
    }


    public static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }

    public static void registerModBlocks() {
    }
}
