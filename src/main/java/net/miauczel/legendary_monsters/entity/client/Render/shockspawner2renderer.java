package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.PoisonousShockwaveSpawner;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class shockspawner2renderer extends EntityRenderer<PoisonousShockwaveSpawner> {

    public shockspawner2renderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PoisonousShockwaveSpawner entity) {
        return null;
    }

    @Override
    public void render(PoisonousShockwaveSpawner entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
    }
}
