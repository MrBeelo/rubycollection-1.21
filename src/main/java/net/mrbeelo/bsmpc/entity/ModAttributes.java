package net.mrbeelo.bsmpc.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mrbeelo.bsmpc.entity.custom.BlobEntity;
import net.mrbeelo.bsmpc.entity.custom.SnekEntity;

public class ModAttributes {
    public static void registerModAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SNEK, SnekEntity.createSnekAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BLOB, BlobEntity.createBlobAttributes());
    }



}
