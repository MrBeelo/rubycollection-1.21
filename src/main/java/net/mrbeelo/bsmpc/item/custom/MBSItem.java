package net.mrbeelo.bsmpc.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.components.ModDataComponentTypes;

import static net.mrbeelo.bsmpc.BsmpC.serverCommand;


public class MBSItem extends Item {
    public MBSItem(Settings settings) {
        super(settings);
    }

    private int lazerDuration = 0;
    private int glowingDuration = 0;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (world.isClient()) {
            return TypedActionResult.success(stack);
        }

        int count = stack.getOrDefault(ModDataComponentTypes.MBS_STAGE, 0);
        int lazer_time = stack.getOrDefault(ModDataComponentTypes.MBS_LAZER_TIME, 0);
        int glowing_time = stack.getOrDefault(ModDataComponentTypes.MBS_GLOWING_TIME, 0);



        if (!user.isSneaking()) {
            stack.set(ModDataComponentTypes.MBS_STAGE, ++count);

            if (count == 0) {
                Text beelium = Text.literal("Beelium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                user.sendMessage(beelium, true);
            }

            if (count == 1) {
                Text aggresium = Text.literal("Aggresium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                user.sendMessage(aggresium, true);
            }

            if (count == 2) {
                Text mobilium = Text.literal("Mobilium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 255 << 8 | 0)));
                user.sendMessage(mobilium, true);
            }

            if (count == 3) {
                Text protisium = Text.literal("Protisium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0 << 16 | 255 << 8 | 255)));
                user.sendMessage(protisium, true);
            }

            if (count == 4) {
                Text beelium = Text.literal("Beelium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                user.sendMessage(beelium, true);
            }

            if (count >= 4) {
                stack.set(ModDataComponentTypes.MBS_STAGE, 0);
            }
        }


        if (user.isSneaking()) {
            if (!user.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                user.getItemCooldownManager().set(stack.getItem(), 500);

                if (count == 0) {
                    Text beeliumA = Text.literal("Beelium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                    user.sendMessage(beeliumA, true);
                    serverCommand((ServerWorld) world, user, "effect give @s resistance 5 255");
                    serverCommand((ServerWorld) world, user, "effect give @s slowness 5 255");
                    serverCommand((ServerWorld) world, user, "execute at @s run summon lightning_bolt ~ ~ ~");
                    serverCommand((ServerWorld) world, user, "effect give @e[distance=..10] levitation 5 2");
                    //stack.set(ModDataComponentTypes.MBS_GLOWING_TIME, 140);
                    glowingDuration = 140;
                }

                if (count == 1) {
                    Text aggresiumA = Text.literal("Aggresium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                    user.sendMessage(aggresiumA, true);
                    for (int i = 3; i <= 18; i++) {
                        serverCommand((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^" + i + " {width:1b,height:1b,limit:1,Tags:['lazer" + i + "','lazer']}");
                    }
                    //stack.set(ModDataComponentTypes.MBS_LAZER_TIME, 140);
                    lazerDuration = 140;
                }

                if (count == 2) {
                    Text mobiliumA = Text.literal("Mobilium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 255 << 8 | 0)));
                    user.sendMessage(mobiliumA, true);
                    serverCommand((ServerWorld) world, user, "tp @s ^ ^ ^25");
                    for (int i = 1; i <= 10; i++) {
                        serverCommand((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^" + i + " 0.12 0.12 0.12 1 500");
                    }
                    serverCommand((ServerWorld) world, user, "summon minecraft:creeper ^ ^ ^10 {Fuse:0,ignited:1b}");
                }

                if (count == 3) {
                    Text protisiumA = Text.literal("Protisium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0 << 16 | 255 << 8 | 255)));
                    user.sendMessage(protisiumA, true);
                    serverCommand((ServerWorld) world, user, "execute as @s run effect give @e[distance=..10] regeneration 7 3");
                    serverCommand((ServerWorld) world, user, "execute at @s run particle dust{color:[0.000,1.000,0.880],scale:1} ~ ~ ~ 5 0.1 5 1 10000");
                }
            }
        }
        return TypedActionResult.success(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            serverCommand((ServerWorld) world, player, "execute at @e[type=minecraft:interaction,tag=lazer] if entity @e[distance=..1.7] run execute as @e[distance=..1.7] run effect give @s instant_damage 1 1");
            if (lazerDuration > 1) {
                for (int i = 3; i <= 18; i++) {
                    serverCommand((ServerWorld) world, player, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^" + i + " 0.25 0.25 0.25 1 1000");
                    serverCommand((ServerWorld) world, player, "execute at @s run tp @e[tag=lazer" + i + ", limit=1, sort=nearest] ^ ^ ^" + i);
                }

            }

            if (lazerDuration == 1) {
                for (int i = 3; i <= 18; i++) {
                    serverCommand((ServerWorld) world, player, "execute at @s run kill @n[tag=lazer" + i + ", distance=..20]");
                }
            }

            if (lazerDuration > 0) {
                lazerDuration--;
            }

            if (glowingDuration > 0) {
                glowingDuration--;
                serverCommand((ServerWorld) world, player, "execute as @s at @e[distance=..10] run particle dust{color:[1.000,0.480,0.000],scale:1} ~ ~ ~ 0.6 0.6 0.6 1 50");
            }
        }
    }


}
