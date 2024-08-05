package net.mrbeelo.rubycollection;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.block.entity.ModBlockEntities;
import net.mrbeelo.rubycollection.components.ModDataComponentTypes;
import net.mrbeelo.rubycollection.entity.ModAttributes;
import net.mrbeelo.rubycollection.entity.ModEntities;
import net.mrbeelo.rubycollection.fluid.ModFluids;
import net.mrbeelo.rubycollection.item.*;
import net.mrbeelo.rubycollection.potion.ModPotionRecipes;
import net.mrbeelo.rubycollection.potion.ModPotions;
import net.mrbeelo.rubycollection.sound.ModSounds;
import net.mrbeelo.rubycollection.util.ModModelPredicates;
import net.mrbeelo.rubycollection.villager.ModCustomTrades;
import net.mrbeelo.rubycollection.villager.ModVillagers;
import net.mrbeelo.rubycollection.world.gen.ModOreGeneration;
import net.mrbeelo.rubycollection.world.gen.ModWorldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rubycollection implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("rubycollection");
	public static final String MOD_ID = "rubycollection";

	@Override
	public void onInitialize() {
		LOGGER.info("Loading...");

		//LOAD ALL MODADDONS CLASSES (INITS)
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModWorldGenerator.generateModWorldGeneration();
		ModArmorMaterials.registerModArmorMaterials();
		ModSounds.registerModSounds();
		ModVillagers.registerModVillagers();
		ModCustomTrades.registerModCustomTrades();
		ModPotions.registerModPotions();
		ModPotionRecipes.registerModPotionRecipes();
		ModFuelItems.registerModFuelItems();
		ModComposterItems.registerModComposterItems();
		ModBlockEntities.registerModBlockEntities();
		ModDataComponentTypes.registerModDataComponentTypes();
		ModEntities.registerModEntities();
		ModAttributes.registerModAttributes();
		ModFluids.registerFluids();

	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

//UPDATE CHECK 16