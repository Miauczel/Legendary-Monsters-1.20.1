package net.miauczel.legendary_monsters.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

import java.util.Arrays;

public class SoulBladeAnimations {


   public static String[] partNames = {
            "cube_r1", "cube_r2", "cube_r3", "cube_r4", "cube_r5",
            "cube_r6", "cube_r7", "cube_r8", "cube_r9", "cube_r10"
    };

        public static final AnimationDefinition comeOut = AnimationDefinition.Builder.withLength(1.0833F)


                .addAnimation("cube_r1", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r4", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r6", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r7", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r8", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r9", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r10", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r11", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 67.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 127.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static int animationHeight = 66;
    public static final AnimationDefinition emerge = AnimationDefinition.Builder.withLength(1.0F)

            .addAnimation("cube_r1", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("cube_r2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            )).addAnimation("cube_r3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r4", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r6", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r7", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r8", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r9", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r10", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cube_r11", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, animationHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
public static int AnimationFallHeight = 64;

        public static int AnimationFallHeight2 = 71;
        public static final AnimationDefinition fall = AnimationDefinition.Builder.withLength(1.3333F)
                .addAnimation("cube_r1", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r4", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r6", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r7", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r8", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r9", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r10", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cube_r11", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, AnimationFallHeight2, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static float y = 104.0f;
        public static final AnimationDefinition emerge2 = AnimationDefinition.Builder.withLength(1.0F)
                .addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, y, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, y, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

}
