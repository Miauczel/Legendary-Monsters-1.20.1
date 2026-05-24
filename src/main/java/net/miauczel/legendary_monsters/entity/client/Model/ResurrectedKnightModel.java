package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.PossessedArmor.ResurrectedKnight.ResurrectedKnightAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.ResurrectedKnight.ResurrectedKnightEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ResurrectedKnightModel<T extends ResurrectedKnightEntity
        > extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart rotator;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart forearm;
    private final ModelPart fist;
    private final ModelPart spine;
    private final ModelPart lower;
    private final ModelPart left_ribs;
    private final ModelPart left_ribs2;
    private final ModelPart right_ribs2;
    private final ModelPart left_arm;
    private final ModelPart left_forearm;
    private final ModelPart left_fist;
    private final ModelPart javelin;
    private final ModelPart head;
    private final ModelPart visor;

    public ResurrectedKnightModel(ModelPart root) {
        this.root = root.getChild("root");
        this.rotator = this.root.getChild("rotator");
        this.body = this.rotator.getChild("body");
        this.right_arm = this.body.getChild("right_arm");
        this.forearm = this.right_arm.getChild("forearm");
        this.fist = this.forearm.getChild("fist");
        this.spine = this.body.getChild("spine");
        this.lower = this.spine.getChild("lower");
        this.left_ribs = this.spine.getChild("left_ribs");
        this.left_ribs2 = this.spine.getChild("left_ribs2");
        this.right_ribs2 = this.spine.getChild("right_ribs2");
        this.left_arm = this.body.getChild("left_arm");
        this.left_forearm = this.left_arm.getChild("left_forearm");
        this.left_fist = this.left_forearm.getChild("left_fist");
        this.javelin = this.left_fist.getChild("javelin");
        this.head = this.body.getChild("head");
        this.visor = this.head.getChild("visor");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(-1.0F, 21.7678F, 4.1464F));

        PartDefinition rotator = root.addOrReplaceChild("rotator", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -25.0F, -12.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition body = rotator.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(117, 60).addBox(-3.3333F, -3.5F, -3.8333F, 4.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.6667F, -13.5F, -0.1667F, -0.4185F, 0.1274F, 0.2783F));

        PartDefinition forearm = right_arm.addOrReplaceChild("forearm", CubeListBuilder.create().texOffs(139, 60).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 16.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(138, 51).addBox(-2.5F, 10.0F, -4.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(127, 112).addBox(-5.5F, 0.5F, -12.0F, 3.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3333F, 10.5F, -1.3333F, 0.5672F, 0.0F, 0.0F));

        PartDefinition fist = forearm.addOrReplaceChild("fist", CubeListBuilder.create().texOffs(115, 81).addBox(-0.5F, -0.5F, -2.6464F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 16.5F, 0.0F));

        PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(75, 47).addBox(-10.5F, 0.0F, 0.0F, 21.0F, 26.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(80, 20).addBox(0.0F, 0.0F, -6.0F, 0.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -20.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition lower = spine.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(75, 73).addBox(-9.5F, 0.0178F, 0.0F, 19.0F, 21.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(92, 20).addBox(0.0F, -0.9822F, -6.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 25.9822F, 0.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition left_ribs = spine.addOrReplaceChild("left_ribs", CubeListBuilder.create().texOffs(117, 49).addBox(-12.0F, -9.5F, 0.0F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, 9.5F, 0.0F, 0.0F, 1.9635F, 0.0F));

        PartDefinition left_ribs2 = spine.addOrReplaceChild("left_ribs2", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.5F, 9.5F, 0.0F, 0.0F, 1.9635F, 0.0F));

        PartDefinition right_ribs2 = spine.addOrReplaceChild("right_ribs2", CubeListBuilder.create().texOffs(117, 49).mirror().addBox(0.3827F, -9.5F, 0.9239F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.5F, 9.5F, 0.0F, 0.0F, -1.9635F, 0.0F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(117, 60).mirror().addBox(-0.6667F, -3.5F, -3.8333F, 4.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.6667F, -13.5F, -0.1667F, -0.1384F, 0.3215F, -0.4152F));

        PartDefinition left_forearm = left_arm.addOrReplaceChild("left_forearm", CubeListBuilder.create().texOffs(139, 60).mirror().addBox(-1.5F, 0.0F, -2.5F, 3.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3333F, 10.5F, -1.3333F, 0.0F, 0.2618F, 0.0F));

        PartDefinition left_fist = left_forearm.addOrReplaceChild("left_fist", CubeListBuilder.create().texOffs(115, 81).mirror().addBox(-4.5F, -0.5F, -2.6464F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 16.5F, 0.0F, 0.0F, 0.1745F, 0.0F));

        PartDefinition javelin = left_fist.addOrReplaceChild("javelin", CubeListBuilder.create().texOffs(61, 114).mirror().addBox(-0.5F, -0.5F, -25.6465F, 2.0F, 2.0F, 62.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(127, 133).mirror().addBox(0.5F, -8.5F, -37.6465F, 0.0F, 17.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(85, 137).mirror().addBox(0.5F, -10.5F, 8.3536F, 0.0F, 21.0F, 49.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 92).addBox(0.2813F, -22.0F, -17.159F, 0.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 96).addBox(-1.5F, 27.0F, -1.8964F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(9, 94).addBox(-3.0F, 28.0F, -3.5F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-6.0F, 30.0F, -6.5F, 12.0F, 19.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, 30.0F, -6.5F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.5F))
                .texOffs(0, 59).addBox(-6.0F, 30.0F, -6.5F, 12.0F, 12.0F, 12.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -42.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition visor = head.addOrReplaceChild("visor", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -5.0F));

        PartDefinition cube_r2 = visor.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 51).addBox(-12.0F, -8.5F, 0.0F, 12.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1317F, 4.5F, 6.0607F, 0.0F, -1.1781F, 0.0F));

        PartDefinition cube_r3 = visor.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(48, 22).addBox(0.0F, -8.5F, -12.0F, 0.0F, 17.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.8388F, 2.5F, 6.0607F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r4 = visor.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3536F, 3.0F, 6.0607F, 0.0F, -0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }
    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

        this.animate((entity).getAnimationState("idle"), ResurrectedKnightAnimations.idle, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("stab"), ResurrectedKnightAnimations.stabCut, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("left_sidestep"), ResurrectedKnightAnimations.LeftsideStep, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("right_sidestep"), ResurrectedKnightAnimations.RightsideStep, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("forwardstep"), ResurrectedKnightAnimations.forwardStep, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("double_stab"), ResurrectedKnightAnimations.stabDoubleEnd, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("death"), ResurrectedKnightAnimations.death, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("sleep"), ResurrectedKnightAnimations.sleep, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("awaken"), ResurrectedKnightAnimations.awaken, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("throw"), ResurrectedKnightAnimations.Javelinthrow, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("stab_end"), ResurrectedKnightAnimations.stabEnd, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("shield_combo"), ResurrectedKnightAnimations.shieldCombo, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("synergy"), ResurrectedKnightAnimations.synergy3, ageInTicks, 1.0F);
    }

    private void applyHeadRotation(T pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
        this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = -pHeadPitch * ((float) Math.PI / 180F);
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