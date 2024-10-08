package net.mrbeelo.bsmpc.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.mrbeelo.bsmpc.util.IEntityDataSaver;

public class PlayerCopyHandler implements ServerPlayerEvents.CopyFrom {
    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        ((IEntityDataSaver) newPlayer).getPersistentData().putIntArray("bsmpc.homepos",
                ((IEntityDataSaver) oldPlayer).getPersistentData().getIntArray("bsmpc.homepos"));
    }
}
