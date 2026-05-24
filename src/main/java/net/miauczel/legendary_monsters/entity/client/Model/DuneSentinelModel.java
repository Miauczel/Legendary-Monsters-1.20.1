// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.BigCannonAnimations;
import net.miauczel.legendary_monsters.entity.animations.FatalMortarAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.DuneSentinelEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class DuneSentinelModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart legs;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart middlehead;
	private final ModelPart boomhead;

	public DuneSentinelModel(ModelPart root) {
		this.root = root.getChild("root");
		this.legs = this.root.getChild("legs");
		this.main = this.legs.getChild("main");
		this.head = this.main.getChild("head");
		this.middlehead = this.head.getChild("middlehead");
		this.boomhead = this.middlehead.getChild("boomhead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(-1.0F, -5.0F, 0.0F));

		PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(132, 127).addBox(13.0F, -21.5F, 7.0F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(124, 50).addBox(18.0F, -12.5F, -9.0F, 0.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(124, 26).addBox(18.0F, -28.5F, -9.0F, 0.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(92, 103).addBox(14.0F, -20.5F, -9.0F, 8.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(140, 114).addBox(12.0F, -19.5F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(140, 114).mirror().addBox(-12.0F, -19.5F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(92, 103).mirror().addBox(-20.0F, -20.5F, -9.0F, 8.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(124, 26).mirror().addBox(-16.0F, -28.5F, -9.0F, 0.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(124, 50).mirror().addBox(-16.0F, -12.5F, -9.0F, 0.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(132, 127).mirror().addBox(-21.0F, -21.5F, 7.0F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition cube_r1 = legs.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(75, 130).addBox(-5.0F, -4.0F, -9.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(75, 130).mirror().addBox(11.0F, -4.0F, -9.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -13.5F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r2 = legs.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 121).addBox(-5.0F, -6.0F, -12.0F, 6.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 121).mirror().addBox(11.0F, -6.0F, -12.0F, 6.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -22.5F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r3 = legs.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 48).addBox(-8.0F, -17.0F, 3.0F, 28.0F, 28.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.5F, 3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition main = legs.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(-4.0F, -16.5552F, 0.4658F));

		PartDefinition cube_r4 = main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(96, 0).addBox(0.0F, -4.7836F, -1.9763F, 10.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9052F, -1.3658F, 1.3526F, 0.0F, 0.0F));

		PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-11.5351F, -18.6339F, -13.4062F, 24.0F, 24.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(36, 125).mirror().addBox(-18.5351F, -4.6339F, -8.4062F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(42, 78).mirror().addBox(-18.5351F, -2.6339F, -12.4062F, 7.0F, 0.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(36, 125).addBox(15.4649F, -4.6339F, -8.4062F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(42, 78).addBox(12.4649F, -2.6339F, -12.4062F, 7.0F, 0.0F, 22.0F, new CubeDeformation(0.0F))
				.texOffs(102, 127).addBox(-5.5351F, -16.6339F, 10.5938F, 12.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5351F, -18.9609F, 2.5404F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(101, 79).addBox(-4.0F, -6.0F, 11.0F, 18.0F, 18.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5351F, 21.3661F, -4.4062F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(6, 84).addBox(17.0012F, -47.408F, -21.979F, 0.0F, 17.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.5363F, 9.2632F, 56.9843F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(142, 105).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4649F, -8.6339F, 13.5938F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(96, 26).mirror().addBox(-1.0F, -5.0F, 0.0F, 2.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.5351F, -12.7326F, -12.1893F, 0.3244F, 0.1313F, -0.3712F));

		PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(96, 26).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.4649F, -12.7326F, -12.1893F, 0.3244F, -0.1313F, 0.3712F));

		PartDefinition middlehead = head.addOrReplaceChild("middlehead", CubeListBuilder.create().texOffs(42, 100).addBox(-9.0F, -16.5F, -14.75F, 18.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4649F, 0.8661F, -5.6562F));

		PartDefinition boomhead = middlehead.addOrReplaceChild("boomhead", CubeListBuilder.create().texOffs(64, 48).addBox(-11.0F, -11.0F, -7.5F, 22.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5F, -15.25F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((DuneSentinelEntity) entity, netHeadYaw, headPitch, ageInTicks);


        this.animateWalk(BigCannonAnimations.WALK, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(((DuneSentinelEntity) entity).idleAnimationState, BigCannonAnimations.IDLE,ageInTicks, 1f);
		this.animate(((DuneSentinelEntity) entity).DeathAnimationState, FatalMortarAnimations.DEATH,ageInTicks, 1f);
		this.animate(((DuneSentinelEntity) entity).attackAnimationState, FatalMortarAnimations.ATTACK4,ageInTicks, 1f);
		this.animate(((DuneSentinelEntity) entity).shootAnimationState, FatalMortarAnimations.ATTACK1,ageInTicks, 1f);


		this.root.xScale = 1.25F;
		this.root.yScale = 1.25F;
		this.root.zScale = 1.25F;
	}



	private void applyHeadRotation(DuneSentinelEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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