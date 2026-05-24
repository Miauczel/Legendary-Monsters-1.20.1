package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn.FlamebornGuardAnimations;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.PossessedArmor.PossessedPaladin.*;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.animations.PPAnims;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class NewPossessedPaladinModel<T extends PossessedPaladinEntity
        > extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart lowerbody;
    private final ModelPart body;
    private final ModelPart cape;
    private final ModelPart lower;
    private final ModelPart GimbalRotator;
    private final ModelPart rightArm;
    private final ModelPart lowerarm2;
    private final ModelPart sword;
    private final ModelPart SoulGreatSword;
    private final ModelPart bone;
    private final ModelPart leftArm;
    private final ModelPart lowerarm;
    private final ModelPart bone2;
    private final ModelPart shield;
    private final ModelPart trident;
    private final ModelPart dagger;
    private final ModelPart head;
    private final ModelPart RightWing;
    private final ModelPart RightWingEdge;
    private final ModelPart LeftWing;
    private final ModelPart LeftWingEdge;
    private final ModelPart legs;
    private final ModelPart rightLeg;
    private final ModelPart middleright;
    private final ModelPart lowerlegright;
    private final ModelPart leftLeg;
    private final ModelPart middle;
    private final ModelPart lowerleg;

    public NewPossessedPaladinModel(ModelPart root) {
        this.root = root.getChild("root");
        this.lowerbody = this.root.getChild("lowerbody");
        this.body = this.lowerbody.getChild("body");
        this.cape = this.body.getChild("cape");
        this.lower = this.cape.getChild("lower");
        this.GimbalRotator = this.body.getChild("GimbalRotator");
        this.rightArm = this.GimbalRotator.getChild("rightArm");
        this.lowerarm2 = this.rightArm.getChild("lowerarm2");
        this.sword = this.lowerarm2.getChild("sword");
        this.SoulGreatSword = this.sword.getChild("SoulGreatSword");
        this.bone = this.SoulGreatSword.getChild("bone");
        this.leftArm = this.body.getChild("leftArm");
        this.lowerarm = this.leftArm.getChild("lowerarm");
        this.bone2 = this.lowerarm.getChild("bone2");
        this.shield = this.bone2.getChild("shield");
        this.trident = this.lowerarm.getChild("trident");
        this.dagger = this.lowerarm.getChild("dagger");
        this.head = this.body.getChild("head");
        this.RightWing = this.body.getChild("RightWing");
        this.RightWingEdge = this.RightWing.getChild("RightWingEdge");
        this.LeftWing = this.body.getChild("LeftWing");
        this.LeftWingEdge = this.LeftWing.getChild("LeftWingEdge");
        this.legs = this.root.getChild("legs");
        this.rightLeg = this.legs.getChild("rightLeg");
        this.middleright = this.rightLeg.getChild("middleright");
        this.lowerlegright = this.middleright.getChild("lowerlegright");
        this.leftLeg = this.legs.getChild("leftLeg");
        this.middle = this.leftLeg.getChild("middle");
        this.lowerleg = this.middle.getChild("lowerleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition lowerbody = root.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(32, 32).addBox(-4.0F, -11.6F, -1.95F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.6F, -0.05F));

        PartDefinition body_r1 = lowerbody.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(40, 48).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.2F, 3.55F, -1.7453F, 0.0F, -3.1416F));

        PartDefinition body_r2 = lowerbody.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(40, 48).addBox(-2.0F, -1.0F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.8F, -2.65F, 1.2654F, 0.0F, 0.0F));

        PartDefinition body = lowerbody.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -6.9256F, 0.2626F));

        PartDefinition upper_r1 = body.addOrReplaceChild("upper_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.6744F, -0.2126F, -0.48F, 0.0F, 0.0F));

        PartDefinition cape = body.addOrReplaceChild("cape", CubeListBuilder.create(), PartPose.offset(0.0F, -4.4884F, 4.7197F));

        PartDefinition cape_r1 = cape.addOrReplaceChild("cape_r1", CubeListBuilder.create().texOffs(0, 45).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

        PartDefinition lower = cape.addOrReplaceChild("lower", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.001F));

        PartDefinition lower_r1 = lower.addOrReplaceChild("lower_r1", CubeListBuilder.create().texOffs(0, 57).addBox(-5.0F, 0.0981F, 0.2321F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0316F, -0.2509F, 0.5236F, 0.0F, 0.0F));

        PartDefinition GimbalRotator = body.addOrReplaceChild("GimbalRotator", CubeListBuilder.create(), PartPose.offset(-7.0209F, -4.9328F, -1.2134F));

        PartDefinition rightArm = GimbalRotator.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(56, 24).mirror().addBox(-1.9791F, -1.7416F, -1.9992F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.6706F, 0.6951F, -0.3196F));

        PartDefinition rightArm_r1 = rightArm.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(20, 48).mirror().addBox(-5.0F, -1.0F, 0.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0209F, -1.2416F, -2.4992F, 0.0F, 0.0F, 0.3927F));

        PartDefinition lowerarm2 = rightArm.addOrReplaceChild("lowerarm2", CubeListBuilder.create().texOffs(56, 35).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0209F, 5.2584F, 0.0008F, -1.6581F, 0.0F, 0.0F));

        PartDefinition leftArm_r1 = lowerarm2.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(54, 16).mirror().addBox(-4.0F, -2.366F, 0.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 3.9F, -2.5F, 0.0F, 0.0F, 0.5236F));

        PartDefinition sword = lowerarm2.addOrReplaceChild("sword", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.6681F, 2.5F, 1.5708F, 0.0F, -1.5708F));

        PartDefinition SoulGreatSword = sword.addOrReplaceChild("SoulGreatSword", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.7765F, -0.2034F, 0.0F, -1.5708F, 0.7854F));

        PartDefinition bone = SoulGreatSword.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(78, 73).addBox(0.01F, -3.5F, -16.0F, 1.975F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(78, 31).addBox(1.0F, -48.5F, -18.5F, 0.0F, 35.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(110, 57).addBox(-0.5F, -5.5F, -16.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(92, 37).addBox(-0.4765F, -8.5F, -19.5F, 2.975F, 3.0F, 9.0F, new CubeDeformation(-0.0005F))
                .texOffs(92, 63).addBox(1.0F, -9.5F, -25.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(106, 71).addBox(-0.001F, -12.499F, -17.999F, 2.0F, 3.998F, 5.998F, new CubeDeformation(-0.1F))
                .texOffs(90, 69).addBox(1.0F, -9.5F, -11.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 14.6083F, 6.7034F, -0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(92, 49).addBox(-1.5F, -3.5F, -3.5F, 2.0F, 7.0F, 7.0F, new CubeDeformation(0.025F)), PartPose.offsetAndRotation(1.5F, -12.0F, -15.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(106, 63).addBox(-1.502F, -2.002F, -2.002F, 3.004F, 4.004F, 4.004F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.35F, -15.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(110, 49).addBox(-1.002F, -2.501F, -1.501F, 2.002F, 4.002F, 4.002F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(1.0F, 3.6213F, -15.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(56, 24).addBox(-2.0209F, -1.7416F, -1.9992F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(7.0209F, -4.9328F, -1.2134F, 0.2679F, 0.2106F, -0.0736F));

        PartDefinition leftArm_r2 = leftArm.addOrReplaceChild("leftArm_r2", CubeListBuilder.create().texOffs(20, 48).addBox(0.0F, -1.0F, 0.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0209F, -1.2416F, -2.4992F, 0.0F, 0.0F, -0.3927F));

        PartDefinition lowerarm = leftArm.addOrReplaceChild("lowerarm", CubeListBuilder.create().texOffs(56, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0209F, 5.2584F, 0.0008F, -0.7854F, 0.0F, 0.0F));

        PartDefinition rightArm_r2 = lowerarm.addOrReplaceChild("rightArm_r2", CubeListBuilder.create().texOffs(54, 16).addBox(-1.0F, -2.366F, 0.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.9F, -2.5F, 0.0F, 0.0F, -0.5236F));

        PartDefinition bone2 = lowerarm.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(1.9072F, 8.2885F, 1.1982F));

        PartDefinition shield = bone2.addOrReplaceChild("shield", CubeListBuilder.create().texOffs(28, 83).addBox(-1.75F, -14.0F, -3.25F, 9.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -1.5249F, 0.1168F, 2.9594F));

        PartDefinition cube_r4 = shield.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 113).addBox(-6.0F, -1.0F, -4.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0258F, 1.6803F, -0.7854F, 0.0F, -1.5708F));

        PartDefinition cube_r5 = shield.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(2, 83).addBox(-5.0F, -27.0F, -1.0F, 11.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, 13.0F, 2.75F, 0.0F, 1.5708F, 0.0F));

        PartDefinition trident = lowerarm.addOrReplaceChild("trident", CubeListBuilder.create().texOffs(71, 124).addBox(-1.0F, -1.0F, -23.0F, 2.0F, 2.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(72, 126).addBox(0.0F, -14.5F, -60.0F, 0.0F, 29.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition cube_r6 = trident.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(112, 149).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r7 = trident.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, 3.1416F, 0.0F, 1.5708F));

        PartDefinition cube_r8 = trident.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 25.0F, 3.1416F, 0.0F, 1.5708F));

        PartDefinition cube_r9 = trident.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r10 = trident.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.0F, -3.1416F, 0.0F, 0.0F));

        PartDefinition dagger = lowerarm.addOrReplaceChild("dagger", CubeListBuilder.create().texOffs(113, 82).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(106, 81).addBox(-1.5F, -12.0F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(114, 90).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(112, 87).addBox(-4.5F, -4.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(106, 90).addBox(0.5F, -4.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.5595F, -0.087F, -1.5277F));

        PartDefinition cube_r11 = dagger.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(109, 93).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-0.0349F, -5.7577F, -0.4667F));

        PartDefinition cube_r12 = head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(34, 16).addBox(-2.0F, -6.0F, -2.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(20, 45).addBox(-0.5F, -9.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 28).addBox(-1.0F, -8.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-3.0F, -7.0F, -3.0F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0349F, -1.9167F, -0.746F, 0.0F, -0.829F, 0.0F));

        PartDefinition cube_r13 = head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 32).addBox(-1.7319F, -12.5F, -0.682F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7332F, -11.4167F, 0.636F, 0.0F, -1.5708F, 0.0F));

        PartDefinition RightWing = body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(0, 96).addBox(0.0F, -14.5F, 0.0F, 0.0F, 33.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1744F, 2.7874F, 0.0F, -1.3963F, 0.0F));

        PartDefinition RightWingEdge = RightWing.addOrReplaceChild("RightWingEdge", CubeListBuilder.create().texOffs(0, 127).addBox(0.0F, -14.5F, 0.0F, 0.0F, 33.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 25.0F));

        PartDefinition LeftWing = body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(0, 96).mirror().addBox(0.0F, -14.5F, 0.0F, 0.0F, 33.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1744F, 2.7874F, 0.0F, 1.3963F, 0.0F));

        PartDefinition LeftWingEdge = LeftWing.addOrReplaceChild("LeftWingEdge", CubeListBuilder.create().texOffs(0, 127).mirror().addBox(0.0F, -14.5F, 0.0F, 0.0F, 33.0F, 33.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 25.0F));

        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 1.0F));

        PartDefinition rightLeg = legs.addOrReplaceChild("rightLeg", CubeListBuilder.create(), PartPose.offset(-2.9F, 0.0F, 0.0F));

        PartDefinition upper_r2 = rightLeg.addOrReplaceChild("upper_r2", CubeListBuilder.create().texOffs(40, 55).mirror().addBox(-1.5F, -2.5F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.7735F, -0.6484F, -0.2182F, 0.0F, 0.0F));

        PartDefinition middleright = rightLeg.addOrReplaceChild("middleright", CubeListBuilder.create(), PartPose.offset(-0.001F, 2.5657F, -2.1173F));

        PartDefinition mid_r1 = middleright.addOrReplaceChild("mid_r1", CubeListBuilder.create().texOffs(79, 0).addBox(-3.4F, -2.5F, -2.5F, 5.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.801F, 2.1514F, 0.8038F, 0.6109F, 0.0F, 0.0F));

        PartDefinition rightLeg_r1 = middleright.addOrReplaceChild("rightLeg_r1", CubeListBuilder.create().texOffs(20, 59).mirror().addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)).mirror(false), PartPose.offsetAndRotation(0.001F, 2.1514F, 0.8038F, 0.1309F, 0.0F, 0.0F));

        PartDefinition lowerlegright = middleright.addOrReplaceChild("lowerlegright", CubeListBuilder.create().texOffs(58, 55).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(60, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(0.001F, 4.4343F, 0.6173F));

        PartDefinition leftLeg = legs.addOrReplaceChild("leftLeg", CubeListBuilder.create(), PartPose.offset(2.9F, 0.0F, 0.0F));

        PartDefinition upper_r3 = leftLeg.addOrReplaceChild("upper_r3", CubeListBuilder.create().texOffs(40, 55).addBox(-2.5F, -2.5F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.7735F, -0.6484F, -0.2182F, 0.0F, 0.0F));

        PartDefinition middle = leftLeg.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offset(0.001F, 2.5657F, -2.1173F));

        PartDefinition mid_r2 = middle.addOrReplaceChild("mid_r2", CubeListBuilder.create().texOffs(97, 0).addBox(-2.4F, -2.5F, -2.5F, 5.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.001F, 2.1514F, 0.8038F, 0.6109F, 0.0F, 0.0F));

        PartDefinition mid_r3 = middle.addOrReplaceChild("mid_r3", CubeListBuilder.create().texOffs(20, 59).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.001F, 2.1514F, 0.8038F, 0.1309F, 0.0F, 0.0F));

        PartDefinition lowerleg = middle.addOrReplaceChild("lowerleg", CubeListBuilder.create().texOffs(58, 55).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(60, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-0.001F, 4.4343F, 0.6173F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

        this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);
        if (entity.getAttackState() == 0 || entity.getAttackState() == 9)
            this.animateWalk(PPAnims.walk, limbSwing, limbSwingAmount, 1.0F, 4.0F);
        // }

        this.animate((entity).getAnimationState("sleep"), PossessedPaladinAnimations4.sleep, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("awaken"), PossessedPaladinAnimations4.awaken3, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("idle"), PossessedPaladinAnimations4.newIdle, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("death"), FlamebornGuardAnimations.death2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("double_slash"), PossessedPaladinAnimations1.DoubleSlashVisualEnd4, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("double_slash_end"), PossessedPaladinAnimations1.DoubleSlashSlamVisual2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("double_slash_slam_end"), PossessedPaladinAnimations3.DoubleSlashSlamVisual4, ageInTicks, 1.0F);


        this.animate((entity).getAnimationState("sword_slam_cut"), PossessedPaladinAnimations1.swordSlamCut, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("sword_slam_end"), PossessedPaladinAnimations1.swordSlamEnd, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("sword_slam_counter_end"), PossessedPaladinAnimations1.swordSlamCounterEnd2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("sword_slam_counter_release"), PossessedPaladinAnimations3.swordSlamCounterEnd5, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("backflip"), PossessedPaladinAnimations1.backflip, ageInTicks, 1.0F);//1
        this.animate((entity).getAnimationState("backflip_end"), PossessedPaladinAnimations3.backflipEnd, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("backflip_double"), PossessedPaladinAnimations3.backflipDB, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("parry"), PossessedPaladinAnimations1.parry2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("fly_away_slash"), PossessedPaladinAnimations1.flyAwaySlash4, ageInTicks, 1.0F);


        this.animate((entity).getAnimationState("flip_smash"), PossessedPaladinAnimations2.flipSmashCut, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("flip_smash_end"), PossessedPaladinAnimations2.flipSmashEnd, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("flip_smash_flip"), PossessedPaladinAnimations2.flipSmashFlipEnd, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("slash_from"), PossessedPaladinAnimations2.slashFromCut, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("slash_from_end"), PossessedPaladinAnimations2.slashFromEnd2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("slash_from_stab"), PossessedPaladinAnimations4.slashFromStabEnd8, ageInTicks, 1.0F);//Old version 'End3'

        this.animate((entity).getAnimationState("slash_from_stab_grab_pre"), PossessedPaladinAnimations2.slashStabFromGrabPre2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("slash_from_stab_grab_fail"), PossessedPaladinAnimations2.slashFromStabGrabFail2, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("slash_from_stab_grab_stab_fail"), PossessedPaladinAnimations4.slashFromStabGrabStabFail, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("slash_from_stab_grab_success"), PossessedPaladinAnimations2.slashFromStabGrabSuccess, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("jump_pre"), PossessedPaladinAnimations2.JumpPre, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("jump_fall"), PossessedPaladinAnimations2.JumpFall, ageInTicks, 1.0F);
        this.animate((entity).getAnimationState("jump_smash"), PossessedPaladinAnimations2.JumpSlamLonger, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("jump_smash_combo"), PossessedPaladinAnimations4.JumpSlamCombo3, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("throw"), PossessedPaladinAnimations2.throw3, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("throw_double"), PossessedPaladinAnimations3.throw5, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("shield_smash"), PossessedPaladinAnimations3.shieldSlam3, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("second_phase"), PossessedPaladinAnimations3.secondPhase, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("side_roll_spin"), PossessedPaladinAnimations3.SideRollSpinSlash2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("left_side_roll_spin"), PossessedPaladinAnimations3.LeftSideRollSpinSlash, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("death"), PossessedPaladinAnimations4.death2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("finisher"), PossessedPaladinAnimations5.finisher2, ageInTicks, 1.0F);

        this.animate((entity).getAnimationState("trident_throw_spin"), PossessedPaladinAnimations5.trident_throw_spinCombo3, ageInTicks, 1.0F);

    }


    private void applyHeadRotation(PossessedPaladinEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 25.0F);
        this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
    }


    public void translateModel(PoseStack matrixStack) {
        root.translateAndRotate(matrixStack);
        lowerbody.translateAndRotate(matrixStack);
        body.translateAndRotate(matrixStack);
        GimbalRotator.translateAndRotate(matrixStack);
        rightArm.translateAndRotate(matrixStack);
        lowerarm2.translateAndRotate(matrixStack);
        sword.translateAndRotate(matrixStack);
        SoulGreatSword.translateAndRotate(matrixStack);
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