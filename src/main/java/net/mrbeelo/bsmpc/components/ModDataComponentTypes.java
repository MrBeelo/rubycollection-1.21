package net.mrbeelo.bsmpc.components;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.bsmpc.BsmpC;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<Integer> MBS_STAGE = Registry.register(Registries.DATA_COMPONENT_TYPE, BsmpC.id("mbs_stage"), ComponentType.<Integer>builder().codec(Codec.INT).build());


    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, BsmpC.id(name),
                (builderOperator.apply(ComponentType.builder())).build());
    }

    public static void registerModDataComponentTypes() {}
}
