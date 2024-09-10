package net.mrbeelo.bsmpc.entity.client.custom.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.entity.client.ModEntityModelLayers;
import net.mrbeelo.bsmpc.entity.client.custom.model.PyroModel;
import net.mrbeelo.bsmpc.entity.custom.PyroEntity;
import net.mrbeelo.bsmpc.entity.custom.SnekEntity;

public class PyroRenderer extends MobEntityRenderer<PyroEntity, PyroModel> {
    public static final Identifier TEXTURE = BsmpC.id("textures/entity/pyro/pyro.png");
    public PyroRenderer(EntityRendererFactory.Context context) {
        super(context, new PyroModel(context.getPart(ModEntityModelLayers.PYRO)), 0.5f);
    }

    @Override
    public Identifier getTexture(PyroEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PyroEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
