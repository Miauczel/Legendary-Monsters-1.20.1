package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownHalbert;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.systems.RenderSystem;

@OnlyIn(Dist.CLIENT)
public class SpearRenderer extends EntityRenderer<ThrownHalbert> {
    public static final ResourceLocation SPEAR_LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/monstrous_spear_entity.png");
    private final SpearModel model;

    public SpearRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SpearModel(pContext.bakeLayer(ModModelLayers.THROWN_SPEAR_LAYER));
    }

    @Override
    public void render(ThrownHalbert pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBuffer(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.disableBlend();

        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownHalbert pEntity) {
        return SPEAR_LOCATION;
    }
}
