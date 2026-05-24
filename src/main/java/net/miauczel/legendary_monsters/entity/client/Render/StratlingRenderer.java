package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple.StratlingEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.StratlingModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StratlingRenderer extends MobRenderer<StratlingEntity, StratlingModel<StratlingEntity>> {
    public StratlingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new StratlingModel<>(pContext.bakeLayer(ModModelLayers.STRATLING_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(StratlingEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/stratling.png")  ;
    }

    @Override
    public void render(StratlingEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
