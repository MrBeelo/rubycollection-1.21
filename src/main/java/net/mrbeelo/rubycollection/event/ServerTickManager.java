package net.mrbeelo.rubycollection.event;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.mrbeelo.rubycollection.components.ModDataComponentTypes;

import static net.mrbeelo.rubycollection.Rubycollection.vanillaCommandByPlayer;

public class ServerTickManager {


    public static void updateCooldowns(ServerWorld world) {
        for (PlayerEntity user : world.getPlayers()) {
            ItemStack stack = user.getMainHandStack();
            int cooldown = stack.getOrDefault(ModDataComponentTypes.MBS_ACTIVE_COOLDOWN, 0);
            if (cooldown > 0) {stack.set(ModDataComponentTypes.MBS_ACTIVE_COOLDOWN, cooldown - 1);}
            int lazer_time = stack.getOrDefault(ModDataComponentTypes.MBS_LAZER_TIME, 0);
            if (lazer_time > 0) {stack.set(ModDataComponentTypes.MBS_LAZER_TIME, lazer_time - 1);}
            int glowing_time = stack.getOrDefault(ModDataComponentTypes.MBS_GLOWING_TIME, 0);
            if (glowing_time > 0) {stack.set(ModDataComponentTypes.MBS_GLOWING_TIME, glowing_time - 1);}
            vanillaCommandByPlayer((ServerWorld) world, user, "execute at @e[type=minecraft:interaction,tag=lazer] run execute as @e[distance=..1.7] run effect give @s instant_damage 1 1");

            if (lazer_time > 0) {
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^3 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^4 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^5 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^6 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^7 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^8 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^9 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^10 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^11 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^12 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^13 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^14 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^15 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^16 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^17 0.25 0.25 0.25 1 1000");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^18 0.25 0.25 0.25 1 1000");

                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer3] ^ ^ ^3");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer4] ^ ^ ^4");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer5] ^ ^ ^5");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer6] ^ ^ ^6");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer7] ^ ^ ^7");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer8] ^ ^ ^8");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer9] ^ ^ ^9");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer10] ^ ^ ^10");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer11] ^ ^ ^11");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer12] ^ ^ ^12");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer13] ^ ^ ^13");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer14] ^ ^ ^14");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer15] ^ ^ ^15");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer16] ^ ^ ^16");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer17] ^ ^ ^17");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run tp @e[tag=lazer18] ^ ^ ^18");
            }

            if (lazer_time == 0) {
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer3, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer4, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer5, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer6, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer7, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer8, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer9, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer10, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer11, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer12, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer13, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer14, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer15, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer16, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer17, distance=..20]");
                vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run kill @e[tag=lazer18, distance=..20]");
            }

            if (glowing_time > 0) {
                vanillaCommandByPlayer((ServerWorld) world, user, "execute as @s at @e[distance=..10] run particle dust{color:[1.000,0.480,0.000],scale:1} ~ ~ ~ 0.6 0.6 0.6 1 50");
            }
        }
    }
}
