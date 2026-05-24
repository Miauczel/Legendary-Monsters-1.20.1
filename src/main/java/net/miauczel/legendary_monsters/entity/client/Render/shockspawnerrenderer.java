package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ShockwaveSpawner;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class shockspawnerrenderer extends EntityRenderer<ShockwaveSpawner> {

    public shockspawnerrenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ShockwaveSpawner entity) {
        return null;
    }

    @Override
    public void render(ShockwaveSpawner entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
    }
}
