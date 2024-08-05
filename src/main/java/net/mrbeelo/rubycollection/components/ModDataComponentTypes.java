package net.mrbeelo.rubycollection.components;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.mrbeelo.rubycollection.Rubycollection;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", builder -> builder.codec(BlockPos.CODEC));
    public static final ComponentType<BlockPos> MBS_CYCLE_STAGE = register("mbs_cycle_stage", builder -> builder.codec(BlockPos.CODEC));


    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Rubycollection.id(name),
                (builderOperator.apply(ComponentType.builder())).build());
    }

    public static void registerModDataComponentTypes() {}
}
