// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Fractured.FracturedApostleAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedApostleEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class FracturedApostleModel<T extends FracturedApostleEntity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightArm3;
	private final ModelPart lowerarm2;
	private final ModelPart fist;
	private final ModelPart dagger2;
	private final ModelPart leftArm3;
	private final ModelPart lowerarm4;
	private final ModelPart fist2;
	private final ModelPart book;
	private final ModelPart left_page;
	private final ModelPart right_page;
	private final ModelPart lowerbody;

	public FracturedApostleModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.head = this.body.getChild("head");
		this.rightArm3 = this.body.getChild("rightArm3");
		this.lowerarm2 = this.rightArm3.getChild("lowerarm2");
		this.fist = this.lowerarm2.getChild("fist");
		this.dagger2 = this.fist.getChild("dagger2");
		this.leftArm3 = this.body.getChild("leftArm3");
		this.lowerarm4 = this.leftArm3.getChild("lowerarm4");
		this.fist2 = this.lowerarm4.getChild("fist2");
		this.book = this.fist2.getChild("book");
		this.left_page = this.book.getChild("left_page");
		this.right_page = this.book.getChild("right_page");
		this.lowerbody = this.body.getChild("lowerbody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 22).addBox(-6.0F, -8.5F, -2.9375F, 11.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 43).addBox(-5.5F, -4.5F, -1.4375F, 10.0F, 16.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(36, 43).addBox(-0.5F, 4.5F, 3.5625F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.5F, -0.0625F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(45, 24).addBox(-4.0F, -7.1719F, -4.7104F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(3, 2).addBox(-4.5F, -7.6719F, -5.2104F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -7.8281F, 0.2729F));

		PartDefinition HatLayer_r1 = head.addOrReplaceChild("Hat Layer_r1", CubeListBuilder.create().texOffs(47, 46).addBox(-4.0F, -4.125F, 1.5F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.5469F, 0.2896F, -0.5672F, 0.0F, 0.0F));

		PartDefinition rightArm3 = body.addOrReplaceChild("rightArm3", CubeListBuilder.create().texOffs(82, 22).addBox(-3.8375F, 0.1875F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.8125F, -6.6875F, 1.0625F));

		PartDefinition leftArm_r1 = rightArm3.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(86, 61).addBox(-3.125F, -3.875F, -2.625F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9375F, 3.0625F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition leftArm_r2 = rightArm3.addOrReplaceChild("leftArm_r2", CubeListBuilder.create().texOffs(58, 60).addBox(-4.125F, -3.875F, -3.125F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9375F, 1.0625F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition lowerarm2 = rightArm3.addOrReplaceChild("lowerarm2", CubeListBuilder.create().texOffs(80, 42).addBox(-1.3667F, -0.525F, -1.975F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.4708F, 6.7125F, 0.975F));

		PartDefinition fist = lowerarm2.addOrReplaceChild("fist", CubeListBuilder.create().texOffs(28, 72).addBox(-3.1F, -2.2125F, -2.0375F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1833F, 6.7625F, -0.5125F));

		PartDefinition dagger2 = fist.addOrReplaceChild("dagger2", CubeListBuilder.create().texOffs(48, 82).addBox(-6.0F, -3.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(48, 72).addBox(-7.0F, -2.0F, 5.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(44, 0).addBox(-6.0F, -5.0F, 10.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(6.1F, 2.7125F, -8.4625F));

		PartDefinition leftArm3 = body.addOrReplaceChild("leftArm3", CubeListBuilder.create().texOffs(82, 22).mirror().addBox(-0.1535F, 0.1774F, -2.1812F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.8035F, -6.6774F, 1.2437F));

		PartDefinition rightArm_r1 = leftArm3.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(86, 61).mirror().addBox(-3.875F, -3.875F, -2.625F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9465F, 3.0524F, -0.1812F, 0.0F, 0.0F, 0.0436F));

		PartDefinition rightArm_r2 = leftArm3.addOrReplaceChild("rightArm_r2", CubeListBuilder.create().texOffs(58, 60).mirror().addBox(-3.875F, -3.875F, -3.125F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9465F, 1.0524F, -0.1812F, 0.0F, 0.0F, 0.3927F));

		PartDefinition lowerarm4 = leftArm3.addOrReplaceChild("lowerarm4", CubeListBuilder.create().texOffs(80, 42).mirror().addBox(-2.3F, -0.1917F, -1.975F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.1465F, 6.369F, 0.7938F));

		PartDefinition fist2 = lowerarm4.addOrReplaceChild("fist2", CubeListBuilder.create().texOffs(28, 72).mirror().addBox(-1.9F, -2.2125F, -3.0375F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.85F, 7.0958F, 0.4875F));

		PartDefinition book = fist2.addOrReplaceChild("book", CubeListBuilder.create(), PartPose.offset(0.9F, 2.7125F, -3.4625F));

		PartDefinition left_page = book.addOrReplaceChild("left_page", CubeListBuilder.create().texOffs(68, 0).addBox(0.0F, -1.0F, -5.01F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition right_page = book.addOrReplaceChild("right_page", CubeListBuilder.create().texOffs(0, 64).addBox(-6.0F, -1.0F, -4.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -3.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition lowerbody = body.addOrReplaceChild("lowerbody", CubeListBuilder.create(), PartPose.offset(-0.5F, 11.3925F, 3.5625F));

		PartDefinition body_r1 = lowerbody.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(68, 72).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1075F, 0.0F, 0.8727F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
		this.animate(entity.getAnimationState("idle"), FracturedApostleAnimations.idle,ageInTicks, 1f);
		this.animate(entity.getAnimationState("summon"), FracturedApostleAnimations.trackingProjectileShoot,ageInTicks, 1f);
		this.animate(entity.getAnimationState("death"), FracturedApostleAnimations.death,ageInTicks, 1f);
		this.animate(entity.getAnimationState("attack"), FracturedApostleAnimations.attack,ageInTicks, 1f);

	}



	private void applyHeadRotation(FracturedApostleEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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