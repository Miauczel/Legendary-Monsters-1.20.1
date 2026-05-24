package net.miauczel.legendary_monsters.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class BomberAnimations {




    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(0.75f).looping()
            .addAnimation("leg1",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -27.5f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, -27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 27.5f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(4f).looping()
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition WALK2 = AnimationDefinition.Builder.withLength(0.75f).looping()
            .addAnimation("leg1",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -27.5f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, -27.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 27.5f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
