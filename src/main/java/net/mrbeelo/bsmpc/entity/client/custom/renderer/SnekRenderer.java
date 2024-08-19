package net.mrbeelo.bsmpc.entity.client.custom.renderer;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.entity.client.ModEntityModelLayers;
import net.mrbeelo.bsmpc.entity.client.custom.model.SnekModel;
import net.mrbeelo.bsmpc.entity.custom.SnekEntity;
import net.mrbeelo.bsmpc.entity.variant.SnekVariant;

import java.util.Map;

public class SnekRenderer extends MobEntityRenderer<SnekEntity, SnekModel> {
    private static final Map<SnekVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SnekVariant.class), map -> {
                map.put(SnekVariant.GREEN, BsmpC.id("textures/entity/snek/snek_green.png"));
                map.put(SnekVariant.RED, BsmpC.id("textures/entity/snek/snek_red.png"));
            });

    public SnekRenderer(EntityRendererFactory.Context context) {
        super(context, new SnekModel(context.getPart(ModEntityModelLayers.SNEK)), 0.5f);
    }

    @Override
    public Identifier getTexture(SnekEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant()); //Rubycollection.id("textures/entity/snek/snek_green.png");
    }

    @Override
    public void render(SnekEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
