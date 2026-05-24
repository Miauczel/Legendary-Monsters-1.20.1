package net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.Flameborn;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class WanderingEyeAnimations {
        public static final AnimationDefinition death = AnimationDefinition.Builder.withLength(1.625F)
                .addAnimation("Eye", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(70.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Eye", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 4.6985F, -1.7101F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -21.5402F, 11.6218F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, -21.5402F, 11.6218F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Layer1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-12.5F, -360.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-12.5F, -540.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-12.5F, -540.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Layer1", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -17.7814F, 10.2537F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, -17.7814F, 10.2537F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Layer2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-24.9164F, 360.0F, 4.5336F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-24.9164F, 540.0F, 4.5336F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-24.9164F, 540.0F, 4.5336F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("Layer2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -14.0226F, 8.8856F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -14.0226F, 8.8856F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
    public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(4.0F).looping()
            .addAnimation("Eye", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-22.74F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Eye", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Layer1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -720.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Layer1", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Layer2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 720.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Layer2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition roll = AnimationDefinition.Builder.withLength(2.75F)
            .addAnimation("Eye", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(61.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(66.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(14.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Eye", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, -2.6239F, 1.4544F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Layer1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(22.5F, -720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-83.66F, -906.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, -1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Layer1", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -6.826F, 2.3251F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, -4.0584F, 1.1819F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, -4.0584F, 1.1819F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Layer2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(20.0F, 180.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(24.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(20.5F, 720.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-81.5F, 906.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 1080.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("Layer2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.767F, 6.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, -0.767F, 7.6642F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -12.5525F, 0.8649F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, -0.6675F, 5.4213F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, -0.6675F, 5.4213F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-407.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-407.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
}
