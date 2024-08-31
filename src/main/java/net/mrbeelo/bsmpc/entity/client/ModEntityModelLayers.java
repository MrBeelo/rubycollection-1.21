package net.mrbeelo.bsmpc.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.mrbeelo.bsmpc.BsmpC;

public class ModEntityModelLayers {
    public static final EntityModelLayer SNEK =
            new EntityModelLayer(BsmpC.id("snek"), "main");

    public static final EntityModelLayer NUKE =
            new EntityModelLayer(BsmpC.id("nuke"), "main");

    public static final EntityModelLayer BLOB =
            new EntityModelLayer(BsmpC.id("blob"), "main");
}
