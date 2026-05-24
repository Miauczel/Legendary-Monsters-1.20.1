// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.SpikebugAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.SpikebugEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class SpikebugModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public SpikebugModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");



	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 15).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 3.0F));

		PartDefinition tail = body2.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 3.5F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 15).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -5.0F));

		PartDefinition leftribcage = head.addOrReplaceChild("leftribcage", CubeListBuilder.create().texOffs(14, 24).addBox(0.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -2.5F));

		PartDefinition rightribcage = head.addOrReplaceChild("rightribcage", CubeListBuilder.create().texOffs(7, 24).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -2.5F));

		PartDefinition spike = body.addOrReplaceChild("spike", CubeListBuilder.create().texOffs(18, 30).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.5F, -1.5F));

		PartDefinition cube_r1 = spike.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 31).addBox(-4.0F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((SpikebugEntity) entity, netHeadYaw, headPitch, ageInTicks);


        this.animateWalk(SpikebugAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(((SpikebugEntity) entity).idleAnimationState, SpikebugAnimations.IDLE,ageInTicks, 1f);
		this.animate(((SpikebugEntity) entity).attackAnimationState, SpikebugAnimations.ATTACK,ageInTicks, 1f);

	}



	private void applyHeadRotation(SpikebugEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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