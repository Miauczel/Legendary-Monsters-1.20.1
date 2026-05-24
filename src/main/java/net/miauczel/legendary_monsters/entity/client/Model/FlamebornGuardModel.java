// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn.FlamebornGuardAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.FlamebornGuardEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class FlamebornGuardModel<T extends FlamebornGuardEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public FlamebornGuardModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("Body").getChild("Head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 51).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 35).addBox(-4.0F, -7.95F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -12.05F, 0.0F));

		PartDefinition upperhead = Head.addOrReplaceChild("upperhead", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -7.8F, -9.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.0F, -8.8F, -10.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(66, 66).mirror().addBox(5.0F, -10.8F, -5.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(66, 51).addBox(-2.0F, -13.8F, -10.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(66, 66).addBox(-8.0F, -10.8F, -5.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.15F, 5.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(48, 35).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(56, 35).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.01F))
				.texOffs(64, 25).addBox(-7.0F, -5.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.01F))
				.texOffs(24, 51).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(-4.0F, -10.0F, 0.0F));

		PartDefinition lowerRightArm = RightArm.addOrReplaceChild("lowerRightArm", CubeListBuilder.create().texOffs(48, 50).addBox(-1.0F, -0.6667F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-1.5F, 1.3333F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 15).addBox(-4.5F, 1.3333F, 0.0F, 3.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 13.6667F, 0.0F));

		PartDefinition Weapon = lowerRightArm.addOrReplaceChild("Weapon", CubeListBuilder.create().texOffs(32, 35).addBox(-1.0F, -22.3571F, -1.0F, 2.0F, 38.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(56, 51).addBox(1.0F, -31.3571F, 0.0F, 5.0F, 20.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(56, 51).mirror().addBox(-6.0F, -31.3571F, 0.0F, 5.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 10).addBox(-2.0F, -22.3571F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 56).addBox(-2.0F, -27.3571F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(66, 61).addBox(-2.0F, 15.6429F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(64, 10).addBox(-2.0F, 14.6429F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 12.1905F, 0.0F, 1.5708F, 0.0F, 1.5708F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(48, 35).mirror().addBox(0.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 35).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.01F)).mirror(false)
				.texOffs(64, 25).mirror().addBox(4.0F, -5.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false)
				.texOffs(24, 51).mirror().addBox(0.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(4.0F, -10.0F, 0.0F));

		PartDefinition lowerLeftArm = LeftArm.addOrReplaceChild("lowerLeftArm", CubeListBuilder.create().texOffs(48, 50).mirror().addBox(-1.0F, -0.6667F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 0).mirror().addBox(-1.5F, 1.3333F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 15).mirror().addBox(1.5F, 1.3333F, 0.0F, 3.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 13.6667F, 0.0F));

		PartDefinition RightLeg = root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(48, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(-2.0F, 7.0F, 0.0F));

		PartDefinition LeftLeg = root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(48, 35).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(40, 35).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(2.0F, 7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

		@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
		if (entity.getAttackState() == 0) this.animateWalk(FlamebornGuardAnimations.walk2, limbSwing, limbSwingAmount, 1.5F, 4.0F);

		this.applyHeadRotation( entity, netHeadYaw, headPitch, ageInTicks);

		this.animate(( entity).getAnimationState("idle"), FlamebornGuardAnimations.idle, ageInTicks, 1.0F);

			this.animate(( entity).getAnimationState("sweep"), FlamebornGuardAnimations.sweep2, ageInTicks, 1.0F);

			this.animate(( entity).getAnimationState("sweep_slam"), FlamebornGuardAnimations.sweepSlam, ageInTicks, 1.0F);

			this.animate(( entity).getAnimationState("double_sweep"), FlamebornGuardAnimations.doubleSweep2, ageInTicks, 1.0F);

			this.animate(( entity).getAnimationState("block"), FlamebornGuardAnimations.block, ageInTicks, 1.0F);

			this.animate(( entity).getAnimationState("death"), FlamebornGuardAnimations.death2, ageInTicks, 1.0F);
	}





	private void applyHeadRotation(T pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}




	@Override
	public void renderToBuffer(PoseStack pMatrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(pMatrixStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}

}