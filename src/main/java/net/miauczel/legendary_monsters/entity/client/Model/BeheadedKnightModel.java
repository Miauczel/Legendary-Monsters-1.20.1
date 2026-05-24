package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.PossessedArmor.BeheadedKnight.BeheadedKnightAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.PossessedArmor.BeheadedKnight.BeheadedKnightAnimations2;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class BeheadedKnightModel<T extends BeheadedKnightEntity
        > extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart rotator;
    private final ModelPart core_body;
    private final ModelPart upper_body;
    private final ModelPart right_arm;
    private final ModelPart forearm;
    private final ModelPart fist;
    private final ModelPart broken_sword;
    private final ModelPart capes;
    private final ModelPart capeRight;
    private final ModelPart lowerCapeRight;
    private final ModelPart capeLeft;
    private final ModelPart lowerCapeLeft;
    private final ModelPart left_arm;
    private final ModelPart forearm7;
    private final ModelPart fist7;
    private final ModelPart ghostArmRoot;
    private final ModelPart ghostForeArm;
    private final ModelPart ghostFist;
    private final ModelPart ghost_spear;
    private final ModelPart lower_body;
    private final ModelPart right_leg;
    private final ModelPart lower_leg2;
    private final ModelPart left_leg2;
    private final ModelPart lower_leg4;

    public BeheadedKnightModel(ModelPart root) {
        this.root = root.getChild("root");
        this.rotator = this.root.getChild("rotator");
        this.core_body = this.rotator.getChild("core_body");
        this.upper_body = this.core_body.getChild("upper_body");
        this.right_arm = this.upper_body.getChild("right_arm");
        this.forearm = this.right_arm.getChild("forearm");
        this.fist = this.forearm.getChild("fist");
        this.broken_sword = this.fist.getChild("broken_sword");
        this.capes = this.upper_body.getChild("capes");
        this.capeRight = this.capes.getChild("capeRight");
        this.lowerCapeRight = this.capeRight.getChild("lowerCapeRight");
        this.capeLeft = this.capes.getChild("capeLeft");
        this.lowerCapeLeft = this.capeLeft.getChild("lowerCapeLeft");
        this.left_arm = this.upper_body.getChild("left_arm");
        this.forearm7 = this.left_arm.getChild("forearm7");
        this.fist7 = this.forearm7.getChild("fist7");
        this.ghostArmRoot = this.upper_body.getChild("ghostArmRoot");
        this.ghostForeArm = this.ghostArmRoot.getChild("ghostForeArm");
        this.ghostFist = this.ghostForeArm.getChild("ghostFist");
        this.ghost_spear = this.ghostFist.getChild("ghost_spear");
        this.lower_body = this.root.getChild("lower_body");
        this.right_leg = this.lower_body.getChild("right_leg");
        this.lower_leg2 = this.right_leg.getChild("lower_leg2");
        this.left_leg2 = this.lower_body.getChild("left_leg2");
        this.lower_leg4 = this.left_leg2.getChild("lower_leg4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.5F, 22.0F, -5.0F));

        PartDefinition rotator = root.addOrReplaceChild("rotator", CubeListBuilder.create(), PartPose.offset(-0.5F, -25.25F, 1.5F));

        PartDefinition core_body = rotator.addOrReplaceChild("core_body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r1 = core_body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(76, 122).addBox(-4.0F, -9.5F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.25F, 1.5F, 0.0F, -0.7854F, 0.0F));

        PartDefinition upper_body = core_body.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1429F, -18.1612F, 2.7561F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = upper_body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(72, 99).addBox(-6.0F, -4.5F, -7.0F, 12.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1429F, 1.9112F, -1.2561F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r3 = upper_body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(1, 74).addBox(-11.0F, -6.5F, -7.0F, 22.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1429F, -4.0888F, -1.2561F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r4 = upper_body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -7.0F, -9.5F, 12.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1429F, -11.5888F, -1.2561F, 0.7854F, 0.0F, 0.0F));

        PartDefinition right_arm = upper_body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.7806F, -6.0348F, 0.4994F, -0.4341F, -0.4073F, 0.1446F));

        PartDefinition cube_r5 = right_arm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(150, 115).addBox(-3.5F, -9.5F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.755F, 11.2452F, -0.0044F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r6 = right_arm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(26, 145).addBox(61.6767F, -24.343F, 5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(102, 0).addBox(50.6767F, -14.343F, -7.0F, 13.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(136, 32).addBox(61.6767F, -24.343F, -7.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 16).addBox(61.6767F, -26.343F, -7.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(148, 64).addBox(46.6767F, -30.343F, 0.0F, 15.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(125, 99).addBox(53.6767F, -12.343F, -5.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-66.4508F, 0.7324F, -0.0044F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r7 = right_arm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(34, 122).addBox(-9.6156F, -5.7509F, -5.0F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4508F, 1.7324F, -0.0044F, 0.0F, 0.0F, 0.3054F));

        PartDefinition forearm = right_arm.addOrReplaceChild("forearm", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.6782F, 14.6619F, -0.0044F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r8 = forearm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(205, 92).addBox(-3.5F, 6.5F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(96, 79).addBox(-12.7517F, 6.5F, 0.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(204, 65).addBox(-4.7517F, 6.5F, -4.0F, 8.0F, 19.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.46F, -6.3632F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition fist = forearm.addOrReplaceChild("fist", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.8237F, 17.6331F, -0.25F, -0.132F, 0.1298F, 0.1137F));

        PartDefinition cube_r9 = fist.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(177, 25).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5088F, 2.3813F, 0.25F, 0.0F, 0.0F, 0.1745F));

        PartDefinition broken_sword = fist.addOrReplaceChild("broken_sword", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.7447F, 2.9832F, -0.25F, 3.0309F, 0.0305F, 0.3392F));

        PartDefinition cube_r10 = broken_sword.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(130, 180).addBox(62.0706F, 25.0214F, 5.0F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(62.0706F, 17.0214F, -54.0F, 0.0F, 22.0F, 51.0F, new CubeDeformation(0.0F))
                .texOffs(110, 172).addBox(61.5658F, 24.0214F, -19.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(156, 0).addBox(60.5658F, 22.0214F, -10.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(34, 142).addBox(60.5658F, 27.0214F, -7.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-57.7957F, -36.5178F, 0.5F, 0.0F, 0.0F, 0.1309F));

        PartDefinition capes = upper_body.addOrReplaceChild("capes", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1429F, -3.7454F, 7.7066F, -0.2618F, 0.0F, 0.0F));

        PartDefinition capeRight = capes.addOrReplaceChild("capeRight", CubeListBuilder.create().texOffs(90, 152).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -0.9563F, -0.1047F));

        PartDefinition lowerCapeRight = capeRight.addOrReplaceChild("lowerCapeRight", CubeListBuilder.create().texOffs(20, 182).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition capeLeft = capes.addOrReplaceChild("capeLeft", CubeListBuilder.create().texOffs(66, 171).addBox(-4.5F, -0.3713F, -0.3211F, 9.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -0.5849F, 0.2163F));

        PartDefinition lowerCapeLeft = capeLeft.addOrReplaceChild("lowerCapeLeft", CubeListBuilder.create().texOffs(178, 60).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.6287F, -0.3211F));

        PartDefinition left_arm = upper_body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(10.3571F, -5.902F, -1.8307F, -0.3054F, 0.0F, 0.2618F));

        PartDefinition cube_r11 = left_arm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(150, 115).mirror().addBox(-2.5F, -9.5F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.9699F, 9.4602F, 0.2236F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r12 = left_arm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(26, 145).mirror().addBox(-63.6767F, -24.343F, 5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(102, 0).mirror().addBox(-63.6767F, -14.343F, -7.0F, 13.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(136, 32).mirror().addBox(-63.6767F, -24.343F, -7.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(136, 16).mirror().addBox(-63.6767F, -26.343F, -7.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(148, 64).mirror().addBox(-61.6767F, -30.343F, 0.0F, 15.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(125, 99).mirror().addBox(-63.6767F, -12.343F, -5.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(65.6656F, -1.0527F, 0.2236F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r13 = left_arm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(34, 122).mirror().addBox(-1.3844F, -5.7509F, -5.0F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6656F, -0.0527F, 0.2236F, 0.0F, 0.0F, -0.3054F));

        PartDefinition forearm7 = left_arm.addOrReplaceChild("forearm7", CubeListBuilder.create(), PartPose.offset(7.8931F, 12.8768F, 0.2236F));

        PartDefinition cube_r14 = forearm7.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(205, 92).mirror().addBox(-2.5F, 6.5F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(96, 79).mirror().addBox(4.7517F, 6.5F, 0.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(204, 65).mirror().addBox(-3.2483F, 6.5F, -4.0F, 8.0F, 19.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.46F, -6.3632F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition fist7 = forearm7.addOrReplaceChild("fist7", CubeListBuilder.create(), PartPose.offsetAndRotation(4.8237F, 17.6331F, -0.25F, 0.0F, 0.0F, 0.0436F));

        PartDefinition cube_r15 = fist7.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(177, 25).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5088F, 2.3813F, 0.25F, 0.0F, 0.0F, -0.3054F));

        PartDefinition ghostArmRoot = upper_body.addOrReplaceChild("ghostArmRoot", CubeListBuilder.create().texOffs(184, 148).addBox(-5.0F, -14.0F, -3.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.8571F, -10.5888F, -2.2561F));

        PartDefinition ghostForeArm = ghostArmRoot.addOrReplaceChild("ghostForeArm", CubeListBuilder.create(), PartPose.offset(-0.5F, -13.0F, 0.0F));

        PartDefinition cube_r16 = ghostForeArm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(133, 138).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.0F, -4.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition ghostFist = ghostForeArm.addOrReplaceChild("ghostFist", CubeListBuilder.create(), PartPose.offset(-0.4167F, -13.6743F, -7.6129F));

        PartDefinition cube_r17 = ghostFist.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(183, 194).addBox(-4.0F, -3.5F, -3.5F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0833F, -0.8791F, -2.6678F, 0.4363F, 0.0F, 0.0F));

        PartDefinition ghost_spear = ghostFist.addOrReplaceChild("ghost_spear", CubeListBuilder.create(), PartPose.offset(0.0833F, -1.1209F, -3.3322F));

        PartDefinition cube_r18 = ghost_spear.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(138, 226).addBox(-20.0F, -0.5F, -4.5F, 14.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(145, 234).addBox(7.0F, -0.5F, -6.5F, 47.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(174, 230).addBox(-10.0F, -1.5F, -1.5F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1667F, 0.2418F, 0.6645F, 0.4363F, 0.0F, 0.0F));

        PartDefinition lower_body = root.addOrReplaceChild("lower_body", CubeListBuilder.create(), PartPose.offset(-1.0F, -25.0F, 3.0F));

        PartDefinition right_leg = lower_body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(66, 151).addBox(-2.5F, 2.0F, -1.5F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -4.0F, -0.65F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r19 = right_leg.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(202, 16).addBox(-9.0F, -5.5F, 0.0F, 10.0F, 21.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(158, 154).addBox(-3.0F, -0.5F, -3.0F, 7.0F, 14.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.5F, 2.0F, 1.5F, 0.0F, 0.0F, 0.0873F));

        PartDefinition lower_leg2 = right_leg.addOrReplaceChild("lower_leg2", CubeListBuilder.create().texOffs(26, 158).addBox(-2.0F, 1.0F, -2.0F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(168, 0).addBox(-2.0F, 1.0F, -2.0F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 13.0F, 1.65F));

        PartDefinition left_leg2 = lower_body.addOrReplaceChild("left_leg2", CubeListBuilder.create().texOffs(66, 151).mirror().addBox(-3.5F, 2.0F, -1.5F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, -5.0F, -0.65F, -0.3696F, -0.4165F, -0.1223F));

        PartDefinition cube_r20 = left_leg2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(202, 16).mirror().addBox(-1.0F, -5.5F, 0.0F, 10.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(158, 154).mirror().addBox(-4.0F, -0.5F, -3.0F, 7.0F, 14.0F, 6.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.0F, 1.5F, 0.0F, 0.0F, -0.0873F));

        PartDefinition lower_leg4 = left_leg2.addOrReplaceChild("lower_leg4", CubeListBuilder.create().texOffs(26, 158).mirror().addBox(-3.0F, 1.0F, -2.0F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(168, 0).mirror().addBox(-3.0F, 1.0F, -2.0F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, 1.65F, 0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        if (entity.getAttackState() == 0 || entity.getAttackState() == 9)
            this.animateWalk(BeheadedKnightAnimations.walk2, limbSwing, limbSwingAmount, 1.0F, 4.0F);
        // }
        this.animate((entity).getAnimationState("idle"), BeheadedKnightAnimations.idle, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("uppercut"), BeheadedKnightAnimations.upperCut3, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("ghost_combo"), BeheadedKnightAnimations.headSlash_combo, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("ghost_uppercut"), BeheadedKnightAnimations.headUppercutTriple2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("stab_double"), BeheadedKnightAnimations.stabDouble, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("stab"), BeheadedKnightAnimations.stab3, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("death"), BeheadedKnightAnimations.death, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("sleep"), BeheadedKnightAnimations.sleep, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("awaken"), BeheadedKnightAnimations.awaken, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("synergy"), BeheadedKnightAnimations2.synergy5, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("grab_and_throw"), BeheadedKnightAnimations2.grabAndThrowCut, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("grab_and_throw_success"), BeheadedKnightAnimations2.grabAndThrowSuccess2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("grab_and_throw_fail"), BeheadedKnightAnimations2.grabAndThrowFail, ageInTicks, 1.0F);


    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

    }
    public void translateModel(PoseStack matrix){
        root.translateAndRotate(matrix);
        rotator.translateAndRotate(matrix);
        core_body.translateAndRotate(matrix);
        upper_body.translateAndRotate(matrix);
        left_arm.translateAndRotate(matrix);
        forearm7.translateAndRotate(matrix);
        fist7.translateAndRotate(matrix);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}