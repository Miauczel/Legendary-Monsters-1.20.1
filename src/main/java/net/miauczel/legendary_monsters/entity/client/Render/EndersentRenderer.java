package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.EndersentEntity;
import net.miauczel.legendary_monsters.entity.client.Model.EndersentModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class EndersentRenderer extends MobRenderer<EndersentEntity, EndersentModel<EndersentEntity>> {
    public EndersentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EndersentModel<>(pContext.bakeLayer(ModModelLayers.ENDERSENT_LAYER)), 1f);
        this.addLayer(new EyesLayer<EndersentEntity, EndersentModel<EndersentEntity>>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/endersent/glow/endersent_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(EndersentEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/endersent6.png")  ;

    }

    @Override
    public void render(EndersentEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
