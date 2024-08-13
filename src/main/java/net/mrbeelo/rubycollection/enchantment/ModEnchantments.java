package net.mrbeelo.rubycollection.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.enchantment.custom.BangEnchantmentEffect;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> BANG_EFFECT_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Rubycollection.id("thundering"));

    public static final MapCodec<BangEnchantmentEffect> BANG_EFFECT = register("bang_effect", BangEnchantmentEffect.CODEC);

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Rubycollection.id(name), codec);
    }

    public static void registerModEnchantments() {}
}
