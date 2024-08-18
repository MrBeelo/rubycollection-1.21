package net.mrbeelo.rubycollection.server;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;
import net.mrbeelo.rubycollection.event.PlayerCopyHandler;

public class ModServerInitHandler {
    public static void registerModServerInitHandler() {
        ServerTickEvents.START_WORLD_TICK.register(world -> {if (world instanceof ServerWorld) {
            ModServerTickHandler.registerModServerTickHandler((ServerWorld) world);}});
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }
}
