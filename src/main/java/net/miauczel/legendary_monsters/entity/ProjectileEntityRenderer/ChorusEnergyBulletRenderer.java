package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ChorusEnergyBulletEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class ChorusEnergyBulletRenderer extends EntityRenderer<ChorusEnergyBulletEntity> {
public static final ResourceLocation CHORUS_BOMB_LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID,
        "textures/entity/the_warped_one/projectile/chorus_energy_bullet.png");
private final ChorusEnergyBulletModel model;

public ChorusEnergyBulletRenderer(EntityRendererProvider.Context pContext) {
    super(pContext);
    this.model = new ChorusEnergyBulletModel(pContext.bakeLayer(ModModelLayers.CHORUS_ENERGY_BULLET_LAYER));
}

@Override
public void render(ChorusEnergyBulletEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                   MultiBufferSource pBuffer, int pPackedLight) {
    pMatrixStack.pushPose();
    pMatrixStack.translate(0.0D, 0.5D, 0.0D);

    RenderType eyes = LMRenderTypes.getGlowEyes(CHORUS_BOMB_LOCATION);
    VertexConsumer vertexconsumer = pBuffer.getBuffer(eyes);
    this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
            1.0F, 1.0F, 1.0F, 1.0F);
    pMatrixStack.popPose();

    super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
}

@Override
public ResourceLocation getTextureLocation(ChorusEnergyBulletEntity pEntity) {
    return CHORUS_BOMB_LOCATION;
}
}