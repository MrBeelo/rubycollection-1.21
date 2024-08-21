package net.mrbeelo.bsmpc.server;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.mrbeelo.bsmpc.components.ModDataComponentTypes;

import java.util.List;

import static net.mrbeelo.bsmpc.BsmpC.serverCommand;


public class ModServerTickHandler {


    public static void registerModServerTickHandler(ServerWorld world) {
        for (PlayerEntity user : world.getPlayers()) {
            ItemStack stack = user.getMainHandStack();
            int cooldown = stack.getOrDefault(ModDataComponentTypes.MBS_ACTIVE_COOLDOWN, 0);
            if (cooldown > 0) {stack.set(ModDataComponentTypes.MBS_ACTIVE_COOLDOWN, cooldown - 1);}
            int lazer_time = stack.getOrDefault(ModDataComponentTypes.MBS_LAZER_TIME, 0);
            if (lazer_time > 0) {stack.set(ModDataComponentTypes.MBS_LAZER_TIME, lazer_time - 1);}
            int glowing_time = stack.getOrDefault(ModDataComponentTypes.MBS_GLOWING_TIME, 0);
            if (glowing_time > 0) {stack.set(ModDataComponentTypes.MBS_GLOWING_TIME, glowing_time - 1);}
            serverCommand((ServerWorld) world, user, "execute at @e[type=minecraft:interaction,tag=lazer] if entity @e[distance=..1.7] run execute as @e[distance=..1.7] run effect give @s instant_damage 1 1");

            if (lazer_time > 1) {
                for (int i = 3; i <= 18; i++) {
                    serverCommand((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^" + i + " 0.25 0.25 0.25 1 1000");
                    serverCommand((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer" + i + ", limit=1, sort=nearest] ^ ^ ^" + i);
                }

            }

            if (lazer_time == 1) {
                for (int i = 3; i <= 18; i++) {
                    serverCommand((ServerWorld) world, user, "execute at @s run kill @n[tag=lazer" + i + ", distance=..20]");
                }
            }

            if (glowing_time > 0) {
                serverCommand((ServerWorld) world, user, "execute as @s at @e[distance=..10] run particle dust{color:[1.000,0.480,0.000],scale:1} ~ ~ ~ 0.6 0.6 0.6 1 50");
            }
        }
    }
}
