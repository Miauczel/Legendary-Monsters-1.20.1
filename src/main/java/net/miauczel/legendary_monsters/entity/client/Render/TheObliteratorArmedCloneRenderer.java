        package net.miauczel.legendary_monsters.entity.client.Render;

        import com.mojang.blaze3d.vertex.PoseStack;
        import com.mojang.blaze3d.vertex.VertexConsumer;
        import com.mojang.math.Axis;
        import net.miauczel.legendary_monsters.LegendaryMonsters;
        import net.miauczel.legendary_monsters.client.RenderUtils;
        import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.TheObliteratorCloneWithArmsEntity;
        import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
        import net.miauczel.legendary_monsters.entity.client.Model.TheObliteratorArmedCloneModel;
        import net.minecraft.client.renderer.MultiBufferSource;
        import net.minecraft.client.renderer.RenderType;
        import net.minecraft.client.renderer.entity.EntityRenderer;
        import net.minecraft.client.renderer.entity.EntityRendererProvider;
        import net.minecraft.client.renderer.texture.OverlayTexture;
        import net.minecraft.resources.ResourceLocation;
        import net.minecraft.util.Mth;


        public class TheObliteratorArmedCloneRenderer extends EntityRenderer<TheObliteratorCloneWithArmsEntity> {
            private static final ResourceLocation BASE_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/the_warped_one.png");
            public static final ResourceLocation INNER_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ball/inner_ball_layer.png");
            public static final ResourceLocation OUTER_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ball/outer_ball_layer.png");


            private final TheObliteratorArmedCloneModel<TheObliteratorCloneWithArmsEntity> model;

            public TheObliteratorArmedCloneRenderer(EntityRendererProvider.Context pContext) {
                super(pContext);
                this.model = new TheObliteratorArmedCloneModel<>(pContext.bakeLayer(ModModelLayers.THE_OBLITERATOR_CLONE_ARMED_LAYER));
            }

            public void render(TheObliteratorCloneWithArmsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

                float f = Mth.cos(pEntity.getYRot() * ((float) Math.PI / 180F));
                float f12 = Mth.sin(pEntity.getYRot() * ((float) Math.PI / 180F));
                double theta = (pEntity.getYRot()) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 0;
                float offset = pEntity.getAnimationState() == 2 || pEntity.getAnimationState() == 3 ? -1.5f : 1.5f;
                double x = 0 +  vec * vecX + f * offset;
                double z = 0+ vec * vecZ + f12 * offset;
                float uniY = 0.25f;
                float yaw = (float) -pEntity.getYRot() +90;



                VertexConsumer vertexConsumer = pBuffer.getBuffer(LMRenderTypes.LIGHTNING_NO_CULL);
                float uniA = 0.65f;

                float animationProgress1 = Math.min(pEntity.RendercontrolledAnim.getAnimationFraction(), 1F);
                float f_0_245976 = 1f- animationProgress1;
                if (f_0_245976 >=0 && pEntity.AnimationTicks >= 3) {
                    RenderUtils.renderPivotedQuad(8, 1.75f, x, uniY, z, 90, yaw, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, 0.25f, 1, 0.25f, Mth.clamp(f_0_245976-uniA,0,1));
                    //    RenderUtils.renderPivotedQuad(10, 0.1f, x, uniY, z, 0,yaw, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, 0.25f, 1, 0.25f, uniA);
                }

                float animationProgress = Math.min(pEntity.controlledAnim.getAnimationFraction(), 1F);
                float f1 = 1f- animationProgress;
                double dx = pEntity.getDestinationX() - pEntity.getX();
                double dy = pEntity.getDestinationY() - pEntity.getY();
                double dz = pEntity.getDestinationZ() - pEntity.getZ();

                double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);

                float yawDeg   = (float)(Math.toDegrees(Math.atan2(dz, dx))) - 90F;
                float horizontal = (float)Math.sqrt(dx*dx + dz*dz);
                float pitchDeg = - (float)(Math.toDegrees(Math.atan2(dy, horizontal)));

                float computedYawRad   = (float)Math.toRadians(yawDeg);
                float computedPitchRad = (float)Math.toRadians(pitchDeg);

                double stopDistance = 2.0;
                boolean shouldRotate = dist > stopDistance;

                float yawRad, pitchRad;
                if (shouldRotate) {
                    pEntity.lastYawToDest   = computedYawRad;
                    pEntity.lastPitchToDest = computedPitchRad;
                    yawRad   = computedYawRad;
                    pitchRad = computedPitchRad;
                } else {
                    yawRad   = pEntity.lastYawToDest;
                    pitchRad = pEntity.lastPitchToDest;
                }
                pMatrixStack.pushPose();
                float uniformScale = 0.8f;
                pMatrixStack.scale(uniformScale,uniformScale,uniformScale);

                pMatrixStack.mulPose(Axis.YP.rotation(-yawRad + (float)Math.PI));

                pMatrixStack.mulPose(Axis.XP.rotation(-pitchRad));

                pMatrixStack.mulPose(Axis.ZP.rotation((float)Math.PI));
                VertexConsumer VertexConsumer = pBuffer.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(pEntity)));
                model.setupAnim(pEntity, 0, 0, pEntity.tickCount + pPartialTicks, 0, 0);

                model.renderToBuffer(pMatrixStack, VertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, f1-0.3f);

                VertexConsumer VertexConsumer2 = pBuffer.getBuffer(LMRenderTypes.eyes(OUTER_LAYER));
                //model.renderToBuffer(pMatrixStack, VertexConsumer2, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.4F);


                VertexConsumer vertexOuter = pBuffer.getBuffer(RenderType.entityTranslucent(OUTER_LAYER));

                VertexConsumer VertexConsumer3 = pBuffer.getBuffer(LMRenderTypes.eyes(INNER_LAYER));


               // model.renderToBuffer(pMatrixStack, VertexConsumer3, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1F);

                pMatrixStack.popPose();

            }

            public ResourceLocation getTextureLocation(TheObliteratorCloneWithArmsEntity pEntity) {
                return BASE_LAYER;
            }
        }