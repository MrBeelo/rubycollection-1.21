package net.mrbeelo.bsmpc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.block.custom.KokainaCropBlock;
import net.mrbeelo.bsmpc.block.custom.RGBBlock;
import net.mrbeelo.bsmpc.fluid.ModFluids;
import net.mrbeelo.bsmpc.item.ModItems;

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
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ROSE, ModBlocks.POTTED_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);
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


        blockStateModelGenerator.registerLog(ModBlocks.CS_LOG).log(ModBlocks.CS_LOG).wood(ModBlocks.CS_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CS_LOG).log(ModBlocks.STRIPPED_CS_LOG).wood(ModBlocks.STRIPPED_CS_WOOD);

        BlockStateModelGenerator.BlockTexturePool csPlankTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CS_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.CS_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CS_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        csPlankTexturePool.stairs(ModBlocks.CS_STAIRS);
        csPlankTexturePool.slab(ModBlocks.CS_SLAB);
        csPlankTexturePool.button(ModBlocks.CS_BUTTON);
        csPlankTexturePool.pressurePlate(ModBlocks.CS_PRESSURE_PLATE);
        csPlankTexturePool.fence(ModBlocks.CS_FENCE);
        csPlankTexturePool.fenceGate(ModBlocks.CS_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.CS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CS_TRAPDOOR);

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
        itemModelGenerator.registerArmor(ModItems.RUBY_HELMET);
        itemModelGenerator.registerArmor(ModItems.RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor(ModItems.RUBY_LEGGINGS);
        itemModelGenerator.registerArmor(ModItems.RUBY_BOOTS);
        itemModelGenerator.register(ModItems.PISTOL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEATH_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUKE_BUTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNEK_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.XO_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModFluids.FROOTOP_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RANDOM_ARTIFACT, Models.GENERATED);
        itemModelGenerator.register(ModItems.POKE_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.registerArmor(ModItems.SNEK_HELMET);
        itemModelGenerator.registerArmor(ModItems.SNEK_CHESTPLATE);
        itemModelGenerator.registerArmor(ModItems.SNEK_LEGGINGS);
        itemModelGenerator.registerArmor(ModItems.SNEK_BOOTS);
        itemModelGenerator.register(ModItems.WARDEN_HORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNEK_SCALE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOB_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.PYRO_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.registerArmor(ModItems.JETPACK);
    }
}
