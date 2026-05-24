// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.ChoruslingAnimations;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.ChoruslingEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class ChoruslingModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public ChoruslingModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(-1.0F, -16.0F, -3.5F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -14.0F, -3.5F, 12.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 3.5F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(40, 0).addBox(-8.0F, 0.001F, 0.0F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -6.001F, 4.5F, 1.5708F, 0.5236F, 1.5708F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 22).addBox(-10.0F, 0.001F, -1.0F, 10.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -11.0F, 4.5F, 1.5708F, 0.5236F, 1.5708F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 12).addBox(-4.0F, -8.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -0.5F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(24, 36).addBox(-3.25F, -1.5F, -3.0F, 6.0F, 31.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(60, 28).addBox(-8.25F, -1.5F, 0.0F, 5.0F, 31.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.75F, -12.5F, -0.5F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 36).addBox(-2.75F, -1.5F, -3.0F, 6.0F, 31.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(60, 59).addBox(3.25F, -1.5F, 0.0F, 5.0F, 31.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(8.75F, -12.5F, -0.5F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(48, 28).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 12.5F, 4.0F));

		PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(48, 58).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 12.5F, 4.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((ChoruslingEntity) entity, netHeadYaw, headPitch, ageInTicks);


		this.animateWalk(ChoruslingAnimations.WALK2, limbSwing, limbSwingAmount, 1.5f, 2.5f);
		this.animate(((ChoruslingEntity) entity).idleAnimationState, ChoruslingAnimations.IDLE,ageInTicks, 1f);
		this.animate(((ChoruslingEntity) entity).attackAnimationState, ChoruslingAnimations.ATTACK,ageInTicks, 1f);
		this.animate(((ChoruslingEntity) entity).DeathAnimationState, ChoruslingAnimations.DEATH,ageInTicks, 1f);
	}



	private void applyHeadRotation(ChoruslingEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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