package net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.PossessedArmor.PossessedPaladin;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class PossessedPaladinAnimations2 {
        public static final AnimationDefinition slashFromEnd2 = AnimationDefinition.Builder.withLength(1.5F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-12.2915F, -5.8699F, -5.2973F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(-1.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.85F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(46.4795F, 27.6219F, 30.2014F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 1.53F, -0.99F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(28.4532F, 61.6677F, 18.8945F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(13.2723F, 15.2322F, 22.4589F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(17.3153F, 24.3043F, 13.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(12.0135F, 9.3622F, 24.5338F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(93.051F, 34.9618F, 11.7494F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(39.69F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(126.9067F, 0.8173F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-16.5586F, -3.7795F, 21.4842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 3.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(126.2564F, -5.1545F, -3.0498F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-54.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -85.31F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -82.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(8.1888F, -51.595F, -14.1144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition slashFromStabEnd8 = AnimationDefinition.Builder.withLength(2.75F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-48.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-75.5189F, 54.6478F, -56.5573F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(34.497F, -14.6034F, -6.1596F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.65F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.39F, 3.0F, 0.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.77F, -0.16F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-23.7392F, -4.5674F, 5.1827F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(50.1293F, 53.9728F, 34.5843F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(136.5882F, 68.5582F, 114.0371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(180.0F, 180.0F, 180.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(53.9556F, 48.8214F, 23.145F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(109.1786F, 56.3082F, 87.3612F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(48.7261F, 19.0349F, 28.6687F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(38.9295F, -16.221F, -0.8826F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(39.9718F, -11.083F, -4.2255F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-4.8917F, 8.2386F, -0.0594F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(8.2069F, 42.492F, -14.4212F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(9.3809F, 71.1054F, 4.1385F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(5.6338F, -35.157F, 11.5351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(5.6338F, -35.157F, 11.5351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-21.9197F, -11.3234F, 3.3536F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(15.6587F, -3.2589F, 4.7585F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0442F, 2.4939F, -38.5149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(59.3545F, 51.6837F, -49.4716F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-22.43F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-78.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(49.56F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(110.8349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(109.2392F, -55.6276F, 110.7302F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(97.7295F, -2.3904F, 115.8838F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(78.3349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(75.3349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-23.9722F, 0.1642F, -1.9154F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 2.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(6.7523F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-8.2477F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(86.0336F, 6.4102F, 1.2016F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(86.0336F, 6.4102F, 1.2016F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.92F, -83.33F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-71.6896F, -21.7878F, -46.0983F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(24.7949F, -14.1838F, -66.8666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-45.548F, -41.6718F, -34.8357F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(-26.0813F, -50.3162F, -24.1921F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(24.6951F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition slashFromStabEnd7 = AnimationDefinition.Builder.withLength(2.5833F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-48.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-75.5189F, 54.6478F, -56.5573F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(34.497F, -14.6034F, -6.1596F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.65F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.39F, 3.0F, 0.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.77F, -0.16F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(-23.7392F, -4.5674F, 5.1827F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(50.1293F, 53.9728F, 34.5843F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(136.5882F, 68.5582F, 114.0371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(180.0F, 180.0F, 180.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(53.9556F, 48.8214F, 23.145F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(109.1786F, 56.3082F, 87.3612F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(48.7261F, 19.0349F, 28.6687F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(38.9295F, -16.221F, -0.8826F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(39.9718F, -11.083F, -4.2255F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-4.8917F, 8.2386F, -0.0594F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(8.2069F, 42.492F, -14.4212F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(9.3809F, 71.1054F, 4.1385F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(5.6338F, -35.157F, 11.5351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(5.6338F, -35.157F, 11.5351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-21.9197F, -11.3234F, 3.3536F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(15.6587F, -3.2589F, 4.7585F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0442F, 2.4939F, -38.5149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(59.3545F, 51.6837F, -49.4716F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-22.43F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-78.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(49.56F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(110.8349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(109.2392F, -55.6276F, 110.7302F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(97.7295F, -2.3904F, 115.8838F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(78.3349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(75.3349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-23.9722F, 0.1642F, -1.9154F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 2.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(6.7523F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-8.2477F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(86.0336F, 6.4102F, 1.2016F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(86.0336F, 6.4102F, 1.2016F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.92F, -83.33F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-71.6896F, -21.7878F, -46.0983F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(24.7949F, -14.1838F, -66.8666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-45.548F, -41.6718F, -34.8357F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-26.0813F, -50.3162F, -24.1921F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(24.6951F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
    public static final AnimationDefinition flipSmashCut = AnimationDefinition.Builder.withLength(1.625F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(7.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(237.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 1.15F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(35.27F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(34.31F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -7.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-4.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(54.933F, -25.7382F, -31.743F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(54.933F, -25.7382F, -31.743F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(-31.67F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -0.887F, 0.4617F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(42.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(3.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(137.6968F, -32.1128F, 19.2607F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-81.065F, -0.8801F, -11.0345F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-12.819F, -7.5189F, 3.1307F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-12.819F, -7.5189F, 3.1307F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(1.5474F, 0.7365F, 0.4624F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-49.3335F, -15.2124F, -38.0492F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(15.6623F, -12.901F, -36.0227F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-10.1669F, -3.9335F, -64.0065F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-10.1669F, -3.9335F, -64.0065F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition flipSmashEnd = AnimationDefinition.Builder.withLength(1.0417F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(34.1156F, -32.8817F, -18.882F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(31.12F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(-37.8174F, -22.7861F, 15.709F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(54.933F, -25.7382F, -31.743F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(15.8239F, -24.1777F, 16.8553F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(13.0507F, -0.5649F, 2.4354F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.819F, -7.5189F, 3.1307F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-93.3456F, -1.906F, -23.8271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.12F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.76F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.1669F, -3.9335F, -64.0065F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-33.3281F, 15.7237F, -48.9172F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.8398F, 0.7619F, 22.4878F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition flipSmashFlipEnd = AnimationDefinition.Builder.withLength(2.375F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(360.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(447.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(597.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(720.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(720.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(142.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(34.1156F, -32.8817F, -18.882F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(31.12F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-37.8174F, -22.7861F, 15.709F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -7.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(72.06F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(54.933F, -25.7382F, -31.743F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(54.933F, -25.7382F, -31.743F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(54.933F, -25.7382F, -31.743F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(15.8239F, -24.1777F, 16.8553F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -7.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-31.67F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(13.0507F, -0.5649F, 2.4354F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.887F, 0.4617F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(42.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(3.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.819F, -7.5189F, 3.1307F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-81.065F, -0.8801F, -11.0345F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-12.819F, -7.5189F, 3.1307F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-12.819F, -7.5189F, 3.1307F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-93.3456F, -1.906F, -23.8271F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(1.5474F, 0.7365F, 0.4624F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.12F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(16.0898F, 2.2746F, -10.2051F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.76F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.1669F, -3.9335F, -64.0065F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.2083F, KeyframeAnimations.degreeVec(15.6623F, -12.901F, -36.0227F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-10.1669F, -3.9335F, -64.0065F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-10.1669F, -3.9335F, -64.0065F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-33.3281F, 15.7237F, -48.9172F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-1.8398F, 0.7619F, 22.4878F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
        public static final AnimationDefinition throw3 = AnimationDefinition.Builder.withLength(2.1667F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(27.8898F, 0.7688F, -10.1167F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(37.8898F, 0.7688F, -10.1167F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(12.5F, 35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-0.911F, -9.6808F, 5.2125F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-4.911F, -16.6808F, 5.2125F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(1.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(33.4919F, 40.081F, 21.9105F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(32.7861F, -37.1299F, -24.1399F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(11.3618F, -55.8679F, -3.3611F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(1.6305F, -31.2741F, 5.4056F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(8.0634F, 21.0759F, 21.5024F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(4.8137F, 0.2684F, -1.8828F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(5.546F, -26.661F, -8.3075F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-2.7901F, -16.0114F, 15.9656F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(68.2834F, -15.4697F, 23.873F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(21.0223F, 10.3017F, -29.0874F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-86.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(107.1429F, -10.2473F, 95.2763F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(130.1429F, -10.2473F, 119.2763F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-51.1265F, 10.7825F, -73.4214F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-143.9699F, -22.0494F, -119.5782F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-113.425F, -32.5973F, -119.3868F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-30.3342F, -17.5245F, -88.4533F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-13.4934F, -20.7509F, -48.2595F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-31.0854F, -11.2694F, -23.0793F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -0.5F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("dagger", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-5.157F, 93.2623F, -27.6301F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-175.8457F, 87.4563F, -176.0659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-175.8457F, 87.4563F, -176.0659F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("dagger", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.624F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();
        public static final AnimationDefinition Throw = AnimationDefinition.Builder.withLength(2.0417F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(27.8898F, 0.7688F, -10.1167F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(37.8898F, 0.7688F, -10.1167F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.5F, 35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(12.5F, 35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-0.911F, -9.6808F, 5.2125F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-4.911F, -16.6808F, 5.2125F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.posVec(1.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.posVec(1.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.posVec(1.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(33.4919F, 40.081F, 21.9105F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(66.5107F, 61.9182F, 60.8825F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.8333F, KeyframeAnimations.degreeVec(38.7076F, 26.8244F, 32.0081F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9583F, KeyframeAnimations.degreeVec(32.7861F, -37.1299F, -24.1399F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(11.3618F, -55.8679F, -3.3611F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(8.0634F, 21.0759F, 21.5024F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(10.0634F, 25.0759F, 26.5024F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(4.8137F, 0.2684F, -1.8828F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(5.546F, -26.661F, -8.3075F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(17.5F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.0F, KeyframeAnimations.degreeVec(68.2834F, -15.4697F, 23.873F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.5F, KeyframeAnimations.degreeVec(-86.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(107.1429F, -10.2473F, 95.2763F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(130.1429F, -10.2473F, 119.2763F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-143.9699F, -22.0494F, -119.5782F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-162.9699F, -22.0494F, -116.5782F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-113.425F, -32.5973F, -119.3868F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-30.3342F, -17.5245F, -88.4533F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-13.4934F, -20.7509F, -48.2595F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -0.5F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("dagger", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-175.8457F, 87.4563F, -176.0659F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-175.8457F, 87.4563F, -176.0659F), AnimationChannel.Interpolations.CATMULLROM),
                new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("dagger", new AnimationChannel(AnimationChannel.Targets.SCALE,
			new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                new Keyframe(0.874F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                new Keyframe(0.875F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();
        public static final AnimationDefinition slashFromCut = AnimationDefinition.Builder.withLength(1.0F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-1.7342F, -65.9575F, -9.8954F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(-1.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(13.77F, -0.16F, 0.75F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-39.2315F, -37.7612F, 26.5651F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -2.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(8.9834F, -7.1089F, -0.5454F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(20.1799F, -59.0726F, -10.2519F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(28.5314F, -68.2107F, -19.5389F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(21.9454F, -29.5016F, -3.4396F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(41.911F, -44.9064F, 51.0379F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-9.5367F, -56.1603F, 112.0319F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-9.0481F, -31.9879F, 105.586F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(37.2259F, -19.0754F, 113.8205F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(2.0F, -2.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(65.0554F, -1.0982F, 13.3082F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(65.5456F, -2.4298F, 29.4443F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(58.0456F, -2.4298F, 29.4443F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(86.3982F, 13.519F, 14.5513F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 2.9502F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -82.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -82.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.0F, 0.92F, -83.33F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition slashFromEnd = AnimationDefinition.Builder.withLength(1.5F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-12.2915F, -5.8699F, -5.2973F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(-1.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.85F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(46.4795F, 27.6219F, 30.2014F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 1.53F, -0.99F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(16.2343F, 36.0214F, 3.111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(13.2723F, 15.2322F, 22.4589F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(17.3153F, 24.3043F, 13.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(12.0135F, 9.3622F, 24.5338F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(93.051F, 34.9618F, 11.7494F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(39.69F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(126.9067F, 0.8173F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-16.5586F, -3.7795F, 21.4842F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 3.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(126.2564F, -5.1545F, -3.0498F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-54.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -85.31F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -82.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(8.1888F, -51.595F, -14.1144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition slashFromStabEnd = AnimationDefinition.Builder.withLength(2.5F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-12.2915F, -5.8699F, -5.2973F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(34.9444F, -53.0463F, -21.5838F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(34.9444F, -53.0463F, -21.5838F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(34.9444F, -53.0463F, -21.5838F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-1.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(-2.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.77F, -0.16F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(4.4384F, 3.7317F, -17.1097F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(4.4384F, 3.7317F, -17.1097F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(4.4384F, 3.7317F, -17.1097F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(46.4795F, 27.6219F, 30.2014F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(47.4584F, 63.9833F, 39.5755F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(47.4584F, 63.9833F, 39.5755F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-5.234F, -7.5815F, 8.839F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-5.234F, -7.5815F, 8.839F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-5.234F, -7.5815F, 8.839F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(2.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(2.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-12.5214F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-12.5214F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(4.9786F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(4.9786F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(4.9786F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(16.2343F, 66.0214F, 30.111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(57.3542F, 63.3945F, 38.7512F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(31.4416F, -9.7252F, -10.0174F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(43.15F, -52.1513F, -38.812F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(29.5756F, -39.7671F, -27.9375F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-8.8463F, -18.6124F, 4.3058F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(23.3153F, 43.3043F, 32.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(17.9561F, 34.9411F, 39.5579F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(2.4234F, -18.909F, 8.4108F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(2.4234F, -25.909F, 4.4108F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(2.4234F, -18.909F, 4.4108F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-2.5212F, -9.3721F, 25.1657F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(93.051F, 34.9618F, 11.7494F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(62.2966F, -2.0683F, -36.264F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(5.4342F, 1.4562F, -10.2712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(39.69F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(45.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-66.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(136.6302F, -69.068F, 94.8402F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(115.6302F, -51.068F, 76.8402F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(48.0207F, 24.6702F, 55.1212F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(11.8796F, 25.1402F, 27.1298F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(8.8796F, 25.1402F, 25.1298F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(8.7434F, 23.7611F, 25.3537F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 2.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(11.4432F, -15.6721F, -4.5958F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(19.9232F, 9.9645F, -26.9384F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(79.4063F, 8.7928F, 5.452F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(79.4063F, 8.7928F, 5.452F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(79.4063F, 8.7928F, 5.452F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-54.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-105.9138F, 28.4272F, 94.5761F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-105.9138F, 28.4272F, 94.5761F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-360.7209F, 0.478F, 277.7201F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-360.7209F, 0.478F, 277.7201F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-360.7209F, 0.478F, 277.7201F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.92F, -83.33F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -82.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-22.704F, -20.9839F, -63.6912F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-22.704F, -20.9839F, -63.6912F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-22.7F, -20.98F, -63.69F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-22.7F, -20.98F, -63.69F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(8.1888F, -51.595F, -14.1144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(8.1888F, -51.595F, -14.1144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(5.7514F, 27.9995F, -4.9733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(5.7514F, 27.9995F, -4.9733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(5.7514F, 27.9995F, -4.9733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition slashFromStabEnd3 = AnimationDefinition.Builder.withLength(2.5833F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-12.2915F, -5.8699F, -5.2973F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(40.5585F, -26.0054F, -35.2319F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(40.5585F, -26.0054F, -35.2319F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-1.0F, -1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(-2.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.77F, -0.16F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-4.2086F, -0.2399F, 25.2335F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-4.2086F, -0.2399F, 25.2335F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-4.2086F, -0.2399F, 25.2335F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(46.4795F, 27.6219F, 30.2014F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(47.4584F, 63.9833F, 39.5755F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(47.4584F, 63.9833F, 39.5755F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-42.734F, -7.5815F, 8.839F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-42.734F, -7.5815F, 8.839F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(2.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(2.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(1.0F, -3.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-12.5214F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-12.5214F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(39.9786F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(39.9786F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(39.9786F, 0.3262F, -7.4929F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(16.2343F, 66.0214F, 30.111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(57.3542F, 63.3945F, 38.7512F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(31.4416F, -9.7252F, -10.0174F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(43.15F, -52.1513F, -38.812F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(35.5756F, -45.7671F, -31.9375F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-8.8463F, -18.6124F, 4.3058F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(23.3153F, 43.3043F, 32.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(17.9561F, 34.9411F, 39.5579F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.4234F, -18.909F, 8.4108F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(2.4234F, -25.909F, 1.4108F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(2.4234F, -18.909F, 4.4108F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-2.5212F, -9.3721F, 25.1657F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(93.051F, 34.9618F, 11.7494F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(62.2966F, -2.0683F, -36.264F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(5.4342F, 1.4562F, -10.2712F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(39.69F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(45.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-66.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(136.6302F, -69.068F, 94.8402F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(115.6302F, -51.068F, 76.8402F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(41.802F, 35.8346F, 62.3426F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(41.802F, 35.8346F, 62.3426F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(41.802F, 35.8346F, 62.3426F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(8.7434F, 23.7611F, 5.3537F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 2.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(11.4432F, -15.6721F, -4.5958F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(19.9232F, 9.9645F, -26.9384F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(88.4063F, 14.7928F, 5.452F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(88.4063F, 14.7928F, 5.452F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(88.4063F, 14.7928F, 5.452F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-54.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-105.9138F, 28.4272F, 94.5761F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-105.9138F, 28.4272F, 94.5761F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-360.7209F, 0.478F, 277.7201F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-360.7209F, 0.478F, 277.7201F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-360.7209F, 0.478F, 277.7201F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.92F, -83.33F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -82.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(-22.704F, -20.9839F, -63.6912F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-70.2F, -20.98F, -63.69F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-70.2F, -20.98F, -63.69F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-70.2F, -20.98F, -63.69F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(8.1888F, -51.595F, -14.1144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(8.1888F, -51.595F, -14.1144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.7514F, 27.9995F, -4.9733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(5.7514F, 27.9995F, -4.9733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5833F, KeyframeAnimations.degreeVec(5.7514F, 27.9995F, -4.9733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition slashStabFromGrabPre2 = AnimationDefinition.Builder.withLength(1.4167F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-48.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-75.5189F, 54.6478F, -56.5573F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.77F, -0.16F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(50.1293F, 53.9728F, 34.5843F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(136.5882F, 68.5582F, 114.0371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(53.9556F, 48.8214F, 23.145F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(109.1786F, 56.3082F, 87.3612F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2917F, KeyframeAnimations.degreeVec(48.7261F, 19.0349F, 28.6687F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(45.7217F, -30.1525F, -12.926F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(8.2069F, 42.492F, -14.4212F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(9.3809F, 71.1054F, 4.1385F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(4.9067F, -20.2194F, 13.0867F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(15.6587F, -3.2589F, 4.7585F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(10.0442F, 2.4939F, -38.5149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(42.94F, 35.38F, -50.7F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-22.43F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-65.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(71.3726F, 1.0459F, 41.8407F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(110.8349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(109.2392F, -55.6276F, 110.7302F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(97.7295F, -2.3904F, 115.8838F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.64F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 2.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(6.7523F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-8.2477F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(49.91F, -5.06F, -6.78F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-123.9326F, 81.4001F, 116.7928F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-123.9326F, 81.4001F, 116.7928F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-120.6833F, 97.7242F, 45.9473F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.92F, -83.33F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-71.6896F, -21.7878F, -46.0983F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(24.7949F, -14.1838F, -66.8666F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-1.45F, 28.42F, 18.3F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition slashStabFromGrabPre = AnimationDefinition.Builder.withLength(1.2083F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-48.3115F, 26.6663F, -14.5588F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-75.5189F, 54.6478F, -56.5573F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-3.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.77F, -0.16F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(43.3116F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.8554F, 48.9401F, 68.8706F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(50.1293F, 53.9728F, 34.5843F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(136.5882F, 68.5582F, 114.0371F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(2.0F, -1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.2343F, 23.0214F, -1.889F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(53.9556F, 48.8214F, 23.145F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(109.1786F, 56.3082F, 87.3612F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(48.7261F, 19.0349F, 28.6687F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(45.7217F, -30.1525F, -12.926F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.3153F, 18.3043F, 11.747F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(8.2069F, 42.492F, -14.4212F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(9.3809F, 71.1054F, 4.1385F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(4.9067F, -20.2194F, 13.0867F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(80.69F, 30.32F, 15.09F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(15.6587F, -3.2589F, 4.7585F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(10.0442F, 2.4939F, -38.5149F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(42.94F, 35.38F, -50.7F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-76.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-22.43F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-65.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(110.9067F, -8.1827F, 86.1008F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(71.3726F, 1.0459F, 41.8407F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(110.8349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(109.2392F, -55.6276F, 110.7302F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(97.7295F, -2.3904F, 115.8838F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.64F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(117.2564F, -5.1545F, 2.9502F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(6.7523F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-8.2477F, -4.8543F, -19.6351F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(49.91F, -5.06F, -6.78F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-123.9326F, 81.4001F, 116.7928F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-123.9326F, 81.4001F, 116.7928F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-120.6833F, 97.7242F, 45.9473F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.92F, -83.33F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-71.6896F, -21.7878F, -46.0983F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(24.7949F, -14.1838F, -66.8666F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-10.3049F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.45F, 28.42F, 18.3F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.1589F, -1.9768F, -11.8727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-3.9173F, -60.6448F, 3.3733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition slashFromStabGrabFail = AnimationDefinition.Builder.withLength(1.5F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(34.497F, -14.6034F, -6.1596F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.65F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.39F, 3.0F, 0.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-23.7392F, -4.5674F, 5.1827F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(180.0F, 180.0F, 180.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(45.7217F, -30.1525F, -12.926F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(40.1896F, -34.6698F, -19.7203F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-4.8917F, 8.2386F, -0.0594F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.9067F, -20.2194F, 13.0867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(4.9067F, -29.2194F, 13.0867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-21.9197F, -11.3234F, 3.3536F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.94F, 35.38F, -50.7F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(59.3545F, 51.6837F, -49.4716F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(-78.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(49.56F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(97.7295F, -2.3904F, 115.8838F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(78.3349F, -1.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(75.3349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-23.9722F, 0.1642F, -1.9154F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.64F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(49.91F, -5.06F, -6.78F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(93.5297F, -5.2199F, 2.8575F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(86.0336F, 6.4102F, 1.2016F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(76.2443F, 9.7422F, 18.8525F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-120.6833F, 97.7242F, 45.9473F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-120.6833F, 97.7242F, 45.9473F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-130.7102F, 55.5841F, 87.3602F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(24.7949F, -14.1838F, -66.8666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-45.548F, -41.6718F, -34.8357F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-26.0813F, -50.3162F, -24.1921F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.45F, 28.42F, 18.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(24.6951F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition slashFromStabGrabSuccess = AnimationDefinition.Builder.withLength(7.5F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(44.51F, -9.06F, -14.21F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(45.5985F, -14.3749F, -20.4282F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(44.51F, -9.06F, -14.21F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(34.51F, -31.56F, -24.21F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(34.51F, -31.56F, -24.21F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(80.6562F, -40.0016F, -55.8942F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(52.5563F, -50.2779F, -37.258F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-40.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.25F, KeyframeAnimations.degreeVec(-40.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5833F, KeyframeAnimations.degreeVec(46.2501F, -63.6708F, -21.4357F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(46.2501F, -63.6708F, -21.4357F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(-1.0F, -2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(-1.0F, -2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.2917F, KeyframeAnimations.posVec(0.06F, 2.94F, -0.12F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.posVec(1.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.25F, KeyframeAnimations.posVec(1.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5833F, KeyframeAnimations.posVec(-3.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.posVec(-3.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-9.19F, -7.06F, 3.01F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-9.19F, -7.06F, 3.01F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(-24.19F, 27.94F, 18.01F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-24.19F, 27.94F, 0.51F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(47.5F, -13.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(59.3571F, -14.3772F, -10.1554F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-11.4464F, -16.7346F, 0.1936F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(-11.4464F, -16.7346F, 0.1936F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(141.59F, 193.56F, 186.54F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(141.59F, 193.56F, 186.54F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(164.09F, 228.56F, 201.54F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(164.09F, 228.56F, 201.54F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(114.09F, 173.56F, 186.54F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(134.09F, 158.56F, 174.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(222.5F, 150.0F, 200.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.25F, KeyframeAnimations.degreeVec(222.5F, 117.5F, 200.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.5833F, KeyframeAnimations.degreeVec(130.0F, 270.0F, 205.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.1667F, KeyframeAnimations.degreeVec(270.0F, 280.0F, 65.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.6667F, KeyframeAnimations.degreeVec(298.75F, 363.12F, 13.75F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.0417F, KeyframeAnimations.degreeVec(360.07F, 367.78F, 4.67F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(360.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(1.0F, -4.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(1.0F, -3.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(5.5833F, KeyframeAnimations.posVec(2.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.1667F, KeyframeAnimations.posVec(2.0F, -3.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(6.6667F, KeyframeAnimations.posVec(-1.0F, 0.5F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(37.0178F, 9.7328F, 3.2117F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(37.0178F, 9.7328F, 3.2117F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-5.48F, 9.73F, 0.71F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-5.48F, 9.73F, 0.71F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(62.5827F, -4.6558F, 2.5532F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(42.5827F, -4.6558F, 2.5532F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.7917F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(45.7217F, -30.1525F, -12.926F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-6.379F, -54.3214F, 12.095F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-20.71F, -54.0429F, 22.0873F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-6.379F, -54.3214F, 12.095F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-30.3007F, -47.8296F, 42.5131F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-49.1629F, -33.7536F, 57.6634F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0417F, KeyframeAnimations.degreeVec(20.7536F, -56.4805F, -4.9125F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(78.6041F, -29.0277F, -47.0173F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(86.1806F, -36.0816F, -42.4701F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.2917F, KeyframeAnimations.degreeVec(23.5188F, -30.3495F, -21.7181F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(31.5252F, 10.0591F, -4.5032F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(35.1899F, 67.9465F, -7.0656F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.375F, KeyframeAnimations.degreeVec(57.0676F, 2.7096F, -13.4044F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(38.7619F, -43.2205F, 2.873F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(50.8363F, -53.9536F, -13.1115F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.9167F, KeyframeAnimations.degreeVec(7.87F, -8.78F, -11.92F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.9067F, -20.2194F, 13.0867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-13.0087F, -8.4075F, 12.816F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-15.7465F, -6.4244F, 17.473F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-13.0087F, -8.4075F, 12.816F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-14.4875F, -5.4254F, 25.0459F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-16.5881F, -0.3204F, 35.4936F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(6.5545F, -10.5992F, -24.4727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(10.5545F, -10.5992F, -29.4727F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.2917F, KeyframeAnimations.degreeVec(1.03F, 11.17F, 25.74F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-9.3175F, 30.4754F, -23.2949F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-28.8333F, 48.6123F, -58.0832F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.375F, KeyframeAnimations.degreeVec(-2.0F, 11.04F, 4.95F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(18.237F, -38.8544F, 34.6472F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(18.737F, -38.8544F, 34.6472F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.9167F, KeyframeAnimations.degreeVec(31.32F, -7.89F, -5.46F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.94F, 35.38F, -50.7F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(20.3766F, -14.0105F, -2.8495F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(17.4806F, 3.6637F, -56.4284F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(13.947F, 11.2504F, -83.1114F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(104.9992F, 52.0954F, -31.3701F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-0.2672F, 12.9427F, 54.5641F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-0.3059F, -0.7837F, 18.9562F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(85.6676F, -0.4472F, -59.3991F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(11.7123F, 2.1363F, 24.1705F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-25.04F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-29.01F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-29.01F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(-105.75F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(36.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.125F, KeyframeAnimations.degreeVec(-75.04F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-15.12F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-91.75F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0F, KeyframeAnimations.degreeVec(34.34F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.875F, KeyframeAnimations.degreeVec(-62.47F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(97.7295F, -2.3904F, 115.8838F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(82.985F, -35.5142F, 116.0101F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(82.1233F, -37.0924F, 118.4499F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(82.985F, -35.5142F, 116.0101F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-7.2111F, 38.7582F, 29.0475F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-67.7111F, 52.7582F, 13.0475F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-131.5962F, 9.5878F, -32.13F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(-129.2381F, 11.2841F, -34.7722F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-97.134F, -71.7645F, -61.4878F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-93.319F, -58.2708F, -68.222F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.375F, KeyframeAnimations.degreeVec(-41.5602F, -82.3972F, -52.1332F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-12.7466F, -48.3253F, -7.1509F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(-12.7466F, -48.3253F, -7.1509F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.7917F, KeyframeAnimations.degreeVec(-103.9154F, -25.2575F, -38.4418F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.64F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.64F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(1.0F, 2.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.7917F, KeyframeAnimations.posVec(0.5019F, 1.4906F, 1.2354F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(49.91F, -5.06F, -6.78F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(92.41F, -5.06F, -6.78F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(92.41F, -5.06F, -6.78F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(49.91F, -5.06F, -6.78F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(42.91F, -5.06F, -6.78F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(97.2523F, 0.3386F, -25.3181F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(97.2523F, 0.3386F, -25.3181F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.2917F, KeyframeAnimations.degreeVec(73.7712F, 30.7072F, -29.65F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(87.5282F, -0.6518F, -4.9574F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(70.5282F, -0.6518F, -4.9574F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.375F, KeyframeAnimations.degreeVec(114.2593F, 9.8165F, 3.5781F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(124.1305F, 47.6993F, -31.3459F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(124.1305F, 47.6993F, -31.3459F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.7917F, KeyframeAnimations.degreeVec(49.7854F, 8.4799F, -2.1158F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(7.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-120.6833F, 97.7242F, 45.9473F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-95.9531F, 103.1971F, 52.6332F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-95.9531F, 103.1971F, 52.6332F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-136.8986F, 31.5535F, 8.9109F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-199.9955F, 21.3451F, 10.5726F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-159.7467F, 14.3458F, -13.9907F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.875F, KeyframeAnimations.degreeVec(-159.7467F, 14.3458F, -13.9907F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-186.82F, 10.3171F, -10.0617F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-117.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(-117.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(24.7949F, -14.1838F, -66.8666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-20.21F, -69.18F, -66.87F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-20.21F, -69.18F, -66.87F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-29.9503F, -5.8802F, -139.1955F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(-55.281F, -19.6928F, -34.6332F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-55.281F, -19.6928F, -34.6332F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-52.6106F, -37.3316F, -18.6733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-52.6106F, -37.3316F, -18.6733F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-10.2688F, -61.07F, -45.1078F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.0833F, KeyframeAnimations.degreeVec(-10.2688F, -61.07F, -45.1078F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.7083F, KeyframeAnimations.degreeVec(-38.0515F, -14.5288F, -26.6306F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.45F, 28.42F, 18.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-1.45F, 28.42F, 18.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-1.45F, 28.42F, 18.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.4167F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.4167F, KeyframeAnimations.degreeVec(5.9834F, 30.3059F, -10.1801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(5.9834F, 30.3059F, -10.1801F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-4.4927F, 43.5108F, 41.098F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.125F, KeyframeAnimations.degreeVec(-24.2553F, 63.5445F, -23.2299F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-24.2553F, 63.5445F, -23.2299F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(4.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(5.5417F, KeyframeAnimations.degreeVec(4.257F, -18.1033F, 9.5244F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.2917F, KeyframeAnimations.degreeVec(4.257F, -18.1033F, 9.5244F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(6.7917F, KeyframeAnimations.degreeVec(-2.3171F, 38.4116F, 6.7649F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(7.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition walkToTheLeft = AnimationDefinition.Builder.withLength(1.5F).looping()
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-72.7389F, -44.1958F, 30.6883F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(10.4138F, -37.1586F, -13.5129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -1.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(50.88F, 37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(14.6218F, 1.0524F, 14.5639F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -22.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 37.5F, 22.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-45.0F, 10.0F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -22.5F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-6.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition walkToTheRight = AnimationDefinition.Builder.withLength(1.5F).looping()
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -37.5F, -22.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(-45.0F, -10.0F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-72.7389F, 44.1958F, -30.6883F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(10.4138F, 37.1586F, 13.5129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, -1.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(50.88F, -37.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(14.6218F, -1.0524F, -14.5639F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-6.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5833F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition slashFromStabGrabFail2 = AnimationDefinition.Builder.withLength(1.5F)
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(44.7322F, -8.8779F, -1.9987F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(34.497F, -14.6034F, -6.1596F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.65F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.39F, 3.0F, 0.72F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-21.6884F, -7.058F, 8.0089F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-23.7392F, -4.5674F, 5.1827F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(156.59F, 161.06F, 204.04F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(180.0F, 180.0F, 180.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(31.5989F, 5.4737F, -23.1372F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(45.7217F, -30.1525F, -12.926F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(40.1896F, -34.6698F, -19.7203F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-4.8917F, 8.2386F, -0.0594F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.9067F, -20.2194F, 13.0867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(4.9067F, -29.2194F, 13.0867F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-21.9197F, -11.3234F, 3.3536F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.94F, 35.38F, -50.7F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(59.3545F, 51.6837F, -49.4716F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.52F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-78.39F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.7083F, KeyframeAnimations.degreeVec(49.56F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(97.7295F, -2.3904F, 115.8838F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(78.3349F, -1.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(75.3349F, -9.442F, 122.2546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-23.9722F, 0.1642F, -1.9154F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.64F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(49.91F, -5.06F, -6.78F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(93.5297F, -5.2199F, 2.8575F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(86.0336F, 6.4102F, 1.2016F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.8333F, KeyframeAnimations.degreeVec(76.2443F, 9.7422F, 18.8525F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-120.6833F, 97.7242F, 45.9473F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-120.6833F, 97.7242F, 45.9473F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-130.7102F, 55.5841F, 87.3602F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(24.7949F, -14.1838F, -66.8666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-45.548F, -41.6718F, -34.8357F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-26.0813F, -50.3162F, -24.1921F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.45F, 28.42F, 18.3F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(24.6951F, 27.6453F, 17.8084F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-2.2578F, 31.778F, -1.2318F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition JumpPre = AnimationDefinition.Builder.withLength(1.6667F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(43.8849F, 5.2117F, -12.4144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(43.8849F, 5.2117F, -12.4144F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -12.0012F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-51.8162F, 32.4346F, 7.6377F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-51.8162F, 32.4346F, 7.6377F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(36.1118F, 13.1175F, 31.1463F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(47.5236F, -2.1649F, -1.2506F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(55.0264F, -1.9832F, -1.5225F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(2.0536F, 66.7052F, 9.4322F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(54.2065F, 12.0174F, 16.1064F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(63.2009F, 12.4823F, 16.6006F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(54.2065F, 12.0174F, 16.1064F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(3.1273F, 4.4902F, 29.6111F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(55.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(38.26F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(65.3982F, -28.0032F, 89.0585F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(65.3982F, -28.0032F, 89.0585F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(95.0687F, -57.554F, 64.4844F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -2.7903F, -0.6717F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -2.7903F, -0.6717F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, -2.79F, -0.67F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-37.5842F, 47.7098F, -68.143F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-37.5842F, 47.7098F, -68.143F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(112.7665F, 87.0201F, 1.1544F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-306.8342F, 5.0381F, 288.8499F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-306.8342F, 5.0381F, 288.8499F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(-0.9744F, -0.2235F, -0.0258F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(-0.9744F, -0.2235F, -0.0258F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(-0.97F, -0.22F, -0.03F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-107.2565F, -32.1261F, -13.1154F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-132.1401F, -37.9627F, -11.5676F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-6.6431F, -31.2867F, -110.0218F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(48.7299F, -10.5469F, 1.942F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(48.7299F, -10.5469F, 1.942F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-19.1776F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-85.7474F, -17.061F, -11.2942F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-85.7474F, -17.061F, -11.2942F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-27.7923F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition JumpFall = AnimationDefinition.Builder.withLength(0.0F).looping()
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -12.0012F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
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
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.0536F, 66.7052F, 9.4322F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
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
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(95.0687F, -57.554F, 64.4844F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.79F, -0.67F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(112.7665F, 87.0201F, 1.1544F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-0.97F, -0.22F, -0.03F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.6431F, -31.2867F, -110.0218F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-19.1776F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.7923F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();

        public static final AnimationDefinition JumpSlam = AnimationDefinition.Builder.withLength(2.8333F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -7.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -7.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -12.0012F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-4.4071F, -29.8276F, 4.3463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-4.4071F, -29.8276F, 4.3463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-83.8982F, -26.3834F, 3.8444F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.774F, 0.9235F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 1.774F, 0.9235F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(19.7252F, -1.231F, -3.0384F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(19.7252F, -1.231F, -3.0384F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(87.4475F, -1.0889F, -2.6875F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.1118F, 13.1175F, 31.1463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-88.518F, -12.2122F, 9.3923F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-88.518F, -12.2122F, 9.3923F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(16.4618F, -6.179F, 12.2064F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(1.0F, 1.847F, -3.548F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.3F, 1.5417F, -0.9318F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-7.51F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.0536F, 66.7052F, 9.4322F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(15.9713F, -33.2777F, 7.0129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(15.9713F, -44.2777F, 7.0129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(22.2836F, -32.2217F, 15.8715F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-29.5362F, -18.1943F, 21.0459F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -0.887F, -0.4617F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.1273F, 4.4902F, 29.6111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(18.9914F, 33.6383F, 26.4714F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(28.4327F, 5.3902F, 4.5324F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(28.4327F, 5.3902F, 4.5324F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-7.5752F, -0.5004F, 14.6608F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-0.176F, -0.7746F, -0.6074F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(107.3207F, 0.0F, -32.5806F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-17.8924F, 9.0866F, 26.0666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-10.7135F, -11.8443F, 14.7205F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(19.9667F, 14.7704F, -21.9F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-91.28F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-34.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(95.0687F, -57.554F, 64.4844F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(86.9565F, -43.9058F, 136.8331F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(83.6205F, -35.0452F, 149.9075F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(70.6535F, -32.0679F, 154.5562F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-52.12F, -9.0254F, -3.9214F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.79F, -0.67F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(-1.7076F, 1.4621F, -0.5981F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.1631F, 0.4596F, -3.4123F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(-1.7076F, 1.4621F, -0.5981F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(112.7665F, 87.0201F, 1.1544F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(104.8818F, 76.5701F, 18.3592F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(94.2317F, 9.6171F, 15.7404F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(94.2352F, -7.8814F, 15.9737F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-33.167F, -43.9439F, 144.4361F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(46.1697F, -28.8316F, 95.4654F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(175.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.2083F, KeyframeAnimations.degreeVec(155.84F, 15.25F, -147.69F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(72.292F, 6.0954F, -59.0342F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-0.97F, -0.22F, -0.03F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.6431F, -31.2867F, -110.0218F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(15.5309F, -3.5815F, -53.5831F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-47.8093F, -27.0185F, -39.0711F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(33.5141F, -42.4445F, -61.1709F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-19.1776F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(37.239F, -0.1083F, 30.5061F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(3.3224F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-55.4577F, -2.3113F, -1.5392F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.7923F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(7.2077F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(7.2077F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-14.4572F, 30.8479F, -11.8437F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
        public static final AnimationDefinition JumpSlamLonger = AnimationDefinition.Builder.withLength(3.25F)
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -7.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -7.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, -7.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -12.0012F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-4.4071F, -29.8276F, 4.3463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-4.4071F, -29.8276F, 4.3463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-4.4071F, -29.8276F, 4.3463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-83.8982F, -26.3834F, 3.8444F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.774F, 0.9235F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 1.774F, 0.9235F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 1.774F, 0.9235F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(19.7252F, -1.231F, -3.0384F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(19.7252F, -1.231F, -3.0384F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(19.7252F, -1.231F, -3.0384F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(87.4475F, -1.0889F, -2.6875F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.1118F, 13.1175F, 31.1463F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-88.518F, -12.2122F, 9.3923F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-88.518F, -12.2122F, 9.3923F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-88.518F, -12.2122F, 9.3923F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(16.4618F, -6.179F, 12.2064F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(1.0F, 1.847F, -3.548F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.3F, 1.5417F, -0.9318F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-7.51F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.0536F, 66.7052F, 9.4322F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(15.9713F, -33.2777F, 7.0129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(15.9713F, -44.2777F, 7.0129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(18.1012F, -45.7098F, 6.4936F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(15.9713F, -44.2777F, 7.0129F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(22.2836F, -32.2217F, 15.8715F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-29.5362F, -18.1943F, 21.0459F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -0.887F, -0.4617F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.1273F, 4.4902F, 29.6111F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(18.9914F, 33.6383F, 26.4714F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(28.4327F, 5.3902F, 4.5324F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(28.4327F, 5.3902F, 4.5324F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(40.5434F, 5.7355F, 3.9386F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(28.4327F, 5.3902F, 4.5324F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-7.5752F, -0.5004F, 14.6608F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-0.176F, -0.7746F, -0.6074F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(107.3207F, 0.0F, -32.5806F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-17.8924F, 9.0866F, 26.0666F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-10.7135F, -11.8443F, 14.7205F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(19.9667F, 14.7704F, -21.9F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lower", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-91.28F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-34.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(95.0687F, -57.554F, 64.4844F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(86.9565F, -43.9058F, 136.8331F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(83.6205F, -35.0452F, 149.9075F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(70.6535F, -32.0679F, 154.5562F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(70.6535F, -32.0679F, 154.5562F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-52.12F, -9.0254F, -3.9214F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.79F, -0.67F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(-1.7076F, 1.4621F, -0.5981F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.1631F, 0.4596F, -3.4123F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(-1.7076F, 1.4621F, -0.5981F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(-1.7076F, 1.4621F, -0.5981F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(112.7665F, 87.0201F, 1.1544F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(104.8818F, 76.5701F, 18.3592F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(94.2317F, 9.6171F, 15.7404F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(94.2352F, -7.8814F, 15.9737F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(94.2352F, -7.8814F, 15.9737F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-33.167F, -43.9439F, 144.4361F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.6667F, KeyframeAnimations.degreeVec(46.1697F, -28.8316F, 95.4654F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(175.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(155.8409F, 15.2549F, -147.6939F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(155.84F, 15.25F, -147.69F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.5417F, KeyframeAnimations.degreeVec(72.292F, 6.0954F, -59.0342F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-0.97F, -0.22F, -0.03F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.6431F, -31.2867F, -110.0218F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(15.5309F, -3.5815F, -53.5831F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-47.8093F, -27.0185F, -39.0711F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-47.8093F, -27.0185F, -39.0711F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(33.5141F, -42.4445F, -61.1709F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-19.1776F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(37.239F, -0.1083F, 30.5061F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(3.3224F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(3.3224F, -3.9656F, 0.7302F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-55.4577F, -2.3113F, -1.5392F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.7923F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(7.2077F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(7.2077F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(7.2077F, -10.6758F, -4.0087F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-14.4572F, 30.8479F, -11.8437F), AnimationChannel.Interpolations.CATMULLROM),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
                ))
                .build();
}
