package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Old.OldShulkerMimic;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.Shulker_MimicOldModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OldShulkerMimicRenderer extends MobRenderer<OldShulkerMimic, Shulker_MimicOldModel<OldShulkerMimic>> {
    public OldShulkerMimicRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Shulker_MimicOldModel<>(pContext.bakeLayer(ModModelLayers.OLD_SHULKER_MIMIC_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OldShulkerMimic pEntity) {
        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/shulker_mimic/shulker_mimic.png")  ;
    }

    @Override
    public void render(OldShulkerMimic pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
