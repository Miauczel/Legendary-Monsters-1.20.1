// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn.AnnihilationPursuer.AnnihilationPursuerAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn.AnnihilationPursuer.AnnihilationPursuerAnimations2;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;


public class AnnihilationPursuerModel<T extends AnnihilationPursuerEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart coreBody;
    private final ModelPart upperBody;
    private final ModelPart neck;
    private final ModelPart jaw;
    private final ModelPart face;
    private final ModelPart toungue;
    private final ModelPart leftUpperArm;
    private final ModelPart forearm2;
    private final ModelPart fist2;
    private final ModelPart neck3;
    private final ModelPart head3;
    private final ModelPart rightUpperArm;
    private final ModelPart forearm5;
    private final ModelPart fist5;
    private final ModelPart sword;
    private final ModelPart neck2;
    private final ModelPart head2;
    private final ModelPart rightLowerArm;
    private final ModelPart forearm4;
    private final ModelPart fist4;
    private final ModelPart small_sword2;
    private final ModelPart leftLowerArm;
    private final ModelPart forearm3;
    private final ModelPart fist3;
    private final ModelPart shield;
    private final ModelPart right_leg;
    private final ModelPart lower_leg2;
    private final ModelPart left_leg;
    private final ModelPart lower_leg3;

    public AnnihilationPursuerModel(ModelPart root) {
        this.root = root.getChild("root");
        this.coreBody = this.root.getChild("coreBody");
        this.upperBody = this.coreBody.getChild("upperBody");
        this.neck = this.upperBody.getChild("neck");
        this.jaw = this.neck.getChild("jaw");
        this.face = this.jaw.getChild("face");
        this.toungue = this.jaw.getChild("toungue");
        this.leftUpperArm = this.upperBody.getChild("leftUpperArm");
        this.forearm2 = this.leftUpperArm.getChild("forearm2");
        this.fist2 = this.forearm2.getChild("fist2");
        this.neck3 = this.leftUpperArm.getChild("neck3");
        this.head3 = this.neck3.getChild("head3");
        this.rightUpperArm = this.upperBody.getChild("rightUpperArm");
        this.forearm5 = this.rightUpperArm.getChild("forearm5");
        this.fist5 = this.forearm5.getChild("fist5");
        this.sword = this.fist5.getChild("sword");
        this.neck2 = this.rightUpperArm.getChild("neck2");
        this.head2 = this.neck2.getChild("head2");
        this.rightLowerArm = this.coreBody.getChild("rightLowerArm");
        this.forearm4 = this.rightLowerArm.getChild("forearm4");
        this.fist4 = this.forearm4.getChild("fist4");
        this.small_sword2 = this.fist4.getChild("small_sword2");
        this.leftLowerArm = this.coreBody.getChild("leftLowerArm");
        this.forearm3 = this.leftLowerArm.getChild("forearm3");
        this.fist3 = this.forearm3.getChild("fist3");
        this.shield = this.forearm3.getChild("shield");
        this.right_leg = this.root.getChild("right_leg");
        this.lower_leg2 = this.right_leg.getChild("lower_leg2");
        this.left_leg = this.root.getChild("left_leg");
        this.lower_leg3 = this.left_leg.getChild("lower_leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.5F, -19.0F, -5.0F));

        PartDefinition coreBody = root.addOrReplaceChild("coreBody", CubeListBuilder.create().texOffs(106, 94).addBox(-5.5F, -20.0F, -5.5F, 9.0F, 22.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 11.0F, 3.5F));

        PartDefinition upperBody = coreBody.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(54, 67).addBox(-10.5F, -11.0F, -7.5F, 21.0F, 12.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(160, 82).mirror().addBox(-7.5F, -9.0F, 7.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 117).mirror().addBox(-6.5F, -20.0F, 9.5F, 0.0F, 26.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 117).addBox(6.5F, -20.0F, 9.5F, 0.0F, 26.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(160, 82).addBox(5.5F, -9.0F, 7.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -19.0F, -1.0F));

        PartDefinition neck = upperBody.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.9063F, -1.0774F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r1 = neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(142, 91).addBox(-2.5F, -8.0F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0937F, 3.5774F, -0.4363F, 0.0F, 0.0F));

        PartDefinition jaw = neck.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0858F, -10.7437F, 7.6345F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = jaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(104, 22).addBox(-7.5F, -7.5F, -7.5F, 15.0F, 7.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0858F, 1.75F, -4.0429F, 0.0F, -0.7854F, 0.0F));

        PartDefinition face = jaw.addOrReplaceChild("face", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 5.0F));

        PartDefinition cube_r3 = face.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(126, 64).mirror().addBox(-22.5F, -7.5F, -7.5F, 15.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0858F, 1.75F, -9.0429F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r4 = face.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(126, 64).addBox(7.5F, -7.5F, -7.5F, 15.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(104, 0).addBox(-7.5F, -7.5F, -7.5F, 15.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0858F, 1.75F, -9.0429F, 0.0F, -0.7854F, 0.0F));

        PartDefinition toungue = jaw.addOrReplaceChild("toungue", CubeListBuilder.create(), PartPose.offset(-0.4142F, -2.8882F, -3.1701F));

        PartDefinition toungue_r1 = toungue.addOrReplaceChild("toungue_r1", CubeListBuilder.create().texOffs(166, 97).addBox(-2.5F, -8.0F, -5.1F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.5383F, -0.887F, -0.6981F, 0.0F, 0.0F));

        PartDefinition leftUpperArm = upperBody.addOrReplaceChild("leftUpperArm", CubeListBuilder.create().texOffs(104, 44).mirror().addBox(-0.5F, -3.5F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(138, 142).mirror().addBox(0.5F, 5.5F, -3.5F, 6.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(160, 74).mirror().addBox(9.5F, -6.5F, 4.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(160, 74).mirror().addBox(9.5F, -6.5F, -4.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, -8.5F, 0.5F, 0.0F, 0.0F, -0.4363F));

        PartDefinition forearm2 = leftUpperArm.addOrReplaceChild("forearm2", CubeListBuilder.create().texOffs(0, 117).mirror().addBox(-3.0F, -0.5F, -4.5F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(52, 134).addBox(4.0F, -3.5F, 0.0F, 13.0F, 25.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 19.0F, 0.0F));

        PartDefinition fist2 = forearm2.addOrReplaceChild("fist2", CubeListBuilder.create().texOffs(24, 153).mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 17.5F, 0.0F));

        PartDefinition neck3 = leftUpperArm.addOrReplaceChild("neck3", CubeListBuilder.create(), PartPose.offset(-10.0F, -4.4063F, 0.4226F));

        PartDefinition head3 = neck3.addOrReplaceChild("head3", CubeListBuilder.create(), PartPose.offset(0.0858F, -6.3437F, 5.5345F));

        PartDefinition rightUpperArm = upperBody.addOrReplaceChild("rightUpperArm", CubeListBuilder.create().texOffs(104, 44).addBox(-9.5F, -3.5F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(138, 142).addBox(-6.5F, 5.5F, -3.5F, 6.0F, 13.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(160, 74).addBox(-16.5F, -6.5F, 4.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(160, 74).addBox(-16.5F, -6.5F, -4.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -8.5F, 0.5F, 0.0F, 0.0F, 0.4363F));

        PartDefinition forearm5 = rightUpperArm.addOrReplaceChild("forearm5", CubeListBuilder.create().texOffs(0, 117).addBox(-4.0F, -0.5F, -4.5F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(52, 134).mirror().addBox(-17.0F, -3.5F, 0.0F, 13.0F, 25.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 19.0F, 0.0F));

        PartDefinition fist5 = forearm5.addOrReplaceChild("fist5", CubeListBuilder.create().texOffs(24, 153).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.5F, 0.0F));

        PartDefinition sword = fist5.addOrReplaceChild("sword", CubeListBuilder.create(), PartPose.offsetAndRotation(1.6215F, 2.8648F, -1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r5 = sword.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(98, 149).addBox(1.2052F, -0.3418F, 4.0F, 0.0F, 11.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(126, 74).addBox(-0.2948F, 3.6582F, -10.0F, 3.0F, 3.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(1.2052F, -4.0918F, -60.0F, 0.0F, 15.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1215F, -0.1148F, 4.5F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r6 = sword.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(142, 114).addBox(-0.7199F, 7.9506F, -5.7469F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1215F, -0.1148F, 4.5F, -0.7854F, 0.0F, -0.9599F));

        PartDefinition neck2 = rightUpperArm.addOrReplaceChild("neck2", CubeListBuilder.create(), PartPose.offset(10.0F, -4.4063F, 0.4226F));

        PartDefinition head2 = neck2.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(-0.0858F, -6.3437F, 5.5345F));

        PartDefinition rightLowerArm = coreBody.addOrReplaceChild("rightLowerArm", CubeListBuilder.create().texOffs(138, 125).addBox(-7.5F, -3.5F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(144, 44).addBox(-6.5F, 5.5F, -3.5F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -10.5F, -1.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition forearm4 = rightLowerArm.addOrReplaceChild("forearm4", CubeListBuilder.create().texOffs(106, 125).addBox(-4.0F, -0.5F, -4.5F, 7.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 17.0F, 0.0F));

        PartDefinition fist4 = forearm4.addOrReplaceChild("fist4", CubeListBuilder.create().texOffs(24, 153).addBox(-3.5F, 0.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition small_sword2 = fist4.addOrReplaceChild("small_sword2", CubeListBuilder.create().texOffs(54, 94).addBox(0.0007F, -8.6667F, -32.3333F, 0.0F, 14.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(52, 159).addBox(-1.5003F, -0.6667F, -6.3333F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(120, 149).addBox(-0.0003F, -2.6667F, 2.6667F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5003F, 3.1667F, 1.8333F));

        PartDefinition leftLowerArm = coreBody.addOrReplaceChild("leftLowerArm", CubeListBuilder.create().texOffs(138, 125).mirror().addBox(-0.5F, -3.5F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 44).mirror().addBox(0.5F, 5.5F, -3.5F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -10.5F, -1.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition forearm3 = leftLowerArm.addOrReplaceChild("forearm3", CubeListBuilder.create().texOffs(106, 125).mirror().addBox(-3.0F, -0.5F, -4.5F, 7.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 17.0F, 0.0F));

        PartDefinition fist3 = forearm3.addOrReplaceChild("fist3", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition cube_r7 = fist3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(24, 153).mirror().addBox(-4.0F, -1.5F, -4.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 2.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition shield = forearm3.addOrReplaceChild("shield", CubeListBuilder.create(), PartPose.offset(5.75F, 7.0F, 0.0F));

        PartDefinition cube_r8 = shield.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(160, 114).addBox(0.25F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 67).addBox(-1.75F, -12.5F, -12.5F, 2.0F, 25.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 144).addBox(-2.5F, 0.0F, -2.5F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 10.0F, 2.35F));

        PartDefinition lower_leg2 = right_leg.addOrReplaceChild("lower_leg2", CubeListBuilder.create().texOffs(78, 134).addBox(-2.0F, -2.0F, -2.0F, 5.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 1.65F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 144).mirror().addBox(-3.5F, 0.0F, -2.5F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.5F, 10.0F, 2.35F));

        PartDefinition lower_leg3 = left_leg.addOrReplaceChild("lower_leg3", CubeListBuilder.create().texOffs(78, 134).mirror().addBox(-3.0F, -2.0F, -2.0F, 5.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 1.65F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    public void translateModel(PoseStack stack) {
        this.root.translateAndRotate(stack);
        this.coreBody.translateAndRotate(stack);
        this.upperBody.translateAndRotate(stack);
        this.leftUpperArm.translateAndRotate(stack);
        this.forearm2.translateAndRotate(stack);
        this.fist2.translateAndRotate(stack);

        //stack.mulPose(Axis.ZP.rotation(2));
        stack.translate(0.0f, 0.1f, 0.0f);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
        if (entity.getAttackState() == 0)
            this.animateWalk(AnnihilationPursuerAnimations.walk, limbSwing, limbSwingAmount, 1.5F, 4.0F);

        this.animate((entity).getAnimationState("idle"), AnnihilationPursuerAnimations.idle, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("idle2"), AnnihilationPursuerAnimations2.idle2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("idle1to2"), AnnihilationPursuerAnimations2.idle1toIdle2, ageInTicks, 1.0F);

        //this.animate(( entity).getAnimationState("stomp_combo"), AnnihilationPursuerAnimations.stompSlash2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("sleep"), AnnihilationPursuerAnimations.sleep, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("awaken"), AnnihilationPursuerAnimations.awaken, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("stomp_combo"), AnnihilationPursuerAnimations.stompSlashCut, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("stomp_combo_end"), AnnihilationPursuerAnimations2.stompSlashEnd, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("stomp_combo_teleport_end"), AnnihilationPursuerAnimations2.stompSlashTeleportEnd, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("single_slash_from"), AnnihilationPursuerAnimations.singleSlashFrom, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("single_slash_from_parry"), AnnihilationPursuerAnimations2.singleSlashFromParry3, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("single_slash_from_fail"), AnnihilationPursuerAnimations.singleSlashFromFail, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("single_slash"), AnnihilationPursuerAnimations.singleSlashCut, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("single_slash_double"), AnnihilationPursuerAnimations.singleSlashDouble, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("single_slash_fail"), AnnihilationPursuerAnimations.singleSlashEnd, ageInTicks, 1.0F);


        this.animate((entity).getAnimationState("grab_pre"), AnnihilationPursuerAnimations2.grabPre, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("grab_success"), AnnihilationPursuerAnimations.grabSuccess, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("grab_fail"), AnnihilationPursuerAnimations.grabFail, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("teleport_slam"), AnnihilationPursuerAnimations2.teleport_sword_slam2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("teleport_chase"), AnnihilationPursuerAnimations2.teleport_chase, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("teleport_chase_next"), AnnihilationPursuerAnimations2.grabPreChase, ageInTicks, 1.0F);


        this.animate((entity).getAnimationState("buckshot"), AnnihilationPursuerAnimations2.bucklerShootCut, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("buckshot_end"), AnnihilationPursuerAnimations2.BucklerShootEnd2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("buckshot_tp"), AnnihilationPursuerAnimations2.BucklerShootTp, ageInTicks, 1.0F);
        //this.animate(( entity).getAnimationState("single_slash"), AnnihilationPursuerAnimations.singleSlash, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("death"), AnnihilationPursuerAnimations2.death, ageInTicks, 1.0F);

    }


    private void applyHeadRotation(T pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
        this.jaw.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.jaw.xRot = pHeadPitch * ((float) Math.PI / 180F);
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