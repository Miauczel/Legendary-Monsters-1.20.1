package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.TheObliterator.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class TheObliteratorModel<T extends TheObliteratorEntity> extends HierarchicalModel<T> {
    public final ModelPart root;
    private final ModelPart legflower;
    private final ModelPart bigRing;
    private final ModelPart bone;
    private final ModelPart body_neutral_rotation;
    public final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart main_rotator2;
    private final ModelPart shoulder_left;
    private final ModelPart forearm_left;
    private final ModelPart finger_left;
    private final ModelPart ultimate_flame;
    private final ModelPart blade;
    private final ModelPart big_half;
    private final ModelPart small_half;
    private final ModelPart right_arm;
    private final ModelPart main_rotator;
    private final ModelPart shoulder_right;
    private final ModelPart forearm_right;
    private final ModelPart blade2;
    private final ModelPart small_half2;
    private final ModelPart big_half2;
    private final ModelPart finger_right;
    public final ModelPart big_cube;
    private final ModelPart inner_cube_body;
    public final ModelPart the_eye;
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
    private final ModelPart upper_part;
    private final ModelPart cube_front_top_left;
    private final ModelPart cube_front_top_right;
    private final ModelPart cube_back_top_right;
    private final ModelPart cube_back_top_left;
    private final ModelPart lower_part;
    private final ModelPart cune_front_down_left;
    private final ModelPart cube_front_down_right;
    private final ModelPart cube_back_down_left;
    private final ModelPart cube_back_down_right;
    private final ModelPart power_ball;

    public TheObliteratorModel(ModelPart root) {
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
        this.ultimate_flame = this.finger_left.getChild("ultimate_flame");
        this.blade = this.forearm_left.getChild("blade");
        this.big_half = this.blade.getChild("big_half");
        this.small_half = this.blade.getChild("small_half");
        this.right_arm = this.body.getChild("right_arm");
        this.main_rotator = this.right_arm.getChild("main_rotator");
        this.shoulder_right = this.main_rotator.getChild("shoulder_right");
        this.forearm_right = this.shoulder_right.getChild("forearm_right");
        this.blade2 = this.forearm_right.getChild("blade2");
        this.small_half2 = this.blade2.getChild("small_half2");
        this.big_half2 = this.blade2.getChild("big_half2");
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
        this.upper_part = this.big_cube.getChild("upper_part");
        this.cube_front_top_left = this.upper_part.getChild("cube_front_top_left");
        this.cube_front_top_right = this.upper_part.getChild("cube_front_top_right");
        this.cube_back_top_right = this.upper_part.getChild("cube_back_top_right");
        this.cube_back_top_left = this.upper_part.getChild("cube_back_top_left");
        this.lower_part = this.big_cube.getChild("lower_part");
        this.cune_front_down_left = this.lower_part.getChild("cune_front_down_left");
        this.cube_front_down_right = this.lower_part.getChild("cube_front_down_right");
        this.cube_back_down_left = this.lower_part.getChild("cube_back_down_left");
        this.cube_back_down_right = this.lower_part.getChild("cube_back_down_right");
        this.power_ball = this.body.getChild("power_ball");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -31.0F, 0.0F));

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

        PartDefinition ultimate_flame = finger_left.addOrReplaceChild("ultimate_flame", CubeListBuilder.create().texOffs(294, 194).addBox(2.0F, -9.5F, -50.0F, 0.0F, 19.0F, 100.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.1F, 8.9F, -0.95F));

        PartDefinition cube_r1 = ultimate_flame.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(294, 194).addBox(0.0F, -11.5F, -50.0F, 0.0F, 19.0F, 100.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition blade = forearm_left.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(256, 0).addBox(3.375F, -10.25F, -2.0F, 11.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(160, 253).addBox(-0.625F, -6.25F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.125F, 13.25F, -0.5F));

        PartDefinition big_half = blade.addOrReplaceChild("big_half", CubeListBuilder.create().texOffs(288, 175).addBox(-9.5F, -1.0F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(8.875F, 8.75F, 0.0F));

        PartDefinition cube_r2 = big_half.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(236, 325).addBox(-9.5F, -13.0F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition small_half = blade.addOrReplaceChild("small_half", CubeListBuilder.create().texOffs(156, 29).addBox(-9.5F, -15.0F, 0.0F, 19.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(8.875F, -9.25F, 0.0F));

        PartDefinition cube_r3 = small_half.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(236, 309).addBox(-9.5F, -8.0F, 0.0F, 19.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-46.6F, -36.0F, -3.8F, 0.0F, 0.0F, 0.3054F));

        PartDefinition main_rotator = right_arm.addOrReplaceChild("main_rotator", CubeListBuilder.create(), PartPose.offset(0.0582F, -9.4504F, -0.2F));

        PartDefinition shoulder_right = main_rotator.addOrReplaceChild("shoulder_right", CubeListBuilder.create().texOffs(288, 64).mirror().addBox(-5.7F, 1.3F, -6.2F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(288, 32).mirror().addBox(-7.7F, -16.7F, -7.2F, 16.0F, 18.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(288, 143).mirror().addBox(-26.7F, -32.7F, -4.2F, 19.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(288, 143).mirror().addBox(-26.7F, -32.7F, 3.8F, 19.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.0582F, 9.4504F, 0.2F));

        PartDefinition forearm_right = shoulder_right.addOrReplaceChild("forearm_right", CubeListBuilder.create().texOffs(236, 269).mirror().addBox(-7.5F, 0.0F, -7.5F, 15.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 16.6F, 0.25F, 0.0F, 0.0F, -0.3927F));

        PartDefinition blade2 = forearm_right.addOrReplaceChild("blade2", CubeListBuilder.create().texOffs(160, 253).mirror().addBox(-3.375F, -6.25F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(256, 0).mirror().addBox(-14.375F, -10.25F, -2.0F, 11.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.125F, 13.25F, -0.5F));

        PartDefinition small_half2 = blade2.addOrReplaceChild("small_half2", CubeListBuilder.create().texOffs(156, 29).mirror().addBox(-9.5F, -15.0F, 0.0F, 19.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.875F, -9.25F, 0.0F));

        PartDefinition cube_r4 = small_half2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(236, 309).mirror().addBox(-9.5F, -8.0F, 0.0F, 19.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition big_half2 = blade2.addOrReplaceChild("big_half2", CubeListBuilder.create().texOffs(288, 175).mirror().addBox(-9.5F, -1.0F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.875F, 8.75F, 0.0F));

        PartDefinition cube_r5 = big_half2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(236, 325).mirror().addBox(-9.5F, -13.0F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

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

        PartDefinition upper_part = big_cube.addOrReplaceChild("upper_part", CubeListBuilder.create(), PartPose.offset(1.0F, -42.0F, -4.0F));

        PartDefinition cube_front_top_left = upper_part.addOrReplaceChild("cube_front_top_left", CubeListBuilder.create().texOffs(104, 45).addBox(-3.0F, -5.0F, -23.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -9.0F, -8.0F));

        PartDefinition cube_r6 = cube_front_top_left.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(288, 119).mirror().addBox(-1.4142F, 0.0F, -1.4142F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(25.0F, -5.0F, -23.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_front_top_right = upper_part.addOrReplaceChild("cube_front_top_right", CubeListBuilder.create().texOffs(104, 97).addBox(-23.0F, -5.0F, -23.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -9.0F, -8.0F));

        PartDefinition cube_r7 = cube_front_top_right.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(288, 119).addBox(-23.0F, 0.0F, 0.0F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, -5.0F, -23.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_back_top_right = upper_part.addOrReplaceChild("cube_back_top_right", CubeListBuilder.create().texOffs(0, 149).addBox(-23.0F, -5.0F, -3.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -9.0F, 8.0F));

        PartDefinition cube_r8 = cube_back_top_right.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(288, 119).addBox(-21.5858F, 0.0F, 1.4142F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, -5.0F, 23.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_back_top_left = upper_part.addOrReplaceChild("cube_back_top_left", CubeListBuilder.create().texOffs(104, 149).addBox(-3.0F, -5.0F, -3.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -9.0F, 8.0F));

        PartDefinition cube_r9 = cube_back_top_left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(288, 119).mirror().addBox(-1.4142F, 0.0F, 1.4142F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(25.0F, -5.0F, 23.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition lower_part = big_cube.addOrReplaceChild("lower_part", CubeListBuilder.create(), PartPose.offset(1.0F, -9.0F, -4.0F));

        PartDefinition cune_front_down_left = lower_part.addOrReplaceChild("cune_front_down_left", CubeListBuilder.create().texOffs(0, 97).addBox(-2.0F, -20.0F, -23.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 8.0F, -8.0F));

        PartDefinition cube_r10 = cune_front_down_left.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(288, 201).mirror().addBox(-1.0F, -19.0F, -1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(25.4142F, 6.0F, -23.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_front_down_right = lower_part.addOrReplaceChild("cube_front_down_right", CubeListBuilder.create().texOffs(0, 45).addBox(-23.0F, -21.0F, -23.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 9.0F, -8.0F));

        PartDefinition cube_r11 = cube_front_down_right.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(288, 201).addBox(-7.0F, -19.0F, -1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.4142F, 5.0F, -23.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_back_down_left = lower_part.addOrReplaceChild("cube_back_down_left", CubeListBuilder.create().texOffs(0, 201).addBox(-2.0F, -20.0F, -3.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 8.0F, 8.0F));

        PartDefinition cube_r12 = cube_back_down_left.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(288, 201).mirror().addBox(-1.0F, -19.0F, 1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(25.4142F, 6.0F, 23.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_back_down_right = lower_part.addOrReplaceChild("cube_back_down_right", CubeListBuilder.create().texOffs(104, 201).addBox(-23.0F, -21.0F, -3.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 9.0F, 8.0F));

        PartDefinition cube_r13 = cube_back_down_right.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(288, 201).addBox(-7.0F, -19.0F, 1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.4142F, 5.0F, 23.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition power_ball = body.addOrReplaceChild("power_ball", CubeListBuilder.create().texOffs(354, 4).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(348, 36).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(2.0F)), PartPose.offset(0.0F, -24.0F, -27.0F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    public void translateModelToRightArm(PoseStack poseStack) {
        this.root.translateAndRotate(poseStack);
        this.body_neutral_rotation.translateAndRotate(poseStack);
        this.body.translateAndRotate(poseStack);

        this.right_arm.translateAndRotate(poseStack);
        this.main_rotator.translateAndRotate(poseStack);
        this.shoulder_right.translateAndRotate(poseStack);
        this.forearm_right.translateAndRotate(poseStack);
        this.finger_right.translateAndRotate(poseStack);

        poseStack.mulPose(Axis.YP.rotationDegrees(90));
    }

    public void translateModelToLeftArm(PoseStack poseStack) {
        this.root.translateAndRotate(poseStack);
        this.body_neutral_rotation.translateAndRotate(poseStack);
        this.body.translateAndRotate(poseStack);
        this.left_arm.translateAndRotate(poseStack);
        this.main_rotator2.translateAndRotate(poseStack);
        this.shoulder_left.translateAndRotate(poseStack);
        this.forearm_left.translateAndRotate(poseStack);
        this.finger_left.translateAndRotate(poseStack);

        poseStack.mulPose(Axis.YP.rotationDegrees(90));
    }


    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

        this.animate(entity.getAnimationState("idle"), TheObliteratorAnimations.idle, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("spin_smash"), TheObliteratorAnimations3.rightSpinSmash2, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("spin_smash_left"), TheObliteratorAnimations3.leftArmSpinSmash2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("shoot_double"), TheObliteratorAnimations.powerBallShootDouble, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("shoot_once"), TheObliteratorAnimations9.powerBallShootPre2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("shoot_once_end"), TheObliteratorAnimations9.PowerBallShootEnd, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("shoot_double_end"), TheObliteratorAnimations9.PowerBallShootDoubleEnd, ageInTicks, 1.0F);


        this.animate(entity.getAnimationState("left_hook_db_combo"), TheObliteratorAnimations.LeftHookComboFaster, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("roar_teleport"), TheObliteratorAnimations.roarTPNew, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("land"), TheObliteratorAnimations.land, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("land_again"), TheObliteratorAnimations13.landTeleport, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("fall"), TheObliteratorAnimations.fall, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("ambush"), TheObliteratorAnimations14.ambush2, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("ambush_longer"), TheObliteratorAnimations14.ambushCut2, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("ambush_swap"), TheObliteratorAnimations14.ambushReinforced, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("slash_combo_right"), TheObliteratorAnimations10.SlashComboRight2, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("slash_combo"), TheObliteratorAnimations10.SlashComboLeft2, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("teleport_slash_combo"), TheObliteratorAnimations10.teleportSlashComboLeftSlower5, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("teleport_slash_combo_right"), TheObliteratorAnimations10.teleportSlashComboRightSlower4, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("teleport_uppercut"), TheObliteratorAnimations2.teleportUppercut, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("teleport_grab_pre"), TheObliteratorAnimations2.teleportGrabPre, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("teleport_grab_success"), TheObliteratorAnimations2.teleportGrabSuccess, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("teleport_grab_fall"), TheObliteratorAnimations2.teleportGrabFall, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("teleport_grab_land"), TheObliteratorAnimations12.teleportGrabLand, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("teleport_grab_fail_rise_up"), TheObliteratorAnimations2.teleport_grab_fail_rise_up, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("teleport_grab_fail_cross_slash"), TheObliteratorAnimations13.tpGrabFail2, ageInTicks, 1.0F);//4

        this.animate(entity.getAnimationState("teleport_grab_fail_0"), TheObliteratorAnimations14.tpGrabFail4, ageInTicks, 1.0F);//4

        this.animate(entity.getAnimationState("jump_teleport"), TheObliteratorAnimations13.jumpTeleport6, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("clone_burst_grab"), TheObliteratorAnimations2.clone_burst_grab_failNew, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("kick_smash_grab"), TheObliteratorAnimations3.kick_smash_grab, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("right_spin_teleport_smash"), TheObliteratorAnimations3.rightSpinTeleportSmash, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("backstep_teleport_slash_p2"), TheObliteratorAnimations3.teleportTrackingBallsP2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("backstep_stomp_left"), TheObliteratorAnimations12.backstep_left_stomp, ageInTicks, 1.0F);//5

        this.animate(entity.getAnimationState("backstep_stomp_right"), TheObliteratorAnimations12.backstep_right_stomp, ageInTicks, 1.0F);//5


        this.animate(entity.getAnimationState("tracking_ball_charge"), TheObliteratorAnimations4.trackingBallCharge, ageInTicks, 1.0F);


        this.animate(entity.getAnimationState("stomp"), TheObliteratorAnimations4.stomp_main, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("stomp_stun_teleport"), TheObliteratorAnimations13.stun_after_stompNew3
                , ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("stomp_kick"), TheObliteratorAnimations14.kick_after_stomp_new3, ageInTicks, 1.0F);//4 // 11

        this.animate(entity.getAnimationState("stomp_after_kick_right"), TheObliteratorAnimations4.stomp_after_kick_stomp_right1, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("stomp_after_kick_left"), TheObliteratorAnimations4.stomp_after_kick_stomp_left, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("spawn"), TheObliteratorAnimations13.spawn3, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("death"), TheObliteratorAnimations13.death5, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("p2"), TheObliteratorAnimations6.p2New, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("kick_smash"), TheObliteratorAnimations11.kick_smash_no_grab2, ageInTicks, 1.0F);//5
        this.animate(entity.getAnimationState("grab_after_kick_smash"), TheObliteratorAnimations6.grab_after_kick_smash_cut, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("kick_smash_bye_bye"), TheObliteratorAnimations10.kick_smash_bye_bye3, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("teleport_grab_after_kick_smash"), TheObliteratorAnimations5.teleport_grab_after_kick_smash_cut, ageInTicks, 1);

        this.animate(entity.getAnimationState("crush_grab_success"), TheObliteratorAnimations9.crushGrabSuccessThrowRight, ageInTicks, 1.0F);//5

        this.animate(entity.getAnimationState("crush_grab_fail"), TheObliteratorAnimations5.crush_grab_fail, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("single_shot_laser"), TheObliteratorAnimations10.singleLaserShot2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("single_shot_laser_end"), TheObliteratorAnimations9.singleShotLaserEnd2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("single_shot_laser_teleport_end"), TheObliteratorAnimations9.singleShotLaserTeleportEnd2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("single_shot_laser_after_stomp"), TheObliteratorAnimations6.single_shot_laser_after_stomp, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("teleport_away_single_shot_laser"), TheObliteratorAnimations10.teleportAwaySingleLaserShot2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("single_shot_laser_quad_end"), TheObliteratorAnimations11.singleShotLaserQuadEndVariant2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("close_pre_teleport_grab"), TheObliteratorAnimations7.close_teleport_grab_pre, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("backstep_stomp_right_spin"), TheObliteratorAnimations7.backstep_stomp_right_spin, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("p3"), TheObliteratorAnimations7.p3_2, ageInTicks, 1.0F);


        this.animate(entity.getAnimationState("left_grab_after_kick_smash"), TheObliteratorAnimations7.left_grab_after_kick_smash, ageInTicks, 1.0F);
        this.animate(entity.getAnimationState("left_crush_grab_success"), TheObliteratorAnimations9.crushGrabSuccessThrowLeft, ageInTicks, 1.0F);//7

        this.animate(entity.getAnimationState("left_crush_grab_fail"), TheObliteratorAnimations7.left_crush_grab_fail, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("arm_block"), TheObliteratorAnimations8.block, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("ultimate"), TheObliteratorAnimations8.UltimateFlame12, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("parry_pre"), TheObliteratorAnimations14.parryPre2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("parry_frame"), TheObliteratorAnimations14.parryFrame2, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("parry_fail"), TheObliteratorAnimations14.parryFail, ageInTicks, 1.0F);

        this.animate(entity.getAnimationState("parry_success"), TheObliteratorAnimations14.parrySuccess4, ageInTicks, 1.0F);//12

        //  the_eye.setPos((float) entity.eyeVec.x, (float) entity.eyeVec.y, (float) entity.eyeVec.z);

    }


    private void applyHeadRotation(TheObliteratorEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
        this.the_eye.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.the_eye.xRot = pHeadPitch * ((float) Math.PI / 180F);
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
