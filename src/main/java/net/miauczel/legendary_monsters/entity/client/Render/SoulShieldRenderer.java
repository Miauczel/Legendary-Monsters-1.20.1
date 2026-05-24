package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulShieldEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.SoulShieldModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;


public class SoulShieldRenderer extends EntityRenderer<SoulShieldEntity> {
    private static final ResourceLocation BASE_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/soul_shield.png");

    private static final ResourceLocation RED_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/soul_shield_red.png");


    private final SoulShieldModel<SoulShieldEntity> model;

    public SoulShieldRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SoulShieldModel<>(pContext.bakeLayer(ModModelLayers.SOUL_SHIELD_LAYER));
    }

    public void render(SoulShieldEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
              /*  pMatrixStack.pushPose();
                VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(pEntity)));
                model.setupAnim(pEntity, 0, 0, pEntity.tickCount + pPartialTicks, 0, 0);
                model.renderToBuffer(pMatrixStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 0.75f);
                pMatrixStack.popPose();*/
        double dx = pEntity.getDestinationX() - pEntity.getX();
        double dy = pEntity.getDestinationY() - pEntity.getY();
        double dz = pEntity.getDestinationZ() - pEntity.getZ();
        float yawDeg = (float) (Math.toDegrees(Math.atan2(dz, dx))) - 90F;
        float horizontal = (float) Math.sqrt(dx * dx + dz * dz);
        float pitchDeg = -(float) (Math.toDegrees(Math.atan2(dy, horizontal)));
        float yawRad = (float) Math.toRadians(yawDeg);
        float pitchRad = (float) Math.toRadians(pitchDeg);


        float animationProgress = Math.min(pEntity.controlledAnim.getAnimationFraction(), 1F);
        float f1 = 1f - animationProgress;
        pMatrixStack.pushPose();
        float uniformScale = 1.75f;
        pMatrixStack.scale(uniformScale, uniformScale, uniformScale);

        pMatrixStack.mulPose(Axis.YP.rotation(-yawRad + (float) Math.PI));

        pMatrixStack.mulPose(Axis.XP.rotation(-pitchRad));

        pMatrixStack.mulPose(Axis.ZP.rotation((float) Math.PI));
        pMatrixStack.translate(0, -1.5, 0);
        Minecraft minecraft = Minecraft.getInstance();

        boolean flag2 = minecraft.shouldEntityAppearGlowing(pEntity);
        RenderType rendertype = this.getRenderType(pEntity, flag2);
        if (rendertype != null) {
            VertexConsumer vertexconsumer = pBuffer.getBuffer(rendertype);
            int i = getOverlayCoords(pEntity, this.getWhiteOverlayProgress(pEntity, pPartialTicks));
            this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, i, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        VertexConsumer VertexConsumer = pBuffer.getBuffer(RenderType.entityTranslucentEmissive(this.getTextureLocation(pEntity)));

        model.setupAnim(pEntity, 0, 0, pEntity.tickCount + pPartialTicks, 0, 0);
        model.renderToBuffer(pMatrixStack, VertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, Mth.clamp(f1 - 0.5f, 0, 1));
        //  System.out.println("SHIELD: " + Mth.clamp(f1 - 0.5f, 0, 1));

       // System.out.println("F1: " + f1);
        pMatrixStack.popPose();

    }

    public ResourceLocation getTextureLocation(SoulShieldEntity pEntity) {
        return pEntity.getRed() ? RED_LAYER : BASE_LAYER;
    }

    @Nullable
    protected RenderType getRenderType(SoulShieldEntity pLivingEntity, boolean pGlowing) {
        ResourceLocation resourcelocation = this.getTextureLocation(pLivingEntity);
        return pGlowing ? RenderType.outline(resourcelocation) : null;
    }

    protected float getWhiteOverlayProgress(SoulShieldEntity entity, float pPartialTicks) {
        return 0.0F;
    }

    public static int getOverlayCoords(SoulShieldEntity pLivingEntity, float pU) {
        return OverlayTexture.pack(OverlayTexture.u(pU), OverlayTexture.v(true));
    }
}