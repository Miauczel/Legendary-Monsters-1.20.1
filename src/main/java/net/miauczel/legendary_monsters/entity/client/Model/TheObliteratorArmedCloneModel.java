// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.TheObliteratorCloneWithArmsEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.TheWarpedOneDuplicateAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;


public class TheObliteratorArmedCloneModel<T extends TheObliteratorCloneWithArmsEntity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart legflower;
	private final ModelPart bigRing;
	private final ModelPart bone;
	private final ModelPart body_neutral_rotation;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart main_rotator2;
	private final ModelPart shoulder_left;
	private final ModelPart forearm_left;
	private final ModelPart finger_left;
	private final ModelPart blade;
	private final ModelPart right_arm;
	private final ModelPart main_rotator;
	private final ModelPart shoulder_right;
	private final ModelPart forearm_right;
	private final ModelPart blade2;
	private final ModelPart finger_right;
	private final ModelPart big_cube;
	private final ModelPart inner_cube_body;
	private final ModelPart the_eye;
	private final ModelPart inner_upper_part;
	private final ModelPart innercube_front_top_left;
	private final ModelPart innercube_front_top_right;
	private final ModelPart innercube_back_top_right;
	private final ModelPart innercube_back_top_left;
	private final ModelPart inner_lower_part;
	private final ModelPart innercube_front_down_right;
	private final ModelPart innercube_front_down_left;
	private final ModelPart innercube_back_down_left;
	private final ModelPart innercube_back_down_right;
	private final ModelPart power_ball;

	public TheObliteratorArmedCloneModel(ModelPart root) {
		this.root = root.getChild("root");
		this.legflower = this.root.getChild("legflower");
		this.bigRing = this.legflower.getChild("bigRing");
		this.bone = this.legflower.getChild("bone");
		this.body_neutral_rotation = this.root.getChild("body_neutral_rotation");
		this.body = this.body_neutral_rotation.getChild("body");
		this.left_arm = this.body.getChild("left_arm");
		this.main_rotator2 = this.left_arm.getChild("main_rotator2");
		this.shoulder_left = this.main_rotator2.getChild("shoulder_left");
		this.forearm_left = this.shoulder_left.getChild("forearm_left");
		this.finger_left = this.forearm_left.getChild("finger_left");
		this.blade = this.forearm_left.getChild("blade");
		this.right_arm = this.body.getChild("right_arm");
		this.main_rotator = this.right_arm.getChild("main_rotator");
		this.shoulder_right = this.main_rotator.getChild("shoulder_right");
		this.forearm_right = this.shoulder_right.getChild("forearm_right");
		this.blade2 = this.forearm_right.getChild("blade2");
		this.finger_right = this.forearm_right.getChild("finger_right");
		this.big_cube = this.body.getChild("big_cube");
		this.inner_cube_body = this.big_cube.getChild("inner_cube_body");
		this.the_eye = this.inner_cube_body.getChild("the_eye");
		this.inner_upper_part = this.inner_cube_body.getChild("inner_upper_part");
		this.innercube_front_top_left = this.inner_upper_part.getChild("innercube_front_top_left");
		this.innercube_front_top_right = this.inner_upper_part.getChild("innercube_front_top_right");
		this.innercube_back_top_right = this.inner_upper_part.getChild("innercube_back_top_right");
		this.innercube_back_top_left = this.inner_upper_part.getChild("innercube_back_top_left");
		this.inner_lower_part = this.inner_cube_body.getChild("inner_lower_part");
		this.innercube_front_down_right = this.inner_lower_part.getChild("innercube_front_down_right");
		this.innercube_front_down_left = this.inner_lower_part.getChild("innercube_front_down_left");
		this.innercube_back_down_left = this.inner_lower_part.getChild("innercube_back_down_left");
		this.innercube_back_down_right = this.inner_lower_part.getChild("innercube_back_down_right");
		this.power_ball = this.body.getChild("power_ball");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -50.0F, 0.0F));

		PartDefinition legflower = root.addOrReplaceChild("legflower", CubeListBuilder.create().texOffs(160, 269).addBox(-9.5F, -0.783F, -9.3F, 19.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 34.783F, -0.2F));

		PartDefinition bigRing = legflower.addOrReplaceChild("bigRing", CubeListBuilder.create().texOffs(0, 0).addBox(-19.5F, 2.217F, -19.3F, 39.0F, 6.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = legflower.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(156, 0).addBox(-12.5F, 13.217F, -12.3F, 25.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_neutral_rotation = root.addOrReplaceChild("body_neutral_rotation", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = body_neutral_rotation.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 4.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(46.6F, -36.0F, -3.8F, 0.0F, 0.0F, -0.3054F));

		PartDefinition main_rotator2 = left_arm.addOrReplaceChild("main_rotator2", CubeListBuilder.create(), PartPose.offset(-0.0582F, -9.4504F, -0.2F));

		PartDefinition shoulder_left = main_rotator2.addOrReplaceChild("shoulder_left", CubeListBuilder.create().texOffs(288, 64).addBox(-6.3F, 1.3F, -6.2F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(288, 32).addBox(-8.3F, -16.7F, -7.2F, 16.0F, 18.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(288, 143).addBox(7.7F, -32.7F, -4.2F, 19.0F, 32.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(288, 143).addBox(7.7F, -32.7F, 3.8F, 19.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0582F, 9.4504F, 0.2F));

		PartDefinition forearm_left = shoulder_left.addOrReplaceChild("forearm_left", CubeListBuilder.create().texOffs(236, 269).addBox(-7.5F, 0.0F, -7.5F, 15.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 16.6F, 0.25F, 0.0F, 0.0F, 0.3927F));

		PartDefinition finger_left = forearm_left.addOrReplaceChild("finger_left", CubeListBuilder.create().texOffs(288, 0).addBox(-8.5F, 0.0F, -8.0F, 17.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -0.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition blade = forearm_left.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(288, 175).addBox(-0.625F, 7.75F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(156, 29).addBox(-0.625F, -24.25F, 0.0F, 19.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(256, 0).addBox(3.375F, -10.25F, -2.0F, 11.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(160, 253).addBox(-0.625F, -6.25F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.125F, 13.25F, -0.5F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-46.6F, -36.0F, -3.8F, 0.0F, 0.0F, 0.3054F));

		PartDefinition main_rotator = right_arm.addOrReplaceChild("main_rotator", CubeListBuilder.create(), PartPose.offset(0.0582F, -9.4504F, -0.2F));

		PartDefinition shoulder_right = main_rotator.addOrReplaceChild("shoulder_right", CubeListBuilder.create().texOffs(288, 64).mirror().addBox(-5.7F, 1.3F, -6.2F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(288, 32).mirror().addBox(-7.7F, -16.7F, -7.2F, 16.0F, 18.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(288, 143).mirror().addBox(-26.7F, -32.7F, -4.2F, 19.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(288, 143).mirror().addBox(-26.7F, -32.7F, 3.8F, 19.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.0582F, 9.4504F, 0.2F));

		PartDefinition forearm_right = shoulder_right.addOrReplaceChild("forearm_right", CubeListBuilder.create().texOffs(236, 269).mirror().addBox(-7.5F, 0.0F, -7.5F, 15.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 16.6F, 0.25F, 0.0F, 0.0F, -0.3927F));

		PartDefinition blade2 = forearm_right.addOrReplaceChild("blade2", CubeListBuilder.create().texOffs(160, 253).mirror().addBox(-3.375F, -6.25F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(256, 0).mirror().addBox(-14.375F, -10.25F, -2.0F, 11.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(156, 29).mirror().addBox(-18.375F, -24.25F, 0.0F, 19.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(288, 175).mirror().addBox(-18.375F, 7.75F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.125F, 13.25F, -0.5F));

		PartDefinition finger_right = forearm_right.addOrReplaceChild("finger_right", CubeListBuilder.create().texOffs(288, 0).mirror().addBox(-8.5F, 0.0F, -8.0F, 17.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, -0.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition big_cube = body.addOrReplaceChild("big_cube", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition inner_cube_body = big_cube.addOrReplaceChild("inner_cube_body", CubeListBuilder.create(), PartPose.offset(21.0F, -5.0F, -4.0F));

		PartDefinition the_eye = inner_cube_body.addOrReplaceChild("the_eye", CubeListBuilder.create().texOffs(288, 94).addBox(-9.0F, -9.0F, -3.5F, 18.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-20.0F, -20.0F, 0.5F));

		PartDefinition inner_upper_part = inner_cube_body.addOrReplaceChild("inner_upper_part", CubeListBuilder.create(), PartPose.offset(-20.0F, -33.0F, 0.0F));

		PartDefinition innercube_front_top_left = inner_upper_part.addOrReplaceChild("innercube_front_top_left", CubeListBuilder.create().texOffs(208, 229).addBox(-18.0F, -5.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -4.0F, 4.0F));

		PartDefinition innercube_front_top_right = inner_upper_part.addOrReplaceChild("innercube_front_top_right", CubeListBuilder.create().texOffs(208, 109).addBox(-2.0F, -5.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -4.0F, 4.0F));

		PartDefinition innercube_back_top_right = inner_upper_part.addOrReplaceChild("innercube_back_top_right", CubeListBuilder.create().texOffs(0, 253).addBox(-2.0F, -5.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -4.0F, -4.0F));

		PartDefinition innercube_back_top_left = inner_upper_part.addOrReplaceChild("innercube_back_top_left", CubeListBuilder.create().texOffs(80, 253).addBox(-18.0F, -5.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -4.0F, -4.0F));

		PartDefinition inner_lower_part = inner_cube_body.addOrReplaceChild("inner_lower_part", CubeListBuilder.create(), PartPose.offset(-20.0F, -8.0F, 0.0F));

		PartDefinition innercube_front_down_right = inner_lower_part.addOrReplaceChild("innercube_front_down_right", CubeListBuilder.create().texOffs(208, 69).addBox(-2.0F, -13.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.0F, 4.0F));

		PartDefinition innercube_front_down_left = inner_lower_part.addOrReplaceChild("innercube_front_down_left", CubeListBuilder.create().texOffs(208, 29).addBox(-18.0F, 0.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -11.0F, 4.0F));

		PartDefinition innercube_back_down_left = inner_lower_part.addOrReplaceChild("innercube_back_down_left", CubeListBuilder.create().texOffs(208, 189).addBox(-18.0F, -14.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 3.0F, -4.0F));

		PartDefinition innercube_back_down_right = inner_lower_part.addOrReplaceChild("innercube_back_down_right", CubeListBuilder.create().texOffs(208, 149).addBox(-2.0F, -14.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, -4.0F));

		PartDefinition power_ball = body.addOrReplaceChild("power_ball", CubeListBuilder.create().texOffs(354, 4).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(348, 36).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(2.0F)), PartPose.offset(0.0F, -24.0F, -27.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.getAnimationState("uppercut"), TheWarpedOneDuplicateAnimations.uppercut, ageInTicks, 1.0F);

		this.animate(entity.getAnimationState("right_uppercut"), TheWarpedOneDuplicateAnimations.uppercutRight, ageInTicks, 1.0F);
		this.animate(entity.getAnimationState("left_hook_combo"), TheWarpedOneDuplicateAnimations.leftHookCombo, ageInTicks, 1.0F);


		double posX = entity.getX();
		double posY = entity.getY();
		double posZ = entity.getZ();

		double destX = entity.getDestinationX();
		double destY = entity.getDestinationY();
		double destZ = entity.getDestinationZ();

		double dx = destX - posX;
		double dy = destY - posY;
		double dz = destZ - posZ;

		float yawDeg = (float)(Math.toDegrees(Math.atan2(dz, dx))) - 90F;
		float horizontalDist = (float)Math.sqrt(dx * dx + dz * dz);
		float pitchDeg = (float)(-Math.toDegrees(Math.atan2(dy, horizontalDist)));

		float yawRad   = yawDeg   * ((float)Math.PI / 180F);
		float pitchRad = pitchDeg * ((float)Math.PI / 180F);

	root.xRot = pitchRad;
	}


	@Override
	public void renderToBuffer(PoseStack pMatrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(pMatrixStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		PoseStack modelStack = pMatrixStack;

		// Skaluj model

	}

	@Override
	public ModelPart root() {
		return root;
	}
}