package net.mrbeelo.rubycollection.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mrbeelo.rubycollection.components.ModDataComponentTypes;
import static net.mrbeelo.rubycollection.Rubycollection.vanillaCommandByPlayer;

public class MBSItem extends Item {
    public MBSItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (world.isClient()) {
            return TypedActionResult.success(stack);
        }

        int count = stack.getOrDefault(ModDataComponentTypes.MBS_STAGE, 0);
        int cooldown = stack.getOrDefault(ModDataComponentTypes.MBS_ACTIVE_COOLDOWN, 0);
        int lazer_time = stack.getOrDefault(ModDataComponentTypes.MBS_LAZER_TIME, 0);
        int glowing_time = stack.getOrDefault(ModDataComponentTypes.MBS_GLOWING_TIME, 0);
        boolean isCrouching = user.isSneaking();


        if (!isCrouching) {
            stack.set(ModDataComponentTypes.MBS_STAGE, ++count);

            if (count == 0) {
                Text beelium = Text.literal("Beelium (Current cooldown: " + cooldown + ")").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                user.sendMessage(beelium, true);
            }

            if (count == 1) {
                Text aggresium = Text.literal("Aggresium (Current cooldown: " + cooldown + ")").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                user.sendMessage(aggresium, true);
            }

            if (count == 2) {
                Text mobilium = Text.literal("Mobilium (Current cooldown: " + cooldown + ")").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 255 << 8 | 0)));
                user.sendMessage(mobilium, true);
            }

            if (count == 3) {
                Text protisium = Text.literal("Protisium (Current cooldown: " + cooldown + ")").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0 << 16 | 255 << 8 | 255)));
                user.sendMessage(protisium, true);
            }

            if (count == 4) {
                Text beelium = Text.literal("Beelium (Current cooldown: " + cooldown + ")").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                user.sendMessage(beelium, true);
            }

            if (count >= 4) {
                stack.set(ModDataComponentTypes.MBS_STAGE, 0);
            }
        }


        if (isCrouching) {
            if (cooldown == 0) {
                stack.set(ModDataComponentTypes.MBS_ACTIVE_COOLDOWN, 500);

                if (count == 0) {
                    Text beeliumA = Text.literal("Beelium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                    user.sendMessage(beeliumA, true);
                    vanillaCommandByPlayer((ServerWorld) world, user, "effect give @s resistance 5 255");
                    vanillaCommandByPlayer((ServerWorld) world, user, "effect give @s slowness 5 255");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon lightning_bolt ~ ~ ~");
                    vanillaCommandByPlayer((ServerWorld) world, user, "effect give @e[distance=..10] levitation 5 2");
                    stack.set(ModDataComponentTypes.MBS_GLOWING_TIME, 140);
                }

                if (count == 1) {
                    Text aggresiumA = Text.literal("Aggresium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                    user.sendMessage(aggresiumA, true);
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^3 {width:1b,height:1b,limit:1,Tags:[\"lazer3\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^4 {width:1b,height:1b,limit:1,Tags:[\"lazer4\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^5 {width:1b,height:1b,limit:1,Tags:[\"lazer5\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^6 {width:1b,height:1b,limit:1,Tags:[\"lazer6\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^7 {width:1b,height:1b,limit:1,Tags:[\"lazer7\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^8 {width:1b,height:1b,limit:1,Tags:[\"lazer8\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^9 {width:1b,height:1b,limit:1,Tags:[\"lazer9\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^10 {width:1b,height:1b,limit:1,Tags:[\"lazer10\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^11 {width:1b,height:1b,limit:1,Tags:[\"lazer11\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^12 {width:1b,height:1b,limit:1,Tags:[\"lazer12\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^13 {width:1b,height:1b,limit:1,Tags:[\"lazer13\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^14 {width:1b,height:1b,limit:1,Tags:[\"lazer14\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^15 {width:1b,height:1b,limit:1,Tags:[\"lazer15\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^16 {width:1b,height:1b,limit:1,Tags:[\"lazer16\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^17 {width:1b,height:1b,limit:1,Tags:[\"lazer17\",\"lazer\"]}");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^18 {width:1b,height:1b,limit:1,Tags:[\"lazer18\",\"lazer\"]}");
                    stack.set(ModDataComponentTypes.MBS_LAZER_TIME, 140);
                }

                if (count == 2) {
                    Text mobiliumA = Text.literal("Mobilium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 255 << 8 | 0)));
                    user.sendMessage(mobiliumA, true);
                    vanillaCommandByPlayer((ServerWorld) world, user, "tp @s ^ ^ ^25");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^1 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^2 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^3 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^4 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^5 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^6 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^7 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^8 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^9 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^10 0.12 0.12 0.12 1 500");
                    vanillaCommandByPlayer((ServerWorld) world, user, "summon minecraft:creeper ^ ^ ^10 {Fuse:0,ignited:1b}");
                }

                if (count == 3) {
                    Text protisiumA = Text.literal("Protisium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0 << 16 | 255 << 8 | 255)));
                    user.sendMessage(protisiumA, true);
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute as @s run effect give @e[distance=..10] regeneration 7 3");
                    vanillaCommandByPlayer((ServerWorld) world, user, "execute at @s run particle dust{color:[0.000,1.000,0.880],scale:1} ~ ~ ~ 5 0.1 5 1 10000");
                }
            } else {
                Text failed = Text.literal("Can't activate, cooldown is: " + cooldown).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                user.sendMessage(failed, true);
            }
        }
        return TypedActionResult.success(stack);
    }


}
