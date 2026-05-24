// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.replacer.EndersentAdvancedAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.EndersentEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class EndersentModel<T extends EndersentEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public EndersentModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 63).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 56.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -55.0F, 0.0F));

		PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(50, 35).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 56.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -55.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -28.0F, -4.0F, 18.0F, 27.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(86, 89).addBox(-4.0F, -19.0F, -6.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -55.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(66, 89).addBox(0.0F, -11.0F, -0.001F, 10.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 4.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(84, 6).addBox(0.0F, -11.0F, -0.001F, 10.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -23.0F, 4.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(100, 47).addBox(-4.0F, 3.3294F, 2.4146F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -5.9567F, -0.3927F, 0.0F, 1.5708F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(100, 52).addBox(-4.0F, -8.3294F, 2.4146F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -5.9567F, 0.3927F, 0.0F, 1.5708F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(100, 42).addBox(-8.0F, -5.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.3806F, -6.9134F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(100, 37).addBox(-8.0F, -5.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -19.0F, -5.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(52, 0).addBox(-4.0F, -10.9F, -7.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(86, 99).addBox(4.0F, -8.9F, -5.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(52, 21).addBox(6.0F, -14.9F, -5.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(100, 17).addBox(-9.0F, -8.9F, -5.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(100, 27).addBox(-9.0F, -14.9F, -5.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.1F, -3.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(66, 55).addBox(-2.0F, -2.3333F, -2.1667F, 4.0F, 30.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(82, 38).addBox(2.0F, 8.6667F, 0.8333F, 9.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -25.6667F, 0.1667F));

		PartDefinition lowerarm2 = leftarm.addOrReplaceChild("lowerarm2", CubeListBuilder.create().texOffs(0, 35).addBox(-4.0F, 40.6667F, -2.1667F, 8.0F, 11.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(32, 63).addBox(-2.0F, -0.3333F, -2.1667F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(82, 21).addBox(2.0F, 14.6667F, 0.8333F, 9.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 0.0F));

		PartDefinition cube_r7 = lowerarm2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(48, 95).mirror().addBox(0.0F, 0.0F, -0.001F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0004F, 40.6667F, 9.8343F, 0.0F, -0.6981F, 0.0F));

		PartDefinition cube_r8 = lowerarm2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(48, 95).addBox(0.0F, 0.0F, -0.001F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 40.6667F, 9.8343F, 0.0F, 0.6981F, 0.0F));

		PartDefinition cube_r9 = lowerarm2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(84, 0).addBox(-8.0F, -0.001F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 51.6685F, 9.8326F, -0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r10 = lowerarm2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(84, 0).addBox(-8.0F, 0.001F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 40.6657F, 9.8333F, 0.6981F, 0.0F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(66, 21).addBox(-2.0F, -2.3333F, -2.1667F, 4.0F, 30.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(82, 72).addBox(-11.0F, 0.6667F, 0.8333F, 9.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -25.6667F, 0.1667F));

		PartDefinition lowerarm = rightarm.addOrReplaceChild("lowerarm", CubeListBuilder.create().texOffs(16, 63).addBox(-2.0F, -0.3333F, -2.1667F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 35).mirror().addBox(-4.0F, 40.6667F, -2.1667F, 8.0F, 11.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(82, 55).addBox(-11.0F, -1.3333F, 0.8333F, 9.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 0.0F));

		PartDefinition cube_r11 = lowerarm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(84, 0).mirror().addBox(0.0F, 0.001F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 40.6657F, 9.8333F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r12 = lowerarm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(48, 95).mirror().addBox(0.0F, 0.0F, -0.001F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 40.6667F, 9.8343F, 0.0F, -0.6981F, 0.0F));

		PartDefinition cube_r13 = lowerarm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(84, 0).mirror().addBox(0.0F, -0.001F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 51.6685F, 9.8325F, -0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r14 = lowerarm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 95).addBox(0.0F, 0.0F, -0.001F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0004F, 40.6667F, 9.8342F, 0.0F, 0.6981F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void setupAnim(EndersentEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (!entity.isSleep()) {

			this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
		}
		if (entity.getAttackState() != 6 && !entity.isSleep()) {
			this.animateWalk(EndersentAdvancedAnimations.WALK2, limbSwing, limbSwingAmount, 1.5F, 4.0F);
		}
		this.animate(entity.getAnimationState("death"), EndersentAdvancedAnimations.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("idle"), EndersentAdvancedAnimations.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sleep"), EndersentAdvancedAnimations.SLEEP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("awake"), EndersentAdvancedAnimations.AWAKE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarmright"), EndersentAdvancedAnimations.ATTACK4, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarmleft"), EndersentAdvancedAnimations.ATTACK3, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarms"), EndersentAdvancedAnimations.ATTACK2, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackteleport"), EndersentAdvancedAnimations.ATTACKTELEPORT, ageInTicks, 1.0F);
	}



	private void applyHeadRotation(EndersentEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}




	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

	}

	@Override
	public ModelPart root() {
		return root;
	}
}