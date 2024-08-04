package net.mrbeelo.rubycollection.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.item.ModItems;
import net.mrbeelo.rubycollection.potion.ModPotions;

import java.util.concurrent.CompletableFuture;

import static net.mrbeelo.rubycollection.potion.ModPotions.KOKAINA;


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
                .offerTo(exporter, Rubycollection.id("ruby_block_from_rubies"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 9)
                .input(ModBlocks.RUBY_BLOCK)
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, Rubycollection.id("rubies_from_ruby_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_INGOT, 1)
                .input('E', ModItems.RUBY)
                .pattern(" E ")
                .pattern("EEE")
                .pattern(" E ")
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Rubycollection.id("ruby_ingot_from_rubies"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 5)
                .input(ModItems.RUBY_INGOT)
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("rubies_from_ruby_ingot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_CLUSTER, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern(" E ")
                .pattern("EEE")
                .pattern(" E ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_cluster_from_ruby_ingots"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_INGOT, 5)
                .input(ModItems.RUBY_CLUSTER)
                .criterion(hasItem(ModItems.RUBY_CLUSTER), conditionsFromItem(ModItems.RUBY_CLUSTER))
                .offerTo(exporter, Rubycollection.id("ruby_ingots_from_ruby_cluster"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 1)
                .input('E', ModItems.RUBY_SHARD)
                .pattern(" E ")
                .pattern("EEE")
                .pattern(" E ")
                .criterion(hasItem(ModItems.RUBY_SHARD), conditionsFromItem(ModItems.RUBY_SHARD))
                .offerTo(exporter, Rubycollection.id("rubies_from_ruby_shards"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_SHARD, 5)
                .input(ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Rubycollection.id("ruby_shards_from_rubies"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_SWORD, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("E")
                .pattern("E")
                .pattern("F")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_PICKAXE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("EEE")
                .pattern(" F ")
                .pattern(" F ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_AXE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("EE")
                .pattern("FE")
                .pattern("F ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_SHOVEL, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("E")
                .pattern("F")
                .pattern("F")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_HOE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .input('F', Items.STICK)
                .pattern("EE")
                .pattern("F ")
                .pattern("F ")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_HELMET, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("EEE")
                .pattern("E E")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_CHESTPLATE, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_LEGGINGS, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_BOOTS, 1)
                .input('E', ModItems.RUBY_INGOT)
                .pattern("E E")
                .pattern("E E")
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter, Rubycollection.id("ruby_boots"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PISTOL, 1)
                .input('E', Items.IRON_INGOT)
                .pattern("EEE")
                .pattern("E  ")
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, Rubycollection.id("pistol"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BULLET, 5)
                .input(Items.IRON_NUGGET)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .offerTo(exporter, Rubycollection.id("bullet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PACKED_IRON_BLOCK, 1)
                .input('E', Blocks.IRON_BLOCK)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .criterion(hasItem(Blocks.IRON_BLOCK), conditionsFromItem(Blocks.IRON_BLOCK))
                .offerTo(exporter, Rubycollection.id("packed_iron_block_from_iron_blocks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.IRON_BLOCK, 9)
                .input(ModBlocks.PACKED_IRON_BLOCK)
                .criterion(hasItem(ModBlocks.PACKED_IRON_BLOCK), conditionsFromItem(ModBlocks.PACKED_IRON_BLOCK))
                .offerTo(exporter, Rubycollection.id("iron_blocks_from_packed_iron_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DEATH_AXE, 1)
                .input('E', ModBlocks.PACKED_IRON_BLOCK)
                .input('S', Items.STICK)
                .pattern("ESE")
                .pattern(" S ")
                .pattern(" S ")
                .criterion(hasItem(ModBlocks.PACKED_IRON_BLOCK), conditionsFromItem(ModBlocks.PACKED_IRON_BLOCK))
                .offerTo(exporter, Rubycollection.id("death_axe"));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.KOKAINA, KOKAINA);
        });

    }
}
