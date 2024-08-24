package net.mrbeelo.bsmpc;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.block.entity.ModBlockEntities;
import net.mrbeelo.bsmpc.command.ModCommands;
import net.mrbeelo.bsmpc.components.ModDataComponentTypes;
import net.mrbeelo.bsmpc.effect.ModEffects;
import net.mrbeelo.bsmpc.enchantment.ModEnchantments;
import net.mrbeelo.bsmpc.entity.ModAttributes;
import net.mrbeelo.bsmpc.entity.ModEntities;
import net.mrbeelo.bsmpc.event.PlayerCopyHandler;
import net.mrbeelo.bsmpc.fluid.ModFluids;
import net.mrbeelo.bsmpc.item.*;
import net.mrbeelo.bsmpc.particle.ModParticles;
import net.mrbeelo.bsmpc.potion.ModPotionRecipes;
import net.mrbeelo.bsmpc.potion.ModPotions;
import net.mrbeelo.bsmpc.sound.ModSounds;
import net.mrbeelo.bsmpc.villager.ModCustomTrades;
import net.mrbeelo.bsmpc.villager.ModVillagers;
import net.mrbeelo.bsmpc.world.ModWorldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.mrbeelo.bsmpc.effect.custom.HighEffect.playersWithHighSound;

public class BsmpC implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("bsmpc");
	public static final String MOD_ID = "bsmpc";

	@Override
	public void onInitialize() {
		LOGGER.info("Loading your stupid BSMP mod.");

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
		ModParticles.registerModParticles();

		ServerTickEvents.END_WORLD_TICK.register(world -> {
			if (world instanceof ServerWorld) {
				for (PlayerEntity player : world.getPlayers()) {
					if (!player.hasStatusEffect(ModEffects.HIGH) && playersWithHighSound.contains(player)) {
						playersWithHighSound.remove(player);
                        serverCommand(world, player, "stopsound @s player bsmpc:high");
                    }
				}
			}});

		ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());

		StrippableBlockRegistry.register(ModBlocks.CS_LOG, ModBlocks.STRIPPED_CS_LOG);
		StrippableBlockRegistry.register(ModBlocks.CS_WOOD, ModBlocks.STRIPPED_CS_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CS_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CS_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CS_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CS_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CS_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CS_LEAVES, 30, 60);
	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static Identifier id(String namespace, String path) {
		return Identifier.of(namespace, path);
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

	public static BlockPos getBlockInFront(PlayerEntity player, int distance) {
		// Get the player's yaw and pitch
		float yaw = player.getYaw();
		float pitch = player.getPitch();

		// Convert yaw and pitch from degrees to radians for trigonometric functions
		double yawRad = Math.toRadians(yaw);
		double pitchRad = Math.toRadians(pitch);

		// Calculate the x, y, z offsets using trigonometry
		double xOffset = -Math.sin(yawRad) * Math.cos(pitchRad) * distance;
		double yOffset = -Math.sin(pitchRad) * distance;
		double zOffset = Math.cos(yawRad) * Math.cos(pitchRad) * distance;

		// Get the player's current position
		Vec3d playerPos = player.getPos();

		// Calculate the target position by adding the offsets to the player's position
		double targetX = playerPos.x + xOffset;
		double targetY = playerPos.y + yOffset;
		double targetZ = playerPos.z + zOffset;

		// Convert the target position to a block position by casting to integers
		// We round the coordinates to get the nearest block
		int blockX = (int) Math.round(targetX);
		int blockY = (int) Math.round(targetY);
		int blockZ = (int) Math.round(targetZ);

		// Return the block position 10 blocks in front of the player
		return new BlockPos(blockX, blockY, blockZ);
	}
}

//UPDATE CHECK 19