package net.mrbeelo.bsmpc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.item.ModItems;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK, 1)
                .input('E', ModItems.RUBY)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, BsmpC.id("ruby_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_STAIRS, 4)
                .input('E', ModBlocks.RUBY_BLOCK)
                .pattern("E  ")
                .pattern("EE ")
                .pattern("EEE")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_stairs"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_SLAB, 6)
                .input('E', ModBlocks.RUBY_BLOCK)
                .pattern("EEE")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BUTTON, 1)
                .input(ModBlocks.RUBY_BLOCK)
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_button"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_PRESSURE_PLATE, 6)
                .input('E', ModBlocks.RUBY_BLOCK)
                .pattern("EE")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_pressure_plate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_FENCE, 3)
                .input('E', ModBlocks.RUBY_BLOCK)
                .input('F', ModItems.RUBY)
                .pattern("EFE")
                .pattern("EFE")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_fence"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_FENCE_GATE, 1)
                .input('E', ModBlocks.RUBY_BLOCK)
                .input('F', ModItems.RUBY)
                .pattern("FEF")
                .pattern("FEF")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_fence_gate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_WALL, 6)
                .input('E', ModBlocks.RUBY_BLOCK)
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_wall"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_DOOR, 3)
                .input('E', ModBlocks.RUBY_BLOCK)
                .pattern("EE")
                .pattern("EE")
                .pattern("EE")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_door"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_TRAPDOOR, 3)
                .input('E', ModBlocks.RUBY_BLOCK)
                .pattern("EEE")
                .pattern("E E")
                .pattern("EEE")
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, BsmpC.id("ruby_trapdoor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_INGOT, 1)
                .input('E', ModItems.RUBY)
                .pattern(" E ")
                .pattern("EEE")
                .pattern(" E ")
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, BsmpC.id("ruby_ingot_from_rubies"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 5)
                .input(ModItems.RUBY_INGOT)
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("rubies_from_ruby_ingot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_CLUSTER, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern(" E ")
                .pattern("EEE")
                .pattern(" E ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_cluster_from_ruby_ingots"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_INGOT, 5)
                .input(ModItems.RUBY_CLUSTER)
                .criterion(hasItem(ModItems.RUBY_CLUSTER), conditionsFromItem(ModItems.RUBY_CLUSTER))
                .offerTo(exporter, BsmpC.id("ruby_ingots_from_ruby_cluster"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 1)
                .input('E', ModItems.RUBY_SHARD)
                .pattern(" E ")
                .pattern("EEE")
                .pattern(" E ")
                .criterion(hasItem(ModItems.RUBY_SHARD), conditionsFromItem(ModItems.RUBY_SHARD))
                .offerTo(exporter, BsmpC.id("rubies_from_ruby_shards"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_SHARD, 5)
                .input(ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, BsmpC.id("ruby_shards_from_rubies"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_SWORD, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("E")
                .pattern("E")
                .pattern("F")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_PICKAXE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("EEE")
                .pattern(" F ")
                .pattern(" F ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_AXE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("EE")
                .pattern("FE")
                .pattern("F ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_SHOVEL, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("E")
                .pattern("F")
                .pattern("F")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_HOE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("EE")
                .pattern("F ")
                .pattern("F ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_HELMET, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("EEE")
                .pattern("E E")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_CHESTPLATE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_LEGGINGS, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_BOOTS, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, BsmpC.id("ruby_boots"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BULLET, 2)
                .input(Items.IRON_NUGGET)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .offerTo(exporter, BsmpC.id("bullet"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_PLANKS, 4)
                .input(ModBlocks.CS_LOG)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .offerTo(exporter, BsmpC.id("cs_planks_from_cs_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_PLANKS, 2)
                .input(ModBlocks.STRIPPED_CS_LOG)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .offerTo(exporter, BsmpC.id("cs_planks_from_stripped_cs_log"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_STAIRS, 4)
                .input('E', ModBlocks.CS_PLANKS)
                .pattern("E  ")
                .pattern("EE ")
                .pattern("EEE")
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_stairs"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_SLAB, 6)
                .input('E', ModBlocks.CS_PLANKS)
                .pattern("EEE")
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_BUTTON, 1)
                .input(ModBlocks.CS_PLANKS)
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_button"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_PRESSURE_PLATE, 6)
                .input('E', ModBlocks.CS_PLANKS)
                .pattern("EE")
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_pressure_plate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_FENCE, 3)
                .input('E', ModBlocks.CS_PLANKS)
                .input('F', Items.STICK)
                .pattern("EFE")
                .pattern("EFE")
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_fence"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_FENCE_GATE, 1)
                .input('E', ModBlocks.CS_PLANKS)
                .input('F', Items.STICK)
                .pattern("FEF")
                .pattern("FEF")
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_fence_gate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_DOOR, 3)
                .input('E', ModBlocks.CS_PLANKS)
                .pattern("EE")
                .pattern("EE")
                .pattern("EE")
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_door"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CS_TRAPDOOR, 3)
                .input('E', ModBlocks.CS_PLANKS)
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModBlocks.CS_PLANKS), conditionsFromItem(ModBlocks.CS_PLANKS))
                .offerTo(exporter, BsmpC.id("cs_trapdoor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WARDEN_SWORD, 1)
                .input('E', ModItems.WARDEN_HORN)
                .input('F', Items.STICK)
                .pattern("E")
                .pattern("E")
                .pattern("F")
                .criterion(hasItem(ModItems.WARDEN_HORN), conditionsFromItem(ModItems.WARDEN_HORN))
                .offerTo(exporter, BsmpC.id("warden_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SNEK_HELMET, 1)
                .input('E', ModItems.SNEK_SCALE)
                .pattern("EEE")
                .pattern("E E")
                .criterion(hasItem(ModItems.SNEK_SCALE), conditionsFromItem(ModItems.SNEK_SCALE))
                .offerTo(exporter, BsmpC.id("snek_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SNEK_CHESTPLATE, 1)
                .input('E', ModItems.SNEK_SCALE)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModItems.SNEK_SCALE), conditionsFromItem(ModItems.SNEK_SCALE))
                .offerTo(exporter, BsmpC.id("snek_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SNEK_LEGGINGS, 1)
                .input('E', ModItems.SNEK_SCALE)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.SNEK_SCALE), conditionsFromItem(ModItems.SNEK_SCALE))
                .offerTo(exporter, BsmpC.id("snek_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SNEK_BOOTS, 1)
                .input('E', ModItems.SNEK_SCALE)
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.SNEK_SCALE), conditionsFromItem(ModItems.SNEK_SCALE))
                .offerTo(exporter, BsmpC.id("snek_boots"));
    }
}
