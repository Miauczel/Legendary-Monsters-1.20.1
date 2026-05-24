package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.FlamebornGuardEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.FlamebornWarriorEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.FlamebornGuardModel;
import net.miauczel.legendary_monsters.entity.client.Model.FlamebornWarriorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class FlamebornWarriorRenderer extends MobRenderer<FlamebornWarriorEntity, FlamebornWarriorModel<FlamebornWarriorEntity>> {
    public FlamebornWarriorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FlamebornWarriorModel<>(pContext.bakeLayer(ModModelLayers.FLAMEBORN_WARRIOR_LAYER)), 0.5f);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/flameborn/flameborn_warrior/flameborn_warrior_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(FlamebornWarriorEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/flameborn/flameborn_warrior/flameborn_warrior.png")  ;
    }

    @Override
    public void render(FlamebornWarriorEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
