package net.mrbeelo.rubycollection.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;
import net.mrbeelo.rubycollection.event.ServerTickManager;
import net.mrbeelo.rubycollection.event.PlayerCopyHandler;

public class ModServerHandling {
    public static void registerModServerHandling() {
        ServerTickEvents.START_WORLD_TICK.register(world -> {if (world instanceof ServerWorld) {
            ServerTickManager.updateCooldowns((ServerWorld) world);}});
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }
}
