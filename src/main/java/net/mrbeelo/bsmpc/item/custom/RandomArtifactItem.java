package net.mrbeelo.bsmpc.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.fluid.ModFluids;
import net.mrbeelo.bsmpc.item.ModItems;
import net.mrbeelo.bsmpc.util.ModTags;

import java.util.List;
import java.util.Random;

public class RandomArtifactItem extends Item {
    public RandomArtifactItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {return TypedActionResult.pass(user.getStackInHand(hand));}

        Random random = new Random();

        ItemStack heldStack = user.getStackInHand(hand);

        if (user != null && world != null) {

            Item[] cardItems = {
                    ModItems.DEATH_AXE,
                    ModItems.PISTOL,
                    ModItems.NUKE_BUTTON,
                    ModItems.KOKAINA,
                    ModItems.KOKAINA_SEED,
                    ModItems.MASTER_BEELO_STAFF,
                    ModBlocks.PEDESTAL.asItem(),
                    ModItems.SNEK_SPAWN_EGG,
                    ModItems.XO_MUSIC_DISC,
                    ModFluids.FROOTOP_BUCKET,
                    ModBlocks.RGB_BLOCK.asItem(),
                    ModItems.POKE_BALL,
                    ModBlocks.ROSE.asItem()
            };

            Item randomCardItem = cardItems[random.nextInt(cardItems.length)];


            // Decrement the item stack

            for (int i = 0; i < 1; i++) {
                ItemStack cardStack = new ItemStack(randomCardItem);
                if (!user.getInventory().insertStack(cardStack)) {
                    user.dropItem(cardStack, false);
                }
            }

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
            tooltip.add(Text.literal("An item that gives the player a random artifact"));
            tooltip.add(Text.literal("when right clicked and deletes itself."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
