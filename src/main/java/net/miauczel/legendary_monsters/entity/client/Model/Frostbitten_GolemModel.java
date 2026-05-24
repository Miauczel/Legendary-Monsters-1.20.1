// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.FrostbittenGolemAnimationTest;
import net.miauczel.legendary_monsters.entity.animations.Frostbitten_GolemAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Frostbitten_GolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class Frostbitten_GolemModel<T extends Frostbitten_GolemEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public Frostbitten_GolemModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("bone").getChild("body").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -2.0F));

		PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(60, 47).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 2.0F));

		PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -14.0F, -6.0F, 20.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -2.0F));

		PartDefinition icespike3 = body.addOrReplaceChild("icespike3", CubeListBuilder.create().texOffs(0, 26).addBox(-3.7493F, -16.9291F, -4.6581F, 7.0F, 19.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(84, 56).addBox(-5.7493F, -5.9291F, -5.6581F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(56, 70).addBox(1.2507F, -8.9291F, -5.6581F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(40, 64).mirror().addBox(-5.7493F, -8.9291F, -0.6581F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.9955F, -12.9285F, 2.7706F, -0.2618F, 0.0F, 0.2182F));

		PartDefinition icespike2 = body.addOrReplaceChild("icespike2", CubeListBuilder.create().texOffs(60, 26).addBox(-2.5347F, -14.0003F, -4.3835F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 52).addBox(-1.5347F, -23.0003F, -3.3835F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(84, 22).addBox(-4.5347F, -9.0003F, -5.3835F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 36).addBox(2.4653F, -8.0003F, -0.3835F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(40, 64).addBox(3.4653F, -11.0003F, -5.3835F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4859F, -11.8327F, 2.2281F, -0.2618F, 0.0F, -0.2182F));

		PartDefinition cube_r1 = icespike2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 64).addBox(-0.4F, -8.5F, 1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9653F, -5.5003F, -1.3835F, -0.0873F, -0.0436F, 0.2182F));

		PartDefinition leftarm2 = body.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(28, 26).addBox(-4.0353F, -4.1891F, -4.5796F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-3.0353F, 6.8109F, -3.5796F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(28, 45).addBox(-4.0353F, 11.8109F, -4.5796F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(20, 81).addBox(-4.0353F, 17.8109F, 3.4204F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 11).addBox(-4.0353F, 14.8109F, 6.4204F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0353F, -11.8109F, 0.5796F));

		PartDefinition cube_r2 = leftarm2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(42, 80).addBox(-2.5F, -5.5F, 1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0788F, -5.9667F, 2.3934F, -0.7308F, 0.0886F, 0.6394F));

		PartDefinition cube_r3 = leftarm2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(72, 70).addBox(3.0F, -7.5F, 1.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0353F, -8.6891F, -0.5796F, -0.3491F, 0.0F, 0.3927F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-2.9647F, 6.8109F, -3.5796F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(28, 45).mirror().addBox(-3.9647F, 11.8109F, -4.5796F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(20, 81).mirror().addBox(-3.9647F, 17.8109F, 3.4204F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 11).mirror().addBox(-3.9647F, 14.8109F, 6.4204F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(28, 26).mirror().addBox(-3.9647F, -4.1891F, -4.5796F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-14.0353F, -11.8109F, 0.5796F));

		PartDefinition cube_r4 = rightarm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(42, 80).mirror().addBox(-0.5F, -5.5F, 1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0788F, -5.9667F, 2.3934F, -0.7308F, -0.0886F, -0.6394F));

		PartDefinition cube_r5 = rightarm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(72, 70).mirror().addBox(-7.0F, -7.5F, 1.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0353F, -8.6891F, -0.5796F, -0.3491F, 0.0F, -0.3927F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 79).addBox(-3.5F, -4.5F, -4.5F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -4.5F));

		PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(60, 56).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -8.0F, 0.0F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(60, 56).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (!entity.isSleep()) {

			this.applyHeadRotation((Frostbitten_GolemEntity) entity, netHeadYaw, headPitch, ageInTicks);
		}
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("death"), FrostbittenGolemAnimationTest.death, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("idle"), FrostbittenGolemAnimationTest.idle, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("sleep"), FrostbittenGolemAnimationTest.sleep, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("awake"), FrostbittenGolemAnimationTest.awake, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("attackarmright"), FrostbittenGolemAnimationTest.rightArmSlam, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("attackarmleft"), FrostbittenGolemAnimationTest.leftArmSlam, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("attackarms"), FrostbittenGolemAnimationTest.slamAttack, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("attackaggresive"), FrostbittenGolemAnimationTest.IceSpikeBigSummon, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("attackicespike"), FrostbittenGolemAnimationTest.IceSpikeSummon, ageInTicks, 1.0F);
		this.animate(((Frostbitten_GolemEntity) entity).getAnimationState("laser"), FrostbittenGolemAnimationTest.laserAttack, ageInTicks, 1.0F);

		this.animateWalk(Frostbitten_GolemAnimations.WALK5, limbSwing, limbSwingAmount, 1.5f, 2.5f);
	}






	private void applyHeadRotation(Frostbitten_GolemEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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