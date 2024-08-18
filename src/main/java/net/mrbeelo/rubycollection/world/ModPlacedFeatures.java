package net.mrbeelo.rubycollection.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.mrbeelo.rubycollection.Rubycollection;

import java.util.List;

public class ModPlacedFeatures {

    //REGISTERING

    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> OVERWORLD_RUBY_ORE_KEY = registerKey("overworld_ruby_ore");
    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> END_RUBY_ORE_KEY = registerKey("end_ruby_ore");

    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> ROSE_KEY = registerKey("rose_key");

    public static void bootstrap(Registerable<net.minecraft.world.gen.feature.PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, OVERWORLD_RUBY_ORE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(-24), YOffset.fixed(64))));

        register(context, NETHER_RUBY_ORE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(128))));

        register(context, END_RUBY_ORE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(128))));

        register(context, ROSE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ROSE_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    //METHODS

    private static RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Rubycollection.id(name));
    }

    private static void register(Registerable<net.minecraft.world.gen.feature.PlacedFeature> context, RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> key, RegistryEntry<net.minecraft.world.gen.feature.ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new net.minecraft.world.gen.feature.PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<net.minecraft.world.gen.feature.PlacedFeature> context, RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> key,
                                                                                   RegistryEntry<net.minecraft.world.gen.feature.ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
