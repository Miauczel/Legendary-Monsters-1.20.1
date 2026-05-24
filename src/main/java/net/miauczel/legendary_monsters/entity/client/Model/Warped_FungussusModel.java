// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.Warped_FungussusAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Warped_FungussusEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;


public class Warped_FungussusModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart lower;
	private final ModelPart middle;
	private final ModelPart top;
	private final ModelPart leg;
	private final ModelPart leg2;

	public Warped_FungussusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.lower = this.body.getChild("lower");
		this.middle = this.lower.getChild("middle");
		this.top = this.middle.getChild("top");
		this.leg = this.root.getChild("leg");
		this.leg2 = this.root.getChild("leg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 30.0F, -0.125F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(0, 33).addBox(-5.0F, -4.25F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(32, 51).addBox(-4.0F, -10.25F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(64, 51).addBox(-12.0F, -20.25F, 0.0F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.75F, 0.0F));

		PartDefinition middle = lower.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(0, 47).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(64, 61).addBox(4.0F, -3.0F, 0.0F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.25F, 0.0F));

		PartDefinition top = middle.addOrReplaceChild("top", CubeListBuilder.create().texOffs(40, 33).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-14.0F, -15.0F, -14.0F, 28.0F, 5.0F, 28.0F, new CubeDeformation(0.0F))
				.texOffs(16, 95).addBox(-14.0F, -10.0F, -14.0F, 28.0F, 5.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition leg = root.addOrReplaceChild("leg", CubeListBuilder.create().texOffs(0, 63).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(11, 65).addBox(-4.5F, 14.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -20.0F, 0.0F));

		PartDefinition leg2 = root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 63).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(11, 65).addBox(-4.5F, 14.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -20.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);



        this.animateWalk(Warped_FungussusAnimations.walk4, limbSwing, limbSwingAmount, 1.5f, 2.5f);
        this.animate(((Warped_FungussusEntity) entity).idleAnimationState,Warped_FungussusAnimations.IDLE,ageInTicks, 1f);
		this.animate(((Warped_FungussusEntity) entity).attackAnimationState, Warped_FungussusAnimations.ATTACK,ageInTicks, 1f);
		this.animate(((Warped_FungussusEntity) entity).DeathAnimationState, Warped_FungussusAnimations.DEATH,ageInTicks, 1f);

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