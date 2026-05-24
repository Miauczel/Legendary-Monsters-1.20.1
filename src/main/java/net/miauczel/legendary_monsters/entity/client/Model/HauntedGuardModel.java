// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.HauntedGuardAnimations;
import net.miauczel.legendary_monsters.entity.animations.LivingArmorAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.HauntedGuardEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class HauntedGuardModel<T extends HauntedGuardEntity> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart lower_body;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart body_c;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart headup;
	private final ModelPart rightArm;
	private final ModelPart lowerarm2;
	private final ModelPart spear_axe;
	private final ModelPart leftArm;
	private final ModelPart lowerarm;
	private final ModelPart shield;

	public HauntedGuardModel(ModelPart root) {
		this.root = root.getChild("root");
		this.lower_body = this.root.getChild("lower_body");
		this.rightLeg = this.lower_body.getChild("rightLeg");
		this.leftLeg = this.lower_body.getChild("leftLeg");
		this.body_c = this.root.getChild("body_c");
		this.body = this.body_c.getChild("body");
		this.head = this.body.getChild("head");
		this.headup = this.head.getChild("headup");
		this.rightArm = this.body.getChild("rightArm");
		this.lowerarm2 = this.rightArm.getChild("lowerarm2");
		this.spear_axe = this.lowerarm2.getChild("spear_axe");
		this.leftArm = this.body.getChild("leftArm");
		this.lowerarm = this.leftArm.getChild("lowerarm");
		this.shield = this.lowerarm.getChild("shield");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition lower_body = root.addOrReplaceChild("lower_body", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition rightLeg = lower_body.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 46).addBox(-1.85F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 50).addBox(-1.85F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-2.15F, 0.0F, 0.0F));

		PartDefinition leftLeg = lower_body.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(48, 50).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(32, 50).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(1.9F, 0.0F, 0.0F));

		PartDefinition body_c = root.addOrReplaceChild("body_c", CubeListBuilder.create(), PartPose.offset(0.0F, -12.4F, -0.05F));

		PartDefinition body = body_c.addOrReplaceChild("body", CubeListBuilder.create().texOffs(36, 0).addBox(-4.0F, -11.6F, -1.95F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(26, 34).addBox(-5.0F, -12.1F, -2.7F, 10.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 18).addBox(-4.0F, -8.5F, -3.8333F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.5F, -9.0F, -4.3333F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.1F, -0.1167F));

		PartDefinition headup = head.addOrReplaceChild("headup", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -7.5F, -6.5F, 0.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 2.6667F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(58, 36).addBox(-1.75F, -2.25F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.75F, -9.35F, 0.05F));

		PartDefinition leftArm_r1 = rightArm.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(58, 26).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition lowerarm2 = rightArm.addOrReplaceChild("lowerarm2", CubeListBuilder.create().texOffs(0, 62).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.3F))
				.texOffs(16, 66).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 3.75F, 0.0F));

		PartDefinition spear_axe = lowerarm2.addOrReplaceChild("spear_axe", CubeListBuilder.create().texOffs(88, 26).addBox(-1.0003F, -15.0833F, -1.1667F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(96, 26).addBox(-1.0003F, -25.0833F, -1.1667F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(96, 32).addBox(-0.0003F, -30.0833F, -1.1667F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(104, 0).addBox(-1.0003F, -21.0833F, -6.1667F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(88, 0).addBox(0.0007F, -27.0833F, -11.1667F, 0.0F, 18.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(104, 16).addBox(0.0007F, -21.0833F, 3.8333F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0003F, 3.8333F, 0.0833F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(64, 46).addBox(-2.25F, -2.25F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.75F, -9.35F, 0.05F));

		PartDefinition leftArm_r2 = leftArm.addOrReplaceChild("leftArm_r2", CubeListBuilder.create().texOffs(58, 16).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -0.75F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition lowerarm = leftArm.addOrReplaceChild("lowerarm", CubeListBuilder.create().texOffs(60, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.3F))
				.texOffs(64, 56).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 4.75F, 0.0F));

		PartDefinition shield = lowerarm.addOrReplaceChild("shield", CubeListBuilder.create(), PartPose.offset(0.4F, 2.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((HauntedGuardEntity) entity, netHeadYaw, headPitch, ageInTicks);

if (entity.getAttackState() == 0) {
	this.animateWalk(LivingArmorAnimations.WALK4, limbSwing, limbSwingAmount, 1.5f, 2.5f);
}
		this.animate((entity).idleAnimationState, LivingArmorAnimations.idle,ageInTicks, 1f);
		this.animate(( (entity).sitAnimationState), HauntedGuardAnimations.sit,ageInTicks, 1f);
		this.animate(( ( entity).slashAnimationState), HauntedGuardAnimations.attack1Smooth,ageInTicks, 1f);

		this.animate(( (entity).uppercutAnimationState), HauntedGuardAnimations.upper_cut,ageInTicks, 1f);

		this.animate(( (entity).slamAnimationState), HauntedGuardAnimations.slam,ageInTicks, 1f);


		this.animate(( (entity).combo2AnimationState), HauntedGuardAnimations.attackCombo,ageInTicks, 1f);

		this.animate(( (entity).DeathAnimationState), LivingArmorAnimations.death,ageInTicks, 1f);

		this.animate(( (entity).guardAnimationState), LivingArmorAnimations.guard,ageInTicks, 1f);

		this.animate(( (entity).awakenAnimationState), LivingArmorAnimations.awaken,ageInTicks, 1f);

		this.root.xScale = 1.25F;
		this.root.yScale = 1.25F;
		this.root.zScale = 1.25F;
	}



	private void applyHeadRotation(HauntedGuardEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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