package net.mrbeelo.rubycollection.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class PurifyItem extends Item {
    public PurifyItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Ensure we don't execute this code on the client to prevent desync.
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        // Send message to player
        user.sendMessage(Text.literal("Imagine me throwing a purple spiked bomb."), false);

        // Get the ItemStack being held
        ItemStack heldStack = user.getStackInHand(hand);

        // Decrease the stack size by 1
        heldStack.decrement(1);

        // Create and shoot an arrow
        ArrowEntity arrow = new ArrowEntity(EntityType.ARROW, world);
        arrow.setPos(user.getX(), user.getEyeY() - 0.1, user.getZ());
        arrow.setOwner(user);
        arrow.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
        world.spawnEntity(arrow);

        // Return the modified ItemStack wrapped in TypedActionResult.success
        return TypedActionResult.success(heldStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A §eNeon White Soul Card§r that throws a purple spiked bomb when right clicked and deletes itself."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}