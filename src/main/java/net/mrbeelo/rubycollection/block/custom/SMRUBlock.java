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

public class SMRUBlock extends Block {
    public SMRUBlock(Settings settings) {
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
            if (stack.getItem() == ModItems.RUBY_SHARD) {
                int shardCount = stack.getCount();
                int rubiesToDrop = shardCount / 5;
                int remainingShards = shardCount % 5;

                if (rubiesToDrop > 0) {
                    item.setStack(new ItemStack(ModItems.RUBY, rubiesToDrop));
                    if (remainingShards > 0) {
                        // Recreate the ItemEntity with the remaining rubies
                        ItemStack remainingStack = new ItemStack(ModItems.RUBY_SHARD, remainingShards);
                        ItemEntity newItemEntity = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), remainingStack);
                        world.spawnEntity(newItemEntity);
                    }
                }
            }

            if (stack.getItem() == ModItems.RUBY) {
                int rubyCount = stack.getCount();
                int ingotsToDrop = rubyCount / 5;
                int remainingRubies = rubyCount % 5;

                if (ingotsToDrop > 0) {
                    item.setStack(new ItemStack(ModItems.RUBY_INGOT, ingotsToDrop));
                    if (remainingRubies > 0) {
                        // Recreate the ItemEntity with the remaining rubies
                        ItemStack remainingStack = new ItemStack(ModItems.RUBY, remainingRubies);
                        ItemEntity newItemEntity = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), remainingStack);
                        world.spawnEntity(newItemEntity);
                    }
                }
            }

            if (stack.getItem() == ModItems.RUBY_INGOT) {
                int ingotCount = stack.getCount();
                int clustersToDrop = ingotCount / 5;
                int remainingIngots = ingotCount % 5;

                if (clustersToDrop > 0) {
                    item.setStack(new ItemStack(ModItems.RUBY_CLUSTER, clustersToDrop));
                    if (remainingIngots > 0) {
                        // Recreate the ItemEntity with the remaining rubies
                        ItemStack remainingStack = new ItemStack(ModItems.RUBY_INGOT, remainingIngots);
                        ItemEntity newItemEntity = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), remainingStack);
                        world.spawnEntity(newItemEntity);
                    }
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
            tooltip.add(Text.literal("A block that upgrades any 5 Ruby items to its superior item."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
