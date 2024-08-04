package net.mrbeelo.rubycollection.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mrbeelo.rubycollection.item.ModItems;
import net.mrbeelo.rubycollection.util.ModTags;

import java.util.List;

public class SMRDBlock extends Block {
    public SMRDBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos,
                                 PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity item) {
            ItemStack stack = item.getStack();
            if (stack.getItem() == ModItems.RUBY_CLUSTER) {
                int clusterCount = stack.getCount();
                int ingotsToDrop = clusterCount * 5;

                // Remove the diamonds from the item entity
                item.setStack(ItemStack.EMPTY);

                // Drop rubies
                if (ingotsToDrop > 0) {
                    ItemStack rubyStack = new ItemStack(ModItems.RUBY_INGOT, ingotsToDrop);
                    ItemEntity newItemEntity = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), rubyStack);
                    world.spawnEntity(newItemEntity);
                }
            }

            if (stack.getItem() == ModItems.RUBY_INGOT) {
                int ingotCount = stack.getCount();
                int rubiesToDrop = ingotCount * 5;

                // Remove the diamonds from the item entity
                item.setStack(ItemStack.EMPTY);

                // Drop rubies
                if (rubiesToDrop > 0) {
                    ItemStack rubyStack = new ItemStack(ModItems.RUBY, rubiesToDrop);
                    ItemEntity newItemEntity = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), rubyStack);
                    world.spawnEntity(newItemEntity);
                }
            }

            if (stack.getItem() == ModItems.RUBY) {
                int rubyCount = stack.getCount();
                int shardsToDrop = rubyCount * 5;

                // Remove the diamonds from the item entity
                item.setStack(ItemStack.EMPTY);

                // Drop rubies
                if (shardsToDrop > 0) {
                    ItemStack rubyStack = new ItemStack(ModItems.RUBY_SHARD, shardsToDrop);
                    ItemEntity newItemEntity = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), rubyStack);
                    world.spawnEntity(newItemEntity);
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A block that downgrades any Ruby item to 5 of its predecessor item."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
