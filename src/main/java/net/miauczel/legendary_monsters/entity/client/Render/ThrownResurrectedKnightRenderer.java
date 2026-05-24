package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.ThrownResurrectedKnightEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import org.joml.Quaternionf;

public class ThrownResurrectedKnightRenderer extends EntityRenderer<ThrownResurrectedKnightEntity> {
    public ThrownResurrectedKnightRenderer(EntityRendererProvider.Context context) {
        super(context);

    }

    @Override
    public ResourceLocation getTextureLocation(ThrownResurrectedKnightEntity entity) {
        return null;
    }

    public final RandomSource randomSource = RandomSource.create();

    @Override
    public void render(ThrownResurrectedKnightEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        matrixStack.pushPose();

        matrixStack.translate(0, 1, -1);
        Quaternionf quaternionf1 = new Quaternionf(Axis.XP.rotation(90));
        matrixStack.mulPose(quaternionf1);
        ///     matrixStack.translate(0,0,0);

        for (Entity passenger : entity.getPassengers()) {
            if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
                continue;
            }
            renderHeldMobs(this.entityRenderDispatcher, passenger, matrixStack, partialTicks, buffer, packedLight);
        }
        matrixStack.popPose();
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    public void renderHeldMobs(EntityRenderDispatcher renderDispatcher, Entity livingEntity, PoseStack pMatrixStack, float partialTicks, MultiBufferSource pBuffer, int packedLight) {

        LegendaryMonsters.PROXY.releaseRenderingEntity(livingEntity.getUUID());
        pMatrixStack.pushPose();
        renderDispatcher.render(livingEntity, 0, 0, 0, 0, partialTicks, pMatrixStack, pBuffer, packedLight);
        pMatrixStack.popPose();
        LegendaryMonsters.PROXY.blockRenderingEntity(livingEntity.getUUID());
    }
}
