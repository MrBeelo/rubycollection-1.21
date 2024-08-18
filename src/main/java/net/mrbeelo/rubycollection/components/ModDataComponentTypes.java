package net.mrbeelo.rubycollection.components;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.rubycollection.Rubycollection;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<Integer> MBS_STAGE = Registry.register(Registries.DATA_COMPONENT_TYPE, Rubycollection.id("mbs_stage"), ComponentType.<Integer>builder().codec(Codec.INT).build());
    public static final ComponentType<Integer> MBS_ACTIVE_COOLDOWN = Registry.register(Registries.DATA_COMPONENT_TYPE, Rubycollection.id("mbs_active_cooldown"), ComponentType.<Integer>builder().codec(Codec.INT).build());
    public static final ComponentType<Integer> MBS_LAZER_TIME = Registry.register(Registries.DATA_COMPONENT_TYPE, Rubycollection.id("mbs_lazer_time"), ComponentType.<Integer>builder().codec(Codec.INT).build());
    public static final ComponentType<Integer> MBS_GLOWING_TIME = Registry.register(Registries.DATA_COMPONENT_TYPE, Rubycollection.id("mbs_glowing_time"), ComponentType.<Integer>builder().codec(Codec.INT).build());


    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Rubycollection.id(name),
                (builderOperator.apply(ComponentType.builder())).build());
    }

    public static void registerModDataComponentTypes() {}
}
