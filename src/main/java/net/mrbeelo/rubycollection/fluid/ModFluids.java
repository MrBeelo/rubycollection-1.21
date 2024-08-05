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
import net.mrbeelo.rubycollection.fluid.custom.CamWaterFluid;

public class ModFluids {
    public static final FlowableFluid STILL_CAM_WATER = Registry.register(Registries.FLUID,
            Rubycollection.id("cam_water"), new CamWaterFluid.Still());
    public static final FlowableFluid FLOWING_CAM_WATER = Registry.register(Registries.FLUID,
            Rubycollection.id("flowing_cam_water"), new CamWaterFluid.Flowing());

    public static final Block CAM_WATER_BLOCK = Registry.register(Registries.BLOCK, Rubycollection.id("cam_water_block"), new FluidBlock(net.mrbeelo.rubycollection.fluid.ModFluids.STILL_CAM_WATER, Block.Settings.copy(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item CAM_WATER_BUCKET = Registry.register(Registries.ITEM, Rubycollection.id("cam_water_bucket"), new BucketItem(net.mrbeelo.rubycollection.fluid.ModFluids.STILL_CAM_WATER,
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static void registerFluids() {}
}