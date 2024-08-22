package net.mrbeelo.bsmpc.entity.client.custom.renderer;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.entity.client.ModEntityModelLayers;
import net.mrbeelo.bsmpc.entity.client.custom.model.NukeModel;
import net.mrbeelo.bsmpc.entity.custom.NukeEntity;

public class NukeRenderer extends EntityRenderer<NukeEntity> {
    public static final Identifier TEXTURE = BsmpC.id("textures/entity/nuke/nuke.png");
    private final EntityModel<NukeEntity> model;
    public NukeRenderer(EntityRendererFactory.Context context, EntityModel<NukeEntity> model) {
        super(context);
        this.model = new NukeModel(context.getPart(ModEntityModelLayers.NUKE));
    }

    @Override
    public Identifier getTexture(NukeEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(NukeEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        // Implement your rendering logic here
        matrixStack.push();

        // Example transformations
        matrixStack.translate(0.0D, 1.5D, 0.0D);
        matrixStack.scale(-1.0F, -1.0F, 1.0F);

        // Render the model
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(entity)));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);

        matrixStack.pop();
        super.render(entity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
