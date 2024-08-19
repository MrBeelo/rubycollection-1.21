package net.mrbeelo.bsmpc.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuelItems {
    public static void registerModFuelItems() {
        FuelRegistry.INSTANCE.add(ModItems.KOKAINA, 700);
    }
}
