package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.CloudEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CloudRender extends EntityRenderer<CloudEntity> {
    public static final ResourceLocation BOMB_LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/falling_cloud.png");
    private final CloudModel model;

    public CloudRender(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new CloudModel(pContext.bakeLayer(ModModelLayers.Cloud));
    }

    @Override
    public void render(CloudEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, 0.5D, 0.0D);

        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CloudEntity pEntity) {
        return BOMB_LOCATION;
    }
}
