package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple.HoveringHurricaneEntity;
import net.miauczel.legendary_monsters.entity.client.Model.HoveringHurricaneModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HoveringHurricaneRenderer extends MobRenderer<HoveringHurricaneEntity, HoveringHurricaneModel<HoveringHurricaneEntity>> {
    public HoveringHurricaneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HoveringHurricaneModel<>(pContext.bakeLayer(ModModelLayers.HURRICANE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(HoveringHurricaneEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/hovering_hurricane.png")  ;
    }

    @Override
    public void render(HoveringHurricaneEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
