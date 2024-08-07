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
import net.mrbeelo.rubycollection.item.ModItems;

import java.util.List;

public class SCAmmoItem extends Item {
    public SCAmmoItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ItemStack heldStack = user.getStackInHand(hand);
        Item bulletItem = ModItems.BULLET;
        for (int i = 0; i < 10; i++) {
            ItemStack bulletStack = new ItemStack(bulletItem);
            if (!user.getInventory().insertStack(bulletStack)) {
                user.dropItem(bulletStack, false);
            }
        }

        user.sendMessage(Text.literal("10 bullets granted!"), true);
        heldStack.decrement(1);

        return TypedActionResult.success(heldStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A §eNeon White Soul Card§r that gives the player 10 bullets when right clicked and deletes itself."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
