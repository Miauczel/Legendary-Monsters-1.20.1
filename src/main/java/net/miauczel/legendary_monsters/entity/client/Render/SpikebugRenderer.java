package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.AncientStronghold.SpikebugEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.SpikebugModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpikebugRenderer extends MobRenderer<SpikebugEntity, SpikebugModel<SpikebugEntity>> {
    public SpikebugRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SpikebugModel<>(pContext.bakeLayer(ModModelLayers.SPIKEBUG_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SpikebugEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/spiky_worm.png")  ;
    }

    @Override
    public void render(SpikebugEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
