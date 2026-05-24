package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Overgrown_colossusEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.Overgrown_colossusModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Overgrown_colossusRenderer extends MobRenderer<Overgrown_colossusEntity, Overgrown_colossusModel<Overgrown_colossusEntity>> {
    public Overgrown_colossusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Overgrown_colossusModel<>(pContext.bakeLayer(ModModelLayers.OVERGROWN_COLOSSUS_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Overgrown_colossusEntity pEntity) {
        Overgrown_colossusEntity.Crackiness crackiness = pEntity.getCrackiness();
        if (pEntity.WantsToStun()) {
            if (crackiness == Overgrown_colossusEntity.Crackiness.MEDIUM || crackiness == Overgrown_colossusEntity.Crackiness.HIGH) {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/overgrown_colosuss/overgrown_colossus.png");
            } else {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/overgrown_colosuss/overgrown_colossus.png");
            }
        } else {
            if (crackiness == Overgrown_colossusEntity.Crackiness.MEDIUM || crackiness == Overgrown_colossusEntity.Crackiness.HIGH) {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/overgrown_colosuss/overgrown_colossus.png");
            } else {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/overgrown_colosuss/overgrown_colossus.png");
            }

        }
    }
    @Override
    public void render(Overgrown_colossusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
