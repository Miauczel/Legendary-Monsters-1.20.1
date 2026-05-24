package net.miauczel.legendary_monsters.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class SkeleraptorAnimations {


        public static final AnimationDefinition sit = AnimationDefinition.Builder.withLength(4.0F).looping()
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -14.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("arm3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("arm4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 32.5F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.5F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 5.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-37.5F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 5.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -47.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition idlenew = AnimationDefinition.Builder.withLength(5.0F).looping()
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition sitEnd = AnimationDefinition.Builder.withLength(1.0F)
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -14.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arm3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("arm4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 32.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.5F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 5.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-37.5F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 5.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();
        public static final AnimationDefinition walk4New = AnimationDefinition.Builder.withLength(1.2083F).looping()
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(7.5019F, -2.8048F, 2.1523F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(7.5019F, 2.8048F, -2.1523F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 37.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-62.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.6905F, -3.6252F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -2.5921F, -0.7688F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, -1.4874F, -7.1572F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, -1.6905F, -3.6252F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(22.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-62.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.5921F, -0.7688F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -1.4874F, -7.1572F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, -1.6905F, -3.6252F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, -2.5921F, -0.7688F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(22.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arm3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arm4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();
        public static final AnimationDefinition sitStart = AnimationDefinition.Builder.withLength(1.0F)
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -14.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arm3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("arm4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 32.5F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-32.5F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-1.0F, 5.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-37.5F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 5.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();
    public static final AnimationDefinition tailhit = AnimationDefinition.Builder.withLength(2.5833F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 147.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 205.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.0F, -20.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(1.0F, -20.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(1.0F, -20.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-4.9166F, -70.0385F, 4.5767F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(28.9292F, 0.2294F, -11.557F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-32.1415F, 36.3963F, -23.114F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-32.1415F, 36.3963F, -23.114F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("tailbody2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -71.74F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-35.36F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, -1.4874F, -7.1572F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, -1.6905F, -3.6252F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(22.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-62.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, -2.5921F, -0.7688F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, -1.4874F, -7.1572F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(22.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition roar = AnimationDefinition.Builder.withLength(2.625F)
            .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(3.9799F, -4.988F, -0.3466F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(3.7564F, 6.0991F, 0.3838F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("tailbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-19.2099F, -27.937F, 3.4302F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-11.5636F, 45.9544F, -4.3234F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(37.51F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(37.51F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("upperjaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(21.17F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("paw4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(21.17F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("paw3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition shockwaves = AnimationDefinition.Builder.withLength(2.9167F)
            .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("mainbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-45.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(3.7963F, 7.284F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-45.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(3.7963F, 7.284F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftleg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 18.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 18.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
    public static final AnimationDefinition WALK4 = AnimationDefinition.Builder.withLength(1.2083433f).looping()
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, 3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("mainbody",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, -4f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.posVec(0f, 0f, -4f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 37.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(0f, -37.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(0f, -45f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 37.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 37.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(0f, -30f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(0f, -30f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(0f, 37.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 37.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("neck",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(40f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -1.69f, -3.63f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -2.59f, -0.77f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, -1.49f, -7.16f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.posVec(0f, -1.69f, -3.63f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-62.86f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(22.86f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(40f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(40f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -2.59f, -0.77f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, -1.49f, -7.16f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.posVec(0f, -1.69f, -3.63f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.posVec(0f, -2.59f, -0.77f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-62.86f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw4",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(22.86f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm4",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(4f).looping()
            .addAnimation("right_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("mainbody",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("mainbody",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("mainbody",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("neck",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("neck",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("neck",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw3",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw3",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw4",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw4",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw4",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition ATTACK2 = AnimationDefinition.Builder.withLength(0.9167666f)
            .addAnimation("right_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("root",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("mainbody",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.posVec(0f, 0f, -9f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0f, -9f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, 0f, -9f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, 0f, -9f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("mainbody",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("mainbody",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("tailbody2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("neck",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("neck",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("neck",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("arm2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg3",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw3",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw3",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw3",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerleg5",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw4",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw4",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("paw4",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("lowerjaw",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("upperjaw",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}