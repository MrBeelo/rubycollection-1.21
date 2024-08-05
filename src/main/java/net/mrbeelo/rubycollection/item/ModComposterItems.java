package net.mrbeelo.rubycollection.item;

import net.minecraft.block.ComposterBlock;

public class ModComposterItems {
    public static void registerModComposterItems() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.KOKAINA, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.KOKAINA_SEED, 0.5f);
    }
}
