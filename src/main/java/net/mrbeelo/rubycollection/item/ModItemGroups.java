package net.mrbeelo.rubycollection.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.potion.ModPotions;


public class ModItemGroups {

    //REGISTERING

    public static final ItemGroup RUBY_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rubycollection.MOD_ID, "ruby"),
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

                    }).build());

    public static final ItemGroup BSMPS3_ARTIFACTS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rubycollection.MOD_ID, "bsmps3_artifacts"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.rubycollection.bsmps3_artifacts"))
                    .icon(() -> new ItemStack(ModItems.PISTOL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DEATH_AXE);
                        entries.add(ModBlocks.PACKED_IRON_BLOCK);

                        entries.add(ModItems.PISTOL);
                        entries.add(ModItems.BULLET);

                        entries.add(ModItems.PURIFY);

                        entries.add(ModItems.NUKE_BUTTON);

                        entries.add(ModItems.KOKAINA);
                        entries.add(ModItems.KOKAINA_LEAF);
                        entries.add(ModItems.KOKAINA_SEED);
                    }).build());


    public static void registerModItemGroups() {

    }
}
