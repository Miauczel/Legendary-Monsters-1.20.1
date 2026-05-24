// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.Lava_eaterAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Lava_eaterEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class Lava_eaterModel<T extends Lava_eaterEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head2;

	public Lava_eaterModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head2 = root.getChild("root").getChild("mainbody").getChild("head");


	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 42, 4.0F));

		PartDefinition lowerhead2 = root.addOrReplaceChild("lowerhead2", CubeListBuilder.create(), PartPose.offset(0.0F, -21.75F, -12.0F));

		PartDefinition leg1 = root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(28, 111).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(74, 26).mirror().addBox(1.501F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(74, 22).mirror().addBox(-1.499F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.375F, -27.25F, -12.5F));

		PartDefinition leg4 = root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(102, 101).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(74, 22).addBox(1.5F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(74, 26).addBox(-1.5F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(10.625F, -27.25F, 0.5F));

		PartDefinition leg3 = root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(114, 72).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(74, 22).mirror().addBox(-1.499F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(74, 26).mirror().addBox(1.501F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.375F, -27.25F, 0.5F));

		PartDefinition leg2 = root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 111).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(74, 22).addBox(1.5F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(74, 26).addBox(-1.5F, 11.0F, -5.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(10.625F, -27.25F, -12.5F));

		PartDefinition mainbody = root.addOrReplaceChild("mainbody", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -14.5F, -14.125F, 16.0F, 14.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(80, 72).addBox(0.0F, -26.5F, -10.375F, 0.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -22.75F, -1.875F));

		PartDefinition mediumbody = mainbody.addOrReplaceChild("mediumbody", CubeListBuilder.create().texOffs(80, 44).addBox(-4.2F, -4.75F, -0.75F, 9.0F, 11.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(32, 83).addBox(0.25F, -16.75F, -0.25F, 0.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, -8.75F, 6.875F));

		PartDefinition smallbody = mediumbody.addOrReplaceChild("smallbody", CubeListBuilder.create().texOffs(64, 101).addBox(-3.0F, -4.0F, -0.5F, 6.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(56, 122).addBox(0.0F, -16.0F, 0.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 0.25F, 16.75F));

		PartDefinition head = mainbody.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-0.25F, -7.25F, -14.125F));

		PartDefinition spikes = head.addOrReplaceChild("spikes", CubeListBuilder.create(), PartPose.offset(4.0F, -8.5F, 4.0F));

		PartDefinition spikes_r1 = spikes.addOrReplaceChild("spikes_r1", CubeListBuilder.create().texOffs(0, 132).addBox(-1.875F, -4.875F, -1.5F, 3.0F, 9.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7734F, 0.1536F, 0.1555F));

		PartDefinition spikes_r2 = spikes.addOrReplaceChild("spikes_r2", CubeListBuilder.create().texOffs(130, 97).addBox(-1.875F, -4.875F, -1.5F, 3.0F, 9.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, 0.0F, 0.0F, -0.7137F, -0.3614F, -0.3876F));

		PartDefinition spikes_r3 = spikes.addOrReplaceChild("spikes_r3", CubeListBuilder.create().texOffs(128, 122).addBox(-1.875F, -4.875F, -1.5F, 3.0F, 9.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, -0.7734F, -0.1536F, -0.1555F));

		PartDefinition spikes_r4 = spikes.addOrReplaceChild("spikes_r4", CubeListBuilder.create().texOffs(116, 122).addBox(-1.875F, -4.875F, -1.5F, 3.0F, 9.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.25F, -2.25F, -0.5236F, 0.0F, 0.0F));

		PartDefinition spikes_r5 = spikes.addOrReplaceChild("spikes_r5", CubeListBuilder.create().texOffs(104, 122).addBox(-1.875F, -4.875F, -1.5F, 3.0F, 9.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, -2.25F, -2.25F, -0.6378F, -0.1582F, -0.2095F));

		PartDefinition spikes_r6 = spikes.addOrReplaceChild("spikes_r6", CubeListBuilder.create().texOffs(92, 122).addBox(-1.875F, -4.875F, -1.5F, 3.0F, 9.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -2.25F, -2.25F, -0.6378F, 0.1582F, 0.2095F));

		PartDefinition spikes_r7 = spikes.addOrReplaceChild("spikes_r7", CubeListBuilder.create().texOffs(80, 122).addBox(-1.875F, -4.875F, -1.5F, 3.0F, 9.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.0F, 0.0F, -0.7137F, 0.3614F, 0.3876F));

		PartDefinition upperhead2 = head.addOrReplaceChild("upperhead2", CubeListBuilder.create().texOffs(0, 35).addBox(-10.9167F, -9.6667F, -17.0F, 22.0F, 6.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(74, 0).addBox(-10.9167F, -3.6667F, -17.0F, 22.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(114, 93).addBox(-10.9167F, -3.6667F, 0.0F, 22.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 83).addBox(-0.1667F, -21.6667F, -16.0F, 0.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4167F, 1.4167F, -1.25F));

		PartDefinition bigtooth4 = upperhead2.addOrReplaceChild("bigtooth4", CubeListBuilder.create().texOffs(12, 132).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.9167F, -4.6667F, -2.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition bigtooth4_r1 = bigtooth4.addOrReplaceChild("bigtooth4_r1", CubeListBuilder.create().texOffs(64, 83).mirror().addBox(-4.5F, -4.875F, -0.5F, 8.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 1.5F, -0.875F, -1.5708F, 0.0F, 0.0F));

		PartDefinition bigtooth4_r2 = bigtooth4.addOrReplaceChild("bigtooth4_r2", CubeListBuilder.create().texOffs(130, 110).mirror().addBox(-1.5F, -4.125F, -1.5F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 1.5F, -1.125F, -1.5708F, 0.0F, 0.0F));

		PartDefinition bigtooth3 = upperhead2.addOrReplaceChild("bigtooth3", CubeListBuilder.create().texOffs(12, 132).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0833F, -4.9167F, -2.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition bigtooth3_r1 = bigtooth3.addOrReplaceChild("bigtooth3_r1", CubeListBuilder.create().texOffs(64, 83).addBox(-3.5F, -4.875F, -0.5F, 8.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.5F, -0.875F, -1.5708F, 0.0F, 0.0F));

		PartDefinition bigtooth3_r2 = bigtooth3.addOrReplaceChild("bigtooth3_r2", CubeListBuilder.create().texOffs(130, 110).addBox(-1.5F, -4.125F, -1.5F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.5F, -1.125F, -1.5708F, 0.0F, 0.0F));

		PartDefinition lowerhead = head.addOrReplaceChild("lowerhead", CubeListBuilder.create().texOffs(0, 59).addBox(-11.0F, 0.5F, -17.0F, 22.0F, 6.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(80, 22).addBox(-11.0F, -3.5F, -17.0F, 22.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.25F, -1.25F));

		PartDefinition bigtooth = lowerhead.addOrReplaceChild("bigtooth", CubeListBuilder.create().texOffs(12, 132).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 1.25F, -2.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition bigtooth_r1 = bigtooth.addOrReplaceChild("bigtooth_r1", CubeListBuilder.create().texOffs(64, 83).addBox(-3.5F, -4.875F, -0.5F, 8.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.5F, -0.875F, -1.5708F, 0.0F, 0.0F));

		PartDefinition bigtooth_r2 = bigtooth.addOrReplaceChild("bigtooth_r2", CubeListBuilder.create().texOffs(130, 110).addBox(-1.5F, -4.125F, -1.5F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.5F, -1.125F, -1.5708F, 0.0F, 0.0F));

		PartDefinition bigtooth2 = lowerhead.addOrReplaceChild("bigtooth2", CubeListBuilder.create().texOffs(12, 132).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, 1.5F, -2.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition bigtooth2_r1 = bigtooth2.addOrReplaceChild("bigtooth2_r1", CubeListBuilder.create().texOffs(64, 83).mirror().addBox(-4.5F, -4.875F, -0.5F, 8.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 1.5F, -0.875F, -1.5708F, 0.0F, 0.0F));

		PartDefinition bigtooth2_r2 = bigtooth2.addOrReplaceChild("bigtooth2_r2", CubeListBuilder.create().texOffs(130, 110).mirror().addBox(-1.5F, -4.125F, -1.5F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 1.5F, -1.125F, -1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);

	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		if (entity.getAttackState() != 4 && !entity.isSleep()) {
			this.applyHeadRotation((Lava_eaterEntity) entity, netHeadYaw, headPitch, ageInTicks);
		}


		this.animateWalk(Lava_eaterAnimations.walk2,limbSwing,limbSwingAmount,1.5F,2.5F);
		this.animate((entity).getAnimationState("death"), Lava_eaterAnimations.death, ageInTicks, 1.0F);
		this.animate(((Lava_eaterEntity) entity).getAnimationState("idle"), Lava_eaterAnimations.idle, ageInTicks, 1.0F);
		this.animate(((Lava_eaterEntity) entity).getAnimationState("sleep"), Lava_eaterAnimations.sleep, ageInTicks, 1.0F);
		this.animate(((Lava_eaterEntity) entity).getAnimationState("awake"), Lava_eaterAnimations.awaken, ageInTicks, 1.0F);
		this.animate(((Lava_eaterEntity) entity).getAnimationState("bite"), Lava_eaterAnimations.attack, ageInTicks, 1.0F);
		this.animate(((Lava_eaterEntity) entity).getAnimationState("dig"), Lava_eaterAnimations.digAttack, ageInTicks, 1.0F);
		this.animate(((Lava_eaterEntity) entity).getAnimationState("spin"), Lava_eaterAnimations.spin, ageInTicks, 1.0F);
		this.animate(((Lava_eaterEntity) entity).getAnimationState("slam"), Lava_eaterAnimations.Slam, ageInTicks, 1.0F);

		this.animate(((Lava_eaterEntity) entity).getAnimationState("fire"), Lava_eaterAnimations.fire2, ageInTicks, 1.0F);
		this.root.xScale = 1.3F;
		this.root.yScale = 1.3F;
		this.root.zScale = 1.3F;

	}

	private void applyHeadRotation(Lava_eaterEntity	 pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
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