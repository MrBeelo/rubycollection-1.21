package net.mrbeelo.bsmpc.item.custom.neon_white;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.item.ModItems;

import java.util.List;
import java.util.Random;

public class SCBookOfLifeItem extends Item {
    public SCBookOfLifeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {return TypedActionResult.pass(user.getStackInHand(hand));}

        Random random = new Random();

        ItemStack heldStack = user.getStackInHand(hand);

        if (user != null && world != null) {

            Item[] cardItems = {
                    ModItems.SC_AMMO,
                    ModItems.SC_DOMINION,
                    ModItems.SC_ELEVATE,
                    ModItems.SC_FIREBALL,
                    ModItems.SC_FIST,
                    ModItems.SC_GODSPEED,
                    ModItems.SC_HEALTH,
                    ModItems.SC_KATANA,
                    ModItems.SC_PURIFY,
                    ModItems.SC_STOMP
            };

            Item randomCardItem = cardItems[random.nextInt(cardItems.length)];


            // Decrement the item stack

            for (int i = 0; i < 1; i++) {
                ItemStack cardStack = new ItemStack(randomCardItem);
                if (!user.getInventory().insertStack(cardStack)) {
                    user.dropItem(cardStack, false);
                }
            }

            user.sendMessage(Text.literal("You got blessed!"), true);
            heldStack.decrement(1);

            return TypedActionResult.success(heldStack, world.isClient());
        }

        return TypedActionResult.success(heldStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A §eNeon White Soul Card§r that gives the player a random soul card when right clicked and deletes itself."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
