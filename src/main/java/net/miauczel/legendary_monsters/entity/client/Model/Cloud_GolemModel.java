// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.*;
import net.miauczel.legendary_monsters.entity.animations.replacer.CGAnims;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class Cloud_GolemModel<T extends Cloud_GolemEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	private final ModelPart u1;

	private final ModelPart u2;

	public Cloud_GolemModel(ModelPart root) {
		this.root = root.getChild("root");

		this.u1 = root.getChild("root").getChild("body").getChild("left_arm").getChild("upper");
		this.u2 = root.getChild("root").getChild("body").getChild("rightarm").getChild("upper2");
		this.head = root.getChild("root").getChild("body").getChild("head");



	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 6.9999F, 0.0826F));

		PartDefinition rune_lower = body.addOrReplaceChild("rune_lower", CubeListBuilder.create().texOffs(0, 0).addBox(-17.75F, -9.0F, -4.5F, 36.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(44, 82).addBox(-17.75F, -22.0F, -4.5F, 9.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 0.0F, 0.5F));

		PartDefinition rune_upper = body.addOrReplaceChild("rune_upper", CubeListBuilder.create().texOffs(0, 18).addBox(-18.25F, 0.0F, -4.5F, 36.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(80, 82).addBox(8.75F, 9.0F, -4.5F, 9.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -35.0F, 0.5F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-2.0F, 14.0F, -5.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(-25.2F, -20.0F, 3.1F));

		PartDefinition upper2 = rightarm.addOrReplaceChild("upper2", CubeListBuilder.create().texOffs(44, 36).mirror().addBox(-5.8F, -3.0F, -8.1F, 11.0F, 13.0F, 11.0F, new CubeDeformation(0.3F)).mirror(false)
				.texOffs(0, 36).mirror().addBox(-5.8F, -3.0F, -8.1F, 11.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower2 = rightarm.addOrReplaceChild("lower2", CubeListBuilder.create().texOffs(90, 0).mirror().addBox(-3.5F, -1.6667F, -3.8333F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 60).mirror().addBox(-3.5F, 9.3333F, -3.8333F, 7.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(90, 18).mirror().addBox(-3.5F, 4.3333F, 6.1667F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.3F, 15.6667F, -2.2667F));

		PartDefinition beam_outer = lower2.addOrReplaceChild("beam_outer", CubeListBuilder.create().texOffs(80, 104).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.3F, 9.3333F, 2.2667F));

		PartDefinition beam_inner = beam_outer.addOrReplaceChild("beam_inner", CubeListBuilder.create().texOffs(34, 104).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(25.5F, -20.25F, 2.6667F));

		PartDefinition upper = left_arm.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(44, 36).addBox(-5.5F, -6.5F, -5.5F, 11.0F, 13.0F, 11.0F, new CubeDeformation(0.3F))
				.texOffs(0, 36).addBox(-5.5F, -6.5F, -5.5F, 11.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.75F, -2.1667F));

		PartDefinition lower = left_arm.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(90, 0).addBox(-3.5F, -1.6667F, -3.8333F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(-3.5F, 9.3333F, -3.8333F, 7.0F, 8.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(90, 18).addBox(-3.5F, 4.3333F, 6.1667F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.9167F, -1.8333F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 83).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(88, 36).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -16.5F, 0.5F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(80, 60).addBox(-4.5F, -0.5F, -4.5F, 9.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, 8.4999F, 0.5826F));

		PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(44, 60).addBox(-4.5F, -0.5F, -4.5F, 9.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.5F, 8.4999F, 0.5826F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((Cloud_GolemEntity) entity, netHeadYaw, headPitch, ageInTicks);
		if (entity.getAttackState()!=28) {
			this.animateWalk(CloudGolemAnimations.walk4, limbSwing, limbSwingAmount, 1.5F, 2.5F);
		}
		this.animate((entity).getAnimationState("death"), CloudGolemAnimations.death, ageInTicks, 1.0F);
		this.animate((entity).getAnimationState("idle"), CloudGolemAnimations.idle, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("sleep"), CloudGolemAnimations.sleep, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("awake"), CloudGolemAnimations.awake, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("attackarmright"), CloudGolemAnimations.rightarmAttack, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("cloudattack"), CloudGolemAnimations.Summon, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("p2"), CloudGolemAnimations.stompp2, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("cloudattackbig"), CloudGolemAnimations.BigSummon, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("blockhitdb"), CloudGolemAnimations.blockhitDB2, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("blockhitstun"), CGAnims.blockHitStun2, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("blockhit"), CloudGolemAnimations.blockhit, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("explode"), CGAnims.explode2, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("attackarmleft"), CloudGolemAnimations.leftarmAttack, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("attackarms"), CloudGolemAnimations.slamAttack, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("attacklightning"), CloudGolemAnimations.attackLight, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("flip"), CloudGolemAnimations.flipHit
				, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("fractureland"), CGAnims.LandFracture2, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("aendcharge"), CGAnims.chargeEndAggresive, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("endcharge"), CGAnims.chargeEnd, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("charge"), CGAnims.charge, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("precharge"), CGAnims.chargePre, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("block"), CloudGolemAnimations.block, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("stompleft"), CGAnims.stompsLeft, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("stomp"), CGAnims.stomps3, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("laser2"), CloudGolemAnimations.laser2, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("fly"), CloudGolemAnimations.fly, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("land"), CloudGolemAnimations.heroFallEnd, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("prefracturefall"), CloudGolemAnimations.heroFall, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("fall"), CloudGolemAnimations.heroFall, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("laser"), CloudGolemAnimations.laser4, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("resp"), CloudGolemAnimations.respawn, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("pull"), CloudGolemAnimations.pullin, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("pullpre"), CloudGolemAnimations.pullPre, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("postpull"), CloudGolemAnimations.pullAttack, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("mhit"), CGAnims.lightningSummon5, ageInTicks, 1.0F);
	}





	private void applyHeadRotation(Cloud_GolemEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -300.0F, 300.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -180.0F, 220.0F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 380F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 360F);
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