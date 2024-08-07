package net.mrbeelo.rubycollection.entity.client.custom.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class PurifyBombModel extends EntityModel<Entity> {
	private final ModelPart body;
	private final ModelPart outside;
	private final ModelPart face1;
	private final ModelPart face2;
	private final ModelPart face3;
	private final ModelPart face4;
	private final ModelPart face5;
	private final ModelPart face6;
	public PurifyBombModel(ModelPart root) {
		this.body = root.getChild("body");
		this.outside = root.getChild("outside");
		this.face1 = root.getChild("face1");
		this.face2 = root.getChild("face2");
		this.face3 = root.getChild("face3");
		this.face4 = root.getChild("face4");
		this.face5 = root.getChild("face5");
		this.face6 = root.getChild("face6");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData outside = body.addChild("outside", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData face1 = outside.addChild("face1", ModelPartBuilder.create().uv(32, 43).cuboid(2.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(40, 42).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(40, 28).cuboid(-0.5F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData face15_r1 = face1.addChild("face15_r1", ModelPartBuilder.create().uv(40, 35).cuboid(-0.5F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face14_r1 = face1.addChild("face14_r1", ModelPartBuilder.create().uv(8, 41).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face13_r1 = face1.addChild("face13_r1", ModelPartBuilder.create().uv(24, 42).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face2 = outside.addChild("face2", ModelPartBuilder.create().uv(40, 21).cuboid(2.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(16, 40).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-0.5F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData face25_r1 = face2.addChild("face25_r1", ModelPartBuilder.create().uv(40, 0).cuboid(-0.5F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face24_r1 = face2.addChild("face24_r1", ModelPartBuilder.create().uv(40, 7).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face23_r1 = face2.addChild("face23_r1", ModelPartBuilder.create().uv(40, 14).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face3 = outside.addChild("face3", ModelPartBuilder.create().uv(32, 36).cuboid(2.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(24, 35).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(32, 29).cuboid(-0.5F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 1.5708F));

		ModelPartData face35_r1 = face3.addChild("face35_r1", ModelPartBuilder.create().uv(0, 33).cuboid(-0.5F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face34_r1 = face3.addChild("face34_r1", ModelPartBuilder.create().uv(16, 33).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face33_r1 = face3.addChild("face33_r1", ModelPartBuilder.create().uv(8, 34).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face4 = outside.addChild("face4", ModelPartBuilder.create().uv(32, 22).cuboid(2.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(32, 15).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(8, 27).cuboid(-0.5F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -1.0F, -1.5708F, 0.0F, -3.1416F));

		ModelPartData face45_r1 = face4.addChild("face45_r1", ModelPartBuilder.create().uv(24, 28).cuboid(-0.5F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face44_r1 = face4.addChild("face44_r1", ModelPartBuilder.create().uv(32, 1).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face43_r1 = face4.addChild("face43_r1", ModelPartBuilder.create().uv(32, 8).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face5 = outside.addChild("face5", ModelPartBuilder.create().uv(16, 26).cuboid(2.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(24, 0).cuboid(-0.5F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.0F, 0.0F, 0.0F, 1.5708F, -1.5708F));

		ModelPartData face55_r1 = face5.addChild("face55_r1", ModelPartBuilder.create().uv(24, 7).cuboid(-0.5F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face54_r1 = face5.addChild("face54_r1", ModelPartBuilder.create().uv(24, 14).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face53_r1 = face5.addChild("face53_r1", ModelPartBuilder.create().uv(24, 21).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 2.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face6 = outside.addChild("face6", ModelPartBuilder.create().uv(8, 20).cuboid(2.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(16, 19).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(-0.5F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 3.1416F));

		ModelPartData face65_r1 = face6.addChild("face65_r1", ModelPartBuilder.create().uv(8, 13).cuboid(-0.5F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face64_r1 = face6.addChild("face64_r1", ModelPartBuilder.create().uv(16, 12).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData face63_r1 = face6.addChild("face63_r1", ModelPartBuilder.create().uv(0, 19).cuboid(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 2.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		body.render(matrices, vertexConsumer, light, overlay, color);
	}
}