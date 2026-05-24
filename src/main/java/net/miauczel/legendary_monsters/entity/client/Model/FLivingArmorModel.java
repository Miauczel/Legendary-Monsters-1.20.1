// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.LivingArmorAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights.FLivingArmorEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class FLivingArmorModel<T extends FLivingArmorEntity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart headup3;
	private final ModelPart rightArm;
	private final ModelPart lowerarm2;
	private final ModelPart sword;
	private final ModelPart sword2;
	private final ModelPart bone;
	private final ModelPart leftArm;
	private final ModelPart lowerarm;
	private final ModelPart shield;
	private final ModelPart blade;
	private final ModelPart lowerbody;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public FLivingArmorModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.head = this.body.getChild("head");
		this.headup3 = this.head.getChild("headup3");
		this.rightArm = this.body.getChild("rightArm");
		this.lowerarm2 = this.rightArm.getChild("lowerarm2");
		this.sword = this.lowerarm2.getChild("sword");
		this.sword2 = this.sword.getChild("sword2");
		this.bone = this.sword2.getChild("bone");
		this.leftArm = this.body.getChild("leftArm");
		this.lowerarm = this.leftArm.getChild("lowerarm");
		this.shield = this.lowerarm.getChild("shield");
		this.blade = this.shield.getChild("blade");
		this.lowerbody = this.root.getChild("lowerbody");
		this.leftLeg = this.lowerbody.getChild("leftLeg");
		this.rightLeg = this.lowerbody.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 50).addBox(-4.0F, -11.6F, -1.95F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 34).addBox(-5.0F, -12.1F, -2.7F, 10.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.4F, -0.05F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 18).addBox(-4.0F, -8.5F, -4.8333F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(26, 0).addBox(-4.5F, -9.0F, -5.3333F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.1F, 0.8833F));

		PartDefinition headup3 = head.addOrReplaceChild("headup3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.5F, -6.5F, 0.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 1.6667F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(62, 0).addBox(-2.25F, -2.25F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.25F, -9.35F, 0.05F));

		PartDefinition leftArm_r1 = rightArm.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(40, 56).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -0.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition lowerarm2 = rightArm.addOrReplaceChild("lowerarm2", CubeListBuilder.create().texOffs(60, 50).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.3F))
				.texOffs(60, 60).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 3.75F, 0.0F));

		PartDefinition sword = lowerarm2.addOrReplaceChild("sword", CubeListBuilder.create(), PartPose.offset(0.0F, 3.6681F, 0.5F));

		PartDefinition sword2 = sword.addOrReplaceChild("sword2", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition bone = sword2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(110, 9).addBox(-2.5F, -3.5F, -4.3319F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(100, 0).addBox(-1.5F, -28.5F, -5.8319F, 0.0F, 23.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(110, 0).addBox(-2.5F, -5.5F, -6.8319F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(110, 18).addBox(-1.5F, -6.5F, -9.8319F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(110, 15).addBox(-1.5F, -6.5F, 0.1681F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(118, 9).addBox(-0.999F, -2.499F, -1.501F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.5F, 5.1213F, -2.6248F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(62, 0).mirror().addBox(-1.75F, -2.25F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.25F, -9.35F, 0.05F));

		PartDefinition rightArm_r1 = leftArm.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(40, 56).mirror().addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.75F, -0.75F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition lowerarm = leftArm.addOrReplaceChild("lowerarm", CubeListBuilder.create().texOffs(60, 50).mirror().addBox(-1.5F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false)
				.texOffs(60, 60).mirror().addBox(-1.5F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.25F, 4.75F, 0.0F));

		PartDefinition shield = lowerarm.addOrReplaceChild("shield", CubeListBuilder.create().texOffs(58, 18).addBox(-2.25F, -0.5F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4F, 2.5F, 0.0F));

		PartDefinition blade = shield.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(32, 34).addBox(-0.25F, -5.5F, -5.5F, 1.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.0F, 0.0F));

		PartDefinition lowerbody = root.addOrReplaceChild("lowerbody", CubeListBuilder.create(), PartPose.offset(0.0F, -12.4F, -0.05F));

		PartDefinition leftLeg = lowerbody.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(24, 56).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(56, 34).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(1.9F, 0.4F, 0.05F));

		PartDefinition rightLeg = lowerbody.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(24, 56).mirror().addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 34).mirror().addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(-1.9F, 0.4F, 0.05F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}



	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((FLivingArmorEntity) entity, netHeadYaw, headPitch, ageInTicks);


		if (entity.getAttackState() == 0) this.animateWalk(LivingArmorAnimations.WALK4, limbSwing, limbSwingAmount, 1.5f, 2.5f);
		this.animate((entity).idleAnimationState, LivingArmorAnimations.idle,ageInTicks, 1f);

		this.animate(( ( entity).slashAnimationState), LivingArmorAnimations.singleSlash,ageInTicks, 1f);
		this.animate(( ( entity).sweepSpinAnimationState), LivingArmorAnimations.spinSlash,ageInTicks, 1f);

		this.animate(( entity).DeathAnimationState, LivingArmorAnimations.death,ageInTicks, 1f);

		this.animate(( entity).parryAnimationState, LivingArmorAnimations.parry,ageInTicks, 1f);

		this.animate(( entity).parryFrameAnimationState, LivingArmorAnimations.parryFrame,ageInTicks, 1f);

		this.animate(( entity).parryFailAnimationState, LivingArmorAnimations.parryFail,ageInTicks, 1f);

		this.animate(( entity).parrySuccessAnimationState, LivingArmorAnimations.parrySuccess,ageInTicks, 1f);

		this.animate(( entity).sitAnimationState, LivingArmorAnimations.sit,ageInTicks, 1f);
		this.root.xScale = 1.25F;
		this.root.yScale = 1.25F;
		this.root.zScale = 1.25F;
	}



	private void applyHeadRotation(FLivingArmorEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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