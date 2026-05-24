// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn.WanderingEyeAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.WanderingEyeEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class WanderingEyeModel<T extends WanderingEyeEntity> extends HierarchicalModel<T> {

    private final ModelPart root;
    private final ModelPart Eye;
    private final ModelPart body;
    private final ModelPart Layer2;
    private final ModelPart Layer1;

    public WanderingEyeModel(ModelPart root) {
        this.root = root.getChild("root");
        this.Eye = this.root.getChild("Eye");
        this.body = this.root.getChild("body");
        this.Layer2 = this.body.getChild("Layer2");
        this.Layer1 = this.body.getChild("Layer1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Eye = root.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -5.0F, -2.5F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Layer2 = body.addOrReplaceChild("Layer2", CubeListBuilder.create().texOffs(0, 24).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition Layer1 = body.addOrReplaceChild("Layer1", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -2.0F, -10.0F, 20.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
        this.animate((entity).getAnimationState("idle"), WanderingEyeAnimations.idle, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("roll"), WanderingEyeAnimations.roll, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("death"), WanderingEyeAnimations.death, ageInTicks, 1.0F);
    }


    private void applyHeadRotation(T pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
        this.Eye.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.Eye.xRot = pHeadPitch * ((float) Math.PI / 180F);
    }


    @Override
    public void renderToBuffer(PoseStack pMatrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(pMatrixStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }

}