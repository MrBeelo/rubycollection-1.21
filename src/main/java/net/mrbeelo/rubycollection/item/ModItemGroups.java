package net.mrbeelo.rubycollection.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.fluid.ModFluids;
import java.util.Optional;


public class ModItemGroups {

    //REGISTERING

    public static final ItemGroup RUBY_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Rubycollection.id("ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.rubycollection.ruby_item_group"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RUBY_INGOT);
                        entries.add(ModItems.RUBY_CLUSTER);
                        entries.add(ModItems.RUBY_SHARD);

                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_BOW);
                        entries.add(ModItems.RUBY_KNOCKER);

                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_RUBY_ORE);
                        entries.add(ModBlocks.SMOOTH_QUARTZ_RUBY_UPGRADER);
                        entries.add(ModBlocks.SMOOTH_QUARTZ_RUBY_DOWNGRADER);
                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_SLAB);
                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_WALL);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);
                    }).build());

    public static final ItemGroup BSMPS3_ARTIFACTS = Registry.register(Registries.ITEM_GROUP,
            Rubycollection.id("bsmps3_artifacts"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.rubycollection.bsmps3_artifacts"))
                    .icon(() -> new ItemStack(ModItems.PISTOL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DEATH_AXE);
                        entries.add(ModBlocks.PACKED_IRON_BLOCK);

                        entries.add(ModItems.PISTOL);
                        entries.add(ModItems.BULLET);

                        entries.add(ModItems.NUKE_BUTTON);

                        entries.add(ModItems.KOKAINA);
                        entries.add(ModItems.KOKAINA_SEED);

                        entries.add(ModItems.MASTER_BEELO_STAFF);

                        entries.add(ModBlocks.PEDESTAL);

                        entries.add(ModItems.SNEK_SPAWN_EGG);

                        entries.add(ModItems.XO_MUSIC_DISC);

                        entries.add(ModFluids.FROOTOP_BUCKET);

                        entries.add(ModBlocks.RGB_BLOCK);

                        entries.add(ModItems.POKE_BALL);

                        entries.add(ModBlocks.ROSE);

                        entries.add(ModBlocks.CS_LOG);
                        entries.add(ModBlocks.CS_WOOD);
                        entries.add(ModBlocks.STRIPPED_CS_LOG);
                        entries.add(ModBlocks.STRIPPED_CS_WOOD);
                        entries.add(ModBlocks.CS_PLANKS);
                        entries.add(ModBlocks.CS_LEAVES);
                        entries.add(ModBlocks.CS_SAPLING);
                        entries.add(ModBlocks.CS_STAIRS);
                        entries.add(ModBlocks.CS_SLAB);
                        entries.add(ModBlocks.CS_BUTTON);
                        entries.add(ModBlocks.CS_PRESSURE_PLATE);
                        entries.add(ModBlocks.CS_FENCE);
                        entries.add(ModBlocks.CS_FENCE_GATE);
                        entries.add(ModBlocks.CS_DOOR);
                        entries.add(ModBlocks.CS_TRAPDOOR);
                    }).build());

    public static final ItemGroup NEON_WHITE_SOUL_CARDS = Registry.register(Registries.ITEM_GROUP,
            Rubycollection.id("neon_white_soul_cards"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.rubycollection.neon_white_soul_cards"))
                    .icon(() -> new ItemStack(ModItems.SC_PURIFY))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SC_AMMO);
                        entries.add(ModItems.SC_BOOK_OF_LIFE);
                        entries.add(ModItems.SC_DOMINION);
                        entries.add(ModItems.SC_ELEVATE);
                        entries.add(ModItems.SC_FIREBALL);
                        entries.add(ModItems.SC_FIST);
                        entries.add(ModItems.SC_GODSPEED);
                        entries.add(ModItems.SC_HEALTH);
                        entries.add(ModItems.SC_KATANA);
                        entries.add(ModItems.SC_PURIFY);
                        entries.add(ModItems.SC_STOMP);
                    }).build());

    public static final ItemGroup EVERYTHING = Registry.register(Registries.ITEM_GROUP,
            Rubycollection.id("everything"),
            FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.rubycollection.everything"))
            .icon(() -> new ItemStack(ModItems.RUBY_INGOT))
            .entries((displayContext, entries) -> Registries.ITEM.getIds()
                    .stream()
                    .filter(key -> key.getNamespace().equals(Rubycollection.MOD_ID))
                    .map(Registries.ITEM::getOrEmpty)
                    .map(Optional::orElseThrow)
                    .filter(item -> !ModItems.BLACKLIST.contains(item))
                    .forEach(entries::add))
            .build());


    public static void registerModItemGroups() {

    }
}
