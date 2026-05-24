package net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.PossessedArmor.PossessedPaladin;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class PossessedPaladinAnimations1 {
    public static final AnimationDefinition parry2 = AnimationDefinition.Builder.withLength(2.9167F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-25.56F, 12.3911F, -11.8139F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-40.6053F, 50.8124F, -39.5666F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(25.4944F, 4.755F, 10.5014F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(25.4944F, 4.755F, 10.5014F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(56.8935F, 35.7216F, 28.2049F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(46.8935F, 35.7216F, 28.2049F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-30.5249F, 27.4316F, -29.2296F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(28.32F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(16.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-18.3285F, -39.2138F, 39.3752F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-18.3285F, -71.7138F, 39.3752F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(53.28F, -7.91F, 1.83F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(26.7023F, 54.2042F, -7.0588F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(18.7023F, 70.2042F, -14.0588F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(24.3729F, 28.7821F, 20.9867F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-5.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-47.5548F, -61.4602F, 60.7529F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(-15.41F, -28.21F, 13.36F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(17.5483F, 49.8397F, -18.4458F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-12.4517F, 64.8397F, -18.4458F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.4331F, 33.8648F, 2.776F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.2127F, 2.6851F, -11.684F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(121.3556F, -71.0069F, -11.0277F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(24.2822F, 0.5684F, -36.2775F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-54.55F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-98.12F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(46.4F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(69.3999F, -51.2211F, 73.7765F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(75.9122F, -33.0011F, 77.0356F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(12.2506F, -30.3676F, 30.3313F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(27.41F, 28.02F, 28.09F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(13.2636F, 32.9271F, 42.5014F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(308.6121F, 38.0615F, 331.0837F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(111.9803F, 31.9671F, 101.199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(123.9803F, 31.9671F, 113.199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(-35.081F, 20.4846F, -6.0125F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(37.8542F, 3.2088F, 9.1766F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(31.1873F, -1.6332F, 14.9004F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(42.65F, -15.46F, 20.65F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(22.2945F, -34.1947F, 42.0668F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(87.0852F, -45.0524F, 2.8233F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(107.2218F, -44.8203F, -1.9384F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(124.2218F, -44.8203F, -10.9384F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-126.6695F, 64.5475F, 133.2051F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-128.1695F, 64.5475F, 133.2051F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-256.0127F, 10.9469F, 262.6353F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-231.0127F, 10.9469F, 262.6353F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-323.5127F, 10.9469F, 262.6353F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-347.5127F, 10.9469F, 262.6353F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-67.6569F, -21.3467F, -30.5515F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-75.1569F, -21.3467F, -30.5515F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(36.676F, -25.9612F, -74.2374F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(36.676F, -25.9612F, -74.2374F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(36.68F, -25.96F, -74.24F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.398F, 0.8669F, -2.8443F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-22.8241F, -49.1154F, 21.2996F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-22.8241F, -49.1154F, 21.2996F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-18.2503F, 21.8517F, -16.4499F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-18.2503F, 21.8517F, -16.4499F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-18.25F, 21.85F, -16.45F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-20.0F, -47.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition DoubleSlashSlamVisual = AnimationDefinition.Builder.withLength(5.25F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-22.5F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(73.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(40.16F, -25.38F, -15.57F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(-3.86F, 0.0F, 2.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(-3.86F, 1.0F, 1.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(25.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-24.93F, -29.31F, 19.88F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-44.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-87.62F, 1.19F, -0.56F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.posVec(1.83F, 2.65F, -4.04F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(45.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(70.86F, -1.96F, 1.49F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(25.0F, 12.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(18.8716F, 49.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(61.9921F, -50.6074F, -61.5231F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(43.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-8.02F, -4.61F, 18.91F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.09F, -3.82F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-15.6263F, 35.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(92.0454F, -46.3002F, -79.5948F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(31.4674F, -19.0789F, 7.9583F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(3.0368F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-7.3099F, 2.8291F, 22.4228F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(13.747F, -30.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(6.08F, -13.71F, 13.61F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-44.0018F, -9.9577F, 16.6829F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-20.8545F, -55.038F, 61.027F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(3.3039F, -40.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-54.5675F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-29.147F, -9.2704F, 12.8851F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-98.1939F, 21.7931F, -114.0006F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-57.7183F, 8.7337F, -5.1715F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(-30.3991F, 9.9453F, 79.5705F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(19.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-24.3477F, 19.7563F, -13.1988F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(100.8959F, -1.9757F, 5.0563F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(86.5546F, -3.7693F, 3.597F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(101.5279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -56.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(94.9301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(92.4145F, 10.6814F, 16.5431F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(94.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-96.7568F, 51.7419F, 44.567F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-186.8203F, 96.7577F, 45.5587F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-200.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-167.9424F, 104.258F, 41.3309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-64.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-9.7156F, -45.0497F, -59.5955F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-11.29F, -2.87F, -35.3F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-50.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-21.48F, 9.01F, -9.14F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(22.0108F, 43.0795F, -34.2464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(93.1914F, 13.4716F, -35.3335F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(15.32F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(35.2866F, 20.2044F, -26.0135F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-5.55F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-38.74F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.25F, KeyframeAnimations.degreeVec(75.17F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-21.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition swordSlamEnd = AnimationDefinition.Builder.withLength(1.3333F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(73.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(40.16F, -25.38F, -15.57F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-24.93F, -29.31F, 19.88F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-44.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-87.62F, 1.19F, -0.56F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(45.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(70.86F, -1.96F, 1.49F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(43.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-8.02F, -4.61F, 18.91F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(13.747F, -30.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(6.08F, -13.71F, 13.61F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(69.2F, -5.89F, 15.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-5.55F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(71.51F, -0.15F, -0.35F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-21.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(19.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-24.3477F, 19.7563F, -13.1988F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(94.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-64.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.64F, -24.47F, -86.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-11.29F, -2.87F, -35.3F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-50.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-21.48F, 9.01F, -9.14F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition swordSlamCounterEnd = AnimationDefinition.Builder.withLength(3.0417F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(129.8884F, -56.993F, -68.5142F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(124.3108F, 58.3522F, -176.2305F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(124.31F, 213.35F, -176.23F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(124.31F, 237.35F, -176.23F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(106.34F, 219.52F, -191.58F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(180.0F, 180.0F, -180.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-3.0F, -2.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(-5.12F, -1.07F, -7.25F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-6.0F, -4.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(-1.0F, -4.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(-1.0F, -4.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-56.0403F, 0.475F, 19.1237F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(46.6152F, 9.9524F, 14.748F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(46.6152F, 9.9524F, 14.748F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(65.36F, 2.75F, 4.07F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-63.3216F, -47.9375F, -8.2179F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-63.32F, -187.94F, -28.22F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-35.82F, -377.94F, 26.78F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-35.82F, -405.94F, 26.78F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-17.14F, -318.67F, 12.81F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(1.83F, -6.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(5.83F, -4.0F, -7.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(-1.17F, -4.0F, -4.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(-1.17F, -4.0F, -4.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.posVec(0.44F, -1.91F, 0.79F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(75.2909F, 18.7889F, 2.822F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(75.2909F, 18.7889F, 2.822F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(101.8F, -37.27F, -78.14F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(167.24F, -1.05F, -190.23F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(49.99F, 26.79F, -344.51F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(36.99F, 26.79F, -379.01F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-13.75F, 49.19F, -372.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -360.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(22.28F, -45.0F, 2.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(23.7556F, -68.7407F, 2.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.33F, -30.38F, -20.1F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(33.75F, -76.36F, 2.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(40.75F, -54.36F, 9.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-37.96F, -27.36F, 35.44F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(69.2F, -5.89F, 15.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(21.5757F, -10.896F, 33.014F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(49.0757F, -10.896F, 33.014F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5417F, KeyframeAnimations.degreeVec(52.5F, 0.0F, -26.84F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(71.51F, -0.15F, -0.35F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-49.8108F, -1.5416F, -3.5633F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-87.3108F, -1.5416F, -3.5633F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-71.85F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(19.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-50.67F, 31.88F, 3.34F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(-76.36F, 60.67F, -56.31F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-116.5774F, 30.0126F, -91.6236F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-123.0F, -15.39F, -84.83F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-78.58F, 73.51F, -54.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-76.08F, 116.01F, -12.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-100.85F, 14.23F, -63.94F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(98.69F, 33.4F, 14.15F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(106.02F, -11.49F, 48.08F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(68.52F, 11.01F, 10.58F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(55.52F, 11.01F, -21.92F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-86.4538F, 55.767F, 67.8464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-107.5713F, 103.4259F, 49.0089F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-227.9F, 82.5F, 38.04F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-196.7621F, 112.5221F, 33.7564F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-196.7621F, 112.5221F, 33.7564F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(13.83F, -10.7F, -70.87F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-20.33F, 67.82F, -20.63F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition swordSlamCut = AnimationDefinition.Builder.withLength(1.5417F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-22.5F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(25.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(1.83F, 2.65F, -4.04F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.09F, -3.82F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(3.0368F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.3099F, 2.8291F, 22.4228F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-98.1939F, 21.7931F, -114.0006F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-57.7183F, 8.7337F, -5.1715F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-30.3991F, 9.9453F, 79.5705F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(19.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(92.4145F, 10.6814F, 16.5431F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(31.64F, -24.47F, -86.5F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-25.04F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(15.32F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(35.2866F, 20.2044F, -26.0135F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(69.2F, -5.89F, 15.39F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-38.74F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(75.17F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(71.51F, -0.15F, -0.35F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition DoubleSlashVisualEnd = AnimationDefinition.Builder.withLength(3.4167F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-17.5F, 5.5607F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(-3.86F, 0.0F, 2.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(-3.86F, 1.0F, 1.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(-1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(22.5F, -2.6837F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-35.0F, 51.6497F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.98F, 3.0F, 0.74F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(40.1837F, -22.2747F, 2.6837F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(25.0F, 12.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(18.8716F, 49.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(61.9921F, -50.6074F, -61.5231F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(2.5305F, 61.1862F, 11.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(5.4862F, -6.1848F, 14.6683F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-15.6263F, 35.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(92.0454F, -46.3002F, -79.5948F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(31.4674F, -19.0789F, 7.9583F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(39.4573F, 37.7447F, 37.3688F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(2.7449F, 16.7224F, 10.0299F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-44.0018F, -9.9577F, 16.6829F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-20.8545F, -55.038F, 61.027F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(3.3039F, -40.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-54.5675F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-29.147F, -9.2704F, 12.8851F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(101.3011F, 28.4777F, 81.3428F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-7.8477F, 9.7563F, 26.8012F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(100.8959F, -1.9757F, 5.0563F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(86.5546F, -3.7693F, 3.597F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(101.5279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -56.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(94.9301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(3.0774F, 4.2733F, 13.4472F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-96.7568F, 51.7419F, 44.567F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-186.8203F, 96.7577F, 45.5587F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-200.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-167.9424F, 104.258F, 41.3309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-9.7156F, -45.0497F, -59.5955F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(11.6641F, -49.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-59.58F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(22.0108F, 43.0795F, -34.2464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(93.1914F, 13.4716F, -35.3335F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();


    public static final AnimationDefinition DoubleSlashVisualEnd4 = AnimationDefinition.Builder.withLength(3.4167F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-17.5F, 5.5607F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-3.86F, 0.0F, 2.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(-3.86F, 1.0F, 1.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(-1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(22.5F, -2.6837F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-35.0F, 51.6497F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.posVec(0.98F, 3.0F, 0.74F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(40.1837F, -22.2747F, 2.6837F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(25.0F, 12.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(18.8716F, 49.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(61.9921F, -50.6074F, -61.5231F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(2.5305F, 61.1862F, 11.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(5.4862F, -6.1848F, 14.6683F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.6263F, 35.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(92.0454F, -46.3002F, -79.5948F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(31.4674F, -19.0789F, 7.9583F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(39.4573F, 37.7447F, 37.3688F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(2.7449F, 16.7224F, 10.0299F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-44.0018F, -9.9577F, 16.6829F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-20.8545F, -55.038F, 61.027F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(3.3039F, -40.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-54.5675F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-29.147F, -9.2704F, 12.8851F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(101.3011F, 28.4777F, 81.3428F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-7.8477F, 9.7563F, 26.8012F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(100.8959F, -1.9757F, 5.0563F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(86.5546F, -3.7693F, 3.597F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(101.5279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -56.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(94.9301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(3.0774F, 4.2733F, 13.4472F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-96.7568F, 51.7419F, 44.567F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-186.8203F, 96.7577F, 45.5587F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-200.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-167.9424F, 104.258F, 41.3309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-9.7156F, -45.0497F, -59.5955F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(11.6641F, -49.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-59.58F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(22.0108F, 43.0795F, -34.2464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(93.1914F, 13.4716F, -35.3335F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition DoubleSlashSlamVisual2 = AnimationDefinition.Builder.withLength(5.25F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-22.5F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(73.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(40.16F, -25.38F, -15.57F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-3.86F, 0.0F, 2.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(-3.86F, 1.0F, 1.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(25.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.3333F, KeyframeAnimations.degreeVec(-24.93F, -29.31F, 19.88F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-44.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-87.62F, 1.19F, -0.56F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(1.83F, 2.65F, -4.04F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(45.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(70.86F, -1.96F, 1.49F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(25.0F, 12.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(18.8716F, 49.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(51.9367F, -73.1729F, -49.2186F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(61.9921F, -50.6074F, -61.5231F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(43.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-8.02F, -4.61F, 18.91F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.09F, -3.82F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.6263F, 35.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(92.0454F, -46.3002F, -79.5948F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(31.4674F, -19.0789F, 7.9583F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(3.0368F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-7.3099F, 2.8291F, 22.4228F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(13.747F, -30.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(6.08F, -13.71F, 13.61F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-44.0018F, -9.9577F, 16.6829F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-20.8545F, -55.038F, 61.027F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(3.3039F, -40.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-54.5675F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-29.147F, -9.2704F, 12.8851F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-98.1939F, 21.7931F, -114.0006F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-57.7183F, 8.7337F, -5.1715F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(-30.3991F, 9.9453F, 79.5705F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(19.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-24.3477F, 19.7563F, -13.1988F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(100.8959F, -1.9757F, 5.0563F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(86.5546F, -3.7693F, 3.597F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(101.5279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -56.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(94.9301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(92.4145F, 10.6814F, 16.5431F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(94.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-96.7568F, 51.7419F, 44.567F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-186.8203F, 96.7577F, 45.5587F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-200.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-167.9424F, 104.258F, 41.3309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-64.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-9.7156F, -45.0497F, -59.5955F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-11.29F, -2.87F, -35.3F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-50.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.3333F, KeyframeAnimations.degreeVec(-21.48F, 9.01F, -9.14F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(22.0108F, 43.0795F, -34.2464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(93.1914F, 13.4716F, -35.3335F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(15.32F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(35.2866F, 20.2044F, -26.0135F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-5.55F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-38.74F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(75.17F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-21.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();


    public static final AnimationDefinition DoubleSlashVisualEnd3 = AnimationDefinition.Builder.withLength(3.5417F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-17.5F, 5.5607F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-3.86F, 0.0F, 2.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7083F, KeyframeAnimations.posVec(-3.86F, 1.0F, 1.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.posVec(-1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(22.5F, -2.6837F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-35.0F, 51.6497F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.posVec(0.98F, 3.0F, 0.74F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(40.1837F, -22.2747F, 2.6837F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.7083F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(25.0F, 12.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(18.8716F, 49.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(61.9921F, -50.6074F, -61.5231F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(2.5305F, 61.1862F, 11.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(5.4862F, -6.1848F, 14.6683F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.6263F, 35.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(92.0454F, -46.3002F, -79.5948F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(31.4674F, -19.0789F, 7.9583F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(39.4573F, 37.7447F, 37.3688F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(2.7449F, 16.7224F, 10.0299F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-44.0018F, -9.9577F, 16.6829F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-20.8545F, -55.038F, 61.027F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(3.3039F, -40.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-54.5675F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-29.147F, -9.2704F, 12.8851F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(101.3011F, 28.4777F, 81.3428F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-7.8477F, 9.7563F, 26.8012F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(100.8959F, -1.9757F, 5.0563F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(86.5546F, -3.7693F, 3.597F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(101.5279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -56.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(94.9301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(3.0774F, 4.2733F, 13.4472F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-96.7568F, 51.7419F, 44.567F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-186.8203F, 96.7577F, 45.5587F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-200.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-167.9424F, 104.258F, 41.3309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-9.7156F, -45.0497F, -59.5955F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(11.6641F, -49.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-59.58F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(22.0108F, 43.0795F, -34.2464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(93.1914F, 13.4716F, -35.3335F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition DoubleSlashSlamVisual3 = AnimationDefinition.Builder.withLength(5.0417F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(54.7609F, -53.8102F, -35.4341F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-34.6435F, 19.2185F, -11.2221F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-22.5F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(73.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(40.16F, -25.38F, -15.57F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-3.86F, 0.0F, 2.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(-3.86F, 1.0F, 1.9F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(1.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(35.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(25.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-24.93F, -29.31F, 19.88F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(58.6704F, 65.3615F, 59.6083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-44.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-87.62F, 1.19F, -0.56F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(1.83F, 2.65F, -4.04F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(45.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(70.86F, -1.96F, 1.49F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(25.0F, 12.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(18.8716F, 49.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(51.9367F, -73.1729F, -49.2186F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(61.9921F, -50.6074F, -61.5231F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(43.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-8.02F, -4.61F, 18.91F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.09F, -3.82F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.6263F, 35.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(92.0454F, -46.3002F, -79.5948F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(31.4674F, -19.0789F, 7.9583F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(3.0368F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-7.3099F, 2.8291F, 22.4228F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(13.747F, -30.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(6.08F, -13.71F, 13.61F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-44.0018F, -9.9577F, 16.6829F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-20.8545F, -55.038F, 61.027F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(3.3039F, -40.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-54.5675F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-29.147F, -9.2704F, 12.8851F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-98.1939F, 21.7931F, -114.0006F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-57.7183F, 8.7337F, -5.1715F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(-30.3991F, 9.9453F, 79.5705F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(19.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-24.3477F, 19.7563F, -13.1988F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(100.8959F, -1.9757F, 5.0563F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(86.5546F, -3.7693F, 3.597F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(101.5279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -56.3918F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(94.9301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(92.4145F, 10.6814F, 16.5431F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(94.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-96.7568F, 51.7419F, 44.567F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-186.8203F, 96.7577F, 45.5587F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-200.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-167.9424F, 104.258F, 41.3309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-64.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-9.7156F, -45.0497F, -59.5955F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-11.29F, -2.87F, -35.3F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-50.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-32.5F, 74.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-21.48F, 9.01F, -9.14F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(22.0108F, 43.0795F, -34.2464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(93.1914F, 13.4716F, -35.3335F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(15.32F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(35.2866F, 20.2044F, -26.0135F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-5.55F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(34.83F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-38.74F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(75.17F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-21.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition swordSlamCounterEnd2 = AnimationDefinition.Builder.withLength(3.375F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(92.7811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(129.8884F, -56.993F, -68.5142F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(124.3108F, 58.3522F, -176.2305F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(124.31F, 213.35F, -176.23F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(124.31F, 237.35F, -176.23F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(124.31F, 237.35F, -176.23F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(106.34F, 219.52F, -191.58F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(180.0F, 180.0F, -180.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, -4.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-3.0F, -2.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(-5.12F, -1.07F, -7.25F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-6.0F, -4.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(-1.0F, -4.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(-1.0F, -4.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-1.0F, -4.0F, -9.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-56.0403F, 0.475F, 19.1237F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(46.6152F, 9.9524F, 14.748F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(46.6152F, 9.9524F, 14.748F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(46.6152F, 9.9524F, 14.748F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(65.36F, 2.75F, 4.07F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-57.5209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-63.3216F, -47.9375F, -8.2179F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-63.32F, -187.94F, -28.22F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-35.82F, -377.94F, 26.78F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-35.82F, -405.94F, 26.78F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-35.82F, -405.94F, 26.78F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-17.14F, -318.67F, 12.81F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(1.83F, -4.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(1.83F, -6.0F, -10.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(5.83F, -4.0F, -7.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(-1.17F, -4.0F, -4.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(-1.17F, -4.0F, -4.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-1.17F, -4.0F, -4.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.posVec(0.44F, -1.91F, 0.79F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(75.2909F, 18.7889F, 2.822F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(75.2909F, 18.7889F, 2.822F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(75.2909F, 18.7889F, 2.822F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(56.6988F, -9.9559F, 3.0527F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(101.8F, -37.27F, -78.14F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(167.24F, -1.05F, -190.23F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(49.99F, 26.79F, -344.51F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(36.99F, 26.79F, -379.01F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(36.99F, 26.79F, -379.01F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-13.75F, 49.19F, -372.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -360.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, -4.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(22.28F, -45.0F, 2.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(23.7556F, -68.7407F, 2.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.33F, -30.38F, -20.1F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(33.75F, -76.36F, 2.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(40.75F, -54.36F, 9.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(40.75F, -54.36F, 9.4F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-37.96F, -27.36F, 35.44F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(69.2F, -5.89F, 15.39F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(21.5757F, -10.896F, 33.014F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(49.0757F, -10.896F, 33.014F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(52.5F, 0.0F, -26.84F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(71.51F, -0.15F, -0.35F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-49.8108F, -1.5416F, -3.5633F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-87.3108F, -1.5416F, -3.5633F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-71.85F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(19.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-50.67F, 31.88F, 3.34F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(-76.36F, 60.67F, -56.31F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-116.5774F, 30.0126F, -91.6236F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-123.0F, -15.39F, -84.83F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-78.58F, 106.51F, -54.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-76.08F, 108.01F, -12.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-76.08F, 108.01F, -12.62F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-100.85F, 14.23F, -63.94F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(98.69F, 33.4F, 14.15F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(106.02F, -11.49F, 48.08F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(68.52F, 11.01F, 10.58F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(55.52F, 11.01F, -21.92F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(55.52F, 11.01F, -21.92F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-84.3381F, 69.6095F, 32.0729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-86.4538F, 55.767F, 67.8464F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-107.5713F, 103.4259F, 49.0089F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-227.9F, 82.5F, 38.04F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-196.7621F, 112.5221F, 33.7564F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-167.7621F, 112.5221F, 33.7564F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-167.7621F, 112.5221F, 33.7564F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(-182.0655F, 91.9331F, 27.5798F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.8333F, KeyframeAnimations.degreeVec(13.83F, -10.7F, -70.87F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.8278F, 20.3175F, -20.6271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-20.33F, 67.82F, -20.63F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition backflip = AnimationDefinition.Builder.withLength(1.4167F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-215.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-342.6407F, 2.2494F, -7.1566F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(-1.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-40.7573F, -7.836F, -16.5861F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -3.8612F, -0.9021F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-102.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(2.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(-1.0F, -2.7509F, -4.1156F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(107.6949F, 3.9972F, 50.8449F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(74.1178F, -46.6053F, 10.9742F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(77.3631F, -26.4251F, 62.5043F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(40.9346F, 48.4258F, -45.9062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-85.262F, -29.5448F, -51.4951F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition flyAwaySlash = AnimationDefinition.Builder.withLength(3.0F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 200.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(25.0133F, -69.9504F, -54.6039F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-60.924F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-78.424F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-60.924F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0643F, -0.9601F, 1.272F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.671F, -1.6999F, 2.8374F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-0.67F, -1.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(-0.67F, -3.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(-0.67F, -5.7F, -4.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.posVec(-0.67F, -3.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(28.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(58.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(73.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(58.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-39.2315F, -37.7612F, 26.5651F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-26.18F, 50.2393F, -5.2964F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.7321F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -1.7321F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -1.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.13F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(20.86F, -11.6174F, 27.8544F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(24.6585F, -26.8101F, 5.5738F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.1283F, -54.7075F, -17.2562F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(8.5486F, 30.8399F, -8.1915F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(54.8217F, -1.3381F, 16.6062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(64.8217F, -1.3381F, 16.6062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(54.8217F, -1.3381F, 16.6062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(-0.2756F, -0.8862F, 0.3724F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.2756F, -0.8862F, 0.3724F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(-0.28F, -3.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(-0.28F, -5.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.posVec(-0.28F, -3.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(22.5F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(26.2326F, -46.618F, -5.5519F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-8.5342F, -1.9339F, -10.1179F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(33.3849F, 14.0053F, -6.2278F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(20.544F, 36.1729F, 2.9261F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(33.9015F, 47.7178F, 9.4084F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(24.9015F, 47.7178F, 9.4084F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(112.7118F, -45.1006F, -7.5698F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-84.73F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(71.0138F, -12.3066F, 38.8933F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-7.9724F, -24.6132F, 77.7865F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-31.4268F, -42.4505F, 91.6427F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-1.3328F, 34.0115F, -4.122F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(75.2376F, 26.2717F, 52.786F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(75.2376F, 26.2717F, 52.786F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-7.3809F, 13.1359F, 26.3932F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.6336F, -1.4104F, -2.291F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.6336F, -1.4104F, -2.291F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(49.6458F, -38.1109F, 15.1729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(49.6458F, -38.1109F, 15.1729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(140.7697F, -70.5927F, -53.1316F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(26.5569F, -58.5975F, 65.8531F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(59.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(82.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(69.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(138.8667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(113.3667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(27.5F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-30.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(27.5F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition flyAwaySlash3 = AnimationDefinition.Builder.withLength(3.6667F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 200.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(25.0133F, -69.9504F, -54.6039F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-60.924F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-78.424F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-60.924F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0643F, -0.9601F, 1.272F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.671F, -1.6999F, 2.8374F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-0.67F, -1.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.posVec(-0.67F, -1.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.posVec(-0.67F, -3.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.posVec(-0.67F, -5.7F, -4.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.posVec(-0.67F, -3.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(28.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(58.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(73.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(58.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-39.2315F, -37.7612F, 26.5651F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.25F, KeyframeAnimations.degreeVec(-26.18F, 50.2393F, -5.2964F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.7321F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -1.7321F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -1.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, -1.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.13F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.25F, KeyframeAnimations.degreeVec(20.86F, -11.6174F, 27.8544F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(24.6585F, -26.8101F, 5.5738F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.1283F, -54.7075F, -17.2562F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(8.5486F, 30.8399F, -8.1915F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(43.6544F, 8.4976F, 20.7119F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(53.7786F, 12.9116F, 6.3682F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.125F, KeyframeAnimations.degreeVec(64.8217F, -1.3381F, 16.6062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(54.8217F, -1.3381F, 16.6062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(-0.2756F, -0.8862F, 0.3724F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.2756F, -0.8862F, 0.3724F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.posVec(-0.28F, -3.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.posVec(-0.28F, -5.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.posVec(-0.28F, -3.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(22.5F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(26.2326F, -46.618F, -5.5519F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-8.5342F, -1.9339F, -10.1179F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(35.8726F, 1.1043F, 12.4108F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(20.544F, 36.1729F, 2.9261F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(33.9015F, 47.7178F, 9.4084F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(24.9015F, 47.7178F, 9.4084F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(112.7118F, -45.1006F, -7.5698F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-84.73F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(71.0138F, -12.3066F, 38.8933F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-7.9724F, -24.6132F, 77.7865F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-31.4268F, -42.4505F, 91.6427F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-1.3328F, 34.0115F, -4.122F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-1.3328F, 34.0115F, -4.122F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(75.2376F, 26.2717F, 52.786F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(75.2376F, 26.2717F, 52.786F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.25F, KeyframeAnimations.degreeVec(-7.3809F, 13.1359F, 26.3932F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.6336F, -1.4104F, -2.291F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.6336F, -1.4104F, -2.291F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(49.6458F, -38.1109F, 15.1729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(49.6458F, -38.1109F, 15.1729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(140.7697F, -70.5927F, -53.1316F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(26.5569F, -58.5975F, 65.8531F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(26.5569F, -58.5975F, 65.8531F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(59.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(82.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(69.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(138.8667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(138.8667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(113.3667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(27.5F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-30.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9583F, KeyframeAnimations.degreeVec(27.5F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition flyAwaySlash4 = AnimationDefinition.Builder.withLength(3.6667F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 200.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(25.0133F, -69.9504F, -54.6039F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-60.924F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-78.424F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(-60.924F, 1.8588F, -16.2371F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0643F, -0.9601F, 1.272F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.671F, -1.6999F, 2.8374F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-0.67F, -1.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.67F, -1.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(-0.67F, -3.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-0.67F, -5.7F, -4.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.posVec(-0.67F, -3.7F, -2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(28.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(58.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(73.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(58.8384F, -8.6474F, 15.2727F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-39.2315F, -37.7612F, 26.5651F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(-36.1706F, 49.2696F, 15.3092F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-26.18F, 50.2393F, -5.2964F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.7321F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -1.7321F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -1.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, -1.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.posVec(0.0F, -3.73F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, 0.13F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.1667F, KeyframeAnimations.degreeVec(20.86F, -11.6174F, 27.8544F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(24.6585F, -26.8101F, 5.5738F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.1283F, -54.7075F, -17.2562F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(8.5486F, 30.8399F, -8.1915F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(43.6544F, 8.4976F, 20.7119F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(53.7786F, 12.9116F, 6.3682F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(64.8217F, -1.3381F, 16.6062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(54.8217F, -1.3381F, 16.6062F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(-0.2756F, -0.8862F, 0.3724F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.2756F, -0.8862F, 0.3724F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(-0.28F, -3.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-0.28F, -5.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.posVec(-0.28F, -3.89F, 0.37F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(22.5F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(26.2326F, -46.618F, -5.5519F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-8.5342F, -1.9339F, -10.1179F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(35.8726F, 1.1043F, 12.4108F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(20.544F, 36.1729F, 2.9261F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(33.9015F, 47.7178F, 9.4084F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(24.9015F, 47.7178F, 9.4084F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(112.7118F, -45.1006F, -7.5698F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-84.73F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(71.0138F, -12.3066F, 38.8933F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-7.9724F, -24.6132F, 77.7865F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-31.4268F, -42.4505F, 91.6427F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-1.3328F, 34.0115F, -4.122F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-1.3328F, 34.0115F, -4.122F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(75.2376F, 26.2717F, 52.786F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(75.2376F, 26.2717F, 52.786F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-7.3809F, 13.1359F, 26.3932F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.6336F, -1.4104F, -2.291F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.6336F, -1.4104F, -2.291F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(49.6458F, -38.1109F, 15.1729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(49.6458F, -38.1109F, 15.1729F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(140.7697F, -70.5927F, -53.1316F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(26.5569F, -58.5975F, 65.8531F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(26.5569F, -58.5975F, 65.8531F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(59.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(82.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(69.1824F, -34.0976F, 22.7178F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(138.8667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(138.8667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(113.3667F, 10.5109F, -192.9301F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(6.3489F, -57.3673F, -69.3816F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(-85.3729F, -37.0682F, -28.6348F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(27.5F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-30.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.875F, KeyframeAnimations.degreeVec(27.5F, -35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

}
