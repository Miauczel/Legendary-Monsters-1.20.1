package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.LightningBoltEntity;
import net.miauczel.legendary_monsters.entity.client.Model.LightningStrikeModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.joml.Matrix4f;

public class LightningRenderer extends EntityRenderer<LightningBoltEntity> {

    private static final RandomSource RANDOM = RandomSource.create();

    private final LightningStrikeModel model;
    private final float linearity;

    public LightningRenderer(EntityRendererProvider.Context context, float linearity) {
        super(context);
        this.linearity = linearity;

        this.model = new LightningStrikeModel(context.bakeLayer(ModModelLayers.LIGHTNING_STRIKE_LAYER));
    }

    @Override
    public void render(LightningBoltEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {

        matrixStack.pushPose();
        float $$6 = entity.getAnimationProgress(partialTicks);

        if ($$6 != 0.0F) {
            float $$7 = 2.0F;
            if ($$6 > 0.9F) {
                $$7 *= (1.0F - $$6) / 0.1F;
            }

            float $$10 = 2.0F;
            if ($$6 > 0.9F) {
                $$10 *= (1.0F - $$6) / 0.1F;
            }
            this.model.setupAnim(entity, $$6, 0.0F, 0.0F, entity.getYRot(), entity.getXRot());
            VertexConsumer vertexconsumer = buffer.getBuffer(this.model.renderType(new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/falling_cloud_angry.png")));
            this.model.renderToBuffer(matrixStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY,
                    1F, 1F, 1F, 1);
            matrixStack.scale(-$$7, -$$7, -$$7);
        }
        matrixStack.popPose();
        matrixStack.pushPose();
        if ($$6 != 0.0F) {
            float $$7 = 1.0F;
            if ($$6 > 0.9F) {
                $$7 *= (1.0F - $$6) / 0.1F;
            }

            float $$10 = 2.0F;
            if ($$6 > 0.9F) {
                $$10 *= (1.0F - $$6) / 0.1F;
            }
        }


if ($$6 != 0.0F) {
            Minecraft mc = Minecraft.getInstance();
            double playerX = mc.player.getX();
            double playerZ = mc.player.getZ();

            double entityX = entity.getX();
            double entityZ = entity.getZ();

            double dirX = playerX - entityX;
            double dirZ = playerZ - entityZ;

            double magnitude = Math.sqrt(dirX * dirX + dirZ * dirZ);
            if (magnitude != 0) {
                dirX /= magnitude;
                dirZ /= magnitude;
            }

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity)));

            float startX = 0.0F;
            float startZ = 0.0F;

            for (int i = 0; i < 7.5f; i++) {
                float maxDeviation = (1.0F - linearity) * 2.0F;
                float endX = startX + RANDOM.nextFloat() * maxDeviation - maxDeviation / 2.0F;
                float endZ = startZ + RANDOM.nextFloat() * maxDeviation - maxDeviation / 2.0F;

                render3DSegment(matrixStack.last().pose(), vertexConsumer, startX, startZ, i, endX, endZ, i + 1, dirX, dirZ, 0.8F, 0.8F, 1.0F,0.7f);

                startX = endX;
                startZ = endZ;

        }}
        matrixStack.popPose();
packedLight = 0xF000F0;
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);

    }

    private void render3DSegment(Matrix4f matrix, VertexConsumer consumer, float startX, float startZ, int startY, float endX, float endZ, int endY, double dirX, double dirZ, float red, float green, float blue, float aplha) {
        float thickness = 0.1F;

        float perpX = (float) -dirZ;
        float perpZ = (float) dirX;

        perpX *= thickness;
        perpZ *= thickness;

        renderQuad(matrix, consumer, startX, startZ, startY, endX, endZ, endY, red, green, blue,aplha, perpX, perpZ);
        renderQuad(matrix, consumer, startX, startZ, startY, endX, endZ, endY, red, green, blue,aplha, -perpX, -perpZ);
    }

    private void renderQuad(Matrix4f matrix, VertexConsumer consumer, float x1, float z1, int y1, float x2, float z2, int y2, float red, float green, float blue,float alpha, float perpX, float perpZ) {
        consumer.vertex(matrix, x1 - perpX, y1 * 1.0F, z1 - perpZ)
                .color(red, green, blue, alpha)
                .uv(0.0F, 0.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();

        consumer.vertex(matrix, x2 - perpX, y2 * 1.0F, z2 - perpZ)
                .color(red, green, blue, alpha)
                .uv(1.0F, 0.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();

        consumer.vertex(matrix, x2 + perpX, y2 * 1.0F, z2 + perpZ)
                .color(red, green, blue, alpha)
                .uv(1.0F, 1.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();

        consumer.vertex(matrix, x1 + perpX, y1 * 1.0F, z1 + perpZ)
                .color(red, green, blue, alpha)
                .uv(0.0F, 1.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();
    }


    @Override
    public ResourceLocation getTextureLocation(LightningBoltEntity entity) {
        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/model.png");
    }
}
