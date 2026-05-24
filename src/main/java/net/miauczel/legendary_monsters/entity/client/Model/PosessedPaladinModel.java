// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.PosessedPaladinEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class PosessedPaladinModel<T extends PosessedPaladinEntity
		> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart leftLeg;
	private final ModelPart middle;
	private final ModelPart lowerleg;
	private final ModelPart rightLeg;
	private final ModelPart middleright;
	private final ModelPart lowerlegright;
	private final ModelPart lowerbody;
	private final ModelPart body;
	private final ModelPart cape;
	private final ModelPart lower;
	private final ModelPart rightArm;
	private final ModelPart lowerarm2;
	private final ModelPart sword;
	private final ModelPart SoulGreatSword;
	private final ModelPart group;
	private final ModelPart lowerarm3;
	private final ModelPart shield2;
	private final ModelPart lowerarm4;
	private final ModelPart leftArm;
	private final ModelPart lowerarm;
	private final ModelPart head;

	public PosessedPaladinModel(ModelPart root) {
		this.root = root.getChild("root");
		this.leftLeg = this.root.getChild("leftLeg");
		this.middle = this.leftLeg.getChild("middle");
		this.lowerleg = this.middle.getChild("lowerleg");
		this.rightLeg = this.root.getChild("rightLeg");
		this.middleright = this.rightLeg.getChild("middleright");
		this.lowerlegright = this.middleright.getChild("lowerlegright");
		this.lowerbody = this.root.getChild("lowerbody");
		this.body = this.lowerbody.getChild("body");
		this.cape = this.body.getChild("cape");
		this.lower = this.cape.getChild("lower");
		this.rightArm = this.body.getChild("rightArm");
		this.lowerarm2 = this.rightArm.getChild("lowerarm2");
		this.sword = this.lowerarm2.getChild("sword");
		this.SoulGreatSword = this.sword.getChild("SoulGreatSword");
		this.group = this.SoulGreatSword.getChild("group");
		this.lowerarm3 = this.rightArm.getChild("lowerarm3");
		this.shield2 = this.lowerarm3.getChild("shield2");
		this.lowerarm4 = this.rightArm.getChild("lowerarm4");
		this.leftArm = this.body.getChild("leftArm");
		this.lowerarm = this.leftArm.getChild("lowerarm");
		this.head = this.body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftLeg = root.addOrReplaceChild("leftLeg", CubeListBuilder.create(), PartPose.offset(2.9F, -12.0F, 1.0F));

		PartDefinition upper_r1 = leftLeg.addOrReplaceChild("upper_r1", CubeListBuilder.create().texOffs(40, 55).addBox(-2.5F, -2.5F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.7735F, -0.6484F, -0.2182F, 0.0F, 0.0F));

		PartDefinition middle = leftLeg.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offset(0.001F, 2.5657F, -2.1173F));

		PartDefinition mid_r1 = middle.addOrReplaceChild("mid_r1", CubeListBuilder.create().texOffs(20, 59).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.001F, 2.1514F, 0.8038F, 0.1309F, 0.0F, 0.0F));

		PartDefinition lowerleg = middle.addOrReplaceChild("lowerleg", CubeListBuilder.create().texOffs(58, 55).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(60, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-0.001F, 4.4343F, 0.6173F));

		PartDefinition rightLeg = root.addOrReplaceChild("rightLeg", CubeListBuilder.create(), PartPose.offset(-2.9F, -12.0F, 1.0F));

		PartDefinition upper_r2 = rightLeg.addOrReplaceChild("upper_r2", CubeListBuilder.create().texOffs(40, 55).mirror().addBox(-1.5F, -2.5F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.7735F, -0.6484F, -0.2182F, 0.0F, 0.0F));

		PartDefinition middleright = rightLeg.addOrReplaceChild("middleright", CubeListBuilder.create(), PartPose.offset(-0.001F, 2.5657F, -2.1173F));

		PartDefinition rightLeg_r1 = middleright.addOrReplaceChild("rightLeg_r1", CubeListBuilder.create().texOffs(20, 59).mirror().addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)).mirror(false), PartPose.offsetAndRotation(0.001F, 2.1514F, 0.8038F, 0.1309F, 0.0F, 0.0F));

		PartDefinition lowerlegright = middleright.addOrReplaceChild("lowerlegright", CubeListBuilder.create().texOffs(58, 55).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(60, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(0.001F, 4.4343F, 0.6173F));

		PartDefinition lowerbody = root.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(32, 32).addBox(-4.0F, -11.6F, -1.95F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.4F, -0.05F));

		PartDefinition body_r1 = lowerbody.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(40, 48).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.2F, 3.55F, -1.7453F, 0.0F, -3.1416F));

		PartDefinition body_r2 = lowerbody.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(40, 48).addBox(-2.0F, -1.0F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.8F, -2.65F, 1.2654F, 0.0F, 0.0F));

		PartDefinition body = lowerbody.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -6.9256F, 0.2626F));

		PartDefinition upper_r3 = body.addOrReplaceChild("upper_r3", CubeListBuilder.create().texOffs(0, 18).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.6744F, -0.2126F, -0.48F, 0.0F, 0.0F));

		PartDefinition cape = body.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(0, 45).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.4884F, 4.7197F));

		PartDefinition lower = cape.addOrReplaceChild("lower", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.001F));

		PartDefinition lower_r1 = lower.addOrReplaceChild("lower_r1", CubeListBuilder.create().texOffs(0, 57).addBox(-5.0F, 0.0981F, 0.2321F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0316F, -0.2509F, 0.5236F, 0.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(56, 24).mirror().addBox(-1.9791F, -1.7416F, -1.9992F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0209F, -4.9328F, -1.2134F));

		PartDefinition rightArm_r1 = rightArm.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(20, 48).mirror().addBox(-5.0F, -1.0F, 0.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0209F, -1.2416F, -2.4992F, 0.0F, 0.0F, 0.3927F));

		PartDefinition lowerarm2 = rightArm.addOrReplaceChild("lowerarm2", CubeListBuilder.create().texOffs(56, 35).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0209F, 5.2584F, 0.0008F));

		PartDefinition leftArm_r1 = lowerarm2.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(54, 16).mirror().addBox(-4.0F, -2.366F, 0.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 3.9F, -2.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition sword = lowerarm2.addOrReplaceChild("sword", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.6681F, 2.5F, 1.5708F, 0.0F, -1.5708F));

		PartDefinition SoulGreatSword = sword.addOrReplaceChild("SoulGreatSword", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.7765F, -0.2034F, 0.0F, -1.5708F, 0.7854F));

		PartDefinition group = SoulGreatSword.addOrReplaceChild("group", CubeListBuilder.create().texOffs(78, 36).addBox(-1.0F, 9.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(78, 0).addBox(0.0F, -29.5F, -3.5F, 0.0F, 29.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(110, 20).addBox(-1.5F, 7.5F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(92, 0).addBox(-1.5F, 4.5F, -4.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(-0.03F))
				.texOffs(92, 26).addBox(0.0F, 3.5F, -10.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(106, 34).addBox(-0.999F, 0.501F, -2.999F, 1.998F, 3.998F, 5.998F, new CubeDeformation(-0.03F))
				.texOffs(92, 32).mirror().addBox(0.0F, 3.5F, 1.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4F, -6.8561F, 6.5673F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(92, 12).addBox(-1.5F, -3.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r2 = group.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(106, 26).addBox(-1.498F, -1.998F, -2.002F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.65F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r3 = group.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(110, 12).addBox(-0.999F, -2.499F, -1.501F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.03F)), PartPose.offsetAndRotation(0.0F, 16.6213F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition lowerarm3 = rightArm.addOrReplaceChild("lowerarm3", CubeListBuilder.create(), PartPose.offset(0.0209F, 7.2584F, 0.0008F));

		PartDefinition shield2 = lowerarm3.addOrReplaceChild("shield2", CubeListBuilder.create(), PartPose.offset(-0.4F, 2.5F, 0.0F));

		PartDefinition lowerarm4 = rightArm.addOrReplaceChild("lowerarm4", CubeListBuilder.create(), PartPose.offset(0.0209F, 7.2584F, 0.0008F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(56, 24).addBox(-2.0209F, -1.7416F, -1.9992F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0209F, -4.9328F, -1.2134F));

		PartDefinition leftArm_r2 = leftArm.addOrReplaceChild("leftArm_r2", CubeListBuilder.create().texOffs(20, 48).addBox(0.0F, -1.0F, 0.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0209F, -1.2416F, -2.4992F, 0.0F, 0.0F, -0.3927F));

		PartDefinition lowerarm = leftArm.addOrReplaceChild("lowerarm", CubeListBuilder.create().texOffs(56, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0209F, 5.2584F, 0.0008F));

		PartDefinition rightArm_r2 = lowerarm.addOrReplaceChild("rightArm_r2", CubeListBuilder.create().texOffs(54, 16).addBox(-1.0F, -2.366F, 0.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.9F, -2.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-0.0349F, -5.7577F, -0.4667F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 16).addBox(-2.0F, -6.0F, -2.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(20, 45).addBox(-0.5F, -9.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(34, 28).addBox(-1.0F, -8.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.5F, -7.5F, -3.5F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 0).addBox(-3.0F, -7.0F, -3.0F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0349F, -1.9167F, -0.746F, 0.0F, -0.829F, 0.0F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 32).addBox(-1.7319F, -12.5F, -0.682F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7332F, -11.4167F, 0.636F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((PosessedPaladinEntity) entity, netHeadYaw, headPitch, ageInTicks);

		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
		if (entity.getAttackState() != 6 && !entity.isSleep()) {
			this.animateWalk(PPAnims.walk, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}
		this.animate(entity.getAnimationState("death"), PPAnims.death, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("idle"), PPAnims.idle, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sleep"), PPAnims.sleep, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("awake"), PPAnims.Awake, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("slash"), PPAnims.attack10, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("midslash"), PPAnims.attack11, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("runpre"), PPAnims.rpre, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("run"), PPAnims.run, ageInTicks, 2F);
		this.animate(entity.getAnimationState("postrun"), PPAnims.runAttack, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("damage"), PPAnims.damage2, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("combo"), PPAnims.Combo, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("combo3"), PPAnims.Combo6, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("combo1"), PPAnims.Combo1, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("c10"), PPAnims2.attackBlock2	, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("c9"), PPAnims2.blockAttack2	, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("combo8"), PPAnims.Combo8	, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("combo7"), PPAnims.Combo7, ageInTicks, 1.0F);
		this.root.xScale = 1.5F;
		this.root.yScale = 1.5F;
		this.root.zScale = 1.5F;

	}





	private void applyHeadRotation(PosessedPaladinEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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