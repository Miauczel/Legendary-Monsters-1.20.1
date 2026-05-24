package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.client.RenderUtils;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.TheObliteratorModel;
import net.miauczel.legendary_monsters.entity.client.layer.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Matrix4f;

public class TheObliteratorRenderer extends MobRenderer<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> {
    public TheObliteratorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TheObliteratorModel<>(pContext.bakeLayer(ModModelLayers.THE_OBLITERATOR_LAYER)), 2.25f);

        this.addLayer(new TheObliteratorUltimateFlame(this));
        this.addLayer(new TheObliteratorFlameyBladesLayer(this));
        this.addLayer(new TheObliteratorPowerBallInnerLayer(this));
        this.addLayer(new TheObliteratorPowerBallOuterLayer(this));

        this.addLayer(new TheObliteratorGrabLayer(this, pContext.getEntityRenderDispatcher()));

    }

    private static final ResourceLocation ARMORED = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/the_warped_one.png");
    private static final ResourceLocation NO_ARMOR = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/the_warped_one_no_armor.png");
    private static final ResourceLocation PHASE_3 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/the_warped_one_phase_3.png");

    @Override
    public ResourceLocation getTextureLocation(TheObliteratorEntity pEntity) {
        if (pEntity.getIsThirdPhase()) {
            return PHASE_3;
        } else if (pEntity.getIsSecondPhase()) {
            return NO_ARMOR;
        } else {
            return ARMORED;
        }
    }

    @Override
    public void render(TheObliteratorEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        float bodyXRotDeg = (model.body.xRot * Mth.RAD_TO_DEG + (model.big_cube.xRot * Mth.RAD_TO_DEG) + (model.root.xRot * Mth.RAD_TO_DEG)) * 1;
        float bodyYRotDeg = (model.body.yRot * Mth.RAD_TO_DEG + (model.big_cube.yRot * Mth.RAD_TO_DEG) + (model.root.yRot * Mth.RAD_TO_DEG)) * 1;
        pEntity.setPartXRot(-bodyXRotDeg);
        pEntity.setPartYRot(-bodyYRotDeg);
        pMatrixStack.scale(0.8f, 0.8f, 0.8f);
        pMatrixStack.pushPose();
        float renderProgress = !pEntity.getIsQuadBeamRight() ? Math.max(pEntity.renderProgress * 5 + pPartialTicks,-90) : Math.min(pEntity.renderProgress * 5 + pPartialTicks,90);
        float yaw = (float) -pEntity.yBodyRot + 90 + renderProgress;

        float yaw2 = (float) -pEntity.yBodyRot + 180 + renderProgress;

        float yaw3 = (float) -pEntity.yBodyRot + 270 + renderProgress;

        float yaw4 = (float) -pEntity.yBodyRot + renderProgress;

        float f = Mth.cos(pEntity.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(pEntity.yBodyRot * ((float) Math.PI / 180F));
        double theta = (pEntity.yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 0;
        float offset = 0;
        double x = 0 + vec * vecX + f * offset;
        double z = 0 + vec * vecZ + f1 * offset;
        VertexConsumer vertexConsumer = pBuffer.getBuffer(LMRenderTypes.LIGHTNING_NO_CULL);
//pMatrixStack.scale(2,2,2);
        if (pEntity.getAttackState() == 46 && (pEntity.attackTicks < 46 && pEntity.attackTicks > 12)) {

            double shine = Math.min(pEntity.QuadLaserShineUp.getTimer() * 0.015, 7.5);

            double shine2 = Math.min(pEntity.QuadLaserShineUp.getTimer() * 0.015, 6.5);
            float uniA = (float) (0.35f + shine2);
            float uniY = 2.5f;

            RenderUtils.renderPivotedQuad(16, 0.25f, x, uniY, z, 0, yaw, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, (float) (0.25f + shine), 1, (float) (0.25f + shine), uniA);
            RenderUtils.renderPivotedQuad(16, 0.25f, x, uniY, z, 0, yaw2, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, (float) (0.25f + shine), 1, (float) (0.25f + shine), uniA);
            RenderUtils.renderPivotedQuad(16, 0.25f, x, uniY, z, 0, yaw3, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, (float) (0.25f + shine), 1, (float) (0.25f + shine), uniA);
            RenderUtils.renderPivotedQuad(16F, 0.25f, x, uniY, z, 0, yaw4, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, (float) (0.25f + shine), 1, (float) (0.25f + shine), uniA);

        }
        pMatrixStack.popPose();

        if (pEntity.attackTicks > 0 && pEntity.attackTicks < 45 && pEntity.getAttackState() == 2) {

            float f5 = ((float) pEntity.attackTicks + pPartialTicks) / 200.0F;
            float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
            RandomSource randomsource = RandomSource.create(432L);
            VertexConsumer vertexconsumer2 = pBuffer.getBuffer(RenderType.lightning());
            pMatrixStack.pushPose();
            pMatrixStack.translate(0.0F, 3.0F + (pEntity.getAttackTicks() * 0.1), 0F);

//Scale
            float duration = 40f;
            float t = Mth.clamp(((float) pEntity.attackTicks + pPartialTicks) / duration, 0f, 1f);

            float scale = (float) Math.sin(Math.PI * t);

            scale = Mth.clamp(scale, 0f, 1f);

            pMatrixStack.scale(scale, scale, scale);


            for (int i = 0; (float) i < (f5 + f5 * f5) / 2.0F * 30.0F; ++i) {
                pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + f5 * 90.0F));
                float f3 = randomsource.nextFloat() * 20.0F + 5.0F + f7 * 10.0F;
                float f4 = randomsource.nextFloat() * 2.0F + 1.0F + f7 * 2.0F;
                Matrix4f matrix4f = pMatrixStack.last().pose();
                int j = (int) (255.0F * (1.0F - f7));
                vertex01(vertexconsumer2, matrix4f, j);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
            }

            pMatrixStack.popPose();
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

    }

    public void renderWarningQuads(LivingEntity entity) {
    }

    private static final float HALF_SQRT_3 = (float) (Math.sqrt(3.0D) / 2.0D);

    private static void vertex01(VertexConsumer pConsumer, Matrix4f pMatrix, int pAlpha) {
        pConsumer.vertex(pMatrix, 0.0F, 4F, 0.0F).color(0, 255, 0, pAlpha).endVertex();
    }

    private static void vertex2(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253704_, float p_253701_) {
        pConsumer.vertex(pMatrix, (-HALF_SQRT_3 * p_253701_), p_253704_, -0.5F * p_253701_).color(0, 255, 0, 0).endVertex();
    }

    private static void vertex3(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253729_, float p_254030_) {
        pConsumer.vertex(pMatrix, (-HALF_SQRT_3 * p_254030_), p_253729_, (-0.5F * p_254030_)).color(0, 255, 0, 0).endVertex();
    }

    private static void vertex4(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253649_, float p_253694_) {
        pConsumer.vertex(pMatrix, 0.0F, p_253649_, (1.0F * p_253694_)).color(0, 255, 0, 0).endVertex();
    }
}
