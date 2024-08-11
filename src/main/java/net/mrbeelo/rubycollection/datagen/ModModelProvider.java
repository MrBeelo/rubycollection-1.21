package net.mrbeelo.rubycollection.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.block.custom.KokainaCropBlock;
import net.mrbeelo.rubycollection.block.custom.RGBBlock;
import net.mrbeelo.rubycollection.fluid.ModFluids;
import net.mrbeelo.rubycollection.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_RUBY_ORE);
        blockStateModelGenerator.registerCrop(ModBlocks.KOKAINA_CROP, KokainaCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_IRON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMOOTH_QUARTZ_RUBY_UPGRADER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMOOTH_QUARTZ_RUBY_DOWNGRADER);
        rubyTexturePool.stairs(ModBlocks.RUBY_STAIRS);
        rubyTexturePool.slab(ModBlocks.RUBY_SLAB);
        rubyTexturePool.button(ModBlocks.RUBY_BUTTON);
        rubyTexturePool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyTexturePool.fence(ModBlocks.RUBY_FENCE);
        rubyTexturePool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyTexturePool.wall(ModBlocks.RUBY_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);

        Identifier rgbOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.RGB_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier rgbOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.RGB_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RGB_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(RGBBlock.CLICKED, rgbOnIdentifier, rgbOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_CLUSTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.KOKAINA, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_KNOCKER, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_BOOTS));
        itemModelGenerator.register(ModItems.PISTOL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEATH_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUKE_BUTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNEK_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.XO_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModFluids.FROOTOP_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_AMMO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_BOOK_OF_LIFE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_DOMINION, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_ELEVATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_FIREBALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_FIST, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_GODSPEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_HEALTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_KATANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_PURIFY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SC_STOMP, Models.GENERATED);
    }
}
