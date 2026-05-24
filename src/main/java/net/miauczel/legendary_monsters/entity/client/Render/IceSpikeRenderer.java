package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.IceSpikeEntity;
import net.miauczel.legendary_monsters.entity.client.Model.IceSpikeModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class IceSpikeRenderer extends EntityRenderer<IceSpikeEntity> {
    private static final ResourceLocation ICESPIKE = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/ice_spike.png");
    private final IceSpikeModel<IceSpikeEntity> model;

    public IceSpikeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new IceSpikeModel(pContext.bakeLayer(ModModelLayers.ICE_SPIKE));
    }

    public void render(IceSpikeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        float $$6 = pEntity.getAnimationProgress(pPartialTicks);
        if ($$6 != 0.0F) {
            float $$7 = 2.0F;
            if ($$6 > 0.9F) {
                $$7 *= (1.0F - $$6) / 0.1F;
            }

                float $$10 = 2.0F;
                if ($$6 > 0.9F) {
                    $$10 *= (1.0F - $$6) / 0.1F;
                }

            pMatrixStack.pushPose();
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(90.0F - pEntity.getYRot()));
            pMatrixStack.scale(-$$7, -$$7, $$7);
            float $$8 = 0.03125F;
            pMatrixStack.translate(0.0, -0.626, 0.0);
            pMatrixStack.scale(0.7F, 0.7F, 0.7F);
            this.model.setupAnim(pEntity, $$6, 0.0F, 0.0F, pEntity.getYRot(), pEntity.getXRot());
            VertexConsumer $$9 = pBuffer.getBuffer(this.model.renderType(ICESPIKE));
            this.model.renderToBuffer(pMatrixStack, $$9, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            pMatrixStack.popPose();
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
        if ($$6 != 0.0F) {
            float $$7 = 2.0F;
            if ($$6 > 0.9F) {
                $$7 *= (1.0F - $$6) / 0.1F;
            }

            float $$10 = 2.0F;
            if ($$6 > 0.9F) {
                $$10 *= (1.0F - $$6) / 0.1F;
            }
            pMatrixStack.scale(+$$10, +$$10, $$10);


        }
    }

    public ResourceLocation getTextureLocation(IceSpikeEntity pEntity) {
        return ICESPIKE;
    }
}