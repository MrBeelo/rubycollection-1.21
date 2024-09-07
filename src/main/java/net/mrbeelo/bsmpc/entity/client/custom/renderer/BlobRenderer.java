package net.mrbeelo.bsmpc.entity.client.custom.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.entity.client.ModEntityModelLayers;
import net.mrbeelo.bsmpc.entity.client.custom.model.BlobModel;
import net.mrbeelo.bsmpc.entity.client.custom.model.SnekModel;
import net.mrbeelo.bsmpc.entity.custom.BlobEntity;

public class BlobRenderer extends MobEntityRenderer<BlobEntity, BlobModel> {
    public static final Identifier TEXTURE = BsmpC.id("textures/entity/blob/blob.png");

    public BlobRenderer(EntityRendererFactory.Context context) {
        super(context, new BlobModel(context.getPart(ModEntityModelLayers.BLOB)), 0.5f);
    }

    @Override
    public Identifier getTexture(BlobEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BlobEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if(entity.isBaby()) {
            matrices.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }
}
