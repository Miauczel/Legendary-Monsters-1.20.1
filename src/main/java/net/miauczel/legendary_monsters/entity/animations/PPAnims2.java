package net.miauczel.legendary_monsters.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class PPAnims2 {

    public static final AnimationDefinition blockAttack2 = AnimationDefinition.Builder.withLength(3.5417F)
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(15.2352F, -42.6462F, -24.0329F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(153.4462F, -53.3689F, -169.8634F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(153.4462F, -53.3689F, -169.8634F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(61.0821F, -77.1628F, -82.0181F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-17.7353F, -6.166F, -6.0629F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-17.7353F, -6.166F, -6.0629F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-12.289F, -9.3652F, 1.2259F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-12.289F, -9.3652F, 1.2259F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(7.8509F, 31.6389F, 14.7276F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(20.2869F, 32.3238F, 14.6426F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(20.2869F, 32.3238F, 14.6426F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(10.686F, 5.0764F, 2.2996F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(10.686F, 5.0764F, 2.2996F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(22.3499F, 10.8313F, 1.3915F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(22.3499F, 10.8313F, 1.3915F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, -1.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(25.4641F, 42.5246F, 23.517F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(25.4641F, 42.5246F, 23.517F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middleright", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("lowerlegright", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(11.8619F, -2.786F, 4.8831F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(11.8619F, -2.786F, 4.8831F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-16.1364F, -16.6667F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(12.5F, -18.3333F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(16.2245F, 22.1302F, 6.2558F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-3.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(4.564F, -7.4355F, -0.9845F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(16.564F, -7.4355F, -0.9845F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-12.5F, 35.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(20.9111F, 5.5252F, -1.5901F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(12.5F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-10.0094F, -42.0785F, -4.3284F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-10.0094F, -42.0785F, -4.3284F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(7.0378F, -6.6637F, -4.7152F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-8.1676F, 24.7611F, -14.5141F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-11.17F, 24.76F, -14.51F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(1.4053F, 15.7508F, -5.345F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-8.0947F, 15.7508F, -5.345F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(1.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-28.8864F, -15.5839F, -25.9629F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-91.4654F, 1.7756F, -32.9061F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-33.7375F, -34.9869F, -23.2003F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-117.1525F, -50.1781F, 22.0782F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-117.1525F, -50.1781F, 22.0782F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-2.0458F, -22.9745F, 82.2416F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(13.95F, -22.97F, 82.24F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-99.573F, -15.6392F, 35.8041F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-115.573F, -15.6392F, 35.8041F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -1.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-31.2325F, -16.6658F, 4.6888F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-35.8868F, -33.8531F, -55.5023F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-5.9022F, 32.4512F, -33.5344F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(1.0733F, 37.8204F, -36.8577F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(1.2472F, -47.168F, -38.4306F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.2472F, -47.168F, -38.4306F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-3.7075F, -6.2049F, 0.1319F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-3.71F, -6.2F, 0.13F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-126.1032F, 56.0852F, 150.3779F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(72.1585F, 27.9298F, -64.3389F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(60.5558F, 46.4567F, -65.3776F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(27.1585F, 27.9298F, -64.3389F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(27.1585F, 27.9298F, -64.3389F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(27.1585F, 27.9298F, -64.3389F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-112.9033F, 40.2982F, 58.1644F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-127.9F, 40.3F, 58.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-311.1209F, 47.1958F, 209.1789F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-321.1608F, 36.6553F, 223.8049F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-43.0807F, 32.6884F, 24.2024F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-133.8541F, 43.9398F, -45.8238F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-89.2524F, 29.0364F, -73.6883F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-89.2166F, -33.4591F, -74.4831F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-89.2166F, -33.4591F, -74.4831F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-9.8896F, 43.9448F, 8.987F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-9.8896F, 43.9448F, 8.987F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-9.8896F, 43.9448F, 8.987F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(36.1718F, 24.5515F, 1.288F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(36.1718F, 24.5515F, 1.288F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(-2.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, -5.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-20.9111F, -4.7463F, 7.1504F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-77.8551F, 2.5546F, 81.8791F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-77.8551F, 2.5546F, 81.8791F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-79.473F, -77.5933F, 3.5804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-79.473F, -77.5933F, 3.5804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-6.3935F, -28.9657F, 15.5885F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-6.3935F, -28.9657F, 15.5885F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(16.3503F, 49.9329F, 26.5083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(16.3503F, 49.9329F, 26.5083F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-7.4097F, -9.1745F, 5.6557F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-7.4097F, -9.1745F, 5.6557F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(4.9922F, 0.263F, -0.0834F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-20.9111F, -4.7463F, 7.1504F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-77.8551F, 2.5546F, 81.8791F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-77.8551F, 2.5546F, 81.8791F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.625F, KeyframeAnimations.degreeVec(-79.473F, -77.5933F, 3.5804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-79.473F, -77.5933F, 3.5804F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-6.3935F, -28.9657F, 15.5885F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-6.3935F, -28.9657F, 15.5885F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();

    public static final AnimationDefinition attackBlock2 = AnimationDefinition.Builder.withLength(3.875F)
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(2.375F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-12.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-12.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(-0.6734F, 0.0F, 1.2293F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(-0.6734F, 0.0F, 1.2293F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.4832F, -0.1105F, -1.6174F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.posVec(0.4832F, -0.1105F, -1.6174F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("middle", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerleg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(36.3092F, 21.8206F, 19.074F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.degreeVec(36.3092F, 21.8206F, 19.074F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.posVec(0.5858F, 0.0F, 1.4142F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.posVec(0.5858F, 0.0F, 1.4142F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(-0.1171F, 0.0F, -2.1255F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.5F, KeyframeAnimations.posVec(-0.1171F, 0.0F, -2.1255F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(0.7431F, 0.0F, 1.9569F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.3333F, KeyframeAnimations.posVec(0.7431F, 0.0F, 1.9569F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(25.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-2.5F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-4.5F, 32.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(15.8967F, -22.368F, -16.0148F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(13.9841F, -22.6081F, -13.2663F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -12.5F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(-2.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 22.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.0F, 27.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerbody", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15.0F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-15.0F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(8.8713F, -2.8267F, 4.2137F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.1972F, 19.6688F, 3.755F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-1.1972F, 19.6688F, 3.755F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(41.8713F, -2.8267F, 4.2137F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(27.269F, -29.5186F, -4.5757F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-14.3901F, -27.5102F, 2.1591F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(-23.0F, -27.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(9.19F, 29.99F, 16.11F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(9.19F, 38.99F, 16.11F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-28.8864F, -15.5839F, -25.9629F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-71.8815F, -67.1051F, -48.2968F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-82.8815F, -77.1051F, -48.2968F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-42.1342F, -9.1395F, -3.7264F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-88.5296F, 27.4897F, -12.0203F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-93.5296F, 27.4897F, -12.0203F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-58.3321F, 6.0621F, -38.4402F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-53.8022F, 5.8838F, -29.9232F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-80.8763F, -40.2707F, -37.4491F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(-84.8763F, -40.2707F, -37.4491F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-3.18F, -6.54F, 49.2F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(15.82F, -6.54F, 66.2F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(2.0F, -1.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(2.0F, -1.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(2.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.posVec(2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.posVec(2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(2.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.posVec(2.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.posVec(2.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.posVec(2.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-31.2325F, -16.6658F, 4.6888F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -32.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -32.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(26.7813F, 20.2935F, -22.5707F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-36.3539F, -18.9989F, -72.1806F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-42.3539F, -18.9989F, -72.1806F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-5.1917F, -22.1215F, -24.0405F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -32.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -32.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-2.87F, -26.81F, 2.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-2.87F, -33.81F, 14.16F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("SoulGreatSword", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-156.1032F, 56.0852F, 150.3779F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-181.5109F, 85.7913F, 75.3826F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-208.5109F, 85.7913F, 75.3826F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-128.3187F, 154.7013F, 116.233F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-158.9818F, 102.6531F, 139.0866F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-178.9425F, 137.206F, 115.4889F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-24.1049F, 166.8302F, 228.7935F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-139.5297F, 106.7422F, 107.2771F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-195.5467F, 109.0911F, 77.0166F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(-205.5467F, 109.0911F, 77.0166F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-313.497F, 143.5607F, -107.4147F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-313.497F, 143.5607F, -107.4147F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-360.0F, 180.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-43.0807F, 32.6884F, 24.2024F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-136.9147F, -17.5322F, -8.3263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-152.9147F, -17.5322F, -8.3263F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-42.4358F, 4.6833F, 6.5712F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-115.2463F, 37.1776F, -7.6376F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-127.2463F, 37.1776F, -7.6376F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-89.6857F, 11.728F, -19.2444F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-102.9059F, -7.582F, -48.6309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(-102.9059F, -7.582F, -48.6309F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(23.42F, -52.62F, -97.38F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(23.42F, -52.62F, -97.38F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-2.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 57.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 57.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-46.5725F, -24.1958F, 50.8037F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.375F, KeyframeAnimations.degreeVec(-53.5725F, -24.1958F, 50.8037F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-18.7691F, 48.1166F, -10.9801F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-22.5F, -17.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-2.5F, -17.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-2.5F, -17.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(-50.41F, 33.0818F, -1.6694F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, -44.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.0F, -64.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .addAnimation("lowerarm5", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(2.75F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
                    new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
            ))
            .build();
}
