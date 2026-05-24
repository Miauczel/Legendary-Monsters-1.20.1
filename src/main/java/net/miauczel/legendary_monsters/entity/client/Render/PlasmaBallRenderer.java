package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.PlasmaOrbEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class PlasmaBallRenderer extends EntityRenderer<PlasmaOrbEntity> {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[] {
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/plasma_ball/plasma_ball_0.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/plasma_ball/plasma_ball_1.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/plasma_ball/plasma_ball_2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/plasma_ball/plasma_ball_3.png")
    };

    public PlasmaBallRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected int getBlockLightLevel(PlasmaOrbEntity pEntity, BlockPos pPos) {
        return 15;
    }

    @Override
    public void render(PlasmaOrbEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.translate(0.0D, entity.getBbHeight() / 2.0D, 0.0D);

        float camYaw   = this.entityRenderDispatcher.camera.getYRot();
        float camPitch = this.entityRenderDispatcher.camera.getXRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - camYaw));
        poseStack.mulPose(Axis.XP.rotationDegrees(-camPitch));
packedLight = 15728880;
        int totalFrames = TEXTURES.length;
        float speed = 8.0F;
        int frame = (int)((entity.tickCount + partialTicks) * speed / 20.0F) % totalFrames;
        ResourceLocation tex = TEXTURES[Math.floorMod(frame, totalFrames)];

        VertexConsumer consumer = buffer.getBuffer(RenderType.eyes(tex));

        int overlay = OverlayTexture.NO_OVERLAY;
        int r = 255, g = 255, b = 255, a = 255;
        Matrix4f matrix = poseStack.last().pose();
        Matrix3f normalMat = poseStack.last().normal();
        float half = 0.5F*3;

        consumer.vertex(matrix, -half, -half, 0.0F)
                .color(r, g, b, a)
                .uv(0.0F, 1.0F)
                .overlayCoords(overlay)
                .uv2(packedLight)
                .normal(normalMat, 0.0F, 0.0F, 1.0F)
                .endVertex();

        consumer.vertex(matrix, half, -half, 0.0F)
                .color(r, g, b, a)
                .uv(1.0F, 1.0F)
                .overlayCoords(overlay)
                .uv2(packedLight)
                .normal(normalMat, 0.0F, 0.0F, 1.0F)
                .endVertex();

        consumer.vertex(matrix, half, half, 0.0F)
                .color(r, g, b, a)
                .uv(1.0F, 0.0F)
                .overlayCoords(overlay)
                .uv2(packedLight)
                .normal(normalMat, 0.0F, 0.0F, 1.0F)
                .endVertex();

        consumer.vertex(matrix, -half, half, 0.0F)
                .color(r, g, b, a)
                .uv(0.0F, 0.0F)
                .overlayCoords(overlay)
                .uv2(packedLight)
                .normal(normalMat, 0.0F, 0.0F, 1.0F)
                .endVertex();
        poseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(PlasmaOrbEntity entity) {
        return TEXTURES[0];
    }
}
