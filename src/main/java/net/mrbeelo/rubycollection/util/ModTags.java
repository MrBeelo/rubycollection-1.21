package net.mrbeelo.rubycollection.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.mrbeelo.rubycollection.Rubycollection;

public class ModTags {

    //REGISTERING

    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = TagKey.of(RegistryKeys.BLOCK, Rubycollection.id("incorrect_for_ruby_tool"));
        public static final TagKey<Block> RUBY_ORES = TagKey.of(RegistryKeys.BLOCK, Rubycollection.id("ruby_ores"));
        public static final TagKey<Block> RUBY_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Rubycollection.id("ruby_blocks"));
    }

    public static class Items {
        public static final TagKey<Item> RUBY_ITEMS = TagKey.of(RegistryKeys.ITEM, Rubycollection.id("ruby_items"));
        public static final TagKey<Item> RUBY_TOOLS = TagKey.of(RegistryKeys.ITEM, Rubycollection.id("ruby_tools"));
        public static final TagKey<Item> RUBY_ARMOR = TagKey.of(RegistryKeys.ITEM, Rubycollection.id("ruby_armor"));
        public static final TagKey<Item> RUBY_VARIANTS = TagKey.of(RegistryKeys.ITEM, Rubycollection.id("ruby_variants"));
        public static final TagKey<Item> KOKAINA_FAMILY = TagKey.of(RegistryKeys.ITEM, Rubycollection.id("kokaina_family"));

    }
}
