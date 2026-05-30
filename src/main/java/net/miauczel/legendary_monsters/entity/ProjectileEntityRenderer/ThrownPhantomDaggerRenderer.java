package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownPhantomDaggerEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrownPhantomDaggerRenderer extends EntityRenderer<ThrownPhantomDaggerEntity> {
    public static final ResourceLocation BOMB_LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/phantom_dagger.png");

    public static final ResourceLocation DAGGER_RED = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/phantom_dagger_red.png");
    private final ThrownPhantomDaggerModel model;

    public ThrownPhantomDaggerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new ThrownPhantomDaggerModel(pContext.bakeLayer(ModModelLayers.PHANTOM_DAGGER));
    }

    @Override
    public void render(ThrownPhantomDaggerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();

        float f = -pEntity.getYRot();
        float f1 = pEntity.getXRot();
        this.model.setupAnim(pEntity, 0.0F, 0.0F,pEntity.tickCount + pPartialTicks, f, f1);
      //  pMatrixStack.translate(2.65D, 0.25, 0.0);
        pMatrixStack.translate(0.0D, -2.5D, 0.0D);
        float uniS = 1.75f;
        pMatrixStack.scale(uniS, uniS, uniS);
        //  pMatrixStack.mulPose(Axis.XP.rotationDegrees(90));
        // pMatrixStack.mulPose(Axis.ZP.rotationDegrees(90));
        //pMatrixStack.mulPose(Axis.YP.rotationDegrees(90));
        //  model.rotateModel(pEntity, pPartialTicks);

        float animationProgress1 = Math.min(pEntity.fade.getAnimationFraction(), 1F);
        float f_0_245976 = 1f - animationProgress1;

        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F,  Math.max(f_0_245976 - 0.45f, 0));
        // model.rotateModel(pEntity, pPartialTicks);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownPhantomDaggerEntity pEntity) {
        return pEntity.getRed() ? DAGGER_RED : BOMB_LOCATION;
    }
}
