package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.Ancient_GuardianEntity;
import net.miauczel.legendary_monsters.entity.client.Model.Ancient_GuardianModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Ancient_GuardianRenderer extends MobRenderer<Ancient_GuardianEntity, Ancient_GuardianModel<Ancient_GuardianEntity>> {
    public Ancient_GuardianRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Ancient_GuardianModel<>(pContext.bakeLayer(ModModelLayers.ANCIENT_GUARDIAN_LAYER)), 1.5f);

    }

    @Override
    public ResourceLocation getTextureLocation(Ancient_GuardianEntity pEntity) {
        Ancient_GuardianEntity.Crackiness crackiness = pEntity.getCrackiness();
        if (pEntity.WantsToStun()) {
            if (crackiness == Ancient_GuardianEntity.Crackiness.MEDIUM || crackiness == Ancient_GuardianEntity.Crackiness.HIGH) {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/ancient_guardian/ancient_guardian_crack.png");
            } else {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/ancient_guardian/ancient_guardian.png");
            }
        } else {
            if (crackiness == Ancient_GuardianEntity.Crackiness.MEDIUM || crackiness == Ancient_GuardianEntity.Crackiness.HIGH) {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/ancient_guardian/ancient_guardian_crack.png");
            } else {
                return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/ancient_guardian/ancient_guardian.png");
            }

        }

    }

    @Override
    public void render(Ancient_GuardianEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }


}
