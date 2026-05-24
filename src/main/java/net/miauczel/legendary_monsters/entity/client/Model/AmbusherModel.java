// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.AmbusherAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.AmbusherEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class AmbusherModel<T extends AmbusherEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public AmbusherModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -11.5F, -18.75F, 12.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 10.75F));

		PartDefinition tailpart1 = body.addOrReplaceChild("tailpart1", CubeListBuilder.create().texOffs(0, 31).addBox(-4.0F, -4.5F, 0.5F, 8.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -0.25F));

		PartDefinition tailpart2 = tailpart1.addOrReplaceChild("tailpart2", CubeListBuilder.create().texOffs(38, 31).addBox(-3.0F, -3.5F, 0.5F, 6.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition spike3 = tailpart2.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(68, 56).addBox(-1.5F, -3.5F, -4.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -7.0F, 7.5F));

		PartDefinition cube_r1 = spike3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(62, 14).addBox(-2.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 1.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition spike2 = tailpart1.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(16, 65).addBox(-3.5F, -3.5F, -5.0F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -8.0F, 8.5F));

		PartDefinition cube_r2 = spike2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 14).addBox(-2.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 51).addBox(-5.0F, -5.0F, -4.0F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, -18.75F));

		PartDefinition leftribcage = head.addOrReplaceChild("leftribcage", CubeListBuilder.create().texOffs(68, 63).addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -4.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition right_ribcage = head.addOrReplaceChild("right_ribcage", CubeListBuilder.create().texOffs(28, 71).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -4.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition knife = body.addOrReplaceChild("knife", CubeListBuilder.create().texOffs(62, 21).addBox(-1.0F, -1.0F, -7.5F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, 4.75F));

		PartDefinition blade = knife.addOrReplaceChild("blade", CubeListBuilder.create(), PartPose.offset(0.0F, 0.3536F, -14.6464F));

		PartDefinition cube_r3 = blade.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 65).addBox(0.0F, -2.5F, -4.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3536F, 3.1464F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r4 = blade.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 65).addBox(0.0F, -2.5F, -4.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3536F, 3.1464F, 0.0F, 0.0F, -2.3562F));

		PartDefinition spikes1 = body.addOrReplaceChild("spikes1", CubeListBuilder.create().texOffs(62, 0).addBox(3.0F, -0.5F, -15.75F, 12.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(62, 7).addBox(3.0F, -0.5F, -3.75F, 12.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -18.0F, 0.0F));

		PartDefinition cube_r5 = spikes1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(38, 49).mirror().addBox(-2.5F, -3.5F, 0.0F, 19.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 3.0F, -16.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r6 = spikes1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(38, 49).addBox(-16.5F, -3.5F, 0.0F, 19.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 3.0F, -16.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition leg4 = root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(48, 56).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -10.0F, 7.5F));

		PartDefinition leg3 = root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(48, 56).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -10.0F, -4.5F));

		PartDefinition leg2 = root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(28, 56).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -10.0F, 7.5F));

		PartDefinition leg1 = root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(28, 56).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -10.0F, -4.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((AmbusherEntity) entity, netHeadYaw, headPitch, ageInTicks);


		this.animate((entity).getAnimationState("idle"), AmbusherAnimations.IDLE, ageInTicks, 1.0F);
		this.animate((entity).getAnimationState("toungue"), AmbusherAnimations.ATTACK, ageInTicks, 1.0F);
		this.animate((entity).getAnimationState("death"), AmbusherAnimations.DEATH, ageInTicks, 1.0F);
        this.animateWalk(AmbusherAnimations.WALK2, limbSwing, limbSwingAmount, 1.5f, 2.5f);

		this.root.xScale = 1.25F;
		this.root.yScale = 1.25F;
		this.root.zScale = 1.25F;
	}



	private void applyHeadRotation(AmbusherEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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