package net.mrbeelo.rubycollection.villager;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.fluid.ModFluids;
import net.mrbeelo.rubycollection.item.ModItems;

public class ModCustomTrades {

    public static void register() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.RUBERT, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RUBY, 2),
                    new ItemStack(Items.EMERALD, 20),
                    9999,
                    1,
                    0.05f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RUBY_INGOT, 1),
                    new ItemStack(Items.DIAMOND, 5),
                    9999,
                    1,
                    0.05f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RUBY, 1),
                    new ItemStack(Items.GOLD_INGOT, 10),
                    9999,
                    1,
                    0.05f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RUBY_SHARD, 2),
                    new ItemStack(Items.COAL, 10),
                    9999,
                    1,
                    0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.RUBERT, 2, factories -> {
            factories.add((entity, random) -> {
                Item[] armorTrims = {
                        Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
                        Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE
                };

                Item randomArmorTrim = armorTrims[random.nextInt(armorTrims.length)];

                return new TradeOffer(
                        new TradedItem(ModItems.RUBY_INGOT, 10),
                        new ItemStack(randomArmorTrim, 1),
                        9999,
                        6,
                        0.05f
                );
            });

            factories.add((entity, random) -> {
                Item[] foodItems = {
                        Items.COOKED_BEEF,
                        Items.COOKED_CHICKEN,
                        Items.COOKED_COD,
                        Items.COOKED_MUTTON,
                        Items.COOKED_PORKCHOP,
                        Items.COOKED_RABBIT,
                        Items.COOKED_SALMON

                };

                Item randomFoodItem = foodItems[random.nextInt(foodItems.length)];

                return new TradeOffer(
                        new TradedItem(ModItems.RUBY, 2),
                        new ItemStack(randomFoodItem, 10),
                        9999,
                        6,
                        0.05f
                );
            });


        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.RUBERT, 3, factories -> {
            factories.add((entity, random) -> {
                Item[] artifactItems = {
                        ModItems.PISTOL,
                        ModItems.KOKAINA_SEED,
                        ModItems.MASTER_BEELO_STAFF,
                        ModItems.SNEK_SPAWN_EGG,
                        ModItems.XO_MUSIC_DISC,
                        ModItems.NUKE_BUTTON,
                        ModBlocks.PEDESTAL.asItem(),
                        ModBlocks.PACKED_IRON_BLOCK.asItem(),
                        ModFluids.FROOTOP_BUCKET
                };

                Item randomArtifactItem = artifactItems[random.nextInt(artifactItems.length)];

                return new TradeOffer(
                        new TradedItem(ModItems.RUBY_CLUSTER, 10),
                        new ItemStack(randomArtifactItem, 1),
                        9999,
                        6,
                        0.05f
                );
            });

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.RUBY, 3),
                    new ItemStack(ModItems.KOKAINA, 2), //KOKAINA
                    9999,
                    10,
                    0.05f
            ));
        });
    }

    public static void registerModCustomTrades() {
        register();
    }
}
