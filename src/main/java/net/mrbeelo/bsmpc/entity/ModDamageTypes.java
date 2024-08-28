package net.mrbeelo.bsmpc.entity;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.mrbeelo.bsmpc.BsmpC;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> EMOTIONAL_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, BsmpC.id("emotional_damage"));
}
