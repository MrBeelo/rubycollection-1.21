package net.mrbeelo.rubycollection;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.mrbeelo.rubycollection.datagen.*;
import net.mrbeelo.rubycollection.world.ConfiguredFeature;
import net.mrbeelo.rubycollection.world.PlacedFeature;


public class RubycollectionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModTranslationProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGeneratorProvider::new);
		pack.addProvider(ModPoiTagProvider::new);
		pack.addProvider(ModFluidTagProvider::new);
		pack.addProvider(ModEnchantmentGeneratorProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeature::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeature::bootstrap);
	}
}
