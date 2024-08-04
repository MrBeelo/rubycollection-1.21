package net.mrbeelo.rubycollection;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.item.ModArmorMaterials;
import net.mrbeelo.rubycollection.item.ModItemGroups;
import net.mrbeelo.rubycollection.item.ModItems;
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

	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

//UPDATE CHECK 15