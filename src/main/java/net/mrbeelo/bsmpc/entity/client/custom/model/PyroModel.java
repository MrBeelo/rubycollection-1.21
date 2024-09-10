package net.mrbeelo.bsmpc.entity.client.custom.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.mrbeelo.bsmpc.entity.client.animation.PyroAnimations;
import net.mrbeelo.bsmpc.entity.custom.PyroEntity;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class PyroModel extends SinglePartEntityModel<PyroEntity> {
	private final ModelPart main;
	private final ModelPart head;
	public PyroModel(ModelPart root) {
		this.main = root.getChild("main");
		this.head = main.getChild("body").getChild("neck").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 21.0F, 0.0F));

		ModelPartData body = main.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -11.0F, -6.0F, 6.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -4.0F, -6.0F, 4.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, -7.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData neck = body.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, -13.0F));

		ModelPartData cube_r2 = neck.addChild("cube_r2", ModelPartBuilder.create().uv(16, 22).cuboid(-1.0F, -1.0611F, -5.2352F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2047F, -0.1787F, -0.4363F, 0.0F, 0.0F));

		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(38, 8).cuboid(-1.0F, -2.5F, -1.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -4.0F));

		ModelPartData upper = head.addChild("upper", ModelPartBuilder.create().uv(17, 30).cuboid(-0.9532F, 0.0185F, -4.3059F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0468F, -2.5185F, -2.1941F));

		ModelPartData cube_r3 = upper.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0468F, -0.7032F, 1.8101F, 1.0321F, 0.2261F, -0.1332F));

		ModelPartData cube_r4 = upper.addChild("cube_r4", ModelPartBuilder.create().uv(0, 3).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.9532F, -0.7032F, 1.8101F, 1.0036F, -0.3747F, 0.2291F));

		ModelPartData cube_r5 = upper.addChild("cube_r5", ModelPartBuilder.create().uv(25, 34).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0468F, 0.5185F, -2.8059F, 0.1309F, 0.0F, 0.0F));

		ModelPartData lower = head.addChild("lower", ModelPartBuilder.create().uv(34, 30).cuboid(-1.0F, -0.5F, -4.5F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -2.0F));

		ModelPartData wings = body.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left = wings.addChild("left", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData upper2 = left.addChild("upper2", ModelPartBuilder.create().uv(36, 25).cuboid(2.0F, -7.5F, -12.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 26).cuboid(3.0F, -7.5F, -10.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 1.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData lower2 = left.addChild("lower2", ModelPartBuilder.create().uv(21, 0).cuboid(3.0F, -6.0F, -10.5F, 0.0F, 4.0F, 3.0F, new Dilation(0.0F))
				.uv(32, 0).cuboid(2.5F, -5.0F, -11.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData right = wings.addChild("right", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

		ModelPartData upper3 = right.addChild("upper3", ModelPartBuilder.create().uv(0, 36).cuboid(2.0F, -7.5F, -12.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(15, 18).cuboid(3.0F, -7.5F, -10.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 1.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData lower3 = right.addChild("lower3", ModelPartBuilder.create().uv(0, 13).cuboid(3.0F, -6.0F, -10.5F, 0.0F, 4.0F, 3.0F, new Dilation(0.0F))
				.uv(8, 28).cuboid(2.5F, -5.0F, -11.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 28).cuboid(-1.0F, -10.0F, 6.5F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(21, 0).cuboid(-1.0F, -10.0F, 10.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F))
				.uv(12, 25).cuboid(0.0F, -10.0F, 13.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(15, 9).cuboid(0.0F, -9.0F, 18.0F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData cube_r6 = tail.addChild("cube_r6", ModelPartBuilder.create().uv(26, 17).cuboid(-2.0F, -4.5F, -6.0F, 4.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 10.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData legs = main.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData left2 = legs.addChild("left2", ModelPartBuilder.create().uv(30, 9).cuboid(-1.0F, -2.5F, -1.5F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -5.5F, 1.5F));

		ModelPartData feet = left2.addChild("feet", ModelPartBuilder.create().uv(0, 20).cuboid(3.0F, 0.0F, 3.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(8, 34).cuboid(3.0F, 2.0F, 0.5F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 2).cuboid(4.0F, 0.0F, 1.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(5, 5).cuboid(4.0F, 0.0F, 0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 5.5F, -1.5F));

		ModelPartData cube_r7 = feet.addChild("cube_r7", ModelPartBuilder.create().uv(38, 36).cuboid(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.0F, 4.0F, 0.5236F, 0.0F, 0.0F));

		ModelPartData right2 = legs.addChild("right2", ModelPartBuilder.create().uv(29, 27).cuboid(-1.0F, -2.5F, -1.5F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -5.5F, 1.5F));

		ModelPartData feet2 = right2.addChild("feet2", ModelPartBuilder.create().uv(0, 6).cuboid(3.0F, 0.0F, 3.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(32, 0).cuboid(3.0F, 2.0F, 0.5F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(4.0F, 0.0F, 1.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 4).cuboid(4.0F, 0.0F, 0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 5.5F, -1.5F));

		ModelPartData cube_r8 = feet2.addChild("cube_r8", ModelPartBuilder.create().uv(20, 37).cuboid(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.0F, 4.0F, 0.5236F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(PyroEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(PyroAnimations.WALKING, limbSwing, limbSwingAmount, 2.0f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, PyroAnimations.IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, PyroAnimations.BITE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25F, 45f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		main.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return main;
	}
}