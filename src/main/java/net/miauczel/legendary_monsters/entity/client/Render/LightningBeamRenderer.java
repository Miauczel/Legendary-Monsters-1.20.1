package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.LightningBeamEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.joml.Matrix4f;

public class LightningBeamRenderer extends EntityRenderer<LightningBeamEntity> {

    private static final RandomSource RANDOM = RandomSource.create();

    private final float linearity;

    public LightningBeamRenderer(EntityRendererProvider.Context context, float linearity) {
        super(context);
        this.linearity = linearity;
    }
    @Override
    public void render(LightningBeamEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {

        matrixStack.pushPose();

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

        float startX = (float) entity.endPosX;
        float startZ = (float) entity.endPosZ;

            for (int i = 0; i < entity.endPosY; i++) {

                float maxDeviation = (1.0F - linearity) * 2.0F;
                float endX = startX + RANDOM.nextFloat() * maxDeviation - maxDeviation / 2.0F;
                float endZ = startZ + RANDOM.nextFloat() * maxDeviation - maxDeviation / 2.0F;

                render3DSegment(matrixStack.last().pose(), vertexConsumer, startX, startZ, i, endX, endZ, i+1, dirX, dirZ, 0.8F, 0.8F, 1.0F);

                startX = endX;
                startZ = endZ;
            }

        matrixStack.popPose();
        packedLight = 0xF000F0; // Maksymalne oświetlenie
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);

    }

    private void render3DSegment(Matrix4f matrix, VertexConsumer consumer, float startX, float startZ, int startY, float endX, float endZ, int endY, double dirX, double dirZ, float red, float green, float blue) {
        float thickness = 0.1F;

        float perpX = (float) -dirZ;
        float perpZ = (float) dirX;

        perpX *= thickness;
        perpZ *= thickness;

        renderQuad(matrix, consumer, startX, startZ, startY, endX, endZ, endY, red, green, blue, perpX, perpZ);
        renderQuad(matrix, consumer, startX, startZ, startY, endX, endZ, endY, red, green, blue, -perpX, -perpZ);
    }

    private void renderQuad(Matrix4f matrix, VertexConsumer consumer, float x1, float z1, int y1, float x2, float z2, int y2, float red, float green, float blue, float perpX, float perpZ) {

        consumer.vertex(matrix, x1 - perpX, y1 * 1.0F, z1 - perpZ)
                .color(red, green, blue, 0.5F)
                .uv(0.0F, 0.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();

        consumer.vertex(matrix, x2 - perpX, y2 * 1.0F, z2 - perpZ)
                .color(red, green, blue, 0.5F)
                .uv(1.0F, 0.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();

        consumer.vertex(matrix, x2 + perpX, y2 * 1.0F, z2 + perpZ)
                .color(red, green, blue, 0.5F)
                .uv(1.0F, 1.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();

        consumer.vertex(matrix, x1 + perpX, y1 * 1.0F, z1 + perpZ)
                .color(red, green, blue, 0.5F)
                .uv(0.0F, 1.0F)
                .overlayCoords(0, 10)
                .uv2(0xF000F0)
                .normal(0, 1, 0)
                .endVertex();
    }
    @Override
    public ResourceLocation getTextureLocation(LightningBeamEntity entity) {
        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/model.png");
    }
}
