package net.mrbeelo.rubycollection.entity.client.custom.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.mrbeelo.rubycollection.entity.client.animation.SnekAnimations;
import net.mrbeelo.rubycollection.entity.custom.SnekEntity;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SnekModel extends SinglePartEntityModel<SnekEntity> {
	private final ModelPart body;
	private final ModelPart head;

	public SnekModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("bodypart1").getChild("bodypart2").getChild("bodypart3").getChild("bodypart4").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bodypart1 = body.addChild("bodypart1", ModelPartBuilder.create().uv(24, 32).cuboid(-3.0F, -26.0F, -3.0F, 6.0F, 26.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bodypart2 = bodypart1.addChild("bodypart2", ModelPartBuilder.create().uv(0, 32).cuboid(-3.0F, -52.0F, -3.0F, 6.0F, 26.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bodypart3 = bodypart2.addChild("bodypart3", ModelPartBuilder.create().uv(24, 0).cuboid(-3.0F, -78.0F, -3.0F, 6.0F, 26.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bodypart4 = bodypart3.addChild("bodypart4", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -104.0F, -3.0F, 6.0F, 26.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = bodypart4.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -105.0F, 14.0F));

		ModelPartData upjaw = head.addChild("upjaw", ModelPartBuilder.create().uv(42, 24).cuboid(-4.0F, -4.0F, -19.0F, 8.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(48, 10).cuboid(-3.0F, -3.0F, -25.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = upjaw.addChild("cube_r1", ModelPartBuilder.create().uv(48, 18).cuboid(-3.0F, -1.35F, -0.5F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -19.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData lowjaw = head.addChild("lowjaw", ModelPartBuilder.create().uv(48, 0).cuboid(-4.0F, -1.0F, -19.0F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F))
		.uv(48, 35).cuboid(-3.0F, -1.0F, -25.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(SnekEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		//this.animateMovement(SnekAnimations.IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, SnekAnimations.IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25F, 45f);

		this.body.yaw = headYaw * 0.017453292F;
		this.body.pitch = headPitch * 0.017453292F;
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