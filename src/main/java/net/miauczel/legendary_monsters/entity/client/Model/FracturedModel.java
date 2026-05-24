// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Fractured.FracturedAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class FracturedModel<T extends FracturedEntity> extends HierarchicalModel<T> {

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart rightArm3;
    private final ModelPart r_lowerarm;
    private final ModelPart r_handcuff;
    private final ModelPart r_c1;
    private final ModelPart r_c2;
    private final ModelPart fist;
    private final ModelPart thumb;
    private final ModelPart r_finger1;
    private final ModelPart r_finger2;
    private final ModelPart leftArm3;
    private final ModelPart l_lowerarm;
    private final ModelPart l_fist;
    private final ModelPart l_finger1;
    private final ModelPart l_thumb;
    private final ModelPart l_finger2;
    private final ModelPart l_handcuff;
    private final ModelPart l_c3;
    private final ModelPart l_c4;
    private final ModelPart lowerbody;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart jaw;

    public FracturedModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.rightArm3 = this.body.getChild("rightArm3");
        this.r_lowerarm = this.rightArm3.getChild("r_lowerarm");
        this.r_handcuff = this.r_lowerarm.getChild("r_handcuff");
        this.r_c1 = this.r_handcuff.getChild("r_c1");
        this.r_c2 = this.r_c1.getChild("r_c2");
        this.fist = this.r_lowerarm.getChild("fist");
        this.thumb = this.fist.getChild("thumb");
        this.r_finger1 = this.fist.getChild("r_finger1");
        this.r_finger2 = this.fist.getChild("r_finger2");
        this.leftArm3 = this.body.getChild("leftArm3");
        this.l_lowerarm = this.leftArm3.getChild("l_lowerarm");
        this.l_fist = this.l_lowerarm.getChild("l_fist");
        this.l_finger1 = this.l_fist.getChild("l_finger1");
        this.l_thumb = this.l_fist.getChild("l_thumb");
        this.l_finger2 = this.l_fist.getChild("l_finger2");
        this.l_handcuff = this.l_lowerarm.getChild("l_handcuff");
        this.l_c3 = this.l_handcuff.getChild("l_c3");
        this.l_c4 = this.l_c3.getChild("l_c4");
        this.lowerbody = this.body.getChild("lowerbody");
        this.neck = this.body.getChild("neck");
        this.head = this.neck.getChild("head");
        this.jaw = this.head.getChild("jaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 43).addBox(-5.5F, -4.5F, -1.4375F, 10.0F, 16.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(36, 43).addBox(-0.5F, -2.5F, 3.5625F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.5F, -0.0625F));

        PartDefinition rightArm3 = body.addOrReplaceChild("rightArm3", CubeListBuilder.create().texOffs(82, 22).addBox(-3.8375F, 0.1875F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.8125F, -6.6875F, 1.0625F));

        PartDefinition r_lowerarm = rightArm3.addOrReplaceChild("r_lowerarm", CubeListBuilder.create().texOffs(80, 42).addBox(-1.3667F, -0.525F, -1.975F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.4708F, 6.7125F, 0.975F));

        PartDefinition r_handcuff = r_lowerarm.addOrReplaceChild("r_handcuff", CubeListBuilder.create().texOffs(11, 16).addBox(-1.9167F, -0.525F, -1.625F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition r_c1 = r_handcuff.addOrReplaceChild("r_c1", CubeListBuilder.create().texOffs(15, 9).addBox(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7833F, 0.475F, 2.875F, -1.5272F, 0.0F, 0.0F));

        PartDefinition leftArm_r1 = r_c1.addOrReplaceChild("left Arm_r1", CubeListBuilder.create().texOffs(15, 9).addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition r_c2 = r_c1.addOrReplaceChild("r_c2", CubeListBuilder.create().texOffs(15, 9).addBox(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(15, 2).mirror().addBox(0.0F, -1.5F, 4.5F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, -0.6545F, 0.0F, 0.0F));

        PartDefinition left_Arm_r2 = r_c2.addOrReplaceChild("left_Arm_r2", CubeListBuilder.create().texOffs(15, 9).addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition fist = r_lowerarm.addOrReplaceChild("fist", CubeListBuilder.create().texOffs(5, 26).addBox(-0.55F, -0.2875F, -1.4625F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1833F, 6.7625F, -0.5125F));

        PartDefinition thumb = fist.addOrReplaceChild("thumb", CubeListBuilder.create().texOffs(19, 25).addBox(-0.75F, -1.0F, -1.25F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 24).addBox(0.25F, -1.0F, -0.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 0.7125F, -1.2125F, 0.0F, 0.0F, 0.4363F));

        PartDefinition r_finger1 = fist.addOrReplaceChild("r_finger1", CubeListBuilder.create().texOffs(18, 28).addBox(-0.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.05F, 2.7125F, -0.4625F));

        PartDefinition r_finger2 = fist.addOrReplaceChild("r_finger2", CubeListBuilder.create().texOffs(28, 28).addBox(-0.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.05F, 2.7125F, 1.5375F));

        PartDefinition leftArm3 = body.addOrReplaceChild("leftArm3", CubeListBuilder.create().texOffs(82, 22).mirror().addBox(-0.1535F, 0.1774F, -2.1812F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.8035F, -6.6774F, 1.2437F));

        PartDefinition l_lowerarm = leftArm3.addOrReplaceChild("l_lowerarm", CubeListBuilder.create().texOffs(80, 42).mirror().addBox(-2.3F, -0.1917F, -1.975F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.1465F, 6.369F, 0.7938F));

        PartDefinition l_fist = l_lowerarm.addOrReplaceChild("l_fist", CubeListBuilder.create().texOffs(5, 26).mirror().addBox(-0.45F, -0.2875F, -1.4625F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.15F, 7.0958F, -0.5125F));

        PartDefinition l_finger1 = l_fist.addOrReplaceChild("l_finger1", CubeListBuilder.create().texOffs(18, 28).mirror().addBox(-2.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.05F, 2.7125F, -0.4625F));

        PartDefinition l_thumb = l_fist.addOrReplaceChild("l_thumb", CubeListBuilder.create().texOffs(19, 25).mirror().addBox(-2.25F, -1.0F, -1.25F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(29, 24).mirror().addBox(-2.25F, -1.0F, -0.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.2F, 0.7125F, -1.2125F, 0.0F, 0.0F, -0.4363F));

        PartDefinition l_finger2 = l_fist.addOrReplaceChild("l_finger2", CubeListBuilder.create().texOffs(28, 28).mirror().addBox(-2.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.05F, 2.7125F, 1.5375F));

        PartDefinition l_handcuff = l_lowerarm.addOrReplaceChild("l_handcuff", CubeListBuilder.create().texOffs(11, 16).mirror().addBox(-3.0833F, -0.525F, -1.625F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3333F, 2.3333F, 0.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition l_c3 = l_handcuff.addOrReplaceChild("l_c3", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.7833F, 0.475F, 2.875F, -1.5272F, 0.0F, 0.0F));

        PartDefinition rightArm_r1 = l_c3.addOrReplaceChild("right Arm_r1", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 0.0F, 0.0F, -1.5708F));

        PartDefinition l_c4 = l_c3.addOrReplaceChild("l_c4", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(15, 2).mirror().addBox(0.0F, -1.5F, 4.5F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, -0.6545F, 0.0F, 0.0F));

        PartDefinition right_Arm_r2 = l_c4.addOrReplaceChild("right_Arm_r2", CubeListBuilder.create().texOffs(15, 9).mirror().addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 0.0F, 0.0F, -1.5708F));

        PartDefinition lowerbody = body.addOrReplaceChild("lowerbody", CubeListBuilder.create(), PartPose.offset(-0.5F, 11.3925F, 3.5625F));

        PartDefinition body_r1 = lowerbody.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(68, 72).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1075F, 0.0F, 0.8727F, 0.0F, 0.0F));

        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(-0.5F, -5.915F, 1.9613F));

        PartDefinition head_r1 = neck.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(45, 28).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.085F, 0.6012F, 0.0436F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 23).addBox(-4.5F, -7.1719F, -4.7104F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.9131F, -2.6884F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(47, 40).addBox(-4.5F, -0.1719F, -5.7104F, 9.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
        this.animate(entity.getAnimationState("idle"), FracturedAnimations.idle, ageInTicks, 1f);
        this.animate(entity.getAnimationState("sweep"), FracturedAnimations.sweep, ageInTicks, 1f);
        this.animate(entity.getAnimationState("grab_pre"), FracturedAnimations.grabPre, ageInTicks, 1f);
        this.animate(entity.getAnimationState("grab_fail"), FracturedAnimations.grabFail, ageInTicks, 1f);
        this.animate(entity.getAnimationState("grab_success"), FracturedAnimations.grabSuccess, ageInTicks, 1f);
        this.animate(entity.getAnimationState("death"), FracturedAnimations.death, ageInTicks, 1f);
       // float yawRad = MathUtils.radAngle(entity.yBodyRot);
      //  root.yRot = Mth.rotLerp(ageInTicks,entity.yRotO * MathUtils.PI / 180, yawRad);
       // root.yRot = MathUtils.lerpRad(1, entity.yRotO * MathUtils.PI / 180, yawRad);
    }


    private void applyHeadRotation(FracturedEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
        this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
         this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
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