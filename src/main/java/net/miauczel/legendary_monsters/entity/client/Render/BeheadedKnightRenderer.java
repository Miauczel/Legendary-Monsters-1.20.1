package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.client.RenderUtils;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.BeheadedKnightModel;
import net.miauczel.legendary_monsters.entity.client.layer.BeheadedKnight.BeheadedKnightGhostArmLayer;
import net.miauczel.legendary_monsters.entity.client.layer.BeheadedKnight.BeheadedKnightGrabLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BeheadedKnightRenderer extends MobRenderer<BeheadedKnightEntity, BeheadedKnightModel<BeheadedKnightEntity>> {
    public BeheadedKnightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BeheadedKnightModel<>(pContext.bakeLayer(ModModelLayers.BEHEADED_KNIGHT_LAYER)), 1.5f);
        this.addLayer(new BeheadedKnightGhostArmLayer(this));
        this.addLayer(new BeheadedKnightGrabLayer(this, pContext.getEntityRenderDispatcher()));
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/beheaded_knight/beheaded_knight.png");

    private static final ResourceLocation TEXTURE_GOLDEN = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/beheaded_knight/beheaded_knight_golden.png");

    private static final ResourceLocation TEXTURE_DIAMOND = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/beheaded_knight/beheaded_knight_diamond.png");

    @Override
    public ResourceLocation getTextureLocation(BeheadedKnightEntity pEntity) {
        switch (pEntity.getTextureVariant()){
            case 2 -> {
                return TEXTURE_GOLDEN;
            }
            case 3->{
                return TEXTURE_DIAMOND;
            }
            default -> {
                return TEXTURE;
            }
        }
    }
    @Override
    public void render(BeheadedKnightEntity entity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        float f = Mth.cos(entity.getYRot() * ((float) Math.PI / 180F));
        float f12 = Mth.sin(entity.getYRot() * ((float) Math.PI / 180F));
        double theta = (entity.getYRot()) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = 0;
        float offset = 0;
        double x = 0 + vec * vecX + f * offset;
        double z = 0 + vec * vecZ + f12 * offset;
        float uniY = 0.25f;
        float yaw = (float) -entity.getYRot() + 90;

        float pitch = (float) -entity.getXRot() + 90;


        VertexConsumer vertexConsumer = pBuffer.getBuffer(LMRenderTypes.LIGHTNING_NO_CULL);
        float uniA = 0.65f;

        float animationProgress1 = Math.min(entity.telegraphFadeAway.getAnimationFraction(), 1F);
        float f_0_245976 = 1f - animationProgress1;

        // System.out.println("F: " + f_0_245976);
        if (f_0_245976 >= 0 && entity.canRenderWarningLines()) {
            RenderUtils.renderPivotedQuad(8, 2f, x, uniY, z, 90, yaw, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, 0, 0.45f, 0.75f, Mth.clamp(f_0_245976 - uniA, 0, 1));
            //    RenderUtils.renderPivotedQuad(10, 0.1f, x, uniY, z, 0,yaw, 0, vertexConsumer, pMatrixStack, OverlayTexture.NO_OVERLAY, pPackedLight, 0.25f, 1, 0.25f, uniA);
        }
        super.render(entity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}



