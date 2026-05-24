package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.AmbusherEntity;
import net.miauczel.legendary_monsters.entity.client.Model.AmbusherModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AmbusherRenderer extends MobRenderer<AmbusherEntity, AmbusherModel<AmbusherEntity>> {
    public AmbusherRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AmbusherModel<>(pContext.bakeLayer(ModModelLayers.AMBUSHER_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(AmbusherEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/ambusher_new.png")  ;
    }

    @Override
    public void render(AmbusherEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
