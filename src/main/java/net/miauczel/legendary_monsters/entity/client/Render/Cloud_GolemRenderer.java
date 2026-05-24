package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.miauczel.legendary_monsters.entity.client.layer.CloudGolemLaserBallInnerLayer;
import net.miauczel.legendary_monsters.entity.client.layer.CloudGolemLaserBallOuterLayer;
import net.miauczel.legendary_monsters.entity.client.Model.Cloud_GolemModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class Cloud_GolemRenderer extends MobRenderer<Cloud_GolemEntity, Cloud_GolemModel<Cloud_GolemEntity>> {

    private static final ResourceLocation NORMAL2 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/cloud_golem_break1.png");
    private static final ResourceLocation ANGRY2 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/cloud_golem_angry_break.png");
    private static final ResourceLocation NORMAL = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/cloud_golem.png");
    private static final ResourceLocation ANGRY = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/cloud_golem_angry2.png");
    private static final ResourceLocation STUN = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/cloud_golem_angry2.png");

    public Cloud_GolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Cloud_GolemModel<>(pContext.bakeLayer(ModModelLayers.CLOUD_GOLEM_LAYER)), 1.5f);
        this.addLayer(new CloudGolemLaserBallInnerLayer(this));

        this.addLayer(new CloudGolemLaserBallOuterLayer(this));
        this.addLayer(new EyesLayer<Cloud_GolemEntity, Cloud_GolemModel<Cloud_GolemEntity>>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/glow/cloud_golem_angry_glow3.png"));
            }

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, Cloud_GolemEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                float alpha = Math.abs((float) Math.sin(entity.LayerTicks * 0.04));

                alpha = Math.min(1.0f, Math.max(0.0f, alpha));

                RenderType renderType = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/glow/cloud_golem_angry_glow3.png"));
                RenderType renderType2 = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/cloud_golem/glow/cloud_golem_angry_glow4.png"));
                if (entity.getAttackState() != 32) {
                    if (entity.isAngry()) {
                        VertexConsumer vertexConsumer = bufferSource.getBuffer(renderType);

                        this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, alpha, alpha, alpha, alpha);
                    } else {
                        VertexConsumer vertexConsumer2 = bufferSource.getBuffer(renderType2);

                        this.getParentModel().renderToBuffer(poseStack, vertexConsumer2, packedLight, OverlayTexture.NO_OVERLAY, alpha, alpha, alpha, alpha);

                    }

                }else{
                    VertexConsumer vertexConsumer3 = bufferSource.getBuffer(renderType);
                    this.getParentModel().renderToBuffer(poseStack, vertexConsumer3, packedLight, OverlayTexture.NO_OVERLAY, 0, 0, 0, 0);
                }
            }
        });
    }

        @Override
    public ResourceLocation getTextureLocation(Cloud_GolemEntity pEntity) {
        switch (pEntity.getTextureVariant()) {
            case 1:
                return ANGRY;
            default:
                return NORMAL;

            case 2:
                return NORMAL2;
            case 3:
                return ANGRY2;

        }
    }

    @Override
    public void render(Cloud_GolemEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
