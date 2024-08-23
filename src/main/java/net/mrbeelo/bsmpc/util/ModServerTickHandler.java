package net.mrbeelo.bsmpc.util;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;


public class ModServerTickHandler {


    public static void registerModServerTickHandler(ServerWorld world) {
        for (PlayerEntity user : world.getPlayers()) {
            ItemStack stack = user.getMainHandStack();
        }
    }
}
