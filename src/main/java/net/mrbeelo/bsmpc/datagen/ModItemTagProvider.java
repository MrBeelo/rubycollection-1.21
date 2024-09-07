package net.mrbeelo.bsmpc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.item.ModItems;
import net.mrbeelo.bsmpc.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.RUBY_SWORD)
                .add(ModItems.WARDEN_SWORD)
                .add(ModItems.RUBY_KNOCKER);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.RUBY_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.RUBY_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.RUBY_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.RUBY_HOE);

        getOrCreateTagBuilder(ModTags.Items.RUBY_TOOLS)
                .add(ModItems.RUBY_SWORD)
                .add(ModItems.RUBY_PICKAXE)
                .add(ModItems.RUBY_AXE)
                .add(ModItems.RUBY_SHOVEL)
                .add(ModItems.RUBY_HOE)
                .add(ModItems.RUBY_KNOCKER);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.RUBY_HELMET).add(ModItems.SNEK_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.RUBY_CHESTPLATE).add(ModItems.SNEK_CHESTPLATE).add(ModItems.JETPACK);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.RUBY_LEGGINGS).add(ModItems.SNEK_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.RUBY_BOOTS).add(ModItems.SNEK_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.RUBY_ARMOR)
                .add(ModItems.RUBY_HELMET)
                .add(ModItems.RUBY_CHESTPLATE)
                .add(ModItems.RUBY_LEGGINGS)
                .add(ModItems.RUBY_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.RUBY_VARIANTS)
                .add(ModItems.RUBY_SHARD)
                .add(ModItems.RUBY)
                .add(ModItems.RUBY_INGOT)
                .add(ModItems.RUBY_CLUSTER);

        getOrCreateTagBuilder(ModTags.Items.RUBY_ITEMS)
                .addTag(ModTags.Items.RUBY_TOOLS)
                .addTag(ModTags.Items.RUBY_ARMOR)
                .addTag(ModTags.Items.RUBY_VARIANTS);

        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .addTag(ModTags.Items.RUBY_VARIANTS);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CS_LOG.asItem(), ModBlocks.CS_WOOD.asItem(), ModBlocks.STRIPPED_CS_LOG.asItem(), ModBlocks.STRIPPED_CS_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CS_PLANKS.asItem());
    }
}
