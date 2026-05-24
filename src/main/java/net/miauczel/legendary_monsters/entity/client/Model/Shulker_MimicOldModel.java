// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.ShulkerMimicNewAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Old.OldShulkerMimic;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class Shulker_MimicOldModel<T extends OldShulkerMimic> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;
private final ModelPart headmini;
	public Shulker_MimicOldModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");
		this.headmini = root.getChild("root").getChild("body").getChild("head").getChild("headmini");;

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(80, 92).addBox(-5.0F, 0.0F, -4.5F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Rotors = body.addOrReplaceChild("Rotors", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, 0.0F, -20.0F, 40.0F, 0.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.5F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 1.0F));

		PartDefinition lowerbox = head.addOrReplaceChild("lowerbox", CubeListBuilder.create().texOffs(0, 40).addBox(-10.0F, 2.8F, -20.0F, 20.0F, 7.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 40).addBox(-10.0F, -3.2F, -20.0F, 20.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.8F, 9.5F));

		PartDefinition cube_r1 = lowerbox.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(76, 104).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.1213F, 6.8F, -10.0007F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = lowerbox.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 104).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.1213F, 6.8F, -10.0007F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r3 = lowerbox.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(76, 104).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8F, 2.122F, 3.1416F, 0.7854F, 3.1416F));

		PartDefinition cube_r4 = lowerbox.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(76, 104).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.8F, 2.122F, 3.1416F, -0.7854F, -3.1416F));

		PartDefinition upperbox = head.addOrReplaceChild("upperbox", CubeListBuilder.create().texOffs(0, 67).addBox(-10.0F, -9.8F, -20.0F, 20.0F, 7.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 66).addBox(-10.0F, -2.8F, -20.0F, 20.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.2F, 9.5F));

		PartDefinition cube_r5 = upperbox.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 94).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.8F, 2.122F, -3.1416F, 0.7854F, -3.1416F));

		PartDefinition cube_r6 = upperbox.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(64, 94).addBox(8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.1213F, -6.8F, -10.0007F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r7 = upperbox.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(64, 94).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.1213F, -6.8F, -10.0007F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r8 = upperbox.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(64, 94).mirror().addBox(-8.5706F, -5.0F, -11.5706F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.8F, 2.122F, -3.1416F, -0.7854F, 3.1416F));

		PartDefinition headmini = head.addOrReplaceChild("headmini", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 94).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -6.1F, -1.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);


        this.animateWalk(ShulkerMimicNewAnimations.WALK, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(( entity).idleAnimationState,ShulkerMimicNewAnimations.IDLE,ageInTicks, 1f);
		this.animate(( entity).attackAnimationState, ShulkerMimicNewAnimations.ATTACK,ageInTicks, 1f);
		this.animate(( entity).DeathAnimationState, ShulkerMimicNewAnimations.DEATH,ageInTicks, 1f);

	}



	private void applyHeadRotation(OldShulkerMimic	 pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
		this.root.xScale = 1.5F;
		this.root.yScale = 1.5F;
		this.root.zScale = 1.5F;
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