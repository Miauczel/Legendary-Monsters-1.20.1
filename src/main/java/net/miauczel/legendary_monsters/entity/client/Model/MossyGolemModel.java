// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.MossyGolemAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.MossyGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class MossyGolemModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public MossyGolemModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -5.0F, -1.0F));

		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 29).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, -1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.5F, -6.5F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(16, 38).addBox(-0.5F, 0.5F, -3.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.5F, -1.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 13).addBox(-1.1F, -12.1F, -0.7F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.5F, -8.1F, -3.2F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 37).addBox(-1.5F, -4.1F, -5.2F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(32, 33).addBox(-4.5F, -8.1F, -4.2F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 38).addBox(-3.5F, -5.1F, -4.2F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.4F, -0.8F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 38).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.1F, 0.8F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 38).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.1F, 0.8F, 0.0F, -2.5307F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 25).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(34, 0).addBox(-0.5F, 2.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(30, 16).addBox(-1.0F, 6.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(8, 38).addBox(-0.5F, 7.5F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(34, 7).addBox(-1.0F, 7.0F, -5.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 38).addBox(-0.5F, 7.5F, 2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -6.5F, 0.0F));

		PartDefinition cube_r3 = left_arm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(34, 7).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 9.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-2.5F, 2.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(30, 16).mirror().addBox(-3.0F, 6.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 38).mirror().addBox(-2.5F, 7.5F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(34, 7).mirror().addBox(-3.0F, 7.0F, -5.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 38).mirror().addBox(-2.5F, 7.5F, 2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(32, 25).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, -6.5F, 0.0F));

		PartDefinition cube_r4 = right_arm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 7).mirror().addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 9.0F, 4.0F, 0.0F, -3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((MossyGolemEntity) entity, netHeadYaw, headPitch, ageInTicks);

		this.animate(((MossyGolemEntity) entity).getAnimationState("slam"), MossyGolemAnimations.smash, ageInTicks, 1.0F);
        this.animateWalk(MossyGolemAnimations.walk4, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(((MossyGolemEntity) entity).idleAnimationState, MossyGolemAnimations.IDLE,ageInTicks, 1f);

		this.animate(((MossyGolemEntity) entity).sitAnimationState, MossyGolemAnimations.sit,ageInTicks, 1f);

		this.animate(((MossyGolemEntity) entity).growthAnimationState, MossyGolemAnimations.growth,ageInTicks, 1f);


		this.root.xScale = 1.25F;
		this.root.yScale = 1.25F;
		this.root.zScale = 1.25F;
	}



	private void applyHeadRotation(MossyGolemEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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