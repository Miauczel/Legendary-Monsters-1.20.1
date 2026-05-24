package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.PosessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Withered_AbominationEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.PosessedPaladinModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class PosessedPaladinRenderer extends MobRenderer<PosessedPaladinEntity, PosessedPaladinModel<PosessedPaladinEntity>> {
    public PosessedPaladinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PosessedPaladinModel<>(pContext.bakeLayer(ModModelLayers.POSESSED_PALADIN_LAYER)), 1.5f);
    }


    @Override
    public ResourceLocation getTextureLocation(PosessedPaladinEntity pEntity) {
        PosessedPaladinEntity.Crackiness crackiness = pEntity.getCrackiness();
        if (pEntity.isAttacking()
        ) {
            return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/posessed_paladin_3d_sword_p2.png");
        } else {
            return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/posessed_paladin_3d_sword.png");
        }

    }

    @Override
    public void render(PosessedPaladinEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        if (pEntity.dragonDeathTime > 0) {
            float deathProgress = (float) pEntity.dragonDeathTime / 50.0F;
            renderDeathRaysControlled(pEntity, deathProgress, pMatrixStack, pBuffer, pPackedLight, pPartialTicks);
            // renderDeathRays(pEntity, deathProgress, pMatrixStack, pBuffer, pPackedLight, pPartialTicks);
        }
    }


    private void renderDeathRaysControlled(PosessedPaladinEntity pEntity, float deathProgress, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, float pPartialTicks) {
        Vec3 entityPosition = pEntity.position();
        RandomSource randomsource = RandomSource.create(432L);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.lightning());
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0F, 2.0F, 0.0F);

        int maxRays = (int) ((deathProgress * deathProgress) / 2.0F * 60.0F);
        int currentRay = (int) (deathProgress * COOLDOWN_FACTOR);
        for (int i = 0; i < currentRay; ++i) {
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
            //pMatrixStack.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + deathProgress * 90.0F));
            float f3 = randomsource.nextFloat() * 20.0F + 5.0F;
            float f4 = randomsource.nextFloat() * 2.0F + 1.0F;
            Matrix4f matrix4f = pMatrixStack.last().pose();
            int j = (int) (255.0F * (1.0F - deathProgress));
            vertex01(vertexconsumer, matrix4f, j);

            //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
            vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

            vertex3(vertexconsumer, matrix4f, f3, f4);

            vertex01(vertexconsumer, matrix4f, j);

            vertex3(vertexconsumer, matrix4f, f3, f4);

            vertex4(vertexconsumer, matrix4f, f3, f4);

            vertex01(vertexconsumer, matrix4f, j);

            vertex4(vertexconsumer, matrix4f, f3, f4);

            vertex2(vertexconsumer, matrix4f, f3, f4, pEntity);

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

    private static void vertex01(VertexConsumer pConsumer, Matrix4f pMatrix, int pAlpha) {
        pConsumer.vertex(pMatrix, 0.0F, 0.0F, 0.0F).color(255, 255, 255, 110).endVertex();

    }

    private static void vertex2(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253704_, float p_253701_, PosessedPaladinEntity pEntity) {
        Vec3 entityPosition = pEntity.position();
        //CameraShakeEntity.cameraShake(pEntity.level(), entityPosition, 20.0F, 0.1F, 0, 20);
        pConsumer.vertex(pMatrix, -HALF_SQRT_3 * p_253701_, p_253704_, -0.5F * p_253701_).color(255, 0, 0, 110).endVertex();
    }

    private static void vertex3(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253729_, float p_254030_) {
        pConsumer.vertex(pMatrix, HALF_SQRT_3 * p_254030_, p_253729_, -0.5F * p_254030_).color(255, 0, 0, 110).endVertex();

    }

    private static void vertex4(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253649_, float p_253694_) {
        pConsumer.vertex(pMatrix, 0.0F, p_253649_, 1.0F * p_253694_).color(255, 0, 0, 110).endVertex();
    }

    private static final float HALF_SQRT_3 = (float) (Math.sqrt(3.0D) / 2.0D);
}



