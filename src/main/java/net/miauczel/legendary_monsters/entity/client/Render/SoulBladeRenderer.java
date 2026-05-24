package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulBladeEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.SoulBladeUndergroundModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SoulBladeRenderer extends EntityRenderer<SoulBladeEntity> {
    private static final ResourceLocation ICESPIKE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/soul_sword3.png");

    private static final ResourceLocation RED = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/soul_sword_red.png");
    private final SoulBladeUndergroundModel<SoulBladeEntity> model;

    public SoulBladeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SoulBladeUndergroundModel<>(pContext.bakeLayer(ModModelLayers.SOUL_BLADE_LAYER));
    }

    public void render(SoulBladeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        float f = pEntity.getAnimationProgress(pPartialTicks);
        if (f != 0.0F) {
            float f1 = 2.0F;
            if (f > 0.9F) {
                f1 *= (1.0F - f) / 0.1F;
            }
        }
        float animationProgress = Math.min(pEntity.controlledAnim.getAnimationFraction(), 1F);
        float f1 = 1f - animationProgress;
        model.setupAnim(pEntity, 0, 0, pEntity.tickCount + pPartialTicks, 0, 0);
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(180F));

        pMatrixStack.mulPose(Axis.YP.rotationDegrees(pEntity.randomRot));

        RenderType renderType = LMRenderTypes.entityTranslucentEmissive(pEntity.getRed() ? RED : ICESPIKE);
        VertexConsumer $$9 = pBuffer.getBuffer(renderType);
        this.model.renderToBuffer(pMatrixStack, $$9, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, Mth.clamp(f1 - 0.25f, 0, 1));
        pMatrixStack.popPose();
    }

    public ResourceLocation getTextureLocation(SoulBladeEntity pEntity) {
        return pEntity.getRed() ? RED : ICESPIKE;
    }
}