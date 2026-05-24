package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedApostleEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.FracturedApostleModel;
import net.miauczel.legendary_monsters.entity.client.layer.Fractured.FracturedApostleBodyLayer;
import net.miauczel.legendary_monsters.entity.client.layer.Fractured.FracturedApostleBookLayer;
import net.miauczel.legendary_monsters.entity.client.layer.Fractured.FracturedApostleKnifeLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FracturedApostleRenderer extends MobRenderer<FracturedApostleEntity, FracturedApostleModel<FracturedApostleEntity>> {
    private static final ResourceLocation HOOD = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/fractured_apostle/fractured_apostle_hood.png");

    public FracturedApostleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FracturedApostleModel<>(pContext.bakeLayer(ModModelLayers.FRACTURED_APOSTLE_LAYER)), 1f);
        addLayer(new FracturedApostleBodyLayer(this));

        addLayer(new FracturedApostleKnifeLayer(this));
        addLayer(new FracturedApostleBookLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(FracturedApostleEntity pEntity) {
        return HOOD;
    }

    @Override
    public void render(FracturedApostleEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
