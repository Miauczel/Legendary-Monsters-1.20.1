// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.OCAnims;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Overgrown_colossusEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class Overgrown_colossusModel<T extends Overgrown_colossusEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public Overgrown_colossusModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -25.1667F, -14.1667F, 30.0F, 28.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(44, 103).addBox(-11.0F, 2.8333F, -14.1667F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 58).addBox(-13.0F, -33.1667F, -2.1667F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(120, 0).addBox(-6.0F, -43.1667F, -1.1667F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(122, 60).addBox(11.122F, -39.1667F, 0.7127F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.8333F, 2.1667F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(122, 60).addBox(-7.75F, 1.5F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.1213F, -45.6667F, 17.3689F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(122, 60).mirror().addBox(-3.0F, 10.5F, -3.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4645F, -45.6667F, 17.3689F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(44, 82).addBox(-5.0F, -19.0F, 0.0F, 8.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -27.1667F, 9.8333F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(44, 82).addBox(-4.0F, -16.0F, 0.0F, 8.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2929F, -30.1667F, 10.5404F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(20, 133).addBox(-3.0F, -5.0F, 0.0F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.7071F, -38.1667F, 10.5404F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(20, 133).addBox(-4.0F, -8.0F, 0.0F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -35.1667F, 9.8333F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 133).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -38.1667F, 2.8333F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 133).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -38.1667F, 2.8333F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(122, 69).addBox(-7.0F, -5.0F, 0.0F, 14.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -30.1667F, -7.1667F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(122, 69).addBox(-7.0F, -8.0F, 0.0F, 14.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -27.1667F, -7.1667F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(120, 33).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -27.1667F, -8.1667F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(120, 33).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -27.1667F, -8.1667F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(64, 80).addBox(1.5F, -8.0F, -5.5F, 11.0F, 20.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(122, 43).addBox(-1.5F, -4.0F, -4.5F, 3.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(16.5F, -19.1667F, 0.3333F));

		PartDefinition midleft = leftarm.addOrReplaceChild("midleft", CubeListBuilder.create().texOffs(80, 111).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 12.0F, 0.0F));

		PartDefinition lower = midleft.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(108, 80).addBox(-5.5F, -1.7F, -5.5F, 11.0F, 19.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(104, 128).addBox(-4.5F, 7.3F, -7.5F, 9.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(120, 18).addBox(-5.5F, 6.3F, -11.5F, 11.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.7F, 0.0F));

		PartDefinition cube_r13 = lower.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(120, 18).addBox(-5.5F, -5.5F, -2.0F, 11.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.8F, 9.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r14 = lower.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(104, 128).addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.8F, 6.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(122, 43).mirror().addBox(-1.5F, -4.0F, -4.5F, 3.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 82).addBox(-12.5F, -8.0F, -5.5F, 11.0F, 20.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(108, 110).addBox(-12.5F, 12.0F, -5.5F, 11.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.5F, -19.1667F, 0.3333F));

		PartDefinition cube_r15 = rightarm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(80, 126).addBox(-6.0F, -5.5F, 0.0F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -13.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r16 = rightarm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(80, 126).addBox(-6.0F, -5.5F, 0.0F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -13.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mid = rightarm.addOrReplaceChild("mid", CubeListBuilder.create().texOffs(80, 111).mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		PartDefinition lowerright = mid.addOrReplaceChild("lowerright", CubeListBuilder.create().texOffs(108, 80).mirror().addBox(-5.5F, -1.7F, -5.5F, 11.0F, 19.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(120, 18).mirror().addBox(-5.5F, 6.3F, -11.5F, 11.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(104, 128).mirror().addBox(-4.5F, 7.3F, -7.5F, 9.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.7F, 0.0F));

		PartDefinition cube_r17 = lowerright.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(104, 128).mirror().addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.8F, 6.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r18 = lowerright.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(120, 18).mirror().addBox(-5.5F, -5.5F, -2.0F, 11.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.8F, 9.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 113).addBox(-6.0F, -8.0F, -7.0F, 12.0F, 13.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(54, 133).addBox(2.0F, -13.0F, -4.75F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(126, 128).addBox(-6.0F, -5.0F, -9.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(58, 103).addBox(-4.0F, -2.0F, -9.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(32, 133).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.1667F, -14.1667F));

		PartDefinition cube_r19 = head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(44, 133).addBox(-3.0F, -2.5F, 0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -10.5F, -3.75F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r20 = head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(44, 133).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -10.5F, -3.75F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(44, 111).addBox(-4.5F, -0.5F, -4.5F, 9.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, -12.5F, 2.5F));

		PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(44, 111).mirror().addBox(-4.5F, -0.5F, -4.5F, 9.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.5F, -12.5F, 2.5F));

		PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(64, 58).addBox(-7.0F, -6.0F, -7.0F, 14.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.applyHeadRotation( entity, netHeadYaw, headPitch, ageInTicks);
		if ((entity.getAttackState() != 6 || entity.getAttackState() != 9) && !entity.isSleep() ) {
			this.animateWalk(OCAnims.WALK4, limbSwing, limbSwingAmount, 1.5F, 4.0F);
		}
		this.animate(entity.getAnimationState("death"), OCAnims.DEATH, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("idle"), OCAnims.IDLE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sleep"), OCAnims.SLEEP, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("awake"), OCAnims.AWAKE, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarmright"), OCAnims.ATTACK4, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarmleft"), OCAnims.ATTACK5, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarms"), OCAnims.SlamNew, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("chargestart"), OCAnims.charge_pre, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("chargeend"), OCAnims.charge_end, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("charge"), OCAnims.charge, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("slash"), OCAnims.hammerSlash, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("uppercut"), OCAnims.uppercut, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackcombo"), OCAnims.ATTACKCOMBO, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackpoison"), OCAnims.POISONSHOCKWAVE, ageInTicks, 1.0F);
	}


	private void applyHeadRotation(Overgrown_colossusEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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