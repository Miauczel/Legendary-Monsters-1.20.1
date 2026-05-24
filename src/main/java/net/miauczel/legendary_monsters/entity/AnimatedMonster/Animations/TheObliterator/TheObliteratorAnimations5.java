package net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.TheObliterator;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class TheObliteratorAnimations5 {
    public static final AnimationDefinition kick_smash_no_grab = AnimationDefinition.Builder.withLength(2.3333F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-117.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-140.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-121.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-53.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-18.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-22.82F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-35.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -3.7964F, 25.8094F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -9.1346F, 0.4025F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, -9.1346F, -4.5975F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -12.63F, -0.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, -23.5736F, 14.5673F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, -25.5736F, 17.5673F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 900.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -900.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, -1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(58.9F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 20.7296F, 9.5017F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 20.7296F, 9.5017F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 23.44F, 11.54F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 31.9109F, 17.9254F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, 29.94F, 16.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 30.9109F, 16.9254F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(86.2339F, -6.4905F, -59.7864F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-90.248F, 24.2427F, -19.09F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-61.48F, 16.95F, -2.42F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(-1.0158F, -3.2216F, -3.6864F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-15.0389F, -1.1252F, -38.2744F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.posVec(-10.66F, -0.12F, -30.76F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(86.2339F, 6.4905F, 59.7864F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-97.5155F, -20.9508F, -13.2805F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-61.48F, -16.95F, 2.42F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(1.0158F, -3.2216F, -3.6864F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(15.0389F, -1.1252F, -38.2744F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.posVec(10.66F, -0.12F, -30.76F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-82.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-82.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-69.93F, -19.82F, -2.72F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(28.2939F, 16.6658F, 5.4161F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 9.4583F, -10.3219F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 9.4583F, -10.3219F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-5.0767F, 9.9616F, -0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-5.0767F, -9.9616F, 0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(5.0767F, -9.9616F, -0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(5.0767F, 9.9616F, 0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-5.0767F, 9.9616F, -0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-5.0767F, -9.9616F, 0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(5.0767F, -9.9616F, -0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(5.0767F, 9.9616F, 0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition grab_after_kick_smash = AnimationDefinition.Builder.withLength(2.7083F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-0.8261F, 39.6869F, -48.919F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(38.2522F, 2.9145F, 45.217F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(38.2522F, -6.0855F, 45.217F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -25.5736F, 17.5673F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-7.0F, 4.17F, 0.43F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.posVec(-7.0F, 4.17F, 0.43F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, -2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(37.0878F, 60.5731F, 4.3148F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(42.69F, 36.22F, -12.86F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(31.8544F, -36.5253F, -14.9803F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(31.8544F, -48.5253F, -14.9803F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(31.85F, -48.53F, -14.98F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 30.9109F, 16.9254F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-114.5176F, 34.92F, 0.4181F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(26.2183F, 26.5141F, 6.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(26.2183F, 26.5141F, 6.7314F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(26.22F, 26.51F, 6.73F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-24.0749F, -4.3398F, -33.0543F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(-12.1316F, -15.7724F, 6.2749F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.posVec(-10.1316F, -17.7724F, 12.2749F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(-10.13F, -17.77F, 12.27F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-7.7632F, -14.8256F, 44.6582F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-102.0812F, -16.7056F, 27.759F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-102.0812F, -16.7056F, 27.759F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-102.08F, -16.71F, 27.76F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(-188.3674F, 11.5106F, -61.1356F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-264.2493F, 31.5614F, -175.9352F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-178.9299F, 56.4374F, -125.3541F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-253.29F, 135.89F, -208.19F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-259.72F, 149.32F, -213.77F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-261.25F, 170.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-280.25F, 194.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-261.25F, 194.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-180.0F, 180.0F, -180.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(14.5418F, -4.8538F, -2.315F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.posVec(10.98F, -3.64F, -17.05F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.posVec(10.3035F, -3.1511F, -20.7536F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.posVec(14.2328F, -0.72F, -26.012F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(14.23F, -0.72F, -26.01F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(17.4778F, -2.8097F, -38.2514F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-13.71F, 4.14F, -47.69F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-13.24F, 3.05F, -45.51F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-0.0222F, -2.8097F, -38.2514F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(1.0554F, -2.6042F, -60.7759F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(1.06F, -2.6F, -60.78F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition kick_smash_bye_bye = AnimationDefinition.Builder.withLength(0.6667F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -25.5736F, 17.5673F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 30.9109F, 16.9254F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
        public static final AnimationDefinition backstep_right_stomp = AnimationDefinition.Builder.withLength(3.125F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-125.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-121.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-53.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-20.5653F, -28.3938F, 10.1158F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-22.82F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-35.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-35.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 7.0F, -13.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 7.0F, -13.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 7.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 7.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(-19.0526F, -5.7355F, -15.0591F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(-19.0526F, -5.7355F, -15.0591F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-21.23F, -24.42F, 15.96F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-21.23F, -19.1937F, 8.633F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 900.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -900.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(31.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(39.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(44.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(53.1104F, -14.1534F, 10.3992F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(53.1104F, -14.1534F, 10.3992F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(93.9543F, 2.0476F, -20.3726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(99.9543F, 5.0476F, -26.3726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 20.7296F, 9.5017F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 23.44F, 11.54F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 31.9109F, 17.9254F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 29.94F, 16.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 30.9109F, 16.9254F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(36.1971F, 10.5479F, -14.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(41.1971F, 12.5479F, -16.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-14.0787F, -38.7435F, -48.8712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(24.8174F, -29.9317F, -38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(29.8174F, -29.9317F, -38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-61.48F, 16.95F, -2.42F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(-1.6662F, -5.2845F, 10.6441F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(-10.66F, -0.12F, -30.76F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-51.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-59.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-75.9478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-75.9478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-33.4478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-28.4478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(36.1971F, -10.5479F, 14.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(41.1971F, -12.5479F, 17.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-14.0787F, 38.7435F, 48.8712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(24.8174F, 29.9317F, 38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(28.8174F, 29.9317F, 38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-61.48F, -16.95F, 2.42F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(1.6662F, -5.2845F, 10.6441F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(10.66F, -0.12F, -30.76F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-51.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-59.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-75.9478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-75.9478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-33.4478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-28.4478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-82.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-69.93F, -19.82F, -2.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-2.04F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-2.04F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 9.4583F, -10.3219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition backstep_left_stomp = AnimationDefinition.Builder.withLength(3.125F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-125.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-121.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-53.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-20.5653F, 28.3938F, -10.1158F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-22.82F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-35.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-35.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 7.0F, -13.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 7.0F, -13.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 7.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 7.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(19.0526F, -5.7355F, -15.0591F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(19.0526F, -5.7355F, -15.0591F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(21.23F, -24.42F, 15.96F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(21.23F, -19.1937F, 8.633F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 900.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -900.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(31.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(39.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(44.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(53.1104F, 14.1534F, -10.3992F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(53.1104F, 14.1534F, -10.3992F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(93.9543F, -2.0476F, 20.3726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(99.9543F, -5.0476F, 26.3726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 20.7296F, 9.5017F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 23.44F, 11.54F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 31.9109F, 17.9254F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 29.94F, 16.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 30.9109F, 16.9254F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(36.1971F, 10.5479F, -14.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(41.1971F, 12.5479F, -16.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-14.0787F, -38.7435F, -48.8712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(24.8174F, -29.9317F, -38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(29.8174F, -29.9317F, -38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-61.48F, 16.95F, -2.42F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(-1.6662F, -5.2845F, 10.6441F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(-10.66F, -0.12F, -30.76F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-51.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-59.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-75.9478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-75.9478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-33.4478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-28.4478F, 25.5642F, 16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(36.1971F, -10.5479F, 14.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(41.1971F, -12.5479F, 17.044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-14.0787F, 38.7435F, 48.8712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(24.8174F, 29.9317F, 38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(28.8174F, 29.9317F, 38.1037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-61.48F, -16.95F, 2.42F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(1.6662F, -5.2845F, 10.6441F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(10.66F, -0.12F, -30.76F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-51.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-59.66F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-75.9478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-75.9478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-33.4478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-28.4478F, -25.5642F, -16.2586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-82.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-69.93F, -19.82F, -2.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-2.04F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-2.04F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 9.4583F, -10.3219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, -38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-27.6201F, 38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, -38.7648F, 2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(27.6201F, 38.7648F, -2.1133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition p2 = AnimationDefinition.Builder.withLength(5.5F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 27.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 27.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 27.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 27.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 27.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(2.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-17.5862F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-17.59F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-15.09F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 9.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 9.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 6.0F, -24.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 6.0F, -24.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 2.8461F, -6.807F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(0.0F, 2.85F, -6.81F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(0.0F, 2.68F, -5.56F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-4.1406F, -14.9626F, 1.0708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-4.1406F, -14.9626F, 1.0708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-4.42F, -13.25F, 0.95F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-118.8105F, 36.4829F, 29.6659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-134.9122F, -24.8883F, 37.1571F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-152.455F, -64.0866F, 107.6664F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-152.455F, -64.0866F, 116.6664F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(-118.8105F, 36.4829F, 29.6659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(-118.8105F, 41.4829F, 32.6659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-119.0085F, -64.0297F, 113.9726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-177.3638F, -77.7262F, 174.7782F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-119.0085F, -64.0297F, 113.9726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-177.3638F, -77.7262F, 174.7782F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-148.17F, -63.3F, 146.2F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-19.5699F, 0.7848F, -35.482F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(9.138F, 5.3568F, -14.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(9.138F, 5.3568F, -14.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-20.5236F, 1.0855F, -35.482F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-20.5236F, 1.0855F, -35.482F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(-4.57F, -15.22F, -10.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-0.5F, -2.04F, -1.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-55.4114F, -18.8294F, 27.4529F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-62.4114F, -22.8294F, 25.4529F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 44.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-43.8609F, -29.3545F, 26.2501F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-52.468F, -15.9649F, 39.1309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-43.8609F, -29.3545F, 26.2501F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-52.468F, -15.9649F, 39.1309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-41.94F, -12.54F, 32.86F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 44.22F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-118.8105F, -36.4829F, -29.6659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-134.9122F, 24.8883F, -37.1571F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-152.455F, 64.0866F, -107.6664F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-152.455F, 64.0866F, -122.6664F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(-118.8105F, -36.4829F, -29.6659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(-118.8105F, -41.4829F, -32.6659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-119.0085F, 64.0297F, -113.9726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-177.3638F, 77.7262F, -174.7782F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-119.0085F, 64.0297F, -113.9726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-177.3638F, 77.7262F, -174.7782F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-148.17F, 63.3F, -146.2F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(19.5699F, 0.7848F, -35.482F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-9.138F, 5.3568F, -14.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-9.138F, 5.3568F, -14.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(19.5699F, 0.7848F, -35.482F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(19.5699F, 0.7848F, -35.482F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(4.57F, -15.22F, -10.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(0.69F, -3.24F, -1.88F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(0.3F, -1.52F, -0.95F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-55.4114F, 18.8294F, -27.4529F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-62.4114F, 23.8294F, -23.4529F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-43.8609F, 29.3545F, -26.2501F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-52.468F, 15.9649F, -39.1309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-43.8609F, 29.3545F, -26.2501F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-52.468F, 15.9649F, -39.1309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-41.94F, 12.54F, -32.86F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -55.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -44.22F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-56.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(2.2156F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-34.5641F, -28.2953F, 10.4236F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-34.5641F, 28.2953F, -10.4236F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-28.63F, -1.93F, 0.71F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 19.7698F, 7.1074F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 19.7698F, 7.1074F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 29.0F, -29.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 29.0F, -29.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -8.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -8.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 9.2083F, -19.6708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(0.0F, 2.61F, -5.33F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(1.59F, -0.8F, -1.59F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-1.59F, -0.8F, -1.59F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-27.9039F, -29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-4.533F, -12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-27.9039F, -29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-4.533F, -12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-20.84F, -24.88F, -5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-27.9F, -29.48F, -4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-2.07F, -1.03F, 2.07F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-27.9039F, 29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-4.533F, 12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-27.9039F, 29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-4.533F, 12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-20.84F, 24.88F, 5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-27.9F, 29.48F, 4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(2.07F, -1.03F, 2.07F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-1.59F, 1.59F, -1.59F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(1.59F, 1.59F, -1.59F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(27.9039F, 29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(4.533F, 12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(27.9039F, 29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(4.533F, 12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(20.84F, 24.88F, -5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(27.9F, 29.48F, -4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(2.07F, 2.07F, 2.07F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(27.9039F, -29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(4.533F, -12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(27.9039F, -29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(4.533F, -12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(20.84F, -24.88F, 5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(27.9F, -29.48F, 4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-2.07F, 2.07F, 2.07F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-27.9039F, -29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-4.533F, -12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-27.9039F, -29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-4.533F, -12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-20.84F, -24.88F, -5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-27.9F, -29.48F, -4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-5.16F, -4.13F, 5.16F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-27.9039F, 29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-4.533F, 12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-27.9039F, 29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-4.533F, 12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(-20.84F, 24.88F, 5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(-27.9F, 29.48F, 4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(5.16F, -4.13F, 5.16F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(3.98F, -3.17F, -3.98F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-3.98F, -3.17F, -3.98F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(27.9039F, -29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(4.533F, -12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(27.9039F, -29.4791F, 4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(4.533F, -12.1248F, 6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(20.84F, -24.88F, 5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(27.9F, -29.48F, 4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-5.16F, 5.16F, 5.16F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(27.9039F, 29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7083F, KeyframeAnimations.degreeVec(4.533F, 12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(27.9039F, 29.4791F, -4.2309F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4167F, KeyframeAnimations.degreeVec(4.533F, 12.1248F, -6.6549F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.degreeVec(20.84F, 24.88F, -5.48F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.degreeVec(27.9F, 29.48F, -4.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, -5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(5.16F, 5.16F, 5.16F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(-3.98F, 3.98F, -3.98F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-5.0F, -5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.625F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.75F, KeyframeAnimations.posVec(3.98F, 3.98F, -3.98F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, -1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, -1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition teleport_grab_after_kick_smash = AnimationDefinition.Builder.withLength(2.9167F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-0.8261F, 39.6869F, -48.919F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(38.2522F, 2.9145F, 45.217F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(38.2522F, -6.0855F, 45.217F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -25.5736F, 17.5673F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-7.0F, 4.17F, 0.43F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(-7.0F, 4.17F, 0.43F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, -2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(37.0878F, 60.5731F, 4.3148F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(42.69F, 36.22F, -12.86F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(31.8544F, -36.5253F, -14.9803F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(31.8544F, -48.5253F, -14.9803F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(31.85F, -48.53F, -14.98F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 30.9109F, 16.9254F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-114.5176F, 34.92F, 0.4181F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(26.2183F, 26.5141F, 6.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(26.2183F, 26.5141F, 6.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(26.22F, 26.51F, 6.73F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-24.0749F, -4.3398F, -33.0543F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-12.1316F, -15.7724F, 6.2749F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(-10.1316F, -17.7724F, 12.2749F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-10.13F, -17.77F, 12.27F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-7.7632F, -14.8256F, 44.6582F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-102.0812F, -16.7056F, 27.759F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(-102.0812F, -16.7056F, 27.759F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-102.08F, -16.71F, 27.76F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-188.3674F, 11.5106F, -61.1356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-264.2493F, 31.5614F, -175.9352F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-178.9299F, 56.4374F, -125.3541F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-253.29F, 135.89F, -208.19F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-259.72F, 149.32F, -213.77F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-261.25F, 170.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(-280.25F, 194.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-261.25F, 194.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-180.0F, 180.0F, -180.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(14.5418F, -4.8538F, -2.315F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(10.98F, -3.64F, -17.05F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(10.3035F, -3.1511F, -20.7536F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(14.2328F, -0.72F, -26.012F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(14.23F, -0.72F, -26.01F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(17.4778F, -2.8097F, -38.2514F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-13.71F, 4.14F, -47.69F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-13.24F, 3.05F, -45.51F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-0.0222F, -2.8097F, -38.2514F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(1.0554F, -2.6042F, -60.7759F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(1.06F, -2.6F, -60.78F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition crushGrabSuccess = AnimationDefinition.Builder.withLength(2.2083F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(34.71F, 7.38F, 35.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-5.02F, 43.24F, -53.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-5.02F, 43.24F, -53.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-5.02F, 43.24F, -53.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-6.31F, 4.3F, 0.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 3.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 3.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 3.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 2340.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 1911.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 1911.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -2340.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -1911.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, -1911.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, -2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(34.19F, -21.48F, -14.95F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(58.8444F, -58.5194F, -60.6031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(62.8444F, -62.5194F, -60.6031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(77.8444F, -62.5194F, -60.6031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(77.8444F, -62.5194F, -60.6031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(62.8444F, -62.5194F, -60.6031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.82F, 27.61F, 6.56F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(23.87F, 27.88F, 9.52F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(23.87F, 27.88F, 9.52F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(23.87F, 27.88F, 9.52F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-13.63F, -14.57F, 1.77F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-12.78F, -15.31F, 5.7F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-12.78F, -15.31F, 5.7F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-12.78F, -15.31F, 5.7F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-92.52F, -16.82F, 29.8F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-100.83F, -17.83F, 32.74F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-100.83F, -17.83F, 32.74F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-100.83F, -17.83F, 32.74F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-259.72F, 149.32F, -213.77F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-291.8F, 187.3F, -245.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-291.8F, 195.3F, -245.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-291.8F, 195.3F, -245.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, -360.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(10.98F, -3.64F, -17.05F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(21.3845F, 14.2545F, -5.9423F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(21.3845F, 14.2545F, -5.9423F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(19.7533F, 2.0287F, -10.0622F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(19.7533F, 2.0287F, -10.0622F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(21.3845F, 14.2545F, -5.9423F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.24F, 3.05F, -45.51F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(9.59F, -14.23F, -45.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(11.59F, -17.23F, -45.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(17.2562F, -11.5502F, -67.9566F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(17.2562F, -11.5502F, -67.9566F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(11.59F, -17.23F, -45.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -82.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.34F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-38.2036F, 26.13F, 11.2349F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-43.2036F, 29.13F, 13.2349F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-43.2036F, 29.13F, 13.2349F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-5.4F, 3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-5.4F, 3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-5.4F, 3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, -0.82F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-0.15F, 0.07F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.15F, 0.07F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.15F, 0.07F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-5.4F, -3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-5.4F, -3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-5.4F, -3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, -0.82F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.15F, 0.07F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.15F, 0.07F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.15F, 0.07F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-25.1344F, -38.8015F, -27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.1344F, -38.8015F, -27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-25.1344F, -38.8015F, -27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, -0.82F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.15F, 0.07F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.15F, 0.07F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(-1.63F, -1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(-1.63F, -1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.15F, 0.07F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-25.1344F, 38.8015F, 27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.1344F, 38.8015F, 27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-25.1344F, 38.8015F, 27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, -0.82F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-0.15F, 0.07F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.15F, 0.07F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(1.63F, -1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(1.63F, -1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.15F, 0.07F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-0.77F, -3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-0.77F, -3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-0.77F, -3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, 1.63F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.15F, -0.15F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.15F, -0.15F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.15F, -0.15F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-3.09F, 3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-3.09F, 3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-3.09F, 3.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, 1.63F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-0.15F, -0.15F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.15F, -0.15F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.15F, -0.15F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.1344F, 38.8015F, -27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(25.1344F, 38.8015F, -27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(25.1344F, 38.8015F, -27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-0.15F, -0.15F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.15F, -0.15F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.15F, -0.15F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.1344F, -38.8015F, 27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(25.1344F, -38.8015F, 27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(25.1344F, -38.8015F, 27.7337F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.15F, -0.15F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.15F, -0.15F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(-1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(-1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.15F, -0.15F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, -3.56F, 4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-4.46F, -3.56F, 4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition teleport_grab_after_kick_smash_cut = AnimationDefinition.Builder.withLength(1.5417F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-46.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-0.8261F, 39.6869F, -48.919F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(34.71F, 7.38F, 35.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -25.5736F, 17.5673F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-6.31F, 4.3F, 0.23F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 2340.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, -2340.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(37.0878F, 60.5731F, 4.3148F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(42.69F, 36.22F, -12.86F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(34.19F, -21.48F, -14.95F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 30.9109F, 16.9254F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, 4.4229F, -51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-114.5176F, 34.92F, 0.4181F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(10.82F, 27.61F, 6.56F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-24.0749F, -4.3398F, -33.0543F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-13.63F, -14.57F, 1.77F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-7.7632F, -14.8256F, 44.6582F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-92.52F, -16.82F, 29.8F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(51.4218F, -4.4229F, 51.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-188.3674F, 11.5106F, -61.1356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-264.2493F, 31.5614F, -175.9352F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-178.9299F, 56.4374F, -125.3541F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-253.29F, 135.89F, -208.19F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-259.72F, 149.32F, -213.77F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(14.5418F, -4.8538F, -2.315F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(10.98F, -3.64F, -17.05F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(17.4778F, -2.8097F, -38.2514F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-13.71F, 4.14F, -47.69F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-13.24F, 3.05F, -45.51F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-0.34F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(1.63F, -0.82F, -1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-1.63F, -0.82F, -1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-1.63F, -0.82F, 1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(1.63F, -0.82F, 1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-1.63F, 1.63F, -1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(1.63F, 1.63F, -1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-4.46F, -3.56F, 4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition crush_grab_fail = AnimationDefinition.Builder.withLength(1.375F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(34.71F, 7.38F, 35.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(38.2522F, -6.0855F, 45.217F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-6.31F, 4.3F, 0.23F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(-7.0F, 4.17F, 0.43F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 2340.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -2340.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, -2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(34.19F, -21.48F, -14.95F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(31.8544F, -48.5253F, -14.9803F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(31.85F, -48.53F, -14.98F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.82F, 27.61F, 6.56F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(26.2183F, 26.5141F, 6.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(26.22F, 26.51F, 6.73F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-13.63F, -14.57F, 1.77F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(-10.1316F, -17.7724F, 12.2749F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(-10.13F, -17.77F, 12.27F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-92.52F, -16.82F, 29.8F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-102.0812F, -16.7056F, 27.759F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-102.08F, -16.71F, 27.76F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-259.72F, 149.32F, -213.77F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-280.25F, 194.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-261.25F, 194.56F, -205.94F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-180.0F, 180.0F, -180.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(10.98F, -3.64F, -17.05F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(14.2328F, -0.72F, -26.012F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(14.23F, -0.72F, -26.01F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.24F, 3.05F, -45.51F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(1.0554F, -2.6042F, -60.7759F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(1.06F, -2.6F, -60.78F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.34F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, -0.82F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, -0.82F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, -0.82F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, -0.82F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, 1.63F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, 1.63F, -1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.9F, -1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.9F, 1.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.63F, 1.63F, 1.63F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, -3.56F, 4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, -3.56F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(4.46F, 4.46F, 4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(4.46F, 4.46F, -4.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();


}
