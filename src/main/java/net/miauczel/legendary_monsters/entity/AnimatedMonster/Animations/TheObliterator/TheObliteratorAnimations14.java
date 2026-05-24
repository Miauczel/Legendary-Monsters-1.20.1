package net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.TheObliterator;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class TheObliteratorAnimations14 {
        public static final AnimationDefinition parryPre2 = AnimationDefinition.Builder.withLength(1.125F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(5.2362F, -11.6345F, -13.3077F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-84.5292F, 28.2039F, 12.4139F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-71.8635F, 3.2132F, 16.8729F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-19.8069F, -12.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-3.8625F, 23.7359F, 52.3991F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.625F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-84.5292F, -28.2039F, -12.4139F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-91.8635F, -3.2132F, -16.8729F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(16.8069F, -6.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-3.6192F, -12.4839F, -49.2966F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(3.6164F, 19.6835F, 10.6276F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition kick_after_stomp_new3 = AnimationDefinition.Builder.withLength(3.375F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-53.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-117.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-140.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.4167F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-18.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.23F, -24.42F, 15.96F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -3.7964F, 25.8094F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -3.7964F, 25.8094F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, -36.8226F, 0.9708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, -9.1346F, -4.5975F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, -33.1789F, 6.2692F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, -7.0987F, -5.9346F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 2520.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(100.9543F, 6.0476F, -24.3726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-30.6724F, 0.0336F, 0.9763F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(83.4483F, -4.2412F, 1.8277F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 33.9109F, 18.9254F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, -6.8374F, 14.4068F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 20.7296F, 9.5017F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(67.4218F, 4.4229F, -59.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(40.6837F, -66.225F, -51.6748F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(67.3982F, -63.9764F, -74.6903F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(40.6837F, -66.225F, -51.6748F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-90.248F, 24.2427F, -19.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-90.248F, 24.2427F, -19.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.875F, KeyframeAnimations.degreeVec(30.6429F, -27.8707F, -25.1952F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(-2.2347F, -7.0875F, -8.1101F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.2347F, -7.0875F, -8.1101F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-15.0389F, -1.1252F, -38.2744F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-15.0389F, -1.1252F, -38.2744F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-37.0247F, 23.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-51.1278F, 32.1883F, 4.7535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-37.0824F, 47.3842F, 24.0675F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-51.1278F, 32.1883F, 4.7535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-82.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-82.0247F, 19.8217F, 2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.875F, KeyframeAnimations.degreeVec(-31.1727F, 25.1679F, 24.867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(67.4218F, -0.4229F, 59.6149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(40.6837F, 66.225F, 51.6748F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(67.3982F, 63.9764F, 74.6903F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(40.6837F, 66.225F, 51.6748F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-97.5155F, -20.9508F, -13.2805F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-97.5155F, -20.9508F, -13.2805F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.875F, KeyframeAnimations.degreeVec(30.6429F, 27.8707F, 25.1952F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0414F, 3.0088F, -7.2066F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(2.2347F, -7.0875F, -8.1101F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.2347F, -7.0875F, -8.1101F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(15.0389F, -1.1252F, -38.2744F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(15.0389F, -1.1252F, -38.2744F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-51.1278F, -32.1883F, -4.7535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-37.0824F, -47.3842F, -24.0675F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-51.1278F, -32.1883F, -4.7535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-82.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-82.0247F, -19.8217F, -2.7199F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.875F, KeyframeAnimations.degreeVec(-31.1727F, -25.1679F, -24.867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(28.2939F, 16.6658F, 5.4161F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(28.2939F, 16.6658F, 5.4161F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.875F, KeyframeAnimations.degreeVec(47.34F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 9.46F, -10.32F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 9.4583F, -10.3219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 9.4583F, -10.3219F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-5.0767F, -9.9616F, 0.8804F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(42.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(42.5F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition ambushReinforced = AnimationDefinition.Builder.withLength(6.25F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9583F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5833F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7083F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.0F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.125F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.4167F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-28.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.5833F, KeyframeAnimations.degreeVec(-3.54F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-3.54F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(22.8934F, -19.4032F, -26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(62.8934F, -19.4032F, -26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(20.4681F, -43.8533F, -28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(20.4681F, -43.8533F, -28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-103.156F, -18.5918F, 86.4848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.9116F, -44.7795F, 62.0964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(-11.5752F, 4.7511F, 22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-11.5752F, 4.7511F, 22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(22.8934F, 19.4032F, 26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(57.8934F, 19.4032F, 26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(20.4681F, 43.8533F, 28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(20.4681F, 43.8533F, 28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-103.156F, 18.5918F, -86.4848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.9116F, 44.7795F, -62.0964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(-11.5752F, -4.7511F, -22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-11.5752F, -4.7511F, -22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("upper_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("inner_lower_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("inner_upper_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition ambush2 = AnimationDefinition.Builder.withLength(4.0417F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.125F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4167F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-28.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(-3.54F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(22.8934F, -19.4032F, -26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(62.8934F, -19.4032F, -26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(20.4681F, -43.8533F, -28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-103.156F, -18.5918F, 86.4848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.9116F, -44.7795F, 62.0964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(-11.5752F, 4.7511F, 22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(22.8934F, 19.4032F, 26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(57.8934F, 19.4032F, 26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(20.4681F, 43.8533F, 28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-103.156F, 18.5918F, -86.4848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.9116F, 44.7795F, -62.0964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(-11.5752F, -4.7511F, -22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("upper_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("inner_lower_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("inner_upper_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
    public static final AnimationDefinition tpGrabFail4 = AnimationDefinition.Builder.withLength(1.0F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-29.27F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(50.37F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.23F, -5.68F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 477.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -477.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-114.2023F, 21.2242F, -2.3866F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(90.3989F, 10.6121F, -1.1933F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(-8.2562F, 8.3133F, -40.2818F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-6.9956F, -17.7652F, -32.6454F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.8499F, 6.9169F, 7.5229F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-102.425F, 3.4584F, 3.7615F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("finger_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 37.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("finger_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-114.2023F, -21.2242F, 2.3866F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(90.3989F, -10.6121F, 1.1933F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(8.2562F, 8.3133F, -40.2818F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(6.9956F, -17.7652F, -32.6454F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.8499F, -6.9169F, -7.5229F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-102.425F, -3.4584F, -3.7615F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.5F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.5F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
        public static final AnimationDefinition ambushCut2 = AnimationDefinition.Builder.withLength(5.0F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9583F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0833F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.375F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-28.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-3.54F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(22.8934F, -19.4032F, -26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(62.8934F, -19.4032F, -26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(20.4681F, -43.8533F, -28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-103.156F, -18.5918F, 86.4848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.9116F, -44.7795F, 62.0964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(-11.5752F, 4.7511F, 22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(22.8934F, 19.4032F, 26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(57.8934F, 19.4032F, 26.821F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(20.4681F, 43.8533F, 28.3133F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-103.156F, 18.5918F, -86.4848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.9116F, 44.7795F, -62.0964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(-11.5752F, -4.7511F, -22.0182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("upper_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("inner_lower_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("inner_upper_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition parryFrame2 = AnimationDefinition.Builder.withLength(0.75F).looping()
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -1080.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 1080.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.2362F, -11.6345F, -13.3077F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-71.8635F, 3.2132F, 16.8729F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-19.8069F, -12.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.8625F, 23.7359F, 52.3991F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-91.8635F, -3.2132F, -16.8729F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(16.8069F, -6.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.6192F, -12.4839F, -49.2966F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.6164F, 19.6835F, 10.6276F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition parrySuccess4 = AnimationDefinition.Builder.withLength(4.375F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 20.0F, 32.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 20.0F, 32.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, -8.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, -8.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(16.7363F, 5.188F, -16.7363F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(78.8636F, 8.6524F, 5.3204F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(78.8636F, 8.6524F, 5.3204F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-8.6364F, 8.6524F, 5.3204F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-61.2789F, 8.6524F, 5.3204F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(46.2211F, 8.6524F, 5.3204F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-3.7789F, 8.6524F, 5.3204F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(-72.5144F, 4.3262F, 2.6602F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 1.0F, 9.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 9.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 6.0F, -11.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 22.01F, -11.03F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, -9.0774F, 23.6402F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 3.01F, 6.97F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(0.0F, 17.8417F, -22.0184F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, -2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, -2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, -3240.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 1800.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 2160.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 2880.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 3240.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.2362F, -11.6345F, -13.3077F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(45.6816F, -51.7774F, -54.0999F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(77.5935F, -64.2663F, -88.3983F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(23.7936F, -50.5804F, -31.4032F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(9.2081F, 5.3526F, -9.6071F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(14.5081F, 18.3526F, -9.6071F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-19.7919F, 5.3526F, -9.6071F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-24.8364F, -36.6178F, 7.7488F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-23.1652F, 31.019F, -20.119F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-23.1652F, 41.019F, -25.119F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, -8.875F, -19.0325F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-71.8635F, 3.2132F, 16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-23.6365F, -73.5516F, -2.6892F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-23.6365F, -73.5516F, -2.6892F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-104.5888F, -22.1588F, 121.6221F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-118.5888F, -6.1588F, 140.6221F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-170.7143F, 58.6336F, 93.0948F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-170.7143F, 58.6336F, 93.0948F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-90.978F, -39.7562F, 80.476F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-86.978F, -39.7562F, 80.476F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(-2.3109F, -46.7129F, -26.7093F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-19.8069F, -12.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(-13.81F, -26.93F, -7.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-13.81F, -26.93F, -7.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(-12.4782F, -24.8388F, -21.7276F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-12.4782F, -24.8388F, -21.7276F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.2518F, -1.425F, -5.8984F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.2518F, -1.425F, -5.8984F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(-17.3394F, -3.3137F, -9.3897F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-18.2686F, 2.8498F, -4.3749F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(-19.33F, -7.2194F, 9.9802F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.8625F, 23.7359F, 52.3991F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-5.9696F, 53.6354F, 49.1426F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-5.9696F, 53.6354F, 49.1426F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(6.5304F, 53.6354F, 49.1426F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(6.5304F, 53.6354F, 49.1426F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-21.903F, -17.9114F, -3.3018F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(84.3097F, 75.9572F, 113.5282F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(98.3097F, 91.9572F, 139.5282F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(12.8028F, 34.5967F, 52.3839F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-15.8454F, 24.5051F, 40.6158F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-15.85F, 24.51F, 40.62F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.8333F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0823F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("small_half", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("small_half", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-91.8635F, -3.2132F, -16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-92.0244F, -23.2019F, -16.1796F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-92.0244F, -27.2019F, -16.1796F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-77.02F, 127.8F, -23.68F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-66.02F, 156.8F, -31.68F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(91.1647F, 62.8721F, 101.7076F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(91.1647F, 62.8721F, 101.7076F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(362.1017F, 63.4628F, 362.7634F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(337.1017F, 63.4628F, 362.7634F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 360.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(16.8069F, -6.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(22.81F, -6.93F, -36.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(22.81F, -6.93F, -36.38F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(10.8957F, -7.7804F, 9.3397F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(5.5873F, -9.3206F, 18.1332F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.59F, -9.32F, -2.87F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(5.59F, -9.32F, -2.87F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(14.411F, -24.1502F, -19.0492F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(8.5034F, -17.9409F, -12.1539F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(7.7019F, -19.9138F, -10.7445F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.6192F, -12.4839F, -49.2966F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-3.0632F, -12.6296F, -51.8535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-1.9332F, -12.8477F, -56.9749F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-9.6983F, 16.0431F, 13.8808F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.0522F, 26.9778F, 31.9612F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-34.9852F, -36.4071F, -29.8877F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-34.9852F, -36.4071F, -29.8877F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-91.8101F, -7.1843F, -78.9073F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-91.9864F, 25.2988F, -79.983F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(-47.0999F, -9.2176F, -62.2743F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -75.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -75.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.6164F, 19.6835F, 10.6276F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(3.6164F, 19.6835F, 10.6276F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-4.4856F, 14.0088F, 14.6991F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(29.1053F, 60.1096F, 26.7705F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-15.619F, -18.8978F, 7.8781F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-15.619F, -18.8978F, 7.8781F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(13.6424F, -18.8244F, -1.2108F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(13.6424F, -18.8244F, -1.2108F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(42.595F, -10.48F, -0.6741F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(-0.3557F, -2.9178F, -16.9517F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-1.3557F, -4.9178F, -19.9517F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(-5.5128F, -10.5793F, 8.1536F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-2.918F, 2.7537F, 7.4478F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(-9.1803F, 21.1167F, 26.8017F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("the_eye", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -42.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-5.4952F, -22.4516F, -34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.4952F, -22.4516F, -34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-35.2379F, -32.7326F, 6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-35.2379F, -32.7326F, 6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-5.4952F, 22.4516F, 34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.4952F, 22.4516F, 34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-35.2379F, 32.7326F, -6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-35.2379F, 32.7326F, -6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(5.4952F, 22.4516F, -34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.4952F, 22.4516F, -34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(35.2379F, 32.7326F, 6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(35.2379F, 32.7326F, 6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(5.4952F, -22.4516F, 34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.4952F, -22.4516F, 34.8832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(35.2379F, -32.7326F, -6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(35.2379F, -32.7326F, -6.051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition parryFail = AnimationDefinition.Builder.withLength(1.0F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.2362F, -11.6345F, -13.3077F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-71.8635F, 3.2132F, 16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(34.2456F, 25.2142F, -21.7901F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-19.8069F, -12.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.8625F, 23.7359F, 52.3991F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-61.6589F, 5.7222F, 22.5961F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-91.8635F, -3.2132F, -16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(34.2456F, -25.2142F, 21.7901F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(16.8069F, -6.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.6192F, -12.4839F, -49.2966F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-61.6589F, -5.7222F, -22.5961F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.6164F, 19.6835F, 10.6276F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -5.44F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition parryFail2 = AnimationDefinition.Builder.withLength(1.2917F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.2362F, -11.6345F, -13.3077F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-71.8635F, 3.2132F, 16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(34.2456F, 25.2142F, -21.7901F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-19.8069F, -12.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.8625F, 23.7359F, 52.3991F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-61.6589F, 5.7222F, 22.5961F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-91.8635F, -3.2132F, -16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(34.2456F, -25.2142F, 21.7901F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(16.8069F, -6.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.6192F, -12.4839F, -49.2966F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-61.6589F, -5.7222F, -22.5961F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.6164F, 19.6835F, 10.6276F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -5.44F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition parryFailTp = AnimationDefinition.Builder.withLength(1.5F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.scaleVec(0.2F, 1.8F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("legflower", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bigRing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 1440.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.2362F, -11.6345F, -13.3077F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-71.8635F, 3.2132F, 16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(34.2456F, 25.2142F, -21.7901F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-19.8069F, -12.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.8625F, 23.7359F, 52.3991F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-61.6589F, 5.7222F, 22.5961F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -12.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("ultimate_flame", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.25F, 1.25F, 1.25F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("blade", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-91.8635F, -3.2132F, -16.8729F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(34.2456F, -25.2142F, 21.7901F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("shoulder_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(16.8069F, -6.9328F, -18.3819F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("forearm_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.6192F, -12.4839F, -49.2966F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-61.6589F, -5.7222F, -22.5961F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("blade2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(3.0F, -16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("finger_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.6164F, 19.6835F, 10.6276F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(28.5715F, 5.8321F, 3.1489F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("big_cube", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -5.44F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -4.47F, 5.36F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("innercube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-2.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_top_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, -4.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cune_front_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_front_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_left", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_back_down_right", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(5.0F, 5.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
}
