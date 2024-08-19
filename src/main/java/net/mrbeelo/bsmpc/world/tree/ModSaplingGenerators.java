package net.mrbeelo.bsmpc.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CUPRESSUS_SEMPERVIRENS = new SaplingGenerator(BsmpC.MOD_ID + ":cs",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CS_KEY), Optional.empty());
}
