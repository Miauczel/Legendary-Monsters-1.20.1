package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulTridentEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SoulTridentRenderer extends EntityRenderer<SoulTridentEntity> {
    public static final ResourceLocation SOUL_TRIDENT = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/layer/possessed_paladin_trident_red_layer.png");
    private final SoulTridentModel model;

    public SoulTridentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SoulTridentModel(pContext.bakeLayer(ModModelLayers.SOUL_TRIDENT_LAYER));
    }
    @Override
    public void render(SoulTridentEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
      //  pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        //pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));

        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot())));
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(pPartialTicks, -pEntity.xRotO, -pEntity.getXRot())));
        float uScale = 1.5f;
        pMatrixStack.scale(uScale,uScale,uScale);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBuffer(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.5F);

        RenderSystem.disableBlend();

        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SoulTridentEntity pEntity) {
        return SOUL_TRIDENT;
    }
}
