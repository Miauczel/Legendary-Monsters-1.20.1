// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.SkeleraptorAnimations;
import net.miauczel.legendary_monsters.entity.animations.SkeletosaurusAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.SkeloraptorEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class SkeloraptorModel<T extends SkeloraptorEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head2;

	public SkeloraptorModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head2 = root.getChild("root").getChild("mainbody").getChild("neck").getChild("head2");


	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition mainbody = root.addOrReplaceChild("mainbody", CubeListBuilder.create().texOffs(0, 0).addBox(-9.75F, -18.9F, -23.55F, 18.0F, 19.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.75F, -1.1F, 6.55F));

		PartDefinition tailbody = mainbody.addOrReplaceChild("tailbody", CubeListBuilder.create().texOffs(0, 49).addBox(-5.75F, -9.675F, 2.275F, 10.0F, 13.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.225F, 4.175F));

		PartDefinition tailbody2 = tailbody.addOrReplaceChild("tailbody2", CubeListBuilder.create().texOffs(58, 80).addBox(-4.75F, -6.95F, 1.225F, 8.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.725F, 19.05F));

		PartDefinition neck = mainbody.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.5F, -15.6F, -19.55F));

		PartDefinition mainbody_r1 = neck.addOrReplaceChild("mainbody_r1", CubeListBuilder.create().texOffs(58, 49).addBox(-5.5F, -9.5F, -5.0F, 11.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, -3.8F, -5.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition head2 = neck.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(104, 74).addBox(-6.85F, -8.0F, -11.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 81).addBox(-6.85F, -6.0F, -11.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4F, -8.3F, -5.0F));

		PartDefinition lowerjaw = head2.addOrReplaceChild("lowerjaw", CubeListBuilder.create().texOffs(104, 44).addBox(-5.0F, 0.0F, -12.0F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.85F, 1.0F, -11.0F));

		PartDefinition upperjaw = head2.addOrReplaceChild("upperjaw", CubeListBuilder.create().texOffs(96, 25).addBox(-5.0F, -5.0F, -12.0F, 10.0F, 7.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offset(-0.85F, 1.0F, -11.0F));

		PartDefinition arm = mainbody.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(-8.7045F, -0.1072F, -20.4071F));

		PartDefinition arm2 = mainbody.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offset(8.6955F, -0.1072F, -20.4071F));

		PartDefinition mainspines = mainbody.addOrReplaceChild("mainspines", CubeListBuilder.create(), PartPose.offset(0.0F, -16.1F, -16.15F));

		PartDefinition arm3 = mainbody.addOrReplaceChild("arm3", CubeListBuilder.create(), PartPose.offset(8.61F, -2.9655F, -18.4801F));

		PartDefinition cube_r1 = arm3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 105).addBox(-0.99F, 4.0F, 1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 105).addBox(1.01F, -4.0F, 1.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.87F, 2.6659F, -3.3337F, -0.2182F, 0.0F, 0.0F));

		PartDefinition arm4 = mainbody.addOrReplaceChild("arm4", CubeListBuilder.create(), PartPose.offset(-9.39F, -1.9655F, -17.4801F));

		PartDefinition cube_r2 = arm4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 105).mirror().addBox(-3.01F, 4.0F, 1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(24, 105).mirror().addBox(-3.01F, -4.0F, 1.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.15F, 1.6659F, -4.3337F, -0.2182F, 0.0F, 0.0F));

		PartDefinition leftleg2 = root.addOrReplaceChild("leftleg2", CubeListBuilder.create(), PartPose.offset(-10.95F, -9.6398F, 1.6417F));

		PartDefinition leg4_r1 = leftleg2.addOrReplaceChild("leg4_r1", CubeListBuilder.create().texOffs(96, 0).addBox(-13.6F, -7.0F, -5.5F, 9.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.975F, 7.0642F, -0.0878F, -0.3491F, 0.0F, 0.0F));

		PartDefinition lowerleg5 = leftleg2.addOrReplaceChild("lowerleg5", CubeListBuilder.create(), PartPose.offset(1.95F, 12.1497F, 2.782F));

		PartDefinition middlelowerleg5_r1 = lowerleg5.addOrReplaceChild("middlelowerleg5_r1", CubeListBuilder.create().texOffs(0, 105).addBox(-17.025F, -16.3901F, -10.5342F, 5.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.425F, 15.8801F, 7.2342F, -0.1745F, 0.0F, 0.0F));

		PartDefinition paw4 = lowerleg5.addOrReplaceChild("paw4", CubeListBuilder.create().texOffs(104, 61).addBox(-2.675F, -0.7503F, -7.9376F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.425F, 12.2404F, 1.0784F));

		PartDefinition claw3 = paw4.addOrReplaceChild("claw3", CubeListBuilder.create().texOffs(48, 81).addBox(3.325F, -0.7503F, -13.3376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 81).addBox(0.325F, -0.7503F, -13.3376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 81).addBox(-2.675F, -0.7503F, -13.3376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 86).addBox(3.325F, 1.2497F, -13.3376F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 86).addBox(0.325F, 1.2497F, -13.3376F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 88).addBox(-2.675F, 1.2497F, -13.3376F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.4F));

		PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(7.25F, -9.6398F, 1.6417F));

		PartDefinition leg3_r1 = leftleg.addOrReplaceChild("leg3_r1", CubeListBuilder.create().texOffs(96, 0).addBox(4.6F, -7.0F, -5.5F, 9.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.225F, 7.0642F, -0.0878F, -0.3491F, 0.0F, 0.0F));

		PartDefinition lowerleg3 = leftleg.addOrReplaceChild("lowerleg3", CubeListBuilder.create(), PartPose.offset(1.95F, 12.1497F, 2.782F));

		PartDefinition middlelowerleg4_r1 = lowerleg3.addOrReplaceChild("middlelowerleg4_r1", CubeListBuilder.create().texOffs(0, 105).addBox(-5.0F, -14.0F, 0.0F, 5.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 13.4901F, -3.3F, -0.1745F, 0.0F, 0.0F));

		PartDefinition paw3 = lowerleg3.addOrReplaceChild("paw3", CubeListBuilder.create().texOffs(104, 61).addBox(-2.675F, -0.7503F, -7.9376F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.425F, 12.2404F, 1.0784F));

		PartDefinition claw = paw3.addOrReplaceChild("claw", CubeListBuilder.create().texOffs(48, 81).addBox(3.325F, -0.7503F, -13.3376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 81).addBox(0.325F, -0.7503F, -13.3376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 81).addBox(-2.675F, -0.7503F, -13.3376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 86).addBox(3.325F, 1.2497F, -13.3376F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 86).addBox(0.325F, 1.2497F, -13.3376F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 86).addBox(-2.675F, 1.2497F, -13.3376F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.4F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((SkeloraptorEntity) entity, netHeadYaw, headPitch, ageInTicks);


        this.animateWalk(SkeleraptorAnimations.walk4New, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(((SkeloraptorEntity) entity).idleAnimationState, SkeleraptorAnimations.IDLE,ageInTicks, 1f);
		this.animate(((SkeloraptorEntity) entity).attackAnimationState, SkeletosaurusAnimations.ATTACK2,ageInTicks, 1f);
		this.animate(( entity).getAnimationState("sitstart"), SkeleraptorAnimations.sitStart, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("sitend"), SkeleraptorAnimations.sitEnd, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("idle"), SkeleraptorAnimations.idlenew, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("sitidle"), SkeleraptorAnimations.sit, ageInTicks, 1.0F);

		this.animate(( entity).getAnimationState("roar"), SkeleraptorAnimations.roar, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("shockwaves"), SkeleraptorAnimations.shockwaves, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("stomp"), SkeleraptorAnimations.shockwaves, ageInTicks, 1.0F);
		this.animate(( entity).getAnimationState("tail"), SkeleraptorAnimations.tailhit, ageInTicks, 1.0F);

	}



	private void applyHeadRotation(SkeloraptorEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
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