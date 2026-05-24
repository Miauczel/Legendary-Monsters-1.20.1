package net.miauczel.legendary_monsters.entity.client.layer.Possessed_Paladin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.client.Model.NewPossessedPaladinModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.Render.PossessedPaladinRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class PossessedPaladinGrabLayer extends RenderLayer<PossessedPaladinEntity, NewPossessedPaladinModel<PossessedPaladinEntity>> {
    private final EntityRenderDispatcher mobRenderer;


    public PossessedPaladinGrabLayer(RenderLayerParent<PossessedPaladinEntity, NewPossessedPaladinModel<PossessedPaladinEntity>> renderer, EntityRenderDispatcher dispatcher) {
        super(renderer);
        mobRenderer = dispatcher;
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, PossessedPaladinEntity pLivingEntity, float pLimbSwing,
                       float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        for (Entity passenger : pLivingEntity.getPassengers()) {
            if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
                continue;
            }
            renderHeldMobs(this.mobRenderer, passenger, pPoseStack, pPartialTick, pBuffer, pPackedLight, pLivingEntity);
        }


    }

    public void renderHeldMobs(EntityRenderDispatcher renderDispatcher, Entity livingEntity, PoseStack matrixStack, float partialTicks, MultiBufferSource pBuffer, int packedLight, PossessedPaladinEntity pLivingEntity) {
        LegendaryMonsters.PROXY.releaseRenderingEntity(livingEntity.getUUID());
        matrixStack.pushPose();
        getParentModel().translateModel(matrixStack);
        matrixStack.scale(0.7f, 0.7f, 0.7f);

        matrixStack.mulPose(Axis.ZP.rotationDegrees(90));
        matrixStack.translate(-1, -1, 1.25f);

        renderSoulRays(pLivingEntity,pLivingEntity.soulRaysCount,matrixStack,pBuffer,packedLight,partialTicks);

        renderDispatcher.render(livingEntity, 0, 0, 0, 0, partialTicks, matrixStack, pBuffer, packedLight);
        matrixStack.popPose();
        LegendaryMonsters.PROXY.blockRenderingEntity(livingEntity.getUUID());
    }

    private void renderSoulRays(PossessedPaladinEntity pEntity, float deathProgress, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, float pPartialTicks) {
        Vec3 entityPosition = pEntity.position();
        RandomSource randomsource = RandomSource.create(432L);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(LMRenderTypes.LIGHTNING_NO_CULL);
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0F, 1F, 0.0F);

        int maxRays = (int) ((deathProgress * deathProgress) / 2.0F * 60.0F);
        int currentRay = (int) deathProgress;
        for (int i = 0; i < currentRay; ++i) {
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + pEntity.attackTicks +pPartialTicks));
            float f3 = randomsource.nextFloat() * 20.0F + 5.0F;
            float f4 = randomsource.nextFloat() * 2.0F + 1.0F;
            Matrix4f matrix4f = pMatrixStack.last().pose();
            int j = (int) (255.0F * (1.0F - deathProgress));
            if (pEntity.getPhase() < 2) {
                vertex01(vertexconsumer, matrix4f, j);

                //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

                vertex3(vertexconsumer, matrix4f, f3, f4);

                vertex01(vertexconsumer, matrix4f, j);
            }else {
                PossessedPaladinRenderer.vertex01(vertexconsumer, matrix4f, j);

                //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
                PossessedPaladinRenderer.vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

                PossessedPaladinRenderer.vertex3(vertexconsumer, matrix4f, f3, f4);

                PossessedPaladinRenderer. vertex01(vertexconsumer, matrix4f, j);
            }
          //  vertex3(vertexconsumer, matrix4f, f3, f4);

          //  vertex4(vertexconsumer, matrix4f, f3, f4);

           // vertex01(vertexconsumer, matrix4f, j);

            //vertex4(vertexconsumer, matrix4f, f3, f4);

            //vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

        }

        pMatrixStack.popPose();
    }

    public static void vertex01(VertexConsumer pConsumer, Matrix4f pMatrix, int pAlpha) {
        pConsumer.vertex(pMatrix, 0.0F, 0.0F, 0.0F).color(255, 255, 255, 110).endVertex();

    }

    public static void vertex2(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253704_, float p_253701_, PossessedPaladinEntity pEntity) {
        Vec3 entityPosition = pEntity.position();
        //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
        pConsumer.vertex(pMatrix, -HALF_SQRT_3 * p_253701_, p_253704_, -0.5F * p_253701_).color(57, 190, 197, 110).endVertex();
    }

    public static void vertex3(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253729_, float p_254030_) {
        pConsumer.vertex(pMatrix, HALF_SQRT_3 * p_254030_, p_253729_, -0.5F * p_254030_).color(57, 190, 197, 110).endVertex();

    }

    private static void vertex4(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253649_, float p_253694_) {
        pConsumer.vertex(pMatrix, 0.0F, p_253649_, 1.0F * p_253694_).color(57, 190, 197, 110).endVertex();
    }

    private static final float HALF_SQRT_3 = (float) (Math.sqrt(3.0D) / 2.0D);
}
