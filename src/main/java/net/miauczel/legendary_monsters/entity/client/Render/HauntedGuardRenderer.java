package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.HauntedGuardEntity;
import net.miauczel.legendary_monsters.entity.client.Model.HauntedGuardModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HauntedGuardRenderer extends MobRenderer<HauntedGuardEntity, HauntedGuardModel<HauntedGuardEntity>> {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_iron.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_golden.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_diamond.png")
    };

    public HauntedGuardRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HauntedGuardModel<>(pContext.bakeLayer(ModModelLayers.HAUNTED_GUARD_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(HauntedGuardEntity pEntity) {
        return TEXTURES[pEntity.getTextureVariant()];
    }

    @Override
    public void render(HauntedGuardEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
