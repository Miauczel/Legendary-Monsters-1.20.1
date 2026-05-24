package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.FallingSoulBladeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulBladeEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.SoulBladeFallingModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class FallingSoulBladeRenderer extends EntityRenderer<FallingSoulBladeEntity> {
    private static final ResourceLocation ICESPIKE = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/posessed_paladin/soul_sword3.png");

    private static final ResourceLocation RED = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/posessed_paladin/soul_sword_red.png");
    private final SoulBladeFallingModel<FallingSoulBladeEntity> model;

    public FallingSoulBladeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SoulBladeFallingModel<>(pContext.bakeLayer(ModModelLayers.FALLING_SOUL_BLADE_LAYER));
    }

    public void render(FallingSoulBladeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        float animationProgress = Math.min(pEntity.controlledAnim1.getAnimationFraction(), 1F);
        float f1 = 1f - animationProgress;

       // System.out.println("F1: " + f1 + " AnimP: " + pEntity.controlledAnim1.getAnimationFraction() );
        model.setupAnim(pEntity, 0, 0, pEntity.tickCount + pPartialTicks, 0, 0);
        pMatrixStack.pushPose();

        pMatrixStack.mulPose(Axis.YP.rotationDegrees(pEntity.randomRot));

        RenderType renderType = RenderType.entityTranslucentEmissive(getTextureLocation(pEntity));
        VertexConsumer $$9 = pBuffer.getBuffer(renderType);
        if (f1 > 0) this.model.renderToBuffer(pMatrixStack, $$9, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, f1-0.25f);
        pMatrixStack.popPose();
    }
    public ResourceLocation getTextureLocation(FallingSoulBladeEntity pEntity) {
        return pEntity.getRed() ? RED :ICESPIKE;
    }
}