package net.mrbeelo.rubycollection.entity.client.custom.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.entity.client.ModEntityModelLayers;
import net.mrbeelo.rubycollection.entity.client.custom.model.SnekModel;
import net.mrbeelo.rubycollection.entity.custom.SnekEntity;

public class SnekRenderer extends MobEntityRenderer<SnekEntity, SnekModel> {
    public SnekRenderer(EntityRendererFactory.Context context) {
        super(context, new SnekModel(context.getPart(ModEntityModelLayers.SNEK)), 0.5f);
    }

    @Override
    public Identifier getTexture(SnekEntity entity) {
        return Rubycollection.id("textures/entity/snek/biollante.png");
    }

    @Override
    public void render(SnekEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
