package net.mrbeelo.rubycollection.server;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.server.world.ServerWorld;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.event.PlayerCopyHandler;

public class ModServerInitHandler {
    public static void registerModServerInitHandler() {
        ServerTickEvents.START_WORLD_TICK.register(world -> {if (world instanceof ServerWorld) {
            ModServerTickHandler.registerModServerTickHandler((ServerWorld) world);}});
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
}
