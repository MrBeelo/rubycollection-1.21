package net.mrbeelo.bsmpc.entity.client.custom.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.mrbeelo.bsmpc.entity.custom.NukeEntity;

public class NukeModel extends SinglePartEntityModel<NukeEntity> {
	private final ModelPart body;
	public NukeModel(ModelPart root) {
		this.body = root.getChild("body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(30, 21).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(18, 23).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 23).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -18.0F, -4.0F, 8.0F, 15.0F, 8.0F, new Dilation(0.0F))
		.uv(28, 5).cuboid(-1.0F, -19.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData wing1 = body.addChild("wing1", ModelPartBuilder.create().uv(24, 28).cuboid(-1.0F, -10.0F, -5.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 30).cuboid(-1.0F, -10.0F, -6.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 12).cuboid(-1.0F, -10.0F, -7.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(17, 34).cuboid(-1.0F, -10.0F, -8.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wing2 = body.addChild("wing2", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, -10.0F, -5.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 30).cuboid(-1.0F, -10.0F, -6.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 8).cuboid(-1.0F, -10.0F, -7.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 32).cuboid(-1.0F, -10.0F, -8.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData wing3 = body.addChild("wing3", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0F, -10.0F, -5.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 0).cuboid(-1.0F, -10.0F, -6.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 28).cuboid(-1.0F, -10.0F, -7.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 16).cuboid(-1.0F, -10.0F, -8.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData wing4 = body.addChild("wing4", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -10.0F, -5.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 30).cuboid(-1.0F, -10.0F, -6.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(18, 30).cuboid(-1.0F, -10.0F, -7.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 24).cuboid(-1.0F, -10.0F, -8.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(NukeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		body.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return body;
	}
}