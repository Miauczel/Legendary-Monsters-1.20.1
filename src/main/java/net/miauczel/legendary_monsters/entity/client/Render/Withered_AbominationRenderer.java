package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Glow.WitheredAbominationEyes.WitheredAbominationEyes;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Withered_AbominationEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.Withered_AbominationModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.joml.Matrix4f;

public class Withered_AbominationRenderer extends MobRenderer<Withered_AbominationEntity, Withered_AbominationModel<Withered_AbominationEntity>> {
    public Withered_AbominationRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Withered_AbominationModel<>(pContext.bakeLayer(ModModelLayers.WITHERED_ABOMINATION_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(Withered_AbominationEntity pEntity) {
        Withered_AbominationEntity.Crackiness crackiness = pEntity.getCrackiness();
        if (crackiness == Withered_AbominationEntity.Crackiness.MEDIUM) {
            return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/withered_abomination/crackiness/withered_abomination_crack1.png");
        }
        if (crackiness == Withered_AbominationEntity.Crackiness.HIGH) {
            return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/withered_abomination/crackiness/withered_abomination_crack2.png");
        }
        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/withered_abomination/withered_abomination.png");
    }

    @Override
    public void render(Withered_AbominationEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        Withered_AbominationEntity.Crackiness crackiness = pEntity.getCrackiness();

        this.layers.removeIf(layer -> layer instanceof WitheredAbominationEyes);

        if (crackiness == Withered_AbominationEntity.Crackiness.MEDIUM || crackiness == Withered_AbominationEntity.Crackiness.HIGH) {
            this.addLayer(new WitheredAbominationEyes<>(this, pEntity));
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

    }
    private void renderDeathRaysControlled(Withered_AbominationEntity pEntity, float deathProgress, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, float pPartialTicks) {
        RandomSource randomsource = RandomSource.create(432L);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.lightning());
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0F, 2.0F, 0.0F);

        int maxRays = (int)((deathProgress * deathProgress) / 2.0F * 60.0F);
        int currentRay = (int)(deathProgress * COOLDOWN_FACTOR);

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
            int j = (int)(255.0F * (1.0F - deathProgress));
            vertex01(vertexconsumer, matrix4f, j);
            vertex2(vertexconsumer, matrix4f, f3, f4);
            vertex3(vertexconsumer, matrix4f, f3, f4);
            vertex01(vertexconsumer, matrix4f, j);
            vertex3(vertexconsumer, matrix4f, f3, f4);
            vertex4(vertexconsumer, matrix4f, f3, f4);
            vertex01(vertexconsumer, matrix4f, j);
            vertex4(vertexconsumer, matrix4f, f3, f4);
            vertex2(vertexconsumer, matrix4f, f3, f4);
        }

        pMatrixStack.popPose();
    }
    private static final float COOLDOWN_FACTOR = 5.0F;
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
            int j = (int)(255.0F * (1.0F - deathProgress));
            vertex01(vertexconsumer, matrix4f, j);
            vertex2(vertexconsumer, matrix4f, f3, f4);
            vertex3(vertexconsumer, matrix4f, f3, f4);
            vertex01(vertexconsumer, matrix4f, j);
            vertex3(vertexconsumer, matrix4f, f3, f4);
            vertex4(vertexconsumer, matrix4f, f3, f4);
            vertex01(vertexconsumer, matrix4f, j);
            vertex4(vertexconsumer, matrix4f, f3, f4);
            vertex2(vertexconsumer, matrix4f, f3, f4);
        }

        pMatrixStack.popPose();
    }

    private static void vertex01(VertexConsumer pConsumer, Matrix4f pMatrix, int pAlpha) {
        pConsumer.vertex(pMatrix, 0.0F, 0.0F, 0.0F).color(255, 255, 255, 255).endVertex();
    }

    private static void vertex2(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253704_, float p_253701_) {
        pConsumer.vertex(pMatrix, -HALF_SQRT_3 * p_253701_, p_253704_, -0.5F * p_253701_).color(255, 0, 255, 250).endVertex();
    }

    private static void vertex3(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253729_, float p_254030_) {
        pConsumer.vertex(pMatrix, HALF_SQRT_3 * p_254030_, p_253729_, -0.5F * p_254030_).color(255, 0, 255, 255).endVertex();
    }

    private static void vertex4(VertexConsumer pConsumer, Matrix4f pMatrix, float p_253649_, float p_253694_) {
        pConsumer.vertex(pMatrix, 0.0F, p_253649_, 1.0F * p_253694_).color(255, 0, 255,255).endVertex();
    }
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);
}
