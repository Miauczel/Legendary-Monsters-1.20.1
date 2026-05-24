package net.miauczel.legendary_monsters.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class RenderUtils {
    public static void renderQuad(float scale, double x, double y, double z, double xRot, double yRot, double zRot, VertexConsumer consumer, PoseStack poseStack, int overlay, int packedLight) {
        poseStack.pushPose();

        poseStack.translate(x, y, z);
        //Quaternionf quaternionf = new Quaternionf(xRot,yRot,zRot,0);
        poseStack.mulPose(Axis.YP.rotationDegrees((float) yRot));

        poseStack.mulPose(Axis.XP.rotationDegrees((float) -xRot));

        poseStack.mulPose(Axis.ZP.rotationDegrees((float) zRot));
        Matrix3f normalMat = poseStack.last().normal();
        Matrix4f matrix = poseStack.last().pose();
        consumer.vertex(matrix, -scale, -scale, 0).color(255, 255, 255, 255).uv(0, 1).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, scale, -scale, 0).color(255, 255, 255, 255).uv(1, 1).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, scale, scale, 0).color(255, 255, 255, 255).uv(1, 0).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, -scale, scale, 0).color(255, 255, 255, 255).uv(0, 0).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        poseStack.popPose();
    }

    //With pivot
    public static void renderPivotedQuad(float scale, float scale2, double x, double y, double z, double xRot, double yRot, double zRot,
                                         VertexConsumer consumer, PoseStack poseStack, int overlay, int packedLight, float r, float g, float b, float a) {

        poseStack.pushPose();
        poseStack.translate(x, y, z);
        poseStack.mulPose(Axis.YP.rotationDegrees((float) yRot));

        poseStack.translate(-scale, 0.0, 0.0);

        poseStack.mulPose(Axis.XP.rotationDegrees((float) -xRot));
        poseStack.mulPose(Axis.ZP.rotationDegrees((float) zRot));
        Matrix3f normalMat = poseStack.last().normal();
        Matrix4f matrix = poseStack.last().pose();

        consumer.vertex(matrix, -scale, -scale2, 0).color(r, g, b, a).uv(0, 1).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, scale, -scale2, 0).color(r, g, b, a).uv(1, 1).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, scale, scale2, 0).color(r, g, b, a).uv(1, 0).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, -scale, scale2, 0).color(r, g, b, a).uv(0, 0).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();

        poseStack.popPose();
    }

    public static void renderPivotedQuad(float scale, float scale2, double x, double y, double z, double xRot, double yRot, double zRot, float pivotX, float pivotY, float pivotZ,
                                         VertexConsumer consumer, PoseStack poseStack, int overlay, int packedLight, float r, float g, float b, float a) {
        poseStack.pushPose();

        poseStack.translate(x, y, z);

        poseStack.translate(pivotX, pivotY, pivotZ);

        poseStack.mulPose(Axis.YP.rotationDegrees((float) yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees((float) -xRot));
        poseStack.mulPose(Axis.ZP.rotationDegrees((float) zRot));

        poseStack.translate(-pivotX, -pivotY, -pivotZ);

        Matrix3f normalMat = poseStack.last().normal();
        Matrix4f matrix = poseStack.last().pose();

        consumer.vertex(matrix, -scale, -scale2, 0).color(r, g, b, a).uv(0, 1).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, scale, -scale2, 0).color(r, g, b, a).uv(1, 1).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, scale, scale2, 0).color(r, g, b, a).uv(1, 0).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();
        consumer.vertex(matrix, -scale, scale2, 0).color(r, g, b, a).uv(0, 0).overlayCoords(overlay).uv2(packedLight).normal(normalMat, 0, 0, 1).endVertex();

        poseStack.popPose();
    }

}
