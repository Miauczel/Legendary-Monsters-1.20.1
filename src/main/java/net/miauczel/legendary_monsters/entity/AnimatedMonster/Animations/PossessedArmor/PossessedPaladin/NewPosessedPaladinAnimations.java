package net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.PossessedArmor.PossessedPaladin;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class NewPosessedPaladinAnimations {
        public static final AnimationDefinition stabGrabPre = AnimationDefinition.Builder.withLength(1.75F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(20.73F, -28.5501F, -31.2456F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(20.73F, -28.5501F, -31.2456F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-1.0F, -1.07F, 2.57F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-1.0F, -1.07F, 2.57F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(42.1199F, 36.7492F, 40.8947F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(42.1199F, 36.7492F, 40.8947F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-26.7711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-26.7711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.49F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.49F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(31.0035F, 0.0F, -7.1877F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(31.0035F, 0.0F, -7.1877F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(32.3977F, 50.3315F, 26.0334F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(38.2467F, 56.4618F, 33.3055F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(35.0226F, -41.0463F, -13.4498F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(35.0226F, -41.0463F, -13.4498F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.1599F, -3.2113F, 12.0868F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(27.259F, 5.6868F, 16.6557F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-2.5238F, -18.5172F, -2.2446F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-2.5238F, -18.5172F, -2.2446F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(172.1457F, -18.8203F, 56.4517F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(172.1457F, -18.8203F, 56.4517F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(5.6397F, 31.836F, 20.7812F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-12.3603F, 31.836F, 20.7812F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.3F, 0.21F, 0.42F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(6.8147F, -9.1823F, 8.5181F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(56.8147F, -9.1823F, 8.5181F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(100.7998F, -4.7445F, -12.9F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(100.7998F, -4.7445F, -12.9F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(6.2099F, -57.554F, -53.7109F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(6.2099F, -57.554F, -53.7109F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-32.7903F, -47.7908F, 5.966F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-32.7903F, -47.7908F, 5.966F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-3.53F, 14.75F, -0.44F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition stabGrabSuccess = AnimationDefinition.Builder.withLength(2.625F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.73F, -28.5501F, -31.2456F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(20.73F, -28.5501F, -31.2456F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(51.0353F, -82.7172F, -70.7558F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(13.2505F, -10.3541F, -20.9845F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(13.2505F, -10.3541F, -20.9845F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, -1.07F, 2.57F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(-1.0F, -1.07F, 2.57F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-1.0F, -1.07F, 2.57F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-1.0F, -1.07F, 2.57F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(14.3701F, -5.0785F, 14.1327F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(14.3701F, -5.0785F, 14.1327F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-26.7711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-26.7711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-26.7711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-14.2711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-14.2711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.49F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.49F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.49F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.49F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.49F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.0035F, 0.0F, -7.1877F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(31.0035F, 0.0F, -7.1877F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(35.0226F, -41.0463F, -13.4498F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-35.8103F, -56.2309F, 23.0241F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-45.868F, -49.6568F, 35.5881F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(46.7538F, -37.8624F, -25.0249F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(46.7538F, -37.8624F, -25.0249F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5238F, -18.5172F, -2.2446F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-2.5238F, -18.5172F, -2.2446F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-10.9735F, -15.214F, 26.3138F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(40.8153F, -18.609F, -4.8801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(40.8153F, -18.609F, -4.8801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(30.0014F, 13.1248F, -10.0356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(30.0014F, 13.1248F, -10.0356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(97.308F, 10.8528F, -9.7598F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-21.07F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-21.07F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-71.33F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(31.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.3603F, 31.836F, 20.7812F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-60.4096F, 40.8529F, -18.2069F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-84.1078F, 41.0968F, -19.2614F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-104.1081F, 6.7343F, -69.0864F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-104.1081F, 6.7343F, -69.0864F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.3F, 0.21F, 0.42F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(1.069F, 0.7487F, 1.5155F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(1.069F, 0.7487F, 1.5155F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(100.7998F, -4.7445F, -12.9F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(100.7998F, -4.7445F, -12.9F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(53.2998F, -4.7445F, -12.9F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(79.4352F, 13.8569F, -29.732F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(79.4352F, 13.8569F, -29.732F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-185.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-167.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-167.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.2099F, -57.554F, -53.7109F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-0.1973F, -21.7851F, -40.5944F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-0.1973F, -21.7851F, -40.5944F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.53F, 14.75F, -0.44F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-22.5F, 42.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-22.5F, 42.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition stabGrabFail = AnimationDefinition.Builder.withLength(0.4167F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.73F, -28.5501F, -31.2456F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, -1.07F, 2.57F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-26.7711F, -6.967F, 15.2131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.49F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.0035F, 0.0F, -7.1877F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(35.0226F, -41.0463F, -13.4498F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5238F, -18.5172F, -2.2446F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.3603F, 31.836F, 20.7812F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.3F, 0.21F, 0.42F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(100.7998F, -4.7445F, -12.9F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.2099F, -57.554F, -53.7109F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.53F, 14.75F, -0.44F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition TripleCombo = AnimationDefinition.Builder.withLength(3.8333F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -71.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(65.2811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(65.2811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(1.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(1.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 85.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-25.0209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-25.0209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(1.83F, 2.65F, -4.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(1.83F, -1.0F, -5.62F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(1.83F, -1.0F, -5.62F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(27.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(27.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(18.8716F, 25.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(48.7234F, -54.6296F, -46.2153F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(52.5775F, 2.5559F, 27.6432F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(52.5775F, 2.5559F, 27.6432F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.09F, -3.82F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.6263F, 22.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(72.0179F, -43.4564F, -51.5041F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(3.0368F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-7.3099F, 2.8291F, 22.4228F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.4325F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(45.5611F, 17.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-12.3337F, 32.0373F, 45.3517F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(110.6928F, 16.8855F, 4.6653F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(72.4301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-176.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-176.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-161.6655F, 82.71F, 52.489F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-110.6119F, 76.2155F, 55.9031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-110.6119F, 76.2155F, 55.9031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-56.1639F, -3.6705F, -39.9978F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(34.9604F, 6.4865F, -29.5554F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, -25.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 25.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition DoubleCombo = AnimationDefinition.Builder.withLength(2.6667F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -71.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 85.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(18.8716F, 25.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(48.7234F, -54.6296F, -46.2153F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-1.4695F, 48.1862F, 11.9249F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.6263F, 22.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(72.0179F, -43.4564F, -51.5041F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-0.9632F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.4325F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(42.5611F, 17.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(110.6928F, 16.8855F, 4.6653F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(72.4301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(106.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-176.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-176.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-161.6655F, 82.71F, 52.489F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-98.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-56.1639F, -3.6705F, -39.9978F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(11.6641F, -49.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, -25.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 25.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition DoubleComboBackFlip = AnimationDefinition.Builder.withLength(3.7917F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-215.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-342.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -71.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-25.7573F, -7.836F, -16.5861F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, -3.8612F, -0.9021F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 85.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(2.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(-1.0F, -2.7509F, -4.1156F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(18.8716F, 25.8378F, -11.1566F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(48.7234F, -54.6296F, -46.2153F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(6.5305F, 34.1862F, 5.9249F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-1.4695F, 48.1862F, 11.9249F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-15.6263F, 22.9193F, -35.6867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(72.0179F, -43.4564F, -51.5041F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(9.0368F, 24.7419F, 4.4695F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-0.9632F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.4325F, -8.2576F, 43.8091F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(42.5611F, 14.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(42.5611F, 17.8084F, 49.9334F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(107.6949F, 3.9972F, 50.8449F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(74.1178F, -46.6053F, 10.9742F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(77.3631F, -26.4251F, 62.5043F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(110.6928F, 16.8855F, 4.6653F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(72.4301F, -15.825F, -8.2493F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(106.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(40.9346F, 48.4258F, -45.9062F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-176.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-176.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-98.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-56.1639F, -3.6705F, -39.9978F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(6.6641F, -44.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(11.6641F, -49.7957F, -40.39F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-85.262F, -29.5448F, -51.4951F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition jumpSlash = AnimationDefinition.Builder.withLength(2.0833F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(7.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(237.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 1.15F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(35.27F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(34.31F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-4.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(50.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(50.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-31.67F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(137.6968F, -32.1128F, 19.2607F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-81.065F, -0.8801F, -11.0345F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-11.9244F, -12.2721F, 4.922F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-11.9244F, -12.2721F, 4.922F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-49.3335F, -15.2124F, -38.0492F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(15.6623F, -12.901F, -36.0227F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition backflipDodge = AnimationDefinition.Builder.withLength(1.5833F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-215.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-342.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.7573F, -7.836F, -16.5861F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -3.8612F, -0.9021F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(2.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-1.0F, -2.7509F, -4.1156F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(107.6949F, 3.9972F, 50.8449F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(74.1178F, -46.6053F, 10.9742F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(77.3631F, -26.4251F, 62.5043F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.9346F, 48.4258F, -45.9062F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-85.262F, -29.5448F, -51.4951F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition DoubleBackflip = AnimationDefinition.Builder.withLength(3.125F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-215.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-342.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-482.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-571.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-684.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-720.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-25.7573F, -7.836F, -16.5861F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-25.7573F, -7.836F, -16.5861F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -3.8612F, -0.9021F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -3.8612F, -0.9021F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(2.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-1.0F, -2.7509F, -4.1156F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(2.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(-1.0F, -2.7509F, -4.1156F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(107.6949F, 3.9972F, 50.8449F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(74.1178F, -46.6053F, 10.9742F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(77.3631F, -26.4251F, 62.5043F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(107.6949F, 3.9972F, 50.8449F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(74.1178F, -46.6053F, 10.9742F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(77.3631F, -26.4251F, 62.5043F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.9346F, 48.4258F, -45.9062F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(40.9346F, 48.4258F, -45.9062F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-85.262F, -29.5448F, -51.4951F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-85.262F, -29.5448F, -51.4951F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition DoubleJumpSmash = AnimationDefinition.Builder.withLength(4.3333F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(7.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(237.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(367.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(387.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(447.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(597.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.8333F, KeyframeAnimations.degreeVec(720.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(720.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 1.15F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 1.15F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(35.27F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(35.27F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(34.31F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(34.31F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-4.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(-4.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(50.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(50.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(50.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(50.2911F, -16.5897F, -18.9729F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-31.67F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-31.67F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(137.6968F, -32.1128F, 19.2607F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-81.065F, -0.8801F, -11.0345F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-11.9244F, -12.2721F, 4.922F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-11.9244F, -12.2721F, 4.922F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(137.6968F, -32.1128F, 19.2607F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-81.065F, -0.8801F, -11.0345F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-11.9244F, -12.2721F, 4.922F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-11.9244F, -12.2721F, 4.922F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-49.3335F, -15.2124F, -38.0492F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(15.6623F, -12.901F, -36.0227F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-49.3335F, -15.2124F, -38.0492F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(15.6623F, -12.901F, -36.0227F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition slamComboQuadruple = AnimationDefinition.Builder.withLength(5.4583F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.2917F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(0.0F, 408.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 9.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(65.2811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(65.2811F, 8.7709F, 3.6642F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(60.0F, -47.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.4878F, 6.8808F, 2.4345F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.4878F, 6.8808F, 2.4345F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(43.0204F, -77.141F, -57.7577F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(43.0204F, -77.141F, -57.7577F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-42.0122F, 6.8808F, 2.4345F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(-42.0122F, 6.8808F, 2.4345F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(1.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(1.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.posVec(-1.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.posVec(-1.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.posVec(0.0F, -3.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.posVec(0.0F, -3.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-47.2933F, -8.1783F, -0.2182F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 95.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-25.0209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-25.0209F, 2.2656F, -1.0571F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(53.1842F, 30.3146F, 10.5041F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(53.1842F, 30.3146F, 10.5041F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-12.3268F, -41.9245F, 18.6129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-12.3268F, -41.9245F, 18.6129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(28.1456F, 12.2504F, 8.3041F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(28.1456F, 12.2504F, 8.3041F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(1.8263F, 0.0F, 1.3801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(1.83F, 2.65F, -4.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(1.83F, -1.0F, -5.62F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(1.83F, -1.0F, -5.62F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(-0.1412F, -0.1548F, 1.9112F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(-0.1412F, -0.1548F, 1.9112F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.posVec(0.86F, -1.15F, -3.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.posVec(0.86F, -1.15F, -3.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.posVec(-0.14F, -0.15F, 1.91F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.posVec(-0.14F, -0.15F, 1.91F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(27.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(27.7909F, -3.7111F, 2.822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(6.4039F, 57.9157F, 25.032F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(52.5775F, 2.5559F, 27.6432F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(52.5775F, 2.5559F, 27.6432F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-8.6772F, -39.8773F, 2.1097F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(34.5485F, -0.5467F, 2.3917F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(26.7209F, 41.2877F, 2.9189F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(24.229F, 84.3359F, 7.0191F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(35.1383F, -32.7932F, -24.0632F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(29.5825F, -80.1593F, -29.5094F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.75F, KeyframeAnimations.degreeVec(19.8327F, -75.6F, -19.5463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(35.1383F, -32.7932F, -24.0632F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(26.0951F, 7.2818F, 4.0895F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(20.9952F, 17.4137F, -19.3492F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.09F, -3.82F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(3.0368F, 30.7419F, 8.4695F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.3099F, 2.8291F, 22.4228F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(18.747F, -36.3597F, 2.4013F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(3.7546F, -49.953F, -2.2285F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(27.5412F, -39.3711F, -0.3785F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-5.247F, -19.8692F, 0.8626F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(-6.612F, 2.4756F, -26.286F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-6.612F, 2.4756F, -26.286F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(12.165F, -17.7859F, 16.8548F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(2.0664F, -47.8746F, 27.01F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(12.165F, -17.7859F, 16.8548F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(7.3308F, -6.9727F, 4.2928F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(3.8965F, 23.3183F, -23.1818F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-98.1939F, 21.7931F, -114.0006F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-12.3337F, 32.0373F, 45.3517F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.8029F, -13.4272F, 93.8703F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(23.8028F, -73.5742F, 93.1959F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(68.7053F, -9.3378F, 133.4236F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(103.2424F, -49.2295F, 116.1802F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(105.7109F, -46.5446F, 98.7119F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(52.0095F, -16.112F, 119.0284F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-33.2381F, -54.8438F, 122.3114F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(-38.964F, -42.6611F, 106.556F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-33.2381F, -54.8438F, 122.3114F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0417F, KeyframeAnimations.degreeVec(11.8725F, -8.1161F, 84.3822F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(128.0686F, -8.6391F, 95.7572F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(135.7585F, -20.5543F, 113.5815F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2083F, KeyframeAnimations.posVec(0.6333F, -1.4279F, -4.3511F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9583F, KeyframeAnimations.posVec(0.6333F, -1.4279F, -4.3511F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.1667F, KeyframeAnimations.posVec(0.3664F, -1.19F, -0.2662F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.9167F, KeyframeAnimations.posVec(0.3664F, -1.19F, -0.2662F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(112.8619F, 7.9616F, 25.0535F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(111.2696F, 10.9034F, 15.3635F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(136.2431F, 27.0478F, 5.1652F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(151.2431F, 27.0478F, 5.1652F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(85.511F, -35.0112F, 16.3646F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(85.511F, -35.0112F, 16.3646F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(101.4115F, -0.5027F, -4.1236F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(101.4115F, -0.5027F, -4.1236F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-121.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-110.6119F, 76.2155F, 55.9031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-110.6119F, 76.2155F, 55.9031F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-21.9124F, 11.0309F, -39.7964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-21.9124F, 11.0309F, -39.7964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(-21.9124F, 11.0309F, -39.7964F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(28.9133F, -22.361F, -80.2026F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -50.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -50.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-44.5688F, -26.678F, -68.7374F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(-44.5688F, -26.678F, -68.7374F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.9167F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(50.0F, 0.0F, -25.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(34.589F, -5.7162F, 35.7189F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(38.4268F, 39.0066F, -38.4268F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.375F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition blockHitPowerful = AnimationDefinition.Builder.withLength(3.75F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-67.4792F, 27.3757F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-67.4792F, 27.3757F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, -3.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, -3.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(25.4944F, 4.755F, 10.5014F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(75.3647F, 54.1378F, 33.5671F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(75.3647F, 54.1378F, 33.5671F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(2.2271F, -0.5493F, 1.9194F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(2.2271F, -0.5493F, 1.9194F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-5.18F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-5.18F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(21.65F, 2.45F, -2.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(16.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-18.3285F, -39.2138F, 39.3752F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(16.2631F, -16.6392F, 17.2189F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(25.6458F, 10.8371F, -9.8594F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(52.2884F, 42.6478F, -3.2176F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(36.3409F, 19.7421F, -26.0592F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-77.5548F, -58.9602F, 88.2529F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-5.885F, -19.1791F, 20.711F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-10.823F, 6.2502F, -5.3543F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-22.0873F, 24.3772F, -31.0861F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-10.823F, 6.2502F, -5.3543F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.2127F, 2.6851F, -11.684F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(77.5F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-54.55F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(69.3999F, -51.2211F, 73.7765F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(75.9122F, -33.0011F, 77.0356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(75.9122F, -33.0011F, 77.0356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(40.9626F, -58.5616F, 53.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(86.0912F, -12.9301F, 65.2881F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(156.5236F, -6.0264F, 124.5068F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(156.5236F, -6.0264F, 124.5068F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(32.1873F, -1.6332F, 14.9004F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(32.1873F, -1.6332F, 14.9004F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(51.9914F, -18.5432F, 30.0379F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(84.1547F, 19.1912F, 6.9406F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(112.0832F, 4.0847F, 10.0439F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(112.0832F, 4.0847F, 10.0439F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-126.6695F, 64.5475F, 133.2051F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-128.1695F, 64.5475F, 133.2051F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-256.0127F, 10.9469F, 262.6353F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-205.0316F, 18.5013F, 152.0037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-205.0316F, 18.5013F, 152.0037F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-100.1569F, -21.3467F, -30.5515F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-100.1569F, -21.3467F, -30.5515F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(36.676F, -25.9612F, -74.2374F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(20.6613F, 37.0441F, -16.9812F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(20.6613F, 37.0441F, -16.9812F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.398F, 0.8669F, -2.8443F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-41.302F, -42.4441F, 18.0191F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-22.8241F, -49.1154F, 21.2996F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-41.302F, -42.4441F, 18.0191F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-18.2503F, 21.8517F, -16.4499F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-13.802F, -42.4441F, 18.0191F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-13.802F, -42.4441F, 18.0191F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition parryNoHit = AnimationDefinition.Builder.withLength(2.7083F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(21.65F, 2.45F, -2.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(16.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.2127F, 2.6851F, -11.684F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-54.55F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(69.3999F, -51.2211F, 73.7765F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(75.9122F, -33.0011F, 77.0356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(75.9122F, -33.0011F, 77.0356F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(32.1873F, -1.6332F, 14.9004F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(32.1873F, -1.6332F, 14.9004F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-126.6695F, 64.5475F, 133.2051F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-128.7746F, 65.3232F, 138.5203F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-128.7746F, 65.3232F, 138.5203F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-128.1695F, 64.5475F, 133.2051F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-100.1569F, -21.3467F, -30.5515F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-100.1787F, -6.2355F, -30.6997F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-100.1787F, -6.2355F, -30.6997F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-100.1569F, -21.3467F, -30.5515F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.398F, 0.8669F, -2.8443F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-41.302F, -42.4441F, 18.0191F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-41.8241F, -49.1154F, 21.2996F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-41.302F, -42.4441F, 18.0191F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition parryNoHitUpper = AnimationDefinition.Builder.withLength(2.7083F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(27.5F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.2127F, 2.6851F, -11.684F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-54.55F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(103.7224F, -24.745F, 161.9667F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(103.7224F, -24.745F, 161.9667F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 2.3461F, -0.9391F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 2.3461F, -0.9391F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(16.6598F, -6.8256F, -4.5831F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(16.6598F, -6.8256F, -4.5831F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-115.1391F, 84.3714F, 119.856F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-115.1391F, 84.3714F, 119.856F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-69.3585F, 0.3291F, -29.6774F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-69.3585F, 0.3291F, -29.6774F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(-0.6F, -0.6674F, -4.4637F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(-0.6F, -0.6674F, -4.4637F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-4.3219F, -43.2567F, 10.8019F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-4.3219F, -43.2567F, 10.8019F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(4.0F).looping()
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(23.0193F, 3.2814F, 15.3656F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.9763F, 0.2164F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.2261F, -1.607F, -7.2785F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.9763F, 0.2164F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition PowerfulJumpPre = AnimationDefinition.Builder.withLength(1.4583F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(43.8849F, 5.2117F, -12.4144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(43.8849F, 5.2117F, -12.4144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -12.0012F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-51.8162F, 32.4346F, 7.6377F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-51.8162F, 32.4346F, 7.6377F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(36.1118F, 13.1175F, 31.1463F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(2.0536F, 66.7052F, 9.4322F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(3.1273F, 4.4902F, 29.6111F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(2.3423F, -43.2131F, 61.5155F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(2.3423F, -43.2131F, 61.5155F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-145.8873F, -66.7205F, -53.6671F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, -2.7903F, -0.6717F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -2.7903F, -0.6717F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -2.0577F, 4.383F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(105.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(105.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(107.5434F, 17.107F, 3.7445F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-163.6407F, 94.3201F, 131.5391F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-163.6407F, 94.3201F, 131.5391F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-229.4338F, 9.8381F, 44.8813F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(-0.9744F, -0.2235F, -0.0258F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-0.9744F, -0.2235F, -0.0258F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-62.2565F, -32.1261F, -13.1154F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-62.2565F, -32.1261F, -13.1154F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-21.751F, -16.9741F, -42.1576F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(48.7299F, -10.5469F, 1.942F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(48.7299F, -10.5469F, 1.942F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-19.1776F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(55.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(5.76F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-27.7923F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition PowerfulJumpSwordSmash= AnimationDefinition.Builder.withLength(2.8333F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -12.0012F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(17.8076F, -10.5064F, -19.8167F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(17.8076F, -10.5064F, -19.8167F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-11.8368F, -47.7381F, 7.9885F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(17.8076F, -10.5064F, -19.8167F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(17.8076F, -10.5064F, -19.8167F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(-2.0F, -2.661F, -3.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(-2.0F, -2.661F, -3.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.001F, -2.0048F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(-2.0F, -2.661F, -3.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-2.0F, -2.661F, -3.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.1118F, 13.1175F, 31.1463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-121.6584F, -11.7035F, 9.9975F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-121.6584F, -11.7035F, 9.9975F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-81.7817F, 25.802F, -10.3781F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-121.6584F, -11.7035F, 9.9975F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-121.6584F, -11.7035F, 9.9975F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, -0.3888F, -9.5845F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -0.3888F, -9.5845F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.424F, -4.6467F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, -0.3888F, -9.5845F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -0.3888F, -9.5845F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(16.7363F, 42.406F, 24.0321F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(27.7644F, -35.9612F, -2.9562F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(27.7644F, -35.9612F, -2.9562F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-39.5781F, -1.6158F, -2.0892F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(25.7074F, -58.0565F, 10.2666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(25.7074F, -58.0565F, 10.2666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, -1.661F, -4.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -1.661F, -4.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 1.001F, -3.0048F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, -1.661F, -4.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -1.661F, -4.3852F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.0719F, 0.0636F, 16.8991F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(41.2452F, -17.5056F, -5.3009F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(41.2452F, -17.5056F, -5.3009F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(2.8858F, -0.4407F, 13.6782F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(41.2452F, -17.5056F, -5.3009F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(41.2452F, -17.5056F, -5.3009F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(64.8332F, 1.8006F, -8.3705F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(66.2965F, 14.365F, 1.9703F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-86.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(5.76F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.3333F, KeyframeAnimations.degreeVec(5.76F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-145.8873F, -66.7205F, -53.6671F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-64.9946F, -18.7002F, -5.6551F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-64.9946F, -18.7002F, -5.6551F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-140.2503F, -43.3464F, -23.1108F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-64.9946F, -18.7002F, -5.6551F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-64.9946F, -18.7002F, -5.6551F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0577F, 4.383F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(2.209F, -3.4964F, 5.4083F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(2.209F, -3.4964F, 5.4083F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(1.3311F, 1.4161F, 2.4001F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(2.209F, -3.4964F, 5.4083F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(2.209F, -3.4964F, 5.4083F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(107.5434F, 17.107F, 3.7445F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(60.7205F, -5.8261F, 33.7712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(60.7205F, -5.8261F, 33.7712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(71.5599F, -15.8122F, -4.2905F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(78.0591F, 18.172F, -0.3552F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(60.7205F, -5.8261F, 33.7712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(60.7205F, -5.8261F, 33.7712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-229.4338F, 9.8381F, 44.8813F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-229.4338F, 9.8381F, 44.8813F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-184.4338F, 9.8381F, 44.8813F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-364.1109F, 2.0947F, 177.7657F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-278.3776F, 4.9149F, 92.1872F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-278.3776F, 4.9149F, 92.1872F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(-0.97F, -0.22F, -0.03F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.751F, -16.9741F, -42.1576F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-21.75F, -16.97F, -42.16F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-19.1776F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-19.18F, -3.97F, 0.73F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.7923F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-28.585F, 8.3041F, -14.0532F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-28.585F, 8.3041F, -14.0532F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-28.585F, 8.3041F, -14.0532F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-28.59F, 8.3F, -14.05F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition PowerfulJumpFall = AnimationDefinition.Builder.withLength(0.0F).looping()
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -12.0012F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.1118F, 13.1175F, 31.1463F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.0536F, 66.7052F, 9.4322F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.1273F, 4.4902F, 29.6111F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-145.8873F, -66.7205F, -53.6671F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0577F, 4.383F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(107.5434F, 17.107F, 3.7445F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-229.4338F, 9.8381F, 44.8813F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.751F, -16.9741F, -42.1576F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-19.1776F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.7923F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition fastSweepBackFlip = AnimationDefinition.Builder.withLength(2.625F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(-215.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-342.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -82.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-25.7573F, -7.836F, -16.5861F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-2.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -3.8612F, -0.9021F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(35.6867F, 22.9193F, 15.6263F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(2.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(-1.0F, -2.7509F, -4.1156F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-1.1523F, 28.5816F, -3.7528F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-34.6328F, 33.0071F, -37.0111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(5.0F, -49.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(5.0F, -41.5F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(-0.3894F, -0.5373F, 0.7481F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-0.39F, -0.54F, 0.75F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, -10.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-20.7909F, 47.1901F, -36.6895F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(31.4092F, -40.886F, -26.8982F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(48.9367F, -66.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(43.9367F, -60.1729F, -40.2186F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-16.6248F, 22.2249F, -38.2876F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(48.7416F, -36.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(64.7416F, -53.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(55.7416F, -44.3456F, -25.6727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-48.4835F, -34.1678F, -32.5842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-70.3729F, -36.7051F, -12.9917F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-11.0214F, -18.3027F, 19.5368F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(3.3039F, -31.3237F, 37.6848F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(107.6949F, 3.9972F, 50.8449F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(74.1178F, -46.6053F, 10.9742F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(77.3631F, -26.4251F, 62.5043F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(44.705F, 3.7902F, 7.0734F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(69.7077F, -11.1844F, -7.808F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(110.6928F, 16.8855F, 4.6653F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(119.0279F, -7.2582F, -38.3918F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(40.9346F, 48.4258F, -45.9062F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-172.4223F, 68.4374F, 62.1842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-202.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-176.2672F, 95.6779F, 73.2038F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-161.5824F, 88.5274F, 122.9209F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-112.3879F, 61.0421F, 132.6942F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-74.9002F, 21.8195F, 81.9123F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-37.5F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-54.9018F, 13.962F, -52.9708F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(6.2746F, 10.4132F, -21.7314F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-85.262F, -29.5448F, -51.4951F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition betterFastSweep = AnimationDefinition.Builder.withLength(2.25F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-122.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-215.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-342.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-30.0F, -87.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-30.0F, -87.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-25.7573F, -7.836F, -16.5861F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, -2.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-3.0F, -2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -3.8612F, -0.9021F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(8.0137F, 25.7302F, 8.6853F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(8.0137F, 25.7302F, 8.6853F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-2.069F, -38.5803F, 10.0214F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-2.07F, -38.58F, 10.02F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(2.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(-1.0F, -2.7509F, -4.1156F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(19.7807F, 33.4989F, -24.5095F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.5895F, -58.8592F, 23.7506F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(2.0284F, -81.3552F, 22.2497F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-25.6179F, 66.8966F, -48.3311F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(30.6376F, -47.8049F, -7.1143F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(25.5412F, -55.7513F, -0.2295F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(7.5F, 0.0F, -28.99F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(79.1999F, 26.9462F, -13.7122F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-49.99F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(14.24F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-81.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-57.641F, -90.5692F, -98.403F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-36.7119F, -88.923F, -133.8141F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-33.3797F, -40.5093F, -67.9036F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(27.3724F, -48.5265F, -41.6192F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(27.3724F, -48.5265F, -41.6192F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(74.1178F, -46.6053F, 10.9742F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(77.3631F, -26.4251F, 62.5043F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(61.862F, -3.3812F, -15.9384F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(61.862F, -3.3812F, -15.9384F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(143.492F, -21.6643F, -28.9147F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(143.492F, -21.6643F, -28.9147F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(40.9346F, 48.4258F, -45.9062F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-48.15F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.5F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(13.1618F, 17.8849F, -39.3128F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(13.16F, 17.88F, -39.31F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-85.262F, -29.5448F, -51.4951F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
}
