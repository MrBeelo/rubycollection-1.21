package net.mrbeelo.bsmpc.item.custom.neon_white;

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

public class SCPurifyItem extends Item {
    public SCPurifyItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        user.sendMessage(Text.literal("Imagine me throwing a purple spiked bomb."), false);
        ItemStack heldStack = user.getStackInHand(hand);
        heldStack.decrement(1);

        ArrowEntity arrow = new ArrowEntity(EntityType.ARROW, world);
        arrow.setPos(user.getX(), user.getEyeY() - 0.1, user.getZ());
        arrow.setOwner(user);
        arrow.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
        world.spawnEntity(arrow);

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