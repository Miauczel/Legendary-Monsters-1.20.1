package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.DuneSentinelEntity;
import net.miauczel.legendary_monsters.entity.client.Model.DuneSentinelModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DuneSentinelRenderer extends MobRenderer<DuneSentinelEntity, DuneSentinelModel<DuneSentinelEntity>> {
    public DuneSentinelRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DuneSentinelModel<>(pContext.bakeLayer(ModModelLayers.BIG_CANNON_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(DuneSentinelEntity entity) {

        if (entity.hasCustomName()) {

            String name = entity.getCustomName().getString();

            if (name.equalsIgnoreCase("peashooter")) {
                return new ResourceLocation(
                        LegendaryMonsters.MOD_ID,
                        "textures/entity/dune_sentinel/pea.png"
                );
            }
        }
        return new ResourceLocation(
                LegendaryMonsters.MOD_ID,
                "textures/entity/dune_sentinel/dune_sentinel.png"
        );
    }

    @Override
    public void render(DuneSentinelEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
