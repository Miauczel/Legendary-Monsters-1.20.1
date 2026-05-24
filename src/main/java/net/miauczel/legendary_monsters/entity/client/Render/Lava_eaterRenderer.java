package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Lava_eaterEntity;
import net.miauczel.legendary_monsters.entity.client.Model.Lava_eaterModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Lava_eaterRenderer extends MobRenderer<Lava_eaterEntity, Lava_eaterModel<Lava_eaterEntity>> {
    public Lava_eaterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Lava_eaterModel<>(pContext.bakeLayer(ModModelLayers.LAVA_EATER_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Lava_eaterEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/lava_eater.png")  ;
    }

    @Override
    public void render(Lava_eaterEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
if (pEntity.k()){
    }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
