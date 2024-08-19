package net.mrbeelo.bsmpc.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.block.entity.custom.PedestalBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, BsmpC.id("pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));


    public static void registerModBlockEntities() {}
}
