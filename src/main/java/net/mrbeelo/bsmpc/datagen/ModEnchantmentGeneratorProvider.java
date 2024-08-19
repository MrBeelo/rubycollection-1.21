package net.mrbeelo.bsmpc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.mrbeelo.bsmpc.enchantment.ModEnchantments;
import net.mrbeelo.bsmpc.enchantment.custom.BangEnchantmentEffect;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentGeneratorProvider extends FabricDynamicRegistryProvider {
    public ModEnchantmentGeneratorProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        RegistryWrapper<Item> itemLookup = registries.getWrapperOrThrow(RegistryKeys.ITEM);

        register(entries, ModEnchantments.BANG_EFFECT_KEY, Enchantment.builder(
                        Enchantment.definition(
                                itemLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                15, // probability of showing up in the enchantment table
                                1, // max level
                                Enchantment.leveledCost(1, 10), // cost per level (base)
                                Enchantment.leveledCost(1, 15), // cost per level (max)
                                7, // anvil applying cost
                                AttributeModifierSlot.HAND
                        ))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new BangEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.5f, 0.15f))));
    }

    private static void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "Enchantment Generator";
    }
}
