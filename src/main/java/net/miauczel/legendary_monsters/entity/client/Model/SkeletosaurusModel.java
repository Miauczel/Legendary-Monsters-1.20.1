// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.miauczel.legendary_monsters.entity.animations.SkeletosaurusAnimationsNew;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SkeletosaurusEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class SkeletosaurusModel<T extends SkeletosaurusEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head2;

	public SkeletosaurusModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head2 = root.getChild("root").getChild("mainbody").getChild("neck").getChild("head2");


	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mainbody = root.addOrReplaceChild("mainbody", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -31.8333F, -49.5833F, 28.0F, 30.0F, 51.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -25.1667F, 11.5833F));

		PartDefinition tailbody = mainbody.addOrReplaceChild("tailbody", CubeListBuilder.create().texOffs(102, 81).addBox(-10.0F, -11.125F, 0.125F, 20.0F, 21.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.7083F, 0.2917F));

		PartDefinition tailbody2 = tailbody.addOrReplaceChild("tailbody2", CubeListBuilder.create().texOffs(102, 135).addBox(-6.0F, -6.25F, 0.375F, 12.0F, 14.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.875F, 31.75F));

		PartDefinition tailspines2 = tailbody2.addOrReplaceChild("tailspines2", CubeListBuilder.create().texOffs(208, 74).addBox(0.0F, -14.0F, -26.0F, 0.0F, 14.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.25F, 26.375F));

		PartDefinition tailspines = tailbody.addOrReplaceChild("tailspines", CubeListBuilder.create().texOffs(168, 180).addBox(0.0F, -16.0F, -6.0F, 0.0F, 16.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.125F, 6.125F));

		PartDefinition neck = mainbody.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -20.3333F, -48.5833F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r1 = neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 148).addBox(-8.5F, -9.5F, -12.0F, 18.0F, 19.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -6.0F, -10.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition head2 = neck.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(188, 163).addBox(-12.0F, -15.0F, -18.0F, 21.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -9.5F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition mainbody_r1 = head2.addOrReplaceChild("mainbody_r1", CubeListBuilder.create().texOffs(158, 0).addBox(-10.5F, -10.5F, -12.0F, 21.0F, 21.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5F, -10.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition lowerjaw = head2.addOrReplaceChild("lowerjaw", CubeListBuilder.create().texOffs(158, 41).addBox(-10.0F, 0.0F, -23.0F, 19.0F, 10.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, -18.0F));

		PartDefinition upperjaw = head2.addOrReplaceChild("upperjaw", CubeListBuilder.create().texOffs(84, 180).addBox(-10.0F, -9.0F, -23.0F, 19.0F, 9.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(188, 135).addBox(-10.0F, 0.0F, -23.0F, 19.0F, 5.0F, 23.0F, new CubeDeformation(0.005F)), PartPose.offset(-1.0F, 0.0F, -18.0F));

		PartDefinition arm = mainbody.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(-14.5075F, -5.1786F, -40.6785F));

		PartDefinition arm2 = mainbody.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offset(14.4925F, -5.1786F, -40.6785F));

		PartDefinition mainspines = mainbody.addOrReplaceChild("mainspines", CubeListBuilder.create().texOffs(0, 81).addBox(0.0F, -16.0F, -16.0F, 0.0F, 16.0F, 51.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -31.8333F, -33.5833F));

		PartDefinition arm3 = mainbody.addOrReplaceChild("arm3", CubeListBuilder.create(), PartPose.offset(13.0F, -3.9676F, -43.6781F));

		PartDefinition cube_r2 = arm3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(158, 74).addBox(-0.99F, 4.0F, 1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 148).addBox(1.01F, -4.0F, 1.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.01F, 2.823F, -3.7472F, -0.2182F, 0.0F, 0.0F));

		PartDefinition arm4 = mainbody.addOrReplaceChild("arm4", CubeListBuilder.create(), PartPose.offset(-13.0F, -3.8333F, -43.5833F));

		PartDefinition cube_r3 = arm4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 148).mirror().addBox(-1.01F, -4.0F, 1.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.99F, 2.823F, -3.7472F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r4 = arm4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(158, 74).mirror().addBox(-1.01F, 8.2955F, -5.0303F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.99F, -0.0655F, 3.0699F, -0.2182F, 0.0F, 0.0F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(12.5F, -44.3996F, -3.2638F));

		PartDefinition leg3_r1 = leftleg.addOrReplaceChild("leg3_r1", CubeListBuilder.create().texOffs(0, 191).addBox(-7.5F, -16.0F, -11.5F, 15.0F, 24.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.125F, 15.4403F, 2.187F, -0.3491F, 0.0F, 0.0F));

		PartDefinition lowerleg3 = leftleg.addOrReplaceChild("lowerleg3", CubeListBuilder.create(), PartPose.offset(3.25F, 20.2495F, 4.6367F));

		PartDefinition middlelowerleg4_r1 = lowerleg3.addOrReplaceChild("middlelowerleg4_r1", CubeListBuilder.create().texOffs(124, 212).addBox(-9.0F, -26.0F, 0.0F, 9.0F, 24.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 22.0F, -5.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition paw3 = lowerleg3.addOrReplaceChild("paw3", CubeListBuilder.create().texOffs(66, 212).addBox(-4.125F, -1.4001F, -13.2293F, 13.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.375F, 20.4006F, 1.7973F));

		PartDefinition claw = paw3.addOrReplaceChild("claw", CubeListBuilder.create().texOffs(84, 160).addBox(5.875F, -1.4001F, -22.2293F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 160).addBox(0.875F, -1.4001F, -22.2293F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 160).addBox(-4.125F, -1.4001F, -22.2293F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 168).addBox(5.875F, 1.5999F, -22.2293F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(84, 168).addBox(0.875F, 1.5999F, -22.2293F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(84, 168).addBox(-4.125F, 1.5999F, -22.2293F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition leftleg2 = root.addOrReplaceChild("leftleg2", CubeListBuilder.create(), PartPose.offset(-19.5F, -44.3996F, -3.2638F));

		PartDefinition leg4_r1 = leftleg2.addOrReplaceChild("leg4_r1", CubeListBuilder.create().texOffs(0, 191).addBox(-7.5F, -16.0F, -11.5F, 15.0F, 24.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.125F, 15.4403F, 2.187F, -0.3491F, 0.0F, 0.0F));

		PartDefinition lowerleg5 = leftleg2.addOrReplaceChild("lowerleg5", CubeListBuilder.create(), PartPose.offset(3.25F, 20.2495F, 4.6367F));

		PartDefinition middlelowerleg5_r1 = lowerleg5.addOrReplaceChild("middlelowerleg5_r1", CubeListBuilder.create().texOffs(124, 212).addBox(0.0F, -26.0F, 0.0F, 9.0F, 24.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 22.0F, -5.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition paw4 = lowerleg5.addOrReplaceChild("paw4", CubeListBuilder.create().texOffs(66, 212).addBox(-4.125F, -1.4001F, -13.2293F, 13.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.375F, 20.4006F, 1.7973F));

		PartDefinition claw3 = paw4.addOrReplaceChild("claw3", CubeListBuilder.create().texOffs(84, 160).addBox(5.875F, -1.4001F, -22.2293F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 160).addBox(0.875F, -1.4001F, -22.2293F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 160).addBox(-4.125F, -1.4001F, -22.2293F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 168).addBox(5.875F, 1.5999F, -22.2293F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(84, 168).addBox(0.875F, 1.5999F, -22.2293F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(84, 168).addBox(-4.125F, 1.5999F, -22.2293F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-18.5F, -36.3996F, -5.2638F));

		PartDefinition lowerleg2 = right_leg.addOrReplaceChild("lowerleg2", CubeListBuilder.create(), PartPose.offset(0.875F, 2.6501F, 3.6841F));

		PartDefinition paw2 = lowerleg2.addOrReplaceChild("paw2", CubeListBuilder.create(), PartPose.offset(0.0F, 30.0F, 8.75F));

		PartDefinition claw2 = paw2.addOrReplaceChild("claw2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);


		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);



		this.animate((entity).getAnimationState("death"), SkeletosaurusAnimationsNew.death, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("idle"), SkeletosaurusAnimationsNew.idle, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("sleep"), SkeletosaurusAnimationsNew.sleep, ageInTicks, 1.0F);
		this.animate((entity).getAnimationState("awake"), SkeletosaurusAnimationsNew.awake, ageInTicks, 1.0F);
		this.animate((entity).getAnimationState("biteattack"), SkeletosaurusAnimationsNew.BiteAttackNew, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("roar"), SkeletosaurusAnimationsNew.roar, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("shockwaves"), SkeletosaurusAnimationsNew.shockwaves, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("tail"), SkeletosaurusAnimationsNew.tailhit, ageInTicks, 1.0F);
	this.animateWalk(SkeletosaurusAnimationsNew.walk4, limbSwing, limbSwingAmount, 1.5f, 2.5f);
		this.animate(( entity).getAnimationState("tailm"), SkeletosaurusAnimationsNew.tailhitM, ageInTicks, 1.0F);

	}



	private void applyHeadRotation(SkeletosaurusEntity	 pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, 25.0F, -25.0F);
		this.head2.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head2.xRot = pHeadPitch * ((float)Math.PI / 180F);
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