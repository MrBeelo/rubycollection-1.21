package net.mrbeelo.rubycollection.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.block.ModBlocks;

public class ModVillagers {

    //REGISTERING

    public static final RegistryKey<PointOfInterestType> RUBY_POI_KEY = poiKey("rubypoi");
    public static final PointOfInterestType RUBY_POI = register("rubypoi", ModBlocks.RUBY_BLOCK);

    public static final VillagerProfession RUBERT = registerProfession("rubert", RUBY_POI_KEY);

    //METHODS

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Rubycollection.id(name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD));
    }

    private static PointOfInterestType register(String name, Block block) {
        return PointOfInterestHelper.register(Rubycollection.id(name), 1, 2, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Rubycollection.id(name));
    }

    public static void registerModVillagers() {}
}
