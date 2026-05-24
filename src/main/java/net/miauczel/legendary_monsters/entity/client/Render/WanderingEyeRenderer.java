package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.WanderingEyeEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.WanderingEyeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WanderingEyeRenderer extends MobRenderer<WanderingEyeEntity, WanderingEyeModel<WanderingEyeEntity>> {
    public WanderingEyeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WanderingEyeModel<>(pContext.bakeLayer(ModModelLayers.WANDERING_EYE)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(WanderingEyeEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/wandering_eye.png")  ;
    }

    @Override
    public void render(WanderingEyeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
