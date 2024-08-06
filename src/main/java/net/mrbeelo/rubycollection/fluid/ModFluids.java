package net.mrbeelo.rubycollection.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.fluid.custom.FrootopFluid;

public class ModFluids {
    public static final FlowableFluid STILL_FROOTOP = Registry.register(Registries.FLUID,
            Rubycollection.id("frootop"), new FrootopFluid.Still());
    public static final FlowableFluid FLOWING_FROOTOP = Registry.register(Registries.FLUID,
            Rubycollection.id("flowing_frootop"), new FrootopFluid.Flowing());

    public static final Block FROOTOP_BLOCK = Registry.register(Registries.BLOCK, Rubycollection.id("frootop_block"), new FluidBlock(net.mrbeelo.rubycollection.fluid.ModFluids.STILL_FROOTOP, Block.Settings.copy(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item FROOTOP_BUCKET = Registry.register(Registries.ITEM, Rubycollection.id("frootop_bucket"), new BucketItem(net.mrbeelo.rubycollection.fluid.ModFluids.STILL_FROOTOP,
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static void registerFluids() {}
}
