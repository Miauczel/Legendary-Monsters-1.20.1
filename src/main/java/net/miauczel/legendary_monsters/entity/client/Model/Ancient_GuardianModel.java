// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.Ancient_GuardianEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class Ancient_GuardianModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public Ancient_GuardianModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("bone").getChild("body").getChild("bone3");



	}

		public static LayerDefinition createBodyLayer() {
			MeshDefinition meshdefinition = new MeshDefinition();
			PartDefinition partdefinition = meshdefinition.getRoot();

			PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -13F, 0.0F));

			PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(90, 0).addBox(-4.5F, -0.5F, -4.5F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, 19.0F, 0.5F));

			PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(92, 20).addBox(-4.5F, -0.5F, -4.5F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, 19.0F, 0.5F));

			PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 0.5F));

			PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0556F, -18.6667F, -10.7778F, 26.0F, 18.0F, 19.0F, new CubeDeformation(0.0F))
					.texOffs(0, 57).addBox(-13.0556F, -30.6667F, -6.7778F, 26.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
					.texOffs(54, 37).addBox(-9.0556F, -30.6667F, -10.7778F, 0.0F, 12.0F, 19.0F, new CubeDeformation(0.0F))
					.texOffs(54, 37).mirror().addBox(8.9444F, -30.6667F, -10.7778F, 0.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false)
					.texOffs(52, 68).addBox(-13.0556F, -30.6667F, 4.2222F, 26.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0556F, -5.8333F, 1.2778F));

			PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 80).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0556F, -9.6667F, 8.2222F, -0.7418F, 0.0F, 0.0F));

			PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(76, 80).addBox(-11.0F, 12.5F, -4.5F, 9.0F, 13.0F, 9.0F, new CubeDeformation(0.0F))
					.texOffs(0, 69).addBox(-11.0F, -6.5F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F))
					.texOffs(48, 100).mirror().addBox(-8.0F, -15.5F, -3.5F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
					.texOffs(20, 100).addBox(-10.0F, 9.5F, -3.5F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
					.texOffs(96, 102).addBox(-2.0F, -3.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0556F, -13.1667F, -1.2778F));

			PartDefinition l = rightarm.addOrReplaceChild("l", CubeListBuilder.create(), PartPose.offset(-1.75F, 22.25F, 0.0F));

			PartDefinition cube_r2 = l.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
					.texOffs(36, 69).addBox(-2.5F, -5.0F, -5.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.75F, 5.25F, 0.0F, 0.0F, -1.5708F, 0.0F));

			PartDefinition r = rightarm.addOrReplaceChild("r", CubeListBuilder.create(), PartPose.offset(-11.25F, 22.25F, 0.0F));

			PartDefinition cube_r3 = r.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
					.texOffs(36, 69).addBox(-2.5F, -5.0F, -5.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.75F, 5.25F, 0.0F, 0.0F, 1.5708F, 0.0F));

			PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 69).addBox(1.0F, -6.5F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F))
					.texOffs(48, 100).addBox(4.0F, -15.5F, -3.5F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
					.texOffs(68, 108).mirror().addBox(1.0F, 11.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
					.texOffs(68, 108).addBox(8.0F, 11.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
					.texOffs(92, 57).addBox(1.0F, 9.5F, -3.5F, 9.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
					.texOffs(104, 66).addBox(-1.0F, -3.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(13.9444F, -13.1667F, -1.2778F));

			PartDefinition anchor = leftarm.addOrReplaceChild("anchor", CubeListBuilder.create().texOffs(0, 94).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 20.0F, 5.0F, new CubeDeformation(0.0F))
					.texOffs(68, 102).addBox(-5.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
					.texOffs(112, 80).addBox(-2.0F, 12.5F, 2.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
					.texOffs(20, 110).addBox(-2.0F, 8.5F, 5.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
					.texOffs(112, 87).addBox(-2.0F, 8.5F, 9.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 15.0F, 0.0F));

			PartDefinition anchor_r1 = anchor.addOrReplaceChild("anchor_r1", CubeListBuilder.create().texOffs(112, 80).addBox(-3.0F, 3.5F, -7.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -9.5F, -3.1416F, 0.0F, 3.1416F));

			PartDefinition anchor_r2 = anchor.addOrReplaceChild("anchor_r2", CubeListBuilder.create().texOffs(20, 110).addBox(-3.0F, -0.5F, -9.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
					.texOffs(112, 87).addBox(-3.0F, -0.5F, -5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -14.5F, -3.1416F, 0.0F, 3.1416F));

			PartDefinition bone3 = body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(92, 40).addBox(-6.0F, -7.0F, -3.5F, 12.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0556F, -9.6667F, -10.2778F));

			PartDefinition ripcage = bone3.addOrReplaceChild("ripcage", CubeListBuilder.create(), PartPose.offset(3.0F, -5.0F, -7.5F));

			PartDefinition ripcageright = ripcage.addOrReplaceChild("ripcageright", CubeListBuilder.create().texOffs(86, 108).addBox(0.0F, -5.0F, 0.0F, 4.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 4.0F, 4.0F, 0.0F, 0.2182F, 0.0F));

			PartDefinition ripcageleft = ripcage.addOrReplaceChild("ripcageleft", CubeListBuilder.create(), PartPose.offset(1.0F, 4.0F, 4.0F));

			PartDefinition ripcageleft_r1 = ripcageleft.addOrReplaceChild("ripcageleft_r1", CubeListBuilder.create().texOffs(36, 110).addBox(-2.0F, -5.5F, 0.0F, 4.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9526F, 0.5F, -0.4329F, 0.0F, -0.2182F, 0.0F));

			PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 37).addBox(-7.0F, -6.5F, -6.5F, 14.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

			return LayerDefinition.create(meshdefinition, 128, 128);
		}

		@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((Ancient_GuardianEntity) entity, netHeadYaw, headPitch, ageInTicks);
		if ((((Ancient_GuardianEntity) entity).getAttackState() != 6 && !(((Ancient_GuardianEntity) entity).isSleep()))) {
			this.animateWalk(AncientGuardianAnimations.walk4, limbSwing, limbSwingAmount, 1.5F, 4.0F);
		}
		if (!(((Ancient_GuardianEntity) entity).isSleep())) {

			this.applyHeadRotation((Ancient_GuardianEntity) entity, netHeadYaw, headPitch, ageInTicks);
		}
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("death"), AncientGuardianAnimations.death, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("idle"), AncientGuardianAnimations.idle, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("sleep"), AncientGuardianAnimations.sleep, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("awake"), AncientGuardianAnimations.awaken, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("attackarmright"), AncientGuardianAnimations.attack4, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("attackarmleft"), AncientGuardianAnimations.attack3, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("attackcombo"), AncientGuardianAnimations.attackcombo1, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("roar"), AncientGuardianAnimations.jump, ageInTicks, 1.0F);

			this.animate(((Ancient_GuardianEntity) entity).getAnimationState("grab"), AncientGuardianAnimations.grab, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("runpre"), AncientGuardianAnimations.jump2, ageInTicks, 1.0F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("run"), AncientGuardianAnimations.jump3, ageInTicks, 2F);
		this.animate(((Ancient_GuardianEntity) entity).getAnimationState("postrun"), AncientGuardianAnimations.jump4, ageInTicks, 1.0F);
		//this.animate(((Ancient_GuardianEntity) entity).DeathAnimationState, Ancient_GuardianAnimations.DEATH,ageInTicks, 1f);
		//this.animate(((Ancient_GuardianEntity) entity).attackAnimationState, Ancient_GuardianAnimations.ATTACK,ageInTicks, 1f);
		//	this.animate(((Ancient_GuardianEntity) entity).SwingAttackAnimationState, Ancient_GuardianAnimations.ATTACK3,ageInTicks, 1f); // old 1f// old 1f


		this.root.xScale = 1.25F;
		this.root.yScale = 1.25F;
		this.root.zScale = 1.25F;

	}





	private void applyHeadRotation(Ancient_GuardianEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
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