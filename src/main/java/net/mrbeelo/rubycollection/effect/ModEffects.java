package net.mrbeelo.rubycollection.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


import net.minecraft.registry.entry.RegistryEntry;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.effect.custom.HighEffect;


public class ModEffects {

    //REGISTERING

    public static RegistryEntry<StatusEffect> HIGH = register("high", new HighEffect(StatusEffectCategory.HARMFUL, 3124687).addAttributeModifier(
            EntityAttributes.GENERIC_MOVEMENT_SPEED, Rubycollection.id("effect.speed"), 1.2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    //METHODS

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Rubycollection.id(id), statusEffect);
    }

    public static void registerModEffects() {}
}
