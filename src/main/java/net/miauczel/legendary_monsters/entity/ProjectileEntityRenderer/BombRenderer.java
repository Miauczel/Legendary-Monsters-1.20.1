package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.BombEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BombRenderer extends EntityRenderer<BombEntity> {
    public static final ResourceLocation BOMB_LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/bomb_dune.png");
    private final BombModel model;

    public BombRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new BombModel(pContext.bakeLayer(ModModelLayers.BOMB_LAYER));
    }

    @Override
    public void render(BombEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, 0.5D, 0.0D);
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot())));
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot())));

        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(BombEntity pEntity) {
        return BOMB_LOCATION;
    }
}
