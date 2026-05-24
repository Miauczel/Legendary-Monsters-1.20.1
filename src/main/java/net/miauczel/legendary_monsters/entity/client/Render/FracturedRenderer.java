package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.FracturedModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;

public class FracturedRenderer extends MobRenderer<FracturedEntity, FracturedModel<FracturedEntity>> {

    private static final ResourceLocation BODY = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/fractured/fractured.png");
    private final FracturedModel model;

    public FracturedRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FracturedModel<>(pContext.bakeLayer(ModModelLayers.FRACTURED_LAYER)), 0.6f);
        model = new FracturedModel(pContext.bakeLayer(ModModelLayers.FRACTURED_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(FracturedEntity pEntity) {
        return BODY;
    }

    @Override
    public void render(FracturedEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        VertexConsumer vertexconsumer = pBuffer.getBuffer(LMRenderTypes.entityTranslucentEmissive(getTextureLocation(pEntity)));

       // float f = Mth.rotLerp(pPartialTicks, -pEntity.yHeadRotO, -pEntity.yHeadRot);
       // float f1 = Mth.rotLerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot());

       // model.setupAnim(pEntity, 0, 0, pPartialTicks, -pEntity.yHeadRot, f1);
      //  pMatrixStack.mulPose(Axis.XP.rotationDegrees(180));
       // pMatrixStack.translate(0, -1.35, 0);
        //  this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
        //       1.0F, 1.0F, 1.0F, 0.5F);

        pMatrixStack.popPose();

        renderModel(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

    }

    public void renderModel(FracturedEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (!MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Pre(pEntity, this, pPartialTicks, pMatrixStack, pBuffer, pPackedLight))) {
            pMatrixStack.pushPose();
            this.model.attackTime = this.getAttackAnim(pEntity, pPartialTicks);
            boolean shouldSit = pEntity.isPassenger() && pEntity.getVehicle() != null && pEntity.getVehicle().shouldRiderSit();
            this.model.riding = shouldSit;
            this.model.young = pEntity.isBaby();
            float f = Mth.rotLerp(pPartialTicks, pEntity.yBodyRotO, pEntity.yBodyRot);
            float f1 = Mth.rotLerp(pPartialTicks, pEntity.yHeadRotO, pEntity.yHeadRot);
            float f2 = f1 - f;
            if (shouldSit && pEntity.getVehicle() instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) pEntity.getVehicle();
                f = Mth.rotLerp(pPartialTicks, livingentity.yBodyRotO, livingentity.yBodyRot);
                f2 = f1 - f;
                float f3 = Mth.wrapDegrees(f2);
                if (f3 < -85.0F) {
                    f3 = -85.0F;
                }

                if (f3 >= 85.0F) {
                    f3 = 85.0F;
                }

                f = f1 - f3;
                if (f3 * f3 > 2500.0F) {
                    f += f3 * 0.2F;
                }

                f2 = f1 - f;
            }
            float f6 = Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot());
            if (isEntityUpsideDown(pEntity)) {
                f6 *= -1.0F;
                f2 *= -1.0F;
            }

            if (pEntity.hasPose(Pose.SLEEPING)) {
                Direction direction = pEntity.getBedOrientation();
                if (direction != null) {
                    float f4 = pEntity.getEyeHeight(Pose.STANDING) - 0.1F;
                    pMatrixStack.translate((float) (-direction.getStepX()) * f4, 0.0F, (float) (-direction.getStepZ()) * f4);
                }
            }

            float f7 = this.getBob(pEntity, pPartialTicks);
            this.setupRotations(pEntity, pMatrixStack, f7, f, pPartialTicks);
            pMatrixStack.scale(-1.0F, -1.0F, 1.0F);
            this.scale(pEntity, pMatrixStack, pPartialTicks);
           // pMatrixStack.mulPose(Axis.XP.rotationDegrees(180));
            pMatrixStack.translate(0.0F, -1.501F, 0.0F);
            float f8 = 0.0F;
            float f5 = 0.0F;
            if (!shouldSit && pEntity.isAlive()) {
                f8 = pEntity.walkAnimation.speed(pPartialTicks);
                f5 = pEntity.walkAnimation.position(pPartialTicks);
                if (pEntity.isBaby()) {
                    f5 *= 3.0F;
                }

                if (f8 > 1.0F) {
                    f8 = 1.0F;
                }
            }

            this.model.prepareMobModel(pEntity, f5, f8, pPartialTicks);
            this.model.setupAnim(pEntity, f5, f8, f7, f2, f6);
            Minecraft minecraft = Minecraft.getInstance();
            boolean flag = this.isBodyVisible(pEntity);
            boolean flag1 = !flag && !pEntity.isInvisibleTo(minecraft.player);
            boolean flag2 = minecraft.shouldEntityAppearGlowing(pEntity);
            RenderType rendertype = this.getRenderType(pEntity, flag, flag1, flag2);
            if (rendertype != null) {
                VertexConsumer vertexconsumer = pBuffer.getBuffer(LMRenderTypes.entityTranslucentEmissive(getTextureLocation(pEntity)));
                int i = getOverlayCoords(pEntity, this.getWhiteOverlayProgress(pEntity, pPartialTicks));
                float animationProgress1 = Math.min(pEntity.bodyFadeAway.getAnimationFraction(), 1F);
                float f_0_245976 = 1f - animationProgress1;
                this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, i, 1.0F, 1.0F, 1.0F, flag1 ? 0.15F :  Math.max(f_0_245976 - 0.5f, 0));
            }

            if (!pEntity.isSpectator()) {
                for (RenderLayer<FracturedEntity, FracturedModel<FracturedEntity>> renderlayer : this.layers) {
                    renderlayer.render(pMatrixStack, pBuffer, pPackedLight, pEntity, f5, f8, pPartialTicks, f7, f2, f6);
                }
            }

            pMatrixStack.popPose();
           // super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
            MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(pEntity, this, pPartialTicks, pMatrixStack, pBuffer, pPackedLight));
        }
    }
}
