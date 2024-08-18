package net.mrbeelo.rubycollection.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.entity.custom.PokeBallProjectileEntity;
import net.mrbeelo.rubycollection.entity.custom.SnekEntity;

public class ModEntities {
    public static final EntityType<SnekEntity> SNEK = Registry.register(Registries.ENTITY_TYPE,
            Rubycollection.id("snek"),
            EntityType.Builder.create(SnekEntity::new, SpawnGroup.CREATURE).dimensions(2f, 6f).build());

    public static final EntityType<PokeBallProjectileEntity> POKE_BALL_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Rubycollection.id("poke_ball_projectile"),
            EntityType.Builder.<PokeBallProjectileEntity>create(PokeBallProjectileEntity::new, SpawnGroup.MISC).dimensions(0.25f, 0.25f).build());
    public static void registerModEntities() {}
}
