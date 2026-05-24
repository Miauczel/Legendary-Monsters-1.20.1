// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.ShulkerMimic.NewShulkerMimicAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class Shulker_MimicModel<T extends Shulker_MimicEntity> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart body;
	public final ModelPart head;
	private final ModelPart headmini;
	private final ModelPart upperboxinnerrotation;
	private final ModelPart upperbox;
	private final ModelPart lowerboxinnerrotation;
	private final ModelPart lowerbox;
	private final ModelPart lowerbody;
	private final ModelPart rotors;

	public Shulker_MimicModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.head = this.body.getChild("head");
		this.headmini = this.head.getChild("headmini");
		this.upperboxinnerrotation = this.head.getChild("upperboxinnerrotation");
		this.upperbox = this.upperboxinnerrotation.getChild("upperbox");
		this.lowerboxinnerrotation = this.head.getChild("lowerboxinnerrotation");
		this.lowerbox = this.lowerboxinnerrotation.getChild("lowerbox");
		this.lowerbody = this.body.getChild("lowerbody");
		this.rotors = this.lowerbody.getChild("rotors");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 1.0F));

		PartDefinition headmini = head.addOrReplaceChild("headmini", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 94).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -6.1F, -1.0F));

		PartDefinition upperboxinnerrotation = head.addOrReplaceChild("upperboxinnerrotation", CubeListBuilder.create(), PartPose.offset(0.0F, -13.2F, -0.5F));

		PartDefinition upperbox = upperboxinnerrotation.addOrReplaceChild("upperbox", CubeListBuilder.create().texOffs(0, 67).addBox(-10.0F, -9.8F, -20.0F, 20.0F, 7.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 66).addBox(-10.0F, -2.8F, -20.0F, 20.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 10.0F));

		PartDefinition cube_r1 = upperbox.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(64, 94).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.8F, 2.122F, -3.1416F, 0.7854F, -3.1416F));

		PartDefinition cube_r2 = upperbox.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(64, 94).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.1213F, -6.8F, -10.0007F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r3 = upperbox.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(64, 94).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.1213F, -6.8F, -10.0007F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r4 = upperbox.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(64, 94).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.8F, 2.122F, -3.1416F, -0.7854F, 3.1416F));

		PartDefinition lowerboxinnerrotation = head.addOrReplaceChild("lowerboxinnerrotation", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition lowerbox = lowerboxinnerrotation.addOrReplaceChild("lowerbox", CubeListBuilder.create().texOffs(0, 40).addBox(-10.0F, 2.8F, -20.0F, 20.0F, 7.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 40).addBox(-10.0F, -3.2F, -20.0F, 20.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.8F, 9.5F));

		PartDefinition cube_r5 = lowerbox.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(76, 104).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.1213F, 6.8F, -10.0007F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r6 = lowerbox.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(76, 104).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.1213F, 6.8F, -10.0007F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r7 = lowerbox.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(76, 104).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8F, 2.122F, 3.1416F, 0.7854F, 3.1416F));

		PartDefinition cube_r8 = lowerbox.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(76, 104).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.8F, 2.122F, 3.1416F, -0.7854F, -3.1416F));

		PartDefinition lowerbody = body.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(80, 92).addBox(-5.0F, 15.0F, -4.5F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 0.0F));

		PartDefinition rotors = lowerbody.addOrReplaceChild("rotors", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, 0.0F, -20.0F, 40.0F, 0.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	public void translateModel(PoseStack pMatrixStack) {
		body.translateAndRotate(pMatrixStack);
		root.translateAndRotate(pMatrixStack);
		this.head.translateAndRotate(pMatrixStack);

	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation( entity, netHeadYaw, headPitch, ageInTicks);
		if (entity.getAttackState() == 0) {
			this.animateWalk(NewShulkerMimicAnimations.walk, limbSwing, limbSwingAmount, 1.5F, 4.0F);
		}
		this.animate(( entity).getAnimationState("idle"), NewShulkerMimicAnimations.idle, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("bite"), NewShulkerMimicAnimations.bite3, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("backstep"), NewShulkerMimicAnimations.backStep, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("backstep_charge"), NewShulkerMimicAnimations.backstepCharge, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("triple_shoot"), NewShulkerMimicAnimations.tripleShootBullets2, ageInTicks, 1.0F);


		this.animate(( entity).getAnimationState("double_shoot"), NewShulkerMimicAnimations.doubleShootBullets, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("triple_shoot_tp1"), NewShulkerMimicAnimations.tripleShootBulletsTp3, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("triple_shoot_tp2"), NewShulkerMimicAnimations.tripleShootBulletsTp4, ageInTicks, 1.0F);


		this.animate(( entity).getAnimationState("big_shoot"), NewShulkerMimicAnimations.bigShoot2, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("pull_hit"), NewShulkerMimicAnimations.pushAway2, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("double_slash"), NewShulkerMimicAnimations.doubleSlash3, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("death"), NewShulkerMimicAnimations.death, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("firework_grab_pre"), NewShulkerMimicAnimations.fireworkGrabPre2, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("firework_grab_fail"), NewShulkerMimicAnimations.fireworkGrabFail, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("firework_grab_success"), NewShulkerMimicAnimations.fireworkGrabSuccess, ageInTicks, 1.0F);


		this.animate(( entity).getAnimationState("sleep"), NewShulkerMimicAnimations.sleep, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("awaken"), NewShulkerMimicAnimations.awaken, ageInTicks, 1.0F);

		//root.xScale = 1.5f;

		//root.yScale = 1.5f;

		//root.zScale = 1.5f;
	}




	private void applyHeadRotation(Shulker_MimicEntity	 pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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