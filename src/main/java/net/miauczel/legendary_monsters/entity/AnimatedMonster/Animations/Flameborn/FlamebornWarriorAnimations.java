package net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class FlamebornWarriorAnimations {
    public static final AnimationDefinition hit = AnimationDefinition.Builder.withLength(1.9583F)
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(51.307F, 44.9387F, 35.4296F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(59.307F, 55.9387F, 43.4296F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(20.2048F, 2.3357F, 5.4134F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(62.6893F, -45.8846F, -29.0315F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(66.6893F, -53.8846F, -35.0315F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-15.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-15.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("upperhead", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.6814F, 19.1769F, 76.7325F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(30.9176F, 7.1648F, 99.306F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.328F, 23.0079F, 123.4067F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-91.2757F, 5.3277F, 123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-105.2757F, 5.3277F, 123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerRightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(27.4767F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(27.4767F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-60.0233F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-75.0233F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-8.9306F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-8.9306F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(51.0694F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(51.0694F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerLeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(6.153F, 8.5489F, 21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(6.153F, 8.5489F, 21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(28.653F, 8.5489F, 21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(28.65F, 8.55F, 21.38F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(14.3569F, 7.1314F, -10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(14.3569F, 7.1314F, -10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-13.1431F, 7.1314F, -10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-13.14F, 7.13F, -10.29F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition hit2 = AnimationDefinition.Builder.withLength(1.9583F)
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(51.307F, -44.9387F, -35.4296F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(59.307F, -55.9387F, -43.4296F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(20.2048F, -2.3357F, -5.4134F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(62.6893F, 45.8846F, 29.0315F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(66.6893F, 53.8846F, 35.0315F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-15.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-15.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("upperhead", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-8.9306F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-8.9306F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(51.0694F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(51.0694F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerRightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.6814F, -19.1769F, -76.7325F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(30.9176F, -7.1648F, -99.306F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.328F, -23.0079F, -123.4067F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-91.2757F, -5.3277F, -123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-105.2757F, -5.3277F, -123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerLeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(27.4767F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(27.4767F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-60.0233F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-75.0233F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(14.3569F, -7.1314F, 10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(14.3569F, -7.1314F, 10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-13.1431F, -7.1314F, 10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-13.14F, -7.13F, 10.29F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(6.153F, -8.5489F, -21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(6.153F, -8.5489F, -21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(28.653F, -8.5489F, -21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(28.65F, -8.55F, -21.38F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

        public static final AnimationDefinition hitDouble = AnimationDefinition.Builder.withLength(3.2083F)
                .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(51.307F, 44.9387F, 35.4296F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(59.307F, 55.9387F, 43.4296F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(20.2048F, 2.3357F, 5.4134F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(62.6893F, -45.8846F, -29.0315F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(66.6893F, -53.8846F, -35.0315F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(48.3517F, -65.5209F, -54.1863F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(71.5885F, 51.4394F, 39.0126F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(76.5885F, 67.4394F, 57.0126F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-15.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-15.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-34.3835F, -40.4166F, 16.1688F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("upperhead", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.6814F, 19.1769F, 76.7325F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(30.9176F, 7.1648F, 99.306F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.328F, 23.0079F, 123.4067F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-91.2757F, 5.3277F, 123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-105.2757F, 5.3277F, 123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(60.2556F, 34.7507F, 52.4217F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(60.26F, 34.75F, 52.42F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerRightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(27.4767F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(27.4767F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-60.0233F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-75.0233F, 0.2154F, -1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-75.02F, 0.22F, -1.07F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-115.0098F, 0.1103F, -0.535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-8.9306F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-8.9306F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(51.0694F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(51.0694F, -10.1969F, -57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(50.1448F, 15.1924F, -78.4591F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-51.1715F, -44.9316F, -101.5395F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-110.513F, -9.3398F, -90.9993F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-129.513F, -16.3398F, -97.9993F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(39.056F, -8.6074F, -49.4371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerLeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(6.153F, 8.5489F, 21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(6.153F, 8.5489F, 21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(28.653F, 8.5489F, 21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(28.65F, 8.55F, 21.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-3.85F, 8.55F, 21.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(26.3961F, 14.3455F, 10.0738F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(31.3961F, 16.3455F, 7.0738F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 3.5F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(14.3569F, 7.1314F, -10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(14.3569F, 7.1314F, -10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-13.1431F, 7.1314F, -10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-13.14F, 7.13F, -10.29F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(7.1217F, -51.0443F, -28.4093F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-14.7499F, -45.4324F, 16.5827F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-5.9806F, -45.026F, 6.6257F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition hitDouble2 = AnimationDefinition.Builder.withLength(3.9583F)
                .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(51.307F, -44.9387F, -35.4296F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(59.307F, -55.9387F, -43.4296F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(20.2048F, -2.3357F, -5.4134F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(62.6893F, 45.8846F, 29.0315F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(66.6893F, 53.8846F, 35.0315F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(48.3517F, 65.5209F, 54.1863F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(71.5885F, -51.4394F, -39.0126F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(76.5885F, -67.4394F, -57.0126F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-15.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-15.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-34.3835F, 40.4166F, -16.1688F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("upperhead", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-8.9306F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-8.9306F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(51.0694F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(51.0694F, 10.1969F, 57.9807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(50.1448F, -15.1924F, 78.4591F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-51.1715F, 44.9316F, 101.5395F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-110.513F, 9.3398F, 90.9993F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-129.513F, 16.3398F, 97.9993F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(39.056F, 8.6074F, 49.4371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerRightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.6814F, -19.1769F, -76.7325F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(30.9176F, -7.1648F, -99.306F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.328F, -23.0079F, -123.4067F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-91.2757F, -5.3277F, -123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-105.2757F, -5.3277F, -123.4219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(60.2556F, -34.7507F, -52.4217F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(60.26F, -34.75F, -52.42F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerLeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(27.4767F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(27.4767F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-60.0233F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-75.0233F, -0.2154F, 1.0697F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(14.3569F, -7.1314F, 10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(14.3569F, -7.1314F, 10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-13.1431F, -7.1314F, 10.2928F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-13.14F, -7.13F, 10.29F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(7.1217F, 51.0443F, 28.4093F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-14.7499F, 45.4324F, -16.5827F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-5.9806F, 45.026F, -6.6257F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(6.153F, -8.5489F, -21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(6.153F, -8.5489F, -21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(28.653F, -8.5489F, -21.3833F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(28.65F, -8.55F, -21.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-3.85F, -8.55F, -21.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(26.3961F, -14.3455F, -10.0738F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(31.3961F, -16.3455F, -7.0738F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -5.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 3.5F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
}
