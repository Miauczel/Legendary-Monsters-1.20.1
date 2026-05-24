package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationBombEntity;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PowerBallBombRenderer extends EntityRenderer<AnnihilationBombEntity> {
    public static final ResourceLocation INNER_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ball/power_ball_inner.png");

    public static final ResourceLocation OUTER_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ball/power_ball_outer.png");
    private final PowerBallBombModel model;

    public PowerBallBombRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new PowerBallBombModel(pContext.bakeLayer(ModModelLayers.POWER_BALL_LAYER));

    }

    @Override
    public void render(AnnihilationBombEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
       // pMatrixStack.mulPose((new Quaternionf()).setAngleAxis(pEntityYaw * ((float)Math.PI / 180F), 0, -1.0F, 0));
        VertexConsumer VertexConsumer = pBuffer.getBuffer(LMRenderTypes.getGlowEyes(this.getTextureLocation(pEntity)));
        model.setupAnim(pEntity, 0, 0, pEntity.tickCount + pPartialTicks, 0, 0);

        model.renderToBuffer(pMatrixStack, VertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
            float uniformScale = 1;
    pMatrixStack.scale(uniformScale,uniformScale,uniformScale);
            VertexConsumer VertexConsumer2 = pBuffer.getBuffer(LMRenderTypes.getGlowEyes(OUTER_LAYER));

        model.renderToBuffer(pMatrixStack, VertexConsumer2, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.4F);
        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(AnnihilationBombEntity pEntity) {
        return INNER_LAYER;
    }
}
