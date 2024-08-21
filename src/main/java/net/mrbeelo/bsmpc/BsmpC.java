package net.mrbeelo.bsmpc;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.block.entity.ModBlockEntities;
import net.mrbeelo.bsmpc.command.ModCommands;
import net.mrbeelo.bsmpc.components.ModDataComponentTypes;
import net.mrbeelo.bsmpc.effect.ModEffects;
import net.mrbeelo.bsmpc.enchantment.ModEnchantments;
import net.mrbeelo.bsmpc.entity.ModAttributes;
import net.mrbeelo.bsmpc.entity.ModEntities;
import net.mrbeelo.bsmpc.fluid.ModFluids;
import net.mrbeelo.bsmpc.item.*;
import net.mrbeelo.bsmpc.potion.ModPotionRecipes;
import net.mrbeelo.bsmpc.potion.ModPotions;
import net.mrbeelo.bsmpc.sound.ModSounds;
import net.mrbeelo.bsmpc.server.ModServerInitHandler;
import net.mrbeelo.bsmpc.villager.ModCustomTrades;
import net.mrbeelo.bsmpc.villager.ModVillagers;
import net.mrbeelo.bsmpc.world.ModWorldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BsmpC implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("bsmpc");
	public static final String MOD_ID = "bsmpc";

	@Override
	public void onInitialize() {
		LOGGER.info("Loading your stupid BSMP mod.");

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
		ModServerInitHandler.registerModServerInitHandler();
	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static void serverCommand(ServerWorld world, PlayerEntity user, String command) {
		if (user != null) {
			// Get a ServerCommandSource with elevated permissions
			ServerCommandSource source = new ServerCommandSource(
					user,
					user.getPos(),
					user.getRotationClient(),
					world,
					4, // Permission level 4 (OP level)
					user.getName().getString(),
					user.getDisplayName(),
					world.getServer(),
					user
			).withSilent(); // This makes the command output silent

			try {
				// Execute the command using the elevated source
				world.getServer().getCommandManager().getDispatcher().execute(command, source);
			} catch (CommandSyntaxException e) {
				user.sendMessage(Text.literal("Command failed: " + e.getMessage()), false);
			}
		} else {
			user.sendMessage(Text.literal("User not found"), false);
		}
	}
}

//UPDATE CHECK 19