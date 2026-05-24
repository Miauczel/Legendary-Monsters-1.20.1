// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.TheObliteratorCloneEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.TheWarpedOneDuplicateAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;


public class TheObliteratorCloneModel<T extends TheObliteratorCloneEntity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart big_cube;
	private final ModelPart inner_cube_body;
	private final ModelPart innercube_front_top_right;
	private final ModelPart innercube_front_top_left;
	private final ModelPart innercube_front_down_right;
	private final ModelPart innercube_front_down_left;
	private final ModelPart innercube_back_top_right;
	private final ModelPart innercube_back_top_left;
	private final ModelPart innercube_back_down_left;
	private final ModelPart innercube_back_down_right;
	private final ModelPart the_eye;
	private final ModelPart lower_part;
	private final ModelPart cune_front_down_left;
	private final ModelPart cube_front_down_right;
	private final ModelPart cube_back_down_left;
	private final ModelPart cube_back_down_right;
	private final ModelPart power_ball;
	private final ModelPart legflower;
	private final ModelPart bigRing;
	private final ModelPart bone;

	public TheObliteratorCloneModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.big_cube = this.body.getChild("big_cube");
		this.inner_cube_body = this.big_cube.getChild("inner_cube_body");
		this.innercube_front_top_right = this.inner_cube_body.getChild("innercube_front_top_right");
		this.innercube_front_top_left = this.inner_cube_body.getChild("innercube_front_top_left");
		this.innercube_front_down_right = this.inner_cube_body.getChild("innercube_front_down_right");
		this.innercube_front_down_left = this.inner_cube_body.getChild("innercube_front_down_left");
		this.innercube_back_top_right = this.inner_cube_body.getChild("innercube_back_top_right");
		this.innercube_back_top_left = this.inner_cube_body.getChild("innercube_back_top_left");
		this.innercube_back_down_left = this.inner_cube_body.getChild("innercube_back_down_left");
		this.innercube_back_down_right = this.inner_cube_body.getChild("innercube_back_down_right");
		this.the_eye = this.inner_cube_body.getChild("the_eye");
		this.lower_part = this.big_cube.getChild("lower_part");
		this.cune_front_down_left = this.lower_part.getChild("cune_front_down_left");
		this.cube_front_down_right = this.lower_part.getChild("cube_front_down_right");
		this.cube_back_down_left = this.lower_part.getChild("cube_back_down_left");
		this.cube_back_down_right = this.lower_part.getChild("cube_back_down_right");
		this.power_ball = this.body.getChild("power_ball");
		this.legflower = this.root.getChild("legflower");
		this.bigRing = this.legflower.getChild("bigRing");
		this.bone = this.legflower.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -50.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 4.0F));

		PartDefinition big_cube = body.addOrReplaceChild("big_cube", CubeListBuilder.create(), PartPose.offset(-1.0F, 10.0F, 0.0F));

		PartDefinition inner_cube_body = big_cube.addOrReplaceChild("inner_cube_body", CubeListBuilder.create(), PartPose.offset(21.0F, -5.0F, -4.0F));

		PartDefinition innercube_front_top_right = inner_cube_body.addOrReplaceChild("innercube_front_top_right", CubeListBuilder.create().texOffs(208, 109).addBox(-2.0F, -5.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -37.0F, 4.0F));

		PartDefinition innercube_front_top_left = inner_cube_body.addOrReplaceChild("innercube_front_top_left", CubeListBuilder.create().texOffs(208, 229).addBox(-18.0F, -5.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -37.0F, 4.0F));

		PartDefinition innercube_front_down_right = inner_cube_body.addOrReplaceChild("innercube_front_down_right", CubeListBuilder.create().texOffs(208, 69).addBox(-2.0F, -13.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -6.0F, 4.0F));

		PartDefinition innercube_front_down_left = inner_cube_body.addOrReplaceChild("innercube_front_down_left", CubeListBuilder.create().texOffs(208, 29).addBox(-18.0F, 0.0F, -2.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -19.0F, 4.0F));

		PartDefinition innercube_back_top_right = inner_cube_body.addOrReplaceChild("innercube_back_top_right", CubeListBuilder.create().texOffs(0, 253).addBox(-2.0F, -5.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -37.0F, -4.0F));

		PartDefinition innercube_back_top_left = inner_cube_body.addOrReplaceChild("innercube_back_top_left", CubeListBuilder.create().texOffs(80, 253).addBox(-18.0F, -5.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -37.0F, -4.0F));

		PartDefinition innercube_back_down_left = inner_cube_body.addOrReplaceChild("innercube_back_down_left", CubeListBuilder.create().texOffs(208, 189).addBox(-18.0F, -14.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -5.0F, -4.0F));

		PartDefinition innercube_back_down_right = inner_cube_body.addOrReplaceChild("innercube_back_down_right", CubeListBuilder.create().texOffs(208, 149).addBox(-2.0F, -14.0F, -18.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -5.0F, -4.0F));

		PartDefinition the_eye = inner_cube_body.addOrReplaceChild("the_eye", CubeListBuilder.create().texOffs(288, 94).addBox(-9.0F, -9.0F, -3.5F, 18.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-20.0F, -20.0F, 0.5F));

		PartDefinition lower_part = big_cube.addOrReplaceChild("lower_part", CubeListBuilder.create(), PartPose.offset(1.0F, -9.0F, -4.0F));

		PartDefinition cune_front_down_left = lower_part.addOrReplaceChild("cune_front_down_left", CubeListBuilder.create(), PartPose.offset(7.0F, 8.0F, -8.0F));

		PartDefinition cube_front_down_right = lower_part.addOrReplaceChild("cube_front_down_right", CubeListBuilder.create(), PartPose.offset(-8.0F, 9.0F, -8.0F));

		PartDefinition cube_back_down_left = lower_part.addOrReplaceChild("cube_back_down_left", CubeListBuilder.create(), PartPose.offset(7.0F, 8.0F, 8.0F));

		PartDefinition cube_back_down_right = lower_part.addOrReplaceChild("cube_back_down_right", CubeListBuilder.create(), PartPose.offset(-8.0F, 9.0F, 8.0F));

		PartDefinition power_ball = body.addOrReplaceChild("power_ball", CubeListBuilder.create().texOffs(354, 4).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(348, 36).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(2.0F)), PartPose.offset(0.0F, -14.0F, -26.0F));

		PartDefinition legflower = root.addOrReplaceChild("legflower", CubeListBuilder.create().texOffs(160, 269).addBox(-9.5F, -0.783F, -9.3F, 19.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 34.783F, -0.2F));

		PartDefinition bigRing = legflower.addOrReplaceChild("bigRing", CubeListBuilder.create().texOffs(0, 0).addBox(-19.5F, 2.217F, -19.3F, 39.0F, 6.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = legflower.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(156, 0).addBox(-12.5F, 13.217F, -12.3F, 25.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.getAnimationState("emerge"), TheWarpedOneDuplicateAnimations.shoot, ageInTicks, 1.0F);

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