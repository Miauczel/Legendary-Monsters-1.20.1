package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.Tornado;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.TornadoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class TornadoRenderer extends EntityRenderer<Tornado> {
    private static final ResourceLocation ICESPIKE = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/cloud_golem/tornado.png");
    private final TornadoModel<Tornado> model;

    public TornadoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new TornadoModel<>(pContext.bakeLayer(ModModelLayers.ICE_SPIKE));
    }

    public void render(Tornado pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        float $$6 = 2;
        if ($$6 != 0.0F) {

            this.model.setupAnim(pEntity, $$6, 0.1F, 0.0F, pEntity.getYRot(), pEntity.getXRot());
            VertexConsumer $$9 = pBuffer.getBuffer(this.model.renderType(ICESPIKE));
            this.model.renderToBuffer(pMatrixStack, $$9, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            pMatrixStack.popPose();
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }

    }

    public ResourceLocation getTextureLocation(Tornado pEntity) {
        return ICESPIKE;
    }
}