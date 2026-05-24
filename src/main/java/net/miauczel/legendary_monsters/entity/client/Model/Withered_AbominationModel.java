// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.WitheredAbominationAnimationsNew;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Withered_AbominationEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class Withered_AbominationModel<T extends Withered_AbominationEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public Withered_AbominationModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("bone").getChild("body")
				.getChild("neck").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 24.0F, 16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(80, 78).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -10.0F, 5.0F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(80, 78).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -10.0F, 5.0F));

		PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-2.0F, -8.8356F, 6.1503F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(106, 98).addBox(2.0F, 6.0F, 5.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(106, 98).addBox(2.0F, 6.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -9.156F, -11.153F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 57).addBox(-6.0F, -7.0F, 0.5F, 12.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.1644F, -1.6503F, -0.6109F, 0.0F, 0.0F));

		PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -4.7567F, 5.2431F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(94, 29).addBox(6.0F, 5.3079F, 12.8118F, 0.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -10.6667F, -21.105F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -12.0F, -5.5F, 20.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.4077F, 1.1065F, -1.0908F, 0.0F, 0.0F));

		PartDefinition leftarm2 = body.addOrReplaceChild("leftarm2", CubeListBuilder.create(), PartPose.offset(-11.5017F, -10.4068F, 9.1065F));

		PartDefinition cube_r5 = leftarm2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 55).addBox(-5.5F, -6.0F, -5.5F, 11.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9983F, 17.9991F, 5.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r6 = leftarm2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(94, 50).addBox(-13.5F, -15.0F, -2.5F, 9.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(72, 0).addBox(-4.5F, -9.0F, -4.5F, 9.0F, 20.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9983F, 4.9991F, 2.0F, 0.2265F, 0.4379F, 0.4543F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(11.5017F, -10.4067F, 8.7978F));

		PartDefinition cube_r7 = rightarm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(50, 32).addBox(-5.5F, -6.0F, -5.5F, 11.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9983F, 17.9991F, 5.3088F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r8 = rightarm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(94, 50).mirror().addBox(4.5F, -8.0F, -4.5F, 9.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3355F, -1.4638F, 2.6501F, 0.2265F, -0.4379F, -0.4543F));

		PartDefinition cube_r9 = rightarm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(44, 78).addBox(-4.5F, -9.0F, -4.5F, 9.0F, 20.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9983F, 4.9991F, 2.3088F, 0.2265F, -0.4379F, -0.4543F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -9.2742F, 10.5697F));

		PartDefinition cube_r10 = neck.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(94, 98).addBox(6.0F, -4.2F, -3.6F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.999F, -6.0012F, 2.3029F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r11 = neck.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 79).addBox(-6.0F, -7.9392F, -4.3054F, 12.0F, 8.0F, 10.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, -0.1851F, -1.2809F, -1.3963F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -1.3808F, 6.3489F));

		PartDefinition cube_r12 = head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(22, 97).addBox(-18.0F, 45.5F, 58.5F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(80, 98).addBox(-19.0F, 45.5F, 53.5F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 97).addBox(-4.0F, 45.5F, 58.5F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(94, 68).addBox(-5.0F, 45.5F, 53.5F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -2.5383F, -66.3442F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r13 = head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, -14.0F, -3.0F, 12.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9324F, -3.1659F, -1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((Withered_AbominationEntity) entity, netHeadYaw, headPitch, ageInTicks);

		this.applyHeadRotation((Withered_AbominationEntity) entity, netHeadYaw, headPitch, ageInTicks);
		if (entity.getAttackState() != 6 && !entity.isSleep()) {
			this.animateWalk(WitheredAbominationAnimationsNew.walk, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}
		this.animate(entity.getAnimationState("death"), WitheredAbominationAnimationsNew.death, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("idle"), WitheredAbominationAnimationsNew.idle, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("sleep"), WitheredAbominationAnimationsNew.sleep, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("awake"), WitheredAbominationAnimationsNew.awake, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarm1"), WitheredAbominationAnimationsNew.leftArmSweep, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarm2"), WitheredAbominationAnimationsNew.rightArmSweep, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackarms"), WitheredAbominationAnimationsNew.slamattack, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackstun"), WitheredAbominationAnimationsNew.hornAttack, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("attackcombo"), WitheredAbominationAnimationsNew.attackcombo, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("runpre"), WitheredAbominationAnimationsNew.runPre, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("run"), WitheredAbominationAnimationsNew.run, ageInTicks, 2F);
		this.animate(entity.getAnimationState("postrun"), WitheredAbominationAnimationsNew.runAttack, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("sweepcomboleft"), WitheredAbominationAnimationsNew.sweepCombo, ageInTicks, 1F);
		this.animate(entity.getAnimationState("sweepcomboright"), WitheredAbominationAnimationsNew.sweepComboRight, ageInTicks, 1.0F);
		this.root.xScale = 1.5F;
		this.root.yScale = 1.5F;
		this.root.zScale = 1.5F;
	}



	private void applyHeadRotation(Withered_AbominationEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25F, 25.0F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = -pHeadPitch * ((float)Math.PI / 180F);
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