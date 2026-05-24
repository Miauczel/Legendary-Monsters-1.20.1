package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Warped_FungussusEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.Warped_FungussusModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class Warped_FungussusRenderer extends MobRenderer<Warped_FungussusEntity, Warped_FungussusModel<Warped_FungussusEntity>> {
    public Warped_FungussusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Warped_FungussusModel<>(pContext.bakeLayer(ModModelLayers.WARPED_FUNGUSSUS_LAYER)), 1f);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/warped_fungussus/glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(Warped_FungussusEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/warped_fungussus/warped_fungussus.png")  ;
    }

    @Override
    public void render(Warped_FungussusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
