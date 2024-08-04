package net.mrbeelo.rubycollection.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> KOKAINA = register("kokaina", new Potion(new StatusEffectInstance(ModEffects.HIGH, 460, 0)));

    public static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Rubycollection.id(name), potion);
    }

    public static void registerModPotions() {}
}
