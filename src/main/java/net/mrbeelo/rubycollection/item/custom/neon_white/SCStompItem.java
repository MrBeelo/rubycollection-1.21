package net.mrbeelo.rubycollection.item.custom.neon_white;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class SCStompItem extends Item {
    private static final double FALL_VELOCITY = -2.0; // Adjust this value to increase/decrease falling speed

    public SCStompItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ItemStack heldStack = user.getStackInHand(hand);

        // Apply a strong downward velocity to the player
        if (user != null && world != null) {
            user.setVelocity(user.getVelocity().x, FALL_VELOCITY, user.getVelocity().z);
            user.velocityModified = true;

            heldStack.decrement(1);
            user.getInventory().markDirty();
        }

        return TypedActionResult.success(heldStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A §eNeon White Soul Card§r that makes the player fall quickly when right-clicked and deletes itself."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
