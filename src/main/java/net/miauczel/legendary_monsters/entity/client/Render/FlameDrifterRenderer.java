package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.FlameDrifter.FlameDrifterEntity;
import net.miauczel.legendary_monsters.entity.client.Model.FlameDrifterModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class FlameDrifterRenderer extends MobRenderer<FlameDrifterEntity, FlameDrifterModel<FlameDrifterEntity>> {
    public FlameDrifterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FlameDrifterModel<>(pContext.bakeLayer(ModModelLayers.FLAME_DRIFTER_LAYER)), 1f);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/flame_drifter/flame_drifter_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(FlameDrifterEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/flame_drifter/flame_drifter.png")  ;
    }

    @Override
    public void render(FlameDrifterEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
