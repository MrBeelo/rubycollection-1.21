package net.mrbeelo.rubycollection.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mrbeelo.rubycollection.entity.custom.SnekEntity;

public class ModAttributes {
    public static void registerModAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SNEK, SnekEntity.createSnekAttributes());
    }



}
