package net.miauczel.legendary_monsters.entity.client.Render;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;

public class CameraShakeRenderer extends EntityRenderer<CameraShakeEntity> {

    public CameraShakeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(CameraShakeEntity entity) {
        return null;
    }

    @Override
    public void render(CameraShakeEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
    }
}
