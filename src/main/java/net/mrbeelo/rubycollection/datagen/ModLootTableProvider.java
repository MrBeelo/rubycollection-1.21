package net.mrbeelo.rubycollection.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RUBY_ORE, oreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, oreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY));
        addDrop(ModBlocks.NETHER_RUBY_ORE, multipleOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RUBY_SHARD,1, 3));
        addDrop(ModBlocks.PACKED_IRON_BLOCK);
        addDrop(ModBlocks.SMOOTH_QUARTZ_RUBY_UPGRADER);
        addDrop(ModBlocks.SMOOTH_QUARTZ_RUBY_DOWNGRADER);
        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_TRAPDOOR);
        addDrop(ModBlocks.PEDESTAL);
        addDrop(ModBlocks.ROSE);
        addDrop(ModBlocks.POTTED_ROSE, pottedPlantDrops(ModBlocks.ROSE));

        addDrop(ModBlocks.CS_LOG);
        addDrop(ModBlocks.CS_WOOD);
        addDrop(ModBlocks.STRIPPED_CS_LOG);
        addDrop(ModBlocks.STRIPPED_CS_WOOD);
        addDrop(ModBlocks.CS_PLANKS);
        addDrop(ModBlocks.CS_SAPLING);
        addDrop(ModBlocks.CS_LEAVES, leavesDrops(ModBlocks.CS_LEAVES, ModBlocks.CS_SAPLING, 0.0625f));
        addDrop(ModBlocks.CS_STAIRS);
        addDrop(ModBlocks.CS_SLAB, slabDrops(ModBlocks.CS_SLAB));
        addDrop(ModBlocks.CS_BUTTON);
        addDrop(ModBlocks.CS_PRESSURE_PLATE);
        addDrop(ModBlocks.CS_FENCE);
        addDrop(ModBlocks.CS_FENCE_GATE);
        addDrop(ModBlocks.CS_DOOR, doorDrops(ModBlocks.CS_DOOR));
        addDrop(ModBlocks.CS_TRAPDOOR);


        LootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.KOKAINA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 3));
        addDrop(ModBlocks.KOKAINA_CROP, cropDrops(ModBlocks.KOKAINA_CROP, ModItems.KOKAINA, ModItems.KOKAINA_SEED, builder));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}





