package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SoulJavelinEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownGoldenHalbert;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SoulJavelinRenderer extends EntityRenderer<SoulJavelinEntity> {
    public static final ResourceLocation SOUL_JAVELIN = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/resurrected_knight/javelin.png");
    private final SoulJavelinModel model;

    public SoulJavelinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SoulJavelinModel(pContext.bakeLayer(ModModelLayers.SOUL_JAVELIN_LAYER));
    }
    @Override
    public void render(SoulJavelinEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
      //  pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        //pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));

        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot())));
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(pPartialTicks, -pEntity.xRotO, -pEntity.getXRot())));
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBuffer(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.5F);

        RenderSystem.disableBlend();

        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SoulJavelinEntity pEntity) {
        return SOUL_JAVELIN;
    }
}
