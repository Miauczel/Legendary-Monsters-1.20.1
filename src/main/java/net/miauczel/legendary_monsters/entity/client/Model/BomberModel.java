// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.BomberAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.BomberEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class BomberModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart leg2;
	private final ModelPart leg1;
	private final ModelPart head;

	public BomberModel(ModelPart root) {
		this.root = root.getChild("root");
		this.leg2 = this.root.getChild("leg2");
		this.leg1 = this.root.getChild("leg1");
		this.head = this.root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.375F, 10.0F, 0.375F, 0.0F, -1.5708F, 0.0F));

		PartDefinition leg2 = root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(25, 33).addBox(0.0F, 6.0F, -2.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(1, 25).addBox(-2.0F, -2.0F, -2.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.125F, 2.0F, 8.375F));

		PartDefinition leg1 = root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(25, 33).addBox(0.0F, 2.0F, -1.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(1, 25).addBox(-2.0F, -6.0F, -1.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.125F, 6.0F, -7.625F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 24).addBox(-3.375F, -4.0F, -3.375F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.375F, -2.0F, -6.375F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.75F, 0.0F, 0.75F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, -10.0F, 1.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).addBox(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.375F, -4.0F, -1.375F, 0.0F, 0.0F, 0.3927F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
applyHeadRotation((BomberEntity) entity,netHeadYaw,headPitch,ageInTicks);

        this.animateWalk(BomberAnimations.WALK2, limbSwing, limbSwingAmount, 1.65f, 2.5f);
        this.animate(((BomberEntity) entity).idleAnimationState, BomberAnimations.IDLE,ageInTicks, 1f);

	}



	private void applyHeadRotation(BomberEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
		this.head.xRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.yRot = pHeadPitch * ((float)Math.PI / 180F);
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