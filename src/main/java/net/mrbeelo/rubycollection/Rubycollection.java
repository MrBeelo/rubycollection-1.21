package net.mrbeelo.rubycollection;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.block.entity.ModBlockEntities;
import net.mrbeelo.rubycollection.command.ModCommands;
import net.mrbeelo.rubycollection.components.ModDataComponentTypes;
import net.mrbeelo.rubycollection.effect.ModEffects;
import net.mrbeelo.rubycollection.enchantment.ModEnchantments;
import net.mrbeelo.rubycollection.entity.ModAttributes;
import net.mrbeelo.rubycollection.entity.ModEntities;
import net.mrbeelo.rubycollection.fluid.ModFluids;
import net.mrbeelo.rubycollection.item.*;
import net.mrbeelo.rubycollection.potion.ModPotionRecipes;
import net.mrbeelo.rubycollection.potion.ModPotions;
import net.mrbeelo.rubycollection.sound.ModSounds;
import net.mrbeelo.rubycollection.util.ModServerHandling;
import net.mrbeelo.rubycollection.villager.ModCustomTrades;
import net.mrbeelo.rubycollection.villager.ModVillagers;
import net.mrbeelo.rubycollection.world.gen.ModWorldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rubycollection implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("rubycollection");
	public static final String MOD_ID = "rubycollection";

	@Override
	public void onInitialize() {
		LOGGER.info("Loading your stupid Ruby mod.");

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
		ModEffects.registerModEffects();
		ModCommands.registerModCommands();
		ModEnchantments.registerModEnchantments();
		ModServerHandling.registerModServerHandling();
	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static void vanillaCommandByPlayer(ServerWorld world, PlayerEntity user, String command) {
		if (user != null) {
			ServerCommandSource source = user.getCommandSource().withSilent().withEntity(user);
			try {
				world.getServer().getCommandManager().getDispatcher().execute(command, source);
			} catch (CommandSyntaxException e) {
				user.sendMessage(Text.literal("Command failed: " + e.getMessage()), false);
			}
		} else {
			user.sendMessage(Text.literal("User not found"), false);
		}
	}
}

//UPDATE CHECK 18