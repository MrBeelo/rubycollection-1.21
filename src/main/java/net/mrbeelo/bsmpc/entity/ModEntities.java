package net.mrbeelo.bsmpc.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.entity.custom.*;

public class ModEntities {
    public static final EntityType<SnekEntity> SNEK = Registry.register(Registries.ENTITY_TYPE,
            BsmpC.id("snek"),
            EntityType.Builder.create(SnekEntity::new, SpawnGroup.CREATURE).dimensions(2f, 6f).build());

    public static final EntityType<PokeBallProjectileEntity> POKE_BALL_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            BsmpC.id("poke_ball_projectile"),
            EntityType.Builder.<PokeBallProjectileEntity>create(PokeBallProjectileEntity::new, SpawnGroup.MISC).dimensions(0.25f, 0.25f).build());

    public static final EntityType<PurifyBombProjectileEntity> PURIFY_BOMB_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            BsmpC.id("purify_bomb_projectile"),
            EntityType.Builder.create(PurifyBombProjectileEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build()
    );

    public static final EntityType<BulletProjectileEntity> BULLET_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            BsmpC.id("bullet_projectile"),
            EntityType.Builder.create(BulletProjectileEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build()
    );

    public static void registerModEntities() {}
}
