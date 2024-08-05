package net.mrbeelo.rubycollection.item;

import net.minecraft.component.type.FoodComponent;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.mrbeelo.rubycollection.effect.ModEffects;

public class ModFoodItems {
    public static final FoodComponent KOKAINA_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(6)
            .saturationModifier(0.4F)
            .statusEffect(new StatusEffectInstance(ModEffects.HIGH, 460, 0, false, true), 1.0f)
            .build();
}


