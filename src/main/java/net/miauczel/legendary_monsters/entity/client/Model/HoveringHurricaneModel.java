// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.animations.HoveringHurricaneAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple.HoveringHurricaneEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class HoveringHurricaneModel<T extends HoveringHurricaneEntity> extends HierarchicalModel<T> {

	private final ModelPart root;


	private final ModelPart head;

	public HoveringHurricaneModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = root.getChild("root").getChild("body").getChild("head");



	}

		public static LayerDefinition createBodyLayer() {
			MeshDefinition meshdefinition = new MeshDefinition();
			PartDefinition partdefinition = meshdefinition.getRoot();

			PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));

			PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

			PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(64, 0).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
					.texOffs(72, 38).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(12.0F, -16.0F, 0.0F));

			PartDefinition lower = leftarm.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
					.texOffs(32, 18).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 13.0F, 0.0F));

			PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(64, 19).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
					.texOffs(0, 68).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(-12.0F, -16.0F, 0.0F));

			PartDefinition lower2 = rightarm.addOrReplaceChild("lower2", CubeListBuilder.create().texOffs(32, 36).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
					.texOffs(0, 50).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 13.0F, 0.0F));

			PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F))
					.texOffs(0, 25).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -19.0F, 0.0F));

			PartDefinition rod = body.addOrReplaceChild("rod", CubeListBuilder.create().texOffs(32, 54).addBox(-2.5F, -11.5F, -2.5F, 5.0F, 23.0F, 5.0F, new CubeDeformation(0.0F))
					.texOffs(52, 54).addBox(-2.5F, -11.5F, -2.5F, 5.0F, 23.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -5.5F, 0.0F));

			PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(20, 68).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
					.texOffs(72, 57).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offset(3.5F, 6.0F, -7.5F));

			PartDefinition bone2 = root.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(72, 72).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
					.texOffs(32, 82).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offset(6.5F, -8.0F, 7.5F));

			PartDefinition bone3 = root.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(44, 82).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
					.texOffs(56, 82).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offset(-5.5F, -4.0F, -2.5F));

			return LayerDefinition.create(meshdefinition, 128, 128);
		}

		@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation( entity, netHeadYaw, headPitch, ageInTicks);
			this.animateWalk(HoveringHurricaneAnimations.walk, limbSwing, limbSwingAmount, 1.5F, 4.0F);

		this.animate(( entity).getAnimationState("idle"), HoveringHurricaneAnimations.idle, ageInTicks, 1.0F);

			this.animate(( entity).getAnimationState("slam"), HoveringHurricaneAnimations.slam, ageInTicks, 1.0F);

			this.animate(( entity).getAnimationState("shoot"), HoveringHurricaneAnimations.tornadoShoot, ageInTicks, 1.0F);
	}





	private void applyHeadRotation(T pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}




	@Override
	public void renderToBuffer(PoseStack pMatrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(pMatrixStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		PoseStack modelStack = pMatrixStack;

		// Skaluj model
		//modelStack.scale(2.0F, 2.0F, 2.0F);
	}

	@Override
	public ModelPart root() {
		return root;
	}

}