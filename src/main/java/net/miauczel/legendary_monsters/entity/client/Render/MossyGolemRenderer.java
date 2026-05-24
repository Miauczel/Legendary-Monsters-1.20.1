package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.MossyGolemEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.MossyGolemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MossyGolemRenderer extends MobRenderer<MossyGolemEntity, MossyGolemModel<MossyGolemEntity>> {
    public MossyGolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MossyGolemModel<>(pContext.bakeLayer(ModModelLayers.MOSSY_GOLEM_LAYER)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(MossyGolemEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/mossy_golem.png")  ;
    }

    @Override
    public void render(MossyGolemEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
