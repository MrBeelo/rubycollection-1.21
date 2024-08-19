package net.mrbeelo.rubycollection.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CUPRESSUS_SEMPERVIRENS = new SaplingGenerator(Rubycollection.MOD_ID + ":cs",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CS_KEY), Optional.empty());
}
