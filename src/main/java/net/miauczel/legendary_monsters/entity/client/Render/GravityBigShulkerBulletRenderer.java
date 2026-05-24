package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.GravityBigShulkerEntity;
import net.miauczel.legendary_monsters.entity.client.Model.GravityBigShulkerBulletModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GravityBigShulkerBulletRenderer extends EntityRenderer<GravityBigShulkerEntity> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("textures/entity/shulker/spark.png");
    private static final RenderType RENDER_TYPE = RenderType.entityTranslucent(TEXTURE_LOCATION);
    private final GravityBigShulkerBulletModel<GravityBigShulkerEntity> model;

   public GravityBigShulkerBulletRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new GravityBigShulkerBulletModel<>(pContext.bakeLayer(ModModelLayers.GRAVITY_BIG_SHULKER_BULLET_LAYER));
    }

    protected int getBlockLightLevel(GravityBigShulkerEntity pEntity, BlockPos pPos) {
        return 15;
    }

    public void render(GravityBigShulkerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource
    pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        float f = Mth.rotLerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot());
        float f1 = Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot());
        float f2 = (float)pEntity.tickCount + pPartialTicks;
        pMatrixStack.translate(0.0F, 0.5F, 0.0F);
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.sin(f2 * 0.1F) * 180.0F));
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(Mth.cos(f2 * 0.1F) * 180.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.sin(f2 * 0.15F) * 360.0F));
        float sizeMult = pEntity.getSize();
        pMatrixStack.scale(2F*sizeMult, 2F*sizeMult, 2F*sizeMult);
        this.model.setupAnim(pEntity, 0.0F, 0.0F, 0.0F, f, f1);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(TEXTURE_LOCATION));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.scale(1.5F, 1.5F, 1.5F);
        VertexConsumer vertexconsumer1 = pBuffer.getBuffer(RENDER_TYPE);
        this.model.renderToBuffer(pMatrixStack, vertexconsumer1, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(GravityBigShulkerEntity pEntity) {
        return TEXTURE_LOCATION;
    }
}