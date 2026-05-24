package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.HauntedKnightEntity;
import net.miauczel.legendary_monsters.entity.client.Model.LivingArmorModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LivingArmorRenderer extends MobRenderer<HauntedKnightEntity, LivingArmorModel<HauntedKnightEntity>> {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_iron2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_golden2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_diamond3.png")
    };

    public LivingArmorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LivingArmorModel<>(pContext.bakeLayer(ModModelLayers.LIVING_ARMOR_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(HauntedKnightEntity pEntity) {
        return TEXTURES[pEntity.getTextureVariant()];
    }

    @Override
    public void render(HauntedKnightEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
