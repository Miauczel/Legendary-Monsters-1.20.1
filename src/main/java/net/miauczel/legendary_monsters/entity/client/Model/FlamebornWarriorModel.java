// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn.FlamebornGuardAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn.FlamebornWarriorAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.FlamebornGuardEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.FlamebornWarriorEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class FlamebornWarriorModel<T extends FlamebornWarriorEntity> extends HierarchicalModel<T> {

    private final ModelPart root;
    private final ModelPart Body;
    private final ModelPart Head;
    private final ModelPart upperhead;
    private final ModelPart RightArm;
    private final ModelPart lowerRightArm;
    private final ModelPart RightWeapon;
    private final ModelPart LeftArm;
    private final ModelPart lowerLeftArm;
    private final ModelPart LeftWeapon;
    private final ModelPart RightLeg;
    private final ModelPart LeftLeg;

    public FlamebornWarriorModel(ModelPart root) {
        this.root = root.getChild("root");
        this.Body = this.root.getChild("Body");
        this.Head = this.Body.getChild("Head");
        this.upperhead = this.Head.getChild("upperhead");
        this.RightArm = this.Body.getChild("RightArm");
        this.lowerRightArm = this.RightArm.getChild("lowerRightArm");
        this.RightWeapon = this.lowerRightArm.getChild("RightWeapon");
        this.LeftArm = this.Body.getChild("LeftArm");
        this.lowerLeftArm = this.LeftArm.getChild("lowerLeftArm");
        this.LeftWeapon = this.lowerLeftArm.getChild("LeftWeapon");
        this.RightLeg = this.root.getChild("RightLeg");
        this.LeftLeg = this.root.getChild("LeftLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(48, 32).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(48, 48).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(40, 16).addBox(-4.0F, -7.95F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -12.05F, 0.0F));

        PartDefinition upperhead = Head.addOrReplaceChild("upperhead", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -7.8F, -9.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-5.0F, -8.8F, -10.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(5.0F, -3.8F, -9.0F, 5.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).mirror().addBox(-10.0F, -3.8F, -9.0F, 5.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(0.0F, -18.8F, -14.0F, 0.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.15F, 5.0F));

        PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(26, 52).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 60).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(-4.0F, -10.0F, 0.0F));

        PartDefinition lowerRightArm = RightArm.addOrReplaceChild("lowerRightArm", CubeListBuilder.create().texOffs(16, 60).addBox(-1.0F, -0.6667F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 13.6667F, 0.0F));

        PartDefinition RightWeapon = lowerRightArm.addOrReplaceChild("RightWeapon", CubeListBuilder.create().texOffs(48, 64).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(56, 64).addBox(-2.0F, 2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(34, 64).addBox(-3.0F, -12.0F, 0.0F, 7.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 12.8333F, 0.0F, 1.5708F, 0.0F, 1.5708F));

        PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(26, 52).mirror().addBox(0.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 60).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(4.0F, -10.0F, 0.0F));

        PartDefinition lowerLeftArm = LeftArm.addOrReplaceChild("lowerLeftArm", CubeListBuilder.create().texOffs(16, 60).mirror().addBox(-1.0F, -0.6667F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 13.6667F, 0.0F));

        PartDefinition LeftWeapon = lowerLeftArm.addOrReplaceChild("LeftWeapon", CubeListBuilder.create().texOffs(48, 64).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(56, 64).mirror().addBox(-2.0F, 2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(34, 64).mirror().addBox(-4.0F, -12.0F, 0.0F, 7.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 12.8333F, 0.0F, 1.5708F, 0.0F, -1.5708F));

        PartDefinition RightLeg = root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(40, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 7.0F, 0.0F));

        PartDefinition LeftLeg = root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(40, 32).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 7.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
        if (entity.getAttackState() == 0)
            this.animateWalk(FlamebornGuardAnimations.walk2, limbSwing, limbSwingAmount, 1.5F, 4.0F);

        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

        this.animate((entity).getAnimationState("idle"), FlamebornGuardAnimations.idle, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("death"), FlamebornGuardAnimations.death2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("hit"), FlamebornWarriorAnimations.hit, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("hit2"), FlamebornWarriorAnimations.hit2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("hit_double"), FlamebornWarriorAnimations.hitDouble, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("hit_double2"), FlamebornWarriorAnimations.hitDouble2, ageInTicks, 1.0F);
    }


    private void applyHeadRotation(T pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
        this.Head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.Head.xRot = pHeadPitch * ((float) Math.PI / 180F);
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