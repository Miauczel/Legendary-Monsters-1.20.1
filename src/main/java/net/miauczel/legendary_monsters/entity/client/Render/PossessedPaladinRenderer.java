package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.client.RenderUtils;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Withered_AbominationEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.NewPossessedPaladinModel;
import net.miauczel.legendary_monsters.entity.client.layer.Possessed_Paladin.*;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class PossessedPaladinRenderer extends MobRenderer<PossessedPaladinEntity, NewPossessedPaladinModel<PossessedPaladinEntity>> {
    public PossessedPaladinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new NewPossessedPaladinModel<>(pContext.bakeLayer(ModModelLayers.NEW_POSSESSED_PALADIN_LAYER)), 0.75f);
        this.addLayer(new PossessedPaladinEyesLayer(this));
        this.addLayer(new PossessedPaladinDaggerLayer(this));
        this.addLayer(new PossessedPaladinShieldLayer(this));
        this.addLayer(new PossessedPaladinTridentLayer(this));
        this.addLayer(new PossessedPaladinWingsLayer(this));
        this.addLayer(new PossessedPaladinGrabLayer(this, pContext.getEntityRenderDispatcher()));
    }

    private static final ResourceLocation PHASE1 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/new_posessed_paladin.png");

    private static final ResourceLocation PHASE2 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/new_posessed_paladin_p2.png");

    @Override
    public ResourceLocation getTextureLocation(PossessedPaladinEntity pEntity) {
        return pEntity.getPhase() >= 2 ? PHASE2 : PHASE1;
    }



    @Override
    public void render(PossessedPaladinEntity entity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        float uniS = 1.75f;
        pMatrixStack.scale(uniS, uniS, uniS);
        float f = Mth.cos(entity.getYRot() * ((float) Math.PI / 180F));
        float f12 = Mth.sin(entity.getYRot() * ((float) Math.PI / 180F));
        double theta = (entity.getYRot()) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 0;
        float offset = 0;
        double x = 0 + vec * vecX + f * offset;
        double z = 0 + vec * vecZ + f12 * offset;
        float uniY = 0.25f;
        float yaw = (float) -entity.getYRot() + 90;


        renderSoulRays(entity, entity.rayAmount, pMatrixStack, pBuffer, pPackedLight, pPartialTicks);

        VertexConsumer vertexConsumer = pBuffer.getBuffer(LMRenderTypes.LIGHTNING_NO_CULL);
        float uniA = 0.65f;

        float animationProgress1 = Math.min(entity.telegraphFadeAway.getAnimationFraction(), 1F);
        float f_0_245976 = 1f - animationProgress1;
        if (f_0_245976 >= 0 && entity.canRenderTelegraph()) {
            RenderUtils.renderPivotedQuad(8, 2f, x, uniY, z, 90, yaw, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, 1, 0.25f, 0.25f, Mth.clamp(f_0_245976 - uniA, 0, 1));
            //    RenderUtils.renderPivotedQuad(10, 0.1f, x, uniY, z, 0,yaw, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, 0.25f, 1, 0.25f, uniA);
        }

        super.render(entity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }


    private void renderSoulRays(PossessedPaladinEntity pEntity, float deathProgress, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, float pPartialTicks) {
        Vec3 entityPosition = pEntity.position();
        RandomSource randomsource = RandomSource.create(432L);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(LMRenderTypes.LIGHTNING_NO_CULL);
        pMatrixStack.pushPose();
        if (pEntity.getAttackTicks() > MathUtils.toTicks(11)) {
            pMatrixStack.translate(0, 1.35F, 0.0F);
        } else {
            pMatrixStack.translate(0, 1.35F, 0.0F);
        }

        int maxRays = (int) ((deathProgress * deathProgress) / 2.0F * 60.0F);
        int currentRay = (int) deathProgress;
        for (int i = 0; i < currentRay; ++i) {
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + pEntity.attackTicks + pPartialTicks));
            float f3 = randomsource.nextFloat() * 20.0F + 5.0F;
            float f4 = randomsource.nextFloat() * 2.0F + 1.0F;
            Matrix4f matrix4f = pMatrixStack.last().pose();
            int j = (int) (255.0F * (1.0F - deathProgress));
            if (pEntity.getPhase() < 2) {
                vertex01(vertexconsumer, matrix4f, j);

                //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                PossessedPaladinGrabLayer.vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

                PossessedPaladinGrabLayer.vertex3(vertexconsumer, matrix4f, f3, f4);

                PossessedPaladinGrabLayer.vertex01(vertexconsumer, matrix4f, j);
            } else {
                PossessedPaladinRenderer.vertex01(vertexconsumer, matrix4f, j);

                //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                PossessedPaladinRenderer.vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

                PossessedPaladinRenderer.vertex3(vertexconsumer, matrix4f, f3, f4);

                PossessedPaladinRenderer.vertex01(vertexconsumer, matrix4f, j);
            }
            //  vertex3(vertexconsumer, matrix4f, f3, f4);

            //  vertex4(vertexconsumer, matrix4f, f3, f4);

            // vertex01(vertexconsumer, matrix4f, j);

            //vertex4(vertexconsumer, matrix4f, f3, f4);

            //vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

        }

        pMatrixStack.popPose();
    }

    private static final float COOLDOWN_FACTOR = 10.0F;

    private void renderDeathRays(Withered_AbominationEntity pEntity, float deathProgress, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, float pPartialTicks) {
        RandomSource randomsource = RandomSource.create(432L);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.lightning());
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0F, 3.0F, 0.0F);

        for (int i = 0; i < (deathProgress + deathProgress * deathProgress) / 2.0F * 60.0F; ++i) {
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + deathProgress * 90.0F));
            float f3 = randomsource.nextFloat() * 50.0F + 5.0F;
            float f4 = randomsource.nextFloat() * 2.0F + 1.0F;
            Matrix4f matrix4f = pMatrixStack.last().pose();
            int j = (int) (255.0F * (1.0F - deathProgress));
            vertex01(vertexconsumer, matrix4f, j);
            //vertex2(vertexconsumer, matrix4f, f3, f4);
            vertex3(vertexconsumer, matrix4f, f3, f4);
            vertex01(vertexconsumer, matrix4f, j);
            vertex3(vertexconsumer, matrix4f, f3, f4);
            vertex4(vertexconsumer, matrix4f, f3, f4);
            vertex01(vertexconsumer, matrix4f, j);
            vertex4(vertexconsumer, matrix4f, f3, f4);
            //vertex2(vertexconsumer, matrix4f, f3, f4,pEntity);
        }

        pMatrixStack.popPose();
    }

    public static void vertex01(VertexConsumer pConsumer, Matrix4f pMatrix, int pAlpha) {
        pConsumer.vertex(pMatrix, 0.0F, 0.0F, 0.0F).color(255, 255, 255, 110).endVertex();

    }

    public static void vertex2(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253704_, float p_253701_, PossessedPaladinEntity pEntity) {
        Vec3 entityPosition = pEntity.position();
        //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
        pConsumer.vertex(pMatrix, -HALF_SQRT_3 * p_253701_, p_253704_, -0.5F * p_253701_).color(255, 0, 0, 110).endVertex();
    }

    public static void vertex3(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253729_, float p_254030_) {
        pConsumer.vertex(pMatrix, HALF_SQRT_3 * p_254030_, p_253729_, -0.5F * p_254030_).color(255, 0, 0, 110).endVertex();

    }

    private static void vertex4(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253649_, float p_253694_) {
        pConsumer.vertex(pMatrix, 0.0F, p_253649_, 1.0F * p_253694_).color(255, 0, 0, 110).endVertex();
    }

    private static final float HALF_SQRT_3 = (float) (Math.sqrt(3.0D) / 2.0D);

}



