package net.mrbeelo.rubycollection.item.custom;

import net.minecraft.component.Component;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mrbeelo.rubycollection.components.ModDataComponentTypes;

public class MBSItem extends Item {
    public MBSItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        // Don't do anything on the client
        if (world.isClient()) {
            return TypedActionResult.success(stack);
        }

        // Check if the player is crouching (sneaking)
        boolean isCrouching = user.isSneaking();

        // Read the current count and increase it by one
        int count = stack.getOrDefault(ModDataComponentTypes.MBS_STAGE, 0);


        if (!isCrouching) {
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


        if (isCrouching) {
            if (count == 0) {
                Text beeliumA = Text.literal("Beelium Activated").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                user.sendMessage(beeliumA, true);
            }

            if (count == 1) {
                Text aggresiumA = Text.literal("Aggresium Activated").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                user.sendMessage(aggresiumA, true);
            }

            if (count == 2) {
                Text mobiliumA = Text.literal("Mobilium Activated").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 255 << 8 | 0)));
                user.sendMessage(mobiliumA, true);
            }

            if (count == 3) {
                Text protisiumA = Text.literal("Protisium Activated").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0 << 16 | 255 << 8 | 255)));
                user.sendMessage(protisiumA, true);
            }
        }
        return TypedActionResult.success(stack);
    }
}
